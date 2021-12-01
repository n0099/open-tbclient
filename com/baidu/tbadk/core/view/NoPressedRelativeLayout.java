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
/* loaded from: classes9.dex */
public class NoPressedRelativeLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f41223e;

    /* renamed from: f  reason: collision with root package name */
    public View f41224f;

    /* renamed from: g  reason: collision with root package name */
    public float f41225g;

    /* renamed from: h  reason: collision with root package name */
    public int f41226h;

    /* renamed from: i  reason: collision with root package name */
    public float f41227i;

    /* renamed from: j  reason: collision with root package name */
    public Rect f41228j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f41229k;
    public a l;
    public boolean m;

    /* loaded from: classes9.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41225g = 0.0f;
        this.f41226h = 0;
        this.f41227i = 0.0f;
        this.f41229k = false;
        this.m = false;
        this.f41226h = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private Rect getTopViewRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (a()) {
                int[] iArr = {0, 0};
                View view = this.f41223e;
                if (view != null) {
                    view.getLocationOnScreen(iArr);
                    this.f41228j = new Rect(iArr[0], iArr[1], iArr[0] + this.f41223e.getWidth(), iArr[1] + this.f41223e.getHeight());
                }
            }
            return this.f41228j;
        }
        return (Rect) invokeV.objValue;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65538, this, z) == null) || (view = this.f41224f) == null) {
            return;
        }
        view.setEnabled(z);
        this.f41224f.setClickable(z);
        this.f41224f.setLongClickable(z);
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f41223e == null) {
                return false;
            }
            Rect rect = this.f41228j;
            return rect == null || rect.width() <= 0 || this.f41228j.height() <= 0;
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
            a aVar = this.l;
            if (aVar != null) {
                aVar.a(motionEvent);
            }
            if (this.f41223e != null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float abs = this.f41227i > Math.abs(this.f41225g - motionEvent.getRawY()) ? this.f41227i : Math.abs(this.f41225g - motionEvent.getRawY());
                            this.f41227i = abs;
                            if (this.f41229k && abs < this.f41226h) {
                                setBottomViewClickEventEnabled(false);
                            } else {
                                setBottomViewClickEventEnabled(true);
                            }
                            return super.dispatchTouchEvent(motionEvent);
                        }
                    }
                    if (this.f41229k) {
                        float abs2 = Math.abs(this.f41225g - motionEvent.getRawY());
                        int i2 = this.f41226h;
                        if (abs2 < i2 && this.f41227i < i2 && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                            setBottomViewClickEventEnabled(false);
                            if (this.f41223e.isClickable()) {
                                this.f41223e.performClick();
                            }
                            return true;
                        }
                    }
                } else {
                    this.f41225g = motionEvent.getRawY();
                    this.f41227i = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.f41229k = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.f41229k = false;
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
            if (this.m) {
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setBottomOrderView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.f41224f = view;
        }
    }

    public void setDispathEventAction(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.l = aVar;
        }
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.m = z;
        }
    }

    public void setTopOrderView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            this.f41223e = view;
        }
    }
}
