package com.baidu.poly.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import b.a.e0.g;
import b.a.e0.h;
import b.a.e0.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class CommonDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f42953e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42954f;

    /* renamed from: g  reason: collision with root package name */
    public View f42955g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f42956h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f42957i;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f42958e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CommonDialog f42959f;

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
            this.f42959f = commonDialog;
            this.f42958e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f42958e.b() == null) {
                return;
            }
            this.f42958e.b().a(this.f42959f);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f42960e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CommonDialog f42961f;

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
            this.f42961f = commonDialog;
            this.f42960e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f42960e.b() == null) {
                return;
            }
            this.f42960e.b().a(this.f42961f);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f42962e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CommonDialog f42963f;

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
            this.f42963f = commonDialog;
            this.f42962e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f42962e.b() == null) {
                return;
            }
            this.f42962e.b().a(this.f42963f);
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f42964a;

        /* renamed from: b  reason: collision with root package name */
        public String f42965b;

        /* renamed from: c  reason: collision with root package name */
        public e f42966c;

        /* renamed from: d  reason: collision with root package name */
        public e f42967d;

        /* renamed from: e  reason: collision with root package name */
        public e f42968e;

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
                commonDialog.i(this.f42964a);
                commonDialog.g(this.f42965b);
                if (this.f42968e != null && this.f42966c != null && this.f42967d != null) {
                    throw new IllegalArgumentException(d.class.getSimpleName() + "CommonDialog button can't support both single & double");
                } else if (this.f42968e == null && (this.f42966c == null || this.f42967d == null)) {
                    throw new IllegalArgumentException(d.class.getSimpleName() + "CommonDialog button double mode should set left & right, if you want to use a single button, you can setSingleButtonEntity()");
                } else {
                    e eVar2 = this.f42968e;
                    if (eVar2 != null) {
                        commonDialog.h(eVar2);
                    }
                    e eVar3 = this.f42966c;
                    if (eVar3 != null && (eVar = this.f42967d) != null) {
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
                this.f42966c = eVar;
                this.f42967d = eVar2;
                return this;
            }
            return (d) invokeLL.objValue;
        }

        public d c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f42965b = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d d(e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eVar)) == null) {
                this.f42968e = eVar;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f42964a = str;
                return this;
            }
            return (d) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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
            this.f42953e = (TextView) findViewById(g.cashiersdk_common_dialog_tv_title);
            this.f42954f = (TextView) findViewById(g.cashiersdk_common_dialog_tv_content);
            this.f42956h = (TextView) findViewById(g.cashiersdk_conmon_dialog_btn_left);
            this.f42957i = (TextView) findViewById(g.cashiersdk_conmon_dialog_btn_right);
            this.f42955g = findViewById(g.cashiersdk_conmon_dialog_line);
        }
    }

    public final void f(e eVar, e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, eVar2) == null) {
            this.f42955g.setVisibility(0);
            this.f42957i.setVisibility(0);
            this.f42956h.setText(eVar.a());
            this.f42956h.setOnClickListener(new a(this, eVar));
            this.f42957i.setText(eVar2.a());
            this.f42957i.setOnClickListener(new b(this, eVar2));
        }
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            TextView textView = this.f42954f;
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
        this.f42955g.setVisibility(8);
        this.f42956h.setVisibility(8);
        this.f42957i.setText(eVar.a());
        this.f42957i.setOnClickListener(new c(this, eVar));
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            TextView textView = this.f42953e;
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
