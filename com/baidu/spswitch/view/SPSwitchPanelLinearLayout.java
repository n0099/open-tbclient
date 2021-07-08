package com.baidu.spswitch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.IPanelConflictLayout;
import com.baidu.spswitch.IPanelHeightTarget;
import com.baidu.spswitch.handler.SPSwitchPanelLayoutHandler;
import com.baidu.spswitch.utils.SPConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SPSwitchPanelLinearLayout extends LinearLayout implements IPanelConflictLayout, IPanelHeightTarget {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public SPSwitchPanelLayoutHandler mPanelLayoutHandler;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1418332691, "Lcom/baidu/spswitch/view/SPSwitchPanelLinearLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1418332691, "Lcom/baidu/spswitch/view/SPSwitchPanelLinearLayout;");
                return;
            }
        }
        TAG = SPSwitchPanelLinearLayout.class.getSimpleName();
        DEBUG = SPConfig.isDebug();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SPSwitchPanelLinearLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mPanelLayoutHandler = new SPSwitchPanelLayoutHandler(this);
        }
    }

    @Override // com.baidu.spswitch.IPanelConflictLayout
    public void handleHide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mPanelLayoutHandler.handleHide();
        }
    }

    @Override // com.baidu.spswitch.IPanelConflictLayout
    public void handleShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.setVisibility(0);
        }
    }

    @Override // com.baidu.spswitch.IPanelConflictLayout
    public boolean isSoftInputShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPanelLayoutHandler.isSoftInputShowing() : invokeV.booleanValue;
    }

    @Override // com.baidu.spswitch.IPanelConflictLayout
    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPanelLayoutHandler.isVisible() : invokeV.booleanValue;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            if (DEBUG) {
                String str = TAG;
                Log.d(str, "panelLayout onMeasure, height: " + View.MeasureSpec.getSize(i3));
            }
            int[] processOnMeasure = this.mPanelLayoutHandler.processOnMeasure(i2, i3);
            if (DEBUG) {
                String str2 = TAG;
                Log.d(str2, "panelLayout onMeasure after process, height: " + View.MeasureSpec.getSize(processOnMeasure[1]));
            }
            super.onMeasure(processOnMeasure[0], processOnMeasure[1]);
        }
    }

    @Override // com.baidu.spswitch.IPanelHeightTarget
    public void onSoftInputShowing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.mPanelLayoutHandler.setIsSoftInputShowing(z);
        }
    }

    @Override // com.baidu.spswitch.IPanelHeightTarget
    public void refreshHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.mPanelLayoutHandler.refreshPanelHeight(i2);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.mPanelLayoutHandler.filterSetVisibility(i2)) {
            return;
        }
        super.setVisibility(i2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SPSwitchPanelLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SPSwitchPanelLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        init();
    }
}
