package com.baidu.tbadk.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.d.n.e.b;
import c.a.s0.s.u.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class PbListView extends b {
    public static /* synthetic */ Interceptable $ic;
    public static final int H;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public LinearLayout B;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public boolean G;

    /* renamed from: f  reason: collision with root package name */
    public final int f40481f;

    /* renamed from: g  reason: collision with root package name */
    public final int f40482g;

    /* renamed from: h  reason: collision with root package name */
    public final int f40483h;

    /* renamed from: i  reason: collision with root package name */
    public Context f40484i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f40485j;
    public ProgressBar k;
    public View.OnClickListener l;
    public View m;
    public View n;
    public ImageView o;
    public int p;
    public boolean q;
    public int r;
    public String s;
    public LinearLayout t;
    public RelativeLayout u;
    public EMTextView v;
    public int w;
    public int x;
    public int y;
    public ImageView z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class IconType {
        public static final /* synthetic */ IconType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final IconType ICON_DOWN_WARD;
        public static final IconType ICON_UP_WARD;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(555906518, "Lcom/baidu/tbadk/core/view/PbListView$IconType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(555906518, "Lcom/baidu/tbadk/core/view/PbListView$IconType;");
                    return;
                }
            }
            ICON_DOWN_WARD = new IconType("ICON_DOWN_WARD", 0);
            IconType iconType = new IconType("ICON_UP_WARD", 1);
            ICON_UP_WARD = iconType;
            $VALUES = new IconType[]{ICON_DOWN_WARD, iconType};
        }

        public IconType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static IconType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (IconType) Enum.valueOf(IconType.class, str) : (IconType) invokeL.objValue;
        }

        public static IconType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (IconType[]) $VALUES.clone() : (IconType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1015143849, "Lcom/baidu/tbadk/core/view/PbListView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1015143849, "Lcom/baidu/tbadk/core/view/PbListView;");
                return;
            }
        }
        H = R.drawable.new_pic_emotion_03;
    }

    public PbListView(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40481f = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.f40482g = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds256);
        this.f40483h = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds104);
        this.f40484i = null;
        this.f40485j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.p = H;
        this.r = 0;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = 0;
        this.x = R.color.CAM_X0110;
        this.y = R.color.CAM_X0205;
        this.z = null;
        this.A = false;
        this.B = null;
        this.C = true;
        this.D = false;
        this.E = -1;
        this.F = 0;
        this.G = false;
        this.f40484i = context;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.z.setVisibility(0);
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.x = i2;
        }
    }

    public void C(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            E(str, this.f40483h);
        }
    }

    public void E(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, str, i2) == null) {
            this.s = str;
            this.f40485j.setText(str);
            this.q = false;
            this.o.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.t.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.bottomMargin = 0;
            this.t.setLayoutParams(layoutParams);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.w = i2;
        }
    }

    public void G(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
            this.s = str;
            this.f40485j.setText(str);
            this.q = true;
            this.o.setVisibility(0);
            this.p = H;
            d(TbadkCoreApplication.getInst().getSkinType());
            e(i2);
            this.G = false;
        }
    }

    public void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f40485j.setTextSize(0, n.f(this.f40484i, i2));
        }
    }

    public void I(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2) == null) {
            this.s = str;
            this.f40485j.setText(str);
            this.q = true;
            this.o.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams.topMargin = i2;
            this.o.setLayoutParams(layoutParams);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void J(String str, @DrawableRes int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, str, i2, i3) == null) {
            this.s = str;
            this.f40485j.setText(str);
            this.q = true;
            this.p = i2;
            this.o.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams.topMargin = i3;
            layoutParams.bottomMargin = this.f40481f;
            this.o.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.t.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.bottomMargin = this.f40482g;
            this.t.setLayoutParams(layoutParams2);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || 8 == this.B.getVisibility()) {
            return;
        }
        this.B.setVisibility(8);
    }

    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.m.setVisibility(i2);
        }
    }

    public void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.n.getLayoutParams());
            layoutParams.height = i2;
            this.n.setLayoutParams(layoutParams);
            this.n.setVisibility(0);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.D) {
                this.t.setVisibility(8);
                this.f40485j.setVisibility(8);
                this.u.setVisibility(0);
            } else {
                this.f40485j.setVisibility(0);
                this.t.setVisibility(0);
            }
            f();
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.k.setVisibility(0);
            if (this.D) {
                this.t.setVisibility(8);
                this.f40485j.setVisibility(8);
                this.u.setVisibility(0);
                return;
            }
            this.f40485j.setVisibility(0);
            this.f40485j.setText(this.f40484i.getText(R.string.loading));
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.B.setVisibility(0);
            this.z.setVisibility(0);
            this.t.setVisibility(0);
            this.f40485j.setVisibility(0);
            this.k.setVisibility(0);
            j();
        }
    }

    public void Q(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || (linearLayout = this.B) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.height = i2;
        this.B.setLayoutParams(layoutParams);
        this.B.setVisibility(0);
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.k.setVisibility(0);
            this.f40485j.setText(this.f40484i.getText(R.string.loading));
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // c.a.d.n.e.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            View inflate = LayoutInflater.from(this.f40484i).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.m = inflate;
            this.t = (LinearLayout) inflate.findViewById(R.id.pb_more_view);
            this.u = (RelativeLayout) this.m.findViewById(R.id.pb_check_more);
            this.v = (EMTextView) this.m.findViewById(R.id.pb_check_more_text);
            this.u.setVisibility(8);
            this.f40485j = (TextView) this.m.findViewById(R.id.pb_more_text);
            this.o = (ImageView) this.m.findViewById(R.id.no_data_image);
            if (this.C) {
                this.t.setVisibility(0);
            } else {
                this.t.setVisibility(8);
            }
            this.k = (ProgressBar) this.m.findViewById(R.id.progress);
            this.z = (ImageView) this.m.findViewById(R.id.pb_more_view_top_line);
            this.n = this.m.findViewById(R.id.empty_view);
            this.B = (LinearLayout) this.m.findViewById(R.id.pb_more_top_extra_view);
            c d2 = c.d(this.v);
            d2.z(R.dimen.T_X12);
            d2.A(R.string.F_X01);
            d2.v(R.color.CAM_X0107);
            return this.m;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.d.n.e.b
    public void c() {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (onClickListener = this.l) == null) {
            return;
        }
        onClickListener.onClick(this.m);
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(int i2) {
        int color;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            int i5 = this.E;
            if (i5 != -1) {
                i2 = i5;
            }
            String charSequence = this.f40485j.getText().toString();
            boolean z = false;
            if (charSequence.equals(this.f40484i.getText(R.string.pb_load_more))) {
                color = SkinManager.getColor(i2, R.color.CAM_X0109);
            } else if (charSequence.equals(this.f40484i.getText(R.string.loading))) {
                color = SkinManager.getColor(i2, R.color.CAM_X0109);
            } else if (!charSequence.equals(this.f40484i.getText(R.string.list_no_more)) && !charSequence.equals(this.f40484i.getText(R.string.list_has_no_more)) && !charSequence.equals(this.f40484i.getText(R.string.sub_pb_list_no_more)) && !this.A) {
                if (charSequence.equals(this.f40484i.getText(R.string.list_no_more_new))) {
                    color = SkinManager.getColor(i2, R.color.CAM_X0110);
                } else {
                    color = (charSequence.equals(this.f40484i.getText(R.string.list_click_load_more)) || charSequence.equals(this.f40484i.getText(R.string.really_great))) ? SkinManager.getColor(i2, R.color.CAM_X0109) : 0;
                }
            } else {
                color = SkinManager.getColor(i2, R.color.CAM_X0109);
                z = true;
            }
            if (z && (i4 = this.x) != 0) {
                color = SkinManager.getColor(i2, i4);
            }
            if (color == 0 && (i3 = this.w) != 0 && !z) {
                color = i3;
            }
            if (color != 0) {
                this.f40485j.setTextColor(color);
            }
            SkinManager.setImageResource(this.z, this.y, i2);
            int i6 = this.F;
            if (i6 == 0) {
                SkinManager.setBackgroundResource(this.t, R.color.CAM_X0201, i2);
            } else if (i6 > 0) {
                SkinManager.setBackgroundResource(this.t, i6, i2);
            }
            int i7 = this.r;
            if (i7 != 0) {
                SkinManager.setBackgroundColor(this.n, i7, i2);
            }
            if (this.q) {
                SkinManager.setImageResource(this.o, this.p);
                SkinManager.setViewTextColor(this.f40485j, R.color.CAM_X0109);
            }
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            int dimension = (int) this.f40484i.getResources().getDimension(R.dimen.tbds156);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams.topMargin = dimension;
            this.o.setLayoutParams(layoutParams);
            M(dimension);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.k.setVisibility(8);
            if (this.s != null) {
                if (this.D) {
                    this.t.setVisibility(8);
                    this.f40485j.setVisibility(8);
                    this.u.setVisibility(0);
                    this.D = false;
                } else {
                    this.u.setVisibility(8);
                    this.t.setVisibility(0);
                    this.f40485j.setVisibility(0);
                    this.f40485j.setText(this.s);
                }
            } else {
                this.f40485j.setText(this.f40484i.getText(R.string.pb_load_more));
            }
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            D(this.f40484i.getResources().getString(R.string.list_no_more));
            f();
        }
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public Boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? Boolean.valueOf(this.D) : (Boolean) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.n.setVisibility(8);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.q = false;
            this.o.setVisibility(8);
            j();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.t.getLayoutParams();
            layoutParams.height = this.f40483h;
            layoutParams.bottomMargin = 0;
            this.t.setLayoutParams(layoutParams);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.n.getLayoutParams());
            layoutParams.height = i2;
            this.n.setLayoutParams(layoutParams);
            this.n.setVisibility(0);
            this.B.setVisibility(8);
            this.z.setVisibility(8);
            this.t.setVisibility(8);
            this.f40485j.setVisibility(8);
            this.k.setVisibility(8);
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            ProgressBar progressBar = this.k;
            return progressBar != null && progressBar.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            SkinManager.setBackgroundResource(this.t, i2);
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.F = i2;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.A = z;
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z.getLayoutParams();
            layoutParams.height = i2;
            this.z.setLayoutParams(layoutParams);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.m.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.t.getLayoutParams());
            layoutParams.height = i2;
            this.t.setLayoutParams(layoutParams);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.C = z;
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.D = z;
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z.getLayoutParams();
            layoutParams.height = n.f(this.f40484i, R.dimen.ds1);
            this.z.setLayoutParams(layoutParams);
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.y = i2;
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.z.setVisibility(8);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z.getLayoutParams();
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.z.setLayoutParams(layoutParams);
        }
    }
}
