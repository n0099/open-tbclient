package com.baidu.ar;

import com.baidu.ar.capture.ICapture;
import com.baidu.ar.cloud.ICloudIR;
import com.baidu.ar.face.IFace;
import com.baidu.ar.marker.IMarker;
import com.baidu.ar.recg.IOnDeviceIR;
import com.baidu.ar.track2d.ITrack2D;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ARProxyManager {
    public HashMap<String, d> a = new HashMap<>();

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
        if ("com.baidu.ar.track3d.Track3DAR".equals(str)) {
            return new com.baidu.ar.g.c();
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
        if ("com.baidu.ar.vps.marker.MarkerAR".equals(str)) {
            return new com.baidu.ar.marker.a();
        }
        return null;
    }

    public void a(c cVar, String str) {
        d a = a(str);
        if (a != null) {
            a.a(cVar);
        }
    }

    public boolean b(String str) {
        return "com.baidu.ar.face.FaceAR".equals(str) || "com.baidu.ar.track2d.Track2DAR".equals(str) || "com.baidu.ar.track3d.Track3DAR".equals(str) || "com.baidu.ar.cloud.CloudAR".equals(str) || "com.baidu.ar.recg.RecgAR".equals(str) || "com.baidu.ar.vps.marker.MarkerAR".equals(str) || "com.baidu.ar.capture.FamilyWithChildAR".equals(str);
    }

    public void d() {
        HashMap<String, d> hashMap = this.a;
        if (hashMap != null) {
            for (d dVar : hashMap.values()) {
                dVar.a(null);
            }
        }
    }

    public void d(String str) {
        d dVar;
        HashMap<String, d> hashMap = this.a;
        if (hashMap == null || (dVar = hashMap.get(str)) == null) {
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

    public IMarker getMarkerAR() {
        return (IMarker) a("com.baidu.ar.vps.marker.MarkerAR");
    }

    public IOnDeviceIR getOnDeviceIRAR() {
        return (IOnDeviceIR) a("com.baidu.ar.recg.RecgAR");
    }

    public ITrack2D getTrack2DAR() {
        return (ITrack2D) a("com.baidu.ar.track2d.Track2DAR");
    }

    public com.baidu.ar.g.a getTrack3DAR() {
        return (com.baidu.ar.g.a) a("com.baidu.ar.track3d.Track3DAR");
    }

    public void release() {
        d();
        HashMap<String, d> hashMap = this.a;
        if (hashMap != null) {
            for (Map.Entry<String, d> entry : hashMap.entrySet()) {
                entry.getValue().release();
            }
            this.a.clear();
            this.a = null;
        }
    }
}
