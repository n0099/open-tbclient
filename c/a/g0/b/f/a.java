package c.a.g0.b.f;

import android.text.TextUtils;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.prologue.business.data.ParseError;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.facebook.common.util.UriUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<g> a(JSONArray jSONArray, String str, boolean z) throws ParseError {
        InterceptResult invokeLLZ;
        List<g> j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65536, null, jSONArray, str, z)) == null) {
            if (jSONArray == null || jSONArray.length() == 0 || (j2 = g.j(jSONArray)) == null || j2.size() == 0) {
                return null;
            }
            if (z) {
                for (g gVar : j2) {
                    gVar.x = true;
                }
            } else {
                HashMap<String, g> q = e.q();
                if (q != null && q.size() != 0) {
                    e.g(j2);
                    e.A(j2);
                } else {
                    e.A(j2);
                }
                e.x(j2);
            }
            return j2;
        }
        return (List) invokeLLZ.objValue;
    }

    public static List<g> b(String str, String str2) throws ParseError {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return c(new JSONObject(str), str2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    throw new ParseError(1, "afd/entry retun invalid json");
                }
            }
            throw new ParseError(1, "afd/entry retun null");
        }
        return (List) invokeLL.objValue;
    }

    public static List<g> c(JSONObject jSONObject, String str) throws ParseError {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, str)) == null) {
            List<g> arrayList = new ArrayList<>();
            if (jSONObject != null) {
                if (jSONObject.optInt("errno", 0) <= 0 && (optJSONObject = jSONObject.optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME)) != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(SpeedStatsUtils.UBC_VALUE_SPLASH);
                    JSONArray optJSONArray = optJSONObject.optJSONArray("ad");
                    if (optJSONObject2 != null) {
                        String optString = optJSONObject2.optString("cmd");
                        SplashStyleRecorder.b(optJSONObject2.optJSONObject("style_desc"));
                        f.E(optJSONObject2.optString("src_ext_info"));
                        if (TextUtils.equals("update", optString)) {
                            arrayList = a(optJSONArray, str, false);
                            String optString2 = optJSONObject2.optString("empty_ext_info");
                            if (!TextUtils.isEmpty(optString2)) {
                                c.a.b0.y.e.a().b("splash_sp_name").j("empty_ext_info", optString2, false);
                            }
                        } else if (TextUtils.equals("query", optString)) {
                            int optInt = optJSONObject2.optInt("realTimeLoading");
                            int optInt2 = optJSONObject2.optInt("isCPC");
                            if (optInt != 1 && optInt2 != 1) {
                                String optString3 = optJSONObject2.optString("ukey");
                                if (TextUtils.isEmpty(optString3)) {
                                    BaseVM.h(32);
                                    return arrayList;
                                }
                                List<g> t = e.t();
                                if (t == null) {
                                    return arrayList;
                                }
                                Iterator<g> it = t.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    g next = it.next();
                                    if (TextUtils.equals(next.f3490c, optString3)) {
                                        c.a.b0.x.a.b(arrayList, next);
                                        break;
                                    }
                                }
                                if (arrayList.size() == 0) {
                                    BaseVM.h(64);
                                }
                            } else {
                                List<g> a = a(optJSONArray, str, true);
                                if (a == null || a.size() == 0) {
                                    BaseVM.h(128);
                                }
                                arrayList = a;
                            }
                            if (arrayList != null && arrayList.size() > 0 && arrayList.get(0) != null) {
                                arrayList.get(0).C = optInt == 1 ? 1 : 0;
                            }
                        }
                    }
                    return arrayList;
                }
                return null;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }
}
