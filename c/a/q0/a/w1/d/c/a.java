package c.a.q0.a.w1.d.c;

import android.util.Log;
import c.a.q0.a.g1.f;
import c.a.q0.a.o0.d.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f8998b;

    /* renamed from: c  reason: collision with root package name */
    public Object f8999c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9000d;

    /* renamed from: e  reason: collision with root package name */
    public String f9001e;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9000d = false;
        this.f8998b = str;
    }

    public static String a(c.a.q0.a.w1.d.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            if (bVar == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("componentId", bVar.f8994f);
                jSONObject.put("pluginProvider", bVar.f8990b);
                jSONObject.put("args", bVar.f8995g);
                jSONObject.put("slaveId", bVar.f8993e);
            } catch (JSONException e2) {
                c.a.q0.a.w1.e.a.b(Log.getStackTraceString(e2));
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
                jSONObject.put("componentId", this.f8998b);
                jSONObject.put("isSuccess", this.f9000d);
                jSONObject.put("data", this.f9001e);
                if (this.f8999c != null) {
                    jSONObject.put("error", this.f8999c.toString());
                }
            } catch (JSONException e2) {
                c.a.q0.a.w1.e.a.b(Log.getStackTraceString(e2));
            }
            hVar.f7490c = jSONObject;
            f.U().m(this.a, hVar);
            c.a.q0.a.w1.e.a.b("finish event, isSuccess = " + this.f9000d);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.f8998b + ExtendedMessageFormat.QUOTE + ", error=" + this.f8999c + ", isSuccess=" + this.f9000d + ", resultData='" + this.f9001e + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
