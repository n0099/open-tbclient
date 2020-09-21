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
public class al {
    public AlaLiveUserInfoData aEz;
    public aa aFf;
    public String aFk;
    public boolean aFn;
    public a aJm;
    public AlaLiveInfoData mLiveInfo;
    public s mLiveSdkInfo;
    public int mErrorCode = 0;
    public String mErrorMsg = null;
    public int aJg = 0;
    public int aJh = 1;
    public String aJi = null;
    public int aJj = 1;
    public String aJk = null;
    public int aJl = 0;
    public long logId = 0;

    /* loaded from: classes4.dex */
    public static class a {
        public List<String> aJn = new ArrayList();
        public String notify;
    }

    public boolean Di() {
        return this.aJg == 0;
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
                this.aJg = optJSONObject2.optInt("user_status");
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("user_info");
                if (optJSONObject3 != null) {
                    this.aEz = new AlaLiveUserInfoData();
                    this.aEz.parserJson(optJSONObject3);
                }
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("live_info");
                if (optJSONObject4 != null) {
                    this.mLiveInfo = new AlaLiveInfoData();
                    this.mLiveInfo.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = optJSONObject2.optJSONObject("pk_solo_info");
                if (optJSONObject5 != null) {
                    this.aFf = new aa();
                    this.aFf.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject(CashierData.SDK);
                if (optJSONObject6 != null) {
                    this.mLiveSdkInfo = new s();
                    this.mLiveSdkInfo.parseJson(optJSONObject6);
                }
                if (this.mLiveInfo != null && this.mLiveSdkInfo != null && this.mLiveInfo.room_id == 0 && this.mLiveSdkInfo.mRoomId != 0) {
                    this.mLiveInfo.room_id = this.mLiveSdkInfo.mRoomId;
                }
                this.aFk = optJSONObject2.optString("user_watermark");
                JSONObject optJSONObject7 = optJSONObject2.optJSONObject(UbcStatConstant.ContentType.UBC_TYPE_STRATEGY);
                if (optJSONObject7 != null) {
                    JSONObject optJSONObject8 = optJSONObject7.optJSONObject(LogConfig.VALUE_LIVE_HK_RECORD_START);
                    if (optJSONObject8 != null) {
                        this.aJi = optJSONObject8.optString("text");
                        this.aJh = optJSONObject8.optInt("switch");
                    }
                    JSONObject optJSONObject9 = optJSONObject7.optJSONObject("user_verify");
                    if (optJSONObject9 != null) {
                        this.aJj = optJSONObject9.optInt("switch");
                        this.aJk = optJSONObject9.optString("text");
                    }
                    JSONObject optJSONObject10 = optJSONObject7.optJSONObject("certify");
                    if (optJSONObject10 != null) {
                        this.aJl = optJSONObject10.optInt("switch");
                    }
                }
                JSONObject optJSONObject11 = optJSONObject2.optJSONObject("live_authen_info");
                if (optJSONObject11 != null) {
                    this.aJm = new a();
                    this.aJm.notify = optJSONObject11.optString("notify");
                    JSONArray optJSONArray = optJSONObject11.optJSONArray("questions");
                    for (int i = 0; optJSONArray != null && i < optJSONArray.length(); i++) {
                        this.aJm.aJn.add(optJSONArray.optString(i));
                    }
                }
                this.aFn = optJSONObject2.optInt("switch_guard_seat") == 1;
            }
        }
    }
}
