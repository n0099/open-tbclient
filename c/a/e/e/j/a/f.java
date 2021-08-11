package c.a.e.e.j.a;

import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import com.android.internal.http.multipart.Part;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f2262a;

    /* renamed from: b  reason: collision with root package name */
    public HttpMessageTask.HTTP_METHOD f2263b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f2264c;

    /* renamed from: d  reason: collision with root package name */
    public LinkedList<BasicNameValuePair> f2265d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, byte[]> f2266e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2267f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2268g;

    public f() {
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
        this.f2262a = "";
        this.f2264c = new HashMap();
        this.f2265d = new LinkedList<>();
        this.f2266e = new HashMap<>();
        this.f2267f = false;
        this.f2268g = false;
    }

    public void a(String str, String str2) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || (map = this.f2264c) == null) {
            return;
        }
        map.put(str, str2);
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            this.f2265d.add(new BasicNameValuePair(str, str2));
        }
    }

    public void c(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bArr) == null) {
            this.f2266e.put(str, bArr);
        }
    }

    public void d(BasicNameValuePair basicNameValuePair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, basicNameValuePair) == null) {
            this.f2265d.add(basicNameValuePair);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f2267f : invokeV.booleanValue;
    }

    public String f(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, dVar)) == null) {
            if (this.f2265d.size() == 0) {
                if (dVar != null) {
                    dVar.f2248a = this.f2262a.length();
                }
                return this.f2262a;
            }
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.f2262a);
            if (this.f2262a.indexOf("?") < 0) {
                sb.append("?");
            } else if (!this.f2262a.endsWith("?") && !this.f2262a.endsWith("&")) {
                sb.append("&");
            }
            for (int i2 = 0; i2 < this.f2265d.size(); i2++) {
                if (i2 != 0) {
                    sb.append("&");
                }
                sb.append(this.f2265d.get(i2).getName());
                sb.append("=");
                sb.append(k.getUrlEncode(this.f2265d.get(i2).getValue()));
            }
            if (dVar != null) {
                dVar.f2248a = sb.length();
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            Map<String, String> map = this.f2264c;
            if (map != null) {
                return map.get(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public HttpMessageTask.HTTP_METHOD h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f2263b : (HttpMessageTask.HTTP_METHOD) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f2262a : (String) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            HashMap<String, byte[]> hashMap = this.f2266e;
            return hashMap != null && hashMap.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f2268g : invokeV.booleanValue;
    }

    public final StringBuilder l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            StringBuilder sb = new StringBuilder(1024);
            LinkedList<BasicNameValuePair> linkedList = this.f2265d;
            if (linkedList != null) {
                int i2 = 0;
                Iterator<BasicNameValuePair> it = linkedList.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    if (next != null) {
                        String name = next.getName();
                        String value = next.getValue();
                        if (i2 != 0) {
                            sb.append("&");
                        }
                        sb.append(name + "=");
                        sb.append(k.getUrlEncode(value));
                        i2++;
                    }
                }
            }
            return sb;
        }
        return (StringBuilder) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f2268g = z;
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f2267f = z;
        }
    }

    public void p(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, hashMap) == null) {
            this.f2264c = hashMap;
        }
    }

    public void q(HttpMessageTask.HTTP_METHOD http_method) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, http_method) == null) {
            this.f2263b = http_method;
        }
    }

    public void r(List<Map.Entry<String, Object>> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, list) == null) || list == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : list) {
            Object value = entry.getValue();
            if (value != null) {
                if (value instanceof String) {
                    this.f2265d.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
                } else if (value instanceof byte[]) {
                    this.f2266e.put(entry.getKey(), (byte[]) entry.getValue());
                } else {
                    throw new UnsupportedOperationException("post type is not String and byte[]");
                }
            }
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            if (str == null) {
                this.f2262a = "";
            } else {
                this.f2262a = str;
            }
        }
    }

    public void t(HttpURLConnection httpURLConnection) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, httpURLConnection) == null) || httpURLConnection == null || (map = this.f2264c) == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public void u(HttpURLConnection httpURLConnection, d dVar) throws Exception {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, httpURLConnection, dVar) == null) {
            if (httpURLConnection != null) {
                String sb = l().toString();
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream.writeBytes(sb);
                    dataOutputStream.flush();
                    c.a.e.e.m.a.d(dataOutputStream);
                    i2 = sb.length();
                } catch (Throwable th) {
                    c.a.e.e.m.a.d(dataOutputStream);
                    throw th;
                }
            } else {
                i2 = 0;
            }
            if (dVar != null) {
                dVar.f2248a = i2;
            }
        }
    }

    public void v(HttpURLConnection httpURLConnection, String str, d dVar) throws Exception {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, httpURLConnection, str, dVar) == null) {
            m();
            if (httpURLConnection != null) {
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    if (this.f2265d != null) {
                        Iterator<BasicNameValuePair> it = this.f2265d.iterator();
                        while (it.hasNext()) {
                            BasicNameValuePair next = it.next();
                            if (next != null) {
                                String name = next.getName();
                                String value = next.getValue();
                                if (value != null && name != null) {
                                    dataOutputStream.writeBytes("--" + str + Part.CRLF);
                                    byte[] bytes = value.getBytes("UTF-8");
                                    dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"" + Part.CRLF);
                                    dataOutputStream.writeBytes(Part.CRLF);
                                    dataOutputStream.write(bytes);
                                    dataOutputStream.writeBytes(Part.CRLF);
                                }
                            }
                        }
                    }
                    if (this.f2266e != null) {
                        for (Map.Entry<String, byte[]> entry : this.f2266e.entrySet()) {
                            String key = entry.getKey();
                            byte[] value2 = entry.getValue();
                            if (value2 != null) {
                                dataOutputStream.writeBytes("--" + str + Part.CRLF);
                                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"" + Part.CRLF);
                                dataOutputStream.writeBytes(Part.CRLF);
                                dataOutputStream.write(value2);
                                dataOutputStream.writeBytes(Part.CRLF);
                            }
                        }
                    }
                    dataOutputStream.writeBytes("--" + str + "--" + Part.CRLF);
                    dataOutputStream.flush();
                    i2 = dataOutputStream.size();
                } finally {
                    c.a.e.e.m.a.d(dataOutputStream);
                }
            } else {
                i2 = 0;
            }
            if (dVar != null) {
                dVar.f2248a = i2;
            }
        }
    }
}
