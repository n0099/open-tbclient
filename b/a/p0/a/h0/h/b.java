package b.a.p0.a.h0.h;

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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.swan.apps.core.handler.SwanAppSafeUrlDialog;
import com.baidu.swan.apps.core.handler.SwanAppSslCertificateDialog;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.res.widget.dialog.AutoOrientationBtnDialog;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f5319c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f5320a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.h0.h.a f5321b;

    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f5322e;

        public a(b bVar, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5322e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (sVar = this.f5322e) == null) {
                return;
            }
            sVar.onCancel();
        }
    }

    /* renamed from: b.a.p0.a.h0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterface$OnClickListenerC0212b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f5323e;

        public DialogInterface$OnClickListenerC0212b(b bVar, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5323e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (sVar = this.f5323e) == null) {
                return;
            }
            sVar.b("");
        }
    }

    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f5324e;

        public c(b bVar, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5324e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (sVar = this.f5324e) == null) {
                return;
            }
            sVar.onCancel();
        }
    }

    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f5325e;

        public d(b bVar, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5325e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (sVar = this.f5325e) == null) {
                return;
            }
            sVar.onCancel();
        }
    }

    /* loaded from: classes.dex */
    public class e implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f5326e;

        public e(b bVar, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5326e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (sVar = this.f5326e) == null) {
                return;
            }
            sVar.b("");
        }
    }

    /* loaded from: classes.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f5327e;

        public f(b bVar, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5327e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (sVar = this.f5327e) == null) {
                return;
            }
            sVar.onCancel();
        }
    }

    /* loaded from: classes.dex */
    public class g implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f5328e;

        public g(b bVar, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5328e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (sVar = this.f5328e) == null) {
                return;
            }
            sVar.onCancel();
        }
    }

    /* loaded from: classes.dex */
    public class h implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f5329e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditText f5330f;

        public h(b bVar, s sVar, EditText editText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sVar, editText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5329e = sVar;
            this.f5330f = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (sVar = this.f5329e) == null) {
                return;
            }
            sVar.b(this.f5330f.getText().toString());
        }
    }

    /* loaded from: classes.dex */
    public class i implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f5331a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f5332b;

        public i(b bVar, r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5332b = bVar;
            this.f5331a = rVar;
        }

        @Override // b.a.p0.a.h0.h.a.f
        public void a(String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) {
                r rVar = this.f5331a;
                if (rVar != null) {
                    rVar.b(str3, str4);
                }
                this.f5332b.f5321b = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f5333a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f5334b;

        public j(b bVar, r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5334b = bVar;
            this.f5333a = rVar;
        }

        @Override // b.a.p0.a.h0.h.a.e
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r rVar = this.f5333a;
                if (rVar != null) {
                    rVar.a();
                }
                this.f5334b.f5321b = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f5335e;

        public k(b bVar, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sslErrorHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5335e = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f5335e.cancel();
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements AutoOrientationBtnDialog.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f5336a;

        public l(b bVar, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5336a = tVar;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.AutoOrientationBtnDialog.c
        public void onItemClick(View view) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (tVar = this.f5336a) == null) {
                return;
            }
            tVar.c();
        }
    }

    /* loaded from: classes.dex */
    public class m implements AutoOrientationBtnDialog.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f5337a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f5338b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SslError f5339c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f5340d;

        public m(b bVar, t tVar, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, tVar, sslErrorHandler, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5340d = bVar;
            this.f5337a = tVar;
            this.f5338b = sslErrorHandler;
            this.f5339c = sslError;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.AutoOrientationBtnDialog.c
        public void onItemClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f5340d.o(this.f5337a, this.f5338b, this.f5339c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements AutoOrientationBtnDialog.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f5341a;

        public n(b bVar, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5341a = tVar;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.AutoOrientationBtnDialog.c
        public void onItemClick(View view) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (tVar = this.f5341a) == null) {
                return;
            }
            tVar.b();
        }
    }

    /* loaded from: classes.dex */
    public class o implements AutoOrientationBtnDialog.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long[] f5342a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SslError f5343b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f5344c;

        public o(b bVar, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5344c = bVar;
            this.f5343b = sslError;
            this.f5342a = null;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.AutoOrientationBtnDialog.c
        public void onItemClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f5342a == null) {
                    this.f5342a = new long[5];
                }
                long[] jArr = this.f5342a;
                System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
                long[] jArr2 = this.f5342a;
                jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
                if (this.f5342a[0] >= SystemClock.uptimeMillis() - 3000) {
                    this.f5342a = null;
                    this.f5344c.g(this.f5343b.toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class p implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t f5345e;

        public p(b bVar, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5345e = tVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (tVar = this.f5345e) == null) {
                return;
            }
            tVar.a();
        }
    }

    /* loaded from: classes.dex */
    public class q implements AutoOrientationBtnDialog.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f5346a;

        public q(b bVar, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5346a = tVar;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.AutoOrientationBtnDialog.c
        public void onItemClick(View view) {
            t tVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (tVar = this.f5346a) == null) {
                return;
            }
            tVar.a();
        }
    }

    /* loaded from: classes.dex */
    public interface r {
        void a();

        void b(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface s {
        void a();

        void b(String str);

        void onCancel();
    }

    /* loaded from: classes.dex */
    public interface t {
        void a();

        void b();

        void c();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597432657, "Lb/a/p0/a/h0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597432657, "Lb/a/p0/a/h0/h/b;");
                return;
            }
        }
        f5319c = b.a.p0.a.k.f6397a;
    }

    public b(Context context) {
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
        this.f5320a = context;
    }

    public final void c(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, linearLayout, i2) == null) {
            d(linearLayout, i2, b.a.p0.a.e.aiapps_dialog_browser_security_good);
        }
    }

    public final void d(LinearLayout linearLayout, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.f5320a).inflate(b.a.p0.a.g.aiapps_ssl_content_header, (ViewGroup) linearLayout, false);
            TextView textView = (TextView) inflate.findViewById(b.a.p0.a.f.ssl_header_text);
            textView.setTextColor(inflate.getContext().getResources().getColor(b.a.p0.a.c.aiapps_safe_dialog_message));
            textView.setText(i2);
            ((BdBaseImageView) inflate.findViewById(b.a.p0.a.f.ssl_header_icon)).setImageResource(i3);
            linearLayout.addView(inflate);
        }
    }

    public final void e(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, linearLayout, i2) == null) {
            d(linearLayout, i2, b.a.p0.a.e.aiapps_dialog_browser_security_bad);
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Context context = this.f5320a;
            return (context instanceof Activity) && !((Activity) context).isFinishing();
        }
        return invokeV.booleanValue;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            ((ClipboardManager) this.f5320a.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(str);
            b.a.p0.a.z1.b.f.e.f(this.f5320a, b.a.p0.a.h.aiapps_ssl_copy_error).F();
        }
    }

    public final SwanAppSslCertificateDialog.a h(SslCertificate sslCertificate, SslError sslError) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, sslCertificate, sslError)) == null) {
            View j2 = j(sslCertificate);
            LinearLayout linearLayout = (LinearLayout) j2.findViewById(b.a.p0.a.f.placeholder);
            j2.findViewById(b.a.p0.a.f.ssl_divider).setBackgroundColor(this.f5320a.getResources().getColor(b.a.p0.a.c.aiapps_dialog_gray));
            if (sslError == null) {
                c(linearLayout, b.a.p0.a.h.aiapps_ssl_certificate_is_valid);
            } else {
                if (sslError.hasError(3)) {
                    e(linearLayout, b.a.p0.a.h.aiapps_ssl_untrusted);
                }
                if (sslError.hasError(2)) {
                    e(linearLayout, b.a.p0.a.h.aiapps_ssl_mismatch);
                }
                if (sslError.hasError(1)) {
                    e(linearLayout, b.a.p0.a.h.aiapps_ssl_expired);
                }
                if (sslError.hasError(0)) {
                    e(linearLayout, b.a.p0.a.h.aiapps_ssl_not_yet_valid);
                }
                if (sslError.hasError(4)) {
                    e(linearLayout, b.a.p0.a.h.aiapps_ssl_date_invalid);
                }
                if (sslError.hasError(5)) {
                    e(linearLayout, b.a.p0.a.h.aiapps_ssl_invalid);
                }
                if (linearLayout.getChildCount() == 0) {
                    e(linearLayout, b.a.p0.a.h.aiapps_ssl_unknown);
                }
            }
            SwanAppSslCertificateDialog.a aVar = new SwanAppSslCertificateDialog.a(this.f5320a);
            aVar.d0(b.a.p0.a.h.aiapps_ssl_certificate);
            aVar.c0(j2);
            return aVar;
        }
        return (SwanAppSslCertificateDialog.a) invokeLL.objValue;
    }

    public final String i(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, date)) == null) ? date == null ? "" : DateFormat.getDateFormat(this.f5320a).format(date) : (String) invokeL.objValue;
    }

    public final View j(SslCertificate sslCertificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, sslCertificate)) == null) {
            View inflate = LayoutInflater.from(this.f5320a).inflate(b.a.p0.a.g.aiapps_ssl_certificate, (ViewGroup) null);
            int color = this.f5320a.getResources().getColor(b.a.p0.a.c.aiapps_safe_dialog_message);
            ViewGroup viewGroup = (ViewGroup) inflate.findViewById(b.a.p0.a.f.body);
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
                ((TextView) inflate.findViewById(b.a.p0.a.f.to_common)).setText(issuedTo.getCName());
                ((TextView) inflate.findViewById(b.a.p0.a.f.to_org)).setText(issuedTo.getOName());
                ((TextView) inflate.findViewById(b.a.p0.a.f.to_org_unit)).setText(issuedTo.getUName());
            }
            SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
            if (issuedBy != null) {
                ((TextView) inflate.findViewById(b.a.p0.a.f.by_common)).setText(issuedBy.getCName());
                ((TextView) inflate.findViewById(b.a.p0.a.f.by_org)).setText(issuedBy.getOName());
                ((TextView) inflate.findViewById(b.a.p0.a.f.by_org_unit)).setText(issuedBy.getUName());
            }
            ((TextView) inflate.findViewById(b.a.p0.a.f.issued_on)).setText(i(sslCertificate.getValidNotBeforeDate()));
            ((TextView) inflate.findViewById(b.a.p0.a.f.expires_on)).setText(i(sslCertificate.getValidNotAfterDate()));
            return inflate;
        }
        return (View) invokeL.objValue;
    }

    public void k(r rVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rVar, str, str2) == null) {
            b.a.p0.a.h0.h.a aVar = new b.a.p0.a.h0.h.a(this.f5320a, str, str2);
            this.f5321b = aVar;
            aVar.h(new i(this, rVar));
            this.f5321b.g(new j(this, rVar));
            this.f5321b.i();
        }
    }

    public boolean l(String str, String str2, s sVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, str, str2, sVar)) == null) {
            if (!f()) {
                boolean z = f5319c;
                if (sVar != null) {
                    sVar.a();
                }
                return false;
            }
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5320a);
            aVar.U(b.a.p0.a.h.aiapps_dialog_webcall_common_title);
            aVar.x(str2);
            aVar.O(b.a.p0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0212b(this, sVar));
            aVar.K(new a(this, sVar));
            if (b.a.p0.a.c1.a.H().a()) {
                aVar.Y(false);
            } else {
                aVar.Y(true);
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean m(String str, String str2, s sVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, str2, sVar)) == null) {
            if (!f()) {
                boolean z = f5319c;
                if (sVar != null) {
                    sVar.a();
                }
                return false;
            }
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5320a);
            aVar.U(b.a.p0.a.h.aiapps_dialog_webcall_common_title);
            aVar.x(str2);
            aVar.O(b.a.p0.a.h.aiapps_confirm, new e(this, sVar));
            aVar.B(b.a.p0.a.h.aiapps_cancel, new d(this, sVar));
            aVar.K(new c(this, sVar));
            if (b.a.p0.a.c1.a.H().a()) {
                aVar.Y(false);
            } else {
                aVar.Y(true);
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean n(String str, String str2, String str3, s sVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, str, str2, str3, sVar)) == null) {
            if (!f()) {
                if (sVar != null) {
                    sVar.a();
                }
                return false;
            }
            View inflate = LayoutInflater.from(this.f5320a).inflate(b.a.p0.a.g.aiapps_js_prompt, (ViewGroup) null);
            EditText editText = (EditText) inflate.findViewById(b.a.p0.a.f.value);
            editText.setText(str3);
            ((TextView) inflate.findViewById(b.a.p0.a.f.message)).setText(str2);
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5320a);
            aVar.U(b.a.p0.a.h.aiapps_dialog_webcall_common_title);
            aVar.W(inflate);
            aVar.O(b.a.p0.a.h.aiapps_confirm, new h(this, sVar, editText));
            aVar.B(b.a.p0.a.h.aiapps_cancel, new g(this, sVar));
            aVar.K(new f(this, sVar));
            if (b.a.p0.a.c1.a.H().a()) {
                aVar.Y(false);
            } else {
                aVar.Y(true);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(t tVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, tVar, sslErrorHandler, sslError) == null) {
            if (!f()) {
                sslErrorHandler.cancel();
                return;
            }
            SslCertificate certificate = sslError.getCertificate();
            if (certificate == null) {
                return;
            }
            SwanAppSslCertificateDialog.a h2 = h(certificate, sslError);
            h2.a0(new AutoOrientationBtnDialog.a(this.f5320a.getText(b.a.p0.a.h.aiapps_confirm_text), b.a.p0.a.c.aiapps_safe_dialog_btn_black, new q(this, tVar)));
            h2.K(new p(this, tVar));
            h2.X();
        }
    }

    public void p(t tVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, tVar, sslErrorHandler, sslError) == null) {
            if (!f()) {
                sslErrorHandler.cancel();
                return;
            }
            SwanAppSafeUrlDialog.c cVar = new SwanAppSafeUrlDialog.c(this.f5320a);
            cVar.g0(b.a.p0.a.h.aiapps_security_warning);
            cVar.f0(b.a.p0.a.h.aiapps_ssl_warnings_header, new o(this, sslError));
            cVar.a0(new AutoOrientationBtnDialog.a(this.f5320a.getText(b.a.p0.a.h.aiapps_ssl_continue), b.a.p0.a.c.aiapps_ssl_dialog_go_on_text_color, new n(this, tVar)));
            cVar.a0(new AutoOrientationBtnDialog.a(this.f5320a.getText(b.a.p0.a.h.aiapps_view_certificate), b.a.p0.a.c.aiapps_safe_dialog_btn_black, new m(this, tVar, sslErrorHandler, sslError)));
            cVar.a0(new AutoOrientationBtnDialog.a(this.f5320a.getText(b.a.p0.a.h.aiapps_ssl_go_back), b.a.p0.a.c.aiapps_safe_dialog_btn_black, new l(this, tVar)));
            cVar.K(new k(this, sslErrorHandler));
            cVar.X();
        }
    }
}
