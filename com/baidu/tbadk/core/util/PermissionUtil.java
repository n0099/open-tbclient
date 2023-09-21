package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.permissionhelper.ApiUtil;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.permissionhelper.context.ContextCompat;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.tbadk.GrowthStatsUtil;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.mainentrance.MainEntrance;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.event.PrivacyPolicyEvent;
import com.baidu.tieba.ax5;
import com.baidu.tieba.cta;
import com.baidu.tieba.cy5;
import com.baidu.tieba.dx5;
import com.baidu.tieba.fq5;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.rw5;
import com.baidu.tieba.ysa;
import com.baidu.tieba.yx5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kuaishou.weapon.p0.h;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes4.dex */
public class PermissionUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PermissionUtil";
    public static boolean isAgreePrivacyPolicy;
    public static boolean isBrowseMode;
    public static boolean isSdkInited;
    public static String localMacAddress;
    public static fq5 mAgreePrivacyPolicyEventListener;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(115782922, "Lcom/baidu/tbadk/core/util/PermissionUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(115782922, "Lcom/baidu/tbadk/core/util/PermissionUtil;");
                return;
            }
        }
        mAgreePrivacyPolicyEventListener = new fq5<PrivacyPolicyEvent>() { // from class: com.baidu.tbadk.core.util.PermissionUtil.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.fq5
            public boolean onEvent(PrivacyPolicyEvent privacyPolicyEvent) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, privacyPolicyEvent)) == null) {
                    if (privacyPolicyEvent != null) {
                        boolean unused = PermissionUtil.isAgreePrivacyPolicy = privacyPolicyEvent.isAgreePrivacyPolicy;
                        if (!PermissionUtil.isSdkInited) {
                            boolean unused2 = PermissionUtil.isSdkInited = PermissionUtil.isAgreePrivacyPolicy;
                            if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
                                PermissionUtil.doApplicationInit();
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921554));
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return invokeL.booleanValue;
            }
        };
    }

    public PermissionUtil() {
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

    public static void doApplicationInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            TbadkCoreApplication.getInst().doBeforeSuperOnCreate();
            TbadkCoreApplication.getInst().doAfterSuperOnCreate();
        }
    }

    public static void doBrowseModeAgreePrivacy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            cy5.b(new yx5<Object>() { // from class: com.baidu.tbadk.core.util.PermissionUtil.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.tieba.yx5
                public Object doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        cta.b();
                        return null;
                    }
                    return invokeV.objValue;
                }
            }, new dx5<Object>() { // from class: com.baidu.tbadk.core.util.PermissionUtil.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.tieba.dx5
                public void onReturnDataInUI(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        PermissionUtil.setIsAgreePrivacyPolicy(true);
                        ysa.b(true);
                    }
                }
            });
        }
    }

    public static void doBrowseModeInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, null) == null) {
            setIsBrowseMode(true);
            doApplicationInit();
        }
    }

    public static boolean isAgreePrivacyPolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            if (isAgreePrivacyPolicy) {
                return true;
            }
            try {
                isAgreePrivacyPolicy = SharedPrefHelper.getInstance().getBoolean("key_secret_is_show_new", false);
            } catch (Exception e) {
                BdLog.e(e);
            }
            return isAgreePrivacyPolicy;
        }
        return invokeV.booleanValue;
    }

    public static boolean isBrowseMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            return isBrowseMode;
        }
        return invokeV.booleanValue;
    }

    public static void registerMutiProcessPrivacyPolicy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, null) == null) {
            MutiProcessManager.getInstance().registerForeverListener(PrivacyPolicyEvent.class, mAgreePrivacyPolicyEventListener);
        }
    }

    public static boolean checkCamera(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (!ApiUtil.shouldCheckPermission()) {
                return true;
            }
            if (context == null) {
                return false;
            }
            try {
                return ContextCompat.checkPermissionGranted(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean checkLocation(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            return checkLocationForGoogle(context);
        }
        return invokeL.booleanValue;
    }

    public static boolean checkReadPhoneState(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (!ApiUtil.shouldCheckPermission()) {
                return true;
            }
            if (context == null) {
                return false;
            }
            try {
                return ContextCompat.checkPermissionGranted(context, h.c);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean checkReadWifiState(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            if (!ApiUtil.shouldCheckPermission()) {
                return true;
            }
            if (context == null) {
                return false;
            }
            try {
                return ContextCompat.checkPermissionGranted(context, h.d);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean checkRecodeAudio(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            if (!ApiUtil.shouldCheckPermission()) {
                return true;
            }
            if (context == null) {
                return false;
            }
            try {
                return ContextCompat.checkPermissionGranted(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean checkWriteExternalStorage(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            if (!ApiUtil.shouldCheckPermission()) {
                return true;
            }
            if (context == null) {
                return false;
            }
            try {
                return ContextCompat.checkPermissionGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String getLocalMacAddress(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            if (!isAgreePrivacyPolicy()) {
                return "";
            }
            if (localMacAddress == null) {
                localMacAddress = rw5.c().d(context);
            }
            return localMacAddress;
        }
        return (String) invokeL.objValue;
    }

    public static Context providerContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            if (context == null) {
                return TbadkCoreApplication.getInst().getContext();
            }
            return context;
        }
        return (Context) invokeL.objValue;
    }

    public static void setIsAgreePrivacyPolicy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65570, null, z) == null) {
            isAgreePrivacyPolicy = z;
            SharedPrefHelper.getInstance().putBoolean("key_secret_is_show_new", z);
        }
    }

    public static void setIsBrowseMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65571, null, z) == null) {
            isBrowseMode = z;
        }
    }

    public static boolean checkLocationForBaiduLocation(Context context) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (!ApiUtil.shouldCheckPermission()) {
                return true;
            }
            if (context == null) {
                return false;
            }
            try {
                z = ContextCompat.checkPermissionGranted(context, h.c);
            } catch (Exception e) {
                e = e;
                z = false;
            }
            try {
                z2 = checkLocationForGoogle(context);
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                z2 = false;
                if (!z2) {
                }
                return false;
            }
            if (!z2 && z) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkLocationForGoogle(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (!ApiUtil.shouldCheckPermission()) {
                return true;
            }
            if (context == null) {
                return false;
            }
            try {
                if (ContextCompat.checkPermissionGranted(context, h.g)) {
                    return true;
                }
                if (ContextCompat.checkPermissionGranted(context, h.h)) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean checkLocationForTieba(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            if (!ApiUtil.shouldCheckPermission()) {
                return true;
            }
            if (context == null) {
                return false;
            }
            try {
                if (ContextCompat.checkPermissionGranted(context, h.g)) {
                    if (ContextCompat.checkPermissionGranted(context, h.h)) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String getLastCachedOid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            if (!isAgreePrivacyPolicy()) {
                return "";
            }
            String string = SharedPrefHelper.getInstance().getString("key_last_cached_oid", "");
            try {
                if (TextUtils.isEmpty(string)) {
                    string = DeviceInfoHelper.getOAID();
                    SharedPrefHelper.getInstance().putString("key_last_cached_oid", string);
                    return string;
                }
                return string;
            } catch (Exception e) {
                e.printStackTrace();
                return string;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean checkPermission(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
            if (!ApiUtil.shouldCheckPermission()) {
                return true;
            }
            if (context == null) {
                return false;
            }
            try {
                return ContextCompat.checkPermissionGranted(context, str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void requestWriteExternalStorage(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65565, null, activity, i) == null) {
            try {
                ActivityCompat.requestPermissions(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, i);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static boolean requestWriteExternalStorgePermission(Activity activity, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65567, null, activity, i)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            if (!checkWriteExternalStorage(activity.getApplicationContext())) {
                permissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            return permissionJudgePolicy.startRequestPermission(activity, i, PermissionJudgePolicy.EXTRA_DIALOG_REFUSE_POLICY.Refuse_one_by_one, null);
        }
        return invokeLI.booleanValue;
    }

    public static void reuqestBaiduLocationPermission(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65568, null, activity, i) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.appendRequestPermission(activity, h.c);
            permissionJudgePolicy.appendRequestPermission(activity, h.h);
            permissionJudgePolicy.appendRequestPermission(activity, h.g);
            permissionJudgePolicy.startRequestPermission(activity, i);
        }
    }

    public static boolean reuqestLocation(Activity activity, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65569, null, activity, i)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.appendRequestPermission(activity, h.h);
            permissionJudgePolicy.appendRequestPermission(activity, h.g);
            return permissionJudgePolicy.startRequestPermission(activity, i);
        }
        return invokeLI.booleanValue;
    }

    public static void doAgreePrivacyInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            setIsAgreePrivacyPolicy(true);
            doApplicationInit();
            if (TbadkCoreApplication.getIntent() != null) {
                String dataString = TbadkCoreApplication.getIntent().getDataString();
                if (!TextUtils.isEmpty(dataString)) {
                    TbSingleton.getInstance().setFirstOpenScheme(Uri.parse(dataString));
                }
            }
            GrowthStatsUtil.statisticActivity();
            MutiProcessManager.getInstance().init(TbadkCoreApplication.getInst());
            MutiProcessManager.publishEvent(new PrivacyPolicyEvent(Boolean.valueOf(isAgreePrivacyPolicy())));
            ax5.i().u();
        }
    }

    public static boolean requestLocation(Activity activity, int i, PermissionJudgePolicy.OnPermissionsGrantedListener onPermissionsGrantedListener) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65564, null, activity, i, onPermissionsGrantedListener)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.appendRequestPermissionWithoutGrantedCheck(activity, h.h);
            permissionJudgePolicy.appendRequestPermissionWithoutGrantedCheck(activity, h.g);
            permissionJudgePolicy.setOnPermissionsGrantedListener(onPermissionsGrantedListener);
            return permissionJudgePolicy.startRequestPermission(activity, i);
        }
        return invokeLIL.booleanValue;
    }

    public static boolean requestWriteExternalStorgeAndCameraPermission(Activity activity, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65566, null, activity, i)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            if (!checkWriteExternalStorage(activity.getApplicationContext())) {
                permissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            if (!checkCamera(activity.getApplicationContext())) {
                permissionJudgePolicy.appendRequestPermission(activity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            }
            return permissionJudgePolicy.startRequestPermission(activity, i, PermissionJudgePolicy.EXTRA_DIALOG_REFUSE_POLICY.Refuse_one_by_one, null);
        }
        return invokeLI.booleanValue;
    }

    public static ArrayMap<String, Boolean> transformPermissionResult(String[] strArr, int[] iArr) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65574, null, strArr, iArr)) == null) {
            if (strArr != null && strArr.length != 0 && iArr != null && iArr.length != 0) {
                ArrayMap<String, Boolean> arrayMap = new ArrayMap<>(strArr.length);
                for (int i = 0; i < strArr.length && i < iArr.length; i++) {
                    String str = strArr[i];
                    if (iArr[i] == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    arrayMap.put(str, Boolean.valueOf(z));
                }
                return arrayMap;
            }
            return null;
        }
        return (ArrayMap) invokeLL.objValue;
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, activity, str)) == null) {
            if (Build.VERSION.SDK_INT == 31) {
                try {
                    return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.e(TAG, "fail: " + e);
                }
            }
            return ActivityCompat.shouldShowRequestPermissionRationale(activity, str);
        }
        return invokeLL.booleanValue;
    }

    public static void starMainTabActivity(Context context, int i) {
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65573, null, context, i) == null) {
            try {
                cls = Class.forName(SpeedRuntimeProvider.MAIN_ACTIVITY_NAME);
            } catch (Exception e) {
                e.printStackTrace();
                cls = null;
            }
            if (cls != null) {
                Intent intent = new Intent(context, cls);
                intent.putExtra(MainEntrance.GOTO_TYPE, i);
                if (TbSingleton.getInstance().getFirstOpenScheme() != null) {
                    intent.setData(TbSingleton.getInstance().getFirstOpenScheme());
                    TbSingleton.getInstance().setFirstOpenScheme(null);
                }
                context.startActivity(intent);
            }
        }
    }
}
