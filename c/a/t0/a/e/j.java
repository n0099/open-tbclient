package c.a.t0.a.e;

import c.a.t0.a.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes3.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends c.a.t0.a.f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ com.baidu.ubs.analytics.a.a f21362b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f21363c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f21364d;

        public a(Map map, com.baidu.ubs.analytics.a.a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = map;
            this.f21362b = aVar;
            this.f21363c = str;
            this.f21364d = str2;
        }

        @Override // c.a.t0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("{");
                    for (Map.Entry entry : this.a.entrySet()) {
                        stringBuffer.append("\"");
                        stringBuffer.append(entry.getKey());
                        stringBuffer.append("\":\"");
                        stringBuffer.append(entry.getValue().toString().replace("\"", "\\\""));
                        stringBuffer.append("\",");
                    }
                    StringBuffer stringBuffer2 = new StringBuffer(stringBuffer.subSequence(0, stringBuffer.length() - 1));
                    stringBuffer2.append("}");
                    this.f21362b.w(stringBuffer2.toString());
                }
                try {
                    this.f21362b.x(m.f().I());
                    this.f21362b.u(String.valueOf(System.currentTimeMillis()));
                    this.f21362b.t(this.f21363c);
                    this.f21362b.s(this.f21364d == null ? "" : this.f21364d);
                    new c.b().c(this.f21362b);
                } catch (Exception e2) {
                    if (e2.getMessage() != null) {
                        c.a.t0.a.f.a.b(e2.getMessage());
                    }
                }
            }
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, str, str2, str3, map) == null) {
            com.baidu.ubs.analytics.a.a aVar = new com.baidu.ubs.analytics.a.a();
            aVar.v(str);
            c.a.t0.a.f.b.c(new a(map, aVar, str2, str3));
        }
    }
}
