package com.baidu.sofire.face.api;

import android.hardware.Camera;
/* loaded from: classes3.dex */
public interface RecordCallback {
    void onBegin();

    void onBeginBuildData();

    void onBeginRecord();

    void onConfigCamera(Camera camera);

    void onDeviceCheckResult(int i);

    void onEnd(int i, RequestInfo requestInfo);

    void onPreviewFrame(byte[] bArr, Camera camera);
}
