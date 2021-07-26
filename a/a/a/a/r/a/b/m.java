package a.a.a.a.r.a.b;

import a.a.a.a.s.h;
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
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.fun.ad.sdk.FunAdSlot;
/* loaded from: classes.dex */
public class m extends g<TTFullScreenVideoAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements TTAdNative.FullScreenVideoAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1134a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ m f1135b;

        public a(m mVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1135b = mVar;
            this.f1134a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.c.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                a.a.a.a.v.d.b("onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f1135b.f1015h.a(Integer.valueOf(i2));
                this.f1135b.b(i2, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTFullScreenVideoAd) == null) {
                a.a.a.a.v.d.a();
                this.f1135b.f1015h.b();
                m mVar = this.f1135b;
                mVar.a((m) tTFullScreenVideoAd);
                mVar.h();
                this.f1135b.l.b(tTFullScreenVideoAd, this.f1134a.getSid());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                a.a.a.a.v.d.a();
                this.f1135b.f1015h.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(h.a aVar) {
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

    public AdSlot a(FunAdSlot funAdSlot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, funAdSlot)) == null) {
            return new AdSlot.Builder().setCodeId(this.f1016i.f1361c).setSupportDeepLink(true).setOrientation(this.f1016i.j ? 2 : 1).build();
        }
        return (AdSlot) invokeL.objValue;
    }

    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, viewGroup, str, obj)) == null) {
            TTFullScreenVideoAd tTFullScreenVideoAd = (TTFullScreenVideoAd) obj;
            this.f1015h.g();
            tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new n(this, tTFullScreenVideoAd, str));
            tTFullScreenVideoAd.setDownloadListener(new a.a.a.a.r.b.a.a(null));
            tTFullScreenVideoAd.showFullScreenVideoAd(activity);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            if (this.n == null) {
                this.n = TTAdSdk.getAdManager().createAdNative(context);
            }
            AdSlot a2 = a(funAdSlot);
            this.f1015h.a(funAdSlot, this.f1016i);
            this.n.loadFullScreenVideoAd(a2, new a(this, funAdSlot));
            g();
        }
    }

    @Override // a.a.a.a.b
    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            TTFullScreenVideoAd tTFullScreenVideoAd = (TTFullScreenVideoAd) obj;
        }
    }
}
