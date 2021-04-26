package a.a.a.d;

import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.cloudbase.plugin.DownSoHelper;
import d.a.k.b.c.a;
import d.a.k.d.b;
import java.io.File;
/* loaded from: classes.dex */
public class ac extends a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f1445a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1446b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ File f1447c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ File f1448d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1449e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ DownSoHelper f1450f;

    public ac(DownSoHelper downSoHelper, b bVar, String str, File file, File file2, String str2) {
        this.f1450f = downSoHelper;
        this.f1445a = bVar;
        this.f1446b = str;
        this.f1447c = file;
        this.f1448d = file2;
        this.f1449e = str2;
    }

    @Override // d.a.k.b.c.a
    public void onCompleted(String str) {
        try {
            this.f1447c.renameTo(this.f1448d);
            d.a.k.e.a.e(this.f1448d, this.f1449e);
            this.f1450f.h(this.f1445a, this.f1446b, this.f1449e);
        } catch (Exception e2) {
            e2.printStackTrace();
            d.a.k.e.a.b(this.f1448d.getAbsolutePath());
            if (d.a.k.e.a.c(this.f1449e)) {
                d.a.k.e.a.a(new File(this.f1449e));
            }
            this.f1450f.e(this.f1445a, this.f1446b, 108, "unzip exception");
        }
    }

    @Override // d.a.k.b.c.a
    public void onFailed(DownloadException downloadException) {
        downloadException.printStackTrace();
        d.a.k.e.a.b(this.f1447c.getAbsolutePath());
        this.f1450f.e(this.f1445a, this.f1446b, downloadException.getErrorCode(), downloadException.getErrorMessage());
    }

    @Override // d.a.k.b.c.a
    public void onProgress(long j, long j2, int i2) {
        this.f1450f.f(this.f1445a, this.f1446b, i2);
    }

    @Override // d.a.k.b.c.a
    public void onStarted() {
        this.f1450f.g(this.f1445a, this.f1446b);
    }
}
