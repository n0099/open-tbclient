package c.a.p0.a.i1.c;

import android.text.TextUtils;
import c.a.p0.a.k;
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
    public String f6591a;

    /* renamed from: b  reason: collision with root package name */
    public String f6592b;

    /* renamed from: c  reason: collision with root package name */
    public String f6593c;

    /* renamed from: d  reason: collision with root package name */
    public int f6594d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6595e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6596f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6597g;

    /* renamed from: h  reason: collision with root package name */
    public int f6598h;

    /* renamed from: i  reason: collision with root package name */
    public float f6599i;

    /* renamed from: j  reason: collision with root package name */
    public String f6600j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2002882357, "Lc/a/p0/a/i1/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2002882357, "Lc/a/p0/a/i1/c/b;");
                return;
            }
        }
        boolean z = k.f7085a;
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
        this.f6591a = "";
        this.f6592b = "";
        this.f6593c = "";
        this.f6594d = 0;
        this.f6595e = false;
        this.f6596f = false;
        this.f6597g = true;
        this.f6598h = 0;
        this.f6599i = 1.0f;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
            b bVar2 = new b();
            if (jSONObject != null) {
                bVar2.f6591a = jSONObject.optString("audioId", bVar.f6591a);
                bVar2.f6592b = jSONObject.optString("slaveId", bVar.f6592b);
                bVar2.f6595e = jSONObject.optBoolean("autoplay", bVar.f6595e);
                bVar2.f6596f = jSONObject.optBoolean("loop", bVar.f6596f);
                bVar2.f6593c = jSONObject.optString("src", bVar.f6593c);
                bVar2.f6594d = jSONObject.optInt("startTime", bVar.f6594d);
                bVar2.f6597g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f6597g);
                bVar2.f6598h = jSONObject.optInt("position", bVar.f6598h);
                bVar2.f6599i = (float) jSONObject.optDouble("volume", bVar.f6599i);
                bVar2.f6600j = jSONObject.optString("cb", bVar.f6600j);
            }
            return bVar2;
        }
        return (b) invokeLL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.f6591a) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "playerId : " + this.f6591a + "; slaveId : " + this.f6592b + "; url : " + this.f6593c + "; AutoPlay : " + this.f6595e + "; Loop : " + this.f6596f + "; startTime : " + this.f6594d + "; ObeyMute : " + this.f6597g + "; pos : " + this.f6598h;
        }
        return (String) invokeV.objValue;
    }
}
