package b.a.k.a.o;

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
    public static d f3134e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f3135a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f3136b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f3137c;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f3138d;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f3139a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3139a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 0) {
                    if (this.f3139a.f3138d != null) {
                        Iterator it = this.f3139a.f3138d.iterator();
                        while (it.hasNext()) {
                            c cVar = (c) it.next();
                            if (this.f3139a.e(cVar)) {
                                this.f3139a.f3135a.submit(cVar);
                                it.remove();
                            }
                        }
                    }
                } else if (i2 == 1) {
                    if (message.obj instanceof c) {
                        this.f3139a.f3138d.add((c) message.obj);
                    }
                } else if (i2 != 2) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3138d = new ArrayList();
        this.f3135a = Executors.newFixedThreadPool(5);
        Executors.newSingleThreadExecutor();
        this.f3136b = new a(this, b.a("threadpool").getLooper());
        this.f3137c = new Handler(Looper.getMainLooper());
    }

    public static d f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f3134e == null) {
                synchronized (d.class) {
                    if (f3134e == null) {
                        f3134e = new d();
                    }
                }
            }
            return f3134e;
        }
        return (d) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f3136b.removeMessages(0);
            this.f3136b.sendEmptyMessage(0);
        }
    }

    public final boolean e(c cVar) {
        InterceptResult invokeL;
        List<BdRunnable> d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
            if (cVar != null && (d2 = cVar.d()) != null) {
                for (int i2 = 0; i2 < d2.size(); i2++) {
                    BdRunnable bdRunnable = d2.get(i2);
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
                this.f3135a.submit(bdRunnable);
                return;
            } else {
                this.f3136b.obtainMessage(1, bdRunnable).sendToTarget();
                return;
            }
        }
        try {
            this.f3135a.submit(bdRunnable);
        } catch (Error e2) {
            bdRunnable.a(e2);
        } catch (Exception e3) {
            bdRunnable.onException(e3);
        }
    }

    public void h(BdRunnable bdRunnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdRunnable) == null) {
            this.f3137c.post(bdRunnable);
        }
    }
}
