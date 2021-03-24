package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsgFactory;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMMediaGetChatSessionRequest extends IMMediaBaseHttpRequest {
    public static final int MAX_FETCH_COUNT = 20;
    public static final String TAG = "IMMediaGetChatSessionRequest";
    public long mContacter;
    public long mContactorPauid;
    public String mContactorThirdid;
    public int mContactorType;
    public int mCount;
    public long mEndTime;
    public String mKey;

    public IMMediaGetChatSessionRequest(Context context, long j, int i, long j2, String str) {
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContacter = j;
        this.mCount = i;
        this.mEndTime = j2;
        this.mKey = str;
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
        if (getHostUrl() == null) {
            return null;
        }
        return getHostUrl() + "rest/3.0/im/fetch_session";
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
            int i = 20;
            if (this.mCount <= 20) {
                i = this.mCount;
            }
            jSONObject.put("count", i);
            jSONObject.put("sign", generateSign(jSONObject));
        } catch (JSONException e2) {
            LogUtils.e(TAG, "Exception ", e2);
        }
        return jSONObject.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        LogUtils.d(TAG, "onFailure error = " + transErrorCode.first + " errormsg = " + ((String) transErrorCode.second));
        ChatSessionManagerImpl.getInstance(this.mContext).onMediaGetChatSessionRequest(((Integer) transErrorCode.first).intValue(), false, 0, null, null, this.mKey);
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0183  */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i, byte[] bArr) {
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        long j;
        long optLong;
        JSONArray jSONArray;
        int i6;
        int i7;
        int i8;
        String str2;
        String extLog;
        int optInt;
        int i9;
        long optLong2;
        long optLong3;
        String str3 = new String(bArr);
        String str4 = TAG;
        LogUtils.d(TAG, "onSuccess resultContent = " + str3);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str3);
            int optInt2 = jSONObject.optInt("error_code", 0);
            if (optInt2 == 0) {
                i2 = jSONObject.optInt("has_more", 0);
                try {
                    i3 = jSONObject.optInt("total_unread_num", 0);
                    try {
                        JSONArray optJSONArray = jSONObject.optJSONArray("sessions");
                        if (optJSONArray != null) {
                            int i10 = 0;
                            while (i10 < optJSONArray.length()) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i10);
                                try {
                                    j = Long.parseLong(Utility.transBDUK(jSONObject2.optString("contacter_pass_uk")));
                                } catch (NumberFormatException e2) {
                                    LogUtils.e(LogUtils.TAG, "IMMediaGetChatSessionRequest NumberFormatException", e2);
                                    j = 0;
                                } catch (JSONException e3) {
                                    e = e3;
                                    str = str4;
                                    LogUtils.e(str, "IMMediaGetChatSessionRequest JSONException", e);
                                    i4 = 1010;
                                    if (i2 == 1) {
                                    }
                                    ChatSessionManagerImpl.getInstance(this.mContext).onMediaGetChatSessionRequest(i4, i2 == 1, i3, hashMap, hashMap2, this.mKey);
                                }
                                String str5 = str4;
                                try {
                                    optLong = jSONObject2.optLong("contacter_pa_uid");
                                    int optInt3 = jSONObject2.optInt("content_type");
                                    String optString = jSONObject2.optString("content");
                                    jSONArray = optJSONArray;
                                    i6 = optInt2;
                                    i7 = i2;
                                    i8 = i3;
                                    try {
                                        ChatMsg newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, 0, optInt3, -1);
                                        str2 = "";
                                        if (newChatMsg != null) {
                                            try {
                                                newChatMsg.setMsgType(optInt3);
                                                newChatMsg.setMsgContentFromServer(optString);
                                                str2 = newChatMsg.getRecommendDescription();
                                                extLog = newChatMsg.getExtLog();
                                            } catch (JSONException e4) {
                                                e = e4;
                                                str = str5;
                                                i2 = i7;
                                                i3 = i8;
                                                LogUtils.e(str, "IMMediaGetChatSessionRequest JSONException", e);
                                                i4 = 1010;
                                                if (i2 == 1) {
                                                }
                                                ChatSessionManagerImpl.getInstance(this.mContext).onMediaGetChatSessionRequest(i4, i2 == 1, i3, hashMap, hashMap2, this.mKey);
                                            }
                                        } else {
                                            extLog = "";
                                        }
                                        optInt = jSONObject2.optInt("unread_num");
                                        i9 = i10;
                                        optLong2 = jSONObject2.optLong("last_time");
                                        optLong3 = jSONObject2.optLong("contacter_im_uk");
                                        str = str5;
                                    } catch (JSONException e5) {
                                        e = e5;
                                        str = str5;
                                    }
                                } catch (JSONException e6) {
                                    e = e6;
                                    str = str5;
                                }
                                try {
                                    int optInt4 = jSONObject2.optInt("is_top", 0);
                                    ChatSession chatSession = new ChatSession(0, optLong3, j, "");
                                    long j2 = j;
                                    chatSession.setNewMsgSum(optInt);
                                    chatSession.setLastMsgTime(optLong2);
                                    chatSession.setLastOpenTime(optLong2);
                                    chatSession.setLastMsg(str2);
                                    chatSession.setMarkTop(optInt4);
                                    chatSession.setMarkTopTime(optLong2);
                                    chatSession.setSessionFrom(1);
                                    chatSession.setIsClicked(1);
                                    chatSession.setExt(extLog);
                                    if (optLong != 0) {
                                        chatSession.setPaid(optLong);
                                        hashMap.put(Long.valueOf(optLong), chatSession);
                                    } else if (j2 != 0) {
                                        hashMap2.put(Long.valueOf(j2), chatSession);
                                    }
                                    i10 = i9 + 1;
                                    optJSONArray = jSONArray;
                                    optInt2 = i6;
                                    i2 = i7;
                                    i3 = i8;
                                    str4 = str;
                                } catch (JSONException e7) {
                                    e = e7;
                                    i2 = i7;
                                    i3 = i8;
                                    LogUtils.e(str, "IMMediaGetChatSessionRequest JSONException", e);
                                    i4 = 1010;
                                    if (i2 == 1) {
                                    }
                                    ChatSessionManagerImpl.getInstance(this.mContext).onMediaGetChatSessionRequest(i4, i2 == 1, i3, hashMap, hashMap2, this.mKey);
                                }
                            }
                        }
                        i5 = optInt2;
                        i2 = i2;
                        i3 = i3;
                    } catch (JSONException e8) {
                        e = e8;
                        str = str4;
                    }
                } catch (JSONException e9) {
                    e = e9;
                    str = TAG;
                    i3 = 0;
                    LogUtils.e(str, "IMMediaGetChatSessionRequest JSONException", e);
                    i4 = 1010;
                    if (i2 == 1) {
                    }
                    ChatSessionManagerImpl.getInstance(this.mContext).onMediaGetChatSessionRequest(i4, i2 == 1, i3, hashMap, hashMap2, this.mKey);
                }
            } else {
                i5 = optInt2;
                i2 = 0;
                i3 = 0;
            }
            i4 = i5;
        } catch (JSONException e10) {
            e = e10;
            str = TAG;
            i2 = 0;
        }
        ChatSessionManagerImpl.getInstance(this.mContext).onMediaGetChatSessionRequest(i4, i2 == 1, i3, hashMap, hashMap2, this.mKey);
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ boolean shouldAbort() {
        return super.shouldAbort();
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
}
