package a.a.a.a.v.f.g;

import a.a.a.a.a.e;
import a.a.a.a.v.f.e;
import com.fun.ad.sdk.FunAdSlot;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static final a.a.a.a.v.f.d BT = a.a.a.a.v.f.d.hw();
    public final a BU = new a();

    public static void a(a aVar, Object obj, Object... objArr) {
        a("ad", aVar, obj, false, objArr);
    }

    public void a() {
        a(this.BU, "left_app", new Object[0]);
    }

    public void a(int i) {
        a(this.BU, "render_failed", "err", Integer.valueOf(i));
    }

    public void a(FunAdSlot funAdSlot, e.a aVar) {
        a aVar2 = this.BU;
        String sid = funAdSlot.getSid();
        long currentTimeMillis = System.currentTimeMillis();
        String str = aVar.c;
        String str2 = aVar.d;
        aVar2.f1012a = sid;
        aVar2.b = currentTimeMillis;
        aVar2.c = str;
        aVar2.d = str2;
        a(this.BU, "ld_start", new Object[0]);
    }

    public void a(Object obj) {
        a(this.BU, "ld_err", "err", obj);
    }

    public void b() {
        a(this.BU, "ld_succeed", new Object[0]);
    }

    public void b(int i) {
        a(this.BU, "video_err", "err", Integer.valueOf(i));
    }

    public void b(Object obj) {
        a(this.BU, "sh_failed", "err", obj);
    }

    public void b(boolean z) {
        a("ad", this.BU, "sh_succeed", z, new Object[0]);
    }

    public void c() {
        a(this.BU, "oncached", new Object[0]);
    }

    public void d() {
        a(this.BU, "onclosed", new Object[0]);
    }

    public void e() {
        a(this.BU, "render_succeed", new Object[0]);
    }

    public void f() {
        a(this.BU, "reward", new Object[0]);
    }

    public void g() {
        a(this.BU, "sh_start", new Object[0]);
    }

    public void h() {
        a(this.BU, "unlike_selected", new Object[0]);
    }

    public void i() {
        a(this.BU, "video_complete", new Object[0]);
    }

    public void j() {
        a(this.BU, "video_err", new Object[0]);
    }

    public void k() {
        a(this.BU, "video_pause", new Object[0]);
    }

    public void l() {
        a(this.BU, "video_resume", new Object[0]);
    }

    public void m() {
        a(this.BU, "video_skip", new Object[0]);
    }

    public void n() {
        a(this.BU, "video_start", new Object[0]);
    }

    public void a(boolean z) {
        a("ad", this.BU, "onclick", z, new Object[0]);
    }

    public static void a(String str, a aVar, Object obj, boolean z, Object... objArr) {
        String str2 = aVar.f1012a;
        String str3 = aVar.c;
        ((a.a.a.a.v.f.e) BT).b.obtainMessage(0, new e.a(str, new JSONObject(new b(aVar.b, str2, aVar.d, str3, obj, z, objArr)))).sendToTarget();
    }
}
