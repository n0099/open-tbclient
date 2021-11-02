package b.a.p0.h.y.e;

import androidx.annotation.NonNull;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f10812b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<b.a.p0.a.y.b.a> f10813a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2086034615, "Lb/a/p0/h/y/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2086034615, "Lb/a/p0/h/y/e/a;");
                return;
            }
        }
        f10812b = k.f6397a;
    }

    public a(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONArray};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10813a = new ArrayList();
        if (jSONArray == null) {
            return;
        }
        if (f10812b) {
            String str = "jsonArray:" + jSONArray;
        }
        int length = jSONArray.length();
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i6);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("type");
                char c2 = 65535;
                int hashCode = optString.hashCode();
                if (hashCode != 1095692943) {
                    if (hashCode == 1427818632 && optString.equals("download")) {
                        c2 = 1;
                    }
                } else if (optString.equals("request")) {
                    c2 = 0;
                }
                if (c2 != 0) {
                    if (c2 == 1 && i5 < 10) {
                        this.f10813a.add(a(optJSONObject));
                        i5++;
                    }
                } else if (i4 < 3) {
                    this.f10813a.add(b(optJSONObject));
                    i4++;
                }
            }
        }
    }

    public final b.a.p0.a.y.b.a a(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            b.a.p0.a.y.b.a aVar = new b.a.p0.a.y.b.a();
            aVar.G("type", jSONObject.optString("type"));
            aVar.G("url", jSONObject.optString("url"));
            aVar.G("filePath", jSONObject.optString("filePath"));
            aVar.G("header", c(jSONObject.optJSONObject("header")));
            return aVar;
        }
        return (b.a.p0.a.y.b.a) invokeL.objValue;
    }

    public final b.a.p0.a.y.b.a b(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            b.a.p0.a.y.b.a aVar = new b.a.p0.a.y.b.a();
            aVar.G("type", jSONObject.optString("type"));
            aVar.G("url", jSONObject.optString("url"));
            aVar.G("responseType", jSONObject.optString("responseType"));
            aVar.G("header", c(jSONObject.optJSONObject("header")));
            return aVar;
        }
        return (b.a.p0.a.y.b.a) invokeL.objValue;
    }

    public final b.a.p0.a.y.b.a c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            b.a.p0.a.y.b.a aVar = new b.a.p0.a.y.b.a();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                aVar.G(next, jSONObject.optString(next));
            }
            return aVar;
        }
        return (b.a.p0.a.y.b.a) invokeL.objValue;
    }
}
