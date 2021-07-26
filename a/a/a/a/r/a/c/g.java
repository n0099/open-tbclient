package a.a.a.a.r.a.c;

import a.a.a.a.q;
import a.a.a.a.s.h;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.R;
import com.fun.ad.sdk.channel.model.gdt.GDTNativeUnifiedVideoView;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends a.a.a.a.b<NativeUnifiedADData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a.a.a.a.k<NativeUnifiedADData, NativeADEventListener> n;

    /* loaded from: classes.dex */
    public class a implements NativeADUnifiedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1186a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f1187b;

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
            this.f1187b = gVar;
            this.f1186a = funAdSlot;
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                a.a.a.a.v.d.a();
                if (list != null && !list.isEmpty()) {
                    this.f1187b.f1015h.b();
                    for (NativeUnifiedADData nativeUnifiedADData : list) {
                        this.f1187b.l.b(nativeUnifiedADData, this.f1186a.getSid());
                    }
                    this.f1187b.a((List) list);
                    return;
                }
                a.a.a.a.v.d.b("onADLoaded error: adList is null or empty", new Object[0]);
                this.f1187b.f1015h.a("NoFill");
                this.f1187b.b(0, "NoFill");
            }
        }

        @Override // com.qq.e.ads.AbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adError) == null) {
                a.a.a.a.v.d.b("onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
                this.f1187b.f1015h.a(Integer.valueOf(adError.getErrorCode()));
                this.f1187b.b(adError.getErrorCode(), adError.getErrorMsg());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements NativeADMediaListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoError(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adError) == null) {
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoInit() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoaded(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoading() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements NativeADEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final NativeUnifiedADData f1188a;

        /* renamed from: b  reason: collision with root package name */
        public final String f1189b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1190c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1191d;

        /* renamed from: e  reason: collision with root package name */
        public d f1192e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f1193f;

        public c(g gVar, NativeUnifiedADData nativeUnifiedADData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, nativeUnifiedADData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1193f = gVar;
            this.f1188a = nativeUnifiedADData;
            this.f1189b = str;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.a.a.a.v.d.a();
                this.f1193f.f1015h.a(this.f1191d);
                this.f1191d = true;
                this.f1193f.e();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adError) == null) {
                a.a.a.a.v.d.a();
                this.f1193f.f1015h.b(Integer.valueOf(adError.getErrorCode()));
                this.f1193f.a(adError.getErrorCode(), adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                a.a.a.a.v.d.a();
                this.f1193f.f1015h.b(this.f1190c);
                this.f1190c = true;
                this.f1193f.a((g) this.f1188a, this.f1189b);
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                a.a.a.a.v.d.a();
                d dVar = this.f1192e;
                if (dVar != null) {
                    dVar.onADStatusChanged();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void onADStatusChanged();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? new a.a.a.a.u.h(aVar) : (a.a.a.a.u.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public FunNativeAd a(Context context, String str, NativeUnifiedADData nativeUnifiedADData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, nativeUnifiedADData)) == null) {
            NativeUnifiedADData nativeUnifiedADData2 = nativeUnifiedADData;
            return new a.a.a.a.r.b.b.a(nativeUnifiedADData2, nativeUnifiedADData2.getAdPatternType() == 2 ? new MediaView(context) : null, str, this.f1016i, this);
        }
        return (FunNativeAd) invokeLLL.objValue;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, funAdSlot) == null) {
            a aVar = new a(this, funAdSlot);
            this.f1015h.a(funAdSlot, this.f1016i);
            NativeUnifiedAD nativeUnifiedAD = new NativeUnifiedAD(context.getApplicationContext(), this.f1016i.f1361c, aVar);
            nativeUnifiedAD.setMinVideoDuration(0);
            nativeUnifiedAD.setMaxVideoDuration(0);
            nativeUnifiedAD.setVideoPlayPolicy(1);
            nativeUnifiedAD.setVideoADContainerRender(1);
            nativeUnifiedAD.loadData(q.a(funAdSlot.getAdCount(), 1, 10));
            g();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(NativeUnifiedADData nativeUnifiedADData) {
        NativeUnifiedADData nativeUnifiedADData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, nativeUnifiedADData) == null) || (nativeUnifiedADData2 = nativeUnifiedADData) == null) {
            return;
        }
        nativeUnifiedADData2.destroy();
        this.n.a(nativeUnifiedADData2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, NativeUnifiedADData nativeUnifiedADData) {
        InterceptResult invokeLLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, activity, viewGroup, str, nativeUnifiedADData)) == null) {
            NativeUnifiedADData nativeUnifiedADData2 = nativeUnifiedADData;
            int adPatternType = nativeUnifiedADData2.getAdPatternType();
            if (adPatternType == 1) {
                i2 = R.layout.gdt_ad_native_unified_img2_view;
            } else if (adPatternType != 2) {
                if (adPatternType != 3) {
                    if (adPatternType != 4) {
                        return false;
                    }
                } else if (nativeUnifiedADData2.getImgList().size() == 3) {
                    i2 = R.layout.gdt_ad_native_unified_img3_view;
                }
                i2 = R.layout.gdt_ad_native_unified_img_view;
            } else {
                i2 = R.layout.gdt_ad_native_unified_video_view;
            }
            this.f1015h.g();
            a.a.a.a.r.b.b.b bVar = (a.a.a.a.r.b.b.b) LayoutInflater.from(activity).inflate(i2, viewGroup, false);
            if (bVar instanceof GDTNativeUnifiedVideoView) {
                ((GDTNativeUnifiedVideoView) bVar).setVideoOnClickListener(new h(this));
            }
            viewGroup.removeAllViews();
            viewGroup.addView(bVar);
            i iVar = new i(this, bVar, nativeUnifiedADData2);
            c cVar = new c(this, nativeUnifiedADData2, str);
            cVar.f1192e = iVar;
            nativeUnifiedADData2.setNativeAdEventListener(cVar);
            bVar.a(activity, nativeUnifiedADData2);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, java.lang.String, com.fun.ad.sdk.FunNativeAdInflater, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, NativeUnifiedADData nativeUnifiedADData) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, activity, str, funNativeAdInflater, nativeUnifiedADData)) == null) {
            NativeUnifiedADData nativeUnifiedADData2 = nativeUnifiedADData;
            MediaView mediaView = nativeUnifiedADData2.getAdPatternType() == 2 ? new MediaView(activity) : null;
            a.a.a.a.r.b.b.a aVar = new a.a.a.a.r.b.b.a(nativeUnifiedADData2, mediaView, str, this.f1016i, this);
            NativeAdContainer gdtAdContainer = funNativeAdInflater.getGdtAdContainer(aVar);
            List<View> clickViews = funNativeAdInflater.getClickViews();
            if (clickViews == null) {
                clickViews = new ArrayList<>();
            }
            j jVar = new j(this, aVar, nativeUnifiedADData2);
            c cVar = new c(this, nativeUnifiedADData2, str);
            cVar.f1192e = jVar;
            nativeUnifiedADData2.setNativeAdEventListener(cVar);
            nativeUnifiedADData2.bindAdToView(gdtAdContainer.getContext(), gdtAdContainer, null, clickViews);
            if (mediaView != null) {
                nativeUnifiedADData2.bindMediaView(mediaView, new VideoOption.Builder().setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? 1 : 0).setAutoPlayMuted(!FunAdSdk.getFunAdConfig().isVideoSoundEnable).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build(), new b());
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
