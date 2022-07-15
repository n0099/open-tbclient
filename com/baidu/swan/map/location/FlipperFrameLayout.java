package com.baidu.swan.map.location;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ScrollingView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.u54;
/* loaded from: classes2.dex */
public class FlipperFrameLayout extends FrameLayout implements u54.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public u54 b;
    public boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlipperFrameLayout(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.u54.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.c = false;
        }
    }

    @Override // com.repackage.u54.b
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.c = true;
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getChildCount() <= 0) {
                return true;
            }
            View childAt = getChildAt(0);
            if (childAt instanceof ScrollingView) {
                return !childAt.canScrollVertically(-1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean d(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f)) == null) ? Math.abs(f) >= ((float) ViewConfiguration.getTouchSlop()) : invokeF.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001a, code lost:
        if (r0 != 3) goto L15;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (!this.c && this.b != null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float rawY = motionEvent.getRawY() - this.a;
                            boolean z = rawY <= 0.0f;
                            if (z && !this.b.d() && d(rawY)) {
                                this.b.e(true);
                                return true;
                            } else if (!z && c() && this.b.d() && d(rawY)) {
                                this.b.e(false);
                                return true;
                            }
                        }
                    }
                    this.a = motionEvent.getRawY();
                } else {
                    this.a = motionEvent.getRawY();
                }
                return super.onInterceptTouchEvent(motionEvent);
            }
            this.a = motionEvent.getRawY();
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setViewFlipper(u54 u54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, u54Var) == null) {
            this.b = u54Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlipperFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlipperFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
    }
}
