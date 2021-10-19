package c.a.r0.c2;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a extends Animation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f16110e;

    /* renamed from: f  reason: collision with root package name */
    public int f16111f;

    /* renamed from: g  reason: collision with root package name */
    public int f16112g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout.LayoutParams f16113h;

    public a(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (view == null) {
            return;
        }
        this.f16110e = view;
        if (view.getVisibility() == 8 && i3 > 0) {
            this.f16111f = i3;
        } else {
            this.f16111f = this.f16110e.getMeasuredHeight();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        this.f16113h = layoutParams;
        this.f16112g = i2;
        if (i2 == 0) {
            layoutParams.bottomMargin = -this.f16111f;
        } else {
            layoutParams.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
            super.applyTransformation(f2, transformation);
            if (f2 < 1.0f) {
                if (this.f16112g == 0) {
                    FrameLayout.LayoutParams layoutParams = this.f16113h;
                    int i2 = this.f16111f;
                    layoutParams.bottomMargin = (-i2) + ((int) (i2 * f2));
                } else {
                    this.f16113h.bottomMargin = -((int) (this.f16111f * f2));
                }
                this.f16110e.requestLayout();
            } else if (this.f16112g == 0) {
                this.f16113h.bottomMargin = 0;
                this.f16110e.requestLayout();
                this.f16111f = this.f16110e.getMeasuredHeight();
            } else {
                this.f16113h.bottomMargin = -this.f16111f;
                this.f16110e.setVisibility(8);
                this.f16110e.requestLayout();
            }
        }
    }
}
