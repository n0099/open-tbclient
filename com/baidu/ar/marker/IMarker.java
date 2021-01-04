package com.baidu.ar.marker;
/* loaded from: classes6.dex */
public interface IMarker {
    void chioceOneCoordinate(com.baidu.ar.marker.a.a aVar);

    void createSession();

    void hideFinalPoint();

    void initMarkerByTrackerType(TrackerType trackerType);

    float[] location2ScreenPoint(float[] fArr);

    void postArrow(float f, float f2, float f3);

    void postArrow(String str, int i, double[] dArr, double[] dArr2, double[] dArr3, float f, float f2);

    void postFinalArrow(String str, double[] dArr);

    void removeAllArrow();

    void removeArrowByArrowId(String str);

    void resetMarker();

    void setAvailableFrame(MarkerFrameInfo markerFrameInfo);

    void setMarkerStateListener(IMarkerStateListener iMarkerStateListener);

    void setTrackerSessionCallback(b bVar);
}
