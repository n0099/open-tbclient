package com.baidu.ar.imu;

import android.content.Context;
import android.hardware.SensorManager;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class IMUController implements c {
    private static final String TAG = IMUController.class.getSimpleName();
    private SensorManager rH;
    private HashMap<g, h> rI;

    @Override // com.baidu.ar.imu.c
    public void destroy() {
        if (this.rI != null) {
            for (h hVar : this.rI.values()) {
                hVar.stop();
            }
            this.rI.clear();
            this.rI = null;
        }
        this.rH = null;
    }

    @Override // com.baidu.ar.imu.c
    public void setContext(Context context) {
        if (context != null) {
            this.rH = (SensorManager) context.getSystemService("sensor");
        }
    }

    @Override // com.baidu.ar.imu.c
    public boolean start(i iVar, g gVar) {
        if (this.rH == null || iVar == null || gVar == null) {
            return false;
        }
        if (this.rI == null) {
            this.rI = new HashMap<>();
        }
        h hVar = this.rI.get(gVar);
        if (hVar == null) {
            hVar = new h();
            this.rI.put(gVar, hVar);
        }
        return hVar.a(this.rH, iVar, gVar);
    }

    @Override // com.baidu.ar.imu.c
    public void stop(g gVar) {
        h remove;
        if (gVar == null || this.rI == null || (remove = this.rI.remove(gVar)) == null) {
            return;
        }
        remove.stop();
    }
}
