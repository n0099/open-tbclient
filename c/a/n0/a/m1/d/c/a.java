package c.a.n0.a.m1.d.c;

import android.util.Log;
import c.a.n0.a.e0.d.h;
import c.a.n0.a.w0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f5454b;

    /* renamed from: c  reason: collision with root package name */
    public Object f5455c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5456d;

    /* renamed from: e  reason: collision with root package name */
    public String f5457e;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5456d = false;
        this.f5454b = str;
    }

    public static String a(c.a.n0.a.m1.d.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            if (bVar == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("componentId", bVar.f5451f);
                jSONObject.put("pluginProvider", bVar.f5447b);
                jSONObject.put("args", bVar.f5452g);
                jSONObject.put("slaveId", bVar.f5450e);
            } catch (JSONException e2) {
                c.a.n0.a.m1.e.a.b(Log.getStackTraceString(e2));
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h hVar = new h();
            ?? jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "functionPageFinished");
                jSONObject.put("componentId", this.f5454b);
                jSONObject.put("isSuccess", this.f5456d);
                jSONObject.put("data", this.f5457e);
                if (this.f5455c != null) {
                    jSONObject.put("error", this.f5455c.toString());
                }
            } catch (JSONException e2) {
                c.a.n0.a.m1.e.a.b(Log.getStackTraceString(e2));
            }
            hVar.f4243c = jSONObject;
            f.U().m(this.a, hVar);
            c.a.n0.a.m1.e.a.b("finish event, isSuccess = " + this.f5456d);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.f5454b + "', error=" + this.f5455c + ", isSuccess=" + this.f5456d + ", resultData='" + this.f5457e + "'}";
        }
        return (String) invokeV.objValue;
    }
}
