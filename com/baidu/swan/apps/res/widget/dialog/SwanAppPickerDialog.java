package com.baidu.swan.apps.res.widget.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f;
import c.a.p0.a.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class SwanAppPickerDialog extends BaseDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a f46521f;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final b f46522a;

        /* renamed from: b  reason: collision with root package name */
        public final SwanAppPickerDialog f46523b;

        /* renamed from: c  reason: collision with root package name */
        public Context f46524c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f46525d;

        /* renamed from: com.baidu.swan.apps.res.widget.dialog.SwanAppPickerDialog$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC1735a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f46526e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f46527f;

            public View$OnClickListenerC1735a(a aVar, DialogInterface.OnClickListener onClickListener) {
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
                this.f46527f = aVar;
                this.f46526e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f46527f.f46523b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.f46526e;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f46527f.f46523b, -1);
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f46528e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f46529f;

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
                this.f46529f = aVar;
                this.f46528e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f46529f.f46523b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.f46528e;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f46529f.f46523b, -2);
                    }
                }
            }
        }

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46525d = false;
            SwanAppPickerDialog b2 = b(context);
            this.f46523b = b2;
            b2.a(this);
            this.f46522a = new b((ViewGroup) this.f46523b.getWindow().getDecorView());
            this.f46524c = context;
        }

        public SwanAppPickerDialog a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f46523b.setOnCancelListener(this.f46522a.f46535f);
                this.f46523b.setOnDismissListener(this.f46522a.f46536g);
                this.f46523b.setOnShowListener(this.f46522a.f46537h);
                this.f46523b.a(this);
                return this.f46523b;
            }
            return (SwanAppPickerDialog) invokeV.objValue;
        }

        public abstract SwanAppPickerDialog b(Context context);

        public a c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f46523b.setCanceledOnTouchOutside(z);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a d(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, onClickListener)) == null) {
                e(this.f46524c.getText(i2), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a e(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, charSequence, onClickListener)) == null) {
                this.f46522a.f46531b.setText(charSequence);
                this.f46522a.f46531b.setOnClickListener(new b(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a f(DialogInterface.OnCancelListener onCancelListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, onCancelListener)) == null) {
                this.f46522a.f46535f = onCancelListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f46522a.f46532c.setText(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a h(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i2, onClickListener)) == null) {
                i(this.f46524c.getText(i2), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a i(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence, onClickListener)) == null) {
                this.f46522a.f46530a.setText(charSequence);
                this.f46522a.f46530a.setOnClickListener(new View$OnClickListenerC1735a(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a j(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, view)) == null) {
                this.f46522a.f46534e.removeAllViews();
                this.f46522a.f46534e.addView(view);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public SwanAppPickerDialog k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                SwanAppPickerDialog a2 = a();
                if (this.f46525d) {
                    a2.getWindow().setType(2003);
                }
                try {
                    a2.show();
                } catch (WindowManager.BadTokenException unused) {
                }
                return a2;
            }
            return (SwanAppPickerDialog) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f46530a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f46531b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f46532c;

        /* renamed from: d  reason: collision with root package name */
        public View f46533d;

        /* renamed from: e  reason: collision with root package name */
        public FrameLayout f46534e;

        /* renamed from: f  reason: collision with root package name */
        public DialogInterface.OnCancelListener f46535f;

        /* renamed from: g  reason: collision with root package name */
        public DialogInterface.OnDismissListener f46536g;

        /* renamed from: h  reason: collision with root package name */
        public DialogInterface.OnShowListener f46537h;

        /* renamed from: i  reason: collision with root package name */
        public FrameLayout f46538i;

        /* renamed from: j  reason: collision with root package name */
        public FrameLayout f46539j;
        public View k;
        public ViewGroup l;
        public RelativeLayout m;
        public LinearLayout n;
        public View o;

        @SuppressLint({"CutPasteId"})
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
            this.l = viewGroup;
            this.f46539j = (FrameLayout) viewGroup.findViewById(f.dialog_root);
            this.f46532c = (TextView) viewGroup.findViewById(f.title_picker);
            this.f46530a = (TextView) viewGroup.findViewById(f.positive_button);
            this.f46531b = (TextView) viewGroup.findViewById(f.negative_button);
            this.f46533d = viewGroup.findViewById(f.dialog_customPanel);
            this.f46534e = (FrameLayout) viewGroup.findViewById(f.dialog_custom_content);
            this.m = (RelativeLayout) viewGroup.findViewById(f.searchbox_alert_dialog);
            this.n = (LinearLayout) viewGroup.findViewById(f.btn_panel);
            this.o = viewGroup.findViewById(f.dialog_customPanel);
            this.f46538i = (FrameLayout) viewGroup.findViewById(f.dialog_root);
            this.k = viewGroup.findViewById(f.nightmode_mask);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppPickerDialog(Context context) {
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
            this.f46521f = aVar;
        }
    }

    public a getBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f46521f : (a) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setContentView(g.swanapp_picker_dialog);
            getWindow().setLayout(-1, -2);
            getWindow().setGravity(80);
            setEnableImmersion(false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppPickerDialog(Context context, int i2) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppPickerDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
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
}
