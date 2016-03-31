package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.CommonVcodeActivityConfig;
import org.json.JSONObject;
import tbclient.GraffitiRankItem;
/* loaded from: classes.dex */
public class u {
    private String TA;
    private int TB;
    private long Ty;
    private int Tz;
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

    public long rS() {
        return this.Ty;
    }

    public void r(long j) {
        this.Ty = j;
    }

    public int rT() {
        return this.Tz;
    }

    public void bJ(int i) {
        this.Tz = i;
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

    public int rU() {
        return this.TB;
    }

    public void bK(int i) {
        this.TB = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String rV() {
        return this.TA;
    }

    public void cp(String str) {
        this.TA = str;
    }

    public void a(GraffitiRankItem graffitiRankItem) {
        if (graffitiRankItem != null) {
            this.type = 1;
            this.gid = graffitiRankItem.gid.longValue();
            this.Ty = graffitiRankItem.vote_count.longValue();
            this.Tz = graffitiRankItem.is_vote.intValue();
            this.url = graffitiRankItem.url;
            this.TA = graffitiRankItem.thumb_url;
            this.uid = graffitiRankItem.uid.longValue();
            this.picId = graffitiRankItem.pic_id;
            this.TB = graffitiRankItem.g_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = 1;
                this.gid = jSONObject.optLong("gid");
                this.Ty = jSONObject.optLong("vote_count");
                this.Tz = jSONObject.optInt("is_vote");
                this.url = jSONObject.optString("url");
                this.TA = jSONObject.optString("thumb_url");
                this.uid = jSONObject.optLong("uid");
                this.picId = jSONObject.optString(CommonVcodeActivityConfig.PIC_ID);
                this.TB = jSONObject.optInt("g_type");
            } catch (Exception e) {
            }
        }
    }

    public boolean rW() {
        return this.TB == 2 || this.TB == 3;
    }

    public boolean rX() {
        return getType() == 1 && getGid() > 0 && !TextUtils.isEmpty(rV()) && !TextUtils.isEmpty(getUrl());
    }
}
