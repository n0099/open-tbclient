package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a {
    public int appCategory;
    public String appId;
    public String appKey;
    public String appName;
    public int appStatus;
    public String atZ;
    public String auc;
    public String aud;
    public String aue;
    public long aum = 432000;
    public long blQ;
    public String blR;
    public String blS;
    public long blT;
    public int blU;
    public String blV;
    public String blW;
    public String blX;
    public String blY;
    public long createTime;
    public String description;
    public String iconUrl;
    public int orientation;
    public int type;
    public int versionCode;
    public String versionName;

    public boolean RG() {
        return this.blU != 0;
    }

    public boolean AE() {
        return (System.currentTimeMillis() - this.createTime) / 1000 > this.aum;
    }

    public void g(g gVar) {
        if (gVar != null) {
            this.appId = gVar.bma;
            this.versionCode = gVar.versionCode;
            this.versionName = gVar.versionName;
            this.type = gVar.bmb;
            this.blT = gVar.size;
        }
    }

    public void h(a aVar) {
        if (aVar != null && TextUtils.equals(this.appId, aVar.appId)) {
            this.versionCode = aVar.versionCode;
            this.versionName = aVar.versionName;
            this.type = aVar.type;
            this.blT = aVar.blT;
            this.createTime = aVar.createTime;
            this.orientation = aVar.orientation;
        }
    }

    public void RH() {
        if (this.aum <= 0) {
            this.aum = 432000L;
        }
        this.createTime = System.currentTimeMillis();
    }

    public boolean RI() {
        return !TextUtils.isEmpty(this.appKey) && this.blQ > 0;
    }
}
