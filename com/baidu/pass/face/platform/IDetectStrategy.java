package com.baidu.pass.face.platform;

import android.graphics.Rect;
import com.baidu.pass.face.platform.listener.ISecurityCallback;
/* loaded from: classes2.dex */
public interface IDetectStrategy {
    void detectStrategy(byte[] bArr);

    void reset();

    void setDetectStrategyConfig(Rect rect, Rect rect2, IDetectStrategyCallback iDetectStrategyCallback);

    void setDetectStrategySoundEnable(boolean z);

    void setISecurityCallback(ISecurityCallback iSecurityCallback);

    void setPreviewDegree(int i);
}
