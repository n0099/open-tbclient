package b.a.r0.x0.v2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f27991a;

    /* renamed from: b  reason: collision with root package name */
    public int f27992b;

    /* renamed from: c  reason: collision with root package name */
    public String f27993c;

    /* renamed from: d  reason: collision with root package name */
    public int f27994d;

    /* renamed from: e  reason: collision with root package name */
    public int f27995e;

    /* renamed from: f  reason: collision with root package name */
    public int f27996f;

    /* renamed from: g  reason: collision with root package name */
    public int f27997g;

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
        this.f27991a = false;
        this.f27992b = 0;
        this.f27993c = null;
        this.f27994d = -1;
        this.f27995e = -1;
        this.f27996f = -1;
        this.f27997g = -1;
    }
}
