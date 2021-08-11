package c.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes4.dex */
public final class c1<SERVICE, RESULT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f31109a;

    /* renamed from: b  reason: collision with root package name */
    public final Intent f31110b;

    /* renamed from: c  reason: collision with root package name */
    public final b<SERVICE, RESULT> f31111c;

    /* renamed from: d  reason: collision with root package name */
    public final Context f31112d;

    /* loaded from: classes4.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final CountDownLatch f31113e;

        /* renamed from: f  reason: collision with root package name */
        public final b<SERVICE, RESULT> f31114f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        public SERVICE f31115g;

        public a(c1 c1Var, CountDownLatch countDownLatch, b<SERVICE, RESULT> bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1Var, countDownLatch, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31113e = countDownLatch;
            this.f31114f = bVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                String str = u0.f31212j;
                o0.e(str, "ServiceBlockBinder#onServiceConnected " + componentName);
                try {
                    this.f31115g = this.f31114f.a(iBinder);
                    this.f31113e.countDown();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                String str = u0.f31212j;
                o0.e(str, "ServiceBlockBinder#onServiceDisconnected" + componentName);
                try {
                    this.f31113e.countDown();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b<T, RESULT> {
        T a(IBinder iBinder);

        RESULT a(T t);
    }

    public c1(Context context, Intent intent, b<SERVICE, RESULT> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, intent, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31112d = context;
        this.f31110b = intent;
        this.f31111c = bVar;
        this.f31109a = new CountDownLatch(1);
    }

    public RESULT a() {
        InterceptResult invokeV;
        c1<SERVICE, RESULT>.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
            return (RESULT) invokeV.objValue;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return null;
        }
        try {
            aVar = new a(this, this.f31109a, this.f31111c);
            this.f31112d.bindService(this.f31110b, aVar, 1);
            this.f31109a.await();
            try {
                return this.f31111c.a((b<SERVICE, RESULT>) aVar.f31115g);
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    b(aVar);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            aVar = null;
        }
    }

    public final void b(c1<SERVICE, RESULT>.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        try {
            this.f31112d.unbindService(aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
