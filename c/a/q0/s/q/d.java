package c.a.q0.s.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14125a;

    /* renamed from: b  reason: collision with root package name */
    public String f14126b;

    /* renamed from: c  reason: collision with root package name */
    public int f14127c;

    /* renamed from: d  reason: collision with root package name */
    public String f14128d;

    /* renamed from: e  reason: collision with root package name */
    public String f14129e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14130f;

    /* renamed from: g  reason: collision with root package name */
    public String f14131g;

    /* renamed from: h  reason: collision with root package name */
    public long f14132h;

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
            }
        }
    }
}
