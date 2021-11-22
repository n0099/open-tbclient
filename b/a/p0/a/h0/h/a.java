package b.a.p0.a.h0.h;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.p0.a.g;
import b.a.p0.a.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f5505a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5506b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5507c;

    /* renamed from: d  reason: collision with root package name */
    public SwanAppAlertDialog f5508d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f5509e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f5510f;

    /* renamed from: g  reason: collision with root package name */
    public f f5511g;

    /* renamed from: h  reason: collision with root package name */
    public e f5512h;

    /* renamed from: b.a.p0.a.h0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0218a implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f5513a;

        public C0218a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5513a = aVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 == 6 || i2 == 0) {
                    if (i2 == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    this.f5513a.f();
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5514e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5514e = aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || this.f5514e.f5512h == null) {
                return;
            }
            this.f5514e.f5512h.onCancel();
        }
    }

    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5515e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5515e = aVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || this.f5515e.f5512h == null) {
                return;
            }
            this.f5515e.f5512h.onCancel();
        }
    }

    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5516e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5516e = aVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f5516e.f();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void onCancel();
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5505a = context;
        this.f5506b = str;
        this.f5507c = str2;
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f5505a).inflate(g.aiapps_browser_http_authentication, (ViewGroup) null);
            this.f5509e = (TextView) inflate.findViewById(b.a.p0.a.f.username_edit);
            TextView textView = (TextView) inflate.findViewById(b.a.p0.a.f.password_edit);
            this.f5510f = textView;
            textView.setOnEditorActionListener(new C0218a(this));
            String replace = this.f5505a.getText(h.aiapps_sign_in_to).toString().replace("[(s1)]", this.f5506b).replace("[(s2)]", this.f5507c);
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5505a);
            aVar.V(replace);
            aVar.u(17301543);
            aVar.W(inflate);
            aVar.O(h.aiapps_http_authentication_login, new d(this));
            aVar.B(h.aiapps_cancel, new c(this));
            aVar.K(new b(this));
            SwanAppAlertDialog c2 = aVar.c();
            this.f5508d = c2;
            c2.getWindow().setSoftInputMode(4);
        }
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f5510f.getText().toString() : (String) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f5509e.getText().toString() : (String) invokeV.objValue;
    }

    public final void f() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (fVar = this.f5511g) == null) {
            return;
        }
        fVar.a(this.f5506b, this.f5507c, e(), d());
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f5512h = eVar;
        }
    }

    public void h(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f5511g = fVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f5508d.show();
            this.f5509e.requestFocus();
        }
    }
}
