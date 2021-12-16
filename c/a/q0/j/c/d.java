package c.a.q0.j.c;

import c.a.q0.a.k;
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
    public String f10347b;

    /* renamed from: c  reason: collision with root package name */
    public String f10348c;

    /* renamed from: d  reason: collision with root package name */
    public float f10349d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10350e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10351f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10352g;

    /* renamed from: h  reason: collision with root package name */
    public int f10353h;

    /* renamed from: i  reason: collision with root package name */
    public float f10354i;

    /* renamed from: j  reason: collision with root package name */
    public String f10355j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1385973138, "Lc/a/q0/j/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1385973138, "Lc/a/q0/j/c/d;");
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
        this.f10347b = "";
        this.f10348c = "";
        this.f10349d = 0.0f;
        this.f10350e = false;
        this.f10351f = false;
        this.f10352g = true;
        this.f10353h = 0;
        this.f10354i = 1.0f;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "url : " + this.f10348c + "; AutoPlay : " + this.f10350e + "; Volume :" + this.f10354i + "; Loop : " + this.f10351f + "; startTime : " + this.f10349d + "; ObeyMute : " + this.f10352g + "; pos : " + this.f10353h;
        }
        return (String) invokeV.objValue;
    }
}
