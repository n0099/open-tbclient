package c.g.b0.d;

import android.content.DialogInterface;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes9.dex */
public class n extends t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28382b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsNativeAd f28383c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ m f28384d;

    public n(m mVar, KsNativeAd ksNativeAd) {
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
        this.f28384d = mVar;
        this.f28383c = ksNativeAd;
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
            LogPrinter.d();
            this.f28384d.onAdClicked(this.f28382b);
            this.f28382b = true;
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
    public void onAdShow(KsNativeAd ksNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ksNativeAd) == null) {
            LogPrinter.d();
            this.f28384d.onAdShow(this.f28383c, this.a);
            this.a = true;
        }
    }
}
