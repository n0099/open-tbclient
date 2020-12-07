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
import com.baidu.searchbox.ugc.model.UgcConstant;
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
/* loaded from: classes9.dex */
public class IMFetchMsgByHostRequest extends BaseHttpRequest {
    private static final String TAG = "IMFetchMsgByHostRequest";
    private long mBeginid;
    private int mCategory;
    private long mContacter;
    private int mCount;
    private long mEndid;
    private boolean mIsReliable;
    private String mKey;
    private long mUk;

    public IMFetchMsgByHostRequest(Context context, String str, long j, long j2, int i, int i2, long j3, long j4, boolean z) {
        this.mContext = context;
        this.mUk = j;
        this.mContacter = j2;
        this.mCategory = i;
        this.mCount = i2;
        this.mBeginid = j3;
        this.mEndid = j4;
        this.mKey = str;
        this.mIsReliable = z;
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
        boolean z = false;
        try {
            JSONObject jSONObject = new JSONObject(str3);
            i3 = jSONObject.getInt("err_code");
            str2 = jSONObject.optString("err_msg", "");
            str4 = jSONObject.optString("request_id", "0");
            z = jSONObject.optBoolean("has_more", false);
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
        if (this.mIsReliable && arrayList != null && arrayList.size() > 0) {
            LogUtils.d(TAG, "短连接回ack begin");
            final ArrayList<ChatMsg> arrayList3 = arrayList;
            TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.request.IMFetchMsgByHostRequest.1
                @Override // java.lang.Runnable
                public void run() {
                    IMAckRequest iMAckRequest = new IMAckRequest(IMFetchMsgByHostRequest.this.mContext, IMFetchMsgByHostRequest.this.mKey, IMFetchMsgByHostRequest.this.mUk, IMFetchMsgByHostRequest.this.mContacter, IMFetchMsgByHostRequest.this.mCategory, IMFetchMsgByHostRequest.this.mCount, IMFetchMsgByHostRequest.this.mBeginid, IMFetchMsgByHostRequest.this.mEndid, IMFetchMsgByHostRequest.this.mIsReliable, arrayList3);
                    HttpHelper.executor(IMFetchMsgByHostRequest.this.mContext, iMAckRequest, iMAckRequest);
                }
            });
        }
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener instanceof IFetchMsgByIdExtendListener) {
            ((IFetchMsgByIdExtendListener) removeListener).onFetchMsgByIdResult(i3, str2, "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, i2, ((Long) type.t).longValue(), arrayList, z);
            LogUtils.d(TAG, "onSuccess, IFetchMsgByIdExtendListener.onFetchMsgByIdResult");
        } else if (removeListener instanceof IFetchMsgByIdListener) {
            ((IFetchMsgByIdListener) removeListener).onFetchMsgByIdResult(i3, str2, "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, i2, ((Long) type.t).longValue(), arrayList);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        LogUtils.d(TAG, "onFailure errorCode: " + transErrorCode(i, bArr, th).first);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener instanceof IFetchMsgByIdExtendListener) {
            ((IFetchMsgByIdExtendListener) removeListener).onFetchMsgByIdResult(i, "", "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, 0, 0L, null, false);
            LogUtils.d(TAG, "onFailure, IFetchMsgByIdExtendListener.onFetchMsgByIdResult");
        } else if (removeListener instanceof IFetchMsgByIdListener) {
            ((IFetchMsgByIdListener) removeListener).onFetchMsgByIdResult(i, "", "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, 0, 0L, null);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        String str = "https://pim.baidu.com/";
        switch (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0)) {
            case 0:
                str = "https://pim.baidu.com/";
                break;
            case 1:
            case 2:
                str = "http://rd-im-server.bcc-szth.baidu.com:8111/";
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
        JSONObject json;
        StringBuilder sb = new StringBuilder();
        sb.append("appid=").append(Utility.readAppId(this.mContext));
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
        LogUtils.d(TAG, "IMFetchMsgByHostRequest param:" + sb2);
        String[] split = sb2.split(ETAG.ITEM_SEPARATOR);
        Arrays.sort(split);
        String str = "";
        for (String str2 : split) {
            if (str2.contains(UgcConstant.EXT_INFO)) {
                str2 = URLDecoder.decode(str2);
            }
            str = str + str2;
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
