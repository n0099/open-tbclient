package com.baidu.ar.record;

import android.view.Surface;
/* loaded from: classes.dex */
public interface MovieRecorderCallback {
    void onRecorderComplete(boolean z, String str);

    void onRecorderError(int i2);

    void onRecorderInit(Surface surface);

    void onRecorderProcess(int i2);

    void onRecorderStart(boolean z);
}
