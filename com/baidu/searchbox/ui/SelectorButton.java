package com.baidu.searchbox.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SelectorButton extends Button {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float DISABLED_ALPHA_SCALE_DEFAULT = 0.4f;
    public static final int NORMAL_ALPHA = 1;
    public static final float PRESSED_ALPHA_SCALE_DEFAULT = 0.6f;
    public transient /* synthetic */ FieldHolder $fh;
    public float disabledAlpha;
    public float pressedAlpha;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectorButton(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, context, attributeSet) == null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.android.common.ui.R.styleable.SelectorImageButton);
                if (obtainStyledAttributes != null) {
                    float f2 = obtainStyledAttributes.getFloat(com.baidu.android.common.ui.R.styleable.SelectorImageButton_disabledAlphaScale, 0.4f);
                    float f3 = obtainStyledAttributes.getFloat(com.baidu.android.common.ui.R.styleable.SelectorImageButton_pressedAlphaScale, 0.6f);
                    this.disabledAlpha = verify(f2);
                    this.pressedAlpha = verify(f3);
                    obtainStyledAttributes.recycle();
                    return;
                }
                return;
            }
            this.disabledAlpha = 1.0f;
            this.pressedAlpha = 1.0f;
        }
    }

    private float verify(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TRACKBALL, this, f2)) == null) {
            if (f2 > 1.0f) {
                return 1.0f;
            }
            if (f2 < 0.0f) {
                return 0.0f;
            }
            return f2;
        }
        return invokeF.floatValue;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (isEnabled()) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    setAlpha(this.pressedAlpha);
                } else if (action == 1) {
                    setAlpha(1.0f);
                } else if (action == 3) {
                    setAlpha(1.0f);
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setDisabledAlphaScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            this.disabledAlpha = verify(f2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            super.setEnabled(z);
            if (!z) {
                setAlpha(this.disabledAlpha);
            } else {
                setAlpha(1.0f);
            }
        }
    }

    public void setPressedAlphaScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
            this.pressedAlpha = verify(f2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectorButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectorButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        init(context, attributeSet);
    }
}
