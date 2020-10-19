package com.baidu.ar.record;

import android.view.Surface;
/* loaded from: classes14.dex */
public interface MovieRecorderCallback {
    void onRecorderComplete(boolean z, String str);

    void onRecorderError(int i);

    void onRecorderInit(Surface surface);

    void onRecorderProcess(int i);

    void onRecorderStart(boolean z);
}
