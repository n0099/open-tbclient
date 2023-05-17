package com.baidu.searchbox.ui.animview.praise.layout;

import android.graphics.Rect;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ui.animview.base.IAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.layout.ILayoutStrategy;
import java.util.Map;
/* loaded from: classes4.dex */
public abstract class BaseLayoutStrategy implements ILayoutStrategy {
    public static final float ERUPTION_SIZE_DP = 313.0f;
    public static final float PRAISELEVEL_SIZE_DP = 170.0f;
    public static final float PRAISENUM_FACTOR_HEIGHT_BASED_PRAISELEVEL = 0.25f;
    public static final float PRAISENUM_FACTOR_POS_X_BASED_PRAISELEVEL = 0.1f;
    public static final float PRAISENUM_FACTOR_POS_Y_BASED_PRAISELEVEL = 0.15f;
    public static final float PRAISENUM_RATIO_BASED_PRAISENUM = 0.61f;
    public static final float SHAKE_SIZE_DP = 21.0f;
    public static final float WAVE_SIZE_DP = 116.0f;
    public Rect mBaseRect;
    public ILayoutStrategy.ICallback mCallback = new ILayoutStrategy.ICallback() { // from class: com.baidu.searchbox.ui.animview.praise.layout.BaseLayoutStrategy.1
        @Override // com.baidu.searchbox.ui.animview.praise.layout.ILayoutStrategy.ICallback
        public void init(IAnimatedElement iAnimatedElement, int i, int i2, int i3, int i4, IResourceProvider iResourceProvider, Object... objArr) {
            if (iAnimatedElement == null) {
                return;
            }
            if (objArr == null) {
                iAnimatedElement.init(i, i2, i3, i4, iResourceProvider, new Object[0]);
            } else {
                iAnimatedElement.init(i, i2, i3, i4, iResourceProvider, objArr);
            }
        }
    };
    public int mCanvasHeight;
    public int mCanvasWidth;
    public IResourceProvider mProvider;

    public abstract float getPraiseLevelFactorPosX();

    public float getPraiseNumFactorDeltaX() {
        return 0.1f;
    }

    public float getPraiseNumFactorHeight() {
        return 0.25f;
    }

    public float getPraiseNumFactorPosX() {
        return 0.1f;
    }

    public float getPraiseNumFactorPosY() {
        return 0.15f;
    }

    public float getPraiseNumRatio() {
        return 0.61f;
    }

    public BaseLayoutStrategy(Rect rect, int i, int i2, IResourceProvider iResourceProvider) {
        this.mBaseRect = rect;
        this.mProvider = iResourceProvider;
        this.mCanvasWidth = i;
        this.mCanvasHeight = i2;
    }

    public int getPraiseLevelSize() {
        return DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 170.0f);
    }

    @Override // com.baidu.searchbox.ui.animview.praise.layout.ILayoutStrategy
    public void getSize(int i, Map<Integer, IAnimatedElement> map, int[] iArr) {
        if (iArr != null && iArr.length >= 2 && map != null && map.size() > 0) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return;
                            }
                            iArr[0] = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 313.0f);
                            iArr[1] = iArr[0];
                            return;
                        }
                        IAnimatedElement iAnimatedElement = map.get(2);
                        if (iAnimatedElement != null) {
                            iArr[1] = (int) ((iAnimatedElement.getHeight() * getPraiseNumFactorHeight()) + 0.5f);
                        }
                        iArr[0] = (int) ((iArr[1] * getPraiseNumRatio()) + 0.5f);
                        return;
                    }
                    iArr[0] = getPraiseLevelSize();
                    iArr[1] = iArr[0];
                    return;
                }
                iArr[0] = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 21.0f);
                iArr[1] = iArr[0];
                return;
            }
            iArr[0] = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 116.0f);
            iArr[1] = iArr[0];
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.layout.ILayoutStrategy
    public void layout(int i, Map<Integer, IAnimatedElement> map) {
        layout(i, map, null);
    }

    @Override // com.baidu.searchbox.ui.animview.praise.layout.ILayoutStrategy
    public void layout(int i, Map<Integer, IAnimatedElement> map, ILayoutStrategy.ICallback iCallback) {
        IAnimatedElement iAnimatedElement;
        int centerX;
        int centerY;
        if (iCallback == null) {
            iCallback = this.mCallback;
        }
        ILayoutStrategy.ICallback iCallback2 = iCallback;
        if (map == null || map.size() <= 0 || (iAnimatedElement = map.get(Integer.valueOf(i))) == null) {
            return;
        }
        int[] iArr = new int[2];
        getSize(i, map, iArr);
        if (i != 0 && i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                    centerX = this.mBaseRect.centerX() - (iArr[0] / 2);
                    centerY = (this.mBaseRect.centerY() - iArr[1]) + DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 2.0f);
                } else {
                    IAnimatedElement iAnimatedElement2 = map.get(2);
                    if (iAnimatedElement2 != null) {
                        iCallback2.init(iAnimatedElement, ((iAnimatedElement2.getLeft() + (iAnimatedElement2.getWidth() / 2)) - ((int) ((getPraiseNumFactorPosX() * iAnimatedElement2.getWidth()) + 0.5f))) - iArr[0], (int) ((((iAnimatedElement2.getTop() + iAnimatedElement2.getHeight()) - (iAnimatedElement2.getHeight() * getPraiseNumFactorPosY())) - iArr[1]) + 0.5f), iArr[0], iArr[1], this.mProvider, Integer.valueOf((int) ((getPraiseNumFactorDeltaX() * iAnimatedElement2.getWidth()) + 0.5f)));
                        return;
                    }
                    return;
                }
            } else {
                centerX = (int) ((this.mBaseRect.centerX() - (iArr[0] * getPraiseLevelFactorPosX())) + 0.5f);
                centerY = (int) ((this.mBaseRect.centerY() - iArr[1]) + 0.5f);
            }
        } else {
            centerX = this.mBaseRect.centerX() - (iArr[0] / 2);
            centerY = this.mBaseRect.centerY() - (iArr[1] / 2);
        }
        iCallback2.init(iAnimatedElement, centerX, centerY, iArr[0], iArr[1], this.mProvider, new Object[0]);
    }
}
