package c.a.p0.h.f0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f11243c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f11244a;

    /* renamed from: b  reason: collision with root package name */
    public volatile ArrayList<a> f11245b;

    public b() {
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
        this.f11245b = new ArrayList<>(20);
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f11243c == null) {
                synchronized (b.class) {
                    if (f11243c == null) {
                        f11243c = new b();
                    }
                }
            }
            return f11243c;
        }
        return (b) invokeV.objValue;
    }

    public synchronized void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            synchronized (this) {
                if (aVar == null) {
                    return;
                }
                if (this.f11245b.size() < 20) {
                    this.f11245b.add(aVar);
                } else {
                    this.f11244a++;
                }
            }
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.f11245b.clear();
                this.f11244a = 0;
            }
        }
    }

    public synchronized JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                int size = this.f11245b.size();
                if (size == 0) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("dropcnt", this.f11244a);
                    jSONObject.put("errorcnt", size);
                    JSONArray jSONArray = new JSONArray();
                    jSONObject.put("errors", jSONArray);
                    Iterator<a> it = this.f11245b.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().a());
                    }
                } catch (JSONException unused) {
                }
                this.f11245b.clear();
                return jSONObject;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
