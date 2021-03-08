package com.baidu.mobads.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobads.MobadsPermissionSettings;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class t implements IXAdSystemUtils {
    private static String e;
    private static String f;
    private static String g;
    private static String i;
    private static String j;
    private static String k;
    private String o;
    private String q;
    private String r;
    private String s;
    private int u;
    private static long h = -1;

    /* renamed from: a  reason: collision with root package name */
    static List<String[]> f2494a = new ArrayList();
    static List<String[]> b = new ArrayList();
    static JSONArray c = new JSONArray();
    private static volatile t l = null;
    public JSONArray d = new JSONArray();
    private String m = "";
    private String n = "";
    private int p = -1;
    private String t = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int a(t tVar) {
        int i2 = tVar.u;
        tVar.u = i2 + 1;
        return i2;
    }

    private t() {
    }

    public static t a() {
        if (l == null) {
            synchronized (t.class) {
                if (l == null) {
                    l = new t();
                }
            }
        }
        return l;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    @TargetApi(4)
    public boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getSnFrom(Context context) {
        return this.m + this.n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 6) {
            return true;
        }
        int length = str.length();
        do {
            length--;
            if (length < 0) {
                return true;
            }
        } while (str.charAt(length) == '0');
        return false;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getIMEI(Context context) {
        if (!MobadsPermissionSettings.hasPermissionGranted("permission_read_phone_state")) {
            return "";
        }
        if (TextUtils.isEmpty(f)) {
            Context applicationContext = context.getApplicationContext();
            if (XAdSDKFoundationFacade.getInstance().getCommonUtils().hasPermission(applicationContext, "android.permission.READ_PHONE_STATE")) {
                this.n = "1";
                String deviceId = getDeviceId(applicationContext);
                if (!e(deviceId)) {
                    this.m = "0";
                    f = deviceId;
                    return f;
                }
            }
            com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new u(this, applicationContext));
        }
        return f;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getSn(Context context) {
        try {
            if (TextUtils.isEmpty(i)) {
                String imei = getIMEI(context);
                if (TextUtils.isEmpty(imei)) {
                    imei = getMacAddress(context);
                }
                i = XAdSDKFoundationFacade.getInstance().getCommonUtils().b(imei);
            }
            return i;
        } catch (Exception e2) {
            return "";
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getCUID(Context context) {
        if (TextUtils.isEmpty(e)) {
            com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new v(this, context));
        }
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().b(e);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public double[] getGPS(Context context) {
        return null;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getGUID(Context context) {
        if (TextUtils.isEmpty(j)) {
            com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new w(this, context));
        }
        return j;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getAndroidId(Context context) {
        try {
            if (!MobadsPermissionSettings.hasPermissionGranted("permission_read_phone_state")) {
                return "";
            }
            if (TextUtils.isEmpty(this.o)) {
                this.o = XAdSDKFoundationFacade.getInstance().getCommonUtils().b(Settings.Secure.getString(context.getContentResolver(), "android_id"));
            }
            return this.o;
        } catch (Exception e2) {
            return "";
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getAppSDC() {
        try {
            Object a2 = XAdSDKFoundationFacade.getInstance().getCommonUtils().a("sysSdc");
            if (a2 != null) {
                return (String) a2;
            }
        } catch (Exception e2) {
            q.a().e(e2);
        }
        if (Environment.getExternalStorageState().equals("mounted")) {
            String str = "";
            try {
                str = getAvailableExternalMemorySize() + "," + getAllExternalMemorySize();
                XAdSDKFoundationFacade.getInstance().getCommonUtils().a("sysSdc", str);
                return str;
            } catch (Exception e3) {
                return str;
            }
        }
        return "0,0";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getMem() {
        try {
            Object a2 = XAdSDKFoundationFacade.getInstance().getCommonUtils().a("sysMem");
            if (a2 != null) {
                return (String) a2;
            }
        } catch (Exception e2) {
            q.a().e(e2);
        }
        String str = "";
        try {
            str = getAvailableInternalMemorySize() + "," + getAllInternalMemorySize();
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a("sysMem", str);
            return str;
        } catch (Exception e3) {
            return str;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public long getAllExternalMemorySize() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return a(Environment.getExternalStorageDirectory());
            }
            return -1L;
        } catch (Exception e2) {
            return -1L;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public long getAllInternalMemorySize() {
        try {
            return a(Environment.getDataDirectory());
        } catch (Exception e2) {
            return -1L;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public long getAvailableExternalMemorySize() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return b(Environment.getExternalStorageDirectory());
            }
            return -1L;
        } catch (Exception e2) {
            return -1L;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public long getAvailableInternalMemorySize() {
        try {
            return b(Environment.getDataDirectory());
        } catch (Exception e2) {
            return -1L;
        }
    }

    @TargetApi(18)
    private long a(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return ((statFs.getBlockSize() * statFs.getBlockCount()) / 1024) / 1024;
        } catch (Exception e2) {
            return -1L;
        }
    }

    @TargetApi(18)
    private long b(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return ((statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1024) / 1024;
        } catch (Exception e2) {
            return -1L;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getMacAddress(Context context) {
        return "";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    @TargetApi(3)
    public String getIp(Context context) {
        return "";
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [501=4] */
    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getMaxCpuFreq() {
        Closeable closeable;
        FileReader fileReader;
        if (this.p < 0) {
            try {
                try {
                    fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    closeable = new BufferedReader(fileReader);
                    try {
                        this.p = Integer.parseInt(closeable.readLine().trim()) / 1000;
                        a(fileReader);
                        a(closeable);
                    } catch (Exception e2) {
                        e = e2;
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
                        a(fileReader);
                        a(closeable);
                        return this.p + "";
                    }
                } catch (Exception e3) {
                    e = e3;
                    closeable = null;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = null;
                    a(fileReader);
                    a(closeable);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                closeable = null;
                fileReader = null;
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                fileReader = null;
            }
        }
        return this.p + "";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getNetworkOperatorName(Context context) {
        if (TextUtils.isEmpty(k)) {
            com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new x(this, (TelephonyManager) context.getSystemService("phone")));
        }
        return k;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getNetworkOperator(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (TextUtils.isEmpty(this.q)) {
                this.q = XAdSDKFoundationFacade.getInstance().getCommonUtils().b(telephonyManager.getNetworkOperator());
            }
            return this.q;
        } catch (Exception e2) {
            return this.q;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getPhoneOSBuildVersionSdk() {
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().b(Build.VERSION.SDK);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    @SuppressLint({"DefaultLocale"})
    @TargetApi(3)
    public String getNetworkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                return "none";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            try {
                if (activeNetworkInfo.getSubtypeName() == null) {
                    return "unknown";
                }
                return activeNetworkInfo.getSubtypeName().toLowerCase();
            } catch (Exception e2) {
                e = e2;
                XAdSDKFoundationFacade.getInstance().getAdLogger().i(e);
                return "none";
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getNetType(Context context) {
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
        if (r4.equalsIgnoreCase("CDMA2000") != false) goto L23;
     */
    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getNetworkCatagory(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    return 100;
                }
                if (activeNetworkInfo.getType() == 0) {
                    String subtypeName = activeNetworkInfo.getSubtypeName();
                    switch (activeNetworkInfo.getSubtype()) {
                        case 0:
                            return 1;
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return 2;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                            return 3;
                        default:
                            if (subtypeName != null) {
                                if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA")) {
                                    break;
                                }
                                return 3;
                            }
                            return 1;
                    }
                }
            }
            return 0;
        } catch (Exception e2) {
            return 0;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public Boolean isWifiConnected(Context context) {
        return a(context, 1);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public Boolean is3GConnected(Context context) {
        return a(context, 0);
    }

    private Boolean a(Context context, int i2) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().e("Utils", "no permission android.permission.ACCESS_NETWORK_STATE");
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return Boolean.valueOf(activeNetworkInfo != null && activeNetworkInfo.getType() == i2 && activeNetworkInfo.isConnected());
        } catch (Exception e2) {
            return false;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getDeviceId(Context context) {
        if (!MobadsPermissionSettings.hasPermissionGranted("permission_read_phone_state")) {
            return "";
        }
        if (TextUtils.isEmpty(g) && context != null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("__x_adsdk_agent_header__", 0);
                IBase64 base64 = XAdSDKFoundationFacade.getInstance().getBase64();
                String str = "";
                long currentTimeMillis = System.currentTimeMillis();
                if (h < 0) {
                    h = sharedPreferences.getLong("IA-Vuifb", 0L);
                    if (h == 0 && sharedPreferences.contains("deviceid")) {
                        String string = sharedPreferences.getString("deviceid", "");
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.remove("deviceid");
                        if (!e(string)) {
                            edit.putString("uANvpyP-pyfb", base64.encode(string));
                        }
                        edit.apply();
                    }
                    str = base64.decodeStr(sharedPreferences.getString("uANvpyP-pyfb", ""));
                    if (!e(str)) {
                        g = str;
                    }
                }
                Object obj = str;
                if (currentTimeMillis - h > 129600000 && Build.VERSION.SDK_INT < 29) {
                    String decodeStr = base64.decodeStr("uvNYwANvpyP-iyfb");
                    String str2 = (String) XAdSDKFoundationFacade.getInstance().getCommonUtils().a((TelephonyManager) context.getApplicationContext().getSystemService("phone"), decodeStr, new Object[0]);
                    h = currentTimeMillis;
                    SharedPreferences.Editor edit2 = sharedPreferences.edit();
                    edit2.putLong("IA-Vuifb", h);
                    if (!e(str2) && !str2.equals(obj)) {
                        edit2.putString("uANvpyP-pyfb", base64.encode(str2));
                        g = str2;
                    }
                    edit2.apply();
                }
            } catch (Throwable th) {
                q.a().d(th);
            }
        }
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().b(g);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getEncodedSN(Context context) {
        try {
            if (TextUtils.isEmpty(this.r)) {
                this.r = XAdSDKFoundationFacade.getInstance().getBase64().encode(getSn(context));
            }
            return this.r;
        } catch (Exception e2) {
            return this.r;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getPhoneOSBrand() {
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().b(Build.BRAND);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public List<String[]> getCell(Context context) {
        if (!MobadsPermissionSettings.hasPermissionGranted("permission_location")) {
            if (f2494a == null) {
                f2494a = new ArrayList();
            } else {
                f2494a.clear();
            }
            return f2494a;
        }
        if (f2494a == null || f2494a.size() == 0) {
            try {
                com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new y(this, ((TelephonyManager) context.getSystemService("phone")).getCellLocation()));
            } catch (Throwable th) {
            }
        }
        return f2494a;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public List<String[]> getWIFI(Context context) {
        return b;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public boolean canSupportSdcardStroage(Context context) {
        try {
            h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
            if (Build.VERSION.SDK_INT <= 28 && !commonUtils.hasPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                if (isUseOldStoragePath()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public boolean isUseOldStoragePath() {
        return Build.VERSION.SDK_INT < 23;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getWifiConnected(Context context) {
        return "";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public JSONArray getWifiScans(Context context) {
        return c;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public JSONArray getBackgroundBrowsers(Context context) {
        IXAdLogger adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
        try {
            String[] supportedBrowsers = XAdSDKFoundationFacade.getInstance().getAdConstants().getSupportedBrowsers();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (packageManager.getLaunchIntentForPackage(runningAppProcessInfo.processName) != null && packageManager.getApplicationInfo(runningAppProcessInfo.processName, 128) != null) {
                    for (String str : supportedBrowsers) {
                        if (runningAppProcessInfo.processName.equals(str)) {
                            this.d.put(runningAppProcessInfo.processName);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            adLogger.d(e2);
        }
        adLogger.d("bgBrowsers:" + this.d);
        return this.d;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public HttpURLConnection getHttpConnection(Context context, String str, int i2, int i3) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i3);
                return httpURLConnection;
            } catch (Exception e2) {
                return httpURLConnection;
            }
        } catch (Exception e3) {
            return null;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public boolean isCurrentNetworkAvailable(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("isCurrentNetworkAvailable", e2);
            return false;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getCurrentProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
            if (this.s == null) {
                int myPid = Process.myPid();
                if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.pid == myPid) {
                            this.s = runningAppProcessInfo.processName;
                        }
                    }
                }
            }
            return this.s;
        } catch (Exception e2) {
            return this.s;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public int getCurrentProcessId(Context context) {
        try {
            return Process.myPid();
        } catch (Exception e2) {
            return 0;
        }
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d(th);
            }
        }
    }

    public String a(Context context) {
        if (!TextUtils.isEmpty(this.t) || this.u > 2) {
            return this.t;
        }
        com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new z(this, context));
        return this.t;
    }
}
