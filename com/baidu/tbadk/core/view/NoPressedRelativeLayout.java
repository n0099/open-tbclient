package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class NoPressedRelativeLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public float c;
    public int d;
    public float e;
    public Rect f;
    public boolean g;
    public a h;
    public boolean i;

    /* loaded from: classes3.dex */
    public interface a {
        void a(MotionEvent motionEvent);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0.0f;
        this.d = 0;
        this.e = 0.0f;
        this.g = false;
        this.i = false;
        this.d = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private Rect getTopViewRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (a()) {
                int[] iArr = {0, 0};
                View view2 = this.a;
                if (view2 != null) {
                    view2.getLocationOnScreen(iArr);
                    this.f = new Rect(iArr[0], iArr[1], iArr[0] + this.a.getWidth(), iArr[1] + this.a.getHeight());
                }
            }
            return this.f;
        }
        return (Rect) invokeV.objValue;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65538, this, z) == null) || (view2 = this.b) == null) {
            return;
        }
        view2.setEnabled(z);
        this.b.setClickable(z);
        this.b.setLongClickable(z);
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a == null) {
                return false;
            }
            Rect rect = this.f;
            return rect == null || rect.width() <= 0 || this.f.height() <= 0;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001d, code lost:
        if (r0 != 3) goto L50;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            a aVar = this.h;
            if (aVar != null) {
                aVar.a(motionEvent);
            }
            if (this.a != null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float abs = this.e > Math.abs(this.c - motionEvent.getRawY()) ? this.e : Math.abs(this.c - motionEvent.getRawY());
                            this.e = abs;
                            if (this.g && abs < this.d) {
                                setBottomViewClickEventEnabled(false);
                            } else {
                                setBottomViewClickEventEnabled(true);
                            }
                            return super.dispatchTouchEvent(motionEvent);
                        }
                    }
                    if (this.g) {
                        float abs2 = Math.abs(this.c - motionEvent.getRawY());
                        int i = this.d;
                        if (abs2 < i && this.e < i && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                            setBottomViewClickEventEnabled(false);
                            if (this.a.isClickable()) {
                                this.a.performClick();
                            }
                            return true;
                        }
                    }
                } else {
                    this.c = motionEvent.getRawY();
                    this.e = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.g = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.g = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            if (this.i) {
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setBottomOrderView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.b = view2;
        }
    }

    public void setDispathEventAction(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.h = aVar;
        }
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.i = z;
        }
    }

    public void setTopOrderView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            this.a = view2;
        }
    }
}
