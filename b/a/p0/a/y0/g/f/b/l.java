package b.a.p0.a.y0.g.f.b;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l extends b.a.p0.a.y0.a<b.a.p0.a.y0.g.h.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public l() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getRemoteUserList" : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.y0.a
    public void c(@NonNull ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, command) == null) {
            command.obj = new JSONObject();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull b.a.p0.a.y0.g.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, command, bVar) == null) {
            ArrayList<b.a.p0.a.y0.g.i.c> h2 = bVar.h();
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (h2 != null) {
                Iterator<b.a.p0.a.y0.g.i.c> it = h2.iterator();
                while (it.hasNext()) {
                    b.a.p0.a.y0.g.i.c next = it.next();
                    JSONObject a2 = next == null ? null : next.a();
                    if (a2 != null) {
                        jSONArray.put(a2);
                    }
                }
            }
            try {
                jSONObject.put("userList", jSONArray);
            } catch (JSONException unused) {
            }
            command.obj = jSONObject;
            String str = command.what;
            d(bVar, str, "" + command.obj, true);
        }
    }
}
