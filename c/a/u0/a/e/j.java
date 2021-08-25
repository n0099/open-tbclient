package c.a.u0.a.e;

import c.a.u0.a.c;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes4.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends c.a.u0.a.f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f30220e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ com.baidu.ubs.analytics.a.a f30221f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f30222g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f30223h;

        public a(Map map, com.baidu.ubs.analytics.a.a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30220e = map;
            this.f30221f = aVar;
            this.f30222g = str;
            this.f30223h = str2;
        }

        @Override // c.a.u0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f30220e != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(StringUtil.ARRAY_START);
                    for (Map.Entry entry : this.f30220e.entrySet()) {
                        stringBuffer.append("\"");
                        stringBuffer.append(entry.getKey());
                        stringBuffer.append("\":\"");
                        stringBuffer.append(entry.getValue().toString().replace("\"", "\\\""));
                        stringBuffer.append("\",");
                    }
                    StringBuffer stringBuffer2 = new StringBuffer(stringBuffer.subSequence(0, stringBuffer.length() - 1));
                    stringBuffer2.append("}");
                    this.f30221f.w(stringBuffer2.toString());
                }
                try {
                    this.f30221f.x(m.e().I());
                    this.f30221f.u(String.valueOf(System.currentTimeMillis()));
                    this.f30221f.t(this.f30222g);
                    this.f30221f.s(this.f30223h == null ? "" : this.f30223h);
                    new c.b().c(this.f30221f);
                } catch (Exception e2) {
                    if (e2.getMessage() != null) {
                        c.a.u0.a.f.a.b(e2.getMessage());
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
            c.a.u0.a.f.b.c(new a(map, aVar, str2, str3));
        }
    }
}
