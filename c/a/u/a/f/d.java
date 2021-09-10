package c.a.u.a.f;

import android.content.Context;
import c.a.u.a.c.a;
import c.a.u.a.c.f;
import c.a.u.a.h.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMHttpDnsUrlRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.daemon.HttpDnsCacheForHost;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public a.d f30250b;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30250b = null;
        this.f30246a = context;
    }

    public void a(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.f30250b = dVar;
        }
    }

    @Override // c.a.u.a.f.c.b
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Host", IMHttpDnsUrlRequest.HTTP_DNS_HOST);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // c.a.u.a.f.c.b
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? IMHttpDnsUrlRequest.HTTP_DNS_URL : (String) invokeV.objValue;
    }

    @Override // c.a.u.a.f.c.b
    public String getMediaType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
    }

    @Override // c.a.u.a.f.a, c.a.u.a.f.c.b
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "GET" : (String) invokeV.objValue;
    }

    @Override // c.a.u.a.f.c.b
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return ("type=ipv4,ipv6&dn=" + f.S(this.f30246a).x).getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // c.a.u.a.f.c.d
    public void onFailure(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) {
            e.b("LCPHttpDnsUrlRequest", "HttpDns failure errorcode:" + i2 + ",errormsg:" + str);
            c.a.u.a.c.a.f(true);
            c.a.u.a.c.a.c(this.f30246a).b(f.S(this.f30246a).x, this.f30250b);
        }
    }

    @Override // c.a.u.a.f.c.d
    public void onSuccess(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bArr) == null) {
            String str = new String(bArr);
            e.a("LCPHttpDnsUrlRequest", "onSuccess----ip of " + f.S(this.f30246a).x + " is " + str);
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("data").getJSONObject(f.S(this.f30246a).x);
                JSONArray optJSONArray = jSONObject.optJSONArray("ip");
                JSONArray optJSONArray2 = jSONObject.optJSONArray(HttpDnsCacheForHost.JSON_KEY_IPV6);
                int length = optJSONArray2 == null ? 0 : optJSONArray2.length();
                int length2 = optJSONArray == null ? 0 : optJSONArray.length();
                if (length2 + length > 0) {
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray != null && length2 > 0) {
                        arrayList.add(optJSONArray.getString(0));
                    }
                    if (optJSONArray2 != null && length > 0) {
                        arrayList.add(optJSONArray2.getString(0));
                    }
                    c.a.u.a.c.a.j(arrayList);
                    if (this.f30250b == null || c.a.u.a.c.a.f30174c.size() <= 0) {
                        return;
                    }
                    this.f30250b.a(0, "ok", c.a.u.a.c.a.f30174c.get(0));
                    if (c.a.u.a.c.a.f30174c.size() > 1) {
                        c.a.u.a.c.a.f30175d++;
                        return;
                    }
                    return;
                }
                e.b("LCPHttpDnsUrlRequest", "HttpDnsResponse ips is null ");
                c.a.u.a.c.a.f(true);
                c.a.u.a.c.a.c(this.f30246a).b(f.S(this.f30246a).x, this.f30250b);
            } catch (Exception e2) {
                e.b("LCPHttpDnsUrlRequest", "HttpDnsRequester ip parse exception " + e2.getMessage());
                c.a.u.a.c.a.f(true);
                c.a.u.a.c.a.c(this.f30246a).b(f.S(this.f30246a).x, this.f30250b);
            }
        }
    }
}
