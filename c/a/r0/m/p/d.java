package c.a.r0.m.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c.a.r0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final int f11535f;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public View f11536b;

    /* renamed from: c  reason: collision with root package name */
    public View f11537c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11538d;

    /* renamed from: e  reason: collision with root package name */
    public b f11539e;

    /* loaded from: classes6.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11540e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f11541f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f11542g;

        public a(d dVar, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Boolean.valueOf(z), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11542g = dVar;
            this.f11540e = z;
            this.f11541f = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!this.f11540e) {
                    this.f11542g.c(this.f11541f);
                }
                if (this.f11542g.f11539e != null) {
                    this.f11542g.f11539e.onFlipOver(this.f11540e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onFlipOver(boolean z);

        void onFlipStart(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-335206589, "Lc/a/r0/m/p/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-335206589, "Lc/a/r0/m/p/d;");
                return;
            }
        }
        f11535f = n0.g(58.0f);
    }

    public d(View view, FrameLayout frameLayout, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, frameLayout, view2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = view;
        this.f11536b = frameLayout;
        this.f11537c = view2;
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            layoutParams.height = this.a.getHeight() - (i2 * 2);
            this.a.setLayoutParams(layoutParams);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11538d : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            b bVar = this.f11539e;
            if (bVar != null) {
                bVar.onFlipStart(z);
            }
            this.f11538d = z;
            int i2 = f11535f;
            if (z) {
                i2 = -i2;
            }
            float[] fArr = new float[2];
            if (z) {
                fArr[0] = 0.0f;
                fArr[1] = i2;
            } else {
                fArr[0] = -i2;
                fArr[1] = 0.0f;
            }
            float[] fArr2 = new float[2];
            if (z) {
                fArr2[0] = 0.0f;
                fArr2[1] = i2 * 2;
            } else {
                fArr2[0] = (-i2) * 2;
                fArr2[1] = 0.0f;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.f11536b, AnimationProperty.TRANSLATE_Y, fArr), ObjectAnimator.ofFloat(this.a, AnimationProperty.TRANSLATE_Y, fArr2), ObjectAnimator.ofFloat(this.f11537c, AnimationProperty.TRANSLATE_Y, fArr2));
            animatorSet.setDuration(200L);
            animatorSet.start();
            animatorSet.addListener(new a(this, z, i2));
            if (z) {
                c(i2);
            }
        }
    }
}
