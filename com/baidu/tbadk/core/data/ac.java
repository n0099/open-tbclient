package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import org.json.JSONObject;
import tbclient.GraffitiRankItem;
/* loaded from: classes.dex */
public class ac {
    private long Rq;
    private int Rr;
    private String Rs;
    private int Rt;
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

    public long qa() {
        return this.Rq;
    }

    public void o(long j) {
        this.Rq = j;
    }

    public int qb() {
        return this.Rr;
    }

    public void bH(int i) {
        this.Rr = i;
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

    public int qc() {
        return this.Rt;
    }

    public void bI(int i) {
        this.Rt = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String qd() {
        return this.Rs;
    }

    public void cm(String str) {
        this.Rs = str;
    }

    public void a(GraffitiRankItem graffitiRankItem) {
        if (graffitiRankItem != null) {
            this.type = 1;
            this.gid = graffitiRankItem.gid.longValue();
            this.Rq = graffitiRankItem.vote_count.longValue();
            this.Rr = graffitiRankItem.is_vote.intValue();
            this.url = graffitiRankItem.url;
            this.Rs = graffitiRankItem.thumb_url;
            this.uid = graffitiRankItem.uid.longValue();
            this.picId = graffitiRankItem.pic_id;
            this.Rt = graffitiRankItem.g_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = 1;
                this.gid = jSONObject.optLong("gid");
                this.Rq = jSONObject.optLong("vote_count");
                this.Rr = jSONObject.optInt("is_vote");
                this.url = jSONObject.optString("url");
                this.Rs = jSONObject.optString("thumb_url");
                this.uid = jSONObject.optLong("uid");
                this.picId = jSONObject.optString(GraffitiVcodeActivityConfig.PIC_ID);
                this.Rt = jSONObject.optInt("g_type");
            } catch (Exception e) {
            }
        }
    }

    public boolean qe() {
        return this.Rt == 2 || this.Rt == 3;
    }

    public boolean qf() {
        return getType() == 1 && getGid() > 0 && !TextUtils.isEmpty(qd()) && !TextUtils.isEmpty(getUrl());
    }
}
