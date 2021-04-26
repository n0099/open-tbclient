package com.baidu.rtc.logreport;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.apollon.statistics.g;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class RtcLogReport {
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
    public OkHttpClient mOkHttpClient = new OkHttpClient().newBuilder().connectTimeout(10, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).build();
    public ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static RtcLogReport getInstance() {
        RtcLogReport rtcLogReport;
        synchronized (RtcLogReport.class) {
            if (instance == null) {
                instance = new RtcLogReport();
            }
            rtcLogReport = instance;
        }
        return rtcLogReport;
    }

    public static String getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
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
                    return g.f3962b;
                case 13:
                    return "4G";
                default:
                    return "MOBILE";
            }
        }
        return "wifi";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGet(String str, int i2) {
        String str2 = i2 == 3 ? UPLOAD_SLI_PERFFIX : UPLOAD_PERFFIX;
        if (i2 == 4) {
            str2 = UPLOAD_ERROR_PERFFIX;
        }
        String encodeToString = Base64.encodeToString((str2 + str).getBytes(), 2);
        Request.Builder builder = new Request.Builder();
        this.mOkHttpClient.newCall(builder.url(DEFAULT_HOST + encodeToString).build()).enqueue(new Callback() { // from class: com.baidu.rtc.logreport.RtcLogReport.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Log.e(RtcLogReport.LOG, "qualityinfo send fail: " + iOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
            }
        });
    }

    public void report(final String str, final int i2) {
        synchronized (this) {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.logreport.RtcLogReport.1
                @Override // java.lang.Runnable
                public void run() {
                    RtcLogReport.this.sendGet(str, i2);
                }
            });
        }
    }
}
