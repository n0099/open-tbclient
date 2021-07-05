package a.a.a.a.u.b.a;

import a.a.a.a.u.a.b.d;
import a.a.a.a.u.a.b.f;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunNativeAd;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends a.a.a.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final TTNativeAd f1298c;

    /* renamed from: d  reason: collision with root package name */
    public final d f1299d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TTNativeAd tTNativeAd, String str, d dVar) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tTNativeAd, str, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1298c = tTNativeAd;
        this.f1299d = dVar;
    }

    @Override // a.a.a.a.b
    public void a(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, context, viewGroup, list, list2, funAdInteractionListener) == null) {
            d dVar = this.f1299d;
            TTNativeAd tTNativeAd = this.f1298c;
            String str = this.f1007a;
            f fVar = new f(dVar, tTNativeAd, str);
            dVar.o.a(tTNativeAd, str, fVar, funAdInteractionListener);
            if (context instanceof Activity) {
                tTNativeAd.setActivityForDownloadApp((Activity) context);
            }
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            tTNativeAd.registerViewForInteraction(viewGroup, list, list2, fVar);
        }
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public ChannelNativeAds_6 getChannelNativeAds_6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ChannelNativeAds_6.create(this.f1298c) : (ChannelNativeAds_6) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1298c.getDescription() : (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TTImage icon = this.f1298c.getIcon();
            if (icon == null) {
                return null;
            }
            return icon.getImageUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public List<String> getImageUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<TTImage> imageList = this.f1298c.getImageList();
            if (imageList == null || imageList.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (TTImage tTImage : imageList) {
                arrayList.add(tTImage.getImageUrl());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public FunNativeAd.InteractionType getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int interactionType = this.f1298c.getInteractionType();
            return (interactionType == 2 || interactionType == 3) ? FunNativeAd.InteractionType.TYPE_BROWSE : interactionType != 4 ? interactionType != 5 ? FunNativeAd.InteractionType.TYPE_UNKNOW : FunNativeAd.InteractionType.TYPE_DIAL : FunNativeAd.InteractionType.TYPE_DOWNLOAD;
        }
        return (FunNativeAd.InteractionType) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String source = this.f1298c.getSource();
            return TextUtils.isEmpty(source) ? this.f1298c.getTitle() : source;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public View getVideoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1298c.getAdView() : (View) invokeV.objValue;
    }
}
