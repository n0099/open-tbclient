package c.a.s0.a.w1.d.c;

import android.util.Log;
import c.a.s0.a.g1.f;
import c.a.s0.a.o0.d.h;
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
    public String f9764b;

    /* renamed from: c  reason: collision with root package name */
    public Object f9765c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9766d;

    /* renamed from: e  reason: collision with root package name */
    public String f9767e;

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
        this.f9766d = false;
        this.f9764b = str;
    }

    public static String a(c.a.s0.a.w1.d.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            if (bVar == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("componentId", bVar.f9760f);
                jSONObject.put("pluginProvider", bVar.f9756b);
                jSONObject.put("args", bVar.f9761g);
                jSONObject.put("slaveId", bVar.f9759e);
            } catch (JSONException e2) {
                c.a.s0.a.w1.e.a.b(Log.getStackTraceString(e2));
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
                jSONObject.put("componentId", this.f9764b);
                jSONObject.put("isSuccess", this.f9766d);
                jSONObject.put("data", this.f9767e);
                if (this.f9765c != null) {
                    jSONObject.put("error", this.f9765c.toString());
                }
            } catch (JSONException e2) {
                c.a.s0.a.w1.e.a.b(Log.getStackTraceString(e2));
            }
            hVar.f8285c = jSONObject;
            f.U().m(this.a, hVar);
            c.a.s0.a.w1.e.a.b("finish event, isSuccess = " + this.f9766d);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.f9764b + ExtendedMessageFormat.QUOTE + ", error=" + this.f9765c + ", isSuccess=" + this.f9766d + ", resultData='" + this.f9767e + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
