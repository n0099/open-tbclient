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
/* loaded from: classes5.dex */
public class NoPressedRelativeLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public View f30073b;

    /* renamed from: c  reason: collision with root package name */
    public float f30074c;

    /* renamed from: d  reason: collision with root package name */
    public int f30075d;

    /* renamed from: e  reason: collision with root package name */
    public float f30076e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f30077f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30078g;

    /* renamed from: h  reason: collision with root package name */
    public a f30079h;
    public boolean i;

    /* loaded from: classes5.dex */
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
        this.f30074c = 0.0f;
        this.f30075d = 0;
        this.f30076e = 0.0f;
        this.f30078g = false;
        this.i = false;
        this.f30075d = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private Rect getTopViewRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (a()) {
                int[] iArr = {0, 0};
                View view = this.a;
                if (view != null) {
                    view.getLocationOnScreen(iArr);
                    this.f30077f = new Rect(iArr[0], iArr[1], iArr[0] + this.a.getWidth(), iArr[1] + this.a.getHeight());
                }
            }
            return this.f30077f;
        }
        return (Rect) invokeV.objValue;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65538, this, z) == null) || (view = this.f30073b) == null) {
            return;
        }
        view.setEnabled(z);
        this.f30073b.setClickable(z);
        this.f30073b.setLongClickable(z);
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a == null) {
                return false;
            }
            Rect rect = this.f30077f;
            return rect == null || rect.width() <= 0 || this.f30077f.height() <= 0;
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
            a aVar = this.f30079h;
            if (aVar != null) {
                aVar.a(motionEvent);
            }
            if (this.a != null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float abs = this.f30076e > Math.abs(this.f30074c - motionEvent.getRawY()) ? this.f30076e : Math.abs(this.f30074c - motionEvent.getRawY());
                            this.f30076e = abs;
                            if (this.f30078g && abs < this.f30075d) {
                                setBottomViewClickEventEnabled(false);
                            } else {
                                setBottomViewClickEventEnabled(true);
                            }
                            return super.dispatchTouchEvent(motionEvent);
                        }
                    }
                    if (this.f30078g) {
                        float abs2 = Math.abs(this.f30074c - motionEvent.getRawY());
                        int i = this.f30075d;
                        if (abs2 < i && this.f30076e < i && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                            setBottomViewClickEventEnabled(false);
                            if (this.a.isClickable()) {
                                this.a.performClick();
                            }
                            return true;
                        }
                    }
                } else {
                    this.f30074c = motionEvent.getRawY();
                    this.f30076e = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.f30078g = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.f30078g = false;
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

    public void setBottomOrderView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.f30073b = view;
        }
    }

    public void setDispathEventAction(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f30079h = aVar;
        }
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.i = z;
        }
    }

    public void setTopOrderView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            this.a = view;
        }
    }
}
