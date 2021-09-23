package c.a.r0.w0.k2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f26959a;

    /* renamed from: b  reason: collision with root package name */
    public int f26960b;

    /* renamed from: c  reason: collision with root package name */
    public String f26961c;

    /* renamed from: d  reason: collision with root package name */
    public int f26962d;

    /* renamed from: e  reason: collision with root package name */
    public int f26963e;

    /* renamed from: f  reason: collision with root package name */
    public int f26964f;

    /* renamed from: g  reason: collision with root package name */
    public int f26965g;

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
        this.f26959a = false;
        this.f26960b = 0;
        this.f26961c = null;
        this.f26962d = -1;
        this.f26963e = -1;
        this.f26964f = -1;
        this.f26965g = -1;
    }
}
