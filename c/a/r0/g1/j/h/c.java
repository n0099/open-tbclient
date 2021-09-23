package c.a.r0.g1.j.h;

import c.a.e.l.e.n;
import c.a.q0.s.q.l0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<n> f18464a;

    /* renamed from: b  reason: collision with root package name */
    public int f18465b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f18466c;

    /* renamed from: d  reason: collision with root package name */
    public int f18467d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.s.q.n f18468e;

    /* renamed from: f  reason: collision with root package name */
    public l0 f18469f;

    public c() {
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
        this.f18465b = 0;
        this.f18466c = true;
        this.f18467d = 1;
    }
}
