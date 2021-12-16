package c.a.s0.c1.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            c.a.r0.s.g0.b.j().x(c.a.r0.s.g0.b.n("search_forum_history"), "");
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        String p = c.a.r0.s.g0.b.j().p(c.a.r0.s.g0.b.n("search_forum_history"), "");
        if (StringUtils.isNull(p)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(p);
            if (jSONArray.length() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                Object obj = jSONArray.get(i2);
                if (!str.equals(obj)) {
                    arrayList.add((String) obj);
                }
            }
            c.a.r0.s.g0.b.j().x(c.a.r0.s.g0.b.n("search_forum_history"), new JSONArray((Collection) arrayList).toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static ArrayList<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65538, null)) != null) {
            return (ArrayList) invokeV.objValue;
        }
        String p = c.a.r0.s.g0.b.j().p(c.a.r0.s.g0.b.n("search_forum_history"), "");
        ArrayList<String> arrayList = null;
        if (StringUtils.isNull(p)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(p);
            if (jSONArray.length() <= 0) {
                return null;
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    Object obj = jSONArray.get(i2);
                    if (obj instanceof String) {
                        arrayList2.add((String) obj);
                    }
                } catch (JSONException e2) {
                    e = e2;
                    arrayList = arrayList2;
                    e.printStackTrace();
                    return arrayList;
                }
            }
            return arrayList2;
        } catch (JSONException e3) {
            e = e3;
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        String p = c.a.r0.s.g0.b.j().p(c.a.r0.s.g0.b.n("search_forum_history"), "");
        try {
            JSONArray jSONArray = StringUtils.isNull(p) ? new JSONArray() : new JSONArray(p);
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            int i2 = 1;
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                Object obj = jSONArray.get(i3);
                if ((obj instanceof String) && !str.equals(obj)) {
                    arrayList.add((String) obj);
                    i2++;
                }
                if (i2 == 6) {
                    break;
                }
            }
            c.a.r0.s.g0.b.j().x(c.a.r0.s.g0.b.n("search_forum_history"), new JSONArray((Collection) arrayList).toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
