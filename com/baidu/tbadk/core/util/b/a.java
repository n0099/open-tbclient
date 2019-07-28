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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0243a bVA;
    private ArrayList<String> bVy = new ArrayList<>();
    private b bVz;

    /* renamed from: com.baidu.tbadk.core.util.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0243a {
        void ajR();
    }

    /* loaded from: classes.dex */
    public interface b {
        void oA(String str);

        void oz(String str);
    }

    public void a(b bVar) {
        this.bVz = bVar;
    }

    public void ajQ() {
        if (this.bVy != null) {
            this.bVy.clear();
        }
    }

    public void e(Activity activity, String str) {
        if (!TextUtils.isEmpty(str) && !f(activity, str)) {
            this.bVy.add(str);
        }
    }

    public boolean ad(Activity activity) {
        if (!com.baidu.e.a.uD()) {
            ajR();
            return false;
        } else if (v.aa(this.bVy)) {
            ajR();
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
        aVar.ht(R.string.request_permission_default_title);
        aVar.hu(oy(str));
        aVar.a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.core.util.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivity(intent);
                if (a.this.bVz != null) {
                    a.this.bVz.oA(str);
                }
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.util.b.a.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                if (a.this.bVz != null) {
                    a.this.bVz.oz(str);
                }
            }
        }).b(i.ab(activity));
        aVar.agI();
        return false;
    }

    private void ae(Activity activity) {
        if (activity != null) {
            try {
                com.baidu.e.a.a.requestPermissions(activity, (String[]) this.bVy.toArray(new String[this.bVy.size()]), 25040);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private int oy(String str) {
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

    public void a(InterfaceC0243a interfaceC0243a) {
        this.bVA = interfaceC0243a;
    }

    public void ajR() {
        if (this.bVA != null) {
            this.bVA.ajR();
        }
    }
}
