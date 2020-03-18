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
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class PermissionJudgePolicy {
    private static final ArrayList<String> dbK = new ArrayList<>(Arrays.asList(PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE, "android.permission.ACCESS_COARSE_LOCATION"));
    private List<String> dbL;
    private b dbM;
    private a dbN;
    private com.baidu.tbadk.core.util.permission.a dbO;
    private int mRequestCode = -1;
    private EXTRA_DIALOG_REFUSE_POLICY dbP = EXTRA_DIALOG_REFUSE_POLICY.Reject_all;
    private a.InterfaceC0378a dbQ = new a.InterfaceC0378a() { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.1
        @Override // com.baidu.tbadk.core.util.permission.a.InterfaceC0378a
        public void e(Activity activity, String str) {
            if (PermissionJudgePolicy.this.dbO != null) {
                PermissionJudgePolicy.this.dbO.dismiss();
            }
        }

        @Override // com.baidu.tbadk.core.util.permission.a.InterfaceC0378a
        public void f(Activity activity, String str) {
            if (PermissionJudgePolicy.this.dbO != null) {
                PermissionJudgePolicy.this.dbL.remove(str);
                if (!v.isEmpty(PermissionJudgePolicy.this.dbL)) {
                    PermissionJudgePolicy.this.ae(activity);
                    return;
                }
                PermissionJudgePolicy.this.dbO.dismiss();
                PermissionJudgePolicy.this.h(activity, PermissionJudgePolicy.this.mRequestCode);
            }
        }
    };
    private a.InterfaceC0378a dbR = new a.InterfaceC0378a() { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.2
        @Override // com.baidu.tbadk.core.util.permission.a.InterfaceC0378a
        public void e(Activity activity, String str) {
            PermissionJudgePolicy.this.requestPermissionList.remove(str);
            PermissionJudgePolicy.this.dbL.remove(str);
            if (!v.isEmpty(PermissionJudgePolicy.this.dbL)) {
                PermissionJudgePolicy.this.ae(activity);
                return;
            }
            PermissionJudgePolicy.this.dbO.dismiss();
            PermissionJudgePolicy.this.h(activity, PermissionJudgePolicy.this.mRequestCode);
        }

        @Override // com.baidu.tbadk.core.util.permission.a.InterfaceC0378a
        public void f(Activity activity, String str) {
            PermissionJudgePolicy.this.dbL.remove(str);
            if (!v.isEmpty(PermissionJudgePolicy.this.dbL)) {
                PermissionJudgePolicy.this.ae(activity);
                return;
            }
            PermissionJudgePolicy.this.dbO.dismiss();
            PermissionJudgePolicy.this.h(activity, PermissionJudgePolicy.this.mRequestCode);
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
        void onPermissionsGranted();
    }

    /* loaded from: classes.dex */
    public interface b {
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
        return f(activity, -1);
    }

    public boolean f(Activity activity, int i) {
        return a(activity, i, EXTRA_DIALOG_REFUSE_POLICY.Reject_all);
    }

    public boolean a(Activity activity, int i, EXTRA_DIALOG_REFUSE_POLICY extra_dialog_refuse_policy) {
        this.mRequestCode = i;
        this.dbP = extra_dialog_refuse_policy;
        if (!com.baidu.k.a.EE()) {
            onPermissionsGranted();
            return false;
        } else if (v.isEmpty(this.requestPermissionList)) {
            onPermissionsGranted();
            return false;
        } else {
            if (activity instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) activity).setCurrentPermissionJudgePolicy(this);
            } else if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).setCurrentPermissionJudgePolicy(this);
            }
            this.dbL = aGW();
            if (af(activity) != null && !v.isEmpty(this.dbL)) {
                ae(activity);
                return true;
            }
            h(activity, this.mRequestCode);
            return true;
        }
    }

    private boolean checkPermissionGranted(Activity activity, String str) {
        if (activity == null) {
            return false;
        }
        return com.baidu.k.a.a.checkPermissionGranted(activity, str);
    }

    public boolean checkPermissionForbidden(final Activity activity, final String str) {
        if (com.baidu.k.a.a.shouldShowRequestPermissionRationale(activity, str)) {
            return true;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.fI(false);
        aVar.jV(R.string.request_permission_default_title);
        aVar.jW(getPermissionDescriptionId(str));
        aVar.a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivity(intent);
                if (PermissionJudgePolicy.this.dbM != null) {
                    PermissionJudgePolicy.this.dbM.onDialogComfirmed(str);
                }
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                if (PermissionJudgePolicy.this.dbM != null) {
                    PermissionJudgePolicy.this.dbM.onDialogCaneled(str);
                }
            }
        }).b(i.ab(activity));
        aVar.aEG();
        return false;
    }

    private void startRequestPermissionInternal(Activity activity) {
        if (activity != null) {
            try {
                com.baidu.k.a.a.requestPermissions(activity, (String[]) this.requestPermissionList.toArray(new String[this.requestPermissionList.size()]), RequestResponseCode.REQUEST_PERMISSION_JUDGEMENT);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void g(Activity activity, int i) {
        if (activity != null) {
            try {
                com.baidu.k.a.a.requestPermissions(activity, (String[]) this.requestPermissionList.toArray(new String[this.requestPermissionList.size()]), i);
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

    public void a(a aVar) {
        this.dbN = aVar;
    }

    public void onPermissionsGranted() {
        if (this.dbN != null) {
            this.dbN.onPermissionsGranted();
        }
    }

    private List<String> aGW() {
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = this.requestPermissionList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (dbK.contains(next)) {
                linkedList.add(next);
            }
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(Activity activity) {
        if (af(activity) != null && !v.isEmpty(this.dbL)) {
            if (this.dbO == null) {
                this.dbO = new com.baidu.tbadk.core.util.permission.a(activity);
                if (this.dbP == EXTRA_DIALOG_REFUSE_POLICY.Refuse_one_by_one) {
                    this.dbO.a(this.dbR);
                } else {
                    this.dbO.a(this.dbQ);
                }
            }
            this.dbO.tF(this.dbL.get(0));
            this.dbO.b(af(activity));
            this.dbO.onChangeSkinType();
            this.dbO.aEG();
        }
    }

    private e af(Activity activity) {
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        if (!(activity instanceof BaseActivity)) {
            return null;
        }
        return ((BaseActivity) activity).getPageContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, int i) {
        if (!v.isEmpty(this.requestPermissionList)) {
            if (i == -1) {
                startRequestPermissionInternal(activity);
            } else {
                g(activity, i);
            }
        }
    }
}
