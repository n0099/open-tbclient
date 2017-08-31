package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import org.json.JSONObject;
import tbclient.GraffitiRankItem;
/* loaded from: classes.dex */
public class ae {
    private String WA;
    private int WB;
    private long Wy;
    private int Wz;
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
        return this.Wy;
    }

    public void l(long j) {
        this.Wy = j;
    }

    public int pY() {
        return this.Wz;
    }

    public void bD(int i) {
        this.Wz = i;
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
        return this.WB;
    }

    public void bE(int i) {
        this.WB = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getThumbUrl() {
        return this.WA;
    }

    public void setThumbUrl(String str) {
        this.WA = str;
    }

    public void a(GraffitiRankItem graffitiRankItem) {
        if (graffitiRankItem != null) {
            this.type = 1;
            this.gid = graffitiRankItem.gid.longValue();
            this.Wy = graffitiRankItem.vote_count.longValue();
            this.Wz = graffitiRankItem.is_vote.intValue();
            this.url = graffitiRankItem.url;
            this.WA = graffitiRankItem.thumb_url;
            this.uid = graffitiRankItem.uid.longValue();
            this.picId = graffitiRankItem.pic_id;
            this.WB = graffitiRankItem.g_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = 1;
                this.gid = jSONObject.optLong("gid");
                this.Wy = jSONObject.optLong("vote_count");
                this.Wz = jSONObject.optInt("is_vote");
                this.url = jSONObject.optString("url");
                this.WA = jSONObject.optString("thumb_url");
                this.uid = jSONObject.optLong(SapiAccountManager.SESSION_UID);
                this.picId = jSONObject.optString("pic_id");
                this.WB = jSONObject.optInt("g_type");
            } catch (Exception e) {
            }
        }
    }

    public boolean qa() {
        return this.WB == 2 || this.WB == 3;
    }

    public boolean qb() {
        return getType() == 1 && getGid() > 0 && !TextUtils.isEmpty(getThumbUrl()) && !TextUtils.isEmpty(getUrl());
    }
}
