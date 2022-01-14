package c.a.c0.v.m0;

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
    public String f2479b;

    /* renamed from: c  reason: collision with root package name */
    public String f2480c;

    /* renamed from: d  reason: collision with root package name */
    public int f2481d;

    /* renamed from: e  reason: collision with root package name */
    public int f2482e;

    /* renamed from: f  reason: collision with root package name */
    public int f2483f;

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
        this.f2479b = "";
        this.f2481d = 0;
        this.f2482e = 0;
        this.f2483f = 0;
    }
}
