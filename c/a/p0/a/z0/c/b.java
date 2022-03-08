package c.a.p0.a.z0.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f9267b;

    /* renamed from: c  reason: collision with root package name */
    public String f9268c;

    /* renamed from: d  reason: collision with root package name */
    public int f9269d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9270e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9271f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9272g;

    /* renamed from: h  reason: collision with root package name */
    public int f9273h;

    /* renamed from: i  reason: collision with root package name */
    public float f9274i;

    /* renamed from: j  reason: collision with root package name */
    public String f9275j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-118053401, "Lc/a/p0/a/z0/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-118053401, "Lc/a/p0/a/z0/c/b;");
                return;
            }
        }
        boolean z = c.a.p0.a.a.a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.f9267b = "";
        this.f9268c = "";
        this.f9269d = 0;
        this.f9270e = false;
        this.f9271f = false;
        this.f9272g = true;
        this.f9273h = 0;
        this.f9274i = 1.0f;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
            b bVar2 = new b();
            if (jSONObject != null) {
                bVar2.a = jSONObject.optString("audioId", bVar.a);
                bVar2.f9267b = jSONObject.optString("slaveId", bVar.f9267b);
                bVar2.f9270e = jSONObject.optBoolean("autoplay", bVar.f9270e);
                bVar2.f9271f = jSONObject.optBoolean("loop", bVar.f9271f);
                bVar2.f9268c = jSONObject.optString("src", bVar.f9268c);
                bVar2.f9269d = jSONObject.optInt(FetchLog.START_TIME, bVar.f9269d);
                bVar2.f9272g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f9272g);
                bVar2.f9273h = jSONObject.optInt("position", bVar.f9273h);
                bVar2.f9274i = (float) jSONObject.optDouble("volume", bVar.f9274i);
                bVar2.f9275j = jSONObject.optString("cb", bVar.f9275j);
            }
            return bVar2;
        }
        return (b) invokeLL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.a) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "playerId : " + this.a + "; slaveId : " + this.f9267b + "; url : " + this.f9268c + "; AutoPlay : " + this.f9270e + "; Loop : " + this.f9271f + "; startTime : " + this.f9269d + "; ObeyMute : " + this.f9272g + "; pos : " + this.f9273h;
        }
        return (String) invokeV.objValue;
    }
}
