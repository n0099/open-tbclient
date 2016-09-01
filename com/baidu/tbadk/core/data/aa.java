package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import org.json.JSONObject;
import tbclient.GraffitiRankItem;
/* loaded from: classes.dex */
public class aa {
    private long Rk;
    private int Rl;
    private String Rm;
    private int Rn;
    private long gid;
    private String picId;
    private int type = 1;
    private long uid;
    private String url;

    public long getGid() {
        return this.gid;
    }

    public void setGid(long j) {
        this.gid = j;
    }

    public long pP() {
        return this.Rk;
    }

    public void o(long j) {
        this.Rk = j;
    }

    public int pQ() {
        return this.Rl;
    }

    public void bH(int i) {
        this.Rl = i;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public long getUid() {
        return this.uid;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public String getPicId() {
        return this.picId;
    }

    public void setPicId(String str) {
        this.picId = str;
    }

    public int pR() {
        return this.Rn;
    }

    public void bI(int i) {
        this.Rn = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String pS() {
        return this.Rm;
    }

    public void cm(String str) {
        this.Rm = str;
    }

    public void a(GraffitiRankItem graffitiRankItem) {
        if (graffitiRankItem != null) {
            this.type = 1;
            this.gid = graffitiRankItem.gid.longValue();
            this.Rk = graffitiRankItem.vote_count.longValue();
            this.Rl = graffitiRankItem.is_vote.intValue();
            this.url = graffitiRankItem.url;
            this.Rm = graffitiRankItem.thumb_url;
            this.uid = graffitiRankItem.uid.longValue();
            this.picId = graffitiRankItem.pic_id;
            this.Rn = graffitiRankItem.g_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = 1;
                this.gid = jSONObject.optLong("gid");
                this.Rk = jSONObject.optLong("vote_count");
                this.Rl = jSONObject.optInt("is_vote");
                this.url = jSONObject.optString("url");
                this.Rm = jSONObject.optString("thumb_url");
                this.uid = jSONObject.optLong("uid");
                this.picId = jSONObject.optString(GraffitiVcodeActivityConfig.PIC_ID);
                this.Rn = jSONObject.optInt("g_type");
            } catch (Exception e) {
            }
        }
    }

    public boolean pT() {
        return this.Rn == 2 || this.Rn == 3;
    }

    public boolean pU() {
        return getType() == 1 && getGid() > 0 && !TextUtils.isEmpty(pS()) && !TextUtils.isEmpty(getUrl());
    }
}
