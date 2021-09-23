package c.a.p0.h.c;

import c.a.p0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f11042a;

    /* renamed from: b  reason: collision with root package name */
    public String f11043b;

    /* renamed from: c  reason: collision with root package name */
    public String f11044c;

    /* renamed from: d  reason: collision with root package name */
    public float f11045d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11046e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11047f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11048g;

    /* renamed from: h  reason: collision with root package name */
    public int f11049h;

    /* renamed from: i  reason: collision with root package name */
    public float f11050i;

    /* renamed from: j  reason: collision with root package name */
    public String f11051j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1158797997, "Lc/a/p0/h/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1158797997, "Lc/a/p0/h/c/d;");
                return;
            }
        }
        boolean z = k.f7085a;
    }

    public d() {
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
        this.f11042a = "";
        this.f11043b = "";
        this.f11044c = "";
        this.f11045d = 0.0f;
        this.f11046e = false;
        this.f11047f = false;
        this.f11048g = true;
        this.f11049h = 0;
        this.f11050i = 1.0f;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "url : " + this.f11044c + "; AutoPlay : " + this.f11046e + "; Volume :" + this.f11050i + "; Loop : " + this.f11047f + "; startTime : " + this.f11045d + "; ObeyMute : " + this.f11048g + "; pos : " + this.f11049h;
        }
        return (String) invokeV.objValue;
    }
}
