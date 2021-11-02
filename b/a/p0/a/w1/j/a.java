package b.a.p0.a.w1.j;

import android.text.TextUtils;
import b.a.p0.a.k;
import b.a.p0.a.r0.n;
import b.a.p0.a.v2.u;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f8801a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2053774686, "Lb/a/p0/a/w1/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2053774686, "Lb/a/p0/a/w1/j/a;");
                return;
            }
        }
        f8801a = k.f6397a;
    }

    public static JSONObject a(List<String> list, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, list, f2)) == null) {
            boolean z = f8801a;
            ArrayList arrayList = new ArrayList();
            b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
            if (i2 == null) {
                return null;
            }
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    File file = new File(str);
                    File k = u.k(file.getName());
                    if (u.b(file, k, (int) (100.0f * f2))) {
                        arrayList.add(k);
                    }
                }
            }
            return b(arrayList, i2);
        }
        return (JSONObject) invokeLF.objValue;
    }

    public static JSONObject b(ArrayList<File> arrayList, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLL;
        String J;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, arrayList, eVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            boolean l0 = eVar.l0();
            try {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                Iterator<File> it = arrayList.iterator();
                while (it.hasNext()) {
                    File next = it.next();
                    if (next != null) {
                        if (l0) {
                            J = n.V(next.getAbsolutePath());
                        } else {
                            J = b.a.p0.a.k2.b.J(next.getAbsolutePath(), eVar.f3961f);
                        }
                        if (f8801a) {
                            String str = "isSwanGame: " + l0 + "; path: " + J;
                        }
                        jSONArray.put(J);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("path", J);
                        jSONObject2.put("size", next.length());
                        jSONArray2.put(jSONObject2);
                    }
                }
                jSONObject.put("tempFilePaths", jSONArray);
                jSONObject.put("tempFiles", jSONArray2);
            } catch (JSONException e2) {
                if (f8801a) {
                    e2.printStackTrace();
                }
            }
            if (f8801a) {
                jSONObject.toString();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
