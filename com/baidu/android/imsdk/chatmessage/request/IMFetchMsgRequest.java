package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdExtendListener;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.request.MessageExt;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.webkit.internal.ETAG;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.SM;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class IMFetchMsgRequest extends BaseHttpRequest {
    private static final String TAG = "IMFetchMsgRequest";
    private Long mAppid;
    private long mBeginid;
    private int mCategory;
    private long mContacter;
    private int mCount;
    private long mEndid;
    private boolean mIsReliable;
    private String mKey;
    private long mUk;

    public IMFetchMsgRequest(Context context, String str, long j, long j2, long j3, int i, int i2, long j4, long j5, boolean z) {
        this.mContext = context;
        this.mAppid = Long.valueOf(j);
        this.mUk = j2;
        this.mContacter = j3;
        this.mCategory = i;
        this.mCount = i2;
        this.mBeginid = j4;
        this.mEndid = j5;
        this.mKey = str;
        this.mIsReliable = z;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Long] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        int i3;
        String str;
        ArrayList<ChatMsg> arrayList;
        String str2 = new String(bArr);
        LogUtils.d(TAG, "  " + str2);
        ArrayList<ChatMsg> arrayList2 = null;
        String str3 = "";
        Type type = new Type();
        type.t = 0L;
        int i4 = 0;
        boolean z = false;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            i3 = jSONObject.getInt("err_code");
            str = jSONObject.optString("err_msg", "");
            str3 = jSONObject.optString("request_id", "0");
            z = jSONObject.optBoolean("has_more", false);
            if (i3 == 0 && jSONObject.has("messages")) {
                JSONArray jSONArray = jSONObject.getJSONArray("messages");
                if (jSONArray != null) {
                    i4 = jSONArray.length();
                }
                arrayList2 = MessageParser.parserMessage(this.mContext, jSONArray, type, true, false);
            }
            i2 = i4;
            arrayList = arrayList2;
        } catch (Exception e) {
            i2 = i4;
            LogUtils.e("IMPaSetDisturbRequest", "JSONException", e);
            i3 = 1010;
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            arrayList = null;
        }
        LogUtils.d(TAG, "requestid : " + str3 + " , resultCode: " + i3 + " , resultMsg : " + str);
        if (this.mIsReliable && arrayList != null && arrayList.size() > 0) {
            LogUtils.d(TAG, "短连接回ack begin");
            final ArrayList<ChatMsg> arrayList3 = arrayList;
            TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.request.IMFetchMsgRequest.1
                @Override // java.lang.Runnable
                public void run() {
                    IMAckRequest iMAckRequest = new IMAckRequest(IMFetchMsgRequest.this.mContext, IMFetchMsgRequest.this.mKey, IMFetchMsgRequest.this.mUk, IMFetchMsgRequest.this.mContacter, IMFetchMsgRequest.this.mCategory, IMFetchMsgRequest.this.mCount, IMFetchMsgRequest.this.mBeginid, IMFetchMsgRequest.this.mEndid, IMFetchMsgRequest.this.mIsReliable, arrayList3);
                    HttpHelper.executor(IMFetchMsgRequest.this.mContext, iMAckRequest, iMAckRequest);
                }
            });
        }
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener instanceof IFetchMsgByIdExtendListener) {
            ((IFetchMsgByIdExtendListener) removeListener).onFetchMsgByIdResult(i3, str, "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, i2, ((Long) type.t).longValue(), arrayList, z);
            LogUtils.d(TAG, "IFetchMsgByIdExtendListener.onFetchMsgByIdResult");
        } else if (removeListener instanceof IFetchMsgByIdListener) {
            ((IFetchMsgByIdListener) removeListener).onFetchMsgByIdResult(i3, str, "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, i2, ((Long) type.t).longValue(), arrayList);
            LogUtils.d(TAG, "IFetchMsgByIdListener.onFetchMsgByIdResult");
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        LogUtils.d(TAG, "  errorCode: " + transErrorCode(i, bArr, th).first);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        String str = "https://pim.baidu.com/";
        switch (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0)) {
            case 0:
                str = "https://pim.baidu.com/";
                break;
            case 1:
                str = "http://rd-im-server.bcc-szth.baidu.com:8111/";
                break;
            case 2:
                str = Constants.URL_HTTP_QA;
                break;
            case 3:
                str = Constants.URL_HTTP_BOX;
                break;
        }
        return str + "imsapi/1.0/fetchmsg/liveshow";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        JSONObject json;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append("appid=").append(this.mAppid);
        sb.append("&category=").append(this.mCategory);
        sb.append("&count=").append(this.mCount);
        sb.append("&msgid_begin=").append(this.mBeginid);
        sb.append("&msgid_end=").append(this.mEndid);
        sb.append("&sdk_version=").append(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
        sb.append("&to=").append(this.mContacter);
        sb.append("&uk=").append(this.mUk);
        if (4 == this.mCategory && (json = MessageExt.getInstance().toJson()) != null && json.length() > 0) {
            sb.append("&ext_info=").append(URLEncoder.encode(json.toString()));
        }
        String sb2 = sb.toString();
        String[] split = sb2.split(ETAG.ITEM_SEPARATOR);
        Arrays.sort(split);
        String str = "";
        for (String str2 : split) {
            if (str2.contains("ext_info")) {
                str2 = URLDecoder.decode(str2);
            }
            str = str + str2;
        }
        LogUtils.d(TAG, "IMFetchMsgRequest param:" + sb2);
        LogUtils.d(TAG, " " + str);
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
