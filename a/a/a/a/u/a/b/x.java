package a.a.a.a.u.a.b;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTSplashAd;
/* loaded from: classes.dex */
public class x implements TTSplashAd.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1172a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1173b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTSplashAd f1174c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1175d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ w f1176e;

    public x(w wVar, TTSplashAd tTSplashAd, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar, tTSplashAd, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1176e = wVar;
        this.f1174c = tTSplashAd;
        this.f1175d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdClicked(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
            a.a.a.a.y.d.a();
            this.f1176e.f1017h.a(this.f1173b);
            this.f1173b = true;
            this.f1176e.e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdShow(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            a.a.a.a.y.d.a();
            this.f1176e.f1017h.b(this.f1172a);
            this.f1172a = true;
            this.f1176e.a((w) this.f1174c, this.f1175d);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdSkip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a.a.a.a.y.d.a();
            this.f1176e.f1017h.h();
            this.f1176e.f();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdTimeOver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a.a.a.a.y.d.a();
            a.a.a.a.y.f.g.c.a(this.f1176e.f1017h.f1409a, "splash_timeover", new Object[0]);
            this.f1176e.f();
        }
    }
}
