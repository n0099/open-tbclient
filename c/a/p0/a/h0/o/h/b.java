package c.a.p0.a.h0.o.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.h0.o.h.g.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b extends c.a.p0.a.h0.o.h.g.a implements c.a.p0.a.h0.o.h.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.a.h0.o.h.d.b.a f6308e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull Context context, c.a.p0.a.h0.o.h.c.a aVar) {
        super(context, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (c.a.p0.a.h0.o.h.c.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6308e = c.a.p0.a.h0.o.h.d.a.a().f();
    }

    @Override // c.a.p0.a.h0.o.h.g.a
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "image" : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.h0.o.h.g.a
    public Map<String, String> f(@NonNull g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar)) == null) {
            Map<String, String> requestHeaders = gVar.getRequestHeaders();
            if (requestHeaders == null) {
                requestHeaders = new HashMap<>();
            }
            String f2 = c.a.p0.a.l2.b.l().f(e(gVar.d()), requestHeaders.get("Cookie"));
            if (!TextUtils.isEmpty(f2)) {
                requestHeaders.put("Cookie", f2);
                if (c.a.p0.a.h0.o.h.e.a.f6322a) {
                    String str = "addCookiesToHeader cookie: " + f2;
                }
            }
            return requestHeaders;
        }
        return (Map) invokeL.objValue;
    }

    @Override // c.a.p0.a.h0.o.h.g.a
    public boolean i(@NonNull g gVar) {
        InterceptResult invokeL;
        Map<String, String> requestHeaders;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar)) == null) {
            if (gVar.c()) {
                return this.f6308e.a(gVar) && (requestHeaders = gVar.getRequestHeaders()) != null && requestHeaders.containsKey("Accept") && (str = requestHeaders.get("Accept")) != null && str.startsWith("image");
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
