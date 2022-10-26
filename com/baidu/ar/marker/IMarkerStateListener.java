package com.baidu.ar.marker;

import java.util.List;
/* loaded from: classes.dex */
public interface IMarkerStateListener {
    void onCoordinateResult(int i, double[] dArr);

    void onError(int i, String str);

    void onLocationResult(boolean z, List list);

    void onSessionCreated(boolean z, String str);
}
