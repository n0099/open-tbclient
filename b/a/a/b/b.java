package b.a.a.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f982b;

    /* renamed from: c  reason: collision with root package name */
    public String f983c;

    /* renamed from: d  reason: collision with root package name */
    public String f984d;

    /* renamed from: e  reason: collision with root package name */
    public int f985e;

    /* renamed from: f  reason: collision with root package name */
    public String f986f;

    /* renamed from: g  reason: collision with root package name */
    public int f987g;

    /* renamed from: h  reason: collision with root package name */
    public String f988h;

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
        this.a = "";
        this.f982b = "";
        this.f983c = "";
        this.f984d = "";
        this.f986f = "";
        this.f987g = 0;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.a);
                jSONObject.put("id", this.f982b);
                jSONObject.put("image", this.f983c);
                jSONObject.put("url", this.f984d);
                jSONObject.put("progress", this.f985e);
                jSONObject.put("downloadPerSize", this.f986f);
                jSONObject.put("status", this.f987g);
                jSONObject.put("savePath", this.f988h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
