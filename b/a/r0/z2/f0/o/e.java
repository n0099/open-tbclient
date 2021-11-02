package b.a.r0.z2.f0.o;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f28048a;

    /* renamed from: b  reason: collision with root package name */
    public long f28049b;

    /* renamed from: c  reason: collision with root package name */
    public long f28050c;

    /* renamed from: d  reason: collision with root package name */
    public long f28051d;

    /* renamed from: e  reason: collision with root package name */
    public long f28052e;

    /* renamed from: f  reason: collision with root package name */
    public String f28053f;

    /* renamed from: g  reason: collision with root package name */
    public int f28054g;

    /* renamed from: h  reason: collision with root package name */
    public int f28055h;

    /* renamed from: i  reason: collision with root package name */
    public String f28056i;
    public String j;
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
        this.f28049b = -1L;
        this.f28052e = -1L;
        this.f28053f = "";
        this.f28056i = null;
    }
}
