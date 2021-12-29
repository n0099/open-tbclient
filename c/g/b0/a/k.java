package c.g.b0.a;

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
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.FunNativeView;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.NumberUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class k extends q<TTNativeAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public final FunNativeAdListenerHelper<TTNativeAd, TTNativeAd.AdInteractionListener> f29081i;

    /* loaded from: classes9.dex */
    public class a implements TTAdNative.NativeAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                LogPrinter.e("onError code: " + i2 + ", message: " + str, new Object[0]);
                this.a.onError(i2, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
        public void onNativeAdLoad(List<TTNativeAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                LogPrinter.d("onNativeAdLoad", new Object[0]);
                if (list != null && !list.isEmpty()) {
                    this.a.onAdLoaded((List) list);
                    return;
                }
                LogPrinter.e("onNativeAdLoad error: list is null or empty", new Object[0]);
                this.a.onError(0, "NoFill");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements TTNativeAd.AdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TTNativeAd a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f29082b;

        public b(k kVar, TTNativeAd tTNativeAd) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, tTNativeAd};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29082b = kVar;
            this.a = tTNativeAd;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd tTNativeAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, tTNativeAd) == null) {
                LogPrinter.d();
                this.f29082b.f29081i.onAdClick(this.a);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, tTNativeAd) == null) {
                LogPrinter.d();
                this.f29082b.f29081i.onAdClick(this.a);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tTNativeAd) == null) {
                LogPrinter.d();
                this.f29082b.f29081i.onAdShow(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Ssp.Pid pid) {
        super(pid, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Ssp.Pid) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29081i = new FunNativeAdListenerHelper<>(this);
    }

    public void b(Activity activity, TTNativeAd tTNativeAd, ViewGroup viewGroup, com.fun.module.csj.e0 e0Var, TTNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, activity, tTNativeAd, viewGroup, e0Var, adInteractionListener) == null) {
            tTNativeAd.setActivityForDownloadApp(activity);
            tTNativeAd.registerViewForInteraction(viewGroup, e0Var.getClickViews(), e0Var.getCreativeViews(), adInteractionListener);
            tTNativeAd.setDownloadListener(e0Var.getDownloadListener());
        }
    }

    public final void c(Context context, TTNativeAd tTNativeAd, String str, ViewGroup viewGroup, List<View> list, List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, tTNativeAd, str, viewGroup, list, list2, adInteractionListener, funAdInteractionListener}) == null) {
            if (viewGroup instanceof FunNativeView) {
                viewGroup = ((FunNativeView) viewGroup).getRoot();
            }
            this.f29081i.startShow(tTNativeAd, str, this.mPid, adInteractionListener, funAdInteractionListener);
            if (context instanceof Activity) {
                tTNativeAd.setActivityForDownloadApp((Activity) context);
            }
            if (list == null) {
                list = new ArrayList<>();
            }
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            tTNativeAd.registerViewForInteraction(viewGroup, list, list2, adInteractionListener);
        }
    }

    public void d(FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, funAdSlot) == null) {
            AdSlot.Builder downloadType = new AdSlot.Builder().setCodeId(this.mPid.pid).setSupportDeepLink(true).setDownloadType(FunAdSdk.getFunAdConfig().downLoadType);
            Ssp.Pid pid = this.mPid;
            this.f29107h.loadNativeAd(downloadType.setImageAcceptedSize(pid.width, pid.height).setNativeAdType(1).setAdCount(NumberUtils.adjustInt(funAdSlot.getAdCount(), 1, 3)).build(), new a(this));
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            this.f29081i.destroy((TTNativeAd) obj);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd getNativeAdInternal(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, str, obj)) == null) ? new m((TTNativeAd) obj, str, this.mPid, this) : (FunNativeAd) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, context, str, obj)) == null) {
            TTNativeAd tTNativeAd = (TTNativeAd) obj;
            return new BaseNativeAd2(FunNativeAd2.NativeType.BOTH, tTNativeAd, new m(tTNativeAd, str, this.mPid, this), new p(this, tTNativeAd));
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    /* renamed from: i */
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, TTNativeAd tTNativeAd) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, activity, viewGroup, str, tTNativeAd)) == null) {
            onShowStart();
            com.fun.module.csj.e0 a2 = l.a(tTNativeAd);
            if (a2 == null) {
                onAdError(0, "AdView present failed");
                return false;
            }
            viewGroup.removeAllViews();
            viewGroup.addView(a2);
            n nVar = new n(this, null, str, tTNativeAd);
            tTNativeAd.setActivityForDownloadApp(activity);
            tTNativeAd.registerViewForInteraction(viewGroup, a2.getClickViews(), a2.getCreativeViews(), nVar);
            tTNativeAd.setDownloadListener(a2.getDownloadListener());
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // c.g.b0.a.q, com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, funAdSlot) == null) {
            super.loadInternal(context, funAdSlot);
            onLoadStart(funAdSlot);
            d(funAdSlot);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, activity, str, funNativeAdInflater, obj)) == null) {
            TTNativeAd tTNativeAd = (TTNativeAd) obj;
            onShowStart();
            ViewGroup adContainer = funNativeAdInflater.getAdContainer(new m(tTNativeAd, str, this.mPid, this));
            List<View> clickViews = funNativeAdInflater.getClickViews();
            if (clickViews == null) {
                clickViews = new ArrayList<>();
            }
            List<View> creativeViews = funNativeAdInflater.getCreativeViews();
            if (creativeViews == null) {
                creativeViews = new ArrayList<>();
            }
            tTNativeAd.setActivityForDownloadApp(activity);
            tTNativeAd.registerViewForInteraction(adContainer, clickViews, creativeViews, new n(this, null, str, tTNativeAd));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
