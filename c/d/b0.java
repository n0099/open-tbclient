package c.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes3.dex */
public class b0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public final p f23127b;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<String, r> f23128c;

    /* loaded from: classes3.dex */
    public interface a<E> {
        void a(E e2);

        void b(E e2);
    }

    public b0() {
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
        this.f23127b = new p();
        this.f23128c = new HashMap<>();
    }

    public final <E> void a(Set<E> set, Set<E> set2, a<E> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, set, set2, aVar) == null) {
            for (E e2 : set2) {
                if (set == null || !set.contains(e2)) {
                    aVar.b(e2);
                } else {
                    aVar.a(e2);
                }
            }
        }
    }
}
