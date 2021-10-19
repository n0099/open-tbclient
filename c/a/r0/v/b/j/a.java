package c.a.r0.v.b.j;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends ShareItem {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.r0 : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.q0 : (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.p0 : (String) invokeV.objValue;
    }

    public JSONArray o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.s0 : (JSONArray) invokeV.objValue;
    }

    public void p(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            this.k0 = true;
            this.r = jSONObject.getString("title");
            this.t = jSONObject.getString("linkUrl");
            this.s = jSONObject.optString("content");
            this.w = jSONObject.optString("imageUrl");
            this.p0 = jSONObject.optString("mediaType");
            String optString = StringUtils.isNull(this.w) ? jSONObject.optString("iconUrl") : this.w;
            this.w = optString;
            this.v = Uri.parse(optString);
            JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
            if (optJSONObject != null) {
                this.l0 = optJSONObject.optString("source2");
                this.n0 = optJSONObject.optString("source3");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("command");
            if (optJSONObject2 != null) {
                this.m0 = 2;
                this.s0 = optJSONObject2.optJSONArray("cmd_pannel");
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("info");
                this.t0 = optJSONObject3;
                if (optJSONObject3 != null) {
                    this.q0 = optJSONObject3.optString("key");
                    this.r0 = this.t0.optString("content");
                    return;
                }
                return;
            }
            this.m0 = "url".equals(jSONObject.optString("type")) ? 1 : 3;
        }
    }
}
