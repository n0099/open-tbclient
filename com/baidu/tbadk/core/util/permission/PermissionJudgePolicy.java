package com.baidu.tbadk.core.util.permission;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.e;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.permission.a;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PermissionJudgePolicy {
    private static final ArrayList<String> dWb = new ArrayList<>(Arrays.asList(PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE, "android.permission.ACCESS_COARSE_LOCATION"));
    private List<String> dWc;
    private c dWd;
    private b dWe;
    private com.baidu.tbadk.core.util.permission.a dWf;
    private a dWh;
    private int mRequestCode = -1;
    private EXTRA_DIALOG_REFUSE_POLICY dWg = EXTRA_DIALOG_REFUSE_POLICY.Reject_all;
    private a.InterfaceC0482a dWi = new a.InterfaceC0482a() { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.1
        @Override // com.baidu.tbadk.core.util.permission.a.InterfaceC0482a
        public void e(Activity activity, String str) {
            if (PermissionJudgePolicy.this.dWf != null) {
                PermissionJudgePolicy.this.dWf.dismiss();
                if (PermissionJudgePolicy.this.dWh != null) {
                    PermissionJudgePolicy.this.dWh.onClose();
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.permission.a.InterfaceC0482a
        public void f(Activity activity, String str) {
            if (PermissionJudgePolicy.this.dWf != null) {
                PermissionJudgePolicy.this.dWc.remove(str);
                if (!w.isEmpty(PermissionJudgePolicy.this.dWc)) {
                    PermissionJudgePolicy.this.aa(activity);
                    return;
                }
                PermissionJudgePolicy.this.dWf.dismiss();
                PermissionJudgePolicy.this.g(activity, PermissionJudgePolicy.this.mRequestCode);
            }
        }
    };
    private a.InterfaceC0482a dWj = new a.InterfaceC0482a() { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.2
        @Override // com.baidu.tbadk.core.util.permission.a.InterfaceC0482a
        public void e(Activity activity, String str) {
            PermissionJudgePolicy.this.requestPermissionList.remove(str);
            PermissionJudgePolicy.this.dWc.remove(str);
            if (!w.isEmpty(PermissionJudgePolicy.this.dWc)) {
                PermissionJudgePolicy.this.aa(activity);
                return;
            }
            PermissionJudgePolicy.this.dWf.dismiss();
            PermissionJudgePolicy.this.g(activity, PermissionJudgePolicy.this.mRequestCode);
        }

        @Override // com.baidu.tbadk.core.util.permission.a.InterfaceC0482a
        public void f(Activity activity, String str) {
            PermissionJudgePolicy.this.dWc.remove(str);
            if (!w.isEmpty(PermissionJudgePolicy.this.dWc)) {
                PermissionJudgePolicy.this.aa(activity);
                return;
            }
            PermissionJudgePolicy.this.dWf.dismiss();
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
        this.dWg = extra_dialog_refuse_policy;
        this.dWh = aVar;
        if (!com.baidu.h.a.NR()) {
            onPermissionsGranted();
            return false;
        } else if (w.isEmpty(this.requestPermissionList)) {
            onPermissionsGranted();
            return false;
        } else {
            if (activity instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) activity).setCurrentPermissionJudgePolicy(this);
            } else if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).setCurrentPermissionJudgePolicy(this);
            }
            this.dWc = aXh();
            if (ab(activity) != null && !w.isEmpty(this.dWc)) {
                aa(activity);
                return true;
            }
            g(activity, this.mRequestCode);
            return true;
        }
    }

    private boolean checkPermissionGranted(Activity activity, String str) {
        if (activity == null) {
            return false;
        }
        return com.baidu.h.a.a.checkPermissionGranted(activity, str);
    }

    public boolean checkPermissionForbidden(final Activity activity, final String str) {
        if (com.baidu.h.a.a.shouldShowRequestPermissionRationale(activity, str)) {
            return true;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.hg(false);
        aVar.kS(R.string.request_permission_default_title);
        aVar.kT(getPermissionDescriptionId(str));
        aVar.a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivity(intent);
                if (PermissionJudgePolicy.this.dWd != null) {
                    PermissionJudgePolicy.this.dWd.onDialogComfirmed(str);
                }
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                if (PermissionJudgePolicy.this.dWd != null) {
                    PermissionJudgePolicy.this.dWd.onDialogCaneled(str);
                }
            }
        }).b(i.G(activity));
        aVar.aUN();
        return false;
    }

    private void startRequestPermissionInternal(Activity activity) {
        if (activity != null) {
            try {
                com.baidu.h.a.a.requestPermissions(activity, (String[]) this.requestPermissionList.toArray(new String[this.requestPermissionList.size()]), RequestResponseCode.REQUEST_PERMISSION_JUDGEMENT);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void f(Activity activity, int i) {
        if (activity != null) {
            try {
                com.baidu.h.a.a.requestPermissions(activity, (String[]) this.requestPermissionList.toArray(new String[this.requestPermissionList.size()]), i);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private int getPermissionDescriptionId(String str) {
        if (TextUtils.isEmpty(str) || "android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
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
        return "android.permission.CALL_PHONE".equals(str) ? R.string.request_permission_cellphone : R.string.request_permission_default_text;
    }

    public void a(b bVar) {
        this.dWe = bVar;
    }

    public void onPermissionsGranted() {
        if (this.dWe != null) {
            this.dWe.onPermissionsGranted();
        }
    }

    private List<String> aXh() {
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = this.requestPermissionList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (dWb.contains(next)) {
                linkedList.add(next);
            }
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(Activity activity) {
        if (ab(activity) != null && !w.isEmpty(this.dWc)) {
            if (this.dWf == null) {
                this.dWf = new com.baidu.tbadk.core.util.permission.a(activity);
                if (this.dWg == EXTRA_DIALOG_REFUSE_POLICY.Refuse_one_by_one) {
                    this.dWf.a(this.dWj);
                } else {
                    this.dWf.a(this.dWi);
                }
            }
            this.dWf.wT(this.dWc.get(0));
            this.dWf.b(ab(activity));
            this.dWf.onChangeSkinType();
            this.dWf.aUN();
        }
    }

    private e ab(Activity activity) {
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
        if (!w.isEmpty(this.requestPermissionList)) {
            if (i == -1) {
                startRequestPermissionInternal(activity);
            } else {
                f(activity, i);
            }
        }
    }
}
