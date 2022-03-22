package c.a.n0.h.a.b;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.component.AdScrollView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public C0651a a;

    /* renamed from: c.a.n0.h.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0651a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b a;

        /* renamed from: b  reason: collision with root package name */
        public final a f8290b;

        /* renamed from: c  reason: collision with root package name */
        public Context f8291c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f8292d;

        /* renamed from: e  reason: collision with root package name */
        public int f8293e;

        /* renamed from: c.a.n0.h.a.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class View$OnClickListenerC0652a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogInterface.OnClickListener a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ C0651a f8294b;

            public View$OnClickListenerC0652a(C0651a c0651a, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0651a, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8294b = c0651a;
                this.a = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f8294b.f8290b.b(-1);
                    this.f8294b.f8290b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.a;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f8294b.f8290b, -1);
                    }
                }
            }
        }

        /* renamed from: c.a.n0.h.a.b.a$a$b */
        /* loaded from: classes.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogInterface.OnClickListener a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ C0651a f8295b;

            public b(C0651a c0651a, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0651a, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8295b = c0651a;
                this.a = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f8295b.f8290b.b(-2);
                    this.f8295b.f8290b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.a;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f8295b.f8290b, -2);
                    }
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-248070938, "Lc/a/n0/h/a/b/a$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-248070938, "Lc/a/n0/h/a/b/a$a;");
            }
        }

        public C0651a(Context context) {
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
            this.a = null;
            this.f8292d = false;
            a e2 = e(context);
            this.f8290b = e2;
            e2.c(this);
            this.f8291c = context;
            this.f8293e = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0705f3);
            if (this.f8290b.getWindow() != null) {
                this.a = new b((ViewGroup) this.f8290b.getWindow().getDecorView());
            }
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f8290b.setCancelable(this.a.k.booleanValue());
                if (this.a.k.booleanValue()) {
                    this.f8290b.setCanceledOnTouchOutside(false);
                }
                this.f8290b.setOnCancelListener(this.a.l);
                this.f8290b.setOnDismissListener(this.a.m);
                this.f8290b.setOnShowListener(this.a.n);
                DialogInterface.OnKeyListener onKeyListener = this.a.p;
                if (onKeyListener != null) {
                    this.f8290b.setOnKeyListener(onKeyListener);
                }
                q();
                b bVar = this.a;
                c cVar = bVar.z;
                if (cVar != null) {
                    cVar.a(this.f8290b, bVar);
                }
                this.f8290b.c(this);
                return this.f8290b;
            }
            return (a) invokeV.objValue;
        }

        public Resources b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f8291c.getResources() : (Resources) invokeV.objValue;
        }

        public C0651a c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.a.a.setVisibility(z ? 8 : 0);
                return this;
            }
            return (C0651a) invokeZ.objValue;
        }

        public TextView d() {
            InterceptResult invokeV;
            int i;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                TextView textView2 = this.a.f8299e;
                if (textView2 == null || textView2.getVisibility() != 0) {
                    i = 0;
                    textView = null;
                } else {
                    textView = this.a.f8299e;
                    i = 1;
                }
                TextView textView3 = this.a.f8300f;
                if (textView3 != null && textView3.getVisibility() == 0) {
                    i++;
                    textView = this.a.f8300f;
                }
                TextView textView4 = this.a.f8301g;
                if (textView4 != null && textView4.getVisibility() == 0) {
                    i++;
                    textView = this.a.f8301g;
                }
                if (i != 1) {
                    return null;
                }
                return textView;
            }
            return (TextView) invokeV.objValue;
        }

        public a e(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? new a(context, R.style.obfuscated_res_0x7f100000) : (a) invokeL.objValue;
        }

        public C0651a f(int i, int i2, int i3, int i4) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048581, this, i, i2, i3, i4)) == null) {
                this.a.A.setPadding(i, i2, i3, i4);
                return this;
            }
            return (C0651a) invokeIIII.objValue;
        }

        public C0651a g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                if (this.a.f8298d.getVisibility() != 0) {
                    this.a.f8298d.setVisibility(0);
                }
                if (str != null) {
                    this.a.f8297c.setText(str);
                    h();
                }
                return this;
            }
            return (C0651a) invokeL.objValue;
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f8293e);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0907ad);
                this.a.t.setLayoutParams(layoutParams);
            }
        }

        public C0651a i(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, onClickListener)) == null) {
                j(this.f8291c.getText(i), onClickListener);
                return this;
            }
            return (C0651a) invokeIL.objValue;
        }

        public C0651a j(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.a.f8300f.setVisibility(8);
                    if (this.a.f8299e.getVisibility() == 0) {
                        this.a.i.setVisibility(8);
                    }
                    return this;
                }
                this.a.f8300f.setVisibility(0);
                if (this.a.f8299e.getVisibility() == 0) {
                    this.a.i.setVisibility(0);
                }
                this.a.f8300f.setText(charSequence);
                this.a.f8300f.setOnClickListener(new b(this, onClickListener));
                return this;
            }
            return (C0651a) invokeLL.objValue;
        }

        public C0651a k(DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, onDismissListener)) == null) {
                this.a.m = onDismissListener;
                return this;
            }
            return (C0651a) invokeL.objValue;
        }

        public C0651a l(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i, onClickListener)) == null) {
                m(this.f8291c.getText(i), onClickListener);
                return this;
            }
            return (C0651a) invokeIL.objValue;
        }

        public C0651a m(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.a.f8299e.setVisibility(8);
                    if (this.a.f8300f.getVisibility() == 0) {
                        this.a.i.setVisibility(8);
                    }
                    return this;
                }
                this.a.f8299e.setVisibility(0);
                if (this.a.f8300f.getVisibility() == 0) {
                    this.a.i.setVisibility(0);
                }
                this.a.f8299e.setText(charSequence);
                this.a.f8299e.setOnClickListener(new View$OnClickListenerC0652a(this, onClickListener));
                return this;
            }
            return (C0651a) invokeLL.objValue;
        }

        public C0651a n(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
                o(b().getColor(i));
                return this;
            }
            return (C0651a) invokeI.objValue;
        }

        public C0651a o(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
                b bVar = this.a;
                bVar.w = i;
                bVar.f8299e.setTextColor(i);
                return this;
            }
            return (C0651a) invokeI.objValue;
        }

        public a p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                a a = a();
                if (this.f8292d && a.getWindow() != null) {
                    a.getWindow().setType(2003);
                }
                try {
                    a.show();
                } catch (WindowManager.BadTokenException unused) {
                }
                return a;
            }
            return (a) invokeV.objValue;
        }

        public final void q() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                int color = b().getColor(R.color.obfuscated_res_0x7f060a12);
                int color2 = b().getColor(R.color.obfuscated_res_0x7f060a0f);
                int color3 = b().getColor(R.color.obfuscated_res_0x7f060a0f);
                int color4 = b().getColor(R.color.obfuscated_res_0x7f060a0e);
                int color5 = b().getColor(R.color.obfuscated_res_0x7f060a10);
                RelativeLayout relativeLayout = this.a.r;
                Resources b2 = b();
                int i = this.a.C;
                if (i == -1) {
                    i = R.drawable.obfuscated_res_0x7f0810ee;
                }
                relativeLayout.setBackground(b2.getDrawable(i));
                this.a.f8296b.setTextColor(color);
                this.a.f8297c.setTextColor(color4);
                b bVar = this.a;
                TextView textView = bVar.f8299e;
                int i2 = bVar.w;
                if (i2 != color3) {
                    color3 = i2;
                }
                textView.setTextColor(color3);
                b bVar2 = this.a;
                int i3 = bVar2.x;
                if (i3 != color2) {
                    bVar2.f8300f.setTextColor(i3);
                } else {
                    int i4 = bVar2.y;
                    if (i4 != -1) {
                        bVar2.f8300f.setTextColor(AppCompatResources.getColorStateList(this.f8291c, i4));
                    } else {
                        bVar2.f8300f.setTextColor(color2);
                    }
                }
                this.a.f8301g.setTextColor(color2);
                if (this.a.D != -1) {
                    color5 = b().getColor(this.a.D);
                }
                this.a.f8302h.setBackgroundColor(color5);
                this.a.i.setBackgroundColor(color5);
                this.a.j.setBackgroundColor(color5);
                this.a.f8299e.setBackground(b().getDrawable(R.drawable.obfuscated_res_0x7f0810ec));
                this.a.f8300f.setBackground(b().getDrawable(R.drawable.obfuscated_res_0x7f0810eb));
                this.a.f8301g.setBackground(b().getDrawable(R.drawable.obfuscated_res_0x7f0810ea));
                TextView d2 = d();
                if (d2 != null) {
                    d2.setBackground(this.a.E ? b().getDrawable(R.drawable.obfuscated_res_0x7f0810ea) : null);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FrameLayout A;
        public View B;
        public int C;
        public int D;
        public boolean E;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f8296b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f8297c;

        /* renamed from: d  reason: collision with root package name */
        public LinearLayout f8298d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f8299e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f8300f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f8301g;

        /* renamed from: h  reason: collision with root package name */
        public View f8302h;
        public View i;
        public View j;
        public Boolean k;
        public DialogInterface.OnCancelListener l;
        public DialogInterface.OnDismissListener m;
        public DialogInterface.OnShowListener n;
        public FrameLayout o;
        public DialogInterface.OnKeyListener p;
        public ImageView q;
        public RelativeLayout r;
        public AdScrollView s;
        public LinearLayout t;
        public View u;
        public ViewGroup v;
        public int w;
        public int x;
        public int y;
        public c z;

        public b(ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = Boolean.TRUE;
            this.y = -1;
            this.C = -1;
            this.D = -1;
            this.E = true;
            this.v = viewGroup;
            this.a = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f092050);
            this.f8296b = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907b6);
            this.f8297c = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907ac);
            this.f8298d = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907ad);
            this.f8299e = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0918a9);
            this.f8300f = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091535);
            this.f8301g = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091542);
            this.i = viewGroup.findViewById(R.id.obfuscated_res_0x7f0907e4);
            this.j = viewGroup.findViewById(R.id.obfuscated_res_0x7f0907e5);
            this.o = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907a2);
            this.q = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907a6);
            this.r = (RelativeLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f091c52);
            this.f8302h = viewGroup.findViewById(R.id.obfuscated_res_0x7f0907e3);
            this.s = (AdScrollView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091409);
            this.t = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f090429);
            this.u = viewGroup.findViewById(R.id.obfuscated_res_0x7f0907a1);
            this.A = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907b3);
            this.B = viewGroup.findViewById(R.id.obfuscated_res_0x7f09157c);
            int color = this.v.getResources().getColor(R.color.obfuscated_res_0x7f060a0f);
            this.w = color;
            this.x = color;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(a aVar, b bVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, int i) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d0616);
            Window window = getWindow();
            if (window != null) {
                window.setLayout(-1, -1);
            }
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
        }
    }

    public void c(C0651a c0651a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c0651a) == null) {
            this.a = c0651a;
        }
    }

    public void d(String str) {
        C0651a c0651a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (c0651a = this.a) == null) {
            return;
        }
        c0651a.g(str);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.dismiss();
        }
    }
}
