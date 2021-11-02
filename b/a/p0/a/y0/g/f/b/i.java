package b.a.p0.a.y0.g.f.b;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i extends b.a.p0.a.y0.a<b.a.p0.a.y0.g.h.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i() {
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

    @Override // b.a.p0.a.y0.a
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "enterRoom" : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.y0.a
    public void c(@NonNull ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, command) == null) {
            Object obj = command.obj;
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                command.ret = new b.a.p0.a.y0.g.i.b(jSONObject.optString("roomName"), jSONObject.optLong("userId", -1L), jSONObject.optString("displayName"), jSONObject.optString("rtcAppId"), jSONObject.optString("token")).a() ? 1 : 0;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull b.a.p0.a.y0.g.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, command, bVar) == null) {
            String str = command.what;
            d(bVar, str, "" + command.obj, true);
            Object obj = command.obj;
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                b.a.p0.a.y0.g.i.b bVar2 = new b.a.p0.a.y0.g.i.b(jSONObject.optString("roomName"), jSONObject.optLong("userId", -1L), jSONObject.optString("displayName"), jSONObject.optString("rtcAppId"), jSONObject.optString("token"));
                boolean a2 = bVar2.a();
                if (a2) {
                    bVar.u(bVar2);
                }
                command.ret = a2 ? 1 : 0;
            }
            String str2 = command.what;
            d(bVar, str2, "result: " + command.ret, true);
        }
    }
}
