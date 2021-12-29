package c.g.b0.a;

import android.view.View;
import c.g.b0.a.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.fun.ad.sdk.FunSplashAdInteractionListener;
/* loaded from: classes9.dex */
public class g extends d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ o f29068f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d dVar, TTSplashAd tTSplashAd, String str, o oVar) {
        super(dVar, tTSplashAd, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, tTSplashAd, str, oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d) objArr2[0], (TTSplashAd) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29068f = oVar;
    }

    @Override // c.g.b0.a.d.b, com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdClicked(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
            super.onAdClicked(view, i2);
            o oVar = this.f29068f;
            String str = this.f29059b;
            FunSplashAdInteractionListener funSplashAdInteractionListener = oVar.f29098j;
            if (funSplashAdInteractionListener != null) {
                funSplashAdInteractionListener.onAdClicked(str);
            }
        }
    }

    @Override // c.g.b0.a.d.b, com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdShow(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            super.onAdShow(view, i2);
            o oVar = this.f29068f;
            oVar.f29095g = oVar.f29090b.getWidth();
            oVar.f29096h = oVar.f29090b.getHeight();
        }
    }
}
