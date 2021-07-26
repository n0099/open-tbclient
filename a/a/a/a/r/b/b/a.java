package a.a.a.a.r.b.b;

import a.a.a.a.r.a.c.g;
import a.a.a.a.r.a.c.k;
import a.a.a.a.s.h;
import a.a.a.a.v.g.g.d;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunNativeAd;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends a.a.a.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final NativeUnifiedADData f1302c;

    /* renamed from: d  reason: collision with root package name */
    public final ChannelNativeAds_6 f1303d;

    /* renamed from: e  reason: collision with root package name */
    public final MediaView f1304e;

    /* renamed from: f  reason: collision with root package name */
    public final g f1305f;

    /* renamed from: g  reason: collision with root package name */
    public final d f1306g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(NativeUnifiedADData nativeUnifiedADData, MediaView mediaView, String str, h.a aVar, g gVar) {
        super(str, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nativeUnifiedADData, mediaView, str, aVar, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (h.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1302c = nativeUnifiedADData;
        this.f1304e = mediaView;
        this.f1303d = ChannelNativeAds_6.create(nativeUnifiedADData);
        this.f1305f = gVar;
        this.f1306g = new d.b(this.f1001a, aVar);
    }

    @Override // a.a.a.a.a
    public void a(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, context, viewGroup, list, list2, funAdInteractionListener) == null) {
            if (!(viewGroup instanceof NativeAdContainer)) {
                a.a.a.a.v.d.b("adContainer must derive from com.qq.e.ads.nativ.widgetNativeAdContainer", new Object[0]);
                if (FunAdSdk.isLogEnabled()) {
                    throw new IllegalArgumentException("adContainer must derive from com.qq.e.ads.nativ.widgetNativeAdContainer");
                }
                return;
            }
            this.f1306g.c();
            g gVar = this.f1305f;
            NativeUnifiedADData nativeUnifiedADData = this.f1302c;
            String str = this.f1001a;
            NativeAdContainer nativeAdContainer = (NativeAdContainer) viewGroup;
            MediaView mediaView = this.f1304e;
            k kVar = new k(gVar, nativeUnifiedADData, str, this.f1303d.getGdtADStatusChangeListener());
            gVar.n.a(nativeUnifiedADData, str, gVar.f1016i, kVar, funAdInteractionListener);
            nativeUnifiedADData.setNativeAdEventListener(kVar);
            nativeUnifiedADData.bindAdToView(nativeAdContainer.getContext(), nativeAdContainer, null, list);
            if (mediaView != null) {
                nativeUnifiedADData.bindMediaView(mediaView, new VideoOption.Builder().setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? 1 : 0).setAutoPlayMuted(!FunAdSdk.getFunAdConfig().isVideoSoundEnable).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build(), new g.b());
            }
        }
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public ChannelNativeAds_6 getChannelNativeAds_6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1303d : (ChannelNativeAds_6) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1302c.getDesc() : (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1302c.getIconUrl() : (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public List<String> getImageUrls() {
        InterceptResult invokeV;
        String imgUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<String> imgList = this.f1302c.getImgList();
            if (imgList == null) {
                imgList = new ArrayList<>();
            }
            if (imgList.isEmpty() && (imgUrl = this.f1302c.getImgUrl()) != null) {
                imgList.add(imgUrl);
            }
            return imgList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public FunNativeAd.InteractionType getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f1302c.isAppAd()) {
                int appStatus = this.f1302c.getAppStatus();
                if (appStatus != 0) {
                    if (appStatus != 1) {
                        if (appStatus != 2 && appStatus != 4) {
                            if (appStatus != 8) {
                                if (appStatus != 16) {
                                    return FunNativeAd.InteractionType.TYPE_UNKNOW;
                                }
                            }
                        }
                    }
                    return FunNativeAd.InteractionType.TYPE_BROWSE;
                }
                return FunNativeAd.InteractionType.TYPE_DOWNLOAD;
            }
            return FunNativeAd.InteractionType.TYPE_BROWSE;
        }
        return (FunNativeAd.InteractionType) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1302c.getTitle() : (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public View getVideoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1304e : (View) invokeV.objValue;
    }
}
