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
    private ArrayList<String> aEj = new ArrayList<>();
    private b aEk;
    private InterfaceC0160a aEl;

    /* renamed from: com.baidu.tbadk.core.util.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0160a {
        void Eu();
    }

    /* loaded from: classes.dex */
    public interface b {
        void fY(String str);

        void fZ(String str);
    }

    public void a(b bVar) {
        this.aEk = bVar;
    }

    public void Et() {
        if (this.aEj != null) {
            this.aEj.clear();
        }
    }

    public void c(Activity activity, String str) {
        if (!TextUtils.isEmpty(str) && !d(activity, str)) {
            this.aEj.add(str);
        }
    }

    public boolean A(Activity activity) {
        if (!com.baidu.e.a.uo()) {
            Eu();
            return false;
        } else if (v.I(this.aEj)) {
            Eu();
            return false;
        } else {
            if (activity instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) activity).setCurrentPermissionJudgePolicy(this);
            } else if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).setCurrentPermissionJudgePolicy(this);
            }
            B(activity);
            return true;
        }
    }

    private boolean d(Activity activity, String str) {
        if (activity == null) {
            return false;
        }
        return com.baidu.e.a.a.checkPermissionGranted(activity, str);
    }

    public boolean e(final Activity activity, final String str) {
        if (com.baidu.e.a.a.shouldShowRequestPermissionRationale(activity, str)) {
            return true;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.bg(false);
        aVar.da(e.j.request_permission_default_title);
        aVar.db(fX(str));
        aVar.a(e.j.isopen, new a.b() { // from class: com.baidu.tbadk.core.util.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivity(intent);
                if (a.this.aEk != null) {
                    a.this.aEk.fZ(str);
                }
            }
        }).b(e.j.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.b.a.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                if (a.this.aEk != null) {
                    a.this.aEk.fY(str);
                }
            }
        }).b(i.aK(activity));
        aVar.BF();
        return false;
    }

    private void B(Activity activity) {
        if (activity != null) {
            try {
                com.baidu.e.a.a.requestPermissions(activity, (String[]) this.aEj.toArray(new String[this.aEj.size()]), 25040);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private int fX(String str) {
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

    public void a(InterfaceC0160a interfaceC0160a) {
        this.aEl = interfaceC0160a;
    }

    public void Eu() {
        if (this.aEl != null) {
            this.aEl.Eu();
        }
    }
}
