package b.a.a.a.t.a.c;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
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
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends g<TTNativeAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b.a.a.a.l<TTNativeAd, TTNativeAd.AdInteractionListener> p;

    /* loaded from: classes.dex */
    public class a implements TTAdNative.NativeAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1160a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f1161b;

        public a(d dVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1161b = dVar;
            this.f1160a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener, com.bytedance.sdk.openadsdk.c.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                b.a.a.a.x.d.f("onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f1161b.f1057h.e(Integer.valueOf(i2));
                this.f1161b.n(i2, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
        public void onNativeAdLoad(List<TTNativeAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                b.a.a.a.x.d.b("onNativeAdLoad", new Object[0]);
                if (list != null && !list.isEmpty()) {
                    this.f1161b.f1057h.h();
                    for (TTNativeAd tTNativeAd : list) {
                        this.f1161b.m.c(tTNativeAd, this.f1160a.getSid());
                    }
                    this.f1161b.j(list);
                    return;
                }
                b.a.a.a.x.d.f("onNativeAdLoad error: list is null or empty", new Object[0]);
                this.f1161b.f1057h.e("NoFill");
                onError(0, "NoFill");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(h.a aVar) {
        super(aVar, true);
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
        this.p = new b.a.a.a.l<>(this);
    }

    @Override // b.a.a.a.c
    public FunNativeAd f(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, obj)) == null) ? new b.a.a.a.t.b.a.b((TTNativeAd) obj, str, this.f1058i, this) : (FunNativeAd) invokeLLL.objValue;
    }

    @Override // b.a.a.a.c
    public boolean l(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, activity, str, funNativeAdInflater, obj)) == null) {
            TTNativeAd tTNativeAd = (TTNativeAd) obj;
            this.f1057h.p();
            ViewGroup adContainer = funNativeAdInflater.getAdContainer(new b.a.a.a.t.b.a.b(tTNativeAd, str, this.f1058i, this));
            List<View> clickViews = funNativeAdInflater.getClickViews();
            if (clickViews == null) {
                clickViews = new ArrayList<>();
            }
            List<View> creativeViews = funNativeAdInflater.getCreativeViews();
            if (creativeViews == null) {
                creativeViews = new ArrayList<>();
            }
            tTNativeAd.setActivityForDownloadApp(activity);
            tTNativeAd.registerViewForInteraction(adContainer, clickViews, creativeViews, new e(this, tTNativeAd, str));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // b.a.a.a.c
    public void o(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, funAdSlot) == null) {
            if (this.o == null) {
                this.o = TTAdSdk.getAdManager().createAdNative(context);
            }
            this.f1057h.d(funAdSlot, this.f1058i);
            w(funAdSlot);
            t();
        }
    }

    @Override // b.a.a.a.c
    public void p(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            this.p.a((TTNativeAd) obj);
        }
    }

    public void w(FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, funAdSlot) == null) {
            AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.f1058i.f1448c).setSupportDeepLink(true);
            h.a aVar = this.f1058i;
            this.o.loadNativeAd(supportDeepLink.setImageAcceptedSize(aVar.f1452g, aVar.f1453h).setNativeAdType(1).setAdCount(b.a.a.a.r.b(funAdSlot.getAdCount(), 1, 3)).build(), new a(this, funAdSlot));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.a.a.c
    /* renamed from: x */
    public boolean k(Activity activity, ViewGroup viewGroup, String str, TTNativeAd tTNativeAd) {
        InterceptResult invokeLLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, activity, viewGroup, str, tTNativeAd)) == null) {
            this.f1057h.p();
            int imageMode = tTNativeAd.getImageMode();
            if (imageMode == 15) {
                i2 = R.layout.csj_ad_native_vertical_video_view;
            } else if (imageMode == 16) {
                i2 = R.layout.csj_ad_native_vertical_img_view;
            } else if (imageMode == 2) {
                i2 = R.layout.csj_ad_native_small_img_view;
            } else if (imageMode == 3) {
                i2 = R.layout.csj_ad_native_large_img_view;
            } else if (imageMode == 4) {
                i2 = R.layout.csj_ad_native_group_img_view;
            } else if (imageMode != 5) {
                return false;
            } else {
                i2 = R.layout.csj_ad_native_large_video_view;
            }
            a.a.a.a.s.b.a.b bVar = (a.a.a.a.s.b.a.b) LayoutInflater.from(activity).inflate(i2, viewGroup, false);
            viewGroup.removeAllViews();
            viewGroup.addView(bVar);
            tTNativeAd.setActivityForDownloadApp(activity);
            bVar.a(activity, tTNativeAd, new e(this, tTNativeAd, str));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
