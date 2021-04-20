package com.baidu.platform.comapi.walknavi.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.npc.ArBridge;
import com.baidu.ar.npc.BaiduArView;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class d implements ArBridge.d {

    /* renamed from: a  reason: collision with root package name */
    public Context f9519a;

    /* renamed from: b  reason: collision with root package name */
    public BaiduArView f9520b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.d.a.b.a f9521c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9522d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9523e = false;

    public d(Context context, com.baidu.platform.comapi.walknavi.d.a.b.a aVar) {
        this.f9519a = context.getApplicationContext();
        this.f9521c = aVar;
    }

    private void g() {
        if (this.f9521c != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("case_id", -1);
            hashMap.put("succeeded", 0);
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("aParams = " + hashMap);
            this.f9521c.a(1, hashMap);
        }
    }

    private void h() {
        a(9);
        a(1901);
        a(1001);
        a(1003);
        a(1005);
        a(1007);
    }

    public BaiduArView a() {
        if (this.f9520b == null) {
            this.f9520b = new BaiduArView(this.f9519a);
        }
        return this.f9520b;
    }

    public void b(String str, int i, int i2) {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("switchCase");
        this.f9523e = false;
        try {
            ArBridge.getInstance().switchCase(str, new HashMap<>(), i, i2);
        } catch (Throwable th) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("AR switchCase Throwable: " + th.getMessage());
            g();
            this.f9523e = true;
        }
    }

    public void c() {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("resumeByUser");
        this.f9522d = false;
        ArBridge.getInstance().onResumeByUser();
    }

    public void d() {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("pause");
        this.f9522d = true;
        BaiduArView baiduArView = this.f9520b;
        if (baiduArView != null) {
            baiduArView.onPause();
        }
    }

    public void e() {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("pauseByUser");
        this.f9522d = true;
        ArBridge.getInstance().onPauseByUser();
    }

    public void f() {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("destroy");
        this.f9522d = true;
        BaiduArView baiduArView = this.f9520b;
        if (baiduArView != null) {
            baiduArView.onPause();
        }
        ArBridge.getInstance().removeMessageHandeler(this);
        ArBridge.getInstance().destroyCase();
        com.baidu.platform.comapi.walknavi.d.a.e.a.a().a("end_ar");
        new Thread(new e(this)).start();
    }

    public void a(String str, int i, int i2) {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("create");
        this.f9522d = false;
        h();
        try {
            ArBridge.getInstance().createCase(str, new HashMap<>(), i, i2);
        } catch (Throwable th) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("AR createCase Throwable: " + th.getMessage());
            g();
        }
        com.baidu.platform.comapi.walknavi.d.a.a.a aVar = new com.baidu.platform.comapi.walknavi.d.a.a.a();
        aVar.a(a(str));
        aVar.a(4);
        com.baidu.platform.comapi.walknavi.d.a.e.a.a().a(this.f9519a, aVar);
        com.baidu.platform.comapi.walknavi.d.a.e.a.a().a("start_ar");
    }

    public void b() {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("resume");
        this.f9522d = false;
        BaiduArView baiduArView = this.f9520b;
        if (baiduArView != null) {
            baiduArView.onResume();
        }
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("/")) {
            return "";
        }
        String[] split = str.split("/");
        return split[split.length - 3];
    }

    public void a(String str, String str2) {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("runScript, mIsPaused=" + this.f9522d + ", mInitCompleted=" + this.f9523e);
        if (this.f9522d || !this.f9523e) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("lua is null");
            return;
        }
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("runScript, lua: " + str);
        ArBridge.getInstance().sendLuaScriptToEngine(str.replace("dfk7fghdsf7d33e", str2));
    }

    public void a(float f2, float f3, float f4, String str) {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("setEuler, mIsPaused=" + this.f9522d + ", mInitCompleted=" + this.f9523e);
        if (this.f9522d || !this.f9523e) {
            return;
        }
        ArBridge.getInstance().setEuler(f2, f3, f4, str);
    }

    public void a(float f2) {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("setFrustum, mIsPaused=" + this.f9522d + ", mInitCompleted=" + this.f9523e);
        if (this.f9522d || !this.f9523e) {
            return;
        }
        float f3 = 0.0f;
        if (a().getWidth() != 0 && a().getHeight() != 0) {
            f3 = a().getWidth() / a().getHeight();
        }
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("setFrustum, aspect=" + f3);
        ArBridge.getInstance().setFrustum(f2, f3);
    }

    private void a(int i) {
        ArBridge.getInstance().registerMessageHandler(i, this);
    }

    @Override // com.baidu.ar.npc.ArBridge.d
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("aMessageType = " + i + ", aParams = " + hashMap);
        com.baidu.platform.comapi.walknavi.d.a.b.a aVar = this.f9521c;
        if (aVar == null) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("ARCallback is null");
        } else if (i == 9) {
            if (hashMap != null) {
                try {
                    if (Integer.parseInt(String.valueOf(hashMap.get("succeeded"))) == 1) {
                        this.f9523e = true;
                    }
                } catch (Exception e2) {
                    com.baidu.platform.comapi.walknavi.d.a.g.a.a("MSG_CASE_INIT_COMPLETED error: " + e2.getMessage());
                }
            }
            this.f9521c.a(1, hashMap);
        } else if (i == 1001) {
            aVar.a(4, hashMap);
        } else if (i == 1003) {
            aVar.a(5, hashMap);
        } else if (i == 1005) {
            aVar.a(6, hashMap);
        } else if (i == 1007) {
            aVar.a(7, hashMap);
        } else if (i != 1901) {
        } else {
            if ("animation_end".equalsIgnoreCase(hashMap.get(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE).toString())) {
                this.f9521c.a(2, hashMap);
            } else if (PrefetchEvent.STATE_CLICK.equalsIgnoreCase(hashMap.get(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE).toString())) {
                this.f9521c.a(3, hashMap);
            } else if ("animation_failed".equalsIgnoreCase(hashMap.get(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE).toString())) {
                this.f9521c.a(8, hashMap);
            }
        }
    }
}
