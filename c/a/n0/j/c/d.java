package c.a.n0.j.c;

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
    public String f8620b;

    /* renamed from: c  reason: collision with root package name */
    public String f8621c;

    /* renamed from: d  reason: collision with root package name */
    public float f8622d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8623e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f8624f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8625g;

    /* renamed from: h  reason: collision with root package name */
    public int f8626h;
    public float i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1781598065, "Lc/a/n0/j/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1781598065, "Lc/a/n0/j/c/d;");
                return;
            }
        }
        boolean z = c.a.n0.a.a.a;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.f8620b = "";
        this.f8621c = "";
        this.f8622d = 0.0f;
        this.f8623e = false;
        this.f8624f = false;
        this.f8625g = true;
        this.f8626h = 0;
        this.i = 1.0f;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "url : " + this.f8621c + "; AutoPlay : " + this.f8623e + "; Volume :" + this.i + "; Loop : " + this.f8624f + "; startTime : " + this.f8622d + "; ObeyMute : " + this.f8625g + "; pos : " + this.f8626h;
        }
        return (String) invokeV.objValue;
    }
}
