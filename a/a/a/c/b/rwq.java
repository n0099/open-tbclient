package a.a.a.c.b;

import a.a.a.c.a.bv;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;
/* loaded from: classes.dex */
public class rwq extends uiou {
    public rwq(bv bvVar, lbvzx lbvzxVar, bv.InterfaceC0007bv interfaceC0007bv) {
        super(bvVar, lbvzxVar, interfaceC0007bv);
    }

    @Override // a.a.a.c.b.uiou
    public RandomAccessFile a(File file, String str, long j) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, str), "rwd");
        randomAccessFile.seek(0L);
        return randomAccessFile;
    }

    @Override // a.a.a.c.b.uiou
    public Map<String, String> a(lbvzx lbvzxVar) {
        return null;
    }

    @Override // a.a.a.c.b.uiou
    public int b() {
        return 200;
    }

    @Override // a.a.a.c.b.uiou
    public void b(lbvzx lbvzxVar) {
    }

    @Override // a.a.a.c.b.uiou
    public String c() {
        return rwq.class.getSimpleName();
    }

    @Override // a.a.a.c.b.uiou
    public void c(lbvzx lbvzxVar) {
    }
}
