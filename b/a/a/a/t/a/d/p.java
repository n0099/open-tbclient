package b.a.a.a.t.a.d;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import b.a.a.a.t.a.d.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class p implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ q.a f1286e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ View f1287f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1288g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f1289h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f1290i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int[] f1291j;
    public final /* synthetic */ ViewGroup k;
    public final /* synthetic */ q l;

    public p(q qVar, q.a aVar, View view, ViewGroup viewGroup, float f2, float f3, int[] iArr, ViewGroup viewGroup2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qVar, aVar, view, viewGroup, Float.valueOf(f2), Float.valueOf(f3), iArr, viewGroup2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = qVar;
        this.f1286e = aVar;
        this.f1287f = view;
        this.f1288g = viewGroup;
        this.f1289h = f2;
        this.f1290i = f3;
        this.f1291j = iArr;
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
            this.l.a(this.f1287f, this.f1288g, this.f1289h, this.f1290i, this.f1291j, this.k, this.f1286e);
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
            b.a.a.a.x.d.b("zoomOut onAnimationStart", new Object[0]);
            if (this.l == null) {
                throw null;
            }
        }
    }
}
