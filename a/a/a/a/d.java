package a.a.a.a;

import a.a.a.a.s.h;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
/* loaded from: classes.dex */
public class d implements m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final m f1020a;

    /* renamed from: b  reason: collision with root package name */
    public final long f1021b;

    /* renamed from: c  reason: collision with root package name */
    public long f1022c;

    /* loaded from: classes.dex */
    public class a implements n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final n f1023a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f1024b;

        public a(d dVar, n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1024b = dVar;
            this.f1023a = nVar;
        }

        @Override // a.a.a.a.n
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1023a.a();
            }
        }

        @Override // a.a.a.a.n
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f1023a.a(i2, str);
            }
        }

        @Override // a.a.a.a.n
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f1023a.b();
            }
        }

        @Override // a.a.a.a.n
        public void onAdClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f1023a.onAdClicked();
            }
        }

        @Override // a.a.a.a.n
        public void onAdClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f1023a.onAdClose();
            }
        }

        @Override // a.a.a.a.n
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f1023a.onAdShow();
            }
        }

        @Override // a.a.a.a.n
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) {
                this.f1023a.onError(i2, str);
            }
        }

        @Override // a.a.a.a.n
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f1024b.f1022c = System.currentTimeMillis();
                this.f1023a.onLoaded();
            }
        }
    }

    public d(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1020a = mVar;
        this.f1021b = mVar.b().f1363e * 60 * 1000;
    }

    @Override // a.a.a.a.m
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f1020a.a();
        }
    }

    @Override // a.a.a.a.m
    public void a(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar) == null) {
            this.f1020a.a(new a(this, nVar));
        }
    }

    @Override // a.a.a.a.m
    public boolean a(Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, activity, viewGroup, str, funNativeAdInflater)) == null) ? this.f1020a.a(activity, viewGroup, str, funNativeAdInflater) : invokeLLLL.booleanValue;
    }

    @Override // a.a.a.a.m
    public boolean a(Context context, FunAdSlot funAdSlot) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, funAdSlot)) == null) ? this.f1020a.a(context, funAdSlot) : invokeLL.booleanValue;
    }

    @Override // a.a.a.a.m
    public h.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1020a.b() : (h.a) invokeV.objValue;
    }

    @Override // a.a.a.a.m
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1020a.c() && System.currentTimeMillis() - this.f1022c < this.f1021b : invokeV.booleanValue;
    }

    @Override // a.a.a.a.m
    public a.a.a.a.u.p d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1020a.d() : (a.a.a.a.u.p) invokeV.objValue;
    }

    @Override // a.a.a.a.m
    public FunNativeAd getNativeAd(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, str)) == null) ? this.f1020a.getNativeAd(context, str) : (FunNativeAd) invokeLL.objValue;
    }
}
