package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsgFactory;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class IMMediaGetChatSessionRequest extends IMMediaBaseHttpRequest {
    private static final int MAX_FETCH_COUNT = 20;
    private static final String TAG = "IMMediaGetChatSessionRequest";
    private long mContacter;
    private long mContactorPauid;
    private String mContactorThirdid;
    private int mContactorType;
    private int mCount;
    private long mEndTime;
    private String mKey;

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

    public IMMediaGetChatSessionRequest(Context context, long j, int i, long j2, String str) {
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContacter = j;
        this.mCount = i;
        this.mEndTime = j2;
        this.mKey = str;
    }

    public IMMediaGetChatSessionRequest(Context context, long j, int i, long j2, String str, int i2, long j3, String str2) {
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContacter = j;
        this.mCount = i2;
        this.mEndTime = j3;
        this.mKey = str2;
        this.mContactorType = i;
        this.mContactorPauid = j2;
        this.mContactorThirdid = str;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        JSONObject jSONObject = new JSONObject();
        try {
            putCommonParams(jSONObject);
            if (this.mContacter > 0) {
                jSONObject.put("contacter", Utility.transBDUID(String.valueOf(this.mContacter)));
            }
            if (this.mEndTime > 0) {
                jSONObject.put("end_time", this.mEndTime);
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
            jSONObject.put("count", this.mCount <= 20 ? this.mCount : 20);
            jSONObject.put("sign", generateSign(jSONObject));
        } catch (JSONException e) {
            LogUtils.e(TAG, "Exception ", e);
        }
        return jSONObject.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return HttpHelper.CONTENT_JSON;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x015f  */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        JSONException e;
        int i3;
        int i4;
        String str;
        String str2;
        String str3 = new String(bArr);
        LogUtils.d(TAG, "onSuccess resultContent = " + str3);
        int i5 = 0;
        int i6 = 0;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str3);
            int optInt = jSONObject.optInt("error_code", 0);
            if (optInt == 0) {
                int optInt2 = jSONObject.optInt("has_more", 0);
                try {
                    int optInt3 = jSONObject.optInt("total_unread_num", 0);
                    try {
                        JSONArray optJSONArray = jSONObject.optJSONArray("sessions");
                        if (optJSONArray != null) {
                            for (int i7 = 0; i7 < optJSONArray.length(); i7++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i7);
                                long j = 0;
                                try {
                                    j = Long.parseLong(Utility.transBDUK(jSONObject2.optString("contacter_pass_uk")));
                                } catch (NumberFormatException e2) {
                                    LogUtils.e(LogUtils.TAG, "IMMediaGetChatSessionRequest NumberFormatException", e2);
                                }
                                long optLong = jSONObject2.optLong("contacter_pa_uid");
                                int optInt4 = jSONObject2.optInt("content_type");
                                String optString = jSONObject2.optString("content");
                                ChatMsg newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, 0, optInt4, -1);
                                if (newChatMsg == null) {
                                    str = "";
                                    str2 = "";
                                } else {
                                    newChatMsg.setMsgType(optInt4);
                                    newChatMsg.setMsgContentFromServer(optString);
                                    String recommendDescription = newChatMsg.getRecommendDescription();
                                    str = newChatMsg.getExtLog();
                                    str2 = recommendDescription;
                                }
                                int optInt5 = jSONObject2.optInt("unread_num");
                                long optLong2 = jSONObject2.optLong("last_time");
                                long optLong3 = jSONObject2.optLong("contacter_im_uk");
                                int optInt6 = jSONObject2.optInt("is_top", 0);
                                ChatSession chatSession = new ChatSession(0, optLong3, j, "");
                                chatSession.setNewMsgSum(optInt5);
                                chatSession.setLastMsgTime(optLong2);
                                chatSession.setLastOpenTime(optLong2);
                                chatSession.setLastMsg(str2);
                                chatSession.setMarkTop(optInt6);
                                chatSession.setMarkTopTime(optLong2);
                                chatSession.setSessionFrom(1);
                                chatSession.setIsClicked(1);
                                chatSession.setExt(str);
                                if (optLong != 0) {
                                    chatSession.setPaid(optLong);
                                    hashMap.put(Long.valueOf(optLong), chatSession);
                                } else if (j != 0) {
                                    hashMap2.put(Long.valueOf(j), chatSession);
                                }
                            }
                        }
                        i6 = optInt3;
                        i5 = optInt2;
                    } catch (JSONException e3) {
                        e = e3;
                        i2 = optInt3;
                        i5 = optInt2;
                        LogUtils.e(TAG, "IMMediaGetChatSessionRequest JSONException", e);
                        i3 = i5;
                        i4 = 1010;
                        ChatSessionManagerImpl.getInstance(this.mContext).onMediaGetChatSessionRequest(i4, i3 != 1, i2, hashMap, hashMap2, this.mKey);
                    }
                } catch (JSONException e4) {
                    i2 = 0;
                    e = e4;
                    i5 = optInt2;
                }
            }
            i2 = i6;
            i3 = i5;
            i4 = optInt;
        } catch (JSONException e5) {
            i2 = 0;
            e = e5;
        }
        ChatSessionManagerImpl.getInstance(this.mContext).onMediaGetChatSessionRequest(i4, i3 != 1, i2, hashMap, hashMap2, this.mKey);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        LogUtils.d(TAG, "onFailure error = " + transErrorCode.first + " errormsg = " + ((String) transErrorCode.second));
        ChatSessionManagerImpl.getInstance(this.mContext).onMediaGetChatSessionRequest(((Integer) transErrorCode.first).intValue(), false, 0, null, null, this.mKey);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        return getHostUrl() + "rest/3.0/im/fetch_session";
    }
}
