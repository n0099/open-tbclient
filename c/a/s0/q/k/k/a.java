package c.a.s0.q.k.k;

import c.a.s0.q.i.i;
import c.a.s0.q.i.j;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.s0.q.i.e a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.s0.q.i.e f11872b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.q.i.c f11873c;

    /* renamed from: d  reason: collision with root package name */
    public Collection<j> f11874d;

    /* renamed from: e  reason: collision with root package name */
    public Collection<i> f11875e;

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
            }
        }
    }
}
