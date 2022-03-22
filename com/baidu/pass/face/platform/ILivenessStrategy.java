package com.baidu.pass.face.platform;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.pass.face.platform.listener.ISecurityCallback;
import java.util.List;
/* loaded from: classes4.dex */
public interface ILivenessStrategy {
    void livenessStrategy(Bitmap bitmap);

    void livenessStrategy(byte[] bArr);

    void reset();

    void setISecurityCallback(ISecurityCallback iSecurityCallback);

    void setLivenessStrategyConfig(List<LivenessTypeEnum> list, Rect rect, Rect rect2, ILivenessStrategyCallback iLivenessStrategyCallback);

    void setLivenessStrategySoundEnable(boolean z);

    void setPreviewDegree(int i);
}
