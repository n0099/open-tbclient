package a.a.a.a.u.a.c;

import a.a.a.a.v.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
/* loaded from: classes.dex */
public class o extends a.a.a.a.c<UnifiedInterstitialAD> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<UnifiedInterstitialAD, String> n;

    /* loaded from: classes.dex */
    public class a implements UnifiedInterstitialADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1221a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1222b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnifiedInterstitialAD[] f1223c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1224d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f1225e;

        public a(o oVar, UnifiedInterstitialAD[] unifiedInterstitialADArr, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, unifiedInterstitialADArr, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1225e = oVar;
            this.f1223c = unifiedInterstitialADArr;
            this.f1224d = funAdSlot;
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.a.a.a.y.d.a();
                this.f1225e.f1017h.a(this.f1222b);
                this.f1222b = true;
                this.f1225e.e();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClosed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a.a.a.a.y.d.a();
                this.f1225e.f1017h.d();
                this.f1225e.f();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADExposure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                a.a.a.a.y.d.a();
                this.f1225e.f1017h.b(this.f1221a);
                UnifiedInterstitialAD unifiedInterstitialAD = this.f1223c[0];
                this.f1221a = true;
                o oVar = this.f1225e;
                oVar.a((o) unifiedInterstitialAD, oVar.n.remove(unifiedInterstitialAD));
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADLeftApplication() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                a.a.a.a.y.d.a();
                this.f1225e.f1017h.a();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADOpened() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                a.a.a.a.y.d.a();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADReceive() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                a.a.a.a.y.d.a();
                this.f1225e.f1017h.b();
                UnifiedInterstitialAD unifiedInterstitialAD = this.f1223c[0];
                this.f1225e.n.put(unifiedInterstitialAD, this.f1224d.getSid());
                o oVar = this.f1225e;
                oVar.a((o) unifiedInterstitialAD);
                oVar.h();
                this.f1225e.l.b(unifiedInterstitialAD, this.f1224d.getSid());
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onNoAD(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, adError) == null) {
                a.a.a.a.y.d.b("onNoAD code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
                this.f1225e.f1017h.a(Integer.valueOf(adError.getErrorCode()));
                this.f1225e.b(adError.getErrorCode(), adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                a.a.a.a.y.d.a();
                this.f1225e.f1017h.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(e.a aVar) {
        super(aVar, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((e.a) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public a.a.a.a.x.a a(e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? new a.a.a.a.x.l(aVar) : (a.a.a.a.x.a) invokeL.objValue;
    }

    public void a(Activity activity, UnifiedInterstitialAD unifiedInterstitialAD) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, unifiedInterstitialAD) == null) {
            unifiedInterstitialAD.show(activity);
        }
    }

    public void a(UnifiedInterstitialAD unifiedInterstitialAD) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unifiedInterstitialAD) == null) {
            unifiedInterstitialAD.loadAD();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, UnifiedInterstitialAD unifiedInterstitialAD) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, activity, viewGroup, str, unifiedInterstitialAD)) == null) {
            UnifiedInterstitialAD unifiedInterstitialAD2 = unifiedInterstitialAD;
            this.f1017h.g();
            this.n.put(unifiedInterstitialAD2, str);
            a(activity, unifiedInterstitialAD2);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, funAdSlot) == null) {
            this.f1017h.a(funAdSlot, this.f1018i);
            if (!(context instanceof Activity)) {
                this.f1017h.a("NoA");
                b(0, "NotActivity");
                return;
            }
            UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) context, this.f1018i.f1345c, new a(this, r2, funAdSlot));
            UnifiedInterstitialAD[] unifiedInterstitialADArr = {unifiedInterstitialAD};
            unifiedInterstitialAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? 1 : 0).setAutoPlayMuted(false).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build());
            unifiedInterstitialAD.setMinVideoDuration(0);
            unifiedInterstitialAD.setMaxVideoDuration(0);
            unifiedInterstitialAD.setVideoPlayPolicy(1);
            a(unifiedInterstitialAD);
            g();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(UnifiedInterstitialAD unifiedInterstitialAD) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, unifiedInterstitialAD) == null) {
            UnifiedInterstitialAD unifiedInterstitialAD2 = unifiedInterstitialAD;
            this.n.remove(unifiedInterstitialAD2);
            if (unifiedInterstitialAD2 != null) {
                try {
                    unifiedInterstitialAD2.destroy();
                } catch (Exception unused) {
                }
            }
        }
    }
}
