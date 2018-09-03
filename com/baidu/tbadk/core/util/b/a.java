package com.baidu.tbadk.core.util.b;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private ArrayList<String> asL = new ArrayList<>();
    private b asM;
    private InterfaceC0103a asN;

    /* renamed from: com.baidu.tbadk.core.util.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0103a {
        void zX();
    }

    /* loaded from: classes.dex */
    public interface b {
        void fa(String str);

        void fb(String str);
    }

    public void a(b bVar) {
        this.asM = bVar;
    }

    public void zW() {
        if (this.asL != null) {
            this.asL.clear();
        }
    }

    public void c(Activity activity, String str) {
        if (!TextUtils.isEmpty(str) && !d(activity, str)) {
            this.asL.add(str);
        }
    }

    public boolean u(Activity activity) {
        if (!com.baidu.e.a.rg()) {
            zX();
            return false;
        } else if (w.z(this.asL)) {
            zX();
            return false;
        } else {
            if (activity instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) activity).setCurrentPermissionJudgePolicy(this);
            } else if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).setCurrentPermissionJudgePolicy(this);
            }
            v(activity);
            return true;
        }
    }

    private boolean d(Activity activity, String str) {
        if (activity == null) {
            return false;
        }
        return com.baidu.e.a.a.P(activity, str);
    }

    public boolean e(final Activity activity, final String str) {
        if (com.baidu.e.a.a.shouldShowRequestPermissionRationale(activity, str)) {
            return true;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.aw(false);
        aVar.ce(f.j.request_permission_default_title);
        aVar.cf(eZ(str));
        aVar.a(f.j.isopen, new a.b() { // from class: com.baidu.tbadk.core.util.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivity(intent);
                if (a.this.asM != null) {
                    a.this.asM.fb(str);
                }
            }
        }).b(f.j.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.b.a.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                if (a.this.asM != null) {
                    a.this.asM.fa(str);
                }
            }
        }).b(i.ad(activity));
        aVar.xe();
        return false;
    }

    private void v(Activity activity) {
        if (activity != null) {
            try {
                com.baidu.e.a.a.requestPermissions(activity, (String[]) this.asL.toArray(new String[this.asL.size()]), 25040);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private int eZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return f.j.request_permission_default_text;
        }
        if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
            return f.j.request_permission_default_text;
        }
        if ("android.permission.ACCESS_FINE_LOCATION".equals(str) || "android.permission.ACCESS_COARSE_LOCATION".equals(str)) {
            return f.j.request_permission_location;
        }
        if ("android.permission.CAMERA".equals(str)) {
            return f.j.request_permission_camera;
        }
        if ("android.permission.RECORD_AUDIO".equals(str)) {
            return f.j.request_permission_microphone;
        }
        if ("android.permission.READ_PHONE_STATE".equals(str)) {
            return f.j.request_permission_contacts;
        }
        if ("android.permission.SEND_SMS".equals(str)) {
            return f.j.request_permission_sms;
        }
        if ("android.permission.CALL_PHONE".equals(str)) {
            return f.j.request_permission_cellphone;
        }
        return f.j.request_permission_default_text;
    }

    public void a(InterfaceC0103a interfaceC0103a) {
        this.asN = interfaceC0103a;
    }

    public void zX() {
        if (this.asN != null) {
            this.asN.zX();
        }
    }
}
