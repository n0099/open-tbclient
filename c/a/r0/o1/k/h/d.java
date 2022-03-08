package c.a.r0.o1.k.h;

import c.a.d.o.e.n;
import c.a.q0.r.r.l0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<n> a;

    /* renamed from: b  reason: collision with root package name */
    public int f20185b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f20186c;

    /* renamed from: d  reason: collision with root package name */
    public int f20187d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.r.r.n f20188e;

    /* renamed from: f  reason: collision with root package name */
    public l0 f20189f;

    public d() {
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
        this.f20185b = 0;
        this.f20186c = true;
        this.f20187d = 1;
    }
}
