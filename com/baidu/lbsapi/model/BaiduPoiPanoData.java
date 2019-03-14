package com.baidu.lbsapi.model;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class BaiduPoiPanoData extends BaiduPanoData {
    private float d;
    private float c = 0.0f;
    private String a = "";
    private String b = "";
    private String e = "";

    public void setPitch(float f) {
        this.d = f;
    }

    public float getPitch() {
        return this.d;
    }

    public double getHeading() {
        return this.c;
    }

    public void setHeading(float f) {
        this.c = f;
    }

    public String getIid() {
        return this.a;
    }

    public void setIid(String str) {
        this.a = str;
    }

    public String getUid() {
        return this.b;
    }

    public void setUid(String str) {
        this.b = str;
    }

    public String getPanoTag() {
        return this.e;
    }

    public void setPanoTag(String str) {
        this.e = str;
    }

    public boolean hasInnerPano() {
        return !TextUtils.isEmpty(this.a);
    }

    @Override // com.baidu.lbsapi.model.BaiduPanoData
    public String toString() {
        return super.toString() + "\n BaiduPoiPanoData [heading=" + this.c + ", pitch=" + this.d + ", iid=" + this.a + ",  uid=" + this.b + ", panoTag=" + this.e + ", hasInnerPano=" + hasInnerPano() + "]";
    }
}
