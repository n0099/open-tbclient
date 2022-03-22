package c.a.a0.j.d;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f1245b;

    /* renamed from: c  reason: collision with root package name */
    public AdDownloadStatus f1246c;

    /* renamed from: d  reason: collision with root package name */
    public String f1247d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1248e;

    /* renamed from: f  reason: collision with root package name */
    public String f1249f;

    /* renamed from: g  reason: collision with root package name */
    public String f1250g;

    /* renamed from: h  reason: collision with root package name */
    public File f1251h;
    public float i;
    public float j;
    public Uri k;
    public long l;
    public long m;
    public d n;
    public b o;
    public c p;

    /* renamed from: c.a.a0.j.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0031a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-804704729, "Lc/a/a0/j/d/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-804704729, "Lc/a/a0/j/d/a$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            a = iArr;
            try {
                iArr[AdDownloadStatus.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadStatus.INSTALLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.f1245b = -1;
        this.f1246c = AdDownloadStatus.NONE;
        this.i = 0.0f;
        this.j = 0.0f;
        this.n = new d();
        this.o = new b();
        this.p = new c();
    }

    @NonNull
    public static a b(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        c.a.a0.s.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adBaseModel)) == null) {
            a aVar = new a();
            if (adBaseModel != null && (cVar = adBaseModel.l) != null && cVar.f1535e) {
                aVar.f1250g = cVar.f1533c;
                aVar.g(cVar.f1534d);
                aVar.f1247d = adBaseModel.l.a;
                AdOperator adOperator = adBaseModel.f27545h;
                aVar.f1249f = adOperator == null ? null : adOperator.f27548d;
                aVar.n.a = adBaseModel.f27543f.f1549d;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public static a c(c.a.a0.s.c cVar, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cVar, str, str2)) == null) {
            a aVar = new a();
            if (cVar != null && cVar.f1535e) {
                aVar.f1250g = cVar.f1533c;
                aVar.g(cVar.f1534d);
                aVar.f1247d = cVar.a;
                aVar.n.a = str;
                aVar.f1249f = str2;
            }
            return aVar;
        }
        return (a) invokeLLL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o.f1256f != 1 : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f1250g) : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f1246c = AdDownloadStatus.NONE;
            this.i = 0.0f;
            this.j = 0.0f;
            this.f1251h = null;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || str == null) {
            return;
        }
        this.a = str;
    }

    public void h(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (aVar != null && TextUtils.equals(d(), aVar.d())) {
                int i = C0031a.a[aVar.f1246c.ordinal()];
                if (i != 1) {
                    if (i == 2 && !c.a.a0.j.i.a.b(aVar.f1247d)) {
                        File file = aVar.f1251h;
                        if (file != null && file.exists()) {
                            aVar.f1246c = AdDownloadStatus.COMPLETED;
                        } else {
                            aVar.f();
                            return;
                        }
                    }
                } else if (c.a.a0.j.i.a.b(aVar.f1247d)) {
                    aVar.f1246c = AdDownloadStatus.INSTALLED;
                } else if (!c.a.a0.j.i.a.f(aVar.f1251h)) {
                    c.a.a0.j.a.a.b().a(aVar);
                    aVar.f();
                }
                if (TextUtils.isEmpty(this.f1247d)) {
                    this.f1247d = aVar.f1247d;
                }
                this.f1245b = aVar.f1245b;
                this.f1246c = aVar.f1246c;
                this.i = aVar.i;
                this.j = aVar.j;
                this.f1251h = aVar.f1251h;
                this.f1247d = aVar.f1247d;
                this.l = aVar.l;
                this.m = aVar.m;
                b bVar = this.o;
                b bVar2 = aVar.o;
                bVar.j = bVar2.j;
                bVar.k = bVar2.k;
                this.n.f1267h = aVar.n.f1267h;
            } else if (c.a.a0.j.i.a.b(this.f1247d)) {
                this.f1246c = AdDownloadStatus.INSTALLED;
            }
        }
    }
}
