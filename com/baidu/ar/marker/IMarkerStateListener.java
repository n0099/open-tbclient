package com.baidu.ar.marker;

import java.util.List;
/* loaded from: classes6.dex */
public interface IMarkerStateListener {
    void onCoordinateResult(int i2, double[] dArr);

    void onError(int i2, String str);

    void onLocationResult(boolean z, List<com.baidu.ar.marker.a.a> list);

    void onSessionCreated(boolean z, String str);
}
