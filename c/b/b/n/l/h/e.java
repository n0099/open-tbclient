package c.b.b.n.l.h;

import c.b.b.q.a;
import c.b.b.q.l;
import c.b.b.q.o;
import c.b.b.q.w;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class e<T> implements o.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public w<String, b> f27671e;

    /* renamed from: f  reason: collision with root package name */
    public c.b.b.q.a<b> f27672f;

    /* renamed from: g  reason: collision with root package name */
    public c.b.b.q.a<a> f27673g;

    /* renamed from: h  reason: collision with root package name */
    public T f27674h;

    /* loaded from: classes7.dex */
    public static class a<T> implements o.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f27675e;

        /* renamed from: f  reason: collision with root package name */
        public Class<T> f27676f;

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
                }
            }
        }

        @Override // c.b.b.q.o.c
        public void a(o oVar, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, oVar, jsonValue) == null) {
                this.f27675e = (String) oVar.l(BreakpointSQLiteKey.FILENAME, String.class, jsonValue);
                String str = (String) oVar.l("type", String.class, jsonValue);
                try {
                    this.f27676f = c.b.b.q.p0.b.a(str);
                } catch (ReflectionException e2) {
                    throw new GdxRuntimeException("Class not found: " + str, e2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements o.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public l f27677e;

        /* renamed from: f  reason: collision with root package name */
        public e f27678f;

        public b() {
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
            new w();
            this.f27677e = new l();
        }

        @Override // c.b.b.q.o.c
        public void a(o oVar, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, oVar, jsonValue) == null) {
                w wVar = (w) oVar.l("data", w.class, jsonValue);
                this.f27677e.b((int[]) oVar.l("indices", int[].class, jsonValue));
            }
        }
    }

    public e() {
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
        this.f27671e = new w<>();
        this.f27672f = new c.b.b.q.a<>(true, 3, b.class);
        this.f27673g = new c.b.b.q.a<>();
    }

    @Override // c.b.b.q.o.c
    public void a(o oVar, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, oVar, jsonValue) == null) {
            w<String, b> wVar = (w) oVar.l("unique", w.class, jsonValue);
            this.f27671e = wVar;
            w.a<String, b> b2 = wVar.b();
            b2.d();
            while (b2.hasNext()) {
                ((b) b2.next().f27939b).f27678f = this;
            }
            c.b.b.q.a<b> aVar = (c.b.b.q.a) oVar.m("data", c.b.b.q.a.class, b.class, jsonValue);
            this.f27672f = aVar;
            a.b<b> it = aVar.iterator();
            while (it.hasNext()) {
                it.next().f27678f = this;
            }
            this.f27673g.b((c.b.b.q.a) oVar.m("assets", c.b.b.q.a.class, a.class, jsonValue));
            this.f27674h = (T) oVar.l("resource", null, jsonValue);
        }
    }

    public c.b.b.q.a<a> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27673g : (c.b.b.q.a) invokeV.objValue;
    }
}
