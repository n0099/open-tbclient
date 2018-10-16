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
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private ArrayList<String> azU = new ArrayList<>();
    private b azV;
    private InterfaceC0126a azW;

    /* renamed from: com.baidu.tbadk.core.util.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0126a {
        void Dj();
    }

    /* loaded from: classes.dex */
    public interface b {
        void fG(String str);

        void fH(String str);
    }

    public void a(b bVar) {
        this.azV = bVar;
    }

    public void Di() {
        if (this.azU != null) {
            this.azU.clear();
        }
    }

    public void c(Activity activity, String str) {
        if (!TextUtils.isEmpty(str) && !d(activity, str)) {
            this.azU.add(str);
        }
    }

    public boolean z(Activity activity) {
        if (!com.baidu.f.a.uf()) {
            Dj();
            return false;
        } else if (v.J(this.azU)) {
            Dj();
            return false;
        } else {
            if (activity instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) activity).setCurrentPermissionJudgePolicy(this);
            } else if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).setCurrentPermissionJudgePolicy(this);
            }
            A(activity);
            return true;
        }
    }

    private boolean d(Activity activity, String str) {
        if (activity == null) {
            return false;
        }
        return com.baidu.f.a.a.checkPermissionGranted(activity, str);
    }

    public boolean e(final Activity activity, final String str) {
        if (com.baidu.f.a.a.shouldShowRequestPermissionRationale(activity, str)) {
            return true;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.aP(false);
        aVar.cy(e.j.request_permission_default_title);
        aVar.cz(fF(str));
        aVar.a(e.j.isopen, new a.b() { // from class: com.baidu.tbadk.core.util.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivity(intent);
                if (a.this.azV != null) {
                    a.this.azV.fH(str);
                }
            }
        }).b(e.j.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.b.a.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                if (a.this.azV != null) {
                    a.this.azV.fG(str);
                }
            }
        }).b(i.aK(activity));
        aVar.Au();
        return false;
    }

    private void A(Activity activity) {
        if (activity != null) {
            try {
                com.baidu.f.a.a.requestPermissions(activity, (String[]) this.azU.toArray(new String[this.azU.size()]), 25040);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private int fF(String str) {
        if (TextUtils.isEmpty(str)) {
            return e.j.request_permission_default_text;
        }
        if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
            return e.j.request_permission_default_text;
        }
        if ("android.permission.ACCESS_FINE_LOCATION".equals(str) || "android.permission.ACCESS_COARSE_LOCATION".equals(str)) {
            return e.j.request_permission_location;
        }
        if ("android.permission.CAMERA".equals(str)) {
            return e.j.request_permission_camera;
        }
        if ("android.permission.RECORD_AUDIO".equals(str)) {
            return e.j.request_permission_microphone;
        }
        if ("android.permission.READ_PHONE_STATE".equals(str)) {
            return e.j.request_permission_contacts;
        }
        if ("android.permission.SEND_SMS".equals(str)) {
            return e.j.request_permission_sms;
        }
        if ("android.permission.CALL_PHONE".equals(str)) {
            return e.j.request_permission_cellphone;
        }
        return e.j.request_permission_default_text;
    }

    public void a(InterfaceC0126a interfaceC0126a) {
        this.azW = interfaceC0126a;
    }

    public void Dj() {
        if (this.azW != null) {
            this.azW.Dj();
        }
    }
}
