package c.a.p0.a.h1.c;

import android.text.TextUtils;
import c.a.p0.a.v2.n0;
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
    public ArrayList<c.a.p0.a.h1.c.h.c> D;
    public int[] E;

    public b() {
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
        this.E = new int[]{0, 0, 0, 0};
    }

    @Override // c.a.p0.a.h1.c.c, c.a.p0.a.c0.b.b, c.a.p0.a.l1.a
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
            this.D = new ArrayList<>(length);
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                if (jSONObject2 != null) {
                    c.a.p0.a.h1.c.h.c cVar = new c.a.p0.a.h1.c.h.c();
                    cVar.a(jSONObject2);
                    if (cVar.isValid()) {
                        this.D.add(cVar);
                    }
                }
            }
        }
        if (!jSONObject.has("padding") || (jSONArray = jSONObject.getJSONArray("padding")) == null || jSONArray.length() <= 0) {
            return;
        }
        int min = Math.min(jSONArray.length(), 4);
        for (int i3 = 0; i3 < min; i3++) {
            this.E[i3] = n0.g(jSONArray.optInt(i3));
        }
    }

    @Override // c.a.p0.a.c0.b.b, c.a.p0.a.l1.a
    public boolean isValid() {
        InterceptResult invokeV;
        ArrayList<c.a.p0.a.h1.c.h.c> arrayList;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (TextUtils.isEmpty(this.f4666g) || TextUtils.isEmpty(this.f4665f) || (arrayList = this.D) == null || arrayList.size() <= 0) ? false : true : invokeV.booleanValue;
    }
}
