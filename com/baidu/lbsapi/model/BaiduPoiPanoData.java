package com.baidu.lbsapi.model;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class BaiduPoiPanoData extends BaiduPanoData {
    private float d;
    private float c = 0.0f;

    /* renamed from: a  reason: collision with root package name */
    private String f2505a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f2506b = "";
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
        return this.f2505a;
    }

    public void setIid(String str) {
        this.f2505a = str;
    }

    public String getUid() {
        return this.f2506b;
    }

    public void setUid(String str) {
        this.f2506b = str;
    }

    public String getPanoTag() {
        return this.e;
    }

    public void setPanoTag(String str) {
        this.e = str;
    }

    public boolean hasInnerPano() {
        return !TextUtils.isEmpty(this.f2505a);
    }

    @Override // com.baidu.lbsapi.model.BaiduPanoData
    public String toString() {
        return super.toString() + "\n BaiduPoiPanoData [heading=" + this.c + ", pitch=" + this.d + ", iid=" + this.f2505a + ",  uid=" + this.f2506b + ", panoTag=" + this.e + ", hasInnerPano=" + hasInnerPano() + "]";
    }
}
