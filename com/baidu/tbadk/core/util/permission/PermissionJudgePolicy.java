package com.baidu.tbadk.core.util.permission;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.f;
import com.baidu.adp.base.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.permission.a;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PermissionJudgePolicy {
    private static final ArrayList<String> faj = new ArrayList<>(Arrays.asList(PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE, "android.permission.ACCESS_COARSE_LOCATION"));
    private List<String> fak;
    private c fal;
    private b fam;
    private com.baidu.tbadk.core.util.permission.a fan;
    private a fap;
    private int mRequestCode = -1;
    private EXTRA_DIALOG_REFUSE_POLICY fao = EXTRA_DIALOG_REFUSE_POLICY.Reject_all;
    private a.InterfaceC0565a faq = new a.InterfaceC0565a() { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.1
        @Override // com.baidu.tbadk.core.util.permission.a.InterfaceC0565a
        public void d(Activity activity, String str) {
            if (PermissionJudgePolicy.this.fan != null) {
                PermissionJudgePolicy.this.fan.dismiss();
                if (PermissionJudgePolicy.this.fap != null) {
                    PermissionJudgePolicy.this.fap.onClose();
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.permission.a.InterfaceC0565a
        public void e(Activity activity, String str) {
            if (PermissionJudgePolicy.this.fan != null) {
                PermissionJudgePolicy.this.fak.remove(str);
                if (!x.isEmpty(PermissionJudgePolicy.this.fak)) {
                    PermissionJudgePolicy.this.ae(activity);
                    return;
                }
                PermissionJudgePolicy.this.fan.dismiss();
                PermissionJudgePolicy.this.g(activity, PermissionJudgePolicy.this.mRequestCode);
            }
        }
    };
    private a.InterfaceC0565a far = new a.InterfaceC0565a() { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.2
        @Override // com.baidu.tbadk.core.util.permission.a.InterfaceC0565a
        public void d(Activity activity, String str) {
            PermissionJudgePolicy.this.requestPermissionList.remove(str);
            PermissionJudgePolicy.this.fak.remove(str);
            if (!x.isEmpty(PermissionJudgePolicy.this.fak)) {
                PermissionJudgePolicy.this.ae(activity);
                return;
            }
            PermissionJudgePolicy.this.fan.dismiss();
            PermissionJudgePolicy.this.g(activity, PermissionJudgePolicy.this.mRequestCode);
        }

        @Override // com.baidu.tbadk.core.util.permission.a.InterfaceC0565a
        public void e(Activity activity, String str) {
            PermissionJudgePolicy.this.fak.remove(str);
            if (!x.isEmpty(PermissionJudgePolicy.this.fak)) {
                PermissionJudgePolicy.this.ae(activity);
                return;
            }
            PermissionJudgePolicy.this.fan.dismiss();
            PermissionJudgePolicy.this.g(activity, PermissionJudgePolicy.this.mRequestCode);
        }
    };
    private ArrayList<String> requestPermissionList = new ArrayList<>();

    /* loaded from: classes.dex */
    public enum EXTRA_DIALOG_REFUSE_POLICY {
        Reject_all,
        Refuse_one_by_one
    }

    /* loaded from: classes.dex */
    public interface a {
        void onClose();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onPermissionsGranted();
    }

    /* loaded from: classes.dex */
    public interface c {
        void onDialogCaneled(String str);

        void onDialogComfirmed(String str);
    }

    public void clearRequestPermissionList() {
        if (this.requestPermissionList != null) {
            this.requestPermissionList.clear();
        }
    }

    public void appendRequestPermission(Activity activity, String str) {
        if (!TextUtils.isEmpty(str) && !checkPermissionGranted(activity, str)) {
            this.requestPermissionList.add(str);
        }
    }

    public boolean startRequestPermission(Activity activity) {
        return e(activity, -1);
    }

    public boolean e(Activity activity, int i) {
        return a(activity, i, EXTRA_DIALOG_REFUSE_POLICY.Reject_all, null);
    }

    public boolean a(Activity activity, int i, EXTRA_DIALOG_REFUSE_POLICY extra_dialog_refuse_policy, a aVar) {
        this.mRequestCode = i;
        this.fao = extra_dialog_refuse_policy;
        this.fap = aVar;
        if (!com.baidu.l.a.abt()) {
            onPermissionsGranted();
            return false;
        } else if (x.isEmpty(this.requestPermissionList)) {
            onPermissionsGranted();
            return false;
        } else {
            if (activity instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) activity).setCurrentPermissionJudgePolicy(this);
            } else if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).setCurrentPermissionJudgePolicy(this);
            }
            this.fak = bsS();
            if (af(activity) != null && !x.isEmpty(this.fak)) {
                ae(activity);
                return true;
            }
            g(activity, this.mRequestCode);
            return true;
        }
    }

    public boolean checkPermissionGranted(Activity activity, String str) {
        if (activity == null) {
            return false;
        }
        return com.baidu.l.a.a.checkPermissionGranted(activity, str);
    }

    public boolean checkPermissionForbidden(final Activity activity, final String str) {
        if (com.baidu.l.a.a.shouldShowRequestPermissionRationale(activity, str)) {
            return true;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.jE(false);
        aVar.nt(R.string.request_permission_default_title);
        aVar.nu(getPermissionDescriptionId(str));
        aVar.a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivity(intent);
                if (PermissionJudgePolicy.this.fal != null) {
                    PermissionJudgePolicy.this.fal.onDialogComfirmed(str);
                }
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                if (PermissionJudgePolicy.this.fal != null) {
                    PermissionJudgePolicy.this.fal.onDialogCaneled(str);
                }
            }
        }).b(j.K(activity));
        aVar.bqe();
        return false;
    }

    private void startRequestPermissionInternal(Activity activity) {
        if (activity != null) {
            try {
                com.baidu.l.a.a.requestPermissions(activity, (String[]) this.requestPermissionList.toArray(new String[this.requestPermissionList.size()]), RequestResponseCode.REQUEST_PERMISSION_JUDGEMENT);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void f(Activity activity, int i) {
        if (activity != null) {
            try {
                com.baidu.l.a.a.requestPermissions(activity, (String[]) this.requestPermissionList.toArray(new String[this.requestPermissionList.size()]), i);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private int getPermissionDescriptionId(String str) {
        if (TextUtils.isEmpty(str)) {
            return R.string.request_permission_default_text;
        }
        if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
            return R.string.request_permission_default_text;
        }
        if ("android.permission.ACCESS_FINE_LOCATION".equals(str) || "android.permission.ACCESS_COARSE_LOCATION".equals(str)) {
            return R.string.request_permission_location;
        }
        if (PermissionRequest.RESOURCE_VIDEO_CAPTURE.equals(str)) {
            return R.string.request_permission_camera;
        }
        if (PermissionRequest.RESOURCE_AUDIO_CAPTURE.equals(str)) {
            return R.string.request_permission_microphone;
        }
        if ("android.permission.READ_PHONE_STATE".equals(str)) {
            return R.string.request_permission_contacts;
        }
        if ("android.permission.SEND_SMS".equals(str)) {
            return R.string.request_permission_sms;
        }
        if ("android.permission.CALL_PHONE".equals(str)) {
            return R.string.request_permission_cellphone;
        }
        return R.string.request_permission_default_text;
    }

    public void a(b bVar) {
        this.fam = bVar;
    }

    public void onPermissionsGranted() {
        if (this.fam != null) {
            this.fam.onPermissionsGranted();
        }
    }

    private List<String> bsS() {
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = this.requestPermissionList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (faj.contains(next)) {
                linkedList.add(next);
            }
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(Activity activity) {
        if (af(activity) != null && !x.isEmpty(this.fak)) {
            if (this.fan == null) {
                this.fan = new com.baidu.tbadk.core.util.permission.a(activity);
                if (this.fao == EXTRA_DIALOG_REFUSE_POLICY.Refuse_one_by_one) {
                    this.fan.a(this.far);
                } else {
                    this.fan.a(this.faq);
                }
            }
            this.fan.AY(this.fak.get(0));
            this.fan.b(af(activity));
            this.fan.onChangeSkinType();
            this.fan.bqe();
        }
    }

    private f af(Activity activity) {
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        if (!(activity instanceof BaseActivity)) {
            return null;
        }
        return ((BaseActivity) activity).getPageContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Activity activity, int i) {
        if (!x.isEmpty(this.requestPermissionList)) {
            if (i == -1) {
                startRequestPermissionInternal(activity);
            } else {
                f(activity, i);
            }
        }
    }
}
