package com.baidu.mobads.sdk.api;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.sdk.internal.RemoteDexLoader;
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
    public static final String PERMISSION_LOCATION = "permission_location";
    public static final String PERMISSION_PHONE_STATE = "permission_read_phone_state";
    public static final String PERMISSION_STORAGE = "permission_storage";
    public static boolean mAccessAppListGranted = true;
    public static boolean mAccessLocationGranted;
    public static boolean mExternalStorageGranted;
    public static boolean mReadPhoneStateGranted;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static JSONObject getPermissionInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("permission_location", "" + mAccessLocationGranted);
                jSONObject.put("permission_storage", "" + mExternalStorageGranted);
                jSONObject.put("permission_app_list", "" + mAccessAppListGranted);
                jSONObject.put("permission_read_phone_state", "" + mReadPhoneStateGranted);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static void postPermissionInfoRemote() {
        IXAdContainerFactory containerFactory;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || (containerFactory = RemoteDexLoader.getInstance().getContainerFactory()) == null) {
            return;
        }
        containerFactory.onTaskDistribute("permission_module", getPermissionInfo());
    }

    public static void setPermissionAppList(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65540, null, z) == null) {
            mAccessAppListGranted = z;
            postPermissionInfoRemote();
        }
    }

    public static void setPermissionLocation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z) == null) {
            mAccessLocationGranted = z;
            postPermissionInfoRemote();
        }
    }

    public static void setPermissionReadDeviceID(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, null, z) == null) {
            mReadPhoneStateGranted = z;
            postPermissionInfoRemote();
        }
    }

    public static void setPermissionStorage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            mExternalStorageGranted = z;
            postPermissionInfoRemote();
        }
    }
}
