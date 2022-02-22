package c.a.u0.e1.y2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f17330b;

    /* renamed from: c  reason: collision with root package name */
    public String f17331c;

    /* renamed from: d  reason: collision with root package name */
    public String f17332d;

    /* renamed from: e  reason: collision with root package name */
    public int f17333e;

    /* renamed from: f  reason: collision with root package name */
    public int f17334f;

    /* renamed from: g  reason: collision with root package name */
    public int f17335g;

    /* renamed from: h  reason: collision with root package name */
    public int f17336h;

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
        this.f17330b = 0;
        this.f17331c = null;
        this.f17332d = null;
        this.f17333e = -1;
        this.f17334f = -1;
        this.f17335g = -1;
        this.f17336h = -1;
    }
}
