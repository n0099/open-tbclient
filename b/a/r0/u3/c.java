package b.a.r0.u3;

import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (list == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(list.get(i2));
                sb.append(StringUtils.LF);
            }
            return sb.toString().getBytes();
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeL.objValue;
    }

    public static boolean c(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, str)) == null) {
            if (bArr == null) {
                return false;
            }
            b.a.e.e.j.a.e eVar = new b.a.e.e.j.a.e();
            eVar.b().s(str);
            eVar.b().q(HttpMessageTask.HTTP_METHOD.POST);
            eVar.b().c("", bArr);
            new b.a.e.e.j.a.c(eVar).n(3, -1, -1);
            int i2 = eVar.c().f1806b;
            byte[] bArr2 = eVar.c().f1812h;
            if (bArr2 == null || i2 != 200) {
                return false;
            }
            try {
                return new JSONObject(new String(bArr2, "utf-8")).optJSONObject("error").optInt("errno") == 0;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
