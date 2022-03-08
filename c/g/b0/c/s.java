package c.g.b0.c;

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
        public boolean f28374b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f28375c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ s f28376d;

        public a(s sVar, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28376d = sVar;
            this.f28375c = dVar;
        }

        @Override // c.g.b0.c.n
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                LogPrinter.e("onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f28376d.onError(i2, str);
            }
        }

        @Override // c.g.b0.c.n
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.d();
                this.f28376d.onAdClicked(this.f28374b);
                this.f28374b = true;
            }
        }

        @Override // c.g.b0.c.n
        public void onDisplayed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
                this.f28376d.onAdShow(this.f28375c, this.a);
                this.a = true;
            }
        }

        @Override // c.g.b0.c.n
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.d();
                this.f28376d.onAdLoaded((s) this.f28375c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FunAdInteractionListener a;

        /* renamed from: b  reason: collision with root package name */
        public final String f28377b;

        /* renamed from: c  reason: collision with root package name */
        public final d f28378c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f28379d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f28380e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s f28381f;

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
            this.f28381f = sVar;
            this.f28377b = str;
            this.f28378c = dVar;
        }

        @Override // c.g.b0.c.n
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                LogPrinter.e("onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f28381f.onError(i2, str);
            }
        }

        @Override // c.g.b0.c.n
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.d();
                this.f28381f.onAdClicked(this.f28380e);
                this.f28380e = true;
                FunAdInteractionListener funAdInteractionListener = this.a;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdClicked(this.f28377b, this.f28381f.mPid.ssp.type, this.f28381f.mPid.pid);
                }
            }
        }

        @Override // c.g.b0.c.n
        public void onDisplayed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
                this.f28381f.onAdShow(this.f28378c, this.f28379d);
                this.f28379d = true;
                FunAdInteractionListener funAdInteractionListener = this.a;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdShow(this.f28377b, this.f28381f.mPid.ssp.type, this.f28381f.mPid.pid);
                }
            }
        }

        @Override // c.g.b0.c.n
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.d();
                this.f28381f.onAdLoaded((s) this.f28378c);
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
            d dVar = (d) c.g.b0.c.a.a(context, this.mPid);
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
