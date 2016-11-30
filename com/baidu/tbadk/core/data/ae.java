package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import org.json.JSONObject;
import tbclient.GraffitiRankItem;
/* loaded from: classes.dex */
public class ae {
    private long RL;
    private int RM;
    private String RO;
    private int RP;
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

    public long qd() {
        return this.RL;
    }

    public void n(long j) {
        this.RL = j;
    }

    public int qe() {
        return this.RM;
    }

    public void bH(int i) {
        this.RM = i;
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

    public int qf() {
        return this.RP;
    }

    public void bI(int i) {
        this.RP = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String qg() {
        return this.RO;
    }

    public void co(String str) {
        this.RO = str;
    }

    public void a(GraffitiRankItem graffitiRankItem) {
        if (graffitiRankItem != null) {
            this.type = 1;
            this.gid = graffitiRankItem.gid.longValue();
            this.RL = graffitiRankItem.vote_count.longValue();
            this.RM = graffitiRankItem.is_vote.intValue();
            this.url = graffitiRankItem.url;
            this.RO = graffitiRankItem.thumb_url;
            this.uid = graffitiRankItem.uid.longValue();
            this.picId = graffitiRankItem.pic_id;
            this.RP = graffitiRankItem.g_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = 1;
                this.gid = jSONObject.optLong("gid");
                this.RL = jSONObject.optLong("vote_count");
                this.RM = jSONObject.optInt("is_vote");
                this.url = jSONObject.optString("url");
                this.RO = jSONObject.optString("thumb_url");
                this.uid = jSONObject.optLong("uid");
                this.picId = jSONObject.optString(GraffitiVcodeActivityConfig.PIC_ID);
                this.RP = jSONObject.optInt("g_type");
            } catch (Exception e) {
            }
        }
    }

    public boolean qh() {
        return this.RP == 2 || this.RP == 3;
    }

    public boolean qi() {
        return getType() == 1 && getGid() > 0 && !TextUtils.isEmpty(qg()) && !TextUtils.isEmpty(getUrl());
    }
}
