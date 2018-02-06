package com.baidu.tbadk.core.util.b;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<String> aZd = new ArrayList<>();
    private InterfaceC0098a aZe;

    /* renamed from: com.baidu.tbadk.core.util.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0098a {
        void eI(String str);

        void eJ(String str);
    }

    public void a(InterfaceC0098a interfaceC0098a) {
        this.aZe = interfaceC0098a;
    }

    public void DI() {
        if (this.aZd != null) {
            this.aZd.clear();
        }
    }

    public void c(Activity activity, String str) {
        if (!TextUtils.isEmpty(str) && !d(activity, str)) {
            this.aZd.add(str);
        }
    }

    public boolean v(Activity activity) {
        if (com.baidu.d.a.vB() && !v.E(this.aZd)) {
            Iterator<String> it = this.aZd.iterator();
            while (it.hasNext()) {
                if (!e(activity, it.next())) {
                    return true;
                }
            }
            w(activity);
            return true;
        }
        return false;
    }

    private boolean d(Activity activity, String str) {
        if (activity == null) {
            return false;
        }
        return com.baidu.d.a.a.Q(activity, str);
    }

    private boolean e(final Activity activity, final String str) {
        if (com.baidu.d.a.a.shouldShowRequestPermissionRationale(activity, str)) {
            return true;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.ba(false);
        aVar.fa(d.j.request_permission_default_title);
        aVar.fb(eH(str));
        aVar.a(d.j.isopen, new a.b() { // from class: com.baidu.tbadk.core.util.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivity(intent);
                if (a.this.aZe != null) {
                    a.this.aZe.eJ(str);
                }
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.b.a.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                if (a.this.aZe != null) {
                    a.this.aZe.eI(str);
                }
            }
        }).b(i.ak(activity));
        aVar.AU();
        return false;
    }

    private void w(Activity activity) {
        if (activity != null) {
            try {
                com.baidu.d.a.a.requestPermissions(activity, (String[]) this.aZd.toArray(new String[this.aZd.size()]), 25040);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private int eH(String str) {
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
}
