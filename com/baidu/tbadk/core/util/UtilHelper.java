package com.baidu.tbadk.core.util;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.behavior.record.api.IBehaviorApi;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.GrowthStatsUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AiAppGuideActivityConfig;
import com.baidu.tbadk.core.atomData.AtMeActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.switchs.VideoMiddlePageSwitch;
import com.baidu.tbadk.switchs.VideoSquareMiddlePageSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.bz4;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.e95;
import com.baidu.tieba.ej;
import com.baidu.tieba.fe5;
import com.baidu.tieba.fy4;
import com.baidu.tieba.g35;
import com.baidu.tieba.hi5;
import com.baidu.tieba.hn;
import com.baidu.tieba.im;
import com.baidu.tieba.iv4;
import com.baidu.tieba.jm;
import com.baidu.tieba.ky4;
import com.baidu.tieba.n9;
import com.baidu.tieba.ni;
import com.baidu.tieba.qt4;
import com.baidu.tieba.rp4;
import com.baidu.tieba.sf;
import com.baidu.tieba.sj5;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import com.baidu.tieba.v9;
import com.baidu.tieba.vd5;
import com.baidu.tieba.w9;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.tieba.wf8;
import com.baidu.tieba.wg;
import com.baidu.tieba.wi;
import com.baidu.tieba.xi;
import com.baidu.tieba.yi;
import com.baidu.tieba.yy4;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.protobuf.CodedInputStream;
import com.kuaishou.weapon.p0.k1;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.conn.util.InetAddressUtils;
import tbclient.BaijiahaoInfo;
/* loaded from: classes3.dex */
public class UtilHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AUTH_TYPE_FORUMMANAGER = 4;
    public static final int AUTH_TYPE_NEWGOD = 3;
    public static final int AUTH_TYPE_NONE = 0;
    public static final int AUTH_TYPE_OFFICAIL = 1;
    public static final int AUTH_TYPE_ORIGINAL = 2;
    public static final int BIG_GOD_ICON_TYPE_PB = 4;
    public static final int BJH_AUTH_ICON_TYPE_CARD = 0;
    public static final int BJH_AUTH_ICON_TYPE_PX12 = 1;
    public static final int BJH_AUTH_ICON_TYPE_PX16 = 2;
    public static final int BJH_AUTH_ICON_TYPE_PX20 = 3;
    public static final int BJH_AUTH_TYPE_COMPANY = 2;
    public static final int BJH_AUTH_TYPE_NORMAL = 0;
    public static final int BJH_AUTH_TYPE_PERSONAL = 3;
    public static final int BJH_AUTH_TYPE_STAR = 1;
    public static final String KEY_HAS_TOKEN = "has_token";
    public static final int MAX_LOCAL_CHANNEL_ADDRESS_COUNT = 18;
    public static final String NATIVE_PAY_FROM = "from_type";
    public static final int PROCESS_LIMIT_NONE = 0;
    public static final Pattern pbPattern0;
    public static final String[] sNativeAdEncoded;
    public static final String[] sNativeAdPrefixes;
    public transient /* synthetic */ FieldHolder $fh;

    public static int getBjhBigVIconId(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65565, null, i, i2)) == null) {
            if (i > 0) {
                return (i2 == 0 || i2 == 4) ? R.drawable.obfuscated_res_0x7f080600 : i2 == 1 ? R.drawable.obfuscated_res_0x7f0805ff : i2 == 2 ? R.drawable.obfuscated_res_0x7f080601 : i2 == 3 ? R.drawable.ic_icon_mask_v20_n_svg : R.drawable.obfuscated_res_0x7f080600;
            }
            return 0;
        }
        return invokeII.intValue;
    }

    public static long getCorrectUserIdAfterOverflowCut(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65569, null, j)) == null) ? j >= 0 ? j : j + 4294967296L : invokeJ.longValue;
    }

    public static boolean isShowBjhBigV(BaijiahaoInfo baijiahaoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65674, null, baijiahaoInfo)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isUgcThreadType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65678, null, i)) == null) ? i == 1 || i == 2 || i == 3 || i == 4 : invokeI.booleanValue;
    }

    public static boolean isVideoThread(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65680, null, i)) == null) ? i == 2 || i == 6 || i == 8 : invokeI.booleanValue;
    }

    public static void startPushService(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65723, null, context) != null) || context == null) {
        }
    }

    public static void stopPushService(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65724, null, context) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public static class NativePage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String id;
        public NativePageType type;

        public NativePage() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.type = NativePageType.NONE;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class NativePageType {
        public static final /* synthetic */ NativePageType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final NativePageType FRS;
        public static final NativePageType NONE;
        public static final NativePageType PB;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(522512647, "Lcom/baidu/tbadk/core/util/UtilHelper$NativePageType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(522512647, "Lcom/baidu/tbadk/core/util/UtilHelper$NativePageType;");
                    return;
                }
            }
            NONE = new NativePageType(HlsPlaylistParser.METHOD_NONE, 0);
            FRS = new NativePageType("FRS", 1);
            NativePageType nativePageType = new NativePageType("PB", 2);
            PB = nativePageType;
            $VALUES = new NativePageType[]{NONE, FRS, nativePageType};
        }

        public NativePageType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static NativePageType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (NativePageType) Enum.valueOf(NativePageType.class, str);
            }
            return (NativePageType) invokeL.objValue;
        }

        public static NativePageType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (NativePageType[]) $VALUES.clone();
            }
            return (NativePageType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1657960181, "Lcom/baidu/tbadk/core/util/UtilHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1657960181, "Lcom/baidu/tbadk/core/util/UtilHelper;");
                return;
            }
        }
        pbPattern0 = Pattern.compile("(tieba.baidu.com/p/){1}([\\d]+)");
        sNativeAdPrefixes = new String[]{"http://m.baidu.com/baidu.php?url=", "https://m.baidu.com/baidu.php?url="};
        sNativeAdEncoded = new String[]{"http%3a%2f%2fm.baidu.com%2fbaidu.php%3furl%3d", "https%3a%2f%2fm.baidu.com%2fbaidu.php%3furl%3d"};
    }

    public static boolean canUseStyleImmersiveSticky() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (Build.VERSION.SDK_INT < 19 || TbadkCoreApplication.getInst() == null || !TbadkCoreApplication.getInst().isMeiZuCanUseImmersive() || isSMF9000()) {
                return false;
            }
            return TbadkCoreApplication.getInst().isImmersiveStickyCanUse();
        }
        return invokeV.booleanValue;
    }

    public static String getClientIP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            boolean isWifiNet = BdNetTypeUtil.isWifiNet();
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                if (isWifiNet) {
                    return getWifiMac(TbadkCoreApplication.getInst().getApp());
                }
                return getGprsIpv4Address();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static int getLightStatusBarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65592, null)) == null) {
            if (canUseStyleImmersiveSticky()) {
                try {
                    return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(wg.e(Class.forName("com.android.internal.R$dimen").getField(SapiSystemBarTintManager.SystemBarConfig.g).get(null).toString(), 0));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static String getNavBarOverride() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static long getNextDayMorning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65597, null)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis();
        }
        return invokeV.longValue;
    }

    public static int getStatusBarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65605, null)) == null) {
            try {
                return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(wg.e(Class.forName("com.android.internal.R$dimen").getField(SapiSystemBarTintManager.SystemBarConfig.g).get(null).toString(), 0));
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static int getStatusBarHeight_gtoe9_0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65606, null)) == null) {
            int identifier = TbadkCoreApplication.getInst().getResources().getIdentifier(SapiSystemBarTintManager.SystemBarConfig.g, EMABTest.TYPE_DIMEN, "android");
            if (identifier > 0) {
                return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static int getStatusBarHeight_ltoe9_0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65607, null)) == null) {
            try {
                return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(wg.e(Class.forName("com.android.internal.R$dimen").getField(SapiSystemBarTintManager.SystemBarConfig.g).get(null).toString(), 0));
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static String getTopActivityClassName() {
        InterceptResult invokeV;
        Activity b;
        ComponentName componentName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65613, null)) == null) {
            if (n9.g() == null || (b = n9.g().b()) == null || (componentName = b.getComponentName()) == null) {
                return null;
            }
            return componentName.getClassName();
        }
        return (String) invokeV.objValue;
    }

    public static boolean isMiNotchDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65658, null)) == null) {
            String g = zi.g();
            if (TextUtils.isEmpty(g)) {
                return false;
            }
            if (!g.contains("MI 8") && !g.contains("MI8")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isOppoDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65667, null)) == null) {
            String str = Build.BRAND;
            if (wi.isEmpty(str)) {
                return false;
            }
            if (!str.contains("OPPO") && !str.contains("oppo") && !str.contains("Oppo")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isVivoDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65682, null)) == null) {
            String str = Build.BRAND;
            if (wi.isEmpty(str)) {
                return false;
            }
            if (!str.contains("VIVO") && !str.contains("vivo") && !str.contains("Vivo")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public UtilHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void clearClipBoard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            try {
                ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setPrimaryClip(ClipData.newPlainText(null, null));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String getCurrentDay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        }
        return (String) invokeV.objValue;
    }

    public static String getDeviceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            return TbadkCoreApplication.getInst().getImei();
        }
        return (String) invokeV.objValue;
    }

    public static int getImmersiveStickyBarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) {
            if (canUseStyleImmersiveSticky()) {
                return getStatusBarHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static int getNetworkOperator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65596, null)) == null) {
            return BdNetTypeUtil.readNetworkOperatorType();
        }
        return invokeV.intValue;
    }

    public static long getTimesMorning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65611, null)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis();
        }
        return invokeV.longValue;
    }

    public static long getTodayZeroTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65612, null)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(13, 0);
            calendar.set(12, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis();
        }
        return invokeV.longValue;
    }

    public static boolean hasNotchMiui() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65624, null)) == null) {
            String systemProperty = getSystemProperty("ro.miui.notch");
            if (!StringUtils.isNULL(systemProperty) && systemProperty.equals("1")) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean hasNotchOPPO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65625, null)) == null) {
            return TbadkCoreApplication.getInst().getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        }
        return invokeV.booleanValue;
    }

    public static boolean isBackgroundProcessLimitNone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65637, null)) == null) {
            Object processLimit = getProcessLimit();
            if (processLimit == null || !processLimit.toString().equals(String.valueOf(0))) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isFlyMeOs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65642, null)) == null) {
            return Build.DISPLAY.toLowerCase().contains("flyme");
        }
        return invokeV.booleanValue;
    }

    public static boolean isFoldScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65644, null)) == null) {
            return isOppoFoldScreen();
        }
        return invokeV.booleanValue;
    }

    public static boolean isGotoVideoMiddlePage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65645, null)) == null) {
            if (SwitchManager.getInstance().findType(VideoMiddlePageSwitch.KEY) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isGotoVideoSquareMiddlePage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65646, null)) == null) {
            if (SwitchManager.getInstance().findType(VideoSquareMiddlePageSwitch.KEY) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isHuaWeiU9508Device() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65649, null)) == null) {
            String g = zi.g();
            if (TextUtils.isEmpty(g) || !g.contains("Huawei_HUAWEI U9508")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isMeizuE3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65655, null)) == null) {
            String str = Build.BRAND;
            String g = zi.g();
            if ("Meizu".equalsIgnoreCase(str) && "MEIZU E3".equalsIgnoreCase(g)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isMeizuM355() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65656, null)) == null) {
            String str = Build.BRAND;
            String g = zi.g();
            if ("Meizu".equalsIgnoreCase(str) && "M355".equalsIgnoreCase(g)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isMeizuPro7Plus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65657, null)) == null) {
            String str = Build.BRAND;
            String g = zi.g();
            if ("Meizu".equalsIgnoreCase(str) && "PRO 7 Plus".equalsIgnoreCase(g)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isNightOrDarkMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65662, null)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType == 1 || skinType == 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isOnePlus6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65665, null)) == null) {
            String str = Build.BRAND;
            String g = zi.g();
            if ("OnePlus".equalsIgnoreCase(str) && "ONEPLUS A6000".equalsIgnoreCase(g)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isOppoFoldScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65669, null)) == null) {
            if ("OPPO".equalsIgnoreCase(RomUtils.getManufacturer()) && "PEUM00".equalsIgnoreCase(RomUtils.getDeviceModel())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isSMF9000() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65671, null)) == null) {
            return zi.g().equalsIgnoreCase("SM-F9000");
        }
        return invokeV.booleanValue;
    }

    public static boolean FirstStartActivity(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) activity.getSystemService("activity")).getRunningTasks(100)) {
                if (runningTaskInfo.baseActivity.getClassName().equals(activity.getClass().getName())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void addFollowUserIconStyle(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, tBSpecificationButtonConfig) == null) && tBSpecificationButtonConfig != null) {
            tBSpecificationButtonConfig.i(R.drawable.obfuscated_res_0x7f080969, 0, TBSpecificationButtonConfig.IconType.WEBP);
            tBSpecificationButtonConfig.h(R.color.CAM_X0304);
            tBSpecificationButtonConfig.g(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26));
            tBSpecificationButtonConfig.f(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
        }
    }

    public static Bitmap getCacheBitmapFromView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, view2)) == null) {
            e95.k().i(xi.l(TbadkCoreApplication.getInst()) * xi.j(TbadkCoreApplication.getInst()) * 2);
            view2.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view2.getDrawingCache();
            Bitmap bitmap = null;
            if (drawingCache == null) {
                return null;
            }
            try {
                bitmap = Bitmap.createBitmap(drawingCache);
                view2.setDrawingCacheEnabled(false);
                return bitmap;
            } catch (OutOfMemoryError unused) {
                System.gc();
                return bitmap;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public static String getCurrentPageName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            if (context == null && n9.g().b() != null && "PbFullScreenEditorActivity".equals(n9.g().b().getClass().getSimpleName())) {
                Activity f = n9.g().f(n9.g().h() - 2);
                if (f instanceof vd5) {
                    return ((vd5) f).getCurrentPageKey();
                }
            }
            if (context instanceof vd5) {
                return ((vd5) context).getCurrentPageKey();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static int getScreenHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65601, null, context)) == null) {
            int i = 0;
            if (context == null) {
                return 0;
            }
            try {
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                i = displayMetrics.heightPixels;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i == 0) {
                return xi.j(context);
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static String getSystemProperty(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65608, null, str)) == null) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            } catch (IOException unused) {
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
                return readLine;
            } catch (IOException unused3) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused4) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }

    public static int getVirtualBarHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65616, null, context)) == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            try {
                Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                return displayMetrics.heightPixels - windowManager.getDefaultDisplay().getHeight();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static boolean hasAvaiableSDCardSpace(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65620, null, i)) == null) {
            try {
                if (!Environment.getExternalStorageState().equals("mounted")) {
                    return false;
                }
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                if ((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024 <= i) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public static boolean hasNavBar(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65621, null, context)) == null) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(SapiSystemBarTintManager.SystemBarConfig.k, "bool", "android");
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                String navBarOverride = getNavBarOverride();
                if ("1".equals(navBarOverride)) {
                    return false;
                }
                if ("0".equals(navBarOverride)) {
                    return true;
                }
                return z;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        return invokeL.booleanValue;
    }

    public static void quitDialog(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65685, null, activity) == null) {
            new iv4(activity).setTitle(R.string.obfuscated_res_0x7f0f0920).setCancelable(false).setMessageId(R.string.obfuscated_res_0x7f0f0268).setPositiveButton(R.string.obfuscated_res_0x7f0f026b, new iv4.e(activity) { // from class: com.baidu.tbadk.core.util.UtilHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Activity val$activity;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {activity};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$activity = activity;
                }

                @Override // com.baidu.tieba.iv4.e
                public void onClick(iv4 iv4Var) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, iv4Var) == null) {
                        iv4Var.dismiss();
                        TbadkCoreApplication.getInst().notifyAppEnterBackground();
                        this.val$activity.finish();
                    }
                }
            }).setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new iv4.e() { // from class: com.baidu.tbadk.core.util.UtilHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.tieba.iv4.e
                public void onClick(iv4 iv4Var) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, iv4Var) == null) {
                        iv4Var.dismiss();
                    }
                }
            }).create(w9.a(activity)).show();
        }
    }

    public static void startHardAccelerated(Window window) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65722, null, window) != null) || Build.VERSION.SDK_INT < 11) {
            return;
        }
        try {
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("FLAG_HARDWARE_ACCELERATED");
            declaredField.setAccessible(true);
            int i = declaredField.getInt(null);
            Window.class.getMethod("setFlags", Integer.TYPE, Integer.TYPE).invoke(window, Integer.valueOf(i), Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String appendCuidParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (!wi.isEmpty(str) && str.indexOf("cuid=") > -1) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf("?") > 0) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            if (!isNativeAdURL(str)) {
                sb.append("cuid=");
                sb.append(TbadkCoreApplication.getInst().getCuid());
                sb.append("&cuid_galaxy2=");
                sb.append(TbadkCoreApplication.getInst().getCuidGalaxy2());
                sb.append("&cuid_gid=");
                sb.append(TbadkCoreApplication.getInst().getCuidGid());
            }
            sb.append("&timestamp=");
            sb.append(Long.toString(System.currentTimeMillis()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void showSkinChangeAnimation(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65712, null, activity) == null) && !hi5.a() && activity != null) {
            View decorView = activity.getWindow().getDecorView();
            Bitmap cacheBitmapFromView = getCacheBitmapFromView(decorView);
            if ((decorView instanceof ViewGroup) && cacheBitmapFromView != null) {
                View view2 = new View(activity);
                view2.setBackgroundDrawable(new BitmapDrawable(activity.getResources(), cacheBitmapFromView));
                ((ViewGroup) decorView).addView(view2, new ViewGroup.LayoutParams(-1, -1));
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ofFloat.addListener(new AnimatorListenerAdapter(decorView, view2, cacheBitmapFromView) { // from class: com.baidu.tbadk.core.util.UtilHelper.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Bitmap val$cacheBitmap;
                    public final /* synthetic */ View val$decorView;
                    public final /* synthetic */ View val$view;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {decorView, view2, cacheBitmapFromView};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$decorView = decorView;
                        this.val$view = view2;
                        this.val$cacheBitmap = cacheBitmapFromView;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                            super.onAnimationEnd(animator);
                            ((ViewGroup) this.val$decorView).removeView(this.val$view);
                            Bitmap bitmap = this.val$cacheBitmap;
                            if (bitmap != null && !bitmap.isRecycled()) {
                                this.val$cacheBitmap.recycle();
                            }
                        }
                    }
                });
                ofFloat.start();
            }
        }
    }

    public static String appendVersionCode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!wi.isEmpty(str) && str.indexOf("_client_version=") > -1) {
                return str;
            }
            return str + "&_client_version=" + TbConfig.getVersion();
        }
        return (String) invokeL.objValue;
    }

    public static String formatNumber(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            StringBuilder sb = new StringBuilder("");
            if (str != null) {
                int i = 0;
                for (int length = str.length() - 1; length >= 0; length--) {
                    sb.insert(0, str.charAt(length));
                    i++;
                    if (i % 3 == 0 && length != 0) {
                        sb.insert(0, ",");
                        i = 0;
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static int getFixedTextSize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (str.charAt(i2) > 255) {
                    i += 2;
                } else {
                    i++;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static String getFromPageKey(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, tbPageContext)) == null) {
            if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof vd5)) {
                return null;
            }
            vd5 vd5Var = (vd5) tbPageContext.getPageActivity();
            if (vd5Var.getCurrentPageSourceKeyList() == null) {
                return null;
            }
            return (String) ListUtils.getItem(vd5Var.getCurrentPageSourceKeyList(), vd5Var.getCurrentPageSourceKeyList().size() - 1);
        }
        return (String) invokeL.objValue;
    }

    public static String getWifiMac(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65617, null, context)) == null) {
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                try {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (!wifiManager.isWifiEnabled()) {
                        wifiManager.setWifiEnabled(true);
                    }
                    return intToIp(wifiManager.getConnectionInfo().getIpAddress());
                } catch (Exception e) {
                    BdLog.e(e.toString());
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void goToMessageCenterFromNotifyCenter(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65619, null, i) == null) {
            Intent intent = new Intent();
            intent.putExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, i);
            intent.putExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016321, intent));
            fy4.e(TbadkCoreApplication.getInst().getApplicationContext(), 3);
        }
    }

    public static boolean hasNotchAndroidP(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65622, null, activity)) == null) {
            if (activity == null) {
                return false;
            }
            try {
                View decorView = activity.getWindow().getDecorView();
                if (decorView == null || Build.VERSION.SDK_INT < 23) {
                    return false;
                }
                WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
                Method declaredMethod = WindowInsets.class.getDeclaredMethod("getDisplayCutout", new Class[0]);
                declaredMethod.setAccessible(true);
                if (declaredMethod.invoke(rootWindowInsets, new Object[0]) == null) {
                    return false;
                }
                return true;
            } catch (NoSuchMethodException | Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean hasNotchAtHuawei(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65623, null, activity)) == null) {
            if (activity == null) {
                return false;
            }
            try {
                Class<?> loadClass = activity.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
            } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String int2ver(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65630, null, i)) == null) {
            return ((i >> 24) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 8) & 255) + "." + (i & 255);
        }
        return (String) invokeI.objValue;
    }

    public static String intToIp(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65631, null, i)) == null) {
            return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
        }
        return (String) invokeI.objValue;
    }

    public static boolean isCutoutScreen(Activity activity) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65639, null, activity)) == null) {
            try {
                Resources resources = activity.getResources();
                int identifier = resources.getIdentifier("config_mainBuiltInDisplayCutout", EMABTest.TYPE_STRING, "android");
                if (identifier > 0) {
                    str = resources.getString(identifier);
                } else {
                    str = null;
                }
                if (str == null) {
                    return false;
                }
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isNativeAdURL(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65659, null, str)) == null) {
            if (str == null) {
                return false;
            }
            for (String str2 : sNativeAdPrefixes) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            for (String str3 : sNativeAdEncoded) {
                if (str.contains(str3)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isNotchScreen(Activity activity) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65663, null, activity)) == null) {
            boolean z2 = false;
            if (Build.VERSION.SDK_INT >= 28) {
                z = hasNotchAndroidP(activity);
            } else {
                z = false;
            }
            if (!z) {
                return (hasNotchMiui() || hasNotchAtHuawei(activity) || isOnePlus6() || hasNotchOPPO() || hasNotchVivo()) ? true : true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean isPhoneNumber(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65670, null, str)) == null) {
            if (StringUtils.isNull(str) || !isNumber(str) || str.length() != 11 || !str.startsWith("1")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isSelf(MetaData metaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65673, null, metaData)) == null) {
            if (metaData == null) {
                return false;
            }
            String userId = metaData.getUserId();
            if (StringUtils.isNull(userId)) {
                return false;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount) || !currentAccount.equals(userId)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isSystemLocationProviderEnabled(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65676, null, context)) == null) {
            if (!sf.n().h() || !PermissionUtil.checkLocationForGoogle(context)) {
                return false;
            }
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                if (!locationManager.isProviderEnabled("gps")) {
                    if (!locationManager.isProviderEnabled("network")) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isTopActivity(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65677, null, str)) == null) {
            Activity b = n9.g().b();
            if (b != null && b.getClass().getSimpleName() != null && b.getClass().getSimpleName().equals(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean useNavigationBarStyleImmersiveSticky(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65728, null, activity)) == null) {
            boolean z = false;
            boolean useNavigationBarStyleImmersiveSticky = useNavigationBarStyleImmersiveSticky(activity, false);
            changeStatusBarIconAndTextColor((TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) ? true : true, activity);
            return useNavigationBarStyleImmersiveSticky;
        }
        return invokeL.booleanValue;
    }

    public static void useNavigationBarStyleImmersiveSticky_KitKat(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65730, null, activity) != null) || activity == null) {
            return;
        }
        boolean z = false;
        int i = -1;
        try {
            Field field = WindowManager.LayoutParams.class.getField("FLAG_TRANSLUCENT_STATUS");
            if (field != null) {
                i = field.getInt(null);
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (z) {
            activity.getWindow().setFlags(i, i);
        }
    }

    public static int ver2int(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65735, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            int i = 0;
            for (int i2 = 0; i2 < split.length; i2++) {
                i |= Integer.valueOf(split[i2]).intValue() << ((3 - i2) * 8);
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static final boolean webViewIsProbablyCorrupt(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65736, null, context)) == null) {
            try {
                SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("webviewCache.db", 0, null);
                if (openOrCreateDatabase != null) {
                    yi.b(openOrCreateDatabase);
                    return false;
                }
                yi.b(openOrCreateDatabase);
                return true;
            } catch (Throwable th) {
                try {
                    if (BdLog.isDebugMode()) {
                        BdLog.e(th.getMessage());
                    }
                    return true;
                } finally {
                    yi.b(null);
                }
            }
        }
        return invokeL.booleanValue;
    }

    public static void callPhone(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, context, str) == null) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                BdLog.detailException(e);
            } catch (SecurityException e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public static boolean dealOneScheme(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, str)) == null) {
            if (context != null && !wi.isEmpty(str)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (!(context instanceof Activity)) {
                    intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                }
                if (isIntentAvailable(context, intent)) {
                    try {
                        context.startActivity(intent);
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String formatOverStep(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65557, null, str, i)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            if (str.length() <= i) {
                return str;
            }
            return str.substring(0, i) + StringHelper.STRING_MORE;
        }
        return (String) invokeLI.objValue;
    }

    public static String getMetaValue(Context context, String str) {
        InterceptResult invokeLL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65593, null, context, str)) == null) {
            if (context == null) {
                return null;
            }
            if (str != null) {
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null) {
                        bundle = applicationInfo.metaData;
                    } else {
                        bundle = null;
                    }
                    if (bundle == null) {
                        return null;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    return null;
                }
            }
            return bundle.getString(str);
        }
        return (String) invokeLL.objValue;
    }

    public static void hideStatusBar(Activity activity, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65627, null, activity, view2) == null) && activity != null && view2 != null) {
            if (Build.VERSION.SDK_INT < 16) {
                if (activity.getWindow() != null) {
                    activity.getWindow().setFlags(1024, 1024);
                    return;
                } else {
                    view2.setSystemUiVisibility(2);
                    return;
                }
            }
            view2.setSystemUiVisibility(4);
        }
    }

    public static void installApkFile(Context context, File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65628, null, context, file) == null) && file != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(getUriFromFile(file, intent, context), "application/vnd.android.package-archive");
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                if (!isHaveActivityCanHandleIntent(intent)) {
                    return;
                }
                context.startActivity(intent);
            } catch (SecurityException unused) {
            }
        }
    }

    public static void install_apk(Context context, String str) {
        File GetFile;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65629, null, context, str) == null) && str != null && str.length() > 0 && (GetFile = FileHelper.GetFile(str)) != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(getUriFromFile(GetFile, intent, context), "application/vnd.android.package-archive");
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                if (!isHaveActivityCanHandleIntent(intent)) {
                    return;
                }
                context.startActivity(intent);
            } catch (SecurityException unused) {
            }
        }
    }

    public static boolean isSameDay(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65672, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (j > j2 || j / 86400000 != j2 / 86400000) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isViewPrimary(View view2, boolean z) {
        InterceptResult invokeLZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65681, null, view2, z)) == null) {
            if (view2 == null) {
                return false;
            }
            if (z) {
                i = getDimenPixelSize(R.dimen.tbds144);
            } else {
                i = 0;
            }
            int j = xi.j(TbadkCoreApplication.getInst());
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int i2 = iArr[1];
            if (i2 <= 0 || i2 >= j - i) {
                return false;
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public static void setNavigationBarBackground_K(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65691, null, activity, i) == null) {
            activity.getWindow().addFlags(134217728);
            View view2 = new View(activity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ni.b(activity));
            layoutParams.gravity = 80;
            view2.setLayoutParams(layoutParams);
            view2.setBackgroundColor(i);
            ((ViewGroup) activity.getWindow().getDecorView()).addView(view2);
        }
    }

    public static void showStatusBar(Activity activity, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65713, null, activity, view2) == null) && activity != null && view2 != null) {
            if (Build.VERSION.SDK_INT < 16) {
                if (activity.getWindow() != null) {
                    activity.getWindow().clearFlags(1024);
                    return;
                } else {
                    view2.setSystemUiVisibility(0);
                    return;
                }
            }
            view2.setSystemUiVisibility(0);
        }
    }

    public static void startBaiduWebView(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65721, null, context, str) == null) {
            if (str != null && str.length() > 0) {
                rp4.n(context, "http://m.baidu.com/s?from=1001157a&word=" + str);
                return;
            }
            rp4.n(context, "http://m.baidu.com/?from=1001157a");
        }
    }

    public static void changeFlyMeStatusBarColor(Window window, boolean z) {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, null, window, z) == null) {
            if (canUseStyleImmersiveSticky()) {
                StatusbarColorUtils.setStatusBarDarkIcon(window, z);
            } else if (Build.VERSION.SDK_INT >= 19 && window != null) {
                try {
                    window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                    window.addFlags(Integer.MIN_VALUE);
                    Method declaredMethod = Window.class.getDeclaredMethod("setStatusBarColor", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    if (z) {
                        color = SkinManager.getColor(R.color.black_alpha60);
                    } else {
                        color = SkinManager.getColor(R.color.common_color_10274);
                    }
                    declaredMethod.invoke(window, Integer.valueOf(color));
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
        }
    }

    public static Drawable getSelectorDrawableByAlpha(@DrawableRes int i, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65602, null, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            Drawable drawable = SkinManager.getDrawable(i);
            Drawable drawable2 = SkinManager.getDrawable(i);
            drawable2.mutate();
            drawable2.setAlpha((int) (f * 255.0f));
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable2);
            stateListDrawable.addState(new int[0], drawable);
            return stateListDrawable;
        }
        return (Drawable) invokeCommon.objValue;
    }

    public static void setFlymeImmersedWindow(Window window, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65687, null, window, z) == null) && z && window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (Build.VERSION.SDK_INT < 19) {
                try {
                    Field declaredField = attributes.getClass().getDeclaredField("meizuFlags");
                    declaredField.setAccessible(true);
                    int i2 = declaredField.getInt(attributes);
                    if (z) {
                        i = i2 | 64;
                    } else {
                        i = i2 & (-65);
                    }
                    declaredField.setInt(attributes, i);
                    return;
                } catch (Exception e) {
                    BdLog.e(e);
                    return;
                }
            }
            attributes.flags |= CodedInputStream.DEFAULT_SIZE_LIMIT;
            window.setAttributes(attributes);
        }
    }

    public static void smsPhone(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65717, null, context, str) == null) {
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
            intent.putExtra("sms_body", "");
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                BdLog.detailException(e);
            } catch (SecurityException e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public static String urlAddParam(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65727, null, str, str2)) == null) {
            if (str != null && str2 != null) {
                if (str.indexOf("?") < 0) {
                    str = str + "?";
                } else if (!str.endsWith("?") && !str.endsWith("&")) {
                    str = str + "&";
                }
                return str + str2;
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static void changeStatusBarIconAndTextColor(boolean z, Activity activity) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(65545, null, z, activity) == null) && activity != null && activity.getWindow() != null && !isMeizuM355()) {
            if (Build.DISPLAY.toLowerCase().contains("flyme") && Build.VERSION.SDK_INT < 28) {
                changeFlyMeStatusBarColor(activity.getWindow(), z);
                setFlymeImmersedWindow(activity.getWindow(), canUseStyleImmersiveSticky());
            }
            if (Build.VERSION.SDK_INT < 23) {
                StatusBarUtil.from(activity).setTransparentStatusbar(true).setLightStatusBar(!z).process();
                return;
            }
            View decorView = activity.getWindow().getDecorView();
            if (decorView == null || Build.VERSION.SDK_INT < 23) {
                return;
            }
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z) {
                i = systemUiVisibility & (-8193);
            } else {
                if (TbadkCoreApplication.getInst().isMIUIRom()) {
                    Window window = activity.getWindow();
                    window.addFlags(Integer.MIN_VALUE);
                    window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                }
                i = systemUiVisibility | 8192;
            }
            decorView.setSystemUiVisibility(i);
        }
    }

    public static RectF fixedDrawableRect(Rect rect, View view2) {
        InterceptResult invokeLL;
        GifView gifView;
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, rect, view2)) == null) {
            if (rect != null) {
                boolean z = view2 instanceof TbImageView;
                if (z || (view2 instanceof GifView)) {
                    RectF rectF = new RectF();
                    if (z) {
                        rectF.right = rectF.left + tbImageView.getImageWidth();
                        rectF.bottom = rectF.top + tbImageView.getImageHeight();
                        ((TbImageView) view2).getImageMatrix().mapRect(rectF);
                    } else if (view2 instanceof GifView) {
                        rectF.right = rectF.left + gifView.getImageWidth();
                        rectF.bottom = rectF.top + gifView.getImageHeight();
                        ((GifView) view2).getImageMatrix().mapRect(rectF);
                    }
                    float f = rectF.left;
                    int i = rect.left;
                    rectF.left = f + i;
                    rectF.right += i;
                    float f2 = rectF.top;
                    int i2 = rect.top;
                    rectF.top = f2 + i2;
                    rectF.bottom += i2;
                    return rectF;
                }
                return null;
            }
            return null;
        }
        return (RectF) invokeLL.objValue;
    }

    public static void startBaiDuBar(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65720, null, context, str) == null) {
            try {
                TiebaStatic.eventStat(context, "search_in_baidu", "searchclick", 1, new Object[0]);
                Intent intent = new Intent();
                intent.addCategory("android.intent.category.DEFAULT");
                if (!TextUtils.isEmpty(str)) {
                    intent.setAction("com.baidu.searchbox.action.SEARCH");
                    intent.putExtra("key_value", str);
                } else {
                    intent.setAction("com.baidu.searchbox.action.VIEW");
                    intent.setData(Uri.parse(TbDomainConfig.DOMAIN_HTTPS_BAIDU));
                }
                intent.putExtra("BROWSER_RESTART", true);
                intent.putExtra("EXTRA_URL_NEW_WINDOW", true);
                intent.putExtra("isBackToLauncher", true);
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                if (TbConfig.IS_START_BAIDU_KUANG_CLOSE_SELF) {
                    n9.g().p();
                }
                context.startActivity(intent);
            } catch (Exception unused) {
                startBaiduWebView(context, str);
            }
        }
    }

    public static boolean checkAiAppGuideResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get("aiapp_guide.gif"))) {
                RequestParams requestParams = new RequestParams();
                requestParams.setRunType(jm.a);
                requestParams.setRunNode("aps");
                requestParams.addChannel(new im("com.baidu.tieba.resloader.aiappguide", (DefaultDownloadCallback) null));
                PmsManager.getInstance().execute(requestParams);
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static String getClipBoardContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            String str = "";
            if (!PermissionUtil.isAgreePrivacyPolicy()) {
                return "";
            }
            try {
                ClipData primaryClip = ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).getPrimaryClip();
                if (primaryClip == null || primaryClip.getItemAt(0) == null || primaryClip.getItemAt(0).getText() == null) {
                    return "";
                }
                str = primaryClip.getItemAt(0).getText().toString();
                ((IBehaviorApi) ServiceManager.getService(IBehaviorApi.SERVICE_REFERENCE)).addBehavior(1, "clp", "tieba", "tieba");
                return str;
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getGprsIpAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress()) {
                            return nextElement.getHostAddress().toString();
                        }
                    }
                }
                return null;
            } catch (SocketException e) {
                BdLog.e(e.toString());
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getGprsIpv4Address() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        String hostAddress = nextElement.getHostAddress();
                        if (!nextElement.isLoopbackAddress() && InetAddressUtils.isIPv4Address(hostAddress)) {
                            return hostAddress;
                        }
                    }
                }
                return null;
            } catch (SocketException e) {
                BdLog.e(e.toString());
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean hasNotchVivo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65626, null)) == null) {
            try {
                Class<?> loadClass = TbadkCoreApplication.getInst().getClassLoader().loadClass("android.util.FtFeature");
                Method[] declaredMethods = loadClass.getDeclaredMethods();
                if (declaredMethods == null) {
                    return false;
                }
                for (Method method : declaredMethods) {
                    if (method != null && method.getName().equalsIgnoreCase("isFeatureSupport")) {
                        return ((Boolean) method.invoke(loadClass, 32)).booleanValue();
                    }
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean isAppForeground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65635, null)) == null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) TbadkCoreApplication.getInst().getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && !StringUtils.isNull(runningAppProcessInfo.processName) && runningAppProcessInfo.processName.equals(TbadkCoreApplication.getInst().getPackageName()) && runningAppProcessInfo.importance == 100) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isFlymeOsOver51() {
        InterceptResult invokeV;
        String r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65643, null)) == null) {
            String str = Build.DISPLAY;
            if (str != null && str.contains("Flyme") && (r = xi.r(str)) != null && r.length() >= 3) {
                int e = wg.e(xi.r(r.substring(0, 1)), 0);
                int e2 = wg.e(xi.r(r.substring(1, 2)), 0);
                if (e == 6 && e2 <= 1) {
                    return true;
                }
                if (e == 5 && e2 >= 1) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isOppoConcaveScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65666, null)) == null) {
            if (!TbadkCoreApplication.getInst().getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism")) {
                return false;
            }
            String g = zi.g();
            String[] strArr = {"PAAM00", "PAAT00", "PACM00", "PACT00", "CPH1831", "CPH1833"};
            for (int i = 0; i < 6; i++) {
                if (g.equalsIgnoreCase(strArr[i])) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void clearClipBoardBySchemaParam(String str) {
        Uri parse;
        String queryParameter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, str) == null) && !TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && (queryParameter = parse.getQueryParameter(KEY_HAS_TOKEN)) != null && queryParameter.equals("1")) {
            clearClipBoard();
        }
    }

    public static void copyToClipBoard(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            try {
                ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setPrimaryClip(ClipData.newPlainText("", str));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean detectOpenGLES20(Context context) {
        InterceptResult invokeL;
        ActivityManager activityManager;
        ConfigurationInfo deviceConfigurationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) == null || deviceConfigurationInfo.reqGlEsVersion < 131072) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String formalDecimalForTwo(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65555, null, f)) == null) {
            return new DecimalFormat("0.00").format(f);
        }
        return (String) invokeF.objValue;
    }

    public static String getAddressInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return StringHelper.cutChineseAndEnglishWithSuffix(str, 18, StringHelper.STRING_MORE);
        }
        return (String) invokeL.objValue;
    }

    public static String getAuthInfo(MetaData metaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, metaData)) == null) {
            return getAuthInfo(metaData, false, 16);
        }
        return (String) invokeL.objValue;
    }

    public static int getBitmapMaxMemory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            return CompatibleUtile.getInstance().getBitmapMaxMemory(context);
        }
        return invokeL.intValue;
    }

    public static Drawable getBjhBigVIconDrawable(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65564, null, i)) == null) {
            return SvgManager.getInstance().getMaskDrawable(i, SvgManager.SvgResourceStateType.NORMAL);
        }
        return (Drawable) invokeI.objValue;
    }

    public static String getCurrentVerson(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, context)) == null) {
            try {
                return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static int getDimenPixelSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65575, null, i)) == null) {
            int idByABTest = EMABTest.getIdByABTest(i, EMABTest.TYPE_DIMEN);
            if (idByABTest == 0) {
                return 0;
            }
            return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(idByABTest);
        }
        return invokeI.intValue;
    }

    public static String getForumNameWithBar(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, str)) == null) {
            return getForumNameWithGodBar(str, -1, false);
        }
        return (String) invokeL.objValue;
    }

    public static Intent getIntent(String str) {
        InterceptResult invokeL;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, null, str)) == null) {
            Intent intent2 = null;
            try {
                intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            } catch (Exception e) {
                e = e;
            }
            try {
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                return intent;
            } catch (Exception e2) {
                e = e2;
                intent2 = intent;
                e.printStackTrace();
                return intent2;
            }
        }
        return (Intent) invokeL.objValue;
    }

    public static String getIpFromDomain(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return InetAddress.getByName(str).getHostAddress();
            } catch (Exception e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static int getNavigationBarHeight(Context context) {
        InterceptResult invokeL;
        Resources resources;
        int identifier;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65595, null, context)) == null) {
            if (hasNavBar(context) && (identifier = (resources = context.getResources()).getIdentifier(SapiSystemBarTintManager.SystemBarConfig.h, EMABTest.TYPE_DIMEN, "android")) > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int getRealScreenOrientation(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65600, null, context)) == null) {
            int[] s = xi.s(context);
            int i = context.getResources().getConfiguration().orientation;
            if (i != 2 && s[0] > s[1]) {
                return 2;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static TbPageContext getTbPageContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65609, null, context)) == null) {
            if (context instanceof BaseActivity) {
                return ((BaseActivity) context).getPageContext();
            }
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public static String getUserName(com.baidu.tbadk.data.MetaData metaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65615, null, metaData)) == null) {
            if (metaData == null) {
                return "";
            }
            return metaData.getName_show();
        }
        return (String) invokeL.objValue;
    }

    public static boolean isActivityStartFromScheme(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65633, null, activity)) == null) {
            if (activity != null && activity.getIntent() != null) {
                return !wi.isEmpty(activity.getIntent().getDataString());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isAppAvilible(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65634, null, str)) == null) {
            try {
                TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(str, 1);
                return true;
            } catch (PackageManager.NameNotFoundException | NullPointerException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isAutoBrightness(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65636, null, context)) == null) {
            return CompatibleUtile.getInstance().isAutoBrightness(context);
        }
        return invokeL.booleanValue;
    }

    public static boolean isCurrentAccount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65638, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount) || !currentAccount.equals(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isDecimal(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65640, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            return Pattern.compile("[0-9|\\.]+").matcher(str).matches();
        }
        return invokeL.booleanValue;
    }

    public static boolean isFllowByPriorty(com.baidu.tbadk.data.MetaData metaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65641, null, metaData)) == null) {
            if (metaData == null) {
                return false;
            }
            int authType = metaData.getAuthType();
            if (authType != 1 && authType != 2 && authType != 3 && authType != 4) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isHaveActivityCanHandleDeeplink(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65647, null, str)) == null) {
            if (URLUtil.isNetworkUrl(str)) {
                return true;
            }
            return isHaveActivityCanHandleIntent(getIntent(str));
        }
        return invokeL.booleanValue;
    }

    public static boolean isHaveActivityCanHandleIntent(Intent intent) {
        InterceptResult invokeL;
        List<ResolveInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65648, null, intent)) == null) {
            PackageManager packageManager = TbadkCoreApplication.getInst().getPackageManager();
            if (packageManager != null) {
                list = packageManager.queryIntentActivities(intent, 32);
            } else {
                list = null;
            }
            if (ListUtils.getCount(list) <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isLargeScreen(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65653, null, context)) == null) {
            if ((context.getResources().getConfiguration().screenLayout & 15) == 3) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isNavigationbarShown(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65661, null, resources)) == null) {
            int identifier = resources.getIdentifier(SapiSystemBarTintManager.SystemBarConfig.k, "bool", "android");
            if (identifier > 0 && resources.getBoolean(identifier)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isNumber(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65664, null, str)) == null) {
            return Pattern.compile("[0-9]+").matcher(str).matches();
        }
        return invokeL.booleanValue;
    }

    public static boolean isOppoFoldLargeScreen(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65668, null, context)) == null) {
            if (isOppoFoldScreen() && isLargeScreen(context)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isSupportGesture(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65675, null, context)) == null) {
            if (Build.VERSION.SDK_INT > 4 && CompatibleUtile.getInstance().supportMultiTouch(context)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isUseSingleGod(UserData userData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65679, null, userData)) == null) {
            if (userData != null && userData.getGodUserData() != null && userData.getGodUserData().getType() == 2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void openGpu(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65683, null, activity) == null) {
            CompatibleUtile.getInstance().openGpu(activity);
        }
    }

    public static void setTranslucentVirtualNavigation(Activity activity) {
        Window window;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65698, null, activity) == null) && (window = activity.getWindow()) != null && Build.VERSION.SDK_INT >= 19) {
            window.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            window.addFlags(134217728);
        }
    }

    @Nullable
    public static TbPageContext tryCastPageContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65726, null, context)) == null) {
            if (context instanceof BaseActivity) {
                return ((BaseActivity) context).getPageContext();
            }
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public static void useNavigationBarStyleImmersiveSticky_L(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65731, null, activity) == null) {
            useNavigationBarStyleImmersiveSticky_L(activity, false, false);
        }
    }

    public static boolean commenDealIntent(Context context, Intent intent) {
        InterceptResult invokeLL;
        String str;
        String str2;
        PbActivityConfig createNormalCfg;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        int i2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, intent)) == null) {
            boolean z5 = false;
            if (intent != null && intent.getExtras() != null) {
                int i3 = intent.getExtras().getInt(DealIntentService.KEY_CLASS, -1);
                TbPageContext<BaseFragmentActivity> tbPageContext = null;
                String str4 = "";
                switch (i3) {
                    case 0:
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        rp4.o(context, intent.getExtras().getString("url"));
                        str4 = intent.getExtras().getString("url");
                        z5 = true;
                        break;
                    case 1:
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        String stringExtra = intent.getStringExtra("id");
                        String stringExtra2 = intent.getStringExtra("from");
                        String string = intent.getExtras().getString("stat");
                        String stringExtra3 = intent.getStringExtra("link");
                        String stringExtra4 = intent.getStringExtra("task_id");
                        if (!wi.isEmpty(stringExtra4)) {
                            TbadkCoreApplication.getInst().setTaskId(stringExtra4);
                        }
                        boolean booleanExtra = intent.getBooleanExtra(TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY, false);
                        long j = intent.getExtras().getLong("message_id");
                        int i4 = intent.getExtras().getInt("video_channel_id", 0);
                        if (i4 > 0) {
                            TiebaStatic.log(new StatisticItem("c11918").param("obj_id", i4));
                        }
                        if (intent.getBooleanExtra("is_message_pv", false)) {
                            createNormalCfg = new PbActivityConfig(context).createMessageCfg(stringExtra, null, stringExtra2, j, stringExtra3, string, "op");
                        } else {
                            createNormalCfg = new PbActivityConfig(context).createNormalCfg(stringExtra, null, stringExtra2);
                        }
                        if (booleanExtra) {
                            createNormalCfg.setFromPushNotify();
                            String stringExtra5 = intent.getStringExtra(TbEnum.ParamKey.GID);
                            if (!TextUtils.isEmpty(stringExtra5)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(stringExtra5 + "", 4)));
                            }
                        }
                        if (intent.getBooleanExtra("key_is_from_local_push", false)) {
                            TiebaStatic.log(new StatisticItem("c13265"));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                        str4 = stringExtra3;
                        z5 = true;
                        break;
                    case 2:
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(context).createNormalCfg(intent.getStringExtra("fname"), intent.getStringExtra("from"));
                        createNormalCfg2.setCallFrom(13);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                        z5 = true;
                        break;
                    case 3:
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        if (fy4.b() != null) {
                            intent.setClass(context, fy4.b());
                            if (!(context instanceof Activity) && intent != null) {
                                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                            }
                            intent.addFlags(603979776);
                            context.startActivity(intent);
                        }
                        z5 = true;
                        break;
                    case 4:
                    case 6:
                    case 7:
                    case 10:
                    case 14:
                    case 16:
                    case 17:
                    case 20:
                    case 26:
                    default:
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = false;
                        break;
                    case 5:
                    case 11:
                    case 21:
                    case 35:
                        int intExtra = intent.getIntExtra("agree_me", 0);
                        int intExtra2 = intent.getIntExtra("at_me", 0);
                        int intExtra3 = intent.getIntExtra("reply_me", 0);
                        int intExtra4 = intent.getIntExtra("chat", 0);
                        int intExtra5 = intent.getIntExtra("group_msg", 0);
                        int intExtra6 = intent.getIntExtra("group_msg_validate", 0);
                        int intExtra7 = intent.getIntExtra("group_msg_updates", 0);
                        int intExtra8 = intent.getIntExtra("officialbar_msg", 0);
                        String stringExtra6 = intent.getStringExtra("replyme_jump_scheme");
                        if (TextUtils.isEmpty(stringExtra6)) {
                            stringExtra6 = UrlSchemaHelper.SCHEMA_REPLY_ME;
                        }
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        int intExtra9 = intent.getIntExtra("KeyOfNotiId", 16);
                        int t = g35.h0().t();
                        int A = g35.h0().A();
                        int u = g35.h0().u();
                        int s = g35.h0().s();
                        int x = g35.h0().x();
                        int y = g35.h0().y();
                        g35.h0().W(t, A, u, s, x, y);
                        if (intExtra4 <= 0 && intExtra7 <= 0 && intExtra6 <= 0 && intExtra5 <= 0 && intExtra8 <= 0) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (intExtra9 == 29 && intExtra > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (intExtra9 == 24 && intExtra3 > 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (intExtra9 == 25 && intExtra2 > 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z2) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(context)));
                            g35.h0().Y(0);
                        } else if (z3) {
                            g35.h0().f0(0);
                            TbPageContext<?> tryCastPageContext = tryCastPageContext(context);
                            if (tryCastPageContext != null) {
                                UrlManager.getInstance().dealOneLink(tryCastPageContext, new String[]{stringExtra6});
                            }
                            g35.h0().f0(0);
                        } else if (z4) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMeActivityConfig(context)));
                            g35.h0().Z(0);
                        } else if (i3 == 35) {
                            if (!z && intExtra <= 0 && intExtra3 <= 0 && intExtra2 <= 0 && y <= 0 && s <= 0) {
                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                    i = TbadkCoreApplication.getCurrentAccountInfo().getSex();
                                } else {
                                    i = 0;
                                }
                                if (currentAccount != null && currentAccount.length() > 0) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(context, false, currentAccount, i)));
                                    g35.h0().c0(0);
                                }
                            } else {
                                goToMessageCenterFromNotifyCenter(intExtra9);
                            }
                        } else if (z) {
                            TiebaStatic.log(TbadkCoreStatisticKey.PUSH_MESSAGE_CLICK);
                            if (i3 == 5 && fy4.a() == 3) {
                                goToMessageCenterFromNotifyCenter(intExtra9);
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(context, intent.getIntExtra(TiebaStatic.Params.TAB_ID, -1))));
                                Intent intent2 = new Intent();
                                intent2.putExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, intExtra9);
                                intent2.putExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 2);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016321, intent2));
                            }
                        }
                        z5 = true;
                        break;
                    case 8:
                        fy4.e(context, 2);
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                        break;
                    case 9:
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(context);
                        } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(context)));
                        } else {
                            fy4.e(context, 1);
                        }
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                        break;
                    case 12:
                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                        if (fy4.a() == 8) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createNormalCfg(8)));
                        } else if (!TextUtils.isEmpty(currentAccount2) && !TextUtils.isEmpty(currentAccountName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, currentAccount2, currentAccountName, g35.h0().x())));
                        }
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                        break;
                    case 13:
                        MessageManager.getInstance().sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(context, wg.g(intent.getStringExtra(DBTableDefine.GroupMessageColumns.COLUMN_GROUPID), 0L), 0)));
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                        break;
                    case 15:
                        fe5.c().a(new PayConfig(wg.e(intent.getStringExtra(MemberPayActivityConfig.PAY_TYPE), 0), intent.getStringExtra("is_left"), intent.getStringExtra("props_id"), intent.getStringExtra("quan_num"), intent.getStringExtra("props_mon"), true, intent.getStringExtra(MemberPayStatistic.REFER_PAGE), intent.getStringExtra(MemberPayStatistic.CLICK_ZONE)), context);
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        break;
                    case 18:
                        MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(context, "", false)));
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                        break;
                    case 19:
                        MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(context)));
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                        break;
                    case 22:
                        String stringExtra7 = intent.getStringExtra("barid");
                        String stringExtra8 = intent.getStringExtra("barname");
                        String stringExtra9 = intent.getStringExtra("portrait");
                        long g = wg.g(stringExtra7, -1L);
                        if (g > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(context, g, stringExtra8, stringExtra9, 0)));
                            str = DealIntentService.KEY_CLASS;
                            str2 = "push";
                            z5 = true;
                            break;
                        }
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        break;
                    case 23:
                        String stringExtra10 = intent.getStringExtra("wanted_type");
                        String stringExtra11 = intent.getStringExtra("from_type");
                        String stringExtra12 = intent.getStringExtra(MemberPayStatistic.REFER_PAGE);
                        String stringExtra13 = intent.getStringExtra(MemberPayStatistic.CLICK_ZONE);
                        int parseInt = Integer.parseInt(stringExtra10);
                        if (!StringUtils.isNull(stringExtra11)) {
                            if (stringExtra11.equals(TbadkCoreStatisticKey.TAIL_PAY_MEMBER_SUCCESS)) {
                                i2 = 6;
                            } else if (stringExtra11.equals(TbadkCoreStatisticKey.BUBBLE_PAY_MEMBER_SUCCESS)) {
                                i2 = 7;
                            }
                            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(context, parseInt, false, i2);
                            memberPayActivityConfig.setReferPageClickZone(stringExtra12, stringExtra13);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                            str = DealIntentService.KEY_CLASS;
                            str2 = "push";
                            z5 = true;
                            break;
                        }
                        i2 = 0;
                        MemberPayActivityConfig memberPayActivityConfig2 = new MemberPayActivityConfig(context, parseInt, false, i2);
                        memberPayActivityConfig2.setReferPageClickZone(stringExtra12, stringExtra13);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig2));
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                    case 24:
                        String currentAccount3 = TbadkCoreApplication.getCurrentAccount();
                        String currentAccountName2 = TbadkCoreApplication.getCurrentAccountName();
                        if (currentAccount3 != null && currentAccount3.length() > 0) {
                            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                str3 = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
                            } else {
                                str3 = currentAccountName2;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(context, currentAccount3, currentAccountName2, str3, 0)));
                        }
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                        break;
                    case 25:
                        CurrencyJumpHelper.nativeGotoBuyBean(context);
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                        break;
                    case 27:
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(context, wg.g(intent.getStringExtra("uid"), 0L), intent.getStringExtra("uname"), null, 0, intent.getIntExtra("user_type", 0))));
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                        break;
                    case 28:
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(context, wg.g(intent.getStringExtra(PbChosenActivityConfig.KEY_TID), 0L), null)));
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                        break;
                    case 29:
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(context, wg.g(intent.getStringExtra(PbChosenActivityConfig.KEY_TID), 0L), null, 2)));
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                        break;
                    case 30:
                        String string2 = intent.getExtras().getString(BigdayActivityConfig.JUMP_URL);
                        boolean z6 = intent.getExtras().getBoolean("is_ad", false);
                        if (intent.getExtras().getBoolean("gd_ad", false) && !StringUtils.isNull(string2)) {
                            wf8.a(TbadkCoreApplication.getInst(), string2, ej.c(string2), intent.getExtras().getString("ext_info", ""), null);
                        } else {
                            v9 c = w9.c(context);
                            if (c instanceof BaseActivity) {
                                UrlManager.getInstance().dealOneLink(((BaseActivity) c).getPageContext(), new String[]{string2}, z6);
                            } else if (c instanceof BaseFragmentActivity) {
                                UrlManager.getInstance().dealOneLink(((BaseFragmentActivity) c).getPageContext(), new String[]{string2}, z6);
                            }
                        }
                        str4 = string2;
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                        break;
                    case 31:
                        TiebaStatic.log(TbadkCoreStatisticKey.PUSH_ENTRANCE);
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                        break;
                    case 32:
                        try {
                            PaymentConfirmRequestData paymentConfirmRequestData = (PaymentConfirmRequestData) intent.getSerializableExtra(PaymentConfirmActivityConfig.REQUEST_PARAMS);
                            if (paymentConfirmRequestData != null) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PaymentConfirmActivityConfig(context, paymentConfirmRequestData, "", "")));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                        break;
                    case 33:
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001259));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(context)));
                        TiebaStatic.log(TbadkCoreStatisticKey.PL_COLLECT_UPDATE_NOTIFICATION);
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                        break;
                    case 34:
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoListActivityConfig(context).createNormalCfg(intent.getStringExtra("fid"), intent.getStringExtra("tid"), "push")));
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                        break;
                    case 36:
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(context, intent.getIntExtra(TiebaStatic.Params.TAB_ID, -1))));
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                        break;
                    case 37:
                        String stringExtra14 = intent.getStringExtra(IntentConfig.KEY_AI_APP_SCHEMA);
                        if (context instanceof BaseActivity) {
                            tbPageContext = ((BaseActivity) context).getPageContext();
                        } else if (context instanceof BaseFragmentActivity) {
                            tbPageContext = ((BaseFragmentActivity) context).getPageContext();
                        }
                        if (tbPageContext != null) {
                            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{stringExtra14});
                        }
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                        break;
                    case 38:
                        if (checkAiAppGuideResource()) {
                            ky4.k().u("key_ai_app_guide_display", false);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AiAppGuideActivityConfig(context)));
                        }
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                        break;
                    case 39:
                        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(context).createSubPbActivityConfig(intent.getStringExtra("thread_id"), intent.getStringExtra("post_id"), "", true);
                        createSubPbActivityConfig.setIsFromeSchema(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z5 = true;
                        break;
                }
                if (z5) {
                    GrowthStatsUtil.statisticChannel(str2, str4);
                }
                if (!z5) {
                    intent.putExtra(str, 3);
                    return commenDealIntent(context, intent);
                }
                return z5;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void commenDealUrl(Context context, String str, String... strArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65550, null, context, str, strArr) == null) && !TextUtils.isEmpty(str)) {
            if (str.length() > 4 && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_WEB)) {
                String substring = str.substring(4);
                String str2 = strArr[0];
                if (!TextUtils.isEmpty(substring)) {
                    rp4.r(context, str2, substring, false);
                }
            } else if (str.length() > 4 && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_FRS)) {
                String substring2 = str.substring(4);
                if (!TextUtils.isEmpty(substring2)) {
                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(context).createNormalCfg(substring2, "official_bar");
                    createNormalCfg.setCallFrom(13);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                }
            } else if (str.length() > 4 && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                String substring3 = str.substring(3);
                if (!TextUtils.isEmpty(substring3)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(context).createNormalCfg(substring3, null, "official_bar")));
                }
            }
        }
    }

    public static boolean parsePushMidPageUrl(String str, StringBuilder sb, StringBuilder sb2) {
        InterceptResult invokeLLL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65684, null, str, sb, sb2)) == null) {
            if (!str.contains("middlepage")) {
                return false;
            }
            String substring = str.substring(str.lastIndexOf(UrlSchemaHelper.SCHEMA_TYPE_MIDDLE_PAGE) + 11);
            String str4 = "";
            if (!substring.startsWith("flag=")) {
                str2 = "";
            } else {
                str2 = substring.substring(5, substring.indexOf("&"));
                substring = substring.substring(str2.length() + 1 + 5);
            }
            if (!"1".equals(str2)) {
                return false;
            }
            if (!substring.startsWith("fid=")) {
                str3 = "";
            } else {
                str3 = substring.substring(substring.lastIndexOf("fid=") + 4, substring.indexOf("&"));
                substring = substring.substring(str3.length() + 1 + 4);
            }
            if (substring.startsWith("tid=")) {
                str4 = substring.substring(substring.lastIndexOf("tid=") + 4);
            }
            if (StringUtils.isNull(str3) || StringUtils.isNull(str4)) {
                return false;
            }
            sb.append(str3);
            sb2.append(str4);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static String getAuthInfo(MetaData metaData, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, null, new Object[]{metaData, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (metaData == null) {
                return "";
            }
            if (isFllowByPriorty(metaData)) {
                if (metaData.getAuthType() == 1) {
                    if (metaData.isOfficial()) {
                        return "";
                    }
                } else if (metaData.getAuthType() == 2) {
                    if (metaData.isOriginal()) {
                        return metaData.getCreatorInfo().authDesc;
                    }
                } else if (metaData.getAuthType() == 3) {
                    if (metaData.isNewGod()) {
                        return metaData.getNewGodData().getFieldName() + sj5.c(metaData.isVideoGod());
                    }
                } else if (metaData.getAuthType() == 4 && !z && metaData.showBazhuGrade()) {
                    return StringHelper.cutChineseAndEnglishWithSuffix(metaData.getBazhuGradeData().getDesc(), i, StringHelper.STRING_MORE);
                }
            }
            if (TextUtils.isEmpty("") && metaData.isOfficial()) {
                return "";
            }
            if (TextUtils.isEmpty("") && metaData.isOriginal()) {
                return metaData.getCreatorInfo().authDesc;
            }
            if (TextUtils.isEmpty("") && metaData.isNewGod()) {
                return metaData.getNewGodData().getFieldName() + sj5.c(metaData.isVideoGod());
            } else if (!TextUtils.isEmpty("") || z || !metaData.showBazhuGrade()) {
                return "";
            } else {
                return StringHelper.cutChineseAndEnglishWithSuffix(metaData.getBazhuGradeData().getDesc(), i, StringHelper.STRING_MORE);
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static void useNavigationBarStyleImmersiveSticky_L(Window window, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65733, null, new Object[]{window, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || window == null) {
            return;
        }
        try {
            Field field = WindowManager.LayoutParams.class.getField("FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS");
            Field field2 = WindowManager.LayoutParams.class.getField("FLAG_TRANSLUCENT_STATUS");
            Field field3 = View.class.getField("SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN");
            Field field4 = View.class.getField("SYSTEM_UI_FLAG_LAYOUT_STABLE");
            Method method = window.getClass().getMethod("setStatusBarColor", Integer.TYPE);
            Method method2 = View.class.getMethod("setSystemUiVisibility", Integer.TYPE);
            if (field != null && field2 != null && field3 != null && field4 != null && method != null && method2 != null) {
                int i = field.getInt(null);
                int i2 = field2.getInt(null);
                int i3 = field3.getInt(null);
                int i4 = field4.getInt(null);
                window.clearFlags(i2);
                if (z2) {
                    Field field5 = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR");
                    if (field5 != null) {
                        window.getDecorView().setSystemUiVisibility(field5.getInt(null) | i3 | i4);
                    }
                } else {
                    method2.invoke(window.getDecorView(), Integer.valueOf(i3 | i4));
                }
                window.addFlags(i);
                method.invoke(window, 0);
                if (z) {
                    Field field6 = WindowManager.LayoutParams.class.getField("FLAG_FULLSCREEN");
                    Method method3 = window.getClass().getMethod("setFlags", Integer.TYPE, Integer.TYPE);
                    int i5 = field6.getInt(null);
                    method3.invoke(window, Integer.valueOf(i5), Integer.valueOf(i5));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getBazhuIconId(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65561, null, str, z)) == null) {
            if (str != null && str.length() > 0) {
                if (!str.equals("5") && !str.toUpperCase().equals(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS)) {
                    if (!str.equals("4") && !str.toUpperCase().equals("B")) {
                        if (!str.equals("3") && !str.toUpperCase().equals("C")) {
                            if (!str.equals("2") && !str.toUpperCase().equals("D")) {
                                if (z) {
                                    return R.drawable.pic_barman_1level_simple12;
                                }
                                return R.drawable.pic_barman_1level40;
                            } else if (z) {
                                return R.drawable.pic_barman_2level_simple12;
                            } else {
                                return R.drawable.pic_barman_2level40;
                            }
                        } else if (z) {
                            return R.drawable.pic_barman_3level_simple12;
                        } else {
                            return R.drawable.pic_barman_3level40;
                        }
                    } else if (z) {
                        return R.drawable.pic_barman_4level_simple12;
                    } else {
                        return R.drawable.pic_barman_4level40;
                    }
                } else if (z) {
                    return R.drawable.pic_barman_5level_simple12;
                } else {
                    return R.drawable.pic_barman_5level40;
                }
            }
            return 0;
        }
        return invokeLZ.intValue;
    }

    public static int getBazhuImIconId(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65562, null, str, z)) == null) {
            if (str != null && str.length() > 0) {
                if (!str.equals("5") && !str.toUpperCase().equals(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS)) {
                    if (!str.equals("4") && !str.toUpperCase().equals("B")) {
                        if (!str.equals("3") && !str.toUpperCase().equals("C")) {
                            if (!str.equals("2") && !str.toUpperCase().equals("D")) {
                                if (str.equals("1") || str.toUpperCase().equals(ExifInterface.LONGITUDE_EAST)) {
                                    if (z) {
                                        return R.drawable.pic_barman_1level_simple12;
                                    }
                                    return R.drawable.pic_barman_1level40;
                                }
                            } else if (z) {
                                return R.drawable.pic_barman_2level_simple12;
                            } else {
                                return R.drawable.pic_barman_2level40;
                            }
                        } else if (z) {
                            return R.drawable.pic_barman_3level_simple12;
                        } else {
                            return R.drawable.pic_barman_3level40;
                        }
                    } else if (z) {
                        return R.drawable.pic_barman_4level_simple12;
                    } else {
                        return R.drawable.pic_barman_4level40;
                    }
                } else if (z) {
                    return R.drawable.pic_barman_5level_simple12;
                } else {
                    return R.drawable.pic_barman_5level40;
                }
            }
            return 0;
        }
        return invokeLZ.intValue;
    }

    public static long getDayBetweenTime(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65573, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return ((j2 - j) / 1000) / 86400;
        }
        return invokeCommon.longValue;
    }

    public static String getFixedText(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65578, null, str, i)) == null) {
            return getFixedText(str, i, true);
        }
        return (String) invokeLI.objValue;
    }

    public static int getInstallApkVersion(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65588, null, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                if (packageInfo != null) {
                    return packageInfo.versionCode;
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static String getInstallApkVersionName(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65589, null, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                if (packageInfo != null) {
                    return packageInfo.versionName;
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isInstallApk(Context context, String str) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65650, null, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isInstalledPackage(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65651, null, context, str)) == null) {
            try {
                if (context.getPackageManager().getApplicationInfo(str, 8192) != null) {
                    return true;
                }
                return false;
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65652, null, context, intent)) == null) {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void setNavigationBarBackground(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65688, null, activity, i) == null) {
            setNavigationBarBackground(activity, i, false);
        }
    }

    public static void setNavigationBarBackgroundForVivoX20(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65690, null, activity, i) == null) && activity != null && DeviceInfoUtil.isVivoX20A() && isNavigationbarShown(activity.getResources())) {
            if (Build.VERSION.SDK_INT > 21) {
                setNavigationBarBackground_L(activity, i);
            } else {
                setNavigationBarBackground_K(activity, i);
            }
        }
    }

    public static void setNavigationBarBackground_L(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65692, null, activity, i) == null) {
            activity.getWindow().setNavigationBarColor(i);
        }
    }

    public static void setNavigationBarBg(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65693, null, activity, i) != null) || activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT > 21) {
            setNavigationBarBackground_L(activity, i);
        } else {
            setNavigationBarBackground_K(activity, i);
        }
    }

    public static void setStatusBarBackground(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65696, null, view2, i) != null) || view2 == null) {
            return;
        }
        SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
    }

    public static void showHeadImageViewBigV(HeadImageView headImageView, com.baidu.tbadk.data.MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65704, null, headImageView, metaData) == null) {
            showHeadImageViewBigV(headImageView, metaData, 0);
        }
    }

    public static boolean showNewGodIcon(ImageView imageView, com.baidu.tbadk.data.MetaData metaData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65709, null, imageView, metaData)) == null) {
            if (imageView == null || metaData == null || !metaData.isNewGod()) {
                return false;
            }
            imageView.setVisibility(0);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean showOfficialIcon(ImageView imageView, com.baidu.tbadk.data.MetaData metaData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65710, null, imageView, metaData)) == null) {
            if (imageView == null || metaData == null || !metaData.isOfficial()) {
                return false;
            }
            imageView.setVisibility(0);
            WebPManager.setMaskDrawable(imageView, R.drawable.obfuscated_res_0x7f0805fa, null);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean showOriginalIcon(ImageView imageView, com.baidu.tbadk.data.MetaData metaData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65711, null, imageView, metaData)) == null) {
            if (imageView == null || metaData == null || !metaData.isOriginal()) {
                return false;
            }
            imageView.setVisibility(0);
            WebPManager.setMaskDrawable(imageView, R.drawable.ic_icon_mask_videov14, null);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void showToast(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65714, null, context, i) == null) {
            CustomToast2.showToast(context, i);
        }
    }

    public static void useNavigationBarStyleImmersiveSticky_M(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65734, null, activity, z) == null) {
            useNavigationBarStyleImmersiveSticky_L(activity, z, true);
        }
    }

    public static String getFixedBarText(String str, int i, boolean z) {
        InterceptResult invokeCommon;
        double d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65576, null, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            double d2 = 0.0d;
            int i2 = 0;
            while (true) {
                if (i2 >= str.length()) {
                    break;
                }
                char charAt = str.charAt(i2);
                if ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || (charAt >= '0' && charAt <= '9'))) {
                    d = 0.5d;
                } else {
                    d = 1.0d;
                }
                d2 += d;
                if (d2 <= i) {
                    sb.append(charAt);
                    i2++;
                } else if (z) {
                    sb.deleteCharAt(i2 - 1);
                    sb.append(StringHelper.STRING_MORE);
                }
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    @Deprecated
    public static String getFixedText(String str, int i, boolean z) {
        InterceptResult invokeCommon;
        double d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65579, null, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            double d2 = 0.0d;
            int i2 = 0;
            while (true) {
                if (i2 >= str.length()) {
                    break;
                }
                char charAt = str.charAt(i2);
                if ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || (charAt >= '0' && charAt <= '9'))) {
                    d = 0.5d;
                } else {
                    d = 1.0d;
                }
                d2 += d;
                if (d2 <= i) {
                    sb.append(charAt);
                    i2++;
                } else if (z) {
                    sb.append(StringHelper.STRING_MORE);
                }
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static void showYYNotification(Context context, qt4 qt4Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(65716, null, context, qt4Var, i) != null) || g35.L()) {
            return;
        }
        String a = qt4Var.a();
        String b = qt4Var.b();
        if (b != null && b.length() > 0) {
            Intent yYNotificationIntent = getYYNotificationIntent(context, qt4Var, b);
            if (yYNotificationIntent != null && yYNotificationIntent.getDataString() != null && yYNotificationIntent.getDataString().contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                yYNotificationIntent.setFlags(276824064);
                NotificationHelper.showNotification(context, i, null, a, a, PendingIntent.getActivity(context, i, yYNotificationIntent, 134217728), false);
            } else if (yYNotificationIntent == null) {
            } else {
                NotificationHelper.showNotification(context, i, null, a, a, PendingIntent.getService(context, 0, yYNotificationIntent, 134217728), false);
            }
        }
    }

    public static String getFixedBarText(String str, int i, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        double d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65577, null, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            double d2 = 0.0d;
            int i2 = 0;
            while (true) {
                if (i2 >= str.length()) {
                    break;
                }
                char charAt = str.charAt(i2);
                if ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || (charAt >= '0' && charAt <= '9'))) {
                    d = 0.5d;
                } else {
                    d = 1.0d;
                }
                d2 += d;
                if (d2 <= i) {
                    sb.append(charAt);
                    i2++;
                } else if (z && z2) {
                    sb.deleteCharAt(i2 - 1);
                    sb.append(StringHelper.STRING_MORE);
                } else if (z) {
                    sb.append(StringHelper.STRING_MORE);
                }
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static SpannableStringBuilder getSpannableIcon(Context context, String str, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65603, null, new Object[]{context, str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (!wi.isEmpty(str) && context != null && i != 0) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                Bitmap bitmap = SkinManager.getBitmap(i);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                yy4 yy4Var = new yy4(bitmapDrawable);
                yy4Var.b(xi.g(context, R.dimen.obfuscated_res_0x7f070224));
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) " ");
                if (z) {
                    spannableStringBuilder.setSpan(yy4Var, length, spannableStringBuilder.length(), 17);
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.append((CharSequence) str);
                } else {
                    spannableStringBuilder.append((CharSequence) str);
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(yy4Var, length, spannableStringBuilder.length(), 17);
                }
                return spannableStringBuilder;
            }
            return null;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public static SpannableStringBuilder getSpannableIconByVertical(Context context, String str, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65604, null, new Object[]{context, str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (!wi.isEmpty(str) && context != null && i != 0) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                Bitmap bitmap = SkinManager.getBitmap(i);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                bz4 bz4Var = new bz4(bitmapDrawable);
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) " ");
                if (z) {
                    spannableStringBuilder.setSpan(bz4Var, length, spannableStringBuilder.length(), 17);
                    spannableStringBuilder.append((CharSequence) str);
                } else {
                    spannableStringBuilder.append((CharSequence) str);
                    spannableStringBuilder.setSpan(bz4Var, length, spannableStringBuilder.length(), 17);
                }
                return spannableStringBuilder;
            }
            return null;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public static String getForumNameWithBar(String str, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65582, null, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (i <= -1) {
                if (wi.byteLength(str) > 14) {
                    str = StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
                }
            } else {
                str = getFixedBarText(str, i, z);
            }
            return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f03e0, new Object[]{str});
        }
        return (String) invokeCommon.objValue;
    }

    public static String getForumNameWithGodBar(String str, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65583, null, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (i <= -1) {
                if (wi.byteLength(str) > 14) {
                    str = StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
                }
            } else {
                str = getFixedBarText(str, i, z);
            }
            return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f03e1, new Object[]{str});
        }
        return (String) invokeCommon.objValue;
    }

    public static void setBitmapByTag(View view2, String str, hn hnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65686, null, view2, str, hnVar) == null) && view2 != null && str != null) {
            if (view2.getTag() != null && view2.getTag().equals(str)) {
                if (hnVar == null) {
                    view2.invalidate();
                } else if (view2 instanceof ImageView) {
                    hnVar.h((ImageView) view2);
                }
            }
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt != null) {
                        setBitmapByTag(childAt, str, hnVar);
                    }
                }
            }
        }
    }

    public static void setSupportHeight(Context context, View view2, float f) {
        ViewGroup.LayoutParams layoutParams;
        DisplayMetrics displayMetrics;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65697, null, new Object[]{context, view2, Float.valueOf(f)}) != null) || view2 == null || f <= 0.0f || context == null || (layoutParams = view2.getLayoutParams()) == null || (displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics()) == null) {
            return;
        }
        layoutParams.height = Math.round(displayMetrics.widthPixels / f);
        view2.requestLayout();
    }

    public static boolean showHeadBazhuIcon(ImageView imageView, com.baidu.tbadk.data.MetaData metaData, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65701, null, imageView, metaData, z)) == null) {
            if (imageView == null || metaData == null || metaData.getBazhuGradeData() == null || wi.isEmpty(metaData.getBazhuGradeData().getLevel()) || !metaData.showBazhuGrade()) {
                return false;
            }
            int bazhuIconId = getBazhuIconId(metaData.getBazhuGradeData().getLevel(), z);
            imageView.setVisibility(0);
            SkinManager.setImageResource(imageView, bazhuIconId);
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    public static void smsTo(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65718, null, context, str, str2) == null) {
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
            intent.putExtra("sms_body", str2 + "");
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                BdLog.detailException(e);
            } catch (SecurityException e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public static boolean startApk(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65719, null, context, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");
                    intent.setComponent(new ComponentName(str, str2));
                    intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                    context.startActivity(intent);
                    return true;
                } catch (Throwable th) {
                    th.printStackTrace();
                    xi.O(context, R.string.obfuscated_res_0x7f0f07cc);
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static Object getProcessLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65598, null)) == null) {
            BdLog.d("baidu.tieba.processlimit ");
            try {
                Class<?> cls = Class.forName("android.app.ActivityManagerNative");
                Object cast = Class.forName("android.app.IActivityManager").cast(cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]));
                return cast.getClass().getMethod("getProcessLimit", new Class[0]).invoke(cast, new Object[0]);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                BdLog.e("getProcessLimit error");
                return null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                BdLog.e("getProcessLimit error");
                return null;
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
                BdLog.e("getProcessLimit error");
                return null;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                BdLog.e("getProcessLimit error");
                return null;
            }
        }
        return invokeV.objValue;
    }

    public static String getTiebaApkMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65610, null)) == null) {
            try {
                String versionName = TbadkCoreApplication.getInst().getVersionName();
                String q = ky4.k().q("version_name", "");
                if (TextUtils.isEmpty(versionName)) {
                    return null;
                }
                if (versionName.equals(q)) {
                    return ky4.k().q("apk_md5", "");
                }
                ky4.k().y("version_name", versionName);
                String aPKMd5 = TbMd5.getAPKMd5(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(TbadkCoreApplication.getInst().getPackageName(), 0));
                ky4.k().y("apk_md5", aPKMd5);
                return aPKMd5;
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0061 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable] */
    public static boolean isARM() {
        InterceptResult invokeV;
        Throwable th;
        RandomAccessFile randomAccessFile;
        Exception e;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = (r5 = interceptable).invokeV(65632, null)) == null) {
            String str = Build.CPU_ABI;
            if (str != null && str.toLowerCase().contains("arm")) {
                return true;
            }
            try {
                try {
                    bArr = new byte[1024];
                    randomAccessFile = new RandomAccessFile(k1.a, "r");
                    try {
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        yi.d(randomAccessFile);
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    yi.d(r5);
                    throw th;
                }
            } catch (Exception e3) {
                randomAccessFile = null;
                e = e3;
            } catch (Throwable th3) {
                ?? r5 = 0;
                th = th3;
                yi.d(r5);
                throw th;
            }
            if (randomAccessFile.read(bArr) < 1) {
                yi.d(randomAccessFile);
                return false;
            }
            String str2 = new String(bArr);
            int indexOf = str2.indexOf(0);
            if (indexOf != -1) {
                str2 = str2.substring(0, indexOf);
            }
            if (str2.toLowerCase().contains("arm")) {
                yi.d(randomAccessFile);
                return true;
            }
            yi.d(randomAccessFile);
            return false;
        }
        return invokeV.booleanValue;
    }

    public static int getRandom(Random random, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65599, null, random, i, i2)) == null) {
            int nextInt = random.nextInt(i);
            if (nextInt == i2) {
                return (nextInt + 1) % i;
            }
            return nextInt;
        }
        return invokeLII.intValue;
    }

    public static boolean showHeadBjhBigVIcon(HeadPendantView headPendantView, com.baidu.tbadk.data.MetaData metaData, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65703, null, headPendantView, metaData, i)) == null) {
            if (headPendantView == null || metaData == null || metaData.getBaijiahaoInfo() == null || !isShowBjhBigV(metaData.getBaijiahaoInfo())) {
                return false;
            }
            headPendantView.j(metaData, i);
            return true;
        }
        return invokeLLI.booleanValue;
    }

    public static void useNavigationBarStyleImmersiveSticky_L(Activity activity, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65732, null, new Object[]{activity, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || activity == null) {
            return;
        }
        useNavigationBarStyleImmersiveSticky_L(activity.getWindow(), z, z2);
    }

    public static Uri getUriFromFile(File file, Intent intent, Context context) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65614, null, file, intent, context)) == null) {
            if (file != null && intent != null && context != null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    intent.addFlags(1);
                    return FileProvider.getUriForFile(context, "com.baidu.tieba.fileprovider", file);
                }
                return Uri.fromFile(file);
            }
            return null;
        }
        return (Uri) invokeLLL.objValue;
    }

    public static boolean isMatchScheme(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65654, null, context, str, str2)) == null) {
            if (StringUtils.isNull(str) || StringUtils.isNull(str2) || !isAppAvilible(str2)) {
                return false;
            }
            Intent intent = getIntent(str);
            if (!isHaveActivityCanHandleIntent(intent)) {
                return false;
            }
            if (context != null) {
                try {
                    context.startActivity(intent);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static void setNavigationBarBackground(Activity activity, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65689, null, new Object[]{activity, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || activity == null) {
            return;
        }
        if (!DeviceInfoUtil.isfullScreen() && !z) {
            return;
        }
        if (Build.VERSION.SDK_INT > 21) {
            setNavigationBarBackground_L(activity, i);
        } else {
            setNavigationBarBackground_K(activity, i);
        }
    }

    public static boolean showHeadBjhBigVIcon(ImageView imageView, com.baidu.tbadk.data.MetaData metaData, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65702, null, imageView, metaData, i)) == null) {
            if (imageView == null || metaData == null || metaData.getBaijiahaoInfo() == null || !isShowBjhBigV(metaData.getBaijiahaoInfo())) {
                return false;
            }
            int bjhBigVIconId = getBjhBigVIconId(metaData.getBaijiahaoInfo().auth_id.intValue(), i);
            imageView.setVisibility(0);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, bjhBigVIconId, SvgManager.SvgResourceStateType.NORMAL);
            return true;
        }
        return invokeLLI.booleanValue;
    }

    public static final Intent getYYNotificationIntent(Context context, qt4 qt4Var, String str) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65618, null, context, qt4Var, str)) == null) {
            if (context != null && qt4Var != null && !TextUtils.isEmpty(str)) {
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_FRS)) {
                    try {
                        return Intent.parseUri(str, 1);
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
                Intent intent = new Intent(context, DealIntentService.class);
                if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP)) {
                    String substring = str.substring(str.lastIndexOf("/") + 1);
                    intent.putExtra(DealIntentService.KEY_CLASS, 1);
                    intent.putExtra("key_start_from", 7);
                    intent.putExtra("id", substring);
                    intent.putExtra("is_message_pv", true);
                } else if (str.equals("tab://1")) {
                    intent.putExtra(DealIntentService.KEY_CLASS, 3);
                    intent.putExtra("is_message_pv", true);
                    intent.putExtra(FrsActivityConfig.KEY_REFRESH, true);
                    intent.putExtra("close_dialog", true);
                    intent.putExtra("locate_type", 0);
                    intent.setFlags(603979776);
                    TbadkCoreApplication.getInst().setWebviewCrashCount(0);
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_WEB)) {
                    if (!str.contains("ftid=")) {
                        return null;
                    }
                    intent.putExtra(DealIntentService.KEY_CLASS, 29);
                    intent.putExtra(PbChosenActivityConfig.KEY_TID, str.substring(str.lastIndexOf("ftid=") + 5));
                    TiebaStatic.log(TbadkCoreStatisticKey.PUSH_RECOMMEND_PB_RECEIVE);
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_OPFEATURE)) {
                    try {
                        intent.putExtra(DealIntentService.KEY_CLASS, 0);
                        str = str.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_OPFEATURE, "http://");
                        intent.putExtra("url", str);
                        intent.putExtra("is_message_pv", true);
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                        return null;
                    }
                } else if (str.startsWith("pk_before:")) {
                    intent.putExtra(DealIntentService.KEY_CLASS, 6);
                    intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
                } else if (str.startsWith("pk_after:")) {
                    intent.putExtra(DealIntentService.KEY_CLASS, 7);
                    intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
                } else if (str.startsWith(NativeConstants.COMPONENT_VOTE)) {
                    intent.putExtra(DealIntentService.KEY_CLASS, 8);
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PHOTOLIVE)) {
                    intent.putExtra(DealIntentService.KEY_CLASS, 31);
                    String substring2 = str.substring(str.lastIndexOf(UrlSchemaHelper.SCHEMA_TYPE_PHOTOLIVE) + 5);
                    if (substring2.startsWith("pid=")) {
                        str2 = substring2.substring(substring2.lastIndexOf("pid=") + 4);
                    } else if (substring2.startsWith("http://")) {
                        str2 = substring2.substring(substring2.lastIndexOf("p/") + 2);
                    } else {
                        str2 = "";
                    }
                    if (StringUtils.isNull(str2)) {
                        return null;
                    }
                    intent.putExtra("tid", str2);
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_MIDDLE_PAGE)) {
                    intent.putExtra(DealIntentService.KEY_CLASS, 34);
                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    if (!parsePushMidPageUrl(str, sb, sb2)) {
                        return null;
                    }
                    String sb3 = sb.toString();
                    String sb4 = sb2.toString();
                    if (!StringUtils.isNull(sb3) && !StringUtils.isNull(sb4)) {
                        intent.putExtra("fid", sb3);
                        intent.putExtra("tid", sb4);
                    }
                }
                intent.putExtra("is_notify", true);
                intent.putExtra("link", str);
                intent.putExtra("message_id", qt4Var.c());
                intent.putExtra("task_id", qt4Var.e());
                if (!TextUtils.isEmpty(qt4Var.d())) {
                    intent.putExtra("stat", qt4Var.d());
                }
                return intent;
            }
            return null;
        }
        return (Intent) invokeLLL.objValue;
    }

    public static NativePage isNativeAddress(String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65660, null, str)) == null) {
            NativePage nativePage = new NativePage();
            if (str != null && !wi.isEmpty(str)) {
                Matcher matcher = pbPattern0.matcher(str);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(2);
                        if (!TextUtils.isEmpty(group)) {
                            nativePage.id = group;
                            nativePage.type = NativePageType.PB;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                int i = 0;
                String str5 = null;
                if (str != null) {
                    str = str.toLowerCase();
                    if (str.startsWith(TbConfig.HTTP_PREFIX)) {
                        str3 = str.substring(TbConfig.HTTP_PREFIX.length());
                    } else if (str.startsWith(TbConfig.HTTPS_PREFIX)) {
                        str3 = str.substring(TbConfig.HTTPS_PREFIX.length());
                    } else {
                        str3 = null;
                    }
                    if (str3 == null) {
                        return nativePage;
                    }
                    String[] split = str3.split("&");
                    if (str3.startsWith("kz=")) {
                        str4 = str3.substring(3);
                    } else {
                        int i2 = 0;
                        while (true) {
                            if (i2 < split.length) {
                                if (split[i2] != null && split[i2].startsWith("kz=")) {
                                    str4 = split[i2].substring(3);
                                    break;
                                }
                                i2++;
                            } else {
                                str4 = null;
                                break;
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        nativePage.id = str4;
                        nativePage.type = NativePageType.PB;
                    }
                }
                if (str != null) {
                    String lowerCase = str.toLowerCase();
                    if (lowerCase.startsWith(TbConfig.HTTP_PREFIX)) {
                        str2 = lowerCase.substring(TbConfig.HTTP_PREFIX.length());
                    } else if (lowerCase.startsWith(TbConfig.HTTP_PREFIX)) {
                        str2 = lowerCase.substring(TbConfig.HTTP_PREFIX.length());
                    } else {
                        str2 = null;
                    }
                    if (str2 == null) {
                        return nativePage;
                    }
                    String[] split2 = str2.split("&");
                    if (!str2.startsWith("kw=")) {
                        while (true) {
                            if (i < split2.length) {
                                if (split2[i] != null && split2[i].startsWith("kw=")) {
                                    str5 = split2[i].substring(3);
                                    break;
                                }
                                i++;
                            } else {
                                break;
                            }
                        }
                    } else {
                        str5 = str2.substring(3);
                    }
                    if (!TextUtils.isEmpty(str5)) {
                        nativePage.id = str5;
                        nativePage.type = NativePageType.FRS;
                    }
                }
            }
            return nativePage;
        }
        return (NativePage) invokeL.objValue;
    }

    public static void setSpan(SpannableString spannableString, String str, String str2, CharacterStyle characterStyle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65694, null, spannableString, str, str2, characterStyle) == null) && spannableString != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && characterStyle != null) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            while (indexOf >= 0) {
                int i = indexOf + length;
                spannableString.setSpan(characterStyle, indexOf, i, 33);
                indexOf = str.indexOf(str2, i);
            }
        }
    }

    public static void setSpan(SpannableStringBuilder spannableStringBuilder, String str, String str2, CharacterStyle characterStyle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65695, null, spannableStringBuilder, str, str2, characterStyle) == null) && spannableStringBuilder != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && characterStyle != null) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            while (indexOf >= 0) {
                int i = indexOf + length;
                spannableStringBuilder.setSpan(characterStyle, indexOf, i, 33);
                indexOf = str.indexOf(str2, i);
            }
        }
    }

    public static void share(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65699, null, context, str, str2, str3) == null) {
            try {
                Intent intent = new Intent("android.intent.action.SEND", (Uri) null);
                intent.addCategory("android.intent.category.DEFAULT");
                if (str2.length() > 140) {
                    str2 = str2.substring(0, Cea708Decoder.COMMAND_DLW);
                }
                intent.putExtra("android.intent.extra.TEXT", str2);
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent, TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.share_to)));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void shareThread(Context context, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(65700, null, context, str, str2, str3, str4) == null) && str2 != null && str3 != null && str4 != null) {
            try {
                if (str3.length() > 140) {
                    str3 = str3.substring(0, Cea708Decoder.COMMAND_DLW);
                }
                String str5 = TbConfig.HTTPS_PB_PREFIX + str2 + "?share=9105";
                if (str != null) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), str, null, 1, "st_param", str2);
                }
                Intent intent = new Intent("android.intent.action.SEND", (Uri) null);
                intent.putExtra("android.intent.extra.TEXT", MessageFormat.format(context.getResources().getString(R.string.obfuscated_res_0x7f0f1186), str3, str4, str5));
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent, context.getResources().getString(R.string.share_to)));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void showHeadImageViewBigV(HeadImageView headImageView, com.baidu.tbadk.data.MetaData metaData, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65705, null, headImageView, metaData, i) == null) && headImageView != null && metaData != null) {
            boolean z2 = false;
            headImageView.setBjhAuthIconRes(0);
            headImageView.setBazhuIconRes(0);
            headImageView.setGodIconResId(0);
            headImageView.setOfficialIconResId(0);
            headImageView.setOriginatorResId(0);
            if (isFllowByPriorty(metaData)) {
                if (metaData.getAuthType() == 1) {
                    if (metaData.isOfficial()) {
                        headImageView.setOfficialIconResId(R.drawable.obfuscated_res_0x7f0805fa);
                        headImageView.setShowV(true);
                        return;
                    }
                } else if (metaData.getAuthType() == 2) {
                    if (metaData.isOriginal()) {
                        headImageView.setOriginatorResId(R.drawable.ic_icon_mask_videov14);
                        headImageView.setShowV(true);
                        return;
                    }
                } else if (metaData.getAuthType() == 3) {
                    if (metaData.isNewGod()) {
                        headImageView.setBjhAuthIconRes(0);
                        headImageView.setBazhuIconRes(0);
                        headImageView.setGodIconResId(R.drawable.icon_mask_shen_liang20_svg);
                        headImageView.setShowV(true);
                        return;
                    }
                } else if (metaData.getAuthType() == 4 && metaData.getBazhuGradeData() != null && !wi.isEmpty(metaData.getBazhuGradeData().getLevel()) && metaData.showBazhuGrade()) {
                    int bazhuIconId = getBazhuIconId(metaData.getBazhuGradeData().getLevel(), true);
                    headImageView.setBjhAuthIconRes(0);
                    headImageView.setBazhuIconRes(bazhuIconId);
                    headImageView.setShowV(true);
                    return;
                }
            }
            if (metaData.isOfficial()) {
                headImageView.setOfficialIconResId(R.drawable.obfuscated_res_0x7f0805fa);
                headImageView.setShowV(true);
            } else if (!metaData.isOriginal() && metaData.getIsOriginalAuthor() == 0) {
                if (metaData.isNewGod()) {
                    headImageView.setBjhAuthIconRes(0);
                    headImageView.setBazhuIconRes(0);
                    headImageView.setGodIconResId(R.drawable.icon_mask_shen_liang20_svg);
                    headImageView.setShowV(true);
                } else if (metaData.getBazhuGradeData() != null && !wi.isEmpty(metaData.getBazhuGradeData().getLevel()) && metaData.showBazhuGrade()) {
                    int bazhuIconId2 = getBazhuIconId(metaData.getBazhuGradeData().getLevel(), true);
                    headImageView.setBjhAuthIconRes(0);
                    headImageView.setBazhuIconRes(bazhuIconId2);
                    headImageView.setShowV(true);
                } else {
                    if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().getImgUrl())) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (metaData.isBigV() && !z) {
                        z2 = true;
                    }
                    headImageView.setShowV(z2);
                }
            } else {
                headImageView.setOriginatorResId(R.drawable.ic_icon_mask_videov14);
                headImageView.setShowV(true);
            }
        }
    }

    public static void showHeadImageViewBigVForStranger(HeadImageView headImageView, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65706, null, headImageView, imMessageCenterShowItemData) == null) && headImageView != null && imMessageCenterShowItemData.getUserExtraData() != null) {
            headImageView.setBjhAuthIconRes(0);
            headImageView.setBazhuIconRes(0);
            headImageView.setGodIconResId(0);
            headImageView.setOfficialIconResId(0);
            headImageView.setOriginatorResId(0);
            int i = imMessageCenterShowItemData.getUserExtraData().c;
            if (i != 0) {
                if (i == 1) {
                    if (imMessageCenterShowItemData.getUserExtraData().a == 1) {
                        headImageView.setOfficialIconResId(R.drawable.obfuscated_res_0x7f0805fa);
                        headImageView.setShowV(true);
                    }
                } else if (i == 2) {
                    if (!wi.isEmpty(imMessageCenterShowItemData.getUserExtraData().b)) {
                        headImageView.setOriginatorResId(R.drawable.ic_icon_mask_videov14);
                        headImageView.setShowV(true);
                    }
                } else if (i == 3) {
                    if (imMessageCenterShowItemData.getUserExtraData().e == 3) {
                        headImageView.setBjhAuthIconRes(0);
                        headImageView.setBazhuIconRes(0);
                        headImageView.setGodIconResId(R.drawable.icon_mask_shen_liang20_svg);
                        headImageView.setShowV(true);
                    }
                } else if (i == 4 && !wi.isEmpty(imMessageCenterShowItemData.getUserExtraData().h) && imMessageCenterShowItemData.getUserExtraData().i != 3) {
                    int bazhuImIconId = getBazhuImIconId(imMessageCenterShowItemData.getUserExtraData().h, true);
                    headImageView.setBjhAuthIconRes(0);
                    headImageView.setBazhuIconRes(bazhuImIconId);
                    headImageView.setShowV(true);
                }
            } else if (imMessageCenterShowItemData.getUserExtraData().a == 1) {
                headImageView.setOfficialIconResId(R.drawable.obfuscated_res_0x7f0805fa);
                headImageView.setShowV(true);
            } else if (!wi.isEmpty(imMessageCenterShowItemData.getUserExtraData().b)) {
                headImageView.setOriginatorResId(R.drawable.ic_icon_mask_videov14);
                headImageView.setShowV(true);
            } else if (imMessageCenterShowItemData.getUserExtraData().e == 3) {
                headImageView.setBjhAuthIconRes(0);
                headImageView.setBazhuIconRes(0);
                headImageView.setGodIconResId(R.drawable.icon_mask_shen_liang20_svg);
                headImageView.setShowV(true);
            } else if (!wi.isEmpty(imMessageCenterShowItemData.getUserExtraData().h) && imMessageCenterShowItemData.getUserExtraData().i != 3) {
                int bazhuImIconId2 = getBazhuImIconId(imMessageCenterShowItemData.getUserExtraData().h, true);
                headImageView.setBjhAuthIconRes(0);
                headImageView.setBazhuIconRes(bazhuImIconId2);
                headImageView.setShowV(true);
            }
        }
    }

    public static void showHeadImageViewFocusBigV(HeadImageView headImageView, com.baidu.tbadk.data.MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65708, null, headImageView, metaData) == null) && headImageView != null && metaData != null) {
            headImageView.setBjhAuthIconRes(0);
            headImageView.setBazhuIconRes(0);
            headImageView.setGodIconResId(0);
            headImageView.setOfficialIconResId(0);
            headImageView.setOriginatorResId(0);
            if (isFllowByPriorty(metaData)) {
                if (metaData.getAuthType() == 1) {
                    if (metaData.isOfficial()) {
                        headImageView.setOfficialIconResId(R.drawable.obfuscated_res_0x7f0805fa);
                        headImageView.setShowV(true);
                    }
                } else if (metaData.getAuthType() == 2) {
                    if (metaData.isOriginal()) {
                        headImageView.setOriginatorResId(R.drawable.ic_icon_mask_videov14);
                        headImageView.setShowV(true);
                    }
                } else if (metaData.getAuthType() == 3) {
                    if (metaData.isNewGod()) {
                        headImageView.setBjhAuthIconRes(0);
                        headImageView.setBazhuIconRes(0);
                        headImageView.setGodIconResId(R.drawable.icon_mask_shen_liang20_svg);
                        headImageView.setShowV(true);
                    }
                } else if (metaData.getAuthType() == 4 && !wi.isEmpty(metaData.getBazhuGradeData().getLevel()) && metaData.getPrivSetsData().getBazhuShowOutside() != 3) {
                    int bazhuImIconId = getBazhuImIconId(metaData.getBazhuGradeData().getLevel(), true);
                    headImageView.setBjhAuthIconRes(0);
                    headImageView.setBazhuIconRes(bazhuImIconId);
                    headImageView.setShowV(true);
                }
            } else if (metaData.isOfficial()) {
                headImageView.setOfficialIconResId(R.drawable.obfuscated_res_0x7f0805fa);
                headImageView.setShowV(true);
            } else if (metaData.isOriginal()) {
                headImageView.setOriginatorResId(R.drawable.ic_icon_mask_videov14);
                headImageView.setShowV(true);
            } else if (metaData.isNewGod()) {
                headImageView.setBjhAuthIconRes(0);
                headImageView.setBazhuIconRes(0);
                headImageView.setGodIconResId(R.drawable.icon_mask_shen_liang20_svg);
                headImageView.setShowV(true);
            } else if (!wi.isEmpty(metaData.getBazhuGradeData().getLevel()) && metaData.getPrivSetsData().getBazhuShowOutside() != 3) {
                int bazhuImIconId2 = getBazhuImIconId(metaData.getBazhuGradeData().getLevel(), true);
                headImageView.setBjhAuthIconRes(0);
                headImageView.setBazhuIconRes(bazhuImIconId2);
                headImageView.setShowV(true);
            }
        }
    }

    public static boolean useNavigationBarStyleImmersiveSticky(Activity activity, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65729, null, activity, z)) == null) {
            if (Build.VERSION.SDK_INT < 19 || activity == null || !ky4.k().h("switch_immersive_sticky_status", true) || !TbadkCoreApplication.getInst().isMeiZuCanUseImmersive()) {
                return false;
            }
            for (AccessibilityServiceInfo accessibilityServiceInfo : ((AccessibilityManager) activity.getSystemService("accessibility")).getEnabledAccessibilityServiceList(1)) {
                if (!StringUtils.isNull(accessibilityServiceInfo.getSettingsActivityName()) && accessibilityServiceInfo.getSettingsActivityName().contains("talkback")) {
                    ky4.k().u("switch_immersive_sticky_status", false);
                    TbadkCoreApplication.getInst().resetIsImmersiveStickyPrefHasRead(false);
                    return false;
                }
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                useNavigationBarStyleImmersiveSticky_M(activity, z);
                StatusBarUtil.from(activity).setTransparentStatusbar(z2).setLightStatusBar(z2).process();
                return true;
            } else if (!StatusBarUtil.from(activity).setTransparentStatusbar(z2).setLightStatusBar(z2).process()) {
                ky4.k().u("switch_immersive_sticky_status", false);
                TbadkCoreApplication.getInst().resetIsImmersiveStickyPrefHasRead(false);
                return false;
            } else if (Build.VERSION.SDK_INT < 21) {
                useNavigationBarStyleImmersiveSticky_KitKat(activity);
                return true;
            } else {
                useNavigationBarStyleImmersiveSticky_L(activity);
                return true;
            }
        }
        return invokeLZ.booleanValue;
    }

    public static void showHeadImageViewBigVForStranger(HeadImageView headImageView, com.baidu.tbadk.data.MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65707, null, headImageView, metaData) == null) && headImageView != null && metaData != null) {
            headImageView.setBjhAuthIconRes(0);
            headImageView.setBazhuIconRes(0);
            headImageView.setGodIconResId(0);
            headImageView.setOfficialIconResId(0);
            headImageView.setOriginatorResId(0);
            int authType = metaData.getAuthType();
            if (authType != 0) {
                if (authType == 1) {
                    if (metaData.getIsBussinessAccount() == 1) {
                        headImageView.setOfficialIconResId(R.drawable.obfuscated_res_0x7f0805fa);
                        headImageView.setShowV(true);
                    }
                } else if (authType == 2) {
                    if (!wi.isEmpty(metaData.getAuthDesc())) {
                        headImageView.setOriginatorResId(R.drawable.ic_icon_mask_videov14);
                        headImageView.setShowV(true);
                    }
                } else if (authType == 3) {
                    if (metaData.getGodStatus() == 3) {
                        headImageView.setBjhAuthIconRes(0);
                        headImageView.setBazhuIconRes(0);
                        headImageView.setGodIconResId(R.drawable.icon_mask_shen_liang20_svg);
                        headImageView.setShowV(true);
                    }
                } else if (authType == 4 && !wi.isEmpty(metaData.getBazhuLevel()) && metaData.getBazhuShowOutside() != 3) {
                    int bazhuImIconId = getBazhuImIconId(metaData.getBazhuLevel(), true);
                    headImageView.setBjhAuthIconRes(0);
                    headImageView.setBazhuIconRes(bazhuImIconId);
                    headImageView.setShowV(true);
                }
            } else if (metaData.getIsBussinessAccount() == 1) {
                headImageView.setOfficialIconResId(R.drawable.obfuscated_res_0x7f0805fa);
                headImageView.setShowV(true);
            } else if (!wi.isEmpty(metaData.getAuthDesc())) {
                headImageView.setOriginatorResId(R.drawable.ic_icon_mask_videov14);
                headImageView.setShowV(true);
            } else if (metaData.getGodStatus() == 3) {
                headImageView.setBjhAuthIconRes(0);
                headImageView.setBazhuIconRes(0);
                headImageView.setGodIconResId(R.drawable.icon_mask_shen_liang20_svg);
                headImageView.setShowV(true);
            } else if (!wi.isEmpty(metaData.getBazhuLevel()) && metaData.getBazhuShowOutside() != 3) {
                int bazhuImIconId2 = getBazhuImIconId(metaData.getBazhuLevel(), true);
                headImageView.setBjhAuthIconRes(0);
                headImageView.setBazhuIconRes(bazhuImIconId2);
                headImageView.setShowV(true);
            }
        }
    }

    public static void showToast(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65715, null, context, str) == null) {
            CustomToast2.showToast(context, str);
        }
    }

    public static String transforIPV6(String str) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65725, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int indexOf = str.indexOf("::");
            if (indexOf >= 0) {
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 2);
                if (!StringUtils.isNull(substring)) {
                    i = substring.split(":").length;
                } else {
                    i = 0;
                }
                if (!StringUtils.isNull(substring2)) {
                    i2 = substring2.split(":").length;
                } else {
                    i2 = 0;
                }
                int i3 = (8 - i) - i2;
                if (i > 0) {
                    stringBuffer.append(transforIPV6(substring));
                    stringBuffer.append(".");
                }
                for (int i4 = 0; i4 < i3; i4++) {
                    stringBuffer.append("0");
                    if (i4 < i3 - 1) {
                        stringBuffer.append(".");
                    }
                }
                if (i2 > 0) {
                    stringBuffer.append(".");
                    stringBuffer.append(transforIPV6(substring2));
                }
            } else {
                String[] split = str.split(":");
                for (int i5 = 0; i5 < split.length; i5++) {
                    stringBuffer.append(String.valueOf(wg.f(split[i5], 0, 16)));
                    if (i5 < split.length - 1) {
                        stringBuffer.append(".");
                    }
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }
}
