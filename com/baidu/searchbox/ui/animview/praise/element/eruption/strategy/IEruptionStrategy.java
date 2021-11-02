package com.baidu.searchbox.ui.animview.praise.element.eruption.strategy;

import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import java.util.List;
/* loaded from: classes7.dex */
public interface IEruptionStrategy {
    public static final int[] sSectionAngle = {225, 340, 340, 20, 20, 135, 135, 225};

    /* loaded from: classes7.dex */
    public interface IHostCallback {
        BaseAnimatedElement createAndInitEruption(int i2, int i3, IResourceProvider iResourceProvider);
    }

    List<BaseAnimatedElement> generateEruptionElementList(IResourceProvider iResourceProvider, IHostCallback iHostCallback);

    List<Float> generateEruptionRotateAngleList();
}
