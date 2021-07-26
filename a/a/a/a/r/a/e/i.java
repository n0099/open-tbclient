package a.a.a.a.r.a.e;

import android.content.DialogInterface;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes.dex */
public class i implements KsNativeAd.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KsNativeAd f1277a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1278b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f1279c;

    public i(g gVar, KsNativeAd ksNativeAd, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, ksNativeAd, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1279c = gVar;
        this.f1277a = ksNativeAd;
        this.f1278b = str;
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
            this.f1279c.n.b(this.f1277a);
            this.f1279c.e();
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
    public void onAdShow(KsNativeAd ksNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ksNativeAd) == null) {
            this.f1279c.n.c(this.f1277a);
            this.f1279c.a((g) this.f1277a, this.f1278b);
        }
    }
}
