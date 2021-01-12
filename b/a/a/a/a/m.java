package b.a.a.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.LocationManager;
import android.net.http.Headers;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import java.util.List;
/* loaded from: classes3.dex */
public final class m {
    private static m At = null;

    /* renamed from: b  reason: collision with root package name */
    private int f1066b = -1;
    private int c = -1;
    private int d = 1;

    /* JADX WARN: Can't wrap try/catch for region: R(14:5|(2:6|7)|(6:9|(1:11)(1:69)|12|13|(2:15|(11:17|18|19|(5:50|51|52|53|(1:55)(2:56|57))(1:21)|(1:23)(1:49)|(1:25)|(1:27)|(1:29)|(1:31)|(1:33)|34))|65)(1:71)|66|18|19|(0)(0)|(0)(0)|(0)|(0)|(0)|(0)|(0)|34) */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008e, code lost:
        r0 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0058 A[Catch: Exception -> 0x009f, TryCatch #0 {Exception -> 0x009f, blocks: (B:20:0x0045, B:26:0x0058, B:28:0x005c, B:30:0x0060, B:32:0x0064, B:34:0x0068, B:35:0x006a, B:37:0x006e, B:45:0x0080), top: B:61:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005c A[Catch: Exception -> 0x009f, TryCatch #0 {Exception -> 0x009f, blocks: (B:20:0x0045, B:26:0x0058, B:28:0x005c, B:30:0x0060, B:32:0x0064, B:34:0x0068, B:35:0x006a, B:37:0x006e, B:45:0x0080), top: B:61:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0060 A[Catch: Exception -> 0x009f, TryCatch #0 {Exception -> 0x009f, blocks: (B:20:0x0045, B:26:0x0058, B:28:0x005c, B:30:0x0060, B:32:0x0064, B:34:0x0068, B:35:0x006a, B:37:0x006e, B:45:0x0080), top: B:61:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064 A[Catch: Exception -> 0x009f, TryCatch #0 {Exception -> 0x009f, blocks: (B:20:0x0045, B:26:0x0058, B:28:0x005c, B:30:0x0060, B:32:0x0064, B:34:0x0068, B:35:0x006a, B:37:0x006e, B:45:0x0080), top: B:61:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068 A[Catch: Exception -> 0x009f, TryCatch #0 {Exception -> 0x009f, blocks: (B:20:0x0045, B:26:0x0058, B:28:0x005c, B:30:0x0060, B:32:0x0064, B:34:0x0068, B:35:0x006a, B:37:0x006e, B:45:0x0080), top: B:61:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e A[Catch: Exception -> 0x009f, TryCatch #0 {Exception -> 0x009f, blocks: (B:20:0x0045, B:26:0x0058, B:28:0x005c, B:30:0x0060, B:32:0x0064, B:34:0x0068, B:35:0x006a, B:37:0x006e, B:45:0x0080), top: B:61:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x008f -> B:23:0x0053). Please submit an issue!!! */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        LocationManager locationManager;
        WifiManager wifiManager;
        boolean z7;
        if (context == null) {
            return -1;
        }
        boolean b2 = b(context);
        try {
            wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        } catch (Throwable th) {
            z = false;
        }
        if (wifiManager != null) {
            z = wifiManager.isWifiEnabled();
            try {
            } catch (Throwable th2) {
                z2 = z;
                z3 = false;
                z4 = false;
                locationManager = (LocationManager) context.getSystemService(Headers.LOCATION);
                if (locationManager != null) {
                }
                if (!b2) {
                }
                if (!z2) {
                }
                if (!z5) {
                }
                if (!z4) {
                }
                if (!z6) {
                }
                if (!z3) {
                }
                switch (i) {
                }
            }
            if (Build.VERSION.SDK_INT >= 18) {
                if (wifiManager.isScanAlwaysAvailable()) {
                    z2 = z;
                    z3 = true;
                    z4 = true;
                    locationManager = (LocationManager) context.getSystemService(Headers.LOCATION);
                    if (locationManager != null) {
                        try {
                            i = Settings.Secure.getInt(context.getContentResolver(), "location_mode");
                        } catch (Throwable th3) {
                            i = 0;
                        }
                        try {
                            z5 = locationManager.isProviderEnabled("gps");
                            List<String> allProviders = locationManager.getAllProviders();
                            z6 = allProviders == null ? false : allProviders.contains("gps");
                        } catch (Exception e) {
                            int i2 = i;
                            z5 = false;
                            z6 = false;
                            i = i2;
                            if (!b2) {
                            }
                            if (!z2) {
                            }
                            if (!z5) {
                            }
                            if (!z4) {
                            }
                            if (!z6) {
                            }
                            if (!z3) {
                            }
                            switch (i) {
                            }
                        }
                    } else {
                        z5 = false;
                        z6 = false;
                        i = 0;
                    }
                    int i3 = !b2 ? 1 : 0;
                    if (!z2) {
                        i3 += 2;
                    }
                    if (!z5) {
                        i3 += 4;
                    }
                    if (!z4) {
                        i3 += 8;
                    }
                    if (!z6) {
                        i3 += 16;
                    }
                    if (!z3) {
                        i3 += 32;
                    }
                    switch (i) {
                        case 0:
                            return i3 + 64;
                        case 1:
                            return i3 + 128;
                        case 2:
                            return i3 + 256;
                        case 3:
                            return i3 + 512;
                        default:
                            return i3;
                    }
                }
            }
            z7 = true;
        } else {
            z7 = false;
            z = false;
        }
        z2 = z;
        z3 = false;
        z4 = z7;
        locationManager = (LocationManager) context.getSystemService(Headers.LOCATION);
        if (locationManager != null) {
        }
        if (!b2) {
        }
        if (!z2) {
        }
        if (!z5) {
        }
        if (!z4) {
        }
        if (!z6) {
        }
        if (!z3) {
        }
        switch (i) {
        }
    }

    private static boolean b(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return false;
            }
            return telephonyManager.getSimState() == 5;
        } catch (Exception e) {
            return false;
        }
    }

    public static m hK() {
        if (At == null) {
            At = new m();
        }
        return At;
    }
}
