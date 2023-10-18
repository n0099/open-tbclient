package com.baidu.mobads.sdk.api;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.sdk.internal.au;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.az;
import com.baidu.mobads.sdk.internal.z;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MobadsPermissionSettings {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PERMISSION_APP_LIST = "permission_app_list";
    public static final String PERMISSION_APP_UPDATE = "permission_app_update";
    public static final String PERMISSION_DEVICE_INFO = "permission_device_info";
    public static final String PERMISSION_LIMIT_STATE = "permission_limitpersonalads";
    public static final String PERMISSION_LOCATION = "permission_location";
    public static final String PERMISSION_OAID = "permission_oaid";
    public static final String PERMISSION_PHONE_STATE = "permission_read_phone_state";
    public static final String PERMISSION_RUNNING_APP = "permission_running_app";
    public static final String PERMISSION_STORAGE = "permission_storage";
    public static boolean mAccessAppListGranted = false;
    public static boolean mAccessLocationGranted = false;
    public static boolean mAppUpdateGranted = true;
    public static boolean mCheckSPLimit = false;
    public static boolean mDeviceInfoGranted = true;
    public static boolean mExternalStorageGranted = false;
    public static boolean mLimitPrivacyAds = false;
    public static boolean mOAIDGranted = true;
    public static boolean mReadPhoneStateGranted = false;
    public static boolean mRunningAppGranted = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(574596382, "Lcom/baidu/mobads/sdk/api/MobadsPermissionSettings;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(574596382, "Lcom/baidu/mobads/sdk/api/MobadsPermissionSettings;");
        }
    }

    public MobadsPermissionSettings() {
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

    public static JSONObject getLimitInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PERMISSION_LIMIT_STATE, mLimitPrivacyAds);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static boolean getLimitPersonalAdsStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            updateSPLimitTag();
            return mLimitPrivacyAds;
        }
        return invokeV.booleanValue;
    }

    public static void postLimitInfoRemote() {
        IXAdContainerFactory c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, null) == null) && (c = z.a().c()) != null) {
            c.onTaskDistribute(az.b, getLimitInfo());
        }
    }

    public static void postPermissionInfoRemote() {
        IXAdContainerFactory c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, null) == null) && (c = z.a().c()) != null) {
            c.onTaskDistribute(az.a, getPermissionInfo());
        }
    }

    public static JSONObject getPermissionInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PERMISSION_LOCATION, "" + mAccessLocationGranted);
                jSONObject.put(PERMISSION_STORAGE, "" + mExternalStorageGranted);
                jSONObject.put(PERMISSION_APP_LIST, "" + mAccessAppListGranted);
                jSONObject.put(PERMISSION_PHONE_STATE, "" + mReadPhoneStateGranted);
                jSONObject.put(PERMISSION_OAID, "" + mOAIDGranted);
                jSONObject.put(PERMISSION_APP_UPDATE, "" + mAppUpdateGranted);
                jSONObject.put(PERMISSION_RUNNING_APP, "" + mRunningAppGranted);
                jSONObject.put(PERMISSION_DEVICE_INFO, "" + mDeviceInfoGranted);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static boolean handleIntegrationInfo(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bundle)) == null) {
            try {
                switchDebugLog(bundle);
                IXAdContainerFactory c = z.a().c();
                if (c != null) {
                    c.getRemoteParam("integrationInfo", bundle);
                    return true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void setLimitPersonalAds(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            mLimitPrivacyAds = z;
            postLimitInfoRemote();
        }
    }

    public static void setPermissionAppList(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            mAccessAppListGranted = z;
            postPermissionInfoRemote();
        }
    }

    public static void setPermissionAppUpdate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            mAppUpdateGranted = z;
            postPermissionInfoRemote();
        }
    }

    public static void setPermissionDeviceInfo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            mDeviceInfoGranted = z;
            postPermissionInfoRemote();
        }
    }

    public static void setPermissionLocation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            mAccessLocationGranted = z;
            postPermissionInfoRemote();
        }
    }

    public static void setPermissionOAID(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, null, z) == null) {
            mOAIDGranted = z;
            postPermissionInfoRemote();
        }
    }

    public static void setPermissionReadDeviceID(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            mReadPhoneStateGranted = z;
            postPermissionInfoRemote();
        }
    }

    public static void setPermissionRunningApp(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, null, z) == null) {
            mRunningAppGranted = z;
            postPermissionInfoRemote();
        }
    }

    public static void setPermissionStorage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65552, null, z) == null) {
            mExternalStorageGranted = z;
            postPermissionInfoRemote();
        }
    }

    public static void switchDebugLog(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, bundle) == null) {
            if (bundle != null && bundle.containsKey("debug_mode")) {
                if (bundle.getBoolean("debug_mode")) {
                    av.a(true);
                } else {
                    av.a();
                }
            } else if (bundle != null && bundle.containsKey(au.b)) {
                if (bundle.getBoolean(au.b)) {
                    av.a((av.a) new au());
                } else {
                    av.i(au.b);
                }
            }
        }
    }

    public static void updateSPLimitTag() {
        z a;
        IXAdContainerFactory c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            try {
                if (!mCheckSPLimit && (a = z.a()) != null && (c = a.c()) != null) {
                    Object remoteParam = c.getRemoteParam("limitPersonalAds", new Object[0]);
                    if (remoteParam instanceof Boolean) {
                        mLimitPrivacyAds = ((Boolean) remoteParam).booleanValue();
                        mCheckSPLimit = true;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
