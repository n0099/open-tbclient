package c.a.p0.j.c;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f10303b;

    /* renamed from: c  reason: collision with root package name */
    public String f10304c;

    /* renamed from: d  reason: collision with root package name */
    public float f10305d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10306e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10307f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10308g;

    /* renamed from: h  reason: collision with root package name */
    public int f10309h;

    /* renamed from: i  reason: collision with root package name */
    public float f10310i;

    /* renamed from: j  reason: collision with root package name */
    public String f10311j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1101539695, "Lc/a/p0/j/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1101539695, "Lc/a/p0/j/c/d;");
                return;
            }
        }
        boolean z = c.a.p0.a.a.a;
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
        this.f10303b = "";
        this.f10304c = "";
        this.f10305d = 0.0f;
        this.f10306e = false;
        this.f10307f = false;
        this.f10308g = true;
        this.f10309h = 0;
        this.f10310i = 1.0f;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "url : " + this.f10304c + "; AutoPlay : " + this.f10306e + "; Volume :" + this.f10310i + "; Loop : " + this.f10307f + "; startTime : " + this.f10305d + "; ObeyMute : " + this.f10308g + "; pos : " + this.f10309h;
        }
        return (String) invokeV.objValue;
    }
}
