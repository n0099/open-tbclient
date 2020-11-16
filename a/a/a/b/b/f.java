package a.a.a.b.b;

import a.a.a.b.a.b;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;
/* loaded from: classes16.dex */
public class f extends i {
    public f(c cVar, e eVar, b.a aVar) {
        super(cVar, eVar, aVar);
    }

    @Override // a.a.a.b.b.i
    public RandomAccessFile a(File file, String str, long j) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, str), "rwd");
        randomAccessFile.seek(0L);
        return randomAccessFile;
    }

    @Override // a.a.a.b.b.i
    public Map<String, String> a(e eVar) {
        return null;
    }

    @Override // a.a.a.b.b.i
    public int b() {
        return 200;
    }

    @Override // a.a.a.b.b.i
    public void b(e eVar) {
    }

    @Override // a.a.a.b.b.i
    public String c() {
        return f.class.getSimpleName();
    }

    @Override // a.a.a.b.b.i
    public void c(e eVar) {
    }
}
