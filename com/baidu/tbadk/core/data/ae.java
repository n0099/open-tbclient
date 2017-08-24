package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import org.json.JSONObject;
import tbclient.GraffitiRankItem;
/* loaded from: classes.dex */
public class ae {
    private long Xp;
    private int Xq;
    private String Xr;
    private int Xs;
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

    public long qc() {
        return this.Xp;
    }

    public void l(long j) {
        this.Xp = j;
    }

    public int qd() {
        return this.Xq;
    }

    public void bD(int i) {
        this.Xq = i;
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

    public int qe() {
        return this.Xs;
    }

    public void bE(int i) {
        this.Xs = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getThumbUrl() {
        return this.Xr;
    }

    public void setThumbUrl(String str) {
        this.Xr = str;
    }

    public void a(GraffitiRankItem graffitiRankItem) {
        if (graffitiRankItem != null) {
            this.type = 1;
            this.gid = graffitiRankItem.gid.longValue();
            this.Xp = graffitiRankItem.vote_count.longValue();
            this.Xq = graffitiRankItem.is_vote.intValue();
            this.url = graffitiRankItem.url;
            this.Xr = graffitiRankItem.thumb_url;
            this.uid = graffitiRankItem.uid.longValue();
            this.picId = graffitiRankItem.pic_id;
            this.Xs = graffitiRankItem.g_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = 1;
                this.gid = jSONObject.optLong("gid");
                this.Xp = jSONObject.optLong("vote_count");
                this.Xq = jSONObject.optInt("is_vote");
                this.url = jSONObject.optString("url");
                this.Xr = jSONObject.optString("thumb_url");
                this.uid = jSONObject.optLong(SapiAccountManager.SESSION_UID);
                this.picId = jSONObject.optString(GraffitiVcodeActivityConfig.PIC_ID);
                this.Xs = jSONObject.optInt("g_type");
            } catch (Exception e) {
            }
        }
    }

    public boolean qf() {
        return this.Xs == 2 || this.Xs == 3;
    }

    public boolean qg() {
        return getType() == 1 && getGid() > 0 && !TextUtils.isEmpty(getThumbUrl()) && !TextUtils.isEmpty(getUrl());
    }
}
