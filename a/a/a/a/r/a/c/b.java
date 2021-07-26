package a.a.a.a.r.a.c;

import a.a.a.a.s.h;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.qq.e.ads.nativ.express2.NativeExpressAD2;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b extends a.a.a.a.b<NativeExpressADData2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<NativeExpressADData2, String> n;

    /* loaded from: classes.dex */
    public class a implements NativeExpressAD2.AdLoadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1174a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f1175b;

        public a(b bVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1175b = bVar;
            this.f1174a = funAdSlot;
        }

        @Override // com.qq.e.ads.nativ.express2.NativeExpressAD2.AdLoadListener
        public void onLoadSuccess(List<NativeExpressADData2> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                a.a.a.a.v.d.a();
                if (list != null && !list.isEmpty()) {
                    this.f1175b.f1015h.b();
                    NativeExpressADData2 nativeExpressADData2 = list.get(0);
                    b bVar = this.f1175b;
                    String sid = this.f1174a.getSid();
                    if (bVar != null) {
                        nativeExpressADData2.setAdEventListener(new c(bVar, nativeExpressADData2, sid));
                        nativeExpressADData2.setMediaListener(new d(bVar));
                        nativeExpressADData2.render();
                        this.f1175b.l.b(nativeExpressADData2, this.f1174a.getSid());
                        return;
                    }
                    throw null;
                }
                this.f1175b.f1015h.a("NoFill");
                this.f1175b.b(0, "NoFill");
            }
        }

        @Override // com.qq.e.ads.AbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adError) == null) {
                a.a.a.a.v.d.b("onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
                this.f1175b.f1015h.a(Integer.valueOf(adError.getErrorCode()));
                this.f1175b.b(adError.getErrorCode(), adError.getErrorMsg());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(h.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((h.a) newInitContext.callArgs[0]);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? new a.a.a.a.u.f(aVar) : (a.a.a.a.u.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, NativeExpressADData2 nativeExpressADData2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, viewGroup, str, nativeExpressADData2)) == null) {
            NativeExpressADData2 nativeExpressADData22 = nativeExpressADData2;
            this.f1015h.g();
            this.n.put(nativeExpressADData22, str);
            View adView = nativeExpressADData22.getAdView();
            if (adView.getParent() != null) {
                ((ViewGroup) adView.getParent()).removeView(adView);
            }
            viewGroup.removeAllViews();
            viewGroup.addView(adView);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            int expressWidth = funAdSlot.getExpressWidth();
            int expressHeight = funAdSlot.getExpressHeight();
            if (expressWidth == 0 && expressHeight == 0 && FunAdSdk.isLogEnabled()) {
                throw new RuntimeException("Invalid expressWidth and expressHeight.");
            }
            NativeExpressAD2 nativeExpressAD2 = new NativeExpressAD2(context.getApplicationContext(), this.f1016i.f1361c, new a(this, funAdSlot));
            this.f1015h.a(funAdSlot, this.f1016i);
            nativeExpressAD2.setAdSize(expressWidth, expressHeight);
            VideoOption2.Builder builder = new VideoOption2.Builder();
            builder.setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? VideoOption2.AutoPlayPolicy.ALWAYS : VideoOption2.AutoPlayPolicy.WIFI).setAutoPlayMuted(!FunAdSdk.getFunAdConfig().isVideoSoundEnable).setDetailPageMuted(false).setMaxVideoDuration(0).setMinVideoDuration(0);
            nativeExpressAD2.setVideoOption2(builder.build());
            nativeExpressAD2.loadAd(1);
            g();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(NativeExpressADData2 nativeExpressADData2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nativeExpressADData2) == null) {
            NativeExpressADData2 nativeExpressADData22 = nativeExpressADData2;
            this.n.remove(nativeExpressADData22);
            if (nativeExpressADData22 != null) {
                nativeExpressADData22.destroy();
            }
        }
    }
}
