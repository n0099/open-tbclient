package c.a.p0.a.m1.d.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f6479b;

    /* renamed from: c  reason: collision with root package name */
    public String f6480c;

    /* renamed from: d  reason: collision with root package name */
    public int f6481d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6482e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6483f;

    public a() {
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
        this.f6481d = -1;
        this.f6482e = false;
        this.f6483f = false;
    }
}
