package c.a.p0.v0.j2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f25937a;

    /* renamed from: b  reason: collision with root package name */
    public int f25938b;

    /* renamed from: c  reason: collision with root package name */
    public String f25939c;

    /* renamed from: d  reason: collision with root package name */
    public int f25940d;

    /* renamed from: e  reason: collision with root package name */
    public int f25941e;

    /* renamed from: f  reason: collision with root package name */
    public int f25942f;

    /* renamed from: g  reason: collision with root package name */
    public int f25943g;

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
        this.f25937a = false;
        this.f25938b = 0;
        this.f25939c = null;
        this.f25940d = -1;
        this.f25941e = -1;
        this.f25942f = -1;
        this.f25943g = -1;
    }
}
