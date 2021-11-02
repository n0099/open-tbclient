package b.g;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
/* loaded from: classes6.dex */
public class q0 implements PidLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final PidLoader f31226a;

    /* renamed from: b  reason: collision with root package name */
    public final long f31227b;

    /* renamed from: c  reason: collision with root package name */
    public long f31228c;

    /* loaded from: classes6.dex */
    public class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final f f31229a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q0 f31230b;

        public a(q0 q0Var, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31230b = q0Var;
            this.f31229a = fVar;
        }

        @Override // b.g.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f31229a.a();
            }
        }

        @Override // b.g.f
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f31229a.a(i2, str);
            }
        }

        @Override // b.g.f
        public void a(RippedAd rippedAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rippedAd) == null) {
                this.f31229a.a(rippedAd);
            }
        }

        @Override // b.g.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f31229a.b();
            }
        }

        @Override // b.g.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
                this.f31229a.b(i2, str);
            }
        }

        @Override // b.g.f
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f31229a.c();
            }
        }

        @Override // b.g.f
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f31230b.f31228c = System.currentTimeMillis();
                this.f31229a.d();
            }
        }

        @Override // b.g.f
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f31229a.e();
            }
        }
    }

    public q0(PidLoader pidLoader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pidLoader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31226a = pidLoader;
        this.f31227b = pidLoader.getPid().tmout * 60 * 1000;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void addListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.f31226a.addListener(new a(this, fVar));
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f31226a.destroy();
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public FunNativeAd getNativeAd(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) ? this.f31226a.getNativeAd(context, str) : (FunNativeAd) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public FunNativeAd2 getNativeAd2(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) ? this.f31226a.getNativeAd2(context, str) : (FunNativeAd2) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public Ssp.Pid getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31226a.getPid() : (Ssp.Pid) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public RippedAd getRippedAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f31226a.getRippedAd() : (RippedAd) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public boolean isLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31226a.isLoaded() && System.currentTimeMillis() - this.f31228c < this.f31227b : invokeV.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public boolean load(Context context, FunAdSlot funAdSlot) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, funAdSlot)) == null) ? this.f31226a.load(context, funAdSlot) : invokeLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void removeListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.f31226a.removeListener(fVar);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public boolean show(Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, activity, viewGroup, str, funNativeAdInflater)) == null) ? this.f31226a.show(activity, viewGroup, str, funNativeAdInflater) : invokeLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public FunSplashAd showSplash(Activity activity, ViewGroup viewGroup, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, activity, viewGroup, str)) == null) ? this.f31226a.showSplash(activity, viewGroup, str) : (FunSplashAd) invokeLLL.objValue;
    }
}
