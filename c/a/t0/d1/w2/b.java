package c.a.t0.d1.w2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f16715b;

    /* renamed from: c  reason: collision with root package name */
    public String f16716c;

    /* renamed from: d  reason: collision with root package name */
    public int f16717d;

    /* renamed from: e  reason: collision with root package name */
    public int f16718e;

    /* renamed from: f  reason: collision with root package name */
    public int f16719f;

    /* renamed from: g  reason: collision with root package name */
    public int f16720g;

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
        this.a = false;
        this.f16715b = 0;
        this.f16716c = null;
        this.f16717d = -1;
        this.f16718e = -1;
        this.f16719f = -1;
        this.f16720g = -1;
    }
}
