package b.a.p0.a.z2.g1;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes.dex */
public abstract class a<OuT> implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final d<OuT> f9793e;

    /* renamed from: f  reason: collision with root package name */
    public OuT f9794f;

    /* renamed from: b.a.p0.a.z2.g1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0504a extends a<OuT> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f9795g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0504a(d dVar, CountDownLatch countDownLatch) {
            super(dVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, countDownLatch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((d) objArr2[0], (C0504a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9795g = countDownLatch;
        }

        @Override // b.a.p0.a.z2.g1.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9795g.countDown();
            }
        }
    }

    public /* synthetic */ a(d dVar, C0504a c0504a) {
        this(dVar);
    }

    public static <OuT> OuT a(Looper looper, d<OuT> dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, looper, dVar)) == null) {
            if (dVar == null) {
                return null;
            }
            if (looper != null && Thread.currentThread() != looper.getThread()) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                C0504a c0504a = new C0504a(dVar, countDownLatch);
                new Handler(looper).post(c0504a);
                try {
                    countDownLatch.await();
                } catch (InterruptedException e2) {
                    b.a.p0.a.e0.d.o("Awaiting", "callOnLooper: Thread=" + Thread.currentThread().getName() + " ret by InterruptedException " + e2);
                    e2.printStackTrace();
                }
                return c0504a.f9794f;
            }
            return dVar.create();
        }
        return (OuT) invokeLL.objValue;
    }

    public static <OuT> OuT b(d<OuT> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, dVar)) == null) ? (OuT) a(Looper.getMainLooper(), dVar) : (OuT) invokeL.objValue;
    }

    public abstract void c();

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                try {
                    this.f9794f = this.f9793e.create();
                } catch (Exception e2) {
                    b.a.p0.a.e0.d.o("Awaiting", "catch: " + e2 + StringUtils.LF + Log.getStackTraceString(e2));
                }
            } finally {
                c();
            }
        }
    }

    public a(d<OuT> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9794f = null;
        this.f9793e = dVar;
    }
}
