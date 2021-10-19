package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.e;
import c.a.p0.a.f;
import c.a.p0.a.g;
import c.a.p0.a.i;
import c.a.p0.a.k;
import c.a.p0.a.v2.d;
import c.a.p0.a.v2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class SwanAppAlertDialog extends BaseDialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float FOLD_SCREEN_DIALOG_FIT_RATIO = 0.8f;
    public static final int HUNDRED = 100;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f46509g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a f46510f;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final b f46511a;

        /* renamed from: b  reason: collision with root package name */
        public final SwanAppAlertDialog f46512b;

        /* renamed from: c  reason: collision with root package name */
        public Context f46513c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f46514d;

        /* renamed from: e  reason: collision with root package name */
        public int f46515e;

        /* renamed from: com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC1739a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f46516e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f46517f;

            public View$OnClickListenerC1739a(a aVar, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46517f = aVar;
                this.f46516e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f46517f.f46512b.onButtonClick(-1);
                    this.f46517f.f46512b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.f46516e;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f46517f.f46512b, -1);
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f46518e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f46519f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f46520g;

            public b(a aVar, int i2, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46520g = aVar;
                this.f46518e = i2;
                this.f46519f = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f46520g.f46512b.onButtonClick(this.f46518e);
                    this.f46520g.f46512b.dismiss();
                    this.f46519f.onClick(this.f46520g.f46512b, this.f46518e);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f46521e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f46522f;

            public c(a aVar, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46522f = aVar;
                this.f46521e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f46522f.f46512b.onButtonClick(-2);
                    this.f46522f.f46512b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.f46521e;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f46522f.f46512b, -2);
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class d implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f46523e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f46524f;

            public d(a aVar, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46524f = aVar;
                this.f46523e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f46524f.f46512b.onButtonClick(-3);
                    this.f46524f.f46512b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.f46523e;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f46524f.f46512b, -3);
                    }
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2108235250, "Lcom/baidu/swan/apps/res/widget/dialog/SwanAppAlertDialog$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2108235250, "Lcom/baidu/swan/apps/res/widget/dialog/SwanAppAlertDialog$a;");
            }
        }

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f46514d = false;
            SwanAppAlertDialog h2 = h(context);
            this.f46512b = h2;
            h2.b(this);
            this.f46511a = new b((ViewGroup) this.f46512b.getWindow().getDecorView());
            this.f46513c = context;
            this.f46515e = context.getResources().getDimensionPixelSize(c.a.p0.a.d.aiapps_dialog_btns_height);
        }

        public final void A() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f46515e);
                layoutParams.addRule(3, f.dialog_message_content);
                this.f46511a.t.setLayoutParams(layoutParams);
            }
        }

        public a B(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, onClickListener)) == null) {
                C(this.f46513c.getText(i2), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a C(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.f46511a.f46530f.setVisibility(8);
                    if (this.f46511a.f46529e.getVisibility() == 0) {
                        this.f46511a.f46533i.setVisibility(8);
                    }
                    return this;
                }
                this.f46511a.f46530f.setVisibility(0);
                if (this.f46511a.f46529e.getVisibility() == 0) {
                    this.f46511a.f46533i.setVisibility(0);
                }
                this.f46511a.f46530f.setText(charSequence);
                this.f46511a.f46530f.setOnClickListener(new c(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a D(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                G(this.f46513c.getResources().getColor(i2));
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a E(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i2)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        G(Color.parseColor(str));
                        return this;
                    } catch (IllegalArgumentException e2) {
                        if (SwanAppAlertDialog.f46509g) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (i2 > 0) {
                    D(i2);
                }
                return this;
            }
            return (a) invokeLI.objValue;
        }

        public a F(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                this.f46511a.y = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a G(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.f46511a.x = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a H(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i2, onClickListener)) == null) {
                I(this.f46513c.getText(i2), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a I(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence, onClickListener)) == null) {
                this.f46511a.f46531g.setVisibility(0);
                if (this.f46511a.f46529e.getVisibility() == 0) {
                    this.f46511a.f46534j.setVisibility(0);
                }
                this.f46511a.f46531g.setText(charSequence);
                this.f46511a.f46531g.setOnClickListener(new d(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a J(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.f46511a.B.setVisibility(z ? 0 : 8);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a K(DialogInterface.OnCancelListener onCancelListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, onCancelListener)) == null) {
                this.f46511a.l = onCancelListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a L(DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, onDismissListener)) == null) {
                this.f46511a.m = onDismissListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a M(DialogInterface.OnKeyListener onKeyListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, onKeyListener)) == null) {
                this.f46511a.p = onKeyListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a N(DialogInterface.OnShowListener onShowListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, onShowListener)) == null) {
                this.f46511a.n = onShowListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a O(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i2, onClickListener)) == null) {
                P(this.f46513c.getText(i2), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a P(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.f46511a.f46529e.setVisibility(8);
                    if (this.f46511a.f46530f.getVisibility() == 0) {
                        this.f46511a.f46533i.setVisibility(8);
                    }
                    return this;
                }
                this.f46511a.f46529e.setVisibility(0);
                if (this.f46511a.f46530f.getVisibility() == 0) {
                    this.f46511a.f46533i.setVisibility(0);
                }
                this.f46511a.f46529e.setText(charSequence);
                this.f46511a.f46529e.setOnClickListener(new View$OnClickListenerC1739a(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a Q(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
                S(d().getColor(i2));
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a R(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, str, i2)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        S(Color.parseColor(str));
                        return this;
                    } catch (IllegalArgumentException e2) {
                        if (SwanAppAlertDialog.f46509g) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (i2 > 0) {
                    Q(i2);
                }
                return this;
            }
            return (a) invokeLI.objValue;
        }

        public a S(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
                b bVar = this.f46511a;
                bVar.w = i2;
                bVar.f46529e.setTextColor(i2);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a T(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
                this.f46511a.E = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a U(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
                this.f46511a.f46526b.setText(this.f46513c.getText(i2));
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a V(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, charSequence)) == null) {
                if (!TextUtils.isEmpty(charSequence)) {
                    this.f46511a.f46526b.setText(charSequence);
                } else {
                    f(true);
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a W(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, view)) == null) {
                this.f46511a.o.removeAllViews();
                this.f46511a.o.addView(view);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f46515e);
                layoutParams.addRule(3, f.dialog_customPanel);
                this.f46511a.t.setLayoutParams(layoutParams);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public SwanAppAlertDialog X() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                SwanAppAlertDialog c2 = c();
                if (this.f46514d) {
                    c2.getWindow().setType(2003);
                }
                try {
                    c2.show();
                } catch (WindowManager.BadTokenException e2) {
                    if (SwanAppAlertDialog.f46509g) {
                        e2.printStackTrace();
                    }
                }
                BdEventBus.Companion.getDefault().post(new c.a.p0.a.z1.b.b.a("show"));
                return c2;
            }
            return (SwanAppAlertDialog) invokeV.objValue;
        }

        @Deprecated
        public SwanAppAlertDialog Y(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) ? X() : (SwanAppAlertDialog) invokeZ.objValue;
        }

        public final void Z() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
                int color = d().getColor(c.a.p0.a.c.aiapps_dialog_title_text_color);
                int color2 = d().getColor(c.a.p0.a.c.aiapps_dialog_btn_text_color);
                int color3 = d().getColor(c.a.p0.a.c.aiapps_dialog_btn_text_color);
                int color4 = d().getColor(c.a.p0.a.c.aiapps_box_dialog_message_text_color);
                int color5 = d().getColor(c.a.p0.a.c.aiapps_dialog_gray);
                RelativeLayout relativeLayout = this.f46511a.r;
                Resources d2 = d();
                int i2 = this.f46511a.C;
                if (i2 == -1) {
                    i2 = e.aiapps_dialog_bg_white;
                }
                relativeLayout.setBackground(d2.getDrawable(i2));
                this.f46511a.f46526b.setTextColor(color);
                this.f46511a.f46527c.setTextColor(color4);
                b bVar = this.f46511a;
                TextView textView = bVar.f46529e;
                int i3 = bVar.w;
                if (i3 != color3) {
                    color3 = i3;
                }
                textView.setTextColor(color3);
                b bVar2 = this.f46511a;
                int i4 = bVar2.x;
                if (i4 != color2) {
                    bVar2.f46530f.setTextColor(i4);
                } else if (bVar2.y != -1) {
                    bVar2.f46530f.setTextColor(d().getColorStateList(this.f46511a.y));
                } else {
                    bVar2.f46530f.setTextColor(color2);
                }
                this.f46511a.f46531g.setTextColor(color2);
                if (this.f46511a.D != -1) {
                    color5 = d().getColor(this.f46511a.D);
                }
                this.f46511a.f46532h.setBackgroundColor(color5);
                this.f46511a.f46533i.setBackgroundColor(color5);
                this.f46511a.f46534j.setBackgroundColor(color5);
                this.f46511a.f46529e.setBackground(d().getDrawable(e.aiapp_alertdialog_button_day_bg_right_selector));
                this.f46511a.f46530f.setBackground(d().getDrawable(e.aiapp_alertdialog_button_day_bg_left_selector));
                this.f46511a.f46531g.setBackground(d().getDrawable(e.aiapp_alertdialog_button_day_bg_all_selector));
                TextView g2 = g();
                if (g2 != null) {
                    g2.setBackground(this.f46511a.E ? d().getDrawable(e.aiapp_alertdialog_button_day_bg_all_selector) : null);
                }
            }
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                if (n0.G()) {
                    r(this.f46513c.getResources().getDimensionPixelSize(c.a.p0.a.d.aiapps_dialog_landscape_default_width));
                    z(this.f46513c.getResources().getDimensionPixelSize(c.a.p0.a.d.aiapps_dialog_landscape_content_default_height));
                    return this;
                }
                return this;
            }
            return (a) invokeV.objValue;
        }

        public a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                ((ViewGroup.MarginLayoutParams) this.f46511a.u.getLayoutParams()).setMargins(0, 0, 0, 0);
                return this;
            }
            return (a) invokeV.objValue;
        }

        public SwanAppAlertDialog c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                this.f46512b.setCancelable(this.f46511a.k.booleanValue());
                if (this.f46511a.k.booleanValue()) {
                    this.f46512b.setCanceledOnTouchOutside(false);
                }
                this.f46512b.setOnCancelListener(this.f46511a.l);
                this.f46512b.setOnDismissListener(this.f46511a.m);
                this.f46512b.setOnShowListener(this.f46511a.n);
                DialogInterface.OnKeyListener onKeyListener = this.f46511a.p;
                if (onKeyListener != null) {
                    this.f46512b.setOnKeyListener(onKeyListener);
                }
                Z();
                b bVar = this.f46511a;
                c cVar = bVar.z;
                if (cVar != null) {
                    cVar.a(this.f46512b, bVar);
                }
                this.f46512b.b(this);
                return this.f46512b;
            }
            return (SwanAppAlertDialog) invokeV.objValue;
        }

        public Resources d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f46513c.getResources() : (Resources) invokeV.objValue;
        }

        public ViewGroup e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f46511a.o : (ViewGroup) invokeV.objValue;
        }

        public a f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048607, this, z)) == null) {
                this.f46511a.f46525a.setVisibility(z ? 8 : 0);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public TextView g() {
            InterceptResult invokeV;
            int i2;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
                TextView textView2 = this.f46511a.f46529e;
                if (textView2 == null || textView2.getVisibility() != 0) {
                    i2 = 0;
                    textView = null;
                } else {
                    textView = this.f46511a.f46529e;
                    i2 = 1;
                }
                TextView textView3 = this.f46511a.f46530f;
                if (textView3 != null && textView3.getVisibility() == 0) {
                    i2++;
                    textView = this.f46511a.f46530f;
                }
                TextView textView4 = this.f46511a.f46531g;
                if (textView4 != null && textView4.getVisibility() == 0) {
                    i2++;
                    textView = this.f46511a.f46531g;
                }
                if (i2 != 1) {
                    return null;
                }
                return textView;
            }
            return (TextView) invokeV.objValue;
        }

        public SwanAppAlertDialog h(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, context)) == null) ? new SwanAppAlertDialog(context, i.SwanAppNoTitleDialog) : (SwanAppAlertDialog) invokeL.objValue;
        }

        public a i(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048610, this, z)) == null) {
                ViewGroup.LayoutParams layoutParams = this.f46511a.u.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.f46513c.getResources().getDimensionPixelSize(c.a.p0.a.d.aiapps_dialog_content_margin_top), 0, 0);
                }
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
                this.f46511a.A.setPadding(0, 0, 0, 0);
                return this;
            }
            return (a) invokeV.objValue;
        }

        public a k(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048612, this, z)) == null) {
                this.f46511a.t.setVisibility(z ? 0 : 8);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public void l(View view, int i2, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048613, this, view, i2, onClickListener) == null) || view == null || onClickListener == null) {
                return;
            }
            view.setOnClickListener(new b(this, i2, onClickListener));
        }

        public a m(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048614, this, z)) == null) {
                this.f46511a.k = Boolean.valueOf(z);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a n(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, cVar)) == null) {
                this.f46511a.z = cVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a o(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) {
                this.f46511a.D = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a p(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i2)) == null) {
                b bVar = this.f46511a;
                bVar.C = i2;
                bVar.r.setBackgroundResource(i2);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public void q(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
                this.f46511a.r.getLayoutParams().height = i2;
                this.f46511a.r.requestLayout();
            }
        }

        public void r(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
                this.f46511a.r.getLayoutParams().width = i2;
                this.f46511a.r.requestLayout();
            }
        }

        public a s(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i2)) == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i2);
                layoutParams.addRule(2, f.btn_panel);
                this.f46511a.f46532h.setLayoutParams(layoutParams);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a t(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048621, this, z)) == null) {
                if (z) {
                    this.f46511a.f46532h.setVisibility(0);
                } else {
                    this.f46511a.f46532h.setVisibility(8);
                }
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a u(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i2)) == null) {
                this.f46511a.q.setImageResource(i2);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a v(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i2)) == null) {
                if (this.f46511a.f46528d.getVisibility() != 0) {
                    this.f46511a.f46528d.setVisibility(0);
                }
                this.f46511a.f46527c.setText(this.f46513c.getText(i2));
                A();
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a w(Spanned spanned) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, spanned)) == null) {
                if (this.f46511a.f46528d.getVisibility() != 0) {
                    this.f46511a.f46528d.setVisibility(0);
                }
                if (spanned != null) {
                    this.f46511a.f46527c.setMovementMethod(LinkMovementMethod.getInstance());
                    this.f46511a.f46527c.setText(spanned);
                    A();
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a x(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, str)) == null) {
                if (this.f46511a.f46528d.getVisibility() != 0) {
                    this.f46511a.f46528d.setVisibility(0);
                }
                if (str != null) {
                    this.f46511a.f46527c.setText(str);
                    A();
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
                this.f46511a.f46527c.setGravity(3);
                return this;
            }
            return (a) invokeV.objValue;
        }

        public a z(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048627, this, i2)) == null) {
                this.f46511a.a(i2);
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FrameLayout A;
        public View B;
        public int C;
        public int D;
        public boolean E;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f46525a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f46526b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f46527c;

        /* renamed from: d  reason: collision with root package name */
        public LinearLayout f46528d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f46529e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f46530f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f46531g;

        /* renamed from: h  reason: collision with root package name */
        public View f46532h;

        /* renamed from: i  reason: collision with root package name */
        public View f46533i;

        /* renamed from: j  reason: collision with root package name */
        public View f46534j;
        public Boolean k;
        public DialogInterface.OnCancelListener l;
        public DialogInterface.OnDismissListener m;
        public DialogInterface.OnShowListener n;
        public FrameLayout o;
        public DialogInterface.OnKeyListener p;
        public ImageView q;
        public RelativeLayout r;
        public SwanAppScrollView s;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            this.f46525a = (LinearLayout) viewGroup.findViewById(f.title_panel);
            this.f46526b = (TextView) viewGroup.findViewById(f.dialog_title);
            this.f46527c = (TextView) viewGroup.findViewById(f.dialog_message);
            this.f46528d = (LinearLayout) viewGroup.findViewById(f.dialog_message_content);
            this.f46529e = (TextView) viewGroup.findViewById(f.positive_button);
            this.f46530f = (TextView) viewGroup.findViewById(f.negative_button);
            this.f46531g = (TextView) viewGroup.findViewById(f.neutral_button);
            this.f46533i = viewGroup.findViewById(f.divider3);
            this.f46534j = viewGroup.findViewById(f.divider4);
            this.o = (FrameLayout) viewGroup.findViewById(f.dialog_custom_content);
            this.q = (ImageView) viewGroup.findViewById(f.dialog_icon);
            this.r = (RelativeLayout) viewGroup.findViewById(f.searchbox_alert_dialog);
            this.f46532h = viewGroup.findViewById(f.divider2);
            this.s = (SwanAppScrollView) viewGroup.findViewById(f.message_scrollview);
            this.t = (LinearLayout) viewGroup.findViewById(f.btn_panel);
            this.u = viewGroup.findViewById(f.dialog_customPanel);
            this.A = (FrameLayout) viewGroup.findViewById(f.dialog_root);
            this.B = viewGroup.findViewById(f.nightmode_mask);
            if (d.k() || d.l()) {
                int dimensionPixelSize = this.f46527c.getResources().getDimensionPixelSize(c.a.p0.a.d.aiapps_dialog_text_padding);
                this.f46527c.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            SwanAppActivity activity = c.a.p0.a.g1.f.V().getActivity();
            if (c.a.p0.t.e.d() && c.a.p0.a.v2.f.d(activity) && c.a.p0.t.e.e(activity)) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (c.a.p0.t.e.a(activity) * 0.8f), -2);
                layoutParams.gravity = 17;
                this.r.setLayoutParams(layoutParams);
            }
            int color = this.v.getResources().getColor(c.a.p0.a.c.aiapps_dialog_btn_text_color);
            this.w = color;
            this.x = color;
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.s.setMaxHeight(i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(SwanAppAlertDialog swanAppAlertDialog, b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(909455375, "Lcom/baidu/swan/apps/res/widget/dialog/SwanAppAlertDialog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(909455375, "Lcom/baidu/swan/apps/res/widget/dialog/SwanAppAlertDialog;");
                return;
            }
        }
        f46509g = k.f7085a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppAlertDialog(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init();
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f46510f = aVar;
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.dismiss();
            BdEventBus.Companion.getDefault().post(new c.a.p0.a.z1.b.b.a("hide"));
        }
    }

    public a getBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f46510f : (a) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setContentView(g.aiapps_alert_dialog);
            getWindow().setLayout(-1, -1);
        }
    }

    public void onButtonClick(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
        }
    }

    public void setMessage(String str) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (aVar = this.f46510f) == null) {
            return;
        }
        aVar.x(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), onCancelListener};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (DialogInterface.OnCancelListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppAlertDialog(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        init();
    }
}
