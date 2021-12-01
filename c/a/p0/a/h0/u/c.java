package c.a.p0.a.h0.u;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends c.a.p0.a.o0.d.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final List<c.a.p0.a.o0.d.b> f6020d;

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
        this.f6020d = new ArrayList();
    }

    @Override // c.a.p0.a.o0.d.b
    public String c(c.a.p0.a.h0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (aVar == null || this.f6020d.size() <= 0) {
                return null;
            }
            int i2 = 0;
            StringBuilder sb = new StringBuilder();
            for (c.a.p0.a.o0.d.b bVar : this.f6020d) {
                sb.append(bVar.d("event" + i2, aVar));
                i2++;
            }
            if (c.a.p0.a.o0.d.b.f7164b) {
                String str = "combine msg - " + sb.toString();
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.p0.a.o0.d.b
    public void h(c.a.p0.a.h0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null || aVar.isWebView() || this.f6020d.size() <= 0) {
            return;
        }
        if (c.a.p0.a.o0.d.b.f7164b) {
            String str = "dispatch event - " + this.a + " on v8";
        }
        for (c.a.p0.a.o0.d.b bVar : this.f6020d) {
            JSEvent e2 = bVar.e(aVar);
            if (e2 != null) {
                j(aVar, e2);
                if (c.a.p0.a.o0.d.b.f7164b) {
                    String str2 = "dispatchJSEvent action - " + e2.type + " on v8 : " + e2.data;
                }
            }
        }
    }

    public c t(c.a.p0.a.o0.d.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            if (bVar != null && !this.f6020d.contains(bVar)) {
                this.f6020d.add(bVar);
            }
            return this;
        }
        return (c) invokeL.objValue;
    }
}
