package a.a.a.d;

import android.util.Log;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.cloudbase.plugin.DownSoHelper;
import d.b.k.b.c.a;
import d.b.k.d.b;
import java.io.File;
/* loaded from: classes.dex */
public class bv extends a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f1446a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1447b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ File f1448c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ File f1449d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1450e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ DownSoHelper f1451f;

    public bv(DownSoHelper downSoHelper, b bVar, String str, File file, File file2, String str2) {
        this.f1451f = downSoHelper;
        this.f1446a = bVar;
        this.f1447b = str;
        this.f1448c = file;
        this.f1449d = file2;
        this.f1450e = str2;
    }

    @Override // d.b.k.b.c.a
    public void onCompleted(String str) {
        try {
            this.f1448c.renameTo(this.f1449d);
            Log.e("RtcDownSo", "unzip:" + this.f1449d + "---" + this.f1450e);
            d.b.k.e.a.e(this.f1449d, this.f1450e);
            d.b.k.e.a.b(this.f1449d.getAbsolutePath());
            this.f1451f.h(this.f1446a, this.f1447b, this.f1450e);
        } catch (Exception e2) {
            e2.printStackTrace();
            d.b.k.e.a.b(this.f1449d.getAbsolutePath());
            if (d.b.k.e.a.c(this.f1450e)) {
                d.b.k.e.a.a(new File(this.f1450e));
            }
            this.f1451f.e(this.f1446a, this.f1447b, 108, "unzip exception");
        }
    }

    @Override // d.b.k.b.c.a
    public void onFailed(DownloadException downloadException) {
        downloadException.printStackTrace();
        d.b.k.e.a.b(this.f1448c.getAbsolutePath());
        this.f1451f.e(this.f1446a, this.f1447b, downloadException.getErrorCode(), downloadException.getErrorMessage());
    }

    @Override // d.b.k.b.c.a
    public void onProgress(long j, long j2, int i) {
        this.f1451f.f(this.f1446a, this.f1447b, i);
    }

    @Override // d.b.k.b.c.a
    public void onStarted() {
        this.f1451f.g(this.f1446a, this.f1447b);
    }
}
