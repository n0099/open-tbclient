package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import org.json.JSONObject;
import tbclient.GraffitiRankItem;
/* loaded from: classes.dex */
public class z {
    private int OA;
    private long Ox;
    private int Oy;
    private String Oz;
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

    public long oM() {
        return this.Ox;
    }

    public void o(long j) {
        this.Ox = j;
    }

    public int oN() {
        return this.Oy;
    }

    public void bu(int i) {
        this.Oy = i;
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

    public int oO() {
        return this.OA;
    }

    public void bv(int i) {
        this.OA = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String oP() {
        return this.Oz;
    }

    public void cl(String str) {
        this.Oz = str;
    }

    public void a(GraffitiRankItem graffitiRankItem) {
        if (graffitiRankItem != null) {
            this.type = 1;
            this.gid = graffitiRankItem.gid.longValue();
            this.Ox = graffitiRankItem.vote_count.longValue();
            this.Oy = graffitiRankItem.is_vote.intValue();
            this.url = graffitiRankItem.url;
            this.Oz = graffitiRankItem.thumb_url;
            this.uid = graffitiRankItem.uid.longValue();
            this.picId = graffitiRankItem.pic_id;
            this.OA = graffitiRankItem.g_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = 1;
                this.gid = jSONObject.optLong("gid");
                this.Ox = jSONObject.optLong("vote_count");
                this.Oy = jSONObject.optInt("is_vote");
                this.url = jSONObject.optString("url");
                this.Oz = jSONObject.optString("thumb_url");
                this.uid = jSONObject.optLong("uid");
                this.picId = jSONObject.optString(GraffitiVcodeActivityConfig.PIC_ID);
                this.OA = jSONObject.optInt("g_type");
            } catch (Exception e) {
            }
        }
    }

    public boolean oQ() {
        return this.OA == 2 || this.OA == 3;
    }

    public boolean oR() {
        return getType() == 1 && getGid() > 0 && !TextUtils.isEmpty(oP()) && !TextUtils.isEmpty(getUrl());
    }
}
