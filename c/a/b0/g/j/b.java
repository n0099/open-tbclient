package c.a.b0.g.j;

import android.os.CountDownTimer;
import androidx.annotation.NonNull;
import c.a.b0.g.j.d;
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
    public long f1551b;

    /* renamed from: c  reason: collision with root package name */
    public long f1552c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<VIEW> f1553d;

    /* loaded from: classes.dex */
    public static class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<b> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NonNull b bVar, long j2, long j3) {
            super(j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public void onTick(long j2) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || (bVar = this.a.get()) == null) {
                return;
            }
            bVar.f1552c = bVar.f1551b - j2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1553d = new WeakReference<>(view);
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1552c : invokeV.longValue;
    }

    public final void f(long j2) {
        VIEW k2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || (k2 = k()) == null) {
            return;
        }
        k2.onFinish(j2);
    }

    public final void g(long j2, long j3) {
        VIEW k2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || (k2 = k()) == null) {
            return;
        }
        k2.onProgress(j2, j3);
    }

    public void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            i();
            this.f1551b = j2;
            this.f1552c = 0L;
            a aVar = new a(this, this.f1551b, 1000L);
            this.a = aVar;
            aVar.start();
            VIEW k2 = k();
            if (k2 != null) {
                long j3 = this.f1551b;
                k2.onStart(j3, j3);
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
        VIEW k2 = k();
        if (k2 != null) {
            k2.onCancel(this.f1552c, this.f1551b);
        }
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1551b : invokeV.longValue;
    }

    public final VIEW k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1553d.get() : (VIEW) invokeV.objValue;
    }
}
