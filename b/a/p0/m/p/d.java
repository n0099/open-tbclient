package b.a.p0.m.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.a.p0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final int f11650f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f11651a;

    /* renamed from: b  reason: collision with root package name */
    public View f11652b;

    /* renamed from: c  reason: collision with root package name */
    public View f11653c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11654d;

    /* renamed from: e  reason: collision with root package name */
    public b f11655e;

    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11656e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f11657f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f11658g;

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
            this.f11658g = dVar;
            this.f11656e = z;
            this.f11657f = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!this.f11656e) {
                    this.f11658g.c(this.f11657f);
                }
                if (this.f11658g.f11655e != null) {
                    this.f11658g.f11655e.onFlipOver(this.f11656e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onFlipOver(boolean z);

        void onFlipStart(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-721861952, "Lb/a/p0/m/p/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-721861952, "Lb/a/p0/m/p/d;");
                return;
            }
        }
        f11650f = n0.g(58.0f);
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
        this.f11651a = view;
        this.f11652b = frameLayout;
        this.f11653c = view2;
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            ViewGroup.LayoutParams layoutParams = this.f11651a.getLayoutParams();
            layoutParams.height = this.f11651a.getHeight() - (i2 * 2);
            this.f11651a.setLayoutParams(layoutParams);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11654d : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            b bVar = this.f11655e;
            if (bVar != null) {
                bVar.onFlipStart(z);
            }
            this.f11654d = z;
            int i2 = f11650f;
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
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.f11652b, "translationY", fArr), ObjectAnimator.ofFloat(this.f11651a, "translationY", fArr2), ObjectAnimator.ofFloat(this.f11653c, "translationY", fArr2));
            animatorSet.setDuration(200L);
            animatorSet.start();
            animatorSet.addListener(new a(this, z, i2));
            if (z) {
                c(i2);
            }
        }
    }
}
