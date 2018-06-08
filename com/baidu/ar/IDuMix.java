package com.baidu.ar;

import android.view.MotionEvent;
import com.baidu.ar.recorder.MovieRecorderCallback;
import com.baidu.ar.resloader.ArCaseDownloadListener;
import java.util.HashMap;
/* loaded from: classes3.dex */
public interface IDuMix {
    void cancelDownloadCase(String str);

    void changeCase(DuMixSource duMixSource);

    void closeVolume();

    void downloadCase(String str, ArCaseDownloadListener arCaseDownloadListener);

    void onCameraPreviewFrame(byte[] bArr, int i, int i2);

    void onClickCameraButton();

    boolean onTouchEvent(MotionEvent motionEvent);

    void openVolume();

    void orientationChange(int i);

    void pause();

    void release();

    void reset();

    void resume();

    boolean sendMessage2Lua(HashMap<String, Object> hashMap);

    void setup(DuMixSource duMixSource, DuMixTarget duMixTarget, DuMixCallback duMixCallback);

    void startRecord(String str, long j, MovieRecorderCallback movieRecorderCallback);

    void stopRecord();

    void switchCamera(boolean z);

    void takePicture(TakePictureCallback2 takePictureCallback2);

    void takePicture(String str, TakePictureCallback takePictureCallback);
}
