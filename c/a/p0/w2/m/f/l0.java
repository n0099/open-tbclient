package c.a.p0.w2.m.f;

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
public class l0 extends c.a.d.a.d {
    public static /* synthetic */ Interceptable $ic;
    public static final int x;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;

    /* renamed from: b  reason: collision with root package name */
    public View f20200b;

    /* renamed from: c  reason: collision with root package name */
    public FlowLayout f20201c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f20202d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f20203e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f20204f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f20205g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f20206h;
    public EMTextView i;
    public EMTextView j;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(218726593, "Lc/a/p0/w2/m/f/l0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(218726593, "Lc/a/p0/w2/m/f/l0;");
                return;
            }
        }
        x = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        u();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f20206h.setVisibility(z ? 0 : 8);
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.i.setVisibility(z ? 0 : 8);
        }
    }

    public void C(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.q.setVisibility(z ? 0 : 8);
            if (z2) {
                this.q.setText(R.string.obfuscated_res_0x7f0f081b);
            } else {
                this.q.setText(R.string.obfuscated_res_0x7f0f081c);
            }
        }
    }

    public void D(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.o.setVisibility(z ? 0 : 8);
            if (z2) {
                this.o.setText(R.string.obfuscated_res_0x7f0f07da);
                O(this.o, R.drawable.obfuscated_res_0x7f08092c);
                return;
            }
            this.o.setText(R.string.obfuscated_res_0x7f0f14fe);
            O(this.o, R.drawable.obfuscated_res_0x7f08093c);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.o.getLayoutParams().width = 201;
            this.k.getLayoutParams().width = 201;
            this.f20202d.getLayoutParams().width = 201;
            this.l.getLayoutParams().width = 201;
            this.f20203e.getLayoutParams().width = 201;
            this.f20204f.getLayoutParams().width = 201;
            this.n.getLayoutParams().width = 201;
            this.f20205g.getLayoutParams().width = 201;
            this.f20206h.getLayoutParams().width = 201;
            this.i.getLayoutParams().width = 201;
            this.j.getLayoutParams().width = 201;
            this.m.getLayoutParams().width = 201;
            this.p.getLayoutParams().width = 201;
            this.q.getLayoutParams().width = 201;
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f20203e.setVisibility(z ? 0 : 8);
        }
    }

    public void G(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.m.setVisibility(z ? 0 : 8);
            if (z2) {
                this.m.setText(R.string.obfuscated_res_0x7f0f0d93);
                O(this.m, R.drawable.obfuscated_res_0x7f08092e);
                return;
            }
            this.m.setText(R.string.obfuscated_res_0x7f0f03fd);
            O(this.m, R.drawable.obfuscated_res_0x7f08092d);
        }
    }

    public void H(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.j.setVisibility(z ? 0 : 8);
            if (z2) {
                this.j.setText(R.string.obfuscated_res_0x7f0f0d94);
                O(this.j, R.drawable.obfuscated_res_0x7f08094b);
                return;
            }
            this.j.setText(R.string.obfuscated_res_0x7f0f13fd);
            O(this.j, R.drawable.obfuscated_res_0x7f08094a);
        }
    }

    public void I(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001281, String.class);
            if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                this.l.setVisibility(z ? 0 : 8);
                if (z2) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f0c6b);
                    O(this.l, R.drawable.obfuscated_res_0x7f080934);
                    return;
                }
                this.l.setText(R.string.obfuscated_res_0x7f0f05c5);
                O(this.l, R.drawable.obfuscated_res_0x7f080941);
                return;
            }
            this.l.setVisibility(8);
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.p.setVisibility(z ? 0 : 8);
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.n.setVisibility(z ? 0 : 8);
        }
    }

    public void M(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.k.setVisibility(z ? 0 : 8);
            if (z2) {
                this.k.setText(R.string.obfuscated_res_0x7f0f1506);
            } else {
                this.k.setText(R.string.obfuscated_res_0x7f0f047e);
            }
            this.k.setText(R.string.obfuscated_res_0x7f0f1187);
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f20202d.setVisibility(z ? 0 : 8);
        }
    }

    public final void O(TextView textView, int i) {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048589, this, textView, i) == null) || textView == null || (pureDrawable = WebPManager.getPureDrawable(i, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i2 = x;
        pureDrawable.setBounds(0, 0, i2, i2);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.s.setVisibility(z ? 0 : 8);
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            MaskView.d(this.m, z);
            MaskView.d(this.j, z);
            MaskView.d(this.f20204f, z);
        }
    }

    public TextView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f20205g : (TextView) invokeV.objValue;
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f20204f : (TextView) invokeV.objValue;
    }

    public TextView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.t : (TextView) invokeV.objValue;
    }

    public TextView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f20206h : (TextView) invokeV.objValue;
    }

    public TextView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.i : (TextView) invokeV.objValue;
    }

    public TextView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.q : (TextView) invokeV.objValue;
    }

    public TextView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.o : (TextView) invokeV.objValue;
    }

    public TextView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f20202d : (TextView) invokeV.objValue;
    }

    public TextView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f20203e : (TextView) invokeV.objValue;
    }

    public TextView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.m : (TextView) invokeV.objValue;
    }

    public TextView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.j : (TextView) invokeV.objValue;
    }

    public TextView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.l : (TextView) invokeV.objValue;
    }

    public TextView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.p : (TextView) invokeV.objValue;
    }

    public TextView r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.n : (TextView) invokeV.objValue;
    }

    public TextView s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f20200b : (View) invokeV.objValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0692, (ViewGroup) null);
            this.f20200b = inflate;
            this.f20201c = (FlowLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0916eb);
            EMTextView eMTextView = (EMTextView) this.f20200b.findViewById(R.id.obfuscated_res_0x7f0916f7);
            this.o = eMTextView;
            eMTextView.setOnClickListener(this.v);
            EMTextView eMTextView2 = (EMTextView) this.f20200b.findViewById(R.id.obfuscated_res_0x7f0916fe);
            this.k = eMTextView2;
            eMTextView2.setOnClickListener(this.v);
            EMTextView eMTextView3 = (EMTextView) this.f20200b.findViewById(R.id.obfuscated_res_0x7f0916f8);
            this.f20202d = eMTextView3;
            eMTextView3.setOnClickListener(this.v);
            EMTextView eMTextView4 = (EMTextView) this.f20200b.findViewById(R.id.obfuscated_res_0x7f0916fb);
            this.l = eMTextView4;
            eMTextView4.setOnClickListener(this.v);
            EMTextView eMTextView5 = (EMTextView) this.f20200b.findViewById(R.id.obfuscated_res_0x7f0916f9);
            this.f20203e = eMTextView5;
            eMTextView5.setOnClickListener(this.v);
            EMTextView eMTextView6 = (EMTextView) this.f20200b.findViewById(R.id.obfuscated_res_0x7f0916f3);
            this.f20204f = eMTextView6;
            eMTextView6.setOnClickListener(this.v);
            EMTextView eMTextView7 = (EMTextView) this.f20200b.findViewById(R.id.obfuscated_res_0x7f0916fd);
            this.n = eMTextView7;
            eMTextView7.setOnClickListener(this.v);
            EMTextView eMTextView8 = (EMTextView) this.f20200b.findViewById(R.id.obfuscated_res_0x7f0916f2);
            this.f20205g = eMTextView8;
            eMTextView8.setOnClickListener(this.v);
            EMTextView eMTextView9 = (EMTextView) this.f20200b.findViewById(R.id.obfuscated_res_0x7f0916f4);
            this.f20206h = eMTextView9;
            eMTextView9.setOnClickListener(this.v);
            EMTextView eMTextView10 = (EMTextView) this.f20200b.findViewById(R.id.obfuscated_res_0x7f0916f5);
            this.i = eMTextView10;
            eMTextView10.setOnClickListener(this.v);
            EMTextView eMTextView11 = (EMTextView) this.f20200b.findViewById(R.id.obfuscated_res_0x7f0916fa);
            this.j = eMTextView11;
            eMTextView11.setOnClickListener(this.v);
            EMTextView eMTextView12 = (EMTextView) this.f20200b.findViewById(R.id.obfuscated_res_0x7f0916f1);
            this.m = eMTextView12;
            eMTextView12.setOnClickListener(this.v);
            EMTextView eMTextView13 = (EMTextView) this.f20200b.findViewById(R.id.obfuscated_res_0x7f0916fc);
            this.p = eMTextView13;
            eMTextView13.setOnClickListener(this.v);
            EMTextView eMTextView14 = (EMTextView) this.f20200b.findViewById(R.id.obfuscated_res_0x7f0916f6);
            this.q = eMTextView14;
            eMTextView14.setOnClickListener(this.v);
            this.s = (TextSizeSeekBar) this.f20200b.findViewById(R.id.obfuscated_res_0x7f0916ee);
            this.r = (LinearLayout) this.f20200b.findViewById(R.id.obfuscated_res_0x7f091d2c);
            EMTextView eMTextView15 = (EMTextView) this.f20200b.findViewById(R.id.obfuscated_res_0x7f0916ea);
            this.t = eMTextView15;
            eMTextView15.setOnClickListener(this.v);
            this.u = this.f20200b.findViewById(R.id.obfuscated_res_0x7f0916e9);
            if (v()) {
                return;
            }
            E();
        }
    }

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.a.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.densityDpi;
            return i % 160 == 0 || ((double) ((((float) i) * 1.0f) / 160.0f)) == 1.5d;
        }
        return invokeV.booleanValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
        }
    }

    public void x() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            SkinManager.setBackgroundColor(this.f20201c, R.color.CAM_X0213);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.r);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.u, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.t, R.color.CAM_X0213);
            SkinManager.setViewTextColorSelector(this.t, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f20202d, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f20203e, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f20204f, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f20205g, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f20206h, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0107, 1);
            int width = ((WindowManager) this.a.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            if (v()) {
                i = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
            } else {
                i = (width - 1005) / 4;
            }
            this.f20201c.setHorizontalSpacing(i);
            O(this.f20202d, R.drawable.obfuscated_res_0x7f08093e);
            EMTextView eMTextView = this.n;
            int i2 = R.drawable.obfuscated_res_0x7f080946;
            O(eMTextView, R.drawable.obfuscated_res_0x7f080946);
            O(this.f20203e, R.drawable.obfuscated_res_0x7f08093d);
            O(this.f20204f, R.drawable.obfuscated_res_0x7f080939);
            this.f20204f.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
            O(this.f20205g, R.drawable.obfuscated_res_0x7f08094e);
            EMTextView eMTextView2 = this.f20206h;
            if (!this.w) {
                i2 = R.drawable.obfuscated_res_0x7f080935;
            }
            O(eMTextView2, i2);
            O(this.i, R.drawable.obfuscated_res_0x7f08092f);
            O(this.p, R.drawable.obfuscated_res_0x7f080945);
            O(this.q, R.drawable.obfuscated_res_0x7f08093a);
            O(this.k, R.drawable.obfuscated_res_0x7f080949);
            TextSizeSeekBar textSizeSeekBar = this.s;
            if (textSizeSeekBar != null) {
                textSizeSeekBar.e();
            }
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.f20205g.setVisibility(z ? 0 : 8);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.f20204f.setVisibility(z ? 0 : 8);
        }
    }
}
