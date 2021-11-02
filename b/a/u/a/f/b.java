package b.a.u.a.f;

import android.content.Context;
import android.text.TextUtils;
import b.a.u.a.a.g;
import b.a.u.a.h.e;
import b.a.u.a.h.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends b.a.u.a.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public a f29041b;

    /* loaded from: classes6.dex */
    public interface a {
        void onFailure(int i2, String str);

        void onResponse(String str);
    }

    public b(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29040a = context;
        this.f29041b = aVar;
    }

    @Override // b.a.u.a.f.c.b
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @Override // b.a.u.a.f.c.b
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int a2 = b.a.u.a.h.c.a(this.f29040a);
            if (a2 == 1) {
                return "http://rd-im-server.bcc-szth.baidu.com:8089/rest/5.0/generate_lcm_token";
            } else if (a2 == 2) {
                return "http://sz-shaheenv-al-b.bcc-szwg.baidu.com:8911/rest/5.0/generate_lcm_token";
            } else if (b.a.u.a.h.c.b(this.f29040a)) {
                return "http://rd-im-server.bcc-szth.baidu.com:8089/rest/5.0/generate_lcm_token";
            } else {
                return "https://pim.baidu.com/rest/5.0/generate_lcm_token";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.u.a.f.c.b
    public String getMediaType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    @Override // b.a.u.a.f.c.b
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                JSONObject jSONObject = (JSONObject) b.a.u.a.h.b.c(this.f29040a, true);
                return jSONObject != null ? jSONObject.toString().getBytes() : new byte[0];
            } catch (Exception unused) {
                return new byte[0];
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // b.a.u.a.f.c.d
    public void onFailure(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
            this.f29041b.onFailure(i2, str);
        }
    }

    @Override // b.a.u.a.f.c.d
    public void onSuccess(byte[] bArr) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bArr) == null) {
            try {
                JSONObject jSONObject2 = new JSONObject(new String(bArr));
                e.a("GetTokenRequest", "onSuccess :" + jSONObject2.toString());
                int optInt = jSONObject2.optInt("error_code", -1);
                String optString = jSONObject2.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                b.a.u.a.a.a.h(this.f29040a).g(601110).c("token_end", System.currentTimeMillis()).b("connect_state", 1).d("P2", jSONObject2.toString()).d("con_err_code", "P2");
                if (optInt == 0) {
                    f.r(this.f29040a, jSONObject2.optBoolean("bddns_enable", false));
                    String optString2 = jSONObject2.optString("token");
                    JSONArray jSONArray = jSONObject2.getJSONArray(WebSocketRequest.PARAM_KEY_PROTOCOLS);
                    if (!TextUtils.isEmpty(optString2) && jSONArray != null && jSONArray.length() >= 1) {
                        f.x(this.f29040a, jSONArray.length());
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject3 = (JSONObject) jSONArray.get(i2);
                            f.w(this.f29040a, jSONObject3.optString("protocol") + ":" + jSONObject3.optString("domain") + ":" + jSONObject3.optString(ClientCookie.PORT_ATTR), i2);
                        }
                        f.t(this.f29040a, jSONObject2.optInt("ipv6_strategy", 3));
                        this.f29041b.onResponse(optString2);
                        f.z(this.f29040a, optString2);
                        try {
                            String optString3 = jSONObject2.optString("client_log_config", "");
                            if (TextUtils.isEmpty(optString3)) {
                                return;
                            }
                            JSONObject jSONObject4 = new JSONObject(optString3);
                            g.j(this.f29040a, jSONObject4.optInt("client_upload_log_switch", 0));
                            JSONArray jSONArray2 = jSONObject4.getJSONArray("realtime_log_switch");
                            if (jSONArray2 != null && jSONArray2.length() > 0) {
                                for (int i3 = 0; i3 < jSONArray2.length() && (jSONObject = jSONArray2.getJSONObject(i3)) != null; i3++) {
                                    g.i(this.f29040a, jSONObject.optInt("id", 0), jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 0));
                                }
                                return;
                            }
                            return;
                        } catch (Exception e2) {
                            a aVar = this.f29041b;
                            aVar.onFailure(10001, "Json Exception" + e2);
                            e.b("GetTokenRequest", "Json Exception");
                            return;
                        }
                    }
                    this.f29041b.onFailure(10002, "token or protocol is empty");
                    b.a.u.a.a.a.h(this.f29040a).g(601110).c("flow_end_time", System.currentTimeMillis()).e();
                    return;
                }
                this.f29041b.onFailure(optInt, optString);
            } catch (JSONException e3) {
                a aVar2 = this.f29041b;
                aVar2.onFailure(10001, "parse response exception ：" + e3);
            }
        }
    }
}
