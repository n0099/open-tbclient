package a.a.a.b.b;

import a.a.a.b.a.a;
import a.a.a.b.a.b;
import com.baidu.cloudbase.download.a.d;
import com.baidu.cloudbase.download.exception.DownloadException;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes10.dex */
public class g implements a.InterfaceC0000a, b.a, com.baidu.cloudbase.download.a.d {
    public Executor c;
    public String d;
    public int g;
    public List<a.a.a.b.a.b> j = new LinkedList();
    public com.baidu.cloudbase.download.b zn;
    public a zo;
    public a.a.a.b.b zp;
    public d.a zq;
    public c zr;
    public a.a.a.b.a.a zs;

    public g(com.baidu.cloudbase.download.b bVar, a aVar, Executor executor, String str, a.a.a.b.b bVar2, d.a aVar2) {
        this.zn = bVar;
        this.zo = aVar;
        this.c = executor;
        this.d = str;
        this.zp = bVar2;
        this.zq = aVar2;
        this.zr = new c(this.zn.getName().toString(), this.zn.getUri(), this.zn.getFolder());
    }

    public final void a() {
        c cVar = this.zr;
        File file = new File(cVar.f1038b, cVar.f1037a);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    public void a(long j, long j2) {
        a aVar = this.zo;
        aVar.zl.setFinished(j);
        aVar.zl.setLength(j2);
        aVar.zl.setPercent((int) ((100 * j) / j2));
        aVar.zl.setStatus(104);
        aVar.zk.a(aVar.zl);
    }

    public void a(DownloadException downloadException) {
        if (((b) this.zs).b()) {
            b();
            return;
        }
        if (((b) this.zs).c == 106) {
            d();
            return;
        }
        this.g = 108;
        a aVar = this.zo;
        aVar.zl.d(downloadException);
        aVar.zl.setStatus(108);
        aVar.zk.a(aVar.zl);
        onDestroy();
    }

    public void a(String str) {
        boolean z;
        boolean z2;
        Iterator<a.a.a.b.a.b> it = this.j.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            if (((i) it.next()).e == 105) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (!z2) {
                z = false;
                break;
            }
        }
        if (z) {
            this.g = 105;
            a aVar = this.zo;
            aVar.zl.setStatus(105);
            aVar.zl.setSavedPath(str);
            aVar.zk.a(aVar.zl);
            onDestroy();
        }
    }

    public void b() {
        a();
        this.g = 107;
        a aVar = this.zo;
        aVar.zl.setStatus(107);
        aVar.zk.a(aVar.zl);
        onDestroy();
    }

    public void b(DownloadException downloadException) {
        boolean z;
        Iterator<a.a.a.b.a.b> it = this.j.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (((i) it.next()).d()) {
                z = false;
                break;
            }
        }
        if (z) {
            this.g = 108;
            a aVar = this.zo;
            aVar.zl.d(downloadException);
            aVar.zl.setStatus(108);
            aVar.zk.a(aVar.zl);
            onDestroy();
        }
    }

    public void c() {
        boolean z;
        Iterator<a.a.a.b.a.b> it = this.j.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (((i) it.next()).d()) {
                z = false;
                break;
            }
        }
        if (z) {
            a();
            this.g = 107;
            a aVar = this.zo;
            aVar.zl.setStatus(107);
            aVar.zk.a(aVar.zl);
            onDestroy();
        }
    }

    @Override // com.baidu.cloudbase.download.a.d
    public void cancel() {
        a.a.a.b.a.a aVar = this.zs;
        if (aVar != null) {
            ((b) aVar).c = 107;
        }
        Iterator<a.a.a.b.a.b> it = this.j.iterator();
        while (it.hasNext()) {
            ((i) it.next()).f = 107;
        }
        if (this.g != 104) {
            c();
        }
    }

    public void d() {
        boolean z;
        Iterator<a.a.a.b.a.b> it = this.j.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (((i) it.next()).d()) {
                z = false;
                break;
            }
        }
        if (z) {
            this.g = 106;
            a aVar = this.zo;
            aVar.zl.setStatus(106);
            aVar.zk.a(aVar.zl);
            onDestroy();
        }
    }

    @Override // com.baidu.cloudbase.download.a.d
    public boolean isRunning() {
        int i = this.g;
        return i == 101 || i == 102 || i == 103 || i == 104;
    }

    public void onDestroy() {
        this.zq.a(this.d, this);
    }

    @Override // com.baidu.cloudbase.download.a.d
    public void pause() {
        a.a.a.b.a.a aVar = this.zs;
        if (aVar != null) {
            ((b) aVar).c = 106;
        }
        Iterator<a.a.a.b.a.b> it = this.j.iterator();
        while (it.hasNext()) {
            ((i) it.next()).f = 106;
        }
        if (this.g != 104) {
            d();
        }
    }

    @Override // com.baidu.cloudbase.download.a.d
    public void start() {
        this.g = 101;
        a aVar = this.zo;
        aVar.zl.setStatus(101);
        aVar.zl.ui().onStarted();
        this.zs = new b(this.zn.getUri(), this);
        this.c.execute(this.zs);
    }
}
