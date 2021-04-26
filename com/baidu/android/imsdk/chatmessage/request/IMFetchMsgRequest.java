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
import com.bumptech.glide.load.engine.GlideException;
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
public class IMFetchMsgRequest extends BaseHttpRequest {
    public static final String TAG = "IMFetchMsgRequest";
    public Long mAppid;
    public long mBeginid;
    public int mCategory;
    public long mContacter;
    public int mCount;
    public long mEndid;
    public boolean mIsReliable;
    public String mKey;
    public long mUk;

    public IMFetchMsgRequest(Context context, String str, long j, long j2, long j3, int i2, int i3, long j4, long j5, boolean z) {
        this.mContext = context;
        this.mAppid = Long.valueOf(j);
        this.mUk = j2;
        this.mContacter = j3;
        this.mCategory = i2;
        this.mCount = i3;
        this.mBeginid = j4;
        this.mEndid = j5;
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
            if (readIntData == 1) {
                str = "http://rd-im-server.bcc-szth.baidu.com:8111/";
            } else if (readIntData == 2) {
                str = Constants.URL_HTTP_QA;
            } else if (readIntData == 3) {
                str = Constants.URL_HTTP_BOX;
            }
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
        sb.append("appid=");
        sb.append(this.mAppid);
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
        String[] split = sb2.split("&");
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
        sb.append("&sign=");
        sb.append(getMd5(str));
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        LogUtils.d(TAG, "  errorCode: " + transErrorCode.first);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0119  */
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
        LogUtils.d(TAG, GlideException.IndentedAppendable.INDENT + str3);
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
                        int length = jSONArray != null ? jSONArray.length() : 0;
                        try {
                            arrayList2 = MessageParser.parserMessage(this.mContext, jSONArray, type, true, false);
                            i5 = length;
                        } catch (Exception e2) {
                            e = e2;
                            i5 = length;
                            LogUtils.e("IMPaSetDisturbRequest", "JSONException", e);
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            i3 = i5;
                            arrayList = null;
                            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                            z2 = z;
                            i4 = 1010;
                            LogUtils.d(TAG, "requestid : " + str2 + " , resultCode: " + i4 + " , resultMsg : " + str);
                            if (this.mIsReliable) {
                                LogUtils.d(TAG, "短连接回ack begin");
                                TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.request.IMFetchMsgRequest.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IMAckRequest iMAckRequest = new IMAckRequest(IMFetchMsgRequest.this.mContext, IMFetchMsgRequest.this.mKey, IMFetchMsgRequest.this.mUk, IMFetchMsgRequest.this.mContacter, IMFetchMsgRequest.this.mCategory, IMFetchMsgRequest.this.mCount, IMFetchMsgRequest.this.mBeginid, IMFetchMsgRequest.this.mEndid, IMFetchMsgRequest.this.mIsReliable, arrayList);
                                        HttpHelper.executor(IMFetchMsgRequest.this.mContext, iMAckRequest, iMAckRequest);
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
        LogUtils.d(TAG, "requestid : " + str2 + " , resultCode: " + i4 + " , resultMsg : " + str);
        if (this.mIsReliable && arrayList != null && arrayList.size() > 0) {
            LogUtils.d(TAG, "短连接回ack begin");
            TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.request.IMFetchMsgRequest.1
                @Override // java.lang.Runnable
                public void run() {
                    IMAckRequest iMAckRequest = new IMAckRequest(IMFetchMsgRequest.this.mContext, IMFetchMsgRequest.this.mKey, IMFetchMsgRequest.this.mUk, IMFetchMsgRequest.this.mContacter, IMFetchMsgRequest.this.mCategory, IMFetchMsgRequest.this.mCount, IMFetchMsgRequest.this.mBeginid, IMFetchMsgRequest.this.mEndid, IMFetchMsgRequest.this.mIsReliable, arrayList);
                    HttpHelper.executor(IMFetchMsgRequest.this.mContext, iMAckRequest, iMAckRequest);
                }
            });
        }
        removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (!(removeListener instanceof IFetchMsgByIdExtendListener)) {
            ((IFetchMsgByIdExtendListener) removeListener).onFetchMsgByIdResult(i4, str, "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, i3, ((Long) type.t).longValue(), arrayList, z2);
            LogUtils.d(TAG, "IFetchMsgByIdExtendListener.onFetchMsgByIdResult");
        } else if (removeListener instanceof IFetchMsgByIdListener) {
            ((IFetchMsgByIdListener) removeListener).onFetchMsgByIdResult(i4, str, "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, i3, ((Long) type.t).longValue(), arrayList);
            LogUtils.d(TAG, "IFetchMsgByIdListener.onFetchMsgByIdResult");
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
