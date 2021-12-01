package c.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class n0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public final e0 f28899b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f28900c;

    public n0(String str, e0 e0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, e0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f28899b = e0Var;
    }

    public n0(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28899b = e0.f28847c;
        HashMap hashMap = new HashMap();
        this.f28900c = hashMap;
        hashMap.putAll(map);
    }

    public byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = this.a;
            if (str == null) {
                return null;
            }
            return str.getBytes(Charset.forName("UTF-8"));
        }
        return (byte[]) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = this.a;
            if (str != null) {
                return str;
            }
            if (this.f28900c != null) {
                StringBuilder sb = new StringBuilder();
                for (String str2 : this.f28900c.keySet()) {
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(str2);
                    Object obj = this.f28900c.get(str2);
                    if (obj != null) {
                        sb.append("=");
                        try {
                            sb.append(URLEncoder.encode(obj.toString(), "UTF-8"));
                        } catch (UnsupportedEncodingException unused) {
                        }
                    }
                }
                return sb.toString();
            }
            throw new IllegalStateException();
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28899b.a : (String) invokeV.objValue;
    }
}
