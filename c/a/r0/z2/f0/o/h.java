package c.a.r0.z2.f0.o;

import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import com.android.internal.http.multipart.Part;
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
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f29646a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f29647b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<BasicNameValuePair> f29648c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, byte[]> f29649d;

    public h() {
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
        this.f29646a = "";
        this.f29647b = new HashMap();
        this.f29648c = new LinkedList<>();
        this.f29649d = new HashMap<>();
    }

    public void a(String str, String str2) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || (map = this.f29647b) == null) {
            return;
        }
        map.put(str, str2);
    }

    public void b(BasicNameValuePair basicNameValuePair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, basicNameValuePair) == null) {
            this.f29648c.add(basicNameValuePair);
        }
    }

    public String c(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            if (this.f29648c.size() == 0) {
                if (eVar != null) {
                    eVar.f29633a = this.f29646a.length();
                }
                return this.f29646a;
            }
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.f29646a);
            if (this.f29646a.indexOf("?") < 0) {
                sb.append("?");
            } else if (!this.f29646a.endsWith("?") && !this.f29646a.endsWith("&")) {
                sb.append("&");
            }
            for (int i2 = 0; i2 < this.f29648c.size(); i2++) {
                if (i2 != 0) {
                    sb.append("&");
                }
                sb.append(this.f29648c.get(i2).getName());
                sb.append("=");
                sb.append(k.getUrlEncode(this.f29648c.get(i2).getValue()));
            }
            if (eVar != null) {
                eVar.f29633a = sb.length();
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            Map<String, String> map = this.f29647b;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f29646a : (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            HashMap<String, byte[]> hashMap = this.f29649d;
            return hashMap != null && hashMap.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public final StringBuilder g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuilder sb = new StringBuilder(1024);
            LinkedList<BasicNameValuePair> linkedList = this.f29648c;
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

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (str == null) {
                this.f29646a = "";
            } else {
                this.f29646a = str;
            }
        }
    }

    public void j(HttpURLConnection httpURLConnection) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, httpURLConnection) == null) || httpURLConnection == null || (map = this.f29647b) == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public void k(HttpURLConnection httpURLConnection, e eVar) throws Exception {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, httpURLConnection, eVar) == null) {
            if (httpURLConnection != null) {
                String sb = g().toString();
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
            if (eVar != null) {
                eVar.f29633a = i2;
            }
        }
    }

    public void l(HttpURLConnection httpURLConnection, String str, e eVar) throws Exception {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, httpURLConnection, str, eVar) == null) {
            h();
            if (httpURLConnection != null) {
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    if (this.f29648c != null) {
                        Iterator<BasicNameValuePair> it = this.f29648c.iterator();
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
                    if (this.f29649d != null) {
                        for (Map.Entry<String, byte[]> entry : this.f29649d.entrySet()) {
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
            if (eVar != null) {
                eVar.f29633a = i2;
            }
        }
    }
}
