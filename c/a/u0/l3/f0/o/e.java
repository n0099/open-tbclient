package c.a.u0.l3.f0.o;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f19264b;

    /* renamed from: c  reason: collision with root package name */
    public long f19265c;

    /* renamed from: d  reason: collision with root package name */
    public long f19266d;

    /* renamed from: e  reason: collision with root package name */
    public long f19267e;

    /* renamed from: f  reason: collision with root package name */
    public String f19268f;

    /* renamed from: g  reason: collision with root package name */
    public int f19269g;

    /* renamed from: h  reason: collision with root package name */
    public int f19270h;

    /* renamed from: i  reason: collision with root package name */
    public String f19271i;

    /* renamed from: j  reason: collision with root package name */
    public String f19272j;
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
        this.f19264b = -1L;
        this.f19267e = -1L;
        this.f19268f = "";
        this.f19271i = null;
    }
}
