package b.a.p0.j.p0;

import androidx.annotation.Nullable;
import b.a.p0.a.g1.f;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.p.b.a.i;
import b.a.p0.a.u.e.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
@Service
/* loaded from: classes4.dex */
public class a extends b.a.p0.a.u.e.c.a implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a.InterfaceC0415a> f11329a;

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
                return;
            }
        }
        this.f11329a = new ArrayList<>();
    }

    @Nullable
    public static a d() {
        InterceptResult invokeV;
        b.a.p0.j.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            g V = f.U().V();
            if (V == null || (aVar = (b.a.p0.j.n.a) V.n(b.a.p0.j.n.a.class)) == null) {
                return null;
            }
            return aVar.r3();
        }
        return (a) invokeV.objValue;
    }

    @Override // b.a.p0.a.p.b.a.i
    public b.a.p0.a.u.e.c.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d() : (b.a.p0.a.u.e.c.a) invokeV.objValue;
    }

    @Override // b.a.p0.a.u.e.c.a
    public synchronized void b(a.InterfaceC0415a interfaceC0415a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0415a) == null) {
            synchronized (this) {
                if (!this.f11329a.contains(interfaceC0415a)) {
                    this.f11329a.add(interfaceC0415a);
                }
            }
        }
    }

    @Override // b.a.p0.a.u.e.c.a
    public synchronized void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            synchronized (this) {
                Iterator<a.InterfaceC0415a> it = this.f11329a.iterator();
                while (it.hasNext()) {
                    it.next().b(i2);
                }
            }
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                Iterator<a.InterfaceC0415a> it = this.f11329a.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                this.f11329a.clear();
            }
        }
    }
}
