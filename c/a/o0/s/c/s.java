package c.a.o0.s.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ICDNProblemUploader;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoSwitchManager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.BannerData;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.tbadk.switchs.AdToMainTabActivitySwitch;
import com.baidu.tbadk.switchs.AddGetUserInfoReqSwitch;
import com.baidu.tbadk.switchs.AiAppsLazyInitSwitch;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.tbadk.switchs.CrabSdkSwitch;
import com.baidu.tbadk.switchs.CsjPrivacySwitch;
import com.baidu.tbadk.switchs.CustomPlayerSwitch;
import com.baidu.tbadk.switchs.FunAdSdkSwitch;
import com.baidu.tbadk.switchs.FunAdServerRecordSwitch;
import com.baidu.tbadk.switchs.FunAdSplashClickRegionSwitch;
import com.baidu.tbadk.switchs.GdtPrivacySwitch;
import com.baidu.tbadk.switchs.JPushSdkSwitch;
import com.baidu.tbadk.switchs.KsPrivacySwitch;
import com.baidu.tbadk.switchs.LaunchCacheOidSwitch;
import com.baidu.tbadk.switchs.LaunchUpNightSwitch;
import com.baidu.tbadk.switchs.LaunchUpSpeedSwitch;
import com.baidu.tbadk.switchs.LoginPassV6Switch;
import com.baidu.tbadk.switchs.LooperBlockOptSwitch;
import com.baidu.tbadk.switchs.MainTabDataSwitch;
import com.baidu.tbadk.switchs.OpenStartSafeModeSwitch;
import com.baidu.tbadk.switchs.PbLoadingViewOptimizeSwitch;
import com.baidu.tbadk.switchs.PreInitMainTabViewSwitch;
import com.baidu.tbadk.switchs.QqShareH5Switch;
import com.baidu.tbadk.switchs.ResetSplashAdConfigSwitch;
import com.baidu.tbadk.switchs.SplashDealyTimeoutSwitch;
import com.baidu.tbadk.switchs.StatSdkSwitch;
import com.baidu.tbadk.switchs.VideoCardLazyInitSwitch;
import com.baidu.tbadk.switchs.WeChatShareSmallAppToH5Switch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BannerData a;

    /* renamed from: b  reason: collision with root package name */
    public String f11253b;

    /* renamed from: c  reason: collision with root package name */
    public String f11254c;

    /* renamed from: d  reason: collision with root package name */
    public String f11255d;

    /* renamed from: e  reason: collision with root package name */
    public String f11256e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11257f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11258g;

    /* renamed from: h  reason: collision with root package name */
    public int f11259h;
    public long i;
    public int j;
    public HashMap<String, Integer> k;
    public c.a.o0.r.r.s l;
    public boolean m;
    public k0 n;
    public int o;
    public String p;

    public s() {
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
        this.f11257f = true;
        this.f11258g = true;
        this.f11259h = 100000;
        this.j = 100;
        this.k = null;
        this.m = false;
        this.o = 1;
        this.f11253b = null;
        this.f11254c = null;
        this.f11255d = null;
        this.f11256e = null;
        this.a = new BannerData();
        this.k = new HashMap<>();
        this.l = new c.a.o0.r.r.s();
        this.n = new k0();
    }

    public final String a(JSONArray jSONArray) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONArray)) == null) {
            if (jSONArray == null) {
                return null;
            }
            int length = jSONArray.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append(jSONArray.get(i));
                if (i < length - 1) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : invokeV.intValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.i : invokeV.longValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f11259h : invokeV.intValue;
    }

    public k0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : (k0) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:187:0x0573 A[Catch: Exception -> 0x0822, TryCatch #0 {Exception -> 0x0822, blocks: (B:7:0x0021, B:9:0x007e, B:13:0x00ae, B:15:0x00b4, B:17:0x00c1, B:18:0x00c8, B:20:0x00d9, B:21:0x00e2, B:23:0x00f6, B:25:0x00fe, B:26:0x0105, B:27:0x0119, B:29:0x0121, B:30:0x013c, B:33:0x015d, B:35:0x0163, B:37:0x0169, B:39:0x0189, B:43:0x0193, B:185:0x056d, B:187:0x0573, B:189:0x0589, B:47:0x01a2, B:49:0x01aa, B:50:0x01b9, B:52:0x01bf, B:54:0x01c5, B:55:0x01ca, B:56:0x01d6, B:58:0x01dc, B:60:0x01e2, B:61:0x01e7, B:62:0x01f3, B:64:0x01f9, B:65:0x0205, B:67:0x020d, B:68:0x021e, B:70:0x0228, B:71:0x0237, B:73:0x023f, B:74:0x024e, B:76:0x0256, B:77:0x0265, B:79:0x026d, B:80:0x027c, B:82:0x0284, B:83:0x0293, B:85:0x029b, B:86:0x02aa, B:88:0x02b2, B:89:0x02c1, B:91:0x02c7, B:93:0x02cd, B:94:0x02d2, B:95:0x02df, B:97:0x02e5, B:99:0x02eb, B:100:0x02f0, B:101:0x02fd, B:103:0x0305, B:104:0x0314, B:106:0x031c, B:107:0x032b, B:109:0x0333, B:110:0x0342, B:112:0x034a, B:113:0x0359, B:115:0x0361, B:116:0x0370, B:118:0x0378, B:119:0x0387, B:121:0x038f, B:122:0x039e, B:124:0x03a6, B:125:0x03b5, B:127:0x03bd, B:128:0x03cc, B:130:0x03d4, B:131:0x03e3, B:133:0x03eb, B:134:0x03fa, B:136:0x0402, B:137:0x0411, B:139:0x0419, B:140:0x0428, B:142:0x0430, B:143:0x043f, B:145:0x0447, B:146:0x0456, B:148:0x045e, B:149:0x046d, B:151:0x0475, B:152:0x0484, B:154:0x048c, B:155:0x049b, B:157:0x04a3, B:158:0x04b0, B:160:0x04b8, B:161:0x04c9, B:163:0x04d3, B:164:0x04e2, B:166:0x04ea, B:167:0x04f9, B:169:0x0501, B:170:0x050f, B:172:0x0517, B:173:0x0525, B:175:0x052d, B:177:0x0534, B:178:0x053f, B:180:0x0547, B:181:0x0553, B:183:0x055b, B:190:0x0597, B:192:0x059d, B:194:0x05a5, B:195:0x05ae, B:202:0x05c7, B:203:0x05c9, B:207:0x05e9, B:209:0x05f8, B:210:0x0607, B:214:0x0621, B:218:0x063c, B:222:0x064e, B:226:0x065d, B:228:0x066c, B:230:0x0675, B:235:0x0684, B:236:0x068b, B:239:0x0698, B:242:0x06aa, B:244:0x06bd, B:246:0x06c7, B:247:0x06d2, B:249:0x06da, B:250:0x06e5, B:252:0x072e, B:253:0x0758, B:255:0x0764, B:256:0x0767, B:258:0x076f, B:259:0x0783, B:261:0x078b, B:262:0x07a9, B:265:0x07e0, B:266:0x07f5, B:268:0x07fd, B:270:0x080c, B:271:0x0810, B:273:0x0818, B:241:0x06a2), top: B:281:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0589 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(JSONObject jSONObject) {
        int i;
        JSONArray jSONArray;
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            String str5 = "auto_play_video_frs_have_4g";
            String str6 = "android_safe_sdk_open";
            String str7 = "switch";
            if (jSONObject == null) {
                return;
            }
            try {
                this.a.parserJson(jSONObject.optJSONObject(SpeedStatsUtils.UBC_VALUE_BANNER));
                this.f11253b = jSONObject.optString("big_head_image_host");
                this.f11254c = jSONObject.optString("small_head_image_host");
                this.f11255d = jSONObject.optString("yijianfankui_fname");
                this.f11256e = jSONObject.optString("yijianfankui_fid");
                this.j = jSONObject.optInt("crash_limit_count", 100);
                int optInt = jSONObject.optInt("app_recommend", -1);
                String str8 = LaunchCacheOidSwitch.KEY_SWITCH;
                String str9 = AddGetUserInfoReqSwitch.KEY_SWITCH;
                this.i = jSONObject.optLong("vip_new_task", 0L);
                this.n.b(jSONObject.optJSONObject("webview_checkurl"));
                JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
                if (optJSONObject != null) {
                    i = optInt;
                    c.a.o0.u.a.k().u(optJSONObject.optInt("distance", 60));
                    c.a.o0.u.a.k().v(optJSONObject.optInt("items_num", 10));
                    c.a.o0.u.a.k().w(1 == optJSONObject.optInt("ad_show", 1));
                } else {
                    i = optInt;
                }
                TbadkCoreApplication.getInst().setYijianfankuiFname(this.f11255d);
                if (this.l == null) {
                    this.l = new c.a.o0.r.r.s();
                }
                this.l.h(jSONObject.optString("photo_strategy"));
                if (ICDNProblemUploader.getInstance() != null) {
                    ICDNProblemUploader.getInstance().setmCdnLogData(this.l);
                }
                c.a.o0.n.a aVar = new c.a.o0.n.a();
                aVar.a(jSONObject.optJSONObject("photo_cdn_time"));
                if (ICDNIPDirectConnect.getInstance() != null) {
                    if (!ICDNIPDirectConnect.getInstance().isAlreadyInit) {
                        ICDNIPDirectConnect.getInstance().init();
                    }
                    ICDNIPDirectConnect.getInstance().setCDNImageTimeData(aVar);
                    ICDNIPDirectConnect.getInstance().setIpDisableTime(jSONObject.optInt("ip_unavailable_time"));
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("movideo");
                if (optJSONObject2 != null) {
                    c.a.p0.a4.r0.a.c(optJSONObject2.optInt("chunk_size"));
                    c.a.p0.a4.r0.a.b(optJSONObject2.optInt("block_size"));
                    c.a.p0.a4.r0.a.d(optJSONObject2.optInt("data_size"));
                }
                PerformanceLoggerHelper.getInstance().setSmallFlowInterval(jSONObject.optLong("small_flow_time_out"));
                TbadkCoreApplication.getInst().setInterviewLivePollingInterval(jSONObject.optLong("interview_pulling_interval"));
                JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                if (optJSONArray != null) {
                    int i2 = 0;
                    while (i2 < optJSONArray.length()) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        if (jSONObject2 != null) {
                            String optString = jSONObject2.optString("name");
                            jSONArray = optJSONArray;
                            Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", -1));
                            str2 = str7;
                            this.k.put(optString, valueOf);
                            if ("netlib_type".equals(optString)) {
                                TbadkCoreApplication.getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            } else if (LoginPassV6Switch.KEY.equals(optString)) {
                                SwitchManager.getInstance().turn(optString, valueOf.intValue());
                                c.a.o0.s.a.a.a();
                            } else if ("auto_play_video_homepage".equals(optString)) {
                                if (valueOf.intValue() <= 0) {
                                    valueOf = 0;
                                }
                                c.a.o0.r.j0.b.k().w("auto_play_video_homepage", valueOf.intValue());
                            } else if ("auto_play_video_frs".equals(optString)) {
                                if (valueOf.intValue() <= 0) {
                                    valueOf = 0;
                                }
                                c.a.o0.r.j0.b.k().w("auto_play_video_frs", valueOf.intValue());
                            } else if (str6.equals(optString)) {
                                c.a.o0.r.j0.b.k().w(str6, valueOf.intValue());
                            } else {
                                if ("android_new_log_upload_switch".equals(optString)) {
                                    str = str6;
                                    c.a.o0.r.j0.b.k().w("KEY_LOG_REAL_TIME_UPLOAD_SWITCH", valueOf.intValue());
                                } else {
                                    str = str6;
                                    if ("android_abtest_channel_switch".equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("key_abtest_channel", valueOf.intValue());
                                    } else if (CrabSdkSwitch.CRAB_SDK_KEY.equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("pref_key_crab_sdk_enable", valueOf.intValue());
                                    } else if (BigdaySwitch.BIGDAY_KEY.equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("key_bigday_sync_switch", valueOf.intValue());
                                    } else if (StatSdkSwitch.STAT_SDK_KEY.equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("pref_key_stat_sdk_enable", valueOf.intValue());
                                    } else if (JPushSdkSwitch.JPUSH_SDK_KEY.equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("pref_key_jpush_sdk_enable", valueOf.intValue());
                                    } else if ("lcslog_upload_switch".equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("key_lcs_log_switch", valueOf.intValue());
                                    } else if ("android_slide_anim_switch".equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("sync_slide_animation__switch", valueOf.intValue());
                                    } else if ("auto_play_video_homepage_have_4g".equals(optString)) {
                                        if (valueOf.intValue() <= 0) {
                                            valueOf = 0;
                                        }
                                        c.a.o0.r.j0.b.k().w("auto_play_video_homepage_have_4g", valueOf.intValue());
                                    } else if (str5.equals(optString)) {
                                        if (valueOf.intValue() <= 0) {
                                            valueOf = 0;
                                        }
                                        c.a.o0.r.j0.b.k().w(str5, valueOf.intValue());
                                    } else if ("image_header_no_cache_enable".equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("image_no_cache_switch", valueOf.intValue());
                                    } else if ("profile_usercenter_open".equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("key_create_center_entrance_switch", valueOf.intValue());
                                    } else if (FunAdSdkSwitch.KEY_SWITCH.equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("pref_key_fun_ad_sdk_enable", valueOf.intValue());
                                    } else if ("pic_req_switch_key".equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("key_pic_req_switch", valueOf.intValue());
                                    } else if (SplashDealyTimeoutSwitch.KEY_SWITCH.equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("pref_key_splash_timeout_enable", valueOf.intValue());
                                    } else if (FunAdServerRecordSwitch.KEY_SWITCH.equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("pref_key_fun_ad_server_record_enable", valueOf.intValue());
                                    } else if (GdtPrivacySwitch.KEY_SWITCH.equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("pref_key_splash_gdt_privacy_enable", valueOf.intValue());
                                    } else if (CsjPrivacySwitch.KEY_SWITCH.equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("pref_key_splash_csj_privacy_enable", valueOf.intValue());
                                    } else if (KsPrivacySwitch.KEY_SWITCH.equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("pref_key_splash_ks_privacy_enable", valueOf.intValue());
                                    } else if (FunAdSplashClickRegionSwitch.KEY_SWITCH.equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("pref_key_fun_ad_splash_click_enable", valueOf.intValue());
                                    } else if (QqShareH5Switch.QQ_SHARE_H5_ENABLE.equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("key_qq_share_h5_enable", valueOf.intValue());
                                    } else if (WeChatShareSmallAppToH5Switch.SMALL_APP_TO_H5.equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("key_wechat_small_app_to_h5", valueOf.intValue());
                                    } else if ("platform_csj_init".equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("key_fun_cjs_init", valueOf.intValue());
                                    } else if ("platform_gdt_init".equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("key_fun_gdt_init", valueOf.intValue());
                                    } else if ("platform_ks_init".equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("key_fun_ks_init", valueOf.intValue());
                                    } else if (LaunchUpSpeedSwitch.LAUNCH_UP_SPEED_ENABLE.equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("key_launch_up_speed", valueOf.intValue());
                                    } else if (MainTabDataSwitch.LAUNCH_UP_MAIN_TAB_DATA_ENABLE.equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("key_launch_up_main_tab_data", valueOf.intValue());
                                    } else if (LaunchUpNightSwitch.LAUNCH_UP_NIGHT_ENABLE.equals(optString)) {
                                        c.a.o0.r.j0.b.k().w("key_launch_up_night", valueOf.intValue());
                                    } else {
                                        str3 = str9;
                                        if (str3.equals(optString)) {
                                            c.a.o0.r.j0.b.k().w(str3, valueOf.intValue());
                                            str4 = str5;
                                            if (!PreInitMainTabViewSwitch.KEY_SWITCH.equals(optString)) {
                                                c.a.o0.r.j0.b.k().w(PreInitMainTabViewSwitch.KEY_SWITCH, valueOf.intValue());
                                            }
                                        } else {
                                            if (AdToMainTabActivitySwitch.AD_TO_MAINATABACTIVITY_ENABLE.equals(optString)) {
                                                str4 = str5;
                                                c.a.o0.r.j0.b.k().w("key_ad_to_maintabactivity", valueOf.intValue());
                                            } else {
                                                str4 = str5;
                                                if (AiAppsLazyInitSwitch.AI_APPS_LAZY_INIT_ENABLE.equals(optString)) {
                                                    c.a.o0.r.j0.b.k().w("key_ai_apps_lazy_init", valueOf.intValue());
                                                } else if (VideoCardLazyInitSwitch.VIDEO_CARD_LAZY_INIT_ENABLE.equals(optString)) {
                                                    c.a.o0.r.j0.b.k().w("key_video_card_lazy_init", valueOf.intValue());
                                                } else if (LooperBlockOptSwitch.LOOPER_BLOCK_OPT_ENABLE.equals(optString)) {
                                                    c.a.o0.r.j0.b.k().w("key_looper_block_opt", valueOf.intValue());
                                                } else if (OpenStartSafeModeSwitch.KEY.equals(optString)) {
                                                    c.a.o0.r.j0.b.k().w("key_is_start_safe_mode", valueOf.intValue());
                                                } else if (ResetSplashAdConfigSwitch.KEY.equals(optString)) {
                                                    if (valueOf.intValue() == 1) {
                                                        c.a.o0.r.j0.b.k().u("key_is_jump_splash_ad", false);
                                                    }
                                                } else {
                                                    String str10 = str8;
                                                    if (str10.equals(optString)) {
                                                        c.a.o0.r.j0.b.k().w(str10, valueOf.intValue());
                                                    } else if (PbLoadingViewOptimizeSwitch.ANDROID_PB_LOADING_VIEW_OPTIMIZE.equals(optString)) {
                                                        str8 = str10;
                                                        c.a.o0.r.j0.b.k().w("key_android_pb_loading_view_optimize", valueOf.intValue());
                                                    }
                                                    str8 = str10;
                                                }
                                            }
                                            if (!PreInitMainTabViewSwitch.KEY_SWITCH.equals(optString)) {
                                            }
                                        }
                                    }
                                }
                                str3 = str9;
                                str4 = str5;
                                if (!PreInitMainTabViewSwitch.KEY_SWITCH.equals(optString)) {
                                }
                            }
                            str = str6;
                            str3 = str9;
                            str4 = str5;
                            if (!PreInitMainTabViewSwitch.KEY_SWITCH.equals(optString)) {
                            }
                        } else {
                            jSONArray = optJSONArray;
                            str = str6;
                            str2 = str7;
                            str3 = str9;
                            str4 = str5;
                        }
                        i2++;
                        str5 = str4;
                        optJSONArray = jSONArray;
                        str7 = str2;
                        str9 = str3;
                        str6 = str;
                    }
                }
                String str11 = str7;
                if (this.k != null && this.k.size() > 0) {
                    SwitchManager.getInstance().refreshSwitchManager(this.k);
                }
                int optInt2 = jSONObject.optInt("force_update_auto_play_video", -1);
                int l = c.a.o0.r.j0.b.k().l("force_update_auto_play_video", 0);
                if (l != 0 && optInt2 >= 1 && optInt2 <= 10 && optInt2 != l) {
                    TbConfig.FORCE_UPDATE = true;
                }
                c.a.o0.r.j0.b.k().w("force_update_auto_play_video", optInt2);
                CustomPlayerSwitch.setSwitchStatus(SwitchManager.getInstance().findType(CustomPlayerSwitch.CUSTOM_PLAYER_SWITCH));
                this.f11258g = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkCoreApplication.getInst().setIsPushServiceOpen(this.f11258g);
                if (!this.f11258g) {
                    UtilHelper.stopPushService(TbadkCoreApplication.getInst().getApp().getApplicationContext());
                }
                TbadkCoreApplication.getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
                this.f11257f = jSONObject.optInt("gpu_open", 1) == 1;
                TbadkCoreApplication.getInst().setGpuOpen(this.f11257f);
                TbadkCoreApplication.getInst().setHttpClientOpen(jSONObject.optInt("http_client", 1) == 1);
                TbadkCoreApplication.getInst().setHttpAutoSwitch(jSONObject.optInt("http_client_auto", 1) == 1);
                boolean z = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
                this.m = z;
                VoiceManager.setVoiceUseSoftDecoder(z);
                if (TbadkCoreApplication.getInst().getFirstSyncImageQuality()) {
                    int optInt3 = jSONObject.optInt("open_abstract", 0);
                    if (!(optInt3 == 0 || TbadkCoreApplication.getInst().getIsAbstractStatus() != 0)) {
                        TbadkCoreApplication.getInst().setIsAbstractOn(optInt3);
                    }
                    TbadkCoreApplication.getInst().setFirstSyncImageQuality(false);
                }
                int i3 = i;
                if (i3 == 1) {
                    TbadkCoreApplication.getInst().setIsAppOn(true);
                } else if (i3 == 0) {
                    TbadkCoreApplication.getInst().setIsAppOn(false);
                }
                this.f11259h = jSONObject.optInt("perform_sample_param", 100000);
                JSONObject optJSONObject3 = jSONObject.optJSONObject("keepalive");
                if (optJSONObject3 != null) {
                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject("wifi");
                    if (optJSONObject4 != null) {
                        TbadkCoreApplication.getInst().setKeepaliveWifi(optJSONObject4.optInt(str11));
                    }
                    JSONObject optJSONObject5 = optJSONObject3.optJSONObject("nonwifi");
                    if (optJSONObject5 != null) {
                        TbadkCoreApplication.getInst().setKeepaliveNonWifi(optJSONObject5.optInt(str11));
                    }
                }
                TbadkCoreApplication.getInst().setHybridBridgeTimeout(jSONObject.optInt("hybrid_bridge_timeout", -1));
                TbadkCoreApplication.getInst().setSocketReconnStratgy(a(jSONObject.optJSONArray("lcsReconStrategy")));
                TbadkCoreApplication.getInst().setSocketHeartBeatStratgy(a(jSONObject.optJSONArray("lcsHeartbeatStrategy")));
                TbadkCoreApplication.getInst().setSocketGetMsgStratgy(a(jSONObject.optJSONArray("imGetMsgStrategy")));
                JSONObject optJSONObject6 = jSONObject.optJSONObject("imNetworkTimeOut");
                if (optJSONObject6 != null) {
                    TbadkCoreApplication.getInst().setImTimeOut(new int[]{optJSONObject6.optInt("2gTo", 0) * 1000, optJSONObject6.optInt("3gTo", 0) * 1000, optJSONObject6.optInt("wifiTo", 0) * 1000});
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("imNotifyRecordStrategy");
                c.a.o0.t.f a = c.a.o0.t.f.a();
                if (optJSONObject7 != null) {
                    a.b(optJSONObject7);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("local_dialog");
                if (optJSONObject8 != null) {
                    this.o = optJSONObject8.optInt("local_dialog_android", 1);
                    c.a.o0.r.j0.b.k().w("sync_local_dialog", this.o);
                }
                JSONObject optJSONObject9 = jSONObject.optJSONObject("benchmark");
                if (optJSONObject9 != null) {
                    int optInt4 = optJSONObject9.optInt("android_flops_dur", Integer.MAX_VALUE);
                    int optInt5 = optJSONObject9.optInt("android_anim_avg_fps", 0);
                    TbSingleton.getInstance().setCpuThreshold(optInt4);
                    TbSingleton.getInstance().setAnimAverageFpsThreshold(optInt5);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008017));
                TbConfig.setBigPhotoAdress(this.f11253b);
                TbConfig.setSmallPhotoAdress(this.f11254c);
                TbConfig.setFeedBack(this.f11255d, this.f11256e);
                PreLoadVideoSwitchManager.getInstance().setSyncSwitchJson(jSONObject.optString("android_preload_conf"));
                JSONObject optJSONObject10 = jSONObject.optJSONObject("duxiaoman_url");
                if (optJSONObject10 != null) {
                    this.p = optJSONObject10.optString("cash_pay");
                    c.a.o0.r.j0.b.k().y("baidu_finance", optJSONObject10.optString("finance"));
                }
                if (TextUtils.isEmpty(this.p) && TextUtils.isEmpty(c.a.o0.r.j0.b.k().q("cash_pay", null))) {
                    this.p = "https://icash.baidu.com/cloan/index?na=postbarapp&CH=postbarapp&fr=solely_bdbar_and&hideShare=1";
                }
                if (StringUtils.isNull(this.p)) {
                    return;
                }
                c.a.o0.r.j0.b.k().y("cash_pay", this.p);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
