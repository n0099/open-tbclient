package a.a.a.d;

import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.cloudbase.plugin.DownSoHelper;
import d.b.k.b.c.a;
import d.b.k.d.b;
import java.io.File;
/* loaded from: classes.dex */
public class ac extends a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f1440a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1441b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ File f1442c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ File f1443d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1444e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ DownSoHelper f1445f;

    public ac(DownSoHelper downSoHelper, b bVar, String str, File file, File file2, String str2) {
        this.f1445f = downSoHelper;
        this.f1440a = bVar;
        this.f1441b = str;
        this.f1442c = file;
        this.f1443d = file2;
        this.f1444e = str2;
    }

    @Override // d.b.k.b.c.a
    public void onCompleted(String str) {
        try {
            this.f1442c.renameTo(this.f1443d);
            d.b.k.e.a.e(this.f1443d, this.f1444e);
            this.f1445f.h(this.f1440a, this.f1441b, this.f1444e);
        } catch (Exception e2) {
            e2.printStackTrace();
            d.b.k.e.a.b(this.f1443d.getAbsolutePath());
            if (d.b.k.e.a.c(this.f1444e)) {
                d.b.k.e.a.a(new File(this.f1444e));
            }
            this.f1445f.e(this.f1440a, this.f1441b, 108, "unzip exception");
        }
    }

    @Override // d.b.k.b.c.a
    public void onFailed(DownloadException downloadException) {
        downloadException.printStackTrace();
        d.b.k.e.a.b(this.f1442c.getAbsolutePath());
        this.f1445f.e(this.f1440a, this.f1441b, downloadException.getErrorCode(), downloadException.getErrorMessage());
    }

    @Override // d.b.k.b.c.a
    public void onProgress(long j, long j2, int i) {
        this.f1445f.f(this.f1440a, this.f1441b, i);
    }

    @Override // d.b.k.b.c.a
    public void onStarted() {
        this.f1445f.g(this.f1440a, this.f1441b);
    }
}
