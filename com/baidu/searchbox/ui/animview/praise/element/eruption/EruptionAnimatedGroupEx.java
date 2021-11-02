package com.baidu.searchbox.ui.animview.praise.element.eruption;

import android.graphics.drawable.Drawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder;
import com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionElementBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class EruptionAnimatedGroupEx extends EruptionAnimatedGroup {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG = false;
    public transient /* synthetic */ FieldHolder $fh;
    public IPraiseElementBuilder.FetchConfig mConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EruptionAnimatedGroupEx(BaseAnimatedElement.ScaleType scaleType) {
        super(null, scaleType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {scaleType};
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
        this.mConfig = new IPraiseElementBuilder.FetchConfig();
    }

    private void parseOtherParams(Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, objArr) == null) || objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Drawable.Callback)) {
            return;
        }
        setDrawableCallback((Drawable.Callback) objArr[0]);
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimatedGroup, com.baidu.searchbox.ui.animview.base.BaseAnimatedElement, com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public BaseAnimatedElement cloneInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new EruptionAnimatedGroupEx(this.mScaleType) : (BaseAnimatedElement) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement, com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void copyAttribute(BaseAnimatedElement baseAnimatedElement) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseAnimatedElement) == null) && baseAnimatedElement != null && (baseAnimatedElement instanceof EruptionAnimatedGroupEx)) {
            EruptionAnimatedGroupEx eruptionAnimatedGroupEx = (EruptionAnimatedGroupEx) baseAnimatedElement;
            int i2 = eruptionAnimatedGroupEx.mLeft;
            this.mLeft = i2;
            int i3 = eruptionAnimatedGroupEx.mTop;
            this.mTop = i3;
            int i4 = eruptionAnimatedGroupEx.mWidth;
            this.mWidth = i4;
            int i5 = eruptionAnimatedGroupEx.mHeight;
            this.mHeight = i5;
            IResourceProvider iResourceProvider = eruptionAnimatedGroupEx.mResourceProvider;
            this.mResourceProvider = iResourceProvider;
            Object[] objArr = eruptionAnimatedGroupEx.mOtherInitParams;
            this.mOtherInitParams = objArr;
            init(i2, i3, i4, i5, iResourceProvider, objArr);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimatedGroup, com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onInit(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objArr) == null) {
            parseOtherParams(objArr);
            this.mOtherInitParams = objArr;
            this.mConfig.setLeft(this.mLeft).setTop(this.mTop).setWidth(this.mWidth).setHeight(this.mHeight).setDrawableCallback(this.mDrawableCallback);
            enableDrawDebugBound(false, -7829368);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimatedGroup, com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimatedGroup
    public void updateCurrentStrategy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.mConfig.setStrategyTag(str);
            EruptionElementBuilder.BuildResult result = EruptionElementBuilder.getInstance().getResult(this.mConfig);
            if (result == null) {
                return;
            }
            this.mElementList = result.eruptionElementList;
            this.mElementAngleList = result.eruptionRotateAngleList;
            this.mElementFactorList = result.transformedFactorList;
        }
    }
}
