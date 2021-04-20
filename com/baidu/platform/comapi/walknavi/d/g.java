package com.baidu.platform.comapi.walknavi.d;

import android.text.TextUtils;
import com.baidu.ar.npc.BaiduArView;
import com.baidu.platform.comapi.walknavi.fsm.RGState;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class g implements com.baidu.platform.comapi.walknavi.d.a.b.a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f9580a = true;

    /* renamed from: d  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.d.b f9583d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.d.a.d f9584e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9586g;
    public boolean l;
    public a o;

    /* renamed from: h  reason: collision with root package name */
    public boolean f9587h = false;
    public String i = null;
    public boolean j = false;
    public boolean k = true;

    /* renamed from: c  reason: collision with root package name */
    public String f9582c = "";
    public boolean m = true;
    public boolean n = false;

    /* renamed from: b  reason: collision with root package name */
    public b f9581b = new b();

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.d.a.b f9585f = new com.baidu.platform.comapi.walknavi.d.a.b(com.baidu.platform.comapi.wnplatform.o.b.a.a());

    /* loaded from: classes2.dex */
    public interface a {
        void a(b bVar);
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public String f9588a;

        /* renamed from: b  reason: collision with root package name */
        public String f9589b;

        /* renamed from: c  reason: collision with root package name */
        public int f9590c;

        public b() {
        }
    }

    public boolean b() {
        return this.k;
    }

    public boolean c() {
        return this.l;
    }

    public void d() {
        this.f9584e.a(45.0f);
    }

    public boolean e() {
        if (this.f9584e != null) {
            this.f9586g = true;
        } else {
            this.f9586g = false;
        }
        return this.f9586g;
    }

    public void f() {
        if (this.f9584e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f9584e.d();
            a(currentTimeMillis, MissionEvent.MESSAGE_PAUSE);
        }
    }

    public void g() {
        if (this.f9584e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f9584e.e();
            a(currentTimeMillis, "pauseByUser");
        }
    }

    public void h() {
        if (this.f9584e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f9584e.c();
            a(currentTimeMillis, "resumeByUser");
        }
    }

    public void i() {
        if (this.f9584e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f9584e.b();
            a(currentTimeMillis, MissionEvent.MESSAGE_RESUME);
        }
    }

    public void j() {
        if (this.f9584e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f9584e.f();
            this.i = null;
            this.f9586g = false;
            this.f9584e = null;
            this.f9583d = null;
            this.f9587h = false;
            this.l = false;
            a(currentTimeMillis, MissionEvent.MESSAGE_DESTROY);
        }
    }

    public BaiduArView k() {
        com.baidu.platform.comapi.walknavi.d.a.d dVar = this.f9584e;
        if (dVar != null) {
            return dVar.a();
        }
        return null;
    }

    public boolean l() {
        return this.n;
    }

    public void m() {
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "downloadCancel");
        long currentTimeMillis = System.currentTimeMillis();
        this.f9585f.b();
        a(currentTimeMillis, "downloadCancel");
        this.n = false;
        b bVar = this.f9581b;
        bVar.f9590c = 0;
        bVar.f9589b = "";
    }

    public boolean n() {
        return this.f9585f.a();
    }

    public void b(boolean z) {
        this.l = z;
    }

    public void c(boolean z) {
        this.f9587h = z;
    }

    public String a() {
        return this.f9582c;
    }

    public void b(String str, int i, int i2) {
        if (this.f9584e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f9584e.a(str, i, i2);
            a(currentTimeMillis, MissionEvent.MESSAGE_CREATE);
        }
    }

    public String c(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String a2 = this.f9585f.a(str);
        a(currentTimeMillis, "queryLocalResource");
        return a2;
    }

    public void a(String str) {
        com.baidu.platform.comapi.walknavi.b.a().H().b("walknavi_current_npc_token", str);
        this.f9582c = str;
        b bVar = this.f9581b;
        bVar.f9588a = str;
        a aVar = this.o;
        if (aVar != null) {
            aVar.a(bVar);
        }
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(this.i)) {
            return TextUtils.equals(str, RGState.METHOD_NAME_ENTER);
        }
        return TextUtils.equals(str, "withoutGPS") || TextUtils.equals(str, "turnRight") || TextUtils.equals(str, "turnLeft") || TextUtils.equals(str, "helpless") || TextUtils.equals(str, "turnAndCry");
    }

    public void a(boolean z) {
        this.k = z;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.b.a
    public void a(int i, HashMap<String, Object> hashMap) {
        com.baidu.platform.comapi.walknavi.d.b bVar = this.f9583d;
        if (bVar == null) {
            return;
        }
        bVar.a(i, hashMap);
    }

    private void a(long j, String str) {
        if (f9580a) {
            com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", str + "time:" + (System.currentTimeMillis() - j));
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", str);
    }

    public void b(String str, c cVar) {
        this.f9585f.b(str, new i(this, cVar));
    }

    public void a(com.baidu.platform.comapi.walknavi.d.b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f9583d = bVar;
        this.f9584e = new com.baidu.platform.comapi.walknavi.d.a.d(com.baidu.platform.comapi.wnplatform.o.b.a.a(), this);
        a(currentTimeMillis, "createArManager");
    }

    public void a(String str, int i, int i2) {
        if (this.f9584e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f9584e.b(str, i, i2);
            this.i = null;
            a(currentTimeMillis, "switchCase");
        }
    }

    public void a(double d2, double d3, double d4, String str) {
        com.baidu.platform.comapi.walknavi.d.a.d dVar;
        if (!this.f9587h || (dVar = this.f9584e) == null) {
            return;
        }
        dVar.a((float) d2, (float) d3, (float) d4, str);
    }

    public void a(String str, String str2) {
        if (this.f9584e == null || !this.k) {
            return;
        }
        if (!TextUtils.equals(str2, this.i) || TextUtils.equals(str2, "turnAndSayHi")) {
            this.f9584e.a(str, str2);
            this.i = str2;
        }
    }

    public void a(String str, c cVar) {
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "download start = ");
        this.n = true;
        b bVar = this.f9581b;
        bVar.f9589b = str;
        a aVar = this.o;
        if (aVar != null) {
            aVar.a(bVar);
        }
        this.f9585f.a(str, new h(this, cVar));
    }

    public boolean a(String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean a2 = this.f9585f.a(str, z);
        a(currentTimeMillis, "clearARResource");
        return a2;
    }

    public void a(a aVar) {
        this.o = aVar;
    }
}
