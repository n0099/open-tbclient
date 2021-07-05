package a.a.a.a.u.a.b;

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
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.fun.ad.sdk.FunAdSlot;
/* loaded from: classes.dex */
public class t extends g<TTRewardVideoAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements TTAdNative.RewardVideoAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1162a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1163b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ t f1164c;

        public a(t tVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1164c = tVar;
            this.f1163b = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.c.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                a.a.a.a.y.d.b("CSJRewardVideoAd onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f1164c.f1017h.a(Integer.valueOf(i2));
                if (this.f1162a) {
                    return;
                }
                this.f1164c.b(i2, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTRewardVideoAd) == null) {
                this.f1162a = true;
                a.a.a.a.y.d.a();
                this.f1164c.f1017h.b();
                t tVar = this.f1164c;
                tVar.a((t) tTRewardVideoAd);
                tVar.h();
                this.f1164c.l.b(tTRewardVideoAd, this.f1163b.getSid());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                a.a.a.a.y.d.a();
                this.f1164c.f1017h.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(e.a aVar) {
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
    }

    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, activity, viewGroup, str, obj)) == null) {
            TTRewardVideoAd tTRewardVideoAd = (TTRewardVideoAd) obj;
            this.f1017h.g();
            tTRewardVideoAd.setRewardAdInteractionListener(new u(this, tTRewardVideoAd, str));
            tTRewardVideoAd.setDownloadListener(new a.a.a.a.u.b.a.a(null));
            tTRewardVideoAd.showRewardVideoAd(activity);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, funAdSlot) == null) {
            if (this.n == null) {
                this.n = TTAdSdk.getAdManager().createAdNative(context);
            }
            AdSlot build = new AdSlot.Builder().setCodeId(this.f1018i.f1345c).setSupportDeepLink(true).setRewardName("Coin").setRewardAmount(1).setUserID(null).setOrientation(this.f1018i.j ? 2 : 1).setMediaExtra("media_extra").build();
            this.f1017h.a(funAdSlot, this.f1018i);
            this.n.loadRewardVideoAd(build, new a(this, funAdSlot));
            g();
        }
    }

    @Override // a.a.a.a.c
    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            TTRewardVideoAd tTRewardVideoAd = (TTRewardVideoAd) obj;
        }
    }
}
