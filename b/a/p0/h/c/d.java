package b.a.p0.h.c;

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
    public String f10245a;

    /* renamed from: b  reason: collision with root package name */
    public String f10246b;

    /* renamed from: c  reason: collision with root package name */
    public String f10247c;

    /* renamed from: d  reason: collision with root package name */
    public float f10248d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10249e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10250f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10251g;

    /* renamed from: h  reason: collision with root package name */
    public int f10252h;

    /* renamed from: i  reason: collision with root package name */
    public float f10253i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-865394990, "Lb/a/p0/h/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-865394990, "Lb/a/p0/h/c/d;");
                return;
            }
        }
        boolean z = k.f6397a;
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
        this.f10245a = "";
        this.f10246b = "";
        this.f10247c = "";
        this.f10248d = 0.0f;
        this.f10249e = false;
        this.f10250f = false;
        this.f10251g = true;
        this.f10252h = 0;
        this.f10253i = 1.0f;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "url : " + this.f10247c + "; AutoPlay : " + this.f10249e + "; Volume :" + this.f10253i + "; Loop : " + this.f10250f + "; startTime : " + this.f10248d + "; ObeyMute : " + this.f10251g + "; pos : " + this.f10252h;
        }
        return (String) invokeV.objValue;
    }
}
