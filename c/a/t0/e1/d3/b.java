package c.a.t0.e1.d3;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.v;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.l;
import c.a.t0.e1.a3.f;
import c.a.t0.e1.a3.g;
import c.a.t0.e1.i1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.servicearea.ServiceAreaView;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.frs.voiceroom.view.FrsVoiceRoomListLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import tbclient.SignActivityInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<Integer, String> n0;
    public static HashSet<Integer> o0;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsTopView A;
    public View B;
    public View C;
    public FrsVoiceRoomListLayout D;
    public EMTextView E;
    public boolean F;
    public SignActivityInfo G;
    public PopupWindow H;
    public View I;
    public TextView J;
    public TextView K;
    public ImageView L;
    public PopupWindow M;
    public BarImageView N;
    public UserIconBox O;
    public ArrayList<l> P;
    public g Q;
    public f R;
    public String S;
    public String T;
    public String U;
    public String V;
    public FrsViewData W;
    public e2 X;
    public int Y;
    public int Z;
    public TbPageContext a;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public FrsFragment f16313b;
    public int b0;

    /* renamed from: c  reason: collision with root package name */
    public Handler f16314c;
    public int c0;

    /* renamed from: d  reason: collision with root package name */
    public View f16315d;
    public int d0;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16316e;
    public int e0;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16317f;
    public boolean f0;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16318g;
    public boolean g0;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f16319h;
    public boolean h0;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f16320i;
    public boolean i0;

    /* renamed from: j  reason: collision with root package name */
    public TextView f16321j;
    public boolean j0;
    public ImageView k;
    public float k0;
    public ImageView l;
    public boolean l0;
    public View m;
    public final Runnable m0;
    public TextView n;
    public TextView o;
    public RelativeLayout p;
    public RelativeLayout q;
    public View r;
    public TextView s;
    public RelativeLayout t;
    public RelativeLayout u;
    public LinearGradientView v;
    public TbImageView w;
    public ServiceAreaView x;
    public FrameLayout y;
    public c.a.t0.e1.s1.g z;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16322e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16322e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupWindow popupWindow;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (popupWindow = this.f16322e.H) != null && popupWindow.isShowing()) {
                b bVar = this.f16322e;
                if (bVar.g0) {
                    return;
                }
                c.a.d.f.m.g.d(bVar.H, bVar.a.getPageActivity());
            }
        }
    }

    /* renamed from: c.a.t0.e1.d3.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1041b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f16323e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float f16324f;

        /* renamed from: c.a.t0.e1.d3.b$b$a */
        /* loaded from: classes7.dex */
        public class a implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1041b f16325e;

            public a(C1041b c1041b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1041b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16325e = c1041b;
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
                    C1041b c1041b = this.f16325e;
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c1041b.f16323e, AnimationProperty.SCALE_X, 0.0f, c1041b.f16324f);
                    ofFloat.setDuration(300L);
                    ofFloat.start();
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
                }
            }
        }

        public C1041b(b bVar, View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, view, Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16323e = view;
            this.f16324f = f2;
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
                a aVar = new a(this);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f16323e, AnimationProperty.SCALE_X, 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ofFloat.addListener(aVar);
                ofFloat.start();
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
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-405910077, "Lc/a/t0/e1/d3/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-405910077, "Lc/a/t0/e1/d3/b;");
                return;
            }
        }
        n0 = new HashMap<>();
        o0 = new HashSet<>();
        n0.put(1, "c0117");
        n0.put(2, "c0124");
        n0.put(3, "c0125");
        n0.put(4, "c0126");
        n0.put(5, "c0127");
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l0 = false;
        this.m0 = new a(this);
    }

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void B(ForumData forumData, FrsViewData frsViewData);

    public void C(TextView textView, TextView textView2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, textView, textView2) == null) {
            textView.setText(String.valueOf(this.c0));
            String string = this.a.getString(i1.experience_divider);
            String string2 = this.a.getString(i1.member_count_unit);
            int i2 = this.d0;
            if (i2 >= 10000) {
                if (i2 % 10000 == 0) {
                    textView2.setText(string + String.valueOf(this.d0 / 10000) + string2);
                    return;
                }
                textView2.setText(string + String.valueOf(i2 / 10000.0f) + string2);
                return;
            }
            textView2.setText(string + String.valueOf(this.d0));
        }
    }

    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (i2 == 0) {
                this.f0 = false;
                this.l0 = false;
                this.p.setVisibility(0);
                this.q.setVisibility(8);
                this.f16319h.setVisibility(0);
                this.f16320i.setVisibility(8);
                return;
            }
            this.f0 = true;
            this.p.setVisibility(8);
            this.q.setVisibility(0);
            this.f16319h.setVisibility(8);
            this.f16320i.setVisibility(0);
        }
    }

    public void E(int i2, String str, int i3, float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            this.U = str;
            this.Y = i3;
            if (i2 == 0) {
                this.f0 = false;
                this.l0 = false;
                this.p.setVisibility(0);
                this.q.setVisibility(8);
                this.f16319h.setVisibility(0);
                this.f16320i.setVisibility(8);
                return;
            }
            this.f0 = true;
            this.p.setVisibility(8);
            this.q.setVisibility(0);
            this.f16319h.setVisibility(8);
            this.f16320i.setVisibility(0);
            if (!z || this.l0) {
                return;
            }
            Q();
            this.l0 = true;
        }
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (i2 == 0) {
                this.h0 = false;
                this.f16320i.setText(this.a.getString(i1.sign));
                z();
                return;
            }
            this.h0 = true;
            this.f16320i.setText(this.a.getString(i1.signed));
            y();
        }
    }

    public void G(SignData signData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, signData) == null) || signData == null) {
            return;
        }
        F(signData.is_signed);
        if (signData.forum_rank == -2) {
            a(false);
            return;
        }
        a(true);
        F(signData.is_signed);
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    public void I(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) || fVar == null) {
            return;
        }
        this.R = fVar;
        fVar.g(this.f16319h);
    }

    public void J(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.e0 = i2;
        }
    }

    public void K(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) || gVar == null) {
            return;
        }
        this.Q = gVar;
        gVar.i(this.f16320i);
    }

    public void L(v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, vVar) == null) {
        }
    }

    public abstract void M(View view, boolean z);

    public abstract void N();

    public abstract void O();

    public void P(View view, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            view.setPivotX(0.0f);
            C1041b c1041b = new C1041b(this, view, f3);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.SCALE_X, f2, 1.0f);
            ofFloat.setDuration(400L);
            ofFloat.addListener(c1041b);
            ofFloat.start();
        }
    }

    public abstract void Q();

    public void R(View view, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) || f2 == f3) {
            return;
        }
        view.setPivotX(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.SCALE_X, f2, f3);
        ofFloat.setDuration(1000L);
        ofFloat.start();
    }

    public abstract void S();

    public void a(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || (gVar = this.Q) == null) {
            return;
        }
        gVar.j(z);
    }

    public abstract void b();

    public abstract void c(int i2);

    public abstract String d();

    public BarImageView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.N : (BarImageView) invokeV.objValue;
    }

    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f16318g : (TextView) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.h0 : invokeV.booleanValue;
    }

    public TextView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.n : (TextView) invokeV.objValue;
    }

    public abstract SignActivityInfo j();

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f16315d : (View) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f0 : invokeV.booleanValue;
    }

    public abstract void m();

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            PopupWindow popupWindow = this.M;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.M.dismiss();
            }
            PopupWindow popupWindow2 = this.H;
            if (popupWindow2 == null || !popupWindow2.isShowing()) {
                return;
            }
            this.H.dismiss();
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.i0 : invokeV.booleanValue;
    }

    public abstract boolean p();

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            int[] iArr = new int[2];
            try {
                this.L.getLocationOnScreen(iArr);
                return iArr[0] >= 160 && iArr[1] >= 105;
            } catch (NullPointerException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.g0 = true;
            o0.clear();
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048613, this, z) == null) || z) {
            return;
        }
        n();
        m();
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            n();
            m();
        }
    }

    public void u(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048615, this, f2) == null) {
            v(false, f2);
        }
    }

    public abstract void v(boolean z, float f2);

    public abstract void w();

    public abstract void x();

    public abstract void y();

    public abstract void z();
}
