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
import com.repackage.fo;
import com.repackage.gs4;
import com.repackage.mi;
/* loaded from: classes3.dex */
public class PbListView extends fo {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: D */
    public static final int new_pic_emotion_03 = 2131234376;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public final int b;
    public final int c;
    public final int d;
    public Context e;
    public TextView f;
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
    public boolean y;
    public boolean z;

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
        this.b = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.c = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds256);
        this.d = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds104);
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.l = new_pic_emotion_03;
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
        this.y = true;
        this.z = false;
        this.A = -1;
        this.B = 0;
        this.C = false;
        this.e = context;
    }

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.t = i;
        }
    }

    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.h = onClickListener;
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            D(str, this.d);
        }
    }

    public void D(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i) == null) {
            this.o = str;
            this.f.setText(str);
            this.m = false;
            this.k.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.p.getLayoutParams();
            layoutParams.height = i;
            layoutParams.bottomMargin = 0;
            this.p.setLayoutParams(layoutParams);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.s = i;
        }
    }

    public void F(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) {
            this.o = str;
            this.f.setText(str);
            this.m = true;
            this.k.setVisibility(0);
            this.l = new_pic_emotion_03;
            d(TbadkCoreApplication.getInst().getSkinType());
            e(i);
            this.C = false;
        }
    }

    public void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f.setTextSize(0, mi.f(this.e, i));
        }
    }

    public void H(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, str, i) == null) {
            this.o = str;
            this.f.setText(str);
            this.m = true;
            this.k.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.topMargin = i;
            this.k.setLayoutParams(layoutParams);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void I(String str, @DrawableRes int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i, i2) == null) {
            this.o = str;
            this.f.setText(str);
            this.m = true;
            this.l = i;
            this.k.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.topMargin = i2;
            layoutParams.bottomMargin = this.b;
            this.k.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.p.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.bottomMargin = this.c;
            this.p.setLayoutParams(layoutParams2);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || 8 == this.x.getVisibility()) {
            return;
        }
        this.x.setVisibility(8);
    }

    public void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.i.setVisibility(i);
        }
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.j.getLayoutParams());
            layoutParams.height = i;
            this.j.setLayoutParams(layoutParams);
            this.j.setVisibility(0);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.z) {
                this.p.setVisibility(8);
                this.f.setVisibility(8);
                this.q.setVisibility(0);
            } else {
                this.f.setVisibility(0);
                this.p.setVisibility(0);
            }
            f();
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.g.setVisibility(0);
            if (this.z) {
                this.p.setVisibility(8);
                this.f.setVisibility(8);
                this.q.setVisibility(0);
                return;
            }
            this.f.setVisibility(0);
            this.f.setText(this.e.getText(R.string.obfuscated_res_0x7f0f0a34));
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.x.setVisibility(0);
            this.v.setVisibility(0);
            this.p.setVisibility(0);
            this.f.setVisibility(0);
            this.g.setVisibility(0);
            j();
        }
    }

    public void P(int i) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || (linearLayout = this.x) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.height = i;
        this.x.setLayoutParams(layoutParams);
        this.x.setVisibility(0);
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.g.setVisibility(0);
            this.f.setText(this.e.getText(R.string.obfuscated_res_0x7f0f0a34));
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.repackage.fo
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            View inflate = LayoutInflater.from(this.e).inflate(R.layout.obfuscated_res_0x7f0d05f4, (ViewGroup) null);
            this.i = inflate;
            this.p = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091716);
            this.q = (RelativeLayout) this.i.findViewById(R.id.obfuscated_res_0x7f0916b4);
            this.r = (EMTextView) this.i.findViewById(R.id.obfuscated_res_0x7f0916b6);
            this.q.setVisibility(8);
            this.f = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091713);
            this.k = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f09159c);
            if (this.y) {
                this.p.setVisibility(0);
            } else {
                this.p.setVisibility(8);
            }
            this.g = (ProgressBar) this.i.findViewById(R.id.obfuscated_res_0x7f091975);
            this.v = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f091725);
            this.j = this.i.findViewById(R.id.obfuscated_res_0x7f0908c2);
            this.x = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f091715);
            gs4 d = gs4.d(this.r);
            d.z(R.dimen.T_X12);
            d.A(R.string.F_X01);
            d.v(R.color.CAM_X0107);
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.fo
    public void c() {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (onClickListener = this.h) == null) {
            return;
        }
        onClickListener.onClick(this.i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(int i) {
        int color;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            int i4 = this.A;
            if (i4 != -1) {
                i = i4;
            }
            String charSequence = this.f.getText().toString();
            boolean z = false;
            if (charSequence.equals(this.e.getText(R.string.obfuscated_res_0x7f0f0dc3))) {
                color = SkinManager.getColor(i, (int) R.color.CAM_X0109);
            } else if (charSequence.equals(this.e.getText(R.string.obfuscated_res_0x7f0f0a34))) {
                color = SkinManager.getColor(i, (int) R.color.CAM_X0109);
            } else if (!charSequence.equals(this.e.getText(R.string.obfuscated_res_0x7f0f09ee)) && !charSequence.equals(this.e.getText(R.string.obfuscated_res_0x7f0f09ec)) && !charSequence.equals(this.e.getText(R.string.obfuscated_res_0x7f0f1206)) && !this.w) {
                if (charSequence.equals(this.e.getText(R.string.obfuscated_res_0x7f0f09ef))) {
                    color = SkinManager.getColor(i, (int) R.color.CAM_X0110);
                } else {
                    color = (charSequence.equals(this.e.getText(R.string.obfuscated_res_0x7f0f09eb)) || charSequence.equals(this.e.getText(R.string.obfuscated_res_0x7f0f0f4d))) ? SkinManager.getColor(i, (int) R.color.CAM_X0109) : 0;
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
                this.f.setTextColor(color);
            }
            SkinManager.setImageResource(this.v, this.u, i);
            int i5 = this.B;
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
                SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
            }
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            int dimension = (int) this.e.getResources().getDimension(R.dimen.tbds156);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.topMargin = dimension;
            this.k.setLayoutParams(layoutParams);
            L(dimension);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.g.setVisibility(8);
            if (this.o != null) {
                if (this.z) {
                    this.p.setVisibility(8);
                    this.f.setVisibility(8);
                    this.q.setVisibility(0);
                    this.z = false;
                } else {
                    this.q.setVisibility(8);
                    this.p.setVisibility(0);
                    this.f.setVisibility(0);
                    this.f.setText(this.o);
                }
            } else {
                this.f.setText(this.e.getText(R.string.obfuscated_res_0x7f0f0dc3));
            }
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            C(this.e.getResources().getString(R.string.obfuscated_res_0x7f0f09ee));
            f();
        }
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public Boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? Boolean.valueOf(this.z) : (Boolean) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.j.setVisibility(8);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.m = false;
            this.k.setVisibility(8);
            j();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.p.getLayoutParams();
            layoutParams.height = this.d;
            layoutParams.bottomMargin = 0;
            this.p.setLayoutParams(layoutParams);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.j.getLayoutParams());
            layoutParams.height = i;
            this.j.setLayoutParams(layoutParams);
            this.j.setVisibility(0);
            this.x.setVisibility(8);
            this.v.setVisibility(8);
            this.p.setVisibility(8);
            this.f.setVisibility(8);
            this.g.setVisibility(8);
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ProgressBar progressBar = this.g;
            return progressBar != null && progressBar.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            SkinManager.setBackgroundResource(this.p, i);
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.B = i;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.w = z;
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.v.getLayoutParams();
            layoutParams.height = i;
            this.v.setLayoutParams(layoutParams);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.i.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.p.getLayoutParams());
            layoutParams.height = i;
            this.p.setLayoutParams(layoutParams);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.z = z;
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.v.getLayoutParams();
            layoutParams.height = mi.f(this.e, R.dimen.obfuscated_res_0x7f070198);
            this.v.setLayoutParams(layoutParams);
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.u = i;
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.v.setVisibility(8);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.v.getLayoutParams();
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.v.setLayoutParams(layoutParams);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.v.setVisibility(0);
        }
    }
}
