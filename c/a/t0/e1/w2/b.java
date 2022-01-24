package c.a.t0.e1.w2;

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
    public int f17047b;

    /* renamed from: c  reason: collision with root package name */
    public String f17048c;

    /* renamed from: d  reason: collision with root package name */
    public int f17049d;

    /* renamed from: e  reason: collision with root package name */
    public int f17050e;

    /* renamed from: f  reason: collision with root package name */
    public int f17051f;

    /* renamed from: g  reason: collision with root package name */
    public int f17052g;

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
        this.f17047b = 0;
        this.f17048c = null;
        this.f17049d = -1;
        this.f17050e = -1;
        this.f17051f = -1;
        this.f17052g = -1;
    }
}
