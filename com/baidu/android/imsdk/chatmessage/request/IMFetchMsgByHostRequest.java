package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.webkit.internal.ETAG;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.SM;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMFetchMsgByHostRequest extends BaseHttpRequest {
    private static final String TAG = "IMFetchMsgByHostRequest";
    private long mBeginid;
    private int mCategory;
    private long mContacter;
    private int mCount;
    private long mEndid;
    private String mKey;
    private long mUk;

    public IMFetchMsgByHostRequest(Context context, String str, long j, long j2, int i, int i2, long j3, long j4) {
        this.mContext = context;
        this.mUk = j;
        this.mContacter = j2;
        this.mCategory = i;
        this.mCount = i2;
        this.mBeginid = j3;
        this.mEndid = j4;
        this.mKey = str;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Long] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        int i3;
        String str2;
        ArrayList<ChatMsg> arrayList;
        String str3 = new String(bArr);
        LogUtils.d(TAG, "onSuccess :" + str3);
        ArrayList<ChatMsg> arrayList2 = null;
        String str4 = "";
        Type type = new Type();
        type.t = 0L;
        int i4 = 0;
        try {
            JSONObject jSONObject = new JSONObject(str3);
            i3 = jSONObject.getInt("err_code");
            str2 = jSONObject.optString("err_msg", "");
            str4 = jSONObject.optString("request_id", "0");
            if (i3 == 0 && jSONObject.has("messages")) {
                JSONArray jSONArray = jSONObject.getJSONArray("messages");
                i4 = jSONArray.length();
                arrayList2 = MessageParser.parserMessage(this.mContext, jSONArray, type, true, false);
            }
            i2 = i4;
            arrayList = arrayList2;
            str = str4;
        } catch (Exception e) {
            i2 = i4;
            str = str4;
            LogUtils.e(TAG, "JSONException", e);
            i3 = 1010;
            str2 = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            arrayList = null;
        }
        LogUtils.d(TAG, "onSuccess requestid : " + str + " , resultCode: " + i3 + " , resultMsg : " + str2);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener instanceof IFetchMsgByIdListener) {
            ((IFetchMsgByIdListener) removeListener).onFetchMsgByIdResult(i3, str2, "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, i2, ((Long) type.t).longValue(), arrayList);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        LogUtils.d(TAG, "onFailure errorCode: " + transErrorCode(i, bArr, th).first);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener instanceof IFetchMsgByIdListener) {
            ((IFetchMsgByIdListener) removeListener).onFetchMsgByIdResult(i, "", "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, 0, 0L, null);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        String str = Constants.URL_HTTP_ONLINE;
        switch (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0)) {
            case 0:
                str = Constants.URL_HTTP_ONLINE;
                break;
            case 1:
            case 2:
                str = "http://cp01-ocean-749.epc.baidu.com:8111/";
                break;
            case 3:
                str = Constants.URL_HTTP_BOX;
                break;
        }
        return str + "imsapi/1.0/fetchmsg/liveshowhost";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        sb.append("appid=").append(Utility.readAppId(this.mContext));
        sb.append("&category=").append(this.mCategory);
        sb.append("&count=").append(this.mCount);
        sb.append("&msgid_begin=").append(this.mBeginid);
        sb.append("&msgid_end=").append(this.mEndid);
        sb.append("&sdk_version=").append(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
        sb.append("&to=").append(this.mContacter);
        sb.append("&uk=").append(this.mUk);
        String[] split = sb.toString().split(ETAG.ITEM_SEPARATOR);
        Arrays.sort(split);
        String str = "";
        for (int i = 0; i < split.length; i++) {
            str = str + split[i];
        }
        LogUtils.d(TAG, "smd5: " + str);
        sb.append("&sign=").append(getMd5(str));
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put(SM.COOKIE, "BDUSS=");
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
