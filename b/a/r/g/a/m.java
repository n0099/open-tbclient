package b.a.r.g.a;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Comparator<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f15292e;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15292e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, jSONObject2)) == null) ? jSONObject.optString(this.f15292e, "").compareTo(jSONObject2.optString(this.f15292e, "")) : invokeLL.intValue;
        }
    }

    public static JSONArray a(JSONArray jSONArray, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, jSONArray, str)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return jSONArray;
            }
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    arrayList.add(optJSONObject);
                }
            }
            Collections.sort(arrayList, new a(str));
            return new JSONArray((Collection) arrayList);
        }
        return (JSONArray) invokeLL.objValue;
    }

    public static boolean b(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, jSONObject, jSONObject2, str)) == null) ? jSONObject.optLong(str, -1L) != jSONObject2.optLong(str, -1L) : invokeLLL.booleanValue;
    }

    public static boolean c(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, jSONObject, jSONObject2, str)) == null) {
            String optString = jSONObject.optString(str);
            String optString2 = jSONObject2.optString(str);
            return !(TextUtils.isEmpty(optString) ? TextUtils.isEmpty(optString2) : optString.equals(optString2));
        }
        return invokeLLL.booleanValue;
    }
}
