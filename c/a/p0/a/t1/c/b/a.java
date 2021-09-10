package c.a.p0.a.t1.c.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f8660a;

    /* renamed from: b  reason: collision with root package name */
    public String f8661b;

    /* renamed from: c  reason: collision with root package name */
    public String f8662c;

    /* renamed from: d  reason: collision with root package name */
    public int f8663d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8664e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f8665f;

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
        this.f8663d = -1;
        this.f8664e = false;
        this.f8665f = false;
    }
}
