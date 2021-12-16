package c.a.c0.h;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<k>> a;

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
        this.a = new ConcurrentHashMap<>();
        new ConcurrentHashMap();
    }

    public <T extends f> void a(@Nullable T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, t) == null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<k> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    b(next, next.f1663d, t);
                }
            }
        }
    }

    public final <T extends f> void b(k kVar, i<T> iVar, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kVar, iVar, t) == null) {
            int i2 = kVar.f1662c;
            if (i2 == 0) {
                iVar.onEvent(t);
            } else if (i2 == 1) {
                j.b().a(kVar, iVar, t);
            } else if (i2 == 2) {
                b.b().a(kVar, iVar, t);
            } else if (i2 != 3) {
            } else {
                a.b().a(kVar, iVar, t);
            }
        }
    }
}
