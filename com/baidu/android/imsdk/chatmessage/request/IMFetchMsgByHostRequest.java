package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdExtendListener;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMFetchMsgByHostRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public long mBeginid;
    public int mCategory;
    public long mContacter;
    public int mCount;
    public long mEndid;
    public boolean mIsReliable;
    public String mKey;
    public long mUk;

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public IMFetchMsgByHostRequest(Context context, String str, long j, long j2, int i, int i2, long j3, long j4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {context, str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Cookie", "BDUSS=");
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
            String str = "https://pim.baidu.com/";
            if (readIntData != 0) {
                if (readIntData != 1) {
                    if (readIntData != 2) {
                        if (readIntData == 3) {
                            str = Constants.URL_HTTP_BOX;
                        }
                    } else {
                        str = Constants.URL_HTTP_QA;
                    }
                } else {
                    str = "http://rd-im-server.bcc-szth.baidu.com:8111/";
                }
            }
            return str + "imsapi/1.0/fetchmsg/liveshowhost";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        JSONObject json;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, bArr, th) == null) {
            Pair transErrorCode = transErrorCode(i, bArr, th);
            LogUtils.d(TAG, "onFailure errorCode: " + transErrorCode.first);
            IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
            if (removeListener instanceof IFetchMsgByIdExtendListener) {
                ((IFetchMsgByIdExtendListener) removeListener).onFetchMsgByIdResult(i, "", "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, 0, 0L, null, false);
                LogUtils.d(TAG, "onFailure, IFetchMsgByIdExtendListener.onFetchMsgByIdResult");
            } else if (removeListener instanceof IFetchMsgByIdListener) {
                ((IFetchMsgByIdListener) removeListener).onFetchMsgByIdResult(i, "", "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, 0, 0L, null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0118  */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i, byte[] bArr) {
        boolean z;
        int i2;
        ArrayList arrayList;
        String str;
        boolean z2;
        int i3;
        IMListener removeListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, bArr) == null) {
            String str2 = "";
            String str3 = new String(bArr);
            LogUtils.d(TAG, "onSuccess :" + str3);
            Type type = new Type();
            type.t = 0L;
            int i4 = 0;
            ArrayList arrayList2 = null;
            try {
                JSONObject jSONObject = new JSONObject(str3);
                int i5 = jSONObject.getInt(PmsConstant.Statistic.STATISTIC_ERRCODE);
                String optString = jSONObject.optString(PmsConstant.Statistic.STATISTIC_ERRMSG, "");
                str2 = jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, "0");
                z = jSONObject.optBoolean("has_more", false);
                if (i5 == 0) {
                    try {
                        if (jSONObject.has(NotificationCompat.CarExtender.KEY_MESSAGES)) {
                            JSONArray jSONArray = jSONObject.getJSONArray(NotificationCompat.CarExtender.KEY_MESSAGES);
                            int length = jSONArray.length();
                            try {
                                arrayList2 = MessageParser.parserMessage(this.mContext, jSONArray, type, true, false);
                                i4 = length;
                            } catch (Exception e) {
                                e = e;
                                i4 = length;
                                LogUtils.e(TAG, "JSONException", e);
                                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                i2 = i4;
                                arrayList = null;
                                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                                z2 = z;
                                i3 = 1010;
                                LogUtils.d(TAG, "onSuccess requestid : " + str2 + " , resultCode: " + i3 + " , resultMsg : " + str);
                                if (this.mIsReliable) {
                                    LogUtils.d(TAG, "短连接回ack begin");
                                    TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable(this, arrayList) { // from class: com.baidu.android.imsdk.chatmessage.request.IMFetchMsgByHostRequest.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ IMFetchMsgByHostRequest this$0;
                                        public final /* synthetic */ ArrayList val$finalMsgs;

                                        {
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, arrayList};
                                                interceptable2.invokeUnInit(65536, newInitContext);
                                                int i6 = newInitContext.flag;
                                                if ((i6 & 1) != 0) {
                                                    int i7 = i6 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable2.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$0 = this;
                                            this.val$finalMsgs = arrayList;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                                IMAckRequest iMAckRequest = new IMAckRequest(this.this$0.mContext, this.this$0.mKey, this.this$0.mUk, this.this$0.mContacter, this.this$0.mCategory, this.this$0.mCount, this.this$0.mBeginid, this.this$0.mEndid, this.this$0.mIsReliable, this.val$finalMsgs);
                                                HttpHelper.executor(this.this$0.mContext, iMAckRequest, iMAckRequest);
                                            }
                                        }
                                    });
                                }
                                removeListener = ListenerManager.getInstance().removeListener(this.mKey);
                                if (!(removeListener instanceof IFetchMsgByIdExtendListener)) {
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                i2 = i4;
                arrayList = arrayList2;
                str = optString;
                z2 = z;
                i3 = i5;
            } catch (Exception e3) {
                e = e3;
                z = false;
            }
            LogUtils.d(TAG, "onSuccess requestid : " + str2 + " , resultCode: " + i3 + " , resultMsg : " + str);
            if (this.mIsReliable && arrayList != null && arrayList.size() > 0) {
                LogUtils.d(TAG, "短连接回ack begin");
                TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable(this, arrayList) { // from class: com.baidu.android.imsdk.chatmessage.request.IMFetchMsgByHostRequest.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ IMFetchMsgByHostRequest this$0;
                    public final /* synthetic */ ArrayList val$finalMsgs;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = objArr;
                            Object[] objArr = {this, arrayList};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i6 = newInitContext.flag;
                            if ((i6 & 1) != 0) {
                                int i7 = i6 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$finalMsgs = arrayList;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            IMAckRequest iMAckRequest = new IMAckRequest(this.this$0.mContext, this.this$0.mKey, this.this$0.mUk, this.this$0.mContacter, this.this$0.mCategory, this.this$0.mCount, this.this$0.mBeginid, this.this$0.mEndid, this.this$0.mIsReliable, this.val$finalMsgs);
                            HttpHelper.executor(this.this$0.mContext, iMAckRequest, iMAckRequest);
                        }
                    }
                });
            }
            removeListener = ListenerManager.getInstance().removeListener(this.mKey);
            if (!(removeListener instanceof IFetchMsgByIdExtendListener)) {
                ((IFetchMsgByIdExtendListener) removeListener).onFetchMsgByIdResult(i3, str, "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, i2, ((Long) type.t).longValue(), arrayList, z2);
                LogUtils.d(TAG, "onSuccess, IFetchMsgByIdExtendListener.onFetchMsgByIdResult");
            } else if (removeListener instanceof IFetchMsgByIdListener) {
                ((IFetchMsgByIdListener) removeListener).onFetchMsgByIdResult(i3, str, "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, i2, ((Long) type.t).longValue(), arrayList);
            }
        }
    }
}
