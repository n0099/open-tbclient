package b.a.p0.a.t1.c.c;

import android.util.Log;
import b.a.p0.a.g1.f;
import b.a.p0.a.o0.d.g;
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
    public String f7949a;

    /* renamed from: b  reason: collision with root package name */
    public String f7950b;

    /* renamed from: c  reason: collision with root package name */
    public Object f7951c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7952d;

    /* renamed from: e  reason: collision with root package name */
    public String f7953e;

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
        this.f7952d = false;
        this.f7950b = str;
    }

    public static String a(b.a.p0.a.t1.c.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            if (bVar == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("componentId", bVar.f7945f);
                jSONObject.put("pluginProvider", bVar.f7941b);
                jSONObject.put("args", bVar.f7946g);
                jSONObject.put("slaveId", bVar.f7944e);
            } catch (JSONException e2) {
                b.a.p0.a.t1.d.a.a(Log.getStackTraceString(e2));
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
                jSONObject.put("componentId", this.f7950b);
                jSONObject.put("isSuccess", this.f7952d);
                jSONObject.put("data", this.f7953e);
                if (this.f7951c != null) {
                    jSONObject.put("error", this.f7951c.toString());
                }
            } catch (JSONException e2) {
                b.a.p0.a.t1.d.a.a(Log.getStackTraceString(e2));
            }
            gVar.f7118c = jSONObject;
            f.T().l(this.f7949a, gVar);
            b.a.p0.a.t1.d.a.a("finish event, isSuccess = " + this.f7952d);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.f7950b + ExtendedMessageFormat.QUOTE + ", error=" + this.f7951c + ", isSuccess=" + this.f7952d + ", resultData='" + this.f7953e + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
