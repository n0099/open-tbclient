package c.a.r0.d1.l2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.c1.e0;
import c.a.r0.d1.j;
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
public class e extends c.a.r0.d1.l2.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.d1.l2.c.f.a f15790d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.d1.l2.c.f.b f15791e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.d1.l2.c.f.e f15792f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.d1.l2.c.f.d f15793g;

    /* renamed from: h  reason: collision with root package name */
    public c f15794h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f15795i;

    /* renamed from: j  reason: collision with root package name */
    public View f15796j;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f15797e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f15798f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f15799g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f15800h;

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
            this.f15800h = eVar;
            this.f15797e = str;
            this.f15798f = i2;
            this.f15799g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13387").param("fid", this.f15797e).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.f15798f));
                UrlManager.getInstance().dealOneLink(this.f15800h.a.getPageContext(), new String[]{this.f15799g});
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(385542199, "Lc/a/r0/d1/l2/b/e$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(385542199, "Lc/a/r0/d1/l2/b/e$b;");
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
        public TextView f15801b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15802c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f15803d;

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
                cVar.f15801b = (TextView) view.findViewById(R.id.widget_title);
                cVar.f15802c = (TextView) view.findViewById(R.id.widget_content);
                cVar.f15803d = (ImageView) view.findViewById(R.id.widget_arrow);
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
    @Override // c.a.r0.d1.l2.b.a, c.a.r0.d1.l2.b.c, c.a.r0.d1.l2.c.f.a
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
                return (T) this.f15790d.a(logicField);
            }
            ?? r0 = (T) new ArrayList();
            r0.add(this.f15792f.a(logicField));
            r0.add(this.f15793g.a(logicField));
            return r0;
        }
        return (T) invokeL.objValue;
    }

    @Override // c.a.r0.d1.l2.b.a, c.a.r0.d1.l2.b.c
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            super.b(z);
            h().b(z);
            if (z) {
                this.f15796j.setVisibility(0);
                this.f15791e.p().setVisibility(0);
                this.f15790d = this.f15791e;
                this.f15792f.b().setVisibility(0);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            } else {
                this.f15791e.p().setVisibility(8);
                c.a.r0.d1.l2.c.f.a k = h().k();
                e0.b(k);
                this.f15790d = k;
                this.f15792f.b().setVisibility(8);
            }
            d(this.f15795i);
        }
    }

    @Override // c.a.r0.d1.l2.c.f.a
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            boolean z2 = z || j.d(j.a());
            this.f15790d.c(z2);
            this.f15792f.c(z2);
            this.f15793g.c(z2);
        }
    }

    @Override // c.a.r0.d1.l2.c.f.a
    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f15795i = onClickListener;
            this.f15790d.d(onClickListener);
            this.f15792f.d(onClickListener);
            this.f15793g.d(onClickListener);
        }
    }

    @Override // c.a.r0.d1.l2.b.a, c.a.r0.d1.l2.b.c
    public void e(@NonNull ThemeElement themeElement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, themeElement) == null) {
            super.e(themeElement);
            this.f15794h.f15802c.setTextColor(c.a.r0.y3.c.e(themeElement.common_color));
        }
    }

    @Override // c.a.r0.d1.l2.b.a, c.a.r0.d1.l2.c.f.a
    public void g(int i2, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
            this.f15790d.g(i2, str);
        }
    }

    @Override // c.a.r0.d1.l2.b.c
    public void i(@Nullable Integer num, @Nullable Integer num2, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, num, num2, z) == null) {
            if (!z && num != null && num2 != null) {
                String forumId = this.a.getForumId();
                String forumName = this.a.getForumName();
                int i2 = 1;
                if (num.intValue() == 2) {
                    this.f15794h.f15802c.setText(R.string.trial_opts_verify);
                    this.f15794h.a.setVisibility(0);
                    str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + forumId + "&nomenu=1";
                    i2 = 2;
                } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                    this.f15794h.f15802c.setText(String.format(this.f15785b.getString(R.string.trial_opts_progress), num2));
                    this.f15794h.a.setVisibility(0);
                    str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + forumId + "&fn=" + forumName + "&nomenu=1";
                } else {
                    this.f15794h.a.setVisibility(8);
                    str = "";
                    i2 = 0;
                }
                this.f15794h.a.setOnClickListener(new a(this, forumId, i2, str));
                return;
            }
            this.f15794h.a.setVisibility(8);
        }
    }

    @Override // c.a.r0.d1.l2.b.a, c.a.r0.d1.l2.c.f.a
    public void j(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f15790d.j(j2, j3);
        }
    }

    @Override // c.a.r0.d1.l2.b.a, c.a.r0.d1.l2.c.f.a
    public void k(@Nullable String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            this.f15790d.k(str, str2);
        }
    }

    @Override // c.a.r0.d1.l2.b.a, c.a.r0.d1.l2.c.f.a
    public void l(@NonNull LogicField logicField, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, logicField, i2) == null) {
            this.f15790d.l(logicField, i2);
        }
    }

    @Override // c.a.r0.d1.l2.b.c
    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f15794h.a : (View) invokeV.objValue;
    }

    @Override // c.a.r0.d1.l2.b.a, c.a.r0.d1.l2.b.c
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

    @Override // c.a.r0.d1.l2.b.a
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            p();
            q();
            b(false);
            r();
        }
    }

    @Override // c.a.r0.d1.l2.b.a, c.a.r0.d1.l2.c.f.a
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f15790d.onChangeSkinType(i2);
            c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(this.f15794h.a);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0201);
            c.a.q0.r.v.c.d(this.f15794h.f15801b).v(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.f15794h.f15803d, R.drawable.icon_arrow12_white, R.color.common_color_10060, null);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f15786c.findViewById(R.id.frs_info_layout).setVisibility(8);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            View findViewById = this.f15786c.findViewById(R.id.frs_header_view_forum_info_container);
            this.f15796j = findViewById;
            c.a.q0.r.v.c.d(findViewById).p(new int[]{R.color.black_alpha0, R.color.black_alpha30}, Direction.TOP);
            this.f15791e = new c.a.r0.d1.l2.c.f.b(this.a, findViewById.findViewById(R.id.forum_info));
            this.f15792f = new c.a.r0.d1.l2.c.f.e(this.a, findViewById.findViewById(R.id.forum_like_sign));
            c.a.r0.d1.l2.c.f.d g2 = h().g();
            this.f15793g = g2;
            e0.b(g2);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c a2 = c.a(this.f15786c.findViewById(R.id.widget_frs_forum_trial_operations));
            this.f15794h = a2;
            a2.a.setVisibility(8);
        }
    }
}
