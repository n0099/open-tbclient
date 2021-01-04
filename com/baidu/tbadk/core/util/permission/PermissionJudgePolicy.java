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
    private static final ArrayList<String> feS = new ArrayList<>(Arrays.asList(PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE, "android.permission.ACCESS_COARSE_LOCATION"));
    private List<String> feT;
    private c feU;
    private b feV;
    private com.baidu.tbadk.core.util.permission.a feW;
    private a feY;
    private int mRequestCode = -1;
    private EXTRA_DIALOG_REFUSE_POLICY feX = EXTRA_DIALOG_REFUSE_POLICY.Reject_all;
    private a.InterfaceC0582a feZ = new a.InterfaceC0582a() { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.1
        @Override // com.baidu.tbadk.core.util.permission.a.InterfaceC0582a
        public void d(Activity activity, String str) {
            if (PermissionJudgePolicy.this.feW != null) {
                PermissionJudgePolicy.this.feW.dismiss();
                if (PermissionJudgePolicy.this.feY != null) {
                    PermissionJudgePolicy.this.feY.onClose();
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.permission.a.InterfaceC0582a
        public void e(Activity activity, String str) {
            if (PermissionJudgePolicy.this.feW != null) {
                PermissionJudgePolicy.this.feT.remove(str);
                if (!x.isEmpty(PermissionJudgePolicy.this.feT)) {
                    PermissionJudgePolicy.this.ae(activity);
                    return;
                }
                PermissionJudgePolicy.this.feW.dismiss();
                PermissionJudgePolicy.this.g(activity, PermissionJudgePolicy.this.mRequestCode);
            }
        }
    };
    private a.InterfaceC0582a ffa = new a.InterfaceC0582a() { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.2
        @Override // com.baidu.tbadk.core.util.permission.a.InterfaceC0582a
        public void d(Activity activity, String str) {
            PermissionJudgePolicy.this.requestPermissionList.remove(str);
            PermissionJudgePolicy.this.feT.remove(str);
            if (!x.isEmpty(PermissionJudgePolicy.this.feT)) {
                PermissionJudgePolicy.this.ae(activity);
                return;
            }
            PermissionJudgePolicy.this.feW.dismiss();
            PermissionJudgePolicy.this.g(activity, PermissionJudgePolicy.this.mRequestCode);
        }

        @Override // com.baidu.tbadk.core.util.permission.a.InterfaceC0582a
        public void e(Activity activity, String str) {
            PermissionJudgePolicy.this.feT.remove(str);
            if (!x.isEmpty(PermissionJudgePolicy.this.feT)) {
                PermissionJudgePolicy.this.ae(activity);
                return;
            }
            PermissionJudgePolicy.this.feW.dismiss();
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
        this.feX = extra_dialog_refuse_policy;
        this.feY = aVar;
        if (!com.baidu.n.a.afl()) {
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
            this.feT = bwL();
            if (af(activity) != null && !x.isEmpty(this.feT)) {
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
        return com.baidu.n.a.a.checkPermissionGranted(activity, str);
    }

    public boolean checkPermissionForbidden(final Activity activity, final String str) {
        if (com.baidu.n.a.a.shouldShowRequestPermissionRationale(activity, str)) {
            return true;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.jI(false);
        aVar.oZ(R.string.request_permission_default_title);
        aVar.pa(getPermissionDescriptionId(str));
        aVar.a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivity(intent);
                if (PermissionJudgePolicy.this.feU != null) {
                    PermissionJudgePolicy.this.feU.onDialogComfirmed(str);
                }
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                if (PermissionJudgePolicy.this.feU != null) {
                    PermissionJudgePolicy.this.feU.onDialogCaneled(str);
                }
            }
        }).b(j.K(activity));
        aVar.btX();
        return false;
    }

    private void startRequestPermissionInternal(Activity activity) {
        if (activity != null) {
            try {
                com.baidu.n.a.a.requestPermissions(activity, (String[]) this.requestPermissionList.toArray(new String[this.requestPermissionList.size()]), RequestResponseCode.REQUEST_PERMISSION_JUDGEMENT);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void f(Activity activity, int i) {
        if (activity != null) {
            try {
                com.baidu.n.a.a.requestPermissions(activity, (String[]) this.requestPermissionList.toArray(new String[this.requestPermissionList.size()]), i);
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
        this.feV = bVar;
    }

    public void onPermissionsGranted() {
        if (this.feV != null) {
            this.feV.onPermissionsGranted();
        }
    }

    private List<String> bwL() {
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = this.requestPermissionList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (feS.contains(next)) {
                linkedList.add(next);
            }
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(Activity activity) {
        if (af(activity) != null && !x.isEmpty(this.feT)) {
            if (this.feW == null) {
                this.feW = new com.baidu.tbadk.core.util.permission.a(activity);
                if (this.feX == EXTRA_DIALOG_REFUSE_POLICY.Refuse_one_by_one) {
                    this.feW.a(this.ffa);
                } else {
                    this.feW.a(this.feZ);
                }
            }
            this.feW.Ck(this.feT.get(0));
            this.feW.b(af(activity));
            this.feW.onChangeSkinType();
            this.feW.btX();
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
