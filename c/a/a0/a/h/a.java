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
    public h a;

    /* renamed from: b  reason: collision with root package name */
    public String f1125b;

    /* renamed from: c  reason: collision with root package name */
    public List<i> f1126c;

    /* renamed from: d  reason: collision with root package name */
    public List<i> f1127d;

    /* renamed from: e  reason: collision with root package name */
    public c f1128e;

    /* renamed from: f  reason: collision with root package name */
    public c f1129f;

    /* renamed from: g  reason: collision with root package name */
    public i f1130g;

    /* renamed from: h  reason: collision with root package name */
    public i.c f1131h;

    /* renamed from: i  reason: collision with root package name */
    public Context f1132i;

    /* renamed from: j  reason: collision with root package name */
    public Boolean f1133j;
    public boolean k;
    public i.c l;

    /* renamed from: c.a.a0.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0009a extends i.c<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0009a(a aVar) {
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.a0.a.h.i.c
        /* renamed from: e */
        public void a(i iVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, iVar, str) == null) {
                this.a.f1127d.remove(iVar);
                this.a.f1126c.add(iVar);
                if (iVar == this.a.f1130g) {
                    this.a.a.i(a.m, this.a.f1130g.m());
                }
                if (this.a.q()) {
                    this.a.r();
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
                this.a.s();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.a0.a.h.i.c
        /* renamed from: g */
        public void c(i iVar, long j2, long j3, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{iVar, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
                super.c(iVar, j2, j3, i2);
                int k = this.a.k();
                if (this.a.f1131h != null) {
                    this.a.f1131h.c(this.a, 0L, 100L, k);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
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
            a = new a(null);
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

    public /* synthetic */ a(C0009a c0009a) {
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
            return b.a;
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
                this.f1126c.add(iVar);
                return;
            }
            if (this.f1127d == null) {
                this.f1127d = new ArrayList();
            }
            this.f1127d.add(iVar);
        }
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<i> list = this.f1127d;
            float f2 = 100.0f;
            if (list != null && list.size() != 0) {
                float size = 100.0f / (this.f1126c.size() + this.f1127d.size());
                float f3 = 0.0f;
                for (int i2 = 0; i2 < this.f1127d.size(); i2++) {
                    f3 += (this.f1127d.get(i2).n() / 100.0f) * size;
                }
                f2 = (this.f1126c.size() * size) + f3;
            }
            return (int) f2;
        }
        return invokeV.intValue;
    }

    public File l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1129f.f1141g : (File) invokeV.objValue;
    }

    public File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1128e.f1141g : (File) invokeV.objValue;
    }

    public boolean n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            Boolean bool = this.f1133j;
            if (bool != null && bool.booleanValue()) {
                return this.f1133j.booleanValue();
            }
            this.f1133j = Boolean.FALSE;
            long currentTimeMillis = System.currentTimeMillis();
            boolean k0 = c.a.a0.a.a.k0();
            if (p()) {
                i("ARControllerProxy.loadSoFile " + k0);
            }
            if (!k0) {
                return this.f1133j.booleanValue();
            }
            File file = this.f1129f.f1141g;
            if (p()) {
                i("setResConfig " + file);
            }
            if (file != null) {
                c.a.a0.a.b.s(new c.a.a0.a.c(file.getAbsolutePath()));
            }
            if (p()) {
                i("initRecource costMS: " + (System.currentTimeMillis() - currentTimeMillis));
            }
            Boolean bool2 = Boolean.TRUE;
            this.f1133j = bool2;
            return bool2.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f1126c.clear();
            List<i> list = this.f1127d;
            if (list != null) {
                list.clear();
            }
            if ("live".equals(c.a.a0.a.b.e())) {
                this.f1128e = c.i();
                this.f1129f = c.g();
            }
            if (BdUploadHandler.MEDIA_SOURCE_KEY.equals(c.a.a0.a.b.e())) {
                this.f1128e = c.h();
                this.f1129f = c.f();
            }
            if ("tieba".equals(c.a.a0.a.b.e())) {
                this.f1128e = c.i();
                this.f1129f = c.f();
            }
            c.a.a0.a.h.b bVar = new c.a.a0.a.h.b(this.f1129f);
            this.f1130g = bVar;
            h(bVar);
            h(new c.a.a0.a.h.b(this.f1128e));
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? c.a.a0.a.b.m() : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        List<i> list;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1126c.size() > 0 && ((list = this.f1127d) == null || list.size() == 0) : invokeV.booleanValue;
    }

    public void r() {
        File file;
        i.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                this.k = false;
            }
            boolean n = n(this.f1132i);
            String str = null;
            if (!n && (cVar = this.f1131h) != null) {
                cVar.b(null, null);
                return;
            }
            this.a.n(this.f1125b);
            this.a.f();
            if (p()) {
                i("all onCompleted " + n);
            }
            if (this.f1131h == null || !n) {
                return;
            }
            c cVar2 = this.f1129f;
            if (cVar2 != null && (file = cVar2.f1141g) != null) {
                str = file.getAbsolutePath();
            }
            this.f1131h.a(this, str);
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
            this.f1125b = this.a.e(m);
            List<i> list = this.f1127d;
            if (list != null && list.size() > 0) {
                for (i iVar : this.f1127d) {
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
            this.f1132i = context;
            this.f1131h = cVar;
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
        this.f1126c = new ArrayList();
        this.f1127d = null;
        this.l = new C0009a(this);
        h hVar = new h(d.d().g());
        this.a = hVar;
        hVar.h(m);
        o();
    }
}
