package c.a.o0.n.m;

import android.text.TextUtils;
import c.a.o0.n.c;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i2, String str, String str2, int i3, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i2), str, str2, Integer.valueOf(i3), jSONObject}) == null) {
            c.b().G(b(i2), str, str2, i3, jSONObject, c(str, i3));
        }
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "unknown" : "swanplugin" : "swandynamiclib" : "swangameconsole" : SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan" : (String) invokeI.objValue;
    }

    public static boolean c(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
            return TextUtils.equals(str, "cs_protocol") && (i2 != 2000);
        }
        return invokeLI.booleanValue;
    }
}
