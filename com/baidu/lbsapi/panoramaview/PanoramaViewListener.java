package com.baidu.lbsapi.panoramaview;
/* loaded from: classes15.dex */
public interface PanoramaViewListener {
    void onCustomMarkerClick(String str);

    void onDescriptionLoadEnd(String str);

    void onLoadPanoramaBegin();

    void onLoadPanoramaEnd(String str);

    void onLoadPanoramaError(String str);

    void onMessage(String str, int i);

    void onMoveEnd();

    void onMoveStart();
}
