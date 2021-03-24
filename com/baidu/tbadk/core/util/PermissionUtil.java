package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.Context;
import androidx.collection.ArrayMap;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.permissionhelper.ApiUtil;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.permissionhelper.context.ContextCompat;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.mutiprocess.event.PrivacyPolicyEvent;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.b.e.j.b.a;
import d.b.b.e.p.l;
import d.b.h0.f0.b;
import d.b.h0.z0.g;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PermissionUtil {
    public static boolean isAgreePrivacyPolicy = false;
    public static boolean isSdkInited = false;
    public static b mAgreePrivacyPolicyEventListener = new b<PrivacyPolicyEvent>() { // from class: com.baidu.tbadk.core.util.PermissionUtil.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.f0.b
        public boolean onEvent(PrivacyPolicyEvent privacyPolicyEvent) {
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
            a.p(TbadkCoreApplication.getInst().getCuidGalaxy2());
            a.q(TbadkCoreApplication.getInst().getCuidGalaxy3());
            TbadkCoreApplication.getInst().initAxeSdk();
            TbadkCoreApplication.getInst().initUBC();
            BdStatisticsManager.getInstance().setCommonDataMac(PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst()));
            BdStatisticsManager.getInstance().setOaid(PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst()));
            BdStatisticsManager.getInstance().setAndroidId(TbadkCoreApplication.getInst().getAndroidId());
            FH.setAgreePolicy(TbadkCoreApplication.getInst(), PermissionUtil.isAgreePrivacyPolicy);
            return true;
        }
    };

    public static boolean checkCamera(Context context) {
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

    public static boolean checkFineLocation(Context context) {
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

    public static boolean checkLocation(Context context) {
        return checkLocationForGoogle(context);
    }

    public static boolean checkLocationForBaiduLocation(Context context) {
        boolean z;
        boolean z2;
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

    public static boolean checkLocationForGoogle(Context context) {
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

    public static boolean checkPermission(Context context, String str) {
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

    public static boolean checkReadPhoneState(Context context) {
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

    public static boolean checkReadWifiState(Context context) {
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

    public static boolean checkRecodeAudio(Context context) {
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

    public static boolean checkRecodeAudioStorageDeniedAndShowPrompt(Context context) {
        Context providerContext = providerContext(context);
        if (providerContext == null) {
            return true;
        }
        try {
            if (ApiUtil.shouldCheckPermission() && ContextCompat.checkPermissionDenied(providerContext, PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
                l.K(providerContext, R.string.record_audio_permission_denied_fun_disable);
                return true;
            }
            return false;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public static boolean checkSendSms(Context context) {
        if (ApiUtil.shouldCheckPermission()) {
            if (context == null) {
                return false;
            }
            return ContextCompat.checkPermissionGranted(context, "android.permission.SEND_SMS");
        }
        return true;
    }

    public static boolean checkWriteExternalStorage(Context context) {
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

    public static boolean checkWriteExternalStorageDeniedAndShowPrompt(Context context) {
        Context providerContext = providerContext(context);
        if (providerContext == null) {
            return true;
        }
        try {
            if (ApiUtil.shouldCheckPermission() && ContextCompat.checkPermissionDenied(providerContext, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                l.K(providerContext, R.string.write_external_storage_permission_denied_fun_disable);
                return true;
            }
            return false;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public static String getLastCachedOid(Context context) {
        return !isAgreePrivacyPolicy() ? "" : d.b.q.b.d(context).e();
    }

    public static String getLocalMacAddress(Context context) {
        return !isAgreePrivacyPolicy() ? "" : g.c().d(context);
    }

    public static boolean isAgreePrivacyPolicy() {
        return isAgreePrivacyPolicy || d.b.h0.r.d0.b.i().g("key_secret_is_show", false) || d.b.h0.r.d0.b.i().g("key_secret_is_show_new", false);
    }

    public static Context providerContext(Context context) {
        return context == null ? TbadkCoreApplication.getInst().getContext() : context;
    }

    public static void registerMutiProcessPrivacyPolicy() {
        d.b.h0.f0.g.e().j(PrivacyPolicyEvent.class, mAgreePrivacyPolicyEventListener);
    }

    public static boolean requestRecordAudioPermission(Activity activity, int i) {
        ArrayList arrayList = new ArrayList();
        if (!checkRecodeAudio(activity.getApplicationContext())) {
            arrayList.add(PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        }
        if (arrayList.size() == 0) {
            return false;
        }
        try {
            ActivityCompat.requestPermissions(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), i);
            return true;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return true;
        }
    }

    public static void requestWriteExternalStorage(Activity activity, int i) {
        try {
            ActivityCompat.requestPermissions(activity, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, i);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static boolean requestWriteExternalStorgeAndAudioPermission(Activity activity, int i) {
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
            ActivityCompat.requestPermissions(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), i);
            return true;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return true;
        }
    }

    public static boolean requestWriteExternalStorgeAndCameraPermission(Activity activity, int i) {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        if (!checkWriteExternalStorage(activity.getApplicationContext())) {
            permissionJudgePolicy.appendRequestPermission(activity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        }
        if (!checkCamera(activity.getApplicationContext())) {
            permissionJudgePolicy.appendRequestPermission(activity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        }
        return permissionJudgePolicy.startRequestPermission(activity, i, PermissionJudgePolicy.EXTRA_DIALOG_REFUSE_POLICY.Refuse_one_by_one, null);
    }

    public static boolean requestWriteExternalStorgePermission(Activity activity, int i) {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        if (!checkWriteExternalStorage(activity.getApplicationContext())) {
            permissionJudgePolicy.appendRequestPermission(activity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        }
        return permissionJudgePolicy.startRequestPermission(activity, i, PermissionJudgePolicy.EXTRA_DIALOG_REFUSE_POLICY.Refuse_one_by_one, null);
    }

    public static void reuqestCamera(Activity activity, int i) {
        try {
            ActivityCompat.requestPermissions(activity, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, i);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static boolean reuqestLocation(Activity activity, int i) {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.appendRequestPermission(activity, "android.permission.ACCESS_COARSE_LOCATION");
        permissionJudgePolicy.appendRequestPermission(activity, "android.permission.ACCESS_FINE_LOCATION");
        return permissionJudgePolicy.startRequestPermission(activity, i);
    }

    public static void reuqestReadPhoneState(Activity activity, int i) {
        try {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.READ_PHONE_STATE"}, i);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void setIsAgreePrivacyPolicy(boolean z) {
        isAgreePrivacyPolicy = z;
        d.b.h0.r.d0.b.i().s("key_secret_is_show_new", z);
        d.b.h0.f0.g.g(new PrivacyPolicyEvent(Boolean.valueOf(z)));
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, "privacy agree");
    }

    public static void syncAgreeStatus(boolean z) {
        if (z && d.b.h0.r.d0.b.i().g("key_secret_is_show", false)) {
            isAgreePrivacyPolicy = true;
            d.b.h0.r.d0.b.i().s("key_secret_is_show_new", true);
            d.b.h0.r.d0.b.i().B("key_secret_is_show");
        }
    }

    public static ArrayMap<String, Boolean> transformPermissionResult(String[] strArr, int[] iArr) {
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            return null;
        }
        ArrayMap<String, Boolean> arrayMap = new ArrayMap<>(strArr.length);
        for (int i = 0; i < strArr.length && i < iArr.length; i++) {
            arrayMap.put(strArr[i], Boolean.valueOf(iArr[i] == 0));
        }
        return arrayMap;
    }

    public static boolean reuqestLocation(Activity activity, int i, PermissionJudgePolicy.IExtraDialogCloseCallback iExtraDialogCloseCallback, PermissionJudgePolicy.ISystemPermissionDialogShowCallBack iSystemPermissionDialogShowCallBack) {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.appendRequestPermission(activity, "android.permission.ACCESS_COARSE_LOCATION");
        permissionJudgePolicy.appendRequestPermission(activity, "android.permission.ACCESS_FINE_LOCATION");
        return permissionJudgePolicy.startRequestPermission(activity, i, PermissionJudgePolicy.EXTRA_DIALOG_REFUSE_POLICY.Reject_all, iExtraDialogCloseCallback, iSystemPermissionDialogShowCallBack);
    }
}
