package com.baidu.poly.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import c.a.g0.g;
import c.a.g0.h;
import c.a.g0.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class CommonDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f38892e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f38893f;

    /* renamed from: g  reason: collision with root package name */
    public View f38894g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f38895h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f38896i;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f38897e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CommonDialog f38898f;

        public a(CommonDialog commonDialog, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonDialog, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38898f = commonDialog;
            this.f38897e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f38897e.b() == null) {
                return;
            }
            this.f38897e.b().a(this.f38898f);
        }
    }

    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f38899e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CommonDialog f38900f;

        public b(CommonDialog commonDialog, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonDialog, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38900f = commonDialog;
            this.f38899e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f38899e.b() == null) {
                return;
            }
            this.f38899e.b().a(this.f38900f);
        }
    }

    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f38901e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CommonDialog f38902f;

        public c(CommonDialog commonDialog, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonDialog, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38902f = commonDialog;
            this.f38901e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f38901e.b() == null) {
                return;
            }
            this.f38901e.b().a(this.f38902f);
        }
    }

    /* loaded from: classes10.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f38903b;

        /* renamed from: c  reason: collision with root package name */
        public e f38904c;

        /* renamed from: d  reason: collision with root package name */
        public e f38905d;

        /* renamed from: e  reason: collision with root package name */
        public e f38906e;

        public d() {
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

        public CommonDialog a(Context context) {
            InterceptResult invokeL;
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                CommonDialog commonDialog = new CommonDialog(context);
                commonDialog.i(this.a);
                commonDialog.g(this.f38903b);
                if (this.f38906e != null && this.f38904c != null && this.f38905d != null) {
                    throw new IllegalArgumentException(d.class.getSimpleName() + "CommonDialog button can't support both single & double");
                } else if (this.f38906e == null && (this.f38904c == null || this.f38905d == null)) {
                    throw new IllegalArgumentException(d.class.getSimpleName() + "CommonDialog button double mode should set left & right, if you want to use a single button, you can setSingleButtonEntity()");
                } else {
                    e eVar2 = this.f38906e;
                    if (eVar2 != null) {
                        commonDialog.h(eVar2);
                    }
                    e eVar3 = this.f38904c;
                    if (eVar3 != null && (eVar = this.f38905d) != null) {
                        commonDialog.f(eVar3, eVar);
                    }
                    return commonDialog;
                }
            }
            return (CommonDialog) invokeL.objValue;
        }

        public d b(e eVar, e eVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, eVar2)) == null) {
                this.f38904c = eVar;
                this.f38905d = eVar2;
                return this;
            }
            return (d) invokeLL.objValue;
        }

        public d c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f38903b = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d d(e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eVar)) == null) {
                this.f38906e = eVar;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.a = str;
                return this;
            }
            return (d) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        public abstract String a();

        public abstract f b();
    }

    /* loaded from: classes10.dex */
    public interface f {
        void a(Dialog dialog);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonDialog(Context context) {
        this(context, j.CashierSDK_CommonDialog);
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
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setContentView(h.dialog_common_cashiersdk);
            this.f38892e = (TextView) findViewById(g.cashiersdk_common_dialog_tv_title);
            this.f38893f = (TextView) findViewById(g.cashiersdk_common_dialog_tv_content);
            this.f38895h = (TextView) findViewById(g.cashiersdk_conmon_dialog_btn_left);
            this.f38896i = (TextView) findViewById(g.cashiersdk_conmon_dialog_btn_right);
            this.f38894g = findViewById(g.cashiersdk_conmon_dialog_line);
        }
    }

    public final void f(e eVar, e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, eVar2) == null) {
            this.f38894g.setVisibility(0);
            this.f38896i.setVisibility(0);
            this.f38895h.setText(eVar.a());
            this.f38895h.setOnClickListener(new a(this, eVar));
            this.f38896i.setText(eVar2.a());
            this.f38896i.setOnClickListener(new b(this, eVar2));
        }
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            TextView textView = this.f38893f;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
        }
    }

    public final void h(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f38894g.setVisibility(8);
        this.f38895h.setVisibility(8);
        this.f38896i.setText(eVar.a());
        this.f38896i.setOnClickListener(new c(this, eVar));
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            TextView textView = this.f38892e;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonDialog(Context context, int i2) {
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
        e();
    }
}
