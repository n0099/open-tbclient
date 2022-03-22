package com.baidu.spswitch.handler;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.IPanelConflictLayout;
import com.baidu.spswitch.utils.SPConfig;
import com.baidu.spswitch.utils.ViewUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SPSwitchPanelLayoutHandler implements IPanelConflictLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsHide;
    public boolean mIsSoftInputShowing;
    public final View mPanelLayout;

    public SPSwitchPanelLayoutHandler(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsHide = false;
        this.mIsSoftInputShowing = false;
        this.mPanelLayout = view;
    }

    public boolean filterSetVisibility(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i == 0) {
                this.mIsHide = false;
            }
            if (i == this.mPanelLayout.getVisibility()) {
                return true;
            }
            return isSoftInputShowing() && i == 0;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.spswitch.IPanelConflictLayout
    public void handleHide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mIsHide = true;
        }
    }

    @Override // com.baidu.spswitch.IPanelConflictLayout
    public void handleShow() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && SPConfig.isDebug()) {
            throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
        }
    }

    @Override // com.baidu.spswitch.IPanelConflictLayout
    public boolean isSoftInputShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mIsSoftInputShowing : invokeV.booleanValue;
    }

    @Override // com.baidu.spswitch.IPanelConflictLayout
    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? !this.mIsHide : invokeV.booleanValue;
    }

    public int[] processOnMeasure(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i, i2)) == null) {
            if (this.mIsHide) {
                this.mPanelLayout.setVisibility(8);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
                i = makeMeasureSpec;
            }
            return new int[]{i, i2};
        }
        return (int[]) invokeII.objValue;
    }

    public void refreshPanelHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            ViewUtil.refreshHeight(this.mPanelLayout, i);
        }
    }

    public void setIsSoftInputShowing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.mIsSoftInputShowing = z;
        }
    }
}
