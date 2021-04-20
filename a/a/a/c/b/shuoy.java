package a.a.a.c.b;

import a.a.a.c.a.ac;
import a.a.a.c.a.bv;
import com.baidu.cloudbase.download.exception.DownloadException;
import d.b.k.b.b;
import d.b.k.b.c.d;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class shuoy implements d, ac.bv, bv.InterfaceC0006bv {

    /* renamed from: a  reason: collision with root package name */
    public b f1406a;

    /* renamed from: b  reason: collision with root package name */
    public ac f1407b;

    /* renamed from: c  reason: collision with root package name */
    public Executor f1408c;

    /* renamed from: d  reason: collision with root package name */
    public String f1409d;

    /* renamed from: e  reason: collision with root package name */
    public a.a.a.c.bv f1410e;

    /* renamed from: f  reason: collision with root package name */
    public d.a f1411f;

    /* renamed from: g  reason: collision with root package name */
    public int f1412g;

    /* renamed from: h  reason: collision with root package name */
    public bv f1413h;
    public a.a.a.c.a.ac i;
    public List<a.a.a.c.a.bv> j = new LinkedList();

    public shuoy(b bVar, ac acVar, Executor executor, String str, a.a.a.c.bv bvVar, d.a aVar) {
        this.f1406a = bVar;
        this.f1407b = acVar;
        this.f1408c = executor;
        this.f1409d = str;
        this.f1410e = bvVar;
        this.f1411f = aVar;
        this.f1413h = new bv(bVar.b().toString(), this.f1406a.c(), this.f1406a.a());
    }

    public final void a() {
        bv bvVar = this.f1413h;
        File file = new File(bvVar.f1399b, bvVar.f1398a);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    public void a(long j, long j2) {
        ac acVar = this.f1407b;
        acVar.f1393b.n(j);
        acVar.f1393b.o(j2);
        acVar.f1393b.p((int) ((100 * j) / j2));
        acVar.f1393b.r(104);
        acVar.f1392a.post(acVar.f1393b);
    }

    public void a(DownloadException downloadException) {
        if (((adfad) this.i).b()) {
            b();
            return;
        }
        if (((adfad) this.i).f1396c == 106) {
            d();
            return;
        }
        this.f1412g = 108;
        ac acVar = this.f1407b;
        acVar.f1393b.m(downloadException);
        acVar.f1393b.r(108);
        acVar.f1392a.post(acVar.f1393b);
        onDestroy();
    }

    public void a(String str) {
        boolean z;
        Iterator<a.a.a.c.a.bv> it = this.j.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            if (((uiou) it.next()).f1421e != 105) {
                z = false;
                continue;
            }
            if (!z) {
                z = false;
                break;
            }
        }
        if (z) {
            this.f1412g = 105;
            ac acVar = this.f1407b;
            acVar.f1393b.r(105);
            acVar.f1393b.q(str);
            acVar.f1392a.post(acVar.f1393b);
            onDestroy();
        }
    }

    public void b() {
        a();
        this.f1412g = 107;
        ac acVar = this.f1407b;
        acVar.f1393b.r(107);
        acVar.f1392a.post(acVar.f1393b);
        onDestroy();
    }

    public void b(DownloadException downloadException) {
        boolean z;
        Iterator<a.a.a.c.a.bv> it = this.j.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (((uiou) it.next()).d()) {
                z = false;
                break;
            }
        }
        if (z) {
            this.f1412g = 108;
            ac acVar = this.f1407b;
            acVar.f1393b.m(downloadException);
            acVar.f1393b.r(108);
            acVar.f1392a.post(acVar.f1393b);
            onDestroy();
        }
    }

    public void c() {
        boolean z;
        Iterator<a.a.a.c.a.bv> it = this.j.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (((uiou) it.next()).d()) {
                z = false;
                break;
            }
        }
        if (z) {
            a();
            this.f1412g = 107;
            ac acVar = this.f1407b;
            acVar.f1393b.r(107);
            acVar.f1392a.post(acVar.f1393b);
            onDestroy();
        }
    }

    @Override // d.b.k.b.c.d
    public void cancel() {
        a.a.a.c.a.ac acVar = this.i;
        if (acVar != null) {
            ((adfad) acVar).f1396c = 107;
        }
        Iterator<a.a.a.c.a.bv> it = this.j.iterator();
        while (it.hasNext()) {
            ((uiou) it.next()).f1422f = 107;
        }
        if (this.f1412g != 104) {
            c();
        }
    }

    public void d() {
        boolean z;
        Iterator<a.a.a.c.a.bv> it = this.j.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (((uiou) it.next()).d()) {
                z = false;
                break;
            }
        }
        if (z) {
            this.f1412g = 106;
            ac acVar = this.f1407b;
            acVar.f1393b.r(106);
            acVar.f1392a.post(acVar.f1393b);
            onDestroy();
        }
    }

    @Override // d.b.k.b.c.d
    public boolean isRunning() {
        int i = this.f1412g;
        return i == 101 || i == 102 || i == 103 || i == 104;
    }

    public void onDestroy() {
        this.f1411f.a(this.f1409d, this);
    }

    @Override // d.b.k.b.c.d
    public void pause() {
        a.a.a.c.a.ac acVar = this.i;
        if (acVar != null) {
            ((adfad) acVar).f1396c = 106;
        }
        Iterator<a.a.a.c.a.bv> it = this.j.iterator();
        while (it.hasNext()) {
            ((uiou) it.next()).f1422f = 106;
        }
        if (this.f1412g != 104) {
            d();
        }
    }

    @Override // d.b.k.b.c.d
    public void start() {
        this.f1412g = 101;
        ac acVar = this.f1407b;
        acVar.f1393b.r(101);
        acVar.f1393b.a().onStarted();
        adfad adfadVar = new adfad(this.f1406a.c(), this);
        this.i = adfadVar;
        this.f1408c.execute(adfadVar);
    }
}
