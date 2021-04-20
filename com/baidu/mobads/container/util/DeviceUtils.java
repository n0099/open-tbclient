package com.baidu.mobads.container.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.service.PluginLoader;
import com.baidu.tbadk.core.util.FieldBuilder;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DeviceUtils {
    public static final String APPSID = "BaiduMobAd_APP_ID";
    public static final String KEY_DEVICE_ID_STRING = "uANvpyP-pyfb";
    public static final String KEY_OLD_NAME_STRING = "deviceid";
    public static final String KEY_SYS_CELL = "cell";
    public static final String KEY_TIME_LONG = "IA-Vuifb";
    public static final String X_ADSDK_AGENT_HEADER = "__x_adsdk_agent_header__";
    public static final DeviceUtils sDeviceUtils = new DeviceUtils();
    public String apinfo;
    public String appId;
    public String cells;
    public String mAndroidId;
    public String mAppSec;
    public String mCuid;
    public String mDeviceId;
    public String mEncodedCuid;
    public String mEncodedSn;
    public String mIMEI;
    public int mImei2Count;
    public String mInitAppsid;
    public String mSn;
    public long mLastUpdateTime = -1;
    public String mFrom = "";
    public String mHasPermission = "";
    public String mImei2 = "";

    public static /* synthetic */ int access$708(DeviceUtils deviceUtils) {
        int i = deviceUtils.mImei2Count;
        deviceUtils.mImei2Count = i + 1;
        return i;
    }

    public static DeviceUtils getInstance() {
        return sDeviceUtils;
    }

    private String getMetaData(Context context, String str) {
        String str2;
        String str3 = "";
        try {
            str2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str) + "";
        } catch (Exception unused) {
        }
        try {
            if (str2.trim().equals("")) {
                throw new Exception();
            }
            return str2;
        } catch (Exception unused2) {
            str3 = str2;
            return str3;
        }
    }

    public String createRequestId(Context context, String str) {
        return EncryptUtils.getMD5(getIMEI(context) + getAppId(context) + str + System.currentTimeMillis());
    }

    public String getAndroidId(Context context) {
        try {
            if (PermissionUtils.hasPermission("permission_read_phone_state")) {
                if (TextUtils.isEmpty(this.mAndroidId)) {
                    String string = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
                    if (TextUtils.isEmpty(string)) {
                        string = "";
                    }
                    this.mAndroidId = string;
                }
                return this.mAndroidId;
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public String getAppId(Context context) {
        try {
            String appsid = AppConfigImp.getInstance().getAppsid();
            this.appId = appsid;
            if (TextUtils.isEmpty(appsid)) {
                this.appId = this.mInitAppsid;
            }
            if (TextUtils.isEmpty(this.appId)) {
                this.appId = getMetaData(context, "BaiduMobAd_APP_ID");
            }
            return this.appId;
        } catch (Exception unused) {
            return "";
        }
    }

    public String getAppSec(Context context) {
        setAppSec(getAppId(context));
        return this.mAppSec;
    }

    public String getBaiduMapsInfo(final Context context) {
        final String appPackage = AppUtils.getAppPackage(context);
        if (TextUtils.isEmpty(this.apinfo)) {
            TaskScheduler.getInstance().submit(new BaseTask<Object>() { // from class: com.baidu.mobads.container.util.DeviceUtils.4
                @Override // com.baidu.mobads.container.executor.BaseTask
                public Object doInBackground() {
                    try {
                        DeviceUtils.this.apinfo = PluginLoader.getLocation(context, appPackage);
                        return null;
                    } catch (Throwable th) {
                        RemoteXAdLogger.getInstance().e(th);
                        return null;
                    }
                }
            });
        }
        return this.apinfo;
    }

    public String getCUID(final Context context) {
        if (TextUtils.isEmpty(this.mCuid)) {
            TaskScheduler.getInstance().submit(new BaseTask<String>() { // from class: com.baidu.mobads.container.util.DeviceUtils.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.mobads.container.executor.BaseTask
                public String doInBackground() {
                    try {
                        String string = Settings.System.getString(context.getContentResolver(), "com.baidu.deviceid");
                        if (!TextUtils.isEmpty(string)) {
                            String string2 = Settings.System.getString(context.getContentResolver(), "bd_setting_i");
                            if (TextUtils.isEmpty(string2)) {
                                string2 = "0";
                            }
                            String stringBuffer = new StringBuffer(string2).reverse().toString();
                            DeviceUtils deviceUtils = DeviceUtils.this;
                            deviceUtils.mCuid = string + FieldBuilder.SE + stringBuffer;
                        }
                    } catch (Throwable unused) {
                        DeviceUtils.this.mCuid = "";
                    }
                    return TextUtils.isEmpty(DeviceUtils.this.mCuid) ? "" : DeviceUtils.this.mCuid;
                }
            });
        }
        return TextUtils.isEmpty(this.mCuid) ? "" : this.mCuid;
    }

    public String getCell(Context context) {
        if (!PermissionUtils.hasPermission("permission_location")) {
            this.cells = "";
            return "";
        }
        if (TextUtils.isEmpty(this.cells)) {
            try {
                final CellLocation cellLocation = ((TelephonyManager) context.getSystemService("phone")).getCellLocation();
                TaskScheduler.getInstance().submit(new BaseTask<Object>() { // from class: com.baidu.mobads.container.util.DeviceUtils.3
                    @Override // com.baidu.mobads.container.executor.BaseTask
                    public Object doInBackground() {
                        try {
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
                                DeviceUtils.this.cells = TextUtils.join("_", strArr);
                            }
                        } catch (Throwable unused) {
                        }
                        return DeviceUtils.this.cells;
                    }
                });
            } catch (Throwable unused) {
            }
        }
        return this.cells;
    }

    public String getChannelId() {
        return "";
    }

    public String getDeviceId(Context context) {
        String str;
        if (PermissionUtils.hasPermission("permission_read_phone_state") && PermissionUtils.checkPermission(context, "android.permission.READ_PHONE_STATE")) {
            if (TextUtils.isEmpty(this.mDeviceId) && context != null) {
                try {
                    SPUtils sPUtils = new SPUtils(context, X_ADSDK_AGENT_HEADER);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.mLastUpdateTime < 0) {
                        long longValue = Long.valueOf(sPUtils.getLong(KEY_TIME_LONG, 0L)).longValue();
                        this.mLastUpdateTime = longValue;
                        if (longValue == 0 && sPUtils.contains(KEY_OLD_NAME_STRING)) {
                            String string = sPUtils.getString(KEY_OLD_NAME_STRING, "");
                            sPUtils.remove(KEY_OLD_NAME_STRING);
                            if (!isImeiInvalid(string)) {
                                sPUtils.putString(KEY_DEVICE_ID_STRING, Base64.encode(string));
                            }
                        }
                        str = Base64.decodeStr(sPUtils.getString(KEY_DEVICE_ID_STRING, ""));
                        if (!isImeiInvalid(str)) {
                            this.mDeviceId = str;
                        }
                    } else {
                        str = "";
                    }
                    if (currentTimeMillis - this.mLastUpdateTime > 129600000 && Build.VERSION.SDK_INT < 29) {
                        String str2 = (String) ReflectionUtils.invoke((TelephonyManager) context.getApplicationContext().getSystemService("phone"), Base64.decodeStr("uvNYwANvpyP-iyfb"), new Object[0]);
                        this.mLastUpdateTime = currentTimeMillis;
                        sPUtils.putLong(KEY_TIME_LONG, currentTimeMillis);
                        if (!isImeiInvalid(str2) && !str2.equals(str)) {
                            sPUtils.putString(KEY_DEVICE_ID_STRING, Base64.encode(str2));
                            this.mDeviceId = str2;
                        }
                    }
                } catch (Throwable th) {
                    RemoteXAdLogger.getInstance().d(th);
                }
            }
            return TextUtils.isEmpty(this.mDeviceId) ? "" : this.mDeviceId;
        }
        return "";
    }

    public String getEncodedCUID(Context context) {
        try {
            if (TextUtils.isEmpty(this.mEncodedCuid)) {
                this.mEncodedCuid = Base64.encode(getCUID(context));
            }
            return this.mEncodedCuid;
        } catch (Exception unused) {
            return this.mEncodedCuid;
        }
    }

    public String getEncodedSN(Context context) {
        try {
            if (TextUtils.isEmpty(this.mEncodedSn)) {
                this.mEncodedSn = Base64.encode(getSn(context));
            }
            return this.mEncodedSn;
        } catch (Exception unused) {
            return this.mEncodedSn;
        }
    }

    public String getGPS(Context context) {
        return "";
    }

    public String getIMEI(Context context) {
        if (PermissionUtils.hasPermission("permission_read_phone_state")) {
            if (TextUtils.isEmpty(this.mIMEI)) {
                final Context applicationContext = context.getApplicationContext();
                if (PermissionUtils.checkPermission(applicationContext, "android.permission.READ_PHONE_STATE")) {
                    this.mHasPermission = "1";
                    String deviceId = getDeviceId(applicationContext);
                    if (!isImeiInvalid(deviceId)) {
                        this.mFrom = "0";
                        this.mIMEI = deviceId;
                        return deviceId;
                    }
                }
                TaskScheduler.getInstance().submit(new BaseTask<String>() { // from class: com.baidu.mobads.container.util.DeviceUtils.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
                        r7.this$0.mHasPermission = "2";
                     */
                    @Override // com.baidu.mobads.container.executor.BaseTask
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public String doInBackground() {
                        try {
                            DeviceUtils.this.mFrom = "1";
                            String string = Settings.System.getString(applicationContext.getContentResolver(), "bd_setting_i");
                            if (DeviceUtils.this.isImeiInvalid(string)) {
                                DeviceUtils.this.mFrom = "2";
                                string = "";
                            }
                            try {
                                String[] strArr = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 4096).requestedPermissions;
                                int i = 0;
                                while (true) {
                                    if (i >= strArr.length) {
                                        break;
                                    } else if (strArr[i].contains("android.permission.READ_PHONE_STATE")) {
                                        break;
                                    } else {
                                        DeviceUtils.this.mHasPermission = "0";
                                        i++;
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                            DeviceUtils.this.mIMEI = string;
                        } catch (Throwable unused2) {
                            DeviceUtils.this.mIMEI = "";
                        }
                        return DeviceUtils.this.mIMEI;
                    }
                });
            }
            return this.mIMEI;
        }
        return "";
    }

    public String getIMEI2(final Context context) {
        if (TextUtils.isEmpty(this.mImei2) && this.mImei2Count <= 2) {
            TaskScheduler.getInstance().submit(new BaseTask<Object>() { // from class: com.baidu.mobads.container.util.DeviceUtils.5
                @Override // com.baidu.mobads.container.executor.BaseTask
                public Object doInBackground() {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        DeviceUtils.this.mImei2 = telephonyManager.getClass().getDeclaredMethod("getImei", Integer.TYPE).invoke(telephonyManager, 1).toString();
                        DeviceUtils.access$708(DeviceUtils.this);
                    } catch (Throwable unused) {
                    }
                    return DeviceUtils.this.mImei2;
                }
            });
            return this.mImei2;
        }
        return this.mImei2;
    }

    @TargetApi(3)
    public String getIp(Context context) {
        return "";
    }

    public String getLocationInfo(Context context) {
        return getBaiduMapsInfo(context);
    }

    public String getPhoneOSBrand() {
        return Build.BRAND;
    }

    public String getPhoneOSBuildVersionSdk() {
        return Build.VERSION.SDK;
    }

    public String getSn(Context context) {
        try {
            if (TextUtils.isEmpty(this.mSn)) {
                String imei = getIMEI(context);
                if (TextUtils.isEmpty(imei)) {
                    imei = "";
                }
                this.mSn = imei;
            }
            return this.mSn;
        } catch (Exception unused) {
            return "";
        }
    }

    public String getSnFrom(Context context) {
        return this.mFrom + this.mHasPermission;
    }

    public String getSubscriberId(Context context) {
        return "";
    }

    public String getWIFI(Context context) {
        return "";
    }

    public JSONArray getWifiScans(Context context) {
        return new JSONArray();
    }

    public boolean isAdbEnable(Context context) {
        return 17 <= Build.VERSION.SDK_INT ? 1 == Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) : 1 == Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0);
    }

    public boolean isImeiInvalid(String str) {
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

    @TargetApi(4)
    public boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public void setAppId(String str) {
        this.mInitAppsid = str;
    }

    public void setAppSec(String str) {
        this.mAppSec = str + "_cpr";
    }
}
