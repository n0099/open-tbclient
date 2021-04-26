package a.a.a.d;

import android.util.Log;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.cloudbase.plugin.DownSoHelper;
import d.a.k.b.c.a;
import d.a.k.d.b;
import java.io.File;
/* loaded from: classes.dex */
public class bv extends a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f1451a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1452b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ File f1453c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ File f1454d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1455e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ DownSoHelper f1456f;

    public bv(DownSoHelper downSoHelper, b bVar, String str, File file, File file2, String str2) {
        this.f1456f = downSoHelper;
        this.f1451a = bVar;
        this.f1452b = str;
        this.f1453c = file;
        this.f1454d = file2;
        this.f1455e = str2;
    }

    @Override // d.a.k.b.c.a
    public void onCompleted(String str) {
        try {
            this.f1453c.renameTo(this.f1454d);
            Log.e("RtcDownSo", "unzip:" + this.f1454d + "---" + this.f1455e);
            d.a.k.e.a.e(this.f1454d, this.f1455e);
            d.a.k.e.a.b(this.f1454d.getAbsolutePath());
            this.f1456f.h(this.f1451a, this.f1452b, this.f1455e);
        } catch (Exception e2) {
            e2.printStackTrace();
            d.a.k.e.a.b(this.f1454d.getAbsolutePath());
            if (d.a.k.e.a.c(this.f1455e)) {
                d.a.k.e.a.a(new File(this.f1455e));
            }
            this.f1456f.e(this.f1451a, this.f1452b, 108, "unzip exception");
        }
    }

    @Override // d.a.k.b.c.a
    public void onFailed(DownloadException downloadException) {
        downloadException.printStackTrace();
        d.a.k.e.a.b(this.f1453c.getAbsolutePath());
        this.f1456f.e(this.f1451a, this.f1452b, downloadException.getErrorCode(), downloadException.getErrorMessage());
    }

    @Override // d.a.k.b.c.a
    public void onProgress(long j, long j2, int i2) {
        this.f1456f.f(this.f1451a, this.f1452b, i2);
    }

    @Override // d.a.k.b.c.a
    public void onStarted() {
        this.f1456f.g(this.f1451a, this.f1452b);
    }
}
