package com.baidu.ar.imu;

import android.content.Context;
import android.hardware.SensorManager;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class IMUController implements c {
    private static final String TAG = IMUController.class.getSimpleName();
    private SensorManager qm;
    private HashMap<g, h> qn;

    @Override // com.baidu.ar.imu.c
    public void destroy() {
        if (this.qn != null) {
            for (h hVar : this.qn.values()) {
                hVar.stop();
            }
            this.qn.clear();
            this.qn = null;
        }
        this.qm = null;
    }

    @Override // com.baidu.ar.imu.c
    public void setContext(Context context) {
        if (context != null) {
            this.qm = (SensorManager) context.getSystemService("sensor");
        }
    }

    @Override // com.baidu.ar.imu.c
    public boolean start(i iVar, g gVar) {
        if (this.qm == null || iVar == null || gVar == null) {
            return false;
        }
        if (this.qn == null) {
            this.qn = new HashMap<>();
        }
        h hVar = this.qn.get(gVar);
        if (hVar == null) {
            hVar = new h();
            this.qn.put(gVar, hVar);
        }
        return hVar.a(this.qm, iVar, gVar);
    }

    @Override // com.baidu.ar.imu.c
    public void stop(g gVar) {
        h remove;
        if (gVar == null || this.qn == null || (remove = this.qn.remove(gVar)) == null) {
            return;
        }
        remove.stop();
    }
}
