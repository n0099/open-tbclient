package c.a.q0.m.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c.a.q0.a.z2.n0;
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
    public static final int f10920f;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public View f10921b;

    /* renamed from: c  reason: collision with root package name */
    public View f10922c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10923d;

    /* renamed from: e  reason: collision with root package name */
    public b f10924e;

    /* loaded from: classes6.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f10925e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f10926f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f10927g;

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
            this.f10927g = dVar;
            this.f10925e = z;
            this.f10926f = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!this.f10925e) {
                    this.f10927g.c(this.f10926f);
                }
                if (this.f10927g.f10924e != null) {
                    this.f10927g.f10924e.onFlipOver(this.f10925e);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1472247874, "Lc/a/q0/m/p/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1472247874, "Lc/a/q0/m/p/d;");
                return;
            }
        }
        f10920f = n0.g(58.0f);
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
        this.f10921b = frameLayout;
        this.f10922c = view2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10923d : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            b bVar = this.f10924e;
            if (bVar != null) {
                bVar.onFlipStart(z);
            }
            this.f10923d = z;
            int i2 = f10920f;
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
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.f10921b, AnimationProperty.TRANSLATE_Y, fArr), ObjectAnimator.ofFloat(this.a, AnimationProperty.TRANSLATE_Y, fArr2), ObjectAnimator.ofFloat(this.f10922c, AnimationProperty.TRANSLATE_Y, fArr2));
            animatorSet.setDuration(200L);
            animatorSet.start();
            animatorSet.addListener(new a(this, z, i2));
            if (z) {
                c(i2);
            }
        }
    }
}
