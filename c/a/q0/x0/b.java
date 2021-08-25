package c.a.q0.x0;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.i3.i0.o;
import c.a.q0.w0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunNativeAd;
import com.kwad.sdk.api.KsNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements TTFeedAd.VideoAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.j f28598a;

        public a(a.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28598a = jVar;
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onProgressUpdate(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                this.f28598a.a(j2, j3);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdComplete(TTFeedAd tTFeedAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTFeedAd) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tTFeedAd) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdPaused(TTFeedAd tTFeedAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, tTFeedAd) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, tTFeedAd) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoError(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoLoad(TTFeedAd tTFeedAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, tTFeedAd) == null) {
            }
        }
    }

    /* renamed from: c.a.q0.x0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C1332b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28599a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-462290872, "Lc/a/q0/x0/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-462290872, "Lc/a/q0/x0/b$b;");
                    return;
                }
            }
            int[] iArr = new int[FunNativeAd.InteractionType.values().length];
            f28599a = iArr;
            try {
                iArr[FunNativeAd.InteractionType.TYPE_DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28599a[FunNativeAd.InteractionType.TYPE_DIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28599a[FunNativeAd.InteractionType.TYPE_BROWSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static void A(FunNativeAd funNativeAd, int i2, a.j jVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65536, null, funNativeAd, i2, jVar) == null) && i2 == 3) {
            TTNativeAd tTNativeAd = funNativeAd.getChannelNativeAds_6().csjNative;
            if (tTNativeAd instanceof TTFeedAd) {
                ((TTFeedAd) tTNativeAd).setVideoAdListener(new a(jVar));
            }
        }
    }

    public static void B(ImageView imageView, FunNativeAd funNativeAd) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, imageView, funNativeAd) == null) || funNativeAd == null) {
            return;
        }
        ChannelNativeAds_6 channelNativeAds_6 = funNativeAd.getChannelNativeAds_6();
        if (channelNativeAds_6 == null) {
            imageView.setVisibility(8);
            imageView.setImageDrawable(null);
        } else if (channelNativeAds_6.gdtNative != null) {
            WebPManager.setMaskDrawable(imageView, R.drawable.icon_mask_advertisement_guangdiantong_12, WebPManager.ResourceStateType.NORMAL);
            imageView.setVisibility(0);
        } else if (channelNativeAds_6.ksNative != null) {
            WebPManager.setMaskDrawable(imageView, R.drawable.icon_mask_advertisement_kuaishou_12, WebPManager.ResourceStateType.NORMAL);
            imageView.setVisibility(0);
        } else if (channelNativeAds_6.csjNative != null) {
            WebPManager.setMaskDrawable(imageView, R.drawable.icon_mask_advertisement_chuanshanjia_12, WebPManager.ResourceStateType.NORMAL);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
            imageView.setImageDrawable(null);
        }
    }

    public static boolean C(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, funNativeAd)) == null) ? (funNativeAd == null || funNativeAd.getChannelNativeAds_6() == null || funNativeAd.getChannelNativeAds_6().gdtNative == null) ? false : true : invokeL.booleanValue;
    }

    public static void D(int i2, String str, String str2, o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), str, str2, oVar}) == null) || oVar == null || oVar.d() == null) {
            return;
        }
        FunNativeAd funNativeAd = (FunNativeAd) oVar.d();
        List<String> imageUrls = funNativeAd.getImageUrls();
        FunAdRecordHttpMessage.uploadShowOrClickRecord(str, str2, String.valueOf(i2), oVar.e(), oVar.c(), funNativeAd.getTitle(), funNativeAd.getDescription(), imageUrls == null ? null : imageUrls.toString(), j(funNativeAd), String.valueOf(n(funNativeAd)));
    }

    public static void a(StatisticItem statisticItem, o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, statisticItem, oVar) == null) || statisticItem == null || oVar == null || oVar.d() == null) {
            return;
        }
        FunNativeAd funNativeAd = (FunNativeAd) oVar.d();
        statisticItem.param("tid", oVar.e());
        statisticItem.param("fid", oVar.c());
        statisticItem.param(TiebaStatic.Params.AD_TYPE, n(funNativeAd));
        statisticItem.param(TiebaStatic.Params.AD_TITLE, funNativeAd.getTitle());
        statisticItem.param(TiebaStatic.Params.AD_DESC, funNativeAd.getDescription());
        statisticItem.param(TiebaStatic.Params.AD_SOURCE, j(funNativeAd));
        List<String> imageUrls = funNativeAd.getImageUrls();
        if (imageUrls != null) {
            statisticItem.param("ad_pic", imageUrls.toString());
        }
    }

    public static int b(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, funNativeAd)) == null) {
            int i2 = C1332b.f28599a[funNativeAd.getInteractionType().ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return i2 != 3 ? 1 : 4;
                }
                return 3;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    public static String c(FunNativeAd funNativeAd, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, funNativeAd, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return i2 != 3 ? "" : funNativeAd.getChannelNativeAds_6().csjNative.getTitle();
                } else if (k.isEmpty(funNativeAd.getChannelNativeAds_6().ksNative.getAppIconUrl())) {
                    return funNativeAd.getChannelNativeAds_6().ksNative.getProductName();
                } else {
                    return funNativeAd.getChannelNativeAds_6().ksNative.getAppName();
                }
            }
            return funNativeAd.getChannelNativeAds_6().gdtNative.getTitle();
        }
        return (String) invokeLI.objValue;
    }

    public static String d(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, funNativeAd)) == null) {
            ChannelNativeAds_6 channelNativeAds_6 = funNativeAd.getChannelNativeAds_6();
            if (channelNativeAds_6 == null) {
                return TbadkCoreApplication.getInst().getContext().getString(R.string.ad_interaction_type_browser);
            }
            KsNativeAd ksNativeAd = channelNativeAds_6.ksNative;
            if (ksNativeAd != null) {
                return ksNativeAd.getActionDescription();
            }
            int i3 = C1332b.f28599a[funNativeAd.getInteractionType().ordinal()];
            if (i3 == 1) {
                i2 = R.string.ad_interaction_type_download;
            } else if (i3 != 2) {
                i2 = R.string.ad_interaction_type_browser_video;
            } else {
                i2 = R.string.ad_interaction_type_dial;
            }
            NativeUnifiedADData nativeUnifiedADData = channelNativeAds_6.gdtNative;
            if (nativeUnifiedADData != null && nativeUnifiedADData.isAppAd()) {
                i2 = R.string.ad_interaction_type_download;
            }
            if (i2 == 0) {
                i2 = R.string.ad_interaction_type_browser_video;
            }
            return TbadkCoreApplication.getInst().getContext().getString(i2);
        }
        return (String) invokeL.objValue;
    }

    public static String e(@NonNull FunNativeAd funNativeAd, @NonNull Context context) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, funNativeAd, context)) == null) {
            ChannelNativeAds_6 channelNativeAds_6 = funNativeAd.getChannelNativeAds_6();
            if (channelNativeAds_6 == null) {
                return context.getString(R.string.ad_interaction_type_browser);
            }
            KsNativeAd ksNativeAd = channelNativeAds_6.ksNative;
            if (ksNativeAd != null) {
                return ksNativeAd.getActionDescription();
            }
            int i3 = C1332b.f28599a[funNativeAd.getInteractionType().ordinal()];
            if (i3 == 1) {
                i2 = R.string.ad_interaction_type_download;
            } else if (i3 != 2) {
                i2 = R.string.ad_interaction_type_browser;
            } else {
                i2 = R.string.ad_interaction_type_dial;
            }
            NativeUnifiedADData nativeUnifiedADData = channelNativeAds_6.gdtNative;
            if (nativeUnifiedADData != null && nativeUnifiedADData.isAppAd()) {
                i2 = R.string.ad_interaction_type_download;
            }
            if (i2 == 0) {
                i2 = R.string.ad_interaction_type_browser;
            }
            return context.getString(i2);
        }
        return (String) invokeLL.objValue;
    }

    public static int f(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        TTNativeAd tTNativeAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, funNativeAd)) == null) {
            if (funNativeAd == null || funNativeAd.getChannelNativeAds_6() == null || (tTNativeAd = funNativeAd.getChannelNativeAds_6().csjNative) == null) {
                return 0;
            }
            if (tTNativeAd.getImageMode() == 2) {
                return 6;
            }
            if (tTNativeAd.getImageMode() == 3) {
                return 1;
            }
            if (tTNativeAd.getImageMode() == 4) {
                return 5;
            }
            if (tTNativeAd.getImageMode() == 5) {
                return 2;
            }
            if (tTNativeAd.getImageMode() == 15) {
                return 4;
            }
            return tTNativeAd.getImageMode() == 16 ? 3 : 0;
        }
        return invokeL.intValue;
    }

    public static String g(FunNativeAd funNativeAd, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, funNativeAd, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return i2 != 3 ? "" : funNativeAd.getChannelNativeAds_6().csjNative.getDescription();
                }
                return funNativeAd.getChannelNativeAds_6().ksNative.getAdDescription();
            }
            return funNativeAd.getChannelNativeAds_6().gdtNative.getDesc();
        }
        return (String) invokeLI.objValue;
    }

    public static int h(@DimenRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) ? l.g(TbadkCoreApplication.getInst(), i2) : invokeI.intValue;
    }

    public static int i(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        ChannelNativeAds_6 channelNativeAds_6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, funNativeAd)) == null) {
            if (funNativeAd == null || (channelNativeAds_6 = funNativeAd.getChannelNativeAds_6()) == null) {
                return -1;
            }
            if (channelNativeAds_6.gdtNative != null) {
                return 1;
            }
            if (channelNativeAds_6.ksNative != null) {
                return 2;
            }
            return channelNativeAds_6.csjNative != null ? 3 : -1;
        }
        return invokeL.intValue;
    }

    public static String j(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        ChannelNativeAds_6 channelNativeAds_6;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, funNativeAd)) == null) ? (funNativeAd == null || (channelNativeAds_6 = funNativeAd.getChannelNativeAds_6()) == null) ? "" : channelNativeAds_6.gdtNative != null ? FunAdSdk.PLATFORM_GDT : channelNativeAds_6.ksNative != null ? FunAdSdk.PLATFORM_KS : channelNativeAds_6.csjNative != null ? "cjs" : "" : (String) invokeL.objValue;
    }

    public static int k(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        TTNativeAd tTNativeAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, funNativeAd)) == null) {
            if (funNativeAd == null || funNativeAd.getChannelNativeAds_6() == null || (tTNativeAd = funNativeAd.getChannelNativeAds_6().csjNative) == null) {
                return -1;
            }
            if (tTNativeAd.getImageMode() == 2) {
                return 2;
            }
            if (tTNativeAd.getImageMode() == 3) {
                return 3;
            }
            if (tTNativeAd.getImageMode() == 4) {
                return 1;
            }
            if (tTNativeAd.getImageMode() == 5) {
                return 5;
            }
            if (tTNativeAd.getImageMode() == 15) {
                return 6;
            }
            return tTNativeAd.getImageMode() == 16 ? 4 : 0;
        }
        return invokeL.intValue;
    }

    public static String l(FunNativeAd funNativeAd, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, funNativeAd, i2)) == null) {
            if (i2 != 1) {
                return i2 != 2 ? i2 != 3 ? "" : funNativeAd.getChannelNativeAds_6().csjNative.getIcon().getImageUrl() : k.isEmpty(funNativeAd.getChannelNativeAds_6().ksNative.getAppIconUrl()) ? "" : funNativeAd.getChannelNativeAds_6().ksNative.getAppIconUrl();
            }
            return funNativeAd.getChannelNativeAds_6().gdtNative.getIconUrl();
        }
        return (String) invokeLI.objValue;
    }

    public static int m(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, funNativeAd)) == null) ? (funNativeAd == null || funNativeAd.getVideoView() == null) ? 1 : 2 : invokeL.intValue;
    }

    public static int n(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, funNativeAd)) == null) {
            if (funNativeAd != null && funNativeAd.getChannelNativeAds_6() != null) {
                ChannelNativeAds_6 channelNativeAds_6 = funNativeAd.getChannelNativeAds_6();
                if (channelNativeAds_6.gdtNative != null) {
                    return m(funNativeAd);
                }
                if (channelNativeAds_6.ksNative != null) {
                    return m(funNativeAd);
                }
                if (channelNativeAds_6.csjNative != null) {
                    return f(funNativeAd);
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean o(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        ChannelNativeAds_6 channelNativeAds_6;
        KsNativeAd ksNativeAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, funNativeAd)) == null) {
            if (funNativeAd == null || (channelNativeAds_6 = funNativeAd.getChannelNativeAds_6()) == null || channelNativeAds_6.gdtNative != null || channelNativeAds_6.csjNative != null || (ksNativeAd = channelNativeAds_6.ksNative) == null) {
                return false;
            }
            return !TextUtils.isEmpty(ksNativeAd.getAppIconUrl());
        }
        return invokeL.booleanValue;
    }

    public static boolean p(FunNativeAd funNativeAd, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, funNativeAd, list)) == null) {
            return (ListUtils.getCount(list) == 1) && k(funNativeAd) == 2;
        }
        return invokeLL.booleanValue;
    }

    public static boolean q(FunNativeAd funNativeAd, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, funNativeAd, list)) == null) {
            return (ListUtils.getCount(list) == 1) && k(funNativeAd) == 4;
        }
        return invokeLL.booleanValue;
    }

    public static boolean r(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, funNativeAd)) == null) {
            return (funNativeAd.getVideoView() != null) && k(funNativeAd) == 6;
        }
        return invokeL.booleanValue;
    }

    public static void s(FunNativeAd funNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, funNativeAd) == null) {
        }
    }

    public static void t(FunNativeAd funNativeAd) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, funNativeAd) == null) && i(funNativeAd) == 3 && (funNativeAd.getChannelNativeAds_6().csjNative instanceof TTDrawFeedAd)) {
            TTDrawFeedAd tTDrawFeedAd = (TTDrawFeedAd) funNativeAd.getChannelNativeAds_6().csjNative;
            tTDrawFeedAd.setCanInterruptVideoPlay(true);
            tTDrawFeedAd.setPauseIcon(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.icon_pure_video_play208), 67);
        }
    }

    public static void u(FunNativeAd funNativeAd) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65560, null, funNativeAd) == null) && i(funNativeAd) == 1) {
            funNativeAd.getChannelNativeAds_6().gdtNative.setVideoMute(false);
        }
    }

    public static void v(ImageView imageView, FunNativeAd funNativeAd) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65561, null, imageView, funNativeAd) == null) || funNativeAd == null || imageView == null) {
            return;
        }
        ChannelNativeAds_6 channelNativeAds_6 = funNativeAd.getChannelNativeAds_6();
        if (channelNativeAds_6 == null) {
            imageView.setVisibility(8);
            imageView.setImageDrawable(null);
        } else if (channelNativeAds_6.gdtNative != null) {
            imageView.setVisibility(0);
            WebPManager.setMaskDrawable(imageView, R.drawable.icon_mask_ad_fun_logo_gdt, WebPManager.ResourceStateType.NORMAL);
        } else if (channelNativeAds_6.ksNative != null) {
            imageView.setVisibility(0);
            WebPManager.setMaskDrawable(imageView, R.drawable.icon_mask_ad_fun_logo_ks, WebPManager.ResourceStateType.NORMAL);
        } else if (channelNativeAds_6.csjNative != null) {
            imageView.setVisibility(0);
            WebPManager.setMaskDrawable(imageView, R.drawable.icon_mask_ad_fun_logo_csj, WebPManager.ResourceStateType.NORMAL);
        } else {
            imageView.setVisibility(8);
            imageView.setImageDrawable(null);
        }
    }

    public static void w(View view, boolean z) {
        int i2;
        int h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65562, null, view, z) == null) || view == null || view.getLayoutParams() == null) {
            return;
        }
        if (z) {
            i2 = h(R.dimen.tbds447);
            h2 = h(R.dimen.tbds796);
        } else {
            i2 = -1;
            h2 = h(R.dimen.tbds504);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = h(R.dimen.M_H_X004);
        if (layoutParams.width == i2 && layoutParams.height == h2) {
            return;
        }
        layoutParams.width = i2;
        layoutParams.height = h2;
        view.setLayoutParams(layoutParams);
    }

    public static void x(View view, boolean z, List<String> list) {
        int i2;
        int h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{view, Boolean.valueOf(z), list}) == null) || view == null || view.getLayoutParams() == null) {
            return;
        }
        if (z) {
            i2 = h(R.dimen.tbds515);
            h2 = h(R.dimen.tbds915);
        } else {
            i2 = -1;
            h2 = h(ListUtils.getCount(list) == 1 ? R.dimen.tbds551 : R.dimen.tbds213);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.width == i2 && layoutParams.height == h2) {
            return;
        }
        layoutParams.width = i2;
        layoutParams.height = h2;
        view.setLayoutParams(layoutParams);
    }

    public static void y(View view, boolean z) {
        int h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65564, null, view, z) == null) || view == null || view.getLayoutParams() == null) {
            return;
        }
        if (z) {
            h2 = h(R.dimen.tbds33);
        } else {
            h2 = h(R.dimen.tbds25);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = h2;
        layoutParams.bottomMargin = 0;
        view.setLayoutParams(layoutParams);
    }

    public static void z(View view, boolean z) {
        int i2;
        int h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65565, null, view, z) == null) || view == null || view.getLayoutParams() == null) {
            return;
        }
        if (z) {
            i2 = h(R.dimen.tbds515);
            h2 = h(R.dimen.tbds915);
        } else {
            i2 = -1;
            h2 = h(R.dimen.tbds551);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.width == i2 && layoutParams.height == h2) {
            return;
        }
        layoutParams.width = i2;
        layoutParams.height = h2;
        view.setLayoutParams(layoutParams);
    }
}
