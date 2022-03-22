package c.a.n0.a.y0.c.h;

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
public class e implements c.a.n0.a.c1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<c> a;

    /* renamed from: b  reason: collision with root package name */
    public int f7723b;

    /* renamed from: c  reason: collision with root package name */
    public int f7724c;

    /* renamed from: d  reason: collision with root package name */
    public int f7725d;

    /* renamed from: e  reason: collision with root package name */
    public int f7726e;

    public e() {
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
        this.f7723b = 1;
        this.f7724c = -16777216;
        this.f7725d = 0;
        this.f7726e = 0;
    }

    @Override // c.a.n0.a.c1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.a = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.a(optJSONObject);
                        if (cVar.isValid()) {
                            this.a.add(cVar);
                        }
                    }
                }
            }
            ArrayList<c> arrayList = this.a;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            this.f7723b = (int) Math.abs(c.a.n0.a.y0.c.d.b(jSONObject.optInt("strokeWidth", 1)));
            this.f7724c = c.a.n0.a.y0.c.d.a(jSONObject.optString("strokeColor"), -16777216);
            this.f7725d = c.a.n0.a.y0.c.d.a(jSONObject.optString("fillColor"), 0);
            this.f7726e = jSONObject.optInt("zIndex", 0);
        }
    }

    @Override // c.a.n0.a.c1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<c> arrayList = this.a;
            return (arrayList == null || arrayList.isEmpty()) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
