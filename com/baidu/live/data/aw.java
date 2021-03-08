package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class aw {
    public AlaLiveUserInfoData aJD;
    public aj aKf;
    public String aKm;
    public boolean aKp;
    public a aPI;
    public int aPJ;
    public int aPK;
    public AlaLiveInfoData mLiveInfo;
    public AlaLiveSdkInfo mLiveSdkInfo;
    public int mErrorCode = 0;
    public String mErrorMsg = null;
    public int aPC = 0;
    public int aPD = 1;
    public String aPE = null;
    public int aPF = 1;
    public String aPG = null;
    public int aPH = 0;
    public long logId = 0;

    /* loaded from: classes10.dex */
    public static class a {
        public List<String> aPL = new ArrayList();
        public String notify;
    }

    public boolean Cx() {
        return this.aPC == 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.logId = jSONObject.optLong("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
            if (optJSONObject != null) {
                this.mErrorCode = optJSONObject.optInt(BaseJsonData.TAG_ERRNO);
                this.mErrorMsg = optJSONObject.optString("usermsg");
                if (TextUtils.isEmpty(this.mErrorMsg)) {
                    this.mErrorMsg = optJSONObject.optString(BaseJsonData.TAG_ERRMSG);
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (optJSONObject2 != null) {
                this.aPJ = optJSONObject2.optInt("new_anchor_assist_task");
                this.aPC = optJSONObject2.optInt("user_status");
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("user_info");
                if (optJSONObject3 != null) {
                    this.aJD = new AlaLiveUserInfoData();
                    this.aJD.parserJson(optJSONObject3);
                }
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("guard_club");
                if (optJSONObject4 != null) {
                    this.aPK = optJSONObject4.optInt("show_rename_help");
                }
                JSONObject optJSONObject5 = optJSONObject2.optJSONObject("live_info");
                if (optJSONObject5 != null) {
                    this.mLiveInfo = new AlaLiveInfoData();
                    this.mLiveInfo.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject("pk_solo_info");
                if (optJSONObject6 != null) {
                    this.aKf = new aj();
                    this.aKf.parserJson(optJSONObject6);
                }
                JSONObject optJSONObject7 = optJSONObject2.optJSONObject(CashierData.SDK);
                if (optJSONObject7 != null) {
                    this.mLiveSdkInfo = new AlaLiveSdkInfo();
                    this.mLiveSdkInfo.parseJson(optJSONObject7);
                }
                if (this.mLiveInfo != null && this.mLiveSdkInfo != null && this.mLiveInfo.room_id == 0 && this.mLiveSdkInfo.mRoomId != 0) {
                    this.mLiveInfo.room_id = this.mLiveSdkInfo.mRoomId;
                }
                this.aKm = optJSONObject2.optString("user_watermark");
                JSONObject optJSONObject8 = optJSONObject2.optJSONObject(UbcStatConstant.ContentType.UBC_TYPE_STRATEGY);
                if (optJSONObject8 != null) {
                    JSONObject optJSONObject9 = optJSONObject8.optJSONObject(LogConfig.VALUE_LIVE_HK_RECORD_START);
                    if (optJSONObject9 != null) {
                        this.aPE = optJSONObject9.optString("text");
                        this.aPD = optJSONObject9.optInt("switch");
                    }
                    JSONObject optJSONObject10 = optJSONObject8.optJSONObject("user_verify");
                    if (optJSONObject10 != null) {
                        this.aPF = optJSONObject10.optInt("switch");
                        this.aPG = optJSONObject10.optString("text");
                    }
                    JSONObject optJSONObject11 = optJSONObject8.optJSONObject("certify");
                    if (optJSONObject11 != null) {
                        this.aPH = optJSONObject11.optInt("switch");
                    }
                }
                JSONObject optJSONObject12 = optJSONObject2.optJSONObject("live_authen_info");
                if (optJSONObject12 != null) {
                    this.aPI = new a();
                    this.aPI.notify = optJSONObject12.optString("notify");
                    JSONArray optJSONArray = optJSONObject12.optJSONArray("questions");
                    for (int i = 0; optJSONArray != null && i < optJSONArray.length(); i++) {
                        this.aPI.aPL.add(optJSONArray.optString(i));
                    }
                }
                this.aKp = optJSONObject2.optInt("switch_guard_seat") == 1;
            }
        }
    }
}
