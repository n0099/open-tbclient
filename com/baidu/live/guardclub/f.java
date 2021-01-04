package com.baidu.live.guardclub;

import android.text.TextUtils;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f {
    public String aLV;
    public String aWS;
    public String bkW;
    public int bkX;
    public long bkx;
    public JSONObject extInfoJson;
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

    /* JADX WARN: Can't wrap try/catch for region: R(15:6|7|(3:9|10|(1:12))|14|(1:16)(1:38)|17|18|19|20|21|(1:23)|25|(1:27)|28|30) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d1, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d2, code lost:
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d3, code lost:
        r1.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d6, code lost:
        r0 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d8, code lost:
        r1 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d9, code lost:
        r2 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a A[Catch: Exception -> 0x00bc, NumberFormatException -> 0x00d8, TRY_LEAVE, TryCatch #1 {NumberFormatException -> 0x00d8, blocks: (B:15:0x0054, B:17:0x005a), top: B:39:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0069 A[Catch: Exception -> 0x00bc, TryCatch #3 {Exception -> 0x00bc, blocks: (B:6:0x0007, B:7:0x000e, B:9:0x0014, B:10:0x0018, B:13:0x003f, B:14:0x004d, B:15:0x0054, B:17:0x005a, B:18:0x005e, B:20:0x0069, B:21:0x008d, B:31:0x00d3, B:27:0x00c8), top: B:37:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parseJson(JSONObject jSONObject) {
        NumberFormatException e;
        String str;
        String str2;
        JSONObject optJSONObject;
        String str3;
        if (jSONObject != null) {
            String str4 = "0";
            try {
                try {
                    str = jSONObject.optString("user_id");
                } catch (NumberFormatException e2) {
                    e = e2;
                }
                try {
                    if (!TextUtils.isEmpty(str)) {
                        str = EncryptionHelper.getDecryptUserId(str);
                    }
                } catch (NumberFormatException e3) {
                    e = e3;
                    str4 = str3;
                    e.printStackTrace();
                    str = str4;
                    this.userId = str;
                    this.userName = jSONObject.optString("user_name");
                    this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                    this.rank = jSONObject.optString("rank");
                    this.isFollowed = jSONObject.optInt("follow_status") != 1;
                    this.bkW = jSONObject.optString("guard_club_id");
                    String str5 = "0";
                    str2 = jSONObject.optString("anchor_id");
                    if (!TextUtils.isEmpty(str2)) {
                    }
                    this.aLV = str2;
                    optJSONObject = jSONObject.optJSONObject("guard_club");
                    if (optJSONObject != null) {
                    }
                    this.bkx = jSONObject.optLong("next_level_need_score");
                    this.portrait = jSONObject.optString("portrait");
                    this.aWS = jSONObject.optString("bd_portrait");
                    this.bkX = jSONObject.optInt("attenuat_date");
                    this.extInfoJson = jSONObject.optJSONObject("ext_info");
                }
                this.userId = str;
                this.userName = jSONObject.optString("user_name");
                this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.rank = jSONObject.optString("rank");
                this.isFollowed = jSONObject.optInt("follow_status") != 1;
                this.bkW = jSONObject.optString("guard_club_id");
                String str52 = "0";
                str2 = jSONObject.optString("anchor_id");
                if (!TextUtils.isEmpty(str2)) {
                    str2 = EncryptionHelper.getDecryptUserId(str2);
                }
                this.aLV = str2;
                optJSONObject = jSONObject.optJSONObject("guard_club");
                if (optJSONObject != null) {
                    this.guardLevel = optJSONObject.optInt("member_guard_level");
                    this.guardName = optJSONObject.optString("guard_name");
                    this.guardGold = optJSONObject.optInt("guard_show_golden_icon");
                    this.guardGoldenType = optJSONObject.optInt("guard_golden_type");
                }
                this.bkx = jSONObject.optLong("next_level_need_score");
                this.portrait = jSONObject.optString("portrait");
                this.aWS = jSONObject.optString("bd_portrait");
                this.bkX = jSONObject.optInt("attenuat_date");
                this.extInfoJson = jSONObject.optJSONObject("ext_info");
            } catch (Exception e4) {
                BdLog.e(e4.getMessage());
            }
        }
    }
}
