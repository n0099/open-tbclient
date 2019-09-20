package com.baidu.tbadk.core.util.c;

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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private ArrayList<String> bWv = new ArrayList<>();
    private b bWw;
    private InterfaceC0252a bWx;

    /* renamed from: com.baidu.tbadk.core.util.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0252a {
        void akf();
    }

    /* loaded from: classes.dex */
    public interface b {
        void oH(String str);

        void oI(String str);
    }

    public void a(b bVar) {
        this.bWw = bVar;
    }

    public void ake() {
        if (this.bWv != null) {
            this.bWv.clear();
        }
    }

    public void e(Activity activity, String str) {
        if (!TextUtils.isEmpty(str) && !f(activity, str)) {
            this.bWv.add(str);
        }
    }

    public boolean ad(Activity activity) {
        if (!com.baidu.e.a.uH()) {
            akf();
            return false;
        } else if (v.aa(this.bWv)) {
            akf();
            return false;
        } else {
            if (activity instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) activity).setCurrentPermissionJudgePolicy(this);
            } else if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).setCurrentPermissionJudgePolicy(this);
            }
            ae(activity);
            return true;
        }
    }

    private boolean f(Activity activity, String str) {
        if (activity == null) {
            return false;
        }
        return com.baidu.e.a.a.N(activity, str);
    }

    public boolean g(final Activity activity, final String str) {
        if (com.baidu.e.a.a.shouldShowRequestPermissionRationale(activity, str)) {
            return true;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.dR(false);
        aVar.hu(R.string.request_permission_default_title);
        aVar.hv(oG(str));
        aVar.a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.core.util.c.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivity(intent);
                if (a.this.bWw != null) {
                    a.this.bWw.oI(str);
                }
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.c.a.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                if (a.this.bWw != null) {
                    a.this.bWw.oH(str);
                }
            }
        }).b(i.ab(activity));
        aVar.agO();
        return false;
    }

    private void ae(Activity activity) {
        if (activity != null) {
            try {
                com.baidu.e.a.a.requestPermissions(activity, (String[]) this.bWv.toArray(new String[this.bWv.size()]), 25040);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private int oG(String str) {
        if (TextUtils.isEmpty(str) || "android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
            return R.string.request_permission_default_text;
        }
        if ("android.permission.ACCESS_FINE_LOCATION".equals(str) || "android.permission.ACCESS_COARSE_LOCATION".equals(str)) {
            return R.string.request_permission_location;
        }
        if ("android.permission.CAMERA".equals(str)) {
            return R.string.request_permission_camera;
        }
        if ("android.permission.RECORD_AUDIO".equals(str)) {
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

    public void a(InterfaceC0252a interfaceC0252a) {
        this.bWx = interfaceC0252a;
    }

    public void akf() {
        if (this.bWx != null) {
            this.bWx.akf();
        }
    }
}
