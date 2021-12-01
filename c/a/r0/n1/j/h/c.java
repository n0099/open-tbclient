package c.a.r0.n1.j.h;

import c.a.d.m.e.n;
import c.a.q0.s.q.l0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<n> a;

    /* renamed from: b  reason: collision with root package name */
    public int f20638b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f20639c;

    /* renamed from: d  reason: collision with root package name */
    public int f20640d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.s.q.n f20641e;

    /* renamed from: f  reason: collision with root package name */
    public l0 f20642f;

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
        this.f20638b = 0;
        this.f20639c = true;
        this.f20640d = 1;
    }
}
