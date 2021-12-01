package c.a.p0.j.c;

import c.a.p0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f10038b;

    /* renamed from: c  reason: collision with root package name */
    public String f10039c;

    /* renamed from: d  reason: collision with root package name */
    public float f10040d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10041e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10042f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10043g;

    /* renamed from: h  reason: collision with root package name */
    public int f10044h;

    /* renamed from: i  reason: collision with root package name */
    public float f10045i;

    /* renamed from: j  reason: collision with root package name */
    public String f10046j;

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
        this.f10038b = "";
        this.f10039c = "";
        this.f10040d = 0.0f;
        this.f10041e = false;
        this.f10042f = false;
        this.f10043g = true;
        this.f10044h = 0;
        this.f10045i = 1.0f;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "url : " + this.f10039c + "; AutoPlay : " + this.f10041e + "; Volume :" + this.f10045i + "; Loop : " + this.f10042f + "; startTime : " + this.f10040d + "; ObeyMute : " + this.f10043g + "; pos : " + this.f10044h;
        }
        return (String) invokeV.objValue;
    }
}
