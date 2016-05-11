package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.CommonVcodeActivityConfig;
import org.json.JSONObject;
import tbclient.GraffitiRankItem;
/* loaded from: classes.dex */
public class u {
    private long Om;
    private int On;
    private String Oo;
    private int Op;
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

    public long pl() {
        return this.Om;
    }

    public void t(long j) {
        this.Om = j;
    }

    public int pm() {
        return this.On;
    }

    public void bv(int i) {
        this.On = i;
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

    public int pn() {
        return this.Op;
    }

    public void bw(int i) {
        this.Op = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String po() {
        return this.Oo;
    }

    public void cm(String str) {
        this.Oo = str;
    }

    public void a(GraffitiRankItem graffitiRankItem) {
        if (graffitiRankItem != null) {
            this.type = 1;
            this.gid = graffitiRankItem.gid.longValue();
            this.Om = graffitiRankItem.vote_count.longValue();
            this.On = graffitiRankItem.is_vote.intValue();
            this.url = graffitiRankItem.url;
            this.Oo = graffitiRankItem.thumb_url;
            this.uid = graffitiRankItem.uid.longValue();
            this.picId = graffitiRankItem.pic_id;
            this.Op = graffitiRankItem.g_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = 1;
                this.gid = jSONObject.optLong("gid");
                this.Om = jSONObject.optLong("vote_count");
                this.On = jSONObject.optInt("is_vote");
                this.url = jSONObject.optString("url");
                this.Oo = jSONObject.optString("thumb_url");
                this.uid = jSONObject.optLong("uid");
                this.picId = jSONObject.optString(CommonVcodeActivityConfig.PIC_ID);
                this.Op = jSONObject.optInt("g_type");
            } catch (Exception e) {
            }
        }
    }

    public boolean pp() {
        return this.Op == 2 || this.Op == 3;
    }

    public boolean pq() {
        return getType() == 1 && getGid() > 0 && !TextUtils.isEmpty(po()) && !TextUtils.isEmpty(getUrl());
    }
}
