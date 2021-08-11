package c.a.o0.s.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f13912a;

    /* renamed from: b  reason: collision with root package name */
    public int f13913b;

    /* renamed from: c  reason: collision with root package name */
    public int f13914c;

    /* renamed from: d  reason: collision with root package name */
    public int f13915d;

    /* renamed from: e  reason: collision with root package name */
    public int f13916e;

    /* renamed from: f  reason: collision with root package name */
    public int f13917f;

    /* renamed from: g  reason: collision with root package name */
    public int f13918g;

    /* renamed from: h  reason: collision with root package name */
    public int f13919h;

    /* renamed from: i  reason: collision with root package name */
    public int f13920i;

    /* renamed from: j  reason: collision with root package name */
    public String f13921j;

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
        this.f13912a = 0;
        this.f13913b = 0;
        this.f13914c = 1;
        this.f13915d = 1;
        this.f13916e = 0;
        this.f13917f = 0;
        this.f13918g = 1;
        this.f13919h = 0;
        this.f13920i = 0;
    }
}
