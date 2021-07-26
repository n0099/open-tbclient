package a.a.a.a.r.a.b;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTSplashAd;
/* loaded from: classes.dex */
public class z implements TTSplashAd.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1169a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1170b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTSplashAd f1171c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1172d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ y f1173e;

    public z(y yVar, TTSplashAd tTSplashAd, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yVar, tTSplashAd, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1173e = yVar;
        this.f1171c = tTSplashAd;
        this.f1172d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdClicked(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
            a.a.a.a.v.d.a();
            this.f1173e.f1015h.a(this.f1170b);
            this.f1170b = true;
            this.f1173e.e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdShow(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            a.a.a.a.v.d.a();
            this.f1173e.f1015h.b(this.f1169a);
            this.f1169a = true;
            this.f1173e.a((y) this.f1171c, this.f1172d);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdSkip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a.a.a.a.v.d.a();
            this.f1173e.f1015h.h();
            this.f1173e.f();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdTimeOver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a.a.a.a.v.d.a();
            a.a.a.a.v.g.g.c.a(this.f1173e.f1015h.f1441a, "splash_timeover", new Object[0]);
            this.f1173e.f();
        }
    }
}
