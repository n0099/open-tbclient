package c.f.a.g.d.h;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.restnet.RestMultipartEntity;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.http.HttpDefines$HttpMethod;
import com.dxmpay.apollon.restnet.rest.RestHttpNetwork;
import com.dxmpay.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static c f32085a;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    public static synchronized c b() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (c.class) {
                if (f32085a == null) {
                    f32085a = new c();
                }
                cVar = f32085a;
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public c.f.a.g.d.d a(Context context, String str, String str2, String str3, HttpDefines$HttpMethod httpDefines$HttpMethod, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, str3, httpDefines$HttpMethod, list, restMultipartEntity, str4, Boolean.valueOf(z)})) == null) ? new RestUrlConnectionRequest(new RestHttpNetwork(new b(context, str2, z)), str3, httpDefines$HttpMethod, list, restMultipartEntity, str4) : (c.f.a.g.d.d) invokeCommon.objValue;
    }
}
