package a.a.a.a.r.a.e;

import a.a.a.a.s.h;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.R;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends a.a.a.a.b<KsNativeAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a.a.a.a.k<KsNativeAd, KsNativeAd.AdInteractionListener> n;

    /* loaded from: classes.dex */
    public class a implements KsLoadManager.NativeAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1270a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f1271b;

        public a(g gVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1271b = gVar;
            this.f1270a = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                a.a.a.a.v.d.b("onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f1271b.f1015h.a(Integer.valueOf(i2));
                this.f1271b.b(i2, str);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                a.a.a.a.v.d.a();
                if (list != null && !list.isEmpty()) {
                    this.f1271b.f1015h.b();
                    for (KsNativeAd ksNativeAd : list) {
                        this.f1271b.l.b(ksNativeAd, this.f1270a.getSid());
                    }
                    this.f1271b.a((List) list);
                    return;
                }
                a.a.a.a.v.d.b("error: adList is null or empty", new Object[0]);
                this.f1271b.f1015h.a("NoFill");
                this.f1271b.b(0, "NoFill");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h.a aVar) {
        super(aVar, true, true);
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
        this.n = new a.a.a.a.k<>(this);
    }

    @Override // a.a.a.a.b
    public a.a.a.a.u.a a(h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? new a.a.a.a.u.m(aVar) : (a.a.a.a.u.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public FunNativeAd a(Context context, String str, KsNativeAd ksNativeAd) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, ksNativeAd)) == null) ? new a.a.a.a.r.b.d.a(context, ksNativeAd, str, this.f1016i, this) : (FunNativeAd) invokeLLL.objValue;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, funAdSlot) == null) {
            KsScene build = new KsScene.Builder(Long.parseLong(this.f1016i.f1361c)).adNum(funAdSlot.getAdCount() <= 0 ? 1 : funAdSlot.getAdCount()).build();
            this.f1015h.a(funAdSlot, this.f1016i);
            KsAdSDK.getLoadManager().loadNativeAd(build, new a(this, funAdSlot));
            g();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(KsNativeAd ksNativeAd) {
        KsNativeAd ksNativeAd2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, ksNativeAd) == null) || (ksNativeAd2 = ksNativeAd) == null) {
            return;
        }
        this.n.a(ksNativeAd2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    @Override // a.a.a.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(Activity activity, ViewGroup viewGroup, String str, KsNativeAd ksNativeAd) {
        InterceptResult invokeLLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, activity, viewGroup, str, ksNativeAd)) != null) {
            return invokeLLLL.booleanValue;
        }
        KsNativeAd ksNativeAd2 = ksNativeAd;
        this.f1015h.g();
        int materialType = ksNativeAd2.getMaterialType();
        if (materialType != 0) {
            if (materialType == 1) {
                int interactionType = ksNativeAd2.getInteractionType();
                if (interactionType == 1) {
                    i2 = R.layout.ks_ad_native_video_app_download_view;
                } else if (interactionType == 2) {
                    i2 = R.layout.ks_ad_native_video_h5_open_view;
                }
            } else if (materialType == 2) {
                int interactionType2 = ksNativeAd2.getInteractionType();
                if (interactionType2 == 1) {
                    i2 = R.layout.ks_ad_native_single_img_app_download_view;
                } else if (interactionType2 == 2) {
                    i2 = R.layout.ks_ad_native_single_img_h5_open_view;
                }
            } else if (materialType != 3) {
                return false;
            } else {
                int interactionType3 = ksNativeAd2.getInteractionType();
                if (interactionType3 == 1) {
                    i2 = R.layout.ks_ad_native_group_img_app_download_view;
                } else if (interactionType3 == 2) {
                    i2 = R.layout.ks_ad_native_group_img_h5_open_view;
                }
            }
            if (i2 != 0) {
                return false;
            }
            a.a.a.a.r.b.d.c cVar = (a.a.a.a.r.b.d.c) LayoutInflater.from(activity).inflate(i2, viewGroup, false);
            viewGroup.removeAllViews();
            viewGroup.addView(cVar);
            cVar.a(activity, ksNativeAd2, new h(this, ksNativeAd2, str));
            return true;
        }
        i2 = 0;
        if (i2 != 0) {
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, java.lang.String, com.fun.ad.sdk.FunNativeAdInflater, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, KsNativeAd ksNativeAd) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, activity, str, funNativeAdInflater, ksNativeAd)) == null) {
            KsNativeAd ksNativeAd2 = ksNativeAd;
            this.f1015h.g();
            ViewGroup adContainer = funNativeAdInflater.getAdContainer(new a.a.a.a.r.b.d.a(activity, ksNativeAd2, str, this.f1016i, this));
            List<View> clickViews = funNativeAdInflater.getClickViews();
            if (clickViews == null) {
                clickViews = new ArrayList<>();
            }
            ksNativeAd2.registerViewForInteraction(adContainer, clickViews, new h(this, ksNativeAd2, str));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
