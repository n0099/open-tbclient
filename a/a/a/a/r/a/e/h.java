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
public class h implements KsNativeAd.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1272a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1273b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsNativeAd f1274c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1275d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ g f1276e;

    public h(g gVar, KsNativeAd ksNativeAd, String str) {
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
        this.f1276e = gVar;
        this.f1274c = ksNativeAd;
        this.f1275d = str;
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
            a.a.a.a.v.d.a();
            this.f1276e.f1015h.a(this.f1273b);
            this.f1273b = true;
            this.f1276e.e();
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
    public void onAdShow(KsNativeAd ksNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ksNativeAd) == null) {
            a.a.a.a.v.d.a();
            this.f1276e.f1015h.b(this.f1272a);
            this.f1272a = true;
            this.f1276e.a((g) this.f1274c, this.f1275d);
        }
    }
}
