package c.a.d0.j.d;

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
    public int f2797b;

    /* renamed from: c  reason: collision with root package name */
    public AdDownloadStatus f2798c;

    /* renamed from: d  reason: collision with root package name */
    public String f2799d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2800e;

    /* renamed from: f  reason: collision with root package name */
    public String f2801f;

    /* renamed from: g  reason: collision with root package name */
    public String f2802g;

    /* renamed from: h  reason: collision with root package name */
    public File f2803h;

    /* renamed from: i  reason: collision with root package name */
    public float f2804i;

    /* renamed from: j  reason: collision with root package name */
    public float f2805j;
    public Uri k;
    public long l;
    public long m;
    public d n;
    public b o;
    public c p;

    /* renamed from: c.a.d0.j.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0087a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1900591510, "Lc/a/d0/j/d/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1900591510, "Lc/a/d0/j/d/a$a;");
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
        this.f2797b = -1;
        this.f2798c = AdDownloadStatus.NONE;
        this.f2804i = 0.0f;
        this.f2805j = 0.0f;
        this.n = new d();
        this.o = new b();
        this.p = new c();
    }

    @NonNull
    public static a b(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        c.a.d0.s.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adBaseModel)) == null) {
            a aVar = new a();
            if (adBaseModel != null && (cVar = adBaseModel.l) != null && cVar.f3078e) {
                aVar.f2802g = cVar.f3076c;
                aVar.g(cVar.f3077d);
                aVar.f2799d = adBaseModel.l.a;
                AdOperator adOperator = adBaseModel.f37260h;
                aVar.f2801f = adOperator == null ? null : adOperator.f37265d;
                aVar.n.a = adBaseModel.f37258f.f3093d;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public static a c(c.a.d0.s.c cVar, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cVar, str, str2)) == null) {
            a aVar = new a();
            if (cVar != null && cVar.f3078e) {
                aVar.f2802g = cVar.f3076c;
                aVar.g(cVar.f3077d);
                aVar.f2799d = cVar.a;
                aVar.n.a = str;
                aVar.f2801f = str2;
            }
            return aVar;
        }
        return (a) invokeLLL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o.f2810f != 1 : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f2802g) : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f2798c = AdDownloadStatus.NONE;
            this.f2804i = 0.0f;
            this.f2805j = 0.0f;
            this.f2803h = null;
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
                int i2 = C0087a.a[aVar.f2798c.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2 && !c.a.d0.j.i.a.b(aVar.f2799d)) {
                        File file = aVar.f2803h;
                        if (file != null && file.exists()) {
                            aVar.f2798c = AdDownloadStatus.COMPLETED;
                        } else {
                            aVar.f();
                            return;
                        }
                    }
                } else if (c.a.d0.j.i.a.b(aVar.f2799d)) {
                    aVar.f2798c = AdDownloadStatus.INSTALLED;
                } else if (!c.a.d0.j.i.a.f(aVar.f2803h)) {
                    c.a.d0.j.a.a.b().a(aVar);
                    aVar.f();
                }
                if (TextUtils.isEmpty(this.f2799d)) {
                    this.f2799d = aVar.f2799d;
                }
                this.f2797b = aVar.f2797b;
                this.f2798c = aVar.f2798c;
                this.f2804i = aVar.f2804i;
                this.f2805j = aVar.f2805j;
                this.f2803h = aVar.f2803h;
                this.f2799d = aVar.f2799d;
                this.l = aVar.l;
                this.m = aVar.m;
                b bVar = this.o;
                b bVar2 = aVar.o;
                bVar.f2814j = bVar2.f2814j;
                bVar.k = bVar2.k;
                this.n.f2823h = aVar.n.f2823h;
            } else if (c.a.d0.j.i.a.b(this.f2799d)) {
                this.f2798c = AdDownloadStatus.INSTALLED;
            }
        }
    }
}
