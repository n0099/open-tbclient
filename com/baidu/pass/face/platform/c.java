package com.baidu.pass.face.platform;

import android.graphics.Rect;
import com.baidu.pass.face.platform.listener.ISecurityCallback;
import java.util.List;
/* loaded from: classes2.dex */
public interface c {
    void livenessStrategy(byte[] bArr);

    void reset();

    void setISecurityCallback(ISecurityCallback iSecurityCallback);

    void setLivenessStrategyConfig(List<LivenessTypeEnum> list, Rect rect, Rect rect2, d dVar);

    void setLivenessStrategySoundEnable(boolean z);

    void setPreviewDegree(int i2);
}
