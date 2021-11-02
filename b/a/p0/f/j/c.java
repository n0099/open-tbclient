package b.a.p0.f.j;

import android.text.TextUtils;
import b.a.p0.a.v2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes4.dex */
public class c implements b.a.p0.h.t.c.b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f9939b = "hasDownloadApk";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f9940a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-922444786, "Lb/a/p0/f/j/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-922444786, "Lb/a/p0/f/j/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9940a = "com.baidu.gamenow";
    }

    @Override // b.a.p0.h.t.c.b
    public boolean a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof Download) {
                Download download = (Download) obj;
                if (TextUtils.equals(b.a.p0.f.j.m.c.f9947a, download.getKeyByUser())) {
                    return true;
                }
                return TextUtils.isEmpty(w.d(download.getFromParam()).optString("apk_id"));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.h.t.c.b
    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && (obj instanceof Download)) {
            b.a.p0.f.j.n.a aVar = new b.a.p0.f.j.n.a((Download) obj);
            b.a.p0.f.j.r.b.n().f("reallyDownloaded", new b.a.p0.f.j.r.a(), aVar.k(), aVar.h(), aVar.j());
        }
    }

    @Override // b.a.p0.h.t.c.b
    public void c(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && (obj instanceof Download)) {
            Download download = (Download) obj;
            b.a.p0.f.j.n.a aVar = new b.a.p0.f.j.n.a(download);
            b.a.p0.f.j.r.b.n().f("statusInstalled", new b.a.p0.f.j.r.a(), download.getKeyByUser(), aVar.h(), aVar.j());
            if (TextUtils.equals(aVar.k(), this.f9940a)) {
                b.a.p0.a.k2.g.h.a().putBoolean(f9939b, true);
                b.a.p0.f.j.r.b.n().p(13, aVar.k(), aVar.f(), aVar.j());
            }
        }
    }
}
