package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class IMMediaSendMsgHttpRequest extends IMMediaBaseHttpRequest {
    private static final String TAG = "IMMediaSendMsgHttpRequest";
    private long mContactor;
    private long mContactorPauid;
    private String mContactorThirdid;
    private int mContactorType;
    private String mContent;
    private String mListenerKey;
    private String mMsgKey;
    private int mMsgType;
    private ChatMsg mSendMsg;

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ Map getHeaders() {
        return super.getHeaders();
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ String getMethod() {
        return super.getMethod();
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ boolean shouldAbort() {
        return super.shouldAbort();
    }

    public IMMediaSendMsgHttpRequest(Context context, long j, ChatMsg chatMsg, String str) {
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContactor = j;
        this.mSendMsg = chatMsg;
        this.mListenerKey = str;
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

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str = new String(bArr);
        LogUtils.d(TAG, "BC> mListenerKey=" + this.mListenerKey + ", errorCode=" + i + ", result=" + str);
        if (!TextUtils.isEmpty(this.mListenerKey)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (i == 200) {
                    i2 = jSONObject.optInt("error_code", -1);
                    long optLong = jSONObject.optLong("msgid", -1L);
                    long optLong2 = jSONObject.optLong("msg_time", -1L);
                    if (optLong > 0) {
                        this.mSendMsg.setMsgId(optLong);
                    }
                    if (optLong2 > 0) {
                        this.mSendMsg.setMsgTime(optLong2);
                    }
                } else {
                    i2 = i;
                }
                this.mSendMsg.setMediaRoleMsg(true);
            } catch (Exception e) {
                i2 = 1010;
                e.printStackTrace();
            }
            ChatMsgManagerImpl.getInstance(this.mContext).onMediaSendChatMsgResult(this.mListenerKey, i2, this.mSendMsg);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        return getHostUrl() + "rest/3.0/im/send_msg";
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
            this.mMsgType = this.mSendMsg.getMsgType();
            jSONObject.put("type", this.mMsgType);
            this.mContent = this.mSendMsg.getMsgContent();
            jSONObject.put("content", this.mContent);
            this.mMsgKey = this.mSendMsg.getMsgKey();
            if (TextUtils.isEmpty(this.mMsgKey)) {
                this.mSendMsg.createMsgKey(this.mContext);
                this.mMsgKey = this.mSendMsg.getMsgKey();
            }
            jSONObject.put("msg_key", this.mMsgKey);
            LogUtils.d(TAG, "BC> before genSign param=" + jSONObject);
            jSONObject.put("sign", generateSign(jSONObject));
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogUtils.d(TAG, "BC> param=" + jSONObject.toString());
        return jSONObject.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return HttpHelper.CONTENT_JSON;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        ChatMsgManagerImpl.getInstance(this.mContext).onMediaSendChatMsgResult(this.mListenerKey, ((Integer) transErrorCode(i, bArr, th).first).intValue(), this.mSendMsg);
    }
}
