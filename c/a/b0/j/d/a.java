package c.a.b0.j.d;

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
    public int f1612b;

    /* renamed from: c  reason: collision with root package name */
    public AdDownloadStatus f1613c;

    /* renamed from: d  reason: collision with root package name */
    public String f1614d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1615e;

    /* renamed from: f  reason: collision with root package name */
    public String f1616f;

    /* renamed from: g  reason: collision with root package name */
    public String f1617g;

    /* renamed from: h  reason: collision with root package name */
    public File f1618h;

    /* renamed from: i  reason: collision with root package name */
    public float f1619i;

    /* renamed from: j  reason: collision with root package name */
    public float f1620j;
    public Uri k;
    public long l;
    public long m;
    public d n;
    public b o;
    public c p;

    /* renamed from: c.a.b0.j.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0046a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1693311208, "Lc/a/b0/j/d/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1693311208, "Lc/a/b0/j/d/a$a;");
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
        this.f1612b = -1;
        this.f1613c = AdDownloadStatus.NONE;
        this.f1619i = 0.0f;
        this.f1620j = 0.0f;
        this.n = new d();
        this.o = new b();
        this.p = new c();
    }

    @NonNull
    public static a b(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        c.a.b0.s.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adBaseModel)) == null) {
            a aVar = new a();
            if (adBaseModel != null && (cVar = adBaseModel.l) != null && cVar.f1908e) {
                aVar.f1617g = cVar.f1906c;
                aVar.g(cVar.f1907d);
                aVar.f1614d = adBaseModel.l.a;
                AdOperator adOperator = adBaseModel.f35663h;
                aVar.f1616f = adOperator == null ? null : adOperator.f35668d;
                aVar.n.a = adBaseModel.f35661f.f1923d;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public static a c(c.a.b0.s.c cVar, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cVar, str, str2)) == null) {
            a aVar = new a();
            if (cVar != null && cVar.f1908e) {
                aVar.f1617g = cVar.f1906c;
                aVar.g(cVar.f1907d);
                aVar.f1614d = cVar.a;
                aVar.n.a = str;
                aVar.f1616f = str2;
            }
            return aVar;
        }
        return (a) invokeLLL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o.f1625f != 1 : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f1617g) : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f1613c = AdDownloadStatus.NONE;
            this.f1619i = 0.0f;
            this.f1620j = 0.0f;
            this.f1618h = null;
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
                int i2 = C0046a.a[aVar.f1613c.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2 && !c.a.b0.j.i.a.b(aVar.f1614d)) {
                        File file = aVar.f1618h;
                        if (file != null && file.exists()) {
                            aVar.f1613c = AdDownloadStatus.COMPLETED;
                        } else {
                            aVar.f();
                            return;
                        }
                    }
                } else if (c.a.b0.j.i.a.b(aVar.f1614d)) {
                    aVar.f1613c = AdDownloadStatus.INSTALLED;
                } else if (!c.a.b0.j.i.a.f(aVar.f1618h)) {
                    c.a.b0.j.a.a.b().a(aVar);
                    aVar.f();
                }
                if (TextUtils.isEmpty(this.f1614d)) {
                    this.f1614d = aVar.f1614d;
                }
                this.f1612b = aVar.f1612b;
                this.f1613c = aVar.f1613c;
                this.f1619i = aVar.f1619i;
                this.f1620j = aVar.f1620j;
                this.f1618h = aVar.f1618h;
                this.f1614d = aVar.f1614d;
                this.l = aVar.l;
                this.m = aVar.m;
                b bVar = this.o;
                b bVar2 = aVar.o;
                bVar.f1629j = bVar2.f1629j;
                bVar.k = bVar2.k;
                this.n.f1638h = aVar.n.f1638h;
            } else if (c.a.b0.j.i.a.b(this.f1614d)) {
                this.f1613c = AdDownloadStatus.INSTALLED;
            }
        }
    }
}
