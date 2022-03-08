package c.a.d.f.j.b;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public HttpMessageTask.HTTP_METHOD f2616b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f2617c;

    /* renamed from: d  reason: collision with root package name */
    public LinkedList<BasicNameValuePair> f2618d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f2619e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, byte[]> f2620f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2621g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2622h;

    public g() {
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
        this.a = "";
        this.f2617c = new HashMap();
        this.f2618d = new LinkedList<>();
        this.f2619e = new LinkedHashMap();
        this.f2620f = new HashMap<>();
        this.f2621g = false;
        this.f2622h = false;
    }

    public void a(String str, String str2) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || (map = this.f2617c) == null) {
            return;
        }
        map.put(str, str2);
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || str2 == null) {
            return;
        }
        this.f2618d.add(new BasicNameValuePair(str, str2));
        this.f2619e.put(str, str2);
    }

    public void c(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bArr) == null) {
            this.f2620f.put(str, bArr);
        }
    }

    public void d(BasicNameValuePair basicNameValuePair) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, basicNameValuePair) == null) || basicNameValuePair == null || basicNameValuePair.getValue() == null) {
            return;
        }
        this.f2618d.add(basicNameValuePair);
        this.f2619e.put(basicNameValuePair.getName(), basicNameValuePair.getValue());
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f2621g : invokeV.booleanValue;
    }

    public String f(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (this.f2618d.size() == 0) {
                if (eVar != null) {
                    eVar.a = this.a.length();
                }
                return this.a;
            }
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.a);
            if (this.a.indexOf("?") < 0) {
                sb.append("?");
            } else if (!this.a.endsWith("?") && !this.a.endsWith("&")) {
                sb.append("&");
            }
            for (int i2 = 0; i2 < this.f2618d.size(); i2++) {
                if (i2 != 0) {
                    sb.append("&");
                }
                sb.append(this.f2618d.get(i2).getName());
                sb.append("=");
                sb.append(m.getUrlEncode(this.f2618d.get(i2).getValue()));
            }
            if (eVar != null) {
                eVar.a = sb.length();
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            Map<String, String> map = this.f2617c;
            if (map != null) {
                return map.get(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public Map<String, String> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f2617c : (Map) invokeV.objValue;
    }

    public HttpMessageTask.HTTP_METHOD i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f2616b : (HttpMessageTask.HTTP_METHOD) invokeV.objValue;
    }

    public Map<String, String> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f2619e : (Map) invokeV.objValue;
    }

    public LinkedList<BasicNameValuePair> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f2618d : (LinkedList) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            HashMap<String, byte[]> hashMap = this.f2620f;
            return hashMap != null && hashMap.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f2622h : invokeV.booleanValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f2622h = z;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f2621g = z;
        }
    }

    public void q(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, hashMap) == null) {
            this.f2617c = hashMap;
        }
    }

    public void r(HttpMessageTask.HTTP_METHOD http_method) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, http_method) == null) {
            this.f2616b = http_method;
        }
    }

    public void s(List<Map.Entry<String, Object>> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, list) == null) || list == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : list) {
            Object value = entry.getValue();
            if (value != null) {
                if (value instanceof String) {
                    if (entry.getValue() != null) {
                        this.f2618d.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
                        this.f2619e.put(entry.getKey(), (String) entry.getValue());
                    }
                } else if (value instanceof byte[]) {
                    this.f2620f.put(entry.getKey(), (byte[]) entry.getValue());
                } else {
                    throw new UnsupportedOperationException("post type is not String and byte[]");
                }
            }
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            if (str == null) {
                this.a = "";
            } else {
                this.a = str;
            }
        }
    }

    public void u(HttpURLConnection httpURLConnection) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, httpURLConnection) == null) || httpURLConnection == null || (map = this.f2617c) == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
    }
}
