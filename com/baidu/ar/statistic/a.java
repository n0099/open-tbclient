package com.baidu.ar.statistic;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean sL;
    public static final Object wk;
    public static a wl;
    public static int wm;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject wi;
    public a wj;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2090663273, "Lcom/baidu/ar/statistic/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2090663273, "Lcom/baidu/ar/statistic/a;");
                return;
            }
        }
        wk = new Object();
    }

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.wj = null;
        this.wi = new JSONObject();
        aA(str);
        setTimestamp(System.currentTimeMillis());
    }

    public static void a(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, aVar) == null) || sL) {
            return;
        }
        synchronized (wk) {
            aVar.ge();
        }
    }

    public static void a(a... aVarArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, aVarArr) == null) || sL) {
            return;
        }
        synchronized (wk) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    aVar.ge();
                }
            }
        }
    }

    public static a aG(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str != null && !str.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject(str.trim());
                    a az = az(jSONObject.getString("event_id"));
                    az.wi = jSONObject;
                    return az;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public static a az(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (!sL) {
                synchronized (wk) {
                    if (wl != null) {
                        a aVar = wl;
                        wl = aVar.wj;
                        aVar.wj = null;
                        wm--;
                        if (aVar.wi == null) {
                            aVar.wi = new JSONObject();
                        }
                        aVar.aA(str);
                        aVar.setTimestamp(System.currentTimeMillis());
                        return aVar;
                    }
                }
            }
            return new a(str);
        }
        return (a) invokeL.objValue;
    }

    public static String b(a aVar) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, aVar)) == null) {
            if (aVar == null || (jSONObject = aVar.wi) == null) {
                return null;
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    private void ge() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.wi = null;
            int i2 = wm;
            if (i2 < 500) {
                this.wj = wl;
                wl = this;
                wm = i2 + 1;
            }
        }
    }

    public static void release() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || sL) {
            return;
        }
        synchronized (wk) {
            sL = true;
            wl = null;
            wm = 0;
        }
    }

    public JSONObject a(Collection<String> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, collection)) == null) ? a(null, collection) : (JSONObject) invokeL.objValue;
    }

    public JSONObject a(JSONObject jSONObject, Collection<String> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, collection)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                Iterator<String> keys = this.wi.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (collection == null || !collection.contains(next)) {
                        jSONObject.put(next, this.wi.get(next));
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public void a(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) || map == null || map.isEmpty()) {
            return;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.wi.putOpt(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void aA(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            try {
                this.wi.putOpt("event_id", str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public String aB(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.wi.optString(str) : (String) invokeL.objValue;
    }

    public Object aC(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.wi.opt(str) : invokeL.objValue;
    }

    public long aD(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            Object aC = aC(str);
            if (aC instanceof Number) {
                return ((Number) aC).longValue();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public boolean aE(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? this.wi.has(str) : invokeL.booleanValue;
    }

    public void aF(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.wi.remove(str);
        }
    }

    public void b(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, obj) == null) {
            try {
                this.wi.putOpt(str, obj);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public long getTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.wi.optLong("time") : invokeV.longValue;
    }

    public String gf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.wi.optString("event_id") : (String) invokeV.objValue;
    }

    public String gg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String b2 = b(this);
            if (b2 == null) {
                return null;
            }
            return com.baidu.ar.h.l.aT(b2);
        }
        return (String) invokeV.objValue;
    }

    public JSONObject gh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? a(null, null) : (JSONObject) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: gi */
    public a clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            a az = az("");
            try {
                az.wi = new JSONObject(this.wi.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return az;
        }
        return (a) invokeV.objValue;
    }

    public Iterator<String> keys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.wi.keys() : (Iterator) invokeV.objValue;
    }

    public void setTimestamp(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j2) == null) {
            try {
                this.wi.putOpt("time", Long.valueOf(j2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
