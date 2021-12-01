package c.a.p0.a.z2.g1;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9170e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f9171f;

        public a(c cVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9170e = cVar;
            this.f9171f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9170e.onCallback(this.f9171f);
            }
        }
    }

    public static <T> void a(Handler handler, c<T> cVar, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, handler, cVar, collection) == null) || cVar == null || collection == null || collection.isEmpty()) {
            return;
        }
        for (T t : collection) {
            e(handler, cVar, t);
        }
    }

    public static <T> void b(Handler handler, c<T> cVar, T... tArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, handler, cVar, tArr) == null) || cVar == null || tArr == null || tArr.length < 1) {
            return;
        }
        for (T t : tArr) {
            e(handler, cVar, t);
        }
    }

    public static <T> void c(c<T> cVar, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, cVar, collection) == null) {
            a(null, cVar, collection);
        }
    }

    public static <T> void d(c<T> cVar, T... tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, cVar, tArr) == null) {
            b(null, cVar, tArr);
        }
    }

    public static <T> void e(Handler handler, c<T> cVar, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, handler, cVar, t) == null) {
            if (handler == null) {
                cVar.onCallback(t);
            } else {
                handler.post(new a(cVar, t));
            }
        }
    }
}
