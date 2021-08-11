package c.a.z.a.h;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.z.a.h.i;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static String m = "def";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public h f30916a;

    /* renamed from: b  reason: collision with root package name */
    public String f30917b;

    /* renamed from: c  reason: collision with root package name */
    public List<i> f30918c;

    /* renamed from: d  reason: collision with root package name */
    public List<i> f30919d;

    /* renamed from: e  reason: collision with root package name */
    public c f30920e;

    /* renamed from: f  reason: collision with root package name */
    public c f30921f;

    /* renamed from: g  reason: collision with root package name */
    public i f30922g;

    /* renamed from: h  reason: collision with root package name */
    public i.c f30923h;

    /* renamed from: i  reason: collision with root package name */
    public Context f30924i;

    /* renamed from: j  reason: collision with root package name */
    public Boolean f30925j;
    public boolean k;
    public i.c l;

    /* renamed from: c.a.z.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1435a extends i.c<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30926a;

        public C1435a(a aVar) {
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
            this.f30926a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.z.a.h.i.c
        /* renamed from: e */
        public void a(i iVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, iVar, str) == null) {
                this.f30926a.f30919d.remove(iVar);
                this.f30926a.f30918c.add(iVar);
                if (iVar == this.f30926a.f30922g) {
                    this.f30926a.f30916a.i(a.m, this.f30926a.f30922g.m());
                }
                if (this.f30926a.q()) {
                    this.f30926a.r();
                }
                super.a(iVar, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.z.a.h.i.c
        /* renamed from: f */
        public void b(i iVar, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, iVar, exc) == null) {
                super.b(iVar, exc);
                this.f30926a.s();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.z.a.h.i.c
        /* renamed from: g */
        public void c(i iVar, long j2, long j3, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{iVar, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
                super.c(iVar, j2, j3, i2);
                int k = this.f30926a.k();
                if (this.f30926a.f30923h != null) {
                    this.f30926a.f30923h.c(this.f30926a, 0L, 100L, k);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f30927a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2057656268, "Lc/a/z/a/h/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2057656268, "Lc/a/z/a/h/a$b;");
                    return;
                }
            }
            f30927a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-958751606, "Lc/a/z/a/h/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-958751606, "Lc/a/z/a/h/a;");
        }
    }

    public /* synthetic */ a(C1435a c1435a) {
        this();
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
        }
    }

    public static final a j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            m = str;
            return b.f30927a;
        }
        return (a) invokeL.objValue;
    }

    public final void h(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            boolean q = iVar.q();
            if (p()) {
                i("isLoaded " + q + StringUtil.ARRAY_ELEMENT_SEPARATOR + iVar.o() + " to " + iVar.m());
            }
            if (iVar.q()) {
                this.f30918c.add(iVar);
                return;
            }
            if (this.f30919d == null) {
                this.f30919d = new ArrayList();
            }
            this.f30919d.add(iVar);
        }
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<i> list = this.f30919d;
            float f2 = 100.0f;
            if (list != null && list.size() != 0) {
                float size = 100.0f / (this.f30918c.size() + this.f30919d.size());
                float f3 = 0.0f;
                for (int i2 = 0; i2 < this.f30919d.size(); i2++) {
                    f3 += (this.f30919d.get(i2).n() / 100.0f) * size;
                }
                f2 = (this.f30918c.size() * size) + f3;
            }
            return (int) f2;
        }
        return invokeV.intValue;
    }

    public File l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30921f.f30937g : (File) invokeV.objValue;
    }

    public File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30920e.f30937g : (File) invokeV.objValue;
    }

    public boolean n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            Boolean bool = this.f30925j;
            if (bool != null && bool.booleanValue()) {
                return this.f30925j.booleanValue();
            }
            this.f30925j = Boolean.FALSE;
            long currentTimeMillis = System.currentTimeMillis();
            boolean k0 = c.a.z.a.a.k0();
            if (p()) {
                i("ARControllerProxy.loadSoFile " + k0);
            }
            if (!k0) {
                return this.f30925j.booleanValue();
            }
            File file = this.f30921f.f30937g;
            if (p()) {
                i("setResConfig " + file);
            }
            if (file != null) {
                c.a.z.a.b.u(new c.a.z.a.c(file.getAbsolutePath()));
            }
            if (p()) {
                i("initRecource costMS: " + (System.currentTimeMillis() - currentTimeMillis));
            }
            Boolean bool2 = Boolean.TRUE;
            this.f30925j = bool2;
            return bool2.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f30918c.clear();
            List<i> list = this.f30919d;
            if (list != null) {
                list.clear();
            }
            if ("live".equals(c.a.z.a.b.f())) {
                this.f30920e = c.i();
                this.f30921f = c.g();
            }
            if (BdUploadHandler.MEDIA_SOURCE_KEY.equals(c.a.z.a.b.f())) {
                this.f30920e = c.h();
                this.f30921f = c.f();
            }
            if ("tieba".equals(c.a.z.a.b.f())) {
                this.f30920e = c.i();
                this.f30921f = c.f();
            }
            c.a.z.a.h.b bVar = new c.a.z.a.h.b(this.f30921f);
            this.f30922g = bVar;
            h(bVar);
            h(new c.a.z.a.h.b(this.f30920e));
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? c.a.z.a.b.n() : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        List<i> list;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f30918c.size() > 0 && ((list = this.f30919d) == null || list.size() == 0) : invokeV.booleanValue;
    }

    public void r() {
        File file;
        i.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean n = n(this.f30924i);
            String str = null;
            if (!n && (cVar = this.f30923h) != null) {
                cVar.b(null, null);
                return;
            }
            this.f30916a.n(this.f30917b);
            this.f30916a.f();
            if (p()) {
                i("all onCompleted " + n);
            }
            synchronized (this) {
                this.k = false;
            }
            if (this.f30923h == null || !n) {
                return;
            }
            c cVar2 = this.f30921f;
            if (cVar2 != null && (file = cVar2.f30937g) != null) {
                str = file.getAbsolutePath();
            }
            this.f30923h.a(this, str);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (p()) {
                i("all onFailed .");
            }
            synchronized (this) {
                this.k = false;
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f30917b = this.f30916a.e(m);
            List<i> list = this.f30919d;
            if (list != null && list.size() > 0) {
                for (i iVar : this.f30919d) {
                    iVar.l(this.l);
                }
                return;
            }
            r();
        }
    }

    public void u(Context context, i.c<a> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, cVar) == null) {
            this.f30924i = context;
            this.f30923h = cVar;
            synchronized (this) {
                if (this.k) {
                    if (p()) {
                        i("start return, isLoading true");
                    }
                    return;
                }
                this.k = true;
                o();
                t();
            }
        }
    }

    public a() {
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
        this.f30918c = new ArrayList();
        this.f30919d = null;
        this.l = new C1435a(this);
        h hVar = new h(d.d().g());
        this.f30916a = hVar;
        hVar.h(m);
        o();
    }
}
