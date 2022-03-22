package c.a.p0.f1.l2.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class e extends c.a.p0.f1.l2.c.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int o;
    public static final int p;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.f1.l2.c.f.b j;
    public EMTextView k;
    public c l;
    public c.a.p0.f1.l2.c.f.e m;
    public boolean n;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.f14211d.onClick(view);
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1952200466, "Lc/a/p0/f1/l2/c/e$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1952200466, "Lc/a/p0/f1/l2/c/e$b;");
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

    /* loaded from: classes2.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f14216b;

        /* renamed from: c  reason: collision with root package name */
        public MessageRedDotView f14217c;

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
                cVar.f14216b = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091438);
                cVar.f14217c = (MessageRedDotView) view.findViewById(R.id.obfuscated_res_0x7f091a29);
                return cVar;
            }
            return (c) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(221025616, "Lc/a/p0/f1/l2/c/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(221025616, "Lc/a/p0/f1/l2/c/e;");
                return;
            }
        }
        o = UtilHelper.getDimenPixelSize(R.dimen.tbds204);
        p = UtilHelper.getDimenPixelSize(R.dimen.tbds666);
        q = UtilHelper.getDimenPixelSize(R.dimen.M_H_X013);
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.p0.f1.l2.c.a, c.a.p0.f1.l2.c.c
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

    @Override // c.a.p0.f1.l2.c.a, c.a.p0.f1.l2.c.c
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.n = z;
            if (z) {
                this.j.p().setVisibility(8);
                this.m.b().setAlpha(0.0f);
                return;
            }
            this.j.p().setVisibility(0);
            this.m.b().setAlpha(1.0f);
        }
    }

    @Override // c.a.p0.f1.l2.c.a, c.a.p0.f1.l2.c.c
    public void c(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
            super.c(f2);
            this.j.p().setAlpha(1.0f - f2);
            float abs = Math.abs(1.0f - (2.0f * f2));
            this.l.a.setAlpha(abs);
            if (this.n) {
                this.m.e(false, this.i);
                this.m.b().setAlpha(f2);
            } else {
                this.m.b().setAlpha(abs);
            }
            ViewGroup.LayoutParams layoutParams = this.f14212e.getLayoutParams();
            int i = o;
            layoutParams.height = (int) (i - ((i - q) * f2));
            this.f14212e.requestLayout();
        }
    }

    @Override // c.a.p0.f1.l2.c.a, c.a.p0.f1.l2.c.c
    public void d(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z) {
                this.l.f14217c.g(String.valueOf(i), false);
                this.l.f14217c.setVisibility(0);
                return;
            }
            this.l.f14217c.setVisibility(8);
        }
    }

    @Override // c.a.p0.f1.l2.c.a, c.a.p0.f1.l2.c.c
    @Nullable
    public c.a.p0.f1.l2.c.f.d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (c.a.p0.f1.l2.c.f.d) invokeV.objValue;
    }

    @Override // c.a.p0.f1.l2.c.a, c.a.p0.f1.l2.c.c
    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            super.h(z);
            int i = z ? 8 : 0;
            this.l.a.setVisibility(i);
            this.j.p().setVisibility(this.n ? 8 : i);
        }
    }

    @Override // c.a.p0.f1.l2.c.a, c.a.p0.f1.l2.c.c
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14212e.getHeight() - q : invokeV.intValue;
    }

    @Override // c.a.p0.f1.l2.c.a, c.a.p0.f1.l2.c.c
    @Nullable
    public c.a.p0.f1.l2.c.f.a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : (c.a.p0.f1.l2.c.f.a) invokeV.objValue;
    }

    @Override // c.a.p0.f1.l2.c.a
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            WebPManager.setPureDrawable(this.l.f14216b, R.drawable.obfuscated_res_0x7f080623, z ? R.color.CAM_X0101 : R.color.CAM_X0106, null);
            if (this.n) {
                return;
            }
            this.m.e(z, this.i);
        }
    }

    @Override // c.a.p0.f1.l2.c.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f14212e.setFixedHeight(false);
            o();
            p();
            q();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            FrameLayout frameLayout = (FrameLayout) this.f14212e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d0310, (View.OnClickListener) null);
            this.j = new c.a.p0.f1.l2.c.f.b(this.a, frameLayout.findViewById(R.id.obfuscated_res_0x7f090a4d));
            this.k = (EMTextView) frameLayout.findViewById(R.id.obfuscated_res_0x7f0909f6);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.m = new c.a.p0.f1.l2.c.f.e(this.a, (ViewGroup) this.f14212e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0311, (View.OnClickListener) null));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c a2 = c.a((ViewGroup) this.f14212e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0312, (View.OnClickListener) null));
            this.l = a2;
            WebPManager.setPureDrawable(a2.f14216b, R.drawable.obfuscated_res_0x7f080623, R.color.white_alpha100, null);
            d(0, false);
            this.l.a.setTag(R.id.obfuscated_res_0x7f090659, LogicField.MORE_BTN);
            this.l.a.setOnClickListener(new a(this));
        }
    }
}
