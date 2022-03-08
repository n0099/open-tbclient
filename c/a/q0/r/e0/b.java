package c.a.q0.r.e0;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            b(jSONObject, "uid", TbadkCoreApplication.getCurrentAccount());
            b(jSONObject, "latest_related_tid", TbadkCoreApplication.getInst().getLatestRelatedTid());
            b(jSONObject, "latest_related_fid", TbadkCoreApplication.getInst().getLatestRelatedFid());
            b(jSONObject, "continuous_crash_times", String.valueOf(c.a.q0.r.h0.a.q().o()));
            b(jSONObject, "trigger_safe_mode_status", String.valueOf(c.a.q0.r.h0.a.q().s()));
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject b(JSONObject jSONObject, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, jSONObject, str, str2)) == null) {
            if (jSONObject == null) {
                return null;
            }
            if (str != null && str2 != null) {
                try {
                    jSONObject.put(str, str2);
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }
}
