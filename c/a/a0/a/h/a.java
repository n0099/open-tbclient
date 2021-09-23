package c.a.a0.a.h;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.a.h.i;
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
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static String m = "def";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public h f1670a;

    /* renamed from: b  reason: collision with root package name */
    public String f1671b;

    /* renamed from: c  reason: collision with root package name */
    public List<i> f1672c;

    /* renamed from: d  reason: collision with root package name */
    public List<i> f1673d;

    /* renamed from: e  reason: collision with root package name */
    public c f1674e;

    /* renamed from: f  reason: collision with root package name */
    public c f1675f;

    /* renamed from: g  reason: collision with root package name */
    public i f1676g;

    /* renamed from: h  reason: collision with root package name */
    public i.c f1677h;

    /* renamed from: i  reason: collision with root package name */
    public Context f1678i;

    /* renamed from: j  reason: collision with root package name */
    public Boolean f1679j;
    public boolean k;
    public i.c l;

    /* renamed from: c.a.a0.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0015a extends i.c<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f1680a;

        public C0015a(a aVar) {
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
            this.f1680a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.a0.a.h.i.c
        /* renamed from: e */
        public void a(i iVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, iVar, str) == null) {
                this.f1680a.f1673d.remove(iVar);
                this.f1680a.f1672c.add(iVar);
                if (iVar == this.f1680a.f1676g) {
                    this.f1680a.f1670a.i(a.m, this.f1680a.f1676g.m());
                }
                if (this.f1680a.q()) {
                    this.f1680a.r();
                }
                super.a(iVar, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.a0.a.h.i.c
        /* renamed from: f */
        public void b(i iVar, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, iVar, exc) == null) {
                super.b(iVar, exc);
                this.f1680a.s();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.a0.a.h.i.c
        /* renamed from: g */
        public void c(i iVar, long j2, long j3, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{iVar, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
                super.c(iVar, j2, j3, i2);
                int k = this.f1680a.k();
                if (this.f1680a.f1677h != null) {
                    this.f1680a.f1677h.c(this.f1680a, 0L, 100L, k);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f1681a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(804388075, "Lc/a/a0/a/h/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(804388075, "Lc/a/a0/a/h/a$b;");
                    return;
                }
            }
            f1681a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-17040023, "Lc/a/a0/a/h/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-17040023, "Lc/a/a0/a/h/a;");
        }
    }

    public /* synthetic */ a(C0015a c0015a) {
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
            return b.f1681a;
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
                this.f1672c.add(iVar);
                return;
            }
            if (this.f1673d == null) {
                this.f1673d = new ArrayList();
            }
            this.f1673d.add(iVar);
        }
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<i> list = this.f1673d;
            float f2 = 100.0f;
            if (list != null && list.size() != 0) {
                float size = 100.0f / (this.f1672c.size() + this.f1673d.size());
                float f3 = 0.0f;
                for (int i2 = 0; i2 < this.f1673d.size(); i2++) {
                    f3 += (this.f1673d.get(i2).n() / 100.0f) * size;
                }
                f2 = (this.f1672c.size() * size) + f3;
            }
            return (int) f2;
        }
        return invokeV.intValue;
    }

    public File l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1675f.f1691g : (File) invokeV.objValue;
    }

    public File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1674e.f1691g : (File) invokeV.objValue;
    }

    public boolean n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            Boolean bool = this.f1679j;
            if (bool != null && bool.booleanValue()) {
                return this.f1679j.booleanValue();
            }
            this.f1679j = Boolean.FALSE;
            long currentTimeMillis = System.currentTimeMillis();
            boolean k0 = c.a.a0.a.a.k0();
            if (p()) {
                i("ARControllerProxy.loadSoFile " + k0);
            }
            if (!k0) {
                return this.f1679j.booleanValue();
            }
            File file = this.f1675f.f1691g;
            if (p()) {
                i("setResConfig " + file);
            }
            if (file != null) {
                c.a.a0.a.b.t(new c.a.a0.a.c(file.getAbsolutePath()));
            }
            if (p()) {
                i("initRecource costMS: " + (System.currentTimeMillis() - currentTimeMillis));
            }
            Boolean bool2 = Boolean.TRUE;
            this.f1679j = bool2;
            return bool2.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f1672c.clear();
            List<i> list = this.f1673d;
            if (list != null) {
                list.clear();
            }
            if ("live".equals(c.a.a0.a.b.f())) {
                this.f1674e = c.i();
                this.f1675f = c.g();
            }
            if (BdUploadHandler.MEDIA_SOURCE_KEY.equals(c.a.a0.a.b.f())) {
                this.f1674e = c.h();
                this.f1675f = c.f();
            }
            if ("tieba".equals(c.a.a0.a.b.f())) {
                this.f1674e = c.i();
                this.f1675f = c.f();
            }
            c.a.a0.a.h.b bVar = new c.a.a0.a.h.b(this.f1675f);
            this.f1676g = bVar;
            h(bVar);
            h(new c.a.a0.a.h.b(this.f1674e));
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? c.a.a0.a.b.n() : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        List<i> list;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1672c.size() > 0 && ((list = this.f1673d) == null || list.size() == 0) : invokeV.booleanValue;
    }

    public void r() {
        File file;
        i.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean n = n(this.f1678i);
            String str = null;
            if (!n && (cVar = this.f1677h) != null) {
                cVar.b(null, null);
                return;
            }
            this.f1670a.n(this.f1671b);
            this.f1670a.f();
            if (p()) {
                i("all onCompleted " + n);
            }
            synchronized (this) {
                this.k = false;
            }
            if (this.f1677h == null || !n) {
                return;
            }
            c cVar2 = this.f1675f;
            if (cVar2 != null && (file = cVar2.f1691g) != null) {
                str = file.getAbsolutePath();
            }
            this.f1677h.a(this, str);
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
            this.f1671b = this.f1670a.e(m);
            List<i> list = this.f1673d;
            if (list != null && list.size() > 0) {
                for (i iVar : this.f1673d) {
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
            this.f1678i = context;
            this.f1677h = cVar;
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
        this.f1672c = new ArrayList();
        this.f1673d = null;
        this.l = new C0015a(this);
        h hVar = new h(d.d().g());
        this.f1670a = hVar;
        hVar.h(m);
        o();
    }
}
