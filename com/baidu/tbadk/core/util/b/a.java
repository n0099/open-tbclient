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
    private ArrayList<String> aXu = new ArrayList<>();
    private InterfaceC0075a aXv;

    /* renamed from: com.baidu.tbadk.core.util.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0075a {
        void ew(String str);

        void ex(String str);
    }

    public void a(InterfaceC0075a interfaceC0075a) {
        this.aXv = interfaceC0075a;
    }

    public void Do() {
        if (this.aXu != null) {
            this.aXu.clear();
        }
    }

    public void c(Activity activity, String str) {
        if (!TextUtils.isEmpty(str) && !d(activity, str)) {
            this.aXu.add(str);
        }
    }

    public boolean u(Activity activity) {
        if (com.baidu.b.a.uP() && !v.E(this.aXu)) {
            Iterator<String> it = this.aXu.iterator();
            while (it.hasNext()) {
                if (!e(activity, it.next())) {
                    return true;
                }
            }
            v(activity);
            return true;
        }
        return false;
    }

    private boolean d(Activity activity, String str) {
        if (activity == null) {
            return false;
        }
        return com.baidu.b.a.a.O(activity, str);
    }

    private boolean e(final Activity activity, final String str) {
        if (com.baidu.b.a.a.shouldShowRequestPermissionRationale(activity, str)) {
            return true;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.aX(false);
        aVar.fa(d.j.request_permission_default_title);
        aVar.fb(ev(str));
        aVar.a(d.j.isopen, new a.b() { // from class: com.baidu.tbadk.core.util.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivity(intent);
                if (a.this.aXv != null) {
                    a.this.aXv.ex(str);
                }
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.b.a.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                if (a.this.aXv != null) {
                    a.this.aXv.ew(str);
                }
            }
        }).b(i.ak(activity));
        aVar.AB();
        return false;
    }

    private void v(Activity activity) {
        if (activity != null) {
            try {
                com.baidu.b.a.a.requestPermissions(activity, (String[]) this.aXu.toArray(new String[this.aXu.size()]), 25039);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private int ev(String str) {
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
        return d.j.request_permission_default_text;
    }
}
