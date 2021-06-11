package a.a.a.a.y.f.g;

import a.a.a.a.v.e;
import androidx.core.app.NotificationCompat;
import com.fun.ad.sdk.FunAdSlot;
/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final a.a.a.a.y.f.d f1405b = a.a.a.a.y.f.d.a();

    /* renamed from: a  reason: collision with root package name */
    public final a f1406a = new a();

    public static void a(a aVar, Object obj, Object... objArr) {
        String str = aVar.f1394a;
        String str2 = aVar.f1396c;
        f1405b.a("ad", new b(aVar.f1395b, str, aVar.f1397d, str2, obj, false, objArr));
    }

    public void a() {
        a(this.f1406a, "left_app", new Object[0]);
    }

    public void a(int i2) {
        a(this.f1406a, "render_failed", NotificationCompat.CATEGORY_ERROR, Integer.valueOf(i2));
    }

    public void a(Object obj) {
        a(this.f1406a, "ld_err", NotificationCompat.CATEGORY_ERROR, obj);
    }

    public void a(boolean z) {
        a(z, this.f1406a, "onclick", new Object[0]);
    }

    public void b() {
        a(this.f1406a, "ld_succeed", new Object[0]);
    }

    public void b(int i2) {
        a(this.f1406a, "video_err", NotificationCompat.CATEGORY_ERROR, Integer.valueOf(i2));
    }

    public void b(Object obj) {
        a(this.f1406a, "sh_failed", NotificationCompat.CATEGORY_ERROR, obj);
    }

    public void b(boolean z) {
        a(z, this.f1406a, "sh_succeed", new Object[0]);
    }

    public void c() {
        a(this.f1406a, "oncached", new Object[0]);
    }

    public void d() {
        a(this.f1406a, "onclosed", new Object[0]);
    }

    public void e() {
        a(this.f1406a, "render_succeed", new Object[0]);
    }

    public void f() {
        a(this.f1406a, "reward", new Object[0]);
    }

    public void g() {
        a(this.f1406a, "sh_start", new Object[0]);
    }

    public void h() {
        a(this.f1406a, "splash_skip", new Object[0]);
    }

    public void i() {
        a(this.f1406a, "unlike_selected", new Object[0]);
    }

    public void j() {
        a(this.f1406a, "video_complete", new Object[0]);
    }

    public void k() {
        a(this.f1406a, "video_err", new Object[0]);
    }

    public void l() {
        a(this.f1406a, "video_pause", new Object[0]);
    }

    public void m() {
        a(this.f1406a, "video_resume", new Object[0]);
    }

    public void n() {
        a(this.f1406a, "video_skip", new Object[0]);
    }

    public void o() {
        a(this.f1406a, "video_start", new Object[0]);
    }

    public static void a(boolean z, a aVar, Object obj, Object... objArr) {
        String str = aVar.f1394a;
        String str2 = aVar.f1396c;
        f1405b.a("ad", new b(aVar.f1395b, str, aVar.f1397d, str2, obj, z, objArr));
    }

    public void a(FunAdSlot funAdSlot, e.a aVar) {
        a aVar2 = this.f1406a;
        String sid = funAdSlot.getSid();
        long currentTimeMillis = System.currentTimeMillis();
        String str = aVar.f1342c;
        String str2 = aVar.f1343d;
        aVar2.f1394a = sid;
        aVar2.f1395b = currentTimeMillis;
        aVar2.f1396c = str;
        aVar2.f1397d = str2;
        a(this.f1406a, "ld_start", new Object[0]);
    }
}
