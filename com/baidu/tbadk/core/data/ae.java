package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import org.json.JSONObject;
import tbclient.GraffitiRankItem;
/* loaded from: classes.dex */
public class ae {
    private long Wu;
    private int Wv;
    private String Ww;
    private int Wx;
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
        return this.Wu;
    }

    public void l(long j) {
        this.Wu = j;
    }

    public int qN() {
        return this.Wv;
    }

    public void bE(int i) {
        this.Wv = i;
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
        return this.Wx;
    }

    public void bF(int i) {
        this.Wx = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String qP() {
        return this.Ww;
    }

    public void cn(String str) {
        this.Ww = str;
    }

    public void a(GraffitiRankItem graffitiRankItem) {
        if (graffitiRankItem != null) {
            this.type = 1;
            this.gid = graffitiRankItem.gid.longValue();
            this.Wu = graffitiRankItem.vote_count.longValue();
            this.Wv = graffitiRankItem.is_vote.intValue();
            this.url = graffitiRankItem.url;
            this.Ww = graffitiRankItem.thumb_url;
            this.uid = graffitiRankItem.uid.longValue();
            this.picId = graffitiRankItem.pic_id;
            this.Wx = graffitiRankItem.g_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = 1;
                this.gid = jSONObject.optLong("gid");
                this.Wu = jSONObject.optLong("vote_count");
                this.Wv = jSONObject.optInt("is_vote");
                this.url = jSONObject.optString("url");
                this.Ww = jSONObject.optString("thumb_url");
                this.uid = jSONObject.optLong(SapiAccountManager.SESSION_UID);
                this.picId = jSONObject.optString(GraffitiVcodeActivityConfig.PIC_ID);
                this.Wx = jSONObject.optInt("g_type");
            } catch (Exception e) {
            }
        }
    }

    public boolean qQ() {
        return this.Wx == 2 || this.Wx == 3;
    }

    public boolean qR() {
        return getType() == 1 && getGid() > 0 && !TextUtils.isEmpty(qP()) && !TextUtils.isEmpty(getUrl());
    }
}
