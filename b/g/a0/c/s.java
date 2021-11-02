package b.g.a0.c;

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
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.BasePidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes6.dex */
public class s extends BasePidLoader<d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f30992a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f30993b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f30994c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f30995d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f30996e;

        public a(s sVar, d dVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, dVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30996e = sVar;
            this.f30994c = dVar;
            this.f30995d = funAdSlot;
        }

        @Override // b.g.a0.c.n
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                LogPrinter.e("onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f30996e.mReporter.recordLoadFailed(Integer.valueOf(i2));
                this.f30996e.onError(i2, str);
            }
        }

        @Override // b.g.a0.c.n
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.d();
                this.f30996e.mReporter.recordOnClicked(this.f30993b);
                this.f30993b = true;
                this.f30996e.onAdClicked();
            }
        }

        @Override // b.g.a0.c.n
        public void onDisplayed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
                this.f30996e.mReporter.recordShowSucceed(this.f30992a);
                this.f30992a = true;
                this.f30996e.onAdShow(this.f30994c);
            }
        }

        @Override // b.g.a0.c.n
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.d();
                this.f30996e.mReporter.recordLoadSucceed();
                this.f30996e.mAdRipper.report(this.f30994c, this.f30995d.getSid());
                this.f30996e.onAdLoaded((s) this.f30994c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public FunAdInteractionListener f30997a;

        /* renamed from: b  reason: collision with root package name */
        public final String f30998b;

        /* renamed from: c  reason: collision with root package name */
        public final d f30999c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f31000d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f31001e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s f31002f;

        public b(s sVar, String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31002f = sVar;
            this.f30998b = str;
            this.f30999c = dVar;
        }

        @Override // b.g.a0.c.n
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                LogPrinter.e("onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f31002f.mReporter.recordLoadFailed(Integer.valueOf(i2));
            }
        }

        @Override // b.g.a0.c.n
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.d();
                this.f31002f.mReporter.recordOnClicked(this.f31001e);
                this.f31001e = true;
                FunAdInteractionListener funAdInteractionListener = this.f30997a;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdClicked(this.f30998b, this.f31002f.mPid.ssp.type, this.f31002f.mPid.pid);
                }
            }
        }

        @Override // b.g.a0.c.n
        public void onDisplayed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
                this.f31002f.mReporter.recordShowSucceed(this.f31000d);
                this.f31000d = true;
                FunAdInteractionListener funAdInteractionListener = this.f30997a;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdShow(this.f30998b, this.f31002f.mPid.ssp.type, this.f31002f.mPid.pid);
                }
            }
        }

        @Override // b.g.a0.c.n
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.d();
                this.f31002f.mReporter.recordLoadSucceed();
                this.f31002f.mAdRipper.report(this.f30999c, this.f30998b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(Ssp.Pid pid) {
        super(pid);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Ssp.Pid) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(d dVar) {
        d dVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || (dVar2 = dVar) == null) {
            return;
        }
        dVar2.a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, d dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, dVar)) == null) {
            d dVar2 = dVar;
            return new BaseNativeAd2(FunNativeAd2.NativeType.EXPRESS, dVar2, new t(this, str, dVar2));
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            d dVar = (d) b.g.a0.c.a.a(context, this.mPid);
            if (dVar == null) {
                onError(0, "jy drawvideo广告创建失败");
                return;
            }
            dVar.c(new a(this, dVar, funAdSlot));
            this.mReporter.recordLoadStart(funAdSlot, this.mPid);
            dVar.b();
            onLoadStart();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, d dVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, activity, viewGroup, str, dVar)) == null) {
            this.mReporter.recordShowStart();
            View d2 = dVar.d();
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
