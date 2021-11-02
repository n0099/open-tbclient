package b.g.a0.b;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import b.g.a0.b.b0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes6.dex */
public class a0 implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ b0.a f30898e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ View f30899f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f30900g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f30901h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f30902i;
    public final /* synthetic */ int[] j;
    public final /* synthetic */ ViewGroup k;
    public final /* synthetic */ b0 l;

    public a0(b0 b0Var, b0.a aVar, View view, ViewGroup viewGroup, float f2, float f3, int[] iArr, ViewGroup viewGroup2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b0Var, aVar, view, viewGroup, Float.valueOf(f2), Float.valueOf(f3), iArr, viewGroup2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = b0Var;
        this.f30898e = aVar;
        this.f30899f = view;
        this.f30900g = viewGroup;
        this.f30901h = f2;
        this.f30902i = f3;
        this.j = iArr;
        this.k = viewGroup2;
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
            this.l.a(this.f30899f, this.f30900g, this.f30901h, this.f30902i, this.j, this.k, this.f30898e);
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
