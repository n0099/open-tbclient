package com.baidu.searchbox.download.center.clearcache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\nJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00018\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0011\u0010\u000f\u001a\u0004\b\u0012\u0010\u0003R2\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u0013j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001`\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/DiskLevelUpdateDataUtils;", "", "getCurrentDiskLevel", "()Ljava/lang/String;", "Lorg/json/JSONObject;", "data", "", "saveData", "(Lorg/json/JSONObject;)V", "saveDefaultDate", "()V", "", "DEFAULT_DATA_VERSION", "I", "DEFAULT_VERSION", "Ljava/lang/String;", "DISK_MONITOR_VERSION", "defaultDatas", "getDefaultDatas", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "diskLevelDatas", "Ljava/util/LinkedHashMap;", "<init>", "lib-clearcache-base_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class DiskLevelUpdateDataUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_DATA_VERSION = 3;
    public static final String DEFAULT_VERSION = "0";
    public static final String DISK_MONITOR_VERSION = "disk_monitor_version";
    public static final DiskLevelUpdateDataUtils INSTANCE;
    public static final String defaultDatas;
    public static final LinkedHashMap<Integer, String> diskLevelDatas;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1386829239, "Lcom/baidu/searchbox/download/center/clearcache/DiskLevelUpdateDataUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1386829239, "Lcom/baidu/searchbox/download/center/clearcache/DiskLevelUpdateDataUtils;");
                return;
            }
        }
        INSTANCE = new DiskLevelUpdateDataUtils();
        diskLevelDatas = MapsKt__MapsKt.linkedMapOf(TuplesKt.to(24, "lt16"), TuplesKt.to(48, "eq32"), TuplesKt.to(96, "eq64"), TuplesKt.to(192, "eq128"));
        defaultDatas = "{\n                                    \"cleanupTimeout\": \"10\",\n                                    \"notifyDelayAfterStart\": \"120\",\n                                    \"diskCheckDuration\": \"1800\",\n                                    \"level\": {\n                                        \"appLimitSwitch\": \"0\",\n                                        \"lt16\": {\n                                            \"criticalLimit\": \"1600\",\n                                            \"waringLimit\": \"2400\",\n                                            \"appCriticalLimit\": \"2000\",\n                                            \"appWaringLimit\": \"1500\",\n                                            \"swing\": \"100\"\n                                        },\n                                        \"eq32\": {\n                                            \"criticalLimit\": \"3200\",\n                                            \"waringLimit\": \"4800\",\n                                            \"appCriticalLimit\": \"2000\",\n                                            \"appWaringLimit\": \"1500\",\n                                            \"swing\": \"100\"\n                                        },\n                                        \"eq64\": {\n                                            \"criticalLimit\": \"5000\",\n                                            \"waringLimit\": \"9600\",\n                                            \"appCriticalLimit\": \"2000\",\n                                            \"appWaringLimit\": \"1500\",\n                                            \"swing\": \"100\"\n                                        },\n                                        \"eq128\": {\n                                            \"criticalLimit\": \"5000\",\n                                            \"waringLimit\": \"15000\",\n                                            \"appCriticalLimit\": \"2000\",\n                                            \"appWaringLimit\": \"1500\",\n                                            \"swing\": \"100\"\n                                        },\n                                        \"gt256\": {\n                                            \"criticalLimit\": \"5000\",\n                                            \"waringLimit\": \"15000\",\n                                            \"appCriticalLimit\": \"2000\",\n                                            \"appWaringLimit\": \"1500\",\n                                            \"swing\": \"100\"\n                                        }\n                                    },\n                                    \"quota\": {\n                                        \"mnp\": {\n                                            \"normal\": \"500\",\n                                            \"warning\": \"400\",\n                                            \"critical\": \"300\"\n                                        },\n                                        \"live\": {\n                                            \"normal\": \"300\",\n                                            \"warning\": \"270\",\n                                            \"critical\": \"240\"\n                                        },\n                                        \"livevip\": {\n                                            \"normal\": \"700\",\n                                            \"warning\": \"600\",\n                                            \"critical\": \"500\"\n                                        },\n                                        \"ar\": {\n                                            \"normal\": \"170\",\n                                            \"warning\": \"130\",\n                                            \"critical\": \"100\"\n                                        },\n                                        \"playkernel\": {\n                                            \"normal\": \"100\",\n                                            \"warning\": \"100\",\n                                            \"critical\": \"100\"\n                                        },\n                                        \"browserkernel\": {\n                                            \"normal\": \"170\",\n                                            \"warning\": \"130\",\n                                            \"critical\": \"100\"\n                                        },\n                                        \"splash\": {\n                                            \"normal\": \"80\",\n                                            \"warning\": \"65\",\n                                            \"critical\": \"50\"\n                                        },\n                                        \"novel\": {\n                                            \"normal\": \"80\",\n                                            \"warning\": \"65\",\n                                            \"critical\": \"50\"\n                                        }\n                                    }\n                                }";
    }

    public DiskLevelUpdateDataUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final String getDefaultDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return defaultDatas;
        }
        return (String) invokeV.objValue;
    }

    private final String getCurrentDiskLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            long diskAllSizeByG = DiskManager.INSTANCE.getDiskAllSizeByG();
            for (Integer key : diskLevelDatas.keySet()) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                if (diskAllSizeByG <= key.intValue()) {
                    return diskLevelDatas.get(key);
                }
            }
            return "gt256";
        }
        return (String) invokeV.objValue;
    }

    public final synchronized void saveDefaultDate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (DiskManagerSharedPrefsUtils.INSTANCE.getInt(DiskManagerSharedPrefsUtils.SP_KEY_DEFAULT_DATA_VERSION, 0) != 3 && Intrinsics.areEqual(PreferenceUtils.getString("disk_monitor_version", "0"), "0")) {
                    try {
                        saveData(new JSONObject(defaultDatas));
                        DiskManagerSharedPrefsUtils.INSTANCE.putInt(DiskManagerSharedPrefsUtils.SP_KEY_DEFAULT_DATA_VERSION, 3);
                    } catch (JSONException e) {
                        if (AppConfig.isDebug()) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public final void saveData(JSONObject data) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            DiskManagerSharedPrefsUtils.INSTANCE.putLong(DiskManagerSharedPrefsUtils.SP_KEY_CLEANUP_TIMEOUT, data.optLong("cleanupTimeout"));
            DiskManagerSharedPrefsUtils.INSTANCE.putLong(DiskManagerSharedPrefsUtils.SP_KEY_NOTIFY_DELAYAFTERSTART, data.optLong("notifyDelayAfterStart"));
            DiskManagerSharedPrefsUtils.INSTANCE.putLong(DiskManagerSharedPrefsUtils.SP_KEY_DISK_CHECK_DURATION, data.optLong("diskCheckDuration"));
            JSONObject optJSONObject = data.optJSONObject("level");
            if (optJSONObject != null) {
                DiskManagerSharedPrefsUtils.INSTANCE.putString(DiskManagerSharedPrefsUtils.SP_KEY_APP_LIMIT_SWITCH, optJSONObject.optString("appLimitSwitch", "0"));
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(getCurrentDiskLevel());
                if (optJSONObject2 != null) {
                    DiskManagerSharedPrefsUtils.INSTANCE.putLong(DiskManagerSharedPrefsUtils.SP_KEY_CRITICAL_LIMIT, optJSONObject2.optLong("criticalLimit"));
                    DiskManagerSharedPrefsUtils.INSTANCE.putLong(DiskManagerSharedPrefsUtils.SP_KEY_WARING_LIMIT, optJSONObject2.optLong("waringLimit"));
                    DiskManagerSharedPrefsUtils.INSTANCE.putLong(DiskManagerSharedPrefsUtils.SP_KEY_APP_CRITICAL_LIMIT, optJSONObject2.optLong("appCriticalLimit"));
                    DiskManagerSharedPrefsUtils.INSTANCE.putLong(DiskManagerSharedPrefsUtils.SP_KEY_APP_WARING_LIMIT, optJSONObject2.optLong("appWaringLimit"));
                    DiskManagerSharedPrefsUtils.INSTANCE.putLong(DiskManagerSharedPrefsUtils.SP_KEY_DIFF, optJSONObject2.optLong("swing"));
                }
            }
            DiskManagerSharedPrefsUtils diskManagerSharedPrefsUtils = DiskManagerSharedPrefsUtils.INSTANCE;
            JSONObject optJSONObject3 = data.optJSONObject("quota");
            if (optJSONObject3 != null) {
                str = optJSONObject3.toString();
            } else {
                str = null;
            }
            diskManagerSharedPrefsUtils.putString(DiskManagerSharedPrefsUtils.SP_KEY_QUOTA_DATA, str);
        }
    }
}
