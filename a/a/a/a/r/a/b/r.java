package a.a.a.a.r.a.b;

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
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class r extends g<TTNativeExpressAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<TTNativeExpressAd, String> o;

    /* loaded from: classes.dex */
    public class a implements TTAdNative.NativeExpressAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1148a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ r f1149b;

        public a(r rVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1149b = rVar;
            this.f1148a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.c.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                a.a.a.a.v.d.b("CSJNativeExpressAd onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f1149b.f1015h.a(Integer.valueOf(i2));
                this.f1149b.b(i2, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                a.a.a.a.v.d.b("CSJNativeExpressAd onNativeExpressAdLoad", new Object[0]);
                if (list != null && !list.isEmpty()) {
                    this.f1149b.f1015h.b();
                    TTNativeExpressAd tTNativeExpressAd = list.get(0);
                    this.f1149b.l.b(tTNativeExpressAd, this.f1148a.getSid());
                    r rVar = this.f1149b;
                    String sid = this.f1148a.getSid();
                    if (rVar == null) {
                        throw null;
                    }
                    tTNativeExpressAd.setExpressInteractionListener(new s(rVar, tTNativeExpressAd, sid));
                    tTNativeExpressAd.setCanInterruptVideoPlay(true);
                    tTNativeExpressAd.render();
                    return;
                }
                a.a.a.a.v.d.b("CSJNativeExpressAd onNativeExpressAdLoad error: adList is null or empty", new Object[0]);
                this.f1149b.f1015h.a("NoFill");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(h.a aVar) {
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
        this.o = new HashMap<>();
    }

    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, activity, viewGroup, str, obj)) == null) {
            TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) obj;
            View expressAdView = tTNativeExpressAd.getExpressAdView();
            if (expressAdView != null && expressAdView.getParent() != null) {
                ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
            }
            this.o.put(tTNativeExpressAd, str);
            this.f1015h.g();
            tTNativeExpressAd.setDislikeCallback(activity, new t(this, expressAdView));
            tTNativeExpressAd.setDownloadListener(new a.a.a.a.r.b.a.a(null));
            viewGroup.removeAllViews();
            viewGroup.addView(expressAdView);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // a.a.a.a.b
    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) obj;
            this.o.remove(tTNativeExpressAd);
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.destroy();
            }
        }
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, funAdSlot) == null) {
            if (this.n == null) {
                this.n = TTAdSdk.getAdManager().createAdNative(context);
            }
            int expressWidth = funAdSlot.getExpressWidth();
            int expressHeight = funAdSlot.getExpressHeight();
            if (expressWidth == 0 && expressHeight == 0 && FunAdSdk.isLogEnabled()) {
                throw new RuntimeException("Invalid expressWidth and expressHeight.");
            }
            AdSlot build = new AdSlot.Builder().setCodeId(this.f1016i.f1361c).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(expressWidth, expressHeight).build();
            this.f1015h.a(funAdSlot, this.f1016i);
            this.n.loadNativeExpressAd(build, new a(this, funAdSlot));
            g();
        }
    }
}
