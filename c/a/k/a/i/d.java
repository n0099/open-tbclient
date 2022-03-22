package c.a.k.a.i;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.async.BdRunnable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static d f3357e;
    public transient /* synthetic */ FieldHolder $fh;
    public ExecutorService a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f3358b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f3359c;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f3360d;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i == 0) {
                    if (this.a.f3360d != null) {
                        Iterator it = this.a.f3360d.iterator();
                        while (it.hasNext()) {
                            c cVar = (c) it.next();
                            if (this.a.e(cVar)) {
                                this.a.a.submit(cVar);
                                it.remove();
                            }
                        }
                    }
                } else if (i == 1) {
                    if (message.obj instanceof c) {
                        this.a.f3360d.add((c) message.obj);
                    }
                } else if (i != 2) {
                } else {
                    Object obj = message.obj;
                    if (obj instanceof BdRunnable) {
                        post((BdRunnable) obj);
                    }
                }
            }
        }
    }

    public d() {
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
        this.f3360d = new ArrayList();
        this.a = Executors.newFixedThreadPool(5);
        Executors.newSingleThreadExecutor();
        this.f3358b = new a(this, b.a("threadpool").getLooper());
        this.f3359c = new Handler(Looper.getMainLooper());
    }

    public static d f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f3357e == null) {
                synchronized (d.class) {
                    if (f3357e == null) {
                        f3357e = new d();
                    }
                }
            }
            return f3357e;
        }
        return (d) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f3358b.removeMessages(0);
            this.f3358b.sendEmptyMessage(0);
        }
    }

    public final boolean e(c cVar) {
        InterceptResult invokeL;
        List<BdRunnable> d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
            if (cVar != null && (d2 = cVar.d()) != null) {
                for (int i = 0; i < d2.size(); i++) {
                    BdRunnable bdRunnable = d2.get(i);
                    if (bdRunnable != null && !bdRunnable.c()) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void g(BdRunnable bdRunnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdRunnable) == null) || bdRunnable == null) {
            return;
        }
        if (bdRunnable instanceof c) {
            if (e((c) bdRunnable)) {
                this.a.submit(bdRunnable);
                return;
            } else {
                this.f3358b.obtainMessage(1, bdRunnable).sendToTarget();
                return;
            }
        }
        try {
            this.a.submit(bdRunnable);
        } catch (Error e2) {
            bdRunnable.a(e2);
        } catch (Exception e3) {
            bdRunnable.onException(e3);
        }
    }

    public void h(BdRunnable bdRunnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdRunnable) == null) {
            this.f3359c.post(bdRunnable);
        }
    }
}
