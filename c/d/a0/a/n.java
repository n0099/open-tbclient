package c.d.a0.a;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes3.dex */
public class n implements TTNativeAd.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f22966b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FunAdInteractionListener f22967c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f22968d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TTNativeAd f22969e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ l f22970f;

    public n(l lVar, FunAdInteractionListener funAdInteractionListener, String str, TTNativeAd tTNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, funAdInteractionListener, str, tTNativeAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22970f = lVar;
        this.f22967c = funAdInteractionListener;
        this.f22968d = str;
        this.f22969e = tTNativeAd;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, tTNativeAd) == null) {
            LogPrinter.d();
            this.f22970f.onAdClicked(this.f22966b, new String[0]);
            this.f22966b = true;
            FunAdInteractionListener funAdInteractionListener = this.f22967c;
            if (funAdInteractionListener != null) {
                String str = this.f22968d;
                pid = this.f22970f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f22970f.mPid;
                funAdInteractionListener.onAdClicked(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, tTNativeAd) == null) {
            LogPrinter.d();
            this.f22970f.onAdClicked(this.f22966b, new String[0]);
            this.f22966b = true;
            FunAdInteractionListener funAdInteractionListener = this.f22967c;
            if (funAdInteractionListener != null) {
                String str = this.f22968d;
                pid = this.f22970f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f22970f.mPid;
                funAdInteractionListener.onAdClicked(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tTNativeAd) == null) {
            LogPrinter.d();
            this.f22970f.onAdShow(this.f22969e, this.a, new String[0]);
            this.a = true;
            FunAdInteractionListener funAdInteractionListener = this.f22967c;
            if (funAdInteractionListener != null) {
                String str = this.f22968d;
                pid = this.f22970f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f22970f.mPid;
                funAdInteractionListener.onAdShow(str, str2, pid2.pid);
            }
        }
    }
}
