package c.a.q0.f1.j.h;

import c.a.e.l.e.n;
import c.a.p0.s.q.l0;
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
    public ArrayList<n> f17921a;

    /* renamed from: b  reason: collision with root package name */
    public int f17922b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17923c;

    /* renamed from: d  reason: collision with root package name */
    public int f17924d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.s.q.n f17925e;

    /* renamed from: f  reason: collision with root package name */
    public l0 f17926f;

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
        this.f17922b = 0;
        this.f17923c = true;
        this.f17924d = 1;
    }
}
