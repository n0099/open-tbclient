package c.a.q0.s.z.s;

import android.content.ClipboardManager;
import c.a.q0.s.z.l;
import c.a.q0.s.z.n;
import c.a.q0.s.z.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(l lVar) {
        super(lVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((l) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @o("copy")
    public JSONObject copyToClipboard(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject != null) {
                String optString = jSONObject.optString("message");
                if (!StringUtils.isNull(optString)) {
                    ((ClipboardManager) getContext().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(optString.trim());
                    jSONObject2.put("status", 0);
                    jSONObject2.put("message", "");
                    return jSONObject2;
                }
            }
            jSONObject2.put("status", -1);
            jSONObject2.put("message", "无效内容");
            return jSONObject2;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // c.a.q0.s.z.n
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "TBHY_COMMON_Clipboard" : (String) invokeV.objValue;
    }
}
