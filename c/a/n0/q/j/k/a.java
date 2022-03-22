package c.a.n0.q.j.k;

import c.a.n0.q.h.i;
import c.a.n0.q.h.j;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.q.h.e a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.q.h.e f9270b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.q.h.c f9271c;

    /* renamed from: d  reason: collision with root package name */
    public Collection<j> f9272d;

    /* renamed from: e  reason: collision with root package name */
    public Collection<i> f9273e;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
