package com.baidu.android.imsdk.shield.request;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.messages.AudioMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsgFactory;
import com.baidu.android.imsdk.chatmessage.messages.ImageMsg;
import com.baidu.android.imsdk.chatmessage.messages.SignleGraphicTextMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.shield.ShieldAndTopManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMForbidRequest extends IMSettingBaseHttpRequest {
    public static final String TAG = "IMForbidRequest";
    public List<ChatMsg> chatMsgs;
    public String key;
    public long touk;
    public int type;
    public long uid;

    public IMForbidRequest(Context context, long j, long j2, int i2, List<ChatMsg> list, String str) {
        this.mContext = context;
        this.chatMsgs = list;
        this.uid = j2;
        this.type = i2;
        this.key = str;
        this.touk = j;
    }

    private String getMsgContent(ChatMsg chatMsg) {
        ChatMsg newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, chatMsg.getCategory(), chatMsg.getMsgType(), -1);
        newChatMsg.setMsgContent(chatMsg.getMsgContent());
        int msgType = chatMsg.getMsgType();
        if (msgType != 0) {
            if (msgType != 1) {
                if (msgType != 2) {
                    if (msgType != 8) {
                        return "";
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("title", ((SignleGraphicTextMsg) newChatMsg).getTitle());
                        jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, ((SignleGraphicTextMsg) newChatMsg).getCover());
                        jSONObject.put("article_url", ((SignleGraphicTextMsg) newChatMsg).getArticleUrl());
                    } catch (Exception e2) {
                        LogUtils.e(TAG, "getMsgContent", e2);
                    }
                    return jSONObject.toString();
                }
                return ((AudioMsg) newChatMsg).getRemoteUrl();
            }
            return ((ImageMsg) newChatMsg).getRemoteUrl();
        }
        return ((TextMsg) newChatMsg).getText();
    }

    private JSONArray msgListToJsonArray() {
        JSONArray jSONArray = new JSONArray();
        List<ChatMsg> list = this.chatMsgs;
        if (list != null && list.size() > 0) {
            for (ChatMsg chatMsg : this.chatMsgs) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("msgid", chatMsg.getMsgId());
                    jSONObject.put("content", getMsgContent(chatMsg));
                    jSONObject.put("type", chatMsg.getMsgType());
                    jSONObject.put("timestamp", chatMsg.getMsgTime());
                    jSONObject.put("from", chatMsg.getFromUser());
                    jSONObject.put("to", chatMsg.isSelf(this.mContext) ? chatMsg.getContacter() : AccountManager.getUK(this.mContext));
                    jSONArray.put(jSONObject);
                } catch (Exception e2) {
                    LogUtils.e(TAG, "msgListToJsonArray exception: ", e2);
                }
            }
        }
        return jSONArray;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/json";
    }

    @Override // com.baidu.android.imsdk.shield.request.IMSettingBaseHttpRequest
    public String getHostUrl() {
        int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
        if (readIntData != 0) {
            if (readIntData == 1 || readIntData == 2) {
                return "http://rd-im-server.bcc-szth.baidu.com:8111/";
            }
            if (readIntData != 3) {
                return null;
            }
            return Constants.URL_HTTP_BOX;
        }
        return "https://pim.baidu.com/";
    }

    @Override // com.baidu.android.imsdk.shield.request.IMSettingBaseHttpRequest
    public String getHostUrlParam() {
        return "chat_report";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        try {
            long appid = AccountManager.getAppid(this.mContext);
            long uk = AccountManager.getUK(this.mContext);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            JSONObject jSONObject = new JSONObject();
            JSONArray msgListToJsonArray = msgListToJsonArray();
            jSONObject.put("appid", appid);
            jSONObject.put("uk_from", uk);
            jSONObject.put("uk_to", this.touk);
            jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
            jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
            jSONObject.put("device_type", 2);
            jSONObject.put("timestamp", currentTimeMillis);
            int i2 = 1;
            jSONObject.put("reason", 1);
            jSONObject.put("msgs", msgListToJsonArray);
            jSONObject.put("bduk_to", Utility.transBDUID(this.uid + ""));
            jSONObject.put("sign", getMd5("" + currentTimeMillis + uk + appid));
            if (!AccountManager.isCuidLogin(this.mContext)) {
                i2 = 0;
            }
            jSONObject.put("account_type", i2);
            LogUtils.d(TAG, "IMForbidRequest msg :" + jSONObject.toString());
            return jSONObject.toString().getBytes();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        ShieldAndTopManager.getInstance(this.mContext).onForbidResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, true, "", this.key);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        String str;
        boolean z;
        String str2;
        int i3;
        String str3 = new String(bArr);
        LogUtils.e(TAG, "IMForbidRequest onSuccess :" + str3);
        boolean z2 = true;
        try {
            JSONObject jSONObject = new JSONObject(str3);
            int optInt = jSONObject.optInt("error_code");
            String optString = jSONObject.optString("error_msg");
            z2 = jSONObject.optBoolean("display_toast", false);
            str = z2 ? jSONObject.optString("toast", "") : "";
            z = z2;
            i3 = optInt;
            str2 = optString;
        } catch (JSONException e2) {
            LogUtils.e(TAG, "JSONException", e2);
            str = "";
            z = z2;
            str2 = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            i3 = 1010;
        }
        ShieldAndTopManager.getInstance(this.mContext).onForbidResult(i3, str2, z, str, this.key);
    }
}
