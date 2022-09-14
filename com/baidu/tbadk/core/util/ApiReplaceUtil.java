package com.baidu.tbadk.core.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.net.wifi.WifiInfo;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.dx4;
import com.baidu.tieba.np4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes3.dex */
public class ApiReplaceUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final Getter sGetter;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class Getter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<String, Object> cache;

        /* loaded from: classes3.dex */
        public interface Action<T> {
            boolean forceApi();

            @NonNull
            String provideKey();

            @Nullable
            T provideValue();
        }

        public Getter() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cache = new ConcurrentHashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkPrivacyPolicyOnDebug() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && np4.e() && !PermissionUtil.isAgreePrivacyPolicy()) {
                throw new IllegalStateException("未同意隐私协议前，禁止调用系统相关API");
            }
        }

        @Nullable
        public <T> T get(@NonNull Action<T> action) {
            InterceptResult invokeL;
            T t;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, action)) == null) {
                String provideKey = action.provideKey();
                if (action.forceApi() || (t = (T) this.cache.get(provideKey)) == null) {
                    checkPrivacyPolicyOnDebug();
                    T provideValue = action.provideValue();
                    this.cache.put(provideKey, provideValue);
                    return provideValue;
                }
                return t;
            }
            return (T) invokeL.objValue;
        }
    }

    @Keep
    /* loaded from: classes3.dex */
    public static class Overload {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Overload() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static String getString(ContentResolver contentResolver, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, contentResolver, str)) == null) ? (String) ApiReplaceUtil.sGetter.get(new Getter.Action<String>(str, contentResolver) { // from class: com.baidu.tbadk.core.util.ApiReplaceUtil.Overload.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String val$name;
                public final /* synthetic */ ContentResolver val$resolver;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, contentResolver};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$name = str;
                    this.val$resolver = contentResolver;
                }

                @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
                public boolean forceApi() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? !TextUtils.equals(HttpRequest.ANDROID_ID, this.val$name) : invokeV.booleanValue;
                }

                @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
                @NonNull
                public String provideKey() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return "getString4" + this.val$name;
                    }
                    return (String) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
                public String provideValue() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? Settings.Secure.getString(this.val$resolver, this.val$name) : (String) invokeV.objValue;
                }
            }) : (String) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1035830911, "Lcom/baidu/tbadk/core/util/ApiReplaceUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1035830911, "Lcom/baidu/tbadk/core/util/ApiReplaceUtil;");
                return;
            }
        }
        sGetter = new Getter();
    }

    public ApiReplaceUtil() {
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

    public static String getDeviceId(TelephonyManager telephonyManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, telephonyManager)) == null) ? (String) sGetter.get(new Getter.Action<String>(telephonyManager) { // from class: com.baidu.tbadk.core.util.ApiReplaceUtil.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TelephonyManager val$manager;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {telephonyManager};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$manager = telephonyManager;
            }

            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            public /* synthetic */ boolean forceApi() {
                return dx4.$default$forceApi(this);
            }

            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            @NonNull
            public String provideKey() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getDeviceId" : (String) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            @SuppressLint({"MissingPermission", "HardwareIds"})
            public String provideValue() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? this.val$manager.getDeviceId() : (String) invokeV.objValue;
            }
        }) : (String) invokeL.objValue;
    }

    public static byte[] getHardwareAddress(NetworkInterface networkInterface) throws SocketException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, networkInterface)) == null) {
            Object obj = sGetter.cache.get("getHardwareAddress");
            if (obj == null) {
                sGetter.checkPrivacyPolicyOnDebug();
                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                sGetter.cache.put("getHardwareAddress", hardwareAddress);
                return hardwareAddress;
            }
            return (byte[]) obj;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String getImei(TelephonyManager telephonyManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, telephonyManager)) == null) ? (String) sGetter.get(new Getter.Action<String>(telephonyManager) { // from class: com.baidu.tbadk.core.util.ApiReplaceUtil.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TelephonyManager val$manager;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {telephonyManager};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$manager = telephonyManager;
            }

            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            public /* synthetic */ boolean forceApi() {
                return dx4.$default$forceApi(this);
            }

            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            @NonNull
            public String provideKey() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getImei" : (String) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            @RequiresApi(api = 26)
            @SuppressLint({"MissingPermission"})
            public String provideValue() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? this.val$manager.getImei() : (String) invokeV.objValue;
            }
        }) : (String) invokeL.objValue;
    }

    public static String getMacAddress(WifiInfo wifiInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, wifiInfo)) == null) ? (String) sGetter.get(new Getter.Action<String>(wifiInfo) { // from class: com.baidu.tbadk.core.util.ApiReplaceUtil.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WifiInfo val$manager;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {wifiInfo};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$manager = wifiInfo;
            }

            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            public /* synthetic */ boolean forceApi() {
                return dx4.$default$forceApi(this);
            }

            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            @NonNull
            public String provideKey() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getMacAddress" : (String) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            @SuppressLint({"HardwareIds"})
            public String provideValue() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? this.val$manager.getMacAddress() : (String) invokeV.objValue;
            }
        }) : (String) invokeL.objValue;
    }

    public static List<ActivityManager.RunningAppProcessInfo> getRunningAppProcesses(ActivityManager activityManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, activityManager)) == null) ? (List) sGetter.get(new Getter.Action<List<ActivityManager.RunningAppProcessInfo>>(activityManager) { // from class: com.baidu.tbadk.core.util.ApiReplaceUtil.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ActivityManager val$manager;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {activityManager};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$manager = activityManager;
            }

            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            public /* synthetic */ boolean forceApi() {
                return dx4.$default$forceApi(this);
            }

            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            @NonNull
            public String provideKey() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getRunningAppProcesses" : (String) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            public List<ActivityManager.RunningAppProcessInfo> provideValue() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? this.val$manager.getRunningAppProcesses() : (List) invokeV.objValue;
            }
        }) : (List) invokeL.objValue;
    }

    public static String getSimSerialNumber(TelephonyManager telephonyManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, telephonyManager)) == null) ? (String) sGetter.get(new Getter.Action<String>(telephonyManager) { // from class: com.baidu.tbadk.core.util.ApiReplaceUtil.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TelephonyManager val$manager;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {telephonyManager};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$manager = telephonyManager;
            }

            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            public /* synthetic */ boolean forceApi() {
                return dx4.$default$forceApi(this);
            }

            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            @NonNull
            public String provideKey() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getSimSerialNumber" : (String) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            @SuppressLint({"MissingPermission", "HardwareIds"})
            public String provideValue() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? this.val$manager.getSimSerialNumber() : (String) invokeV.objValue;
            }
        }) : (String) invokeL.objValue;
    }

    public static String getString(ContentResolver contentResolver, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, contentResolver, str)) == null) ? (String) sGetter.get(new Getter.Action<String>(str, contentResolver) { // from class: com.baidu.tbadk.core.util.ApiReplaceUtil.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String val$name;
            public final /* synthetic */ ContentResolver val$resolver;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, contentResolver};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$name = str;
                this.val$resolver = contentResolver;
            }

            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            public boolean forceApi() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? !TextUtils.equals(HttpRequest.ANDROID_ID, this.val$name) : invokeV.booleanValue;
            }

            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            @NonNull
            public String provideKey() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return "getString4" + this.val$name;
                }
                return (String) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            public String provideValue() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? Settings.System.getString(this.val$resolver, this.val$name) : (String) invokeV.objValue;
            }
        }) : (String) invokeLL.objValue;
    }

    public static String getSubscriberId(TelephonyManager telephonyManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, telephonyManager)) == null) ? (String) sGetter.get(new Getter.Action<String>(telephonyManager) { // from class: com.baidu.tbadk.core.util.ApiReplaceUtil.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TelephonyManager val$manager;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {telephonyManager};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$manager = telephonyManager;
            }

            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            public /* synthetic */ boolean forceApi() {
                return dx4.$default$forceApi(this);
            }

            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            @NonNull
            public String provideKey() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getSubscriberId" : (String) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.util.ApiReplaceUtil.Getter.Action
            @SuppressLint({"MissingPermission", "HardwareIds"})
            public String provideValue() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? this.val$manager.getSubscriberId() : (String) invokeV.objValue;
            }
        }) : (String) invokeL.objValue;
    }
}
