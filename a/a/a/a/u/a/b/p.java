package a.a.a.a.u.a.b;

import a.a.a.a.v.e;
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
public class p extends g<TTNativeExpressAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<TTNativeExpressAd, String> o;

    /* loaded from: classes.dex */
    public class a implements TTAdNative.NativeExpressAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1151a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ p f1152b;

        public a(p pVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1152b = pVar;
            this.f1151a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.c.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                a.a.a.a.y.d.b("CSJNativeExpressAd onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f1152b.f1017h.a(Integer.valueOf(i2));
                this.f1152b.b(i2, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                a.a.a.a.y.d.b("CSJNativeExpressAd onNativeExpressAdLoad", new Object[0]);
                if (list != null && !list.isEmpty()) {
                    this.f1152b.f1017h.b();
                    TTNativeExpressAd tTNativeExpressAd = list.get(0);
                    this.f1152b.l.b(tTNativeExpressAd, this.f1151a.getSid());
                    p pVar = this.f1152b;
                    String sid = this.f1151a.getSid();
                    if (pVar == null) {
                        throw null;
                    }
                    tTNativeExpressAd.setExpressInteractionListener(new q(pVar, tTNativeExpressAd, sid));
                    tTNativeExpressAd.setCanInterruptVideoPlay(true);
                    tTNativeExpressAd.render();
                    return;
                }
                a.a.a.a.y.d.b("CSJNativeExpressAd onNativeExpressAdLoad error: adList is null or empty", new Object[0]);
                this.f1152b.f1017h.a("NoFill");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(e.a aVar) {
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
                super((e.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new HashMap<>();
    }

    @Override // a.a.a.a.c
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
            this.f1017h.g();
            tTNativeExpressAd.setDislikeCallback(activity, new r(this, expressAdView));
            tTNativeExpressAd.setDownloadListener(new a.a.a.a.u.b.a.a(null));
            viewGroup.removeAllViews();
            viewGroup.addView(expressAdView);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // a.a.a.a.c
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

    @Override // a.a.a.a.c
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
            AdSlot build = new AdSlot.Builder().setCodeId(this.f1018i.f1345c).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(expressWidth, expressHeight).build();
            this.f1017h.a(funAdSlot, this.f1018i);
            this.n.loadNativeExpressAd(build, new a(this, funAdSlot));
            g();
        }
    }
}
