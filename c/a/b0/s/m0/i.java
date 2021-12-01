package c.a.b0.s.m0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f2040b;

    /* renamed from: c  reason: collision with root package name */
    public String f2041c;

    /* renamed from: d  reason: collision with root package name */
    public int f2042d;

    /* renamed from: e  reason: collision with root package name */
    public int f2043e;

    /* renamed from: f  reason: collision with root package name */
    public int f2044f;

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2040b = "";
        this.f2042d = 0;
        this.f2043e = 0;
        this.f2044f = 0;
    }
}
