package com.baidu.batsdk.b;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class b {
    private static Locale a;
    private static TelephonyManager b;
    private static ConnectivityManager c;
    private static Display d;
    private static int e;
    private static int f;
    private static Map<String, Object> g;
    private static SharedPreferences h;
    private static Bitmap i;
    private static Bitmap j;
    private static SimpleDateFormat k;

    public static String a(Thread thread) {
        StackTraceElement[] stackTrace;
        StringBuilder sb = new StringBuilder();
        if (thread != null) {
            sb.append("threadId： ").append(thread.getId()).append(IOUtils.LINE_SEPARATOR_UNIX);
            sb.append("name: ").append(thread.getName()).append(IOUtils.LINE_SEPARATOR_UNIX);
            sb.append("priority: ").append(thread.getPriority()).append(IOUtils.LINE_SEPARATOR_UNIX);
            if (thread.getThreadGroup() != null) {
                sb.append("groupName: ").append(thread.getThreadGroup().getName()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            sb.append("state: ").append(thread.getState()).append(IOUtils.LINE_SEPARATOR_UNIX);
            sb.append("stacktrace: \n");
            for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
                sb.append("\tat ").append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber()).append(")\n");
            }
        }
        return sb.toString();
    }

    public static int h() {
        try {
            return Build.VERSION.class.getField("SDK_INT").getInt(null);
        } catch (IllegalAccessException e2) {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (IllegalArgumentException e3) {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (NoSuchFieldException e4) {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (SecurityException e5) {
            return Integer.parseInt(Build.VERSION.SDK);
        }
    }

    public static String a(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        if (map.containsKey("screenshot")) {
            map.put("screenshot", com.baidu.batsdk.f.b.a((byte[]) map.get("screenshot"), 0));
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            try {
                Object obj = map.get(str);
                if (obj instanceof String) {
                    jSONObject.put(str, (String) obj);
                } else if (obj instanceof Integer) {
                    jSONObject.put(str, (Integer) obj);
                } else if (obj instanceof Long) {
                    jSONObject.put(str, (Long) obj);
                } else if (obj instanceof Float) {
                    jSONObject.put(str, (Float) obj);
                } else {
                    com.baidu.batsdk.f.a.d("mapRecord2JSON: unexpected key[" + str + "]'s value " + obj);
                }
            } catch (JSONException e2) {
                com.baidu.batsdk.f.a.b("Could not create JSON object for key " + str, e2);
            }
        }
        return jSONObject.toString();
    }

    public static void c(Context context) {
        a = Locale.getDefault();
    }

    public static void a(Context context, CharSequence charSequence, int i2) {
        try {
            Toast.makeText(context, charSequence, i2).show();
        } catch (RuntimeException e2) {
            com.baidu.batsdk.f.a.b("sendToast fail.", e2);
        }
    }

    public static String a() {
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fileReader = new FileReader("/proc/stat");
            BufferedReader bufferedReader = new BufferedReader(fileReader, 8192);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e2) {
            com.baidu.batsdk.f.a.b("getCPUStat fail.", e2);
        } catch (IOException e3) {
            com.baidu.batsdk.f.a.b("getCPUStat fail.", e3);
        }
        return sb.toString();
    }

    public static String k(Context context) {
        StringBuilder sb = new StringBuilder();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (defaultSharedPreferences != null) {
            Map<String, ?> all = defaultSharedPreferences.getAll();
            if (all != null && all.size() > 0) {
                for (String str : all.keySet()) {
                    if (all.get(str) != null) {
                        sb.append(defaultSharedPreferences).append(FilenameUtils.EXTENSION_SEPARATOR).append(str).append(": ").append(all.get(str).toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
                    } else {
                        sb.append(defaultSharedPreferences).append(FilenameUtils.EXTENSION_SEPARATOR).append(str).append(": null\n");
                    }
                }
            } else {
                sb.append(defaultSharedPreferences).append(": empty\n");
            }
        }
        return sb.toString();
    }

    public static String a(Context context) {
        Field[] fields;
        StringBuilder sb = new StringBuilder();
        try {
            Configuration configuration = context.getResources().getConfiguration();
            for (Field field : configuration.getClass().getFields()) {
                try {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        sb.append(field.getName()).append(": ").append(field.get(configuration));
                        sb.append('\n');
                    }
                } catch (IllegalAccessException e2) {
                    com.baidu.batsdk.f.a.b("Failed to inspect device configuration: " + configuration, e2);
                } catch (IllegalArgumentException e3) {
                    com.baidu.batsdk.f.a.b("Failed to inspect device configuration: " + configuration, e3);
                }
            }
        } catch (RuntimeException e4) {
            com.baidu.batsdk.f.a.a("Couldn't retrieve CrashConfiguration for : " + context.getPackageName(), e4);
        }
        return sb.toString();
    }

    public static String h(Context context) {
        Field[] fields;
        StringBuilder sb = new StringBuilder();
        for (Field field : Settings.System.class.getFields()) {
            if (!field.isAnnotationPresent(Deprecated.class) && field.getType() == String.class) {
                try {
                    String string = Settings.System.getString(context.getContentResolver(), (String) field.get(null));
                    if (string != null) {
                        sb.append(field.getName()).append(": ").append((Object) string).append(IOUtils.LINE_SEPARATOR_UNIX);
                    }
                } catch (IllegalAccessException e2) {
                    com.baidu.batsdk.f.a.a("getSystemSettingsInfo Error: ", e2);
                } catch (IllegalArgumentException e3) {
                    com.baidu.batsdk.f.a.a("getSystemSettingsInfo Error: ", e3);
                } catch (Exception e4) {
                }
            }
        }
        return sb.toString();
    }

    public static String d(Context context) {
        NetworkInfo activeNetworkInfo;
        StringBuilder sb = new StringBuilder();
        try {
            if (c == null) {
                c = (ConnectivityManager) context.getSystemService("connectivity");
            }
            activeNetworkInfo = c.getActiveNetworkInfo();
        } catch (RuntimeException e2) {
            com.baidu.batsdk.f.a.a("NetworkCollector: Couldn't get NetworkInfo : " + context.getPackageName(), e2);
        }
        if (activeNetworkInfo == null) {
            com.baidu.batsdk.f.a.c("NetworkCollector: Couldn't get NetworkInfo : " + context.getPackageName());
            return "N/A";
        }
        if (!activeNetworkInfo.isConnected()) {
            sb.append("type: none\n");
        } else {
            sb.append("type: ").append(activeNetworkInfo.getTypeName()).append(IOUtils.LINE_SEPARATOR_UNIX);
            if (activeNetworkInfo.getType() == 0) {
                sb.append("subType: ").append(activeNetworkInfo.getSubtypeName()).append(IOUtils.LINE_SEPARATOR_UNIX);
                if (b == null) {
                    b = (TelephonyManager) context.getSystemService("phone");
                }
                sb.append("isRoaming: ").append(b.isNetworkRoaming() ? "yes" : "no").append(IOUtils.LINE_SEPARATOR_UNIX);
            }
        }
        return sb.toString();
    }

    public static String d() {
        String str;
        int myPid = Process.myPid();
        if (!com.baidu.batsdk.a.p || myPid <= 0) {
            str = null;
        } else {
            str = String.valueOf(Integer.toString(myPid)) + "):";
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("logcat");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(Arrays.asList("-t", String.valueOf(com.baidu.batsdk.a.o), "-v", "time"));
        int indexOf = arrayList2.indexOf("-t");
        if (indexOf >= 0 && indexOf < arrayList2.size() && h() < 8) {
            arrayList2.remove(indexOf + 1);
            arrayList2.remove(indexOf);
            arrayList2.add("-d");
        }
        com.baidu.batsdk.f.c cVar = new com.baidu.batsdk.f.c(com.baidu.batsdk.a.o);
        arrayList.addAll(arrayList2);
        try {
            Process exec = Runtime.getRuntime().exec((String[]) arrayList.toArray(new String[arrayList.size()]));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 8192);
            new Thread(new d(exec)).start();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (str == null || readLine.contains(str)) {
                    cVar.add(String.valueOf(readLine) + IOUtils.LINE_SEPARATOR_UNIX);
                }
            }
        } catch (IOException e2) {
            com.baidu.batsdk.f.a.b("LogCatCollector.collectLogCat failed.", e2);
        }
        return cVar.toString();
    }

    public static String c() {
        return String.valueOf(a.getLanguage()) + "-" + a.getCountry();
    }

    public static int[] f(Context context) {
        if (e == 0) {
            if (d == null) {
                d = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            }
            Point point = new Point();
            if (h() < 13) {
                point.set(d.getWidth(), d.getHeight());
            } else {
                d.getSize(point);
            }
            e = point.x;
            f = point.y;
        }
        return new int[]{e, f};
    }

    public static Map<String, Object> a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = jSONObject.get(next);
                    if (obj == JSONObject.NULL) {
                        hashMap.put(next, null);
                    } else if (obj instanceof JSONObject) {
                        hashMap.put(next, a((JSONObject) obj));
                    } else if (obj instanceof JSONArray) {
                        com.baidu.batsdk.f.a.d("json2Map fail. SHOULD NOT have JSONArray.");
                    } else {
                        hashMap.put(next, obj);
                    }
                }
            } catch (JSONException e2) {
                com.baidu.batsdk.f.a.b("json2Map fail.", e2);
            }
        }
        return hashMap;
    }

    public static void a(Context context, String str) {
        a(context, "bat_crash_" + System.currentTimeMillis(), str);
    }

    public static String b(Context context) {
        Object[] objArr;
        if (h() < 5) {
            return "N/A";
        }
        StringBuilder sb = new StringBuilder();
        try {
            for (Object obj : (Object[]) PackageManager.class.getMethod("getSystemAvailableFeatures", null).invoke(context.getPackageManager(), new Object[0])) {
                String str = (String) obj.getClass().getField("name").get(obj);
                if (str != null) {
                    sb.append(str);
                } else {
                    sb.append("glEsVersion = ");
                    sb.append((String) obj.getClass().getMethod("getGlEsVersion", null).invoke(obj, new Object[0]));
                }
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
        } catch (Throwable th) {
            com.baidu.batsdk.f.a.b("Couldn't retrieve DeviceFeatures for " + context.getPackageName(), th);
        }
        return sb.toString();
    }

    public static String n(Context context) {
        Map<String, Object> w = w(context);
        g = w;
        return w.containsKey("syncId") ? String.valueOf(g.get("syncId")) : "";
    }

    public static void b(Context context, String str) {
        a(context, "bat_feedback_" + System.currentTimeMillis(), str);
    }

    public static String e() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            sb.append(a(entry.getKey())).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        return sb.toString();
    }

    public static Map<String, Object> a(Context context, Throwable th) {
        String stackTraceElement;
        Map<String, Object> l = l(context);
        try {
            l.put("errorType", th.getClass().getName());
            if (th == null) {
                com.baidu.batsdk.f.a.d("getErrorLine thr is null.");
                stackTraceElement = "";
            } else {
                StackTraceElement[] stackTrace = th.getStackTrace();
                stackTraceElement = stackTrace.length > 0 ? stackTrace[0].toString() : "N/A";
            }
            l.put("errorLine", stackTraceElement);
            com.baidu.batsdk.f.a.b("errorLine: " + stackTraceElement);
            String a2 = a(th);
            l.put("errorOriLine", a2);
            com.baidu.batsdk.f.a.b("errorOriLine: " + a2);
            l.put("errorTrace", Log.getStackTraceString(th));
        } catch (RuntimeException e2) {
            com.baidu.batsdk.f.a.b("createCrashRecord fail.", e2);
        }
        return l;
    }

    public static String b() {
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fileReader = new FileReader("/proc/" + Process.myPid() + "/stat");
            BufferedReader bufferedReader = new BufferedReader(fileReader, 8192);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e2) {
            com.baidu.batsdk.f.a.b("getMyAppCPUStat fail.", e2);
        } catch (IOException e3) {
            com.baidu.batsdk.f.a.b("getMyAppCPUStat fail.", e3);
        }
        return sb.toString();
    }

    public static Map<String, Object> l(Context context) {
        String a2;
        String a3;
        String str;
        String k2;
        String j2;
        String i2;
        String h2;
        String sb;
        String a4;
        String b2;
        String e2;
        String a5;
        String d2;
        String d3;
        String b3;
        String a6;
        String b4;
        byte[] d4;
        HashMap hashMap = new HashMap();
        try {
            if (com.baidu.batsdk.a.C) {
                com.baidu.batsdk.f.a.a("screenshot collecting");
                hashMap.put("screenshot", a.d());
                com.baidu.batsdk.f.a.a("screenshot done " + b(d4.length));
            } else {
                hashMap.put("screenshot", new byte[0]);
            }
            hashMap.put("phoneTime", Long.valueOf(System.currentTimeMillis()));
            if (com.baidu.batsdk.a.R) {
                com.baidu.batsdk.f.a.a("myAppCPUStat collecting");
                hashMap.put("myAppCPUStat", b());
                com.baidu.batsdk.f.a.a("myAppCPUStat done " + b(b4.length()));
            }
            if (com.baidu.batsdk.a.S) {
                com.baidu.batsdk.f.a.a("memInfo collecting");
                hashMap.put("memInfo", com.baidu.batsdk.e.b.b());
                com.baidu.batsdk.f.a.a("memInfo done " + b(b3.length()));
                com.baidu.batsdk.f.a.a("sysMemInfo collecting");
                hashMap.put("sysMemInfo", com.baidu.batsdk.e.b.a());
                com.baidu.batsdk.f.a.a("sysMemInfo done " + b(a6.length()));
            }
            hashMap.put("pageHistory", a.b());
            if (com.baidu.batsdk.a.E) {
                com.baidu.batsdk.f.a.a("networkInfo collecting");
                if (com.baidu.batsdk.f.d.a("android.permission.ACCESS_NETWORK_STATE")) {
                    hashMap.put("networkInfo", d(context));
                    com.baidu.batsdk.f.a.a("networkInfo done " + b(d3.length()));
                } else {
                    com.baidu.batsdk.f.a.c("Don't hasPermission ACCESS_NETWORK_STATE for netWorkInfo.");
                    hashMap.put("networkInfo", "N/A");
                }
            }
            if (com.baidu.batsdk.f.d.a("android.permission.ACCESS_NETWORK_STATE")) {
                hashMap.put("netType", e(context));
            } else {
                com.baidu.batsdk.f.a.c("Don't hasPermission ACCESS_NETWORK_STATE for netType.");
                hashMap.put("netType", "N/A");
            }
            if (com.baidu.batsdk.a.F) {
                com.baidu.batsdk.f.a.a("logcat collecting");
                hashMap.put("logcat", d());
                com.baidu.batsdk.f.a.a("logcat done " + b(d2.length()));
            }
            if (com.baidu.batsdk.a.G) {
                com.baidu.batsdk.f.a.a("dropbox collecting");
                if (com.baidu.batsdk.f.d.a("android.permission.READ_LOGS")) {
                    hashMap.put("dropbox", c.a(context));
                    com.baidu.batsdk.f.a.a("dropBox done " + b(a5.length()));
                } else {
                    com.baidu.batsdk.f.a.c("Don't hasPermission READ_LOGS for dropBox.");
                    hashMap.put("dropbox", "N/A");
                }
            }
            hashMap.put("recordId", UUID.randomUUID().toString());
            hashMap.put("uname", g.d());
            hashMap.put("uid", g.b());
            hashMap.put("batVN", "1.0.0");
            hashMap.put("developerName", com.baidu.batsdk.a.k);
            hashMap.put("pkgName", e.a());
            hashMap.put("appLabel", e.b());
            hashMap.put("appVN", e.c());
            hashMap.put("appVC", Integer.valueOf(e.d()));
            hashMap.put("model", Build.MODEL);
            hashMap.put("brand", Build.BRAND);
            hashMap.put("os", "Android");
            hashMap.put("osVN", Build.VERSION.RELEASE);
            hashMap.put("osVC", Integer.valueOf(h()));
            hashMap.put("startupTime", Long.valueOf(a.a()));
            hashMap.put("curPage", a.c());
            hashMap.put("screenSize", g(context));
            hashMap.put("locale", c());
            if (com.baidu.batsdk.a.O) {
                com.baidu.batsdk.f.a.a("allThreadStacks collecting");
                hashMap.put("allThreadStacks", e());
                com.baidu.batsdk.f.a.a("allThreadStacks done " + b(e2.length()));
            }
            if (com.baidu.batsdk.a.H) {
                com.baidu.batsdk.f.a.a("deviceInfo collecting");
                hashMap.put("deviceInfo", b(context));
                com.baidu.batsdk.f.a.a("deviceInfo done " + b2.length());
            }
            if (com.baidu.batsdk.a.I) {
                com.baidu.batsdk.f.a.a("appCurConfig collecting");
                hashMap.put("appCurConfig", a(context));
                com.baidu.batsdk.f.a.a("appCurConfig done " + b(a4.length()));
            }
            if (com.baidu.batsdk.a.M) {
                com.baidu.batsdk.f.a.a("screenInfo collecting");
                StringBuilder sb2 = new StringBuilder();
                if (d == null) {
                    d = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                }
                sb2.append(a(d));
                sb2.append("screenSize: ").append(g(context)).append(IOUtils.LINE_SEPARATOR_UNIX);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                d.getMetrics(displayMetrics);
                sb2.append("density: ").append(displayMetrics.density).append(IOUtils.LINE_SEPARATOR_UNIX);
                sb2.append("pixelFormat: ").append(d.getPixelFormat()).append(IOUtils.LINE_SEPARATOR_UNIX);
                sb2.append("refreshRate: ").append(d.getRefreshRate()).append(IOUtils.LINE_SEPARATOR_UNIX);
                sb2.append(b(d));
                hashMap.put("screenInfo", sb2.toString());
                com.baidu.batsdk.f.a.a("screenInfo done " + b(sb.length()));
            }
            if (com.baidu.batsdk.a.J) {
                com.baidu.batsdk.f.a.a("systemSetting collecting");
                hashMap.put("systemSetting", h(context));
                com.baidu.batsdk.f.a.a("systemSetting done " + b(h2.length()));
            }
            if (com.baidu.batsdk.a.K) {
                com.baidu.batsdk.f.a.a("secureSetting collecting");
                hashMap.put("secureSetting", i(context));
                com.baidu.batsdk.f.a.a("secureSetting done " + b(i2.length()));
            }
            if (com.baidu.batsdk.a.L) {
                com.baidu.batsdk.f.a.a("globalSetting collecting");
                hashMap.put("globalSetting", j(context));
                com.baidu.batsdk.f.a.a("globalSetting done " + b(j2.length()));
            }
            if (com.baidu.batsdk.a.N) {
                com.baidu.batsdk.f.a.a("sharedPref collecting");
                hashMap.put("sharedPref", k(context));
                com.baidu.batsdk.f.a.a("sharedPref done " + b(k2.length()));
            }
            if (com.baidu.batsdk.a.P) {
                com.baidu.batsdk.f.a.a("internalStorage collecting");
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
                StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
                long availableBlocks = statFs2.getAvailableBlocks() * statFs2.getBlockSize();
                hashMap.put("internalStorageInfo", "Total: " + b(blockCount) + " Used: " + b(blockCount - availableBlocks) + " Free: " + b(availableBlocks));
                com.baidu.batsdk.f.a.a("internalStorage done " + b(str.length()));
            }
            if (com.baidu.batsdk.a.Q) {
                com.baidu.batsdk.f.a.a("CPUStat collecting");
                hashMap.put("CPUStat", a());
                com.baidu.batsdk.f.a.a("CPUStat done " + b(a3.length()));
            }
            if (com.baidu.batsdk.a.T) {
                com.baidu.batsdk.f.a.a("allProcessInfo collecting");
                hashMap.put("allProcessInfo", f.a());
                com.baidu.batsdk.f.a.a("allProcessInfo done " + b(a2.length()));
            }
            hashMap.put("userInfo", g.c());
            com.baidu.batsdk.f.a.b("createRecord success.");
        } catch (RuntimeException e3) {
            com.baidu.batsdk.f.a.b("createRecord fail.", e3);
        }
        return hashMap;
    }

    private static void a(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            byte[] bytes = str2.getBytes("UTF-8");
            com.baidu.batsdk.f.a.a("writeRecord before gzip: " + b(bytes.length));
            if (com.baidu.batsdk.a.B) {
                DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(openFileOutput, new Deflater(9, true));
                deflaterOutputStream.write(bytes);
                deflaterOutputStream.close();
                openFileOutput.close();
            } else {
                openFileOutput.write(bytes);
                openFileOutput.close();
            }
        } catch (FileNotFoundException e2) {
            com.baidu.batsdk.f.a.b("Could not write file " + str, e2);
        } catch (UnsupportedEncodingException e3) {
            com.baidu.batsdk.f.a.b("Could not write file " + str, e3);
        } catch (IOException e4) {
            com.baidu.batsdk.f.a.b("Could not write file " + str, e4);
        }
    }

    public static String i(Context context) {
        Field[] fields;
        StringBuilder sb = new StringBuilder();
        for (Field field : Settings.Secure.class.getFields()) {
            if (!field.isAnnotationPresent(Deprecated.class) && field.getType() == String.class) {
                try {
                    String string = Settings.Secure.getString(context.getContentResolver(), (String) field.get(null));
                    if (string != null) {
                        sb.append(field.getName()).append(": ").append((Object) string).append(IOUtils.LINE_SEPARATOR_UNIX);
                    }
                } catch (IllegalAccessException e2) {
                    com.baidu.batsdk.f.a.a("getSecureSettingsInfo Error: ", e2);
                } catch (IllegalArgumentException e3) {
                    com.baidu.batsdk.f.a.a("getSecureSettingsInfo Error: ", e3);
                } catch (Exception e4) {
                }
            }
        }
        return sb.toString();
    }

    public static String g(Context context) {
        int[] f2 = f(context);
        return String.valueOf(f2[0]) + "x" + f2[1];
    }

    public static void a(Map<String, Object> map, Intent intent) {
        if (map != null && intent != null) {
            for (String str : map.keySet()) {
                Object obj = map.get(str);
                if (obj instanceof String) {
                    intent.putExtra(str, (String) obj);
                } else if (obj instanceof Integer) {
                    intent.putExtra(str, (Integer) obj);
                } else if (obj instanceof Long) {
                    intent.putExtra(str, (Long) obj);
                } else if (obj instanceof Float) {
                    intent.putExtra(str, (Float) obj);
                } else if (obj instanceof byte[]) {
                    intent.putExtra(str, (byte[]) obj);
                } else if (obj == null) {
                    com.baidu.batsdk.f.a.d("mapRecord2Intent: unexpected key[" + str + "]'s value null.");
                } else {
                    com.baidu.batsdk.f.a.d("mapRecord2Intent: unexpected key[" + str + "]'s value type " + obj.getClass().getName());
                }
            }
        }
    }

    public static String e(Context context) {
        try {
            if (c == null) {
                c = (ConnectivityManager) context.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = c.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                com.baidu.batsdk.f.a.c("getNetworkType fail, getActiveNetworkInfo() is null.");
                return "UNKNOWN";
            } else if (!activeNetworkInfo.isConnected()) {
                return "NONE";
            } else {
                return activeNetworkInfo.getTypeName().toUpperCase();
            }
        } catch (RuntimeException e2) {
            com.baidu.batsdk.f.a.b("getNetworkType fail,", e2);
            return "UNKNOWN";
        }
    }

    public static String a(long j2) {
        if (k == null) {
            k = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        }
        return k.format(new Date(j2));
    }

    public static String o(Context context) {
        Map<String, Object> w = w(context);
        g = w;
        return w.containsKey("msg") ? String.valueOf(g.get("msg")) : "";
    }

    public static String b(long j2) {
        if (j2 / 1000000000 > 0) {
            return (((float) (j2 / 100000000)) / 10.0f) + "G";
        }
        if (j2 / 1000000 > 0) {
            return (((float) (j2 / 100000)) / 10.0f) + "M";
        }
        if (j2 / 1000 > 0) {
            return (((float) (j2 / 100)) / 10.0f) + "K";
        }
        return j2 + "B";
    }

    public static Map<String, Object> m(Context context) {
        File filesDir;
        File[] listFiles;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long j2 = 0;
        if (context != null && (filesDir = context.getFilesDir()) != null && (listFiles = filesDir.listFiles()) != null) {
            for (File file : listFiles) {
                String name = file.getName();
                if (name.startsWith("bat_crash_")) {
                    arrayList.add(name);
                    j2 += file.length();
                } else if (name.startsWith("bat_feedback_")) {
                    arrayList2.add(name);
                    j2 += file.length();
                }
            }
        }
        hashMap.put("crashFiles", arrayList);
        hashMap.put("feedbackFiles", arrayList2);
        hashMap.put("allSize", Long.valueOf(j2));
        return hashMap;
    }

    public static String j(Context context) {
        Object invoke;
        if (h() < 17) {
            return "N/A";
        }
        StringBuilder sb = new StringBuilder();
        try {
            Class<?> cls = Class.forName("android.provider.Settings$Global");
            Field[] fields = cls.getFields();
            Method method = cls.getMethod("getString", ContentResolver.class, String.class);
            for (Field field : fields) {
                if (!field.isAnnotationPresent(Deprecated.class) && field.getType() == String.class && (invoke = method.invoke(null, context.getContentResolver(), (String) field.get(null))) != null) {
                    sb.append(field.getName()).append(": ").append(invoke).append(IOUtils.LINE_SEPARATOR_UNIX);
                }
            }
        } catch (ClassNotFoundException e2) {
            com.baidu.batsdk.f.a.a("getGlobalSettingsInfo Error: ", e2);
        } catch (IllegalAccessException e3) {
            com.baidu.batsdk.f.a.a("getGlobalSettingsInfo Error: ", e3);
        } catch (IllegalArgumentException e4) {
            com.baidu.batsdk.f.a.a("getGlobalSettingsInfo Error: ", e4);
        } catch (NoSuchMethodException e5) {
            com.baidu.batsdk.f.a.a("getGlobalSettingsInfo Error: ", e5);
        } catch (SecurityException e6) {
            com.baidu.batsdk.f.a.a("getGlobalSettingsInfo Error: ", e6);
        } catch (InvocationTargetException e7) {
        } catch (Exception e8) {
        }
        return sb.toString();
    }

    public static void a(Intent intent, Map<String, Object> map) {
        Bundle extras = intent.getExtras();
        for (String str : extras.keySet()) {
            Object obj = extras.get(str);
            if (obj instanceof String) {
                map.put(str, (String) obj);
            } else if (obj instanceof Integer) {
                map.put(str, (Integer) obj);
            } else if (obj instanceof Long) {
                map.put(str, (Long) obj);
            } else if (obj instanceof Float) {
                map.put(str, (Float) obj);
            } else if (obj instanceof byte[]) {
                map.put(str, (byte[]) obj);
            } else {
                com.baidu.batsdk.f.a.d("intent2MapRecord: unexpected key[" + str + "]'s value " + obj);
            }
        }
    }

    private static String a(Display display) {
        Field[] fields;
        StringBuilder sb = new StringBuilder();
        try {
            int intValue = ((Integer) display.getClass().getMethod("getFlags", new Class[0]).invoke(display, new Object[0])).intValue();
            SparseArray sparseArray = new SparseArray();
            for (Field field : display.getClass().getFields()) {
                if (field.getName().startsWith("FLAG_")) {
                    sparseArray.put(field.getInt(null), field.getName());
                }
            }
            sb.append("flags: ").append(a(sparseArray, intValue)).append('\n');
        } catch (IllegalAccessException e2) {
        } catch (IllegalArgumentException e3) {
        } catch (NoSuchMethodException e4) {
        } catch (SecurityException e5) {
        } catch (InvocationTargetException e6) {
        }
        return sb.toString();
    }

    public static long p(Context context) {
        Map<String, Object> w = w(context);
        g = w;
        if (w.containsKey("expireAfterPeriod")) {
            try {
                return ((Number) g.get("expireAfterPeriod")).longValue();
            } catch (ClassCastException e2) {
                com.baidu.batsdk.f.a.a("SyncStorage.getExpireAfterPeriod fail.", e2);
                return 0L;
            }
        }
        return 0L;
    }

    public static byte[] c(Context context, String str) {
        if (str.startsWith("bat_crash_") || str.startsWith("bat_feedback_")) {
            try {
                FileInputStream openFileInput = context.openFileInput(str);
                if (openFileInput == null) {
                    com.baidu.batsdk.f.a.d("Invalid record file " + str);
                }
                return a(openFileInput);
            } catch (FileNotFoundException e2) {
                com.baidu.batsdk.f.a.b("Invalid record file " + str, e2);
            } catch (RuntimeException e3) {
                com.baidu.batsdk.f.a.b("Invalid record file " + str, e3);
            }
        } else {
            com.baidu.batsdk.f.a.d("Should NOT delete file " + str);
        }
        return new byte[0];
    }

    private static String a(SparseArray<String> sparseArray, int i2) {
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < sparseArray.size()) {
                int keyAt = sparseArray.keyAt(i4) & i2;
                if (keyAt > 0) {
                    if (sb.length() > 0) {
                        sb.append('+');
                    }
                    sb.append(sparseArray.get(keyAt));
                }
                i3 = i4 + 1;
            } else {
                return sb.toString();
            }
        }
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, bArr.length);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e2) {
                com.baidu.batsdk.f.a.b("stream2ByteArray fail", e2);
            }
        }
        byteArrayOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public static long q(Context context) {
        Map<String, Object> w = w(context);
        g = w;
        if (w.containsKey("expireAtTime")) {
            try {
                return ((Number) g.get("expireAtTime")).longValue();
            } catch (ClassCastException e2) {
                com.baidu.batsdk.f.a.a("SyncStorage.getExpireAtTime fail.", e2);
                return 0L;
            }
        }
        return 0L;
    }

    private static String b(Display display) {
        StringBuilder sb = new StringBuilder();
        try {
            int intValue = ((Integer) display.getClass().getMethod("getRotation", new Class[0]).invoke(display, new Object[0])).intValue();
            sb.append("rotation: ");
            switch (intValue) {
                case 0:
                    sb.append("ROTATION_0");
                    break;
                case 1:
                    sb.append("ROTATION_90");
                    break;
                case 2:
                    sb.append("ROTATION_180");
                    break;
                case 3:
                    sb.append("ROTATION_270");
                    break;
                default:
                    sb.append(intValue);
                    break;
            }
            sb.append('\n');
        } catch (IllegalAccessException e2) {
        } catch (IllegalArgumentException e3) {
        } catch (NoSuchMethodException e4) {
        } catch (SecurityException e5) {
        } catch (InvocationTargetException e6) {
        }
        return sb.toString();
    }

    public static void d(Context context, String str) {
        if (str.startsWith("bat_crash_") || str.startsWith("bat_feedback_")) {
            File file = new File(context.getFilesDir(), str);
            if (file.exists() && file.isFile()) {
                file.delete();
                return;
            }
            return;
        }
        com.baidu.batsdk.f.a.d("Should NOT delete file " + str);
    }

    public static String r(Context context) {
        Map<String, Object> w = w(context);
        g = w;
        return w.containsKey("when") ? String.valueOf(g.get("when")) : "";
    }

    public static long s(Context context) {
        Map<String, Object> w = w(context);
        g = w;
        if (w.containsKey("repeatInterval")) {
            try {
                return ((Number) g.get("repeatInterval")).longValue();
            } catch (ClassCastException e2) {
                com.baidu.batsdk.f.a.a("SyncStorage.getRepeatInterval fail.", e2);
                return 0L;
            }
        }
        return 0L;
    }

    public static Bitmap f() {
        if (i == null) {
            byte[] a2 = com.baidu.batsdk.f.b.a("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\n7wAAAABJRU5ErkJggg==\n", 0);
            i = BitmapFactory.decodeByteArray(a2, 0, a2.length, null);
        }
        return i;
    }

    public static Bitmap g() {
        if (j == null) {
            byte[] a2 = com.baidu.batsdk.f.b.a("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\n/xkAQnJX+33FAKAAAAAASUVORK5CYII=\n", 0);
            com.baidu.batsdk.f.a.a("getSmallIcon bytes " + a2.length);
            j = BitmapFactory.decodeByteArray(a2, 0, a2.length, null);
        }
        return j;
    }

    public static long t(Context context) {
        Map<String, Object> w = w(context);
        g = w;
        if (w.containsKey("repeatEnd")) {
            try {
                return ((Number) g.get("repeatEnd")).longValue();
            } catch (ClassCastException e2) {
                com.baidu.batsdk.f.a.a("SyncStorage.getRepeatEnd fail.", e2);
                return 0L;
            }
        }
        return 0L;
    }

    public static String a(Throwable th) {
        if (th == null) {
            com.baidu.batsdk.f.a.d("getErrorOriginalLine thr is null.");
            return "";
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        String a2 = e.a();
        for (int i2 = 0; i2 < stackTrace.length; i2++) {
            if (stackTrace[i2].getClassName().contains(a2)) {
                return stackTrace[i2].toString();
            }
        }
        return stackTrace.length > 0 ? stackTrace[0].toString() : "N/A";
    }

    public static String u(Context context) {
        Map<String, Object> w = w(context);
        g = w;
        return w.containsKey("lastSyncId") ? String.valueOf(g.get("lastSyncId")) : "";
    }

    public static String a(Class cls) {
        StringBuilder sb = new StringBuilder();
        try {
            Field[] fields = cls.getFields();
            sb.append(cls.getName()).append("[");
            for (Field field : fields) {
                sb.append(field.getName()).append(":").append(field.get(null)).append(",");
            }
            sb.append("]");
        } catch (IllegalAccessException e2) {
            com.baidu.batsdk.f.a.b("getClassFields failed.", e2);
        } catch (IllegalArgumentException e3) {
            com.baidu.batsdk.f.a.b("getClassFields failed.", e3);
        }
        return sb.toString();
    }

    public static long v(Context context) {
        Map<String, Object> w = w(context);
        g = w;
        if (w.containsKey("lastShowTime")) {
            try {
                return ((Number) g.get("lastShowTime")).longValue();
            } catch (ClassCastException e2) {
                com.baidu.batsdk.f.a.a("SyncStorage.getLastShowTime fail.", e2);
                return 0L;
            }
        }
        return 0L;
    }

    public static Map<String, Object> w(Context context) {
        if (g == null) {
            g = new HashMap();
            if (h == null) {
                h = context.getSharedPreferences("batsdk_sync", 0);
            }
            Map<String, ?> all = h.getAll();
            for (String str : all.keySet()) {
                g.put(str, all.get(str));
            }
        }
        return g;
    }

    public static void a(Context context, Map<String, Object> map) {
        if (map != null) {
            g = w(context);
            if (map.containsKey("syncId")) {
                String valueOf = String.valueOf(map.get("syncId"));
                String str = "";
                if (g.containsKey("syncId")) {
                    str = String.valueOf(g.get("syncId"));
                }
                if (valueOf != null && !valueOf.equals(str)) {
                    SharedPreferences.Editor edit = h.edit();
                    for (String str2 : map.keySet()) {
                        Object obj = g.get(str2);
                        Object obj2 = map.get(str2);
                        if (obj == null || !obj.equals(obj2)) {
                            g.put(str2, obj2);
                            if (obj2 instanceof String) {
                                edit.putString(str2, (String) obj2);
                            } else if (obj2 instanceof Integer) {
                                edit.putInt(str2, ((Integer) obj2).intValue());
                            } else if (obj2 instanceof Long) {
                                edit.putLong(str2, ((Long) obj2).longValue());
                            } else if (obj2 instanceof Float) {
                                edit.putFloat(str2, ((Float) obj2).floatValue());
                            } else {
                                com.baidu.batsdk.f.a.d("saveSync: unexpected key[" + str2 + "]'s value is " + obj2);
                            }
                        }
                    }
                    edit.commit();
                    com.baidu.batsdk.f.a.a("save mMapSync: " + g);
                }
            }
        }
    }

    public static void x(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        String valueOf = String.valueOf(g.get("syncId"));
        Map<String, Object> w = w(context);
        g = w;
        w.put("lastShowTime", Long.valueOf(currentTimeMillis));
        g.put("lastSyncId", valueOf);
        SharedPreferences.Editor edit = h.edit();
        edit.putLong("lastShowTime", currentTimeMillis);
        edit.putString("lastSyncId", valueOf);
        edit.commit();
    }
}
