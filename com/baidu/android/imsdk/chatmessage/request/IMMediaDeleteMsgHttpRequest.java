package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMMediaDeleteMsgHttpRequest extends IMMediaBaseHttpRequest {
    private static final String TAG = "IMMediaDeleteMsgHttpRequest";
    private long mContactor;
    private long mContactorPauid;
    private String mContactorThirdid;
    private int mContactorType;
    private String mListenerKey;
    private long mMaxId;
    private List<Long> mMsgIds;

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

    public IMMediaDeleteMsgHttpRequest(Context context, long j, long j2, List<Long> list, String str) {
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContactor = j;
        this.mMaxId = j2;
        this.mMsgIds = list;
        this.mListenerKey = str;
    }

    public IMMediaDeleteMsgHttpRequest(Context context, long j, int i, long j2, String str, long j3, List<Long> list, String str2) {
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContactor = j;
        this.mMaxId = j3;
        this.mMsgIds = list;
        this.mListenerKey = str2;
        this.mContactorType = i;
        this.mContactorPauid = j2;
        this.mContactorThirdid = str;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str = new String(bArr);
        LogUtils.d(TAG, "BC> mListenerKey=" + this.mListenerKey + ", errorCode=" + i + ", result=" + str);
        if (!TextUtils.isEmpty(this.mListenerKey)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (i == 200) {
                    i = jSONObject.optInt("error_code", -1);
                }
            } catch (Exception e) {
                i = 1010;
                e.printStackTrace();
            }
            ChatMsgManagerImpl.getInstance(this.mContext).onMediaDeleteChatMsgResult(this.mListenerKey, i, "success!");
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        return getHostUrl() + "rest/3.0/im/delete_msg";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        JSONObject jSONObject = new JSONObject();
        try {
            putCommonParams(jSONObject);
            if (this.mContactor > 0) {
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
            if (this.mMaxId > 0) {
                jSONObject.put("max_msgid", this.mMaxId);
            }
            if (this.mMsgIds != null && this.mMsgIds.size() > 0) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i < this.mMsgIds.size(); i++) {
                        jSONArray.put(this.mMsgIds.get(i));
                    }
                    jSONObject.put("msgids", jSONArray);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            LogUtils.d(TAG, "BC> before genSign param=" + jSONObject);
            jSONObject.put("sign", generateSign(jSONObject));
        } catch (Exception e2) {
            e2.printStackTrace();
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
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        ChatMsgManagerImpl.getInstance(this.mContext).onMediaDeleteChatMsgResult(this.mListenerKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second);
    }
}
