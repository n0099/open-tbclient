package c.a.t0.p4.e0.p.w;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.p4.f;
import c.a.t0.p4.g;
import c.a.t0.p4.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public final View f21464b;

    /* renamed from: c  reason: collision with root package name */
    public final int f21465c;

    /* renamed from: d  reason: collision with root package name */
    public final int f21466d;

    /* renamed from: e  reason: collision with root package name */
    public final c f21467e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f21468f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f21469g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f21470h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f21471i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f21472j;
    public ImageView k;
    public EMTextView l;
    public EMTextView m;
    public EMTextView n;
    public EMTextView o;
    public EMTextView p;
    public TbCheckBox q;
    public NavigationBar r;
    public ImageView s;
    public ArrayList<d> t;

    /* loaded from: classes8.dex */
    public static final class a implements TbCheckBox.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f21473e;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21473e = true;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public boolean isChecked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21473e : invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public void setChecked(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.f21473e = z;
            }
        }
    }

    public e(TbPageContext<?> mPageContext, View mRootView, int i2, int i3, c mPresenter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mPageContext, mRootView, Integer.valueOf(i2), Integer.valueOf(i3), mPresenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mPageContext, "mPageContext");
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        Intrinsics.checkNotNullParameter(mPresenter, "mPresenter");
        this.a = mPageContext;
        this.f21464b = mRootView;
        this.f21465c = i2;
        this.f21466d = i3;
        this.f21467e = mPresenter;
        this.t = new ArrayList<>();
        n();
    }

    public static final void o(e this$0, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.f21467e.finishPage();
        }
    }

    public static final void p(e this$0, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.f21467e.openUpgrade(this$0.h().isChecked());
            if (this$0.f21465c == 2) {
                TiebaStatic.log(new StatisticItem("c14366"));
            } else {
                TiebaStatic.log(new StatisticItem("c14365"));
            }
        }
    }

    public final void A(EMTextView eMTextView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eMTextView) == null) {
            Intrinsics.checkNotNullParameter(eMTextView, "<set-?>");
            this.m = eMTextView;
        }
    }

    public final void B(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView) == null) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.f21472j = imageView;
        }
    }

    public final void C(EMTextView eMTextView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eMTextView) == null) {
            Intrinsics.checkNotNullParameter(eMTextView, "<set-?>");
            this.n = eMTextView;
        }
    }

    public final void D(EMTextView eMTextView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eMTextView) == null) {
            Intrinsics.checkNotNullParameter(eMTextView, "<set-?>");
            this.l = eMTextView;
        }
    }

    public final void E(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, imageView) == null) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.k = imageView;
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            new BdTopToast(this.a.getPageActivity()).setIcon(false).setContent(str).show(e());
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d().removeAllViews();
            int i2 = f.icon_mask_video_write42;
            String string = this.a.getString(j.guide_upgrde_item_one);
            Intrinsics.checkNotNullExpressionValue(string, "mPageContext.getString(R…ng.guide_upgrde_item_one)");
            b(i2, string);
            int i3 = f.icon_mask_video_legal42;
            String string2 = this.a.getString(j.guide_upgrde_item_two);
            Intrinsics.checkNotNullExpressionValue(string2, "mPageContext.getString(R…ng.guide_upgrde_item_two)");
            b(i3, string2);
            int i4 = f.icon_mask_post_flow42;
            String string3 = this.a.getString(j.guide_upgrde_item_three);
            Intrinsics.checkNotNullExpressionValue(string3, "mPageContext.getString(R….guide_upgrde_item_three)");
            b(i4, string3);
            int i5 = f.icon_mask_post_cash42;
            String string4 = this.a.getString(j.guide_upgrde_item_four);
            Intrinsics.checkNotNullExpressionValue(string4, "mPageContext.getString(R…g.guide_upgrde_item_four)");
            b(i5, string4);
        }
    }

    public final void b(int i2, String title) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, title) == null) {
            Intrinsics.checkNotNullParameter(title, "title");
            d dVar = new d(this.a.getPageActivity());
            dVar.e(title);
            dVar.d(i2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(c.a.t0.p4.e.tbds77);
            d().addView(dVar.b(), layoutParams);
            this.t.add(dVar);
        }
    }

    public final ImageView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ImageView imageView = this.s;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mLineView");
            return null;
        }
        return (ImageView) invokeV.objValue;
    }

    public final LinearLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            LinearLayout linearLayout = this.f21470h;
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mUpgradeItemConten");
            return null;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final RelativeLayout e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            RelativeLayout relativeLayout = this.f21471i;
            if (relativeLayout != null) {
                return relativeLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mUpgradeMain");
            return null;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final LinearLayout f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            LinearLayout linearLayout = this.f21468f;
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mUpgradeTop");
            return null;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final NavigationBar g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            NavigationBar navigationBar = this.r;
            if (navigationBar != null) {
                return navigationBar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public final TbCheckBox h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            TbCheckBox tbCheckBox = this.q;
            if (tbCheckBox != null) {
                return tbCheckBox;
            }
            Intrinsics.throwUninitializedPropertyAccessException("selectOfficeCkb");
            return null;
        }
        return (TbCheckBox) invokeV.objValue;
    }

    public final EMTextView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            EMTextView eMTextView = this.p;
            if (eMTextView != null) {
                return eMTextView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("upgradeBottomTip");
            return null;
        }
        return (EMTextView) invokeV.objValue;
    }

    public final EMTextView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            EMTextView eMTextView = this.m;
            if (eMTextView != null) {
                return eMTextView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("upgradeHasOpen");
            return null;
        }
        return (EMTextView) invokeV.objValue;
    }

    public final ImageView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ImageView imageView = this.f21472j;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("upgradeIcon");
            return null;
        }
        return (ImageView) invokeV.objValue;
    }

    public final EMTextView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            EMTextView eMTextView = this.n;
            if (eMTextView != null) {
                return eMTextView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("upgradeOpenBtn");
            return null;
        }
        return (EMTextView) invokeV.objValue;
    }

    public final EMTextView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            EMTextView eMTextView = this.l;
            if (eMTextView != null) {
                return eMTextView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("upgradeTip");
            return null;
        }
        return (EMTextView) invokeV.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            View findViewById = this.f21464b.findViewById(g.upgrade_main);
            Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.upgrade_main)");
            u((RelativeLayout) findViewById);
            View findViewById2 = this.f21464b.findViewById(g.upgrade_top);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.upgrade_top)");
            v((LinearLayout) findViewById2);
            View findViewById3 = this.f21464b.findViewById(g.upgrade_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.upgrade_icon)");
            B((ImageView) findViewById3);
            View findViewById4 = this.f21464b.findViewById(g.upgrade_icon_title);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.upgrade_icon_title)");
            E((ImageView) findViewById4);
            View findViewById5 = this.f21464b.findViewById(g.upgrade_tip);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.upgrade_tip)");
            D((EMTextView) findViewById5);
            View findViewById6 = this.f21464b.findViewById(g.upgrade_has_open);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R.id.upgrade_has_open)");
            A((EMTextView) findViewById6);
            View findViewById7 = this.f21464b.findViewById(g.select_office_ckb);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "mRootView.findViewById(R.id.select_office_ckb)");
            y((TbCheckBox) findViewById7);
            View findViewById8 = this.f21464b.findViewById(g.select_office_number);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "mRootView.findViewById(R.id.select_office_number)");
            x((EMTextView) findViewById8);
            View findViewById9 = this.f21464b.findViewById(g.upgrade_bottom_tip);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "mRootView.findViewById(R.id.upgrade_bottom_tip)");
            z((EMTextView) findViewById9);
            View findViewById10 = this.f21464b.findViewById(g.btn_upgrade_open);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "mRootView.findViewById(R.id.btn_upgrade_open)");
            C((EMTextView) findViewById10);
            View findViewById11 = this.f21464b.findViewById(g.upgrade_content);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "mRootView.findViewById(R.id.upgrade_content)");
            s((RelativeLayout) findViewById11);
            View findViewById12 = this.f21464b.findViewById(g.upgrade_item);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "mRootView.findViewById(R.id.upgrade_item)");
            t((LinearLayout) findViewById12);
            View findViewById13 = this.f21464b.findViewById(g.line_view);
            Intrinsics.checkNotNullExpressionValue(findViewById13, "mRootView.findViewById(R.id.line_view)");
            r((ImageView) findViewById13);
            View findViewById14 = this.f21464b.findViewById(g.title_bar);
            Intrinsics.checkNotNullExpressionValue(findViewById14, "mRootView.findViewById(R.id.title_bar)");
            w((NavigationBar) findViewById14);
            g().addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: c.a.t0.p4.e0.p.w.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        e.o(e.this, view);
                    }
                }
            });
            g().getBackImageView().setImageDrawable(WebPManager.getPureDrawable(f.icon_pure_topbar_close40, SkinManager.getColor(c.a.t0.p4.d.CAM_X0622), null));
            h().setTagData(new a());
            int i2 = n.i(this.a.getPageActivity());
            if (n.k(this.a.getPageActivity()) == 1080 && i2 == 1920) {
                ViewGroup.LayoutParams layoutParams = f().getLayoutParams();
                if (layoutParams != null) {
                    ((RelativeLayout.LayoutParams) layoutParams).topMargin = UtilHelper.getDimenPixelSize(c.a.t0.p4.e.tbds123);
                    ViewGroup.LayoutParams layoutParams2 = f().getLayoutParams();
                    if (layoutParams2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    }
                    ((RelativeLayout.LayoutParams) layoutParams2).bottomMargin = 0;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                }
            }
            h().setBackgroundDrawableId(f.icon_pure_strok_s, f.icon_pure_strok_n);
            l().setOnClickListener(new View.OnClickListener() { // from class: c.a.t0.p4.e0.p.w.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        e.p(e.this, view);
                    }
                }
            });
            if (this.f21465c != 2) {
                j().setVisibility(8);
            } else {
                l().setText(this.a.getString(j.guide_upgrde_go_on_open));
            }
            if (this.f21466d == c.a.s0.s.m.d.f13428e) {
                i().setVisibility(0);
            } else {
                i().setVisibility(8);
            }
            a();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(m());
            d2.z(c.a.t0.p4.e.T_X08);
            d2.A(j.F_X01);
            d2.w(c.a.t0.p4.e.M_T_X002);
            c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(i());
            d3.z(c.a.t0.p4.e.T_X09);
            d3.w(c.a.t0.p4.e.M_T_X002);
            c.a.s0.s.u.c d4 = c.a.s0.s.u.c.d(l());
            d4.z(c.a.t0.p4.e.T_X05);
            d4.n(j.J_X01);
            d4.g(SkinManager.getColor(0, c.a.t0.p4.d.CAM_X0321));
            h().changeSkinType();
            Iterator<d> it = this.t.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            k().setImageDrawable(WebPManager.getMaskDrawable(f.icon_pic_video_logo, false));
            c().setImageDrawable(WebPManager.getMaskDrawable(f.icon_pic_video_line, false));
            e().setBackgroundResource(f.icon_pic_video_bg);
        }
    }

    public final void r(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, imageView) == null) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.s = imageView;
        }
    }

    public final void s(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, relativeLayout) == null) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.f21469g = relativeLayout;
        }
    }

    public final void t(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, linearLayout) == null) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.f21470h = linearLayout;
        }
    }

    public final void u(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, relativeLayout) == null) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.f21471i = relativeLayout;
        }
    }

    public final void v(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, linearLayout) == null) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.f21468f = linearLayout;
        }
    }

    public final void w(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, navigationBar) == null) {
            Intrinsics.checkNotNullParameter(navigationBar, "<set-?>");
            this.r = navigationBar;
        }
    }

    public final void x(EMTextView eMTextView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, eMTextView) == null) {
            Intrinsics.checkNotNullParameter(eMTextView, "<set-?>");
            this.o = eMTextView;
        }
    }

    public final void y(TbCheckBox tbCheckBox) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, tbCheckBox) == null) {
            Intrinsics.checkNotNullParameter(tbCheckBox, "<set-?>");
            this.q = tbCheckBox;
        }
    }

    public final void z(EMTextView eMTextView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, eMTextView) == null) {
            Intrinsics.checkNotNullParameter(eMTextView, "<set-?>");
            this.p = eMTextView;
        }
    }
}
