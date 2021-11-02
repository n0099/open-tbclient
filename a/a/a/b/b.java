package a.a.a.b;

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
    public String f1011a;

    /* renamed from: b  reason: collision with root package name */
    public String f1012b;

    /* renamed from: c  reason: collision with root package name */
    public String f1013c;

    /* renamed from: d  reason: collision with root package name */
    public String f1014d;

    /* renamed from: e  reason: collision with root package name */
    public int f1015e;

    /* renamed from: f  reason: collision with root package name */
    public String f1016f;

    /* renamed from: g  reason: collision with root package name */
    public int f1017g;

    /* renamed from: h  reason: collision with root package name */
    public String f1018h;

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
        this.f1011a = "";
        this.f1012b = "";
        this.f1013c = "";
        this.f1014d = "";
        this.f1016f = "";
        this.f1017g = 0;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.f1011a);
                jSONObject.put("id", this.f1012b);
                jSONObject.put("image", this.f1013c);
                jSONObject.put("url", this.f1014d);
                jSONObject.put("progress", this.f1015e);
                jSONObject.put("downloadPerSize", this.f1016f);
                jSONObject.put("status", this.f1017g);
                jSONObject.put("savePath", this.f1018h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
