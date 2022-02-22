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
/* loaded from: classes11.dex */
public class NoPressedRelativeLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f40684e;

    /* renamed from: f  reason: collision with root package name */
    public View f40685f;

    /* renamed from: g  reason: collision with root package name */
    public float f40686g;

    /* renamed from: h  reason: collision with root package name */
    public int f40687h;

    /* renamed from: i  reason: collision with root package name */
    public float f40688i;

    /* renamed from: j  reason: collision with root package name */
    public Rect f40689j;
    public boolean k;
    public a l;
    public boolean m;

    /* loaded from: classes11.dex */
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
        this.f40686g = 0.0f;
        this.f40687h = 0;
        this.f40688i = 0.0f;
        this.k = false;
        this.m = false;
        this.f40687h = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private Rect getTopViewRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (a()) {
                int[] iArr = {0, 0};
                View view = this.f40684e;
                if (view != null) {
                    view.getLocationOnScreen(iArr);
                    this.f40689j = new Rect(iArr[0], iArr[1], iArr[0] + this.f40684e.getWidth(), iArr[1] + this.f40684e.getHeight());
                }
            }
            return this.f40689j;
        }
        return (Rect) invokeV.objValue;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65538, this, z) == null) || (view = this.f40685f) == null) {
            return;
        }
        view.setEnabled(z);
        this.f40685f.setClickable(z);
        this.f40685f.setLongClickable(z);
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f40684e == null) {
                return false;
            }
            Rect rect = this.f40689j;
            return rect == null || rect.width() <= 0 || this.f40689j.height() <= 0;
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
            if (this.f40684e != null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float abs = this.f40688i > Math.abs(this.f40686g - motionEvent.getRawY()) ? this.f40688i : Math.abs(this.f40686g - motionEvent.getRawY());
                            this.f40688i = abs;
                            if (this.k && abs < this.f40687h) {
                                setBottomViewClickEventEnabled(false);
                            } else {
                                setBottomViewClickEventEnabled(true);
                            }
                            return super.dispatchTouchEvent(motionEvent);
                        }
                    }
                    if (this.k) {
                        float abs2 = Math.abs(this.f40686g - motionEvent.getRawY());
                        int i2 = this.f40687h;
                        if (abs2 < i2 && this.f40688i < i2 && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                            setBottomViewClickEventEnabled(false);
                            if (this.f40684e.isClickable()) {
                                this.f40684e.performClick();
                            }
                            return true;
                        }
                    }
                } else {
                    this.f40686g = motionEvent.getRawY();
                    this.f40688i = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.k = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.k = false;
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
            this.f40685f = view;
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
            this.f40684e = view;
        }
    }
}
