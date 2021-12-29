package c.a.r0.q.k;

import androidx.annotation.Nullable;
import c.a.r0.q.f.i;
import c.a.r0.q.k.i.n;
import com.baidu.swan.pms.node.Node;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(@Nullable c<JSONArray> cVar, @Nullable c<JSONObject> cVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, cVar, cVar2)) == null) ? b(Node.values(), cVar, cVar2) : (JSONObject) invokeLL.objValue;
    }

    public static JSONObject b(Node[] nodeArr, @Nullable c<JSONArray> cVar, @Nullable c<JSONObject> cVar2) {
        InterceptResult invokeLLL;
        e provider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, nodeArr, cVar, cVar2)) == null) {
            if (nodeArr == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                for (Node node : nodeArr) {
                    if (node != null && (provider = Node.getProvider(node)) != null) {
                        if (node.isDataArray()) {
                            jSONObject.put(node.getName(), provider.b(cVar));
                        } else {
                            jSONObject.put(node.getName(), provider.a(cVar2));
                        }
                    }
                }
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public static void c(JSONObject jSONObject, i iVar, @Nullable i iVar2, @Nullable i iVar3) {
        c.a.r0.q.a b2;
        d a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, jSONObject, iVar, iVar2, iVar3) == null) || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Node nodeByConfigName = Node.getNodeByConfigName(next);
            if (nodeByConfigName != null && (a = g.a(nodeByConfigName)) != null) {
                if (nodeByConfigName.isDataArray()) {
                    a.a(jSONObject.optJSONArray(next), iVar, iVar2, iVar3);
                } else {
                    a.b(jSONObject.optJSONObject(next), iVar, iVar2, iVar3);
                }
            }
        }
        if (!n.a || (b2 = c.a.r0.q.c.b()) == null) {
            return;
        }
        b2.C();
    }
}
