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
    public String f10836b;

    /* renamed from: c  reason: collision with root package name */
    public String f10837c;

    /* renamed from: d  reason: collision with root package name */
    public float f10838d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10839e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10840f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10841g;

    /* renamed from: h  reason: collision with root package name */
    public int f10842h;

    /* renamed from: i  reason: collision with root package name */
    public float f10843i;

    /* renamed from: j  reason: collision with root package name */
    public String f10844j;

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
        this.f10836b = "";
        this.f10837c = "";
        this.f10838d = 0.0f;
        this.f10839e = false;
        this.f10840f = false;
        this.f10841g = true;
        this.f10842h = 0;
        this.f10843i = 1.0f;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "url : " + this.f10837c + "; AutoPlay : " + this.f10839e + "; Volume :" + this.f10843i + "; Loop : " + this.f10840f + "; startTime : " + this.f10838d + "; ObeyMute : " + this.f10841g + "; pos : " + this.f10842h;
        }
        return (String) invokeV.objValue;
    }
}
