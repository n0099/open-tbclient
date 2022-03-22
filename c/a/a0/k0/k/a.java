package c.a.a0.k0.k;

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
import c.a.a0.k0.q.a;
import c.a.a0.l0.q.a;
import c.a.a0.l0.q.d;
import c.a.a0.l0.q.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.BdBaseImageView;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static Set<String> f1319c;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.a0.k0.q.a f1320b;

    /* renamed from: c.a.a0.k0.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0045a implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.a0.k0.o.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f1321b;

        public C0045a(a aVar, c.a.a0.k0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1321b = aVar;
            this.a = bVar;
        }

        @Override // c.a.a0.k0.q.a.f
        public void a(String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) {
                this.a.setHttpAuthUsernamePassword(str, str2, str3, str4);
                this.a.a(str3, str4);
                this.f1321b.f1320b = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.a0.k0.o.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f1322b;

        public b(a aVar, c.a.a0.k0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1322b = aVar;
            this.a = bVar;
        }

        @Override // c.a.a0.k0.q.a.e
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.cancel();
                this.f1322b.f1320b = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SslErrorHandler a;

        public c(a aVar, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sslErrorHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements a.c {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sslErrorHandler;
        }

        @Override // c.a.a0.l0.q.a.c
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.a0.k0.o.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f1323b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SslError f1324c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f1325d;

        public e(a aVar, c.a.a0.k0.o.c cVar, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, sslErrorHandler, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1325d = aVar;
            this.a = cVar;
            this.f1323b = sslErrorHandler;
            this.f1324c = sslError;
        }

        @Override // c.a.a0.l0.q.a.c
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f1325d.m(this.a, this.f1323b, this.f1324c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements a.c {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sslErrorHandler;
        }

        @Override // c.a.a0.l0.q.a.c
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.proceed();
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long[] a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SslError f1326b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f1327c;

        public g(a aVar, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1327c = aVar;
            this.f1326b = sslError;
            this.a = null;
        }

        @Override // c.a.a0.l0.q.a.c
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
                    this.f1327c.h(this.f1326b.toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.a0.k0.o.c a;

        public h(a aVar, c.a.a0.k0.o.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @RequiresApi(api = 26)
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.a0.k0.o.c a;

        public i(a aVar, c.a.a0.k0.o.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.a0.l0.q.a.c
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-265409394, "Lc/a/a0/k0/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-265409394, "Lc/a/a0/k0/k/a;");
                return;
            }
        }
        HashSet hashSet = new HashSet();
        f1319c = hashSet;
        hashSet.add(".baidu.com");
        f1319c.add(".nuomi.com");
        f1319c.add(".nuomi.bdimg.com");
        f1319c.add(".hao123.com");
        f1319c.add(".qunaer.com");
        f1319c.add(".wejianzhan.com");
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
        new HashMap();
        new HashMap();
        new HashMap();
        new HashMap();
        this.a = context;
    }

    public final void d(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, linearLayout, i2) == null) {
            e(linearLayout, i2, R.drawable.obfuscated_res_0x7f080db0);
        }
    }

    public final void e(LinearLayout linearLayout, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d05d0, (ViewGroup) linearLayout, false);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091d8d);
            textView.setTextColor(inflate.getContext().getResources().getColor(R.color.obfuscated_res_0x7f06082e));
            textView.setText(i2);
            ((BdBaseImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091d8c)).setImageResource(i3);
            linearLayout.addView(inflate);
        }
    }

    public final void f(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, linearLayout, i2) == null) {
            e(linearLayout, i2, R.drawable.obfuscated_res_0x7f080daf);
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
            c.a.a0.e0.b.a().b(this.a, R.string.obfuscated_res_0x7f0f0bc9);
        }
    }

    public final e.a i(SslCertificate sslCertificate, SslError sslError) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, sslCertificate, sslError)) == null) {
            View k = k(sslCertificate);
            LinearLayout linearLayout = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f091852);
            k.findViewById(R.id.obfuscated_res_0x7f091d8b).setBackgroundColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0607fd));
            if (sslError == null) {
                d(linearLayout, R.string.obfuscated_res_0x7f0f0bc7);
            } else {
                if (sslError.hasError(3)) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0bd2);
                }
                if (sslError.hasError(2)) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0bcf);
                }
                if (sslError.hasError(1)) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0bcb);
                }
                if (sslError.hasError(0)) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0bd0);
                }
                if (sslError.hasError(4)) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0bca);
                }
                if (sslError.hasError(5)) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0bce);
                }
                if (linearLayout.getChildCount() == 0) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0bd1);
                }
            }
            e.a aVar = new e.a(this.a);
            aVar.w(R.string.obfuscated_res_0x7f0f0bc6);
            aVar.v(k);
            return aVar;
        }
        return (e.a) invokeLL.objValue;
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
            View inflate = View.inflate(this.a, R.layout.obfuscated_res_0x7f0d05cf, null);
            int color = this.a.getResources().getColor(R.color.obfuscated_res_0x7f06082e);
            ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f09038e);
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
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092080)).setText(issuedTo.getCName());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092083)).setText(issuedTo.getOName());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092085)).setText(issuedTo.getUName());
            }
            SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
            if (issuedBy != null) {
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09047d)).setText(issuedBy.getCName());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09047f)).setText(issuedBy.getOName());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090481)).setText(issuedBy.getUName());
            }
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090f57)).setText(j(sslCertificate.getValidNotBeforeDate()));
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090942)).setText(j(sslCertificate.getValidNotAfterDate()));
            return inflate;
        }
        return (View) invokeL.objValue;
    }

    public void l(@NonNull c.a.a0.k0.o.b bVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, str, str2) == null) {
            c.a.a0.k0.q.a aVar = new c.a.a0.k0.q.a(this.a, str, str2);
            this.f1320b = aVar;
            aVar.h(new C0045a(this, bVar));
            this.f1320b.g(new b(this, bVar));
            this.f1320b.i();
        }
    }

    public final void m(@NonNull c.a.a0.k0.o.c cVar, SslErrorHandler sslErrorHandler, SslError sslError) {
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
            e.a i2 = i(certificate, sslError);
            i2.t(new a.C0060a(this.a.getText(R.string.obfuscated_res_0x7f0f0bcd), R.color.obfuscated_res_0x7f06082c, new i(this, cVar)));
            i2.l(new h(this, cVar));
            i2.r();
        }
    }

    public void n(@NonNull c.a.a0.k0.o.c cVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, cVar, sslErrorHandler, sslError) == null) {
            if (!g()) {
                sslErrorHandler.cancel();
                return;
            }
            d.c cVar2 = new d.c(this.a);
            cVar2.y(R.string.obfuscated_res_0x7f0f0bc2);
            cVar2.x(R.string.obfuscated_res_0x7f0f0bd3, new g(this, sslError));
            cVar2.t(new a.C0060a(this.a.getText(R.string.obfuscated_res_0x7f0f0bc8), R.color.obfuscated_res_0x7f06082f, new f(this, sslErrorHandler)));
            cVar2.t(new a.C0060a(this.a.getText(R.string.obfuscated_res_0x7f0f0bf6), R.color.obfuscated_res_0x7f06082c, new e(this, cVar, sslErrorHandler, sslError)));
            cVar2.t(new a.C0060a(this.a.getText(R.string.obfuscated_res_0x7f0f0bcc), R.color.obfuscated_res_0x7f06082c, new d(this, sslErrorHandler)));
            cVar2.l(new c(this, sslErrorHandler));
            cVar2.r();
        }
    }
}
