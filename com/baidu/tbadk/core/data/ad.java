package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import org.json.JSONObject;
import tbclient.GraffitiRankItem;
/* loaded from: classes.dex */
public class ad {
    private long RI;
    private int RJ;
    private String RK;
    private int RL;
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

    public long qe() {
        return this.RI;
    }

    public void n(long j) {
        this.RI = j;
    }

    public int qf() {
        return this.RJ;
    }

    public void bH(int i) {
        this.RJ = i;
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

    public int qg() {
        return this.RL;
    }

    public void bI(int i) {
        this.RL = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String qh() {
        return this.RK;
    }

    public void cp(String str) {
        this.RK = str;
    }

    public void a(GraffitiRankItem graffitiRankItem) {
        if (graffitiRankItem != null) {
            this.type = 1;
            this.gid = graffitiRankItem.gid.longValue();
            this.RI = graffitiRankItem.vote_count.longValue();
            this.RJ = graffitiRankItem.is_vote.intValue();
            this.url = graffitiRankItem.url;
            this.RK = graffitiRankItem.thumb_url;
            this.uid = graffitiRankItem.uid.longValue();
            this.picId = graffitiRankItem.pic_id;
            this.RL = graffitiRankItem.g_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = 1;
                this.gid = jSONObject.optLong("gid");
                this.RI = jSONObject.optLong("vote_count");
                this.RJ = jSONObject.optInt("is_vote");
                this.url = jSONObject.optString("url");
                this.RK = jSONObject.optString("thumb_url");
                this.uid = jSONObject.optLong(SapiAccountManager.SESSION_UID);
                this.picId = jSONObject.optString(GraffitiVcodeActivityConfig.PIC_ID);
                this.RL = jSONObject.optInt("g_type");
            } catch (Exception e) {
            }
        }
    }

    public boolean qi() {
        return this.RL == 2 || this.RL == 3;
    }

    public boolean qj() {
        return getType() == 1 && getGid() > 0 && !TextUtils.isEmpty(qh()) && !TextUtils.isEmpty(getUrl());
    }
}
