package a.a.a.b.b;

import a.a.a.b.a.b;
import com.baidubce.http.Headers;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes16.dex */
public class d extends i {
    public d(c cVar, e eVar, b.a aVar) {
        super(cVar, eVar, aVar);
    }

    @Override // a.a.a.b.b.i
    public RandomAccessFile a(File file, String str, long j) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, str), "rwd");
        randomAccessFile.seek(j);
        return randomAccessFile;
    }

    @Override // a.a.a.b.b.i
    public Map<String, String> a(e eVar) {
        HashMap hashMap = new HashMap();
        long j = eVar.b;
        long j2 = eVar.d;
        long j3 = eVar.c;
        hashMap.put(Headers.RANGE, "bytes=" + (j + j2) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j3);
        return hashMap;
    }

    @Override // a.a.a.b.b.i
    public int b() {
        return 206;
    }

    @Override // a.a.a.b.b.i
    public void b(e eVar) {
    }

    @Override // a.a.a.b.b.i
    public String c() {
        return d.class.getSimpleName();
    }

    @Override // a.a.a.b.b.i
    public void c(e eVar) {
    }
}
