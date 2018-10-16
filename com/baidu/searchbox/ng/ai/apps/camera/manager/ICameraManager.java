package com.baidu.searchbox.ng.ai.apps.camera.manager;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.camera.listener.CameraTimeOutListener;
import com.baidu.searchbox.ng.ai.apps.camera.view.CameraPreview;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public interface ICameraManager {
    public static final List<CameraPreview> cameraList = new ArrayList();

    void addCameraPreview(CameraPreview cameraPreview);

    void cancelTimer();

    void clearCameraList();

    CameraPreview getCameraPreviewBySlaveId(String str);

    boolean hasCameraPermission(Context context);

    boolean hasRecordPermission(Context context);

    void onAiAppForegroundChange(boolean z);

    void onExceptionError(String str, String str2, boolean z);

    void removeCameraPreviewBySlaveId(String str);

    boolean saveImage(byte[] bArr, String str, int i, int i2);

    void startTimer(int i, CameraTimeOutListener cameraTimeOutListener);

    void stopTimer();
}
