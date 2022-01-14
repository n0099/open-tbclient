package c.a.t0.j2;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a extends Animation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f18216e;

    /* renamed from: f  reason: collision with root package name */
    public int f18217f;

    /* renamed from: g  reason: collision with root package name */
    public int f18218g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout.LayoutParams f18219h;

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
        this.f18216e = view;
        if (view.getVisibility() == 8 && i3 > 0) {
            this.f18217f = i3;
        } else {
            this.f18217f = this.f18216e.getMeasuredHeight();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        this.f18219h = layoutParams;
        this.f18218g = i2;
        if (i2 == 0) {
            layoutParams.bottomMargin = -this.f18217f;
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
                if (this.f18218g == 0) {
                    FrameLayout.LayoutParams layoutParams = this.f18219h;
                    int i2 = this.f18217f;
                    layoutParams.bottomMargin = (-i2) + ((int) (i2 * f2));
                } else {
                    this.f18219h.bottomMargin = -((int) (this.f18217f * f2));
                }
                this.f18216e.requestLayout();
            } else if (this.f18218g == 0) {
                this.f18219h.bottomMargin = 0;
                this.f18216e.requestLayout();
                this.f18217f = this.f18216e.getMeasuredHeight();
            } else {
                this.f18219h.bottomMargin = -this.f18217f;
                this.f18216e.setVisibility(8);
                this.f18216e.requestLayout();
            }
        }
    }
}
