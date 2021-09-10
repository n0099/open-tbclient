package c.a.q0.s.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f14166a;

    /* renamed from: b  reason: collision with root package name */
    public int f14167b;

    /* renamed from: c  reason: collision with root package name */
    public int f14168c;

    /* renamed from: d  reason: collision with root package name */
    public int f14169d;

    /* renamed from: e  reason: collision with root package name */
    public int f14170e;

    /* renamed from: f  reason: collision with root package name */
    public int f14171f;

    /* renamed from: g  reason: collision with root package name */
    public int f14172g;

    /* renamed from: h  reason: collision with root package name */
    public int f14173h;

    /* renamed from: i  reason: collision with root package name */
    public int f14174i;

    /* renamed from: j  reason: collision with root package name */
    public String f14175j;

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
        this.f14166a = 0;
        this.f14167b = 0;
        this.f14168c = 1;
        this.f14169d = 1;
        this.f14170e = 0;
        this.f14171f = 0;
        this.f14172g = 1;
        this.f14173h = 0;
        this.f14174i = 0;
    }
}
