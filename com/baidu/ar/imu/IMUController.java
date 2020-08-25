package com.baidu.ar.imu;

import android.content.Context;
import android.hardware.SensorManager;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class IMUController implements c {
    private static final String TAG = IMUController.class.getSimpleName();
    private SensorManager rq;
    private HashMap<g, h> rr;

    @Override // com.baidu.ar.imu.c
    public void destroy() {
        if (this.rr != null) {
            for (h hVar : this.rr.values()) {
                hVar.stop();
            }
            this.rr.clear();
            this.rr = null;
        }
        this.rq = null;
    }

    @Override // com.baidu.ar.imu.c
    public void setContext(Context context) {
        if (context != null) {
            this.rq = (SensorManager) context.getSystemService("sensor");
        }
    }

    @Override // com.baidu.ar.imu.c
    public boolean start(i iVar, g gVar) {
        if (this.rq == null || iVar == null || gVar == null) {
            return false;
        }
        if (this.rr == null) {
            this.rr = new HashMap<>();
        }
        h hVar = this.rr.get(gVar);
        if (hVar == null) {
            hVar = new h();
            this.rr.put(gVar, hVar);
        }
        return hVar.a(this.rq, iVar, gVar);
    }

    @Override // com.baidu.ar.imu.c
    public void stop(g gVar) {
        h remove;
        if (gVar == null || this.rr == null || (remove = this.rr.remove(gVar)) == null) {
            return;
        }
        remove.stop();
    }
}
