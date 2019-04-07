package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a {
    public int appCategory;
    public String appId;
    public String appKey;
    public String appName;
    public int appStatus;
    public String atY;
    public String aub;
    public String auc;
    public String aud;
    public long aul = 432000;
    public long blP;
    public String blQ;
    public String blR;
    public long blS;
    public int blT;
    public String blU;
    public String blV;
    public String blW;
    public String blX;
    public long createTime;
    public String description;
    public String iconUrl;
    public int orientation;
    public int type;
    public int versionCode;
    public String versionName;

    public boolean RG() {
        return this.blT != 0;
    }

    public boolean AE() {
        return (System.currentTimeMillis() - this.createTime) / 1000 > this.aul;
    }

    public void g(g gVar) {
        if (gVar != null) {
            this.appId = gVar.blZ;
            this.versionCode = gVar.versionCode;
            this.versionName = gVar.versionName;
            this.type = gVar.bma;
            this.blS = gVar.size;
        }
    }

    public void h(a aVar) {
        if (aVar != null && TextUtils.equals(this.appId, aVar.appId)) {
            this.versionCode = aVar.versionCode;
            this.versionName = aVar.versionName;
            this.type = aVar.type;
            this.blS = aVar.blS;
            this.createTime = aVar.createTime;
            this.orientation = aVar.orientation;
        }
    }

    public void RH() {
        if (this.aul <= 0) {
            this.aul = 432000L;
        }
        this.createTime = System.currentTimeMillis();
    }

    public boolean RI() {
        return !TextUtils.isEmpty(this.appKey) && this.blP > 0;
    }
}
