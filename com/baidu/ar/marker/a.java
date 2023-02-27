package com.baidu.ar.marker;

import com.baidu.ar.c;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a extends d implements IMarker {
    public WeakReference<IMarker> sZ;
    public IMarkerStateListener ta;
    public b tb;

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        if (cVar instanceof IMarker) {
            WeakReference<IMarker> weakReference = new WeakReference<>((IMarker) cVar);
            this.sZ = weakReference;
            if (this.ta != null) {
                weakReference.get().setMarkerStateListener(this.ta);
            }
            if (this.tb != null) {
                this.sZ.get().setTrackerSessionCallback(this.tb);
            }
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void chioceOneCoordinate(com.baidu.ar.marker.a.a aVar) {
        WeakReference<IMarker> weakReference = this.sZ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().chioceOneCoordinate(aVar);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void createSession() {
        WeakReference<IMarker> weakReference = this.sZ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().createSession();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void hideFinalPoint() {
        WeakReference<IMarker> weakReference = this.sZ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().hideFinalPoint();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void initMarkerByTrackerType(TrackerType trackerType) {
        WeakReference<IMarker> weakReference = this.sZ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().initMarkerByTrackerType(trackerType);
    }

    @Override // com.baidu.ar.marker.IMarker
    public float[] location2ScreenPoint(float[] fArr) {
        WeakReference<IMarker> weakReference = this.sZ;
        return (weakReference == null || weakReference.get() == null) ? new float[0] : this.sZ.get().location2ScreenPoint(fArr);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postArrow(float f, float f2, float f3) {
        WeakReference<IMarker> weakReference = this.sZ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().postArrow(f, f2, f3);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postArrow(String str, int i, double[] dArr, double[] dArr2, double[] dArr3, float f, float f2) {
        WeakReference<IMarker> weakReference = this.sZ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().postArrow(str, i, dArr, dArr2, dArr3, f, f2);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postFinalArrow(String str, double[] dArr) {
        WeakReference<IMarker> weakReference = this.sZ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().postFinalArrow(str, dArr);
    }

    @Override // com.baidu.ar.d
    public void release() {
        WeakReference<IMarker> weakReference = this.sZ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sZ.clear();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void removeAllArrow() {
        WeakReference<IMarker> weakReference = this.sZ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().removeAllArrow();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void removeArrowByArrowId(String str) {
        WeakReference<IMarker> weakReference = this.sZ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().removeArrowByArrowId(str);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void resetMarker() {
        WeakReference<IMarker> weakReference = this.sZ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().resetMarker();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setAvailableFrame(MarkerFrameInfo markerFrameInfo) {
        WeakReference<IMarker> weakReference = this.sZ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().setAvailableFrame(markerFrameInfo);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setMarkerStateListener(IMarkerStateListener iMarkerStateListener) {
        this.ta = iMarkerStateListener;
        WeakReference<IMarker> weakReference = this.sZ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().setMarkerStateListener(iMarkerStateListener);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setTrackerSessionCallback(b bVar) {
        this.tb = bVar;
        WeakReference<IMarker> weakReference = this.sZ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sZ.get().setTrackerSessionCallback(bVar);
    }
}
