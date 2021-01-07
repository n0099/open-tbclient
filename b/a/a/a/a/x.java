package b.a.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.Locale;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public final class x implements Runnable {
    private static final Pattern Bb;
    private static final Pattern Bc;
    private static final Pattern Bd;
    private final w AA;

    /* renamed from: a  reason: collision with root package name */
    public String f1083a;

    /* renamed from: b  reason: collision with root package name */
    public int f1084b;
    public String c;
    public String d;
    public long e;
    private String f;
    private String h;
    private String i;
    private String j;
    private int k = 0;
    private int l;
    private int m;

    static {
        Pattern compile = Pattern.compile("[0-9a-zA-Z+-]*");
        Bb = compile;
        Bc = compile;
        Bd = Pattern.compile("[a-zA-Z0-9]{12}");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.AA = wVar;
    }

    private static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() != 2) {
                    hexString = "0".concat(String.valueOf(hexString));
                }
                sb.append(hexString).append("");
            }
            return sb.toString();
        } catch (Exception e) {
            return str;
        }
    }

    private static String a(String str, Pattern pattern) {
        return (str != null && pattern.matcher(str).matches()) ? str : "";
    }

    public static String b() {
        return "lite.1.1.1";
    }

    public static String c() {
        return "200214";
    }

    public static String d() {
        return "sdk_lite";
    }

    public static String g() {
        return "0123456789ABCDEF";
    }

    private String j() {
        byte[] hardwareAddress;
        String str = "";
        try {
            SharedPreferences sharedPreferences = this.AA.Ba;
            String string = sharedPreferences == null ? "" : sharedPreferences.getString("mac_addr", "");
            try {
                if (TextUtils.isEmpty(string)) {
                    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                    str = string;
                    while (networkInterfaces.hasMoreElements()) {
                        NetworkInterface nextElement = networkInterfaces.nextElement();
                        if (nextElement != null && nextElement.getName().equalsIgnoreCase("wlan0") && (hardwareAddress = nextElement.getHardwareAddress()) != null && hardwareAddress.length != 0) {
                            StringBuilder sb = new StringBuilder();
                            int length = hardwareAddress.length;
                            for (int i = 0; i < length; i++) {
                                sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                            }
                            if (sb.length() > 0) {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            String sb2 = sb.toString();
                            if (sharedPreferences != null) {
                                try {
                                    sharedPreferences.edit().putString("mac_addr", sb2).apply();
                                    str = sb2;
                                } catch (Throwable th) {
                                    return sb2;
                                }
                            } else {
                                str = sb2;
                            }
                        }
                    }
                    return str;
                }
                return string;
            } catch (Throwable th2) {
                return string;
            }
        } catch (Throwable th3) {
            return str;
        }
    }

    public final void a() {
        new Thread(this).start();
    }

    public final String e() {
        return (TextUtils.isEmpty(this.h) || this.h.contains("0000")) ? "0123456789ABCDEF" : this.h;
    }

    public final String f() {
        return TextUtils.isEmpty(this.i) ? "0123456789ABCDEF" : this.i;
    }

    public final String h() {
        return TextUtils.isEmpty(this.j) ? "0123456789ABCDEF" : this.j;
    }

    public final String i() {
        if (this.f == null) {
            StringBuilder sb = new StringBuilder(100);
            sb.append(f()).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(h()).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(e()).append("_QQGeoLocation");
            this.f = a(sb.toString());
        }
        return this.f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Context context = this.AA.f1082a;
            this.d = context.getPackageName();
            try {
                PackageInfo packageInfo = this.AA.d.getPackageInfo(this.d, 0);
                if (packageInfo != null) {
                    this.f1084b = packageInfo.versionCode;
                    this.f1083a = packageInfo.versionName;
                }
            } catch (Throwable th) {
            }
            CharSequence loadLabel = context.getApplicationInfo().loadLabel(this.AA.d);
            this.c = loadLabel != null ? loadLabel.toString() : "unknown";
            this.c = this.c.replaceAll("[|_]", "");
            if (this.AA.a()) {
                TelephonyManager telephonyManager = this.AA.e;
                int[] iArr = new int[2];
                c.a(telephonyManager, iArr);
                this.l = iArr[0];
                this.m = iArr[1];
                this.k = telephonyManager.getPhoneType();
                try {
                    this.i = a(telephonyManager.getDeviceId(), Bb).toUpperCase(Locale.ENGLISH);
                    this.j = a(telephonyManager.getSubscriberId(), Bc);
                } catch (Throwable th2) {
                }
            }
            this.h = a(j().replaceAll(":", "").toUpperCase(Locale.ENGLISH), Bd);
            new StringBuilder("os:[").append(Build.MODEL).append(",").append(Build.VERSION.RELEASE).append(",").append(f()).append("],net:[").append(this.l).append(",").append(this.m).append(",").append(this.AA.d()).append("],app:[").append(this.c).append(",").append(this.f1084b).append(",").append(this.f1083a).append("],sdk:[lite.1.1.1,200214]");
            al.a(this.AA.f1082a, "lite.1.1.1-200214");
        } catch (Throwable th3) {
        }
    }
}
