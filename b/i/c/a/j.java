package b.i.c.a;

import android.animation.ValueAnimator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.InstallActivity;
/* loaded from: classes6.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f32934e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f32935f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f32936g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ InstallActivity f32937h;

    public j(InstallActivity installActivity, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {installActivity, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32937h = installActivity;
        this.f32934e = i2;
        this.f32935f = i3;
        this.f32936g = i4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
            float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
            float animatedFraction2 = valueAnimator.getAnimatedFraction();
            int i2 = this.f32935f;
            this.f32937h.getWindow().setLayout((int) ((this.f32934e * animatedFraction) + (i2 * animatedFraction2)), (int) ((this.f32936g * animatedFraction) + (i2 * animatedFraction2)));
            this.f32937h.getWindow().getDecorView().refreshDrawableState();
        }
    }
}
