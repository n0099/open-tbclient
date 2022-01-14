package c.a.s0.t.c;

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
import com.baidu.tbadk.switchs.AdToMainTabActivitySwitch;
import com.baidu.tbadk.switchs.AddGetUserInfoReqSwitch;
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
import com.baidu.tbadk.switchs.LaunchUpPrefetchSwitch;
import com.baidu.tbadk.switchs.LaunchUpSpeedSwitch;
import com.baidu.tbadk.switchs.LoginPassV6Switch;
import com.baidu.tbadk.switchs.OpenStartSafeModeSwitch;
import com.baidu.tbadk.switchs.PicReqSwitch;
import com.baidu.tbadk.switchs.QqShareH5Switch;
import com.baidu.tbadk.switchs.ResetSplashAdConfigSwitch;
import com.baidu.tbadk.switchs.SplashDealyTimeoutSwitch;
import com.baidu.tbadk.switchs.StatSdkSwitch;
import com.baidu.tbadk.switchs.WeChatShareSmallAppToH5Switch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BannerData a;

    /* renamed from: b  reason: collision with root package name */
    public String f13902b;

    /* renamed from: c  reason: collision with root package name */
    public String f13903c;

    /* renamed from: d  reason: collision with root package name */
    public String f13904d;

    /* renamed from: e  reason: collision with root package name */
    public String f13905e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13906f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13907g;

    /* renamed from: h  reason: collision with root package name */
    public int f13908h;

    /* renamed from: i  reason: collision with root package name */
    public long f13909i;

    /* renamed from: j  reason: collision with root package name */
    public int f13910j;
    public HashMap<String, Integer> k;
    public c.a.s0.s.q.s l;
    public boolean m;
    public m0 n;
    public int o;
    public String p;

    public u() {
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
        this.f13906f = true;
        this.f13907g = true;
        this.f13908h = 100000;
        this.f13910j = 100;
        this.k = null;
        this.m = false;
        this.o = 1;
        this.f13902b = null;
        this.f13903c = null;
        this.f13904d = null;
        this.f13905e = null;
        this.a = new BannerData();
        this.k = new HashMap<>();
        this.l = new c.a.s0.s.q.s();
        this.n = new m0();
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
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(jSONArray.get(i2));
                if (i2 < length - 1) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13910j : invokeV.intValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13909i : invokeV.longValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13908h : invokeV.intValue;
    }

    public m0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : (m0) invokeV.objValue;
    }

    public void f(JSONObject jSONObject) {
        String str;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            String str2 = "switch";
            if (jSONObject == null) {
                return;
            }
            try {
                this.a.parserJson(jSONObject.optJSONObject(SpeedStatsUtils.UBC_VALUE_BANNER));
                this.f13902b = jSONObject.optString("big_head_image_host");
                this.f13903c = jSONObject.optString("small_head_image_host");
                this.f13904d = jSONObject.optString("yijianfankui_fname");
                this.f13905e = jSONObject.optString("yijianfankui_fid");
                this.f13910j = jSONObject.optInt("crash_limit_count", 100);
                int optInt = jSONObject.optInt("app_recommend", -1);
                this.f13909i = jSONObject.optLong("vip_new_task", 0L);
                this.n.b(jSONObject.optJSONObject("webview_checkurl"));
                JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
                if (optJSONObject != null) {
                    c.a.s0.v.a.k().u(optJSONObject.optInt("distance", 60));
                    c.a.s0.v.a.k().v(optJSONObject.optInt("items_num", 10));
                    c.a.s0.v.a.k().w(1 == optJSONObject.optInt("ad_show", 1));
                }
                TbadkCoreApplication.getInst().setYijianfankuiFname(this.f13904d);
                if (this.l == null) {
                    this.l = new c.a.s0.s.q.s();
                }
                this.l.h(jSONObject.optString("photo_strategy"));
                if (ICDNProblemUploader.getInstance() != null) {
                    ICDNProblemUploader.getInstance().setmCdnLogData(this.l);
                }
                c.a.s0.o.a aVar = new c.a.s0.o.a();
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
                    c.a.t0.w3.q0.a.c(optJSONObject2.optInt("chunk_size"));
                    c.a.t0.w3.q0.a.b(optJSONObject2.optInt("block_size"));
                    c.a.t0.w3.q0.a.d(optJSONObject2.optInt("data_size"));
                }
                c.a.s0.s0.k.d().i(jSONObject.optLong("small_flow_time_out"));
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
                            str = str2;
                            this.k.put(optString, valueOf);
                            if ("netlib_type".equals(optString)) {
                                TbadkCoreApplication.getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            } else if (LoginPassV6Switch.KEY.equals(optString)) {
                                SwitchManager.getInstance().turn(optString, valueOf.intValue());
                                c.a.s0.t.a.a.a();
                            } else if ("auto_play_video_homepage".equals(optString)) {
                                if (valueOf.intValue() <= 0) {
                                    valueOf = 0;
                                }
                                c.a.s0.s.h0.b.k().w("auto_play_video_homepage", valueOf.intValue());
                            } else if ("auto_play_video_frs".equals(optString)) {
                                if (valueOf.intValue() <= 0) {
                                    valueOf = 0;
                                }
                                c.a.s0.s.h0.b.k().w("auto_play_video_frs", valueOf.intValue());
                            } else if ("android_safe_sdk_open".equals(optString)) {
                                c.a.s0.s.h0.b.k().w("android_safe_sdk_open", valueOf.intValue());
                            } else if ("android_new_log_upload_switch".equals(optString)) {
                                c.a.s0.s.h0.b.k().w("KEY_LOG_REAL_TIME_UPLOAD_SWITCH", valueOf.intValue());
                            } else if ("android_splash_video_switch".equals(optString)) {
                                c.a.s0.s.h0.b.k().w("key_video_splash_switch", valueOf.intValue());
                            } else if ("android_abtest_channel_switch".equals(optString)) {
                                c.a.s0.s.h0.b.k().w("key_abtest_channel", valueOf.intValue());
                            } else if (CrabSdkSwitch.CRAB_SDK_KEY.equals(optString)) {
                                c.a.s0.s.h0.b.k().w("pref_key_crab_sdk_enable", valueOf.intValue());
                            } else if (BigdaySwitch.BIGDAY_KEY.equals(optString)) {
                                c.a.s0.s.h0.b.k().w("key_bigday_sync_switch", valueOf.intValue());
                            } else if (StatSdkSwitch.STAT_SDK_KEY.equals(optString)) {
                                c.a.s0.s.h0.b.k().w("pref_key_stat_sdk_enable", valueOf.intValue());
                            } else if (JPushSdkSwitch.JPUSH_SDK_KEY.equals(optString)) {
                                c.a.s0.s.h0.b.k().w("pref_key_jpush_sdk_enable", valueOf.intValue());
                            } else if ("lcslog_upload_switch".equals(optString)) {
                                c.a.s0.s.h0.b.k().w("key_lcs_log_switch", valueOf.intValue());
                            } else if ("android_slide_anim_switch".equals(optString)) {
                                c.a.s0.s.h0.b.k().w("sync_slide_animation__switch", valueOf.intValue());
                            } else if ("auto_play_video_homepage_have_4g".equals(optString)) {
                                if (valueOf.intValue() <= 0) {
                                    valueOf = 0;
                                }
                                c.a.s0.s.h0.b.k().w("auto_play_video_homepage_have_4g", valueOf.intValue());
                            } else if ("auto_play_video_frs_have_4g".equals(optString)) {
                                if (valueOf.intValue() <= 0) {
                                    valueOf = 0;
                                }
                                c.a.s0.s.h0.b.k().w("auto_play_video_frs_have_4g", valueOf.intValue());
                            } else if ("image_header_no_cache_enable".equals(optString)) {
                                c.a.s0.s.h0.b.k().w("image_no_cache_switch", valueOf.intValue());
                            } else if ("profile_usercenter_open".equals(optString)) {
                                c.a.s0.s.h0.b.k().w("key_create_center_entrance_switch", valueOf.intValue());
                            } else if (FunAdSdkSwitch.KEY_SWITCH.equals(optString)) {
                                c.a.s0.s.h0.b.k().w("pref_key_fun_ad_sdk_enable", valueOf.intValue());
                            } else if (PicReqSwitch.PIC_REQ_SWITCH_KEY.equals(optString)) {
                                c.a.s0.s.h0.b.k().w("key_pic_req_switch", valueOf.intValue());
                            } else if (SplashDealyTimeoutSwitch.KEY_SWITCH.equals(optString)) {
                                c.a.s0.s.h0.b.k().w("pref_key_splash_timeout_enable", valueOf.intValue());
                            } else if (FunAdServerRecordSwitch.KEY_SWITCH.equals(optString)) {
                                c.a.s0.s.h0.b.k().w("pref_key_fun_ad_server_record_enable", valueOf.intValue());
                            } else if (GdtPrivacySwitch.KEY_SWITCH.equals(optString)) {
                                c.a.s0.s.h0.b.k().w("pref_key_splash_gdt_privacy_enable", valueOf.intValue());
                            } else if (CsjPrivacySwitch.KEY_SWITCH.equals(optString)) {
                                c.a.s0.s.h0.b.k().w("pref_key_splash_csj_privacy_enable", valueOf.intValue());
                            } else if (KsPrivacySwitch.KEY_SWITCH.equals(optString)) {
                                c.a.s0.s.h0.b.k().w("pref_key_splash_ks_privacy_enable", valueOf.intValue());
                            } else if (FunAdSplashClickRegionSwitch.KEY_SWITCH.equals(optString)) {
                                c.a.s0.s.h0.b.k().w("pref_key_fun_ad_splash_click_enable", valueOf.intValue());
                            } else if (QqShareH5Switch.QQ_SHARE_H5_ENABLE.equals(optString)) {
                                c.a.s0.s.h0.b.k().w("key_qq_share_h5_enable", valueOf.intValue());
                            } else if (WeChatShareSmallAppToH5Switch.SMALL_APP_TO_H5.equals(optString)) {
                                c.a.s0.s.h0.b.k().w("key_wechat_small_app_to_h5", valueOf.intValue());
                            } else if ("platform_csj_init".equals(optString)) {
                                c.a.s0.s.h0.b.k().w("key_fun_cjs_init", valueOf.intValue());
                            } else if ("platform_gdt_init".equals(optString)) {
                                c.a.s0.s.h0.b.k().w("key_fun_gdt_init", valueOf.intValue());
                            } else if ("platform_ks_init".equals(optString)) {
                                c.a.s0.s.h0.b.k().w("key_fun_ks_init", valueOf.intValue());
                            } else if (LaunchUpSpeedSwitch.LAUNCH_UP_SPEED_ENABLE.equals(optString)) {
                                c.a.s0.s.h0.b.k().w("key_launch_up_speed", valueOf.intValue());
                            } else if (LaunchUpPrefetchSwitch.LAUNCH_UP_PREFETCH_ENABLE.equals(optString)) {
                                c.a.s0.s.h0.b.k().w("key_launch_up_prefetch_v2", valueOf.intValue());
                            } else if (AddGetUserInfoReqSwitch.KEY_SWITCH.equals(optString)) {
                                c.a.s0.s.h0.b.k().w(AddGetUserInfoReqSwitch.KEY_SWITCH, valueOf.intValue());
                            } else if (AdToMainTabActivitySwitch.AD_TO_MAINATABACTIVITY_ENABLE.equals(optString)) {
                                c.a.s0.s.h0.b.k().w("key_ad_to_maintabactivity", valueOf.intValue());
                            } else if (OpenStartSafeModeSwitch.KEY.equals(optString)) {
                                c.a.s0.s.h0.b.k().w("key_is_start_safe_mode", valueOf.intValue());
                            } else if (ResetSplashAdConfigSwitch.KEY.equals(optString) && valueOf.intValue() == 1) {
                                c.a.s0.s.h0.b.k().u("key_is_jump_splash_ad", false);
                            }
                        } else {
                            str = str2;
                            jSONArray = optJSONArray;
                        }
                        i2++;
                        optJSONArray = jSONArray;
                        str2 = str;
                    }
                }
                String str3 = str2;
                if (this.k != null && this.k.size() > 0) {
                    SwitchManager.getInstance().refreshSwitchManager(this.k);
                }
                int optInt2 = jSONObject.optInt("force_update_auto_play_video", -1);
                int l = c.a.s0.s.h0.b.k().l("force_update_auto_play_video", 0);
                if (l != 0 && optInt2 >= 1 && optInt2 <= 10 && optInt2 != l) {
                    TbConfig.FORCE_UPDATE = true;
                }
                c.a.s0.s.h0.b.k().w("force_update_auto_play_video", optInt2);
                CustomPlayerSwitch.setSwitchStatus(SwitchManager.getInstance().findType(CustomPlayerSwitch.CUSTOM_PLAYER_SWITCH));
                this.f13907g = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkCoreApplication.getInst().setIsPushServiceOpen(this.f13907g);
                if (!this.f13907g) {
                    UtilHelper.stopPushService(TbadkCoreApplication.getInst().getApp().getApplicationContext());
                }
                TbadkCoreApplication.getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
                this.f13906f = jSONObject.optInt("gpu_open", 1) == 1;
                TbadkCoreApplication.getInst().setGpuOpen(this.f13906f);
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
                if (optInt == 1) {
                    TbadkCoreApplication.getInst().setIsAppOn(true);
                } else if (optInt == 0) {
                    TbadkCoreApplication.getInst().setIsAppOn(false);
                }
                this.f13908h = jSONObject.optInt("perform_sample_param", 100000);
                JSONObject optJSONObject3 = jSONObject.optJSONObject("keepalive");
                if (optJSONObject3 != null) {
                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject("wifi");
                    if (optJSONObject4 != null) {
                        TbadkCoreApplication.getInst().setKeepaliveWifi(optJSONObject4.optInt(str3));
                    }
                    JSONObject optJSONObject5 = optJSONObject3.optJSONObject("nonwifi");
                    if (optJSONObject5 != null) {
                        TbadkCoreApplication.getInst().setKeepaliveNonWifi(optJSONObject5.optInt(str3));
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
                c.a.s0.u.f a = c.a.s0.u.f.a();
                if (optJSONObject7 != null) {
                    a.b(optJSONObject7);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("local_dialog");
                if (optJSONObject8 != null) {
                    this.o = optJSONObject8.optInt("local_dialog_android", 1);
                    c.a.s0.s.h0.b.k().w("sync_local_dialog", this.o);
                }
                JSONObject optJSONObject9 = jSONObject.optJSONObject("benchmark");
                if (optJSONObject9 != null) {
                    int optInt4 = optJSONObject9.optInt("android_flops_dur", Integer.MAX_VALUE);
                    int optInt5 = optJSONObject9.optInt("android_anim_avg_fps", 0);
                    TbSingleton.getInstance().setCpuThreshold(optInt4);
                    TbSingleton.getInstance().setAnimAverageFpsThreshold(optInt5);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008017));
                TbConfig.setBigPhotoAdress(this.f13902b);
                TbConfig.setSmallPhotoAdress(this.f13903c);
                TbConfig.setFeedBack(this.f13904d, this.f13905e);
                PreLoadVideoSwitchManager.getInstance().setSyncSwitchJson(jSONObject.optString("android_preload_conf"));
                JSONObject optJSONObject10 = jSONObject.optJSONObject("duxiaoman_url");
                if (optJSONObject10 != null) {
                    this.p = optJSONObject10.optString("cash_pay");
                    c.a.s0.s.h0.b.k().y("baidu_finance", optJSONObject10.optString("finance"));
                }
                if (TextUtils.isEmpty(this.p) && TextUtils.isEmpty(c.a.s0.s.h0.b.k().q("cash_pay", null))) {
                    this.p = "https://icash.baidu.com/cloan/index?na=postbarapp&CH=postbarapp&fr=solely_bdbar_and&hideShare=1";
                }
                if (StringUtils.isNull(this.p)) {
                    return;
                }
                c.a.s0.s.h0.b.k().y("cash_pay", this.p);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
