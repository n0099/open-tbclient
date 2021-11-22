package b.a.p0.a.z1.j;

import android.text.TextUtils;
import b.a.p0.a.k;
import b.a.p0.a.r0.n;
import b.a.p0.a.z2.u;
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
    public static final boolean f9705a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(421318433, "Lb/a/p0/a/z1/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(421318433, "Lb/a/p0/a/z1/j/a;");
                return;
            }
        }
        f9705a = k.f6863a;
    }

    public static JSONObject a(List<String> list, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, list, f2)) == null) {
            boolean z = f9705a;
            ArrayList arrayList = new ArrayList();
            b.a.p0.a.d2.e L = b.a.p0.a.d2.e.L();
            if (L == null) {
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
            return b(arrayList, L);
        }
        return (JSONObject) invokeLF.objValue;
    }

    public static JSONObject b(ArrayList<File> arrayList, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLL;
        String J;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, arrayList, eVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            boolean v0 = eVar.v0();
            try {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                Iterator<File> it = arrayList.iterator();
                while (it.hasNext()) {
                    File next = it.next();
                    if (next != null) {
                        if (v0) {
                            J = n.Z(next.getAbsolutePath());
                        } else {
                            J = b.a.p0.a.o2.b.J(next.getAbsolutePath(), eVar.f4474f);
                        }
                        if (f9705a) {
                            String str = "isSwanGame: " + v0 + "; path: " + J;
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
                if (f9705a) {
                    e2.printStackTrace();
                }
            }
            if (f9705a) {
                jSONObject.toString();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
