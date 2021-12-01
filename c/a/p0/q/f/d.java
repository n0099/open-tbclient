package c.a.p0.q.f;

import androidx.annotation.Nullable;
import c.a.p0.q.j.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d implements g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final c f10685e;

    public d(@Nullable c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10685e = cVar;
    }

    @Override // c.a.p0.q.j.g.a
    public void a(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
        }
    }

    @Override // c.a.p0.q.j.g.a
    public void b(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
            try {
                HashMap hashMap = new HashMap();
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(keys.next());
                    if (optJSONObject2 != null) {
                        hashMap.put(optJSONObject2.optString("appkey"), optJSONObject2.optString("openbundleid"));
                    }
                }
                if (this.f10685e != null) {
                    this.f10685e.onResult(hashMap);
                }
            } catch (Exception e2) {
                c cVar = this.f10685e;
                if (cVar != null) {
                    cVar.onFail(e2);
                }
            }
        }
    }

    @Override // c.a.p0.q.j.g.a
    public void onFail(Exception exc) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) || (cVar = this.f10685e) == null) {
            return;
        }
        cVar.onFail(exc);
    }

    @Override // c.a.p0.q.j.g.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }
}
