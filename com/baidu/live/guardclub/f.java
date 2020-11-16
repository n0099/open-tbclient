package com.baidu.live.guardclub;

import android.text.TextUtils;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public String aOM;
    public int beE;
    public long beF;
    public String bfa;
    public String bfc;
    public int bfd;
    public boolean isFollowed;
    public String portrait;
    public String rank;
    public String score;
    public String userId;
    public String userName;

    /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a A[Catch: Exception -> 0x008f, NumberFormatException -> 0x00a8, TRY_LEAVE, TryCatch #0 {Exception -> 0x008f, blocks: (B:6:0x0007, B:7:0x000e, B:9:0x0014, B:10:0x0018, B:13:0x003f, B:14:0x004d, B:15:0x0054, B:17:0x005a, B:18:0x005e, B:26:0x00a3, B:23:0x009a), top: B:32:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parseJson(JSONObject jSONObject) {
        String str;
        String str2;
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
                        this.bfa = jSONObject.optString("guard_club_id");
                        String str6 = "0";
                        str2 = jSONObject.optString("anchor_id");
                        try {
                            if (!TextUtils.isEmpty(str2)) {
                            }
                        } catch (NumberFormatException e2) {
                            str6 = str3;
                            e = e2;
                            e.printStackTrace();
                            str2 = str6;
                            this.aOM = str2;
                            this.beE = jSONObject.optInt("member_level");
                            this.beF = jSONObject.optLong("next_level_need_score");
                            this.portrait = jSONObject.optString("portrait");
                            this.bfc = jSONObject.optString("bd_portrait");
                            this.bfd = jSONObject.optInt("attenuat_date");
                        }
                        this.aOM = str2;
                        this.beE = jSONObject.optInt("member_level");
                        this.beF = jSONObject.optLong("next_level_need_score");
                        this.portrait = jSONObject.optString("portrait");
                        this.bfc = jSONObject.optString("bd_portrait");
                        this.bfd = jSONObject.optInt("attenuat_date");
                    }
                } catch (Exception e3) {
                    BdLog.e(e3.getMessage());
                    return;
                }
            } catch (NumberFormatException e4) {
                e = e4;
            }
            this.userId = str;
            this.userName = jSONObject.optString("user_name");
            this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
            this.rank = jSONObject.optString("rank");
            this.isFollowed = jSONObject.optInt("follow_status") != 1;
            this.bfa = jSONObject.optString("guard_club_id");
            String str62 = "0";
            try {
                str2 = jSONObject.optString("anchor_id");
                if (!TextUtils.isEmpty(str2)) {
                    str2 = EncryptionHelper.getDecryptUserId(str2);
                }
            } catch (NumberFormatException e5) {
                e = e5;
            }
            this.aOM = str2;
            this.beE = jSONObject.optInt("member_level");
            this.beF = jSONObject.optLong("next_level_need_score");
            this.portrait = jSONObject.optString("portrait");
            this.bfc = jSONObject.optString("bd_portrait");
            this.bfd = jSONObject.optInt("attenuat_date");
        }
    }
}
