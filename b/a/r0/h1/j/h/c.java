package b.a.r0.h1.j.h;

import b.a.e.m.e.n;
import b.a.q0.s.q.l0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<n> f19033a;

    /* renamed from: b  reason: collision with root package name */
    public int f19034b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f19035c;

    /* renamed from: d  reason: collision with root package name */
    public int f19036d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.s.q.n f19037e;

    /* renamed from: f  reason: collision with root package name */
    public l0 f19038f;

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
        this.f19034b = 0;
        this.f19035c = true;
        this.f19036d = 1;
    }
}
