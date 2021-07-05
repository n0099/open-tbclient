package a.a.a.a.u.a.b;

import a.a.a.a.v.e;
import android.app.Activity;
import android.content.Context;
import android.support.v4.media.session.MediaSessionCompat;
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
public class h extends g<TTNativeExpressAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<TTNativeExpressAd, String> o;

    /* loaded from: classes.dex */
    public class a implements TTAdNative.NativeExpressAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1124a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f1125b;

        public a(h hVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1125b = hVar;
            this.f1124a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.c.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                a.a.a.a.y.d.b("onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f1125b.f1017h.a(Integer.valueOf(i2));
                this.f1125b.b(i2, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                a.a.a.a.y.d.a();
                if (list != null && !list.isEmpty()) {
                    this.f1125b.f1017h.b();
                    for (TTNativeExpressAd tTNativeExpressAd : list) {
                        this.f1125b.l.b(tTNativeExpressAd, this.f1124a.getSid());
                    }
                    h hVar = this.f1125b;
                    String sid = this.f1124a.getSid();
                    if (hVar == null) {
                        throw null;
                    }
                    b bVar = new b(hVar, list.size());
                    for (TTNativeExpressAd tTNativeExpressAd2 : list) {
                        tTNativeExpressAd2.setExpressInteractionListener(new i(hVar, tTNativeExpressAd2, bVar, sid));
                        tTNativeExpressAd2.render();
                    }
                    return;
                }
                onError(0, "NoFill");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f1126a;

        /* renamed from: b  reason: collision with root package name */
        public final int f1127b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1128c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h f1129d;

        public b(h hVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1129d = hVar;
            this.f1128c = false;
            this.f1127b = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(e.a aVar) {
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
            this.f1017h.g();
            this.o.put(tTNativeExpressAd, str);
            tTNativeExpressAd.setCanInterruptVideoPlay(true);
            tTNativeExpressAd.setVideoAdListener(new j(this));
            View expressAdView = tTNativeExpressAd.getExpressAdView();
            if (expressAdView.getParent() != null) {
                ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
            }
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
            AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(this.f1018i.f1345c).setSupportDeepLink(true).setExpressViewAcceptedSize(expressWidth, expressHeight).setImageAcceptedSize(640, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP).setAdCount(a.a.a.a.a.a(funAdSlot.getAdCount(), 1, 3));
            TTAdNative createAdNative = TTAdSdk.getAdManager().createAdNative(context);
            this.f1017h.a(funAdSlot, this.f1018i);
            createAdNative.loadExpressDrawFeedAd(adCount.build(), new a(this, funAdSlot));
            g();
        }
    }
}
