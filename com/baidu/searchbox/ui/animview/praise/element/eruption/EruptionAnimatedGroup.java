package com.baidu.searchbox.ui.animview.praise.element.eruption;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.EruptionStrategyGroup;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class EruptionAnimatedGroup extends BaseAnimatedElement {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final float ERUPTION_RANDOM_DURATION_FACTOR = 0.6f;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Float> mElementAngleList;
    public List<Float> mElementFactorList;
    public List<BaseAnimatedElement> mElementList;
    public IEruptionStrategyGroup mEruptionStrategyGrp;
    public IEruptionStrategy.IHostCallback mHostCallback;
    public Object[] mOtherInitParams;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EruptionAnimatedGroup(Drawable.Callback callback, BaseAnimatedElement.ScaleType scaleType) {
        super(callback, scaleType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback, scaleType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Drawable.Callback) objArr2[0], (BaseAnimatedElement.ScaleType) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void generatedElements() {
        List<Float> transformedFactorList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (this.mHostCallback == null) {
                this.mHostCallback = new IEruptionStrategy.IHostCallback(this) { // from class: com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimatedGroup.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ EruptionAnimatedGroup this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy.IHostCallback
                    public BaseAnimatedElement createAndInitEruption(int i2, int i3, IResourceProvider iResourceProvider) {
                        InterceptResult invokeIIL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i2, i3, iResourceProvider)) == null) {
                            EruptionAnimElement eruptionAnimElement = new EruptionAnimElement(i3, this.this$0.mDrawableCallback, this.this$0.mScaleType);
                            eruptionAnimElement.init(this.this$0.mLeft, this.this$0.mTop, this.this$0.mWidth, this.this$0.mHeight, iResourceProvider, new Object[0]);
                            return eruptionAnimElement;
                        }
                        return (BaseAnimatedElement) invokeIIL.objValue;
                    }
                };
            }
            List<BaseAnimatedElement> generateEruptionElementList = this.mEruptionStrategyGrp.generateEruptionElementList(this.mResourceProvider, this.mHostCallback);
            List<Float> generateEruptionRotateAngleList = this.mEruptionStrategyGrp.generateEruptionRotateAngleList();
            if (generateEruptionElementList == null || generateEruptionElementList.isEmpty() || generateEruptionRotateAngleList == null || generateEruptionRotateAngleList.isEmpty() || (transformedFactorList = getTransformedFactorList(generateEruptionElementList.size())) == null || transformedFactorList.isEmpty()) {
                return;
            }
            releaseResouces();
            this.mElementList = generateEruptionElementList;
            this.mElementAngleList = generateEruptionRotateAngleList;
            this.mElementFactorList = transformedFactorList;
        }
    }

    private List<Float> getTransformedFactorList(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList.add(Float.valueOf(1.0f / ((float) ((Math.random() * 0.3999999761581421d) + 0.6000000238418579d))));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public static float getTransformedFraction(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float f4 = f2 * f3;
            if (f4 >= 1.0f) {
                return 1.0f;
            }
            return f4;
        }
        return invokeCommon.floatValue;
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement, com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public BaseAnimatedElement cloneInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            EruptionAnimatedGroup eruptionAnimatedGroup = new EruptionAnimatedGroup(this.mDrawableCallback, this.mScaleType);
            eruptionAnimatedGroup.init(this.mLeft, this.mTop, this.mWidth, this.mHeight, this.mResourceProvider, new Object[0]);
            return eruptionAnimatedGroup;
        }
        return (BaseAnimatedElement) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement, com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void dispatchAnimate(Canvas canvas, float f2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, Float.valueOf(f2), Long.valueOf(j)}) == null) {
            super.dispatchAnimate(canvas, f2, j);
            List<BaseAnimatedElement> list = this.mElementList;
            if (list == null || list.isEmpty() || !this.mVisibility) {
                return;
            }
            int i2 = 0;
            for (BaseAnimatedElement baseAnimatedElement : this.mElementList) {
                canvas.save();
                List<Float> list2 = this.mElementAngleList;
                if (list2 != null && i2 < list2.size() && (baseAnimatedElement instanceof EruptionAnimElement)) {
                    ((EruptionAnimElement) baseAnimatedElement).setRotate(this.mElementAngleList.get(i2).floatValue(), 0.5f, 1.0f);
                }
                baseAnimatedElement.dispatchAnimate(canvas, getTransformedFraction(f2, this.mElementFactorList.get(i2).floatValue()), j);
                i2++;
                canvas.restore();
            }
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onDispatchAnimate(Canvas canvas, float f2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{canvas, Float.valueOf(f2), Long.valueOf(j)}) == null) {
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onInit(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
            enableDrawDebugBound(false, -7829368);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
        List<BaseAnimatedElement> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.mElementList) == null || list.size() <= 0) {
            return;
        }
        for (BaseAnimatedElement baseAnimatedElement : this.mElementList) {
            baseAnimatedElement.releaseResouces();
        }
    }

    public void updateCurrentStrategy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (this.mEruptionStrategyGrp == null) {
                this.mEruptionStrategyGrp = new EruptionStrategyGroup();
            }
            this.mEruptionStrategyGrp.setCurrentStrategy(str);
            generatedElements();
        }
    }
}
