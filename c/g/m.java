package c.g;

import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, Double> a;

    public m() {
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
        this.a = new HashMap();
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                LogPrinter.d("new dey", new Object[0]);
                double a = c0.a();
                c0.f29264b.clear().apply();
                this.a.clear();
                if (a <= 0.0d) {
                    return;
                }
                a0.c(a0.i() + a);
            }
        }
    }

    public synchronized void b() {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.a.clear();
                try {
                    jSONArray = new JSONArray(c0.a.getString("key_ad_cpmcfg", ""));
                } catch (JSONException unused) {
                    this.a.clear();
                }
                if (jSONArray.length() < 1) {
                    return;
                }
                double i2 = a0.i();
                double a = c0.a();
                HashMap hashMap = new HashMap();
                boolean z = false;
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    String string = jSONObject.getString("aid");
                    double d2 = jSONObject.getDouble("cpm");
                    LogPrinter.d("update Cpm:" + string, new Object[0]);
                    hashMap.put(string, Double.valueOf(d2));
                    int i4 = c0.a.getInt(string, 0);
                    LogPrinter.d("need adjust aid count:" + i4, new Object[0]);
                    if (i4 != 0) {
                        a -= c0.b(string);
                        i2 += i4 * d2;
                        c0.f29264b.remove(string).remove(string + "_");
                        z = true;
                    }
                }
                this.a.putAll(hashMap);
                if (z) {
                    LogPrinter.d("update totalPrice&totalPriceByBasePrice", new Object[0]);
                    if (a < 0.0d) {
                        a = 0.0d;
                    }
                    SharedPreferences.Editor editor = c0.f29264b;
                    editor.putLong("key_price_by_baseprice", Double.doubleToRawLongBits(a));
                    editor.apply();
                    a0.c(i2);
                }
            }
        }
    }
}
