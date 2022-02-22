package c.a.u0.e1.v2.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.u0.e1.c1;
import c.a.u0.e1.d1;
import c.a.u0.e1.e1;
import c.a.u0.e1.f1;
import c.a.u0.e1.g1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e extends c.a.u0.e1.v2.c.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int o;
    public static final int p;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public c.a.u0.e1.v2.c.f.b f17231j;
    public EMTextView k;
    public c l;
    public c.a.u0.e1.v2.c.f.e m;
    public boolean n;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f17232e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17232e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17232e.f17224d.onClick(view);
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-123733246, "Lc/a/u0/e1/v2/c/e$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-123733246, "Lc/a/u0/e1/v2/c/e$b;");
                    return;
                }
            }
            int[] iArr = new int[LogicField.values().length];
            a = iArr;
            try {
                iArr[LogicField.FOLD_TITLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f17233b;

        /* renamed from: c  reason: collision with root package name */
        public MessageRedDotView f17234c;

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
                cVar.f17233b = (ImageView) view.findViewById(f1.more);
                cVar.f17234c = (MessageRedDotView) view.findViewById(f1.red_dot);
                return cVar;
            }
            return (c) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-764373696, "Lc/a/u0/e1/v2/c/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-764373696, "Lc/a/u0/e1/v2/c/e;");
                return;
            }
        }
        o = UtilHelper.getDimenPixelSize(d1.tbds204);
        p = UtilHelper.getDimenPixelSize(d1.tbds666);
        q = UtilHelper.getDimenPixelSize(d1.M_H_X013);
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.u0.e1.v2.c.a, c.a.u0.e1.v2.c.c
    @Nullable
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            if (b.a[logicField.ordinal()] != 1) {
                return (T) super.a(logicField);
            }
            return (T) this.k;
        }
        return (T) invokeL.objValue;
    }

    @Override // c.a.u0.e1.v2.c.a, c.a.u0.e1.v2.c.c
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.n = z;
            if (z) {
                this.f17231j.p().setVisibility(8);
                this.m.b().setAlpha(0.0f);
                return;
            }
            this.f17231j.p().setVisibility(0);
            this.m.b().setAlpha(1.0f);
        }
    }

    @Override // c.a.u0.e1.v2.c.a, c.a.u0.e1.v2.c.c
    public void c(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
            super.c(f2);
            this.f17231j.p().setAlpha(1.0f - f2);
            float abs = Math.abs(1.0f - (2.0f * f2));
            this.l.a.setAlpha(abs);
            if (this.n) {
                this.m.e(false, this.f17229i);
                this.m.b().setAlpha(f2);
            } else {
                this.m.b().setAlpha(abs);
            }
            ViewGroup.LayoutParams layoutParams = this.f17225e.getLayoutParams();
            int i2 = o;
            layoutParams.height = (int) (i2 - ((i2 - q) * f2));
            this.f17225e.requestLayout();
        }
    }

    @Override // c.a.u0.e1.v2.c.a, c.a.u0.e1.v2.c.c
    public void d(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                this.l.f17234c.refresh(String.valueOf(i2), false);
                this.l.f17234c.setVisibility(0);
                return;
            }
            this.l.f17234c.setVisibility(8);
        }
    }

    @Override // c.a.u0.e1.v2.c.a, c.a.u0.e1.v2.c.c
    @Nullable
    public c.a.u0.e1.v2.c.f.d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (c.a.u0.e1.v2.c.f.d) invokeV.objValue;
    }

    @Override // c.a.u0.e1.v2.c.a, c.a.u0.e1.v2.c.c
    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            super.h(z);
            int i2 = z ? 8 : 0;
            this.l.a.setVisibility(i2);
            this.f17231j.p().setVisibility(this.n ? 8 : i2);
        }
    }

    @Override // c.a.u0.e1.v2.c.a, c.a.u0.e1.v2.c.c
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f17225e.getHeight() - q : invokeV.intValue;
    }

    @Override // c.a.u0.e1.v2.c.a, c.a.u0.e1.v2.c.c
    @Nullable
    public c.a.u0.e1.v2.c.f.a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f17231j : (c.a.u0.e1.v2.c.f.a) invokeV.objValue;
    }

    @Override // c.a.u0.e1.v2.c.a
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            WebPManager.setPureDrawable(this.l.f17233b, e1.ic_icon_pure_topbar_more_black, z ? c1.CAM_X0101 : c1.CAM_X0106, null);
            if (this.n) {
                return;
            }
            this.m.e(z, this.f17229i);
        }
    }

    @Override // c.a.u0.e1.v2.c.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f17225e.setFixedHeight(false);
            o();
            p();
            q();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            FrameLayout frameLayout = (FrameLayout) this.f17225e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, g1.frs_forum_info_container, (View.OnClickListener) null);
            this.f17231j = new c.a.u0.e1.v2.c.f.b(this.a, frameLayout.findViewById(f1.forum_info));
            this.k = (EMTextView) frameLayout.findViewById(f1.fold_title);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.m = new c.a.u0.e1.v2.c.f.e(this.a, (ViewGroup) this.f17225e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, g1.frs_forum_like_sign, (View.OnClickListener) null));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c a2 = c.a((ViewGroup) this.f17225e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, g1.frs_forum_more, (View.OnClickListener) null));
            this.l = a2;
            WebPManager.setPureDrawable(a2.f17233b, e1.ic_icon_pure_topbar_more_black, c1.white_alpha100, null);
            d(0, false);
            this.l.a.setTag(f1.click_view_tag, LogicField.MORE_BTN);
            this.l.a.setOnClickListener(new a(this));
        }
    }
}
