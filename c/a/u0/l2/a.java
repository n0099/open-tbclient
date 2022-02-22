package c.a.u0.l2;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a extends Animation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f19126e;

    /* renamed from: f  reason: collision with root package name */
    public int f19127f;

    /* renamed from: g  reason: collision with root package name */
    public int f19128g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout.LayoutParams f19129h;

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
        this.f19126e = view;
        if (view.getVisibility() == 8 && i3 > 0) {
            this.f19127f = i3;
        } else {
            this.f19127f = this.f19126e.getMeasuredHeight();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        this.f19129h = layoutParams;
        this.f19128g = i2;
        if (i2 == 0) {
            layoutParams.bottomMargin = -this.f19127f;
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
                if (this.f19128g == 0) {
                    FrameLayout.LayoutParams layoutParams = this.f19129h;
                    int i2 = this.f19127f;
                    layoutParams.bottomMargin = (-i2) + ((int) (i2 * f2));
                } else {
                    this.f19129h.bottomMargin = -((int) (this.f19127f * f2));
                }
                this.f19126e.requestLayout();
            } else if (this.f19128g == 0) {
                this.f19129h.bottomMargin = 0;
                this.f19126e.requestLayout();
                this.f19127f = this.f19126e.getMeasuredHeight();
            } else {
                this.f19129h.bottomMargin = -this.f19127f;
                this.f19126e.setVisibility(8);
                this.f19126e.requestLayout();
            }
        }
    }
}
