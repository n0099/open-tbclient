package a.a.a.c.b;

import a.a.a.c.a.ac;
import a.a.a.c.a.bv;
import com.baidu.cloudbase.download.exception.DownloadException;
import d.a.k.b.b;
import d.a.k.b.c.d;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class shuoy implements d, ac.bv, bv.InterfaceC0006bv {

    /* renamed from: a  reason: collision with root package name */
    public b f1424a;

    /* renamed from: b  reason: collision with root package name */
    public ac f1425b;

    /* renamed from: c  reason: collision with root package name */
    public Executor f1426c;

    /* renamed from: d  reason: collision with root package name */
    public String f1427d;

    /* renamed from: e  reason: collision with root package name */
    public a.a.a.c.bv f1428e;

    /* renamed from: f  reason: collision with root package name */
    public d.a f1429f;

    /* renamed from: g  reason: collision with root package name */
    public int f1430g;

    /* renamed from: h  reason: collision with root package name */
    public bv f1431h;

    /* renamed from: i  reason: collision with root package name */
    public a.a.a.c.a.ac f1432i;
    public List<a.a.a.c.a.bv> j = new LinkedList();

    public shuoy(b bVar, ac acVar, Executor executor, String str, a.a.a.c.bv bvVar, d.a aVar) {
        this.f1424a = bVar;
        this.f1425b = acVar;
        this.f1426c = executor;
        this.f1427d = str;
        this.f1428e = bvVar;
        this.f1429f = aVar;
        this.f1431h = new bv(bVar.b().toString(), this.f1424a.c(), this.f1424a.a());
    }

    public final void a() {
        bv bvVar = this.f1431h;
        File file = new File(bvVar.f1417b, bvVar.f1416a);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    public void a(long j, long j2) {
        ac acVar = this.f1425b;
        acVar.f1411b.n(j);
        acVar.f1411b.o(j2);
        acVar.f1411b.p((int) ((100 * j) / j2));
        acVar.f1411b.r(104);
        acVar.f1410a.post(acVar.f1411b);
    }

    public void a(DownloadException downloadException) {
        if (((adfad) this.f1432i).b()) {
            b();
            return;
        }
        if (((adfad) this.f1432i).f1414c == 106) {
            d();
            return;
        }
        this.f1430g = 108;
        ac acVar = this.f1425b;
        acVar.f1411b.m(downloadException);
        acVar.f1411b.r(108);
        acVar.f1410a.post(acVar.f1411b);
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
            if (((uiou) it.next()).f1440e != 105) {
                z = false;
                continue;
            }
            if (!z) {
                z = false;
                break;
            }
        }
        if (z) {
            this.f1430g = 105;
            ac acVar = this.f1425b;
            acVar.f1411b.r(105);
            acVar.f1411b.q(str);
            acVar.f1410a.post(acVar.f1411b);
            onDestroy();
        }
    }

    public void b() {
        a();
        this.f1430g = 107;
        ac acVar = this.f1425b;
        acVar.f1411b.r(107);
        acVar.f1410a.post(acVar.f1411b);
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
            this.f1430g = 108;
            ac acVar = this.f1425b;
            acVar.f1411b.m(downloadException);
            acVar.f1411b.r(108);
            acVar.f1410a.post(acVar.f1411b);
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
            this.f1430g = 107;
            ac acVar = this.f1425b;
            acVar.f1411b.r(107);
            acVar.f1410a.post(acVar.f1411b);
            onDestroy();
        }
    }

    @Override // d.a.k.b.c.d
    public void cancel() {
        a.a.a.c.a.ac acVar = this.f1432i;
        if (acVar != null) {
            ((adfad) acVar).f1414c = 107;
        }
        Iterator<a.a.a.c.a.bv> it = this.j.iterator();
        while (it.hasNext()) {
            ((uiou) it.next()).f1441f = 107;
        }
        if (this.f1430g != 104) {
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
            this.f1430g = 106;
            ac acVar = this.f1425b;
            acVar.f1411b.r(106);
            acVar.f1410a.post(acVar.f1411b);
            onDestroy();
        }
    }

    @Override // d.a.k.b.c.d
    public boolean isRunning() {
        int i2 = this.f1430g;
        return i2 == 101 || i2 == 102 || i2 == 103 || i2 == 104;
    }

    public void onDestroy() {
        this.f1429f.a(this.f1427d, this);
    }

    @Override // d.a.k.b.c.d
    public void pause() {
        a.a.a.c.a.ac acVar = this.f1432i;
        if (acVar != null) {
            ((adfad) acVar).f1414c = 106;
        }
        Iterator<a.a.a.c.a.bv> it = this.j.iterator();
        while (it.hasNext()) {
            ((uiou) it.next()).f1441f = 106;
        }
        if (this.f1430g != 104) {
            d();
        }
    }

    @Override // d.a.k.b.c.d
    public void start() {
        this.f1430g = 101;
        ac acVar = this.f1425b;
        acVar.f1411b.r(101);
        acVar.f1411b.a().onStarted();
        adfad adfadVar = new adfad(this.f1424a.c(), this);
        this.f1432i = adfadVar;
        this.f1426c.execute(adfadVar);
    }
}
