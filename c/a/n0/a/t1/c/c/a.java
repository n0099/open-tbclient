package c.a.n0.a.t1.c.c;

import android.util.Log;
import c.a.n0.a.g1.f;
import c.a.n0.a.o0.d.g;
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
    public String f8401a;

    /* renamed from: b  reason: collision with root package name */
    public String f8402b;

    /* renamed from: c  reason: collision with root package name */
    public Object f8403c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8404d;

    /* renamed from: e  reason: collision with root package name */
    public String f8405e;

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
        this.f8404d = false;
        this.f8402b = str;
    }

    public static String a(c.a.n0.a.t1.c.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            if (bVar == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("componentId", bVar.f8397f);
                jSONObject.put("pluginProvider", bVar.f8393b);
                jSONObject.put("args", bVar.f8398g);
                jSONObject.put("slaveId", bVar.f8396e);
            } catch (JSONException e2) {
                c.a.n0.a.t1.d.a.a(Log.getStackTraceString(e2));
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
                jSONObject.put("componentId", this.f8402b);
                jSONObject.put("isSuccess", this.f8404d);
                jSONObject.put("data", this.f8405e);
                if (this.f8403c != null) {
                    jSONObject.put("error", this.f8403c.toString());
                }
            } catch (JSONException e2) {
                c.a.n0.a.t1.d.a.a(Log.getStackTraceString(e2));
            }
            gVar.f7540c = jSONObject;
            f.V().m(this.f8401a, gVar);
            c.a.n0.a.t1.d.a.a("finish event, isSuccess = " + this.f8404d);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.f8402b + ExtendedMessageFormat.QUOTE + ", error=" + this.f8403c + ", isSuccess=" + this.f8404d + ", resultData='" + this.f8405e + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
