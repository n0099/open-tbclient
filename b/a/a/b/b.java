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

    /* renamed from: a  reason: collision with root package name */
    public String f1520a;

    /* renamed from: b  reason: collision with root package name */
    public String f1521b;

    /* renamed from: c  reason: collision with root package name */
    public String f1522c;

    /* renamed from: d  reason: collision with root package name */
    public String f1523d;

    /* renamed from: e  reason: collision with root package name */
    public int f1524e;

    /* renamed from: f  reason: collision with root package name */
    public String f1525f;

    /* renamed from: g  reason: collision with root package name */
    public int f1526g;

    /* renamed from: h  reason: collision with root package name */
    public String f1527h;

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
        this.f1520a = "";
        this.f1521b = "";
        this.f1522c = "";
        this.f1523d = "";
        this.f1525f = "";
        this.f1526g = 0;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.f1520a);
                jSONObject.put("id", this.f1521b);
                jSONObject.put("image", this.f1522c);
                jSONObject.put("url", this.f1523d);
                jSONObject.put("progress", this.f1524e);
                jSONObject.put("downloadPerSize", this.f1525f);
                jSONObject.put("status", this.f1526g);
                jSONObject.put("savePath", this.f1527h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
