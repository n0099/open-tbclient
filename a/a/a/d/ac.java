package a.a.a.d;

import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.cloudbase.plugin.DownSoHelper;
import d.a.k.b.c.a;
import d.a.k.d.b;
import java.io.File;
/* loaded from: classes.dex */
public class ac extends a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f1458a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1459b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ File f1460c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ File f1461d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1462e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ DownSoHelper f1463f;

    public ac(DownSoHelper downSoHelper, b bVar, String str, File file, File file2, String str2) {
        this.f1463f = downSoHelper;
        this.f1458a = bVar;
        this.f1459b = str;
        this.f1460c = file;
        this.f1461d = file2;
        this.f1462e = str2;
    }

    @Override // d.a.k.b.c.a
    public void onCompleted(String str) {
        try {
            this.f1460c.renameTo(this.f1461d);
            d.a.k.e.a.e(this.f1461d, this.f1462e);
            this.f1463f.h(this.f1458a, this.f1459b, this.f1462e);
        } catch (Exception e2) {
            e2.printStackTrace();
            d.a.k.e.a.b(this.f1461d.getAbsolutePath());
            if (d.a.k.e.a.c(this.f1462e)) {
                d.a.k.e.a.a(new File(this.f1462e));
            }
            this.f1463f.e(this.f1458a, this.f1459b, 108, "unzip exception");
        }
    }

    @Override // d.a.k.b.c.a
    public void onFailed(DownloadException downloadException) {
        downloadException.printStackTrace();
        d.a.k.e.a.b(this.f1460c.getAbsolutePath());
        this.f1463f.e(this.f1458a, this.f1459b, downloadException.getErrorCode(), downloadException.getErrorMessage());
    }

    @Override // d.a.k.b.c.a
    public void onProgress(long j, long j2, int i2) {
        this.f1463f.f(this.f1458a, this.f1459b, i2);
    }

    @Override // d.a.k.b.c.a
    public void onStarted() {
        this.f1463f.g(this.f1458a, this.f1459b);
    }
}
