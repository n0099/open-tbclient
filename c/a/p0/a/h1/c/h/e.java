package c.a.p0.a.h1.c.h;

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
public class e implements c.a.p0.a.l1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c> f6558e;

    /* renamed from: f  reason: collision with root package name */
    public int f6559f;

    /* renamed from: g  reason: collision with root package name */
    public int f6560g;

    /* renamed from: h  reason: collision with root package name */
    public int f6561h;

    /* renamed from: i  reason: collision with root package name */
    public int f6562i;

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
        this.f6559f = 1;
        this.f6560g = -16777216;
        this.f6561h = 0;
        this.f6562i = 0;
    }

    @Override // c.a.p0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.f6558e = new ArrayList<>(length);
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.a(optJSONObject);
                        if (cVar.isValid()) {
                            this.f6558e.add(cVar);
                        }
                    }
                }
            }
            ArrayList<c> arrayList = this.f6558e;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            this.f6559f = (int) Math.abs(c.a.p0.a.h1.c.d.b(jSONObject.optInt("strokeWidth", 1)));
            this.f6560g = c.a.p0.a.h1.c.d.a(jSONObject.optString("strokeColor"), -16777216);
            this.f6561h = c.a.p0.a.h1.c.d.a(jSONObject.optString("fillColor"), 0);
            this.f6562i = jSONObject.optInt("zIndex", 0);
        }
    }

    @Override // c.a.p0.a.l1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<c> arrayList = this.f6558e;
            return (arrayList == null || arrayList.isEmpty()) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
