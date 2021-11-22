package b.a.p0.j.c;

import b.a.p0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f10943a;

    /* renamed from: b  reason: collision with root package name */
    public String f10944b;

    /* renamed from: c  reason: collision with root package name */
    public String f10945c;

    /* renamed from: d  reason: collision with root package name */
    public float f10946d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10947e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10948f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10949g;

    /* renamed from: h  reason: collision with root package name */
    public int f10950h;

    /* renamed from: i  reason: collision with root package name */
    public float f10951i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-808136688, "Lb/a/p0/j/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-808136688, "Lb/a/p0/j/c/d;");
                return;
            }
        }
        boolean z = k.f6863a;
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
        this.f10943a = "";
        this.f10944b = "";
        this.f10945c = "";
        this.f10946d = 0.0f;
        this.f10947e = false;
        this.f10948f = false;
        this.f10949g = true;
        this.f10950h = 0;
        this.f10951i = 1.0f;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "url : " + this.f10945c + "; AutoPlay : " + this.f10947e + "; Volume :" + this.f10951i + "; Loop : " + this.f10948f + "; startTime : " + this.f10946d + "; ObeyMute : " + this.f10949g + "; pos : " + this.f10950h;
        }
        return (String) invokeV.objValue;
    }
}
