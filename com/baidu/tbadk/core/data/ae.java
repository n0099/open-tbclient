package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import org.json.JSONObject;
import tbclient.GraffitiRankItem;
/* loaded from: classes.dex */
public class ae {
    private long QS;
    private int QT;
    private String QU;
    private int QV;
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

    public long pX() {
        return this.QS;
    }

    public void m(long j) {
        this.QS = j;
    }

    public int pY() {
        return this.QT;
    }

    public void bG(int i) {
        this.QT = i;
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

    public int pZ() {
        return this.QV;
    }

    public void bH(int i) {
        this.QV = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String qa() {
        return this.QU;
    }

    public void cn(String str) {
        this.QU = str;
    }

    public void a(GraffitiRankItem graffitiRankItem) {
        if (graffitiRankItem != null) {
            this.type = 1;
            this.gid = graffitiRankItem.gid.longValue();
            this.QS = graffitiRankItem.vote_count.longValue();
            this.QT = graffitiRankItem.is_vote.intValue();
            this.url = graffitiRankItem.url;
            this.QU = graffitiRankItem.thumb_url;
            this.uid = graffitiRankItem.uid.longValue();
            this.picId = graffitiRankItem.pic_id;
            this.QV = graffitiRankItem.g_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = 1;
                this.gid = jSONObject.optLong("gid");
                this.QS = jSONObject.optLong("vote_count");
                this.QT = jSONObject.optInt("is_vote");
                this.url = jSONObject.optString("url");
                this.QU = jSONObject.optString("thumb_url");
                this.uid = jSONObject.optLong(SapiAccountManager.SESSION_UID);
                this.picId = jSONObject.optString(GraffitiVcodeActivityConfig.PIC_ID);
                this.QV = jSONObject.optInt("g_type");
            } catch (Exception e) {
            }
        }
    }

    public boolean qb() {
        return this.QV == 2 || this.QV == 3;
    }

    public boolean qc() {
        return getType() == 1 && getGid() > 0 && !TextUtils.isEmpty(qa()) && !TextUtils.isEmpty(getUrl());
    }
}
