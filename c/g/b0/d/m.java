package c.g.b0.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.FunNativeView;
import com.fun.ad.sdk.channel.ks.R;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.NumberUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class m extends ReporterPidLoader<KsNativeAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final FunNativeAdListenerHelper<KsNativeAd, KsNativeAd.AdInteractionListener> f29244h;

    /* loaded from: classes9.dex */
    public class a implements KsLoadManager.NativeAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m a;

        public a(m mVar) {
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
            this.a = mVar;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                LogPrinter.e("onError code: " + i2 + ", message: " + str, new Object[0]);
                this.a.onError(i2, str);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                LogPrinter.d();
                if (list != null && !list.isEmpty()) {
                    this.a.onAdLoaded((List) list);
                    return;
                }
                LogPrinter.e("error: adList is null or empty", new Object[0]);
                this.a.onError(0, "NoFill");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final KsNativeAd a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ m f29245b;

        public b(m mVar, KsNativeAd ksNativeAd) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, ksNativeAd};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29245b = mVar;
            this.a = ksNativeAd;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, onClickListener)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdClicked(View view, KsNativeAd ksNativeAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, ksNativeAd) == null) {
                this.f29245b.f29244h.onAdClick(this.a);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdShow(KsNativeAd ksNativeAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ksNativeAd) == null) {
                this.f29245b.f29244h.onAdShow(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Ssp.Pid pid) {
        super(pid, true, true);
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
                super((Ssp.Pid) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29244h = new FunNativeAdListenerHelper<>(this);
    }

    public final com.fun.module.ks.x a(Context context, KsNativeAd ksNativeAd) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, ksNativeAd)) == null) {
            int i2 = R.layout.fun_ks_ad_native_single_img_h5_open_view;
            int materialType = ksNativeAd.getMaterialType();
            if (materialType == 1) {
                int interactionType = ksNativeAd.getInteractionType();
                if (interactionType == 1) {
                    i2 = R.layout.fun_ks_ad_native_video_app_download_view;
                } else if (interactionType == 2) {
                    i2 = R.layout.fun_ks_ad_native_video_h5_open_view;
                }
            } else if (materialType == 2) {
                int interactionType2 = ksNativeAd.getInteractionType();
                if (interactionType2 == 1) {
                    i2 = R.layout.fun_ks_ad_native_single_img_app_download_view;
                } else if (interactionType2 == 2) {
                    i2 = R.layout.fun_ks_ad_native_single_img_h5_open_view;
                }
            } else if (materialType == 3) {
                int interactionType3 = ksNativeAd.getInteractionType();
                if (interactionType3 == 1) {
                    i2 = R.layout.fun_ks_ad_native_group_img_app_download_view;
                } else if (interactionType3 == 2) {
                    i2 = R.layout.fun_ks_ad_native_group_img_h5_open_view;
                }
            }
            com.fun.module.ks.x xVar = (com.fun.module.ks.x) LayoutInflater.from(context).inflate(i2, (ViewGroup) null, false);
            xVar.a(ksNativeAd);
            return xVar;
        }
        return (com.fun.module.ks.x) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pid)) == null) ? new z(pid) : (AdRipper) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        KsNativeAd ksNativeAd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || (ksNativeAd = (KsNativeAd) obj) == null) {
            return;
        }
        this.f29244h.destroy(ksNativeAd);
    }

    /* JADX DEBUG: Incorrect args count in method signature: (Landroid/content/Context;Lcom/kwad/sdk/api/KsNativeAd;Ljava/lang/String;Landroid/view/ViewGroup;Ljava/util/List<Landroid/view/View;>;Lc/g/b0/d/m$b;Lcom/fun/ad/sdk/FunAdInteractionListener;)V */
    public void f(KsNativeAd ksNativeAd, String str, ViewGroup viewGroup, List list, b bVar, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{ksNativeAd, str, viewGroup, list, bVar, funAdInteractionListener}) == null) {
            this.f29244h.startShow(ksNativeAd, str, this.mPid, bVar, funAdInteractionListener);
            if (viewGroup instanceof FunNativeView) {
                viewGroup = ((FunNativeView) viewGroup).getRoot();
            }
            ksNativeAd.registerViewForInteraction(viewGroup, list, bVar);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd getNativeAdInternal(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, str, obj)) == null) ? new x(context, (KsNativeAd) obj, str, this.mPid, this) : (FunNativeAd) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, context, str, obj)) == null) {
            KsNativeAd ksNativeAd = (KsNativeAd) obj;
            return new BaseNativeAd2(FunNativeAd2.NativeType.BOTH, ksNativeAd, new x(context, ksNativeAd, str, this.mPid, this), new o(this, ksNativeAd, context));
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, funAdSlot) == null) {
            KsScene build = new KsScene.Builder(Long.parseLong(this.mPid.pid)).adNum(NumberUtils.adjustInt(funAdSlot.getAdCount(), 1, 5)).build();
            onLoadStart(funAdSlot);
            KsAdSDK.getLoadManager().loadNativeAd(build, new a(this));
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, activity, viewGroup, str, obj)) == null) {
            KsNativeAd ksNativeAd = (KsNativeAd) obj;
            onShowStart();
            com.fun.module.ks.x a2 = a(activity, ksNativeAd);
            ksNativeAd.registerViewForInteraction(a2, a2.getClickViews(), new n(this, ksNativeAd));
            viewGroup.removeAllViews();
            viewGroup.addView(a2);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, str, funNativeAdInflater, obj)) == null) {
            KsNativeAd ksNativeAd = (KsNativeAd) obj;
            onShowStart();
            ViewGroup adContainer = funNativeAdInflater.getAdContainer(new x(activity, ksNativeAd, str, this.mPid, this));
            List<View> clickViews = funNativeAdInflater.getClickViews();
            if (clickViews == null) {
                clickViews = new ArrayList<>();
            }
            ksNativeAd.registerViewForInteraction(adContainer, clickViews, new n(this, ksNativeAd));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
