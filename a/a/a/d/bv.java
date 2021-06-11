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
    public final /* synthetic */ b f1464a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1465b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ File f1466c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ File f1467d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1468e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ DownSoHelper f1469f;

    public bv(DownSoHelper downSoHelper, b bVar, String str, File file, File file2, String str2) {
        this.f1469f = downSoHelper;
        this.f1464a = bVar;
        this.f1465b = str;
        this.f1466c = file;
        this.f1467d = file2;
        this.f1468e = str2;
    }

    @Override // d.a.k.b.c.a
    public void onCompleted(String str) {
        try {
            this.f1466c.renameTo(this.f1467d);
            Log.e("RtcDownSo", "unzip:" + this.f1467d + "---" + this.f1468e);
            d.a.k.e.a.e(this.f1467d, this.f1468e);
            d.a.k.e.a.b(this.f1467d.getAbsolutePath());
            this.f1469f.h(this.f1464a, this.f1465b, this.f1468e);
        } catch (Exception e2) {
            e2.printStackTrace();
            d.a.k.e.a.b(this.f1467d.getAbsolutePath());
            if (d.a.k.e.a.c(this.f1468e)) {
                d.a.k.e.a.a(new File(this.f1468e));
            }
            this.f1469f.e(this.f1464a, this.f1465b, 108, "unzip exception");
        }
    }

    @Override // d.a.k.b.c.a
    public void onFailed(DownloadException downloadException) {
        downloadException.printStackTrace();
        d.a.k.e.a.b(this.f1466c.getAbsolutePath());
        this.f1469f.e(this.f1464a, this.f1465b, downloadException.getErrorCode(), downloadException.getErrorMessage());
    }

    @Override // d.a.k.b.c.a
    public void onProgress(long j, long j2, int i2) {
        this.f1469f.f(this.f1464a, this.f1465b, i2);
    }

    @Override // d.a.k.b.c.a
    public void onStarted() {
        this.f1469f.g(this.f1464a, this.f1465b);
    }
}
