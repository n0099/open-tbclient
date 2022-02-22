package c.a.u0.e1.v2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.d1.f0;
import c.a.u0.e1.c1;
import c.a.u0.e1.e1;
import c.a.u0.e1.f1;
import c.a.u0.e1.i1;
import c.a.u0.e1.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
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
/* loaded from: classes8.dex */
public class e extends c.a.u0.e1.v2.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public c.a.u0.e1.v2.c.f.a f17208d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.u0.e1.v2.c.f.b f17209e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.u0.e1.v2.c.f.e f17210f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.u0.e1.v2.c.f.d f17211g;

    /* renamed from: h  reason: collision with root package name */
    public c f17212h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f17213i;

    /* renamed from: j  reason: collision with root package name */
    public View f17214j;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17215e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f17216f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f17217g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f17218h;

        public a(e eVar, String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17218h = eVar;
            this.f17215e = str;
            this.f17216f = i2;
            this.f17217g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13387").param("fid", this.f17215e).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.f17216f));
                UrlManager.getInstance().dealOneLink(this.f17218h.a.getPageContext(), new String[]{this.f17217g});
            }
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-152362397, "Lc/a/u0/e1/v2/b/e$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-152362397, "Lc/a/u0/e1/v2/b/e$b;");
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

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17219b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17220c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f17221d;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                cVar.f17219b = (TextView) view.findViewById(f1.widget_title);
                cVar.f17220c = (TextView) view.findViewById(f1.widget_content);
                cVar.f17221d = (ImageView) view.findViewById(f1.widget_arrow);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List, T, java.util.ArrayList] */
    @Override // c.a.u0.e1.v2.b.a, c.a.u0.e1.v2.b.c, c.a.u0.e1.v2.c.f.a
    @Nullable
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            int i2 = b.a[logicField.ordinal()];
            if (i2 != 1 && i2 != 2) {
                if (i2 != 3) {
                    return (T) super.a(logicField);
                }
                return (T) this.f17208d.a(logicField);
            }
            ?? r0 = (T) new ArrayList();
            r0.add(this.f17210f.a(logicField));
            r0.add(this.f17211g.a(logicField));
            return r0;
        }
        return (T) invokeL.objValue;
    }

    @Override // c.a.u0.e1.v2.b.a, c.a.u0.e1.v2.b.c
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            super.b(z);
            h().b(z);
            if (z) {
                this.f17214j.setVisibility(0);
                this.f17209e.p().setVisibility(0);
                this.f17208d = this.f17209e;
                this.f17210f.b().setVisibility(0);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            } else {
                this.f17209e.p().setVisibility(8);
                c.a.u0.e1.v2.c.f.a k = h().k();
                f0.b(k);
                this.f17208d = k;
                this.f17210f.b().setVisibility(8);
            }
            d(this.f17213i);
        }
    }

    @Override // c.a.u0.e1.v2.c.f.a
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            boolean z2 = z || j.d(j.a());
            this.f17208d.c(z2);
            this.f17210f.c(z2);
            this.f17211g.c(z2);
        }
    }

    @Override // c.a.u0.e1.v2.c.f.a
    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f17213i = onClickListener;
            this.f17208d.d(onClickListener);
            this.f17210f.d(onClickListener);
            this.f17211g.d(onClickListener);
        }
    }

    @Override // c.a.u0.e1.v2.b.a, c.a.u0.e1.v2.b.c
    public void e(@NonNull ThemeElement themeElement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, themeElement) == null) {
            super.e(themeElement);
            this.f17212h.f17220c.setTextColor(c.a.u0.z3.c.e(themeElement.common_color));
        }
    }

    @Override // c.a.u0.e1.v2.b.a, c.a.u0.e1.v2.c.f.a
    public void g(int i2, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
            this.f17208d.g(i2, str);
        }
    }

    @Override // c.a.u0.e1.v2.b.c
    public void i(@Nullable Integer num, @Nullable Integer num2, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, num, num2, z) == null) {
            if (!z && num != null && num2 != null) {
                String forumId = this.a.getForumId();
                String forumName = this.a.getForumName();
                int i2 = 1;
                if (num.intValue() == 2) {
                    this.f17212h.f17220c.setText(i1.trial_opts_verify);
                    this.f17212h.a.setVisibility(0);
                    str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + forumId + "&nomenu=1";
                    i2 = 2;
                } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                    this.f17212h.f17220c.setText(String.format(this.f17203b.getString(i1.trial_opts_progress), num2));
                    this.f17212h.a.setVisibility(0);
                    str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + forumId + "&fn=" + forumName + "&nomenu=1";
                } else {
                    this.f17212h.a.setVisibility(8);
                    str = "";
                    i2 = 0;
                }
                this.f17212h.a.setOnClickListener(new a(this, forumId, i2, str));
                return;
            }
            this.f17212h.a.setVisibility(8);
        }
    }

    @Override // c.a.u0.e1.v2.b.a, c.a.u0.e1.v2.c.f.a
    public void j(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f17208d.j(j2, j3);
        }
    }

    @Override // c.a.u0.e1.v2.b.a, c.a.u0.e1.v2.c.f.a
    public void k(@Nullable String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            this.f17208d.k(str, str2);
        }
    }

    @Override // c.a.u0.e1.v2.b.a, c.a.u0.e1.v2.c.f.a
    public void l(@NonNull LogicField logicField, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, logicField, i2) == null) {
            this.f17208d.l(logicField, i2);
        }
    }

    @Override // c.a.u0.e1.v2.b.c
    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f17212h.a : (View) invokeV.objValue;
    }

    @Override // c.a.u0.e1.v2.b.a, c.a.u0.e1.v2.b.c
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

    @Override // c.a.u0.e1.v2.b.a
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            p();
            q();
            b(false);
            r();
        }
    }

    @Override // c.a.u0.e1.v2.b.a, c.a.u0.e1.v2.c.f.a
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f17208d.onChangeSkinType(i2);
            c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(this.f17212h.a);
            d2.n(i1.J_X05);
            d2.f(c1.CAM_X0201);
            c.a.t0.s.v.c.d(this.f17212h.f17219b).v(c1.CAM_X0105);
            WebPManager.setPureDrawable(this.f17212h.f17221d, e1.icon_arrow12_white, c1.common_color_10060, null);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f17204c.findViewById(f1.frs_info_layout).setVisibility(8);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            View findViewById = this.f17204c.findViewById(f1.frs_header_view_forum_info_container);
            this.f17214j = findViewById;
            c.a.t0.s.v.c.d(findViewById).p(new int[]{c1.black_alpha0, c1.black_alpha30}, Direction.TOP);
            this.f17209e = new c.a.u0.e1.v2.c.f.b(this.a, findViewById.findViewById(f1.forum_info));
            this.f17210f = new c.a.u0.e1.v2.c.f.e(this.a, findViewById.findViewById(f1.forum_like_sign));
            c.a.u0.e1.v2.c.f.d g2 = h().g();
            this.f17211g = g2;
            f0.b(g2);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c a2 = c.a(this.f17204c.findViewById(f1.widget_frs_forum_trial_operations));
            this.f17212h = a2;
            a2.a.setVisibility(8);
        }
    }
}
