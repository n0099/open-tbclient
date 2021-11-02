package b.a.r0.c2;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a extends Animation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f15145e;

    /* renamed from: f  reason: collision with root package name */
    public int f15146f;

    /* renamed from: g  reason: collision with root package name */
    public int f15147g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout.LayoutParams f15148h;

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
        this.f15145e = view;
        if (view.getVisibility() == 8 && i3 > 0) {
            this.f15146f = i3;
        } else {
            this.f15146f = this.f15145e.getMeasuredHeight();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        this.f15148h = layoutParams;
        this.f15147g = i2;
        if (i2 == 0) {
            layoutParams.bottomMargin = -this.f15146f;
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
                if (this.f15147g == 0) {
                    FrameLayout.LayoutParams layoutParams = this.f15148h;
                    int i2 = this.f15146f;
                    layoutParams.bottomMargin = (-i2) + ((int) (i2 * f2));
                } else {
                    this.f15148h.bottomMargin = -((int) (this.f15146f * f2));
                }
                this.f15145e.requestLayout();
            } else if (this.f15147g == 0) {
                this.f15148h.bottomMargin = 0;
                this.f15145e.requestLayout();
                this.f15146f = this.f15145e.getMeasuredHeight();
            } else {
                this.f15148h.bottomMargin = -this.f15146f;
                this.f15145e.setVisibility(8);
                this.f15145e.requestLayout();
            }
        }
    }
}
