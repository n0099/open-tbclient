package com.baidu.searchbox.ui.animview.praise.layout;

import android.graphics.Rect;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
/* loaded from: classes4.dex */
public class LeftLayoutStrategy extends BaseLayoutStrategy {
    public static final float PRAISELEVEL_FACTOR_POS_X_BASED_PRAISELEVEL = 0.14f;
    public static final float PRAISELEVEL_SIZE_DP = 360.0f;
    public static final float PRAISENUM_FACTOR_HEIGHT_BASED_PRAISELEVEL = 0.12f;
    public static final float PRAISENUM_FACTOR_POS_DELTA_X_BASED_PRAISELEVEL = 0.08f;
    public static final float PRAISENUM_FACTOR_POS_X_BASED_PRAISELEVEL = 0.3f;
    public static final float PRAISENUM_FACTOR_POS_Y_BASED_PRAISELEVEL = 0.077295f;

    @Override // com.baidu.searchbox.ui.animview.praise.layout.BaseLayoutStrategy
    public float getPraiseLevelFactorPosX() {
        return 0.14f;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.layout.BaseLayoutStrategy
    public float getPraiseNumFactorDeltaX() {
        return -0.08f;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.layout.BaseLayoutStrategy
    public float getPraiseNumFactorHeight() {
        return 0.12f;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.layout.BaseLayoutStrategy
    public float getPraiseNumFactorPosX() {
        return 0.3f;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.layout.BaseLayoutStrategy
    public float getPraiseNumFactorPosY() {
        return 0.077295f;
    }

    public LeftLayoutStrategy(Rect rect, int i, int i2, IResourceProvider iResourceProvider) {
        super(rect, i, i2, iResourceProvider);
    }

    @Override // com.baidu.searchbox.ui.animview.praise.layout.BaseLayoutStrategy
    public int getPraiseLevelSize() {
        return DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 360.0f);
    }
}
