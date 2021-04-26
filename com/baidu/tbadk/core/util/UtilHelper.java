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
import androidx.core.content.FileProvider;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.apollon.statusbar.ImmersiveOSUtils;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AiAppGuideActivityConfig;
import com.baidu.tbadk.core.atomData.AtMessageActivityConfig;
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
import com.baidu.tbadk.core.atomData.ReplyMeActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.switchs.VideoMiddlePageSwitch;
import com.baidu.tbadk.switchs.VideoSquareMiddlePageSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.google.protobuf.CodedInputStream;
import d.a.c.a.i;
import d.a.c.a.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.c.e.p.m;
import d.a.i0.a0.c;
import d.a.i0.l.a;
import d.a.i0.l0.d;
import d.a.i0.r.a0.b;
import d.a.i0.r.q.x0;
import d.a.i0.r.s.a;
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
    public static final String NATIVE_PAY_FROM = "from_type";
    public static final int PROCESS_LIMIT_NONE = 0;
    public static final Pattern pbPattern0 = Pattern.compile("(tieba.baidu.com/p/){1}([\\d]+)");
    public static final String[] sNativeAdPrefixes = {"http://m.baidu.com/baidu.php?url=", "https://m.baidu.com/baidu.php?url="};
    public static final String[] sNativeAdEncoded = {"http%3a%2f%2fm.baidu.com%2fbaidu.php%3furl%3d", "https%3a%2f%2fm.baidu.com%2fbaidu.php%3furl%3d"};

    /* loaded from: classes3.dex */
    public static class NativePage {
        public String id;
        public NativePageType type = NativePageType.NONE;
    }

    /* loaded from: classes3.dex */
    public enum NativePageType {
        NONE,
        FRS,
        PB
    }

    public static boolean FirstStartActivity(Activity activity) {
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) activity.getSystemService("activity")).getRunningTasks(100)) {
            if (runningTaskInfo.baseActivity.getClassName().equals(activity.getClass().getName())) {
                return true;
            }
        }
        return false;
    }

    public static String appendCuidParam(String str) {
        if (k.isEmpty(str) || str.indexOf("cuid=") <= -1) {
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

    public static String appendVersionCode(String str) {
        if (k.isEmpty(str) || str.indexOf("_client_version=") <= -1) {
            return str + "&_client_version=" + TbConfig.getVersion();
        }
        return str;
    }

    public static void callPhone(Context context, String str) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            BdLog.detailException(e2);
        } catch (SecurityException e3) {
            BdLog.detailException(e3);
        }
    }

    public static boolean canUseStyleImmersiveSticky() {
        if (Build.VERSION.SDK_INT >= 19 && TbadkCoreApplication.getInst() != null && TbadkCoreApplication.getInst().isMeiZuCanUseImmersive() && !isSMF9000()) {
            return TbadkCoreApplication.getInst().isImmersiveStickyCanUse();
        }
        return false;
    }

    public static void changeFlyMeStatusBarColor(Window window, boolean z) {
        int color;
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
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public static void changeStatusBarIconAndTextColor(boolean z, Activity activity) {
        int i2;
        if (activity == null || activity.getWindow() == null || isMeizuM355()) {
            return;
        }
        if (Build.DISPLAY.toLowerCase().contains(ImmersiveOSUtils.FLYME) && Build.VERSION.SDK_INT < 28) {
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
            i2 = systemUiVisibility & (-8193);
        } else {
            if (TbadkCoreApplication.getInst().isMIUIRom()) {
                Window window = activity.getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            }
            i2 = systemUiVisibility | 8192;
        }
        decorView.setSystemUiVisibility(i2);
    }

    public static void clearClipBoard() {
        try {
            ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, null));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void clearClipBoardBySchemaParam(String str) {
        Uri parse;
        String queryParameter;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (queryParameter = parse.getQueryParameter(KEY_HAS_TOKEN)) == null || !queryParameter.equals("1")) {
            return;
        }
        clearClipBoard();
    }

    public static boolean commenDealIntent(Context context, Intent intent) {
        PbActivityConfig createNormalCfg;
        int i2;
        boolean z = false;
        if (intent == null || intent.getExtras() == null) {
            return false;
        }
        int i3 = intent.getExtras().getInt(DealIntentService.KEY_CLASS, -1);
        TbPageContext<BaseFragmentActivity> tbPageContext = null;
        switch (i3) {
            case 0:
                a.l(context, intent.getExtras().getString("url"));
                z = true;
                break;
            case 1:
                String stringExtra = intent.getStringExtra("id");
                String stringExtra2 = intent.getStringExtra("from");
                String string = intent.getExtras().getString("stat");
                String stringExtra3 = intent.getStringExtra("link");
                String stringExtra4 = intent.getStringExtra("task_id");
                if (!k.isEmpty(stringExtra4)) {
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
                    String stringExtra5 = intent.getStringExtra("gid");
                    if (!TextUtils.isEmpty(stringExtra5)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(stringExtra5 + "", 4)));
                    }
                }
                if (intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_LOCAL_PUSH, false)) {
                    TiebaStatic.log(new StatisticItem("c13265"));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                z = true;
                break;
            case 2:
                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(context).createNormalCfg(intent.getStringExtra("fname"), intent.getStringExtra("from"));
                createNormalCfg2.setCallFrom(13);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                z = true;
                break;
            case 3:
                if (b.b() != null) {
                    intent.setClass(context, b.b());
                    if (!(context instanceof Activity) && intent != null) {
                        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    }
                    context.startActivity(intent);
                }
                z = true;
                break;
            case 4:
            case 6:
            case 7:
            case 10:
            case 16:
            case 17:
            case 20:
            case 26:
            default:
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
                int intExtra9 = intent.getIntExtra("KeyOfNotiId", 16);
                int u = d.a.i0.s.d.b.g0().u();
                int A = d.a.i0.s.d.b.g0().A();
                int v = d.a.i0.s.d.b.g0().v();
                int t = d.a.i0.s.d.b.g0().t();
                int y = d.a.i0.s.d.b.g0().y();
                int z2 = d.a.i0.s.d.b.g0().z();
                d.a.i0.s.d.b.g0().W(u, A, v, t, y, z2);
                boolean z3 = intExtra4 > 0 || intExtra7 > 0 || intExtra6 > 0 || intExtra5 > 0 || intExtra8 > 0;
                boolean z4 = intExtra9 == 29 && intExtra > 0;
                boolean z5 = intExtra9 == 24 && intExtra3 > 0;
                boolean z6 = intExtra9 == 25 && intExtra2 > 0;
                if (z4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(context)));
                    d.a.i0.s.d.b.g0().Y(0);
                } else if (z5) {
                    d.a.i0.s.d.b.g0().e0(0);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ReplyMeActivityConfig(context)));
                    d.a.i0.s.d.b.g0().e0(0);
                } else if (z6) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(context)));
                    d.a.i0.s.d.b.g0().Z(0);
                } else if (i3 == 35) {
                    if (!z3 && intExtra <= 0 && intExtra3 <= 0 && intExtra2 <= 0 && z2 <= 0 && t <= 0) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        int sex = TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getSex() : 0;
                        if (currentAccount != null && currentAccount.length() > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(context, false, currentAccount, sex)));
                            d.a.i0.s.d.b.g0().c0(0);
                        }
                    } else {
                        goToMessageCenterFromNotifyCenter(intExtra9);
                    }
                } else if (z3) {
                    TiebaStatic.log(TbadkCoreStatisticKey.PUSH_MESSAGE_CLICK);
                    if (i3 == 5 && b.a() == 3) {
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
                b.e(context, 2);
                z = true;
                break;
            case 9:
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(context);
                } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(context)));
                } else {
                    b.e(context, 1);
                }
                z = true;
                break;
            case 12:
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                if (b.a() == 8) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createNormalCfg(8)));
                } else if (!TextUtils.isEmpty(currentAccount2) && !TextUtils.isEmpty(currentAccountName)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, currentAccount2, currentAccountName, d.a.i0.s.d.b.g0().y())));
                }
                z = true;
                break;
            case 13:
                MessageManager.getInstance().sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(context, d.a.c.e.m.b.f(intent.getStringExtra("groupid"), 0L), 0)));
                z = true;
                break;
            case 14:
                MessageManager.getInstance().sendMessage(new CustomMessage(2008013));
                z = true;
                break;
            case 15:
                d.c().a(new PayConfig(d.a.c.e.m.b.d(intent.getStringExtra("pay_type"), 0), intent.getStringExtra("is_left"), intent.getStringExtra("props_id"), intent.getStringExtra("quan_num"), intent.getStringExtra("props_mon"), true, intent.getStringExtra(MemberPayStatistic.REFER_PAGE), intent.getStringExtra(MemberPayStatistic.CLICK_ZONE)), context);
                break;
            case 18:
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(context, "", false)));
                z = true;
                break;
            case 19:
                MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(context)));
                z = true;
                break;
            case 22:
                String stringExtra6 = intent.getStringExtra("barid");
                String stringExtra7 = intent.getStringExtra("barname");
                String stringExtra8 = intent.getStringExtra("portrait");
                long f2 = d.a.c.e.m.b.f(stringExtra6, -1L);
                if (f2 > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(context, f2, stringExtra7, stringExtra8, 0)));
                    z = true;
                    break;
                }
                break;
            case 23:
                String stringExtra9 = intent.getStringExtra("wanted_type");
                String stringExtra10 = intent.getStringExtra("from_type");
                String stringExtra11 = intent.getStringExtra(MemberPayStatistic.REFER_PAGE);
                String stringExtra12 = intent.getStringExtra(MemberPayStatistic.CLICK_ZONE);
                int parseInt = Integer.parseInt(stringExtra9);
                if (!StringUtils.isNull(stringExtra10)) {
                    if (stringExtra10.equals(TbadkCoreStatisticKey.TAIL_PAY_MEMBER_SUCCESS)) {
                        i2 = 6;
                    } else if (stringExtra10.equals(TbadkCoreStatisticKey.BUBBLE_PAY_MEMBER_SUCCESS)) {
                        i2 = 7;
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(context, parseInt, false, i2);
                    memberPayActivityConfig.setReferPageClickZone(stringExtra11, stringExtra12);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                    z = true;
                    break;
                }
                i2 = 0;
                MemberPayActivityConfig memberPayActivityConfig2 = new MemberPayActivityConfig(context, parseInt, false, i2);
                memberPayActivityConfig2.setReferPageClickZone(stringExtra11, stringExtra12);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig2));
                z = true;
            case 24:
                String currentAccount3 = TbadkCoreApplication.getCurrentAccount();
                String currentAccountName2 = TbadkCoreApplication.getCurrentAccountName();
                if (currentAccount3 != null && currentAccount3.length() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(context, currentAccount3, currentAccountName2, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow() : currentAccountName2, 0)));
                }
                z = true;
                break;
            case 25:
                CurrencyJumpHelper.nativeGotoBuyBean(context);
                z = true;
                break;
            case 27:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(context, d.a.c.e.m.b.f(intent.getStringExtra("uid"), 0L), intent.getStringExtra("uname"), null, 0, intent.getIntExtra("user_type", 0))));
                z = true;
                break;
            case 28:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(context, d.a.c.e.m.b.f(intent.getStringExtra(PbChosenActivityConfig.KEY_TID), 0L), null)));
                z = true;
                break;
            case 29:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(context, d.a.c.e.m.b.f(intent.getStringExtra(PbChosenActivityConfig.KEY_TID), 0L), null, 2)));
                z = true;
                break;
            case 30:
                String string2 = intent.getExtras().getString("jump_url");
                boolean z7 = intent.getExtras().getBoolean("is_ad", false);
                i c2 = j.c(context);
                if (c2 instanceof BaseActivity) {
                    UrlManager.getInstance().dealOneLink(((BaseActivity) c2).getPageContext(), new String[]{string2}, z7);
                } else if (c2 instanceof BaseFragmentActivity) {
                    UrlManager.getInstance().dealOneLink(((BaseFragmentActivity) c2).getPageContext(), new String[]{string2}, z7);
                } else if (c2 instanceof ProxyAdkBaseActivity) {
                    UrlManager.getInstance().dealOneLink(((ProxyAdkBaseActivity) c2).getPageContext(), new String[]{string2}, z7);
                }
                z = true;
                break;
            case 31:
                TiebaStatic.log(TbadkCoreStatisticKey.PUSH_ENTRANCE);
                z = true;
                break;
            case 32:
                try {
                    PaymentConfirmRequestData paymentConfirmRequestData = (PaymentConfirmRequestData) intent.getSerializableExtra(PaymentConfirmActivityConfig.REQUEST_PARAMS);
                    if (paymentConfirmRequestData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PaymentConfirmActivityConfig(context, paymentConfirmRequestData, "", "")));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                z = true;
                break;
            case 33:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001259));
                MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(context)));
                TiebaStatic.log(TbadkCoreStatisticKey.PL_COLLECT_UPDATE_NOTIFICATION);
                z = true;
                break;
            case 34:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoListActivityConfig(context).createNormalCfg(intent.getStringExtra("fid"), intent.getStringExtra("tid"), "push")));
                z = true;
                break;
            case 36:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(context, intent.getIntExtra("tab_id", -1))));
                z = true;
                break;
            case 37:
                String stringExtra13 = intent.getStringExtra(IntentConfig.KEY_AI_APP_SCHEMA);
                if (context instanceof BaseActivity) {
                    tbPageContext = ((BaseActivity) context).getPageContext();
                } else if (context instanceof BaseFragmentActivity) {
                    tbPageContext = ((BaseFragmentActivity) context).getPageContext();
                }
                if (tbPageContext != null) {
                    UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{stringExtra13});
                }
                z = true;
                break;
            case 38:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AiAppGuideActivityConfig(context)));
                z = true;
                break;
            case 39:
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(context).createSubPbActivityConfig(intent.getStringExtra("thread_id"), intent.getStringExtra("post_id"), "", true);
                createSubPbActivityConfig.setIsFromeSchema(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                z = true;
                break;
        }
        if (z) {
            return z;
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 3);
        return commenDealIntent(context, intent);
    }

    public static void commenDealUrl(Context context, String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.length() > 4 && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_WEB)) {
            String substring = str.substring(4);
            String str2 = strArr[0];
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            a.n(context, str2, substring, false);
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
        try {
            ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("", str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean dealOneScheme(Context context, String str) {
        if (context != null && !k.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (!(context instanceof Activity)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            if (isIntentAvailable(context, intent)) {
                try {
                    context.startActivity(intent);
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public static boolean detectOpenGLES20(Context context) {
        ActivityManager activityManager;
        ConfigurationInfo deviceConfigurationInfo;
        return (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) == null || deviceConfigurationInfo.reqGlEsVersion < 131072) ? false : true;
    }

    public static RectF fixedDrawableRect(Rect rect, View view) {
        GifView gifView;
        TbImageView tbImageView;
        if (rect != null) {
            boolean z = view instanceof TbImageView;
            if (z || (view instanceof GifView)) {
                RectF rectF = new RectF();
                if (z) {
                    rectF.right = rectF.left + tbImageView.getImageWidth();
                    rectF.bottom = rectF.top + tbImageView.getImageHeight();
                    ((TbImageView) view).getImageMatrix().mapRect(rectF);
                } else if (view instanceof GifView) {
                    rectF.right = rectF.left + gifView.getImageWidth();
                    rectF.bottom = rectF.top + gifView.getImageHeight();
                    ((GifView) view).getImageMatrix().mapRect(rectF);
                }
                float f2 = rectF.left;
                int i2 = rect.left;
                rectF.left = f2 + i2;
                rectF.right += i2;
                float f3 = rectF.top;
                int i3 = rect.top;
                rectF.top = f3 + i3;
                rectF.bottom += i3;
                return rectF;
            }
            return null;
        }
        return null;
    }

    public static String formalDecimalForTwo(float f2) {
        return new DecimalFormat("0.00").format(f2);
    }

    public static String formatNumber(String str) {
        StringBuilder sb = new StringBuilder("");
        if (str != null) {
            int i2 = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                sb.insert(0, str.charAt(length));
                i2++;
                if (i2 % 3 == 0 && length != 0) {
                    sb.insert(0, ",");
                    i2 = 0;
                }
            }
        }
        return sb.toString();
    }

    public static String formatOverStep(String str, int i2) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() <= i2) {
            return str;
        }
        return str.substring(0, i2) + StringHelper.STRING_MORE;
    }

    public static int getBazhuIconId(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        return (str.equals("5") || str.toUpperCase().equals("A")) ? z ? R.drawable.pic_barman_5level_simple12 : R.drawable.pic_barman_5level40 : (str.equals("4") || str.toUpperCase().equals("B")) ? z ? R.drawable.pic_barman_4level_simple12 : R.drawable.pic_barman_4level40 : (str.equals("3") || str.toUpperCase().equals("C")) ? z ? R.drawable.pic_barman_3level_simple12 : R.drawable.pic_barman_3level40 : (str.equals("2") || str.toUpperCase().equals("D")) ? z ? R.drawable.pic_barman_2level_simple12 : R.drawable.pic_barman_2level40 : z ? R.drawable.pic_barman_1level_simple12 : R.drawable.pic_barman_1level40;
    }

    public static int getBitmapMaxMemory(Context context) {
        return CompatibleUtile.getInstance().getBitmapMaxMemory(context);
    }

    public static Drawable getBjhBigVIconDrawable(int i2) {
        return SvgManager.getInstance().getMaskDrawable(i2, SvgManager.SvgResourceStateType.NORMAL);
    }

    public static int getBjhBigVIconId(int i2, int i3) {
        if (i2 > 0) {
            if (i3 == 0 || i3 == 4) {
                return R.drawable.ic_icon_mask_v14_n_svg;
            }
            if (i3 == 1) {
                return R.drawable.ic_icon_mask_v12_n_svg;
            }
            if (i3 == 2) {
                return R.drawable.ic_icon_mask_v16_n_svg;
            }
            if (i3 == 3) {
                return R.drawable.ic_icon_mask_v20_n_svg;
            }
            return R.drawable.ic_icon_mask_v14_n_svg;
        }
        return 0;
    }

    public static Bitmap getCacheBitmapFromView(View view) {
        c.k().i(l.k(TbadkCoreApplication.getInst()) * l.i(TbadkCoreApplication.getInst()) * 2);
        view.setDrawingCacheEnabled(true);
        Bitmap drawingCache = view.getDrawingCache();
        Bitmap bitmap = null;
        if (drawingCache != null) {
            try {
                bitmap = Bitmap.createBitmap(drawingCache);
                view.setDrawingCacheEnabled(false);
                return bitmap;
            } catch (OutOfMemoryError unused) {
                System.gc();
                return bitmap;
            }
        }
        return null;
    }

    public static String getClientIP() {
        if (d.a.c.e.p.j.H()) {
            return getWifiMac(TbadkCoreApplication.getInst().getApp());
        }
        return getGprsIpv4Address();
    }

    public static String getClipBoardContent() {
        try {
            ClipData primaryClip = ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService("clipboard")).getPrimaryClip();
            return (primaryClip == null || primaryClip.getItemAt(0) == null || primaryClip.getItemAt(0).getText() == null) ? "" : primaryClip.getItemAt(0).getText().toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static long getCorrectUserIdAfterOverflowCut(long j) {
        return j >= 0 ? j : j + 4294967296L;
    }

    public static String getCurrentDay() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public static String getCurrentVerson(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static long getDayBetweenTime(long j, long j2) {
        return ((j2 - j) / 1000) / 86400;
    }

    public static String getDeviceId() {
        TelephonyManager telephonyManager;
        return (!PermissionUtil.checkReadPhoneState(TbadkCoreApplication.getInst()) || (telephonyManager = (TelephonyManager) TbadkCoreApplication.getInst().getSystemService("phone")) == null) ? "" : telephonyManager.getDeviceId();
    }

    public static int getDimenPixelSize(int i2) {
        return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i2);
    }

    public static String getFixedBarText(String str, int i2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        double d2 = 0.0d;
        int i3 = 0;
        while (true) {
            if (i3 >= str.length()) {
                break;
            }
            char charAt = str.charAt(i3);
            d2 += ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z') && (charAt < '0' || charAt > '9')) ? 1.0d : 0.5d;
            if (d2 <= i2) {
                sb.append(charAt);
                i3++;
            } else if (z) {
                sb.deleteCharAt(i3 - 1);
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    public static String getFixedText(String str, int i2) {
        return getFixedText(str, i2, true);
    }

    public static int getFixedTextSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            i2 = str.charAt(i3) > 255 ? i2 + 2 : i2 + 1;
        }
        return i2;
    }

    public static String getForumNameWithBar(String str) {
        return getForumNameWithGodBar(str, -1, false);
    }

    public static String getForumNameWithGodBar(String str, int i2, boolean z) {
        if (i2 <= -1) {
            if (k.byteLength(str) > 14) {
                str = StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
            }
        } else {
            str = getFixedBarText(str, i2, z);
        }
        return TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_god_bar, new Object[]{str});
    }

    public static String getFromPageKey(TbPageContext tbPageContext) {
        if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof d.a.i0.k0.a)) {
            return null;
        }
        d.a.i0.k0.a aVar = (d.a.i0.k0.a) tbPageContext.getPageActivity();
        if (aVar.getCurrentPageSourceKeyList() == null) {
            return null;
        }
        return (String) ListUtils.getItem(aVar.getCurrentPageSourceKeyList(), aVar.getCurrentPageSourceKeyList().size() - 1);
    }

    public static String getGprsIpAddress() {
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
        } catch (SocketException e2) {
            BdLog.e(e2.toString());
            return null;
        }
    }

    public static String getGprsIpv4Address() {
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
        } catch (SocketException e2) {
            BdLog.e(e2.toString());
            return null;
        }
    }

    public static int getImmersiveStickyBarHeight() {
        if (canUseStyleImmersiveSticky()) {
            return getStatusBarHeight();
        }
        return 0;
    }

    public static int getInstallApkVersion(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        return -1;
    }

    public static String getInstallApkVersionName(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static String getIpFromDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (Exception e2) {
            BdLog.detailException(e2);
            return null;
        }
    }

    public static int getLightStatusBarHeight() {
        if (canUseStyleImmersiveSticky()) {
            try {
                return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.a.c.e.m.b.d(Class.forName("com.android.internal.R$dimen").getField("status_bar_height").get(null).toString(), 0));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    public static String getMetaValue(Context context, String str) {
        Bundle bundle;
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

    public static String getNavBarOverride() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int getNavigationBarHeight(Context context) {
        Resources resources;
        int identifier;
        if (!hasNavBar(context) || (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public static int getNetworkOperator() {
        String substring;
        String simOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService("phone")).getSimOperator();
        if (simOperator == null || simOperator.length() < 4 || k.isEmptyStringAfterTrim(simOperator) || (substring = simOperator.substring(0, 3)) == null || !substring.equals("460")) {
            return 0;
        }
        int d2 = d.a.c.e.m.b.d(simOperator.substring(3), 0);
        if (d2 != 0) {
            if (d2 != 1) {
                if (d2 != 2) {
                    if (d2 != 3 && d2 != 5) {
                        if (d2 != 6) {
                            if (d2 != 7) {
                                if (d2 != 11) {
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

    public static long getNextDayMorning() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static Object getProcessLimit() {
        BdLog.d("baidu.tieba.processlimit ");
        try {
            Class<?> cls = Class.forName("android.app.ActivityManagerNative");
            Object cast = Class.forName("android.app.IActivityManager").cast(cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]));
            return cast.getClass().getMethod("getProcessLimit", new Class[0]).invoke(cast, new Object[0]);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            BdLog.e("getProcessLimit error");
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            BdLog.e("getProcessLimit error");
            return null;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            BdLog.e("getProcessLimit error");
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            BdLog.e("getProcessLimit error");
            return null;
        }
    }

    public static int getRandom(Random random, int i2, int i3) {
        int nextInt = random.nextInt(i2);
        return nextInt == i3 ? (nextInt + 1) % i2 : nextInt;
    }

    public static int getRealScreenOrientation(Context context) {
        int[] p = l.p(context);
        int i2 = context.getResources().getConfiguration().orientation;
        if (i2 == 2 || p[0] <= p[1]) {
            return i2;
        }
        return 2;
    }

    public static int getScreenHeight(Context context) {
        int i2 = 0;
        if (context == null) {
            return 0;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            i2 = displayMetrics.heightPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return i2 == 0 ? l.i(context) : i2;
    }

    public static Drawable getSelectorDrawableByAlpha(@DrawableRes int i2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Drawable drawable = SkinManager.getDrawable(i2);
        Drawable drawable2 = SkinManager.getDrawable(i2);
        drawable2.mutate();
        drawable2.setAlpha((int) (f2 * 255.0f));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static SpannableStringBuilder getSpannableIcon(Context context, String str, int i2, boolean z) {
        if (k.isEmpty(str) || context == null || i2 == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Bitmap bitmap = SkinManager.getBitmap(i2);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        if (bitmap != null) {
            bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        d.a.i0.r.f0.i iVar = new d.a.i0.r.f0.i(bitmapDrawable);
        iVar.b(l.g(context, R.dimen.ds4));
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) " ");
        if (z) {
            spannableStringBuilder.setSpan(iVar, length, spannableStringBuilder.length(), 17);
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.append((CharSequence) str);
        } else {
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.setSpan(iVar, length, spannableStringBuilder.length(), 17);
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder getSpannableIconByVertical(Context context, String str, int i2, boolean z) {
        if (k.isEmpty(str) || context == null || i2 == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Bitmap bitmap = SkinManager.getBitmap(i2);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        if (bitmap != null) {
            bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        d.a.i0.r.f0.l lVar = new d.a.i0.r.f0.l(bitmapDrawable);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) " ");
        if (z) {
            spannableStringBuilder.setSpan(lVar, length, spannableStringBuilder.length(), 17);
            spannableStringBuilder.append((CharSequence) str);
        } else {
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.setSpan(lVar, length, spannableStringBuilder.length(), 17);
        }
        return spannableStringBuilder;
    }

    public static int getStatusBarHeight() {
        try {
            return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.a.c.e.m.b.d(Class.forName("com.android.internal.R$dimen").getField("status_bar_height").get(null).toString(), 0));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int getStatusBarHeight_gtoe9_0() {
        int identifier = TbadkCoreApplication.getInst().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getStatusBarHeight_ltoe9_0() {
        try {
            return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.a.c.e.m.b.d(Class.forName("com.android.internal.R$dimen").getField("status_bar_height").get(null).toString(), 0));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static String getSystemProperty(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return readLine;
            } catch (IOException unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static TbPageContext getTbPageContext(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }

    public static String getTiebaApkMd5() {
        try {
            String versionName = TbadkCoreApplication.getInst().getVersionName();
            String p = d.a.i0.r.d0.b.j().p("version_name", "");
            if (TextUtils.isEmpty(versionName)) {
                return null;
            }
            if (versionName.equals(p)) {
                return d.a.i0.r.d0.b.j().p("apk_md5", "");
            }
            d.a.i0.r.d0.b.j().x("version_name", versionName);
            String aPKMd5 = TbMd5.getAPKMd5(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(TbadkCoreApplication.getInst().getPackageName(), 0));
            d.a.i0.r.d0.b.j().x("apk_md5", aPKMd5);
            return aPKMd5;
        } catch (PackageManager.NameNotFoundException e2) {
            BdLog.detailException(e2);
            return null;
        }
    }

    public static long getTimesMorning() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static long getTodayZeroTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static String getTopActivityClassName() {
        Activity b2;
        ComponentName componentName;
        if (d.a.c.a.b.f() == null || (b2 = d.a.c.a.b.f().b()) == null || (componentName = b2.getComponentName()) == null) {
            return null;
        }
        return componentName.getClassName();
    }

    public static Uri getUriFromFile(File file, Intent intent, Context context) {
        if (file == null || intent == null || context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
            return FileProvider.getUriForFile(context, "com.baidu.tieba.fileprovider", file);
        }
        return Uri.fromFile(file);
    }

    public static String getUserName(MetaData metaData) {
        return metaData == null ? "" : metaData.getName_show();
    }

    public static int getVirtualBarHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics.heightPixels - windowManager.getDefaultDisplay().getHeight();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static String getWifiMac(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (!wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(true);
            }
            return intToIp(wifiManager.getConnectionInfo().getIpAddress());
        } catch (Exception e2) {
            BdLog.e(e2.toString());
            return null;
        }
    }

    public static final Intent getYYNotificationIntent(Context context, x0 x0Var, String str) {
        String substring;
        if (context != null && x0Var != null && !TextUtils.isEmpty(str)) {
            if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_FRS)) {
                try {
                    return Intent.parseUri(str, 1);
                } catch (URISyntaxException e2) {
                    e2.printStackTrace();
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
                } catch (Exception e3) {
                    BdLog.e(e3.toString());
                    return null;
                }
            } else if (str.startsWith("pk_before:")) {
                intent.putExtra(DealIntentService.KEY_CLASS, 6);
                intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
            } else if (str.startsWith("pk_after:")) {
                intent.putExtra(DealIntentService.KEY_CLASS, 7);
                intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
            } else if (str.startsWith("vote")) {
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
            intent.putExtra("message_id", x0Var.c());
            intent.putExtra("task_id", x0Var.e());
            if (!TextUtils.isEmpty(x0Var.d())) {
                intent.putExtra("stat", x0Var.d());
            }
            return intent;
        }
        return null;
    }

    public static void goToMessageCenterFromNotifyCenter(int i2) {
        Intent intent = new Intent();
        intent.putExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, i2);
        intent.putExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 1);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016321, intent));
        b.e(TbadkCoreApplication.getInst().getApplicationContext(), 3);
    }

    public static boolean hasAvaiableSDCardSpace(int i2) {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024 > ((long) i2);
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
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

    public static boolean hasNotchAndroidP(Activity activity) {
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

    public static boolean hasNotchAtHuawei(Activity activity) {
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

    public static boolean hasNotchMiui() {
        String systemProperty = getSystemProperty("ro.miui.notch");
        return !StringUtils.isNULL(systemProperty) && systemProperty.equals("1");
    }

    public static boolean hasNotchOPPO() {
        return TbadkCoreApplication.getInst().getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean hasNotchVivo() {
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
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void hideStatusBar(Activity activity, View view) {
        if (activity == null || view == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 16) {
            if (activity.getWindow() != null) {
                activity.getWindow().setFlags(1024, 1024);
                return;
            } else {
                view.setSystemUiVisibility(2);
                return;
            }
        }
        view.setSystemUiVisibility(4);
    }

    public static void install_apk(Context context, String str) {
        File GetFile;
        if (str == null || str.length() <= 0 || (GetFile = FileHelper.GetFile(str)) == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(getUriFromFile(GetFile, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            if (isHaveActivityCanHandleIntent(intent)) {
                context.startActivity(intent);
            }
        } catch (SecurityException unused) {
        }
    }

    public static String int2ver(int i2) {
        return ((i2 >> 24) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 8) & 255) + "." + (i2 & 255);
    }

    public static String intToIp(int i2) {
        return (i2 & 255) + "." + ((i2 >> 8) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 24) & 255);
    }

    public static boolean isARM() {
        RandomAccessFile randomAccessFile;
        Throwable th;
        Exception e2;
        byte[] bArr;
        String str = Build.CPU_ABI;
        if (str == null || !str.toLowerCase().contains("arm")) {
            try {
                bArr = new byte[1024];
                randomAccessFile = new RandomAccessFile("/proc/cpuinfo", r.f7975a);
                try {
                    try {
                    } catch (Exception e3) {
                        e2 = e3;
                        BdLog.e(e2.getMessage());
                        m.d(randomAccessFile);
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    m.d(randomAccessFile);
                    throw th;
                }
            } catch (Exception e4) {
                randomAccessFile = null;
                e2 = e4;
            } catch (Throwable th3) {
                randomAccessFile = null;
                th = th3;
                m.d(randomAccessFile);
                throw th;
            }
            if (randomAccessFile.read(bArr) < 1) {
                m.d(randomAccessFile);
                return false;
            }
            String str2 = new String(bArr);
            int indexOf = str2.indexOf(0);
            if (indexOf != -1) {
                str2 = str2.substring(0, indexOf);
            }
            if (str2.toLowerCase().contains("arm")) {
                m.d(randomAccessFile);
                return true;
            }
            m.d(randomAccessFile);
            return false;
        }
        return true;
    }

    public static boolean isActivityStartFromScheme(Activity activity) {
        if (activity == null || activity.getIntent() == null) {
            return false;
        }
        return !k.isEmpty(activity.getIntent().getDataString());
    }

    public static boolean isAppForeground() {
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

    public static boolean isAutoBrightness(Context context) {
        return CompatibleUtile.getInstance().isAutoBrightness(context);
    }

    public static boolean isBackgroundProcessLimitNone() {
        Object processLimit = getProcessLimit();
        return processLimit != null && processLimit.toString().equals(String.valueOf(0));
    }

    public static boolean isCurrentAccount(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return !StringUtils.isNull(currentAccount) && currentAccount.equals(str);
    }

    public static boolean isCutoutScreen(Activity activity) {
        try {
            Resources resources = activity.getResources();
            int identifier = resources.getIdentifier("config_mainBuiltInDisplayCutout", "string", "android");
            String string = identifier > 0 ? resources.getString(identifier) : null;
            if (string != null) {
                return !TextUtils.isEmpty(string);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isDecimal(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return Pattern.compile("[0-9|\\.]+").matcher(str).matches();
    }

    public static boolean isFlyMeOs() {
        return Build.DISPLAY.toLowerCase().contains(ImmersiveOSUtils.FLYME);
    }

    public static boolean isFlymeOsOver51() {
        String o;
        String str = Build.DISPLAY;
        if (str != null && str.contains("Flyme") && (o = l.o(str)) != null && o.length() >= 3) {
            int d2 = d.a.c.e.m.b.d(l.o(o.substring(0, 1)), 0);
            int d3 = d.a.c.e.m.b.d(l.o(o.substring(1, 2)), 0);
            if (d2 == 6 && d3 <= 1) {
                return true;
            }
            if (d2 == 5 && d3 >= 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean isGotoVideoMiddlePage() {
        return SwitchManager.getInstance().findType(VideoMiddlePageSwitch.KEY) == 1;
    }

    public static boolean isGotoVideoSquareMiddlePage() {
        return SwitchManager.getInstance().findType(VideoSquareMiddlePageSwitch.KEY) == 1;
    }

    public static boolean isHaveActivityCanHandleIntent(Intent intent) {
        PackageManager packageManager = TbadkCoreApplication.getInst().getPackageManager();
        return ListUtils.getCount(packageManager != null ? packageManager.queryIntentActivities(intent, 32) : null) > 0;
    }

    public static boolean isHuaWeiU9508Device() {
        String str = Build.MODEL;
        return !TextUtils.isEmpty(str) && str.contains("Huawei_HUAWEI U9508");
    }

    public static boolean isInstallApk(Context context, String str) {
        PackageInfo packageInfo;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean isInstalledPackage(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 8192) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return (queryIntentActivities == null || queryIntentActivities.isEmpty()) ? false : true;
    }

    public static boolean isMeizuE3() {
        return "Meizu".equalsIgnoreCase(Build.BRAND) && "MEIZU E3".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean isMeizuM355() {
        return "Meizu".equalsIgnoreCase(Build.BRAND) && "M355".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean isMeizuPro7Plus() {
        return "Meizu".equalsIgnoreCase(Build.BRAND) && "PRO 7 Plus".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean isMiNotchDevice() {
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("MI 8") || str.contains("MI8");
    }

    public static boolean isNativeAdURL(String str) {
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

    public static NativePage isNativeAddress(String str) {
        String substring;
        String substring2;
        String str2;
        NativePage nativePage = new NativePage();
        if (str != null && !k.isEmpty(str)) {
            Matcher matcher = pbPattern0.matcher(str);
            if (matcher.find()) {
                try {
                    String group = matcher.group(2);
                    if (!TextUtils.isEmpty(group)) {
                        nativePage.id = group;
                        nativePage.type = NativePageType.PB;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            int i2 = 0;
            String str3 = null;
            if (str != null) {
                str = str.toLowerCase();
                if (str.startsWith("http://tieba.baidu.com/f?")) {
                    substring2 = str.substring(25);
                } else {
                    substring2 = str.startsWith("http://tieba.baidu.com/f?") ? str.substring(25) : null;
                }
                if (substring2 == null) {
                    return nativePage;
                }
                String[] split = substring2.split("&");
                if (!substring2.startsWith("kz=")) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= split.length) {
                            str2 = null;
                            break;
                        } else if (split[i3] != null && split[i3].startsWith("kz=")) {
                            str2 = split[i3].substring(3);
                            break;
                        } else {
                            i3++;
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
                if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                    substring = lowerCase.substring(25);
                } else {
                    substring = lowerCase.startsWith("http://tieba.baidu.com/f?") ? lowerCase.substring(25) : null;
                }
                if (substring == null) {
                    return nativePage;
                }
                String[] split2 = substring.split("&");
                if (!substring.startsWith("kw=")) {
                    while (true) {
                        if (i2 < split2.length) {
                            if (split2[i2] != null && split2[i2].startsWith("kw=")) {
                                str3 = split2[i2].substring(3);
                                break;
                            }
                            i2++;
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

    public static boolean isNavigationbarShown(Resources resources) {
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        return identifier > 0 && resources.getBoolean(identifier);
    }

    public static boolean isNotchScreen(Activity activity) {
        boolean z = false;
        boolean hasNotchAndroidP = Build.VERSION.SDK_INT >= 28 ? hasNotchAndroidP(activity) : false;
        if (hasNotchAndroidP) {
            return hasNotchAndroidP;
        }
        return (hasNotchMiui() || hasNotchAtHuawei(activity) || isOnePlus6() || hasNotchOPPO() || hasNotchVivo()) ? true : true;
    }

    public static boolean isNumber(String str) {
        return Pattern.compile("[0-9]+").matcher(str).matches();
    }

    public static boolean isOnePlus6() {
        return "OnePlus".equalsIgnoreCase(Build.BRAND) && "ONEPLUS A6000".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean isOppoConcaveScreen() {
        if (TbadkCoreApplication.getInst().getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism")) {
            String str = Build.MODEL;
            String[] strArr = {"PAAM00", "PAAT00", "PACM00", "PACT00", "CPH1831", "CPH1833"};
            for (int i2 = 0; i2 < 6; i2++) {
                if (str.equalsIgnoreCase(strArr[i2])) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean isOppoDevice() {
        String str = Build.BRAND;
        if (k.isEmpty(str)) {
            return false;
        }
        return str.contains("OPPO") || str.contains(RomUtils.MANUFACTURER_OPPO) || str.contains("Oppo");
    }

    public static boolean isPhoneNumber(String str) {
        return !StringUtils.isNull(str) && isNumber(str) && str.length() == 11 && str.startsWith("1");
    }

    public static boolean isSMF9000() {
        return Build.MODEL.equalsIgnoreCase("SM-F9000");
    }

    public static boolean isSameDay(long j, long j2) {
        return j <= j2 && j / 86400000 == j2 / 86400000;
    }

    public static boolean isSelf(com.baidu.tbadk.core.data.MetaData metaData) {
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

    public static boolean isShowBjhBigV(BaijiahaoInfo baijiahaoInfo) {
        return baijiahaoInfo != null && baijiahaoInfo.auth_id.intValue() > 0;
    }

    public static boolean isSupportGesture(Context context) {
        return Build.VERSION.SDK_INT > 4 && CompatibleUtile.getInstance().supportMultiTouch(context);
    }

    public static boolean isSystemLocationProviderEnabled(Context context) {
        if (PermissionUtil.checkLocationForGoogle(context)) {
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                if (!locationManager.isProviderEnabled("gps")) {
                    if (!locationManager.isProviderEnabled("network")) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean isTopActivity(String str) {
        Activity b2 = d.a.c.a.b.f().b();
        return (b2 == null || b2.getClass().getSimpleName() == null || !b2.getClass().getSimpleName().equals(str)) ? false : true;
    }

    public static boolean isUgcThreadType(int i2) {
        return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4;
    }

    public static boolean isUseSingleGod(UserData userData) {
        return (userData == null || userData.getGodUserData() == null || userData.getGodUserData().getType() != 2) ? false : true;
    }

    public static boolean isVivoDevice() {
        String str = Build.BRAND;
        if (k.isEmpty(str)) {
            return false;
        }
        return str.contains("VIVO") || str.contains(RomUtils.MANUFACTURER_VIVO) || str.contains("Vivo");
    }

    public static void openGpu(Activity activity) {
        CompatibleUtile.getInstance().openGpu(activity);
    }

    public static boolean parsePushMidPageUrl(String str, StringBuilder sb, StringBuilder sb2) {
        String str2;
        String str3;
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

    public static void quitDialog(final Activity activity) {
        new d.a.i0.r.s.a(activity).setTitle(R.string.inform).setCancelable(false).setMessageId(R.string.alert_quit_confirm).setPositiveButton(R.string.alert_yes_button, new a.e() { // from class: com.baidu.tbadk.core.util.UtilHelper.2
            @Override // d.a.i0.r.s.a.e
            public void onClick(d.a.i0.r.s.a aVar) {
                aVar.dismiss();
                TbadkCoreApplication.getInst().notifyAppEnterBackground();
                activity.finish();
            }
        }).setNegativeButton(R.string.cancel, new a.e() { // from class: com.baidu.tbadk.core.util.UtilHelper.1
            @Override // d.a.i0.r.s.a.e
            public void onClick(d.a.i0.r.s.a aVar) {
                aVar.dismiss();
            }
        }).create(j.a(activity)).show();
    }

    public static void setBitmapByTag(View view, String str, d.a.c.j.d.a aVar) {
        if (view == null || str == null) {
            return;
        }
        if (view.getTag() != null && view.getTag().equals(str)) {
            if (aVar == null) {
                view.invalidate();
            } else if (view instanceof ImageView) {
                aVar.h((ImageView) view);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt != null) {
                    setBitmapByTag(childAt, str, aVar);
                }
            }
        }
    }

    public static void setFlymeImmersedWindow(Window window, boolean z) {
        if (z && window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (Build.VERSION.SDK_INT < 19) {
                try {
                    Field declaredField = attributes.getClass().getDeclaredField("meizuFlags");
                    declaredField.setAccessible(true);
                    int i2 = declaredField.getInt(attributes);
                    declaredField.setInt(attributes, z ? i2 | 64 : i2 & (-65));
                    return;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return;
                }
            }
            attributes.flags |= CodedInputStream.DEFAULT_SIZE_LIMIT;
            window.setAttributes(attributes);
        }
    }

    public static void setNavigationBarBackground(Activity activity, int i2) {
        if (activity == null || !DeviceInfoUtil.isfullScreen()) {
            return;
        }
        if (Build.VERSION.SDK_INT > 21) {
            setNavigationBarBackground_L(activity, i2);
        } else {
            setNavigationBarBackground_K(activity, i2);
        }
    }

    public static void setNavigationBarBackgroundForVivoX20(Activity activity, int i2) {
        if (activity != null && DeviceInfoUtil.isVivoX20A() && isNavigationbarShown(activity.getResources())) {
            if (Build.VERSION.SDK_INT > 21) {
                setNavigationBarBackground_L(activity, i2);
            } else {
                setNavigationBarBackground_K(activity, i2);
            }
        }
    }

    public static void setNavigationBarBackground_K(Activity activity, int i2) {
        activity.getWindow().addFlags(134217728);
        View view = new View(activity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, d.a.c.e.p.a.b(activity));
        layoutParams.gravity = 80;
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(i2);
        ((ViewGroup) activity.getWindow().getDecorView()).addView(view);
    }

    public static void setNavigationBarBackground_L(Activity activity, int i2) {
        activity.getWindow().setNavigationBarColor(i2);
    }

    public static void setSpan(SpannableString spannableString, String str, String str2, CharacterStyle characterStyle) {
        if (spannableString == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || characterStyle == null) {
            return;
        }
        int indexOf = str.indexOf(str2);
        int length = str2.length();
        while (indexOf >= 0) {
            int i2 = indexOf + length;
            spannableString.setSpan(characterStyle, indexOf, i2, 33);
            indexOf = str.indexOf(str2, i2);
        }
    }

    public static void setStatusBarBackground(View view, int i2) {
        if (view == null) {
            return;
        }
        SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
    }

    public static void setSupportHeight(Context context, View view, float f2) {
        ViewGroup.LayoutParams layoutParams;
        DisplayMetrics displayMetrics;
        if (view == null || f2 <= 0.0f || context == null || (layoutParams = view.getLayoutParams()) == null || (displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics()) == null) {
            return;
        }
        layoutParams.height = Math.round(displayMetrics.widthPixels / f2);
        view.requestLayout();
    }

    public static void setTranslucentVirtualNavigation(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        window.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        window.addFlags(134217728);
    }

    public static void share(Context context, String str, String str2, String str3) {
        try {
            Intent intent = new Intent("android.intent.action.SEND", (Uri) null);
            intent.addCategory("android.intent.category.DEFAULT");
            if (str2.length() > 140) {
                str2 = str2.substring(0, PbFullScreenEditorActivity.REPLY_MAX_SIZE);
            }
            intent.putExtra("android.intent.extra.TEXT", str2);
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.setType("text/plain");
            context.startActivity(Intent.createChooser(intent, TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.share_to)));
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public static void shareThread(Context context, String str, String str2, String str3, String str4) {
        if (str2 == null || str3 == null || str4 == null) {
            return;
        }
        try {
            if (str3.length() > 140) {
                str3 = str3.substring(0, PbFullScreenEditorActivity.REPLY_MAX_SIZE);
            }
            String str5 = "http://tieba.baidu.com/p/" + str2 + "?share=9105";
            if (str != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), str, null, 1, "st_param", str2);
            }
            Intent intent = new Intent("android.intent.action.SEND", (Uri) null);
            intent.putExtra("android.intent.extra.TEXT", MessageFormat.format(context.getResources().getString(R.string.share_format), str3, str4, str5));
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.setType("text/plain");
            context.startActivity(Intent.createChooser(intent, context.getResources().getString(R.string.share_to)));
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public static boolean showHeadBazhuIcon(ImageView imageView, MetaData metaData, boolean z) {
        if (imageView == null || metaData == null || metaData.getBazhuGradeData() == null || k.isEmpty(metaData.getBazhuGradeData().getLevel()) || !metaData.showBazhuGrade()) {
            return false;
        }
        int bazhuIconId = getBazhuIconId(metaData.getBazhuGradeData().getLevel(), z);
        imageView.setVisibility(0);
        SkinManager.setImageResource(imageView, bazhuIconId);
        return true;
    }

    public static boolean showHeadBjhBigVIcon(ImageView imageView, MetaData metaData, int i2) {
        if (imageView == null || metaData == null || metaData.getBaijiahaoInfo() == null || !isShowBjhBigV(metaData.getBaijiahaoInfo())) {
            return false;
        }
        int bjhBigVIconId = getBjhBigVIconId(metaData.getBaijiahaoInfo().auth_id.intValue(), i2);
        imageView.setVisibility(0);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, bjhBigVIconId, SvgManager.SvgResourceStateType.NORMAL);
        return true;
    }

    public static void showHeadImageViewBigV(HeadImageView headImageView, MetaData metaData) {
        showHeadImageViewBigV(headImageView, metaData, 0);
    }

    public static boolean showOfficialIcon(ImageView imageView, MetaData metaData) {
        if (imageView == null || metaData == null || !metaData.isOfficial()) {
            return false;
        }
        imageView.setVisibility(0);
        WebPManager.setMaskDrawable(imageView, R.drawable.ic_icon_mask_shang22_n, null);
        return true;
    }

    public static void showSkinChangeAnimation(Activity activity) {
        if (d.a.i0.z0.l.a() || activity == null) {
            return;
        }
        final View decorView = activity.getWindow().getDecorView();
        final Bitmap cacheBitmapFromView = getCacheBitmapFromView(decorView);
        if (!(decorView instanceof ViewGroup) || cacheBitmapFromView == null) {
            return;
        }
        final View view = new View(activity);
        view.setBackgroundDrawable(new BitmapDrawable(activity.getResources(), cacheBitmapFromView));
        ((ViewGroup) decorView).addView(view, new ViewGroup.LayoutParams(-1, -1));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(300L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.core.util.UtilHelper.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ((ViewGroup) decorView).removeView(view);
                Bitmap bitmap = cacheBitmapFromView;
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                cacheBitmapFromView.recycle();
            }
        });
        ofFloat.start();
    }

    public static void showStatusBar(Activity activity, View view) {
        if (activity == null || view == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 16) {
            if (activity.getWindow() != null) {
                activity.getWindow().clearFlags(1024);
                return;
            } else {
                view.setSystemUiVisibility(0);
                return;
            }
        }
        view.setSystemUiVisibility(0);
    }

    public static void showToast(Context context, String str) {
        CustomToast2.showToast(context, str);
    }

    public static void showYYNotification(Context context, x0 x0Var, int i2) {
        String a2 = x0Var.a();
        String b2 = x0Var.b();
        if (b2 == null || b2.length() <= 0) {
            return;
        }
        Intent yYNotificationIntent = getYYNotificationIntent(context, x0Var, b2);
        if (yYNotificationIntent != null && yYNotificationIntent.getDataString() != null && yYNotificationIntent.getDataString().contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
            yYNotificationIntent.setFlags(276824064);
            NotificationHelper.showNotification(context, i2, null, a2, a2, PendingIntent.getActivity(context, i2, yYNotificationIntent, 134217728), false);
        } else if (yYNotificationIntent == null) {
        } else {
            NotificationHelper.showNotification(context, i2, null, a2, a2, PendingIntent.getService(context, 0, yYNotificationIntent, 134217728), false);
        }
    }

    public static void smsPhone(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", "");
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            BdLog.detailException(e2);
        } catch (SecurityException e3) {
            BdLog.detailException(e3);
        }
    }

    public static void smsTo(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", str2 + "");
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            BdLog.detailException(e2);
        } catch (SecurityException e3) {
            BdLog.detailException(e3);
        }
    }

    public static boolean startApk(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setComponent(new ComponentName(str, str2));
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                context.startActivity(intent);
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                l.L(context, R.string.game_start_fail);
            }
        }
        return false;
    }

    public static void startBaiDuBar(Context context, String str) {
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
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            if (TbConfig.IS_START_BAIDU_KUANG_CLOSE_SELF) {
                d.a.c.a.b.f().o();
            }
            context.startActivity(intent);
        } catch (Exception unused) {
            startBaiduWebView(context, str);
        }
    }

    public static void startBaiduWebView(Context context, String str) {
        if (str != null && str.length() > 0) {
            d.a.i0.l.a.k(context, "http://m.baidu.com/s?from=1001157a&word=" + str);
            return;
        }
        d.a.i0.l.a.k(context, "http://m.baidu.com/?from=1001157a");
    }

    public static void startHardAccelerated(Window window) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        try {
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("FLAG_HARDWARE_ACCELERATED");
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(null);
            Window.class.getMethod("setFlags", Integer.TYPE, Integer.TYPE).invoke(window, Integer.valueOf(i2), Integer.valueOf(i2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void startPushService(Context context) {
        if (context == null) {
        }
    }

    public static void stopPushService(Context context) {
    }

    public static String transforIPV6(String str) {
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
            int i2 = (8 - length) - length2;
            if (length > 0) {
                stringBuffer.append(transforIPV6(substring));
                stringBuffer.append(".");
            }
            for (int i3 = 0; i3 < i2; i3++) {
                stringBuffer.append("0");
                if (i3 < i2 - 1) {
                    stringBuffer.append(".");
                }
            }
            if (length2 > 0) {
                stringBuffer.append(".");
                stringBuffer.append(transforIPV6(substring2));
            }
        } else {
            String[] split = str.split(":");
            for (int i4 = 0; i4 < split.length; i4++) {
                stringBuffer.append(String.valueOf(d.a.c.e.m.b.e(split[i4], 0, 16)));
                if (i4 < split.length - 1) {
                    stringBuffer.append(".");
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String urlAddParam(String str, String str2) {
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

    public static boolean useNavigationBarStyleImmersiveSticky(Activity activity, boolean z) {
        if (Build.VERSION.SDK_INT < 19 || activity == null || !d.a.i0.r.d0.b.j().g("switch_immersive_sticky_status", true) || !TbadkCoreApplication.getInst().isMeiZuCanUseImmersive()) {
            return false;
        }
        for (AccessibilityServiceInfo accessibilityServiceInfo : ((AccessibilityManager) activity.getSystemService("accessibility")).getEnabledAccessibilityServiceList(1)) {
            if (!StringUtils.isNull(accessibilityServiceInfo.getSettingsActivityName()) && accessibilityServiceInfo.getSettingsActivityName().contains("talkback")) {
                d.a.i0.r.d0.b.j().t("switch_immersive_sticky_status", false);
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
            d.a.i0.r.d0.b.j().t("switch_immersive_sticky_status", false);
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

    public static void useNavigationBarStyleImmersiveSticky_KitKat(Activity activity) {
        if (activity == null) {
            return;
        }
        boolean z = false;
        int i2 = -1;
        try {
            Field field = WindowManager.LayoutParams.class.getField("FLAG_TRANSLUCENT_STATUS");
            if (field != null) {
                i2 = field.getInt(null);
                z = true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (z) {
            activity.getWindow().setFlags(i2, i2);
        }
    }

    public static void useNavigationBarStyleImmersiveSticky_L(Activity activity, boolean z, boolean z2) {
        if (activity == null) {
            return;
        }
        useNavigationBarStyleImmersiveSticky_L(activity.getWindow(), z, z2);
    }

    public static void useNavigationBarStyleImmersiveSticky_M(Activity activity, boolean z) {
        useNavigationBarStyleImmersiveSticky_L(activity, z, true);
    }

    public static int ver2int(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
        int i2 = 0;
        for (int i3 = 0; i3 < split.length; i3++) {
            i2 |= Integer.valueOf(split[i3]).intValue() << ((3 - i3) * 8);
        }
        return i2;
    }

    public static final boolean webViewIsProbablyCorrupt(Context context) {
        try {
            SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase(WebViewUtil.WEBVIEW_CACHE_DATABASE_FILE, 0, null);
            if (openOrCreateDatabase != null) {
                m.b(openOrCreateDatabase);
                return false;
            }
            m.b(openOrCreateDatabase);
            return true;
        } catch (Throwable th) {
            try {
                if (BdLog.isDebugMode()) {
                    BdLog.e(th.getMessage());
                }
                return true;
            } finally {
                m.b(null);
            }
        }
    }

    @Deprecated
    public static String getFixedText(String str, int i2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        double d2 = 0.0d;
        int i3 = 0;
        while (true) {
            if (i3 >= str.length()) {
                break;
            }
            char charAt = str.charAt(i3);
            d2 += ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z') && (charAt < '0' || charAt > '9')) ? 1.0d : 0.5d;
            if (d2 <= i2) {
                sb.append(charAt);
                i3++;
            } else if (z) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    public static String getForumNameWithBar(String str, int i2, boolean z) {
        if (i2 <= -1) {
            if (k.byteLength(str) > 14) {
                str = StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
            }
        } else {
            str = getFixedBarText(str, i2, z);
        }
        return TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{str});
    }

    public static void showHeadImageViewBigV(HeadImageView headImageView, MetaData metaData, int i2) {
        if (headImageView == null || metaData == null) {
            return;
        }
        boolean z = false;
        headImageView.setBjhAuthIconRes(0);
        headImageView.setBazhuIconRes(0);
        headImageView.setGodIconResId(0);
        headImageView.setOfficialIconResId(0);
        if (metaData.isOfficial()) {
            headImageView.setOfficialIconResId(R.drawable.ic_icon_mask_shang22_n);
            headImageView.setShowV(true);
        } else if (metaData.isNewGod()) {
            headImageView.setBjhAuthIconRes(0);
            headImageView.setBazhuIconRes(0);
            headImageView.setGodIconResId(R.drawable.icon_mask_shen_liang20_svg);
            headImageView.setShowV(true);
        } else if (metaData.getBazhuGradeData() != null && !k.isEmpty(metaData.getBazhuGradeData().getLevel()) && metaData.showBazhuGrade()) {
            int bazhuIconId = getBazhuIconId(metaData.getBazhuGradeData().getLevel(), true);
            headImageView.setBjhAuthIconRes(0);
            headImageView.setBazhuIconRes(bazhuIconId);
            headImageView.setShowV(true);
        } else if (metaData.getBaijiahaoInfo() != null && isShowBjhBigV(metaData.getBaijiahaoInfo())) {
            headImageView.setBjhAuthIconRes(getBjhBigVIconId(metaData.getBaijiahaoInfo().auth_id.intValue(), i2));
            headImageView.setShowV(true);
        } else {
            boolean z2 = (metaData.getPendantData() == null || StringUtils.isNull(metaData.getPendantData().a())) ? false : true;
            if (metaData.isBigV() && !z2) {
                z = true;
            }
            headImageView.setShowV(z);
        }
    }

    public static void showToast(Context context, int i2) {
        CustomToast2.showToast(context, i2);
    }

    public static void useNavigationBarStyleImmersiveSticky_L(Window window, boolean z, boolean z2) {
        if (window == null) {
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
                int i2 = field.getInt(null);
                int i3 = field2.getInt(null);
                int i4 = field3.getInt(null);
                int i5 = field4.getInt(null);
                window.clearFlags(i3);
                if (z2) {
                    Field field5 = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR");
                    if (field5 != null) {
                        window.getDecorView().setSystemUiVisibility(field5.getInt(null) | i4 | i5);
                    }
                } else {
                    method2.invoke(window.getDecorView(), Integer.valueOf(i4 | i5));
                }
                window.addFlags(i2);
                method.invoke(window, 0);
                if (z) {
                    Field field6 = WindowManager.LayoutParams.class.getField("FLAG_FULLSCREEN");
                    Method method3 = window.getClass().getMethod("setFlags", Integer.TYPE, Integer.TYPE);
                    int i6 = field6.getInt(null);
                    method3.invoke(window, Integer.valueOf(i6), Integer.valueOf(i6));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean showHeadBjhBigVIcon(HeadPendantView headPendantView, MetaData metaData, int i2) {
        if (headPendantView == null || metaData == null || metaData.getBaijiahaoInfo() == null || !isShowBjhBigV(metaData.getBaijiahaoInfo())) {
            return false;
        }
        headPendantView.i(metaData, i2);
        return true;
    }

    public static void setSpan(SpannableStringBuilder spannableStringBuilder, String str, String str2, CharacterStyle characterStyle) {
        if (spannableStringBuilder == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || characterStyle == null) {
            return;
        }
        int indexOf = str.indexOf(str2);
        int length = str2.length();
        while (indexOf >= 0) {
            int i2 = indexOf + length;
            spannableStringBuilder.setSpan(characterStyle, indexOf, i2, 33);
            indexOf = str.indexOf(str2, i2);
        }
    }

    public static String getFixedBarText(String str, int i2, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        double d2 = 0.0d;
        int i3 = 0;
        while (true) {
            if (i3 >= str.length()) {
                break;
            }
            char charAt = str.charAt(i3);
            d2 += ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z') && (charAt < '0' || charAt > '9')) ? 1.0d : 0.5d;
            if (d2 <= i2) {
                sb.append(charAt);
                i3++;
            } else if (z && z2) {
                sb.deleteCharAt(i3 - 1);
                sb.append(StringHelper.STRING_MORE);
            } else if (z) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    public static boolean useNavigationBarStyleImmersiveSticky(Activity activity) {
        boolean z = false;
        boolean useNavigationBarStyleImmersiveSticky = useNavigationBarStyleImmersiveSticky(activity, false);
        changeStatusBarIconAndTextColor((TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) ? true : true, activity);
        return useNavigationBarStyleImmersiveSticky;
    }

    public static void useNavigationBarStyleImmersiveSticky_L(Activity activity) {
        useNavigationBarStyleImmersiveSticky_L(activity, false, false);
    }
}
