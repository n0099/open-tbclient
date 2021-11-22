package b.f.a0.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.kwad.sdk.core.response.model.AdInfo;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static RippedAd a(AdInfo adInfo) {
        InterceptResult invokeL;
        String str;
        List<AdInfo.AdMaterialInfo.MaterialFeature> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adInfo)) == null) {
            AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
            AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
            RippedAd.Builder builder = new RippedAd.Builder();
            AdInfo.AdMaterialInfo adMaterialInfo = adInfo.adMaterialInfo;
            String str2 = null;
            if (adMaterialInfo == null || (list = adMaterialInfo.materialFeatureList) == null || list.isEmpty()) {
                str = null;
            } else {
                AdInfo.AdMaterialInfo.MaterialFeature materialFeature = adMaterialInfo.materialFeatureList.get(0);
                String str3 = materialFeature.materialUrl;
                str2 = materialFeature.coverUrl;
                str = str3;
            }
            builder.setCorporation(adBaseInfo.corporationName).setTitle(adBaseInfo.productName).setDescription(adBaseInfo.adDescription).setAppName(adBaseInfo.appName).setAppPkg(adBaseInfo.appPackageName).setAppUrl(adConversionInfo.appDownloadUrl).setIconUrl(adBaseInfo.appIconUrl).setImageUrl(RippedAd.combineStrWithComma(adBaseInfo.appImageUrl)).setVideoImageUrl(str2).setVideoUrl(str).setClickUrl(adBaseInfo.clickUrl).setDeepLinkUrl(adConversionInfo.deeplinkUrl).setConvUrl(adBaseInfo.convUrl);
            return builder.build();
        }
        return (RippedAd) invokeL.objValue;
    }
}
