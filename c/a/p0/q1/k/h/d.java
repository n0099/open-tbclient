package c.a.p0.q1.k.h;

import c.a.d.o.e.n;
import c.a.o0.r.r.l0;
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
    public int f17521b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17522c;

    /* renamed from: d  reason: collision with root package name */
    public int f17523d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.r.r.n f17524e;

    /* renamed from: f  reason: collision with root package name */
    public l0 f17525f;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17521b = 0;
        this.f17522c = true;
        this.f17523d = 1;
    }
}
