package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMMediaSendMsgHttpRequest extends IMMediaBaseHttpRequest {
    public static final String TAG = "IMMediaSendMsgHttpRequest";
    public long mContactor;
    public long mContactorPauid;
    public String mContactorThirdid;
    public int mContactorType;
    public String mContent;
    public String mListenerKey;
    public String mMsgKey;
    public int mMsgType;
    public ChatMsg mSendMsg;

    public IMMediaSendMsgHttpRequest(Context context, long j, ChatMsg chatMsg, String str) {
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContactor = j;
        this.mSendMsg = chatMsg;
        this.mListenerKey = str;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/json";
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ Map getHeaders() {
        return super.getHeaders();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        return getHostUrl() + "rest/3.0/im/send_msg";
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ String getMethod() {
        return super.getMethod();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        JSONObject jSONObject = new JSONObject();
        try {
            putCommonParams(jSONObject);
            if (this.mContactor > 0) {
                LogUtils.d(TAG, "BC> before transBDUID mContactor=" + this.mContactor);
                jSONObject.put("contacter", Utility.transBDUID(this.mContactor + ""));
            }
            if (this.mContactorType >= 0) {
                jSONObject.put("contacter_type", this.mContactorType);
            }
            if (this.mContactorPauid > 0) {
                jSONObject.put("contacter_pa_uid", this.mContactorPauid);
            }
            if (!TextUtils.isEmpty(this.mContactorThirdid)) {
                jSONObject.put("contacter_third_id", this.mContactorThirdid);
            }
            int msgType = this.mSendMsg.getMsgType();
            this.mMsgType = msgType;
            jSONObject.put("type", msgType);
            String msgContent = this.mSendMsg.getMsgContent();
            this.mContent = msgContent;
            jSONObject.put("content", msgContent);
            String msgKey = this.mSendMsg.getMsgKey();
            this.mMsgKey = msgKey;
            if (TextUtils.isEmpty(msgKey)) {
                this.mSendMsg.createMsgKey(this.mContext);
                this.mMsgKey = this.mSendMsg.getMsgKey();
            }
            jSONObject.put("msg_key", this.mMsgKey);
            LogUtils.d(TAG, "BC> before genSign param=" + jSONObject);
            jSONObject.put("sign", generateSign(jSONObject));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        LogUtils.d(TAG, "BC> param=" + jSONObject.toString());
        return jSONObject.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        ChatMsgManagerImpl.getInstance(this.mContext).onMediaSendChatMsgResult(this.mListenerKey, ((Integer) transErrorCode(i, bArr, th).first).intValue(), this.mSendMsg);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str = new String(bArr);
        LogUtils.d(TAG, "BC> mListenerKey=" + this.mListenerKey + ", errorCode=" + i + ", result=" + str);
        if (TextUtils.isEmpty(this.mListenerKey)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (i == 200) {
                i = jSONObject.optInt("error_code", -1);
                long optLong = jSONObject.optLong("msgid", -1L);
                long optLong2 = jSONObject.optLong("msg_time", -1L);
                if (optLong > 0) {
                    this.mSendMsg.setMsgId(optLong);
                }
                if (optLong2 > 0) {
                    this.mSendMsg.setMsgTime(optLong2);
                }
            }
            this.mSendMsg.setMediaRoleMsg(true);
        } catch (Exception e2) {
            e2.printStackTrace();
            i = 1010;
        }
        ChatMsgManagerImpl.getInstance(this.mContext).onMediaSendChatMsgResult(this.mListenerKey, i, this.mSendMsg);
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ boolean shouldAbort() {
        return super.shouldAbort();
    }

    public IMMediaSendMsgHttpRequest(Context context, long j, int i, long j2, String str, ChatMsg chatMsg, String str2) {
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContactor = j;
        this.mSendMsg = chatMsg;
        this.mListenerKey = str2;
        this.mContactorType = i;
        this.mContactorPauid = j2;
        this.mContactorThirdid = str;
    }
}
