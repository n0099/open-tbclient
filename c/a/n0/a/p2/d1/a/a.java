package c.a.n0.a.p2.d1.a;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.a.u0.d;
import c.a.n0.a.u0.e;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1178278738, "Lc/a/n0/a/p2/d1/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1178278738, "Lc/a/n0/a/p2/d1/a/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public static List<JSONObject> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String schemesDes = SchemeCollecter.getSchemesDes(str, 0);
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(schemesDes);
                arrayList.add(jSONObject);
                int i = jSONObject.getInt("totalSlices");
                for (int i2 = 1; i2 < i; i2++) {
                    arrayList.add(new JSONObject(SchemeCollecter.getSchemesDes(str, i2)));
                }
                return arrayList;
            } catch (JSONException e2) {
                if (a) {
                    Log.e("SwanAppCompat", "getDescriptions", e2);
                    return null;
                }
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    public static List<JSONObject> b(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            List<JSONObject> a2 = a(str);
            if (a2 == null || a2.isEmpty()) {
                return null;
            }
            for (JSONObject jSONObject : a2) {
                JSONArray optJSONArray = jSONObject.optJSONArray("descriptions");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            Iterator<e> it = d.b().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    e next = it.next();
                                    String optString = optJSONObject.optString("name");
                                    if (next.a(str, optString)) {
                                        try {
                                            optJSONArray.put(i, next.c(optString, optJSONObject));
                                            break;
                                        } catch (JSONException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return a2;
        }
        return (List) invokeLL.objValue;
    }
}
