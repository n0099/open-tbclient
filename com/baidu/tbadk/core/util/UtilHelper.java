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
import android.telephony.TelephonyManager;
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
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
import com.baidu.tieba.an;
import com.baidu.tieba.ba5;
import com.baidu.tieba.bm;
import com.baidu.tieba.cm;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.gi;
import com.baidu.tieba.gq4;
import com.baidu.tieba.h9;
import com.baidu.tieba.hc8;
import com.baidu.tieba.hv4;
import com.baidu.tieba.i9;
import com.baidu.tieba.ka5;
import com.baidu.tieba.km4;
import com.baidu.tieba.kv4;
import com.baidu.tieba.lf;
import com.baidu.tieba.ne5;
import com.baidu.tieba.nz4;
import com.baidu.tieba.o55;
import com.baidu.tieba.ou4;
import com.baidu.tieba.pg;
import com.baidu.tieba.pi;
import com.baidu.tieba.qi;
import com.baidu.tieba.ri;
import com.baidu.tieba.si;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import com.baidu.tieba.tu4;
import com.baidu.tieba.uf5;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.tieba.wr4;
import com.baidu.tieba.xi;
import com.baidu.tieba.z8;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NativePageType) Enum.valueOf(NativePageType.class, str) : (NativePageType) invokeL.objValue;
        }

        public static NativePageType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NativePageType[]) $VALUES.clone() : (NativePageType[]) invokeV.objValue;
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
        if (!(interceptable == null || interceptable.invokeL(65539, null, tBSpecificationButtonConfig) == null) || tBSpecificationButtonConfig == null) {
            return;
        }
        tBSpecificationButtonConfig.i(R.drawable.obfuscated_res_0x7f080934, 0, TBSpecificationButtonConfig.IconType.WEBP);
        tBSpecificationButtonConfig.h(R.color.CAM_X0304);
        tBSpecificationButtonConfig.g(ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26));
        tBSpecificationButtonConfig.f(ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
    }

    public static String appendCuidParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (qi.isEmpty(str) || str.indexOf("cuid=") <= -1) {
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
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String appendVersionCode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (qi.isEmpty(str) || str.indexOf("_client_version=") <= -1) {
                return str + "&_client_version=" + TbConfig.getVersion();
            }
            return str;
        }
        return (String) invokeL.objValue;
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

    public static boolean canUseStyleImmersiveSticky() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (Build.VERSION.SDK_INT >= 19 && TbadkCoreApplication.getInst() != null && TbadkCoreApplication.getInst().isMeiZuCanUseImmersive() && !isSMF9000()) {
                return TbadkCoreApplication.getInst().isImmersiveStickyCanUse();
            }
            return false;
        }
        return invokeV.booleanValue;
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

    public static void changeStatusBarIconAndTextColor(boolean z, Activity activity) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(65545, null, z, activity) == null) || activity == null || activity.getWindow() == null || isMeizuM355()) {
            return;
        }
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

    public static boolean checkAiAppGuideResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get("aiapp_guide.gif"))) {
                RequestParams requestParams = new RequestParams();
                requestParams.setRunType(cm.a);
                requestParams.setRunNode("aps");
                requestParams.addChannel(new bm("com.baidu.tieba.resloader.aiappguide", (DefaultDownloadCallback) null));
                PmsManager.getInstance().execute(requestParams);
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
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

    public static void clearClipBoardBySchemaParam(String str) {
        Uri parse;
        String queryParameter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, str) == null) || TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (queryParameter = parse.getQueryParameter(KEY_HAS_TOKEN)) == null || !queryParameter.equals("1")) {
            return;
        }
        clearClipBoard();
    }

    public static boolean commenDealIntent(Context context, Intent intent) {
        InterceptResult invokeLL;
        String str;
        String str2;
        PbActivityConfig createNormalCfg;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, intent)) == null) {
            boolean z = false;
            if (intent == null || intent.getExtras() == null) {
                return false;
            }
            int i2 = intent.getExtras().getInt(DealIntentService.KEY_CLASS, -1);
            TbPageContext<BaseFragmentActivity> tbPageContext = null;
            String str3 = "";
            switch (i2) {
                case 0:
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    km4.o(context, intent.getExtras().getString("url"));
                    str3 = intent.getExtras().getString("url");
                    z = true;
                    break;
                case 1:
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    String stringExtra = intent.getStringExtra("id");
                    String stringExtra2 = intent.getStringExtra("from");
                    String string = intent.getExtras().getString("stat");
                    String stringExtra3 = intent.getStringExtra("link");
                    String stringExtra4 = intent.getStringExtra("task_id");
                    if (!qi.isEmpty(stringExtra4)) {
                        TbadkCoreApplication.getInst().setTaskId(stringExtra4);
                    }
                    boolean booleanExtra = intent.getBooleanExtra(TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY, false);
                    long j = intent.getExtras().getLong("message_id");
                    int i3 = intent.getExtras().getInt("video_channel_id", 0);
                    if (i3 > 0) {
                        TiebaStatic.log(new StatisticItem("c11918").param("obj_id", i3));
                    }
                    if (intent.getBooleanExtra("is_message_pv", false)) {
                        createNormalCfg = new PbActivityConfig(context).createMessageCfg(stringExtra, null, stringExtra2, j, stringExtra3, string, "op");
                    } else {
                        createNormalCfg = new PbActivityConfig(context).createNormalCfg(stringExtra, null, stringExtra2);
                    }
                    if (booleanExtra) {
                        createNormalCfg.setFromPushNotify();
                        String stringExtra5 = intent.getStringExtra("gid");
                        if (!TextUtils.isEmpty(stringExtra5)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(stringExtra5 + "", 4)));
                        }
                    }
                    if (intent.getBooleanExtra("key_is_from_local_push", false)) {
                        TiebaStatic.log(new StatisticItem("c13265"));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    str3 = stringExtra3;
                    z = true;
                    break;
                case 2:
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(context).createNormalCfg(intent.getStringExtra("fname"), intent.getStringExtra("from"));
                    createNormalCfg2.setCallFrom(13);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                    z = true;
                    break;
                case 3:
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    if (ou4.b() != null) {
                        intent.setClass(context, ou4.b());
                        if (!(context instanceof Activity) && intent != null) {
                            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                        }
                        intent.addFlags(603979776);
                        context.startActivity(intent);
                    }
                    z = true;
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
                    z = false;
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
                    int t = nz4.h0().t();
                    int A = nz4.h0().A();
                    int u = nz4.h0().u();
                    int s = nz4.h0().s();
                    int x = nz4.h0().x();
                    int y = nz4.h0().y();
                    nz4.h0().W(t, A, u, s, x, y);
                    boolean z2 = intExtra4 > 0 || intExtra7 > 0 || intExtra6 > 0 || intExtra5 > 0 || intExtra8 > 0;
                    boolean z3 = intExtra9 == 29 && intExtra > 0;
                    boolean z4 = intExtra9 == 24 && intExtra3 > 0;
                    boolean z5 = intExtra9 == 25 && intExtra2 > 0;
                    if (z3) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(context)));
                        nz4.h0().Y(0);
                    } else if (z4) {
                        nz4.h0().f0(0);
                        TbPageContext<?> tryCastPageContext = tryCastPageContext(context);
                        if (tryCastPageContext != null) {
                            UrlManager.getInstance().dealOneLink(tryCastPageContext, new String[]{stringExtra6});
                        }
                        nz4.h0().f0(0);
                    } else if (z5) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMeActivityConfig(context)));
                        nz4.h0().Z(0);
                    } else if (i2 == 35) {
                        if (!z2 && intExtra <= 0 && intExtra3 <= 0 && intExtra2 <= 0 && y <= 0 && s <= 0) {
                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                            int sex = TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getSex() : 0;
                            if (currentAccount != null && currentAccount.length() > 0) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(context, false, currentAccount, sex)));
                                nz4.h0().c0(0);
                            }
                        } else {
                            goToMessageCenterFromNotifyCenter(intExtra9);
                        }
                    } else if (z2) {
                        TiebaStatic.log(TbadkCoreStatisticKey.PUSH_MESSAGE_CLICK);
                        if (i2 == 5 && ou4.a() == 3) {
                            goToMessageCenterFromNotifyCenter(intExtra9);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(context, intent.getIntExtra("tab_id", -1))));
                            Intent intent2 = new Intent();
                            intent2.putExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, intExtra9);
                            intent2.putExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 2);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016321, intent2));
                        }
                    }
                    z = true;
                    break;
                case 8:
                    ou4.e(context, 2);
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    z = true;
                    break;
                case 9:
                    if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(context);
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(context)));
                    } else {
                        ou4.e(context, 1);
                    }
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    z = true;
                    break;
                case 12:
                    String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                    String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                    if (ou4.a() == 8) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createNormalCfg(8)));
                    } else if (!TextUtils.isEmpty(currentAccount2) && !TextUtils.isEmpty(currentAccountName)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, currentAccount2, currentAccountName, nz4.h0().x())));
                    }
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    z = true;
                    break;
                case 13:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(context, pg.g(intent.getStringExtra(DBTableDefine.GroupMessageColumns.COLUMN_GROUPID), 0L), 0)));
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    z = true;
                    break;
                case 15:
                    ka5.c().a(new PayConfig(pg.e(intent.getStringExtra("pay_type"), 0), intent.getStringExtra("is_left"), intent.getStringExtra("props_id"), intent.getStringExtra("quan_num"), intent.getStringExtra("props_mon"), true, intent.getStringExtra(MemberPayStatistic.REFER_PAGE), intent.getStringExtra(MemberPayStatistic.CLICK_ZONE)), context);
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    break;
                case 18:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(context, "", false)));
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    z = true;
                    break;
                case 19:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(context)));
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    z = true;
                    break;
                case 22:
                    String stringExtra7 = intent.getStringExtra("barid");
                    String stringExtra8 = intent.getStringExtra("barname");
                    String stringExtra9 = intent.getStringExtra("portrait");
                    long g = pg.g(stringExtra7, -1L);
                    if (g > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(context, g, stringExtra8, stringExtra9, 0)));
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z = true;
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
                            i = 6;
                        } else if (stringExtra11.equals(TbadkCoreStatisticKey.BUBBLE_PAY_MEMBER_SUCCESS)) {
                            i = 7;
                        }
                        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(context, parseInt, false, i);
                        memberPayActivityConfig.setReferPageClickZone(stringExtra12, stringExtra13);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                        str = DealIntentService.KEY_CLASS;
                        str2 = "push";
                        z = true;
                        break;
                    }
                    i = 0;
                    MemberPayActivityConfig memberPayActivityConfig2 = new MemberPayActivityConfig(context, parseInt, false, i);
                    memberPayActivityConfig2.setReferPageClickZone(stringExtra12, stringExtra13);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig2));
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    z = true;
                case 24:
                    String currentAccount3 = TbadkCoreApplication.getCurrentAccount();
                    String currentAccountName2 = TbadkCoreApplication.getCurrentAccountName();
                    if (currentAccount3 != null && currentAccount3.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(context, currentAccount3, currentAccountName2, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow() : currentAccountName2, 0)));
                    }
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    z = true;
                    break;
                case 25:
                    CurrencyJumpHelper.nativeGotoBuyBean(context);
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    z = true;
                    break;
                case 27:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(context, pg.g(intent.getStringExtra("uid"), 0L), intent.getStringExtra("uname"), null, 0, intent.getIntExtra("user_type", 0))));
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    z = true;
                    break;
                case 28:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(context, pg.g(intent.getStringExtra(PbChosenActivityConfig.KEY_TID), 0L), null)));
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    z = true;
                    break;
                case 29:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(context, pg.g(intent.getStringExtra(PbChosenActivityConfig.KEY_TID), 0L), null, 2)));
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    z = true;
                    break;
                case 30:
                    String string2 = intent.getExtras().getString(BigdayActivityConfig.JUMP_URL);
                    boolean z6 = intent.getExtras().getBoolean("is_ad", false);
                    if (intent.getExtras().getBoolean("gd_ad", false) && !StringUtils.isNull(string2)) {
                        hc8.a(TbadkCoreApplication.getInst(), string2, xi.c(string2), intent.getExtras().getString("ext_info", ""), null);
                    } else {
                        h9 c = i9.c(context);
                        if (c instanceof BaseActivity) {
                            UrlManager.getInstance().dealOneLink(((BaseActivity) c).getPageContext(), new String[]{string2}, z6);
                        } else if (c instanceof BaseFragmentActivity) {
                            UrlManager.getInstance().dealOneLink(((BaseFragmentActivity) c).getPageContext(), new String[]{string2}, z6);
                        }
                    }
                    str3 = string2;
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    z = true;
                    break;
                case 31:
                    TiebaStatic.log(TbadkCoreStatisticKey.PUSH_ENTRANCE);
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    z = true;
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
                    z = true;
                    break;
                case 33:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001259));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(context)));
                    TiebaStatic.log(TbadkCoreStatisticKey.PL_COLLECT_UPDATE_NOTIFICATION);
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    z = true;
                    break;
                case 34:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoListActivityConfig(context).createNormalCfg(intent.getStringExtra("fid"), intent.getStringExtra("tid"), "push")));
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    z = true;
                    break;
                case 36:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(context, intent.getIntExtra("tab_id", -1))));
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    z = true;
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
                    z = true;
                    break;
                case 38:
                    if (checkAiAppGuideResource()) {
                        tu4.k().u("key_ai_app_guide_display", false);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AiAppGuideActivityConfig(context)));
                    }
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    z = true;
                    break;
                case 39:
                    SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(context).createSubPbActivityConfig(intent.getStringExtra("thread_id"), intent.getStringExtra("post_id"), "", true);
                    createSubPbActivityConfig.setIsFromeSchema(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                    str = DealIntentService.KEY_CLASS;
                    str2 = "push";
                    z = true;
                    break;
            }
            if (z) {
                GrowthStatsUtil.statisticChannel(str2, str3);
            }
            if (z) {
                return z;
            }
            intent.putExtra(str, 3);
            return commenDealIntent(context, intent);
        }
        return invokeLL.booleanValue;
    }

    public static void commenDealUrl(Context context, String str, String... strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65550, null, context, str, strArr) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.length() > 4 && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_WEB)) {
            String substring = str.substring(4);
            String str2 = strArr[0];
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            km4.r(context, str2, substring, false);
        } else if (str.length() > 4 && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_FRS)) {
            String substring2 = str.substring(4);
            if (TextUtils.isEmpty(substring2)) {
                return;
            }
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(context).createNormalCfg(substring2, "official_bar");
            createNormalCfg.setCallFrom(13);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        } else if (str.length() <= 4 || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
        } else {
            String substring3 = str.substring(3);
            if (TextUtils.isEmpty(substring3)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(context).createNormalCfg(substring3, null, "official_bar")));
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

    public static boolean dealOneScheme(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, str)) == null) {
            if (context != null && !qi.isEmpty(str)) {
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

    public static boolean detectOpenGLES20(Context context) {
        InterceptResult invokeL;
        ActivityManager activityManager;
        ConfigurationInfo deviceConfigurationInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) ? (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) == null || deviceConfigurationInfo.reqGlEsVersion < 131072) ? false : true : invokeL.booleanValue;
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

    public static String formalDecimalForTwo(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65555, null, f)) == null) ? new DecimalFormat("0.00").format(f) : (String) invokeF.objValue;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, metaData)) == null) ? getAuthInfo(metaData, false, 16) : (String) invokeL.objValue;
    }

    public static int getBazhuIconId(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65561, null, str, z)) == null) {
            if (str == null || str.length() <= 0) {
                return 0;
            }
            return (str.equals("5") || str.toUpperCase().equals("A")) ? z ? R.drawable.pic_barman_5level_simple12 : R.drawable.pic_barman_5level40 : (str.equals("4") || str.toUpperCase().equals("B")) ? z ? R.drawable.pic_barman_4level_simple12 : R.drawable.pic_barman_4level40 : (str.equals("3") || str.toUpperCase().equals("C")) ? z ? R.drawable.pic_barman_3level_simple12 : R.drawable.pic_barman_3level40 : (str.equals("2") || str.toUpperCase().equals("D")) ? z ? R.drawable.pic_barman_2level_simple12 : R.drawable.pic_barman_2level40 : z ? R.drawable.pic_barman_1level_simple12 : R.drawable.pic_barman_1level40;
        }
        return invokeLZ.intValue;
    }

    public static int getBazhuImIconId(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65562, null, str, z)) == null) {
            if (str != null && str.length() > 0) {
                if (str.equals("5") || str.toUpperCase().equals("A")) {
                    return z ? R.drawable.pic_barman_5level_simple12 : R.drawable.pic_barman_5level40;
                } else if (str.equals("4") || str.toUpperCase().equals("B")) {
                    return z ? R.drawable.pic_barman_4level_simple12 : R.drawable.pic_barman_4level40;
                } else if (str.equals("3") || str.toUpperCase().equals("C")) {
                    return z ? R.drawable.pic_barman_3level_simple12 : R.drawable.pic_barman_3level40;
                } else if (str.equals("2") || str.toUpperCase().equals("D")) {
                    return z ? R.drawable.pic_barman_2level_simple12 : R.drawable.pic_barman_2level40;
                } else if (str.equals("1") || str.toUpperCase().equals("E")) {
                    return z ? R.drawable.pic_barman_1level_simple12 : R.drawable.pic_barman_1level40;
                }
            }
            return 0;
        }
        return invokeLZ.intValue;
    }

    public static int getBitmapMaxMemory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) ? CompatibleUtile.getInstance().getBitmapMaxMemory(context) : invokeL.intValue;
    }

    public static Drawable getBjhBigVIconDrawable(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65564, null, i)) == null) ? SvgManager.getInstance().getMaskDrawable(i, SvgManager.SvgResourceStateType.NORMAL) : (Drawable) invokeI.objValue;
    }

    public static int getBjhBigVIconId(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65565, null, i, i2)) == null) {
            if (i > 0) {
                return (i2 == 0 || i2 == 4) ? R.drawable.obfuscated_res_0x7f0805e5 : i2 == 1 ? R.drawable.obfuscated_res_0x7f0805e4 : i2 == 2 ? R.drawable.obfuscated_res_0x7f0805e6 : i2 == 3 ? R.drawable.ic_icon_mask_v20_n_svg : R.drawable.obfuscated_res_0x7f0805e5;
            }
            return 0;
        }
        return invokeII.intValue;
    }

    public static Bitmap getCacheBitmapFromView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, view2)) == null) {
            o55.k().i(ri.k(TbadkCoreApplication.getInst()) * ri.i(TbadkCoreApplication.getInst()) * 2);
            view2.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view2.getDrawingCache();
            Bitmap bitmap = null;
            if (drawingCache != null) {
                try {
                    bitmap = Bitmap.createBitmap(drawingCache);
                    view2.setDrawingCacheEnabled(false);
                    return bitmap;
                } catch (OutOfMemoryError unused) {
                    System.gc();
                    return bitmap;
                }
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static String getClientIP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            boolean H = pi.H();
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                if (H) {
                    return getWifiMac(TbadkCoreApplication.getInst().getApp());
                }
                return getGprsIpv4Address();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static String getClipBoardContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                try {
                    ClipData primaryClip = ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).getPrimaryClip();
                    return (primaryClip == null || primaryClip.getItemAt(0) == null || primaryClip.getItemAt(0).getText() == null) ? "" : primaryClip.getItemAt(0).getText().toString();
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static long getCorrectUserIdAfterOverflowCut(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65569, null, j)) == null) ? j >= 0 ? j : j + 4294967296L : invokeJ.longValue;
    }

    public static String getCurrentDay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) ? new SimpleDateFormat("yyyy-MM-dd").format(new Date()) : (String) invokeV.objValue;
    }

    public static String getCurrentPageName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            if (context == null && z8.g().b() != null && "PbFullScreenEditorActivity".equals(z8.g().b().getClass().getSimpleName())) {
                Activity f = z8.g().f(z8.g().h() - 2);
                if (f instanceof ba5) {
                    return ((ba5) f).getCurrentPageKey();
                }
            }
            return context instanceof ba5 ? ((ba5) context).getCurrentPageKey() : "";
        }
        return (String) invokeL.objValue;
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

    public static long getDayBetweenTime(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65573, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? ((j2 - j) / 1000) / 86400 : invokeCommon.longValue;
    }

    public static String getDeviceId() {
        InterceptResult invokeV;
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) ? (!PermissionUtil.checkReadPhoneState(TbadkCoreApplication.getInst()) || (telephonyManager = (TelephonyManager) TbadkCoreApplication.getInst().getSystemService("phone")) == null) ? "" : ApiReplaceUtil.getDeviceId(telephonyManager) : (String) invokeV.objValue;
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

    public static String getFixedBarText(String str, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65576, null, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            double d = 0.0d;
            int i2 = 0;
            while (true) {
                if (i2 >= str.length()) {
                    break;
                }
                char charAt = str.charAt(i2);
                d += ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z') && (charAt < '0' || charAt > '9')) ? 1.0d : 0.5d;
                if (d <= i) {
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

    public static String getFixedText(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65578, null, str, i)) == null) ? getFixedText(str, i, true) : (String) invokeLI.objValue;
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
                i = str.charAt(i2) > 255 ? i + 2 : i + 1;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static String getForumNameWithBar(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65581, null, str)) == null) ? getForumNameWithGodBar(str, -1, false) : (String) invokeL.objValue;
    }

    public static String getForumNameWithGodBar(String str, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65583, null, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (i <= -1) {
                if (qi.byteLength(str) > 14) {
                    str = StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
                }
            } else {
                str = getFixedBarText(str, i, z);
            }
            return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f03d4, new Object[]{str});
        }
        return (String) invokeCommon.objValue;
    }

    public static String getFromPageKey(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, tbPageContext)) == null) {
            if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof ba5)) {
                return null;
            }
            ba5 ba5Var = (ba5) tbPageContext.getPageActivity();
            if (ba5Var.getCurrentPageSourceKeyList() == null) {
                return null;
            }
            return (String) ListUtils.getItem(ba5Var.getCurrentPageSourceKeyList(), ba5Var.getCurrentPageSourceKeyList().size() - 1);
        }
        return (String) invokeL.objValue;
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

    public static int getLightStatusBarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65592, null)) == null) {
            if (canUseStyleImmersiveSticky()) {
                try {
                    return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(pg.e(Class.forName("com.android.internal.R$dimen").getField(SapiSystemBarTintManager.SystemBarConfig.g).get(null).toString(), 0));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static String getMetaValue(Context context, String str) {
        InterceptResult invokeLL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65593, null, context, str)) == null) {
            if (context != null) {
                if (str != null) {
                    try {
                        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                        bundle = applicationInfo != null ? applicationInfo.metaData : null;
                        if (bundle == null) {
                            return null;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        return null;
                    }
                }
                return bundle.getString(str);
            }
            return null;
        }
        return (String) invokeLL.objValue;
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

    public static int getNavigationBarHeight(Context context) {
        InterceptResult invokeL;
        Resources resources;
        int identifier;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65595, null, context)) == null) {
            if (!hasNavBar(context) || (identifier = (resources = context.getResources()).getIdentifier(SapiSystemBarTintManager.SystemBarConfig.h, EMABTest.TYPE_DIMEN, "android")) <= 0) {
                return 0;
            }
            return resources.getDimensionPixelSize(identifier);
        }
        return invokeL.intValue;
    }

    public static int getNetworkOperator() {
        InterceptResult invokeV;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65596, null)) == null) {
            String simOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService("phone")).getSimOperator();
            if (simOperator == null || simOperator.length() < 4 || qi.isEmptyStringAfterTrim(simOperator) || (substring = simOperator.substring(0, 3)) == null || !substring.equals("460")) {
                return 0;
            }
            int e = pg.e(simOperator.substring(3), 0);
            if (e != 0) {
                if (e != 1) {
                    if (e != 2) {
                        if (e != 3 && e != 5) {
                            if (e != 6) {
                                if (e != 7) {
                                    if (e != 11) {
                                        return 0;
                                    }
                                }
                            }
                        }
                        return 3;
                    }
                }
                return 2;
            }
            return 1;
        }
        return invokeV.intValue;
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

    public static int getRandom(Random random, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65599, null, random, i, i2)) == null) {
            int nextInt = random.nextInt(i);
            return nextInt == i2 ? (nextInt + 1) % i : nextInt;
        }
        return invokeLII.intValue;
    }

    public static int getRealScreenOrientation(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65600, null, context)) == null) {
            int[] q = ri.q(context);
            int i = context.getResources().getConfiguration().orientation;
            if (i == 2 || q[0] <= q[1]) {
                return i;
            }
            return 2;
        }
        return invokeL.intValue;
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
            return i == 0 ? ri.i(context) : i;
        }
        return invokeL.intValue;
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

    public static SpannableStringBuilder getSpannableIcon(Context context, String str, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65603, null, new Object[]{context, str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (qi.isEmpty(str) || context == null || i == 0) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            Bitmap bitmap = SkinManager.getBitmap(i);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            if (bitmap != null) {
                bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            }
            hv4 hv4Var = new hv4(bitmapDrawable);
            hv4Var.b(ri.f(context, R.dimen.obfuscated_res_0x7f070224));
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " ");
            if (z) {
                spannableStringBuilder.setSpan(hv4Var, length, spannableStringBuilder.length(), 17);
                spannableStringBuilder.append((CharSequence) " ");
                spannableStringBuilder.append((CharSequence) str);
            } else {
                spannableStringBuilder.append((CharSequence) str);
                spannableStringBuilder.append((CharSequence) " ");
                spannableStringBuilder.setSpan(hv4Var, length, spannableStringBuilder.length(), 17);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public static SpannableStringBuilder getSpannableIconByVertical(Context context, String str, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65604, null, new Object[]{context, str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (qi.isEmpty(str) || context == null || i == 0) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            Bitmap bitmap = SkinManager.getBitmap(i);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            if (bitmap != null) {
                bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            }
            kv4 kv4Var = new kv4(bitmapDrawable);
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " ");
            if (z) {
                spannableStringBuilder.setSpan(kv4Var, length, spannableStringBuilder.length(), 17);
                spannableStringBuilder.append((CharSequence) str);
            } else {
                spannableStringBuilder.append((CharSequence) str);
                spannableStringBuilder.setSpan(kv4Var, length, spannableStringBuilder.length(), 17);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public static int getStatusBarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65605, null)) == null) {
            try {
                return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(pg.e(Class.forName("com.android.internal.R$dimen").getField(SapiSystemBarTintManager.SystemBarConfig.g).get(null).toString(), 0));
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
                return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(pg.e(Class.forName("com.android.internal.R$dimen").getField(SapiSystemBarTintManager.SystemBarConfig.g).get(null).toString(), 0));
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return invokeV.intValue;
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

    public static String getTiebaApkMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65610, null)) == null) {
            try {
                String versionName = TbadkCoreApplication.getInst().getVersionName();
                String q = tu4.k().q("version_name", "");
                if (TextUtils.isEmpty(versionName)) {
                    return null;
                }
                if (versionName.equals(q)) {
                    return tu4.k().q("apk_md5", "");
                }
                tu4.k().y("version_name", versionName);
                String aPKMd5 = TbMd5.getAPKMd5(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(TbadkCoreApplication.getInst().getPackageName(), 0));
                tu4.k().y("apk_md5", aPKMd5);
                return aPKMd5;
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return (String) invokeV.objValue;
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

    public static String getTopActivityClassName() {
        InterceptResult invokeV;
        Activity b;
        ComponentName componentName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65613, null)) == null) {
            if (z8.g() == null || (b = z8.g().b()) == null || (componentName = b.getComponentName()) == null) {
                return null;
            }
            return componentName.getClassName();
        }
        return (String) invokeV.objValue;
    }

    public static Uri getUriFromFile(File file, Intent intent, Context context) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65614, null, file, intent, context)) == null) {
            if (file == null || intent == null || context == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
                return FileProvider.getUriForFile(context, "com.baidu.tieba.fileprovider", file);
            }
            return Uri.fromFile(file);
        }
        return (Uri) invokeLLL.objValue;
    }

    public static String getUserName(com.baidu.tbadk.data.MetaData metaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65615, null, metaData)) == null) ? metaData == null ? "" : metaData.getName_show() : (String) invokeL.objValue;
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

    public static final Intent getYYNotificationIntent(Context context, gq4 gq4Var, String str) {
        InterceptResult invokeLLL;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65618, null, context, gq4Var, str)) == null) {
            if (context != null && gq4Var != null && !TextUtils.isEmpty(str)) {
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_FRS)) {
                    try {
                        return Intent.parseUri(str, 1);
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
                Intent intent = new Intent(context, DealIntentService.class);
                if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP)) {
                    String substring2 = str.substring(str.lastIndexOf("/") + 1);
                    intent.putExtra(DealIntentService.KEY_CLASS, 1);
                    intent.putExtra("key_start_from", 7);
                    intent.putExtra("id", substring2);
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
                    String substring3 = str.substring(str.lastIndexOf(UrlSchemaHelper.SCHEMA_TYPE_PHOTOLIVE) + 5);
                    if (substring3.startsWith("pid=")) {
                        substring = substring3.substring(substring3.lastIndexOf("pid=") + 4);
                    } else {
                        substring = substring3.startsWith("http://") ? substring3.substring(substring3.lastIndexOf("p/") + 2) : "";
                    }
                    if (StringUtils.isNull(substring)) {
                        return null;
                    }
                    intent.putExtra("tid", substring);
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
                intent.putExtra("message_id", gq4Var.c());
                intent.putExtra("task_id", gq4Var.e());
                if (!TextUtils.isEmpty(gq4Var.d())) {
                    intent.putExtra("stat", gq4Var.d());
                }
                return intent;
            }
            return null;
        }
        return (Intent) invokeLLL.objValue;
    }

    public static void goToMessageCenterFromNotifyCenter(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65619, null, i) == null) {
            Intent intent = new Intent();
            intent.putExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, i);
            intent.putExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016321, intent));
            ou4.e(TbadkCoreApplication.getInst().getApplicationContext(), 3);
        }
    }

    public static boolean hasAvaiableSDCardSpace(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65620, null, i)) == null) {
            try {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                    return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024 > ((long) i);
                }
                return false;
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
                return declaredMethod.invoke(rootWindowInsets, new Object[0]) != null;
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

    public static boolean hasNotchMiui() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65624, null)) == null) {
            String systemProperty = getSystemProperty("ro.miui.notch");
            return !StringUtils.isNULL(systemProperty) && systemProperty.equals("1");
        }
        return invokeV.booleanValue;
    }

    public static boolean hasNotchOPPO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65625, null)) == null) ? TbadkCoreApplication.getInst().getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism") : invokeV.booleanValue;
    }

    public static boolean hasNotchVivo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65626, null)) == null) {
            try {
                Class<?> loadClass = TbadkCoreApplication.getInst().getClassLoader().loadClass("android.util.FtFeature");
                Method[] declaredMethods = loadClass.getDeclaredMethods();
                if (declaredMethods != null) {
                    for (Method method : declaredMethods) {
                        if (method != null && method.getName().equalsIgnoreCase("isFeatureSupport")) {
                            return ((Boolean) method.invoke(loadClass, 32)).booleanValue();
                        }
                    }
                    return false;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static void hideStatusBar(Activity activity, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65627, null, activity, view2) == null) || activity == null || view2 == null) {
            return;
        }
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

    public static void install_apk(Context context, String str) {
        File GetFile;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65628, null, context, str) == null) || str == null || str.length() <= 0 || (GetFile = FileHelper.GetFile(str)) == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(getUriFromFile(GetFile, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            if (isHaveActivityCanHandleIntent(intent)) {
                context.startActivity(intent);
            }
        } catch (SecurityException unused) {
        }
    }

    public static String int2ver(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65629, null, i)) == null) {
            return ((i >> 24) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 8) & 255) + "." + (i & 255);
        }
        return (String) invokeI.objValue;
    }

    public static String intToIp(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65630, null, i)) == null) {
            return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
        }
        return (String) invokeI.objValue;
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
        if (interceptable == null || (invokeV = (r5 = interceptable).invokeV(65631, null)) == null) {
            String str = Build.CPU_ABI;
            if (str == null || !str.toLowerCase().contains("arm")) {
                try {
                    try {
                        bArr = new byte[1024];
                        randomAccessFile = new RandomAccessFile(k1.a, "r");
                        try {
                        } catch (Exception e2) {
                            e = e2;
                            BdLog.e(e.getMessage());
                            si.d(randomAccessFile);
                            return false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        si.d(r5);
                        throw th;
                    }
                } catch (Exception e3) {
                    randomAccessFile = null;
                    e = e3;
                } catch (Throwable th3) {
                    ?? r5 = 0;
                    th = th3;
                    si.d(r5);
                    throw th;
                }
                if (randomAccessFile.read(bArr) < 1) {
                    si.d(randomAccessFile);
                    return false;
                }
                String str2 = new String(bArr);
                int indexOf = str2.indexOf(0);
                if (indexOf != -1) {
                    str2 = str2.substring(0, indexOf);
                }
                if (str2.toLowerCase().contains("arm")) {
                    si.d(randomAccessFile);
                    return true;
                }
                si.d(randomAccessFile);
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isActivityStartFromScheme(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65632, null, activity)) == null) {
            if (activity == null || activity.getIntent() == null) {
                return false;
            }
            return !qi.isEmpty(activity.getIntent().getDataString());
        }
        return invokeL.booleanValue;
    }

    public static boolean isAppAvilible(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65633, null, str)) == null) {
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

    public static boolean isAppForeground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65634, null)) == null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) TbadkCoreApplication.getInst().getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null || runningAppProcesses.size() <= 0) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null && !StringUtils.isNull(runningAppProcessInfo.processName) && runningAppProcessInfo.processName.equals(TbadkCoreApplication.getInst().getPackageName()) && runningAppProcessInfo.importance == 100) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isAutoBrightness(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65635, null, context)) == null) ? CompatibleUtile.getInstance().isAutoBrightness(context) : invokeL.booleanValue;
    }

    public static boolean isBackgroundProcessLimitNone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65636, null)) == null) {
            Object processLimit = getProcessLimit();
            return processLimit != null && processLimit.toString().equals(String.valueOf(0));
        }
        return invokeV.booleanValue;
    }

    public static boolean isCurrentAccount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65637, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            return !StringUtils.isNull(currentAccount) && currentAccount.equals(str);
        }
        return invokeL.booleanValue;
    }

    public static boolean isCutoutScreen(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65638, null, activity)) == null) {
            try {
                Resources resources = activity.getResources();
                int identifier = resources.getIdentifier("config_mainBuiltInDisplayCutout", EMABTest.TYPE_STRING, "android");
                String string = identifier > 0 ? resources.getString(identifier) : null;
                if (string != null) {
                    return !TextUtils.isEmpty(string);
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isDecimal(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65639, null, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65640, null, metaData)) == null) {
            if (metaData == null) {
                return false;
            }
            int authType = metaData.getAuthType();
            return authType == 1 || authType == 2 || authType == 3 || authType == 4;
        }
        return invokeL.booleanValue;
    }

    public static boolean isFlyMeOs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65641, null)) == null) ? Build.DISPLAY.toLowerCase().contains("flyme") : invokeV.booleanValue;
    }

    public static boolean isFlymeOsOver51() {
        InterceptResult invokeV;
        String p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65642, null)) == null) {
            String str = Build.DISPLAY;
            if (str != null && str.contains("Flyme") && (p = ri.p(str)) != null && p.length() >= 3) {
                int e = pg.e(ri.p(p.substring(0, 1)), 0);
                int e2 = pg.e(ri.p(p.substring(1, 2)), 0);
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

    public static boolean isGotoVideoMiddlePage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65643, null)) == null) ? SwitchManager.getInstance().findType(VideoMiddlePageSwitch.KEY) == 1 : invokeV.booleanValue;
    }

    public static boolean isGotoVideoSquareMiddlePage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65644, null)) == null) ? SwitchManager.getInstance().findType(VideoSquareMiddlePageSwitch.KEY) == 1 : invokeV.booleanValue;
    }

    public static boolean isHaveActivityCanHandleIntent(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65645, null, intent)) == null) {
            PackageManager packageManager = TbadkCoreApplication.getInst().getPackageManager();
            return ListUtils.getCount(packageManager != null ? packageManager.queryIntentActivities(intent, 32) : null) > 0;
        }
        return invokeL.booleanValue;
    }

    public static boolean isHuaWeiU9508Device() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65646, null)) == null) {
            String str = Build.MODEL;
            return !TextUtils.isEmpty(str) && str.contains("Huawei_HUAWEI U9508");
        }
        return invokeV.booleanValue;
    }

    public static boolean isInstallApk(Context context, String str) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65647, null, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                packageInfo = null;
            }
            return packageInfo != null;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isInstalledPackage(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65648, null, context, str)) == null) {
            try {
                return context.getPackageManager().getApplicationInfo(str, 8192) != null;
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65649, null, context, intent)) == null) {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            return (queryIntentActivities == null || queryIntentActivities.isEmpty()) ? false : true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isMatchScheme(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65650, null, context, str, str2)) == null) {
            if (StringUtils.isNull(str) || StringUtils.isNull(str2) || !isAppAvilible(str2)) {
                return false;
            }
            Intent intent = getIntent(str);
            if (isHaveActivityCanHandleIntent(intent)) {
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
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean isMeizuE3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65651, null)) == null) {
            return "Meizu".equalsIgnoreCase(Build.BRAND) && "MEIZU E3".equalsIgnoreCase(Build.MODEL);
        }
        return invokeV.booleanValue;
    }

    public static boolean isMeizuM355() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65652, null)) == null) {
            return "Meizu".equalsIgnoreCase(Build.BRAND) && "M355".equalsIgnoreCase(Build.MODEL);
        }
        return invokeV.booleanValue;
    }

    public static boolean isMeizuPro7Plus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65653, null)) == null) {
            return "Meizu".equalsIgnoreCase(Build.BRAND) && "PRO 7 Plus".equalsIgnoreCase(Build.MODEL);
        }
        return invokeV.booleanValue;
    }

    public static boolean isMiNotchDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65654, null)) == null) {
            String str = Build.MODEL;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.contains("MI 8") || str.contains("MI8");
        }
        return invokeV.booleanValue;
    }

    public static boolean isNativeAdURL(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65655, null, str)) == null) {
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

    public static NativePage isNativeAddress(String str) {
        InterceptResult invokeL;
        String substring;
        String substring2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65656, null, str)) == null) {
            NativePage nativePage = new NativePage();
            if (str != null && !qi.isEmpty(str)) {
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
                String str3 = null;
                if (str != null) {
                    str = str.toLowerCase();
                    if (str.startsWith("https://tieba.baidu.com/f?")) {
                        substring2 = str.substring(26);
                    } else {
                        substring2 = str.startsWith("https://tieba.baidu.com/f?") ? str.substring(26) : null;
                    }
                    if (substring2 == null) {
                        return nativePage;
                    }
                    String[] split = substring2.split("&");
                    if (!substring2.startsWith("kz=")) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= split.length) {
                                str2 = null;
                                break;
                            } else if (split[i2] != null && split[i2].startsWith("kz=")) {
                                str2 = split[i2].substring(3);
                                break;
                            } else {
                                i2++;
                            }
                        }
                    } else {
                        str2 = substring2.substring(3);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        nativePage.id = str2;
                        nativePage.type = NativePageType.PB;
                    }
                }
                if (str != null) {
                    String lowerCase = str.toLowerCase();
                    if (lowerCase.startsWith("https://tieba.baidu.com/f?")) {
                        substring = lowerCase.substring(26);
                    } else {
                        substring = lowerCase.startsWith("https://tieba.baidu.com/f?") ? lowerCase.substring(26) : null;
                    }
                    if (substring == null) {
                        return nativePage;
                    }
                    String[] split2 = substring.split("&");
                    if (!substring.startsWith("kw=")) {
                        while (true) {
                            if (i < split2.length) {
                                if (split2[i] != null && split2[i].startsWith("kw=")) {
                                    str3 = split2[i].substring(3);
                                    break;
                                }
                                i++;
                            } else {
                                break;
                            }
                        }
                    } else {
                        str3 = substring.substring(3);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        nativePage.id = str3;
                        nativePage.type = NativePageType.FRS;
                    }
                }
            }
            return nativePage;
        }
        return (NativePage) invokeL.objValue;
    }

    public static boolean isNavigationbarShown(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65657, null, resources)) == null) {
            int identifier = resources.getIdentifier(SapiSystemBarTintManager.SystemBarConfig.k, "bool", "android");
            return identifier > 0 && resources.getBoolean(identifier);
        }
        return invokeL.booleanValue;
    }

    public static boolean isNightOrDarkMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65658, null)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            return skinType == 1 || skinType == 4;
        }
        return invokeV.booleanValue;
    }

    public static boolean isNotchScreen(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65659, null, activity)) == null) {
            boolean z = false;
            boolean hasNotchAndroidP = Build.VERSION.SDK_INT >= 28 ? hasNotchAndroidP(activity) : false;
            if (hasNotchAndroidP) {
                return hasNotchAndroidP;
            }
            return (hasNotchMiui() || hasNotchAtHuawei(activity) || isOnePlus6() || hasNotchOPPO() || hasNotchVivo()) ? true : true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isNumber(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65660, null, str)) == null) ? Pattern.compile("[0-9]+").matcher(str).matches() : invokeL.booleanValue;
    }

    public static boolean isOnePlus6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65661, null)) == null) {
            return "OnePlus".equalsIgnoreCase(Build.BRAND) && "ONEPLUS A6000".equalsIgnoreCase(Build.MODEL);
        }
        return invokeV.booleanValue;
    }

    public static boolean isOppoConcaveScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65662, null)) == null) {
            if (TbadkCoreApplication.getInst().getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism")) {
                String str = Build.MODEL;
                String[] strArr = {"PAAM00", "PAAT00", "PACM00", "PACT00", "CPH1831", "CPH1833"};
                for (int i = 0; i < 6; i++) {
                    if (str.equalsIgnoreCase(strArr[i])) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isOppoDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65663, null)) == null) {
            String str = Build.BRAND;
            if (qi.isEmpty(str)) {
                return false;
            }
            return str.contains("OPPO") || str.contains("oppo") || str.contains("Oppo");
        }
        return invokeV.booleanValue;
    }

    public static boolean isPhoneNumber(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65664, null, str)) == null) ? !StringUtils.isNull(str) && isNumber(str) && str.length() == 11 && str.startsWith("1") : invokeL.booleanValue;
    }

    public static boolean isSMF9000() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65665, null)) == null) ? Build.MODEL.equalsIgnoreCase("SM-F9000") : invokeV.booleanValue;
    }

    public static boolean isSameDay(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65666, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? j <= j2 && j / 86400000 == j2 / 86400000 : invokeCommon.booleanValue;
    }

    public static boolean isSelf(MetaData metaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65667, null, metaData)) == null) {
            if (metaData == null) {
                return false;
            }
            String userId = metaData.getUserId();
            if (StringUtils.isNull(userId)) {
                return false;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            return !StringUtils.isNull(currentAccount) && currentAccount.equals(userId);
        }
        return invokeL.booleanValue;
    }

    public static boolean isShowBjhBigV(BaijiahaoInfo baijiahaoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65668, null, baijiahaoInfo)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isSupportGesture(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65669, null, context)) == null) ? Build.VERSION.SDK_INT > 4 && CompatibleUtile.getInstance().supportMultiTouch(context) : invokeL.booleanValue;
    }

    public static boolean isSystemLocationProviderEnabled(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65670, null, context)) == null) {
            if (lf.n().h() && PermissionUtil.checkLocationForGoogle(context)) {
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
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isTopActivity(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65671, null, str)) == null) {
            Activity b = z8.g().b();
            return (b == null || b.getClass().getSimpleName() == null || !b.getClass().getSimpleName().equals(str)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isUgcThreadType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65672, null, i)) == null) ? i == 1 || i == 2 || i == 3 || i == 4 : invokeI.booleanValue;
    }

    public static boolean isUseSingleGod(UserData userData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65673, null, userData)) == null) ? (userData == null || userData.getGodUserData() == null || userData.getGodUserData().getType() != 2) ? false : true : invokeL.booleanValue;
    }

    public static boolean isVideoThread(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65674, null, i)) == null) ? i == 2 || i == 6 || i == 8 : invokeI.booleanValue;
    }

    public static boolean isVivoDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65675, null)) == null) {
            String str = Build.BRAND;
            if (qi.isEmpty(str)) {
                return false;
            }
            return str.contains("VIVO") || str.contains("vivo") || str.contains("Vivo");
        }
        return invokeV.booleanValue;
    }

    public static void openGpu(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65676, null, activity) == null) {
            CompatibleUtile.getInstance().openGpu(activity);
        }
    }

    public static boolean parsePushMidPageUrl(String str, StringBuilder sb, StringBuilder sb2) {
        InterceptResult invokeLLL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65677, null, str, sb, sb2)) == null) {
            if (str.contains("middlepage")) {
                String substring = str.substring(str.lastIndexOf(UrlSchemaHelper.SCHEMA_TYPE_MIDDLE_PAGE) + 11);
                if (substring.startsWith("flag=")) {
                    str2 = substring.substring(5, substring.indexOf("&"));
                    substring = substring.substring(str2.length() + 1 + 5);
                } else {
                    str2 = "";
                }
                if (!"1".equals(str2)) {
                    return false;
                }
                if (substring.startsWith("fid=")) {
                    str3 = substring.substring(substring.lastIndexOf("fid=") + 4, substring.indexOf("&"));
                    substring = substring.substring(str3.length() + 1 + 4);
                } else {
                    str3 = "";
                }
                String substring2 = substring.startsWith("tid=") ? substring.substring(substring.lastIndexOf("tid=") + 4) : "";
                if (StringUtils.isNull(str3) || StringUtils.isNull(substring2)) {
                    return false;
                }
                sb.append(str3);
                sb2.append(substring2);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void quitDialog(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65678, null, activity) == null) {
            new wr4(activity).setTitle(R.string.obfuscated_res_0x7f0f08f4).setCancelable(false).setMessageId(R.string.obfuscated_res_0x7f0f0263).setPositiveButton(R.string.obfuscated_res_0x7f0f0266, new wr4.e(activity) { // from class: com.baidu.tbadk.core.util.UtilHelper.2
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

                @Override // com.baidu.tieba.wr4.e
                public void onClick(wr4 wr4Var) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, wr4Var) == null) {
                        wr4Var.dismiss();
                        TbadkCoreApplication.getInst().notifyAppEnterBackground();
                        this.val$activity.finish();
                    }
                }
            }).setNegativeButton(R.string.obfuscated_res_0x7f0f0371, new wr4.e() { // from class: com.baidu.tbadk.core.util.UtilHelper.1
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

                @Override // com.baidu.tieba.wr4.e
                public void onClick(wr4 wr4Var) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, wr4Var) == null) {
                        wr4Var.dismiss();
                    }
                }
            }).create(i9.a(activity)).show();
        }
    }

    public static void setBitmapByTag(View view2, String str, an anVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65679, null, view2, str, anVar) == null) || view2 == null || str == null) {
            return;
        }
        if (view2.getTag() != null && view2.getTag().equals(str)) {
            if (anVar == null) {
                view2.invalidate();
            } else if (view2 instanceof ImageView) {
                anVar.h((ImageView) view2);
            }
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null) {
                    setBitmapByTag(childAt, str, anVar);
                }
            }
        }
    }

    public static void setFlymeImmersedWindow(Window window, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65680, null, window, z) == null) && z && window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (Build.VERSION.SDK_INT < 19) {
                try {
                    Field declaredField = attributes.getClass().getDeclaredField("meizuFlags");
                    declaredField.setAccessible(true);
                    int i = declaredField.getInt(attributes);
                    declaredField.setInt(attributes, z ? i | 64 : i & (-65));
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

    public static void setNavigationBarBackground(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65681, null, activity, i) == null) && activity != null && DeviceInfoUtil.isfullScreen()) {
            if (Build.VERSION.SDK_INT > 21) {
                setNavigationBarBackground_L(activity, i);
            } else {
                setNavigationBarBackground_K(activity, i);
            }
        }
    }

    public static void setNavigationBarBackgroundForVivoX20(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65682, null, activity, i) == null) && activity != null && DeviceInfoUtil.isVivoX20A() && isNavigationbarShown(activity.getResources())) {
            if (Build.VERSION.SDK_INT > 21) {
                setNavigationBarBackground_L(activity, i);
            } else {
                setNavigationBarBackground_K(activity, i);
            }
        }
    }

    public static void setNavigationBarBackground_K(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65683, null, activity, i) == null) {
            activity.getWindow().addFlags(134217728);
            View view2 = new View(activity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, gi.b(activity));
            layoutParams.gravity = 80;
            view2.setLayoutParams(layoutParams);
            view2.setBackgroundColor(i);
            ((ViewGroup) activity.getWindow().getDecorView()).addView(view2);
        }
    }

    public static void setNavigationBarBackground_L(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65684, null, activity, i) == null) {
            activity.getWindow().setNavigationBarColor(i);
        }
    }

    public static void setNavigationBarBg(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65685, null, activity, i) == null) || activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT > 21) {
            setNavigationBarBackground_L(activity, i);
        } else {
            setNavigationBarBackground_K(activity, i);
        }
    }

    public static void setSpan(SpannableString spannableString, String str, String str2, CharacterStyle characterStyle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65686, null, spannableString, str, str2, characterStyle) == null) || spannableString == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || characterStyle == null) {
            return;
        }
        int indexOf = str.indexOf(str2);
        int length = str2.length();
        while (indexOf >= 0) {
            int i = indexOf + length;
            spannableString.setSpan(characterStyle, indexOf, i, 33);
            indexOf = str.indexOf(str2, i);
        }
    }

    public static void setStatusBarBackground(View view2, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65688, null, view2, i) == null) || view2 == null) {
            return;
        }
        SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
    }

    public static void setSupportHeight(Context context, View view2, float f) {
        ViewGroup.LayoutParams layoutParams;
        DisplayMetrics displayMetrics;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65689, null, new Object[]{context, view2, Float.valueOf(f)}) == null) || view2 == null || f <= 0.0f || context == null || (layoutParams = view2.getLayoutParams()) == null || (displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics()) == null) {
            return;
        }
        layoutParams.height = Math.round(displayMetrics.widthPixels / f);
        view2.requestLayout();
    }

    public static void setTranslucentVirtualNavigation(Activity activity) {
        Window window;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65690, null, activity) == null) || (window = activity.getWindow()) == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        window.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        window.addFlags(134217728);
    }

    public static void share(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65691, null, context, str, str2, str3) == null) {
            try {
                Intent intent = new Intent("android.intent.action.SEND", (Uri) null);
                intent.addCategory("android.intent.category.DEFAULT");
                if (str2.length() > 140) {
                    str2 = str2.substring(0, Cea708Decoder.COMMAND_DLW);
                }
                intent.putExtra("android.intent.extra.TEXT", str2);
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent, TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.obfuscated_res_0x7f0f1162)));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void shareThread(Context context, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65692, null, context, str, str2, str3, str4) == null) || str2 == null || str3 == null || str4 == null) {
            return;
        }
        try {
            if (str3.length() > 140) {
                str3 = str3.substring(0, Cea708Decoder.COMMAND_DLW);
            }
            String str5 = "https://tieba.baidu.com/p/" + str2 + "?share=9105";
            if (str != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), str, null, 1, "st_param", str2);
            }
            Intent intent = new Intent("android.intent.action.SEND", (Uri) null);
            intent.putExtra("android.intent.extra.TEXT", MessageFormat.format(context.getResources().getString(R.string.obfuscated_res_0x7f0f1136), str3, str4, str5));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.setType("text/plain");
            context.startActivity(Intent.createChooser(intent, context.getResources().getString(R.string.obfuscated_res_0x7f0f1162)));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static boolean showHeadBazhuIcon(ImageView imageView, com.baidu.tbadk.data.MetaData metaData, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65693, null, imageView, metaData, z)) == null) {
            if (imageView == null || metaData == null || metaData.getBazhuGradeData() == null || qi.isEmpty(metaData.getBazhuGradeData().getLevel()) || !metaData.showBazhuGrade()) {
                return false;
            }
            int bazhuIconId = getBazhuIconId(metaData.getBazhuGradeData().getLevel(), z);
            imageView.setVisibility(0);
            SkinManager.setImageResource(imageView, bazhuIconId);
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    public static boolean showHeadBjhBigVIcon(ImageView imageView, com.baidu.tbadk.data.MetaData metaData, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65694, null, imageView, metaData, i)) == null) {
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

    public static void showHeadImageViewBigV(HeadImageView headImageView, com.baidu.tbadk.data.MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65696, null, headImageView, metaData) == null) {
            showHeadImageViewBigV(headImageView, metaData, 0);
        }
    }

    public static void showHeadImageViewBigVForStranger(HeadImageView headImageView, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65698, null, headImageView, imMessageCenterShowItemData) == null) || headImageView == null || imMessageCenterShowItemData.getUserExtraData() == null) {
            return;
        }
        headImageView.setBjhAuthIconRes(0);
        headImageView.setBazhuIconRes(0);
        headImageView.setGodIconResId(0);
        headImageView.setOfficialIconResId(0);
        headImageView.setOriginatorResId(0);
        int i = imMessageCenterShowItemData.getUserExtraData().c;
        if (i == 0) {
            if (imMessageCenterShowItemData.getUserExtraData().a == 1) {
                headImageView.setOfficialIconResId(R.drawable.obfuscated_res_0x7f0805df);
                headImageView.setShowV(true);
            } else if (!qi.isEmpty(imMessageCenterShowItemData.getUserExtraData().b)) {
                headImageView.setOriginatorResId(R.drawable.ic_icon_mask_videov14);
                headImageView.setShowV(true);
            } else if (imMessageCenterShowItemData.getUserExtraData().e == 3) {
                headImageView.setBjhAuthIconRes(0);
                headImageView.setBazhuIconRes(0);
                headImageView.setGodIconResId(R.drawable.icon_mask_shen_liang20_svg);
                headImageView.setShowV(true);
            } else if (qi.isEmpty(imMessageCenterShowItemData.getUserExtraData().h) || imMessageCenterShowItemData.getUserExtraData().i == 3) {
            } else {
                int bazhuImIconId = getBazhuImIconId(imMessageCenterShowItemData.getUserExtraData().h, true);
                headImageView.setBjhAuthIconRes(0);
                headImageView.setBazhuIconRes(bazhuImIconId);
                headImageView.setShowV(true);
            }
        } else if (i == 1) {
            if (imMessageCenterShowItemData.getUserExtraData().a == 1) {
                headImageView.setOfficialIconResId(R.drawable.obfuscated_res_0x7f0805df);
                headImageView.setShowV(true);
            }
        } else if (i == 2) {
            if (qi.isEmpty(imMessageCenterShowItemData.getUserExtraData().b)) {
                return;
            }
            headImageView.setOriginatorResId(R.drawable.ic_icon_mask_videov14);
            headImageView.setShowV(true);
        } else if (i == 3) {
            if (imMessageCenterShowItemData.getUserExtraData().e == 3) {
                headImageView.setBjhAuthIconRes(0);
                headImageView.setBazhuIconRes(0);
                headImageView.setGodIconResId(R.drawable.icon_mask_shen_liang20_svg);
                headImageView.setShowV(true);
            }
        } else if (i != 4 || qi.isEmpty(imMessageCenterShowItemData.getUserExtraData().h) || imMessageCenterShowItemData.getUserExtraData().i == 3) {
        } else {
            int bazhuImIconId2 = getBazhuImIconId(imMessageCenterShowItemData.getUserExtraData().h, true);
            headImageView.setBjhAuthIconRes(0);
            headImageView.setBazhuIconRes(bazhuImIconId2);
            headImageView.setShowV(true);
        }
    }

    public static void showHeadImageViewFocusBigV(HeadImageView headImageView, com.baidu.tbadk.data.MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65700, null, headImageView, metaData) == null) || headImageView == null || metaData == null) {
            return;
        }
        headImageView.setBjhAuthIconRes(0);
        headImageView.setBazhuIconRes(0);
        headImageView.setGodIconResId(0);
        headImageView.setOfficialIconResId(0);
        headImageView.setOriginatorResId(0);
        if (isFllowByPriorty(metaData)) {
            if (metaData.getAuthType() == 1) {
                if (metaData.isOfficial()) {
                    headImageView.setOfficialIconResId(R.drawable.obfuscated_res_0x7f0805df);
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
            } else if (metaData.getAuthType() != 4 || qi.isEmpty(metaData.getBazhuGradeData().getLevel()) || metaData.getPrivSetsData().getBazhuShowOutside() == 3) {
            } else {
                int bazhuImIconId = getBazhuImIconId(metaData.getBazhuGradeData().getLevel(), true);
                headImageView.setBjhAuthIconRes(0);
                headImageView.setBazhuIconRes(bazhuImIconId);
                headImageView.setShowV(true);
            }
        } else if (metaData.isOfficial()) {
            headImageView.setOfficialIconResId(R.drawable.obfuscated_res_0x7f0805df);
            headImageView.setShowV(true);
        } else if (metaData.isOriginal()) {
            headImageView.setOriginatorResId(R.drawable.ic_icon_mask_videov14);
            headImageView.setShowV(true);
        } else if (metaData.isNewGod()) {
            headImageView.setBjhAuthIconRes(0);
            headImageView.setBazhuIconRes(0);
            headImageView.setGodIconResId(R.drawable.icon_mask_shen_liang20_svg);
            headImageView.setShowV(true);
        } else if (qi.isEmpty(metaData.getBazhuGradeData().getLevel()) || metaData.getPrivSetsData().getBazhuShowOutside() == 3) {
        } else {
            int bazhuImIconId2 = getBazhuImIconId(metaData.getBazhuGradeData().getLevel(), true);
            headImageView.setBjhAuthIconRes(0);
            headImageView.setBazhuIconRes(bazhuImIconId2);
            headImageView.setShowV(true);
        }
    }

    public static boolean showNewGodIcon(ImageView imageView, com.baidu.tbadk.data.MetaData metaData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65701, null, imageView, metaData)) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65702, null, imageView, metaData)) == null) {
            if (imageView == null || metaData == null || !metaData.isOfficial()) {
                return false;
            }
            imageView.setVisibility(0);
            WebPManager.setMaskDrawable(imageView, R.drawable.obfuscated_res_0x7f0805df, null);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean showOriginalIcon(ImageView imageView, com.baidu.tbadk.data.MetaData metaData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65703, null, imageView, metaData)) == null) {
            if (imageView == null || metaData == null || !metaData.isOriginal()) {
                return false;
            }
            imageView.setVisibility(0);
            WebPManager.setMaskDrawable(imageView, R.drawable.ic_icon_mask_videov14, null);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void showSkinChangeAnimation(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65704, null, activity) == null) || ne5.a() || activity == null) {
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        Bitmap cacheBitmapFromView = getCacheBitmapFromView(decorView);
        if (!(decorView instanceof ViewGroup) || cacheBitmapFromView == null) {
            return;
        }
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
                    if (bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    this.val$cacheBitmap.recycle();
                }
            }
        });
        ofFloat.start();
    }

    public static void showStatusBar(Activity activity, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65705, null, activity, view2) == null) || activity == null || view2 == null) {
            return;
        }
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

    public static void showToast(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65707, null, context, str) == null) {
            CustomToast2.showToast(context, str);
        }
    }

    public static void showYYNotification(Context context, gq4 gq4Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65708, null, context, gq4Var, i) == null) || nz4.L()) {
            return;
        }
        String a = gq4Var.a();
        String b = gq4Var.b();
        if (b == null || b.length() <= 0) {
            return;
        }
        Intent yYNotificationIntent = getYYNotificationIntent(context, gq4Var, b);
        if (yYNotificationIntent != null && yYNotificationIntent.getDataString() != null && yYNotificationIntent.getDataString().contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
            yYNotificationIntent.setFlags(276824064);
            NotificationHelper.showNotification(context, i, null, a, a, PendingIntent.getActivity(context, i, yYNotificationIntent, 134217728), false);
        } else if (yYNotificationIntent == null) {
        } else {
            NotificationHelper.showNotification(context, i, null, a, a, PendingIntent.getService(context, 0, yYNotificationIntent, 134217728), false);
        }
    }

    public static void smsPhone(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65709, null, context, str) == null) {
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

    public static void smsTo(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65710, null, context, str, str2) == null) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65711, null, context, str, str2)) == null) {
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
                    ri.M(context, R.string.obfuscated_res_0x7f0f07a7);
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void startBaiDuBar(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65712, null, context, str) == null) {
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
                    z8.g().p();
                }
                context.startActivity(intent);
            } catch (Exception unused) {
                startBaiduWebView(context, str);
            }
        }
    }

    public static void startBaiduWebView(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65713, null, context, str) == null) {
            if (str != null && str.length() > 0) {
                km4.n(context, "http://m.baidu.com/s?from=1001157a&word=" + str);
                return;
            }
            km4.n(context, "http://m.baidu.com/?from=1001157a");
        }
    }

    public static void startHardAccelerated(Window window) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65714, null, window) == null) || Build.VERSION.SDK_INT < 11) {
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

    public static void startPushService(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65715, null, context) != null) || context == null) {
        }
    }

    public static void stopPushService(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65716, null, context) == null) {
        }
    }

    public static String transforIPV6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65717, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int indexOf = str.indexOf("::");
            if (indexOf >= 0) {
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 2);
                int length = !StringUtils.isNull(substring) ? substring.split(":").length : 0;
                int length2 = !StringUtils.isNull(substring2) ? substring2.split(":").length : 0;
                int i = (8 - length) - length2;
                if (length > 0) {
                    stringBuffer.append(transforIPV6(substring));
                    stringBuffer.append(".");
                }
                for (int i2 = 0; i2 < i; i2++) {
                    stringBuffer.append("0");
                    if (i2 < i - 1) {
                        stringBuffer.append(".");
                    }
                }
                if (length2 > 0) {
                    stringBuffer.append(".");
                    stringBuffer.append(transforIPV6(substring2));
                }
            } else {
                String[] split = str.split(":");
                for (int i3 = 0; i3 < split.length; i3++) {
                    stringBuffer.append(String.valueOf(pg.f(split[i3], 0, 16)));
                    if (i3 < split.length - 1) {
                        stringBuffer.append(".");
                    }
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static TbPageContext tryCastPageContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65718, null, context)) == null) {
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

    public static String urlAddParam(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65719, null, str, str2)) == null) {
            if (str == null || str2 == null) {
                return str;
            }
            if (str.indexOf("?") < 0) {
                str = str + "?";
            } else if (!str.endsWith("?") && !str.endsWith("&")) {
                str = str + "&";
            }
            return str + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean useNavigationBarStyleImmersiveSticky(Activity activity, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65721, null, activity, z)) == null) {
            if (Build.VERSION.SDK_INT < 19 || activity == null || !tu4.k().h("switch_immersive_sticky_status", true) || !TbadkCoreApplication.getInst().isMeiZuCanUseImmersive()) {
                return false;
            }
            for (AccessibilityServiceInfo accessibilityServiceInfo : ((AccessibilityManager) activity.getSystemService("accessibility")).getEnabledAccessibilityServiceList(1)) {
                if (!StringUtils.isNull(accessibilityServiceInfo.getSettingsActivityName()) && accessibilityServiceInfo.getSettingsActivityName().contains("talkback")) {
                    tu4.k().u("switch_immersive_sticky_status", false);
                    TbadkCoreApplication.getInst().resetIsImmersiveStickyPrefHasRead(false);
                    return false;
                }
            }
            boolean z2 = TbadkCoreApplication.getInst().getSkinType() != 2;
            if (Build.VERSION.SDK_INT >= 23) {
                useNavigationBarStyleImmersiveSticky_M(activity, z);
                StatusBarUtil.from(activity).setTransparentStatusbar(z2).setLightStatusBar(z2).process();
                return true;
            } else if (!StatusBarUtil.from(activity).setTransparentStatusbar(z2).setLightStatusBar(z2).process()) {
                tu4.k().u("switch_immersive_sticky_status", false);
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

    public static void useNavigationBarStyleImmersiveSticky_KitKat(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65722, null, activity) == null) || activity == null) {
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

    public static void useNavigationBarStyleImmersiveSticky_L(Activity activity, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65724, null, new Object[]{activity, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || activity == null) {
            return;
        }
        useNavigationBarStyleImmersiveSticky_L(activity.getWindow(), z, z2);
    }

    public static void useNavigationBarStyleImmersiveSticky_M(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65726, null, activity, z) == null) {
            useNavigationBarStyleImmersiveSticky_L(activity, z, true);
        }
    }

    public static int ver2int(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65727, null, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65728, null, context)) == null) {
            try {
                SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase(WebViewUtil.WEBVIEW_CACHE_DATABASE_FILE, 0, null);
                if (openOrCreateDatabase != null) {
                    si.b(openOrCreateDatabase);
                    return false;
                }
                si.b(openOrCreateDatabase);
                return true;
            } catch (Throwable th) {
                try {
                    if (BdLog.isDebugMode()) {
                        BdLog.e(th.getMessage());
                    }
                    return true;
                } finally {
                    si.b(null);
                }
            }
        }
        return invokeL.booleanValue;
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
                        return metaData.getNewGodData().getFieldName() + uf5.c(metaData.isVideoGod());
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
            if (!TextUtils.isEmpty("") || !metaData.isNewGod()) {
                return (TextUtils.isEmpty("") && !z && metaData.showBazhuGrade()) ? StringHelper.cutChineseAndEnglishWithSuffix(metaData.getBazhuGradeData().getDesc(), i, StringHelper.STRING_MORE) : "";
            }
            return metaData.getNewGodData().getFieldName() + uf5.c(metaData.isVideoGod());
        }
        return (String) invokeCommon.objValue;
    }

    @Deprecated
    public static String getFixedText(String str, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65579, null, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            double d = 0.0d;
            int i2 = 0;
            while (true) {
                if (i2 >= str.length()) {
                    break;
                }
                char charAt = str.charAt(i2);
                d += ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z') && (charAt < '0' || charAt > '9')) ? 1.0d : 0.5d;
                if (d <= i) {
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

    public static String getForumNameWithBar(String str, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65582, null, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (i <= -1) {
                if (qi.byteLength(str) > 14) {
                    str = StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
                }
            } else {
                str = getFixedBarText(str, i, z);
            }
            return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f03d3, new Object[]{str});
        }
        return (String) invokeCommon.objValue;
    }

    public static void showHeadImageViewBigV(HeadImageView headImageView, com.baidu.tbadk.data.MetaData metaData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65697, null, headImageView, metaData, i) == null) || headImageView == null || metaData == null) {
            return;
        }
        boolean z = false;
        headImageView.setBjhAuthIconRes(0);
        headImageView.setBazhuIconRes(0);
        headImageView.setGodIconResId(0);
        headImageView.setOfficialIconResId(0);
        headImageView.setOriginatorResId(0);
        if (isFllowByPriorty(metaData)) {
            if (metaData.getAuthType() == 1) {
                if (metaData.isOfficial()) {
                    headImageView.setOfficialIconResId(R.drawable.obfuscated_res_0x7f0805df);
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
            } else if (metaData.getAuthType() == 4 && metaData.getBazhuGradeData() != null && !qi.isEmpty(metaData.getBazhuGradeData().getLevel()) && metaData.showBazhuGrade()) {
                int bazhuIconId = getBazhuIconId(metaData.getBazhuGradeData().getLevel(), true);
                headImageView.setBjhAuthIconRes(0);
                headImageView.setBazhuIconRes(bazhuIconId);
                headImageView.setShowV(true);
                return;
            }
        }
        if (metaData.isOfficial()) {
            headImageView.setOfficialIconResId(R.drawable.obfuscated_res_0x7f0805df);
            headImageView.setShowV(true);
        } else if (!metaData.isOriginal() && metaData.getIsOriginalAuthor() == 0) {
            if (metaData.isNewGod()) {
                headImageView.setBjhAuthIconRes(0);
                headImageView.setBazhuIconRes(0);
                headImageView.setGodIconResId(R.drawable.icon_mask_shen_liang20_svg);
                headImageView.setShowV(true);
            } else if (metaData.getBazhuGradeData() != null && !qi.isEmpty(metaData.getBazhuGradeData().getLevel()) && metaData.showBazhuGrade()) {
                int bazhuIconId2 = getBazhuIconId(metaData.getBazhuGradeData().getLevel(), true);
                headImageView.setBjhAuthIconRes(0);
                headImageView.setBazhuIconRes(bazhuIconId2);
                headImageView.setShowV(true);
            } else {
                boolean z2 = (metaData.getPendantData() == null || StringUtils.isNull(metaData.getPendantData().getImgUrl())) ? false : true;
                if (metaData.isBigV() && !z2) {
                    z = true;
                }
                headImageView.setShowV(z);
            }
        } else {
            headImageView.setOriginatorResId(R.drawable.ic_icon_mask_videov14);
            headImageView.setShowV(true);
        }
    }

    public static void showToast(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65706, null, context, i) == null) {
            CustomToast2.showToast(context, i);
        }
    }

    public static void useNavigationBarStyleImmersiveSticky_L(Window window, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65725, null, new Object[]{window, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || window == null) {
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

    public static boolean showHeadBjhBigVIcon(HeadPendantView headPendantView, com.baidu.tbadk.data.MetaData metaData, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65695, null, headPendantView, metaData, i)) == null) {
            if (headPendantView == null || metaData == null || metaData.getBaijiahaoInfo() == null || !isShowBjhBigV(metaData.getBaijiahaoInfo())) {
                return false;
            }
            headPendantView.j(metaData, i);
            return true;
        }
        return invokeLLI.booleanValue;
    }

    public static void setSpan(SpannableStringBuilder spannableStringBuilder, String str, String str2, CharacterStyle characterStyle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65687, null, spannableStringBuilder, str, str2, characterStyle) == null) || spannableStringBuilder == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || characterStyle == null) {
            return;
        }
        int indexOf = str.indexOf(str2);
        int length = str2.length();
        while (indexOf >= 0) {
            int i = indexOf + length;
            spannableStringBuilder.setSpan(characterStyle, indexOf, i, 33);
            indexOf = str.indexOf(str2, i);
        }
    }

    public static String getFixedBarText(String str, int i, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65577, null, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            double d = 0.0d;
            int i2 = 0;
            while (true) {
                if (i2 >= str.length()) {
                    break;
                }
                char charAt = str.charAt(i2);
                d += ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z') && (charAt < '0' || charAt > '9')) ? 1.0d : 0.5d;
                if (d <= i) {
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

    public static boolean useNavigationBarStyleImmersiveSticky(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65720, null, activity)) == null) {
            boolean z = false;
            boolean useNavigationBarStyleImmersiveSticky = useNavigationBarStyleImmersiveSticky(activity, false);
            changeStatusBarIconAndTextColor((TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) ? true : true, activity);
            return useNavigationBarStyleImmersiveSticky;
        }
        return invokeL.booleanValue;
    }

    public static void useNavigationBarStyleImmersiveSticky_L(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65723, null, activity) == null) {
            useNavigationBarStyleImmersiveSticky_L(activity, false, false);
        }
    }

    public static void showHeadImageViewBigVForStranger(HeadImageView headImageView, com.baidu.tbadk.data.MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65699, null, headImageView, metaData) == null) || headImageView == null || metaData == null) {
            return;
        }
        headImageView.setBjhAuthIconRes(0);
        headImageView.setBazhuIconRes(0);
        headImageView.setGodIconResId(0);
        headImageView.setOfficialIconResId(0);
        headImageView.setOriginatorResId(0);
        int authType = metaData.getAuthType();
        if (authType == 0) {
            if (metaData.getIsBussinessAccount() == 1) {
                headImageView.setOfficialIconResId(R.drawable.obfuscated_res_0x7f0805df);
                headImageView.setShowV(true);
            } else if (!qi.isEmpty(metaData.getAuthDesc())) {
                headImageView.setOriginatorResId(R.drawable.ic_icon_mask_videov14);
                headImageView.setShowV(true);
            } else if (metaData.getGodStatus() == 3) {
                headImageView.setBjhAuthIconRes(0);
                headImageView.setBazhuIconRes(0);
                headImageView.setGodIconResId(R.drawable.icon_mask_shen_liang20_svg);
                headImageView.setShowV(true);
            } else if (qi.isEmpty(metaData.getBazhuLevel()) || metaData.getBazhuShowOutside() == 3) {
            } else {
                int bazhuImIconId = getBazhuImIconId(metaData.getBazhuLevel(), true);
                headImageView.setBjhAuthIconRes(0);
                headImageView.setBazhuIconRes(bazhuImIconId);
                headImageView.setShowV(true);
            }
        } else if (authType == 1) {
            if (metaData.getIsBussinessAccount() == 1) {
                headImageView.setOfficialIconResId(R.drawable.obfuscated_res_0x7f0805df);
                headImageView.setShowV(true);
            }
        } else if (authType == 2) {
            if (qi.isEmpty(metaData.getAuthDesc())) {
                return;
            }
            headImageView.setOriginatorResId(R.drawable.ic_icon_mask_videov14);
            headImageView.setShowV(true);
        } else if (authType == 3) {
            if (metaData.getGodStatus() == 3) {
                headImageView.setBjhAuthIconRes(0);
                headImageView.setBazhuIconRes(0);
                headImageView.setGodIconResId(R.drawable.icon_mask_shen_liang20_svg);
                headImageView.setShowV(true);
            }
        } else if (authType != 4 || qi.isEmpty(metaData.getBazhuLevel()) || metaData.getBazhuShowOutside() == 3) {
        } else {
            int bazhuImIconId2 = getBazhuImIconId(metaData.getBazhuLevel(), true);
            headImageView.setBjhAuthIconRes(0);
            headImageView.setBazhuIconRes(bazhuImIconId2);
            headImageView.setShowV(true);
        }
    }
}
