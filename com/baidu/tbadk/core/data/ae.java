package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import org.json.JSONObject;
import tbclient.GraffitiRankItem;
/* loaded from: classes.dex */
public class ae {
    private long Wt;
    private int Wu;
    private String Wv;
    private int Ww;
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

    public long qM() {
        return this.Wt;
    }

    public void l(long j) {
        this.Wt = j;
    }

    public int qN() {
        return this.Wu;
    }

    public void bE(int i) {
        this.Wu = i;
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

    public int qO() {
        return this.Ww;
    }

    public void bF(int i) {
        this.Ww = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String qP() {
        return this.Wv;
    }

    public void cn(String str) {
        this.Wv = str;
    }

    public void a(GraffitiRankItem graffitiRankItem) {
        if (graffitiRankItem != null) {
            this.type = 1;
            this.gid = graffitiRankItem.gid.longValue();
            this.Wt = graffitiRankItem.vote_count.longValue();
            this.Wu = graffitiRankItem.is_vote.intValue();
            this.url = graffitiRankItem.url;
            this.Wv = graffitiRankItem.thumb_url;
            this.uid = graffitiRankItem.uid.longValue();
            this.picId = graffitiRankItem.pic_id;
            this.Ww = graffitiRankItem.g_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = 1;
                this.gid = jSONObject.optLong("gid");
                this.Wt = jSONObject.optLong("vote_count");
                this.Wu = jSONObject.optInt("is_vote");
                this.url = jSONObject.optString("url");
                this.Wv = jSONObject.optString("thumb_url");
                this.uid = jSONObject.optLong(SapiAccountManager.SESSION_UID);
                this.picId = jSONObject.optString(GraffitiVcodeActivityConfig.PIC_ID);
                this.Ww = jSONObject.optInt("g_type");
            } catch (Exception e) {
            }
        }
    }

    public boolean qQ() {
        return this.Ww == 2 || this.Ww == 3;
    }

    public boolean qR() {
        return getType() == 1 && getGid() > 0 && !TextUtils.isEmpty(qP()) && !TextUtils.isEmpty(getUrl());
    }
}
