package c.a.p0.h.j;

import android.text.TextUtils;
import c.a.p0.a.z2.w;
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
/* loaded from: classes5.dex */
public class c implements c.a.p0.j.u.c.b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f9793b = "hasDownloadApk";
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1158589491, "Lc/a/p0/h/j/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1158589491, "Lc/a/p0/h/j/c;");
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
        this.a = "com.baidu.gamenow";
    }

    @Override // c.a.p0.j.u.c.b
    public boolean a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof Download) {
                Download download = (Download) obj;
                if (TextUtils.equals(c.a.p0.h.j.m.c.a, download.getKeyByUser())) {
                    return true;
                }
                return TextUtils.isEmpty(w.d(download.getFromParam()).optString("apk_id"));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.j.u.c.b
    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && (obj instanceof Download)) {
            c.a.p0.h.j.n.a aVar = new c.a.p0.h.j.n.a((Download) obj);
            c.a.p0.h.j.r.b.n().f("reallyDownloaded", new c.a.p0.h.j.r.a(), aVar.m(), aVar.j(), aVar.l());
        }
    }

    @Override // c.a.p0.j.u.c.b
    public void c(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && (obj instanceof Download)) {
            Download download = (Download) obj;
            c.a.p0.h.j.n.a aVar = new c.a.p0.h.j.n.a(download);
            c.a.p0.h.j.r.b.n().f("statusInstalled", new c.a.p0.h.j.r.a(), download.getKeyByUser(), aVar.j(), aVar.l());
            if (TextUtils.equals(aVar.m(), this.a)) {
                c.a.p0.a.o2.g.h.a().putBoolean(f9793b, true);
                c.a.p0.h.j.r.b.n().p(13, aVar.m(), aVar.h(), aVar.l());
            }
        }
    }
}
