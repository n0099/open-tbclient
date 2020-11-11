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
/* loaded from: classes4.dex */
public class ap {
    public AlaLiveUserInfoData aIV;
    public String aJC;
    public boolean aJF;
    public ad aJx;
    public a aNY;
    public AlaLiveInfoData mLiveInfo;
    public AlaLiveSdkInfo mLiveSdkInfo;
    public int mErrorCode = 0;
    public String mErrorMsg = null;
    public int aNS = 0;
    public int aNT = 1;
    public String aNU = null;
    public int aNV = 1;
    public String aNW = null;
    public int aNX = 0;
    public long logId = 0;

    /* loaded from: classes4.dex */
    public static class a {
        public List<String> aNZ = new ArrayList();
        public String notify;
    }

    public boolean EK() {
        return this.aNS == 0;
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
                this.aNS = optJSONObject2.optInt("user_status");
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("user_info");
                if (optJSONObject3 != null) {
                    this.aIV = new AlaLiveUserInfoData();
                    this.aIV.parserJson(optJSONObject3);
                }
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("live_info");
                if (optJSONObject4 != null) {
                    this.mLiveInfo = new AlaLiveInfoData();
                    this.mLiveInfo.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = optJSONObject2.optJSONObject("pk_solo_info");
                if (optJSONObject5 != null) {
                    this.aJx = new ad();
                    this.aJx.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject(CashierData.SDK);
                if (optJSONObject6 != null) {
                    this.mLiveSdkInfo = new AlaLiveSdkInfo();
                    this.mLiveSdkInfo.parseJson(optJSONObject6);
                }
                if (this.mLiveInfo != null && this.mLiveSdkInfo != null && this.mLiveInfo.room_id == 0 && this.mLiveSdkInfo.mRoomId != 0) {
                    this.mLiveInfo.room_id = this.mLiveSdkInfo.mRoomId;
                }
                this.aJC = optJSONObject2.optString("user_watermark");
                JSONObject optJSONObject7 = optJSONObject2.optJSONObject(UbcStatConstant.ContentType.UBC_TYPE_STRATEGY);
                if (optJSONObject7 != null) {
                    JSONObject optJSONObject8 = optJSONObject7.optJSONObject(LogConfig.VALUE_LIVE_HK_RECORD_START);
                    if (optJSONObject8 != null) {
                        this.aNU = optJSONObject8.optString("text");
                        this.aNT = optJSONObject8.optInt("switch");
                    }
                    JSONObject optJSONObject9 = optJSONObject7.optJSONObject("user_verify");
                    if (optJSONObject9 != null) {
                        this.aNV = optJSONObject9.optInt("switch");
                        this.aNW = optJSONObject9.optString("text");
                    }
                    JSONObject optJSONObject10 = optJSONObject7.optJSONObject("certify");
                    if (optJSONObject10 != null) {
                        this.aNX = optJSONObject10.optInt("switch");
                    }
                }
                JSONObject optJSONObject11 = optJSONObject2.optJSONObject("live_authen_info");
                if (optJSONObject11 != null) {
                    this.aNY = new a();
                    this.aNY.notify = optJSONObject11.optString("notify");
                    JSONArray optJSONArray = optJSONObject11.optJSONArray("questions");
                    for (int i = 0; optJSONArray != null && i < optJSONArray.length(); i++) {
                        this.aNY.aNZ.add(optJSONArray.optString(i));
                    }
                }
                this.aJF = optJSONObject2.optInt("switch_guard_seat") == 1;
            }
        }
    }
}
