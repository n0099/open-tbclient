package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import org.json.JSONObject;
import tbclient.GraffitiRankItem;
/* loaded from: classes.dex */
public class ae {
    private long Xo;
    private int Xp;
    private String Xq;
    private int Xr;
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

    public long qb() {
        return this.Xo;
    }

    public void l(long j) {
        this.Xo = j;
    }

    public int qc() {
        return this.Xp;
    }

    public void bD(int i) {
        this.Xp = i;
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

    public int qd() {
        return this.Xr;
    }

    public void bE(int i) {
        this.Xr = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getThumbUrl() {
        return this.Xq;
    }

    public void setThumbUrl(String str) {
        this.Xq = str;
    }

    public void a(GraffitiRankItem graffitiRankItem) {
        if (graffitiRankItem != null) {
            this.type = 1;
            this.gid = graffitiRankItem.gid.longValue();
            this.Xo = graffitiRankItem.vote_count.longValue();
            this.Xp = graffitiRankItem.is_vote.intValue();
            this.url = graffitiRankItem.url;
            this.Xq = graffitiRankItem.thumb_url;
            this.uid = graffitiRankItem.uid.longValue();
            this.picId = graffitiRankItem.pic_id;
            this.Xr = graffitiRankItem.g_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = 1;
                this.gid = jSONObject.optLong("gid");
                this.Xo = jSONObject.optLong("vote_count");
                this.Xp = jSONObject.optInt("is_vote");
                this.url = jSONObject.optString("url");
                this.Xq = jSONObject.optString("thumb_url");
                this.uid = jSONObject.optLong(SapiAccountManager.SESSION_UID);
                this.picId = jSONObject.optString(GraffitiVcodeActivityConfig.PIC_ID);
                this.Xr = jSONObject.optInt("g_type");
            } catch (Exception e) {
            }
        }
    }

    public boolean qe() {
        return this.Xr == 2 || this.Xr == 3;
    }

    public boolean qf() {
        return getType() == 1 && getGid() > 0 && !TextUtils.isEmpty(getThumbUrl()) && !TextUtils.isEmpty(getUrl());
    }
}
