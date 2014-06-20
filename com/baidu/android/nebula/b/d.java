package com.baidu.android.nebula.b;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class d implements s {
    private File a;
    private OutputStream b;

    public d(String str) {
        this.a = File.createTempFile("NanoHTTPD-", "", new File(str));
        this.b = new FileOutputStream(this.a);
    }

    @Override // com.baidu.android.nebula.b.s
    public void a() {
        h.b(this.b);
        this.a.delete();
    }

    @Override // com.baidu.android.nebula.b.s
    public String b() {
        return this.a.getAbsolutePath();
    }
}
