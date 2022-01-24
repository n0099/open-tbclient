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
    public String f10978b;

    /* renamed from: c  reason: collision with root package name */
    public String f10979c;

    /* renamed from: d  reason: collision with root package name */
    public float f10980d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10981e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10982f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10983g;

    /* renamed from: h  reason: collision with root package name */
    public int f10984h;

    /* renamed from: i  reason: collision with root package name */
    public float f10985i;

    /* renamed from: j  reason: collision with root package name */
    public String f10986j;

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
        this.f10978b = "";
        this.f10979c = "";
        this.f10980d = 0.0f;
        this.f10981e = false;
        this.f10982f = false;
        this.f10983g = true;
        this.f10984h = 0;
        this.f10985i = 1.0f;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "url : " + this.f10979c + "; AutoPlay : " + this.f10981e + "; Volume :" + this.f10985i + "; Loop : " + this.f10982f + "; startTime : " + this.f10980d + "; ObeyMute : " + this.f10983g + "; pos : " + this.f10984h;
        }
        return (String) invokeV.objValue;
    }
}
