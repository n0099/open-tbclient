package c.a.r0.s.r;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f13309b;

    /* renamed from: c  reason: collision with root package name */
    public int f13310c;

    /* renamed from: d  reason: collision with root package name */
    public int f13311d;

    /* renamed from: e  reason: collision with root package name */
    public int f13312e;

    /* renamed from: f  reason: collision with root package name */
    public int f13313f;

    /* renamed from: g  reason: collision with root package name */
    public int f13314g;

    /* renamed from: h  reason: collision with root package name */
    public int f13315h;

    /* renamed from: i  reason: collision with root package name */
    public int f13316i;

    /* renamed from: j  reason: collision with root package name */
    public String f13317j;

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
        this.a = 0;
        this.f13309b = 0;
        this.f13310c = 1;
        this.f13311d = 1;
        this.f13312e = 0;
        this.f13313f = 0;
        this.f13314g = 1;
        this.f13315h = 0;
        this.f13316i = 0;
    }
}
