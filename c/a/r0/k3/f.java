package c.a.r0.k3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f20982a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f20983b;

    /* renamed from: c  reason: collision with root package name */
    public int f20984c;

    /* renamed from: d  reason: collision with root package name */
    public String f20985d;

    /* renamed from: e  reason: collision with root package name */
    public long f20986e;

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
        this.f20982a = false;
        this.f20983b = false;
        this.f20984c = 0;
        this.f20985d = "";
        this.f20986e = 0L;
    }
}
