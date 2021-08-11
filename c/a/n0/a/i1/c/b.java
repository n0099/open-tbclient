package c.a.n0.a.i1.c;

import android.text.TextUtils;
import c.a.n0.a.k;
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
    public String f6309a;

    /* renamed from: b  reason: collision with root package name */
    public String f6310b;

    /* renamed from: c  reason: collision with root package name */
    public String f6311c;

    /* renamed from: d  reason: collision with root package name */
    public int f6312d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6313e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6314f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6315g;

    /* renamed from: h  reason: collision with root package name */
    public int f6316h;

    /* renamed from: i  reason: collision with root package name */
    public float f6317i;

    /* renamed from: j  reason: collision with root package name */
    public String f6318j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1744716919, "Lc/a/n0/a/i1/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1744716919, "Lc/a/n0/a/i1/c/b;");
                return;
            }
        }
        boolean z = k.f6803a;
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
        this.f6309a = "";
        this.f6310b = "";
        this.f6311c = "";
        this.f6312d = 0;
        this.f6313e = false;
        this.f6314f = false;
        this.f6315g = true;
        this.f6316h = 0;
        this.f6317i = 1.0f;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
            b bVar2 = new b();
            if (jSONObject != null) {
                bVar2.f6309a = jSONObject.optString("audioId", bVar.f6309a);
                bVar2.f6310b = jSONObject.optString("slaveId", bVar.f6310b);
                bVar2.f6313e = jSONObject.optBoolean("autoplay", bVar.f6313e);
                bVar2.f6314f = jSONObject.optBoolean("loop", bVar.f6314f);
                bVar2.f6311c = jSONObject.optString("src", bVar.f6311c);
                bVar2.f6312d = jSONObject.optInt("startTime", bVar.f6312d);
                bVar2.f6315g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f6315g);
                bVar2.f6316h = jSONObject.optInt("position", bVar.f6316h);
                bVar2.f6317i = (float) jSONObject.optDouble("volume", bVar.f6317i);
                bVar2.f6318j = jSONObject.optString("cb", bVar.f6318j);
            }
            return bVar2;
        }
        return (b) invokeLL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.f6309a) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "playerId : " + this.f6309a + "; slaveId : " + this.f6310b + "; url : " + this.f6311c + "; AutoPlay : " + this.f6313e + "; Loop : " + this.f6314f + "; startTime : " + this.f6312d + "; ObeyMute : " + this.f6315g + "; pos : " + this.f6316h;
        }
        return (String) invokeV.objValue;
    }
}
