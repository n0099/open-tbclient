package c.a.r0.x0.k2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f27134a;

    /* renamed from: b  reason: collision with root package name */
    public int f27135b;

    /* renamed from: c  reason: collision with root package name */
    public String f27136c;

    /* renamed from: d  reason: collision with root package name */
    public int f27137d;

    /* renamed from: e  reason: collision with root package name */
    public int f27138e;

    /* renamed from: f  reason: collision with root package name */
    public int f27139f;

    /* renamed from: g  reason: collision with root package name */
    public int f27140g;

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
        this.f27134a = false;
        this.f27135b = 0;
        this.f27136c = null;
        this.f27137d = -1;
        this.f27138e = -1;
        this.f27139f = -1;
        this.f27140g = -1;
    }
}
