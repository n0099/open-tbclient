package c.a.r0.d1.v2;

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
import c.a.d.o.e.v;
import c.a.q0.r.r.e2;
import c.a.q0.r.r.l;
import c.a.r0.d1.s2.f;
import c.a.r0.d1.s2.g;
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
import com.baidu.tieba.R;
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
import java.util.List;
import tbclient.SignActivityInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
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
    public FrsFragment f16602b;
    public int b0;

    /* renamed from: c  reason: collision with root package name */
    public Handler f16603c;
    public int c0;

    /* renamed from: d  reason: collision with root package name */
    public View f16604d;
    public int d0;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16605e;
    public int e0;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16606f;
    public boolean f0;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16607g;
    public boolean g0;

    /* renamed from: h  reason: collision with root package name */
    public List<TBSpecificationBtn> f16608h;
    public boolean h0;

    /* renamed from: i  reason: collision with root package name */
    public List<TBSpecificationBtn> f16609i;
    public boolean i0;

    /* renamed from: j  reason: collision with root package name */
    public TextView f16610j;
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
    public c.a.r0.d1.i1.g z;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16611e;

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
            this.f16611e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupWindow popupWindow;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (popupWindow = this.f16611e.H) != null && popupWindow.isShowing()) {
                b bVar = this.f16611e;
                if (bVar.g0) {
                    return;
                }
                c.a.d.f.m.g.d(bVar.H, bVar.a.getPageActivity());
            }
        }
    }

    /* renamed from: c.a.r0.d1.v2.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1059b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f16612e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float f16613f;

        /* renamed from: c.a.r0.d1.v2.b$b$a */
        /* loaded from: classes2.dex */
        public class a implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1059b f16614e;

            public a(C1059b c1059b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1059b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16614e = c1059b;
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
                    C1059b c1059b = this.f16614e;
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c1059b.f16612e, AnimationProperty.SCALE_X, 0.0f, c1059b.f16613f);
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

        public C1059b(b bVar, View view, float f2) {
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
            this.f16612e = view;
            this.f16613f = f2;
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
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f16612e, AnimationProperty.SCALE_X, 1.0f, 0.0f);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1461775893, "Lc/a/r0/d1/v2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1461775893, "Lc/a/r0/d1/v2/b;");
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

    public abstract void A();

    public abstract void B();

    public abstract void C();

    public abstract void D(View.OnClickListener onClickListener);

    public abstract void E(ForumData forumData, FrsViewData frsViewData);

    public void F(TextView textView, TextView textView2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, textView, textView2) == null) {
            textView.setText(String.valueOf(this.c0));
            String string = this.a.getString(R.string.experience_divider);
            String string2 = this.a.getString(R.string.member_count_unit);
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

    public void G(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (i2 == 0) {
                this.f0 = false;
                this.l0 = false;
                this.p.setVisibility(0);
                this.q.setVisibility(8);
            } else {
                this.f0 = true;
                this.p.setVisibility(8);
                this.q.setVisibility(0);
            }
            u(this.f0);
        }
    }

    public void H(int i2, String str, int i3, float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            this.U = str;
            this.Y = i3;
            if (i2 == 0) {
                this.f0 = false;
                this.l0 = false;
                this.p.setVisibility(0);
                this.q.setVisibility(8);
            } else {
                this.f0 = true;
                this.p.setVisibility(8);
                this.q.setVisibility(0);
                if (z && !this.l0) {
                    T();
                    this.l0 = true;
                }
            }
            u(this.f0);
        }
    }

    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            if (i2 == 0) {
                this.h0 = false;
                C();
                return;
            }
            this.h0 = true;
            B();
        }
    }

    public void J(SignData signData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, signData) == null) || signData == null) {
            return;
        }
        I(signData.is_signed);
        if (signData.forum_rank == -2) {
            b(false);
            return;
        }
        b(true);
        I(signData.is_signed);
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    public void L(f fVar) {
        List<TBSpecificationBtn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) || fVar == null || (list = this.f16608h) == null) {
            return;
        }
        this.R = fVar;
        fVar.g(list);
    }

    public void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.e0 = i2;
        }
    }

    public void N(g gVar) {
        List<TBSpecificationBtn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) || gVar == null || (list = this.f16609i) == null) {
            return;
        }
        this.Q = gVar;
        gVar.i(list);
    }

    public void O(v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, vVar) == null) {
        }
    }

    public abstract void P(View view, boolean z);

    public abstract void Q();

    public abstract void R();

    public void S(View view, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            view.setPivotX(0.0f);
            C1059b c1059b = new C1059b(this, view, f3);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.SCALE_X, f2, 1.0f);
            ofFloat.setDuration(400L);
            ofFloat.addListener(c1059b);
            ofFloat.start();
        }
    }

    public abstract void T();

    public void U(View view, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) || f2 == f3) {
            return;
        }
        view.setPivotX(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.SCALE_X, f2, f3);
        ofFloat.setDuration(1000L);
        ofFloat.start();
    }

    public abstract void V();

    public abstract void a();

    public void b(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || (gVar = this.Q) == null) {
            return;
        }
        gVar.j(z);
    }

    public abstract void c();

    public abstract void d(int i2);

    public abstract String e();

    public BarImageView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.N : (BarImageView) invokeV.objValue;
    }

    public TextView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f16607g : (TextView) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.h0 : invokeV.booleanValue;
    }

    public TextView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.n : (TextView) invokeV.objValue;
    }

    public abstract SignActivityInfo k();

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f16604d : (View) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f0 : invokeV.booleanValue;
    }

    public abstract void n();

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
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

    public abstract boolean p();

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.i0 : invokeV.booleanValue;
    }

    public abstract boolean r();

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
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

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.g0 = true;
            o0.clear();
        }
    }

    public abstract void u(boolean z);

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048619, this, z) == null) || z) {
            return;
        }
        o();
        n();
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            o();
            n();
        }
    }

    public void x(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048621, this, f2) == null) {
            y(false, f2);
        }
    }

    public abstract void y(boolean z, float f2);

    public abstract void z();
}
