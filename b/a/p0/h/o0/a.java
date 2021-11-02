package b.a.p0.h.o0;

import androidx.annotation.Nullable;
import b.a.p0.a.g1.f;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.p.b.a.i;
import b.a.p0.a.u.e.d.a;
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
public class a extends b.a.p0.a.u.e.d.a implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a.InterfaceC0383a> f10612a;

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
        this.f10612a = new ArrayList<>();
    }

    @Nullable
    public static a d() {
        InterceptResult invokeV;
        b.a.p0.h.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            g U = f.T().U();
            if (U == null || (aVar = (b.a.p0.h.n.a) U.n(b.a.p0.h.n.a.class)) == null) {
                return null;
            }
            return aVar.a3();
        }
        return (a) invokeV.objValue;
    }

    @Override // b.a.p0.a.p.b.a.i
    public b.a.p0.a.u.e.d.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d() : (b.a.p0.a.u.e.d.a) invokeV.objValue;
    }

    @Override // b.a.p0.a.u.e.d.a
    public synchronized void b(a.InterfaceC0383a interfaceC0383a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0383a) == null) {
            synchronized (this) {
                if (!this.f10612a.contains(interfaceC0383a)) {
                    this.f10612a.add(interfaceC0383a);
                }
            }
        }
    }

    @Override // b.a.p0.a.u.e.d.a
    public synchronized void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            synchronized (this) {
                Iterator<a.InterfaceC0383a> it = this.f10612a.iterator();
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
                Iterator<a.InterfaceC0383a> it = this.f10612a.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                this.f10612a.clear();
            }
        }
    }
}
