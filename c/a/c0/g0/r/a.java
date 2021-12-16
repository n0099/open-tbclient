package c.a.c0.g0.r;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.ClipboardManager;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.g0.w.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.BdBaseImageView;
import com.baidu.nadcore.widget.dialog.AutoOrientationBtnDialog;
import com.baidu.nadcore.widget.dialog.SafeUrlDialog;
import com.baidu.nadcore.widget.dialog.SslCertificateDialog;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.Domains;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static Set<String> f1590c;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.c0.g0.w.a f1591b;

    /* renamed from: c.a.c0.g0.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0047a implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.c0.g0.u.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f1592b;

        public C0047a(a aVar, c.a.c0.g0.u.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1592b = aVar;
            this.a = bVar;
        }

        @Override // c.a.c0.g0.w.a.f
        public void a(String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) {
                this.a.setHttpAuthUsernamePassword(str, str2, str3, str4);
                this.a.a(str3, str4);
                this.f1592b.f1591b = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.c0.g0.u.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f1593b;

        public b(a aVar, c.a.c0.g0.u.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1593b = aVar;
            this.a = bVar;
        }

        @Override // c.a.c0.g0.w.a.e
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.cancel();
                this.f1593b.f1591b = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f1594e;

        public c(a aVar, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sslErrorHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1594e = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f1594e.cancel();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements AutoOrientationBtnDialog.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SslErrorHandler a;

        public d(a aVar, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sslErrorHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sslErrorHandler;
        }

        @Override // com.baidu.nadcore.widget.dialog.AutoOrientationBtnDialog.c
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements AutoOrientationBtnDialog.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.c0.g0.u.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f1595b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SslError f1596c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f1597d;

        public e(a aVar, c.a.c0.g0.u.c cVar, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, sslErrorHandler, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1597d = aVar;
            this.a = cVar;
            this.f1595b = sslErrorHandler;
            this.f1596c = sslError;
        }

        @Override // com.baidu.nadcore.widget.dialog.AutoOrientationBtnDialog.c
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f1597d.m(this.a, this.f1595b, this.f1596c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements AutoOrientationBtnDialog.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SslErrorHandler a;

        public f(a aVar, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sslErrorHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sslErrorHandler;
        }

        @Override // com.baidu.nadcore.widget.dialog.AutoOrientationBtnDialog.c
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.proceed();
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements AutoOrientationBtnDialog.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long[] a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SslError f1598b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f1599c;

        public g(a aVar, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1599c = aVar;
            this.f1598b = sslError;
            this.a = null;
        }

        @Override // com.baidu.nadcore.widget.dialog.AutoOrientationBtnDialog.c
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a == null) {
                    this.a = new long[5];
                }
                long[] jArr = this.a;
                System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
                long[] jArr2 = this.a;
                jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
                if (this.a[0] >= SystemClock.uptimeMillis() - 3000) {
                    this.a = null;
                    this.f1599c.h(this.f1598b.toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.c0.g0.u.c f1600e;

        public h(a aVar, c.a.c0.g0.u.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1600e = cVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @RequiresApi(api = 26)
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f1600e.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements AutoOrientationBtnDialog.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.c0.g0.u.c a;

        public i(a aVar, c.a.c0.g0.u.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.nadcore.widget.dialog.AutoOrientationBtnDialog.c
        @RequiresApi(api = 26)
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(86724705, "Lc/a/c0/g0/r/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(86724705, "Lc/a/c0/g0/r/a;");
                return;
            }
        }
        HashSet hashSet = new HashSet();
        f1590c = hashSet;
        hashSet.add(Domains.BAIDU);
        f1590c.add(Domains.NUOMI);
        f1590c.add(".nuomi.bdimg.com");
        f1590c.add(".hao123.com");
        f1590c.add(".qunaer.com");
        f1590c.add(".wejianzhan.com");
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
        this.a = context;
    }

    public final void d(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, linearLayout, i2) == null) {
            e(linearLayout, i2, c.a.c0.g0.f.nad_ic_dialog_browser_security_good);
        }
    }

    public final void e(LinearLayout linearLayout, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(c.a.c0.g0.h.nad_ssl_content_header, (ViewGroup) linearLayout, false);
            TextView textView = (TextView) inflate.findViewById(c.a.c0.g0.g.ssl_header_text);
            textView.setTextColor(inflate.getContext().getResources().getColor(c.a.c0.g0.e.nad_safe_dialog_message));
            textView.setText(i2);
            ((BdBaseImageView) inflate.findViewById(c.a.c0.g0.g.ssl_header_icon)).setImageResource(i3);
            linearLayout.addView(inflate);
        }
    }

    public final void f(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, linearLayout, i2) == null) {
            e(linearLayout, i2, c.a.c0.g0.f.nad_ic_dialog_browser_security_bad);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Context context = this.a;
            return (context instanceof Activity) && !((Activity) context).isFinishing();
        }
        return invokeV.booleanValue;
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            ClipboardManager clipboardManager = (ClipboardManager) this.a.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
            if (clipboardManager != null) {
                clipboardManager.setText(str);
            }
            c.a.c0.b0.b.a().b(this.a, c.a.c0.g0.i.nad_ssl_copy_error);
        }
    }

    public final SslCertificateDialog.a i(SslCertificate sslCertificate, SslError sslError) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, sslCertificate, sslError)) == null) {
            View k2 = k(sslCertificate);
            LinearLayout linearLayout = (LinearLayout) k2.findViewById(c.a.c0.g0.g.placeholder);
            k2.findViewById(c.a.c0.g0.g.ssl_divider).setBackgroundColor(this.a.getResources().getColor(c.a.c0.g0.e.nad_dialog_gray));
            if (sslError == null) {
                d(linearLayout, c.a.c0.g0.i.nad_ssl_certificate_is_valid);
            } else {
                if (sslError.hasError(3)) {
                    f(linearLayout, c.a.c0.g0.i.nad_ssl_untrusted);
                }
                if (sslError.hasError(2)) {
                    f(linearLayout, c.a.c0.g0.i.nad_ssl_mismatch);
                }
                if (sslError.hasError(1)) {
                    f(linearLayout, c.a.c0.g0.i.nad_ssl_expired);
                }
                if (sslError.hasError(0)) {
                    f(linearLayout, c.a.c0.g0.i.nad_ssl_not_yet_valid);
                }
                if (sslError.hasError(4)) {
                    f(linearLayout, c.a.c0.g0.i.nad_ssl_date_invalid);
                }
                if (sslError.hasError(5)) {
                    f(linearLayout, c.a.c0.g0.i.nad_ssl_invalid);
                }
                if (linearLayout.getChildCount() == 0) {
                    f(linearLayout, c.a.c0.g0.i.nad_ssl_unknown);
                }
            }
            SslCertificateDialog.a aVar = new SslCertificateDialog.a(this.a);
            aVar.y(c.a.c0.g0.i.nad_ssl_certificate);
            aVar.x(k2);
            return aVar;
        }
        return (SslCertificateDialog.a) invokeLL.objValue;
    }

    public final String j(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, date)) == null) ? date == null ? "" : DateFormat.getDateFormat(this.a).format(date) : (String) invokeL.objValue;
    }

    public final View k(SslCertificate sslCertificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, sslCertificate)) == null) {
            View inflate = View.inflate(this.a, c.a.c0.g0.h.nad_ssl_certificate, null);
            int color = this.a.getResources().getColor(c.a.c0.g0.e.nad_safe_dialog_message);
            ViewGroup viewGroup = (ViewGroup) inflate.findViewById(c.a.c0.g0.g.body);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextColor(color);
                    textView.setTextSize(14.0f);
                }
            }
            SslCertificate.DName issuedTo = sslCertificate.getIssuedTo();
            if (issuedTo != null) {
                ((TextView) inflate.findViewById(c.a.c0.g0.g.to_common)).setText(issuedTo.getCName());
                ((TextView) inflate.findViewById(c.a.c0.g0.g.to_org)).setText(issuedTo.getOName());
                ((TextView) inflate.findViewById(c.a.c0.g0.g.to_org_unit)).setText(issuedTo.getUName());
            }
            SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
            if (issuedBy != null) {
                ((TextView) inflate.findViewById(c.a.c0.g0.g.by_common)).setText(issuedBy.getCName());
                ((TextView) inflate.findViewById(c.a.c0.g0.g.by_org)).setText(issuedBy.getOName());
                ((TextView) inflate.findViewById(c.a.c0.g0.g.by_org_unit)).setText(issuedBy.getUName());
            }
            ((TextView) inflate.findViewById(c.a.c0.g0.g.issued_on)).setText(j(sslCertificate.getValidNotBeforeDate()));
            ((TextView) inflate.findViewById(c.a.c0.g0.g.expires_on)).setText(j(sslCertificate.getValidNotAfterDate()));
            return inflate;
        }
        return (View) invokeL.objValue;
    }

    public void l(@NonNull c.a.c0.g0.u.b bVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, str, str2) == null) {
            c.a.c0.g0.w.a aVar = new c.a.c0.g0.w.a(this.a, str, str2);
            this.f1591b = aVar;
            aVar.h(new C0047a(this, bVar));
            this.f1591b.g(new b(this, bVar));
            this.f1591b.i();
        }
    }

    public final void m(@NonNull c.a.c0.g0.u.c cVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, cVar, sslErrorHandler, sslError) == null) {
            if (!g()) {
                sslErrorHandler.cancel();
                return;
            }
            SslCertificate certificate = sslError.getCertificate();
            if (certificate == null) {
                return;
            }
            SslCertificateDialog.a i2 = i(certificate, sslError);
            i2.v(new AutoOrientationBtnDialog.a(this.a.getText(c.a.c0.g0.i.nad_ssl_got_it), c.a.c0.g0.e.nad_safe_dialog_btn_black, new i(this, cVar)));
            i2.n(new h(this, cVar));
            i2.t();
        }
    }

    public void n(@NonNull c.a.c0.g0.u.c cVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, cVar, sslErrorHandler, sslError) == null) {
            if (!g()) {
                sslErrorHandler.cancel();
                return;
            }
            SafeUrlDialog.c cVar2 = new SafeUrlDialog.c(this.a);
            cVar2.A(c.a.c0.g0.i.nad_security_warning);
            cVar2.z(c.a.c0.g0.i.nad_ssl_warnings_header, new g(this, sslError));
            cVar2.v(new AutoOrientationBtnDialog.a(this.a.getText(c.a.c0.g0.i.nad_ssl_continue), c.a.c0.g0.e.nad_ssl_dialog_go_on_text_color, new f(this, sslErrorHandler)));
            cVar2.v(new AutoOrientationBtnDialog.a(this.a.getText(c.a.c0.g0.i.nad_view_certificate), c.a.c0.g0.e.nad_safe_dialog_btn_black, new e(this, cVar, sslErrorHandler, sslError)));
            cVar2.v(new AutoOrientationBtnDialog.a(this.a.getText(c.a.c0.g0.i.nad_ssl_go_back), c.a.c0.g0.e.nad_safe_dialog_btn_black, new d(this, sslErrorHandler)));
            cVar2.n(new c(this, sslErrorHandler));
            cVar2.t();
        }
    }
}
