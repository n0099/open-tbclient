package com.baidu.searchbox.ui.span;

import android.content.Context;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.UnifyTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BdSpanTouchFixTextView extends UnifyTextView implements ISpanTouchFix {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mNeedForceEventToParent;
    public boolean mRealPressStatus;
    public boolean mSuperNeedLongClickEvent;
    public boolean mSyncSpanPressStatus;
    public boolean mTouchSpanHit;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdSpanTouchFixTextView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void onSetPressed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            super.setPressed(z);
        }
    }

    @Override // com.baidu.searchbox.ui.span.ISpanTouchFix
    public void onSpanSetPressed(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && this.mSyncSpanPressStatus) {
            setPressed(z);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (!(getText() instanceof Spannable)) {
                return super.onTouchEvent(motionEvent);
            }
            this.mTouchSpanHit = false;
            return this.mNeedForceEventToParent ? this.mTouchSpanHit : super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean performClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mTouchSpanHit || this.mNeedForceEventToParent) {
                return false;
            }
            return super.performClick();
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if ((this.mTouchSpanHit || this.mNeedForceEventToParent) && !this.mSuperNeedLongClickEvent) {
                return false;
            }
            return super.performLongClick();
        }
        return invokeV.booleanValue;
    }

    public void setBdMovementMethod() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setMovementMethod(BdLinkTouchMovementMethod.getInstance());
            if (this.mNeedForceEventToParent) {
                setNeedForceEventToParent(true);
            }
        }
    }

    public void setNeedForceEventToParent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.mNeedForceEventToParent = z;
            setFocusable(!z);
            setClickable(!z);
            setLongClickable(!z);
        }
    }

    @Override // android.view.View
    public final void setPressed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.mRealPressStatus = z;
            if (this.mSyncSpanPressStatus || !this.mTouchSpanHit) {
                onSetPressed(z);
            }
        }
    }

    public void setSuperNeedLongClickEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.mSuperNeedLongClickEvent = z;
        }
    }

    public void setSyncSpanPressStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mSyncSpanPressStatus = z;
        }
    }

    @Override // com.baidu.searchbox.ui.span.ISpanTouchFix
    public void setTouchSpanHit(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || this.mTouchSpanHit == z) {
            return;
        }
        this.mTouchSpanHit = z;
        setPressed(this.mRealPressStatus);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdSpanTouchFixTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdSpanTouchFixTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mRealPressStatus = false;
        this.mNeedForceEventToParent = false;
        this.mSyncSpanPressStatus = false;
        this.mSuperNeedLongClickEvent = false;
        setHighlightColor(0);
    }
}
