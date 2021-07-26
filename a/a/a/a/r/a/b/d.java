package a.a.a.a.r.a.b;

import a.a.a.a.s.h;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
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
    public final a.a.a.a.k<TTNativeAd, TTNativeAd.AdInteractionListener> o;

    /* loaded from: classes.dex */
    public class a implements TTAdNative.NativeAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1104a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f1105b;

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
            this.f1105b = dVar;
            this.f1104a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener, com.bytedance.sdk.openadsdk.c.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                a.a.a.a.v.d.b("onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f1105b.f1015h.a(Integer.valueOf(i2));
                this.f1105b.b(i2, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
        public void onNativeAdLoad(List<TTNativeAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                a.a.a.a.v.d.a("onNativeAdLoad", new Object[0]);
                if (list != null && !list.isEmpty()) {
                    this.f1105b.f1015h.b();
                    for (TTNativeAd tTNativeAd : list) {
                        this.f1105b.l.b(tTNativeAd, this.f1104a.getSid());
                    }
                    this.f1105b.a((List) list);
                    return;
                }
                a.a.a.a.v.d.b("onNativeAdLoad error: list is null or empty", new Object[0]);
                this.f1105b.f1015h.a("NoFill");
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
        this.o = new a.a.a.a.k<>(this);
    }

    @Override // a.a.a.a.b
    public FunNativeAd a(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, obj)) == null) ? new a.a.a.a.r.b.a.c((TTNativeAd) obj, str, this.f1016i, this) : (FunNativeAd) invokeLLL.objValue;
    }

    public void a(FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funAdSlot) == null) {
            AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.f1016i.f1361c).setSupportDeepLink(true);
            h.a aVar = this.f1016i;
            this.n.loadNativeAd(supportDeepLink.setImageAcceptedSize(aVar.f1365g, aVar.f1366h).setNativeAdType(1).setAdCount(a.a.a.a.q.a(funAdSlot.getAdCount(), 1, 3)).build(), new a(this, funAdSlot));
        }
    }

    @Override // a.a.a.a.b
    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            this.o.a((TTNativeAd) obj);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, TTNativeAd tTNativeAd) {
        InterceptResult invokeLLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, activity, viewGroup, str, tTNativeAd)) == null) {
            this.f1015h.g();
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
            a.a.a.a.r.b.a.b bVar = (a.a.a.a.r.b.a.b) LayoutInflater.from(activity).inflate(i2, viewGroup, false);
            viewGroup.removeAllViews();
            viewGroup.addView(bVar);
            tTNativeAd.setActivityForDownloadApp(activity);
            bVar.a(activity, tTNativeAd, new e(this, tTNativeAd, str));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, funAdSlot) == null) {
            if (this.n == null) {
                this.n = TTAdSdk.getAdManager().createAdNative(context);
            }
            this.f1015h.a(funAdSlot, this.f1016i);
            a(funAdSlot);
            g();
        }
    }

    @Override // a.a.a.a.b
    public boolean a(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, activity, str, funNativeAdInflater, obj)) == null) {
            TTNativeAd tTNativeAd = (TTNativeAd) obj;
            this.f1015h.g();
            ViewGroup adContainer = funNativeAdInflater.getAdContainer(new a.a.a.a.r.b.a.c(tTNativeAd, str, this.f1016i, this));
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
}
