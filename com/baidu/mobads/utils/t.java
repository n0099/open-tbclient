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
import com.baidu.down.utils.Utils;
import com.baidu.mobads.MobadsPermissionSettings;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class t implements IXAdSystemUtils {

    /* renamed from: e  reason: collision with root package name */
    public static String f8567e = null;

    /* renamed from: f  reason: collision with root package name */
    public static String f8568f = null;

    /* renamed from: g  reason: collision with root package name */
    public static String f8569g = null;

    /* renamed from: h  reason: collision with root package name */
    public static long f8570h = -1;
    public static String i;
    public static String j;
    public static String k;
    public String o;
    public String q;
    public String r;
    public String s;
    public int u;

    /* renamed from: a  reason: collision with root package name */
    public static List<String[]> f8564a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static List<String[]> f8565b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static JSONArray f8566c = new JSONArray();
    public static volatile t l = null;

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f8571d = new JSONArray();
    public String m = "";
    public String n = "";
    public int p = -1;
    public String t = "";

    public static /* synthetic */ int a(t tVar) {
        int i2 = tVar.u;
        tVar.u = i2 + 1;
        return i2;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public boolean canSupportSdcardStroage(Context context) {
        try {
            h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
            if (Build.VERSION.SDK_INT <= 28 && !commonUtils.hasPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                if (isUseOldStoragePath()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public long getAllExternalMemorySize() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return a(Environment.getExternalStorageDirectory());
            }
            return -1L;
        } catch (Exception unused) {
            return -1L;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public long getAllInternalMemorySize() {
        try {
            return a(Environment.getDataDirectory());
        } catch (Exception unused) {
            return -1L;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getAndroidId(Context context) {
        try {
            if (MobadsPermissionSettings.hasPermissionGranted("permission_read_phone_state")) {
                if (TextUtils.isEmpty(this.o)) {
                    this.o = XAdSDKFoundationFacade.getInstance().getCommonUtils().b(Settings.Secure.getString(context.getContentResolver(), "android_id"));
                }
                return this.o;
            }
            return "";
        } catch (Exception unused) {
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
            } catch (Exception unused) {
                return str;
            }
        }
        return "0,0";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public long getAvailableExternalMemorySize() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return b(Environment.getExternalStorageDirectory());
            }
            return -1L;
        } catch (Exception unused) {
            return -1L;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public long getAvailableInternalMemorySize() {
        try {
            return b(Environment.getDataDirectory());
        } catch (Exception unused) {
            return -1L;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public JSONArray getBackgroundBrowsers(Context context) {
        IXAdLogger adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
        try {
            String[] supportedBrowsers = XAdSDKFoundationFacade.getInstance().getAdConstants().getSupportedBrowsers();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (packageManager.getLaunchIntentForPackage(runningAppProcessInfo.processName) != null && packageManager.getApplicationInfo(runningAppProcessInfo.processName, 128) != null) {
                    for (String str : supportedBrowsers) {
                        if (runningAppProcessInfo.processName.equals(str)) {
                            this.f8571d.put(runningAppProcessInfo.processName);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            adLogger.d(e2);
        }
        adLogger.d("bgBrowsers:" + this.f8571d);
        return this.f8571d;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getCUID(Context context) {
        if (TextUtils.isEmpty(f8567e)) {
            com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new v(this, context));
        }
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().b(f8567e);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public List<String[]> getCell(Context context) {
        if (!MobadsPermissionSettings.hasPermissionGranted("permission_location")) {
            List<String[]> list = f8564a;
            if (list == null) {
                f8564a = new ArrayList();
            } else {
                list.clear();
            }
            return f8564a;
        }
        List<String[]> list2 = f8564a;
        if (list2 == null || list2.size() == 0) {
            try {
                com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new y(this, ((TelephonyManager) context.getSystemService("phone")).getCellLocation()));
            } catch (Throwable unused) {
            }
        }
        return f8564a;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public int getCurrentProcessId(Context context) {
        try {
            return Process.myPid();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getCurrentProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
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
        } catch (Exception unused) {
            return this.s;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getDeviceId(Context context) {
        String str = "";
        if (MobadsPermissionSettings.hasPermissionGranted("permission_read_phone_state")) {
            if (TextUtils.isEmpty(f8569g) && context != null) {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("__x_adsdk_agent_header__", 0);
                    IBase64 base64 = XAdSDKFoundationFacade.getInstance().getBase64();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (f8570h < 0) {
                        long j2 = sharedPreferences.getLong("IA-Vuifb", 0L);
                        f8570h = j2;
                        if (j2 == 0 && sharedPreferences.contains("deviceid")) {
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
                            f8569g = str;
                        }
                    }
                    if (currentTimeMillis - f8570h > 129600000 && Build.VERSION.SDK_INT < 29) {
                        String decodeStr = base64.decodeStr("uvNYwANvpyP-iyfb");
                        String str2 = (String) XAdSDKFoundationFacade.getInstance().getCommonUtils().a((TelephonyManager) context.getApplicationContext().getSystemService("phone"), decodeStr, new Object[0]);
                        f8570h = currentTimeMillis;
                        SharedPreferences.Editor edit2 = sharedPreferences.edit();
                        edit2.putLong("IA-Vuifb", f8570h);
                        if (!e(str2) && !str2.equals(str)) {
                            edit2.putString("uANvpyP-pyfb", base64.encode(str2));
                            f8569g = str2;
                        }
                        edit2.apply();
                    }
                } catch (Throwable th) {
                    q.a().d(th);
                }
            }
            return XAdSDKFoundationFacade.getInstance().getCommonUtils().b(f8569g);
        }
        return "";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getEncodedSN(Context context) {
        try {
            if (TextUtils.isEmpty(this.r)) {
                this.r = XAdSDKFoundationFacade.getInstance().getBase64().encode(getSn(context));
            }
            return this.r;
        } catch (Exception unused) {
            return this.r;
        }
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
    public HttpURLConnection getHttpConnection(Context context, String str, int i2, int i3) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i3);
                return httpURLConnection;
            } catch (Exception unused) {
                return httpURLConnection;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getIMEI(Context context) {
        if (MobadsPermissionSettings.hasPermissionGranted("permission_read_phone_state")) {
            if (TextUtils.isEmpty(f8568f)) {
                Context applicationContext = context.getApplicationContext();
                if (XAdSDKFoundationFacade.getInstance().getCommonUtils().hasPermission(applicationContext, "android.permission.READ_PHONE_STATE")) {
                    this.n = "1";
                    String deviceId = getDeviceId(applicationContext);
                    if (!e(deviceId)) {
                        this.m = "0";
                        f8568f = deviceId;
                        return deviceId;
                    }
                }
                com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new u(this, applicationContext));
            }
            return f8568f;
        }
        return "";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    @TargetApi(3)
    public String getIp(Context context) {
        return "";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getMacAddress(Context context) {
        return "";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getMaxCpuFreq() {
        Closeable closeable;
        Throwable th;
        FileReader fileReader;
        Exception e2;
        if (this.p < 0) {
            try {
                try {
                    fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    closeable = new BufferedReader(fileReader);
                    try {
                        this.p = Integer.parseInt(closeable.readLine().trim()) / 1000;
                    } catch (Exception e3) {
                        e2 = e3;
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
                        a(fileReader);
                        a(closeable);
                        return this.p + "";
                    }
                } catch (Exception e4) {
                    closeable = null;
                    e2 = e4;
                } catch (Throwable th3) {
                    closeable = null;
                    th = th3;
                    a(fileReader);
                    a(closeable);
                    throw th;
                }
            } catch (Exception e5) {
                closeable = null;
                e2 = e5;
                fileReader = null;
            } catch (Throwable th4) {
                closeable = null;
                th = th4;
                fileReader = null;
            }
            a(fileReader);
            a(closeable);
        }
        return this.p + "";
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
        } catch (Exception unused) {
            return str;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getNetType(Context context) {
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
        if (r3.equalsIgnoreCase("CDMA2000") != false) goto L25;
     */
    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getNetworkCatagory(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return 0;
            }
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
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getNetworkOperator(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (TextUtils.isEmpty(this.q)) {
                this.q = XAdSDKFoundationFacade.getInstance().getCommonUtils().b(telephonyManager.getNetworkOperator());
            }
            return this.q;
        } catch (Exception unused) {
            return this.q;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getNetworkOperatorName(Context context) {
        if (TextUtils.isEmpty(k)) {
            com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new x(this, (TelephonyManager) context.getSystemService("phone")));
        }
        return k;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    @SuppressLint({"DefaultLocale"})
    @TargetApi(3)
    public String getNetworkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) ? "none" : activeNetworkInfo.getType() == 1 ? "wifi" : activeNetworkInfo.getSubtypeName() != null ? activeNetworkInfo.getSubtypeName().toLowerCase() : "unknown";
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().i(e2);
            return "none";
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getPhoneOSBrand() {
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().b(Build.BRAND);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getPhoneOSBuildVersionSdk() {
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().b(Build.VERSION.SDK);
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
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getSnFrom(Context context) {
        return this.m + this.n;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public List<String[]> getWIFI(Context context) {
        return f8565b;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getWifiConnected(Context context) {
        return "";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public JSONArray getWifiScans(Context context) {
        return f8566c;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public Boolean is3GConnected(Context context) {
        return a(context, 0);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public boolean isCurrentNetworkAvailable(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("isCurrentNetworkAvailable", e2);
            return false;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    @TargetApi(4)
    public boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public boolean isUseOldStoragePath() {
        return Build.VERSION.SDK_INT < 23;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public Boolean isWifiConnected(Context context) {
        return a(context, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 6) {
            int length = str.length();
            do {
                length--;
                if (length >= 0) {
                }
            } while (str.charAt(length) == '0');
            return false;
        }
        return true;
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

    @TargetApi(18)
    private long b(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return ((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024) / 1024;
        } catch (Exception unused) {
            return -1L;
        }
    }

    @TargetApi(18)
    private long a(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return ((statFs.getBlockCount() * statFs.getBlockSize()) / 1024) / 1024;
        } catch (Exception unused) {
            return -1L;
        }
    }

    private Boolean a(Context context, int i2) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            boolean z = true;
            if (context.checkCallingOrSelfPermission(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION) != 0) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().e(Utils.TAG, "no permission android.permission.ACCESS_NETWORK_STATE");
                return Boolean.FALSE;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != i2 || !activeNetworkInfo.isConnected()) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception unused) {
            return Boolean.FALSE;
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
        if (TextUtils.isEmpty(this.t) && this.u <= 2) {
            com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new z(this, context));
            return this.t;
        }
        return this.t;
    }
}
