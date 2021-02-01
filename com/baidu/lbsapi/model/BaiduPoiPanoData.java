package com.baidu.lbsapi.model;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class BaiduPoiPanoData extends BaiduPanoData {
    private float d;
    private float c = 0.0f;

    /* renamed from: a  reason: collision with root package name */
    private String f2503a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f2504b = "";
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
        return this.f2503a;
    }

    public void setIid(String str) {
        this.f2503a = str;
    }

    public String getUid() {
        return this.f2504b;
    }

    public void setUid(String str) {
        this.f2504b = str;
    }

    public String getPanoTag() {
        return this.e;
    }

    public void setPanoTag(String str) {
        this.e = str;
    }

    public boolean hasInnerPano() {
        return !TextUtils.isEmpty(this.f2503a);
    }

    @Override // com.baidu.lbsapi.model.BaiduPanoData
    public String toString() {
        return super.toString() + "\n BaiduPoiPanoData [heading=" + this.c + ", pitch=" + this.d + ", iid=" + this.f2503a + ",  uid=" + this.f2504b + ", panoTag=" + this.e + ", hasInnerPano=" + hasInnerPano() + "]";
    }
}
