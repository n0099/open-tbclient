package c.a.r0.z0;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.y0.a;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.CsjPrivacySwitch;
import com.baidu.tbadk.switchs.GdtPrivacySwitch;
import com.baidu.tbadk.switchs.KsPrivacySwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTLocation;
import com.fun.ad.sdk.FunAdCallback;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.FunSplashAdInteractionListener;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements a.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public p f29413a;

    /* renamed from: b  reason: collision with root package name */
    public final FunAdCallback f29414b;

    /* loaded from: classes4.dex */
    public class a implements a.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f29415a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f29416b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f29417c;

        public a(c cVar, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, activity, funAdSlot, funAdLoadListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29415a = activity;
            this.f29416b = funAdSlot;
            this.f29417c = funAdLoadListener;
        }

        @Override // c.a.r0.y0.a.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    FunAdSdk.getAdFactory().loadAd(this.f29415a, this.f29416b, this.f29417c);
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.i f29418a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.g f29419b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f29420c;

        public b(c cVar, a.i iVar, a.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, iVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29420c = cVar;
            this.f29418a = iVar;
            this.f29419b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) || (iVar = this.f29418a) == null) {
                return;
            }
            iVar.onAdClicked(str, str2, str3);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (iVar = this.f29418a) == null) {
                return;
            }
            iVar.onAdClose(str);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                a.i iVar = this.f29418a;
                if (iVar != null) {
                    iVar.onAdError(str);
                }
                this.f29420c.v("advert_show", str, 0, this.f29419b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                a.i iVar = this.f29418a;
                if (iVar != null) {
                    iVar.onAdShow(str, str2, str3);
                }
                this.f29420c.v("advert_show", str, 1, this.f29419b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (iVar = this.f29418a) == null) {
                return;
            }
            iVar.onRewardedVideo(str);
        }
    }

    /* renamed from: c.a.r0.z0.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1374c implements a.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunNativeAd f29421a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f29422b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f29423c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f29424d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f29425e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f29426f;

        public C1374c(c cVar, FunNativeAd funNativeAd, Activity activity, ViewGroup viewGroup, List list, List list2, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, funNativeAd, activity, viewGroup, list, list2, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29421a = funNativeAd;
            this.f29422b = activity;
            this.f29423c = viewGroup;
            this.f29424d = list;
            this.f29425e = list2;
            this.f29426f = funAdInteractionListener;
        }

        @Override // c.a.r0.y0.a.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29421a.show(this.f29422b, this.f29423c, this.f29424d, this.f29425e, this.f29426f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.i f29427a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.g f29428b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f29429c;

        public d(c cVar, a.i iVar, a.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, iVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29429c = cVar;
            this.f29427a = iVar;
            this.f29428b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) || (iVar = this.f29427a) == null) {
                return;
            }
            iVar.onAdClicked(str, str2, str3);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (iVar = this.f29427a) == null) {
                return;
            }
            iVar.onAdClose(str);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                a.i iVar = this.f29427a;
                if (iVar != null) {
                    iVar.onAdError(str);
                }
                this.f29429c.v("advert_show", str, 0, this.f29428b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                a.i iVar = this.f29427a;
                if (iVar != null) {
                    iVar.onAdShow(str, str2, str3);
                }
                if (this.f29429c.f29413a != null) {
                    this.f29429c.f29413a.f29455b = str;
                    this.f29429c.f29413a.f29456c = str2;
                }
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    String str4 = "BEAR ad sspType=" + str2 + ", sid=" + str + " ,pid=" + str3;
                }
                this.f29429c.v("advert_show", str, 1, this.f29428b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (iVar = this.f29427a) == null) {
                return;
            }
            iVar.onRewardedVideo(str);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f29430a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f29431b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f29432c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f29433d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f29434e;

        public e(c cVar, Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, activity, viewGroup, str, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29434e = cVar;
            this.f29430a = activity;
            this.f29431b = viewGroup;
            this.f29432c = str;
            this.f29433d = funAdInteractionListener;
        }

        @Override // c.a.r0.y0.a.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunSplashAd showSplash = FunAdSdk.getAdFactory().showSplash(this.f29430a, this.f29431b, this.f29432c, this.f29433d);
                if (showSplash != null) {
                    this.f29434e.f29413a = new p();
                    this.f29434e.f29413a.f29454a = showSplash;
                }
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    String str = "BEAR ad showSplash:" + this.f29434e.f29413a;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements FunSplashAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f29435a;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29435a = cVar;
        }

        @Override // com.fun.ad.sdk.FunSplashAdInteractionListener
        public void onAdClicked(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f29435a.t(CommonStatisticKey.KEY_EYE_SPLASH_BEAR_CLICK);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements FunAdCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdClose(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdLoad(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdLoadError(String str, String str2, String str3, int i2, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, Integer.valueOf(i2), str4}) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW_ERROR).param("obj_locate", i2).param("obj_source", str).param("obj_param1", str4).param(TiebaStatic.Params.OBJ_PARAM2, str2).param(TiebaStatic.Params.OBJ_PARAM3, str3));
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdLoaded(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdShowError(String str, String str2, String str3, int i2, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, Integer.valueOf(i2), str4}) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onRewardedVideo(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends TTCustomController {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean alist() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? CsjPrivacySwitch.isOpen() : invokeV.booleanValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getDevImei() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TbadkCoreApplication.getInst().getImei() : (String) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public TTLocation getTTLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new TTLocation(c.a.e.e.m.b.c(TbadkCoreApplication.getInst().getLocationLng(), 0.0d), c.a.e.e.m.b.c(TbadkCoreApplication.getInst().getLocationLat(), 0.0d)) : (TTLocation) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? CsjPrivacySwitch.isOpen() : invokeV.booleanValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUsePhoneState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? CsjPrivacySwitch.isOpen() : invokeV.booleanValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWifiState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? CsjPrivacySwitch.isOpen() : invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class i implements FunAdSdk.SdkInitializeCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.l f29436a;

        public i(c cVar, a.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29436a = lVar;
        }

        @Override // com.fun.ad.sdk.FunAdSdk.SdkInitializeCallback
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GlobalSetting.setAgreePrivacyStrategy(GdtPrivacySwitch.isOpen());
                a.l lVar = this.f29436a;
                if (lVar != null) {
                    lVar.a();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements FunAdLoadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.h f29437a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.g f29438b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f29439c;

        public j(c cVar, a.h hVar, a.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, hVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29439c = cVar;
            this.f29437a = hVar;
            this.f29438b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                a.h hVar = this.f29437a;
                if (hVar != null) {
                    hVar.a(str, 0);
                }
                this.f29439c.v("advert_load", str, 1, this.f29438b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                a.h hVar = this.f29437a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                this.f29439c.v("advert_load", str, 0, this.f29438b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements a.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f29440a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f29441b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f29442c;

        public k(c cVar, Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context, funAdSlot, funAdLoadListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29440a = context;
            this.f29441b = funAdSlot;
            this.f29442c = funAdLoadListener;
        }

        @Override // c.a.r0.y0.a.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().loadAd(this.f29440a, this.f29441b, this.f29442c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.i f29443a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.g f29444b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f29445c;

        public l(c cVar, a.i iVar, a.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, iVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29445c = cVar;
            this.f29443a = iVar;
            this.f29444b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) || (iVar = this.f29443a) == null) {
                return;
            }
            iVar.onAdClicked(str, str2, str3);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (iVar = this.f29443a) == null) {
                return;
            }
            iVar.onAdClose(str);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                a.i iVar = this.f29443a;
                if (iVar != null) {
                    iVar.onAdError(str);
                }
                this.f29445c.v("advert_show", str, 0, this.f29444b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                a.i iVar = this.f29443a;
                if (iVar != null) {
                    iVar.onAdShow(str, str2, str3);
                }
                this.f29445c.v("advert_show", str, 1, this.f29444b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (iVar = this.f29443a) == null) {
                return;
            }
            iVar.onRewardedVideo(str);
        }
    }

    /* loaded from: classes4.dex */
    public class m implements a.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f29446a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f29447b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f29448c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f29449d;

        public m(c cVar, Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, activity, viewGroup, str, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29446a = activity;
            this.f29447b = viewGroup;
            this.f29448c = str;
            this.f29449d = funAdInteractionListener;
        }

        @Override // c.a.r0.y0.a.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().showAd(this.f29446a, this.f29447b, this.f29448c, this.f29449d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements a.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f29450a;

        public n(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29450a = str;
        }

        @Override // c.a.r0.y0.a.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().destroyAd(this.f29450a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements FunAdLoadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.h f29451a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.g f29452b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f29453c;

        public o(c cVar, a.h hVar, a.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, hVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29453c = cVar;
            this.f29451a = hVar;
            this.f29452b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                a.h hVar = this.f29451a;
                if (hVar != null) {
                    hVar.a(str, 0);
                }
                this.f29453c.v("advert_load", str, 1, this.f29452b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                a.h hVar = this.f29451a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                this.f29453c.v("advert_load", str, 0, this.f29452b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public FunSplashAd f29454a;

        /* renamed from: b  reason: collision with root package name */
        public String f29455b;

        /* renamed from: c  reason: collision with root package name */
        public String f29456c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f29457d;

        public p() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29455b = null;
            this.f29456c = "cjs";
            this.f29457d = false;
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29414b = new g(this);
    }

    @Override // c.a.r0.y0.a.f
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            destroyAd(str);
        }
    }

    @Override // c.a.r0.y0.a.f
    public void b(ImageView imageView, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView, obj) == null) && (obj instanceof FunNativeAd) && imageView != null) {
            c.a.r0.z0.b.B(imageView, (FunNativeAd) obj);
        }
    }

    @Override // c.a.r0.y0.a.f
    public void c(Activity activity, @NonNull Object obj, a.i iVar, ViewGroup viewGroup, List<View> list, List<View> list2, a.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, obj, iVar, viewGroup, list, list2, gVar}) == null) && !activity.isDestroyed() && (obj instanceof FunNativeAd)) {
            u(new C1374c(this, (FunNativeAd) obj, activity, viewGroup, list, list2, new b(this, iVar, gVar)));
        }
    }

    @Override // c.a.r0.y0.a.f
    public ViewGroup d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? new NativeAdContainer(context) : (ViewGroup) invokeL.objValue;
    }

    @Override // c.a.r0.y0.a.f
    public void destroyAd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            u(new n(this, str));
        }
    }

    @Override // c.a.r0.y0.a.f
    public View e(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof FunNativeAd) {
                FunNativeAd funNativeAd = (FunNativeAd) obj;
                c.a.r0.z0.b.t(funNativeAd);
                c.a.r0.z0.b.u(funNativeAd);
                return funNativeAd.getVideoView();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Override // c.a.r0.y0.a.f
    public boolean f(Activity activity) {
        InterceptResult invokeL;
        FunSplashAd funSplashAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, activity)) == null) {
            p pVar = this.f29413a;
            if (pVar == null || (funSplashAd = pVar.f29454a) == null || pVar.f29457d) {
                return false;
            }
            boolean showMiniWindow = funSplashAd.showMiniWindow(activity, false, new f(this));
            if (TbadkCoreApplication.getInst().isDebugMode()) {
                String str = "BEAR ad showMiniWindow: " + this.f29413a + ", isSucceed=" + showMiniWindow;
            }
            if (showMiniWindow) {
                this.f29413a.f29457d = true;
                t(CommonStatisticKey.KEY_EYE_SPLASH_BEAR_SHOW);
            }
            return showMiniWindow;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.y0.a.f
    public void g(Activity activity, String str, ViewGroup viewGroup, a.i iVar, a.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048583, this, activity, str, viewGroup, iVar, gVar) == null) || viewGroup == null) {
            return;
        }
        u(new e(this, activity, viewGroup, str, new d(this, iVar, gVar)));
    }

    @Override // c.a.r0.y0.a.f
    public boolean h(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj instanceof FunNativeAd) {
                return c.a.r0.z0.b.C((FunNativeAd) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.y0.a.f
    public Object i(@NonNull Activity activity, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, activity, str)) == null) {
            u(null);
            return FunAdSdk.getAdFactory().getNativeAd(activity, str);
        }
        return invokeLL.objValue;
    }

    @Override // c.a.r0.y0.a.f
    public boolean isAdReady(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            u(null);
            return FunAdSdk.getAdFactory().isAdReady(str);
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.y0.a.f
    public void j(Context context, String str, a.h hVar, a.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, context, str, hVar, gVar) == null) {
            u(new k(this, context, new FunAdSlot.Builder().setSid(str).setExpressWidth(c.a.e.e.p.l.k(context)).build(), new j(this, hVar, gVar)));
        }
    }

    @Override // c.a.r0.y0.a.f
    public void k(Object obj, a.j jVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, obj, jVar) == null) && (obj instanceof FunNativeAd)) {
            FunNativeAd funNativeAd = (FunNativeAd) obj;
            c.a.r0.z0.b.A(funNativeAd, c.a.r0.z0.b.i(funNativeAd), jVar);
        }
    }

    @Override // c.a.r0.y0.a.f
    public synchronized void l(Application application, a.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, application, lVar) == null) {
            synchronized (this) {
                if (FunAdSdk.isSdkInitializeComplete()) {
                    if (lVar != null) {
                        lVar.a();
                    }
                    return;
                }
                HashSet hashSet = new HashSet();
                if (c.a.q0.s.d0.b.j().k("key_fun_cjs_init", 1) == 0) {
                    hashSet.add(FunAdSdk.PLATFORM_CSJ);
                }
                if (c.a.q0.s.d0.b.j().k("key_fun_gdt_init", 1) == 0) {
                    hashSet.add(FunAdSdk.PLATFORM_GDT);
                }
                if (c.a.q0.s.d0.b.j().k("key_fun_ks_init", 1) == 0) {
                    hashSet.add(FunAdSdk.PLATFORM_KS);
                }
                FunAdSdk.init(new FunAdConfig.Builder(application).setAppName(application.getString(R.string.app_name)).setAppId("b122ce58b8954c27b6882f7987c08860").setUserId("").setUseTextureView(true).setTitleBarTheme(1).setVideoSoundEnable(false).setVideoDataFlowAutoStart(false).setSspTypeBlacklist(hashSet).setLogEnabled(TbadkCoreApplication.getInst().isDebugMode()).setTTCustomController(new h(this)).setKsCanReadICCID(KsPrivacySwitch.isOpen()).setKsCanReadNearbyWifiList(KsPrivacySwitch.isOpen()).setKsCanReadMacAddress(KsPrivacySwitch.isOpen()).build(), this.f29414b, new i(this, lVar));
            }
        }
    }

    @Override // c.a.r0.y0.a.f
    public void m(Activity activity, String str, a.h hVar, a.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, activity, str, hVar, gVar) == null) {
            u(new a(this, activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(c.a.e.e.p.l.k(activity)).build(), new o(this, hVar, gVar)));
        }
    }

    @Override // c.a.r0.y0.a.f
    public void n(Activity activity, String str, ViewGroup viewGroup, a.i iVar, a.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048591, this, activity, str, viewGroup, iVar, gVar) == null) || viewGroup == null) {
            return;
        }
        u(new m(this, activity, viewGroup, str, new l(this, iVar, gVar)));
    }

    @Override // c.a.r0.y0.a.f
    public c.a.r0.y3.g o(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) {
            c.a.r0.y3.g gVar = null;
            if (obj instanceof FunNativeAd) {
                FunNativeAd funNativeAd = (FunNativeAd) obj;
                int i2 = c.a.r0.z0.b.i(funNativeAd);
                if (i2 == -1) {
                    return null;
                }
                gVar = new c.a.r0.y3.g();
                String c2 = c.a.r0.z0.b.c(funNativeAd, i2);
                if (c.a.e.e.p.k.isEmpty(c2)) {
                    c2 = "推广";
                }
                gVar.k(c2);
                gVar.l(c.a.r0.z0.b.l(funNativeAd, i2));
                gVar.j(c.a.r0.z0.b.g(funNativeAd, i2));
                gVar.g(c.a.r0.z0.b.d(funNativeAd));
                gVar.h(c.a.r0.z0.b.b(funNativeAd));
                gVar.i(i2);
            }
            return gVar;
        }
        return (c.a.r0.y3.g) invokeL.objValue;
    }

    @Override // c.a.r0.y0.a.f
    public void removeMiniWindow() {
        FunSplashAd funSplashAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            p pVar = this.f29413a;
            if (pVar != null && (funSplashAd = pVar.f29454a) != null) {
                funSplashAd.removeMiniWindow();
            }
            this.f29413a = null;
        }
    }

    public final void t(String str) {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (pVar = this.f29413a) == null || TextUtils.isEmpty(pVar.f29455b) || str == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(str).param("obj_source", 6).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_PARAM2, this.f29413a.f29455b).param(TiebaStatic.Params.OBJ_TO, this.f29413a.f29456c));
    }

    public final void u(a.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, lVar) == null) {
            l(TbadkCoreApplication.getInst(), lVar);
        }
    }

    public final void v(String str, String str2, int i2, a.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048596, this, str, str2, i2, gVar) == null) {
            c.a.e.e.n.a a2 = c.a.q0.q0.j.a();
            a2.b("type", "bear");
            a2.b("locate", gVar.f28507a);
            a2.b(SetImageWatermarkTypeReqMsg.SWITCH, gVar.f28508b);
            a2.b("sid", str2);
            a2.c("isSuccess", Integer.valueOf(i2));
            BdStatisticsManager.getInstance().debug(str, a2);
        }
    }
}
