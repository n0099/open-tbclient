package c.a.o0.h.c;

import c.a.o0.a.k;
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
    public String f11006a;

    /* renamed from: b  reason: collision with root package name */
    public String f11007b;

    /* renamed from: c  reason: collision with root package name */
    public String f11008c;

    /* renamed from: d  reason: collision with root package name */
    public float f11009d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11010e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11011f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11012g;

    /* renamed from: h  reason: collision with root package name */
    public int f11013h;

    /* renamed from: i  reason: collision with root package name */
    public float f11014i;

    /* renamed from: j  reason: collision with root package name */
    public String f11015j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(648656466, "Lc/a/o0/h/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(648656466, "Lc/a/o0/h/c/d;");
                return;
            }
        }
        boolean z = k.f7049a;
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
        this.f11006a = "";
        this.f11007b = "";
        this.f11008c = "";
        this.f11009d = 0.0f;
        this.f11010e = false;
        this.f11011f = false;
        this.f11012g = true;
        this.f11013h = 0;
        this.f11014i = 1.0f;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "url : " + this.f11008c + "; AutoPlay : " + this.f11010e + "; Volume :" + this.f11014i + "; Loop : " + this.f11011f + "; startTime : " + this.f11009d + "; ObeyMute : " + this.f11012g + "; pos : " + this.f11013h;
        }
        return (String) invokeV.objValue;
    }
}
