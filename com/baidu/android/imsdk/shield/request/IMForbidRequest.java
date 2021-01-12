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
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.sapi2.SapiContext;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMForbidRequest extends IMSettingBaseHttpRequest {
    private static final String TAG = "IMForbidRequest";
    private List<ChatMsg> chatMsgs;
    private String key;
    private long touk;
    private int type;
    private long uid;

    public IMForbidRequest(Context context, long j, long j2, int i, List<ChatMsg> list, String str) {
        this.mContext = context;
        this.chatMsgs = list;
        this.uid = j2;
        this.type = i;
        this.key = str;
        this.touk = j;
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
            jSONObject.put(SapiContext.KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
            jSONObject.put(HttpConstants.DEVICE_TYPE, 2);
            jSONObject.put("timestamp", currentTimeMillis);
            jSONObject.put(TiebaInitialize.LogFields.REASON, 1);
            jSONObject.put("msgs", msgListToJsonArray);
            jSONObject.put("bduk_to", Utility.transBDUID(this.uid + ""));
            jSONObject.put("sign", getMd5("" + currentTimeMillis + uk + appid));
            jSONObject.put("account_type", AccountManager.isCuidLogin(this.mContext) ? 1 : 0);
            LogUtils.d(TAG, "IMForbidRequest msg :" + jSONObject.toString());
            return jSONObject.toString().getBytes();
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return HttpHelper.CONTENT_JSON;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        String str2;
        String str3 = new String(bArr);
        LogUtils.e(TAG, "IMForbidRequest onSuccess :" + str3);
        String str4 = "";
        boolean z = true;
        try {
            JSONObject jSONObject = new JSONObject(str3);
            i2 = jSONObject.optInt("error_code");
            str = jSONObject.optString("error_msg");
            z = jSONObject.optBoolean("display_toast", false);
            if (z) {
                str4 = jSONObject.optString(TipsConfigItem.TipConfigData.TOAST, "");
            }
            str2 = str4;
        } catch (JSONException e) {
            LogUtils.e(TAG, "JSONException", e);
            i2 = 1010;
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            str2 = "";
        }
        ShieldAndTopManager.getInstance(this.mContext).onForbidResult(i2, str, z, str2, this.key);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        ShieldAndTopManager.getInstance(this.mContext).onForbidResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, true, "", this.key);
    }

    @Override // com.baidu.android.imsdk.shield.request.IMSettingBaseHttpRequest
    public String getHostUrlParam() {
        return "chat_report";
    }

    private JSONArray msgListToJsonArray() {
        JSONArray jSONArray = new JSONArray();
        if (this.chatMsgs == null || this.chatMsgs.size() <= 0) {
            return jSONArray;
        }
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
            } catch (Exception e) {
                LogUtils.e(TAG, "msgListToJsonArray exception: ", e);
            }
        }
        return jSONArray;
    }

    private String getMsgContent(ChatMsg chatMsg) {
        ChatMsg newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, chatMsg.getCategory(), chatMsg.getMsgType(), -1);
        newChatMsg.setMsgContent(chatMsg.getMsgContent());
        switch (chatMsg.getMsgType()) {
            case 0:
                return ((TextMsg) newChatMsg).getText();
            case 1:
                return ((ImageMsg) newChatMsg).getRemoteUrl();
            case 2:
                return ((AudioMsg) newChatMsg).getRemoteUrl();
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            default:
                return "";
            case 8:
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("title", ((SignleGraphicTextMsg) newChatMsg).getTitle());
                    jSONObject.put("cover", ((SignleGraphicTextMsg) newChatMsg).getCover());
                    jSONObject.put("article_url", ((SignleGraphicTextMsg) newChatMsg).getArticleUrl());
                } catch (Exception e) {
                    LogUtils.e(TAG, "getMsgContent", e);
                }
                return jSONObject.toString();
        }
    }

    @Override // com.baidu.android.imsdk.shield.request.IMSettingBaseHttpRequest
    protected String getHostUrl() {
        switch (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0)) {
            case 0:
                return "https://pim.baidu.com/";
            case 1:
            case 2:
                return "http://rd-im-server.bcc-szth.baidu.com:8111/";
            case 3:
                return Constants.URL_HTTP_BOX;
            default:
                return null;
        }
    }
}
