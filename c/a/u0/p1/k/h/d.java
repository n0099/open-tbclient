package c.a.u0.p1.k.h;

import c.a.d.o.e.n;
import c.a.t0.s.r.l0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<n> a;

    /* renamed from: b  reason: collision with root package name */
    public int f20850b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f20851c;

    /* renamed from: d  reason: collision with root package name */
    public int f20852d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.s.r.n f20853e;

    /* renamed from: f  reason: collision with root package name */
    public l0 f20854f;

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
        this.f20850b = 0;
        this.f20851c = true;
        this.f20852d = 1;
    }
}
