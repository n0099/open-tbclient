package com.baidu.ar.imu;

import android.content.Context;
import android.hardware.SensorManager;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class IMUController implements c {
    private static final String TAG = IMUController.class.getSimpleName();
    private SensorManager qL;
    private HashMap<g, h> qM;

    @Override // com.baidu.ar.imu.c
    public void destroy() {
        if (this.qM != null) {
            for (h hVar : this.qM.values()) {
                hVar.stop();
            }
            this.qM.clear();
            this.qM = null;
        }
        this.qL = null;
    }

    @Override // com.baidu.ar.imu.c
    public void setContext(Context context) {
        if (context != null) {
            this.qL = (SensorManager) context.getSystemService("sensor");
        }
    }

    @Override // com.baidu.ar.imu.c
    public boolean start(i iVar, g gVar) {
        if (this.qL == null || iVar == null || gVar == null) {
            return false;
        }
        if (this.qM == null) {
            this.qM = new HashMap<>();
        }
        h hVar = this.qM.get(gVar);
        if (hVar == null) {
            hVar = new h();
            this.qM.put(gVar, hVar);
        }
        return hVar.a(this.qL, iVar, gVar);
    }

    @Override // com.baidu.ar.imu.c
    public void stop(g gVar) {
        h remove;
        if (gVar == null || this.qM == null || (remove = this.qM.remove(gVar)) == null) {
            return;
        }
        remove.stop();
    }
}
