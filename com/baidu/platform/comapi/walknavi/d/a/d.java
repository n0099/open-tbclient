package com.baidu.platform.comapi.walknavi.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.npc.ArBridge;
import com.baidu.ar.npc.BaiduArView;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class d implements ArBridge.d {

    /* renamed from: a  reason: collision with root package name */
    private Context f4430a;

    /* renamed from: b  reason: collision with root package name */
    private BaiduArView f4431b;
    private com.baidu.platform.comapi.walknavi.d.a.b.a c;
    private boolean d = false;
    private boolean e = false;

    public d(Context context, com.baidu.platform.comapi.walknavi.d.a.b.a aVar) {
        this.f4430a = context.getApplicationContext();
        this.c = aVar;
    }

    public BaiduArView a() {
        if (this.f4431b == null) {
            this.f4431b = new BaiduArView(this.f4430a);
        }
        return this.f4431b;
    }

    public void a(String str, int i, int i2) {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("create");
        this.d = false;
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
        com.baidu.platform.comapi.walknavi.d.a.e.a.a().a(this.f4430a, aVar);
        com.baidu.platform.comapi.walknavi.d.a.e.a.a().a("start_ar");
    }

    public void b(String str, int i, int i2) {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("switchCase");
        this.e = false;
        try {
            ArBridge.getInstance().switchCase(str, new HashMap<>(), i, i2);
        } catch (Throwable th) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("AR switchCase Throwable: " + th.getMessage());
            g();
            this.e = true;
        }
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("/")) {
            return "";
        }
        String[] split = str.split("/");
        return split[split.length - 3];
    }

    private void g() {
        if (this.c != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("case_id", -1);
            hashMap.put("succeeded", 0);
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("aParams = " + hashMap);
            this.c.a(1, hashMap);
        }
    }

    public void b() {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("resume");
        this.d = false;
        if (this.f4431b != null) {
            this.f4431b.onResume();
        }
    }

    public void c() {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("resumeByUser");
        this.d = false;
        ArBridge.getInstance().onResumeByUser();
    }

    public void d() {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("pause");
        this.d = true;
        if (this.f4431b != null) {
            this.f4431b.onPause();
        }
    }

    public void e() {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("pauseByUser");
        this.d = true;
        ArBridge.getInstance().onPauseByUser();
    }

    public void f() {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("destroy");
        this.d = true;
        if (this.f4431b != null) {
            this.f4431b.onPause();
        }
        ArBridge.getInstance().removeMessageHandeler(this);
        ArBridge.getInstance().destroyCase();
        com.baidu.platform.comapi.walknavi.d.a.e.a.a().a("end_ar");
        new Thread(new e(this)).start();
    }

    public void a(String str, String str2) {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("runScript, mIsPaused=" + this.d + ", mInitCompleted=" + this.e);
        if (!this.d && this.e) {
            if (TextUtils.isEmpty(str)) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("lua is null");
                return;
            }
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("runScript, lua: " + str);
            ArBridge.getInstance().sendLuaScriptToEngine(str.replace("dfk7fghdsf7d33e", str2));
        }
    }

    public void a(float f, float f2, float f3, String str) {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("setEuler, mIsPaused=" + this.d + ", mInitCompleted=" + this.e);
        if (!this.d && this.e) {
            ArBridge.getInstance().setEuler(f, f2, f3, str);
        }
    }

    public void a(float f) {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("setFrustum, mIsPaused=" + this.d + ", mInitCompleted=" + this.e);
        if (!this.d && this.e) {
            float f2 = 0.0f;
            if (a().getWidth() != 0 && a().getHeight() != 0) {
                f2 = a().getWidth() / a().getHeight();
            }
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("setFrustum, aspect=" + f2);
            ArBridge.getInstance().setFrustum(f, f2);
        }
    }

    private void a(int i) {
        ArBridge.getInstance().registerMessageHandler(i, this);
    }

    private void h() {
        a(9);
        a(ARPMessageType.MSG_TYPE_LUA_SDK_BRIDGE);
        a(1001);
        a(1003);
        a(1005);
        a(1007);
    }

    @Override // com.baidu.ar.npc.ArBridge.d
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("aMessageType = " + i + ", aParams = " + hashMap);
        if (this.c == null) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("ARCallback is null");
            return;
        }
        switch (i) {
            case 9:
                if (hashMap != null) {
                    try {
                        if (Integer.parseInt(String.valueOf(hashMap.get("succeeded"))) == 1) {
                            this.e = true;
                        }
                    } catch (Exception e) {
                        com.baidu.platform.comapi.walknavi.d.a.g.a.a("MSG_CASE_INIT_COMPLETED error: " + e.getMessage());
                    }
                }
                this.c.a(1, hashMap);
                return;
            case 1001:
                this.c.a(4, hashMap);
                return;
            case 1003:
                this.c.a(5, hashMap);
                return;
            case 1005:
                this.c.a(6, hashMap);
                return;
            case 1007:
                this.c.a(7, hashMap);
                return;
            case ARPMessageType.MSG_TYPE_LUA_SDK_BRIDGE /* 1901 */:
                if ("animation_end".equalsIgnoreCase(hashMap.get(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE).toString())) {
                    this.c.a(2, hashMap);
                    return;
                } else if ("click".equalsIgnoreCase(hashMap.get(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE).toString())) {
                    this.c.a(3, hashMap);
                    return;
                } else if ("animation_failed".equalsIgnoreCase(hashMap.get(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE).toString())) {
                    this.c.a(8, hashMap);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
