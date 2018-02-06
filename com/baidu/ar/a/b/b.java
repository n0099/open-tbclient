package com.baidu.ar.a.b;

import android.os.Bundle;
import com.baidu.ar.a.a.c;
import com.baidu.ar.slam.SlamStateMachine;
import com.baidu.slamlibrary.TrackParams;
/* loaded from: classes3.dex */
public class b extends c {
    private com.baidu.slamlibrary.b d;

    public b(byte[] bArr, int i, int i2, com.baidu.slamlibrary.b bVar, com.baidu.ar.a.a.a aVar) {
        super(bArr, i, i2, aVar);
        this.d = bVar;
    }

    @Override // com.baidu.ar.a.a.c
    public void b() {
        if (this.d == null) {
            return;
        }
        TrackParams a = this.d.a(c(), SlamStateMachine.a().b());
        float f = a.processTime;
        int i = a.trackQuality;
        int a2 = this.d.a((int) f);
        Bundle bundle = new Bundle();
        bundle.putInt(com.baidu.ar.a.a.b.b, i);
        bundle.putFloat(com.baidu.ar.a.a.b.c, f);
        bundle.putString(com.baidu.ar.a.a.b.d, a.extendedStatusStr);
        bundle.putFloatArray(com.baidu.ar.a.a.b.e, a.trans);
        bundle.putInt("average_time", a2);
        if (this.c != null) {
            this.c.a(bundle);
        }
    }
}
