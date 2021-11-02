package com.baidu.searchbox.ui.animview.praise.element;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimatedGroup;
import com.baidu.searchbox.ui.animview.praise.layout.ILayoutStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class PraiseAnimElementBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect mBaseRect;
    public int mCanvasHeight;
    public int mCanvasWidth;
    public Context mCtx;
    public Drawable.Callback mDrawableCallback;
    public Map<Integer, Integer> mElementCntsMap;
    public Map<Integer, List<IAnimatedElement>> mElementListMap;
    public Map<Integer, IAnimatedElement> mElementSingleMap;
    public ILayoutStrategy mLayoutStrategy;
    public IResourceProvider mProvider;
    public int mSourceType;
    public int mStrategy;

    public PraiseAnimElementBuilder(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBaseRect = new Rect();
        this.mElementSingleMap = new HashMap();
        this.mElementListMap = new HashMap();
        this.mCtx = context;
        this.mSourceType = i2;
    }

    private void addToElementListMap(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i2) == null) {
            Map<Integer, Integer> map = this.mElementCntsMap;
            int intValue = (map == null || map.isEmpty() || !this.mElementCntsMap.containsKey(Integer.valueOf(i2))) ? 0 : this.mElementCntsMap.get(Integer.valueOf(i2)).intValue();
            ArrayList arrayList = new ArrayList();
            IAnimatedElement iAnimatedElement = this.mElementSingleMap.get(Integer.valueOf(i2));
            if (iAnimatedElement == null) {
                return;
            }
            arrayList.add(iAnimatedElement);
            if (intValue <= 1) {
                this.mElementListMap.put(Integer.valueOf(i2), arrayList);
                return;
            }
            for (int i3 = 0; i3 < intValue - 1; i3++) {
                BaseAnimatedElement cloneInstance = iAnimatedElement.cloneInstance();
                if (cloneInstance == null) {
                    return;
                }
                arrayList.add(cloneInstance);
            }
            this.mElementListMap.put(Integer.valueOf(i2), arrayList);
        }
    }

    private void generateElement(int i2) {
        IAnimatedElement waveAnimElement;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            if (i2 == 0) {
                waveAnimElement = new WaveAnimElement(this.mDrawableCallback, BaseAnimatedElement.ScaleType.FIT_CENTER);
            } else if (i2 == 1) {
                waveAnimElement = new ShakeAnimElement(this.mDrawableCallback, BaseAnimatedElement.ScaleType.FIT_CENTER);
            } else if (i2 == 2) {
                waveAnimElement = new PraiseLevelAnimElement(this.mDrawableCallback, BaseAnimatedElement.ScaleType.FIT_XY);
            } else if (i2 == 3) {
                waveAnimElement = new PraiseNumberAnimElement();
            } else if (i2 != 4) {
                return;
            } else {
                waveAnimElement = new EruptionAnimatedGroup(this.mDrawableCallback, BaseAnimatedElement.ScaleType.FIT_XY);
            }
            if (this.mLayoutStrategy != null) {
                this.mElementSingleMap.put(Integer.valueOf(i2), waveAnimElement);
                this.mLayoutStrategy.layout(i2, this.mElementSingleMap);
                addToElementListMap(i2);
            }
        }
    }

    private void initLayoutStrategy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mLayoutStrategy = ILayoutStrategy.Factory.getLayoutStrategy(this.mStrategy, this.mBaseRect, this.mCanvasWidth, this.mCanvasHeight, this.mProvider);
        }
    }

    public Map<Integer, List<IAnimatedElement>> build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            initLayoutStrategy();
            generateElement(0);
            generateElement(1);
            generateElement(2);
            generateElement(3);
            generateElement(4);
            return this.mElementListMap;
        }
        return (Map) invokeV.objValue;
    }

    public PraiseAnimElementBuilder setBaseHeight(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            Rect rect = this.mBaseRect;
            rect.bottom = rect.top + i2;
            return this;
        }
        return (PraiseAnimElementBuilder) invokeI.objValue;
    }

    public PraiseAnimElementBuilder setBaseLeft(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.mBaseRect.left = i2;
            return this;
        }
        return (PraiseAnimElementBuilder) invokeI.objValue;
    }

    public PraiseAnimElementBuilder setBaseTop(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            this.mBaseRect.top = i2;
            return this;
        }
        return (PraiseAnimElementBuilder) invokeI.objValue;
    }

    public PraiseAnimElementBuilder setBaseWidth(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            Rect rect = this.mBaseRect;
            rect.right = rect.left + i2;
            return this;
        }
        return (PraiseAnimElementBuilder) invokeI.objValue;
    }

    public PraiseAnimElementBuilder setCanvasSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) {
            this.mCanvasWidth = i2;
            this.mCanvasHeight = i3;
            return this;
        }
        return (PraiseAnimElementBuilder) invokeII.objValue;
    }

    public PraiseAnimElementBuilder setDrawableCallback(Drawable.Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, callback)) == null) {
            this.mDrawableCallback = callback;
            return this;
        }
        return (PraiseAnimElementBuilder) invokeL.objValue;
    }

    public PraiseAnimElementBuilder setElementCnts(Map<Integer, Integer> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, map)) == null) {
            this.mElementCntsMap = map;
            return this;
        }
        return (PraiseAnimElementBuilder) invokeL.objValue;
    }

    public PraiseAnimElementBuilder setLayoutStrategy(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            this.mStrategy = i2;
            return this;
        }
        return (PraiseAnimElementBuilder) invokeI.objValue;
    }

    public PraiseAnimElementBuilder setResourceProvider(IResourceProvider iResourceProvider) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, iResourceProvider)) == null) {
            this.mProvider = iResourceProvider;
            return this;
        }
        return (PraiseAnimElementBuilder) invokeL.objValue;
    }
}
