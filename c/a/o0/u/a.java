package c.a.o0.u;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<c.a.o0.u.c.b<T>> f12359a;

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
        this.f12359a = new ArrayList(6);
    }

    public void a(c.a.o0.u.c.b<T> bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null || this.f12359a.contains(bVar)) {
            return;
        }
        this.f12359a.add(bVar);
    }

    public T b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<c.a.o0.u.c.b> arrayList = new ArrayList();
            Iterator<c.a.o0.u.c.b<T>> it = this.f12359a.iterator();
            T t = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c.a.o0.u.c.b<T> next = it.next();
                T t2 = next.get();
                if (c(t2)) {
                    t = t2;
                    break;
                }
                arrayList.add(next);
                t = t2;
            }
            if (arrayList.size() > 0) {
                for (c.a.o0.u.c.b bVar : arrayList) {
                    bVar.put(t);
                }
            }
            return t;
        }
        return (T) invokeV.objValue;
    }

    public final boolean c(T t) {
        InterceptResult invokeL;
        char[] charArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            if (t != null && (t instanceof String)) {
                String str = (String) t;
                if (str.length() != 32) {
                    return false;
                }
                for (char c2 : str.toCharArray()) {
                    if ((c2 < 'A' || c2 > 'Z') && (c2 < '0' || c2 > '9')) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d(T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, t) == null) || c(t)) {
            return;
        }
        for (c.a.o0.u.c.b<T> bVar : this.f12359a) {
            if (bVar.a()) {
                bVar.put(t);
            }
        }
    }
}
