package a.a.a.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ac {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f1451a;

    /* renamed from: b  reason: collision with root package name */
    public String f1452b;

    /* renamed from: c  reason: collision with root package name */
    public String f1453c;

    /* renamed from: d  reason: collision with root package name */
    public String f1454d;

    /* renamed from: e  reason: collision with root package name */
    public int f1455e;

    /* renamed from: f  reason: collision with root package name */
    public String f1456f;

    /* renamed from: g  reason: collision with root package name */
    public int f1457g;

    /* renamed from: h  reason: collision with root package name */
    public String f1458h;

    public ac() {
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
        this.f1451a = "";
        this.f1452b = "";
        this.f1453c = "";
        this.f1454d = "";
        this.f1456f = "";
        this.f1457g = 0;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.f1451a);
                jSONObject.put("id", this.f1452b);
                jSONObject.put("image", this.f1453c);
                jSONObject.put("url", this.f1454d);
                jSONObject.put("progress", this.f1455e);
                jSONObject.put("downloadPerSize", this.f1456f);
                jSONObject.put("status", this.f1457g);
                jSONObject.put("savePath", this.f1458h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
