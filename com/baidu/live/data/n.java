package com.baidu.live.data;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class n {
    private boolean aIl;
    private String aIm;
    private boolean aIn;
    private String aIo;
    private boolean aIp;
    private String aIq;
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

    public boolean By() {
        return this.aIl;
    }

    public void bu(boolean z) {
        this.aIl = z;
    }

    public boolean Bz() {
        return this.aIn;
    }

    public void bv(boolean z) {
        this.aIn = z;
    }

    public String BA() {
        return this.aIo;
    }

    public void fz(String str) {
        this.aIo = str;
    }

    public void bw(boolean z) {
        this.aIp = z;
    }

    public void fA(String str) {
        this.aIq = str;
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
            fz(jSONObject.optString("team_id", ""));
            bw(jSONObject.optInt("is_leader", 0) == 1);
            fA(jSONObject.optString("subject_id", ""));
            setStatus(jSONObject.optInt("status"));
        }
    }

    public String toString() {
        return "AlaGuessGroupInfo{nickname='" + this.nickname + "', avatar='" + this.avatar + "', userId='" + this.userId + "', isAnswer=" + this.aIl + ", userAnswer='" + this.aIm + "', isDouble=" + this.aIn + ", teamId='" + this.aIo + "', isLeader=" + this.aIp + ", subjectId='" + this.aIq + "', status=" + this.status + '}';
    }
}
