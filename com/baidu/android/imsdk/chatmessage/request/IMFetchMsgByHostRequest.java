package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
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
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.pms.constants.PmsConstant;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMFetchMsgByHostRequest extends BaseHttpRequest {
    public static final String TAG = "IMFetchMsgByHostRequest";
    public long mBeginid;
    public int mCategory;
    public long mContacter;
    public int mCount;
    public long mEndid;
    public boolean mIsReliable;
    public String mKey;
    public long mUk;

    public IMFetchMsgByHostRequest(Context context, String str, long j, long j2, int i2, int i3, long j3, long j4, boolean z) {
        this.mContext = context;
        this.mUk = j;
        this.mContacter = j2;
        this.mCategory = i2;
        this.mCount = i3;
        this.mBeginid = j3;
        this.mEndid = j4;
        this.mKey = str;
        this.mIsReliable = z;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put("Cookie", "BDUSS=");
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
        String str = "https://pim.baidu.com/";
        if (readIntData != 0) {
            if (readIntData == 1 || readIntData == 2) {
                str = "http://rd-im-server.bcc-szth.baidu.com:8111/";
            } else if (readIntData == 3) {
                str = Constants.URL_HTTP_BOX;
            }
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
        sb.append("appid=");
        sb.append(Utility.readAppId(this.mContext));
        sb.append("&category=");
        sb.append(this.mCategory);
        sb.append("&count=");
        sb.append(this.mCount);
        sb.append("&msgid_begin=");
        sb.append(this.mBeginid);
        sb.append("&msgid_end=");
        sb.append(this.mEndid);
        sb.append("&sdk_version=");
        sb.append(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
        sb.append("&to=");
        sb.append(this.mContacter);
        sb.append("&uk=");
        sb.append(this.mUk);
        if (4 == this.mCategory && (json = MessageExt.getInstance().toJson()) != null && json.length() > 0) {
            sb.append("&ext_info=");
            sb.append(URLEncoder.encode(json.toString()));
        }
        String sb2 = sb.toString();
        LogUtils.d(TAG, "IMFetchMsgByHostRequest param:" + sb2);
        String[] split = sb2.split("&");
        Arrays.sort(split);
        String str = "";
        for (String str2 : split) {
            if (str2.contains("ext_info")) {
                str2 = URLDecoder.decode(str2);
            }
            str = str + str2;
        }
        LogUtils.d(TAG, "smd5: " + str);
        sb.append("&sign=");
        sb.append(getMd5(str));
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        LogUtils.d(TAG, "onFailure errorCode: " + transErrorCode.first);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener instanceof IFetchMsgByIdExtendListener) {
            ((IFetchMsgByIdExtendListener) removeListener).onFetchMsgByIdResult(i2, "", "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, 0, 0L, null, false);
            LogUtils.d(TAG, "onFailure, IFetchMsgByIdExtendListener.onFetchMsgByIdResult");
        } else if (removeListener instanceof IFetchMsgByIdListener) {
            ((IFetchMsgByIdListener) removeListener).onFetchMsgByIdResult(i2, "", "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, 0, 0L, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0113  */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, java.lang.Long] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i2, byte[] bArr) {
        boolean z;
        int i3;
        final ArrayList<ChatMsg> arrayList;
        String str;
        boolean z2;
        int i4;
        IMListener removeListener;
        String str2 = "";
        String str3 = new String(bArr);
        LogUtils.d(TAG, "onSuccess :" + str3);
        Type type = new Type();
        type.t = 0L;
        int i5 = 0;
        ArrayList<ChatMsg> arrayList2 = null;
        try {
            JSONObject jSONObject = new JSONObject(str3);
            int i6 = jSONObject.getInt(PmsConstant.Statistic.STATISTIC_ERRCODE);
            String optString = jSONObject.optString(PmsConstant.Statistic.STATISTIC_ERRMSG, "");
            str2 = jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, "0");
            z = jSONObject.optBoolean("has_more", false);
            if (i6 == 0) {
                try {
                    if (jSONObject.has(NotificationCompat.CarExtender.KEY_MESSAGES)) {
                        JSONArray jSONArray = jSONObject.getJSONArray(NotificationCompat.CarExtender.KEY_MESSAGES);
                        int length = jSONArray.length();
                        try {
                            arrayList2 = MessageParser.parserMessage(this.mContext, jSONArray, type, true, false);
                            i5 = length;
                        } catch (Exception e2) {
                            e = e2;
                            i5 = length;
                            LogUtils.e(TAG, "JSONException", e);
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            i3 = i5;
                            arrayList = null;
                            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                            z2 = z;
                            i4 = 1010;
                            LogUtils.d(TAG, "onSuccess requestid : " + str2 + " , resultCode: " + i4 + " , resultMsg : " + str);
                            if (this.mIsReliable) {
                                LogUtils.d(TAG, "短连接回ack begin");
                                TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.request.IMFetchMsgByHostRequest.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IMAckRequest iMAckRequest = new IMAckRequest(IMFetchMsgByHostRequest.this.mContext, IMFetchMsgByHostRequest.this.mKey, IMFetchMsgByHostRequest.this.mUk, IMFetchMsgByHostRequest.this.mContacter, IMFetchMsgByHostRequest.this.mCategory, IMFetchMsgByHostRequest.this.mCount, IMFetchMsgByHostRequest.this.mBeginid, IMFetchMsgByHostRequest.this.mEndid, IMFetchMsgByHostRequest.this.mIsReliable, arrayList);
                                        HttpHelper.executor(IMFetchMsgByHostRequest.this.mContext, iMAckRequest, iMAckRequest);
                                    }
                                });
                            }
                            removeListener = ListenerManager.getInstance().removeListener(this.mKey);
                            if (!(removeListener instanceof IFetchMsgByIdExtendListener)) {
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            i3 = i5;
            arrayList = arrayList2;
            str = optString;
            z2 = z;
            i4 = i6;
        } catch (Exception e4) {
            e = e4;
            z = false;
        }
        LogUtils.d(TAG, "onSuccess requestid : " + str2 + " , resultCode: " + i4 + " , resultMsg : " + str);
        if (this.mIsReliable && arrayList != null && arrayList.size() > 0) {
            LogUtils.d(TAG, "短连接回ack begin");
            TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.request.IMFetchMsgByHostRequest.1
                @Override // java.lang.Runnable
                public void run() {
                    IMAckRequest iMAckRequest = new IMAckRequest(IMFetchMsgByHostRequest.this.mContext, IMFetchMsgByHostRequest.this.mKey, IMFetchMsgByHostRequest.this.mUk, IMFetchMsgByHostRequest.this.mContacter, IMFetchMsgByHostRequest.this.mCategory, IMFetchMsgByHostRequest.this.mCount, IMFetchMsgByHostRequest.this.mBeginid, IMFetchMsgByHostRequest.this.mEndid, IMFetchMsgByHostRequest.this.mIsReliable, arrayList);
                    HttpHelper.executor(IMFetchMsgByHostRequest.this.mContext, iMAckRequest, iMAckRequest);
                }
            });
        }
        removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (!(removeListener instanceof IFetchMsgByIdExtendListener)) {
            ((IFetchMsgByIdExtendListener) removeListener).onFetchMsgByIdResult(i4, str, "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, i3, ((Long) type.t).longValue(), arrayList, z2);
            LogUtils.d(TAG, "onSuccess, IFetchMsgByIdExtendListener.onFetchMsgByIdResult");
        } else if (removeListener instanceof IFetchMsgByIdListener) {
            ((IFetchMsgByIdListener) removeListener).onFetchMsgByIdResult(i4, str, "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, i3, ((Long) type.t).longValue(), arrayList);
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
