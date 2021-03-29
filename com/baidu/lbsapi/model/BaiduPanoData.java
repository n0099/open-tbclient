package com.baidu.lbsapi.model;

import android.text.TextUtils;
import com.baidu.pano.platform.c.j;
/* loaded from: classes2.dex */
public class BaiduPanoData {

    /* renamed from: a  reason: collision with root package name */
    public String f6351a;

    /* renamed from: b  reason: collision with root package name */
    public String f6352b;

    /* renamed from: c  reason: collision with root package name */
    public int f6353c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f6354d = 0;

    /* renamed from: e  reason: collision with root package name */
    public String f6355e = j.a();

    /* renamed from: f  reason: collision with root package name */
    public int f6356f = 404;

    /* renamed from: g  reason: collision with root package name */
    public String f6357g = "";

    public String getDescription() {
        return toString();
    }

    public int getErrorCode() {
        return this.f6356f;
    }

    public String getName() {
        return this.f6352b;
    }

    public String getPid() {
        return this.f6351a;
    }

    public int getX() {
        return this.f6353c;
    }

    public int getY() {
        return this.f6354d;
    }

    public boolean hasStreetPano() {
        return !TextUtils.isEmpty(this.f6351a);
    }

    public void setErrorCode(int i) {
        this.f6356f = i;
    }

    public void setName(String str) {
        this.f6352b = str;
    }

    public void setPid(String str) {
        this.f6351a = str;
    }

    public void setX(int i) {
        if (i > 100000000) {
            i /= 100;
        }
        this.f6353c = i;
    }

    public void setY(int i) {
        if (i > 100000000) {
            i /= 100;
        }
        this.f6354d = i;
    }

    public String toString() {
        return "BaiduPanoData [pid = " + this.f6351a + ", name=" + this.f6352b + ",x=" + this.f6353c + ", y=" + this.f6354d + ", sdkVersion=" + this.f6355e + ", errorCode=" + this.f6356f + ", hasStreetPano=" + hasStreetPano() + "]";
    }
}
