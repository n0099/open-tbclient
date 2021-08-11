package c.a.p0.x2.f0.o;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f28481a;

    /* renamed from: b  reason: collision with root package name */
    public long f28482b;

    /* renamed from: c  reason: collision with root package name */
    public long f28483c;

    /* renamed from: d  reason: collision with root package name */
    public long f28484d;

    /* renamed from: e  reason: collision with root package name */
    public long f28485e;

    /* renamed from: f  reason: collision with root package name */
    public String f28486f;

    /* renamed from: g  reason: collision with root package name */
    public int f28487g;

    /* renamed from: h  reason: collision with root package name */
    public int f28488h;

    /* renamed from: i  reason: collision with root package name */
    public String f28489i;

    /* renamed from: j  reason: collision with root package name */
    public String f28490j;
    public String k;
    public String l;

    public e() {
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
        this.f28482b = -1L;
        this.f28485e = -1L;
        this.f28486f = "";
        this.f28489i = null;
    }
}
