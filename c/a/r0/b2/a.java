package c.a.r0.b2;

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
    public View f15938e;

    /* renamed from: f  reason: collision with root package name */
    public int f15939f;

    /* renamed from: g  reason: collision with root package name */
    public int f15940g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout.LayoutParams f15941h;

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
        this.f15938e = view;
        if (view.getVisibility() == 8 && i3 > 0) {
            this.f15939f = i3;
        } else {
            this.f15939f = this.f15938e.getMeasuredHeight();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        this.f15941h = layoutParams;
        this.f15940g = i2;
        if (i2 == 0) {
            layoutParams.bottomMargin = -this.f15939f;
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
                if (this.f15940g == 0) {
                    FrameLayout.LayoutParams layoutParams = this.f15941h;
                    int i2 = this.f15939f;
                    layoutParams.bottomMargin = (-i2) + ((int) (i2 * f2));
                } else {
                    this.f15941h.bottomMargin = -((int) (this.f15939f * f2));
                }
                this.f15938e.requestLayout();
            } else if (this.f15940g == 0) {
                this.f15941h.bottomMargin = 0;
                this.f15938e.requestLayout();
                this.f15939f = this.f15938e.getMeasuredHeight();
            } else {
                this.f15941h.bottomMargin = -this.f15939f;
                this.f15938e.setVisibility(8);
                this.f15938e.requestLayout();
            }
        }
    }
}
