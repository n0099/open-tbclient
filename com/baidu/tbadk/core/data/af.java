package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import org.json.JSONObject;
import tbclient.GraffitiRankItem;
/* loaded from: classes.dex */
public class af {
    private long VA;
    private int VB;
    private String VC;
    private int VD;
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

    public long pO() {
        return this.VA;
    }

    public void l(long j) {
        this.VA = j;
    }

    public int pP() {
        return this.VB;
    }

    public void bC(int i) {
        this.VB = i;
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

    public int pQ() {
        return this.VD;
    }

    public void bD(int i) {
        this.VD = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getThumbUrl() {
        return this.VC;
    }

    public void setThumbUrl(String str) {
        this.VC = str;
    }

    public void a(GraffitiRankItem graffitiRankItem) {
        if (graffitiRankItem != null) {
            this.type = 1;
            this.gid = graffitiRankItem.gid.longValue();
            this.VA = graffitiRankItem.vote_count.longValue();
            this.VB = graffitiRankItem.is_vote.intValue();
            this.url = graffitiRankItem.url;
            this.VC = graffitiRankItem.thumb_url;
            this.uid = graffitiRankItem.uid.longValue();
            this.picId = graffitiRankItem.pic_id;
            this.VD = graffitiRankItem.g_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = 1;
                this.gid = jSONObject.optLong("gid");
                this.VA = jSONObject.optLong("vote_count");
                this.VB = jSONObject.optInt("is_vote");
                this.url = jSONObject.optString("url");
                this.VC = jSONObject.optString("thumb_url");
                this.uid = jSONObject.optLong(SapiAccountManager.SESSION_UID);
                this.picId = jSONObject.optString(GraffitiVcodeActivityConfig.PIC_ID);
                this.VD = jSONObject.optInt("g_type");
            } catch (Exception e) {
            }
        }
    }

    public boolean pR() {
        return this.VD == 2 || this.VD == 3;
    }

    public boolean pS() {
        return getType() == 1 && getGid() > 0 && !TextUtils.isEmpty(getThumbUrl()) && !TextUtils.isEmpty(getUrl());
    }
}
