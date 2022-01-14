package c.p.a;

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
    public Context f30260e;

    /* renamed from: f  reason: collision with root package name */
    public String f30261f;

    /* renamed from: g  reason: collision with root package name */
    public String f30262g;

    /* renamed from: h  reason: collision with root package name */
    public String f30263h;

    /* renamed from: i  reason: collision with root package name */
    public String f30264i;

    /* renamed from: j  reason: collision with root package name */
    public String f30265j;
    public String k;
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
        this.f30261f = "";
        this.f30262g = "";
        this.f30263h = "";
        this.f30264i = "";
        this.f30265j = "";
        this.k = "";
        this.l = new HashMap<>();
    }

    public String a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            if (z) {
                return n(this.f30261f);
            }
            return this.f30261f;
        }
        return (String) invokeZ.objValue;
    }

    public Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30260e : (Context) invokeV.objValue;
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
                return n(this.f30263h);
            }
            return this.f30263h;
        }
        return (String) invokeZ.objValue;
    }

    public String f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            if (z) {
                return n(this.f30265j);
            }
            return this.f30265j;
        }
        return (String) invokeZ.objValue;
    }

    public String g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            if (z) {
                return n(this.f30262g);
            }
            return this.f30262g;
        }
        return (String) invokeZ.objValue;
    }

    public String h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            if (z) {
                return n(this.k);
            }
            return this.k;
        }
        return (String) invokeZ.objValue;
    }

    public String i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            if (z) {
                return n(this.f30264i);
            }
            return this.f30264i;
        }
        return (String) invokeZ.objValue;
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f30261f = str;
        }
    }

    public void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            this.f30260e = context.getApplicationContext();
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f30263h = str;
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f30264i = str;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.f30260e == null || TextUtils.isEmpty(this.f30261f) || TextUtils.isEmpty(this.f30263h) || TextUtils.isEmpty(this.f30264i)) ? false : true : invokeV.booleanValue;
    }
}
