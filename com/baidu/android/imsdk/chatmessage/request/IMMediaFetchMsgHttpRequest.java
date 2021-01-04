package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class IMMediaFetchMsgHttpRequest extends IMMediaBaseHttpRequest {
    private static final String TAG = "IMMediaFetchMsgHttpRequest";
    private long mBeginMsgTime;
    private long mContactor;
    private long mContactorPauid;
    private String mContactorThirdid;
    private int mContactorType;
    private int mCount;
    private long mEndMsgTime;
    private String mListenerKey;

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

    public IMMediaFetchMsgHttpRequest(Context context, long j, long j2, long j3, int i, String str) {
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContactor = j;
        this.mBeginMsgTime = j2;
        this.mEndMsgTime = j3;
        this.mCount = i;
        this.mListenerKey = str;
    }

    public IMMediaFetchMsgHttpRequest(Context context, long j, int i, long j2, String str, long j3, long j4, int i2, String str2) {
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContactor = j;
        this.mBeginMsgTime = j3;
        this.mEndMsgTime = j4;
        this.mCount = i2;
        this.mListenerKey = str2;
        this.mContactorType = i;
        this.mContactorPauid = j2;
        this.mContactorThirdid = str;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        Exception exc;
        boolean z;
        int i2;
        String str;
        boolean z2;
        String str2 = new String(bArr);
        LogUtils.d(TAG, "BC> mListenerKey=" + this.mListenerKey + ", errorCode=" + i + ", result=" + str2);
        if (!TextUtils.isEmpty(this.mListenerKey)) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (i != 200) {
                    z2 = false;
                    str = "";
                } else {
                    i = jSONObject.optInt("error_code", -1);
                    String optString = jSONObject.optString("error_msg", "");
                    z2 = jSONObject.optInt("has_more", 0) == 1;
                    if (i == 0) {
                        try {
                            JSONArray optJSONArray = jSONObject.optJSONArray("msgs");
                            LogUtils.d(TAG, "BC> msgArrJson=" + optJSONArray);
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                    parserMsg(arrayList, optJSONArray, i3);
                                }
                            }
                        } catch (Exception e) {
                            exc = e;
                            z = z2;
                            i2 = 1010;
                            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                            exc.printStackTrace();
                            ChatMsgManagerImpl.getInstance(this.mContext).onMediaFetchChatMsgsResult(this.mListenerKey, i2, str, z, arrayList);
                        }
                    }
                    str = optString;
                }
                z = z2;
                i2 = i;
            } catch (Exception e2) {
                exc = e2;
                z = false;
            }
            ChatMsgManagerImpl.getInstance(this.mContext).onMediaFetchChatMsgsResult(this.mListenerKey, i2, str, z, arrayList);
        }
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [T, java.lang.Long] */
    private void parserMsg(List<ChatMsg> list, JSONArray jSONArray, int i) {
        try {
            LogUtils.d(TAG, "BC> parserMsg=" + jSONArray);
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            long optLong = jSONObject.optLong("contacter_im_uk", -1L);
            String transBDUK = Utility.transBDUK(jSONObject.optString("from_pass_uk", ""));
            long optLong2 = jSONObject.optLong("from_im_uk", -1L);
            String transBDUK2 = Utility.transBDUK(jSONObject.optString("to_pass_uk", ""));
            Type type = new Type();
            type.t = 0L;
            ChatMsg parserMessage = MessageParser.parserMessage(this.mContext, jSONObject, type, false);
            parserMessage.setMsgId(((Long) type.t).longValue());
            parserMessage.setFromUser(optLong2);
            parserMessage.setContacter(optLong);
            parserMessage.setContacterBduid(transBDUK2);
            parserMessage.setSenderUid(transBDUK);
            parserMessage.setIsClicked(true);
            parserMessage.setMsgReaded(1);
            LogUtils.d(TAG, "BC> msg=" + parserMessage.toString());
            parserMessage.setMediaRoleMsg(true);
            parserMessage.setStatus(0);
            list.add(parserMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        return getHostUrl() + "rest/3.0/im/fetch_msg";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        JSONObject jSONObject = new JSONObject();
        try {
            putCommonParams(jSONObject);
            if (this.mCount > 0) {
                jSONObject.put("count", Math.abs(this.mCount));
            }
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
            if (this.mBeginMsgTime > 0) {
                jSONObject.put("begin_time", this.mBeginMsgTime);
            }
            if (this.mEndMsgTime > 0) {
                jSONObject.put("end_time", this.mEndMsgTime);
            }
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
        LogUtils.d(TAG, "BC> mListenerKey=" + this.mListenerKey + ", errorCode=" + i + ", resultContent=" + new String(bArr));
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        ChatMsgManagerImpl.getInstance(this.mContext).onMediaFetchChatMsgsResult(this.mListenerKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, false, null);
    }
}
