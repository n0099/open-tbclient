package b.a.r0.d4.u.p.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import b.a.e.e.p.l;
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
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f16202a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f16203b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f16204c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f16205d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f16206e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f16207f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f16208g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f16209h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f16210i;
    public EMTextView j;
    public EMTextView k;
    public TbCheckBox l;
    public NavigationBar m;
    public ImageView n;
    public ArrayList<b.a.r0.d4.u.p.b.b> o;
    public final TbPageContext<?> p;
    public final View q;
    public final int r;
    public final int s;
    public final b.a.r0.d4.u.p.b.a t;

    /* loaded from: classes4.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f16211e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16211e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16211e.t.finishPage();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements TbCheckBox.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f16212e;

        public b() {
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
            this.f16212e = true;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public boolean isChecked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16212e : invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public void setChecked(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.f16212e = z;
            }
        }
    }

    /* renamed from: b.a.r0.d4.u.p.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class View$OnClickListenerC0825c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f16213e;

        public View$OnClickListenerC0825c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16213e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16213e.t.openUpgrade(this.f16213e.e().isChecked());
                if (this.f16213e.r == 2) {
                    TiebaStatic.log(new StatisticItem("c14366"));
                } else {
                    TiebaStatic.log(new StatisticItem("c14365"));
                }
            }
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, int i2, int i3, b.a.r0.d4.u.p.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, Integer.valueOf(i2), Integer.valueOf(i3), aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = tbPageContext;
        this.q = view;
        this.r = i2;
        this.s = i3;
        this.t = aVar;
        this.o = new ArrayList<>();
        f();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout linearLayout = this.f16204c;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUpgradeItemConten");
            }
            linearLayout.removeAllViews();
            int i2 = R.drawable.icon_mask_video_write42;
            String string = this.p.getString(R.string.guide_upgrde_item_one);
            Intrinsics.checkExpressionValueIsNotNull(string, "mPageContext.getString(R…ng.guide_upgrde_item_one)");
            d(i2, string);
            int i3 = R.drawable.icon_mask_video_legal42;
            String string2 = this.p.getString(R.string.guide_upgrde_item_two);
            Intrinsics.checkExpressionValueIsNotNull(string2, "mPageContext.getString(R…ng.guide_upgrde_item_two)");
            d(i3, string2);
            int i4 = R.drawable.icon_mask_post_flow42;
            String string3 = this.p.getString(R.string.guide_upgrde_item_three);
            Intrinsics.checkExpressionValueIsNotNull(string3, "mPageContext.getString(R….guide_upgrde_item_three)");
            d(i4, string3);
            int i5 = R.drawable.icon_mask_post_cash42;
            String string4 = this.p.getString(R.string.guide_upgrde_item_four);
            Intrinsics.checkExpressionValueIsNotNull(string4, "mPageContext.getString(R…g.guide_upgrde_item_four)");
            d(i5, string4);
        }
    }

    public final void d(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            b.a.r0.d4.u.p.b.b bVar = new b.a.r0.d4.u.p.b.b(this.p.getPageActivity());
            bVar.e(str);
            bVar.d(i2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds77);
            LinearLayout linearLayout = this.f16204c;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUpgradeItemConten");
            }
            linearLayout.addView(bVar.b(), layoutParams);
            this.o.add(bVar);
        }
    }

    public final TbCheckBox e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TbCheckBox tbCheckBox = this.l;
            if (tbCheckBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectOfficeCkb");
            }
            return tbCheckBox;
        }
        return (TbCheckBox) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View findViewById = this.q.findViewById(R.id.upgrade_main);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "mRootView.findViewById(R.id.upgrade_main)");
            this.f16205d = (RelativeLayout) findViewById;
            View findViewById2 = this.q.findViewById(R.id.upgrade_top);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "mRootView.findViewById(R.id.upgrade_top)");
            this.f16202a = (LinearLayout) findViewById2;
            View findViewById3 = this.q.findViewById(R.id.upgrade_icon);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "mRootView.findViewById(R.id.upgrade_icon)");
            this.f16206e = (ImageView) findViewById3;
            View findViewById4 = this.q.findViewById(R.id.upgrade_icon_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "mRootView.findViewById(R.id.upgrade_icon_title)");
            this.f16207f = (ImageView) findViewById4;
            View findViewById5 = this.q.findViewById(R.id.upgrade_tip);
            Intrinsics.checkExpressionValueIsNotNull(findViewById5, "mRootView.findViewById(R.id.upgrade_tip)");
            this.f16208g = (EMTextView) findViewById5;
            View findViewById6 = this.q.findViewById(R.id.upgrade_has_open);
            Intrinsics.checkExpressionValueIsNotNull(findViewById6, "mRootView.findViewById(R.id.upgrade_has_open)");
            this.f16209h = (EMTextView) findViewById6;
            View findViewById7 = this.q.findViewById(R.id.select_office_ckb);
            Intrinsics.checkExpressionValueIsNotNull(findViewById7, "mRootView.findViewById(R.id.select_office_ckb)");
            this.l = (TbCheckBox) findViewById7;
            View findViewById8 = this.q.findViewById(R.id.select_office_number);
            Intrinsics.checkExpressionValueIsNotNull(findViewById8, "mRootView.findViewById(R.id.select_office_number)");
            this.j = (EMTextView) findViewById8;
            View findViewById9 = this.q.findViewById(R.id.upgrade_bottom_tip);
            Intrinsics.checkExpressionValueIsNotNull(findViewById9, "mRootView.findViewById(R.id.upgrade_bottom_tip)");
            this.k = (EMTextView) findViewById9;
            View findViewById10 = this.q.findViewById(R.id.btn_upgrade_open);
            Intrinsics.checkExpressionValueIsNotNull(findViewById10, "mRootView.findViewById(R.id.btn_upgrade_open)");
            this.f16210i = (EMTextView) findViewById10;
            View findViewById11 = this.q.findViewById(R.id.upgrade_content);
            Intrinsics.checkExpressionValueIsNotNull(findViewById11, "mRootView.findViewById(R.id.upgrade_content)");
            this.f16203b = (RelativeLayout) findViewById11;
            View findViewById12 = this.q.findViewById(R.id.upgrade_item);
            Intrinsics.checkExpressionValueIsNotNull(findViewById12, "mRootView.findViewById(R.id.upgrade_item)");
            this.f16204c = (LinearLayout) findViewById12;
            View findViewById13 = this.q.findViewById(R.id.line_view);
            Intrinsics.checkExpressionValueIsNotNull(findViewById13, "mRootView.findViewById(R.id.line_view)");
            this.n = (ImageView) findViewById13;
            View findViewById14 = this.q.findViewById(R.id.title_bar);
            Intrinsics.checkExpressionValueIsNotNull(findViewById14, "mRootView.findViewById(R.id.title_bar)");
            NavigationBar navigationBar = (NavigationBar) findViewById14;
            this.m = navigationBar;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
            }
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            NavigationBar navigationBar2 = this.m;
            if (navigationBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
            }
            navigationBar2.getBackImageView().setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_close40, SkinManager.getColor(R.color.CAM_X0622), null));
            TbCheckBox tbCheckBox = this.l;
            if (tbCheckBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectOfficeCkb");
            }
            tbCheckBox.setTagData(new b());
            int i2 = l.i(this.p.getPageActivity());
            if (l.k(this.p.getPageActivity()) == 1080 && i2 == 1920) {
                LinearLayout linearLayout = this.f16202a;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUpgradeTop");
                }
                ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                if (layoutParams != null) {
                    ((RelativeLayout.LayoutParams) layoutParams).topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds123);
                    LinearLayout linearLayout2 = this.f16202a;
                    if (linearLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mUpgradeTop");
                    }
                    ViewGroup.LayoutParams layoutParams2 = linearLayout2.getLayoutParams();
                    if (layoutParams2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    }
                    ((RelativeLayout.LayoutParams) layoutParams2).bottomMargin = 0;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                }
            }
            TbCheckBox tbCheckBox2 = this.l;
            if (tbCheckBox2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectOfficeCkb");
            }
            tbCheckBox2.setBackgroundDrawableId(R.drawable.icon_pure_strok_s, R.drawable.icon_pure_strok_n);
            EMTextView eMTextView = this.f16210i;
            if (eMTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("upgradeOpenBtn");
            }
            eMTextView.setOnClickListener(new View$OnClickListenerC0825c(this));
            if (this.r != 2) {
                EMTextView eMTextView2 = this.f16209h;
                if (eMTextView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("upgradeHasOpen");
                }
                eMTextView2.setVisibility(8);
            } else {
                EMTextView eMTextView3 = this.f16210i;
                if (eMTextView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("upgradeOpenBtn");
                }
                eMTextView3.setText(this.p.getString(R.string.guide_upgrde_go_on_open));
            }
            if (this.s == b.a.q0.s.m.c.f13158d) {
                EMTextView eMTextView4 = this.k;
                if (eMTextView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("upgradeBottomTip");
                }
                eMTextView4.setVisibility(0);
            } else {
                EMTextView eMTextView5 = this.k;
                if (eMTextView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("upgradeBottomTip");
                }
                eMTextView5.setVisibility(8);
            }
            c();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            EMTextView eMTextView = this.f16208g;
            if (eMTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("upgradeTip");
            }
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(eMTextView);
            d2.z(R.dimen.T_X08);
            d2.A(R.string.F_X01);
            d2.w(R.dimen.M_T_X002);
            EMTextView eMTextView2 = this.k;
            if (eMTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("upgradeBottomTip");
            }
            b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(eMTextView2);
            d3.z(R.dimen.T_X09);
            d3.w(R.dimen.M_T_X002);
            EMTextView eMTextView3 = this.f16210i;
            if (eMTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("upgradeOpenBtn");
            }
            b.a.q0.s.u.c d4 = b.a.q0.s.u.c.d(eMTextView3);
            d4.z(R.dimen.T_X05);
            d4.n(R.string.J_X01);
            d4.g(SkinManager.getColor(0, R.color.CAM_X0321));
            TbCheckBox tbCheckBox = this.l;
            if (tbCheckBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectOfficeCkb");
            }
            tbCheckBox.changeSkinType();
            Iterator<b.a.r0.d4.u.p.b.b> it = this.o.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            ImageView imageView = this.f16206e;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("upgradeIcon");
            }
            imageView.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_pic_video_logo, false));
            ImageView imageView2 = this.n;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLineView");
            }
            imageView2.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_pic_video_line, false));
            RelativeLayout relativeLayout = this.f16205d;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUpgradeMain");
            }
            relativeLayout.setBackgroundResource(R.drawable.icon_pic_video_bg);
        }
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            BdTopToast content = new BdTopToast(this.p.getPageActivity()).setIcon(false).setContent(str);
            RelativeLayout relativeLayout = this.f16205d;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUpgradeMain");
            }
            content.show(relativeLayout);
        }
    }
}
