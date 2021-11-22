package b.a.r0.a3.f0.o;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f15683a;

    /* renamed from: b  reason: collision with root package name */
    public long f15684b;

    /* renamed from: c  reason: collision with root package name */
    public long f15685c;

    /* renamed from: d  reason: collision with root package name */
    public long f15686d;

    /* renamed from: e  reason: collision with root package name */
    public long f15687e;

    /* renamed from: f  reason: collision with root package name */
    public String f15688f;

    /* renamed from: g  reason: collision with root package name */
    public int f15689g;

    /* renamed from: h  reason: collision with root package name */
    public int f15690h;

    /* renamed from: i  reason: collision with root package name */
    public String f15691i;
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
        this.f15684b = -1L;
        this.f15687e = -1L;
        this.f15688f = "";
        this.f15691i = null;
    }
}
