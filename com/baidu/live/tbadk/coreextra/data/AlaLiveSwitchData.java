package com.baidu.live.tbadk.coreextra.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaLiveSwitchData extends BaseData {
    public static final String SWITCH_DEFAULT_VALUE = "0";
    public static int isHotLive;
    public static String liveActivityType;
    public boolean isHot;
    public String mActivityPolling;
    public String mActivityTaskWatch;
    public String mAudience;
    public String mCashGift;
    public String mDayList;
    public String mEventPolling;
    public String mFirstCharge;
    public String mFollowBtn;
    public String mGiftPanel;
    public String mGiftPanelInvalid;
    public String mGmsgGetLiveStatus;
    public String mGuardFans;
    public String mGuardThrone;
    public String mLiveSwitch;
    public String mNobleInfo;
    public String mPayBarrage;
    public String mPopupWindow;
    public String mQuickChat;
    public String mQuickGift;
    public String mRankHour;
    public String mRedPkg;
    public String mRotaryTable;
    public String mShareBtn;
    public String mSmallWindowPendant;
    public String mSuperConsumer;
    public String mVideoGoodslist;
    public String mZanAnim;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mEventPolling = jSONObject.optString("l_eventpolling");
            this.mCashGift = jSONObject.optString("f_cashgift");
            this.mFollowBtn = jSONObject.optString("s_followBtn");
            this.mRankHour = jSONObject.optString("s_rankHour");
            this.mQuickGift = jSONObject.optString("s_quickGift");
            this.mDayList = jSONObject.optString("s_dayGuard");
            this.mActivityPolling = jSONObject.optString("l_activity");
            this.mLiveSwitch = jSONObject.optString("f_liveSwitch");
            this.mGuardFans = jSONObject.optString("s_guardianFans");
            this.mGiftPanel = jSONObject.optString("s_giftPanel");
            this.mPopupWindow = jSONObject.optString("f_modal");
            this.mAudience = jSONObject.optString("c_audience");
            this.mFirstCharge = jSONObject.optString("s_firstCharge");
            this.mSuperConsumer = jSONObject.optString("f_large_charge");
            this.mRotaryTable = jSONObject.optString("s_rotary_table");
            this.mShareBtn = jSONObject.optString("s_shareBtn");
            this.mRedPkg = jSONObject.optString("f_live_effect_redpacket");
            this.mGuardThrone = jSONObject.optString("s_guard_seat");
            this.mVideoGoodslist = jSONObject.optString("f_video_goodslist");
            this.mActivityTaskWatch = jSONObject.optString("f_activity_task_watch");
            this.mGmsgGetLiveStatus = jSONObject.optString("f_gmsg_getLiveStatus");
            this.mNobleInfo = jSONObject.optString("s_noble_info");
            this.mPayBarrage = jSONObject.optString("s_paid_barrage");
            this.mQuickChat = jSONObject.optString("s_quick_chat");
            this.mGiftPanelInvalid = jSONObject.optString("s_gift_panel");
            this.mSmallWindowPendant = jSONObject.optString("s_small_window_pendant");
            this.mZanAnim = jSONObject.optString("s_hide_zan");
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("l_eventpolling", this.mEventPolling);
            jSONObject.put("f_cashgift", this.mCashGift);
            jSONObject.put("s_followBtn", this.mFollowBtn);
            jSONObject.put("s_rankHour", this.mRankHour);
            jSONObject.put("s_quickGift", this.mQuickGift);
            jSONObject.put("s_dayGuard", this.mDayList);
            jSONObject.put("l_activity", this.mActivityPolling);
            jSONObject.put("f_liveSwitch", this.mLiveSwitch);
            jSONObject.put("s_guardianFans", this.mGuardFans);
            jSONObject.put("s_giftPanel", this.mGiftPanel);
            jSONObject.put("f_modal", this.mPopupWindow);
            jSONObject.put("c_audience", this.mAudience);
            jSONObject.put("s_firstCharge", this.mFirstCharge);
            jSONObject.put("f_large_charge", this.mSuperConsumer);
            jSONObject.put("s_rotary_table", this.mRotaryTable);
            jSONObject.put("s_shareBtn", this.mShareBtn);
            jSONObject.put("f_live_effect_redpacket", this.mRedPkg);
            jSONObject.put("s_guard_seat", this.mGuardThrone);
            jSONObject.put("f_video_goodslist", this.mVideoGoodslist);
            jSONObject.put("f_activity_task_watch", this.mActivityTaskWatch);
            jSONObject.put("f_gmsg_getLiveStatus", this.mGmsgGetLiveStatus);
            jSONObject.put("s_noble_info", this.mNobleInfo);
            jSONObject.put("s_paid_barrage", this.mPayBarrage);
            jSONObject.put("s_quick_chat", this.mQuickChat);
            jSONObject.put("s_gift_panel", this.mGiftPanelInvalid);
            jSONObject.put("s_small_window_pendant", this.mSmallWindowPendant);
            jSONObject.put("s_hide_zan", this.mZanAnim);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public boolean isActivityTaskWatchUnabled() {
        return TextUtils.equals(this.mActivityTaskWatch, "0");
    }

    public boolean isGmsgGetLiveStatusUnabled() {
        return TextUtils.equals(this.mGmsgGetLiveStatus, "0");
    }

    public boolean isVideoGoodslistUnabled() {
        return TextUtils.equals(this.mVideoGoodslist, "0");
    }

    public boolean isEventPollingUnabled() {
        return TextUtils.equals(this.mEventPolling, "0");
    }

    public boolean isCashGiftUnabled() {
        return TextUtils.equals(this.mCashGift, "0");
    }

    public boolean isFollowBtnUnabled() {
        return TextUtils.equals(this.mFollowBtn, "0");
    }

    public boolean isRankHourUnabled() {
        return TextUtils.equals(this.mRankHour, "0");
    }

    public boolean isQuickGiftUnabled() {
        return TextUtils.equals(this.mQuickGift, "0");
    }

    public boolean isDayListUnabled() {
        return TextUtils.equals(this.mDayList, "0");
    }

    public boolean isActivityPollingUnabled() {
        return TextUtils.equals(this.mActivityPolling, "0");
    }

    public boolean isLiveSwitchUnabled() {
        return TextUtils.equals(this.mLiveSwitch, "0");
    }

    public boolean isGuardFansUnabled() {
        return TextUtils.equals(this.mGuardFans, "0");
    }

    public boolean isPopupWindowUnabled() {
        return TextUtils.equals(this.mPopupWindow, "0");
    }

    public boolean isAudienceUnabled() {
        return TextUtils.equals(this.mAudience, "0");
    }

    public boolean isFirstChargeUnabled() {
        return TextUtils.equals(this.mFirstCharge, "0");
    }

    public boolean isEntrySuperCustomerUnabled() {
        return TextUtils.equals(this.mSuperConsumer, "0");
    }

    public boolean isRotaryTableUnabled() {
        return TextUtils.equals(this.mRotaryTable, "0");
    }

    public boolean isShareBtnUnabled() {
        return TextUtils.equals(this.mShareBtn, "0");
    }

    public boolean isRedPkgSwitchUnabled() {
        return TextUtils.equals(this.mRedPkg, "0");
    }

    public boolean isGuardThroneSwitchUnabled() {
        return TextUtils.equals(this.mGuardThrone, "0");
    }

    public boolean isNobleInfoSwitchUnabled() {
        return TextUtils.equals(this.mNobleInfo, "0");
    }

    public boolean isPayBarrageUnabled() {
        return TextUtils.equals(this.mPayBarrage, "0");
    }

    public boolean isQuickChatUnabled() {
        return TextUtils.equals(this.mQuickChat, "0");
    }

    public boolean isGiftPanelUnabled() {
        return TextUtils.equals(this.mGiftPanelInvalid, "0");
    }

    public boolean isSmallWindowPendantUnabled() {
        return !TextUtils.equals(this.mSmallWindowPendant, "1");
    }

    public boolean isZanAnimUnabled() {
        return TextUtils.equals(this.mZanAnim, "0");
    }
}
