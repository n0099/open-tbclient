package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import org.json.JSONObject;
import tbclient.GraffitiRankItem;
/* loaded from: classes.dex */
public class af {
    private long We;
    private int Wf;
    private String Wg;
    private int Wh;
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

    public long qp() {
        return this.We;
    }

    public void l(long j) {
        this.We = j;
    }

    public int qq() {
        return this.Wf;
    }

    public void bB(int i) {
        this.Wf = i;
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

    public int qr() {
        return this.Wh;
    }

    public void bC(int i) {
        this.Wh = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String qs() {
        return this.Wg;
    }

    public void cg(String str) {
        this.Wg = str;
    }

    public void a(GraffitiRankItem graffitiRankItem) {
        if (graffitiRankItem != null) {
            this.type = 1;
            this.gid = graffitiRankItem.gid.longValue();
            this.We = graffitiRankItem.vote_count.longValue();
            this.Wf = graffitiRankItem.is_vote.intValue();
            this.url = graffitiRankItem.url;
            this.Wg = graffitiRankItem.thumb_url;
            this.uid = graffitiRankItem.uid.longValue();
            this.picId = graffitiRankItem.pic_id;
            this.Wh = graffitiRankItem.g_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = 1;
                this.gid = jSONObject.optLong("gid");
                this.We = jSONObject.optLong("vote_count");
                this.Wf = jSONObject.optInt("is_vote");
                this.url = jSONObject.optString("url");
                this.Wg = jSONObject.optString("thumb_url");
                this.uid = jSONObject.optLong(SapiAccountManager.SESSION_UID);
                this.picId = jSONObject.optString(GraffitiVcodeActivityConfig.PIC_ID);
                this.Wh = jSONObject.optInt("g_type");
            } catch (Exception e) {
            }
        }
    }

    public boolean qt() {
        return this.Wh == 2 || this.Wh == 3;
    }

    public boolean qu() {
        return getType() == 1 && getGid() > 0 && !TextUtils.isEmpty(qs()) && !TextUtils.isEmpty(getUrl());
    }
}
