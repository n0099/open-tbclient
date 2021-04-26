package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.DuzhanUpMsgCreator;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.bumptech.glide.load.engine.GlideException;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMSendMsg extends Message {
    public static final String TAG = "IMSendMsg";
    public List<Long> mAtUsers;
    public List<Long> mCastids;
    public ChatMsg mChatMsg;
    public String mContent;
    public Context mContext;
    public String mMsgKey;
    public long mRowId;
    public long mToUser;
    public int mType;

    public IMSendMsg(Context context, long j, int i2, String str, String str2, List<Long> list, List<Long> list2) {
        LogUtils.d(TAG, "IMSendMsg " + j + " " + i2 + GlideException.IndentedAppendable.INDENT + str);
        this.mContext = context;
        initCommonParameter(context);
        this.mToUser = j;
        this.mType = i2;
        this.mContent = str;
        this.mMsgKey = str2;
        this.mAtUsers = list;
        this.mCastids = list2;
        setNeedReplay(true);
        setType(55);
    }

    public static IMSendMsg newInstance(Context context, Intent intent) {
        ChatMsg chatMsg;
        int i2;
        if (!intent.hasExtra(Constants.EXTRA_SEND_MSG) || (chatMsg = (ChatMsg) intent.getParcelableExtra(Constants.EXTRA_SEND_MSG)) == null) {
            return null;
        }
        int chatType = chatMsg.getChatType();
        int msgType = chatMsg.getMsgType();
        if (chatType == 7 || chatType == 16 || chatType == 25 || msgType == 18) {
            DuzhanUpMsgCreator.reCreateChatMsg(chatType, chatMsg);
            i2 = 80;
        } else {
            i2 = msgType;
        }
        IMSendMsg iMSendMsg = new IMSendMsg(context, chatMsg.getContacter(), i2, chatMsg.getSendMsgContent(), chatMsg.getMsgKey(), chatMsg.getAtUsers(), chatMsg.getCastids());
        iMSendMsg.setChatMsg(chatMsg);
        return iMSendMsg;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mChatMsg.getCategory() != 0 && this.mChatMsg.getCategory() != 7) {
                if (this.mChatMsg.getCategory() == 4) {
                    jSONObject.put("method", 185);
                    jSONObject.put("mcast_id", this.mToUser);
                    jSONObject.put("role", Utility.getLoginRole(this.mContext));
                    if (!TextUtils.isEmpty(Utility.getAccessToken(this.mContext))) {
                        jSONObject.put("token", Utility.getAccessToken(this.mContext));
                    }
                    if (this.mAtUsers != null && this.mAtUsers.size() > 0) {
                        JSONArray jSONArray = new JSONArray();
                        for (Long l : this.mAtUsers) {
                            jSONArray.put(l);
                        }
                        jSONObject.put("at_uks", jSONArray);
                    }
                    if (this.mCastids != null && this.mCastids.size() > 0) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (Long l2 : this.mCastids) {
                            jSONArray2.put(l2);
                        }
                        jSONObject.put(Constants.EXTRA_CAST_IDS, jSONArray2);
                    }
                } else {
                    jSONObject.put("method", 65);
                    jSONObject.put("group_id", this.mToUser);
                    if (this.mContent.contains("stargroupext")) {
                        jSONObject.put("group_type", 2);
                    }
                    jSONObject.put("client_identifier", AccountManagerImpl.getInstance(this.mContext).getExtraSafeParams());
                }
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("uk", this.mUk);
                jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
                jSONObject.put("type", this.mType);
                jSONObject.put("content", this.mContent);
                jSONObject.put("msg_key", this.mMsgKey);
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                this.mBody = jSONObject.toString();
            }
            jSONObject.put("method", 55);
            Map<String, Object> otherParameters = IMConfigInternal.getInstance().getIMConfig(this.mContext).getOtherParameters(this.mContext, this.mChatMsg);
            if (otherParameters != null) {
                for (String str : otherParameters.keySet()) {
                    jSONObject.put(str, otherParameters.get(str));
                }
            }
            jSONObject.put("to_user", this.mToUser);
            if ((this.mChatMsg.getContacter() & Constants.PAFLAG) != 0) {
                jSONObject.put("pa_uid", this.mToUser);
            }
            if (this.mChatMsg.getCategory() == 7) {
                jSONObject.put("category", 7);
            }
            jSONObject.put("client_identifier", AccountManagerImpl.getInstance(this.mContext).getExtraSafeParams());
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
            jSONObject.put("type", this.mType);
            jSONObject.put("content", this.mContent);
            jSONObject.put("msg_key", this.mMsgKey);
            jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            this.mBody = jSONObject.toString();
        } catch (JSONException e2) {
            LogUtils.e(TAG, "Exception ", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
        }
    }

    public ChatMsg getChatMsg() {
        return this.mChatMsg;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i2, String str) {
        int i3;
        String str2 = "";
        long j = -1;
        boolean z = false;
        try {
            z = jSONObject.has("msgid");
            if (z) {
                getChatMsg().setMsgId(jSONObject.getLong("msgid"));
            }
            j = jSONObject.optLong("time", -1L);
            if (jSONObject.optBoolean("display_tips")) {
                str2 = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            }
        } catch (Exception e2) {
            LogUtils.e(TAG, "handle IMSendMsg exception :", e2);
        }
        long j2 = j;
        if (i2 != 0 || z) {
            i3 = i2;
        } else {
            str = Constants.ERROR_MSG_SERVER_INTERNAL_ERROR;
            i3 = 1015;
        }
        super.handleMessageResult(context, jSONObject, i3, str);
        LogUtils.d(TAG, "errorCode:" + i3 + "  strMsg" + str);
        getChatMsg().setTipsCode(i3);
        getChatMsg().setTips(str2);
        ChatMsgManagerImpl.getInstance(this.mContext).onSendMessageResult(i3, getChatMsg(), j2, getListenerKey());
    }

    public void setChatMsg(ChatMsg chatMsg) {
        this.mChatMsg = chatMsg;
    }
}
