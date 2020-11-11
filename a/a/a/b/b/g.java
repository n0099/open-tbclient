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
public class g implements a.InterfaceC0000a, b.a, com.baidu.cloudbase.download.a.d {
    public Executor c;
    public String d;
    public int g;
    public List<a.a.a.b.a.b> j = new LinkedList();
    public a.a.a.b.b yA;
    public d.a yB;
    public c yC;
    public a.a.a.b.a.a yD;
    public com.baidu.cloudbase.download.b yy;
    public a yz;

    public g(com.baidu.cloudbase.download.b bVar, a aVar, Executor executor, String str, a.a.a.b.b bVar2, d.a aVar2) {
        this.yy = bVar;
        this.yz = aVar;
        this.c = executor;
        this.d = str;
        this.yA = bVar2;
        this.yB = aVar2;
        this.yC = new c(this.yy.getName().toString(), this.yy.getUri(), this.yy.getFolder());
    }

    public final void a() {
        c cVar = this.yC;
        File file = new File(cVar.b, cVar.f955a);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    public void a(long j, long j2) {
        a aVar = this.yz;
        aVar.yw.setFinished(j);
        aVar.yw.setLength(j2);
        aVar.yw.setPercent((int) ((100 * j) / j2));
        aVar.yw.setStatus(104);
        aVar.yv.a(aVar.yw);
    }

    public void a(DownloadException downloadException) {
        if (((b) this.yD).b()) {
            b();
            return;
        }
        if (((b) this.yD).c == 106) {
            d();
            return;
        }
        this.g = 108;
        a aVar = this.yz;
        aVar.yw.d(downloadException);
        aVar.yw.setStatus(108);
        aVar.yv.a(aVar.yw);
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
            a aVar = this.yz;
            aVar.yw.setStatus(105);
            aVar.yw.setSavedPath(str);
            aVar.yv.a(aVar.yw);
            onDestroy();
        }
    }

    public void b() {
        a();
        this.g = 107;
        a aVar = this.yz;
        aVar.yw.setStatus(107);
        aVar.yv.a(aVar.yw);
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
            a aVar = this.yz;
            aVar.yw.d(downloadException);
            aVar.yw.setStatus(108);
            aVar.yv.a(aVar.yw);
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
            a aVar = this.yz;
            aVar.yw.setStatus(107);
            aVar.yv.a(aVar.yw);
            onDestroy();
        }
    }

    @Override // com.baidu.cloudbase.download.a.d
    public void cancel() {
        a.a.a.b.a.a aVar = this.yD;
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
            a aVar = this.yz;
            aVar.yw.setStatus(106);
            aVar.yv.a(aVar.yw);
            onDestroy();
        }
    }

    @Override // com.baidu.cloudbase.download.a.d
    public boolean isRunning() {
        int i = this.g;
        return i == 101 || i == 102 || i == 103 || i == 104;
    }

    public void onDestroy() {
        this.yB.a(this.d, this);
    }

    @Override // com.baidu.cloudbase.download.a.d
    public void pause() {
        a.a.a.b.a.a aVar = this.yD;
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
        a aVar = this.yz;
        aVar.yw.setStatus(101);
        aVar.yw.uH().onStarted();
        this.yD = new b(this.yy.getUri(), this);
        this.c.execute(this.yD);
    }
}
