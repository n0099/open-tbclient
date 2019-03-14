package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a {
    public int appCategory;
    public String appId;
    public String appKey;
    public String appName;
    public int appStatus;
    public String atU;
    public String atX;
    public String atY;
    public String atZ;
    public long auh = 432000;
    public long blM;
    public String blN;
    public String blO;
    public long blP;
    public int blQ;
    public String blR;
    public String blS;
    public String blT;
    public String blU;
    public long createTime;
    public String description;
    public String iconUrl;
    public int orientation;
    public int type;
    public int versionCode;
    public String versionName;

    public boolean RI() {
        return this.blQ != 0;
    }

    public boolean AF() {
        return (System.currentTimeMillis() - this.createTime) / 1000 > this.auh;
    }

    public void g(g gVar) {
        if (gVar != null) {
            this.appId = gVar.blW;
            this.versionCode = gVar.versionCode;
            this.versionName = gVar.versionName;
            this.type = gVar.blX;
            this.blP = gVar.size;
        }
    }

    public void h(a aVar) {
        if (aVar != null && TextUtils.equals(this.appId, aVar.appId)) {
            this.versionCode = aVar.versionCode;
            this.versionName = aVar.versionName;
            this.type = aVar.type;
            this.blP = aVar.blP;
            this.createTime = aVar.createTime;
            this.orientation = aVar.orientation;
        }
    }

    public void RJ() {
        if (this.auh <= 0) {
            this.auh = 432000L;
        }
        this.createTime = System.currentTimeMillis();
    }

    public boolean RK() {
        return !TextUtils.isEmpty(this.appKey) && this.blM > 0;
    }
}
