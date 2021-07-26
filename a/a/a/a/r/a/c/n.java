package a.a.a.a.r.a.c;

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
import com.fun.ad.sdk.FunAdSlot;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
/* loaded from: classes.dex */
public class n extends a.a.a.a.b<UnifiedBannerView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<UnifiedBannerView, String> n;

    /* loaded from: classes.dex */
    public class a implements UnifiedBannerADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1213a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1214b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnifiedBannerView[] f1215c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1216d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f1217e;

        public a(n nVar, UnifiedBannerView[] unifiedBannerViewArr, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, unifiedBannerViewArr, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1217e = nVar;
            this.f1215c = unifiedBannerViewArr;
            this.f1216d = funAdSlot;
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.a.a.a.v.d.a();
                this.f1217e.f1015h.a(this.f1214b);
                this.f1214b = true;
                this.f1217e.e();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADCloseOverlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a.a.a.a.v.d.a();
                a.a.a.a.v.g.g.c.a(this.f1217e.f1015h.f1441a, "overlay_close", new Object[0]);
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClosed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                a.a.a.a.v.d.b();
                this.f1217e.f1015h.d();
                this.f1217e.f();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADExposure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                a.a.a.a.v.d.a();
                this.f1217e.f1015h.b(this.f1213a);
                this.f1213a = true;
                UnifiedBannerView unifiedBannerView = this.f1215c[0];
                n nVar = this.f1217e;
                nVar.a((n) unifiedBannerView, nVar.n.remove(unifiedBannerView));
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADLeftApplication() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                a.a.a.a.v.d.a();
                this.f1217e.f1015h.a();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADOpenOverlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                a.a.a.a.v.d.b();
                a.a.a.a.v.g.g.c.a(this.f1217e.f1015h.f1441a, "overlay_open", new Object[0]);
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADReceive() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                a.a.a.a.v.d.a();
                this.f1217e.f1015h.b();
                UnifiedBannerView unifiedBannerView = this.f1215c[0];
                this.f1217e.n.put(unifiedBannerView, this.f1216d.getSid());
                n nVar = this.f1217e;
                nVar.a((n) unifiedBannerView);
                nVar.h();
                this.f1217e.l.b(unifiedBannerView, this.f1216d.getSid());
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onNoAD(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, adError) == null) {
                this.f1217e.f1015h.a(Integer.valueOf(adError.getErrorCode()));
                this.f1217e.b(adError.getErrorCode(), adError.getErrorMsg());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(h.a aVar) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? new a.a.a.a.u.k(aVar) : (a.a.a.a.u.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, UnifiedBannerView unifiedBannerView) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, viewGroup, str, unifiedBannerView)) == null) {
            UnifiedBannerView unifiedBannerView2 = unifiedBannerView;
            this.f1015h.g();
            if (unifiedBannerView2.getParent() != null) {
                ((ViewGroup) unifiedBannerView2.getParent()).removeView(unifiedBannerView2);
            }
            this.n.put(unifiedBannerView2, str);
            viewGroup.removeAllViews();
            int width = viewGroup.getWidth();
            viewGroup.addView(unifiedBannerView2, new ViewGroup.LayoutParams(width, Math.round(width / 6.4f)));
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
                b(0, "Not Activity");
                return;
            }
            UnifiedBannerView unifiedBannerView = new UnifiedBannerView((Activity) context, this.f1016i.f1361c, new a(this, r0, funAdSlot));
            unifiedBannerView.setRefresh(0);
            unifiedBannerView.loadAD();
            UnifiedBannerView[] unifiedBannerViewArr = {unifiedBannerView};
            g();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(UnifiedBannerView unifiedBannerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, unifiedBannerView) == null) {
            UnifiedBannerView unifiedBannerView2 = unifiedBannerView;
            this.n.remove(unifiedBannerView2);
            if (unifiedBannerView2 != null) {
                unifiedBannerView2.destroy();
            }
        }
    }
}
