package com.baidu.mobads.container.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.service.PluginLoader;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DeviceUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APPSID = "BaiduMobAd_APP_ID";
    public static final String KEY_DEVICE_ID_STRING = "uANvpyP-pyfb";
    public static final String KEY_OLD_NAME_STRING = "deviceid";
    public static final String KEY_SYS_CELL = "cell";
    public static final String KEY_TIME_LONG = "IA-Vuifb";
    public static final String X_ADSDK_AGENT_HEADER = "__x_adsdk_agent_header__";
    public static final DeviceUtils sDeviceUtils;
    public transient /* synthetic */ FieldHolder $fh;
    public String apinfo;
    public String appId;
    public String cells;
    public String mAndroidId;
    public String mAppSec;
    public String mCuid;
    public String mDeviceId;
    public String mEncodedCuid;
    public String mEncodedSn;
    public String mFrom;
    public String mHasPermission;
    public String mIMEI;
    public String mImei2;
    public int mImei2Count;
    public String mInitAppsid;
    public long mLastUpdateTime;
    public String mSn;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(76600910, "Lcom/baidu/mobads/container/util/DeviceUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(76600910, "Lcom/baidu/mobads/container/util/DeviceUtils;");
                return;
            }
        }
        sDeviceUtils = new DeviceUtils();
    }

    public DeviceUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLastUpdateTime = -1L;
        this.mFrom = "";
        this.mHasPermission = "";
        this.mImei2 = "";
    }

    public static /* synthetic */ int access$708(DeviceUtils deviceUtils) {
        int i2 = deviceUtils.mImei2Count;
        deviceUtils.mImei2Count = i2 + 1;
        return i2;
    }

    public static DeviceUtils getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? sDeviceUtils : (DeviceUtils) invokeV.objValue;
    }

    private String getMetaData(Context context, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, this, context, str)) == null) {
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
        return (String) invokeLL.objValue;
    }

    public String createRequestId(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            return EncryptUtils.getMD5(getIMEI(context) + getAppId(context) + str + System.currentTimeMillis());
        }
        return (String) invokeLL.objValue;
    }

    public String getAndroidId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
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
        return (String) invokeL.objValue;
    }

    public String getAppId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
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
        return (String) invokeL.objValue;
    }

    public String getAppSec(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            setAppSec(getAppId(context));
            return this.mAppSec;
        }
        return (String) invokeL.objValue;
    }

    public String getBaiduMapsInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            String appPackage = AppUtils.getAppPackage(context);
            if (TextUtils.isEmpty(this.apinfo)) {
                TaskScheduler.getInstance().submit(new BaseTask<Object>(this, context, appPackage) { // from class: com.baidu.mobads.container.util.DeviceUtils.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DeviceUtils this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$packageName;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, appPackage};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                        this.val$packageName = appPackage;
                    }

                    @Override // com.baidu.mobads.container.executor.BaseTask
                    public Object doInBackground() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            try {
                                this.this$0.apinfo = PluginLoader.getLocation(this.val$context, this.val$packageName);
                                return null;
                            } catch (Throwable th) {
                                RemoteXAdLogger.getInstance().e(th);
                                return null;
                            }
                        }
                        return invokeV.objValue;
                    }
                });
            }
            return this.apinfo;
        }
        return (String) invokeL.objValue;
    }

    public String getCUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            if (TextUtils.isEmpty(this.mCuid)) {
                TaskScheduler.getInstance().submit(new BaseTask<String>(this, context) { // from class: com.baidu.mobads.container.util.DeviceUtils.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DeviceUtils this$0;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.mobads.container.executor.BaseTask
                    public String doInBackground() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            try {
                                String string = Settings.System.getString(this.val$context.getContentResolver(), "com.baidu.deviceid");
                                if (!TextUtils.isEmpty(string)) {
                                    String string2 = Settings.System.getString(this.val$context.getContentResolver(), "bd_setting_i");
                                    if (TextUtils.isEmpty(string2)) {
                                        string2 = "0";
                                    }
                                    String stringBuffer = new StringBuffer(string2).reverse().toString();
                                    DeviceUtils deviceUtils = this.this$0;
                                    deviceUtils.mCuid = string + "|" + stringBuffer;
                                }
                            } catch (Throwable unused) {
                                this.this$0.mCuid = "";
                            }
                            return TextUtils.isEmpty(this.this$0.mCuid) ? "" : this.this$0.mCuid;
                        }
                        return (String) invokeV.objValue;
                    }
                });
            }
            return TextUtils.isEmpty(this.mCuid) ? "" : this.mCuid;
        }
        return (String) invokeL.objValue;
    }

    public String getCell(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            if (!PermissionUtils.hasPermission("permission_location")) {
                this.cells = "";
                return "";
            }
            if (TextUtils.isEmpty(this.cells)) {
                try {
                    TaskScheduler.getInstance().submit(new BaseTask<Object>(this, ((TelephonyManager) context.getSystemService("phone")).getCellLocation()) { // from class: com.baidu.mobads.container.util.DeviceUtils.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DeviceUtils this$0;
                        public final /* synthetic */ CellLocation val$cellLocation;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r7};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$cellLocation = r7;
                        }

                        @Override // com.baidu.mobads.container.executor.BaseTask
                        public Object doInBackground() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                                try {
                                    if (this.val$cellLocation != null) {
                                        String[] strArr = new String[3];
                                        if (this.val$cellLocation instanceof GsmCellLocation) {
                                            GsmCellLocation gsmCellLocation = (GsmCellLocation) this.val$cellLocation;
                                            strArr[0] = gsmCellLocation.getCid() + "";
                                            strArr[1] = gsmCellLocation.getLac() + "";
                                            strArr[2] = "0";
                                        } else {
                                            String[] split = this.val$cellLocation.toString().replace(PreferencesUtil.LEFT_MOUNT, "").replace(PreferencesUtil.RIGHT_MOUNT, "").split(",");
                                            strArr[0] = split[0];
                                            strArr[1] = split[3];
                                            strArr[2] = split[4];
                                        }
                                        this.this$0.cells = TextUtils.join("_", strArr);
                                    }
                                } catch (Throwable unused) {
                                }
                                return this.this$0.cells;
                            }
                            return invokeV.objValue;
                        }
                    });
                } catch (Throwable unused) {
                }
            }
            return this.cells;
        }
        return (String) invokeL.objValue;
    }

    public String getChannelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "" : (String) invokeV.objValue;
    }

    public String getDeviceId(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
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
        return (String) invokeL.objValue;
    }

    public String getEncodedCUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
            try {
                if (TextUtils.isEmpty(this.mEncodedCuid)) {
                    this.mEncodedCuid = Base64.encode(getCUID(context));
                }
                return this.mEncodedCuid;
            } catch (Exception unused) {
                return this.mEncodedCuid;
            }
        }
        return (String) invokeL.objValue;
    }

    public String getEncodedSN(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) {
            try {
                if (TextUtils.isEmpty(this.mEncodedSn)) {
                    this.mEncodedSn = Base64.encode(getSn(context));
                }
                return this.mEncodedSn;
            } catch (Exception unused) {
                return this.mEncodedSn;
            }
        }
        return (String) invokeL.objValue;
    }

    public String getGPS(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public String getIMEI(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, context)) == null) {
            if (PermissionUtils.hasPermission("permission_read_phone_state")) {
                if (TextUtils.isEmpty(this.mIMEI)) {
                    Context applicationContext = context.getApplicationContext();
                    if (PermissionUtils.checkPermission(applicationContext, "android.permission.READ_PHONE_STATE")) {
                        this.mHasPermission = "1";
                        String deviceId = getDeviceId(applicationContext);
                        if (!isImeiInvalid(deviceId)) {
                            this.mFrom = "0";
                            this.mIMEI = deviceId;
                            return deviceId;
                        }
                    }
                    TaskScheduler.getInstance().submit(new BaseTask<String>(this, applicationContext) { // from class: com.baidu.mobads.container.util.DeviceUtils.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DeviceUtils this$0;
                        public final /* synthetic */ Context val$appContext;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, applicationContext};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$appContext = applicationContext;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
                            r7.this$0.mHasPermission = "2";
                         */
                        @Override // com.baidu.mobads.container.executor.BaseTask
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public String doInBackground() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                try {
                                    this.this$0.mFrom = "1";
                                    String string = Settings.System.getString(this.val$appContext.getContentResolver(), "bd_setting_i");
                                    if (this.this$0.isImeiInvalid(string)) {
                                        this.this$0.mFrom = "2";
                                        string = "";
                                    }
                                    try {
                                        String[] strArr = this.val$appContext.getPackageManager().getPackageInfo(this.val$appContext.getPackageName(), 4096).requestedPermissions;
                                        int i2 = 0;
                                        while (true) {
                                            if (i2 >= strArr.length) {
                                                break;
                                            } else if (strArr[i2].contains("android.permission.READ_PHONE_STATE")) {
                                                break;
                                            } else {
                                                this.this$0.mHasPermission = "0";
                                                i2++;
                                            }
                                        }
                                    } catch (Throwable unused) {
                                    }
                                    this.this$0.mIMEI = string;
                                } catch (Throwable unused2) {
                                    this.this$0.mIMEI = "";
                                }
                                return this.this$0.mIMEI;
                            }
                            return (String) invokeV.objValue;
                        }
                    });
                }
                return this.mIMEI;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public String getIMEI2(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) {
            if (TextUtils.isEmpty(this.mImei2) && this.mImei2Count <= 2) {
                TaskScheduler.getInstance().submit(new BaseTask<Object>(this, context) { // from class: com.baidu.mobads.container.util.DeviceUtils.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DeviceUtils this$0;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                    }

                    @Override // com.baidu.mobads.container.executor.BaseTask
                    public Object doInBackground() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            try {
                                TelephonyManager telephonyManager = (TelephonyManager) this.val$context.getSystemService("phone");
                                this.this$0.mImei2 = telephonyManager.getClass().getDeclaredMethod("getImei", Integer.TYPE).invoke(telephonyManager, 1).toString();
                                DeviceUtils.access$708(this.this$0);
                            } catch (Throwable unused) {
                            }
                            return this.this$0.mImei2;
                        }
                        return invokeV.objValue;
                    }
                });
                return this.mImei2;
            }
            return this.mImei2;
        }
        return (String) invokeL.objValue;
    }

    @TargetApi(3)
    public String getIp(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public String getLocationInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, context)) == null) ? getBaiduMapsInfo(context) : (String) invokeL.objValue;
    }

    public String getPhoneOSBrand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? Build.BRAND : (String) invokeV.objValue;
    }

    public String getPhoneOSBuildVersionSdk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? Build.VERSION.SDK : (String) invokeV.objValue;
    }

    public String getSn(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, context)) == null) {
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
        return (String) invokeL.objValue;
    }

    public String getSnFrom(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, context)) == null) {
            return this.mFrom + this.mHasPermission;
        }
        return (String) invokeL.objValue;
    }

    public String getSubscriberId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public String getWIFI(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public JSONArray getWifiScans(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, context)) == null) ? new JSONArray() : (JSONArray) invokeL.objValue;
    }

    public boolean isAdbEnable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, context)) == null) ? 17 <= Build.VERSION.SDK_INT ? 1 == Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) : 1 == Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) : invokeL.booleanValue;
    }

    public boolean isImeiInvalid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
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
        return invokeL.booleanValue;
    }

    @TargetApi(4)
    public boolean isTablet(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, context)) == null) ? (context.getResources().getConfiguration().screenLayout & 15) >= 3 : invokeL.booleanValue;
    }

    public void setAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.mInitAppsid = str;
        }
    }

    public void setAppSec(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.mAppSec = str + "_cpr";
        }
    }
}
