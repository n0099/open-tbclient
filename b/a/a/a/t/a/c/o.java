package b.a.a.a.t.a.c;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import b.a.a.a.u.h;
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
public class o extends g<TTNativeExpressAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<TTNativeExpressAd, String> p;

    /* loaded from: classes.dex */
    public class a implements TTAdNative.NativeExpressAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1197a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o f1198b;

        public a(o oVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1198b = oVar;
            this.f1197a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.c.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                b.a.a.a.x.d.f("onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f1198b.f1057h.e(Integer.valueOf(i2));
                this.f1198b.n(i2, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                b.a.a.a.x.d.a();
                if (list != null && !list.isEmpty()) {
                    this.f1198b.f1057h.h();
                    TTNativeExpressAd tTNativeExpressAd = list.get(0);
                    this.f1198b.m.c(tTNativeExpressAd, this.f1197a.getSid());
                    o oVar = this.f1198b;
                    String sid = this.f1197a.getSid();
                    if (oVar == null) {
                        throw null;
                    }
                    tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) new p(oVar, tTNativeExpressAd, sid));
                    tTNativeExpressAd.render();
                    return;
                }
                b.a.a.a.x.d.f("onNativeExpressAdLoad error: adList is null or empty", new Object[0]);
                this.f1198b.f1057h.e("NoFill");
                this.f1198b.n(0, "NoFill");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(h.a aVar) {
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
        this.p = new HashMap<>();
    }

    @Override // b.a.a.a.c
    public boolean k(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, activity, viewGroup, str, obj)) == null) {
            TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) obj;
            this.f1057h.p();
            this.p.put(tTNativeExpressAd, str);
            tTNativeExpressAd.setDownloadListener(new b.a.a.a.t.b.a.a(null));
            tTNativeExpressAd.showInteractionExpressAd(activity);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // b.a.a.a.c
    public void o(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, funAdSlot) == null) {
            if (this.o == null) {
                this.o = TTAdSdk.getAdManager().createAdNative(context);
            }
            int expressWidth = funAdSlot.getExpressWidth();
            int expressHeight = funAdSlot.getExpressHeight();
            if (expressWidth == 0 && expressHeight == 0 && FunAdSdk.isLogEnabled()) {
                throw new RuntimeException("Invalid expressWidth and expressHeight.");
            }
            AdSlot build = new AdSlot.Builder().setCodeId(this.f1058i.f1448c).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(expressWidth, expressHeight).build();
            this.f1057h.d(funAdSlot, this.f1058i);
            this.o.loadInteractionExpressAd(build, new a(this, funAdSlot));
            t();
        }
    }

    @Override // b.a.a.a.c
    public void p(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) obj;
            this.p.remove(tTNativeExpressAd);
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.destroy();
            }
        }
    }
}
