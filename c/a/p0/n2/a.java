package c.a.p0.n2;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends Animation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public int f16530b;

    /* renamed from: c  reason: collision with root package name */
    public int f16531c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout.LayoutParams f16532d;

    public a(View view, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (view == null) {
            return;
        }
        this.a = view;
        if (view.getVisibility() == 8 && i2 > 0) {
            this.f16530b = i2;
        } else {
            this.f16530b = this.a.getMeasuredHeight();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        this.f16532d = layoutParams;
        this.f16531c = i;
        if (i == 0) {
            layoutParams.bottomMargin = -this.f16530b;
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
                if (this.f16531c == 0) {
                    FrameLayout.LayoutParams layoutParams = this.f16532d;
                    int i = this.f16530b;
                    layoutParams.bottomMargin = (-i) + ((int) (i * f2));
                } else {
                    this.f16532d.bottomMargin = -((int) (this.f16530b * f2));
                }
                this.a.requestLayout();
            } else if (this.f16531c == 0) {
                this.f16532d.bottomMargin = 0;
                this.a.requestLayout();
                this.f16530b = this.a.getMeasuredHeight();
            } else {
                this.f16532d.bottomMargin = -this.f16530b;
                this.a.setVisibility(8);
                this.a.requestLayout();
            }
        }
    }
}
