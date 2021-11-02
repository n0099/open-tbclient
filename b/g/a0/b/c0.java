package b.g.a0.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.g.a0.b.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.ChannelNativeAds;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.internal.api.BaseFunNativeAd;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c0 extends BaseFunNativeAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final NativeUnifiedADData f30912b;

    /* renamed from: c  reason: collision with root package name */
    public final ChannelNativeAds f30913c;

    /* renamed from: d  reason: collision with root package name */
    public final MediaView f30914d;

    /* renamed from: e  reason: collision with root package name */
    public final o f30915e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(NativeUnifiedADData nativeUnifiedADData, MediaView mediaView, String str, Ssp.Pid pid, o oVar) {
        super(str, pid);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nativeUnifiedADData, mediaView, str, pid, oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Ssp.Pid) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30912b = nativeUnifiedADData;
        this.f30914d = mediaView;
        this.f30913c = ChannelNativeAds.createGdt(nativeUnifiedADData);
        this.f30915e = oVar;
    }

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public ChannelNativeAds getChannelNativeAds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30913c : (ChannelNativeAds) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30912b.getDesc() : (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30912b.getIconUrl() : (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public List<String> getImageUrls() {
        InterceptResult invokeV;
        String imgUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<String> imgList = this.f30912b.getImgList();
            if (imgList == null) {
                imgList = new ArrayList<>();
            }
            if (imgList.isEmpty() && (imgUrl = this.f30912b.getImgUrl()) != null) {
                imgList.add(imgUrl);
            }
            return imgList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public FunNativeAd.InteractionType getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f30912b.isAppAd()) {
                int appStatus = this.f30912b.getAppStatus();
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

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30912b.getTitle() : (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public View getVideoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f30914d : (View) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BaseFunNativeAd
    public void showInternal(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, context, viewGroup, list, list2, funAdInteractionListener) == null) {
            if (!(viewGroup instanceof NativeAdContainer)) {
                LogPrinter.e("adContainer must derive from com.qq.e.ads.nativ.widgetNativeAdContainer", new Object[0]);
                if (FunAdSdk.isLogEnabled()) {
                    throw new IllegalArgumentException("adContainer must derive from com.qq.e.ads.nativ.widgetNativeAdContainer");
                }
                return;
            }
            o oVar = this.f30915e;
            NativeUnifiedADData nativeUnifiedADData = this.f30912b;
            String str = this.mSid;
            NativeAdContainer nativeAdContainer = (NativeAdContainer) viewGroup;
            MediaView mediaView = this.f30914d;
            ChannelNativeAds.GdtADStatusChangeListener gdtADStatusChangeListener = this.f30913c.getGdtADStatusChangeListener();
            oVar.getClass();
            o.c cVar = new o.c(oVar, nativeUnifiedADData, str);
            if (gdtADStatusChangeListener != null) {
                cVar.f30938d = new s(oVar, gdtADStatusChangeListener, nativeUnifiedADData);
            }
            oVar.f(nativeUnifiedADData, str, nativeAdContainer, mediaView, list, cVar, funAdInteractionListener);
        }
    }
}
