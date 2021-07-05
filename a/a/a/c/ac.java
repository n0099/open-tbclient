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
    public String f1418a;

    /* renamed from: b  reason: collision with root package name */
    public String f1419b;

    /* renamed from: c  reason: collision with root package name */
    public String f1420c;

    /* renamed from: d  reason: collision with root package name */
    public String f1421d;

    /* renamed from: e  reason: collision with root package name */
    public int f1422e;

    /* renamed from: f  reason: collision with root package name */
    public String f1423f;

    /* renamed from: g  reason: collision with root package name */
    public int f1424g;

    /* renamed from: h  reason: collision with root package name */
    public String f1425h;

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
        this.f1418a = "";
        this.f1419b = "";
        this.f1420c = "";
        this.f1421d = "";
        this.f1423f = "";
        this.f1424g = 0;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.f1418a);
                jSONObject.put("id", this.f1419b);
                jSONObject.put("image", this.f1420c);
                jSONObject.put("url", this.f1421d);
                jSONObject.put("progress", this.f1422e);
                jSONObject.put("downloadPerSize", this.f1423f);
                jSONObject.put("status", this.f1424g);
                jSONObject.put("savePath", this.f1425h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
