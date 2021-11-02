package b.a.r0.z0;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.y0.a;
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
import java.util.List;
/* loaded from: classes6.dex */
public class c implements a.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public p f27829a;

    /* renamed from: b  reason: collision with root package name */
    public final FunAdCallback f27830b;

    /* loaded from: classes6.dex */
    public class a implements a.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f27831a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f27832b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f27833c;

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
            this.f27831a = activity;
            this.f27832b = funAdSlot;
            this.f27833c = funAdLoadListener;
        }

        @Override // b.a.r0.y0.a.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    FunAdSdk.getAdFactory().loadAd(this.f27831a, this.f27832b, this.f27833c);
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.i f27834a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.g f27835b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f27836c;

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
            this.f27836c = cVar;
            this.f27834a = iVar;
            this.f27835b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) || (iVar = this.f27834a) == null) {
                return;
            }
            iVar.onAdClicked(str, str2, str3);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (iVar = this.f27834a) == null) {
                return;
            }
            iVar.onAdClose(str);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                a.i iVar = this.f27834a;
                if (iVar != null) {
                    iVar.onAdError(str);
                }
                this.f27836c.v("advert_show", str, 0, this.f27835b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                a.i iVar = this.f27834a;
                if (iVar != null) {
                    iVar.onAdShow(str, str2, str3);
                }
                this.f27836c.v("advert_show", str, 1, this.f27835b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (iVar = this.f27834a) == null) {
                return;
            }
            iVar.onRewardedVideo(str);
        }
    }

    /* renamed from: b.a.r0.z0.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1360c implements a.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunNativeAd f27837a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f27838b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f27839c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f27840d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f27841e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f27842f;

        public C1360c(c cVar, FunNativeAd funNativeAd, Activity activity, ViewGroup viewGroup, List list, List list2, FunAdInteractionListener funAdInteractionListener) {
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
            this.f27837a = funNativeAd;
            this.f27838b = activity;
            this.f27839c = viewGroup;
            this.f27840d = list;
            this.f27841e = list2;
            this.f27842f = funAdInteractionListener;
        }

        @Override // b.a.r0.y0.a.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27837a.show(this.f27838b, this.f27839c, this.f27840d, this.f27841e, this.f27842f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.i f27843a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.g f27844b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f27845c;

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
            this.f27845c = cVar;
            this.f27843a = iVar;
            this.f27844b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) || (iVar = this.f27843a) == null) {
                return;
            }
            iVar.onAdClicked(str, str2, str3);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (iVar = this.f27843a) == null) {
                return;
            }
            iVar.onAdClose(str);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                a.i iVar = this.f27843a;
                if (iVar != null) {
                    iVar.onAdError(str);
                }
                this.f27845c.v("advert_show", str, 0, this.f27844b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                a.i iVar = this.f27843a;
                if (iVar != null) {
                    iVar.onAdShow(str, str2, str3);
                }
                if (this.f27845c.f27829a != null) {
                    this.f27845c.f27829a.f27871b = str;
                    this.f27845c.f27829a.f27872c = str2;
                }
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    String str4 = "BEAR ad sspType=" + str2 + ", sid=" + str + " ,pid=" + str3;
                }
                this.f27845c.v("advert_show", str, 1, this.f27844b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (iVar = this.f27843a) == null) {
                return;
            }
            iVar.onRewardedVideo(str);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements a.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f27846a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f27847b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f27848c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f27849d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f27850e;

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
            this.f27850e = cVar;
            this.f27846a = activity;
            this.f27847b = viewGroup;
            this.f27848c = str;
            this.f27849d = funAdInteractionListener;
        }

        @Override // b.a.r0.y0.a.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunSplashAd showSplash = FunAdSdk.getAdFactory().showSplash(this.f27846a, this.f27847b, this.f27848c, this.f27849d);
                if (showSplash != null) {
                    this.f27850e.f27829a = new p();
                    this.f27850e.f27829a.f27870a = showSplash;
                }
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    String str = "BEAR ad showSplash:" + this.f27850e.f27829a;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements FunSplashAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f27851a;

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
            this.f27851a = cVar;
        }

        @Override // com.fun.ad.sdk.FunSplashAdInteractionListener
        public void onAdClicked(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f27851a.t(CommonStatisticKey.KEY_EYE_SPLASH_BEAR_CLICK);
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        /* renamed from: a */
        public TTLocation getTTLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new TTLocation(b.a.e.e.m.b.c(TbadkCoreApplication.getInst().getLocationLng(), 0.0d), b.a.e.e.m.b.c(TbadkCoreApplication.getInst().getLocationLat(), 0.0d)) : (TTLocation) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean alist() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? CsjPrivacySwitch.isOpen() : invokeV.booleanValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getDevImei() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TbadkCoreApplication.getInst().getImei() : (String) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? CsjPrivacySwitch.isOpen() : invokeV.booleanValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUsePhoneState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? CsjPrivacySwitch.isOpen() : invokeV.booleanValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWifiState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? CsjPrivacySwitch.isOpen() : invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class i implements FunAdSdk.SdkInitializeCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.l f27852a;

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
            this.f27852a = lVar;
        }

        @Override // com.fun.ad.sdk.FunAdSdk.SdkInitializeCallback
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GlobalSetting.setAgreePrivacyStrategy(GdtPrivacySwitch.isOpen());
                GlobalSetting.setAllowLocation(GdtPrivacySwitch.isOpen());
                a.l lVar = this.f27852a;
                if (lVar != null) {
                    lVar.a();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements FunAdLoadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.h f27853a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.g f27854b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f27855c;

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
            this.f27855c = cVar;
            this.f27853a = hVar;
            this.f27854b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                a.h hVar = this.f27853a;
                if (hVar != null) {
                    hVar.a(str, 0);
                }
                this.f27855c.v("advert_load", str, 1, this.f27854b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                a.h hVar = this.f27853a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                this.f27855c.v("advert_load", str, 0, this.f27854b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements a.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f27856a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f27857b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f27858c;

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
            this.f27856a = context;
            this.f27857b = funAdSlot;
            this.f27858c = funAdLoadListener;
        }

        @Override // b.a.r0.y0.a.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().loadAd(this.f27856a, this.f27857b, this.f27858c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.i f27859a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.g f27860b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f27861c;

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
            this.f27861c = cVar;
            this.f27859a = iVar;
            this.f27860b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) || (iVar = this.f27859a) == null) {
                return;
            }
            iVar.onAdClicked(str, str2, str3);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (iVar = this.f27859a) == null) {
                return;
            }
            iVar.onAdClose(str);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                a.i iVar = this.f27859a;
                if (iVar != null) {
                    iVar.onAdError(str);
                }
                this.f27861c.v("advert_show", str, 0, this.f27860b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                a.i iVar = this.f27859a;
                if (iVar != null) {
                    iVar.onAdShow(str, str2, str3);
                }
                this.f27861c.v("advert_show", str, 1, this.f27860b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (iVar = this.f27859a) == null) {
                return;
            }
            iVar.onRewardedVideo(str);
        }
    }

    /* loaded from: classes6.dex */
    public class m implements a.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f27862a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f27863b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f27864c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f27865d;

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
            this.f27862a = activity;
            this.f27863b = viewGroup;
            this.f27864c = str;
            this.f27865d = funAdInteractionListener;
        }

        @Override // b.a.r0.y0.a.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().showAd(this.f27862a, this.f27863b, this.f27864c, this.f27865d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements a.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f27866a;

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
            this.f27866a = str;
        }

        @Override // b.a.r0.y0.a.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().destroyAd(this.f27866a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements FunAdLoadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.h f27867a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.g f27868b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f27869c;

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
            this.f27869c = cVar;
            this.f27867a = hVar;
            this.f27868b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                a.h hVar = this.f27867a;
                if (hVar != null) {
                    hVar.a(str, 0);
                }
                this.f27869c.v("advert_load", str, 1, this.f27868b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                a.h hVar = this.f27867a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                this.f27869c.v("advert_load", str, 0, this.f27868b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public FunSplashAd f27870a;

        /* renamed from: b  reason: collision with root package name */
        public String f27871b;

        /* renamed from: c  reason: collision with root package name */
        public String f27872c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f27873d;

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
            this.f27871b = null;
            this.f27872c = "cjs";
            this.f27873d = false;
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
        this.f27830b = new g(this);
    }

    @Override // b.a.r0.y0.a.f
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            destroyAd(str);
        }
    }

    @Override // b.a.r0.y0.a.f
    public void b(ImageView imageView, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView, obj) == null) && (obj instanceof FunNativeAd) && imageView != null) {
            b.a.r0.z0.b.B(imageView, (FunNativeAd) obj);
        }
    }

    @Override // b.a.r0.y0.a.f
    public void c(Activity activity, @NonNull Object obj, a.i iVar, ViewGroup viewGroup, List<View> list, List<View> list2, a.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, obj, iVar, viewGroup, list, list2, gVar}) == null) && !activity.isDestroyed() && (obj instanceof FunNativeAd)) {
            u(new C1360c(this, (FunNativeAd) obj, activity, viewGroup, list, list2, new b(this, iVar, gVar)));
        }
    }

    @Override // b.a.r0.y0.a.f
    public ViewGroup d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? new NativeAdContainer(context) : (ViewGroup) invokeL.objValue;
    }

    @Override // b.a.r0.y0.a.f
    public void destroyAd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            u(new n(this, str));
        }
    }

    @Override // b.a.r0.y0.a.f
    public View e(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof FunNativeAd) {
                FunNativeAd funNativeAd = (FunNativeAd) obj;
                b.a.r0.z0.b.t(funNativeAd);
                b.a.r0.z0.b.u(funNativeAd);
                return funNativeAd.getVideoView();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Override // b.a.r0.y0.a.f
    public boolean f(Activity activity) {
        InterceptResult invokeL;
        FunSplashAd funSplashAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, activity)) == null) {
            p pVar = this.f27829a;
            if (pVar == null || (funSplashAd = pVar.f27870a) == null || pVar.f27873d) {
                return false;
            }
            boolean showMiniWindow = funSplashAd.showMiniWindow(activity, false, new f(this));
            if (TbadkCoreApplication.getInst().isDebugMode()) {
                String str = "BEAR ad showMiniWindow: " + this.f27829a + ", isSucceed=" + showMiniWindow;
            }
            if (showMiniWindow) {
                this.f27829a.f27873d = true;
                t(CommonStatisticKey.KEY_EYE_SPLASH_BEAR_SHOW);
            }
            return showMiniWindow;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.r0.y0.a.f
    public void g(Activity activity, String str, ViewGroup viewGroup, a.i iVar, a.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048583, this, activity, str, viewGroup, iVar, gVar) == null) || viewGroup == null) {
            return;
        }
        u(new e(this, activity, viewGroup, str, new d(this, iVar, gVar)));
    }

    @Override // b.a.r0.y0.a.f
    public boolean h(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj instanceof FunNativeAd) {
                return b.a.r0.z0.b.C((FunNativeAd) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.r0.y0.a.f
    public Object i(@NonNull Activity activity, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, activity, str)) == null) {
            u(null);
            return FunAdSdk.getAdFactory().getNativeAd(activity, str);
        }
        return invokeLL.objValue;
    }

    @Override // b.a.r0.y0.a.f
    public boolean isAdReady(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            u(null);
            return FunAdSdk.getAdFactory().isAdReady(str);
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.r0.y0.a.f
    public void j(Context context, String str, a.h hVar, a.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, context, str, hVar, gVar) == null) {
            u(new k(this, context, new FunAdSlot.Builder().setSid(str).setExpressWidth(b.a.e.e.p.l.k(context)).build(), new j(this, hVar, gVar)));
        }
    }

    @Override // b.a.r0.y0.a.f
    public void k(Object obj, a.j jVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, obj, jVar) == null) && (obj instanceof FunNativeAd)) {
            FunNativeAd funNativeAd = (FunNativeAd) obj;
            b.a.r0.z0.b.A(funNativeAd, b.a.r0.z0.b.i(funNativeAd), jVar);
        }
    }

    @Override // b.a.r0.y0.a.f
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
                FunAdConfig.Builder builder = new FunAdConfig.Builder(application);
                if (b.a.q0.s.e0.b.j().k("key_fun_cjs_init", 1) == 0) {
                    builder.forbiddenPlatform(FunAdSdk.PLATFORM_CSJ);
                }
                if (b.a.q0.s.e0.b.j().k("key_fun_gdt_init", 1) == 0) {
                    builder.forbiddenPlatform(FunAdSdk.PLATFORM_GDT);
                }
                if (b.a.q0.s.e0.b.j().k("key_fun_ks_init", 1) == 0) {
                    builder.forbiddenPlatform(FunAdSdk.PLATFORM_KS);
                }
                builder.setAppName(application.getString(R.string.app_name)).setAppId("b122ce58b8954c27b6882f7987c08860").setUserId("").setUseTextureView(true).setTitleBarTheme(1).setVideoSoundEnable(false).setVideoDataFlowAutoStart(false).setLogEnabled(TbadkCoreApplication.getInst().isDebugMode()).setTTCustomController(new h(this)).setKsCanReadICCID(KsPrivacySwitch.isOpen()).setKsCanReadNearbyWifiList(KsPrivacySwitch.isOpen()).setKsCanReadMacAddress(KsPrivacySwitch.isOpen());
                FunAdSdk.init(builder.build(), this.f27830b, new i(this, lVar));
            }
        }
    }

    @Override // b.a.r0.y0.a.f
    public void m(Activity activity, String str, a.h hVar, a.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, activity, str, hVar, gVar) == null) {
            u(new a(this, activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(b.a.e.e.p.l.k(activity)).build(), new o(this, hVar, gVar)));
        }
    }

    @Override // b.a.r0.y0.a.f
    public void n(Activity activity, String str, ViewGroup viewGroup, a.i iVar, a.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048591, this, activity, str, viewGroup, iVar, gVar) == null) || viewGroup == null) {
            return;
        }
        u(new m(this, activity, viewGroup, str, new l(this, iVar, gVar)));
    }

    @Override // b.a.r0.y0.a.f
    public b.a.r0.z3.g o(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) {
            b.a.r0.z3.g gVar = null;
            if (obj instanceof FunNativeAd) {
                FunNativeAd funNativeAd = (FunNativeAd) obj;
                int i2 = b.a.r0.z0.b.i(funNativeAd);
                if (i2 == -1) {
                    return null;
                }
                gVar = new b.a.r0.z3.g();
                String c2 = b.a.r0.z0.b.c(funNativeAd, i2);
                if (b.a.e.e.p.k.isEmpty(c2)) {
                    c2 = "推广";
                }
                gVar.k(c2);
                gVar.l(b.a.r0.z0.b.l(funNativeAd, i2));
                gVar.j(b.a.r0.z0.b.g(funNativeAd, i2));
                gVar.g(b.a.r0.z0.b.d(funNativeAd));
                gVar.h(b.a.r0.z0.b.b(funNativeAd));
                gVar.i(i2);
            }
            return gVar;
        }
        return (b.a.r0.z3.g) invokeL.objValue;
    }

    @Override // b.a.r0.y0.a.f
    public void removeMiniWindow() {
        FunSplashAd funSplashAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            p pVar = this.f27829a;
            if (pVar != null && (funSplashAd = pVar.f27870a) != null) {
                funSplashAd.removeMiniWindow();
            }
            this.f27829a = null;
        }
    }

    public final void t(String str) {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (pVar = this.f27829a) == null || TextUtils.isEmpty(pVar.f27871b) || str == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(str).param("obj_source", 6).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_PARAM2, this.f27829a.f27871b).param(TiebaStatic.Params.OBJ_TO, this.f27829a.f27872c));
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
            b.a.e.e.n.a a2 = b.a.q0.q0.j.a();
            a2.b("type", "bear");
            a2.b("locate", gVar.f27237a);
            a2.b(SetImageWatermarkTypeReqMsg.SWITCH, gVar.f27238b);
            a2.b("sid", str2);
            a2.c("isSuccess", Integer.valueOf(i2));
            BdStatisticsManager.getInstance().debug(str, a2);
        }
    }
}
