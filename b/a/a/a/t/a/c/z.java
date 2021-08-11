package b.a.a.a.t.a.c;

import android.view.View;
import b.a.a.a.t.a.c.y;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.fun.ad.sdk.FunSplashAdInteractionListener;
/* loaded from: classes.dex */
public class z extends y.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ b.a.a.a.t.b.a.c f1230f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(y yVar, TTSplashAd tTSplashAd, String str, b.a.a.a.t.b.a.c cVar) {
        super(yVar, tTSplashAd, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yVar, tTSplashAd, str, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((y) objArr2[0], (TTSplashAd) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1230f = cVar;
    }

    @Override // b.a.a.a.t.a.c.y.b, com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdClicked(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
            super.onAdClicked(view, i2);
            b.a.a.a.t.b.a.c cVar = this.f1230f;
            String str = this.f1226b;
            FunSplashAdInteractionListener funSplashAdInteractionListener = cVar.f1383h;
            if (funSplashAdInteractionListener != null) {
                funSplashAdInteractionListener.onAdClicked(str);
            }
        }
    }

    @Override // b.a.a.a.t.a.c.y.b, com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdShow(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            super.onAdShow(view, i2);
            b.a.a.a.t.b.a.c cVar = this.f1230f;
            cVar.f1380e = cVar.f1377b.getWidth();
            cVar.f1381f = cVar.f1377b.getHeight();
        }
    }
}
