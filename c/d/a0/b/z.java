package c.d.a0.b;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import c.d.a0.b.a0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes3.dex */
public class z implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ a0.a a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f23053b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f23054c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f23055d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ float f23056e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int[] f23057f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f23058g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ a0 f23059h;

    public z(a0 a0Var, a0.a aVar, View view, ViewGroup viewGroup, float f2, float f3, int[] iArr, ViewGroup viewGroup2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a0Var, aVar, view, viewGroup, Float.valueOf(f2), Float.valueOf(f3), iArr, viewGroup2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23059h = a0Var;
        this.a = aVar;
        this.f23053b = view;
        this.f23054c = viewGroup;
        this.f23055d = f2;
        this.f23056e = f3;
        this.f23057f = iArr;
        this.f23058g = viewGroup2;
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
            this.f23059h.a(this.f23053b, this.f23054c, this.f23055d, this.f23056e, this.f23057f, this.f23058g, this.a);
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
            this.f23059h.getClass();
        }
    }
}
