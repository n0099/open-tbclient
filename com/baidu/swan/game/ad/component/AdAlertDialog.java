package com.baidu.swan.game.ad.component;

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
import b.a.p0.h.i.d;
import b.a.p0.h.i.e;
import b.a.p0.h.i.f;
import b.a.p0.h.i.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AdAlertDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALIDATE_RES_ID = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f45329e;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b f45330a;

        /* renamed from: b  reason: collision with root package name */
        public final AdAlertDialog f45331b;

        /* renamed from: c  reason: collision with root package name */
        public Context f45332c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f45333d;

        /* renamed from: e  reason: collision with root package name */
        public int f45334e;

        /* renamed from: com.baidu.swan.game.ad.component.AdAlertDialog$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1738a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f45335e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f45336f;

            public View$OnClickListenerC1738a(a aVar, DialogInterface.OnClickListener onClickListener) {
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
                this.f45336f = aVar;
                this.f45335e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f45336f.f45331b.onButtonClick(-1);
                    this.f45336f.f45331b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.f45335e;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f45336f.f45331b, -1);
                    }
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f45337e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f45338f;

            public b(a aVar, DialogInterface.OnClickListener onClickListener) {
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
                this.f45338f = aVar;
                this.f45337e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f45338f.f45331b.onButtonClick(-2);
                    this.f45338f.f45331b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.f45337e;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f45338f.f45331b, -2);
                    }
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-223187122, "Lcom/baidu/swan/game/ad/component/AdAlertDialog$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-223187122, "Lcom/baidu/swan/game/ad/component/AdAlertDialog$a;");
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
            this.f45330a = null;
            this.f45333d = false;
            AdAlertDialog e2 = e(context);
            this.f45331b = e2;
            e2.a(this);
            this.f45332c = context;
            this.f45334e = context.getResources().getDimensionPixelSize(b.a.p0.h.i.c.swan_ad_dialog_btns_height);
            if (this.f45331b.getWindow() != null) {
                this.f45330a = new b((ViewGroup) this.f45331b.getWindow().getDecorView());
            }
        }

        public AdAlertDialog a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f45331b.setCancelable(this.f45330a.k.booleanValue());
                if (this.f45330a.k.booleanValue()) {
                    this.f45331b.setCanceledOnTouchOutside(false);
                }
                this.f45331b.setOnCancelListener(this.f45330a.l);
                this.f45331b.setOnDismissListener(this.f45330a.m);
                this.f45331b.setOnShowListener(this.f45330a.n);
                DialogInterface.OnKeyListener onKeyListener = this.f45330a.p;
                if (onKeyListener != null) {
                    this.f45331b.setOnKeyListener(onKeyListener);
                }
                q();
                b bVar = this.f45330a;
                c cVar = bVar.z;
                if (cVar != null) {
                    cVar.a(this.f45331b, bVar);
                }
                this.f45331b.a(this);
                return this.f45331b;
            }
            return (AdAlertDialog) invokeV.objValue;
        }

        public Resources b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45332c.getResources() : (Resources) invokeV.objValue;
        }

        public a c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f45330a.f45339a.setVisibility(z ? 8 : 0);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public TextView d() {
            InterceptResult invokeV;
            int i2;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                TextView textView2 = this.f45330a.f45343e;
                if (textView2 == null || textView2.getVisibility() != 0) {
                    i2 = 0;
                    textView = null;
                } else {
                    textView = this.f45330a.f45343e;
                    i2 = 1;
                }
                TextView textView3 = this.f45330a.f45344f;
                if (textView3 != null && textView3.getVisibility() == 0) {
                    i2++;
                    textView = this.f45330a.f45344f;
                }
                TextView textView4 = this.f45330a.f45345g;
                if (textView4 != null && textView4.getVisibility() == 0) {
                    i2++;
                    textView = this.f45330a.f45345g;
                }
                if (i2 != 1) {
                    return null;
                }
                return textView;
            }
            return (TextView) invokeV.objValue;
        }

        public AdAlertDialog e(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? new AdAlertDialog(context, h.AdNoTitleDialog) : (AdAlertDialog) invokeL.objValue;
        }

        public a f(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048581, this, i2, i3, i4, i5)) == null) {
                this.f45330a.A.setPadding(i2, i3, i4, i5);
                return this;
            }
            return (a) invokeIIII.objValue;
        }

        public a g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                if (this.f45330a.f45342d.getVisibility() != 0) {
                    this.f45330a.f45342d.setVisibility(0);
                }
                if (str != null) {
                    this.f45330a.f45341c.setText(str);
                    h();
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f45334e);
                layoutParams.addRule(3, e.dialog_message_content);
                this.f45330a.t.setLayoutParams(layoutParams);
            }
        }

        public a i(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, onClickListener)) == null) {
                j(this.f45332c.getText(i2), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a j(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.f45330a.f45344f.setVisibility(8);
                    if (this.f45330a.f45343e.getVisibility() == 0) {
                        this.f45330a.f45347i.setVisibility(8);
                    }
                    return this;
                }
                this.f45330a.f45344f.setVisibility(0);
                if (this.f45330a.f45343e.getVisibility() == 0) {
                    this.f45330a.f45347i.setVisibility(0);
                }
                this.f45330a.f45344f.setText(charSequence);
                this.f45330a.f45344f.setOnClickListener(new b(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a k(DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, onDismissListener)) == null) {
                this.f45330a.m = onDismissListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a l(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i2, onClickListener)) == null) {
                m(this.f45332c.getText(i2), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a m(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.f45330a.f45343e.setVisibility(8);
                    if (this.f45330a.f45344f.getVisibility() == 0) {
                        this.f45330a.f45347i.setVisibility(8);
                    }
                    return this;
                }
                this.f45330a.f45343e.setVisibility(0);
                if (this.f45330a.f45344f.getVisibility() == 0) {
                    this.f45330a.f45347i.setVisibility(0);
                }
                this.f45330a.f45343e.setText(charSequence);
                this.f45330a.f45343e.setOnClickListener(new View$OnClickListenerC1738a(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a n(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                o(b().getColor(i2));
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a o(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
                b bVar = this.f45330a;
                bVar.w = i2;
                bVar.f45343e.setTextColor(i2);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public AdAlertDialog p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                AdAlertDialog a2 = a();
                if (this.f45333d && a2.getWindow() != null) {
                    a2.getWindow().setType(2003);
                }
                try {
                    a2.show();
                } catch (WindowManager.BadTokenException unused) {
                }
                return a2;
            }
            return (AdAlertDialog) invokeV.objValue;
        }

        public final void q() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                int color = b().getColor(b.a.p0.h.i.b.swan_ad_dialog_title_text_color);
                int color2 = b().getColor(b.a.p0.h.i.b.swan_ad_dialog_btn_text_color);
                int color3 = b().getColor(b.a.p0.h.i.b.swan_ad_dialog_btn_text_color);
                int color4 = b().getColor(b.a.p0.h.i.b.swan_ad_box_dialog_message_text_color);
                int color5 = b().getColor(b.a.p0.h.i.b.swan_ad_dialog_gray);
                RelativeLayout relativeLayout = this.f45330a.r;
                Resources b2 = b();
                int i2 = this.f45330a.C;
                if (i2 == -1) {
                    i2 = d.swan_ad_dialog_bg_white;
                }
                relativeLayout.setBackground(b2.getDrawable(i2));
                this.f45330a.f45340b.setTextColor(color);
                this.f45330a.f45341c.setTextColor(color4);
                b bVar = this.f45330a;
                TextView textView = bVar.f45343e;
                int i3 = bVar.w;
                if (i3 != color3) {
                    color3 = i3;
                }
                textView.setTextColor(color3);
                b bVar2 = this.f45330a;
                int i4 = bVar2.x;
                if (i4 != color2) {
                    bVar2.f45344f.setTextColor(i4);
                } else {
                    int i5 = bVar2.y;
                    if (i5 != -1) {
                        bVar2.f45344f.setTextColor(AppCompatResources.getColorStateList(this.f45332c, i5));
                    } else {
                        bVar2.f45344f.setTextColor(color2);
                    }
                }
                this.f45330a.f45345g.setTextColor(color2);
                if (this.f45330a.D != -1) {
                    color5 = b().getColor(this.f45330a.D);
                }
                this.f45330a.f45346h.setBackgroundColor(color5);
                this.f45330a.f45347i.setBackgroundColor(color5);
                this.f45330a.j.setBackgroundColor(color5);
                this.f45330a.f45343e.setBackground(b().getDrawable(d.swan_ad_alertdialog_button_day_bg_right_selector));
                this.f45330a.f45344f.setBackground(b().getDrawable(d.swan_ad_alertdialog_button_day_bg_left_selector));
                this.f45330a.f45345g.setBackground(b().getDrawable(d.swan_ad_alertdialog_button_day_bg_all_selector));
                TextView d2 = d();
                if (d2 != null) {
                    d2.setBackground(this.f45330a.E ? b().getDrawable(d.swan_ad_alertdialog_button_day_bg_all_selector) : null);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FrameLayout A;
        public View B;
        public int C;
        public int D;
        public boolean E;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f45339a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f45340b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f45341c;

        /* renamed from: d  reason: collision with root package name */
        public LinearLayout f45342d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f45343e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f45344f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f45345g;

        /* renamed from: h  reason: collision with root package name */
        public View f45346h;

        /* renamed from: i  reason: collision with root package name */
        public View f45347i;
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
            this.f45339a = (LinearLayout) viewGroup.findViewById(e.title_panel);
            this.f45340b = (TextView) viewGroup.findViewById(e.dialog_title);
            this.f45341c = (TextView) viewGroup.findViewById(e.dialog_message);
            this.f45342d = (LinearLayout) viewGroup.findViewById(e.dialog_message_content);
            this.f45343e = (TextView) viewGroup.findViewById(e.positive_button);
            this.f45344f = (TextView) viewGroup.findViewById(e.negative_button);
            this.f45345g = (TextView) viewGroup.findViewById(e.neutral_button);
            this.f45347i = viewGroup.findViewById(e.divider3);
            this.j = viewGroup.findViewById(e.divider4);
            this.o = (FrameLayout) viewGroup.findViewById(e.dialog_custom_content);
            this.q = (ImageView) viewGroup.findViewById(e.dialog_icon);
            this.r = (RelativeLayout) viewGroup.findViewById(e.searchbox_alert_dialog);
            this.f45346h = viewGroup.findViewById(e.divider2);
            this.s = (AdScrollView) viewGroup.findViewById(e.message_scrollview);
            this.t = (LinearLayout) viewGroup.findViewById(e.btn_panel);
            this.u = viewGroup.findViewById(e.dialog_customPanel);
            this.A = (FrameLayout) viewGroup.findViewById(e.dialog_root);
            this.B = viewGroup.findViewById(e.nightmode_mask);
            int color = this.v.getResources().getColor(b.a.p0.h.i.b.swan_ad_dialog_btn_text_color);
            this.w = color;
            this.x = color;
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(AdAlertDialog adAlertDialog, b bVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdAlertDialog(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init();
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f45329e = aVar;
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.dismiss();
        }
    }

    public a getBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f45329e : (a) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setContentView(f.ng_game_alert_dialog);
            Window window = getWindow();
            if (window != null) {
                window.setLayout(-1, -1);
            }
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
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (aVar = this.f45329e) == null) {
            return;
        }
        aVar.g(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), onCancelListener};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (DialogInterface.OnCancelListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdAlertDialog(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init();
    }
}
