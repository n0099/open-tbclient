package com.baidu.live.data;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class n {
    private boolean aGL;
    private String aGM;
    private boolean aGN;
    private String aGO;
    private boolean aGP;
    private String aGQ;
    private String avatar;
    private String nickname;
    private int status;
    private String userId;

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public boolean Bv() {
        return this.aGL;
    }

    public void bu(boolean z) {
        this.aGL = z;
    }

    public boolean Bw() {
        return this.aGN;
    }

    public void bv(boolean z) {
        this.aGN = z;
    }

    public String Bx() {
        return this.aGO;
    }

    public void ft(String str) {
        this.aGO = str;
    }

    public void bw(boolean z) {
        this.aGP = z;
    }

    public void fu(String str) {
        this.aGQ = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            bu(jSONObject.optInt("is_answer", 0) == 1);
            setNickname(jSONObject.optString("nickname", ""));
            setAvatar(jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR, ""));
            setUserId(jSONObject.optString("user_id", ""));
            bv(jSONObject.optInt("is_double", 0) == 1);
            ft(jSONObject.optString("team_id", ""));
            bw(jSONObject.optInt("is_leader", 0) == 1);
            fu(jSONObject.optString("subject_id", ""));
            setStatus(jSONObject.optInt("status"));
        }
    }

    public String toString() {
        return "AlaGuessGroupInfo{nickname='" + this.nickname + "', avatar='" + this.avatar + "', userId='" + this.userId + "', isAnswer=" + this.aGL + ", userAnswer='" + this.aGM + "', isDouble=" + this.aGN + ", teamId='" + this.aGO + "', isLeader=" + this.aGP + ", subjectId='" + this.aGQ + "', status=" + this.status + '}';
    }
}
