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
    public String f3603b;

    /* renamed from: c  reason: collision with root package name */
    public int f3604c;

    /* renamed from: d  reason: collision with root package name */
    public String f3605d;

    /* renamed from: e  reason: collision with root package name */
    public int f3606e;

    /* renamed from: f  reason: collision with root package name */
    public int f3607f;

    /* renamed from: g  reason: collision with root package name */
    public int f3608g;

    /* renamed from: h  reason: collision with root package name */
    public int f3609h;

    /* renamed from: i  reason: collision with root package name */
    public int f3610i;

    /* renamed from: j  reason: collision with root package name */
    public String f3611j;
    public int k;
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
        this.f3610i = 3;
    }
}
