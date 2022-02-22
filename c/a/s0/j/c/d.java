package c.a.s0.j.c;

import c.a.s0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f11078b;

    /* renamed from: c  reason: collision with root package name */
    public String f11079c;

    /* renamed from: d  reason: collision with root package name */
    public float f11080d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11081e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11082f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11083g;

    /* renamed from: h  reason: collision with root package name */
    public int f11084h;

    /* renamed from: i  reason: collision with root package name */
    public float f11085i;

    /* renamed from: j  reason: collision with root package name */
    public String f11086j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2066031508, "Lc/a/s0/j/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2066031508, "Lc/a/s0/j/c/d;");
                return;
            }
        }
        boolean z = k.a;
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
        this.a = "";
        this.f11078b = "";
        this.f11079c = "";
        this.f11080d = 0.0f;
        this.f11081e = false;
        this.f11082f = false;
        this.f11083g = true;
        this.f11084h = 0;
        this.f11085i = 1.0f;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "url : " + this.f11079c + "; AutoPlay : " + this.f11081e + "; Volume :" + this.f11085i + "; Loop : " + this.f11082f + "; startTime : " + this.f11080d + "; ObeyMute : " + this.f11083g + "; pos : " + this.f11084h;
        }
        return (String) invokeV.objValue;
    }
}
