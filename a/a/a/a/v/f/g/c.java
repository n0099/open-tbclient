package a.a.a.a.v.f.g;

import a.a.a.a.s.e;
import a.a.a.a.v.f.e;
import androidx.core.app.NotificationCompat;
import com.fun.ad.sdk.FunAdSlot;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final a.a.a.a.v.f.d f1376b = a.a.a.a.v.f.d.a();

    /* renamed from: a  reason: collision with root package name */
    public final a f1377a = new a();

    public static void a(a aVar, Object obj, Object... objArr) {
        a("ad", aVar, obj, false, objArr);
    }

    public void a() {
        a(this.f1377a, "left_app", new Object[0]);
    }

    public void a(int i) {
        a(this.f1377a, "render_failed", NotificationCompat.CATEGORY_ERROR, Integer.valueOf(i));
    }

    public void a(FunAdSlot funAdSlot, e.a aVar) {
        a aVar2 = this.f1377a;
        String sid = funAdSlot.getSid();
        long currentTimeMillis = System.currentTimeMillis();
        String str = aVar.f1320c;
        String str2 = aVar.f1321d;
        aVar2.f1365a = sid;
        aVar2.f1366b = currentTimeMillis;
        aVar2.f1367c = str;
        aVar2.f1368d = str2;
        a(this.f1377a, "ld_start", new Object[0]);
    }

    public void a(Object obj) {
        a(this.f1377a, "ld_err", NotificationCompat.CATEGORY_ERROR, obj);
    }

    public void b() {
        a(this.f1377a, "ld_succeed", new Object[0]);
    }

    public void b(int i) {
        a(this.f1377a, "video_err", NotificationCompat.CATEGORY_ERROR, Integer.valueOf(i));
    }

    public void b(Object obj) {
        a(this.f1377a, "sh_failed", NotificationCompat.CATEGORY_ERROR, obj);
    }

    public void b(boolean z) {
        a("ad", this.f1377a, "sh_succeed", z, new Object[0]);
    }

    public void c() {
        a(this.f1377a, "oncached", new Object[0]);
    }

    public void d() {
        a(this.f1377a, "onclosed", new Object[0]);
    }

    public void e() {
        a(this.f1377a, "render_succeed", new Object[0]);
    }

    public void f() {
        a(this.f1377a, "reward", new Object[0]);
    }

    public void g() {
        a(this.f1377a, "sh_start", new Object[0]);
    }

    public void h() {
        a(this.f1377a, "unlike_selected", new Object[0]);
    }

    public void i() {
        a(this.f1377a, "video_complete", new Object[0]);
    }

    public void j() {
        a(this.f1377a, "video_err", new Object[0]);
    }

    public void k() {
        a(this.f1377a, "video_pause", new Object[0]);
    }

    public void l() {
        a(this.f1377a, "video_resume", new Object[0]);
    }

    public void m() {
        a(this.f1377a, "video_skip", new Object[0]);
    }

    public void n() {
        a(this.f1377a, "video_start", new Object[0]);
    }

    public void a(boolean z) {
        a("ad", this.f1377a, "onclick", z, new Object[0]);
    }

    public static void a(String str, a aVar, Object obj, boolean z, Object... objArr) {
        String str2 = aVar.f1365a;
        String str3 = aVar.f1367c;
        ((a.a.a.a.v.f.e) f1376b).f1358b.obtainMessage(0, new e.a(str, new JSONObject(new b(aVar.f1366b, str2, aVar.f1368d, str3, obj, z, objArr)))).sendToTarget();
    }
}
