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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes3.dex */
public class IMFetchMsgRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMFetchMsgRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public Long mAppid;
    public long mBeginid;
    public int mCategory;
    public long mContacter;
    public int mCount;
    public long mEndid;
    public boolean mIsReliable;
    public String mKey;
    public long mUk;

    public IMFetchMsgRequest(Context context, String str, long j2, long j3, long j4, int i2, int i3, long j5, long j6, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {context, str, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j5), Long.valueOf(j6), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mAppid = Long.valueOf(j2);
        this.mUk = j3;
        this.mContacter = j4;
        this.mCategory = i2;
        this.mCount = i3;
        this.mBeginid = j5;
        this.mEndid = j6;
        this.mKey = str;
        this.mIsReliable = z;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
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
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        JSONObject json;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
            LogUtils.d(TAG, "  errorCode: " + transErrorCode.first);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011d  */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, java.lang.Long] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i2, byte[] bArr) {
        boolean z;
        int i3;
        ArrayList<ChatMsg> arrayList;
        String str;
        boolean z2;
        int i4;
        IMListener removeListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, bArr) == null) {
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
                                    TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable(this, arrayList) { // from class: com.baidu.android.imsdk.chatmessage.request.IMFetchMsgRequest.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ IMFetchMsgRequest this$0;
                                        public final /* synthetic */ ArrayList val$finalMsgs;

                                        {
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, arrayList};
                                                interceptable2.invokeUnInit(65536, newInitContext);
                                                int i7 = newInitContext.flag;
                                                if ((i7 & 1) != 0) {
                                                    int i8 = i7 & 2;
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
                TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable(this, arrayList) { // from class: com.baidu.android.imsdk.chatmessage.request.IMFetchMsgRequest.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ IMFetchMsgRequest this$0;
                    public final /* synthetic */ ArrayList val$finalMsgs;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = objArr;
                            Object[] objArr = {this, arrayList};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i7 = newInitContext.flag;
                            if ((i7 & 1) != 0) {
                                int i8 = i7 & 2;
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
                ((IFetchMsgByIdExtendListener) removeListener).onFetchMsgByIdResult(i4, str, "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, i3, ((Long) type.t).longValue(), arrayList, z2);
                LogUtils.d(TAG, "IFetchMsgByIdExtendListener.onFetchMsgByIdResult");
            } else if (removeListener instanceof IFetchMsgByIdListener) {
                ((IFetchMsgByIdListener) removeListener).onFetchMsgByIdResult(i4, str, "0", this.mCategory, this.mContacter, this.mBeginid, this.mEndid, this.mCount, i3, ((Long) type.t).longValue(), arrayList);
                LogUtils.d(TAG, "IFetchMsgByIdListener.onFetchMsgByIdResult");
            }
        }
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
}
