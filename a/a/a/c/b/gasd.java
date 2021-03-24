package a.a.a.c.b;

import a.a.a.c.a.bv;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class gasd extends uiou {
    public gasd(bv bvVar, lbvzx lbvzxVar, bv.InterfaceC0007bv interfaceC0007bv) {
        super(bvVar, lbvzxVar, interfaceC0007bv);
    }

    @Override // a.a.a.c.b.uiou
    public RandomAccessFile a(File file, String str, long j) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, str), "rwd");
        randomAccessFile.seek(j);
        return randomAccessFile;
    }

    @Override // a.a.a.c.b.uiou
    public Map<String, String> a(lbvzx lbvzxVar) {
        HashMap hashMap = new HashMap();
        long j = lbvzxVar.f1417b;
        long j2 = lbvzxVar.f1419d;
        long j3 = lbvzxVar.f1418c;
        hashMap.put("Range", "bytes=" + (j + j2) + "-" + j3);
        return hashMap;
    }

    @Override // a.a.a.c.b.uiou
    public int b() {
        return 206;
    }

    @Override // a.a.a.c.b.uiou
    public void b(lbvzx lbvzxVar) {
    }

    @Override // a.a.a.c.b.uiou
    public String c() {
        return gasd.class.getSimpleName();
    }

    @Override // a.a.a.c.b.uiou
    public void c(lbvzx lbvzxVar) {
    }
}
