package c.a.r0.j.c;

import c.a.r0.a.k;
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
    public String f11082b;

    /* renamed from: c  reason: collision with root package name */
    public String f11083c;

    /* renamed from: d  reason: collision with root package name */
    public float f11084d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11085e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11086f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11087g;

    /* renamed from: h  reason: collision with root package name */
    public int f11088h;

    /* renamed from: i  reason: collision with root package name */
    public float f11089i;

    /* renamed from: j  reason: collision with root package name */
    public String f11090j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-421481325, "Lc/a/r0/j/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-421481325, "Lc/a/r0/j/c/d;");
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
        this.f11082b = "";
        this.f11083c = "";
        this.f11084d = 0.0f;
        this.f11085e = false;
        this.f11086f = false;
        this.f11087g = true;
        this.f11088h = 0;
        this.f11089i = 1.0f;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "url : " + this.f11083c + "; AutoPlay : " + this.f11085e + "; Volume :" + this.f11089i + "; Loop : " + this.f11086f + "; startTime : " + this.f11084d + "; ObeyMute : " + this.f11087g + "; pos : " + this.f11088h;
        }
        return (String) invokeV.objValue;
    }
}
