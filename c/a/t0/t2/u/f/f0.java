package c.a.t0.t2.u.f;

import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.pb.view.TextSizeSeekBar;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class f0 extends c.a.d.a.d {
    public static /* synthetic */ Interceptable $ic;
    public static final int x;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;

    /* renamed from: b  reason: collision with root package name */
    public View f23090b;

    /* renamed from: c  reason: collision with root package name */
    public FlowLayout f23091c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f23092d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f23093e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f23094f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f23095g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f23096h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f23097i;

    /* renamed from: j  reason: collision with root package name */
    public EMTextView f23098j;
    public EMTextView k;
    public EMTextView l;
    public EMTextView m;
    public EMTextView n;
    public EMTextView o;
    public EMTextView p;
    public EMTextView q;
    public LinearLayout r;
    public TextSizeSeekBar s;
    public EMTextView t;
    public View u;
    public View.OnClickListener v;
    public boolean w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1855255830, "Lc/a/t0/t2/u/f/f0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1855255830, "Lc/a/t0/t2/u/f/f0;");
                return;
            }
        }
        x = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.t2.g.tbds78);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = null;
        this.v = null;
        this.a = baseFragment;
        this.v = onClickListener;
        initUI();
    }

    public void A(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.o.setVisibility(z ? 0 : 8);
            if (z2) {
                this.o.setText(c.a.t0.t2.l.group_info_intro_more);
                K(this.o, c.a.t0.t2.h.icon_pure_pb_recommend_all30);
                return;
            }
            this.o.setText(c.a.t0.t2.l.view_host);
            K(this.o, c.a.t0.t2.h.icon_pure_pb_recommend_host30);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.o.getLayoutParams().width = 201;
            this.k.getLayoutParams().width = 201;
            this.f23092d.getLayoutParams().width = 201;
            this.l.getLayoutParams().width = 201;
            this.f23093e.getLayoutParams().width = 201;
            this.f23094f.getLayoutParams().width = 201;
            this.n.getLayoutParams().width = 201;
            this.f23095g.getLayoutParams().width = 201;
            this.f23096h.getLayoutParams().width = 201;
            this.f23097i.getLayoutParams().width = 201;
            this.f23098j.getLayoutParams().width = 201;
            this.m.getLayoutParams().width = 201;
            this.p.getLayoutParams().width = 201;
            this.q.getLayoutParams().width = 201;
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f23093e.setVisibility(z ? 0 : 8);
        }
    }

    public void D(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.m.setVisibility(z ? 0 : 8);
            if (z2) {
                this.m.setText(c.a.t0.t2.l.pb_cancel_good);
                K(this.m, c.a.t0.t2.h.icon_pure_pb_recommend_bested30);
                return;
            }
            this.m.setText(c.a.t0.t2.l.commit_good);
            K(this.m, c.a.t0.t2.h.icon_pure_pb_recommend_best30);
        }
    }

    public void E(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f23098j.setVisibility(z ? 0 : 8);
            if (z2) {
                this.f23098j.setText(c.a.t0.t2.l.pb_cancel_top);
                K(this.f23098j, c.a.t0.t2.h.icon_pure_pb_recommend_toped30);
                return;
            }
            this.f23098j.setText(c.a.t0.t2.l.top);
            K(this.f23098j, c.a.t0.t2.h.icon_pure_pb_recommend_top30);
        }
    }

    public void F(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001281, String.class);
            if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                this.l.setVisibility(z ? 0 : 8);
                if (z2) {
                    this.l.setText(c.a.t0.t2.l.normal_mode);
                    K(this.l, c.a.t0.t2.h.icon_pure_pb_recommend_daytime30);
                    return;
                }
                this.l.setText(c.a.t0.t2.l.eyeshield_mode);
                K(this.l, c.a.t0.t2.h.icon_pure_pb_recommend_night30);
                return;
            }
            this.l.setVisibility(8);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.p.setVisibility(z ? 0 : 8);
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.n.setVisibility(z ? 0 : 8);
        }
    }

    public void I(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.k.setVisibility(z ? 0 : 8);
            if (z2) {
                this.k.setText(c.a.t0.t2.l.view_reverse);
            } else {
                this.k.setText(c.a.t0.t2.l.default_sort);
            }
            this.k.setText(c.a.t0.t2.l.sort_selector);
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f23092d.setVisibility(z ? 0 : 8);
        }
    }

    public final void K(TextView textView, int i2) {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048586, this, textView, i2) == null) || textView == null || (pureDrawable = WebPManager.getPureDrawable(i2, SkinManager.getColor(c.a.t0.t2.f.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i3 = x;
        pureDrawable.setBounds(0, 0, i3, i3);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.s.setVisibility(z ? 0 : 8);
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            MaskView.maskTextView(this.m, z);
            MaskView.maskTextView(this.f23098j, z);
            MaskView.maskTextView(this.f23094f, z);
        }
    }

    public TextView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f23095g : (TextView) invokeV.objValue;
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f23094f : (TextView) invokeV.objValue;
    }

    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.t : (TextView) invokeV.objValue;
    }

    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f23096h : (TextView) invokeV.objValue;
    }

    public TextView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f23097i : (TextView) invokeV.objValue;
    }

    public TextView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.q : (TextView) invokeV.objValue;
    }

    public TextView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.o : (TextView) invokeV.objValue;
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(c.a.t0.t2.j.pb_more_pop_view, (ViewGroup) null);
            this.f23090b = inflate;
            this.f23091c = (FlowLayout) inflate.findViewById(c.a.t0.t2.i.pb_more_flowlayout);
            EMTextView eMTextView = (EMTextView) this.f23090b.findViewById(c.a.t0.t2.i.pb_more_view_item_host_only);
            this.o = eMTextView;
            eMTextView.setOnClickListener(this.v);
            EMTextView eMTextView2 = (EMTextView) this.f23090b.findViewById(c.a.t0.t2.i.pb_more_view_item_reversed);
            this.k = eMTextView2;
            eMTextView2.setOnClickListener(this.v);
            EMTextView eMTextView3 = (EMTextView) this.f23090b.findViewById(c.a.t0.t2.i.pb_more_view_item_jump);
            this.f23092d = eMTextView3;
            eMTextView3.setOnClickListener(this.v);
            EMTextView eMTextView4 = (EMTextView) this.f23090b.findViewById(c.a.t0.t2.i.pb_more_view_item_night_style);
            this.l = eMTextView4;
            eMTextView4.setOnClickListener(this.v);
            EMTextView eMTextView5 = (EMTextView) this.f23090b.findViewById(c.a.t0.t2.i.pb_more_view_item_jump_top);
            this.f23093e = eMTextView5;
            eMTextView5.setOnClickListener(this.v);
            EMTextView eMTextView6 = (EMTextView) this.f23090b.findViewById(c.a.t0.t2.i.pb_more_view_item_call_fans);
            this.f23094f = eMTextView6;
            eMTextView6.setOnClickListener(this.v);
            EMTextView eMTextView7 = (EMTextView) this.f23090b.findViewById(c.a.t0.t2.i.pb_more_view_item_report);
            this.n = eMTextView7;
            eMTextView7.setOnClickListener(this.v);
            EMTextView eMTextView8 = (EMTextView) this.f23090b.findViewById(c.a.t0.t2.i.pb_more_view_item_block);
            this.f23095g = eMTextView8;
            eMTextView8.setOnClickListener(this.v);
            EMTextView eMTextView9 = (EMTextView) this.f23090b.findViewById(c.a.t0.t2.i.pb_more_view_item_delete);
            this.f23096h = eMTextView9;
            eMTextView9.setOnClickListener(this.v);
            EMTextView eMTextView10 = (EMTextView) this.f23090b.findViewById(c.a.t0.t2.i.pb_more_view_item_forbidden);
            this.f23097i = eMTextView10;
            eMTextView10.setOnClickListener(this.v);
            EMTextView eMTextView11 = (EMTextView) this.f23090b.findViewById(c.a.t0.t2.i.pb_more_view_item_make_top);
            this.f23098j = eMTextView11;
            eMTextView11.setOnClickListener(this.v);
            EMTextView eMTextView12 = (EMTextView) this.f23090b.findViewById(c.a.t0.t2.i.pb_more_view_item_add_good);
            this.m = eMTextView12;
            eMTextView12.setOnClickListener(this.v);
            EMTextView eMTextView13 = (EMTextView) this.f23090b.findViewById(c.a.t0.t2.i.pb_more_view_item_private);
            this.p = eMTextView13;
            eMTextView13.setOnClickListener(this.v);
            EMTextView eMTextView14 = (EMTextView) this.f23090b.findViewById(c.a.t0.t2.i.pb_more_view_item_heating_thread);
            this.q = eMTextView14;
            eMTextView14.setOnClickListener(this.v);
            this.s = (TextSizeSeekBar) this.f23090b.findViewById(c.a.t0.t2.i.pb_more_text_size_seekbar);
            this.r = (LinearLayout) this.f23090b.findViewById(c.a.t0.t2.i.size_seek_bar_group);
            EMTextView eMTextView15 = (EMTextView) this.f23090b.findViewById(c.a.t0.t2.i.pb_more_cancel);
            this.t = eMTextView15;
            eMTextView15.setOnClickListener(this.v);
            this.u = this.f23090b.findViewById(c.a.t0.t2.i.pb_more_bomb_enter_anim_place_holder);
            if (s()) {
                return;
            }
            B();
        }
    }

    public TextView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f23092d : (TextView) invokeV.objValue;
    }

    public TextView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f23093e : (TextView) invokeV.objValue;
    }

    public TextView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.m : (TextView) invokeV.objValue;
    }

    public TextView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f23098j : (TextView) invokeV.objValue;
    }

    public TextView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.l : (TextView) invokeV.objValue;
    }

    public TextView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.p : (TextView) invokeV.objValue;
    }

    public TextView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.n : (TextView) invokeV.objValue;
    }

    public TextView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f23090b : (View) invokeV.objValue;
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.a.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.densityDpi;
            return i2 % 160 == 0 || ((double) ((((float) i2) * 1.0f) / 160.0f)) == 1.5d;
        }
        return invokeV.booleanValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
        }
    }

    public void u() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            SkinManager.setBackgroundColor(this.f23091c, c.a.t0.t2.f.CAM_X0213);
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.r);
            d2.n(c.a.t0.t2.l.J_X14);
            d2.f(c.a.t0.t2.f.CAM_X0213);
            SkinManager.setBackgroundResource(this.u, c.a.t0.t2.f.CAM_X0213);
            SkinManager.setBackgroundResource(this.t, c.a.t0.t2.f.CAM_X0213);
            SkinManager.setViewTextColorSelector(this.t, c.a.t0.t2.f.CAM_X0107);
            SkinManager.setViewTextColor(this.f23092d, c.a.t0.t2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.n, c.a.t0.t2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.o, c.a.t0.t2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f23093e, c.a.t0.t2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f23094f, c.a.t0.t2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f23095g, c.a.t0.t2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f23096h, c.a.t0.t2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f23098j, c.a.t0.t2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.m, c.a.t0.t2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f23097i, c.a.t0.t2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.k, c.a.t0.t2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.l, c.a.t0.t2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.p, c.a.t0.t2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.q, c.a.t0.t2.f.CAM_X0107, 1);
            int width = ((WindowManager) this.a.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(c.a.t0.t2.g.M_W_X007) * 2);
            if (s()) {
                i2 = (width - (UtilHelper.getDimenPixelSize(c.a.t0.t2.g.tbds201) * 5)) / 4;
            } else {
                i2 = (width - 1005) / 4;
            }
            this.f23091c.setHorizontalSpacing(i2);
            K(this.f23092d, c.a.t0.t2.h.icon_pure_pb_recommend_jump30);
            K(this.n, c.a.t0.t2.h.icon_pure_pb_recommend_report30);
            K(this.f23093e, c.a.t0.t2.h.icon_pure_pb_recommend_initial30);
            K(this.f23094f, c.a.t0.t2.h.icon_pure_pb_recommend_fans30);
            this.f23094f.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
            K(this.f23095g, c.a.t0.t2.h.icon_pure_pb_shield30);
            K(this.f23096h, this.w ? c.a.t0.t2.h.icon_pure_pb_recommend_report30 : c.a.t0.t2.h.icon_pure_pb_recommend_delete30);
            K(this.f23097i, c.a.t0.t2.h.icon_pure_pb_recommend_block30);
            K(this.p, c.a.t0.t2.h.icon_pure_pb_recommend_private30);
            K(this.q, c.a.t0.t2.h.icon_pure_pb_recommend_fire_30);
            K(this.k, c.a.t0.t2.h.icon_pure_pb_recommend_sort30);
            TextSizeSeekBar textSizeSeekBar = this.s;
            if (textSizeSeekBar != null) {
                textSizeSeekBar.onChangeSkinType();
            }
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.f23095g.setVisibility(z ? 0 : 8);
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.f23094f.setVisibility(z ? 0 : 8);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.f23096h.setVisibility(z ? 0 : 8);
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.f23097i.setVisibility(z ? 0 : 8);
        }
    }

    public void z(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.q.setVisibility(z ? 0 : 8);
            if (z2) {
                this.q.setText(c.a.t0.t2.l.heating_thread);
            } else {
                this.q.setText(c.a.t0.t2.l.help_heating_thread);
            }
        }
    }
}
