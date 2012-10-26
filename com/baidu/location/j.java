package com.baidu.location;

import android.location.Location;
import android.util.Log;
import com.baidu.location.c;
import com.baidu.location.e;
import com.baidu.tieba.data.Config;
import java.io.File;
import java.util.Calendar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j {

    /* renamed from: do  reason: not valid java name */
    public static boolean f181do = false;
    public static boolean c = false;

    /* renamed from: new  reason: not valid java name */
    public static int f188new = 16;

    /* renamed from: for  reason: not valid java name */
    public static int f183for = Config.MAX_CASH_PB_PHOTO_NUM;

    /* renamed from: case  reason: not valid java name */
    public static float f179case = 200.0f;

    /* renamed from: if  reason: not valid java name */
    public static float f185if = 50.0f;

    /* renamed from: char  reason: not valid java name */
    public static float f180char = 0.9f;

    /* renamed from: void  reason: not valid java name */
    public static boolean f190void = false;

    /* renamed from: try  reason: not valid java name */
    public static boolean f189try = false;
    public static boolean b = false;

    /* renamed from: long  reason: not valid java name */
    public static int f187long = 0;
    private static String a = f.g;

    /* renamed from: int  reason: not valid java name */
    private static String f186int = "http://loc.map.baidu.com/sdk.php";

    /* renamed from: else  reason: not valid java name */
    private static boolean f182else = false;

    /* renamed from: byte  reason: not valid java name */
    private static boolean f178byte = false;

    /* renamed from: goto  reason: not valid java name */
    private static Process f184goto = null;

    j() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(String str, String str2, String str3) {
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
            a(a, "util numberFormatException, intStr : " + substring);
            e.printStackTrace();
            return Float.MIN_VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        Calendar calendar = Calendar.getInstance();
        return String.format("%d-%d-%d %d:%d:%d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
    }

    public static String a(c.a aVar, e.c cVar, Location location, String str, int i) {
        String m92for;
        String aVar2;
        StringBuffer stringBuffer = new StringBuffer();
        if (i != 0) {
            stringBuffer.append("&q=");
            stringBuffer.append(i);
        }
        if (aVar != null && (aVar2 = aVar.toString()) != null) {
            stringBuffer.append(aVar2);
        }
        if (cVar != null) {
            String m115try = i == 0 ? cVar.m115try() : cVar.m114new();
            if (m115try != null) {
                stringBuffer.append(m115try);
            }
        }
        if (location != null) {
            String m51if = (f187long == 0 || i == 0) ? b.m51if(location) : b.m42byte();
            if (m51if != null) {
                stringBuffer.append(m51if);
            }
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        String a2 = c.a(i == 0);
        if (a2 != null) {
            stringBuffer.append(a2);
        }
        if (aVar != null && (m92for = aVar.m92for()) != null && m92for.length() + stringBuffer.length() < 750) {
            stringBuffer.append(m92for);
        }
        String stringBuffer2 = stringBuffer.toString();
        a(a, "util format : " + stringBuffer2);
        return stringBuffer2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2, String str3, double d) {
        int indexOf;
        int length;
        int indexOf2;
        if (str == null || str.equals("") || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, (length = indexOf + str2.length()))) == -1) {
            return null;
        }
        return str.replaceFirst(str.substring(length, indexOf2), String.format("%.7f", Double.valueOf(d)));
    }

    public static void a(String str, String str2) {
        if (f182else) {
            Log.d(str, str2);
        }
    }

    public static boolean a(String str) {
        int m185if = m185if(str, "error\":\"", "\"");
        return m185if > 100 && m185if < 200;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: do  reason: not valid java name */
    public static double m182do(String str, String str2, String str3) {
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
            a(a, "util numberFormatException, doubleStr : " + substring);
            e.printStackTrace();
            return Double.MIN_VALUE;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static String m183do() {
        return f186int;
    }

    /* renamed from: for  reason: not valid java name */
    public static void m184for() {
        if (f182else || f178byte) {
            try {
                if (f184goto != null) {
                    f184goto.destroy();
                    f184goto = null;
                }
                File file = new File(f.O);
                if (file.exists()) {
                    a("sdkdemo_applocation", "directory already exists...");
                } else {
                    file.mkdirs();
                    a("sdkdemo_applocation", "directory not exists, make dirs...");
                }
                a(a, "logcat start ...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: if  reason: not valid java name */
    public static int m185if(String str, String str2, String str3) {
        int indexOf;
        int length;
        int indexOf2;
        String substring;
        if (str == null || str.equals("") || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, (length = indexOf + str2.length()))) == -1 || (substring = str.substring(length, indexOf2)) == null || substring.equals("")) {
            return Integer.MIN_VALUE;
        }
        try {
            return Integer.parseInt(substring);
        } catch (NumberFormatException e) {
            a(a, "util numberFormatException, intStr : " + substring);
            e.printStackTrace();
            return Integer.MIN_VALUE;
        }
    }

    /* renamed from: if  reason: not valid java name */
    static String m186if() {
        Calendar calendar = Calendar.getInstance();
        return String.format("%d_%d_%d_%d_%d_%d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
    }

    /* renamed from: if  reason: not valid java name */
    public static void m187if(String str) {
        if ((f182else || f178byte) && str != null) {
            f186int = str;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static void m188if(String str, String str2) {
        if (f178byte) {
            Log.d(str, str2);
        }
    }

    /* renamed from: int  reason: not valid java name */
    public static void m189int() {
        if (f184goto != null) {
            try {
                a(a, "logcat stop...");
                f184goto.destroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
