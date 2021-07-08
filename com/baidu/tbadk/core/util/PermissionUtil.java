package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.Context;
import androidx.collection.ArrayMap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.permissionhelper.ApiUtil;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.permissionhelper.context.ContextCompat;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.mutiprocess.event.PrivacyPolicyEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.e.j.b.a;
import d.a.c.e.p.l;
import d.a.o0.f0.b;
import d.a.o0.f0.h;
import d.a.o0.z0.g;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PermissionUtil {
    public static /* synthetic */ Interceptable $ic;
    public static boolean isAgreePrivacyPolicy;
    public static boolean isSdkInited;
    public static b mAgreePrivacyPolicyEventListener;
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
        mAgreePrivacyPolicyEventListener = new b<PrivacyPolicyEvent>() { // from class: com.baidu.tbadk.core.util.PermissionUtil.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.o0.f0.b
            public boolean onEvent(PrivacyPolicyEvent privacyPolicyEvent) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, privacyPolicyEvent)) == null) {
                    if (privacyPolicyEvent == null) {
                        return true;
                    }
                    boolean unused = PermissionUtil.isAgreePrivacyPolicy = privacyPolicyEvent.isAgreePrivacyPolicy;
                    if (PermissionUtil.isSdkInited) {
                        return true;
                    }
                    boolean unused2 = PermissionUtil.isSdkInited = PermissionUtil.isAgreePrivacyPolicy;
                    if (TbadkCoreApplication.getInst().isYunPushProcess()) {
                        TbadkCoreApplication.getInst().initYunPushProcess();
                        return true;
                    }
                    TbadkCoreApplication.getInst().initCrabSdk();
                    TbadkCoreApplication.getInst().registerPhoneListener();
                    TbadkCoreApplication.getInst().initCyberPlayer();
                    TbadkCoreApplication.getInst().initCuidGalaxy2();
                    TbadkCoreApplication.getInst().initCuidGalaxy3();
                    TbadkCoreApplication.getInst().initBearSdk();
                    a.p(TbadkCoreApplication.getInst().getCuidGalaxy2());
                    a.q(TbadkCoreApplication.getInst().getCuidGalaxy3());
                    TbadkCoreApplication.getInst().initAxeSdk();
                    TbadkCoreApplication.getInst().initUBC();
                    BdStatisticsManager.getInstance().setCommonDataMac(PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst()));
                    BdStatisticsManager.getInstance().setOaid(PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst()));
                    BdStatisticsManager.getInstance().setAndroidId(TbadkCoreApplication.getInst().getAndroidId());
                    FH.setAgreePolicy(TbadkCoreApplication.getInst(), PermissionUtil.isAgreePrivacyPolicy);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921554));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
                    if (SapiAccountManager.getInstance() != null) {
                        SapiAccountManager.getInstance().setAgreeDangerousProtocol(true);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean checkCamera(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            if (ApiUtil.shouldCheckPermission()) {
                if (context == null) {
                    return false;
                }
                try {
                    return ContextCompat.checkPermissionGranted(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkFineLocation(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            boolean z = true;
            if (ApiUtil.shouldCheckPermission()) {
                try {
                    if (!ContextCompat.checkPermissionGranted(context, "android.permission.ACCESS_FINE_LOCATION")) {
                        if (!ContextCompat.checkPermissionGranted(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                            z = false;
                        }
                    }
                    return z;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkLocation(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? checkLocationForGoogle(context) : invokeL.booleanValue;
    }

    public static boolean checkLocationForBaiduLocation(Context context) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (ApiUtil.shouldCheckPermission()) {
                if (context == null) {
                    return false;
                }
                try {
                    z = ContextCompat.checkPermissionGranted(context, "android.permission.READ_PHONE_STATE");
                } catch (Exception e2) {
                    e = e2;
                    z = false;
                }
                try {
                    z2 = checkLocationForGoogle(context);
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    z2 = false;
                    if (z2) {
                    }
                }
                return !z2 && z;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkLocationForGoogle(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (ApiUtil.shouldCheckPermission()) {
                if (context == null) {
                    return false;
                }
                try {
                    if (ContextCompat.checkPermissionGranted(context, "android.permission.ACCESS_FINE_LOCATION")) {
                        return true;
                    }
                    return ContextCompat.checkPermissionGranted(context, "android.permission.ACCESS_COARSE_LOCATION");
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkPermission(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
            if (ApiUtil.shouldCheckPermission()) {
                if (context == null) {
                    return false;
                }
                try {
                    return ContextCompat.checkPermissionGranted(context, str);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean checkReadPhoneState(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            if (ApiUtil.shouldCheckPermission()) {
                if (context == null) {
                    return false;
                }
                try {
                    return ContextCompat.checkPermissionGranted(context, "android.permission.READ_PHONE_STATE");
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkReadWifiState(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (ApiUtil.shouldCheckPermission()) {
                if (context == null) {
                    return false;
                }
                try {
                    return ContextCompat.checkPermissionGranted(context, "android.permission.ACCESS_WIFI_STATE");
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkRecodeAudio(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (ApiUtil.shouldCheckPermission()) {
                if (context == null) {
                    return false;
                }
                try {
                    return ContextCompat.checkPermissionGranted(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkRecodeAudioStorageDeniedAndShowPrompt(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            Context providerContext = providerContext(context);
            if (providerContext == null) {
                return true;
            }
            try {
                if (ApiUtil.shouldCheckPermission() && ContextCompat.checkPermissionDenied(providerContext, PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
                    l.L(providerContext, R.string.record_audio_permission_denied_fun_disable);
                    return true;
                }
                return false;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean checkSendSms(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            if (ApiUtil.shouldCheckPermission()) {
                if (context == null) {
                    return false;
                }
                return ContextCompat.checkPermissionGranted(context, "android.permission.SEND_SMS");
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkWriteExternalStorage(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            if (ApiUtil.shouldCheckPermission()) {
                if (context == null) {
                    return false;
                }
                try {
                    return ContextCompat.checkPermissionGranted(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkWriteExternalStorageDeniedAndShowPrompt(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            Context providerContext = providerContext(context);
            if (providerContext == null) {
                return true;
            }
            try {
                if (ApiUtil.shouldCheckPermission() && ContextCompat.checkPermissionDenied(providerContext, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                    l.L(providerContext, R.string.write_external_storage_permission_denied_fun_disable);
                    return true;
                }
                return false;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String getLastCachedOid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) ? !isAgreePrivacyPolicy() ? "" : d.a.r.b.d(context).e() : (String) invokeL.objValue;
    }

    public static String getLocalMacAddress(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) ? !isAgreePrivacyPolicy() ? "" : g.c().d(context) : (String) invokeL.objValue;
    }

    public static boolean isAgreePrivacyPolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? isAgreePrivacyPolicy || d.a.o0.r.d0.b.j().g("key_secret_is_show", false) || d.a.o0.r.d0.b.j().g("key_secret_is_show_new", false) : invokeV.booleanValue;
    }

    public static Context providerContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) ? context == null ? TbadkCoreApplication.getInst().getContext() : context : (Context) invokeL.objValue;
    }

    public static void registerMutiProcessPrivacyPolicy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, null) == null) {
            h.f().l(PrivacyPolicyEvent.class, mAgreePrivacyPolicyEventListener);
        }
    }

    public static boolean requestRecordAudioPermission(Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65560, null, activity, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!checkRecodeAudio(activity.getApplicationContext())) {
                arrayList.add(PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            }
            if (arrayList.size() == 0) {
                return false;
            }
            try {
                ActivityCompat.requestPermissions(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), i2);
                return true;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return true;
            }
        }
        return invokeLI.booleanValue;
    }

    public static void requestWriteExternalStorage(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65561, null, activity, i2) == null) {
            try {
                ActivityCompat.requestPermissions(activity, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, i2);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static boolean requestWriteExternalStorgeAndAudioPermission(Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65562, null, activity, i2)) == null) {
            ArrayList arrayList = new ArrayList(2);
            if (!checkWriteExternalStorage(activity.getApplicationContext())) {
                arrayList.add(StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            }
            if (!checkRecodeAudio(activity.getApplicationContext())) {
                arrayList.add(PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            }
            if (arrayList.size() == 0) {
                return false;
            }
            try {
                ActivityCompat.requestPermissions(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), i2);
                return true;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return true;
            }
        }
        return invokeLI.booleanValue;
    }

    public static boolean requestWriteExternalStorgeAndCameraPermission(Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65563, null, activity, i2)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            if (!checkWriteExternalStorage(activity.getApplicationContext())) {
                permissionJudgePolicy.appendRequestPermission(activity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            }
            if (!checkCamera(activity.getApplicationContext())) {
                permissionJudgePolicy.appendRequestPermission(activity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            }
            return permissionJudgePolicy.startRequestPermission(activity, i2, PermissionJudgePolicy.EXTRA_DIALOG_REFUSE_POLICY.Refuse_one_by_one, null);
        }
        return invokeLI.booleanValue;
    }

    public static boolean requestWriteExternalStorgePermission(Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65564, null, activity, i2)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            if (!checkWriteExternalStorage(activity.getApplicationContext())) {
                permissionJudgePolicy.appendRequestPermission(activity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            }
            return permissionJudgePolicy.startRequestPermission(activity, i2, PermissionJudgePolicy.EXTRA_DIALOG_REFUSE_POLICY.Refuse_one_by_one, null);
        }
        return invokeLI.booleanValue;
    }

    public static void reuqestBaiduLocationPermission(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65565, null, activity, i2) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.appendRequestPermission(activity, "android.permission.READ_PHONE_STATE");
            permissionJudgePolicy.appendRequestPermission(activity, "android.permission.ACCESS_COARSE_LOCATION");
            permissionJudgePolicy.appendRequestPermission(activity, "android.permission.ACCESS_FINE_LOCATION");
            permissionJudgePolicy.startRequestPermission(activity, i2);
        }
    }

    public static void reuqestCamera(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65566, null, activity, i2) == null) {
            try {
                ActivityCompat.requestPermissions(activity, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, i2);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static boolean reuqestLocation(Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65567, null, activity, i2)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.appendRequestPermission(activity, "android.permission.ACCESS_COARSE_LOCATION");
            permissionJudgePolicy.appendRequestPermission(activity, "android.permission.ACCESS_FINE_LOCATION");
            return permissionJudgePolicy.startRequestPermission(activity, i2);
        }
        return invokeLI.booleanValue;
    }

    public static void reuqestReadPhoneState(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65569, null, activity, i2) == null) {
            try {
                ActivityCompat.requestPermissions(activity, new String[]{"android.permission.READ_PHONE_STATE"}, i2);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void setIsAgreePrivacyPolicy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65570, null, z) == null) {
            isAgreePrivacyPolicy = z;
            d.a.o0.r.d0.b.j().t("key_secret_is_show_new", z);
            h.i(new PrivacyPolicyEvent(Boolean.valueOf(z)));
            BdSocketLinkService.setHasAbsoluteClose(false);
            BdSocketLinkService.setAvailable(true);
            BdSocketLinkService.startService(true, "privacy agree");
        }
    }

    public static void syncAgreeStatus(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65571, null, z) == null) && z && d.a.o0.r.d0.b.j().g("key_secret_is_show", false)) {
            isAgreePrivacyPolicy = true;
            d.a.o0.r.d0.b.j().t("key_secret_is_show_new", true);
            d.a.o0.r.d0.b.j().C("key_secret_is_show");
        }
    }

    public static ArrayMap<String, Boolean> transformPermissionResult(String[] strArr, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, strArr, iArr)) == null) {
            if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
                return null;
            }
            ArrayMap<String, Boolean> arrayMap = new ArrayMap<>(strArr.length);
            for (int i2 = 0; i2 < strArr.length && i2 < iArr.length; i2++) {
                arrayMap.put(strArr[i2], Boolean.valueOf(iArr[i2] == 0));
            }
            return arrayMap;
        }
        return (ArrayMap) invokeLL.objValue;
    }

    public static boolean reuqestLocation(Activity activity, int i2, PermissionJudgePolicy.IExtraDialogCloseCallback iExtraDialogCloseCallback, PermissionJudgePolicy.ISystemPermissionDialogShowCallBack iSystemPermissionDialogShowCallBack) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65568, null, activity, i2, iExtraDialogCloseCallback, iSystemPermissionDialogShowCallBack)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.appendRequestPermission(activity, "android.permission.ACCESS_COARSE_LOCATION");
            permissionJudgePolicy.appendRequestPermission(activity, "android.permission.ACCESS_FINE_LOCATION");
            return permissionJudgePolicy.startRequestPermission(activity, i2, PermissionJudgePolicy.EXTRA_DIALOG_REFUSE_POLICY.Reject_all, iExtraDialogCloseCallback, iSystemPermissionDialogShowCallBack);
        }
        return invokeLILL.booleanValue;
    }
}
