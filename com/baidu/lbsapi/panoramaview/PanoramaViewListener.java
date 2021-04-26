package com.baidu.lbsapi.panoramaview;
/* loaded from: classes2.dex */
public interface PanoramaViewListener {
    void onCustomMarkerClick(String str);

    void onDescriptionLoadEnd(String str);

    void onLoadPanoramaBegin();

    void onLoadPanoramaEnd(String str);

    void onLoadPanoramaError(String str);

    void onMessage(String str, int i2);

    void onMoveEnd();

    void onMoveStart();
}
