package c.a.q0.x2.i0.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f28879a;

    /* renamed from: b  reason: collision with root package name */
    public double f28880b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f28881c;

    /* renamed from: d  reason: collision with root package name */
    public int f28882d;

    /* renamed from: e  reason: collision with root package name */
    public int f28883e;

    public d() {
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

    public static d a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            d dVar = new d();
            dVar.f28879a = jSONObject.optInt("label_measure") == 2;
            dVar.f28880b = jSONObject.optDouble("show_width_scale", 1.0d);
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_pic_list");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        c.a.q0.o1.o.k.a.a(arrayList, optJSONObject.optString("pic"));
                    }
                }
            }
            dVar.f28881c = arrayList;
            dVar.f28882d = jSONObject.optInt("width");
            dVar.f28883e = jSONObject.optInt("height");
            return dVar;
        }
        return (d) invokeL.objValue;
    }
}
