package com.baidu.platform.comapi.walknavi.d;

import android.text.TextUtils;
import com.baidu.ar.npc.BaiduArView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class g implements com.baidu.platform.comapi.walknavi.d.a.b.a {
    public static boolean a = true;
    private com.baidu.platform.comapi.walknavi.d.b d;
    private com.baidu.platform.comapi.walknavi.d.a.d e;
    private boolean g;
    private boolean l;
    private a o;
    private boolean h = false;
    private String i = null;
    private boolean j = false;
    private boolean k = true;
    public String c = "";
    private boolean m = true;
    private boolean n = false;
    public b b = new b();
    private com.baidu.platform.comapi.walknavi.d.a.b f = new com.baidu.platform.comapi.walknavi.d.a.b(com.baidu.platform.comapi.wnplatform.o.b.a.a());

    /* loaded from: classes6.dex */
    public interface a {
        void a(b bVar);
    }

    public String a() {
        return this.c;
    }

    public void a(String str) {
        com.baidu.platform.comapi.walknavi.b.a().H().b("walknavi_current_npc_token", str);
        this.c = str;
        this.b.a = str;
        if (this.o != null) {
            this.o.a(this.b);
        }
    }

    public void a(boolean z) {
        this.k = z;
    }

    public boolean b() {
        return this.k;
    }

    public boolean c() {
        return this.l;
    }

    public void b(boolean z) {
        this.l = z;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.b.a
    public void a(int i, HashMap<String, Object> hashMap) {
        if (this.d != null) {
            this.d.a(i, hashMap);
        }
    }

    private void a(long j, String str) {
        if (a) {
            com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", str + "time:" + (System.currentTimeMillis() - j));
        } else {
            com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.platform.comapi.walknavi.d.b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        this.d = bVar;
        this.e = new com.baidu.platform.comapi.walknavi.d.a.d(com.baidu.platform.comapi.wnplatform.o.b.a.a(), this);
        a(currentTimeMillis, "createArManager");
    }

    public void d() {
        this.e.a(45.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        if (this.e != null) {
            this.g = true;
        } else {
            this.g = false;
        }
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, int i2) {
        if (this.e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.e.b(str, i, i2);
            this.i = null;
            a(currentTimeMillis, "switchCase");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, int i, int i2) {
        if (this.e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.e.a(str, i, i2);
            a(currentTimeMillis, MissionEvent.MESSAGE_CREATE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (this.e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.e.d();
            a(currentTimeMillis, MissionEvent.MESSAGE_PAUSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        if (this.e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.e.e();
            a(currentTimeMillis, "pauseByUser");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (this.e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.e.c();
            a(currentTimeMillis, "resumeByUser");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        if (this.e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.e.b();
            a(currentTimeMillis, MissionEvent.MESSAGE_RESUME);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        if (this.e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.e.f();
            this.i = null;
            this.g = false;
            this.e = null;
            this.d = null;
            this.h = false;
            this.l = false;
            a(currentTimeMillis, MissionEvent.MESSAGE_DESTROY);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(boolean z) {
        this.h = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(double d, double d2, double d3, String str) {
        if (this.h && this.e != null) {
            this.e.a((float) d, (float) d2, (float) d3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2) {
        if (this.e != null && this.k) {
            if (!TextUtils.equals(str2, this.i) || TextUtils.equals(str2, "turnAndSayHi")) {
                this.e.a(str, str2);
                this.i = str2;
            }
        }
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(this.i)) {
            return TextUtils.equals(str, "enter");
        }
        return TextUtils.equals(str, "withoutGPS") || TextUtils.equals(str, "turnRight") || TextUtils.equals(str, "turnLeft") || TextUtils.equals(str, "helpless") || TextUtils.equals(str, "turnAndCry");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaiduArView k() {
        if (this.e != null) {
            return this.e.a();
        }
        return null;
    }

    public boolean l() {
        return this.n;
    }

    public void a(String str, c cVar) {
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "download start = ");
        this.n = true;
        this.b.b = str;
        if (this.o != null) {
            this.o.a(this.b);
        }
        this.f.a(str, new h(this, cVar));
    }

    public void b(String str, c cVar) {
        this.f.b(str, new i(this, cVar));
    }

    public void m() {
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "downloadCancel");
        long currentTimeMillis = System.currentTimeMillis();
        this.f.b();
        a(currentTimeMillis, "downloadCancel");
        this.n = false;
        this.b.c = 0;
        this.b.b = "";
    }

    public String c(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String a2 = this.f.a(str);
        a(currentTimeMillis, "queryLocalResource");
        return a2;
    }

    public boolean a(String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean a2 = this.f.a(str, z);
        a(currentTimeMillis, "clearARResource");
        return a2;
    }

    public boolean n() {
        return this.f.a();
    }

    public void a(a aVar) {
        this.o = aVar;
    }

    /* loaded from: classes6.dex */
    public class b {
        public String a;
        public String b;
        public int c;

        public b() {
        }
    }
}
