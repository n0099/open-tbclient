package c.e.b.a.c;

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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<c.e.b.a.c.b> f32106a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f32107b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Activity> f32108c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f32109d;

    /* renamed from: c.e.b.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1462a implements Comparator<c.e.b.a.c.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1462a(a aVar) {
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
        public int compare(c.e.b.a.c.b bVar, c.e.b.a.c.b bVar2) {
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

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f32110e;

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
            this.f32110e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    c.e.b.a.c.b bVar = (c.e.b.a.c.b) this.f32110e.f32106a.get(0);
                    if (bVar.isShowing()) {
                        return;
                    }
                    bVar.show();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f32110e.f();
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
        this.f32106a = new ArrayList();
        this.f32109d = new AtomicBoolean(false);
        this.f32108c = new WeakReference<>(activity);
        this.f32107b = new Handler(Looper.getMainLooper());
    }

    public List<c.e.b.a.c.b> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32106a : (List) invokeV.objValue;
    }

    public boolean c(c.e.b.a.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            if (this.f32106a.isEmpty()) {
                this.f32109d.set(false);
            }
            this.f32106a.add(bVar);
            bVar.setHostQuene(this);
            i();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f32106a.clear();
            this.f32109d.set(false);
        }
    }

    public boolean e(c.e.b.a.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) ? this.f32106a.contains(bVar) : invokeL.booleanValue;
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
            if (!this.f32106a.isEmpty()) {
                this.f32106a.remove(0);
            }
            this.f32109d.set(false);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            WeakReference<Activity> weakReference = this.f32108c;
            if (weakReference == null || weakReference.get() == null || this.f32108c.get().isFinishing()) {
                d();
            } else if (this.f32106a.isEmpty() || this.f32109d.getAndSet(true)) {
            } else {
                this.f32107b.postDelayed(new b(this), 500L);
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Collections.sort(this.f32106a, new C1462a(this));
        }
    }
}
