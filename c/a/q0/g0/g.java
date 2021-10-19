package c.a.q0.g0;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g extends c.a.q0.g0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ContinuousAnimationView f13424a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f13425b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f13426c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f13427d;

    /* renamed from: e  reason: collision with root package name */
    public int f13428e;

    /* renamed from: f  reason: collision with root package name */
    public final int f13429f;

    /* renamed from: g  reason: collision with root package name */
    public int f13430g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f13431h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13432i;

    /* renamed from: j  reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f13433j;
    public final Animator.AnimatorListener k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f13434e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13434e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.f13434e.isViewAttached()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(this.f13434e.f13431h);
                    return;
                }
                this.f13434e.f13426c.setText(this.f13434e.f13425b[this.f13434e.k()]);
                TbadkCoreApplication.getInst().handler.postDelayed(this.f13434e.f13431h, 200L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f13435e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13435e = gVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.f13435e.f13432i) {
                return;
            }
            this.f13435e.f13424a.setAlpha(Math.min(1.0f, (valueAnimator.getAnimatedFraction() * 24.0f) / 6.0f));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f13436e;

        public c(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13436e = gVar;
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
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                this.f13436e.f13432i = true;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.f13436e.f13432i = false;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(Context context) {
        this(context, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.q0.g0.a
    public void dettachView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            ContinuousAnimationView continuousAnimationView = this.f13424a;
            if (continuousAnimationView != null) {
                continuousAnimationView.cancelAnimation();
            }
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.f13431h);
            super.dettachView(view);
        }
    }

    public void h() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (continuousAnimationView = this.f13424a) == null) {
            return;
        }
        ((RelativeLayout.LayoutParams) continuousAnimationView.getLayoutParams()).addRule(15, 0);
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.attachedView : (View) invokeV.objValue;
    }

    public TextView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13427d : (TextView) invokeV.objValue;
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.f13428e + 1;
            this.f13428e = i2;
            if (i2 >= this.f13429f) {
                this.f13428e = 0;
            }
            return this.f13428e;
        }
        return invokeV.intValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            SkinManager.setViewTextColor(this.f13426c, R.color.CAM_X0108, 1, i2);
            SkinManager.setViewTextColor(this.f13427d, R.color.CAM_X0108, 1, i2);
            SkinManager.setLottieAnimation(this.f13424a, R.raw.lottie_full_screen_refresh);
            if (isViewAttached()) {
                r();
            }
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.f13431h);
            TbadkCoreApplication.getInst().handler.postDelayed(this.f13431h, 200L);
            this.f13430g = i2;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            s();
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.f13431h);
        }
    }

    public void n(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (view = this.attachedView) == null) {
            return;
        }
        view.setBackgroundColor(i2);
    }

    public void o(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.f13424a == null || (textView = this.f13427d) == null) {
            return;
        }
        if (textView.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams = this.f13424a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = i2;
                this.f13424a.setLayoutParams(marginLayoutParams);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.f13427d.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams2.bottomMargin = i2;
            this.f13427d.setLayoutParams(marginLayoutParams2);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f13430g == -1) {
                this.f13430g = TbadkCoreApplication.getInst().getSkinType();
            }
            if (isViewAttached()) {
                SkinManager.setViewTextColor(this.f13426c, R.color.CAM_X0108, 1, this.f13430g);
                SkinManager.setViewTextColor(this.f13427d, R.color.CAM_X0108, 1, this.f13430g);
                r();
            }
        }
    }

    @Override // c.a.q0.g0.a
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f13430g == -1) {
                this.f13430g = TbadkCoreApplication.getInst().getSkinType();
            }
            SkinManager.setLottieAnimation(this.f13424a, R.raw.lottie_full_screen_refresh);
            r();
            SkinManager.setViewTextColor(this.f13426c, R.color.CAM_X0108, 1, this.f13430g);
            SkinManager.setViewTextColor(this.f13427d, R.color.CAM_X0108, 1, this.f13430g);
            this.f13426c.setText(this.f13425b[0]);
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.f13431h);
            TbadkCoreApplication.getInst().handler.postDelayed(this.f13431h, 200L);
            this.attachedView.setClickable(true);
        }
    }

    @Override // c.a.q0.g0.a
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            m();
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f13430g = i2;
        }
    }

    public void q(int i2) {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (continuousAnimationView = this.f13424a) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = continuousAnimationView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2;
            this.f13424a.setLayoutParams(marginLayoutParams);
        }
    }

    public final void r() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (continuousAnimationView = this.f13424a) == null) {
            return;
        }
        continuousAnimationView.playAnimation();
    }

    public final void s() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (continuousAnimationView = this.f13424a) == null) {
            return;
        }
        continuousAnimationView.pauseAnimation();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, int i2) {
        super(LayoutInflater.from(context).inflate(R.layout.loading_view_layout, (ViewGroup) null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13428e = 0;
        this.f13430g = -1;
        this.f13431h = new a(this);
        this.f13433j = new b(this);
        this.k = new c(this);
        ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.attachedView.findViewById(R.id.common_loading_view);
        this.f13424a = continuousAnimationView;
        if (i2 > 0) {
            ViewGroup.LayoutParams layoutParams = continuousAnimationView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i2;
                this.f13424a.setLayoutParams(marginLayoutParams);
            }
        }
        SkinManager.setLottieAnimation(this.f13424a, R.raw.lottie_full_screen_refresh);
        this.f13424a.setMinAndMaxProgress(0.0f, 1.0f);
        this.f13424a.setRepeatMode(1);
        this.f13424a.addAnimatorUpdateListener(this.f13433j);
        this.f13424a.addAnimatorListener(this.k);
        this.f13424a.setSpeed(1.2f);
        this.f13426c = (TextView) this.attachedView.findViewById(R.id.loading_anim_ellipsis);
        this.f13427d = (TextView) this.attachedView.findViewById(R.id.loading_text);
        String[] stringArray = context.getResources().getStringArray(R.array.loading_anim_text_array);
        this.f13425b = stringArray;
        this.f13429f = stringArray.length;
    }
}
