package com.baidu.ar.marker;

import com.baidu.ar.c;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class a extends d implements IMarker {
    private WeakReference<IMarker> sZ;
    private IMarkerStateListener ta;
    private b tb;

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        if (cVar instanceof IMarker) {
            this.sZ = new WeakReference<>((IMarker) cVar);
            if (this.ta != null) {
                this.sZ.get().setMarkerStateListener(this.ta);
            }
            if (this.tb != null) {
                this.sZ.get().setTrackerSessionCallback(this.tb);
            }
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void chioceOneCoordinate(com.baidu.ar.marker.a.a aVar) {
        if (this.sZ == null || this.sZ.get() == null) {
            return;
        }
        this.sZ.get().chioceOneCoordinate(aVar);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void createSession() {
        if (this.sZ == null || this.sZ.get() == null) {
            return;
        }
        this.sZ.get().createSession();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void hideFinalPoint() {
        if (this.sZ == null || this.sZ.get() == null) {
            return;
        }
        this.sZ.get().hideFinalPoint();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void initMarkerByTrackerType(TrackerType trackerType) {
        if (this.sZ == null || this.sZ.get() == null) {
            return;
        }
        this.sZ.get().initMarkerByTrackerType(trackerType);
    }

    @Override // com.baidu.ar.marker.IMarker
    public float[] location2ScreenPoint(float[] fArr) {
        return (this.sZ == null || this.sZ.get() == null) ? new float[0] : this.sZ.get().location2ScreenPoint(fArr);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postArrow(float f, float f2, float f3) {
        if (this.sZ == null || this.sZ.get() == null) {
            return;
        }
        this.sZ.get().postArrow(f, f2, f3);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postArrow(String str, int i, double[] dArr, double[] dArr2, double[] dArr3, float f, float f2) {
        if (this.sZ == null || this.sZ.get() == null) {
            return;
        }
        this.sZ.get().postArrow(str, i, dArr, dArr2, dArr3, f, f2);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postFinalArrow(String str, double[] dArr) {
        if (this.sZ == null || this.sZ.get() == null) {
            return;
        }
        this.sZ.get().postFinalArrow(str, dArr);
    }

    @Override // com.baidu.ar.d
    public void release() {
        if (this.sZ == null || this.sZ.get() == null) {
            return;
        }
        this.sZ.clear();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void removeAllArrow() {
        if (this.sZ == null || this.sZ.get() == null) {
            return;
        }
        this.sZ.get().removeAllArrow();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void removeArrowByArrowId(String str) {
        if (this.sZ == null || this.sZ.get() == null) {
            return;
        }
        this.sZ.get().removeArrowByArrowId(str);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void resetMarker() {
        if (this.sZ == null || this.sZ.get() == null) {
            return;
        }
        this.sZ.get().resetMarker();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setAvailableFrame(MarkerFrameInfo markerFrameInfo) {
        if (this.sZ == null || this.sZ.get() == null) {
            return;
        }
        this.sZ.get().setAvailableFrame(markerFrameInfo);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setMarkerStateListener(IMarkerStateListener iMarkerStateListener) {
        this.ta = iMarkerStateListener;
        if (this.sZ == null || this.sZ.get() == null) {
            return;
        }
        this.sZ.get().setMarkerStateListener(iMarkerStateListener);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setTrackerSessionCallback(b bVar) {
        this.tb = bVar;
        if (this.sZ == null || this.sZ.get() == null) {
            return;
        }
        this.sZ.get().setTrackerSessionCallback(bVar);
    }
}
