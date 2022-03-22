package c.d.a0.a;

import android.view.View;
import c.d.a0.a.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.fun.ad.sdk.FunSplashAdInteractionListener;
/* loaded from: classes3.dex */
public class h extends g.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ q f22954f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, TTSplashAd tTSplashAd, String str, q qVar) {
        super(gVar, tTSplashAd, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, tTSplashAd, str, qVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((g) objArr2[0], (TTSplashAd) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22954f = qVar;
    }

    @Override // c.d.a0.a.g.b, com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdClicked(View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i) == null) {
            super.onAdClicked(view, i);
            q qVar = this.f22954f;
            String str = this.f22950b;
            FunSplashAdInteractionListener funSplashAdInteractionListener = qVar.j;
            if (funSplashAdInteractionListener != null) {
                funSplashAdInteractionListener.onAdClicked(str);
            }
        }
    }

    @Override // c.d.a0.a.g.b, com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdShow(View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i) == null) {
            super.onAdShow(view, i);
            q qVar = this.f22954f;
            qVar.f22979g = qVar.f22974b.getWidth();
            qVar.f22980h = qVar.f22974b.getHeight();
        }
    }
}
