package c.a.r0.j3.r0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f21071a;

    /* renamed from: b  reason: collision with root package name */
    public long f21072b;

    /* renamed from: c  reason: collision with root package name */
    public int f21073c;

    /* renamed from: d  reason: collision with root package name */
    public String f21074d;

    /* renamed from: e  reason: collision with root package name */
    public Map<Long, a> f21075e;

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
        this.f21071a = System.currentTimeMillis();
        this.f21075e = new HashMap();
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.f21071a);
            jSONObject.put("endTime", this.f21072b);
            jSONObject.put("errorCode", this.f21073c);
            jSONObject.put("errorMessage", this.f21074d);
            if (this.f21075e != null) {
                JSONArray jSONArray = new JSONArray();
                for (a aVar : this.f21075e.values()) {
                    jSONArray.put(aVar.a());
                }
                jSONObject.put("imageInfo", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
