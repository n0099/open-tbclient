package com.baidu.sofire.ac;

import android.hardware.Camera;
/* loaded from: classes4.dex */
public interface RecordCallback {
    void onBegin();

    void onBeginBuildData();

    void onBeginRecord();

    void onConfigCamera(Camera camera);

    void onDeviceCheckResult(int i);

    void onEnd(int i, RequestInfo requestInfo);

    void onPreviewFrame(byte[] bArr, Camera camera);
}
