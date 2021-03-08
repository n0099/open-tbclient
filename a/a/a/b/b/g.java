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
/* loaded from: classes9.dex */
public class g implements a.InterfaceC0006a, b.a, com.baidu.cloudbase.download.a.d {
    public com.baidu.cloudbase.download.b BZ;
    public a Ca;
    public a.a.a.b.b Cb;
    public d.a Cc;
    public c Cd;
    public a.a.a.b.a.a Ce;
    public Executor c;
    public String d;
    public int g;
    public List<a.a.a.b.a.b> j = new LinkedList();

    public g(com.baidu.cloudbase.download.b bVar, a aVar, Executor executor, String str, a.a.a.b.b bVar2, d.a aVar2) {
        this.BZ = bVar;
        this.Ca = aVar;
        this.c = executor;
        this.d = str;
        this.Cb = bVar2;
        this.Cc = aVar2;
        this.Cd = new c(this.BZ.getName().toString(), this.BZ.getUri(), this.BZ.getFolder());
    }

    public final void a() {
        c cVar = this.Cd;
        File file = new File(cVar.b, cVar.f1018a);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    public void a(long j, long j2) {
        a aVar = this.Ca;
        aVar.BX.setFinished(j);
        aVar.BX.setLength(j2);
        aVar.BX.setPercent((int) ((100 * j) / j2));
        aVar.BX.setStatus(104);
        aVar.BW.a(aVar.BX);
    }

    public void a(DownloadException downloadException) {
        if (((b) this.Ce).b()) {
            b();
            return;
        }
        if (((b) this.Ce).c == 106) {
            d();
            return;
        }
        this.g = 108;
        a aVar = this.Ca;
        aVar.BX.d(downloadException);
        aVar.BX.setStatus(108);
        aVar.BW.a(aVar.BX);
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
            a aVar = this.Ca;
            aVar.BX.setStatus(105);
            aVar.BX.setSavedPath(str);
            aVar.BW.a(aVar.BX);
            onDestroy();
        }
    }

    public void b() {
        a();
        this.g = 107;
        a aVar = this.Ca;
        aVar.BX.setStatus(107);
        aVar.BW.a(aVar.BX);
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
            a aVar = this.Ca;
            aVar.BX.d(downloadException);
            aVar.BX.setStatus(108);
            aVar.BW.a(aVar.BX);
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
            a aVar = this.Ca;
            aVar.BX.setStatus(107);
            aVar.BW.a(aVar.BX);
            onDestroy();
        }
    }

    @Override // com.baidu.cloudbase.download.a.d
    public void cancel() {
        a.a.a.b.a.a aVar = this.Ce;
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
            a aVar = this.Ca;
            aVar.BX.setStatus(106);
            aVar.BW.a(aVar.BX);
            onDestroy();
        }
    }

    @Override // com.baidu.cloudbase.download.a.d
    public boolean isRunning() {
        int i = this.g;
        return i == 101 || i == 102 || i == 103 || i == 104;
    }

    public void onDestroy() {
        this.Cc.a(this.d, this);
    }

    @Override // com.baidu.cloudbase.download.a.d
    public void pause() {
        a.a.a.b.a.a aVar = this.Ce;
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
        a aVar = this.Ca;
        aVar.BX.setStatus(101);
        aVar.BX.tY().onStarted();
        this.Ce = new b(this.BZ.getUri(), this);
        this.c.execute(this.Ce);
    }
}
