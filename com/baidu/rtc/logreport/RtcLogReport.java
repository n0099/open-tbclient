package com.baidu.rtc.logreport;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes7.dex */
public class RtcLogReport {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_HOST = "https://rtc-log.cdn.bcebos.com/collect?message=";
    public static final String LOG = "RTCLOGREPORT";
    public static final int RTC_REPORTING_LOG_TYPE_DEVICE_INFO = 0;
    public static final int RTC_REPORTING_LOG_TYPE_ERROR_INFO = 4;
    public static final int RTC_REPORTING_LOG_TYPE_QUALITY_INFO = 2;
    public static final int RTC_REPORTING_LOG_TYPE_ROOM_EVENTS = 1;
    public static final int RTC_REPORTING_LOG_TYPE_SLI_INFO = 3;
    public static final String UPLOAD_ERROR_PERFFIX = "[RTC_LOG]";
    public static final String UPLOAD_PERFFIX = "[RTC_QUALITY_CONTROL]";
    public static final String UPLOAD_SLI_PERFFIX = "[RTC_SLI]";
    public static RtcLogReport instance;
    public transient /* synthetic */ FieldHolder $fh;
    public ScheduledExecutorService executor;
    public OkHttpClient mOkHttpClient;

    public RtcLogReport() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOkHttpClient = new OkHttpClient().newBuilder().connectTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).build();
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    public static String getDeviceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Build.MODEL : (String) invokeV.objValue;
    }

    public static synchronized RtcLogReport getInstance() {
        InterceptResult invokeV;
        RtcLogReport rtcLogReport;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (RtcLogReport.class) {
                if (instance == null) {
                    instance = new RtcLogReport();
                }
                rtcLogReport = instance;
            }
            return rtcLogReport;
        }
        return (RtcLogReport) invokeV.objValue;
    }

    public static String getNetworkType(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
                return StringUtil.NULL_STRING;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || (state = networkInfo.getState()) == null || !(state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return "2G";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return "3G";
                    case 13:
                        return "4G";
                    default:
                        return "MOBILE";
                }
            }
            return "wifi";
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGet(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, this, str, i2) == null) {
            String str2 = i2 == 3 ? UPLOAD_SLI_PERFFIX : UPLOAD_PERFFIX;
            if (i2 == 4) {
                str2 = UPLOAD_ERROR_PERFFIX;
            }
            String encodeToString = Base64.encodeToString((str2 + str).getBytes(), 2);
            Request.Builder builder = new Request.Builder();
            this.mOkHttpClient.newCall(builder.url(DEFAULT_HOST + encodeToString).build()).enqueue(new Callback(this) { // from class: com.baidu.rtc.logreport.RtcLogReport.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RtcLogReport this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, call, iOException) == null) {
                        String str3 = "qualityinfo send fail: " + iOException;
                    }
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                    }
                }
            });
        }
    }

    public void release() {
        ScheduledExecutorService scheduledExecutorService;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (scheduledExecutorService = this.executor) == null) {
            return;
        }
        scheduledExecutorService.shutdown();
        this.executor = null;
    }

    public synchronized void report(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
            synchronized (this) {
                this.executor.execute(new Runnable(this, str, i2) { // from class: com.baidu.rtc.logreport.RtcLogReport.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ RtcLogReport this$0;
                    public final /* synthetic */ int val$infoType;
                    public final /* synthetic */ String val$log;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$log = str;
                        this.val$infoType = i2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.sendGet(this.val$log, this.val$infoType);
                        }
                    }
                });
            }
        }
    }
}
