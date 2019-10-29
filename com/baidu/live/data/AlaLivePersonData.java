package com.baidu.live.data;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaLivePersonData implements Serializable {
    public AlaAvtsConfigInfo mAvtsConfigInfo;
    public AlaAvtsData mAvtsData;
    public AlaPersonChallengeData mChallengeData;
    public AlaLiveInfoData mLiveInfo;
    public h mLiveSdkInfo;
    public AlaLocationData mLocationData;
    public AlaPersonPkData mPkData;
    public AlaRelationData mRelationData;
    public AlaLiveUserInfoData mUserData;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.mUserData = new AlaLiveUserInfoData();
                this.mUserData.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.mLiveInfo = new AlaLiveInfoData();
                this.mLiveInfo.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.mRelationData = new AlaRelationData();
                this.mRelationData.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("location_info");
            if (optJSONObject4 != null) {
                this.mLocationData = new AlaLocationData();
                this.mLocationData.parserJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("pk_info");
            if (optJSONObject5 != null) {
                this.mPkData = new AlaPersonPkData();
                this.mPkData.parserJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("challenge_info");
            if (optJSONObject6 != null) {
                this.mChallengeData = new AlaPersonChallengeData();
                this.mChallengeData.parserJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("avts_info");
            if (optJSONObject7 != null) {
                this.mAvtsData = new AlaAvtsData();
                this.mAvtsData.parserJson(optJSONObject7);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("avts_conf");
            if (optJSONObject8 != null) {
                this.mAvtsConfigInfo = new AlaAvtsConfigInfo();
                this.mAvtsConfigInfo.parserJson(optJSONObject8);
            }
            JSONObject jSONObject2 = (JSONObject) jSONObject.opt("sdk");
            if (jSONObject2 != null) {
                this.mLiveSdkInfo = new h();
                this.mLiveSdkInfo.parseJson(jSONObject2);
            }
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mUserData != null) {
                jSONObject.put("user_info", this.mUserData.toJsonObject());
            }
            if (this.mLiveInfo != null) {
                jSONObject.put("live_info", this.mLiveInfo.toJsonObject());
            }
            if (this.mRelationData != null) {
                jSONObject.put("relation_info", this.mRelationData.toJsonObject());
            }
            if (this.mLocationData != null) {
                jSONObject.put("location_info", this.mLocationData.toJsonObject());
            }
            if (this.mPkData != null) {
                jSONObject.put("pk_info", this.mPkData.toJsonObject());
            }
            if (this.mChallengeData != null) {
                jSONObject.put("challenge_info", this.mChallengeData.toJsonObject());
            }
            if (this.mAvtsData != null) {
                jSONObject.put("avts_info", this.mAvtsData.toJsonObject());
            }
            if (this.mAvtsConfigInfo != null) {
                jSONObject.put("avts_conf", this.mAvtsConfigInfo.toJsonObject());
            }
            if (this.mLiveSdkInfo != null) {
                jSONObject.put("sdk", this.mLiveSdkInfo.toJsonObject());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
