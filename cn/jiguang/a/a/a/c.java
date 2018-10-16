package cn.jiguang.a.a.a;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public final class c {
    private static AtomicInteger a = new AtomicInteger(2);

    /* JADX INFO: Access modifiers changed from: private */
    public static Process B(String str) {
        Process process = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                process = Runtime.getRuntime().exec(str);
                try {
                    process.waitFor();
                } catch (InterruptedException e) {
                }
            } catch (IOException e2) {
            }
        }
        return process;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String a(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i & 255);
        stringBuffer.append('.');
        stringBuffer.append((i >> 8) & 255);
        stringBuffer.append('.');
        stringBuffer.append((i >> 16) & 255);
        stringBuffer.append('.');
        stringBuffer.append((i >> 24) & 255);
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bArr[0] & 255);
        stringBuffer.append('.');
        stringBuffer.append(bArr[1] & 255);
        stringBuffer.append('.');
        stringBuffer.append(bArr[2] & 255);
        stringBuffer.append('.');
        stringBuffer.append(bArr[3] & 255);
        return stringBuffer.toString();
    }

    public static void a(Context context) {
        if (a.get() != 2) {
            return;
        }
        c(1);
        if (context == null) {
            c(2);
        } else if (!cn.jiguang.g.a.e(context).toUpperCase().startsWith("WIFI")) {
            c(2);
        } else if (!((Boolean) cn.jiguang.d.a.d.b(context, "arpinfo_report_enable", false)).booleanValue()) {
            c(2);
        } else if (!cn.jiguang.d.a.d.d(context)) {
            c(2);
        } else {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager == null) {
                c(2);
            } else if (!cn.jiguang.g.a.a(context, "android.permission.ACCESS_WIFI_STATE")) {
                c(2);
            } else {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                String str = "";
                String str2 = "";
                if (connectionInfo != null) {
                    str2 = cn.jiguang.g.i.c(connectionInfo.getSSID());
                    str = connectionInfo.getBSSID();
                }
                String str3 = TextUtils.isEmpty(str) ? "" : str;
                String str4 = TextUtils.isEmpty(str2) ? "" : str2;
                String str5 = TextUtils.isEmpty(str3) ? str4 : str3;
                boolean b = a.bm().b(context, str5);
                a.bm();
                a.a(context);
                if (b) {
                    new h(wifiManager, str5, str3, str4, context, 300, 2, (byte) 0).start();
                } else {
                    c(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ byte[] a(long j) {
        return new byte[]{(byte) (255 & j), (byte) ((j >> 8) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 24) & 255)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(int i) {
        a.getAndSet(i);
    }
}
