package c.a.r0.a.i1.c.h;

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
public class f implements c.a.r0.a.m1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c> f7378e;

    /* renamed from: f  reason: collision with root package name */
    public int f7379f;

    /* renamed from: g  reason: collision with root package name */
    public float f7380g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7381h;

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
        this.f7379f = 0;
        this.f7380g = 0.0f;
        this.f7381h = false;
    }

    @Override // c.a.r0.a.m1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.f7378e = new ArrayList<>(length);
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.a(optJSONObject);
                        if (cVar.isValid()) {
                            this.f7378e.add(cVar);
                        }
                    }
                }
            }
            ArrayList<c> arrayList = this.f7378e;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            this.f7379f = c.a.r0.a.i1.c.d.a(jSONObject.optString("color"), 0);
            this.f7380g = Math.abs(c.a.r0.a.i1.c.d.b(jSONObject.optDouble("width", 0.0d)));
            this.f7381h = jSONObject.optBoolean("dottedLine", false);
            jSONObject.optBoolean("arrowLine", false);
            jSONObject.optString("arrowIconPath");
            c.a.r0.a.i1.c.d.a(jSONObject.optString("borderColor"), 0);
            Math.abs(c.a.r0.a.i1.c.d.b(jSONObject.optDouble("borderWidth", 0.0d)));
        }
    }

    @Override // c.a.r0.a.m1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<c> arrayList = this.f7378e;
            return arrayList != null && arrayList.size() > 0;
        }
        return invokeV.booleanValue;
    }
}
