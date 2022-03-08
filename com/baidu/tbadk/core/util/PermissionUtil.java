package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import c.a.d.f.j.c.a;
import c.a.d.f.p.n;
import c.a.q0.c1.l;
import c.a.q0.c1.r;
import c.a.q0.j0.b;
import c.a.r0.l4.h;
import c.a.t0.c0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.config.AppIdentityManager;
import com.baidu.permissionhelper.ApiUtil;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.permissionhelper.context.ContextCompat;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.performance.speed.task.LaunchTaskSchedule;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.GrowthStatsUtil;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.mutiprocess.event.PrivacyPolicyEvent;
import com.baidu.tbadk.switchs.LaunchCacheOidSwitch;
import com.baidu.tbadk.switchs.LaunchUpSpeedSwitch;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kuaishou.weapon.un.s;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes5.dex */
public class PermissionUtil {
    public static /* synthetic */ Interceptable $ic;
    public static boolean isAgreePrivacyPolicy;
    public static boolean isSdkInited;
    public static String localMacAddress;
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
            @Override // c.a.q0.j0.b
            public boolean onEvent(PrivacyPolicyEvent privacyPolicyEvent) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, privacyPolicyEvent)) == null) {
                    if (privacyPolicyEvent == null) {
                        return true;
                    }
                    boolean z = privacyPolicyEvent.isAgreePrivacyPolicy;
                    if (z) {
                        if (!LaunchUpSpeedSwitch.getIsOn()) {
                            LaunchTaskSchedule.getInstance().startTask(3);
                        } else {
                            LaunchTaskSchedule.getInstance().start(3);
                        }
                    }
                    boolean unused = PermissionUtil.isAgreePrivacyPolicy = z;
                    if (PermissionUtil.isSdkInited) {
                        return true;
                    }
                    boolean unused2 = PermissionUtil.isSdkInited = PermissionUtil.isAgreePrivacyPolicy;
                    a.p(TbadkCoreApplication.getInst().getCuidGalaxy2());
                    a.q(TbadkCoreApplication.getInst().getCuidGalaxy3());
                    PermissionUtil.initUBC();
                    BdStatisticsManager.getInstance().setCommonDataMac(PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst()));
                    BdStatisticsManager.getInstance().setOaid(PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst()));
                    BdStatisticsManager.getInstance().setAndroidId(TbadkCoreApplication.getInst().getAndroidId());
                    BdStatisticsManager.getInstance().setCuid(TbadkCoreApplication.getInst().getCuid());
                    BdStatisticsManager.getInstance().setCuidGalaxy2(TbadkCoreApplication.getInst().getCuidGalaxy2());
                    c.a.d.f.n.n.b.m().o(TbadkCoreApplication.getInst().getCuid());
                    c.a.d.f.n.n.b.m().p(TbadkCoreApplication.getInst().getCuidGalaxy2());
                    c.a.d.f.n.m.a.o().p();
                    FH.setAgreePolicy(TbadkCoreApplication.getInst(), PermissionUtil.isAgreePrivacyPolicy);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921554));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
                    if (SapiAccountManager.getInstance() != null) {
                        SapiAccountManager.getInstance().setAgreeDangerousProtocol(true);
                    }
                    h.c().b();
                    if (TbadkCoreApplication.getInst().isMainProcess(false) || TbadkCoreApplication.getInst().isRemoteProcess()) {
                        c.a.b0.h.b.c();
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            boolean z = true;
            if (ApiUtil.shouldCheckPermission()) {
                try {
                    if (!ContextCompat.checkPermissionGranted(context, s.f53808g)) {
                        if (!ContextCompat.checkPermissionGranted(context, s.f53809h)) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) ? checkLocationForGoogle(context) : invokeL.booleanValue;
    }

    public static boolean checkLocationForBaiduLocation(Context context) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (ApiUtil.shouldCheckPermission()) {
                if (context == null) {
                    return false;
                }
                try {
                    z = ContextCompat.checkPermissionGranted(context, s.f53804c);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (ApiUtil.shouldCheckPermission()) {
                if (context == null) {
                    return false;
                }
                try {
                    if (ContextCompat.checkPermissionGranted(context, s.f53808g)) {
                        return true;
                    }
                    return ContextCompat.checkPermissionGranted(context, s.f53809h);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkLocationForTieba(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            if (ApiUtil.shouldCheckPermission()) {
                if (context == null) {
                    return false;
                }
                try {
                    if (ContextCompat.checkPermissionGranted(context, s.f53808g)) {
                        if (ContextCompat.checkPermissionGranted(context, s.f53809h)) {
                            return true;
                        }
                    }
                    return false;
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (ApiUtil.shouldCheckPermission()) {
                if (context == null) {
                    return false;
                }
                try {
                    return ContextCompat.checkPermissionGranted(context, s.f53804c);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            if (ApiUtil.shouldCheckPermission()) {
                if (context == null) {
                    return false;
                }
                try {
                    return ContextCompat.checkPermissionGranted(context, s.f53805d);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            Context providerContext = providerContext(context);
            if (providerContext == null) {
                return true;
            }
            try {
                if (ApiUtil.shouldCheckPermission() && ContextCompat.checkPermissionDenied(providerContext, PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
                    n.M(providerContext, R.string.record_audio_permission_denied_fun_disable);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
            if (ApiUtil.shouldCheckPermission()) {
                if (context == null) {
                    return false;
                }
                try {
                    return ContextCompat.checkPermissionGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE");
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            Context providerContext = providerContext(context);
            if (providerContext == null) {
                return true;
            }
            try {
                if (ApiUtil.shouldCheckPermission() && ContextCompat.checkPermissionDenied(providerContext, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    n.M(providerContext, R.string.write_external_storage_permission_denied_fun_disable);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            if (isAgreePrivacyPolicy()) {
                if (!LaunchCacheOidSwitch.getIsOn()) {
                    return c.a.q.b.f(context).g();
                }
                String q = c.a.q0.r.j0.b.k().q("key_last_cached_oid", "");
                try {
                    if (TextUtils.isEmpty(q)) {
                        q = c.a.q.b.f(context).g();
                        c.a.q0.r.j0.b.k().y("key_last_cached_oid", q);
                        return q;
                    }
                    return q;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return q;
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String getLocalMacAddress(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            if (isAgreePrivacyPolicy()) {
                if (localMacAddress == null) {
                    localMacAddress = l.d().e(context);
                }
                return localMacAddress;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static void initUBC() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65559, null) == null) && isAgreePrivacyPolicy()) {
            AppIdentityManager.getInstance().setAppName("tieba");
            if (c.a.i0.b.a.a.g()) {
                c0.a();
                CloudControlManager.getInstance().requestCloudControl("0");
            }
        }
    }

    public static boolean isAgreePrivacyPolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            boolean z = true;
            if (isAgreePrivacyPolicy) {
                return true;
            }
            if (!c.a.q0.r.j0.b.k().h("key_secret_is_show", false) && !c.a.q0.r.j0.b.k().h("key_secret_is_show_new", false)) {
                z = false;
            }
            isAgreePrivacyPolicy = z;
            return z;
        }
        return invokeV.booleanValue;
    }

    public static Context providerContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) ? context == null ? TbadkCoreApplication.getInst().getContext() : context : (Context) invokeL.objValue;
    }

    public static void registerMutiProcessPrivacyPolicy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, null) == null) {
            c.a.q0.j0.h.f().l(PrivacyPolicyEvent.class, mAgreePrivacyPolicyEventListener);
        }
    }

    public static boolean requestLocation(Activity activity, int i2, PermissionJudgePolicy.OnPermissionsGrantedListener onPermissionsGrantedListener) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65563, null, activity, i2, onPermissionsGrantedListener)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.appendRequestPermissionWithoutGrantedCheck(activity, s.f53809h);
            permissionJudgePolicy.appendRequestPermissionWithoutGrantedCheck(activity, s.f53808g);
            permissionJudgePolicy.setOnPermissionsGrantedListener(onPermissionsGrantedListener);
            return permissionJudgePolicy.startRequestPermission(activity, i2);
        }
        return invokeLIL.booleanValue;
    }

    public static boolean requestRecordAudioPermission(Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65564, null, activity, i2)) == null) {
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
        if (interceptable == null || interceptable.invokeLI(65565, null, activity, i2) == null) {
            try {
                ActivityCompat.requestPermissions(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, i2);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static boolean requestWriteExternalStorgeAndAudioPermission(Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65566, null, activity, i2)) == null) {
            ArrayList arrayList = new ArrayList(2);
            if (!checkWriteExternalStorage(activity.getApplicationContext())) {
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
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
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65567, null, activity, i2)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            if (!checkWriteExternalStorage(activity.getApplicationContext())) {
                permissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
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
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65568, null, activity, i2)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            if (!checkWriteExternalStorage(activity.getApplicationContext())) {
                permissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            return permissionJudgePolicy.startRequestPermission(activity, i2, PermissionJudgePolicy.EXTRA_DIALOG_REFUSE_POLICY.Refuse_one_by_one, null);
        }
        return invokeLI.booleanValue;
    }

    public static void reuqestBaiduLocationPermission(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65569, null, activity, i2) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.appendRequestPermission(activity, s.f53804c);
            permissionJudgePolicy.appendRequestPermission(activity, s.f53809h);
            permissionJudgePolicy.appendRequestPermission(activity, s.f53808g);
            permissionJudgePolicy.startRequestPermission(activity, i2);
        }
    }

    public static void reuqestCamera(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65570, null, activity, i2) == null) {
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
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65571, null, activity, i2)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.appendRequestPermission(activity, s.f53809h);
            permissionJudgePolicy.appendRequestPermission(activity, s.f53808g);
            return permissionJudgePolicy.startRequestPermission(activity, i2);
        }
        return invokeLI.booleanValue;
    }

    public static void reuqestReadPhoneState(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65573, null, activity, i2) == null) {
            try {
                ActivityCompat.requestPermissions(activity, new String[]{s.f53804c}, i2);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void setIsAgreePrivacyPolicy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65574, null, z) == null) {
            isAgreePrivacyPolicy = z;
            c.a.q0.r.j0.b.k().u("key_secret_is_show_new", z);
            if (TbadkCoreApplication.getIntent() != null) {
                String dataString = TbadkCoreApplication.getIntent().getDataString();
                if (!TextUtils.isEmpty(dataString)) {
                    TbSingleton.getInstance().setFirstOpenScheme(Uri.parse(dataString));
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).addParam("obj_param1", 2));
                }
            }
            GrowthStatsUtil.statisticActivity();
            c.a.q0.j0.h.i(new PrivacyPolicyEvent(Boolean.valueOf(z)));
            FH.setAgreePolicy(TbadkCoreApplication.getInst(), isAgreePrivacyPolicy);
            CloudControlManager.getInstance().requestCloudControl("0");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
            arrayList.add(new BasicNameValuePair("cuid", TbadkCoreApplication.getUniqueIdentifier()));
            c.a.d.c.e.c.h.f(arrayList);
            c.a.d.f.r.h.j().w(arrayList);
            BdSocketLinkService.setHasAbsoluteClose(false);
            BdSocketLinkService.setAvailable(true);
            BdSocketLinkService.startService(true, "privacy agree");
            c.a.d.e.a.b().a("permissionAgree", new Runnable() { // from class: com.baidu.tbadk.core.util.PermissionUtil.2
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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921644));
                    }
                }
            });
            r.g().q();
        }
    }

    public static void syncAgreeStatus(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65575, null, z) == null) && z && c.a.q0.r.j0.b.k().h("key_secret_is_show", false)) {
            isAgreePrivacyPolicy = true;
            c.a.q0.r.j0.b.k().u("key_secret_is_show_new", true);
            c.a.q0.r.j0.b.k().D("key_secret_is_show");
        }
    }

    public static ArrayMap<String, Boolean> transformPermissionResult(String[] strArr, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65576, null, strArr, iArr)) == null) {
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
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65572, null, activity, i2, iExtraDialogCloseCallback, iSystemPermissionDialogShowCallBack)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.appendRequestPermission(activity, s.f53809h);
            permissionJudgePolicy.appendRequestPermission(activity, s.f53808g);
            return permissionJudgePolicy.startRequestPermission(activity, i2, PermissionJudgePolicy.EXTRA_DIALOG_REFUSE_POLICY.Reject_all, iExtraDialogCloseCallback, iSystemPermissionDialogShowCallBack);
        }
        return invokeLILL.booleanValue;
    }
}
