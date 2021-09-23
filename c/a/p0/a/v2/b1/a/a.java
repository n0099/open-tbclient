package c.a.p0.a.v2.b1.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.p0.a.k;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9301a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1239293964, "Lc/a/p0/a/v2/b1/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1239293964, "Lc/a/p0/a/v2/b1/a/a;");
                return;
            }
        }
        f9301a = k.f7085a;
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
                int i2 = jSONObject.getInt("totalSlices");
                for (int i3 = 1; i3 < i2; i3++) {
                    arrayList.add(new JSONObject(SchemeCollecter.getSchemesDes(str, i3)));
                }
                return arrayList;
            } catch (JSONException unused) {
                boolean z = f9301a;
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
            c.a.p0.a.e1.a aVar = new c.a.p0.a.e1.a();
            boolean z = false;
            for (JSONObject jSONObject : a2) {
                JSONArray optJSONArray = jSONObject.optJSONArray("descriptions");
                if (optJSONArray != null) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= optJSONArray.length()) {
                            break;
                        }
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null && TextUtils.equals(aVar.a(), str) && TextUtils.equals(aVar.c(), optJSONObject.optString("name"))) {
                            try {
                                aVar.b(optJSONObject);
                                optJSONArray.put(i2, optJSONObject);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            z = true;
                            break;
                        }
                        i2++;
                    }
                    if (z) {
                        break;
                    }
                }
            }
            return a2;
        }
        return (List) invokeLL.objValue;
    }
}
