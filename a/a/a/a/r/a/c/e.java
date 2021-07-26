package a.a.a.a.r.a.c;

import a.a.a.a.s.h;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class e extends a.a.a.a.b<NativeExpressADView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<NativeExpressADView, String> n;

    /* loaded from: classes.dex */
    public class a implements NativeExpressAD.NativeExpressADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1182a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1183b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1184c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f1185d;

        public a(e eVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1185d = eVar;
            this.f1184c = funAdSlot;
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nativeExpressADView) == null) {
                a.a.a.a.v.d.a();
                this.f1185d.f1015h.a(this.f1183b);
                this.f1183b = true;
                this.f1185d.e();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADCloseOverlay(NativeExpressADView nativeExpressADView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nativeExpressADView) == null) {
                a.a.a.a.v.d.b("GDTNativeExpressAd onADCloseOverlay", new Object[0]);
                a.a.a.a.v.g.g.c.a(this.f1185d.f1015h.f1441a, "overlay_close", new Object[0]);
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nativeExpressADView) == null) {
                a.a.a.a.v.d.b("GDTNativeExpressAd onADClosed", new Object[0]);
                this.f1185d.f1015h.d();
                this.f1185d.f();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, nativeExpressADView) == null) {
                a.a.a.a.v.d.a();
                this.f1185d.f1015h.b(this.f1182a);
                this.f1182a = true;
                e eVar = this.f1185d;
                eVar.a((e) nativeExpressADView, eVar.n.remove(nativeExpressADView));
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, nativeExpressADView) == null) {
                a.a.a.a.v.d.b("GDTNativeExpressAd onADLeftApplication", new Object[0]);
                this.f1185d.f1015h.a();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
                a.a.a.a.v.d.a();
                if (list != null && !list.isEmpty()) {
                    this.f1185d.f1015h.b();
                    NativeExpressADView nativeExpressADView = list.get(0);
                    this.f1185d.l.b(nativeExpressADView, this.f1184c.getSid());
                    nativeExpressADView.render();
                    return;
                }
                this.f1185d.f1015h.a("NoFill");
                this.f1185d.b(0, "NoFill");
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADOpenOverlay(NativeExpressADView nativeExpressADView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, nativeExpressADView) == null) {
                a.a.a.a.v.d.b("GDTNativeExpressAd onADOpenOverlay", new Object[0]);
                a.a.a.a.v.g.g.c.a(this.f1185d.f1015h.f1441a, "overlay_open", new Object[0]);
            }
        }

        @Override // com.qq.e.ads.AbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, adError) == null) {
                a.a.a.a.v.d.b("GDTNativeExpressAd onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
                this.f1185d.f1015h.a(Integer.valueOf(adError.getErrorCode()));
                this.f1185d.b(adError.getErrorCode(), adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nativeExpressADView) == null) {
                a.a.a.a.v.d.b();
                a.a.a.a.v.g.g.c.a(this.f1185d.f1015h.f1441a, "render_failed", new Object[0]);
                this.f1185d.b(0, "RenderFail");
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, nativeExpressADView) == null) {
                a.a.a.a.v.d.a();
                this.f1185d.f1015h.e();
                this.f1185d.n.put(nativeExpressADView, this.f1184c.getSid());
                e eVar = this.f1185d;
                eVar.a((e) nativeExpressADView);
                eVar.h();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h.a aVar) {
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
                super((h.a) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new HashMap<>();
    }

    @Override // a.a.a.a.b
    public a.a.a.a.u.a a(h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? new a.a.a.a.u.g(aVar) : (a.a.a.a.u.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, NativeExpressADView nativeExpressADView) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, viewGroup, str, nativeExpressADView)) == null) {
            NativeExpressADView nativeExpressADView2 = nativeExpressADView;
            if (nativeExpressADView2.getBoundData().getAdPatternType() == 2) {
                nativeExpressADView2.setMediaListener(new f(this));
            }
            this.f1015h.g();
            this.n.put(nativeExpressADView2, str);
            if (nativeExpressADView2.getParent() != null) {
                ((ViewGroup) nativeExpressADView2.getParent()).removeView(nativeExpressADView2);
            }
            viewGroup.removeAllViews();
            viewGroup.addView(nativeExpressADView2);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            this.f1015h.a(funAdSlot, this.f1016i);
            if (!(context instanceof Activity)) {
                this.f1015h.a("NoA");
                b(0, "NotActvity");
                return;
            }
            NativeExpressAD nativeExpressAD = new NativeExpressAD((Activity) context, new ADSize(-1, -2), this.f1016i.f1361c, new a(this, funAdSlot));
            nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? 1 : 0).setAutoPlayMuted(!FunAdSdk.getFunAdConfig().isVideoSoundEnable).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build());
            nativeExpressAD.setMinVideoDuration(0);
            nativeExpressAD.setMaxVideoDuration(0);
            nativeExpressAD.setVideoPlayPolicy(1);
            nativeExpressAD.loadAD(1);
            g();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(NativeExpressADView nativeExpressADView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nativeExpressADView) == null) {
            NativeExpressADView nativeExpressADView2 = nativeExpressADView;
            this.n.remove(nativeExpressADView2);
            if (nativeExpressADView2 != null) {
                nativeExpressADView2.destroy();
            }
        }
    }
}
