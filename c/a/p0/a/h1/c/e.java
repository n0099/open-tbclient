package c.a.p0.a.h1.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String D;
    public String E;
    public ArrayList<String> F;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.D = "";
        this.E = "";
    }

    @Override // c.a.p0.a.h1.c.c, c.a.p0.a.c0.b.b, c.a.p0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        if (jSONObject.has("scale")) {
            this.o = jSONObject.optDouble("scale", 18.0d);
        }
        if (jSONObject.has("name")) {
            this.D = jSONObject.optString("name");
        }
        if (jSONObject.has("address")) {
            this.E = jSONObject.optString("address");
        }
        if (jSONObject.has("ignoredApps") && (optJSONArray = jSONObject.optJSONArray("ignoredApps")) != null) {
            int length = optJSONArray.length();
            this.F = new ArrayList<>();
            for (int i2 = 0; i2 < length; i2++) {
                this.F.add(optJSONArray.optString(i2));
            }
        }
        if (jSONObject.has("naviPreference")) {
            jSONObject.optInt("naviPreference", -1);
        }
    }

    @Override // c.a.p0.a.c0.b.b, c.a.p0.a.l1.a
    public boolean isValid() {
        InterceptResult invokeV;
        c.a.p0.a.h1.c.h.c cVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (TextUtils.isEmpty(this.f4666g) || (cVar = this.n) == null || !cVar.isValid()) ? false : true : invokeV.booleanValue;
    }
}
