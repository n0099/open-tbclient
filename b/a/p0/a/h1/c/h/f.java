package b.a.p0.a.h1.c.h;

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
public class f implements b.a.p0.a.l1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c> f5890e;

    /* renamed from: f  reason: collision with root package name */
    public int f5891f;

    /* renamed from: g  reason: collision with root package name */
    public float f5892g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5893h;

    public f() {
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
        this.f5891f = 0;
        this.f5892g = 0.0f;
        this.f5893h = false;
    }

    @Override // b.a.p0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.f5890e = new ArrayList<>(length);
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.a(optJSONObject);
                        if (cVar.isValid()) {
                            this.f5890e.add(cVar);
                        }
                    }
                }
            }
            ArrayList<c> arrayList = this.f5890e;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            this.f5891f = b.a.p0.a.h1.c.d.a(jSONObject.optString("color"), 0);
            this.f5892g = Math.abs(b.a.p0.a.h1.c.d.b(jSONObject.optDouble("width", 0.0d)));
            this.f5893h = jSONObject.optBoolean("dottedLine", false);
            jSONObject.optBoolean("arrowLine", false);
            jSONObject.optString("arrowIconPath");
            b.a.p0.a.h1.c.d.a(jSONObject.optString("borderColor"), 0);
            Math.abs(b.a.p0.a.h1.c.d.b(jSONObject.optDouble("borderWidth", 0.0d)));
        }
    }

    @Override // b.a.p0.a.l1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<c> arrayList = this.f5890e;
            return arrayList != null && arrayList.size() > 0;
        }
        return invokeV.booleanValue;
    }
}
