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
    public String f1006b;

    /* renamed from: c  reason: collision with root package name */
    public String f1007c;

    /* renamed from: d  reason: collision with root package name */
    public String f1008d;

    /* renamed from: e  reason: collision with root package name */
    public int f1009e;

    /* renamed from: f  reason: collision with root package name */
    public String f1010f;

    /* renamed from: g  reason: collision with root package name */
    public int f1011g;

    /* renamed from: h  reason: collision with root package name */
    public String f1012h;

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
        this.a = "";
        this.f1006b = "";
        this.f1007c = "";
        this.f1008d = "";
        this.f1010f = "";
        this.f1011g = 0;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.a);
                jSONObject.put("id", this.f1006b);
                jSONObject.put("image", this.f1007c);
                jSONObject.put("url", this.f1008d);
                jSONObject.put("progress", this.f1009e);
                jSONObject.put("downloadPerSize", this.f1010f);
                jSONObject.put("status", this.f1011g);
                jSONObject.put("savePath", this.f1012h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
