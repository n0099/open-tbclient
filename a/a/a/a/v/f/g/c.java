package a.a.a.a.v.f.g;

import a.a.a.a.s.e;
import a.a.a.a.v.f.e;
import androidx.core.app.NotificationCompat;
import com.fun.ad.sdk.FunAdSlot;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final a.a.a.a.v.f.d f1390b = a.a.a.a.v.f.d.a();

    /* renamed from: a  reason: collision with root package name */
    public final a f1391a = new a();

    public static void a(a aVar, Object obj, Object... objArr) {
        a("ad", aVar, obj, false, objArr);
    }

    public void a() {
        a(this.f1391a, "left_app", new Object[0]);
    }

    public void a(int i) {
        a(this.f1391a, "render_failed", NotificationCompat.CATEGORY_ERROR, Integer.valueOf(i));
    }

    public void a(FunAdSlot funAdSlot, e.a aVar) {
        a aVar2 = this.f1391a;
        String sid = funAdSlot.getSid();
        long currentTimeMillis = System.currentTimeMillis();
        String str = aVar.f1334c;
        String str2 = aVar.f1335d;
        aVar2.f1379a = sid;
        aVar2.f1380b = currentTimeMillis;
        aVar2.f1381c = str;
        aVar2.f1382d = str2;
        a(this.f1391a, "ld_start", new Object[0]);
    }

    public void a(Object obj) {
        a(this.f1391a, "ld_err", NotificationCompat.CATEGORY_ERROR, obj);
    }

    public void b() {
        a(this.f1391a, "ld_succeed", new Object[0]);
    }

    public void b(int i) {
        a(this.f1391a, "video_err", NotificationCompat.CATEGORY_ERROR, Integer.valueOf(i));
    }

    public void b(Object obj) {
        a(this.f1391a, "sh_failed", NotificationCompat.CATEGORY_ERROR, obj);
    }

    public void b(boolean z) {
        a("ad", this.f1391a, "sh_succeed", z, new Object[0]);
    }

    public void c() {
        a(this.f1391a, "oncached", new Object[0]);
    }

    public void d() {
        a(this.f1391a, "onclosed", new Object[0]);
    }

    public void e() {
        a(this.f1391a, "render_succeed", new Object[0]);
    }

    public void f() {
        a(this.f1391a, "reward", new Object[0]);
    }

    public void g() {
        a(this.f1391a, "sh_start", new Object[0]);
    }

    public void h() {
        a(this.f1391a, "unlike_selected", new Object[0]);
    }

    public void i() {
        a(this.f1391a, "video_complete", new Object[0]);
    }

    public void j() {
        a(this.f1391a, "video_err", new Object[0]);
    }

    public void k() {
        a(this.f1391a, "video_pause", new Object[0]);
    }

    public void l() {
        a(this.f1391a, "video_resume", new Object[0]);
    }

    public void m() {
        a(this.f1391a, "video_skip", new Object[0]);
    }

    public void n() {
        a(this.f1391a, "video_start", new Object[0]);
    }

    public void a(boolean z) {
        a("ad", this.f1391a, "onclick", z, new Object[0]);
    }

    public static void a(String str, a aVar, Object obj, boolean z, Object... objArr) {
        String str2 = aVar.f1379a;
        String str3 = aVar.f1381c;
        ((a.a.a.a.v.f.e) f1390b).f1372b.obtainMessage(0, new e.a(str, new JSONObject(new b(aVar.f1380b, str2, aVar.f1382d, str3, obj, z, objArr)))).sendToTarget();
    }
}
