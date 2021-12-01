package com.baidu.sofire.ac;

import android.hardware.Camera;
/* loaded from: classes9.dex */
public interface RecordCallback {
    void onBegin();

    void onBeginBuildData();

    void onBeginRecord();

    void onConfigCamera(Camera camera);

    void onDeviceCheckResult(int i2);

    void onEnd(int i2, RequestInfo requestInfo);

    void onPreviewFrame(byte[] bArr, Camera camera);
}
