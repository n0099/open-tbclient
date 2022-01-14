package c.a.c0.j.d;

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
    public int f1950b;

    /* renamed from: c  reason: collision with root package name */
    public AdDownloadStatus f1951c;

    /* renamed from: d  reason: collision with root package name */
    public String f1952d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1953e;

    /* renamed from: f  reason: collision with root package name */
    public String f1954f;

    /* renamed from: g  reason: collision with root package name */
    public String f1955g;

    /* renamed from: h  reason: collision with root package name */
    public File f1956h;

    /* renamed from: i  reason: collision with root package name */
    public float f1957i;

    /* renamed from: j  reason: collision with root package name */
    public float f1958j;
    public Uri k;
    public long l;
    public long m;
    public d n;
    public b o;
    public c p;

    /* renamed from: c.a.c0.j.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0061a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-103640151, "Lc/a/c0/j/d/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-103640151, "Lc/a/c0/j/d/a$a;");
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.f1950b = -1;
        this.f1951c = AdDownloadStatus.NONE;
        this.f1957i = 0.0f;
        this.f1958j = 0.0f;
        this.n = new d();
        this.o = new b();
        this.p = new c();
    }

    @NonNull
    public static a b(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        c.a.c0.s.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adBaseModel)) == null) {
            a aVar = new a();
            if (adBaseModel != null && (cVar = adBaseModel.f37021i) != null && cVar.f2223d) {
                aVar.f1955g = cVar.f2221b;
                aVar.g(cVar.f2222c);
                aVar.f1952d = adBaseModel.f37021i.a;
                AdOperator adOperator = adBaseModel.f37018f;
                aVar.f1954f = adOperator == null ? null : adOperator.f37025d;
                aVar.n.a = adBaseModel.f37016d.f2233b;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public static a c(c.a.c0.s.c cVar, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cVar, str, str2)) == null) {
            a aVar = new a();
            if (cVar != null && cVar.f2223d) {
                aVar.f1955g = cVar.f2221b;
                aVar.g(cVar.f2222c);
                aVar.f1952d = cVar.a;
                aVar.n.a = str;
                aVar.f1954f = str2;
            }
            return aVar;
        }
        return (a) invokeLLL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o.f1963f != 1 : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f1955g) : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f1951c = AdDownloadStatus.NONE;
            this.f1957i = 0.0f;
            this.f1958j = 0.0f;
            this.f1956h = null;
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
                int i2 = C0061a.a[aVar.f1951c.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2 && !c.a.c0.j.i.a.b(aVar.f1952d)) {
                        File file = aVar.f1956h;
                        if (file != null && file.exists()) {
                            aVar.f1951c = AdDownloadStatus.COMPLETED;
                        } else {
                            aVar.f();
                            return;
                        }
                    }
                } else if (c.a.c0.j.i.a.b(aVar.f1952d)) {
                    aVar.f1951c = AdDownloadStatus.INSTALLED;
                } else if (!c.a.c0.j.i.a.f(aVar.f1956h)) {
                    c.a.c0.j.a.a.b().a(aVar);
                    aVar.f();
                }
                if (TextUtils.isEmpty(this.f1952d)) {
                    this.f1952d = aVar.f1952d;
                }
                this.f1950b = aVar.f1950b;
                this.f1951c = aVar.f1951c;
                this.f1957i = aVar.f1957i;
                this.f1958j = aVar.f1958j;
                this.f1956h = aVar.f1956h;
                this.f1952d = aVar.f1952d;
                this.l = aVar.l;
                this.m = aVar.m;
                b bVar = this.o;
                b bVar2 = aVar.o;
                bVar.f1967j = bVar2.f1967j;
                bVar.k = bVar2.k;
                this.n.f1976h = aVar.n.f1976h;
            } else if (c.a.c0.j.i.a.b(this.f1952d)) {
                this.f1951c = AdDownloadStatus.INSTALLED;
            }
        }
    }
}
