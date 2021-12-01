package c.g.a0.b;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import c.g.a0.b.a0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes7.dex */
public class z implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a0.a f28742e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ View f28743f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f28744g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f28745h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f28746i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int[] f28747j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f28748k;
    public final /* synthetic */ a0 l;

    public z(a0 a0Var, a0.a aVar, View view, ViewGroup viewGroup, float f2, float f3, int[] iArr, ViewGroup viewGroup2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a0Var, aVar, view, viewGroup, Float.valueOf(f2), Float.valueOf(f3), iArr, viewGroup2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = a0Var;
        this.f28742e = aVar;
        this.f28743f = view;
        this.f28744g = viewGroup;
        this.f28745h = f2;
        this.f28746i = f3;
        this.f28747j = iArr;
        this.f28748k = viewGroup2;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
            this.l.a(this.f28743f, this.f28744g, this.f28745h, this.f28746i, this.f28747j, this.f28748k, this.f28742e);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            LogPrinter.d("zoomOut onAnimationStart", new Object[0]);
            this.l.getClass();
        }
    }
}
