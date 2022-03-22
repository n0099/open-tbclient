package c.a.a0.l0.q;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.dialog.BoxScrollView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c extends c.a.a0.l0.q.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b a;

        /* renamed from: b  reason: collision with root package name */
        public final c f1473b;

        /* renamed from: c  reason: collision with root package name */
        public Context f1474c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1475d;

        /* renamed from: e  reason: collision with root package name */
        public int f1476e;

        /* renamed from: c.a.a0.l0.q.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class View$OnClickListenerC0062a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogInterface.OnClickListener a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f1477b;

            public View$OnClickListenerC0062a(a aVar, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1477b = aVar;
                this.a = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f1477b.f1473b.c(-1);
                    this.f1477b.f1473b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.a;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f1477b.f1473b, -1);
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogInterface.OnClickListener a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f1478b;

            public b(a aVar, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1478b = aVar;
                this.a = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f1478b.f1473b.c(-2);
                    this.f1478b.f1473b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.a;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f1478b.f1473b, -2);
                    }
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1003971114, "Lc/a/a0/l0/q/c$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1003971114, "Lc/a/a0/l0/q/c$a;");
            }
        }

        public a(Context context) {
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
            this.f1475d = false;
            c f2 = f(context);
            this.f1473b = f2;
            f2.d(this);
            this.a = new b((ViewGroup) this.f1473b.getWindow().getDecorView());
            this.f1474c = context;
            this.f1476e = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704c1);
        }

        public c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f1473b.setCancelable(this.a.k.booleanValue());
                if (this.a.k.booleanValue()) {
                    this.f1473b.setCanceledOnTouchOutside(false);
                }
                this.f1473b.setOnCancelListener(this.a.l);
                this.f1473b.setOnDismissListener(this.a.m);
                this.f1473b.setOnShowListener(this.a.n);
                DialogInterface.OnKeyListener onKeyListener = this.a.q;
                if (onKeyListener != null) {
                    this.f1473b.setOnKeyListener(onKeyListener);
                }
                s();
                b bVar = this.a;
                InterfaceC0063c interfaceC0063c = bVar.y;
                if (interfaceC0063c != null) {
                    interfaceC0063c.a(this.f1473b, bVar);
                }
                this.f1473b.d(this);
                return this.f1473b;
            }
            return (c) invokeV.objValue;
        }

        public Resources b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1474c.getResources() : (Resources) invokeV.objValue;
        }

        public ViewGroup c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.p : (ViewGroup) invokeV.objValue;
        }

        public a d(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.a.a.setVisibility(z ? 8 : 0);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public TextView e() {
            InterceptResult invokeV;
            int i;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                TextView textView2 = this.a.f1482e;
                if (textView2 == null || textView2.getVisibility() != 0) {
                    i = 0;
                    textView = null;
                } else {
                    textView = this.a.f1482e;
                    i = 1;
                }
                TextView textView3 = this.a.f1483f;
                if (textView3 != null && textView3.getVisibility() == 0) {
                    i++;
                    textView = this.a.f1483f;
                }
                TextView textView4 = this.a.f1484g;
                if (textView4 != null && textView4.getVisibility() == 0) {
                    i++;
                    textView = this.a.f1484g;
                }
                if (i != 1) {
                    return null;
                }
                return textView;
            }
            return (TextView) invokeV.objValue;
        }

        public c f(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? new c(context, R.style.obfuscated_res_0x7f100132) : (c) invokeL.objValue;
        }

        public a g(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.a.u.setVisibility(z ? 0 : 8);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public void h(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                if (z) {
                    this.a.f1485h.setVisibility(0);
                } else {
                    this.a.f1485h.setVisibility(8);
                }
            }
        }

        public a i(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.a.r.setImageResource(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a j(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, onClickListener)) == null) {
                k(this.f1474c.getText(i), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a k(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.a.f1483f.setVisibility(8);
                    if (this.a.f1482e.getVisibility() == 0) {
                        this.a.i.setVisibility(8);
                    }
                    return this;
                }
                this.a.f1483f.setVisibility(0);
                if (this.a.f1482e.getVisibility() == 0) {
                    this.a.i.setVisibility(0);
                }
                this.a.f1483f.setText(charSequence);
                this.a.f1483f.setOnClickListener(new b(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a l(DialogInterface.OnCancelListener onCancelListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, onCancelListener)) == null) {
                this.a.l = onCancelListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a m(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, onClickListener)) == null) {
                n(this.f1474c.getText(i), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a n(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.a.f1482e.setVisibility(8);
                    if (this.a.f1483f.getVisibility() == 0) {
                        this.a.i.setVisibility(8);
                    }
                    return this;
                }
                this.a.f1482e.setVisibility(0);
                if (this.a.f1483f.getVisibility() == 0) {
                    this.a.i.setVisibility(0);
                }
                this.a.f1482e.setText(charSequence);
                this.a.f1482e.setOnClickListener(new View$OnClickListenerC0062a(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a o(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
                this.a.f1479b.setText(this.f1474c.getText(i));
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a p(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, charSequence)) == null) {
                if (!TextUtils.isEmpty(charSequence)) {
                    this.a.f1479b.setText(charSequence);
                } else {
                    d(true);
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a q(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view)) == null) {
                this.a.p.removeAllViews();
                this.a.p.addView(view);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f1476e);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0907a1);
                this.a.u.setLayoutParams(layoutParams);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public c r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                c a = a();
                if (this.f1475d) {
                    a.getWindow().setType(2003);
                }
                try {
                    a.show();
                } catch (WindowManager.BadTokenException unused) {
                }
                return a;
            }
            return (c) invokeV.objValue;
        }

        public final void s() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
                int color = b().getColor(R.color.obfuscated_res_0x7f0607ff);
                int color2 = b().getColor(R.color.obfuscated_res_0x7f0607fc);
                int color3 = b().getColor(R.color.obfuscated_res_0x7f0607fc);
                int color4 = b().getColor(R.color.obfuscated_res_0x7f0607ef);
                int color5 = b().getColor(R.color.obfuscated_res_0x7f0607fd);
                this.a.s.setBackground(b().getDrawable(R.drawable.obfuscated_res_0x7f080d9d));
                this.a.f1479b.setTextColor(color);
                this.a.f1480c.setTextColor(color4);
                b bVar = this.a;
                TextView textView = bVar.f1482e;
                int i = bVar.w;
                if (i != -1) {
                    color3 = i;
                }
                textView.setTextColor(color3);
                b bVar2 = this.a;
                TextView textView2 = bVar2.f1483f;
                int i2 = bVar2.x;
                if (i2 == -1) {
                    i2 = color2;
                }
                textView2.setTextColor(i2);
                this.a.f1484g.setTextColor(color2);
                this.a.f1485h.setBackgroundColor(color5);
                this.a.i.setBackgroundColor(color5);
                this.a.j.setBackgroundColor(color5);
                this.a.f1482e.setBackground(b().getDrawable(R.drawable.obfuscated_res_0x7f080d9c));
                this.a.f1483f.setBackground(b().getDrawable(R.drawable.obfuscated_res_0x7f080d9a));
                this.a.f1484g.setBackgroundColor(b().getColor(R.color.obfuscated_res_0x7f0607fa));
                TextView e2 = e();
                if (e2 != null) {
                    e2.setBackground(b().getDrawable(R.drawable.obfuscated_res_0x7f080d98));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f1479b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f1480c;

        /* renamed from: d  reason: collision with root package name */
        public LinearLayout f1481d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f1482e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f1483f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f1484g;

        /* renamed from: h  reason: collision with root package name */
        public View f1485h;
        public View i;
        public View j;
        public Boolean k;
        public DialogInterface.OnCancelListener l;
        public DialogInterface.OnDismissListener m;
        public DialogInterface.OnShowListener n;
        public View o;
        public FrameLayout p;
        public DialogInterface.OnKeyListener q;
        public ImageView r;
        public RelativeLayout s;
        public BoxScrollView t;
        public LinearLayout u;
        public ViewGroup v;
        public int w;
        public int x;
        public InterfaceC0063c y;

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
            this.w = -1;
            this.x = -1;
            this.v = viewGroup;
            this.a = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0914e2);
            this.f1479b = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907b6);
            this.f1480c = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907ac);
            this.f1481d = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0914a7);
            this.f1482e = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0918a9);
            this.f1483f = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091535);
            this.f1484g = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091542);
            this.i = viewGroup.findViewById(R.id.obfuscated_res_0x7f0907e4);
            this.j = viewGroup.findViewById(R.id.obfuscated_res_0x7f0907e5);
            this.o = viewGroup.findViewById(R.id.obfuscated_res_0x7f0907a1);
            this.p = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907a2);
            this.r = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907a6);
            this.s = (RelativeLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f091c52);
            this.f1485h = viewGroup.findViewById(R.id.obfuscated_res_0x7f0907e3);
            this.t = (BoxScrollView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091409);
            this.u = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0914a5);
        }
    }

    /* renamed from: c.a.a0.l0.q.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0063c {
        void a(c cVar, b bVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, int i) {
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
        b();
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (a) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d05a9);
            getWindow().setLayout(-1, -1);
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
        }
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.a = aVar;
        }
    }
}
