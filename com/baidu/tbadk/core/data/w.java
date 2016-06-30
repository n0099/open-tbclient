package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import org.json.JSONObject;
import tbclient.GraffitiRankItem;
/* loaded from: classes.dex */
public class w {
    private long Ol;
    private int Om;
    private String On;
    private int Oo;
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

    public long pd() {
        return this.Ol;
    }

    public void t(long j) {
        this.Ol = j;
    }

    public int pe() {
        return this.Om;
    }

    public void bv(int i) {
        this.Om = i;
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

    public int pf() {
        return this.Oo;
    }

    public void bw(int i) {
        this.Oo = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String pg() {
        return this.On;
    }

    public void cl(String str) {
        this.On = str;
    }

    public void a(GraffitiRankItem graffitiRankItem) {
        if (graffitiRankItem != null) {
            this.type = 1;
            this.gid = graffitiRankItem.gid.longValue();
            this.Ol = graffitiRankItem.vote_count.longValue();
            this.Om = graffitiRankItem.is_vote.intValue();
            this.url = graffitiRankItem.url;
            this.On = graffitiRankItem.thumb_url;
            this.uid = graffitiRankItem.uid.longValue();
            this.picId = graffitiRankItem.pic_id;
            this.Oo = graffitiRankItem.g_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = 1;
                this.gid = jSONObject.optLong("gid");
                this.Ol = jSONObject.optLong("vote_count");
                this.Om = jSONObject.optInt("is_vote");
                this.url = jSONObject.optString("url");
                this.On = jSONObject.optString("thumb_url");
                this.uid = jSONObject.optLong("uid");
                this.picId = jSONObject.optString(GraffitiVcodeActivityConfig.PIC_ID);
                this.Oo = jSONObject.optInt("g_type");
            } catch (Exception e) {
            }
        }
    }

    public boolean ph() {
        return this.Oo == 2 || this.Oo == 3;
    }

    public boolean pi() {
        return getType() == 1 && getGid() > 0 && !TextUtils.isEmpty(pg()) && !TextUtils.isEmpty(getUrl());
    }
}
