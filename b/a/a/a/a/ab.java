package b.a.a.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class ab {

    /* renamed from: a  reason: collision with root package name */
    public static int f1050a = 0;
    public final af Be;
    private final z Bf;
    private final aa Bg;

    public ab(af afVar, z zVar, aa aaVar) {
        this.Be = afVar;
        this.Bf = zVar;
        this.Bg = aaVar;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:66:? */
    /* JADX DEBUG: Multi-variable search result rejected for r6v5, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r6v6, resolved type: boolean */
    /* JADX WARN: Can't wrap try/catch for region: R(17:5|6|7|(6:9|(1:11)(1:69)|12|13|(2:15|(13:17|18|19|(5:50|51|52|53|(1:55)(2:56|57))(1:21)|(1:23)(1:49)|(1:25)(1:48)|(1:27)(1:47)|(1:29)(1:46)|(1:31)(1:45)|(1:33)(1:44)|(1:37)|38|43))|65)(1:71)|66|18|19|(0)(0)|(0)(0)|(0)(0)|(0)(0)|(0)(0)|(0)(0)|(0)(0)|(2:35|37)|38|43) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0099, code lost:
        r0 = 0;
        r6 = r6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x009a -> B:23:0x0050). Please submit an issue!!! */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(Context context) {
        int i;
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        int i3;
        int i4;
        int i5;
        boolean z4;
        LocationManager locationManager;
        WifiManager wifiManager;
        boolean z5;
        int i6 = 1;
        int i7 = 0;
        if (context == null) {
            return -1;
        }
        boolean b2 = b(context);
        try {
            wifiManager = (WifiManager) context.getSystemService("wifi");
        } catch (Throwable th) {
            i = 0;
        }
        if (wifiManager != null) {
            i = wifiManager.isWifiEnabled() ? 1 : 0;
            try {
            } catch (Throwable th2) {
                i2 = i;
                z = false;
                z2 = false;
                locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager != null) {
                }
                if (!z4) {
                }
                if (i2 == 0) {
                }
                if (z3 == 0) {
                }
                if (!z2) {
                }
                if (i3 == 0) {
                }
                if (!z) {
                }
                if (i4 >= 0) {
                }
                i6 = r7 + 0 + (b2 ? 1 : 0) + i2 + r4 + i5;
                return r0 + i6 + i7;
            }
            if (Build.VERSION.SDK_INT >= 18) {
                if (wifiManager.isScanAlwaysAvailable()) {
                    i2 = i;
                    z = true;
                    z2 = true;
                    locationManager = (LocationManager) context.getSystemService("location");
                    if (locationManager != null) {
                        try {
                            i5 = Settings.Secure.getInt(context.getContentResolver(), "location_mode");
                        } catch (Throwable th3) {
                            i5 = 0;
                        }
                        try {
                            boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
                            List<String> allProviders = locationManager.getAllProviders();
                            if (allProviders == null) {
                                i3 = 0;
                                i4 = i5;
                                z3 = isProviderEnabled;
                                z4 = b2;
                            } else {
                                i3 = allProviders.contains("gps") ? 1 : 0;
                                i4 = i5;
                                z3 = isProviderEnabled;
                                z4 = b2;
                            }
                        } catch (Throwable th4) {
                            int i8 = i5;
                            boolean z6 = b2;
                            z3 = i7;
                            i3 = i7;
                            i4 = i8;
                            z4 = z6;
                            if (!z4) {
                            }
                            if (i2 == 0) {
                            }
                            if (z3 == 0) {
                            }
                            if (!z2) {
                            }
                            if (i3 == 0) {
                            }
                            if (!z) {
                            }
                            if (i4 >= 0) {
                            }
                            i6 = r7 + 0 + (b2 ? 1 : 0) + i2 + r4 + i5;
                            return r0 + i6 + i7;
                        }
                    } else {
                        z3 = 0;
                        i3 = 0;
                        i4 = 0;
                        z4 = b2;
                    }
                    int i9 = !z4 ? i6 : i7;
                    b2 = i2 == 0 ? 2 : i7;
                    i2 = z3 == 0 ? 4 : i7;
                    int i10 = !z2 ? 8 : i7;
                    i5 = i3 == 0 ? 16 : i7;
                    int i11 = !z ? 32 : i7;
                    if (i4 >= 0 && i4 <= 3) {
                        i7 = i6 << (i4 + 6);
                    }
                    i6 = i9 + 0 + (b2 ? 1 : 0) + i2 + i10 + i5;
                    return i11 + i6 + i7;
                }
            }
            z5 = true;
        } else {
            z5 = false;
            i = 0;
        }
        i2 = i;
        z = false;
        z2 = z5;
        locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager != null) {
        }
        if (!z4) {
        }
        if (i2 == 0) {
        }
        if (z3 == 0) {
        }
        if (!z2) {
        }
        if (i3 == 0) {
        }
        if (!z) {
        }
        if (i4 >= 0) {
            i7 = i6 << (i4 + 6);
        }
        i6 = i9 + 0 + (b2 ? 1 : 0) + i2 + i10 + i5;
        return i11 + i6 + i7;
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

    public final String a(w wVar, boolean z) {
        String sb;
        aa aaVar;
        String sb2;
        String str;
        JSONObject jSONObject;
        if (wVar == null) {
            return "";
        }
        try {
            boolean z2 = this.Bf == null ? true : f1050a != this.Bf.e;
            f1050a = this.Bf == null ? f1050a : this.Bf.e;
            if (this.Be == null) {
                sb = "[]";
            } else {
                af afVar = this.Be;
                if (afVar.f1053b.size() <= 0) {
                    sb = "[]";
                } else {
                    StringBuilder sb3 = new StringBuilder("[");
                    int i = 0;
                    for (ScanResult scanResult : afVar.f1053b) {
                        if (i > 0) {
                            sb3.append(",");
                        }
                        sb3.append("{\"mac\":\"").append(scanResult.BSSID).append("\",\"rssi\":").append(scanResult.level).append("}");
                        i++;
                    }
                    sb3.append("]");
                    sb = sb3.toString();
                }
            }
            String a2 = this.Bf == null ? "[]" : this.Bf.a(z2);
            if (this.Bg == null) {
                sb2 = "{}";
            } else {
                Location location = this.Bg.f1049b;
                StringBuilder sb4 = new StringBuilder();
                String a3 = aa.a(location.getLatitude(), 6);
                String a4 = aa.a(location.getLongitude(), 6);
                String a5 = aa.a(location.getAltitude(), 1);
                String a6 = aa.a(location.getAccuracy(), 1);
                String a7 = aa.a(location.getBearing(), 1);
                String a8 = aa.a(location.getSpeed(), 1);
                sb4.append("{");
                sb4.append("\"latitude\":");
                sb4.append(a3);
                sb4.append(",\"longitude\":");
                sb4.append(a4);
                sb4.append(",\"additional\":");
                sb4.append("\"" + a5 + "," + a6 + "," + a7 + "," + a8 + "," + aaVar.c + "\"");
                sb4.append("}");
                sb2 = sb4.toString();
            }
            x xVar = wVar.AX;
            HashMap hashMap = new HashMap();
            hashMap.put("imei", xVar.f());
            hashMap.put("imsi", xVar.h());
            hashMap.put("phonenum", "");
            hashMap.put("qq", "");
            hashMap.put("mac", xVar.e().toLowerCase(Locale.ENGLISH));
            String jSONObject2 = new JSONObject(hashMap).toString();
            String i2 = xVar.i();
            int a9 = a(wVar.f1081a);
            String a10 = j.a(wVar.f1081a);
            try {
                if (!sb.equals("[]") || a10.equals("{}")) {
                    str = sb;
                } else {
                    new JSONObject(a10).remove("ssid");
                    str = "[" + jSONObject.toString() + "]";
                }
            } catch (Throwable th) {
                str = sb;
            }
            String str2 = xVar.c;
            if (str2 != null) {
                str2 = str2.replaceAll("[\"|_]", "");
            }
            String str3 = (("{\"version\":\"" + x.b() + "\",\"address\":0") + ",\"source\":203,\"access_token\":\"" + i2 + "\",\"app_name\":\"" + x.d() + "\",\"app_label\":\"" + (str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + xVar.f1082a) + "\",\"bearing\":1") + ",\"control\":0";
            return (((z ? str3 + ",\"detectgps\":1" : str3 + ",\"detectgps\":0") + ",\"pstat\":" + a9) + ",\"wlan\":" + a10) + ",\"attribute\":" + jSONObject2 + ",\"location\":" + sb2 + ",\"cells\":" + a2 + ",\"wifis\":" + str + ",\"bles\":[]}";
        } catch (Throwable th2) {
            return null;
        }
    }

    public final boolean a() {
        return this.Bg != null;
    }
}
