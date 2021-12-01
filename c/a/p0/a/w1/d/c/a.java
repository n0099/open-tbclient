package c.a.p0.a.w1.d.c;

import android.util.Log;
import c.a.p0.a.g1.f;
import c.a.p0.a.o0.d.h;
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
    public String f8689b;

    /* renamed from: c  reason: collision with root package name */
    public Object f8690c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8691d;

    /* renamed from: e  reason: collision with root package name */
    public String f8692e;

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
        this.f8691d = false;
        this.f8689b = str;
    }

    public static String a(c.a.p0.a.w1.d.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            if (bVar == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("componentId", bVar.f8685f);
                jSONObject.put("pluginProvider", bVar.f8681b);
                jSONObject.put("args", bVar.f8686g);
                jSONObject.put("slaveId", bVar.f8684e);
            } catch (JSONException e2) {
                c.a.p0.a.w1.e.a.b(Log.getStackTraceString(e2));
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
                jSONObject.put("componentId", this.f8689b);
                jSONObject.put("isSuccess", this.f8691d);
                jSONObject.put("data", this.f8692e);
                if (this.f8690c != null) {
                    jSONObject.put("error", this.f8690c.toString());
                }
            } catch (JSONException e2) {
                c.a.p0.a.w1.e.a.b(Log.getStackTraceString(e2));
            }
            hVar.f7181c = jSONObject;
            f.U().l(this.a, hVar);
            c.a.p0.a.w1.e.a.b("finish event, isSuccess = " + this.f8691d);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.f8689b + ExtendedMessageFormat.QUOTE + ", error=" + this.f8690c + ", isSuccess=" + this.f8691d + ", resultData='" + this.f8692e + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
