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
    public final /* synthetic */ b f1432a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1433b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ File f1434c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ File f1435d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1436e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ DownSoHelper f1437f;

    public bv(DownSoHelper downSoHelper, b bVar, String str, File file, File file2, String str2) {
        this.f1437f = downSoHelper;
        this.f1432a = bVar;
        this.f1433b = str;
        this.f1434c = file;
        this.f1435d = file2;
        this.f1436e = str2;
    }

    @Override // d.b.k.b.c.a
    public void onCompleted(String str) {
        try {
            this.f1434c.renameTo(this.f1435d);
            Log.e("RtcDownSo", "unzip:" + this.f1435d + "---" + this.f1436e);
            d.b.k.e.a.e(this.f1435d, this.f1436e);
            d.b.k.e.a.b(this.f1435d.getAbsolutePath());
            this.f1437f.h(this.f1432a, this.f1433b, this.f1436e);
        } catch (Exception e2) {
            e2.printStackTrace();
            d.b.k.e.a.b(this.f1435d.getAbsolutePath());
            if (d.b.k.e.a.c(this.f1436e)) {
                d.b.k.e.a.a(new File(this.f1436e));
            }
            this.f1437f.e(this.f1432a, this.f1433b, 108, "unzip exception");
        }
    }

    @Override // d.b.k.b.c.a
    public void onFailed(DownloadException downloadException) {
        downloadException.printStackTrace();
        d.b.k.e.a.b(this.f1434c.getAbsolutePath());
        this.f1437f.e(this.f1432a, this.f1433b, downloadException.getErrorCode(), downloadException.getErrorMessage());
    }

    @Override // d.b.k.b.c.a
    public void onProgress(long j, long j2, int i) {
        this.f1437f.f(this.f1432a, this.f1433b, i);
    }

    @Override // d.b.k.b.c.a
    public void onStarted() {
        this.f1437f.g(this.f1432a, this.f1433b);
    }
}
