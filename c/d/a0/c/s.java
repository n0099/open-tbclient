package c.d.a0.c;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes3.dex */
public class s extends ReporterPidLoader<d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f23060b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f23061c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ s f23062d;

        public a(s sVar, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23062d = sVar;
            this.f23061c = dVar;
        }

        @Override // c.d.a0.c.n
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                LogPrinter.e("onError code: " + i + ", message: " + str, new Object[0]);
                this.f23062d.onError(i, str);
            }
        }

        @Override // c.d.a0.c.n
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.d();
                this.f23062d.onAdClicked(this.f23060b, new String[0]);
                this.f23060b = true;
            }
        }

        @Override // c.d.a0.c.n
        public void onDisplayed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
                this.f23062d.onAdShow(this.f23061c, this.a, new String[0]);
                this.a = true;
            }
        }

        @Override // c.d.a0.c.n
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.d();
                this.f23062d.onAdLoaded((s) this.f23061c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FunAdInteractionListener a;

        /* renamed from: b  reason: collision with root package name */
        public final String f23063b;

        /* renamed from: c  reason: collision with root package name */
        public final d f23064c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f23065d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f23066e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s f23067f;

        public b(s sVar, String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23067f = sVar;
            this.f23063b = str;
            this.f23064c = dVar;
        }

        @Override // c.d.a0.c.n
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                LogPrinter.e("onError code: " + i + ", message: " + str, new Object[0]);
                this.f23067f.onError(i, str);
            }
        }

        @Override // c.d.a0.c.n
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.d();
                this.f23067f.onAdClicked(this.f23066e, new String[0]);
                this.f23066e = true;
                FunAdInteractionListener funAdInteractionListener = this.a;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdClicked(this.f23063b, this.f23067f.mPid.ssp.type, this.f23067f.mPid.pid);
                }
            }
        }

        @Override // c.d.a0.c.n
        public void onDisplayed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
                this.f23067f.onAdShow(this.f23064c, this.f23065d, new String[0]);
                this.f23065d = true;
                FunAdInteractionListener funAdInteractionListener = this.a;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdShow(this.f23063b, this.f23067f.mPid.ssp.type, this.f23067f.mPid.pid);
                }
            }
        }

        @Override // c.d.a0.c.n
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.d();
                this.f23067f.onAdLoaded((s) this.f23064c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(Ssp.Pid pid) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.DRAW), pid);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || (dVar = (d) obj) == null) {
            return;
        }
        dVar.a();
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, obj)) == null) {
            d dVar = (d) obj;
            return new BaseNativeAd2(FunNativeAd2.NativeType.EXPRESS, dVar, new t(this, str, dVar));
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            d dVar = (d) c.d.a0.c.a.a(context, this.mPid);
            onLoadStart(funAdSlot);
            if (dVar == null) {
                onError(0, "jy drawvideo广告创建失败");
                return;
            }
            dVar.c(new a(this, dVar));
            dVar.b();
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, activity, viewGroup, str, obj)) == null) {
            onShowStart();
            View d2 = ((d) obj).d();
            if (d2.getParent() != null) {
                ((ViewGroup) d2.getParent()).removeView(d2);
            }
            viewGroup.removeAllViews();
            viewGroup.addView(d2);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
