package com.baidu.ar.algo.b.c;

import android.os.Bundle;
import com.baidu.ar.algo.TrackParams;
import com.baidu.ar.algo.b.a.b;
/* loaded from: classes3.dex */
public class a extends b {
    private com.baidu.ar.algo.a.b.b e;

    public a(byte[] bArr, int i, int i2, com.baidu.ar.algo.a.b.b bVar, com.baidu.ar.algo.b.a.a aVar) {
        super(bArr, i, i2, aVar);
        this.e = bVar;
    }

    @Override // com.baidu.ar.algo.b.a.b
    public void b() {
        if (this.e == null) {
            return;
        }
        TrackParams a = this.e.a(c());
        if (a == null) {
            if (this.c != null) {
                this.c.a(null);
                return;
            }
            return;
        }
        float f = a.processTime;
        int i = a.trackQuality;
        int a2 = this.e.a((int) f);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("slam_track_result", this.e.b());
        bundle.putInt("slam_track_quality", i);
        bundle.putFloat("slam_process_time", f);
        bundle.putString("slam_track_status", a.extendedStatusStr);
        bundle.putInt("average_time", a2);
        if (this.c != null) {
            this.c.a(bundle);
        }
    }
}
