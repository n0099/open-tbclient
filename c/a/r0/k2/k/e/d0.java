package c.a.r0.k2.k.e;

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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.TextSizeSeekBar;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d0 extends c.a.e.a.d {
    public static /* synthetic */ Interceptable $ic;
    public static final int x;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragment f20165a;

    /* renamed from: b  reason: collision with root package name */
    public View f20166b;

    /* renamed from: c  reason: collision with root package name */
    public FlowLayout f20167c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f20168d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f20169e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f20170f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f20171g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f20172h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f20173i;

    /* renamed from: j  reason: collision with root package name */
    public EMTextView f20174j;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(214144068, "Lc/a/r0/k2/k/e/d0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(214144068, "Lc/a/r0/k2/k/e/d0;");
                return;
            }
        }
        x = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(BaseFragment baseFragment, View.OnClickListener onClickListener) {
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = null;
        this.v = null;
        this.f20165a = baseFragment;
        this.v = onClickListener;
        initUI();
    }

    public void A(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.o.setVisibility(z ? 0 : 8);
            if (z2) {
                this.o.setText(R.string.group_info_intro_more);
                R(this.o, R.drawable.icon_pure_pb_recommend_all30);
                return;
            }
            this.o.setText(R.string.view_host);
            R(this.o, R.drawable.icon_pure_pb_recommend_host30);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.o.getLayoutParams().width = 201;
            this.k.getLayoutParams().width = 201;
            this.f20168d.getLayoutParams().width = 201;
            this.l.getLayoutParams().width = 201;
            this.f20169e.getLayoutParams().width = 201;
            this.f20170f.getLayoutParams().width = 201;
            this.n.getLayoutParams().width = 201;
            this.f20171g.getLayoutParams().width = 201;
            this.f20172h.getLayoutParams().width = 201;
            this.f20173i.getLayoutParams().width = 201;
            this.f20174j.getLayoutParams().width = 201;
            this.m.getLayoutParams().width = 201;
            this.p.getLayoutParams().width = 201;
            this.q.getLayoutParams().width = 201;
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f20169e.setVisibility(z ? 0 : 8);
        }
    }

    public void J(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.m.setVisibility(z ? 0 : 8);
            if (z2) {
                this.m.setText(R.string.pb_cancel_good);
                R(this.m, R.drawable.icon_pure_pb_recommend_bested30);
                return;
            }
            this.m.setText(R.string.commit_good);
            R(this.m, R.drawable.icon_pure_pb_recommend_best30);
        }
    }

    public void K(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f20174j.setVisibility(z ? 0 : 8);
            if (z2) {
                this.f20174j.setText(R.string.pb_cancel_top);
                R(this.f20174j, R.drawable.icon_pure_pb_recommend_toped30);
                return;
            }
            this.f20174j.setText(R.string.top);
            R(this.f20174j, R.drawable.icon_pure_pb_recommend_top30);
        }
    }

    public void L(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001281, String.class);
            if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                this.l.setVisibility(z ? 0 : 8);
                if (z2) {
                    this.l.setText(R.string.normal_mode);
                    R(this.l, R.drawable.icon_pure_pb_recommend_daytime30);
                    return;
                }
                this.l.setText(R.string.eyeshield_mode);
                R(this.l, R.drawable.icon_pure_pb_recommend_night30);
                return;
            }
            this.l.setVisibility(8);
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.p.setVisibility(z ? 0 : 8);
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.n.setVisibility(z ? 0 : 8);
        }
    }

    public void P(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.k.setVisibility(z ? 0 : 8);
            if (z2) {
                this.k.setText(R.string.view_reverse);
            } else {
                this.k.setText(R.string.default_sort);
            }
            this.k.setText(R.string.sort_selector);
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f20168d.setVisibility(z ? 0 : 8);
        }
    }

    public final void R(TextView textView, int i2) {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048586, this, textView, i2) == null) || textView == null || (pureDrawable = WebPManager.getPureDrawable(i2, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i3 = x;
        pureDrawable.setBounds(0, 0, i3, i3);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.s.setVisibility(z ? 0 : 8);
        }
    }

    public void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            MaskView.maskTextView(this.m, z);
            MaskView.maskTextView(this.f20174j, z);
            MaskView.maskTextView(this.f20170f, z);
        }
    }

    public TextView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f20171g : (TextView) invokeV.objValue;
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f20170f : (TextView) invokeV.objValue;
    }

    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.t : (TextView) invokeV.objValue;
    }

    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f20172h : (TextView) invokeV.objValue;
    }

    public TextView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f20173i : (TextView) invokeV.objValue;
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
            View inflate = LayoutInflater.from(this.f20165a.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
            this.f20166b = inflate;
            this.f20167c = (FlowLayout) inflate.findViewById(R.id.pb_more_flowlayout);
            EMTextView eMTextView = (EMTextView) this.f20166b.findViewById(R.id.pb_more_view_item_host_only);
            this.o = eMTextView;
            eMTextView.setOnClickListener(this.v);
            EMTextView eMTextView2 = (EMTextView) this.f20166b.findViewById(R.id.pb_more_view_item_reversed);
            this.k = eMTextView2;
            eMTextView2.setOnClickListener(this.v);
            EMTextView eMTextView3 = (EMTextView) this.f20166b.findViewById(R.id.pb_more_view_item_jump);
            this.f20168d = eMTextView3;
            eMTextView3.setOnClickListener(this.v);
            EMTextView eMTextView4 = (EMTextView) this.f20166b.findViewById(R.id.pb_more_view_item_night_style);
            this.l = eMTextView4;
            eMTextView4.setOnClickListener(this.v);
            EMTextView eMTextView5 = (EMTextView) this.f20166b.findViewById(R.id.pb_more_view_item_jump_top);
            this.f20169e = eMTextView5;
            eMTextView5.setOnClickListener(this.v);
            EMTextView eMTextView6 = (EMTextView) this.f20166b.findViewById(R.id.pb_more_view_item_call_fans);
            this.f20170f = eMTextView6;
            eMTextView6.setOnClickListener(this.v);
            EMTextView eMTextView7 = (EMTextView) this.f20166b.findViewById(R.id.pb_more_view_item_report);
            this.n = eMTextView7;
            eMTextView7.setOnClickListener(this.v);
            EMTextView eMTextView8 = (EMTextView) this.f20166b.findViewById(R.id.pb_more_view_item_block);
            this.f20171g = eMTextView8;
            eMTextView8.setOnClickListener(this.v);
            EMTextView eMTextView9 = (EMTextView) this.f20166b.findViewById(R.id.pb_more_view_item_delete);
            this.f20172h = eMTextView9;
            eMTextView9.setOnClickListener(this.v);
            EMTextView eMTextView10 = (EMTextView) this.f20166b.findViewById(R.id.pb_more_view_item_forbidden);
            this.f20173i = eMTextView10;
            eMTextView10.setOnClickListener(this.v);
            EMTextView eMTextView11 = (EMTextView) this.f20166b.findViewById(R.id.pb_more_view_item_make_top);
            this.f20174j = eMTextView11;
            eMTextView11.setOnClickListener(this.v);
            EMTextView eMTextView12 = (EMTextView) this.f20166b.findViewById(R.id.pb_more_view_item_add_good);
            this.m = eMTextView12;
            eMTextView12.setOnClickListener(this.v);
            EMTextView eMTextView13 = (EMTextView) this.f20166b.findViewById(R.id.pb_more_view_item_private);
            this.p = eMTextView13;
            eMTextView13.setOnClickListener(this.v);
            EMTextView eMTextView14 = (EMTextView) this.f20166b.findViewById(R.id.pb_more_view_item_heating_thread);
            this.q = eMTextView14;
            eMTextView14.setOnClickListener(this.v);
            this.s = (TextSizeSeekBar) this.f20166b.findViewById(R.id.pb_more_text_size_seekbar);
            this.r = (LinearLayout) this.f20166b.findViewById(R.id.size_seek_bar_group);
            EMTextView eMTextView15 = (EMTextView) this.f20166b.findViewById(R.id.pb_more_cancel);
            this.t = eMTextView15;
            eMTextView15.setOnClickListener(this.v);
            this.u = this.f20166b.findViewById(R.id.pb_more_bomb_enter_anim_place_holder);
            if (s()) {
                return;
            }
            B();
        }
    }

    public TextView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f20168d : (TextView) invokeV.objValue;
    }

    public TextView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f20169e : (TextView) invokeV.objValue;
    }

    public TextView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.m : (TextView) invokeV.objValue;
    }

    public TextView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f20174j : (TextView) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f20166b : (View) invokeV.objValue;
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.f20165a.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
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
            SkinManager.setBackgroundColor(this.f20167c, R.color.CAM_X0213);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.r);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.u, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.t, R.color.CAM_X0213);
            SkinManager.setViewTextColorSelector(this.t, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f20168d, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f20169e, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f20170f, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f20171g, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f20172h, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f20174j, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f20173i, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0107, 1);
            int width = ((WindowManager) this.f20165a.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            if (s()) {
                i2 = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
            } else {
                i2 = (width - 1005) / 4;
            }
            this.f20167c.setHorizontalSpacing(i2);
            R(this.f20168d, R.drawable.icon_pure_pb_recommend_jump30);
            R(this.n, R.drawable.icon_pure_pb_recommend_report30);
            R(this.f20169e, R.drawable.icon_pure_pb_recommend_initial30);
            R(this.f20170f, R.drawable.icon_pure_pb_recommend_fans30);
            this.f20170f.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
            R(this.f20171g, R.drawable.icon_pure_pb_shield30);
            R(this.f20172h, this.w ? R.drawable.icon_pure_pb_recommend_report30 : R.drawable.icon_pure_pb_recommend_delete30);
            R(this.f20173i, R.drawable.icon_pure_pb_recommend_block30);
            R(this.p, R.drawable.icon_pure_pb_recommend_private30);
            R(this.q, R.drawable.icon_pure_pb_recommend_fire_30);
            R(this.k, R.drawable.icon_pure_pb_recommend_sort30);
            TextSizeSeekBar textSizeSeekBar = this.s;
            if (textSizeSeekBar != null) {
                textSizeSeekBar.onChangeSkinType();
            }
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.f20171g.setVisibility(z ? 0 : 8);
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.f20170f.setVisibility(z ? 0 : 8);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.f20172h.setVisibility(z ? 0 : 8);
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.f20173i.setVisibility(z ? 0 : 8);
        }
    }

    public void z(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.q.setVisibility(z ? 0 : 8);
            if (z2) {
                this.q.setText(R.string.heating_thread);
            } else {
                this.q.setText(R.string.help_heating_thread);
            }
        }
    }
}
