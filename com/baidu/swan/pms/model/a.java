package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a {
    public int appCategory;
    public String appId;
    public String appKey;
    public String appName;
    public int appStatus;
    public String atT;
    public String atW;
    public String atX;
    public String atY;
    public long aug = 432000;
    public long blL;
    public String blM;
    public String blN;
    public long blO;
    public int blP;
    public String blQ;
    public String blR;
    public String blS;
    public String blT;
    public long createTime;
    public String description;
    public String iconUrl;
    public int orientation;
    public int type;
    public int versionCode;
    public String versionName;

    public boolean RI() {
        return this.blP != 0;
    }

    public boolean AF() {
        return (System.currentTimeMillis() - this.createTime) / 1000 > this.aug;
    }

    public void g(g gVar) {
        if (gVar != null) {
            this.appId = gVar.blV;
            this.versionCode = gVar.versionCode;
            this.versionName = gVar.versionName;
            this.type = gVar.blW;
            this.blO = gVar.size;
        }
    }

    public void h(a aVar) {
        if (aVar != null && TextUtils.equals(this.appId, aVar.appId)) {
            this.versionCode = aVar.versionCode;
            this.versionName = aVar.versionName;
            this.type = aVar.type;
            this.blO = aVar.blO;
            this.createTime = aVar.createTime;
            this.orientation = aVar.orientation;
        }
    }

    public void RJ() {
        if (this.aug <= 0) {
            this.aug = 432000L;
        }
        this.createTime = System.currentTimeMillis();
    }

    public boolean RK() {
        return !TextUtils.isEmpty(this.appKey) && this.blL > 0;
    }
}
