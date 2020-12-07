package com.baidu.live.guardclub;

import android.text.TextUtils;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public String aRO;
    public long biS;
    public String bjr;
    public String bjs;
    public int bjt;
    private int guardGold;
    public int guardGoldenType;
    public int guardLevel;
    public String guardName;
    public boolean isFollowed;
    public String portrait;
    public String rank;
    public String score;
    public String userId;
    public String userName;

    public boolean isGold() {
        return this.guardGold == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a A[Catch: Exception -> 0x00b3, NumberFormatException -> 0x00cd, TRY_LEAVE, TryCatch #2 {NumberFormatException -> 0x00cd, blocks: (B:15:0x0054, B:17:0x005a), top: B:39:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0069 A[Catch: Exception -> 0x00b3, TryCatch #4 {Exception -> 0x00b3, blocks: (B:6:0x0007, B:7:0x000e, B:9:0x0014, B:10:0x0018, B:13:0x003f, B:14:0x004d, B:15:0x0054, B:17:0x005a, B:18:0x005e, B:20:0x0069, B:21:0x008d, B:29:0x00c8, B:26:0x00be), top: B:41:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parseJson(JSONObject jSONObject) {
        String str;
        String str2;
        JSONObject optJSONObject;
        String str3;
        String str4;
        if (jSONObject != null) {
            String str5 = "0";
            try {
                try {
                    str = jSONObject.optString("user_id");
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            str = EncryptionHelper.getDecryptUserId(str);
                        }
                    } catch (NumberFormatException e) {
                        str5 = str4;
                        e = e;
                        e.printStackTrace();
                        str = str5;
                        this.userId = str;
                        this.userName = jSONObject.optString("user_name");
                        this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                        this.rank = jSONObject.optString("rank");
                        this.isFollowed = jSONObject.optInt("follow_status") != 1;
                        this.bjr = jSONObject.optString("guard_club_id");
                        String str6 = "0";
                        str2 = jSONObject.optString("anchor_id");
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        this.aRO = str2;
                        optJSONObject = jSONObject.optJSONObject("guard_club");
                        if (optJSONObject != null) {
                        }
                        this.biS = jSONObject.optLong("next_level_need_score");
                        this.portrait = jSONObject.optString("portrait");
                        this.bjs = jSONObject.optString("bd_portrait");
                        this.bjt = jSONObject.optInt("attenuat_date");
                    }
                } catch (NumberFormatException e2) {
                    e = e2;
                }
                this.userId = str;
                this.userName = jSONObject.optString("user_name");
                this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.rank = jSONObject.optString("rank");
                this.isFollowed = jSONObject.optInt("follow_status") != 1;
                this.bjr = jSONObject.optString("guard_club_id");
                String str62 = "0";
                try {
                    str2 = jSONObject.optString("anchor_id");
                } catch (NumberFormatException e3) {
                    e = e3;
                }
                try {
                    if (!TextUtils.isEmpty(str2)) {
                        str2 = EncryptionHelper.getDecryptUserId(str2);
                    }
                } catch (NumberFormatException e4) {
                    str62 = str3;
                    e = e4;
                    e.printStackTrace();
                    str2 = str62;
                    this.aRO = str2;
                    optJSONObject = jSONObject.optJSONObject("guard_club");
                    if (optJSONObject != null) {
                    }
                    this.biS = jSONObject.optLong("next_level_need_score");
                    this.portrait = jSONObject.optString("portrait");
                    this.bjs = jSONObject.optString("bd_portrait");
                    this.bjt = jSONObject.optInt("attenuat_date");
                }
                this.aRO = str2;
                optJSONObject = jSONObject.optJSONObject("guard_club");
                if (optJSONObject != null) {
                    this.guardLevel = optJSONObject.optInt("member_guard_level");
                    this.guardName = optJSONObject.optString("guard_name");
                    this.guardGold = optJSONObject.optInt("guard_show_golden_icon");
                    this.guardGoldenType = optJSONObject.optInt("guard_golden_type");
                }
                this.biS = jSONObject.optLong("next_level_need_score");
                this.portrait = jSONObject.optString("portrait");
                this.bjs = jSONObject.optString("bd_portrait");
                this.bjt = jSONObject.optInt("attenuat_date");
            } catch (Exception e5) {
                BdLog.e(e5.getMessage());
            }
        }
    }
}
