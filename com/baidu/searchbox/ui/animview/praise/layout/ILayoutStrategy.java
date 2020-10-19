package com.baidu.searchbox.ui.animview.praise.layout;

import android.graphics.Rect;
import com.baidu.searchbox.ui.animview.base.IAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import java.util.Map;
/* loaded from: classes9.dex */
public interface ILayoutStrategy {
    public static final int ELEMENT_TYPE_ERUPTION = 4;
    public static final int ELEMENT_TYPE_PRAISE_LEVEL = 2;
    public static final int ELEMENT_TYPE_PRAISE_NUMBER = 3;
    public static final int ELEMENT_TYPE_SHAKE = 1;
    public static final int ELEMENT_TYPE_WAVE = 0;
    public static final int STRATEGY_LEFT = 0;
    public static final int STRATEGY_MIDDLE = 1;
    public static final int STRATEGY_RIGHT = 2;

    /* loaded from: classes9.dex */
    public interface ICallback {
        void init(IAnimatedElement iAnimatedElement, int i, int i2, int i3, int i4, IResourceProvider iResourceProvider, Object... objArr);
    }

    void getSize(int i, Map<Integer, IAnimatedElement> map, int[] iArr);

    void layout(int i, Map<Integer, IAnimatedElement> map);

    void layout(int i, Map<Integer, IAnimatedElement> map, ICallback iCallback);

    /* loaded from: classes9.dex */
    public static class Factory {
        public static int calculateLayoutStrategy(Rect rect, int i, int i2) {
            if (rect == null) {
                return 2;
            }
            int centerX = rect.centerX();
            int i3 = i / 3;
            if (centerX < i3) {
                return 0;
            }
            return centerX < i3 * 2 ? 1 : 2;
        }

        public static ILayoutStrategy getLayoutStrategy(int i, Rect rect, int i2, int i3, IResourceProvider iResourceProvider) {
            switch (i) {
                case 0:
                    return new LeftLayoutStrategy(rect, i2, i3, iResourceProvider);
                case 1:
                    return new MiddleLayoutStrategy(rect, i2, i3, iResourceProvider);
                case 2:
                    return new RightLayoutStrategy(rect, i2, i3, iResourceProvider);
                default:
                    return null;
            }
        }
    }
}
