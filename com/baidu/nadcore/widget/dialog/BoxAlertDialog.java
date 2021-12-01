package com.baidu.nadcore.widget.dialog;

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
import c.a.b0.h0.o;
import c.a.b0.h0.p;
import c.a.b0.h0.q;
import c.a.b0.h0.r;
import c.a.b0.h0.s;
import c.a.b0.h0.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class BoxAlertDialog extends BaseDialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HUNDRED = 100;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f37859e;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b a;

        /* renamed from: b  reason: collision with root package name */
        public final BoxAlertDialog f37860b;

        /* renamed from: c  reason: collision with root package name */
        public Context f37861c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f37862d;

        /* renamed from: e  reason: collision with root package name */
        public int f37863e;

        /* renamed from: com.baidu.nadcore.widget.dialog.BoxAlertDialog$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1752a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f37864e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f37865f;

            public View$OnClickListenerC1752a(a aVar, DialogInterface.OnClickListener onClickListener) {
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
                this.f37865f = aVar;
                this.f37864e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f37865f.f37860b.onButtonClick(-1);
                    this.f37865f.f37860b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.f37864e;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f37865f.f37860b, -1);
                    }
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f37866e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f37867f;

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
                this.f37867f = aVar;
                this.f37866e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f37867f.f37860b.onButtonClick(-2);
                    this.f37867f.f37860b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.f37866e;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f37867f.f37860b, -2);
                    }
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-221798116, "Lcom/baidu/nadcore/widget/dialog/BoxAlertDialog$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-221798116, "Lcom/baidu/nadcore/widget/dialog/BoxAlertDialog$a;");
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
            this.f37862d = false;
            BoxAlertDialog f2 = f(context);
            this.f37860b = f2;
            f2.a(this);
            this.a = new b((ViewGroup) this.f37860b.getWindow().getDecorView());
            this.f37861c = context;
            this.f37863e = context.getResources().getDimensionPixelSize(p.nad_dialog_btns_height);
        }

        public BoxAlertDialog a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f37860b.setCancelable(this.a.f37877k.booleanValue());
                if (this.a.f37877k.booleanValue()) {
                    this.f37860b.setCanceledOnTouchOutside(false);
                }
                this.f37860b.setOnCancelListener(this.a.l);
                this.f37860b.setOnDismissListener(this.a.m);
                this.f37860b.setOnShowListener(this.a.n);
                DialogInterface.OnKeyListener onKeyListener = this.a.q;
                if (onKeyListener != null) {
                    this.f37860b.setOnKeyListener(onKeyListener);
                }
                u();
                b bVar = this.a;
                c cVar = bVar.y;
                if (cVar != null) {
                    cVar.a(this.f37860b, bVar);
                }
                this.f37860b.a(this);
                return this.f37860b;
            }
            return (BoxAlertDialog) invokeV.objValue;
        }

        public Resources b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37861c.getResources() : (Resources) invokeV.objValue;
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
            int i2;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                TextView textView2 = this.a.f37871e;
                if (textView2 == null || textView2.getVisibility() != 0) {
                    i2 = 0;
                    textView = null;
                } else {
                    textView = this.a.f37871e;
                    i2 = 1;
                }
                TextView textView3 = this.a.f37872f;
                if (textView3 != null && textView3.getVisibility() == 0) {
                    i2++;
                    textView = this.a.f37872f;
                }
                TextView textView4 = this.a.f37873g;
                if (textView4 != null && textView4.getVisibility() == 0) {
                    i2++;
                    textView = this.a.f37873g;
                }
                if (i2 != 1) {
                    return null;
                }
                return textView;
            }
            return (TextView) invokeV.objValue;
        }

        public BoxAlertDialog f(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? new BoxAlertDialog(context, u.NadNoTitleDialog) : (BoxAlertDialog) invokeL.objValue;
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
                    this.a.f37874h.setVisibility(0);
                } else {
                    this.a.f37874h.setVisibility(8);
                }
            }
        }

        public a i(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                this.a.r.setImageResource(i2);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                if (this.a.f37870d.getVisibility() != 0) {
                    this.a.f37870d.setVisibility(0);
                }
                if (str != null) {
                    this.a.f37869c.setText(str);
                    k();
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f37863e);
                layoutParams.addRule(3, r.nad_dialog_message_content);
                this.a.u.setLayoutParams(layoutParams);
            }
        }

        public a l(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i2, onClickListener)) == null) {
                m(this.f37861c.getText(i2), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a m(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.a.f37872f.setVisibility(8);
                    if (this.a.f37871e.getVisibility() == 0) {
                        this.a.f37875i.setVisibility(8);
                    }
                    return this;
                }
                this.a.f37872f.setVisibility(0);
                if (this.a.f37871e.getVisibility() == 0) {
                    this.a.f37875i.setVisibility(0);
                }
                this.a.f37872f.setText(charSequence);
                this.a.f37872f.setOnClickListener(new b(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a n(DialogInterface.OnCancelListener onCancelListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, onCancelListener)) == null) {
                this.a.l = onCancelListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a o(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i2, onClickListener)) == null) {
                p(this.f37861c.getText(i2), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a p(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.a.f37871e.setVisibility(8);
                    if (this.a.f37872f.getVisibility() == 0) {
                        this.a.f37875i.setVisibility(8);
                    }
                    return this;
                }
                this.a.f37871e.setVisibility(0);
                if (this.a.f37872f.getVisibility() == 0) {
                    this.a.f37875i.setVisibility(0);
                }
                this.a.f37871e.setText(charSequence);
                this.a.f37871e.setOnClickListener(new View$OnClickListenerC1752a(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a q(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
                this.a.f37868b.setText(this.f37861c.getText(i2));
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a r(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, charSequence)) == null) {
                if (!TextUtils.isEmpty(charSequence)) {
                    this.a.f37868b.setText(charSequence);
                } else {
                    d(true);
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a s(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, view)) == null) {
                this.a.p.removeAllViews();
                this.a.p.addView(view);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f37863e);
                layoutParams.addRule(3, r.dialog_customPanel);
                this.a.u.setLayoutParams(layoutParams);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public BoxAlertDialog t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                BoxAlertDialog a = a();
                if (this.f37862d) {
                    a.getWindow().setType(2003);
                }
                try {
                    a.show();
                } catch (WindowManager.BadTokenException unused) {
                }
                return a;
            }
            return (BoxAlertDialog) invokeV.objValue;
        }

        public final void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
                int color = b().getColor(o.nad_dialog_title_text_color);
                int color2 = b().getColor(o.nad_dialog_btn_text_color);
                int color3 = b().getColor(o.nad_dialog_btn_text_color);
                int color4 = b().getColor(o.nad_box_dialog_message_text_color);
                int color5 = b().getColor(o.nad_dialog_gray);
                this.a.s.setBackground(b().getDrawable(q.nad_custom_dialog_corner_bg));
                this.a.f37868b.setTextColor(color);
                this.a.f37869c.setTextColor(color4);
                b bVar = this.a;
                TextView textView = bVar.f37871e;
                int i2 = bVar.w;
                if (i2 != -1) {
                    color3 = i2;
                }
                textView.setTextColor(color3);
                b bVar2 = this.a;
                TextView textView2 = bVar2.f37872f;
                int i3 = bVar2.x;
                if (i3 == -1) {
                    i3 = color2;
                }
                textView2.setTextColor(i3);
                this.a.f37873g.setTextColor(color2);
                this.a.f37874h.setBackgroundColor(color5);
                this.a.f37875i.setBackgroundColor(color5);
                this.a.f37876j.setBackgroundColor(color5);
                this.a.f37871e.setBackground(b().getDrawable(q.nad_custom_dialog_btn_right_corner_bg_selector));
                this.a.f37872f.setBackground(b().getDrawable(q.nad_custom_dialog_btn_left_corner_bg_selector));
                this.a.f37873g.setBackgroundColor(b().getColor(o.nad_custom_dialog_btn_bg_selector));
                TextView e2 = e();
                if (e2 != null) {
                    e2.setBackground(b().getDrawable(q.nad_custom_dialog_btn_corner_bg_selector));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f37868b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f37869c;

        /* renamed from: d  reason: collision with root package name */
        public LinearLayout f37870d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f37871e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f37872f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f37873g;

        /* renamed from: h  reason: collision with root package name */
        public View f37874h;

        /* renamed from: i  reason: collision with root package name */
        public View f37875i;

        /* renamed from: j  reason: collision with root package name */
        public View f37876j;

        /* renamed from: k  reason: collision with root package name */
        public Boolean f37877k;
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
        public c y;

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
            this.f37877k = Boolean.TRUE;
            this.w = -1;
            this.x = -1;
            this.v = viewGroup;
            this.a = (LinearLayout) viewGroup.findViewById(r.nad_title_panel);
            this.f37868b = (TextView) viewGroup.findViewById(r.dialog_title);
            this.f37869c = (TextView) viewGroup.findViewById(r.dialog_message);
            this.f37870d = (LinearLayout) viewGroup.findViewById(r.nad_dialog_message_content);
            this.f37871e = (TextView) viewGroup.findViewById(r.positive_button);
            this.f37872f = (TextView) viewGroup.findViewById(r.negative_button);
            this.f37873g = (TextView) viewGroup.findViewById(r.neutral_button);
            this.f37875i = viewGroup.findViewById(r.divider3);
            this.f37876j = viewGroup.findViewById(r.divider4);
            this.o = viewGroup.findViewById(r.dialog_customPanel);
            this.p = (FrameLayout) viewGroup.findViewById(r.dialog_custom_content);
            this.r = (ImageView) viewGroup.findViewById(r.dialog_icon);
            this.s = (RelativeLayout) viewGroup.findViewById(r.searchbox_alert_dialog);
            this.f37874h = viewGroup.findViewById(r.divider2);
            this.t = (BoxScrollView) viewGroup.findViewById(r.message_scrollview);
            this.u = (LinearLayout) viewGroup.findViewById(r.nad_btn_panel);
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(BoxAlertDialog boxAlertDialog, b bVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoxAlertDialog(Context context) {
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
            this.f37859e = aVar;
        }
    }

    public a getBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37859e : (a) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setContentView(s.nad_custom_dialog_layout);
            getWindow().setLayout(-1, -1);
        }
    }

    public void onButtonClick(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
        }
    }

    public void setMessage(String str) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (aVar = this.f37859e) == null) {
            return;
        }
        aVar.j(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoxAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
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
    public BoxAlertDialog(Context context, int i2) {
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
