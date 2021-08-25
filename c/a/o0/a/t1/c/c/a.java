package c.a.o0.a.t1.c.c;

import android.util.Log;
import c.a.o0.a.g1.f;
import c.a.o0.a.o0.d.g;
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

    /* renamed from: a  reason: collision with root package name */
    public String f8647a;

    /* renamed from: b  reason: collision with root package name */
    public String f8648b;

    /* renamed from: c  reason: collision with root package name */
    public Object f8649c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8650d;

    /* renamed from: e  reason: collision with root package name */
    public String f8651e;

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
        this.f8650d = false;
        this.f8648b = str;
    }

    public static String a(c.a.o0.a.t1.c.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            if (bVar == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("componentId", bVar.f8643f);
                jSONObject.put("pluginProvider", bVar.f8639b);
                jSONObject.put("args", bVar.f8644g);
                jSONObject.put("slaveId", bVar.f8642e);
            } catch (JSONException e2) {
                c.a.o0.a.t1.d.a.a(Log.getStackTraceString(e2));
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g gVar = new g();
            ?? jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "functionPageFinished");
                jSONObject.put("componentId", this.f8648b);
                jSONObject.put("isSuccess", this.f8650d);
                jSONObject.put("data", this.f8651e);
                if (this.f8649c != null) {
                    jSONObject.put("error", this.f8649c.toString());
                }
            } catch (JSONException e2) {
                c.a.o0.a.t1.d.a.a(Log.getStackTraceString(e2));
            }
            gVar.f7786c = jSONObject;
            f.V().m(this.f8647a, gVar);
            c.a.o0.a.t1.d.a.a("finish event, isSuccess = " + this.f8650d);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.f8648b + ExtendedMessageFormat.QUOTE + ", error=" + this.f8649c + ", isSuccess=" + this.f8650d + ", resultData='" + this.f8651e + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
