package c.a.n0.a.y0.c;

import android.text.TextUtils;
import c.a.n0.a.p2.n0;
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
public class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] A;
    public ArrayList<c.a.n0.a.y0.c.h.c> z;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.A = new int[]{0, 0, 0, 0};
    }

    @Override // c.a.n0.a.y0.c.c, c.a.n0.a.s.b.b, c.a.n0.a.c1.a
    public void a(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        if (jSONObject.has("points") && (jSONArray2 = jSONObject.getJSONArray("points")) != null && jSONArray2.length() > 0) {
            int length = jSONArray2.length();
            this.z = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                if (jSONObject2 != null) {
                    c.a.n0.a.y0.c.h.c cVar = new c.a.n0.a.y0.c.h.c();
                    cVar.a(jSONObject2);
                    if (cVar.isValid()) {
                        this.z.add(cVar);
                    }
                }
            }
        }
        if (!jSONObject.has("padding") || (jSONArray = jSONObject.getJSONArray("padding")) == null || jSONArray.length() <= 0) {
            return;
        }
        int min = Math.min(jSONArray.length(), 4);
        for (int i2 = 0; i2 < min; i2++) {
            this.A[i2] = n0.g(jSONArray.optInt(i2));
        }
    }

    @Override // c.a.n0.a.s.b.b, c.a.n0.a.c1.a
    public boolean isValid() {
        InterceptResult invokeV;
        ArrayList<c.a.n0.a.y0.c.h.c> arrayList;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (TextUtils.isEmpty(this.f6097c) || TextUtils.isEmpty(this.f6096b) || (arrayList = this.z) == null || arrayList.size() <= 0) ? false : true : invokeV.booleanValue;
    }
}
