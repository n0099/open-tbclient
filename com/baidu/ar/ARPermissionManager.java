package com.baidu.ar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.external.ARCallback;
import com.baidu.ar.permissions.PermissionAction;
import com.baidu.ar.permissions.c;
import com.baidu.ar.permissions.d;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import com.baidu.ar.ui.a;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.UiUtils;
import com.baidu.ar.utils.AppUtils;
import com.baidu.searchbox.a.a;
/* loaded from: classes3.dex */
public class ARPermissionManager {
    private static final String[] d = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA"};
    private com.baidu.ar.permissions.a a;
    private Activity b;
    private ARFragment c;
    private com.baidu.ar.ui.a e;
    private ARCallback f;
    private a.InterfaceC0047a g = new a.InterfaceC0047a() { // from class: com.baidu.ar.ARPermissionManager.1
        @Override // com.baidu.ar.ui.a.InterfaceC0047a
        public void a() {
            if (!ARPermissionManager.hasCameraPermission(ARPermissionManager.this.b)) {
                StatisticHelper.getInstance().statisticInfo(StatisticConstants.USER_CAMERA_PERMISSION_DENY);
            }
            ARPermissionManager.this.c.callbackQuitAR();
        }

        @Override // com.baidu.ar.ui.a.InterfaceC0047a
        public void b() {
            Activity activity = ARPermissionManager.this.b;
            if (activity == null) {
                return;
            }
            AppUtils.openDetailSettings(activity);
            if (ARPermissionManager.hasCameraPermission(activity)) {
                return;
            }
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.USER_SETTING_CAMERA_PERMISSION);
        }
    };
    private boolean h;
    private b i;

    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC0095a {
        private String b;
        private int c;
        private String d;

        public a(String str, int i, String str2) {
            this.b = str;
            this.c = i;
            this.d = str2;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z);
    }

    public ARPermissionManager(ARFragment aRFragment) {
        this.a = new com.baidu.ar.permissions.a(aRFragment);
        this.b = aRFragment.getActivity();
        this.c = aRFragment;
    }

    private void a() {
        if (this.e == null || !this.e.isShowing()) {
            return;
        }
        this.e.dismiss();
        this.e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.i != null) {
            this.i.a(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        a();
        if (this.e == null) {
            this.e = new com.baidu.ar.ui.a(this.b);
            this.e.a(this.g);
            UiUtils.showDialogSafely(this.e);
            this.e.a(Res.getString("bdar_all_permission"));
            this.e.a(true);
            this.e.b(c() + Res.getString("bdar_all_description_for_android_m_above"));
            this.e.c(Res.getString("bdar_go_setting"));
        }
    }

    private String c() {
        return this.b != null ? AppUtils.getApplicationName(this.b, this.b.getPackageName()) : "";
    }

    public static boolean hasAllPermissions(Activity activity) {
        return d.a(activity, d).size() == 0;
    }

    public static boolean hasAudioPermission(Activity activity) {
        return d.b(activity, "android.permission.RECORD_AUDIO");
    }

    public static boolean hasCameraPermission(Activity activity) {
        return d.b(activity, "android.permission.CAMERA");
    }

    public static boolean hasSdcardPermission(Activity activity) {
        return d.b(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public void handleOpenCameraFailed() {
        a();
        if (Build.VERSION.SDK_INT >= 23) {
            b();
        } else if (this.e == null) {
            this.e = new com.baidu.ar.ui.a(this.b);
            this.e.a(new a.InterfaceC0047a() { // from class: com.baidu.ar.ARPermissionManager.4
                @Override // com.baidu.ar.ui.a.InterfaceC0047a
                public void a() {
                }

                @Override // com.baidu.ar.ui.a.InterfaceC0047a
                public void b() {
                    if (ARPermissionManager.this.b != null) {
                        ARPermissionManager.this.b.finish();
                    }
                }
            });
            UiUtils.showDialogSafely(this.e);
            this.e.a(Res.getString("bdar_open_camera_permission"));
            this.e.a(false);
            this.e.b(c() + Res.getString("bdar_open_camera_description_for_android_m_under"));
            this.e.c(Res.getString("bdar_got_it"));
        }
    }

    public boolean hasNecessaryPermission() {
        return hasAllPermissions(this.b);
    }

    public void onPause() {
        a();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.a.a(i, strArr, iArr);
    }

    public void onResume() {
        if (this.h) {
            return;
        }
        if (!hasAllPermissions(this.b)) {
            b();
            return;
        }
        this.h = true;
        a();
        a(true);
    }

    public void release() {
        a();
    }

    public void request(String str, PermissionAction permissionAction) {
        if (ARConfig.isBox()) {
            requestFroBaidu(str, permissionAction);
        } else {
            this.a.a(str, permissionAction);
        }
    }

    public void requestAllPermission(b bVar) {
        this.i = bVar;
        this.h = hasAllPermissions(this.b);
        if (this.h) {
            a(true);
            return;
        }
        final boolean hasCameraPermission = hasCameraPermission(this.b);
        if (!hasCameraPermission) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.SYSTEM_REQUEST_CAMERA_PERMISSION);
        }
        this.a.a(d, new c() { // from class: com.baidu.ar.ARPermissionManager.2
            @Override // com.baidu.ar.permissions.c
            public void a(String[] strArr, boolean[] zArr) {
                ARPermissionManager.this.h = d.a(zArr);
                if (!hasCameraPermission) {
                    if (ARPermissionManager.hasCameraPermission(ARPermissionManager.this.b)) {
                        StatisticHelper.getInstance().statisticInfo(StatisticConstants.SYSTEM_CAMERA_PERMISSION_GRANTED);
                    } else {
                        StatisticHelper.getInstance().statisticInfo(StatisticConstants.SYSTEM_CAMERA_PERMISSION_DENY);
                    }
                }
                if (ARPermissionManager.this.h) {
                    ARPermissionManager.this.a(true);
                    return;
                }
                if (!hasCameraPermission) {
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.USER_REQUEST_CAMERA_PERMISSION);
                }
                ARPermissionManager.this.b();
            }
        });
    }

    @TargetApi(23)
    public void requestFroBaidu(final String str, final PermissionAction permissionAction) {
        if (Build.VERSION.SDK_INT < 23) {
            if (permissionAction != null) {
                permissionAction.onGranted();
            }
        } else if (this.c.getActivity().checkSelfPermission(str) == 0) {
            if (permissionAction != null) {
                permissionAction.onGranted();
            }
        } else {
            String[] strArr = {str};
            if (com.baidu.searchbox.a.b.a(this.b, strArr)) {
                return;
            }
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.BAIDU_CUSTOMIZED_PERMISSION_DIALOG_REQUEST_MICROPHONE);
            com.baidu.searchbox.a.b.a("plugin_ar_audio_recg", this.b, strArr, new a.InterfaceC0095a() { // from class: com.baidu.ar.ARPermissionManager.3
            });
        }
    }

    @TargetApi(23)
    public void requestSDCardAndCameraPermissionForBaidu(b bVar) {
        this.i = bVar;
        this.h = hasAllPermissions(this.b);
        if (this.h) {
            a(true);
        } else if (Build.VERSION.SDK_INT < 23) {
            a(true);
        } else if (!ARConfig.isBox()) {
            requestAllPermission(this.i);
        } else {
            String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE"};
            if (!com.baidu.searchbox.a.b.a(this.b, strArr)) {
                com.baidu.searchbox.a.b.a("plugin_ar_resource_save", this.b, strArr, new a("plugin_ar_resource_save", 101, strArr[0]));
            }
            String[] strArr2 = {"android.permission.CAMERA"};
            if (com.baidu.searchbox.a.b.a(this.b, strArr2)) {
                return;
            }
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.BAIDU_CUSTOMIZED_PERMISSION_DIALOG_REQUEST_CAMERA);
            com.baidu.searchbox.a.b.a("plugin_ar_camera", this.b, strArr2, new a("plugin_ar_camera", 100, strArr2[0]));
        }
    }

    public void setArCallBack(ARCallback aRCallback) {
        this.f = aRCallback;
    }
}
