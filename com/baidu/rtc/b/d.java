package com.baidu.rtc.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes9.dex */
public class d {
    private static d cBj;
    private OkHttpClient mOkHttpClient = new OkHttpClient().newBuilder().connectTimeout(10, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).build();
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(String str, int i) {
        String str2 = i == 3 ? "[RTC_SLI]" : "[RTC_QUALITY_CONTROL]";
        String encodeToString = Base64.encodeToString((str2 + str).getBytes(), 2);
        Request.Builder builder = new Request.Builder();
        this.mOkHttpClient.newCall(builder.url("https://rtc-log.cdn.bcebos.com/collect?message=" + encodeToString).build()).enqueue(new Callback() { // from class: com.baidu.rtc.b.d.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Log.e("RTCLOGREPORT", "qualityinfo send fail: " + iOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
            }
        });
    }

    public static d afv() {
        d dVar;
        synchronized (d.class) {
            try {
                if (cBj == null) {
                    cBj = new d();
                }
                dVar = cBj;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return "null";
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

    public void O(final String str, final int i) {
        synchronized (this) {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.b.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.N(str, i);
                }
            });
        }
    }
}
