package c.a.q0.x0;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.w0.a;
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
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements a.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public p f28600a;

    /* renamed from: b  reason: collision with root package name */
    public final FunAdCallback f28601b;

    /* loaded from: classes4.dex */
    public class a implements a.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f28602a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f28603b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f28604c;

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
            this.f28602a = activity;
            this.f28603b = funAdSlot;
            this.f28604c = funAdLoadListener;
        }

        @Override // c.a.q0.w0.a.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    FunAdSdk.getAdFactory().loadAd(this.f28602a, this.f28603b, this.f28604c);
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
        public final /* synthetic */ a.i f28605a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.g f28606b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f28607c;

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
            this.f28607c = cVar;
            this.f28605a = iVar;
            this.f28606b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) || (iVar = this.f28605a) == null) {
                return;
            }
            iVar.onAdClicked(str, str2, str3);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (iVar = this.f28605a) == null) {
                return;
            }
            iVar.onAdClose(str);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                a.i iVar = this.f28605a;
                if (iVar != null) {
                    iVar.onAdError(str);
                }
                this.f28607c.v("advert_show", str, 0, this.f28606b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                a.i iVar = this.f28605a;
                if (iVar != null) {
                    iVar.onAdShow(str, str2, str3);
                }
                this.f28607c.v("advert_show", str, 1, this.f28606b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (iVar = this.f28605a) == null) {
                return;
            }
            iVar.onRewardedVideo(str);
        }
    }

    /* renamed from: c.a.q0.x0.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1333c implements a.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunNativeAd f28608a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f28609b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f28610c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f28611d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f28612e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f28613f;

        public C1333c(c cVar, FunNativeAd funNativeAd, Activity activity, ViewGroup viewGroup, List list, List list2, FunAdInteractionListener funAdInteractionListener) {
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
            this.f28608a = funNativeAd;
            this.f28609b = activity;
            this.f28610c = viewGroup;
            this.f28611d = list;
            this.f28612e = list2;
            this.f28613f = funAdInteractionListener;
        }

        @Override // c.a.q0.w0.a.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28608a.show(this.f28609b, this.f28610c, this.f28611d, this.f28612e, this.f28613f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.i f28614a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.g f28615b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f28616c;

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
            this.f28616c = cVar;
            this.f28614a = iVar;
            this.f28615b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) || (iVar = this.f28614a) == null) {
                return;
            }
            iVar.onAdClicked(str, str2, str3);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (iVar = this.f28614a) == null) {
                return;
            }
            iVar.onAdClose(str);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                a.i iVar = this.f28614a;
                if (iVar != null) {
                    iVar.onAdError(str);
                }
                this.f28616c.v("advert_show", str, 0, this.f28615b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                a.i iVar = this.f28614a;
                if (iVar != null) {
                    iVar.onAdShow(str, str2, str3);
                }
                if (this.f28616c.f28600a != null) {
                    this.f28616c.f28600a.f28642b = str;
                    this.f28616c.f28600a.f28643c = str2;
                }
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    String str4 = "BEAR ad sspType=" + str2 + ", sid=" + str + " ,pid=" + str3;
                }
                this.f28616c.v("advert_show", str, 1, this.f28615b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (iVar = this.f28614a) == null) {
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
        public final /* synthetic */ Activity f28617a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f28618b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f28619c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f28620d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f28621e;

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
            this.f28621e = cVar;
            this.f28617a = activity;
            this.f28618b = viewGroup;
            this.f28619c = str;
            this.f28620d = funAdInteractionListener;
        }

        @Override // c.a.q0.w0.a.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunSplashAd showSplash = FunAdSdk.getAdFactory().showSplash(this.f28617a, this.f28618b, this.f28619c, this.f28620d);
                if (showSplash != null) {
                    this.f28621e.f28600a = new p();
                    this.f28621e.f28600a.f28641a = showSplash;
                }
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    String str = "BEAR ad showSplash:" + this.f28621e.f28600a;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements FunSplashAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f28622a;

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
            this.f28622a = cVar;
        }

        @Override // com.fun.ad.sdk.FunSplashAdInteractionListener
        public void onAdClicked(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f28622a.t(CommonStatisticKey.KEY_EYE_SPLASH_BEAR_CLICK);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new TTLocation(c.a.e.e.m.b.b(TbadkCoreApplication.getInst().getLocationLng(), 0.0d), c.a.e.e.m.b.b(TbadkCoreApplication.getInst().getLocationLat(), 0.0d)) : (TTLocation) invokeV.objValue;
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
        public final /* synthetic */ a.l f28623a;

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
            this.f28623a = lVar;
        }

        @Override // com.fun.ad.sdk.FunAdSdk.SdkInitializeCallback
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GlobalSetting.setAgreePrivacyStrategy(GdtPrivacySwitch.isOpen());
                a.l lVar = this.f28623a;
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
        public final /* synthetic */ a.h f28624a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.g f28625b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f28626c;

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
            this.f28626c = cVar;
            this.f28624a = hVar;
            this.f28625b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                a.h hVar = this.f28624a;
                if (hVar != null) {
                    hVar.a(str, 0);
                }
                this.f28626c.v("advert_load", str, 1, this.f28625b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                a.h hVar = this.f28624a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                this.f28626c.v("advert_load", str, 0, this.f28625b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements a.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f28627a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f28628b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f28629c;

        public k(c cVar, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
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
            this.f28627a = activity;
            this.f28628b = funAdSlot;
            this.f28629c = funAdLoadListener;
        }

        @Override // c.a.q0.w0.a.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().loadAd(this.f28627a, this.f28628b, this.f28629c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.i f28630a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.g f28631b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f28632c;

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
            this.f28632c = cVar;
            this.f28630a = iVar;
            this.f28631b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) || (iVar = this.f28630a) == null) {
                return;
            }
            iVar.onAdClicked(str, str2, str3);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (iVar = this.f28630a) == null) {
                return;
            }
            iVar.onAdClose(str);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                a.i iVar = this.f28630a;
                if (iVar != null) {
                    iVar.onAdError(str);
                }
                this.f28632c.v("advert_show", str, 0, this.f28631b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                a.i iVar = this.f28630a;
                if (iVar != null) {
                    iVar.onAdShow(str, str2, str3);
                }
                this.f28632c.v("advert_show", str, 1, this.f28631b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (iVar = this.f28630a) == null) {
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
        public final /* synthetic */ Activity f28633a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f28634b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f28635c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f28636d;

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
            this.f28633a = activity;
            this.f28634b = viewGroup;
            this.f28635c = str;
            this.f28636d = funAdInteractionListener;
        }

        @Override // c.a.q0.w0.a.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().showAd(this.f28633a, this.f28634b, this.f28635c, this.f28636d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements a.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f28637a;

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
            this.f28637a = str;
        }

        @Override // c.a.q0.w0.a.l
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().destroyAd(this.f28637a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements FunAdLoadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.h f28638a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.g f28639b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f28640c;

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
            this.f28640c = cVar;
            this.f28638a = hVar;
            this.f28639b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                a.h hVar = this.f28638a;
                if (hVar != null) {
                    hVar.a(str, 0);
                }
                this.f28640c.v("advert_load", str, 1, this.f28639b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                a.h hVar = this.f28638a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                this.f28640c.v("advert_load", str, 0, this.f28639b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public FunSplashAd f28641a;

        /* renamed from: b  reason: collision with root package name */
        public String f28642b;

        /* renamed from: c  reason: collision with root package name */
        public String f28643c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f28644d;

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
            this.f28642b = null;
            this.f28643c = "cjs";
            this.f28644d = false;
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
        this.f28601b = new g(this);
    }

    @Override // c.a.q0.w0.a.f
    public void a(Activity activity, String str, a.h hVar, a.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, activity, str, hVar, gVar) == null) {
            u(new k(this, activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(c.a.e.e.p.l.k(activity)).build(), new j(this, hVar, gVar)));
        }
    }

    @Override // c.a.q0.w0.a.f
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            destroyAd(str);
        }
    }

    @Override // c.a.q0.w0.a.f
    public void c(ImageView imageView, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imageView, obj) == null) && (obj instanceof FunNativeAd) && imageView != null) {
            c.a.q0.x0.b.B(imageView, (FunNativeAd) obj);
        }
    }

    @Override // c.a.q0.w0.a.f
    public void d(Activity activity, @NonNull Object obj, a.i iVar, ViewGroup viewGroup, List<View> list, List<View> list2, a.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{activity, obj, iVar, viewGroup, list, list2, gVar}) == null) && !activity.isDestroyed() && (obj instanceof FunNativeAd)) {
            u(new C1333c(this, (FunNativeAd) obj, activity, viewGroup, list, list2, new b(this, iVar, gVar)));
        }
    }

    @Override // c.a.q0.w0.a.f
    public void destroyAd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            u(new n(this, str));
        }
    }

    @Override // c.a.q0.w0.a.f
    public View e(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof FunNativeAd) {
                FunNativeAd funNativeAd = (FunNativeAd) obj;
                c.a.q0.x0.b.t(funNativeAd);
                c.a.q0.x0.b.u(funNativeAd);
                return funNativeAd.getVideoView();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Override // c.a.q0.w0.a.f
    public boolean f(Activity activity) {
        InterceptResult invokeL;
        FunSplashAd funSplashAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, activity)) == null) {
            p pVar = this.f28600a;
            if (pVar == null || (funSplashAd = pVar.f28641a) == null || pVar.f28644d) {
                return false;
            }
            boolean showMiniWindow = funSplashAd.showMiniWindow(activity, false, new f(this));
            if (TbadkCoreApplication.getInst().isDebugMode()) {
                String str = "BEAR ad showMiniWindow: " + this.f28600a + ", isSucceed=" + showMiniWindow;
            }
            if (showMiniWindow) {
                this.f28600a.f28644d = true;
                t(CommonStatisticKey.KEY_EYE_SPLASH_BEAR_SHOW);
            }
            return showMiniWindow;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.q0.w0.a.f
    public ViewGroup g(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, activity, str)) == null) ? new FrameLayout(activity) : (ViewGroup) invokeLL.objValue;
    }

    @Override // c.a.q0.w0.a.f
    public void h(Activity activity, String str, ViewGroup viewGroup, a.i iVar, a.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, str, viewGroup, iVar, gVar) == null) || viewGroup == null) {
            return;
        }
        u(new e(this, activity, viewGroup, str, new d(this, iVar, gVar)));
    }

    @Override // c.a.q0.w0.a.f
    public boolean i(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            if (obj instanceof FunNativeAd) {
                return c.a.q0.x0.b.C((FunNativeAd) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.q0.w0.a.f
    public boolean isAdReady(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            u(null);
            return FunAdSdk.getAdFactory().isAdReady(str);
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.q0.w0.a.f
    public Object j(@NonNull Activity activity, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, activity, str)) == null) {
            u(null);
            return FunAdSdk.getAdFactory().getNativeAd(activity, str);
        }
        return invokeLL.objValue;
    }

    @Override // c.a.q0.w0.a.f
    public void k(Object obj, a.j jVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, obj, jVar) == null) && (obj instanceof FunNativeAd)) {
            FunNativeAd funNativeAd = (FunNativeAd) obj;
            c.a.q0.x0.b.A(funNativeAd, c.a.q0.x0.b.i(funNativeAd), jVar);
        }
    }

    @Override // c.a.q0.w0.a.f
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
                if (c.a.p0.s.d0.b.j().k("key_fun_cjs_init", 1) == 0) {
                    hashSet.add(FunAdSdk.PLATFORM_CSJ);
                }
                if (c.a.p0.s.d0.b.j().k("key_fun_gdt_init", 1) == 0) {
                    hashSet.add(FunAdSdk.PLATFORM_GDT);
                }
                if (c.a.p0.s.d0.b.j().k("key_fun_ks_init", 1) == 0) {
                    hashSet.add(FunAdSdk.PLATFORM_KS);
                }
                FunAdSdk.init(new FunAdConfig.Builder(application).setAppName(application.getString(R.string.app_name)).setAppId("b122ce58b8954c27b6882f7987c08860").setUserId("").setUseTextureView(true).setTitleBarTheme(1).setVideoSoundEnable(false).setVideoDataFlowAutoStart(false).setSspTypeBlacklist(hashSet).setLogEnabled(TbadkCoreApplication.getInst().isDebugMode()).setTTCustomController(new h(this)).setKsCanReadICCID(KsPrivacySwitch.isOpen()).setKsCanReadNearbyWifiList(KsPrivacySwitch.isOpen()).setKsCanReadMacAddress(KsPrivacySwitch.isOpen()).build(), this.f28601b, new i(this, lVar));
            }
        }
    }

    @Override // c.a.q0.w0.a.f
    public void m(Activity activity, String str, a.h hVar, a.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, activity, str, hVar, gVar) == null) {
            u(new a(this, activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(c.a.e.e.p.l.k(activity)).build(), new o(this, hVar, gVar)));
        }
    }

    @Override // c.a.q0.w0.a.f
    public void n(Activity activity, String str, ViewGroup viewGroup, a.i iVar, a.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048591, this, activity, str, viewGroup, iVar, gVar) == null) || viewGroup == null) {
            return;
        }
        u(new m(this, activity, viewGroup, str, new l(this, iVar, gVar)));
    }

    @Override // c.a.q0.w0.a.f
    public c.a.q0.w3.g o(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) {
            c.a.q0.w3.g gVar = null;
            if (obj instanceof FunNativeAd) {
                FunNativeAd funNativeAd = (FunNativeAd) obj;
                int i2 = c.a.q0.x0.b.i(funNativeAd);
                if (i2 == -1) {
                    return null;
                }
                gVar = new c.a.q0.w3.g();
                String c2 = c.a.q0.x0.b.c(funNativeAd, i2);
                if (c.a.e.e.p.k.isEmpty(c2)) {
                    c2 = "推广";
                }
                gVar.k(c2);
                gVar.l(c.a.q0.x0.b.l(funNativeAd, i2));
                gVar.j(c.a.q0.x0.b.g(funNativeAd, i2));
                gVar.g(c.a.q0.x0.b.d(funNativeAd));
                gVar.h(c.a.q0.x0.b.b(funNativeAd));
                gVar.i(i2);
            }
            return gVar;
        }
        return (c.a.q0.w3.g) invokeL.objValue;
    }

    @Override // c.a.q0.w0.a.f
    public void removeMiniWindow() {
        FunSplashAd funSplashAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            p pVar = this.f28600a;
            if (pVar != null && (funSplashAd = pVar.f28641a) != null) {
                funSplashAd.removeMiniWindow();
            }
            this.f28600a = null;
        }
    }

    public final void t(String str) {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (pVar = this.f28600a) == null || TextUtils.isEmpty(pVar.f28642b) || str == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(str).param("obj_source", 6).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_PARAM2, this.f28600a.f28642b).param(TiebaStatic.Params.OBJ_TO, this.f28600a.f28643c));
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
            c.a.e.e.n.a a2 = c.a.p0.o0.j.a();
            a2.b("type", "bear");
            a2.b("locate", gVar.f27624a);
            a2.b(SetImageWatermarkTypeReqMsg.SWITCH, gVar.f27625b);
            a2.b("sid", str2);
            a2.c("isSuccess", Integer.valueOf(i2));
            BdStatisticsManager.getInstance().debug(str, a2);
        }
    }
}
