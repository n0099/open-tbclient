package com.baidu.nadcore.stats.request;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.ApsConstants;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.core.data.WorkPostNotifyFlutterData;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.f31;
import com.baidu.tieba.g31;
import com.baidu.tieba.i31;
import com.baidu.tieba.k31;
import com.baidu.tieba.m31;
import com.baidu.tieba.oi0;
import com.baidu.tieba.q11;
import com.baidu.tieba.r11;
import com.baidu.tieba.w01;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ClogBuilder extends q11 {
    public final JSONObject c = w01.c(null);

    public ClogBuilder() {
        d("origin_time", String.valueOf(System.currentTimeMillis()));
    }

    @Override // com.baidu.tieba.o11, com.baidu.tieba.r11
    public void a() {
        oi0 oi0Var = (oi0) ServiceManager.getService(oi0.a);
        if (oi0Var != null) {
            A(oi0Var.a(this.c.optString("extra_param")));
        }
        g();
    }

    @NonNull
    public JSONObject h() {
        return this.c;
    }

    @Override // com.baidu.tieba.q11, com.baidu.tieba.r11
    public boolean isValid() {
        if (!TextUtils.isEmpty(this.c.optString("da_type"))) {
            return super.isValid();
        }
        return false;
    }

    /* loaded from: classes2.dex */
    public enum Area {
        ICON("icon"),
        NAME("name"),
        BUTTON(NativeConstants.ID_BUTTON),
        OPEN_BUTTON("openbtn"),
        DOWNLOAD_BUTTON("downloadbtn"),
        INSTALL_NOW_BUTTON("install_now_button"),
        INSTALL_LATER_BUTTON("install_later_button"),
        HOTAREA("hotarea"),
        AD_NOTIFICATION_ITEM_CLICK("ad_notification_item_click"),
        AD_NOTIFICATION_BTN_CLICK("ad_notification_btn_click"),
        AD_NOTIFICATION_SHOW("ad_notification_show"),
        AD_NOTIFICATION_NOTIFY("ad_notification_notify"),
        AD_NOTIFICATION_REMOVE("ad_notification_remove"),
        DIALOG(MapController.POPUP_LAYER_TAG),
        DIALOG_POSITIVE("popup_select"),
        DIALOG_NEGATIVE("popup_cancel"),
        DIALOG_KEYBACK("popup_back"),
        AD_CALL("CALL"),
        APP_PRIVACY("app_privacy"),
        APP_PERMISSION("app_permission"),
        FLOATING("floating_btn"),
        IMAGE("image"),
        CLOSE_BTN("close_btn"),
        AUTO_HIDE("auto_hide"),
        AD_DIALOG_SHOW("ad_dialog_show"),
        BTN_POSITIVE("btn_positive"),
        BTN_NAGITIVE("btn_nagitive"),
        APP_NOTIFICATION("APP_NOTIFICATION"),
        SLIDING_TAG("sliding_tag"),
        REWARD_SLIDING_TAG("tag"),
        SWIPE_UP("swipeup"),
        AD_BLANK("blank"),
        DOWN_ARROW("down_arrow"),
        REWARD_LANDING_PAGE("landingpage"),
        ARROW("arrow"),
        APP(GrsBaseInfo.CountryCodeSource.APP),
        URL("URL"),
        AD_BTN_DETAIL("detailbtn"),
        AD_LEAVE("leave"),
        AVATAR("avatar"),
        TITTLE("title"),
        INVALID("INVALID");
        
        public final String type;

        Area(String str) {
            this.type = str;
        }
    }

    /* loaded from: classes2.dex */
    public enum LogType {
        CLICK("2"),
        SHOW("3"),
        DISCARD("5"),
        FAIL("6"),
        CLOSE("7"),
        FREE_SHOW("103"),
        FREE_CLICK(WorkPostNotifyFlutterData.FAIL_POST),
        VIDEO_LP_BT("12"),
        VIDEO_LP_PV("103"),
        VIDEO_LP_VIDEO_HIDE("131"),
        CHAN_MORE("22"),
        DEEP_LINK("706"),
        VISIBLE_SHOW("203"),
        VIDEO_LP_TAIL_CLICK(WorkPostNotifyFlutterData.FAIL_POST),
        DOWNLOAD_START("701"),
        DOWNLOAD_PAUSE("702"),
        DOWNLOAD_CONTINUE("703"),
        DOWNLOAD_COMPLETE("704"),
        DOWNLOAD_INSTALL("705"),
        DOWNLOAD_KEEP("707"),
        DOWNLOAD_RETRY("708"),
        DOWNLOAD_FAILED("709"),
        INSTALL_COMPLETE("710"),
        MINI_PROGRAM("717"),
        OPEN_APP("713"),
        AD_CALL("777"),
        VISIBLE_TWO_SEC("213"),
        TAIL_FRAME_SHOW_TIME(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK),
        DURATION("331"),
        TRUE_VIEW("332"),
        DAZZLE_IN(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_LINK_ITEM_CLICK),
        DAZZLE_OUT(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK),
        DAZZLE_TRANS_SLIDING_COUNT(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_CLOSE_BTN_CLICK),
        DAZZLE_CLICK(WorkPostNotifyFlutterData.FAIL_POST),
        DAZZLE_CARD_SHOW("103"),
        PLAY_ZERO_SEC(PayUVEventType.THIRD_PAY_WAY_DIALOG_CHANNEL_CLICK),
        VIDEO_START(PayUVEventType.PAY_SPLIT_ORDER_PAGE_SHOW),
        VIDEO_PAUSE(PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK),
        VIDEO_RESUME(PayUVEventType.PAY_SPLIT_ORDER_BACK_BTN_CLICK),
        VIDEO_COMPLETED(PayUVEventType.PAY_SPLIT_ORDER_MOTIFY_BTN_CLICK),
        EXCEPTION(TbEnum.SystemMessage.EVENT_ID_UPLOAD_STAT),
        CHECK(TbEnum.SystemMessage.EVENT_ID_PLUGIN_CONFIG_SYNC),
        TOP_VIEW_SPEED_STATE("801"),
        NAVIDEO_POP_CLOSE("8"),
        INTERACTION_PRAISE("107"),
        INTERACTION_SHARE("108"),
        INTERACTION_COMMENT("109"),
        SKIP("11"),
        STOCK("13"),
        GESTURE_MATCH_SUCCESS("9"),
        GESTURE_MATCH_FAILURE("104"),
        INTERACTION_FOLLOW(TbEnum.SystemMessage.EVENT_ID_COMMON),
        AD_NOTIFICATION_NOTIFY_FAILED("111"),
        LOTTIE_LONG_PRESS("112"),
        LOTTIE_SHOW("113"),
        LOTTIE_DISMISS("114"),
        LOTTIE_CLICK("115"),
        LOTTIE_RES_PREFETCH_FAIL(ApsConstants.TYPE_ANDROID_PLUGIN),
        LOTTIE_LOAD_FAIL("117"),
        HOME_PAGE_FIRST_SCREEN_AD_SHOW("118"),
        HW_API_REQUEST("119"),
        DEEPLINK_STAY_TRANS("751"),
        DEEPLINK_STAY_TIME("752"),
        INTERACTION_COLLECT("805"),
        PHONE_STATE_LISTEN("807"),
        REWARD_TOKEN_FAIL("781"),
        REWARD_COIN_FAIL("782"),
        REWARD_HALF_TAIL_SLIDE("783"),
        REWARD_ACTIVATE_TASK("784"),
        REWARD_COMPLETE_TASK("785"),
        REWARD_SHOW_TASK("786"),
        NON_AD_CLICK("8"),
        PLACEHOLDER("-1");
        
        public final String type;

        LogType(String str) {
            this.type = str;
        }
    }

    /* loaded from: classes2.dex */
    public enum Page {
        AD_CALL("AD_CALL"),
        AD_NOTIFICATION("AD_NOTIFICATION"),
        RETARGET("RETARGET"),
        AD_START_INSTALL_TIPS("AD_START_INSTALL_TIPS"),
        AD_INSTALL_TIPS("AD_INSTALL_TIPS"),
        POPUP(MapController.POPUP_LAYER_TAG),
        PAGE_NA("page_na"),
        PAGE_SEARCHBOX("HOMEPAGE"),
        AD_TAIL("TAIL"),
        PAGE_VIDEO_LANDING("NAVIDEO"),
        PAGE_VIDEO_TAIL("NAVIDEO_TAIL"),
        REWARD_VIDEO("REWARD_VIDEO"),
        NA_SPLASH("NA_SPLASH"),
        DOWNLOAD_RECTIFY("DOWNLOAD_RECTIFY"),
        VIDEO_LIST("VIDEOLIST"),
        WELFAREPANEL("WELFAREPANEL"),
        WELFAREMAXLP("WELFAREMAXLP"),
        WELFARETAIL("WELFARETAIL"),
        WELFAREBIGCARD("WELFAREBIGCARD"),
        PAGE_VIDEO_IMMERSIVE_LP("IMMERSIVE_VIDEOADDETAIL"),
        NAVIDEO_POP("NAVIDEO_POP"),
        AD_DIALOG("AD_DIALOG"),
        MINI_PROGRAM("WXMnProgram"),
        NAVIDEO_POP_WEB_PANEL("NAVIDEO_POP_WEB_PANEL"),
        INVALID("INVALID");
        
        public final String type;

        Page(String str) {
            this.type = str;
        }
    }

    public ClogBuilder A(String str) {
        d("video_pos", str);
        return this;
    }

    public ClogBuilder i(Area area) {
        d("da_area", area.type);
        return this;
    }

    public ClogBuilder j(String str) {
        d("da_area", str);
        return this;
    }

    public ClogBuilder k(String str) {
        d("da_ext1", str);
        return this;
    }

    public ClogBuilder l(String str) {
        d("da_ext2", str);
        return this;
    }

    public ClogBuilder m(String str) {
        d("da_ext3", str);
        return this;
    }

    public ClogBuilder n(String str) {
        d("da_ext4", str);
        return this;
    }

    public ClogBuilder o(String str) {
        d("da_ext5", str);
        return this;
    }

    public ClogBuilder p(String str) {
        d("extra_param", str);
        return this;
    }

    public ClogBuilder q(String str) {
        d("da_locate", str);
        return this;
    }

    public ClogBuilder r(String str) {
        d("da_menu1", str);
        return this;
    }

    public ClogBuilder s(@NonNull String str) {
        d("da_menu2", str);
        return this;
    }

    public ClogBuilder t(@NonNull String str) {
        d("da_menu3", str);
        return this;
    }

    public ClogBuilder u(Page page) {
        d(BdVideoAd.AD_VIDEO_DAPAGE, page.type);
        return this;
    }

    public ClogBuilder v(String str) {
        d(BdVideoAd.AD_VIDEO_DAPAGE, str);
        return this;
    }

    public ClogBuilder w(String str) {
        d("da_page_num", str);
        return this;
    }

    public ClogBuilder x(String str) {
        d("place_id", str);
        return this;
    }

    public ClogBuilder y(LogType logType) {
        d("da_type", logType.type);
        return this;
    }

    public ClogBuilder z(String str) {
        d("da_type", str);
        return this;
    }

    @Override // com.baidu.tieba.o11, com.baidu.tieba.r11
    public <T extends r11> T b(String str, String str2) {
        d(str, str2);
        return this;
    }

    @Override // com.baidu.tieba.o11
    public <T extends r11> T d(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        w01.f(this.c, str, obj);
        return this;
    }

    public final void g() {
        if (!g31.a) {
            return;
        }
        m31 m31Var = (m31) f31.a().a(m31.class);
        if (m31Var != null) {
            m31Var.a(h());
        }
        i31 i31Var = (i31) f31.a().a(i31.class);
        if (i31Var != null) {
            i31Var.a(h());
        }
        k31 k31Var = (k31) f31.a().a(k31.class);
        if (k31Var != null) {
            k31Var.a(h());
        }
    }

    @Override // com.baidu.tieba.q11, com.baidu.tieba.o11, com.baidu.tieba.r11
    @NonNull
    public String toString() {
        super.toString();
        if (this.a.toString().contains("ad")) {
            return this.a.toString();
        }
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.c);
            String encode = URLEncoder.encode(jSONArray.toString(), IMAudioTransRequest.CHARSET);
            if (this.a.length() > 0) {
                this.a.append('&');
            }
            StringBuilder sb = this.a;
            sb.append("ad");
            sb.append('=');
            sb.append(encode);
            return sb.toString();
        } catch (Exception unused) {
            return this.a.toString();
        }
    }
}
