package c.a.p0.l3.g0.o;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
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
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f16206b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<BasicNameValuePair> f16207c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, byte[]> f16208d;

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.f16206b = new HashMap();
        this.f16207c = new LinkedList<>();
        this.f16208d = new HashMap<>();
    }

    public void a(String str, String str2) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || (map = this.f16206b) == null) {
            return;
        }
        map.put(str, str2);
    }

    public void b(BasicNameValuePair basicNameValuePair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, basicNameValuePair) == null) {
            this.f16207c.add(basicNameValuePair);
        }
    }

    public String c(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            if (this.f16207c.size() == 0) {
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
            for (int i = 0; i < this.f16207c.size(); i++) {
                if (i != 0) {
                    sb.append("&");
                }
                sb.append(this.f16207c.get(i).getName());
                sb.append("=");
                sb.append(m.getUrlEncode(this.f16207c.get(i).getValue()));
            }
            if (eVar != null) {
                eVar.a = sb.length();
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            Map<String, String> map = this.f16206b;
            if (map != null) {
                return map.get(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            HashMap<String, byte[]> hashMap = this.f16208d;
            return hashMap != null && hashMap.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public final StringBuilder g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuilder sb = new StringBuilder(1024);
            LinkedList<BasicNameValuePair> linkedList = this.f16207c;
            if (linkedList != null) {
                int i = 0;
                Iterator<BasicNameValuePair> it = linkedList.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    if (next != null) {
                        String name = next.getName();
                        String value = next.getValue();
                        if (i != 0) {
                            sb.append("&");
                        }
                        sb.append(name + "=");
                        sb.append(m.getUrlEncode(value));
                        i++;
                    }
                }
            }
            return sb;
        }
        return (StringBuilder) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (str == null) {
                this.a = "";
            } else {
                this.a = str;
            }
        }
    }

    public void j(HttpURLConnection httpURLConnection) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, httpURLConnection) == null) || httpURLConnection == null || (map = this.f16206b) == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public void k(HttpURLConnection httpURLConnection, e eVar) throws Exception {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, httpURLConnection, eVar) == null) {
            if (httpURLConnection != null) {
                String sb = g().toString();
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream.writeBytes(sb);
                    dataOutputStream.flush();
                    c.a.d.f.m.a.d(dataOutputStream);
                    i = sb.length();
                } catch (Throwable th) {
                    c.a.d.f.m.a.d(dataOutputStream);
                    throw th;
                }
            } else {
                i = 0;
            }
            if (eVar != null) {
                eVar.a = i;
            }
        }
    }

    public void l(HttpURLConnection httpURLConnection, String str, e eVar) throws Exception {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, httpURLConnection, str, eVar) == null) {
            h();
            if (httpURLConnection != null) {
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    if (this.f16207c != null) {
                        Iterator<BasicNameValuePair> it = this.f16207c.iterator();
                        while (it.hasNext()) {
                            BasicNameValuePair next = it.next();
                            if (next != null) {
                                String name = next.getName();
                                String value = next.getValue();
                                if (value != null && name != null) {
                                    dataOutputStream.writeBytes("--" + str + "\r\n");
                                    byte[] bytes = value.getBytes("UTF-8");
                                    dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"\r\n");
                                    dataOutputStream.writeBytes("\r\n");
                                    dataOutputStream.write(bytes);
                                    dataOutputStream.writeBytes("\r\n");
                                }
                            }
                        }
                    }
                    if (this.f16208d != null) {
                        for (Map.Entry<String, byte[]> entry : this.f16208d.entrySet()) {
                            String key = entry.getKey();
                            byte[] value2 = entry.getValue();
                            if (value2 != null) {
                                dataOutputStream.writeBytes("--" + str + "\r\n");
                                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"\r\n");
                                dataOutputStream.writeBytes("\r\n");
                                dataOutputStream.write(value2);
                                dataOutputStream.writeBytes("\r\n");
                            }
                        }
                    }
                    dataOutputStream.writeBytes("--" + str + "--\r\n");
                    dataOutputStream.flush();
                    i = dataOutputStream.size();
                } finally {
                    c.a.d.f.m.a.d(dataOutputStream);
                }
            } else {
                i = 0;
            }
            if (eVar != null) {
                eVar.a = i;
            }
        }
    }
}
