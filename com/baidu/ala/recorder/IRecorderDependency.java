package com.baidu.ala.recorder;

import android.content.Context;
/* loaded from: classes5.dex */
public interface IRecorderDependency {
    Context getAppContext();

    String getClientId();

    boolean getIsBackCamera();

    boolean getIsPhoneCalling();

    String getUid();

    boolean isDebugMode();

    void setIsBackCamera(boolean z);
}
