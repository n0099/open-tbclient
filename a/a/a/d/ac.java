package a.a.a.d;

import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.cloudbase.plugin.DownSoHelper;
import d.b.k.b.c.a;
import d.b.k.d.b;
import java.io.File;
/* loaded from: classes.dex */
public class ac extends a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f1426a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1427b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ File f1428c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ File f1429d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1430e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ DownSoHelper f1431f;

    public ac(DownSoHelper downSoHelper, b bVar, String str, File file, File file2, String str2) {
        this.f1431f = downSoHelper;
        this.f1426a = bVar;
        this.f1427b = str;
        this.f1428c = file;
        this.f1429d = file2;
        this.f1430e = str2;
    }

    @Override // d.b.k.b.c.a
    public void onCompleted(String str) {
        try {
            this.f1428c.renameTo(this.f1429d);
            d.b.k.e.a.e(this.f1429d, this.f1430e);
            this.f1431f.h(this.f1426a, this.f1427b, this.f1430e);
        } catch (Exception e2) {
            e2.printStackTrace();
            d.b.k.e.a.b(this.f1429d.getAbsolutePath());
            if (d.b.k.e.a.c(this.f1430e)) {
                d.b.k.e.a.a(new File(this.f1430e));
            }
            this.f1431f.e(this.f1426a, this.f1427b, 108, "unzip exception");
        }
    }

    @Override // d.b.k.b.c.a
    public void onFailed(DownloadException downloadException) {
        downloadException.printStackTrace();
        d.b.k.e.a.b(this.f1428c.getAbsolutePath());
        this.f1431f.e(this.f1426a, this.f1427b, downloadException.getErrorCode(), downloadException.getErrorMessage());
    }

    @Override // d.b.k.b.c.a
    public void onProgress(long j, long j2, int i) {
        this.f1431f.f(this.f1426a, this.f1427b, i);
    }

    @Override // d.b.k.b.c.a
    public void onStarted() {
        this.f1431f.g(this.f1426a, this.f1427b);
    }
}
