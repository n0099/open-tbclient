package c.g.b0.a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.channel.csj.R;
import com.fun.ad.sdk.channel.model.csj.CSJDrawVideoNativeView;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.NumberUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class r extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a implements TTAdNative.DrawFeedAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public a(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
        public void onDrawFeedAdLoad(List<TTDrawFeedAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                LogPrinter.d();
                if (list == null || list.isEmpty()) {
                    LogPrinter.e("onFeedAdLoad error: adList is null or empty", new Object[0]);
                    this.a.onError(0, "NoFill");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (TTDrawFeedAd tTDrawFeedAd : list) {
                    arrayList.add(tTDrawFeedAd);
                }
                this.a.onAdLoaded((List) arrayList);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                LogPrinter.e("CSJDrawNative onError code: " + i2 + ", message: " + str, new Object[0]);
                this.a.onError(i2, str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Ssp.Pid pid) {
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

    @Override // c.g.b0.a.k
    public void d(FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, funAdSlot) == null) {
            this.f28245h.loadDrawFeedAd(new AdSlot.Builder().setCodeId(this.mPid.pid).setDownloadType(FunAdSdk.getFunAdConfig().downLoadType).setAdCount(NumberUtils.adjustInt(funAdSlot.getAdCount(), 1, 3)).build(), new a(this));
        }
    }

    @Override // c.g.b0.a.k
    public boolean i(Activity activity, ViewGroup viewGroup, String str, TTNativeAd tTNativeAd) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, viewGroup, str, tTNativeAd)) == null) {
            onShowStart();
            CSJDrawVideoNativeView cSJDrawVideoNativeView = (CSJDrawVideoNativeView) LayoutInflater.from(activity).inflate(R.layout.fun_csj_ad_draw_video_native, viewGroup, false);
            viewGroup.removeAllViews();
            viewGroup.addView(cSJDrawVideoNativeView);
            cSJDrawVideoNativeView.a(tTNativeAd);
            s sVar = new s(this, tTNativeAd);
            tTNativeAd.setActivityForDownloadApp(activity);
            tTNativeAd.registerViewForInteraction(viewGroup, cSJDrawVideoNativeView.getClickViews(), cSJDrawVideoNativeView.getCreativeViews(), sVar);
            tTNativeAd.setDownloadListener(cSJDrawVideoNativeView.getDownloadListener());
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // c.g.b0.a.k, com.fun.ad.sdk.internal.api.BasePidLoader
    public /* bridge */ /* synthetic */ boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        i(activity, viewGroup, str, (TTNativeAd) obj);
        return true;
    }
}
