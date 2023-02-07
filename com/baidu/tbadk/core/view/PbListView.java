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
import com.baidu.tieba.ej;
import com.baidu.tieba.p15;
import com.baidu.tieba.rn;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class PbListView extends rn {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int B = 2131234486;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public final int b;
    public Context c;
    public TextView d;
    public ProgressBar e;
    public View.OnClickListener f;
    public View g;
    public View h;
    public ImageView i;
    public int j;
    public boolean k;
    public int l;
    public String m;
    public LinearLayout n;
    public RelativeLayout o;
    public EMTextView p;
    public int q;
    public int r;
    public int s;
    public ImageView t;
    public boolean u;
    public LinearLayout v;
    public boolean w;
    public boolean x;
    public int y;
    public int z;

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
    /* loaded from: classes3.dex */
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
        ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds256);
        this.b = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.j = B;
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = 0;
        this.r = R.color.CAM_X0110;
        this.s = R.color.CAM_X0205;
        this.t = null;
        this.u = false;
        this.v = null;
        this.w = true;
        this.x = false;
        this.y = -1;
        this.z = 0;
        this.A = false;
        this.c = context;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.t.setVisibility(8);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.t.getLayoutParams();
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.t.setLayoutParams(layoutParams);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.t.setVisibility(0);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && 8 != this.v.getVisibility()) {
            this.v.setVisibility(8);
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.v.setVisibility(0);
            this.t.setVisibility(0);
            this.n.setVisibility(0);
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            l();
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.e.setVisibility(0);
            this.d.setText(this.c.getText(R.string.obfuscated_res_0x7f0f0ae6));
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.rn
    public void d() {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (onClickListener = this.f) != null) {
            onClickListener.onClick(this.g);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            F(this.c.getResources().getString(R.string.list_no_more));
            g();
        }
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public Boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return Boolean.valueOf(this.x);
        }
        return (Boolean) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.g.getVisibility();
        }
        return invokeV.intValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.h.setVisibility(8);
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            ProgressBar progressBar = this.e;
            if (progressBar == null || progressBar.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.t.getLayoutParams();
            layoutParams.height = ej.g(this.c, R.dimen.obfuscated_res_0x7f070198);
            this.t.setLayoutParams(layoutParams);
        }
    }

    public void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.r = i;
        }
    }

    public void E(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f = onClickListener;
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            G(str, this.b);
        }
    }

    public void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.q = i;
        }
    }

    public void J(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.d.setTextSize(0, ej.g(this.c, i));
        }
    }

    public void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.g.setVisibility(i);
        }
    }

    public void N(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.h.getLayoutParams());
            layoutParams.height = i;
            this.h.setLayoutParams(layoutParams);
            this.h.setVisibility(0);
        }
    }

    public void R(int i) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048593, this, i) != null) || (linearLayout = this.v) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.height = i;
        this.v.setLayoutParams(layoutParams);
        this.v.setVisibility(0);
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            int dimension = (int) this.c.getResources().getDimension(R.dimen.tbds156);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams.topMargin = dimension;
            this.i.setLayoutParams(layoutParams);
            N(dimension);
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            SkinManager.setBackgroundResource(this.n, i);
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.z = i;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.u = z;
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.t.getLayoutParams();
            layoutParams.height = i;
            this.t.setLayoutParams(layoutParams);
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.n.getLayoutParams());
            layoutParams.height = i;
            this.n.setLayoutParams(layoutParams);
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.w = z;
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.x = z;
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.s = i;
        }
    }

    public void G(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
            this.m = str;
            this.d.setText(str);
            this.k = false;
            this.i.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.height = i;
            layoutParams.bottomMargin = 0;
            this.n.setLayoutParams(layoutParams);
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void I(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i) == null) {
            this.m = str;
            this.d.setText(str);
            this.k = true;
            this.i.setVisibility(0);
            this.j = B;
            e(TbadkCoreApplication.getInst().getSkinType());
            f(i);
            this.A = false;
        }
    }

    public void K(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, str, i) == null) {
            this.m = str;
            this.d.setText(str);
            this.k = true;
            this.i.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams.topMargin = i;
            this.i.setLayoutParams(layoutParams);
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.x) {
                this.n.setVisibility(8);
                this.d.setVisibility(8);
                this.o.setVisibility(0);
            } else {
                this.d.setVisibility(0);
                this.n.setVisibility(0);
            }
            g();
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.e.setVisibility(0);
            if (this.x) {
                this.n.setVisibility(8);
                this.d.setVisibility(8);
                this.o.setVisibility(0);
                return;
            }
            this.d.setVisibility(0);
            this.d.setText(this.c.getText(R.string.obfuscated_res_0x7f0f0ae6));
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.k = false;
            this.i.setVisibility(8);
            l();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.height = this.b;
            layoutParams.bottomMargin = 0;
            this.n.setLayoutParams(layoutParams);
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.rn
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            View inflate = LayoutInflater.from(this.c).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.g = inflate;
            this.n = (LinearLayout) inflate.findViewById(R.id.pb_more_view);
            this.o = (RelativeLayout) this.g.findViewById(R.id.pb_check_more);
            this.p = (EMTextView) this.g.findViewById(R.id.pb_check_more_text);
            this.o.setVisibility(8);
            this.d = (TextView) this.g.findViewById(R.id.pb_more_text);
            this.i = (ImageView) this.g.findViewById(R.id.no_data_image);
            if (this.w) {
                this.n.setVisibility(0);
            } else {
                this.n.setVisibility(8);
            }
            this.e = (ProgressBar) this.g.findViewById(R.id.obfuscated_res_0x7f091b9a);
            this.t = (ImageView) this.g.findViewById(R.id.pb_more_view_top_line);
            this.h = this.g.findViewById(R.id.empty_view);
            this.v = (LinearLayout) this.g.findViewById(R.id.pb_more_top_extra_view);
            p15 d = p15.d(this.p);
            d.z(R.dimen.T_X12);
            d.A(R.string.F_X01);
            d.v(R.color.CAM_X0107);
            return this.g;
        }
        return (View) invokeV.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public void e(int i) {
        int color;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            int i4 = this.y;
            if (i4 != -1) {
                i = i4;
            }
            String charSequence = this.d.getText().toString();
            boolean z = false;
            if (charSequence.equals(this.c.getText(R.string.pb_load_more))) {
                color = SkinManager.getColor(i, (int) R.color.CAM_X0109);
            } else if (charSequence.equals(this.c.getText(R.string.obfuscated_res_0x7f0f0ae6))) {
                color = SkinManager.getColor(i, (int) R.color.CAM_X0109);
            } else if (!charSequence.equals(this.c.getText(R.string.list_no_more)) && !charSequence.equals(this.c.getText(R.string.list_has_no_more)) && !charSequence.equals(this.c.getText(R.string.sub_pb_list_no_more)) && !this.u) {
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
            if (z && (i3 = this.r) != 0) {
                color = SkinManager.getColor(i, i3);
            }
            if (color == 0 && (i2 = this.q) != 0 && !z) {
                color = i2;
            }
            if (color != 0) {
                this.d.setTextColor(color);
            }
            SkinManager.setImageResource(this.t, this.s, i);
            int i5 = this.z;
            if (i5 == 0) {
                SkinManager.setBackgroundResource(this.n, R.color.CAM_X0201, i);
            } else if (i5 > 0) {
                SkinManager.setBackgroundResource(this.n, i5, i);
            }
            int i6 = this.l;
            if (i6 != 0) {
                SkinManager.setBackgroundColor(this.h, i6, i);
            }
            if (this.k) {
                SkinManager.setImageResource(this.i, this.j);
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.e.setVisibility(8);
            if (this.m != null) {
                if (this.x) {
                    this.n.setVisibility(8);
                    this.d.setVisibility(8);
                    this.o.setVisibility(0);
                    this.x = false;
                } else {
                    this.o.setVisibility(8);
                    this.n.setVisibility(0);
                    this.d.setVisibility(0);
                    this.d.setText(this.m);
                }
            } else {
                this.d.setText(this.c.getText(R.string.pb_load_more));
            }
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.h.getLayoutParams());
            layoutParams.height = i;
            this.h.setLayoutParams(layoutParams);
            this.h.setVisibility(0);
            this.v.setVisibility(8);
            this.t.setVisibility(8);
            this.n.setVisibility(8);
            this.d.setVisibility(8);
            this.e.setVisibility(8);
        }
    }
}
