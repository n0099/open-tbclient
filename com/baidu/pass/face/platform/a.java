package com.baidu.pass.face.platform;

import android.graphics.Rect;
import com.baidu.pass.face.platform.listener.ISecurityCallback;
/* loaded from: classes8.dex */
public interface a {
    void detectStrategy(byte[] bArr);

    void reset();

    void setDetectStrategyConfig(Rect rect, Rect rect2, b bVar);

    void setDetectStrategySoundEnable(boolean z);

    void setISecurityCallback(ISecurityCallback iSecurityCallback);

    void setPreviewDegree(int i2);
}
