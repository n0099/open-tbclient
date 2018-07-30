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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private ArrayList<String> asK = new ArrayList<>();
    private b asL;
    private InterfaceC0103a asM;

    /* renamed from: com.baidu.tbadk.core.util.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0103a {
        void zZ();
    }

    /* loaded from: classes.dex */
    public interface b {
        void fa(String str);

        void fb(String str);
    }

    public void a(b bVar) {
        this.asL = bVar;
    }

    public void zY() {
        if (this.asK != null) {
            this.asK.clear();
        }
    }

    public void c(Activity activity, String str) {
        if (!TextUtils.isEmpty(str) && !d(activity, str)) {
            this.asK.add(str);
        }
    }

    public boolean u(Activity activity) {
        if (!com.baidu.e.a.rj()) {
            zZ();
            return false;
        } else if (w.z(this.asK)) {
            zZ();
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
        aVar.av(false);
        aVar.ce(d.j.request_permission_default_title);
        aVar.cf(eZ(str));
        aVar.a(d.j.isopen, new a.b() { // from class: com.baidu.tbadk.core.util.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivity(intent);
                if (a.this.asL != null) {
                    a.this.asL.fb(str);
                }
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.b.a.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                if (a.this.asL != null) {
                    a.this.asL.fa(str);
                }
            }
        }).b(i.ad(activity));
        aVar.xf();
        return false;
    }

    private void v(Activity activity) {
        if (activity != null) {
            try {
                com.baidu.e.a.a.requestPermissions(activity, (String[]) this.asK.toArray(new String[this.asK.size()]), 25040);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private int eZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return d.j.request_permission_default_text;
        }
        if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
            return d.j.request_permission_default_text;
        }
        if ("android.permission.ACCESS_FINE_LOCATION".equals(str) || "android.permission.ACCESS_COARSE_LOCATION".equals(str)) {
            return d.j.request_permission_location;
        }
        if ("android.permission.CAMERA".equals(str)) {
            return d.j.request_permission_camera;
        }
        if ("android.permission.RECORD_AUDIO".equals(str)) {
            return d.j.request_permission_microphone;
        }
        if ("android.permission.READ_PHONE_STATE".equals(str)) {
            return d.j.request_permission_contacts;
        }
        if ("android.permission.SEND_SMS".equals(str)) {
            return d.j.request_permission_sms;
        }
        if ("android.permission.CALL_PHONE".equals(str)) {
            return d.j.request_permission_cellphone;
        }
        return d.j.request_permission_default_text;
    }

    public void a(InterfaceC0103a interfaceC0103a) {
        this.asM = interfaceC0103a;
    }

    public void zZ() {
        if (this.asM != null) {
            this.asM.zZ();
        }
    }
}
