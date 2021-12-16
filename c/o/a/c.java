package c.o.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f31092e;

    /* renamed from: f  reason: collision with root package name */
    public String f31093f;

    /* renamed from: g  reason: collision with root package name */
    public String f31094g;

    /* renamed from: h  reason: collision with root package name */
    public String f31095h;

    /* renamed from: i  reason: collision with root package name */
    public String f31096i;

    /* renamed from: j  reason: collision with root package name */
    public String f31097j;

    /* renamed from: k  reason: collision with root package name */
    public String f31098k;
    public HashMap<String, String> l;

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
                return;
            }
        }
        this.f31093f = "";
        this.f31094g = "";
        this.f31095h = "";
        this.f31096i = "";
        this.f31097j = "";
        this.f31098k = "";
        this.l = new HashMap<>();
    }

    public String a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            if (z) {
                return n(this.f31093f);
            }
            return this.f31093f;
        }
        return (String) invokeZ.objValue;
    }

    public Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31092e : (Context) invokeV.objValue;
    }

    public String c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            if (this.l.isEmpty()) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : this.l.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException unused) {
                    return "";
                }
            }
            if (z) {
                return n(jSONObject.toString());
            }
            return jSONObject.toString();
        }
        return (String) invokeZ.objValue;
    }

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                c cVar = (c) super.clone();
                HashMap<String, String> hashMap = new HashMap<>();
                for (Map.Entry<String, String> entry : cVar.l.entrySet()) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
                cVar.l = hashMap;
                return cVar;
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }
        return invokeV.objValue;
    }

    public String e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            if (z) {
                return n(this.f31095h);
            }
            return this.f31095h;
        }
        return (String) invokeZ.objValue;
    }

    public String f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            if (z) {
                return n(this.f31097j);
            }
            return this.f31097j;
        }
        return (String) invokeZ.objValue;
    }

    public String g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            if (z) {
                return n(this.f31094g);
            }
            return this.f31094g;
        }
        return (String) invokeZ.objValue;
    }

    public String h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            if (z) {
                return n(this.f31098k);
            }
            return this.f31098k;
        }
        return (String) invokeZ.objValue;
    }

    public String i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            if (z) {
                return n(this.f31096i);
            }
            return this.f31096i;
        }
        return (String) invokeZ.objValue;
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f31093f = str;
        }
    }

    public void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            this.f31092e = context.getApplicationContext();
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f31095h = str;
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f31096i = str;
        }
    }

    public final String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.f31092e == null || TextUtils.isEmpty(this.f31093f) || TextUtils.isEmpty(this.f31095h) || TextUtils.isEmpty(this.f31096i)) ? false : true : invokeV.booleanValue;
    }
}
