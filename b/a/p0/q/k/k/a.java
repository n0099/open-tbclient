package b.a.p0.q.k.k;

import b.a.p0.q.i.i;
import b.a.p0.q.i.j;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.q.i.e f11956a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.q.i.e f11957b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.p0.q.i.c f11958c;

    /* renamed from: d  reason: collision with root package name */
    public Collection<j> f11959d;

    /* renamed from: e  reason: collision with root package name */
    public Collection<i> f11960e;

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
