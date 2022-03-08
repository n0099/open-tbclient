package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PermissionHoverDialog extends SwanAppAlertDialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NOT_TIP_IS_CHECKED = 1;
    public static final int NOT_TIP_NOT_CHECKED = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends SwanAppAlertDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public TextView f37934f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f37935g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f37936h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f37937i;

        /* renamed from: j  reason: collision with root package name */
        public LinearLayout f37938j;
        public LinearLayout k;
        public CheckBox l;

        /* renamed from: com.baidu.swan.apps.res.widget.dialog.PermissionHoverDialog$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class DialogInterface$OnKeyListenerC1876a implements DialogInterface.OnKeyListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f37939e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f37940f;

            public DialogInterface$OnKeyListenerC1876a(a aVar, DialogInterface.OnClickListener onClickListener) {
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
                this.f37940f = aVar;
                this.f37939e = onClickListener;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                InterceptResult invokeLIL;
                DialogInterface.OnClickListener onClickListener;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i2, keyEvent)) == null) {
                    if (keyEvent.getAction() == 1 && i2 == 4 && keyEvent.getRepeatCount() == 0 && (onClickListener = this.f37939e) != null) {
                        onClickListener.onClick(dialogInterface, this.f37940f.c0());
                        return true;
                    }
                    return false;
                }
                return invokeLIL.booleanValue;
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f37941e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f37942f;

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
                this.f37942f = aVar;
                this.f37941e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogInterface.OnClickListener onClickListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (onClickListener = this.f37941e) == null) {
                    return;
                }
                a aVar = this.f37942f;
                onClickListener.onClick(aVar.f37949b, aVar.c0());
            }
        }

        /* loaded from: classes5.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f37943e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f37944f;

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
                this.f37944f = aVar;
                this.f37943e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogInterface.OnClickListener onClickListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (onClickListener = this.f37943e) == null) {
                    return;
                }
                a aVar = this.f37944f;
                onClickListener.onClick(aVar.f37949b, aVar.c0());
            }
        }

        /* loaded from: classes5.dex */
        public class d implements DialogInterface.OnShowListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnShowListener f37945e;

            public d(a aVar, DialogInterface.OnShowListener onShowListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onShowListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f37945e = onShowListener;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                DialogInterface.OnShowListener onShowListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (onShowListener = this.f37945e) == null) {
                    return;
                }
                onShowListener.onShow(dialogInterface);
            }
        }

        /* loaded from: classes5.dex */
        public class e implements DialogInterface.OnDismissListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnDismissListener f37946e;

            public e(a aVar, DialogInterface.OnDismissListener onDismissListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onDismissListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f37946e = onDismissListener;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                DialogInterface.OnDismissListener onDismissListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (onDismissListener = this.f37946e) == null) {
                    return;
                }
                onDismissListener.onDismiss(dialogInterface);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
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
            n(new c.a.p0.a.q2.h.a());
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.swan_app_auth_hover_dialog, e(), false);
            W(viewGroup);
            this.f37938j = (LinearLayout) viewGroup.findViewById(R.id.auth_layout);
            this.f37936h = (TextView) viewGroup.findViewById(R.id.auth_negative_button);
            this.f37937i = (TextView) viewGroup.findViewById(R.id.auth_positive_button);
            this.k = (LinearLayout) viewGroup.findViewById(R.id.know_it_layout);
            this.l = (CheckBox) viewGroup.findViewById(R.id.hover_dialog_not_tips);
            this.f37934f = (TextView) viewGroup.findViewById(R.id.hover_dialog_title);
            this.f37935g = (TextView) viewGroup.findViewById(R.id.hover_dialog_tip);
            this.l.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(R.drawable.swanapp_hover_dialog_tip_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            this.k.setVisibility(8);
            this.f37938j.setVisibility(0);
            this.l.setVisibility(0);
            this.f37949b.setCancelable(false);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog.a
        public /* bridge */ /* synthetic */ SwanAppAlertDialog.a N(DialogInterface.OnShowListener onShowListener) {
            j0(onShowListener);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog.a
        /* renamed from: b0 */
        public PermissionHoverDialog c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (PermissionHoverDialog) super.c() : (PermissionHoverDialog) invokeV.objValue;
        }

        public final int c0() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l.isChecked() ? 1 : 0 : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog.a
        /* renamed from: d0 */
        public PermissionHoverDialog h(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? new PermissionHoverDialog(context) : (PermissionHoverDialog) invokeL.objValue;
        }

        public a e0(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f37935g.setText(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a f0(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f37934f.setText(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g0(DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, onClickListener)) == null) {
                this.f37936h.setOnClickListener(new b(this, onClickListener));
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a h0(DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, onClickListener)) == null) {
                super.M(new DialogInterface$OnKeyListenerC1876a(this, onClickListener));
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a i0(DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, onDismissListener)) == null) {
                super.L(new e(this, onDismissListener));
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a j0(DialogInterface.OnShowListener onShowListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, onShowListener)) == null) {
                super.N(new d(this, onShowListener));
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a k0(DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, onClickListener)) == null) {
                this.f37937i.setOnClickListener(new c(this, onClickListener));
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionHoverDialog(Context context) {
        super(context, R.style.SwanAppNoTitleDialog);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        setEnableImmersion(false);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setWindowAnimations(R.style.action_sheet_animation);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            SwanAppAlertDialog.a builder = getBuilder();
            builder.p(R.drawable.aiapps_action_sheet_bg);
            builder.f(true);
            builder.k(false);
            builder.j();
            builder.t(false);
        }
    }
}
