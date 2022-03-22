package c.a.p0.f1.v2;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.o.e.w;
import c.a.o0.r.r.l;
import c.a.p0.a4.m;
import c.a.p0.f1.j2.h;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.recommend.FrsLikeRecommendLayout;
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
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public abstract class d {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<Integer, String> o0;
    public static HashSet<Integer> p0;
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
    public c.a.p0.f1.s2.g Q;
    public c.a.p0.f1.s2.f R;
    public FrsLikeRecommendLayout S;
    public String T;
    public String U;
    public String V;
    public String W;
    public FrsViewData X;
    public ThreadData Y;
    public int Z;
    public TbPageContext a;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public FrsFragment f14769b;
    public int b0;

    /* renamed from: c  reason: collision with root package name */
    public Handler f14770c;
    public int c0;

    /* renamed from: d  reason: collision with root package name */
    public View f14771d;
    public int d0;

    /* renamed from: e  reason: collision with root package name */
    public TextView f14772e;
    public int e0;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14773f;
    public int f0;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14774g;
    public boolean g0;

    /* renamed from: h  reason: collision with root package name */
    public List<TBSpecificationBtn> f14775h;
    public boolean h0;
    public List<TBSpecificationBtn> i;
    public boolean i0;
    public TextView j;
    public boolean j0;
    public ImageView k;
    public boolean k0;
    public ImageView l;
    public float l0;
    public View m;
    public boolean m0;
    public TextView n;
    public final Runnable n0;
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
    public c.a.p0.f1.i1.g z;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupWindow popupWindow;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (popupWindow = this.a.H) != null && popupWindow.isShowing()) {
                d dVar = this.a;
                if (dVar.h0) {
                    return;
                }
                c.a.d.f.m.g.d(dVar.H, dVar.a.getPageActivity());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ float f14776b;

        /* loaded from: classes2.dex */
        public class a implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
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
                    b bVar = this.a;
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.a, AnimationProperty.SCALE_X, 0.0f, bVar.f14776b);
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

        public b(d dVar, View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, view, Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view;
            this.f14776b = f2;
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
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, AnimationProperty.SCALE_X, 1.0f, 0.0f);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-48635249, "Lc/a/p0/f1/v2/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-48635249, "Lc/a/p0/f1/v2/d;");
                return;
            }
        }
        o0 = new HashMap<>();
        p0 = new HashSet<>();
        o0.put(1, "c0117");
        o0.put(2, "c0124");
        o0.put(3, "c0125");
        o0.put(4, "c0126");
        o0.put(5, "c0127");
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m0 = false;
        this.n0 = new a(this);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            p();
            o();
        }
    }

    public void B(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            C(false, f2);
        }
    }

    public abstract void C(boolean z, float f2);

    public abstract void D();

    public abstract void E();

    public abstract void F();

    public abstract void G();

    public abstract void H(View.OnClickListener onClickListener);

    public abstract void I(ForumData forumData, FrsViewData frsViewData);

    public void J(TextView textView, TextView textView2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, textView, textView2) == null) {
            textView.setText(String.valueOf(this.d0));
            String string = this.a.getString(R.string.obfuscated_res_0x7f0f05bf);
            String string2 = this.a.getString(R.string.obfuscated_res_0x7f0f0aa2);
            int i = this.e0;
            if (i >= 10000) {
                if (i % 10000 == 0) {
                    textView2.setText(string + String.valueOf(this.e0 / 10000) + string2);
                    return;
                }
                textView2.setText(string + String.valueOf(i / 10000.0f) + string2);
                return;
            }
            textView2.setText(string + String.valueOf(this.e0));
        }
    }

    public void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            if (i == 0) {
                this.g0 = false;
                this.m0 = false;
                this.p.setVisibility(0);
                this.q.setVisibility(8);
            } else {
                this.g0 = true;
                this.p.setVisibility(8);
                this.q.setVisibility(0);
            }
            y(this.g0);
        }
    }

    public void L(int i, String str, int i2, float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            this.V = str;
            this.Z = i2;
            if (i == 0) {
                this.g0 = false;
                this.m0 = false;
                this.p.setVisibility(0);
                this.q.setVisibility(8);
            } else {
                this.g0 = true;
                this.p.setVisibility(8);
                this.q.setVisibility(0);
                if (z && !this.m0) {
                    Y();
                    this.m0 = true;
                }
            }
            y(this.g0);
        }
    }

    public void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            if (i == 0) {
                this.i0 = false;
                G();
                return;
            }
            this.i0 = true;
            F();
        }
    }

    public void N(SignData signData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, signData) == null) || signData == null) {
            return;
        }
        M(signData.is_signed);
        if (signData.forum_rank == -2) {
            b(false);
            return;
        }
        b(true);
        M(signData.is_signed);
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
        }
    }

    public void P(c.a.p0.f1.s2.f fVar) {
        List<TBSpecificationBtn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, fVar) == null) || fVar == null || (list = this.f14775h) == null) {
            return;
        }
        this.R = fVar;
        fVar.g(list);
    }

    public void Q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.f0 = i;
        }
    }

    public void R(c.a.p0.f1.s2.g gVar) {
        List<TBSpecificationBtn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, gVar) == null) || gVar == null || (list = this.i) == null) {
            return;
        }
        this.Q = gVar;
        gVar.i(list);
    }

    public void S(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, wVar) == null) {
        }
    }

    public abstract void T(View view, boolean z);

    public abstract void U();

    public void V(List<m> list) {
        ForumData forum;
        FrsLikeRecommendLayout frsLikeRecommendLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, list) == null) || this.a == null || TextUtils.isEmpty(this.U) || ListUtils.isEmpty(list) || (forum = this.X.getForum()) == null || forum.getThemeColorInfo() == null) {
            return;
        }
        ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
        if (e(themeColorInfo) && UbsABTestHelper.isFrsModifyABTestA() && (frsLikeRecommendLayout = this.S) != null) {
            frsLikeRecommendLayout.setHeightChangeListener(new h() { // from class: c.a.p0.f1.v2.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // c.a.p0.f1.j2.h
                public final void a(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        d.this.v(i);
                    }
                }
            });
            this.S.setThemeColor(themeColorInfo);
            this.S.i(this.a, this.U, list);
            this.S.setCloseListener(new View.OnClickListener() { // from class: c.a.p0.f1.v2.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        d.this.w(view);
                    }
                }
            });
        }
    }

    public abstract void W();

    public void X(View view, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            view.setPivotX(0.0f);
            b bVar = new b(this, view, f3);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.SCALE_X, f2, 1.0f);
            ofFloat.setDuration(400L);
            ofFloat.addListener(bVar);
            ofFloat.start();
        }
    }

    public abstract void Y();

    public void Z(View view, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) || f2 == f3) {
            return;
        }
        view.setPivotX(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.SCALE_X, f2, f3);
        ofFloat.setDuration(1000L);
        ofFloat.start();
    }

    public abstract void a();

    public abstract void a0();

    public void b(boolean z) {
        c.a.p0.f1.s2.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || (gVar = this.Q) == null) {
            return;
        }
        gVar.j(z);
    }

    public abstract void c();

    public abstract void d(int i);

    public final boolean e(ThemeColorInfo themeColorInfo) {
        InterceptResult invokeL;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, themeColorInfo)) == null) ? (themeColorInfo == null || (themeElement = themeColorInfo.day) == null || themeColorInfo.dark == null || themeColorInfo.night == null || StringUtils.isNull(themeElement.font_color) || StringUtils.isNull(themeColorInfo.dark.font_color) || StringUtils.isNull(themeColorInfo.night.font_color)) ? false : true : invokeL.booleanValue;
    }

    public abstract String f();

    public BarImageView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.N : (BarImageView) invokeV.objValue;
    }

    public TextView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f14774g : (TextView) invokeV.objValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.i0 : invokeV.booleanValue;
    }

    public TextView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.n : (TextView) invokeV.objValue;
    }

    public abstract SignActivityInfo l();

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f14771d : (View) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.g0 : invokeV.booleanValue;
    }

    public abstract void o();

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
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

    public void q() {
        FrsLikeRecommendLayout frsLikeRecommendLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && (frsLikeRecommendLayout = this.S) != null && frsLikeRecommendLayout.getVisibility() == 0) {
            this.S.j();
        }
    }

    public abstract boolean r();

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.j0 : invokeV.booleanValue;
    }

    public abstract boolean t();

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
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

    public /* synthetic */ void v(int i) {
        a();
    }

    public /* synthetic */ void w(View view) {
        this.S.j();
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.h0 = true;
            p0.clear();
        }
    }

    public abstract void y(boolean z);

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048628, this, z) == null) || z) {
            return;
        }
        p();
        o();
    }
}
