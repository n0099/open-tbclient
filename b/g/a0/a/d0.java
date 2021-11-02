package b.g.a0.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes6.dex */
public class d0 implements TTAdDislike.DislikeInteractionCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f30808a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FunAdInteractionListener f30809b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f30810c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b0 f30811d;

    public d0(b0 b0Var, View view, FunAdInteractionListener funAdInteractionListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b0Var, view, funAdInteractionListener, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30811d = b0Var;
        this.f30808a = view;
        this.f30809b = funAdInteractionListener;
        this.f30810c = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onCancel() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LogPrinter.e("CSJNativeExpressAd dislike callback onCancel", new Object[0]);
            adReporter = this.f30811d.mReporter;
            adReporter.recordUnlikeCanceled();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onSelected(int i2, String str, boolean z) {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            LogPrinter.e("CSJNativeExpressAd dislike callback onSelected position: " + i2 + ", message: " + str, new Object[0]);
            adReporter = this.f30811d.mReporter;
            adReporter.recordUnlikeSelected();
            View view = this.f30808a;
            if (view != null && view.getParent() != null) {
                ((ViewGroup) this.f30808a.getParent()).removeView(this.f30808a);
            }
            this.f30811d.onAdClose();
            FunAdInteractionListener funAdInteractionListener = this.f30809b;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClose(this.f30810c);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
