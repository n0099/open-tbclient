package c.a.i0.r;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(int i2, String str, String str2) {
        InterceptResult invokeILL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65536, null, i2, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str2)) {
                str3 = "statecode={" + i2 + "};order_no={" + str + "};notify=" + str2;
            } else {
                str3 = "statecode={" + i2 + "};order_no={" + str + "};notify={" + str2 + "}";
            }
            try {
                jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, i2);
                jSONObject.put("statusMsg", str2);
                jSONObject.put("responseData", str3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeILL.objValue;
    }
}
