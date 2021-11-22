package b.a.p0.a.j1.c;

import android.text.TextUtils;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
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

    /* renamed from: a  reason: collision with root package name */
    public String f6570a;

    /* renamed from: b  reason: collision with root package name */
    public String f6571b;

    /* renamed from: c  reason: collision with root package name */
    public String f6572c;

    /* renamed from: d  reason: collision with root package name */
    public int f6573d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6574e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6575f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6576g;

    /* renamed from: h  reason: collision with root package name */
    public int f6577h;

    /* renamed from: i  reason: collision with root package name */
    public float f6578i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-894047081, "Lb/a/p0/a/j1/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-894047081, "Lb/a/p0/a/j1/c/b;");
                return;
            }
        }
        boolean z = k.f6863a;
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
        this.f6570a = "";
        this.f6571b = "";
        this.f6572c = "";
        this.f6573d = 0;
        this.f6574e = false;
        this.f6575f = false;
        this.f6576g = true;
        this.f6577h = 0;
        this.f6578i = 1.0f;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
            b bVar2 = new b();
            if (jSONObject != null) {
                bVar2.f6570a = jSONObject.optString("audioId", bVar.f6570a);
                bVar2.f6571b = jSONObject.optString("slaveId", bVar.f6571b);
                bVar2.f6574e = jSONObject.optBoolean("autoplay", bVar.f6574e);
                bVar2.f6575f = jSONObject.optBoolean("loop", bVar.f6575f);
                bVar2.f6572c = jSONObject.optString("src", bVar.f6572c);
                bVar2.f6573d = jSONObject.optInt("startTime", bVar.f6573d);
                bVar2.f6576g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f6576g);
                bVar2.f6577h = jSONObject.optInt("position", bVar.f6577h);
                bVar2.f6578i = (float) jSONObject.optDouble("volume", bVar.f6578i);
                bVar2.j = jSONObject.optString("cb", bVar.j);
            }
            return bVar2;
        }
        return (b) invokeLL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.f6570a) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "playerId : " + this.f6570a + "; slaveId : " + this.f6571b + "; url : " + this.f6572c + "; AutoPlay : " + this.f6574e + "; Loop : " + this.f6575f + "; startTime : " + this.f6573d + "; ObeyMute : " + this.f6576g + "; pos : " + this.f6577h;
        }
        return (String) invokeV.objValue;
    }
}
