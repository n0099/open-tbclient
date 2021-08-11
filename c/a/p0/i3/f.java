package c.a.p0.i3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f19899a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f19900b;

    /* renamed from: c  reason: collision with root package name */
    public int f19901c;

    /* renamed from: d  reason: collision with root package name */
    public String f19902d;

    /* renamed from: e  reason: collision with root package name */
    public long f19903e;

    public f() {
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
        this.f19899a = false;
        this.f19900b = false;
        this.f19901c = 0;
        this.f19902d = "";
        this.f19903e = 0L;
    }
}
