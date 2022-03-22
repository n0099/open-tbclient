package c.a.a0.j.j;

import android.os.CountDownTimer;
import androidx.annotation.NonNull;
import c.a.a0.j.j.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b<VIEW extends d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CountDownTimer a;

    /* renamed from: b  reason: collision with root package name */
    public long f1287b;

    /* renamed from: c  reason: collision with root package name */
    public long f1288c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<VIEW> f1289d;

    /* loaded from: classes.dex */
    public static class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<b> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NonNull b bVar, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(bVar);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.a.get()) == null) {
                return;
            }
            bVar.f(bVar.j());
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || (bVar = this.a.get()) == null) {
                return;
            }
            bVar.f1288c = bVar.f1287b - j;
            bVar.g(bVar.e(), bVar.j());
        }
    }

    public b(@NonNull VIEW view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1289d = new WeakReference<>(view);
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1288c : invokeV.longValue;
    }

    public final void f(long j) {
        VIEW k;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || (k = k()) == null) {
            return;
        }
        k.a(j);
    }

    public final void g(long j, long j2) {
        VIEW k;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || (k = k()) == null) {
            return;
        }
        k.onProgress(j, j2);
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            i();
            this.f1287b = j;
            this.f1288c = 0L;
            a aVar = new a(this, this.f1287b, 1000L);
            this.a = aVar;
            aVar.start();
            VIEW k = k();
            if (k != null) {
                long j2 = this.f1287b;
                k.b(j2, j2);
            }
        }
    }

    public void i() {
        CountDownTimer countDownTimer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (countDownTimer = this.a) == null) {
            return;
        }
        countDownTimer.cancel();
        VIEW k = k();
        if (k != null) {
            k.c(this.f1288c, this.f1287b);
        }
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1287b : invokeV.longValue;
    }

    public final VIEW k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1289d.get() : (VIEW) invokeV.objValue;
    }
}
