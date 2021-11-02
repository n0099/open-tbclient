package b.a.r0.h1.j.h;

import b.a.e.l.e.n;
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
    public ArrayList<n> f17564a;

    /* renamed from: b  reason: collision with root package name */
    public int f17565b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17566c;

    /* renamed from: d  reason: collision with root package name */
    public int f17567d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.s.q.n f17568e;

    /* renamed from: f  reason: collision with root package name */
    public l0 f17569f;

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
        this.f17565b = 0;
        this.f17566c = true;
        this.f17567d = 1;
    }
}
