package com.baidu.platform.comapi.walknavi.d;

import android.text.TextUtils;
import com.baidu.ar.npc.BaiduArView;
import com.baidu.platform.comapi.walknavi.fsm.RGState;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class g implements com.baidu.platform.comapi.walknavi.d.a.b.a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f9937a = true;

    /* renamed from: d  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.d.b f9940d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.d.a.d f9941e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9943g;
    public boolean l;
    public a o;

    /* renamed from: h  reason: collision with root package name */
    public boolean f9944h = false;

    /* renamed from: i  reason: collision with root package name */
    public String f9945i = null;
    public boolean j = false;
    public boolean k = true;

    /* renamed from: c  reason: collision with root package name */
    public String f9939c = "";
    public boolean m = true;
    public boolean n = false;

    /* renamed from: b  reason: collision with root package name */
    public b f9938b = new b();

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.d.a.b f9942f = new com.baidu.platform.comapi.walknavi.d.a.b(com.baidu.platform.comapi.wnplatform.o.b.a.a());

    /* loaded from: classes2.dex */
    public interface a {
        void a(b bVar);
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public String f9946a;

        /* renamed from: b  reason: collision with root package name */
        public String f9947b;

        /* renamed from: c  reason: collision with root package name */
        public int f9948c;

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
        this.f9941e.a(45.0f);
    }

    public boolean e() {
        if (this.f9941e != null) {
            this.f9943g = true;
        } else {
            this.f9943g = false;
        }
        return this.f9943g;
    }

    public void f() {
        if (this.f9941e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f9941e.d();
            a(currentTimeMillis, MissionEvent.MESSAGE_PAUSE);
        }
    }

    public void g() {
        if (this.f9941e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f9941e.e();
            a(currentTimeMillis, "pauseByUser");
        }
    }

    public void h() {
        if (this.f9941e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f9941e.c();
            a(currentTimeMillis, "resumeByUser");
        }
    }

    public void i() {
        if (this.f9941e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f9941e.b();
            a(currentTimeMillis, MissionEvent.MESSAGE_RESUME);
        }
    }

    public void j() {
        if (this.f9941e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f9941e.f();
            this.f9945i = null;
            this.f9943g = false;
            this.f9941e = null;
            this.f9940d = null;
            this.f9944h = false;
            this.l = false;
            a(currentTimeMillis, MissionEvent.MESSAGE_DESTROY);
        }
    }

    public BaiduArView k() {
        com.baidu.platform.comapi.walknavi.d.a.d dVar = this.f9941e;
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
        this.f9942f.b();
        a(currentTimeMillis, "downloadCancel");
        this.n = false;
        b bVar = this.f9938b;
        bVar.f9948c = 0;
        bVar.f9947b = "";
    }

    public boolean n() {
        return this.f9942f.a();
    }

    public void b(boolean z) {
        this.l = z;
    }

    public void c(boolean z) {
        this.f9944h = z;
    }

    public String a() {
        return this.f9939c;
    }

    public void b(String str, int i2, int i3) {
        if (this.f9941e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f9941e.a(str, i2, i3);
            a(currentTimeMillis, MissionEvent.MESSAGE_CREATE);
        }
    }

    public String c(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String a2 = this.f9942f.a(str);
        a(currentTimeMillis, "queryLocalResource");
        return a2;
    }

    public void a(String str) {
        com.baidu.platform.comapi.walknavi.b.a().H().b("walknavi_current_npc_token", str);
        this.f9939c = str;
        b bVar = this.f9938b;
        bVar.f9946a = str;
        a aVar = this.o;
        if (aVar != null) {
            aVar.a(bVar);
        }
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(this.f9945i)) {
            return TextUtils.equals(str, RGState.METHOD_NAME_ENTER);
        }
        return TextUtils.equals(str, "withoutGPS") || TextUtils.equals(str, "turnRight") || TextUtils.equals(str, "turnLeft") || TextUtils.equals(str, "helpless") || TextUtils.equals(str, "turnAndCry");
    }

    public void a(boolean z) {
        this.k = z;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.b.a
    public void a(int i2, HashMap<String, Object> hashMap) {
        com.baidu.platform.comapi.walknavi.d.b bVar = this.f9940d;
        if (bVar == null) {
            return;
        }
        bVar.a(i2, hashMap);
    }

    private void a(long j, String str) {
        if (f9937a) {
            com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", str + "time:" + (System.currentTimeMillis() - j));
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", str);
    }

    public void b(String str, c cVar) {
        this.f9942f.b(str, new i(this, cVar));
    }

    public void a(com.baidu.platform.comapi.walknavi.d.b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f9940d = bVar;
        this.f9941e = new com.baidu.platform.comapi.walknavi.d.a.d(com.baidu.platform.comapi.wnplatform.o.b.a.a(), this);
        a(currentTimeMillis, "createArManager");
    }

    public void a(String str, int i2, int i3) {
        if (this.f9941e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f9941e.b(str, i2, i3);
            this.f9945i = null;
            a(currentTimeMillis, "switchCase");
        }
    }

    public void a(double d2, double d3, double d4, String str) {
        com.baidu.platform.comapi.walknavi.d.a.d dVar;
        if (!this.f9944h || (dVar = this.f9941e) == null) {
            return;
        }
        dVar.a((float) d2, (float) d3, (float) d4, str);
    }

    public void a(String str, String str2) {
        if (this.f9941e == null || !this.k) {
            return;
        }
        if (!TextUtils.equals(str2, this.f9945i) || TextUtils.equals(str2, "turnAndSayHi")) {
            this.f9941e.a(str, str2);
            this.f9945i = str2;
        }
    }

    public void a(String str, c cVar) {
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "download start = ");
        this.n = true;
        b bVar = this.f9938b;
        bVar.f9947b = str;
        a aVar = this.o;
        if (aVar != null) {
            aVar.a(bVar);
        }
        this.f9942f.a(str, new h(this, cVar));
    }

    public boolean a(String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean a2 = this.f9942f.a(str, z);
        a(currentTimeMillis, "clearARResource");
        return a2;
    }

    public void a(a aVar) {
        this.o = aVar;
    }
}
