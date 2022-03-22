package c.a.p0.f1.l2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.c1.e0;
import c.a.p0.f1.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ThemeElement;
/* loaded from: classes2.dex */
public class e extends c.a.p0.f1.l2.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.f1.l2.c.f.a f14198d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.f1.l2.c.f.b f14199e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.f1.l2.c.f.e f14200f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.f1.l2.c.f.d f14201g;

    /* renamed from: h  reason: collision with root package name */
    public c f14202h;
    public View.OnClickListener i;
    public View j;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f14203b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f14204c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f14205d;

        public a(e eVar, String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14205d = eVar;
            this.a = str;
            this.f14203b = i;
            this.f14204c = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13387").param("fid", this.a).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.f14203b));
                UrlManager.getInstance().dealOneLink(this.f14205d.a.getPageContext(), new String[]{this.f14204c});
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1923571315, "Lc/a/p0/f1/l2/b/e$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1923571315, "Lc/a/p0/f1/l2/b/e$b;");
                    return;
                }
            }
            int[] iArr = new int[LogicField.values().length];
            a = iArr;
            try {
                iArr[LogicField.LIKE_BTN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LogicField.SIGN_BTN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[LogicField.SPEED_ICON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[LogicField.SERVICE_AREA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[LogicField.TOP_AREA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[LogicField.ROUND_CORNER_STYLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[LogicField.TOP_DIVIDER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[LogicField.BANNER_AND_BOTTOM_VIEW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14206b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14207c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f14208d;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @NonNull
        public static c a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view)) == null) {
                c cVar = new c();
                cVar.a = view;
                cVar.f14206b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092473);
                cVar.f14207c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09246a);
                cVar.f14208d = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f092468);
                return cVar;
            }
            return (c) invokeL.objValue;
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List, T, java.util.ArrayList] */
    @Override // c.a.p0.f1.l2.b.a, c.a.p0.f1.l2.b.c, c.a.p0.f1.l2.c.f.a
    @Nullable
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            int i = b.a[logicField.ordinal()];
            if (i != 1 && i != 2) {
                if (i != 3) {
                    return (T) super.a(logicField);
                }
                return (T) this.f14198d.a(logicField);
            }
            ?? r0 = (T) new ArrayList();
            r0.add(this.f14200f.a(logicField));
            r0.add(this.f14201g.a(logicField));
            return r0;
        }
        return (T) invokeL.objValue;
    }

    @Override // c.a.p0.f1.l2.b.a, c.a.p0.f1.l2.b.c
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            super.b(z);
            h().b(z);
            if (z) {
                this.j.setVisibility(0);
                this.f14199e.p().setVisibility(0);
                this.f14198d = this.f14199e;
                this.f14200f.b().setVisibility(0);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            } else {
                this.f14199e.p().setVisibility(8);
                c.a.p0.f1.l2.c.f.a k = h().k();
                e0.b(k);
                this.f14198d = k;
                this.f14200f.b().setVisibility(8);
            }
            d(this.i);
        }
    }

    @Override // c.a.p0.f1.l2.c.f.a
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            boolean z2 = z || j.d(j.a());
            this.f14198d.c(z2);
            this.f14200f.c(z2);
            this.f14201g.c(z2);
        }
    }

    @Override // c.a.p0.f1.l2.c.f.a
    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.i = onClickListener;
            this.f14198d.d(onClickListener);
            this.f14200f.d(onClickListener);
            this.f14201g.d(onClickListener);
        }
    }

    @Override // c.a.p0.f1.l2.b.a, c.a.p0.f1.l2.b.c
    public void e(@NonNull ThemeElement themeElement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, themeElement) == null) {
            super.e(themeElement);
            this.f14202h.f14207c.setTextColor(c.a.p0.a4.c.e(themeElement.common_color));
        }
    }

    @Override // c.a.p0.f1.l2.b.a, c.a.p0.f1.l2.c.f.a
    public void g(int i, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
            this.f14198d.g(i, str);
        }
    }

    @Override // c.a.p0.f1.l2.b.c
    public void i(@Nullable Integer num, @Nullable Integer num2, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, num, num2, z) == null) {
            if (!z && num != null && num2 != null) {
                String c2 = this.a.c();
                String a2 = this.a.a();
                int i = 1;
                if (num.intValue() == 2) {
                    this.f14202h.f14207c.setText(R.string.obfuscated_res_0x7f0f141e);
                    this.f14202h.a.setVisibility(0);
                    str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + c2 + "&nomenu=1";
                    i = 2;
                } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                    this.f14202h.f14207c.setText(String.format(this.f14193b.getString(R.string.obfuscated_res_0x7f0f141d), num2));
                    this.f14202h.a.setVisibility(0);
                    str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + c2 + "&fn=" + a2 + "&nomenu=1";
                } else {
                    this.f14202h.a.setVisibility(8);
                    str = "";
                    i = 0;
                }
                this.f14202h.a.setOnClickListener(new a(this, c2, i, str));
                return;
            }
            this.f14202h.a.setVisibility(8);
        }
    }

    @Override // c.a.p0.f1.l2.b.a, c.a.p0.f1.l2.c.f.a
    public void j(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f14198d.j(j, j2);
        }
    }

    @Override // c.a.p0.f1.l2.b.a, c.a.p0.f1.l2.c.f.a
    public void k(@Nullable String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            this.f14198d.k(str, str2);
        }
    }

    @Override // c.a.p0.f1.l2.b.a, c.a.p0.f1.l2.c.f.a
    public void l(@NonNull LogicField logicField, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, logicField, i) == null) {
            this.f14198d.l(logicField, i);
        }
    }

    @Override // c.a.p0.f1.l2.b.c
    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f14202h.a : (View) invokeV.objValue;
    }

    @Override // c.a.p0.f1.l2.b.a, c.a.p0.f1.l2.b.c
    public int n(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, logicField)) == null) {
            switch (b.a[logicField.ordinal()]) {
                case 4:
                case 5:
                case 6:
                case 7:
                    return 8;
                case 8:
                    return 0;
                default:
                    return super.n(logicField);
            }
        }
        return invokeL.intValue;
    }

    @Override // c.a.p0.f1.l2.b.a
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            p();
            q();
            b(false);
            r();
        }
    }

    @Override // c.a.p0.f1.l2.b.a, c.a.p0.f1.l2.c.f.a
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.f14198d.onChangeSkinType(i);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f14202h.a);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0201);
            c.a.o0.r.v.c.d(this.f14202h.f14206b).v(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.f14202h.f14208d, R.drawable.icon_arrow12_white, R.color.common_color_10060, null);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f14194c.findViewById(R.id.obfuscated_res_0x7f090b3a).setVisibility(8);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            View findViewById = this.f14194c.findViewById(R.id.obfuscated_res_0x7f090b31);
            this.j = findViewById;
            c.a.o0.r.v.c.d(findViewById).p(new int[]{R.color.black_alpha0, R.color.black_alpha30}, Direction.TOP);
            this.f14199e = new c.a.p0.f1.l2.c.f.b(this.a, findViewById.findViewById(R.id.obfuscated_res_0x7f090a4d));
            this.f14200f = new c.a.p0.f1.l2.c.f.e(this.a, findViewById.findViewById(R.id.obfuscated_res_0x7f090a5b));
            c.a.p0.f1.l2.c.f.d g2 = h().g();
            this.f14201g = g2;
            e0.b(g2);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c a2 = c.a(this.f14194c.findViewById(R.id.obfuscated_res_0x7f09246d));
            this.f14202h = a2;
            a2.a.setVisibility(8);
        }
    }
}
