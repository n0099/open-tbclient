package b.d.b.a.c;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<b.d.b.a.c.b> f31494a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f31495b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Activity> f31496c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f31497d;

    /* renamed from: b.d.b.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1497a implements Comparator<b.d.b.a.c.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1497a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b.d.b.a.c.b bVar, b.d.b.a.c.b bVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, bVar2)) == null) {
                if (bVar == null) {
                    return -1;
                }
                if (bVar2 == null) {
                    return 1;
                }
                if (bVar.isShowing()) {
                    return -1;
                }
                if (bVar2.isShowing()) {
                    return 1;
                }
                if (bVar.getIndex() < bVar2.getIndex()) {
                    return -1;
                }
                return bVar.getIndex() > bVar2.getIndex() ? 1 : 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f31498e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31498e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    b.d.b.a.c.b bVar = (b.d.b.a.c.b) this.f31498e.f31494a.get(0);
                    if (bVar.isShowing()) {
                        return;
                    }
                    bVar.show();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f31498e.f();
                }
            }
        }
    }

    public a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31494a = new ArrayList();
        this.f31497d = new AtomicBoolean(false);
        this.f31496c = new WeakReference<>(activity);
        this.f31495b = new Handler(Looper.getMainLooper());
    }

    public List<b.d.b.a.c.b> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31494a : (List) invokeV.objValue;
    }

    public boolean c(b.d.b.a.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            if (this.f31494a.isEmpty()) {
                this.f31497d.set(false);
            }
            this.f31494a.add(bVar);
            bVar.setHostQuene(this);
            i();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f31494a.clear();
            this.f31497d.set(false);
        }
    }

    public boolean e(b.d.b.a.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) ? this.f31494a.contains(bVar) : invokeL.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            g();
            h();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!this.f31494a.isEmpty()) {
                this.f31494a.remove(0);
            }
            this.f31497d.set(false);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            WeakReference<Activity> weakReference = this.f31496c;
            if (weakReference == null || weakReference.get() == null || this.f31496c.get().isFinishing()) {
                d();
            } else if (this.f31494a.isEmpty() || this.f31497d.getAndSet(true)) {
            } else {
                this.f31495b.postDelayed(new b(this), 500L);
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Collections.sort(this.f31494a, new C1497a(this));
        }
    }
}
