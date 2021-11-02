package b.a.r0.x0.u2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f26385a;

    /* renamed from: b  reason: collision with root package name */
    public int f26386b;

    /* renamed from: c  reason: collision with root package name */
    public String f26387c;

    /* renamed from: d  reason: collision with root package name */
    public int f26388d;

    /* renamed from: e  reason: collision with root package name */
    public int f26389e;

    /* renamed from: f  reason: collision with root package name */
    public int f26390f;

    /* renamed from: g  reason: collision with root package name */
    public int f26391g;

    public b() {
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
        this.f26385a = false;
        this.f26386b = 0;
        this.f26387c = null;
        this.f26388d = -1;
        this.f26389e = -1;
        this.f26390f = -1;
        this.f26391g = -1;
    }
}
