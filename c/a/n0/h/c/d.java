package c.a.n0.h.c;

import c.a.n0.a.k;
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
    public String f10760a;

    /* renamed from: b  reason: collision with root package name */
    public String f10761b;

    /* renamed from: c  reason: collision with root package name */
    public String f10762c;

    /* renamed from: d  reason: collision with root package name */
    public float f10763d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10764e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10765f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10766g;

    /* renamed from: h  reason: collision with root package name */
    public int f10767h;

    /* renamed from: i  reason: collision with root package name */
    public float f10768i;

    /* renamed from: j  reason: collision with root package name */
    public String f10769j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1838856367, "Lc/a/n0/h/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1838856367, "Lc/a/n0/h/c/d;");
                return;
            }
        }
        boolean z = k.f6803a;
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
        this.f10760a = "";
        this.f10761b = "";
        this.f10762c = "";
        this.f10763d = 0.0f;
        this.f10764e = false;
        this.f10765f = false;
        this.f10766g = true;
        this.f10767h = 0;
        this.f10768i = 1.0f;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "url : " + this.f10762c + "; AutoPlay : " + this.f10764e + "; Volume :" + this.f10768i + "; Loop : " + this.f10765f + "; startTime : " + this.f10763d + "; ObeyMute : " + this.f10766g + "; pos : " + this.f10767h;
        }
        return (String) invokeV.objValue;
    }
}
