package com.baidu.mobads.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.webkit.internal.ETAG;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class p implements IXAdSystemUtils {
    private String d;
    private String e;
    private String f;
    private String g;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f2448a = new JSONArray();
    private String b = "";
    private String c = "";
    private int h = -1;

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    @TargetApi(4)
    public boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getSnFrom(Context context) {
        return this.b + this.c;
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
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
        PackageManager packageManager = context.getPackageManager();
        if (XAdSDKFoundationFacade.getInstance().getCommonUtils().hasPermission(context, "android.permission.READ_PHONE_STATE")) {
            this.c = "1";
            String deviceId = getDeviceId(context);
            if (a(deviceId)) {
                String string = Settings.System.getString(context.getContentResolver(), "bd_setting_i");
                if (a(string)) {
                    this.b = "2";
                    return "";
                }
                this.b = "1";
                return string;
            }
            this.b = "0";
            return deviceId;
        }
        this.b = "1";
        String string2 = Settings.System.getString(context.getContentResolver(), "bd_setting_i");
        if (a(string2)) {
            this.b = "2";
            string2 = "";
        }
        try {
            String[] strArr = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            for (String str : strArr) {
                if (str.contains("android.permission.READ_PHONE_STATE")) {
                    this.c = "2";
                    return string2;
                }
                this.c = "0";
            }
            return string2;
        } catch (Exception e) {
            e.printStackTrace();
            return string2;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getSn(Context context) {
        try {
            if (TextUtils.isEmpty(this.d)) {
                String imei = getIMEI(context);
                if (TextUtils.isEmpty(imei)) {
                    imei = getMacAddress(context);
                }
                this.d = XAdSDKFoundationFacade.getInstance().getCommonUtils().b(imei);
            }
            return this.d;
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getCUID(Context context) {
        return b.a(context);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public double[] getGPS(Context context) {
        double[] dArr;
        Location lastKnownLocation;
        try {
            Object a2 = XAdSDKFoundationFacade.getInstance().getCommonUtils().a("SYSGPS");
            if (a2 != null) {
                return (double[]) a2;
            }
        } catch (Exception e) {
            m.a().e(e);
        }
        if (XAdSDKFoundationFacade.getInstance().getCommonUtils().hasPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
            try {
                lastKnownLocation = ((LocationManager) context.getSystemService("location")).getLastKnownLocation("gps");
            } catch (Exception e2) {
                dArr = null;
            }
            if (lastKnownLocation != null) {
                dArr = new double[3];
                try {
                    dArr[0] = lastKnownLocation.getTime();
                    dArr[1] = lastKnownLocation.getLongitude();
                    dArr[2] = lastKnownLocation.getLatitude();
                } catch (Exception e3) {
                }
                XAdSDKFoundationFacade.getInstance().getCommonUtils().a("SYSGPS", dArr);
                return dArr;
            }
        }
        dArr = null;
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a("SYSGPS", dArr);
        return dArr;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getGUID(Context context) {
        try {
            if (this.e == null && context != null) {
                e commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
                this.e = context.getSharedPreferences("__x_adsdk_agent_header__", 0).getString("guid", "");
                if (this.e == null || this.e.length() <= 0) {
                    this.e = commonUtils.md5(getMacAddress(context) + ETAG.ITEM_SEPARATOR + getIMEI(context) + "&&");
                    if (this.e == null || this.e.length() <= 0) {
                        return "";
                    }
                    context.getSharedPreferences("__x_adsdk_agent_header__", 0).edit().putString("guid", this.e).commit();
                }
                return this.e;
            }
            return this.e;
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getAndroidId(Context context) {
        try {
            if (TextUtils.isEmpty(this.f)) {
                this.f = XAdSDKFoundationFacade.getInstance().getCommonUtils().b(Settings.Secure.getString(context.getContentResolver(), "android_id"));
            }
            return this.f;
        } catch (Exception e) {
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
        } catch (Exception e) {
            m.a().e(e);
        }
        if (Environment.getExternalStorageState().equals("mounted")) {
            String str = "";
            try {
                str = getAvailableExternalMemorySize() + "," + getAllExternalMemorySize();
                XAdSDKFoundationFacade.getInstance().getCommonUtils().a("sysSdc", str);
                return str;
            } catch (Exception e2) {
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
        } catch (Exception e) {
            m.a().e(e);
        }
        String str = "";
        try {
            str = getAvailableInternalMemorySize() + "," + getAllInternalMemorySize();
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a("sysMem", str);
            return str;
        } catch (Exception e2) {
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
        } catch (Exception e) {
            return -1L;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public long getAllInternalMemorySize() {
        try {
            return a(Environment.getDataDirectory());
        } catch (Exception e) {
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
        } catch (Exception e) {
            return -1L;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public long getAvailableInternalMemorySize() {
        try {
            return b(Environment.getDataDirectory());
        } catch (Exception e) {
            return -1L;
        }
    }

    @TargetApi(18)
    private long a(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return ((statFs.getBlockSize() * statFs.getBlockCount()) / 1024) / 1024;
        } catch (Exception e) {
            return -1L;
        }
    }

    @TargetApi(18)
    private long b(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return ((statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1024) / 1024;
        } catch (Exception e) {
            return -1L;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getMacAddress(Context context) {
        if (TextUtils.isEmpty(this.g)) {
            IXAdLogger adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
            e commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (commonUtils.hasPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                    this.g = XAdSDKFoundationFacade.getInstance().getCommonUtils().b(wifiManager.getConnectionInfo().getMacAddress());
                } else {
                    adLogger.e("", "Could not get mac address. no android.permission.ACCESS_WIFI_STATE");
                }
            } catch (Exception e) {
                adLogger.e("", "Could not get mac address." + e.toString());
            }
        }
        return this.g;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007c -> B:32:0x0015). Please submit an issue!!! */
    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    @TargetApi(3)
    public String getIp(Context context) {
        String str;
        String str2 = "";
        if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() == null) {
            return "";
        }
        try {
            str2 = Formatter.formatIpAddress(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress());
        } catch (SocketException e) {
        } catch (Exception e2) {
        }
        if (!TextUtils.isEmpty(str2)) {
            str = "0.0.0.0".equals(str2) ? "" : str2;
        } else {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            loop0: while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && !nextElement.isLinkLocalAddress() && nextElement.isSiteLocalAddress() && (nextElement instanceof Inet4Address)) {
                        str = nextElement.getHostAddress();
                        break loop0;
                    }
                }
            }
            str = str2;
        }
        return str;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getMaxCpuFreq() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        IXAdLogger adLogger;
        FileReader fileReader2 = null;
        if (this.h < 0) {
            try {
                fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
                try {
                    bufferedReader = new BufferedReader(fileReader);
                    try {
                        this.h = Integer.parseInt(bufferedReader.readLine().trim()) / 1000;
                        try {
                            fileReader.close();
                            bufferedReader.close();
                        } catch (IOException e) {
                            e = e;
                            adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                            adLogger.d(e);
                            return this.h + "";
                        }
                    } catch (Exception e2) {
                        e = e2;
                        fileReader2 = fileReader;
                        try {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
                            try {
                                fileReader2.close();
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e = e3;
                                adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                                adLogger.d(e);
                                return this.h + "";
                            }
                            return this.h + "";
                        } catch (Throwable th) {
                            th = th;
                            fileReader = fileReader2;
                            try {
                                fileReader.close();
                                bufferedReader.close();
                            } catch (IOException e4) {
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d(e4);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileReader.close();
                        bufferedReader.close();
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    bufferedReader = null;
                    fileReader2 = fileReader;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (Exception e6) {
                e = e6;
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                fileReader = null;
            }
        }
        return this.h + "";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getNetworkOperatorName(Context context) {
        if (TextUtils.isEmpty(this.i)) {
            try {
                e commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                String simOperatorName = telephonyManager.getSimOperatorName();
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty(simOperatorName)) {
                    sb.append(simOperatorName);
                } else {
                    String networkOperatorName = telephonyManager.getNetworkOperatorName();
                    if (!TextUtils.isEmpty(networkOperatorName)) {
                        sb.append(networkOperatorName);
                    } else {
                        return "";
                    }
                }
                sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                String simOperator = telephonyManager.getSimOperator();
                if (!TextUtils.isEmpty(simOperator)) {
                    sb.append(simOperator);
                }
                if (sb.length() > 1) {
                    this.i = commonUtils.getTextEncoder(sb.toString());
                }
            } catch (Exception e) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().e("Get operator failed", "");
            }
        }
        return this.i;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getNetworkOperator(Context context) {
        try {
            if (TextUtils.isEmpty(this.j)) {
                this.j = XAdSDKFoundationFacade.getInstance().getCommonUtils().b(((TelephonyManager) context.getSystemService("phone")).getNetworkOperator());
            }
            return this.j;
        } catch (Exception e) {
            return this.j;
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
        Exception e;
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
        String str;
        String str2 = "";
        try {
            str2 = PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && networkInfo.isAvailable()) {
                str = networkInfo.getExtraInfo() + str2;
            } else {
                str = (networkInfo2 == null || !networkInfo2.isAvailable()) ? str2 : "wifi" + str2;
            }
            return str;
        } catch (Exception e) {
            String str3 = str2;
            m.a().e(e);
            return str3;
        }
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
        } catch (Exception e) {
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

    private Boolean a(Context context, int i) {
        try {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().e("Utils", "no permission android.permission.ACCESS_NETWORK_STATE");
                return false;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return Boolean.valueOf(activeNetworkInfo != null && activeNetworkInfo.getType() == i && activeNetworkInfo.isConnected());
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getDeviceId(Context context) {
        if (TextUtils.isEmpty(this.k) && context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("__x_adsdk_agent_header__", 0);
            String string = sharedPreferences.getString(XAdSDKFoundationFacade.getInstance().getBase64().decodeStr("pyd-pifb"), "");
            if (!TextUtils.isEmpty(string)) {
                this.k = string;
            } else {
                try {
                    String decodeStr = XAdSDKFoundationFacade.getInstance().getBase64().decodeStr("uvNYwANvpyP-iyfb");
                    String str = (String) XAdSDKFoundationFacade.getInstance().getCommonUtils().a((TelephonyManager) context.getApplicationContext().getSystemService("phone"), decodeStr, new Object[0]);
                    if (!TextUtils.isEmpty(str)) {
                        new Thread(new q(this, sharedPreferences, str)).start();
                        this.k = str;
                    }
                } catch (Exception e) {
                    m.a().d(e);
                }
            }
        }
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().b(this.k);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getEncodedSN(Context context) {
        try {
            if (TextUtils.isEmpty(this.l)) {
                this.l = XAdSDKFoundationFacade.getInstance().getBase64().encode(getSn(context));
            }
            return this.l;
        } catch (Exception e) {
            return this.l;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getPhoneOSBrand() {
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().b(Build.BRAND);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public List<String[]> getCell(Context context) {
        try {
            Object a2 = XAdSDKFoundationFacade.getInstance().getCommonUtils().a("cell");
            if (a2 != null) {
                return (List) a2;
            }
        } catch (Exception e) {
            m.a().e(e);
        }
        ArrayList arrayList = new ArrayList();
        try {
            CellLocation cellLocation = ((TelephonyManager) context.getSystemService("phone")).getCellLocation();
            if (cellLocation != null) {
                String[] strArr = new String[3];
                if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    strArr[0] = gsmCellLocation.getCid() + "";
                    strArr[1] = gsmCellLocation.getLac() + "";
                    strArr[2] = "0";
                } else {
                    String[] split = cellLocation.toString().replace("[", "").replace("]", "").split(",");
                    strArr[0] = split[0];
                    strArr[1] = split[3];
                    strArr[2] = split[4];
                }
                arrayList.add(strArr);
            }
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a("cell", arrayList);
        } catch (Exception e2) {
        }
        return arrayList;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public List<String[]> getWIFI(Context context) {
        e commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        try {
            Object a2 = commonUtils.a("wifi");
            if (a2 != null) {
                return (List) a2;
            }
        } catch (Exception e) {
            m.a().e(e);
        }
        ArrayList arrayList = new ArrayList();
        try {
            if (commonUtils.hasPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager.isWifiEnabled()) {
                    List<ScanResult> scanResults = wifiManager.getScanResults();
                    Collections.sort(scanResults, new r(this));
                    for (int i = 0; i < scanResults.size() && i < 5; i++) {
                        ScanResult scanResult = scanResults.get(i);
                        arrayList.add(new String[]{scanResult.BSSID.replace(":", "").toLowerCase(Locale.getDefault()), Math.abs(scanResult.level) + ""});
                    }
                }
            }
        } catch (Exception e2) {
            m.a().e(e2);
        }
        commonUtils.a("wifi", arrayList);
        return arrayList;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public boolean canSupportSdcardStroage(Context context) {
        try {
            if (!XAdSDKFoundationFacade.getInstance().getCommonUtils().hasPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                if (isUseOldStoragePath()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public boolean isUseOldStoragePath() {
        return Build.VERSION.SDK_INT < 23;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getWifiConnected(Context context) {
        try {
            if (XAdSDKFoundationFacade.getInstance().getCommonUtils().hasPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                String ssid = connectionInfo.getSSID();
                if (ssid != null) {
                    if (ssid.length() > 2 && ssid.startsWith("\"") && ssid.endsWith("\"")) {
                        ssid = ssid.substring(1, ssid.length() - 1);
                    }
                } else {
                    ssid = "";
                }
                return connectionInfo.getBSSID() + "|" + XAdSDKFoundationFacade.getInstance().getBase64().encode(ssid);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
        return "";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public JSONArray getWifiScans(Context context) {
        try {
            Object a2 = XAdSDKFoundationFacade.getInstance().getCommonUtils().a("wifiScans");
            if (a2 != null) {
                return (JSONArray) a2;
            }
        } catch (Exception e) {
            m.a().e(e);
        }
        JSONArray jSONArray = new JSONArray();
        try {
            if (XAdSDKFoundationFacade.getInstance().getCommonUtils().hasPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager.isWifiEnabled()) {
                    List<ScanResult> scanResults = wifiManager.getScanResults();
                    Collections.sort(scanResults, new s(this));
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= scanResults.size() || i2 >= 50) {
                            break;
                        }
                        ScanResult scanResult = scanResults.get(i2);
                        jSONArray.put(scanResult.BSSID + "|" + XAdSDKFoundationFacade.getInstance().getBase64().encode(scanResult.SSID));
                        i = i2 + 1;
                    }
                }
            }
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
        }
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a("wifiScans", jSONArray);
        return jSONArray;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public JSONArray getBackgroundBrowsers(Context context) {
        IXAdLogger adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
        String[] supportedBrowsers = XAdSDKFoundationFacade.getInstance().getAdConstants().getSupportedBrowsers();
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (packageManager.getLaunchIntentForPackage(runningAppProcessInfo.processName) != null && packageManager.getApplicationInfo(runningAppProcessInfo.processName, 128) != null) {
                    for (String str : supportedBrowsers) {
                        if (runningAppProcessInfo.processName.equals(str)) {
                            this.f2448a.put(runningAppProcessInfo.processName);
                        }
                    }
                }
            }
        } catch (Exception e) {
            adLogger.d(e);
        }
        adLogger.d("bgBrowsers:" + this.f2448a);
        return this.f2448a;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public HttpURLConnection getHttpConnection(Context context, String str, int i, int i2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i2);
                return httpURLConnection;
            } catch (Exception e) {
                return httpURLConnection;
            }
        } catch (Exception e2) {
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
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("isCurrentNetworkAvailable", e);
            return false;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public String getCurrentProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            if (this.m == null) {
                int myPid = Process.myPid();
                ActivityManager activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
                if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.pid == myPid) {
                            this.m = runningAppProcessInfo.processName;
                        }
                    }
                }
            }
            return this.m;
        } catch (Exception e) {
            return this.m;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdSystemUtils
    public int getCurrentProcessId(Context context) {
        try {
            return Process.myPid();
        } catch (Exception e) {
            return 0;
        }
    }
}
