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
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.fun.ad.sdk.FunAdSlot;
/* loaded from: classes.dex */
public class v extends g<TTRewardVideoAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements TTAdNative.RewardVideoAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1215a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1216b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ v f1217c;

        public a(v vVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1217c = vVar;
            this.f1216b = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.c.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                b.a.a.a.x.d.f("CSJRewardVideoAd onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f1217c.f1057h.e(Integer.valueOf(i2));
                if (this.f1215a) {
                    return;
                }
                this.f1217c.n(i2, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTRewardVideoAd) == null) {
                this.f1215a = true;
                b.a.a.a.x.d.a();
                this.f1217c.f1057h.h();
                v vVar = this.f1217c;
                vVar.h(tTRewardVideoAd);
                vVar.u();
                this.f1217c.m.c(tTRewardVideoAd, this.f1216b.getSid());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.a.a.a.x.d.a();
                this.f1217c.f1057h.l();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(h.a aVar) {
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
    }

    @Override // b.a.a.a.c
    public boolean k(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, activity, viewGroup, str, obj)) == null) {
            TTRewardVideoAd tTRewardVideoAd = (TTRewardVideoAd) obj;
            this.f1057h.p();
            tTRewardVideoAd.setRewardAdInteractionListener(new w(this, tTRewardVideoAd, str));
            tTRewardVideoAd.setDownloadListener(new b.a.a.a.t.b.a.a(null));
            tTRewardVideoAd.showRewardVideoAd(activity);
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
            AdSlot build = new AdSlot.Builder().setCodeId(this.f1058i.f1448c).setSupportDeepLink(true).setRewardName("Coin").setRewardAmount(1).setUserID(null).setOrientation(this.f1058i.f1455j ? 2 : 1).setMediaExtra("media_extra").build();
            this.f1057h.d(funAdSlot, this.f1058i);
            this.o.loadRewardVideoAd(build, new a(this, funAdSlot));
            t();
        }
    }

    @Override // b.a.a.a.c
    public void p(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            TTRewardVideoAd tTRewardVideoAd = (TTRewardVideoAd) obj;
        }
    }
}
