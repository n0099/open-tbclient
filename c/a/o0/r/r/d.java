package c.a.o0.r.r;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f10830b;

    /* renamed from: c  reason: collision with root package name */
    public int f10831c;

    /* renamed from: d  reason: collision with root package name */
    public String f10832d;

    /* renamed from: e  reason: collision with root package name */
    public String f10833e;

    /* renamed from: f  reason: collision with root package name */
    public String f10834f;

    /* renamed from: g  reason: collision with root package name */
    public String f10835g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10836h;
    public String i;
    public long j;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
