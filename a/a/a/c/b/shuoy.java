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
public class shuoy implements d, ac.bv, bv.InterfaceC0007bv {

    /* renamed from: a  reason: collision with root package name */
    public b f1437a;

    /* renamed from: b  reason: collision with root package name */
    public ac f1438b;

    /* renamed from: c  reason: collision with root package name */
    public Executor f1439c;

    /* renamed from: d  reason: collision with root package name */
    public String f1440d;

    /* renamed from: e  reason: collision with root package name */
    public a.a.a.c.bv f1441e;

    /* renamed from: f  reason: collision with root package name */
    public d.a f1442f;

    /* renamed from: g  reason: collision with root package name */
    public int f1443g;

    /* renamed from: h  reason: collision with root package name */
    public bv f1444h;

    /* renamed from: i  reason: collision with root package name */
    public a.a.a.c.a.ac f1445i;
    public List<a.a.a.c.a.bv> j = new LinkedList();

    public shuoy(b bVar, ac acVar, Executor executor, String str, a.a.a.c.bv bvVar, d.a aVar) {
        this.f1437a = bVar;
        this.f1438b = acVar;
        this.f1439c = executor;
        this.f1440d = str;
        this.f1441e = bvVar;
        this.f1442f = aVar;
        this.f1444h = new bv(bVar.b().toString(), this.f1437a.c(), this.f1437a.a());
    }

    public final void a() {
        bv bvVar = this.f1444h;
        File file = new File(bvVar.f1430b, bvVar.f1429a);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    public void a(long j, long j2) {
        ac acVar = this.f1438b;
        acVar.f1424b.n(j);
        acVar.f1424b.o(j2);
        acVar.f1424b.p((int) ((100 * j) / j2));
        acVar.f1424b.r(104);
        acVar.f1423a.post(acVar.f1424b);
    }

    public void a(DownloadException downloadException) {
        if (((adfad) this.f1445i).b()) {
            b();
            return;
        }
        if (((adfad) this.f1445i).f1427c == 106) {
            d();
            return;
        }
        this.f1443g = 108;
        ac acVar = this.f1438b;
        acVar.f1424b.m(downloadException);
        acVar.f1424b.r(108);
        acVar.f1423a.post(acVar.f1424b);
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
            if (((uiou) it.next()).f1453e != 105) {
                z = false;
                continue;
            }
            if (!z) {
                z = false;
                break;
            }
        }
        if (z) {
            this.f1443g = 105;
            ac acVar = this.f1438b;
            acVar.f1424b.r(105);
            acVar.f1424b.q(str);
            acVar.f1423a.post(acVar.f1424b);
            onDestroy();
        }
    }

    public void b() {
        a();
        this.f1443g = 107;
        ac acVar = this.f1438b;
        acVar.f1424b.r(107);
        acVar.f1423a.post(acVar.f1424b);
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
            this.f1443g = 108;
            ac acVar = this.f1438b;
            acVar.f1424b.m(downloadException);
            acVar.f1424b.r(108);
            acVar.f1423a.post(acVar.f1424b);
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
            this.f1443g = 107;
            ac acVar = this.f1438b;
            acVar.f1424b.r(107);
            acVar.f1423a.post(acVar.f1424b);
            onDestroy();
        }
    }

    @Override // d.a.k.b.c.d
    public void cancel() {
        a.a.a.c.a.ac acVar = this.f1445i;
        if (acVar != null) {
            ((adfad) acVar).f1427c = 107;
        }
        Iterator<a.a.a.c.a.bv> it = this.j.iterator();
        while (it.hasNext()) {
            ((uiou) it.next()).f1454f = 107;
        }
        if (this.f1443g != 104) {
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
            this.f1443g = 106;
            ac acVar = this.f1438b;
            acVar.f1424b.r(106);
            acVar.f1423a.post(acVar.f1424b);
            onDestroy();
        }
    }

    @Override // d.a.k.b.c.d
    public boolean isRunning() {
        int i2 = this.f1443g;
        return i2 == 101 || i2 == 102 || i2 == 103 || i2 == 104;
    }

    public void onDestroy() {
        this.f1442f.a(this.f1440d, this);
    }

    @Override // d.a.k.b.c.d
    public void pause() {
        a.a.a.c.a.ac acVar = this.f1445i;
        if (acVar != null) {
            ((adfad) acVar).f1427c = 106;
        }
        Iterator<a.a.a.c.a.bv> it = this.j.iterator();
        while (it.hasNext()) {
            ((uiou) it.next()).f1454f = 106;
        }
        if (this.f1443g != 104) {
            d();
        }
    }

    @Override // d.a.k.b.c.d
    public void start() {
        this.f1443g = 101;
        ac acVar = this.f1438b;
        acVar.f1424b.r(101);
        acVar.f1424b.a().onStarted();
        adfad adfadVar = new adfad(this.f1437a.c(), this);
        this.f1445i = adfadVar;
        this.f1439c.execute(adfadVar);
    }
}
