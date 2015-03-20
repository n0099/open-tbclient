package com.baidu.location;

import android.location.Location;
import android.os.Environment;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.location.au;
import com.baidu.location.u;
import java.io.File;
import java.util.Calendar;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a0, n {
    public static final boolean aE = true;
    public static boolean aL = false;
    public static boolean a5 = false;
    public static boolean an = false;
    public static int aq = 0;
    private static String af = "http://loc.map.baidu.com/sdk.php";
    public static String aU = "http://loc.map.baidu.com/sdk_ep.php";
    private static String aw = "http://loc.map.baidu.com/user_err.php";
    private static String al = "http://loc.map.baidu.com/oqur.php";
    private static String av = "http://loc.map.baidu.com/tcu.php";
    private static String ao = "https://api.skyhookwireless.com/wps2/location";
    private static boolean aI = false;
    private static boolean as = false;
    private static String ag = "[baidu_location_service]";
    private static Process be = null;
    public static String aF = "no";
    public static String bc = BDGeofence.COORD_TYPE_GCJ;
    public static boolean aK = true;
    public static int at = 3;
    public static double aO = 0.0d;
    public static double a3 = 0.0d;
    public static double Y = 0.0d;
    public static double au = 0.0d;
    public static int aN = 0;
    public static byte[] ar = null;
    public static boolean bb = false;
    public static int ap = 0;
    public static float bg = 1.1f;
    public static float am = 2.2f;
    public static float aJ = 2.3f;
    public static float aY = 3.8f;
    public static int ax = 3;
    public static int aP = 10;
    public static int a1 = 2;
    public static int ab = 7;
    public static int Z = 20;
    public static int a7 = 70;
    public static int ai = 120;
    public static float aH = 2.0f;
    public static float aG = 10.0f;
    public static float bd = 50.0f;
    public static float aW = 200.0f;
    public static int a2 = 16;
    public static float ad = 0.9f;
    public static int aX = 10000;
    public static float X = 0.5f;
    public static float aB = 0.0f;
    public static float aA = 0.1f;
    public static int az = 30;
    public static int ay = 100;
    public static int aV = 420000;
    public static boolean aj = true;
    public static boolean ac = true;
    public static int aZ = 20;
    public static int a4 = 300;
    public static int aQ = 1000;
    public static long aR = 900000;
    public static long a8 = 420000;
    public static long aT = 180000;
    public static long aS = 180000;
    public static long a6 = 15;
    public static long bf = 300000;
    public static int ak = 100;
    public static int ba = 0;
    public static int aa = 30000;
    public static int ae = 30000;
    public static float aM = 10.0f;
    public static float aD = 6.0f;
    public static float a0 = 10.0f;
    public static int aC = 60;
    public static int a9 = 70;
    public static int ah = 6;

    c() {
    }

    /* renamed from: byte  reason: not valid java name */
    public static String m256byte() {
        return aw;
    }

    /* renamed from: case  reason: not valid java name */
    public static String m257case() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                String path = Environment.getExternalStorageDirectory().getPath();
                File file = new File(path + "/baidu/tempdata");
                if (file.exists()) {
                    return path;
                }
                file.mkdirs();
                return path;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: char  reason: not valid java name */
    public static void m258char() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: do  reason: not valid java name */
    public static int m259do(String str, String str2, String str3) {
        int indexOf;
        int length;
        int indexOf2;
        String substring;
        if (str == null || str.equals("") || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, (length = indexOf + str2.length()))) == -1 || (substring = str.substring(length, indexOf2)) == null || substring.equals("")) {
            return ExploreByTouchHelper.INVALID_ID;
        }
        try {
            return Integer.parseInt(substring);
        } catch (NumberFormatException e) {
            return ExploreByTouchHelper.INVALID_ID;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static String m260do() {
        return al;
    }

    /* renamed from: do  reason: not valid java name */
    public static void m261do(String str) {
        if (str != null) {
            af = str;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static void m262do(String str, String str2) {
    }

    /* renamed from: else  reason: not valid java name */
    public static void m263else() {
        try {
            if (be != null) {
                be.destroy();
                be = null;
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: for  reason: not valid java name */
    static double m264for(String str, String str2, String str3) {
        int indexOf;
        int length;
        int indexOf2;
        String substring;
        if (str == null || str.equals("") || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, (length = indexOf + str2.length()))) == -1 || (substring = str.substring(length, indexOf2)) == null || substring.equals("")) {
            return Double.MIN_VALUE;
        }
        try {
            return Double.parseDouble(substring);
        } catch (NumberFormatException e) {
            return Double.MIN_VALUE;
        }
    }

    /* renamed from: for  reason: not valid java name */
    public static String m265for() {
        return af;
    }

    /* renamed from: goto  reason: not valid java name */
    public static String m266goto() {
        String m257case = m257case();
        if (m257case == null) {
            return null;
        }
        return m257case + "/baidu/tempdata";
    }

    /* renamed from: if  reason: not valid java name */
    static float m267if(String str, String str2, String str3) {
        int indexOf;
        int length;
        int indexOf2;
        String substring;
        if (str == null || str.equals("") || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, (length = indexOf + str2.length()))) == -1 || (substring = str.substring(length, indexOf2)) == null || substring.equals("")) {
            return Float.MIN_VALUE;
        }
        try {
            return Float.parseFloat(substring);
        } catch (NumberFormatException e) {
            return Float.MIN_VALUE;
        }
    }

    /* renamed from: if  reason: not valid java name */
    static String m268if() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(5);
        return String.format(Locale.CHINA, "%d_%d_%d_%d_%d_%d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(i), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
    }

    /* renamed from: if  reason: not valid java name */
    public static String m269if(u.a aVar, au.b bVar, Location location, String str) {
        String m355for;
        String str2;
        String aVar2;
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar != null && (aVar2 = aVar.toString()) != null) {
            stringBuffer.append(aVar2);
        }
        if (bVar != null) {
            try {
                str2 = bVar.m222if(5);
            } catch (Exception e) {
                str2 = null;
            }
            if (str2 != null) {
                stringBuffer.append(str2);
            }
        }
        if (location != null) {
            String m404new = aq != 0 ? z.m404new(location) : z.m368byte(location);
            if (m404new != null) {
                stringBuffer.append(m404new);
            }
        }
        String m78char = a2.cC().m78char(false);
        if (m78char != null) {
            stringBuffer.append(m78char);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        if (aVar != null && (m355for = aVar.m355for()) != null && m355for.length() + stringBuffer.length() < 750) {
            stringBuffer.append(m355for);
        }
        return stringBuffer.toString();
    }

    /* renamed from: if  reason: not valid java name */
    public static String m270if(u.a aVar, au.b bVar, Location location, String str, int i) {
        String m355for;
        String aVar2;
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar != null && (aVar2 = aVar.toString()) != null) {
            stringBuffer.append(aVar2);
        }
        if (bVar != null) {
            String m216char = i == 0 ? bVar.m216char() : bVar.m214byte();
            if (m216char != null) {
                stringBuffer.append(m216char);
            }
        }
        if (location != null) {
            String m368byte = (aq == 0 || i == 0) ? z.m368byte(location) : z.m404new(location);
            if (m368byte != null) {
                stringBuffer.append(m368byte);
            }
        }
        String m78char = a2.cC().m78char(i == 0);
        if (m78char != null) {
            stringBuffer.append(m78char);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        String a = az.m252do().a();
        if (!TextUtils.isEmpty(a)) {
            stringBuffer.append("&bc=").append(a);
        }
        if (aVar != null && (m355for = aVar.m355for()) != null && m355for.length() + stringBuffer.length() < 750) {
            stringBuffer.append(m355for);
        }
        String stringBuffer2 = stringBuffer.toString();
        try {
            if (location == null || bVar == null) {
                at = 3;
            } else {
                float speed = location.getSpeed();
                int i2 = aq;
                int m217do = bVar.m217do();
                int m227try = bVar.m227try();
                boolean m215case = bVar.m215case();
                if (speed < aD && ((i2 == 1 || i2 == 0) && (m217do < aC || m215case))) {
                    at = 1;
                } else if (speed >= a0 || (!(i2 == 1 || i2 == 0 || i2 == 3) || (m217do >= a9 && m227try <= ah))) {
                    at = 3;
                } else {
                    at = 2;
                }
            }
        } catch (Exception e) {
            at = 3;
        }
        return stringBuffer2;
    }

    /* renamed from: if  reason: not valid java name */
    static String m271if(String str, String str2, String str3, double d) {
        int indexOf;
        int length;
        int indexOf2;
        if (str == null || str.equals("") || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, (length = indexOf + str2.length()))) == -1) {
            return null;
        }
        return str.substring(0, length) + String.format(Locale.CHINA, "%.7f", Double.valueOf(d)) + str.substring(indexOf2);
    }

    /* renamed from: if  reason: not valid java name */
    public static void m272if(String str) {
        if (as) {
            Log.d(ag, str);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static void m273if(String str, String str2) {
        if (aI) {
            Log.d(str, str2);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static boolean m274if(BDLocation bDLocation) {
        int locType = bDLocation.getLocType();
        return locType > 100 && locType < 200;
    }

    /* renamed from: int  reason: not valid java name */
    public static String m275int() {
        return ao;
    }

    /* renamed from: long  reason: not valid java name */
    public static String m276long() {
        try {
            File file = new File(f.getServiceContext().getFilesDir() + File.separator + "lldt");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: new  reason: not valid java name */
    public static String m277new() {
        return av;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: try  reason: not valid java name */
    public static String m278try() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(5);
        return String.format(Locale.CHINA, "%d-%d-%d %d:%d:%d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(i), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
    }
}
