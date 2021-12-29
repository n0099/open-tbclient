package c.a.e.m.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f3521b;

    /* renamed from: c  reason: collision with root package name */
    public int f3522c;

    /* renamed from: d  reason: collision with root package name */
    public String f3523d;

    /* renamed from: e  reason: collision with root package name */
    public int f3524e;

    /* renamed from: f  reason: collision with root package name */
    public int f3525f;

    /* renamed from: g  reason: collision with root package name */
    public int f3526g;

    /* renamed from: h  reason: collision with root package name */
    public int f3527h;

    /* renamed from: i  reason: collision with root package name */
    public int f3528i;

    /* renamed from: j  reason: collision with root package name */
    public String f3529j;

    /* renamed from: k  reason: collision with root package name */
    public int f3530k;
    public int l;

    public a() {
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
        this.f3528i = 3;
    }
}
