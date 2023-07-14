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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.d85;
import com.baidu.tieba.mn;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PbListView extends mn {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int E = 2131235000;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public int C;
    public boolean D;
    public final int b;
    public Context c;
    public TextView d;
    public View e;
    public View f;
    public ProgressBar g;
    public View.OnClickListener h;
    public View i;
    public View j;
    public ImageView k;
    public int l;
    public boolean m;
    public int n;
    public String o;
    public LinearLayout p;
    public RelativeLayout q;
    public EMTextView r;
    public int s;
    public int t;
    public int u;
    public ImageView v;
    public boolean w;
    public LinearLayout x;
    public LinearLayout y;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1015143849, "Lcom/baidu/tbadk/core/view/PbListView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1015143849, "Lcom/baidu/tbadk/core/view/PbListView;");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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

        public IconType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (IconType) Enum.valueOf(IconType.class, str);
            }
            return (IconType) invokeL.objValue;
        }

        public static IconType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (IconType[]) $VALUES.clone();
            }
            return (IconType[]) invokeV.objValue;
        }
    }

    public PbListView(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds256);
        this.b = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.l = E;
        this.n = 0;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = 0;
        this.t = R.color.CAM_X0110;
        this.u = R.color.CAM_X0205;
        this.v = null;
        this.w = false;
        this.x = null;
        this.y = null;
        this.z = true;
        this.A = false;
        this.B = -1;
        this.C = 0;
        this.D = false;
        this.c = context;
    }

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.u = i;
        }
    }

    public void E(int i) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (linearLayout = this.p) != null && (linearLayout.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.p.getLayoutParams();
            layoutParams.topMargin = i;
            this.p.setLayoutParams(layoutParams);
        }
    }

    public void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.t = i;
        }
    }

    public void G(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.h = onClickListener;
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            I(str, this.b);
        }
    }

    public void J(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.s = i;
        }
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.d.setTextSize(0, yi.g(this.c, i));
        }
    }

    public void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.i.setVisibility(i);
        }
    }

    public void P(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.j.getLayoutParams());
            layoutParams.height = i;
            this.j.setLayoutParams(layoutParams);
            this.j.setVisibility(0);
        }
    }

    public void T(int i) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048595, this, i) != null) || (linearLayout = this.x) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.height = i;
        this.x.setLayoutParams(layoutParams);
        this.x.setVisibility(0);
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            int dimension = (int) this.c.getResources().getDimension(R.dimen.tbds156);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.topMargin = dimension;
            this.k.setLayoutParams(layoutParams);
            P(dimension);
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            SkinManager.setBackgroundResource(this.p, i);
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.C = i;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.w = z;
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.v.getLayoutParams();
            layoutParams.height = i;
            this.v.setLayoutParams(layoutParams);
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.p.getLayoutParams());
            layoutParams.height = i;
            this.p.setLayoutParams(layoutParams);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.z = z;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.A = z;
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.v.setVisibility(8);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.v.getLayoutParams();
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.v.setLayoutParams(layoutParams);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.v.setVisibility(0);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && 8 != this.x.getVisibility()) {
            this.x.setVisibility(8);
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.x.setVisibility(0);
            this.v.setVisibility(0);
            this.p.setVisibility(0);
            this.d.setVisibility(0);
            this.g.setVisibility(0);
            m();
        }
    }

    @Override // com.baidu.tieba.mn
    public void d() {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (onClickListener = this.h) != null) {
            onClickListener.onClick(this.i);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            H(this.c.getResources().getString(R.string.list_no_more));
            g();
        }
    }

    public LinearLayout i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.y;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    public Boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return Boolean.valueOf(this.A);
        }
        return (Boolean) invokeV.objValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.i.getVisibility();
        }
        return invokeV.intValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.j.setVisibility(8);
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            ProgressBar progressBar = this.g;
            if (progressBar == null || progressBar.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.i.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.v.getLayoutParams();
            layoutParams.height = yi.g(this.c, R.dimen.obfuscated_res_0x7f070198);
            this.v.setLayoutParams(layoutParams);
        }
    }

    public void I(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i) == null) {
            this.o = str;
            this.d.setText(str);
            this.m = false;
            this.k.setVisibility(8);
            if (TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments).equals(str)) {
                this.e.setVisibility(0);
                this.f.setVisibility(0);
            } else {
                this.e.setVisibility(8);
                this.f.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.p.getLayoutParams();
            layoutParams.height = i;
            layoutParams.bottomMargin = 0;
            this.p.setLayoutParams(layoutParams);
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void K(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, str, i) == null) {
            this.o = str;
            this.d.setText(str);
            this.m = true;
            this.k.setVisibility(0);
            this.l = E;
            e(TbadkCoreApplication.getInst().getSkinType());
            f(i);
            this.D = false;
        }
    }

    public void M(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, str, i) == null) {
            this.o = str;
            this.d.setText(str);
            this.m = true;
            this.k.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.topMargin = i;
            this.k.setLayoutParams(layoutParams);
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.A) {
                this.p.setVisibility(8);
                this.d.setVisibility(8);
                this.f.setVisibility(8);
                this.e.setVisibility(8);
                this.q.setVisibility(0);
            } else {
                this.d.setVisibility(0);
                this.p.setVisibility(0);
            }
            g();
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.g.setVisibility(0);
            this.f.setVisibility(8);
            this.e.setVisibility(8);
            this.d.setText(this.c.getText(R.string.obfuscated_res_0x7f0f0be2));
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.m = false;
            this.k.setVisibility(8);
            m();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.p.getLayoutParams();
            layoutParams.height = this.b;
            layoutParams.bottomMargin = 0;
            this.p.setLayoutParams(layoutParams);
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.g.setVisibility(0);
            if (this.A) {
                this.p.setVisibility(8);
                this.d.setVisibility(8);
                this.f.setVisibility(8);
                this.e.setVisibility(8);
                this.q.setVisibility(0);
                return;
            }
            this.d.setVisibility(0);
            this.d.setText(this.c.getText(R.string.obfuscated_res_0x7f0f0be2));
        }
    }

    @Override // com.baidu.tieba.mn
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            View inflate = LayoutInflater.from(this.c).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.i = inflate;
            this.p = (LinearLayout) inflate.findViewById(R.id.pb_more_view);
            this.q = (RelativeLayout) this.i.findViewById(R.id.pb_check_more);
            this.r = (EMTextView) this.i.findViewById(R.id.pb_check_more_text);
            this.q.setVisibility(8);
            this.d = (TextView) this.i.findViewById(R.id.pb_more_text);
            this.e = this.i.findViewById(R.id.pb_more_text_left_line);
            this.f = this.i.findViewById(R.id.pb_more_text_right_line);
            this.k = (ImageView) this.i.findViewById(R.id.no_data_image);
            if (this.z) {
                this.p.setVisibility(0);
            } else {
                this.p.setVisibility(8);
            }
            this.g = (ProgressBar) this.i.findViewById(R.id.obfuscated_res_0x7f091d48);
            this.v = (ImageView) this.i.findViewById(R.id.pb_more_view_top_line);
            this.j = this.i.findViewById(R.id.empty_view);
            this.x = (LinearLayout) this.i.findViewById(R.id.pb_more_top_extra_view);
            this.y = (LinearLayout) this.i.findViewById(R.id.pb_more_bottom_extra_view);
            d85 d = d85.d(this.r);
            d.C(R.dimen.T_X12);
            d.D(R.string.F_X01);
            d.x(R.color.CAM_X0107);
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public void e(int i) {
        int color;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            int i4 = this.B;
            if (i4 != -1) {
                i = i4;
            }
            String charSequence = this.d.getText().toString();
            boolean z = false;
            if (charSequence.equals(this.c.getText(R.string.pb_load_more))) {
                color = SkinManager.getColor(i, (int) R.color.CAM_X0109);
            } else if (charSequence.equals(this.c.getText(R.string.obfuscated_res_0x7f0f0be2))) {
                color = SkinManager.getColor(i, (int) R.color.CAM_X0109);
            } else if (!charSequence.equals(this.c.getText(R.string.list_no_more)) && !charSequence.equals(this.c.getText(R.string.list_has_all_comments)) && !charSequence.equals(this.c.getText(R.string.sub_pb_list_no_more)) && !this.w) {
                if (charSequence.equals(this.c.getText(R.string.list_no_more_new))) {
                    color = SkinManager.getColor(i, (int) R.color.CAM_X0110);
                } else if (!charSequence.equals(this.c.getText(R.string.list_click_load_more)) && !charSequence.equals(this.c.getText(R.string.really_great))) {
                    color = 0;
                } else {
                    color = SkinManager.getColor(i, (int) R.color.CAM_X0109);
                }
            } else {
                color = SkinManager.getColor(i, (int) R.color.CAM_X0109);
                z = true;
            }
            if (z && (i3 = this.t) != 0) {
                color = SkinManager.getColor(i, i3);
            }
            if (color == 0 && (i2 = this.s) != 0 && !z) {
                color = i2;
            }
            if (color != 0) {
                this.d.setTextColor(color);
            }
            View view2 = this.e;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0112);
            }
            View view3 = this.f;
            if (view3 != null) {
                SkinManager.setBackgroundColor(view3, R.color.CAM_X0112);
            }
            SkinManager.setImageResource(this.v, this.u, i);
            int i5 = this.C;
            if (i5 == 0) {
                SkinManager.setBackgroundResource(this.p, R.color.CAM_X0201, i);
            } else if (i5 > 0) {
                SkinManager.setBackgroundResource(this.p, i5, i);
            }
            int i6 = this.n;
            if (i6 != 0) {
                SkinManager.setBackgroundColor(this.j, i6, i);
            }
            if (this.m) {
                SkinManager.setImageResource(this.k, this.l);
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.g.setVisibility(8);
            if (this.o != null) {
                if (this.A) {
                    this.p.setVisibility(8);
                    this.d.setVisibility(8);
                    this.f.setVisibility(8);
                    this.e.setVisibility(8);
                    this.q.setVisibility(0);
                    this.A = false;
                } else {
                    this.q.setVisibility(8);
                    this.p.setVisibility(0);
                    this.d.setVisibility(0);
                    this.d.setText(this.o);
                }
            } else {
                this.d.setText(this.c.getText(R.string.pb_load_more));
            }
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.j.getLayoutParams());
            layoutParams.height = i;
            this.j.setLayoutParams(layoutParams);
            this.j.setVisibility(0);
            this.x.setVisibility(8);
            this.y.setVisibility(8);
            this.v.setVisibility(8);
            this.p.setVisibility(8);
            this.d.setVisibility(8);
            this.f.setVisibility(8);
            this.e.setVisibility(8);
            this.g.setVisibility(8);
        }
    }
}
