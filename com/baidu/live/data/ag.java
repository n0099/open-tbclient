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
/* loaded from: classes7.dex */
public class ag {
    public AlaLiveUserInfoData aDG;
    public String aEm;
    public boolean aEq;
    public a aHS;
    public AlaLiveInfoData mLiveInfo;
    public p mLiveSdkInfo;
    public int mErrorCode = 0;
    public String mErrorMsg = null;
    public int aHM = 0;
    public int aHN = 1;
    public String aHO = null;
    public int aHP = 1;
    public String aHQ = null;
    public int aHR = 0;
    public long aEo = 0;

    /* loaded from: classes7.dex */
    public static class a {
        public List<String> aHT = new ArrayList();
        public String notify;
    }

    public boolean CS() {
        return this.aHM == 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aEo = jSONObject.optLong("logid");
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
                this.aHM = optJSONObject2.optInt("user_status");
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("user_info");
                if (optJSONObject3 != null) {
                    this.aDG = new AlaLiveUserInfoData();
                    this.aDG.parserJson(optJSONObject3);
                }
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("live_info");
                if (optJSONObject4 != null) {
                    this.mLiveInfo = new AlaLiveInfoData();
                    this.mLiveInfo.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = optJSONObject2.optJSONObject(CashierData.SDK);
                if (optJSONObject5 != null) {
                    this.mLiveSdkInfo = new p();
                    this.mLiveSdkInfo.parseJson(optJSONObject5);
                }
                if (this.mLiveInfo != null && this.mLiveSdkInfo != null && this.mLiveInfo.room_id == 0 && this.mLiveSdkInfo.mRoomId != 0) {
                    this.mLiveInfo.room_id = this.mLiveSdkInfo.mRoomId;
                }
                this.aEm = optJSONObject2.optString("user_watermark");
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject(UbcStatConstant.ContentType.UBC_TYPE_STRATEGY);
                if (optJSONObject6 != null) {
                    JSONObject optJSONObject7 = optJSONObject6.optJSONObject(LogConfig.VALUE_LIVE_HK_RECORD_START);
                    if (optJSONObject7 != null) {
                        this.aHO = optJSONObject7.optString("text");
                        this.aHN = optJSONObject7.optInt("switch");
                    }
                    JSONObject optJSONObject8 = optJSONObject6.optJSONObject("user_verify");
                    if (optJSONObject8 != null) {
                        this.aHP = optJSONObject8.optInt("switch");
                        this.aHQ = optJSONObject8.optString("text");
                    }
                    JSONObject optJSONObject9 = optJSONObject6.optJSONObject("certify");
                    if (optJSONObject9 != null) {
                        this.aHR = optJSONObject9.optInt("switch");
                    }
                }
                JSONObject optJSONObject10 = optJSONObject2.optJSONObject("live_authen_info");
                if (optJSONObject10 != null) {
                    this.aHS = new a();
                    this.aHS.notify = optJSONObject10.optString("notify");
                    JSONArray optJSONArray = optJSONObject10.optJSONArray("questions");
                    for (int i = 0; optJSONArray != null && i < optJSONArray.length(); i++) {
                        this.aHS.aHT.add(optJSONArray.optString(i));
                    }
                }
                this.aEq = optJSONObject2.optInt("switch_guard_seat") == 1;
            }
        }
    }
}
