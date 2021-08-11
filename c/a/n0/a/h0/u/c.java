package c.a.n0.a.h0.u;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.landingpage.XDetailPageJavaScript;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends c.a.n0.a.o0.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.n0.a.o0.d.a> f6195d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c() {
        super("combine");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6195d = new ArrayList();
    }

    @Override // c.a.n0.a.o0.d.a
    public String b(c.a.n0.a.h0.f.a aVar) {
        InterceptResult invokeL;
        String str;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (aVar == null || this.f6195d.size() <= 0) {
                return null;
            }
            int i2 = 0;
            StringBuilder sb = new StringBuilder();
            for (c.a.n0.a.o0.d.a aVar2 : this.f6195d) {
                String str2 = "event" + i2;
                if (aVar.isWebView()) {
                    str = "var " + str2 + " = new Event('" + aVar2.f7521a + "');";
                    c2 = "";
                } else {
                    str = "var " + str2 + " = new Object();";
                    c2 = c.a.n0.a.o0.a.c(str2, "type", aVar2.f7521a);
                }
                sb.append(str);
                sb.append(c2);
                sb.append(aVar2.f(str2));
                sb.append(c.a.n0.a.o0.a.e(aVar));
                sb.append(".dispatchEvent(");
                sb.append(str2);
                sb.append(");");
                i2++;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("javascript:(function(){");
            stringBuffer.append((CharSequence) sb);
            stringBuffer.append(XDetailPageJavaScript.STATIC_JAVASCRIPT_FUNC_OVER);
            if (c.a.n0.a.o0.d.a.f7520b) {
                String str3 = "combine msg - " + stringBuffer.toString();
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public c h(c.a.n0.a.o0.d.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (aVar != null && !this.f6195d.contains(aVar)) {
                this.f6195d.add(aVar);
            }
            return this;
        }
        return (c) invokeL.objValue;
    }
}
