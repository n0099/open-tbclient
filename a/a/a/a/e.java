package a.a.a.a;

import a.a.a.a.v.e;
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
public class e implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final n f1021a;

    /* renamed from: b  reason: collision with root package name */
    public final long f1022b;

    /* renamed from: c  reason: collision with root package name */
    public long f1023c;

    /* loaded from: classes.dex */
    public class a implements o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final o f1024a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f1025b;

        public a(e eVar, o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1025b = eVar;
            this.f1024a = oVar;
        }

        @Override // a.a.a.a.o
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1024a.a();
            }
        }

        @Override // a.a.a.a.o
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f1024a.a(i2, str);
            }
        }

        @Override // a.a.a.a.o
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f1024a.b();
            }
        }

        @Override // a.a.a.a.o
        public void onAdClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f1024a.onAdClicked();
            }
        }

        @Override // a.a.a.a.o
        public void onAdClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f1024a.onAdClose();
            }
        }

        @Override // a.a.a.a.o
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f1024a.onAdShow();
            }
        }

        @Override // a.a.a.a.o
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) {
                this.f1024a.onError(i2, str);
            }
        }

        @Override // a.a.a.a.o
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f1025b.f1023c = System.currentTimeMillis();
                this.f1024a.onLoaded();
            }
        }
    }

    public e(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1021a = nVar;
        this.f1022b = nVar.b().f1347e * 60 * 1000;
    }

    @Override // a.a.a.a.n
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f1021a.a();
        }
    }

    @Override // a.a.a.a.n
    public void a(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oVar) == null) {
            this.f1021a.a(new a(this, oVar));
        }
    }

    @Override // a.a.a.a.n
    public boolean a(Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, activity, viewGroup, str, funNativeAdInflater)) == null) ? this.f1021a.a(activity, viewGroup, str, funNativeAdInflater) : invokeLLLL.booleanValue;
    }

    @Override // a.a.a.a.n
    public boolean a(Context context, FunAdSlot funAdSlot) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, funAdSlot)) == null) ? this.f1021a.a(context, funAdSlot) : invokeLL.booleanValue;
    }

    @Override // a.a.a.a.n
    public e.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1021a.b() : (e.a) invokeV.objValue;
    }

    @Override // a.a.a.a.n
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1021a.c() && System.currentTimeMillis() - this.f1023c < this.f1022b : invokeV.booleanValue;
    }

    @Override // a.a.a.a.n
    public a.a.a.a.x.p d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1021a.d() : (a.a.a.a.x.p) invokeV.objValue;
    }

    @Override // a.a.a.a.n
    public FunNativeAd getNativeAd(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, str)) == null) ? this.f1021a.getNativeAd(context, str) : (FunNativeAd) invokeLL.objValue;
    }
}
