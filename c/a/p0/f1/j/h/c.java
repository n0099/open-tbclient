package c.a.p0.f1.j.h;

import c.a.e.k.e.n;
import c.a.o0.s.q.l0;
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
    public ArrayList<n> f17573a;

    /* renamed from: b  reason: collision with root package name */
    public int f17574b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17575c;

    /* renamed from: d  reason: collision with root package name */
    public int f17576d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.s.q.n f17577e;

    /* renamed from: f  reason: collision with root package name */
    public l0 f17578f;

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
        this.f17574b = 0;
        this.f17575c = true;
        this.f17576d = 1;
    }
}
