package com.baidu.ar.algo.b.b;

import android.os.Bundle;
import android.util.Log;
import com.baidu.ar.algo.b.a.b;
/* loaded from: classes3.dex */
public class a extends b {
    com.baidu.ar.algo.a.a.b e;

    public a(byte[] bArr, int i, int i2, com.baidu.ar.algo.a.a.b bVar, com.baidu.ar.algo.b.a.a aVar, int i3) {
        super(bArr, i, i2, aVar, i3);
        this.e = bVar;
    }

    @Override // com.baidu.ar.algo.b.a.b
    public void b() {
        if (this.e != null) {
            Log.d("PaddleRunnable", "bdar: PaddleRunnable algo");
            Bundle a = this.e.a(c(), this.a, this.b);
            if (this.c != null) {
                this.c.a(a);
            }
        }
    }
}
