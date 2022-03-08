package c.a.p0.q.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f10956b;

    /* renamed from: c  reason: collision with root package name */
    public long f10957c;

    /* renamed from: d  reason: collision with root package name */
    public long f10958d;

    /* renamed from: e  reason: collision with root package name */
    public int f10959e;

    /* renamed from: f  reason: collision with root package name */
    public long f10960f;

    public d() {
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
        this.a = "";
        this.f10956b = 0L;
        this.f10957c = 0L;
        this.f10958d = 0L;
        this.f10959e = 0;
    }
}
