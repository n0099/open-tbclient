package c.a.q0.x.v.c;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.x.v.d.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b implements c.a.q0.x.v.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final View f15111e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15112f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15113g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15114h;

    public b(View view, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15112f = false;
        this.f15113g = false;
        this.f15114h = false;
        this.f15111e = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, R$styleable.KPSwitchPanelLayout);
                this.f15113g = typedArray.getBoolean(R$styleable.KPSwitchPanelLayout_ignore_recommend_height, false);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 == 0) {
                this.f15112f = false;
            }
            if (i2 == this.f15111e.getVisibility()) {
                return true;
            }
            return isKeyboardShowing() && i2 == 0;
        }
        return invokeI.booleanValue;
    }

    public int[] b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            if (this.f15112f) {
                this.f15111e.setVisibility(8);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
                i3 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
                i2 = makeMeasureSpec;
            }
            return new int[]{i2, i3};
        }
        return (int[]) invokeII.objValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f15113g) {
            return;
        }
        d.d(this.f15111e, i2);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f15113g = z;
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f15114h = z;
        }
    }

    @Override // c.a.q0.x.v.a
    public void handleHide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f15112f = true;
        }
    }

    @Override // c.a.q0.x.v.a
    public void handleShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
        }
    }

    @Override // c.a.q0.x.v.a
    public boolean isKeyboardShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f15114h : invokeV.booleanValue;
    }

    @Override // c.a.q0.x.v.a
    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? !this.f15112f : invokeV.booleanValue;
    }
}
