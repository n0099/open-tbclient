package com.baidu.searchbox.ui.animview.praise.layout;

import android.graphics.Rect;
import com.baidu.searchbox.ui.animview.base.IAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes7.dex */
public interface ILayoutStrategy {
    public static final int ELEMENT_TYPE_ERUPTION = 4;
    public static final int ELEMENT_TYPE_PRAISE_LEVEL = 2;
    public static final int ELEMENT_TYPE_PRAISE_NUMBER = 3;
    public static final int ELEMENT_TYPE_SHAKE = 1;
    public static final int ELEMENT_TYPE_WAVE = 0;
    public static final int STRATEGY_LEFT = 0;
    public static final int STRATEGY_MIDDLE = 1;
    public static final int STRATEGY_RIGHT = 2;

    /* loaded from: classes7.dex */
    public static class Factory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Factory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static int calculateLayoutStrategy(Rect rect, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, rect, i2, i3)) == null) {
                if (rect == null) {
                    return 2;
                }
                int centerX = rect.centerX();
                int i4 = i2 / 3;
                if (centerX < i4) {
                    return 0;
                }
                return centerX < i4 * 2 ? 1 : 2;
            }
            return invokeLII.intValue;
        }

        public static ILayoutStrategy getLayoutStrategy(int i2, Rect rect, int i3, int i4, IResourceProvider iResourceProvider) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), rect, Integer.valueOf(i3), Integer.valueOf(i4), iResourceProvider})) == null) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            return null;
                        }
                        return new RightLayoutStrategy(rect, i3, i4, iResourceProvider);
                    }
                    return new MiddleLayoutStrategy(rect, i3, i4, iResourceProvider);
                }
                return new LeftLayoutStrategy(rect, i3, i4, iResourceProvider);
            }
            return (ILayoutStrategy) invokeCommon.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface ICallback {
        void init(IAnimatedElement iAnimatedElement, int i2, int i3, int i4, int i5, IResourceProvider iResourceProvider, Object... objArr);
    }

    void getSize(int i2, Map<Integer, IAnimatedElement> map, int[] iArr);

    void layout(int i2, Map<Integer, IAnimatedElement> map);

    void layout(int i2, Map<Integer, IAnimatedElement> map, ICallback iCallback);
}
