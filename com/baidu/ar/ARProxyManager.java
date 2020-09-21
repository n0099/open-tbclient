package com.baidu.ar;

import com.baidu.ar.capture.ICapture;
import com.baidu.ar.cloud.ICloudIR;
import com.baidu.ar.face.IFace;
import com.baidu.ar.recg.IOnDeviceIR;
import com.baidu.ar.track2d.ITrack2D;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class ARProxyManager {
    private HashMap<String, d> a = new HashMap<>();

    private d a(String str) {
        if (b(str)) {
            if (this.a == null) {
                this.a = new HashMap<>();
            }
            d dVar = this.a.get(str);
            if (dVar == null) {
                dVar = c(str);
            }
            if (dVar != null) {
                this.a.put(str, dVar);
                return dVar;
            }
            return dVar;
        }
        return null;
    }

    private d c(String str) {
        if ("com.baidu.ar.face.FaceAR".equals(str)) {
            return new com.baidu.ar.face.a();
        }
        if ("com.baidu.ar.track2d.Track2DAR".equals(str)) {
            return new com.baidu.ar.track2d.a();
        }
        if ("com.baidu.ar.cloud.CloudAR".equals(str)) {
            return new com.baidu.ar.cloud.a();
        }
        if ("com.baidu.ar.recg.RecgAR".equals(str)) {
            return new com.baidu.ar.recg.a();
        }
        if ("com.baidu.ar.capture.FamilyWithChildAR".equals(str)) {
            return new com.baidu.ar.capture.b();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, String str) {
        d a = a(str);
        if (a != null) {
            a.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(String str) {
        return "com.baidu.ar.face.FaceAR".equals(str) || "com.baidu.ar.track2d.Track2DAR".equals(str) || "com.baidu.ar.cloud.CloudAR".equals(str) || "com.baidu.ar.recg.RecgAR".equals(str) || "com.baidu.ar.capture.FamilyWithChildAR".equals(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.a != null) {
            for (d dVar : this.a.values()) {
                dVar.a(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        d dVar;
        if (this.a == null || (dVar = this.a.get(str)) == null) {
            return;
        }
        dVar.a(null);
    }

    public ICapture getCaptureAR() {
        return (ICapture) a("com.baidu.ar.capture.FamilyWithChildAR");
    }

    public ICloudIR getCloudIRAR() {
        return (ICloudIR) a("com.baidu.ar.cloud.CloudAR");
    }

    public IFace getFaceAR() {
        return (IFace) a("com.baidu.ar.face.FaceAR");
    }

    public IOnDeviceIR getOnDeviceIRAR() {
        return (IOnDeviceIR) a("com.baidu.ar.recg.RecgAR");
    }

    public ITrack2D getTrack2DAR() {
        return (ITrack2D) a("com.baidu.ar.track2d.Track2DAR");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        d();
        if (this.a != null) {
            for (Map.Entry<String, d> entry : this.a.entrySet()) {
                entry.getValue().release();
            }
            this.a.clear();
            this.a = null;
        }
    }
}
