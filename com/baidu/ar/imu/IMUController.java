package com.baidu.ar.imu;

import android.content.Context;
import android.hardware.SensorManager;
import java.util.HashMap;
/* loaded from: classes.dex */
public class IMUController implements c {
    public static final String TAG = "IMUController";
    public SensorManager rH;
    public HashMap<g, h> rI;

    @Override // com.baidu.ar.imu.c
    public void destroy() {
        HashMap<g, h> hashMap = this.rI;
        if (hashMap != null) {
            for (h hVar : hashMap.values()) {
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
        HashMap<g, h> hashMap;
        h remove;
        if (gVar == null || (hashMap = this.rI) == null || (remove = hashMap.remove(gVar)) == null) {
            return;
        }
        remove.stop();
    }
}
