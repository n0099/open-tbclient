package b.a.a.a.t.a.c;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
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
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunSplashAd;
/* loaded from: classes.dex */
public class y extends g<TTSplashAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements TTAdNative.SplashAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1223a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ y f1224b;

        public a(y yVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1224b = yVar;
            this.f1223a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener, com.bytedance.sdk.openadsdk.c.b
        @MainThread
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                b.a.a.a.x.d.f("CSJSplashAd onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f1224b.f1057h.e(Integer.valueOf(i2));
                this.f1224b.n(i2, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        @MainThread
        public void onSplashAdLoad(TTSplashAd tTSplashAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTSplashAd) == null) {
                b.a.a.a.x.d.a();
                this.f1224b.f1057h.h();
                y yVar = this.f1224b;
                yVar.h(tTSplashAd);
                yVar.u();
                this.f1224b.m.c(tTSplashAd, this.f1223a.getSid());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        @MainThread
        public void onTimeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.a.a.a.x.d.e();
                this.f1224b.f1057h.e("TimeOut");
                this.f1224b.n(0, "Load Timeout");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements TTSplashAd.AdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final TTSplashAd f1225a;

        /* renamed from: b  reason: collision with root package name */
        public final String f1226b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1227c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1228d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ y f1229e;

        public b(y yVar, TTSplashAd tTSplashAd, String str) {
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
            this.f1229e = yVar;
            this.f1225a = tTSplashAd;
            this.f1226b = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdClicked(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
                b.a.a.a.x.d.a();
                this.f1229e.f1057h.f(this.f1228d);
                this.f1228d = true;
                this.f1229e.r();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdShow(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
                b.a.a.a.x.d.a();
                this.f1229e.f1057h.k(this.f1227c);
                this.f1227c = true;
                this.f1229e.i(this.f1225a, this.f1226b);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdSkip() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.a.a.a.x.d.a();
                this.f1229e.f1057h.q();
                this.f1229e.s();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdTimeOver() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                b.a.a.a.x.d.a();
                b.a.a.a.x.f.g.b.c(this.f1229e.f1057h.f1519a, "splash_timeover", new Object[0]);
                this.f1229e.s();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(h.a aVar) {
        super(aVar, false, true);
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
                super((h.a) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
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
            TTSplashAd tTSplashAd = (TTSplashAd) obj;
            w(viewGroup, tTSplashAd, new b(this, tTSplashAd, str));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // b.a.a.a.c
    public FunSplashAd m(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, viewGroup, str, obj)) == null) {
            TTSplashAd tTSplashAd = (TTSplashAd) obj;
            b.a.a.a.t.b.a.c cVar = new b.a.a.a.t.b.a.c(tTSplashAd);
            cVar.f1384i = ((ViewGroup) activity.getWindow().getDecorView()).getHeight();
            w(viewGroup, tTSplashAd, new z(this, tTSplashAd, str, cVar));
            return cVar;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }

    @Override // b.a.a.a.c
    public void o(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            if (this.o == null) {
                this.o = TTAdSdk.getAdManager().createAdNative(context);
            }
            AdSlot x = x();
            this.f1057h.d(funAdSlot, this.f1058i);
            this.o.loadSplashAd(x, new a(this, funAdSlot), 5000);
            t();
        }
    }

    @Override // b.a.a.a.c
    public void p(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            TTSplashAd tTSplashAd = (TTSplashAd) obj;
        }
    }

    public final boolean w(ViewGroup viewGroup, TTSplashAd tTSplashAd, TTSplashAd.AdInteractionListener adInteractionListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, viewGroup, tTSplashAd, adInteractionListener)) == null) {
            View splashView = tTSplashAd.getSplashView();
            if (splashView.getParent() != null) {
                ((ViewGroup) splashView.getParent()).removeView(splashView);
            }
            viewGroup.removeAllViews();
            viewGroup.addView(splashView);
            this.f1057h.p();
            tTSplashAd.setSplashInteractionListener(adInteractionListener);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public AdSlot x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new AdSlot.Builder().setCodeId(this.f1058i.f1448c).setSupportDeepLink(true).setImageAcceptedSize(1080, 1920).build() : (AdSlot) invokeV.objValue;
    }
}
