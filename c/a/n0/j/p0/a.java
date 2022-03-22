package c.a.n0.j.p0;

import androidx.annotation.Nullable;
import c.a.n0.a.f.b.a.i;
import c.a.n0.a.k.e.c.a;
import c.a.n0.a.w0.f;
import c.a.n0.a.x.g.g;
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
/* loaded from: classes2.dex */
public class a extends c.a.n0.a.k.e.c.a implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<a.InterfaceC0329a> a;

    public a() {
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
        this.a = new ArrayList<>();
    }

    @Nullable
    public static a d() {
        InterceptResult invokeV;
        c.a.n0.j.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            g V = f.U().V();
            if (V == null || (aVar = (c.a.n0.j.n.a) V.n(c.a.n0.j.n.a.class)) == null) {
                return null;
            }
            return aVar.s3();
        }
        return (a) invokeV.objValue;
    }

    @Override // c.a.n0.a.f.b.a.i
    public c.a.n0.a.k.e.c.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d() : (c.a.n0.a.k.e.c.a) invokeV.objValue;
    }

    @Override // c.a.n0.a.k.e.c.a
    public synchronized void b(a.InterfaceC0329a interfaceC0329a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0329a) == null) {
            synchronized (this) {
                if (!this.a.contains(interfaceC0329a)) {
                    this.a.add(interfaceC0329a);
                }
            }
        }
    }

    @Override // c.a.n0.a.k.e.c.a
    public synchronized void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            synchronized (this) {
                Iterator<a.InterfaceC0329a> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().b(i);
                }
            }
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                Iterator<a.InterfaceC0329a> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                this.a.clear();
            }
        }
    }
}
