package com.baidu.lbsapi.model;

import android.text.TextUtils;
import com.baidu.pano.platform.c.j;
/* loaded from: classes2.dex */
public class BaiduPanoData {

    /* renamed from: a  reason: collision with root package name */
    public String f6571a;

    /* renamed from: b  reason: collision with root package name */
    public String f6572b;

    /* renamed from: c  reason: collision with root package name */
    public int f6573c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f6574d = 0;

    /* renamed from: e  reason: collision with root package name */
    public String f6575e = j.a();

    /* renamed from: f  reason: collision with root package name */
    public int f6576f = 404;

    /* renamed from: g  reason: collision with root package name */
    public String f6577g = "";

    public String getDescription() {
        return toString();
    }

    public int getErrorCode() {
        return this.f6576f;
    }

    public String getName() {
        return this.f6572b;
    }

    public String getPid() {
        return this.f6571a;
    }

    public int getX() {
        return this.f6573c;
    }

    public int getY() {
        return this.f6574d;
    }

    public boolean hasStreetPano() {
        return !TextUtils.isEmpty(this.f6571a);
    }

    public void setErrorCode(int i2) {
        this.f6576f = i2;
    }

    public void setName(String str) {
        this.f6572b = str;
    }

    public void setPid(String str) {
        this.f6571a = str;
    }

    public void setX(int i2) {
        if (i2 > 100000000) {
            i2 /= 100;
        }
        this.f6573c = i2;
    }

    public void setY(int i2) {
        if (i2 > 100000000) {
            i2 /= 100;
        }
        this.f6574d = i2;
    }

    public String toString() {
        return "BaiduPanoData [pid = " + this.f6571a + ", name=" + this.f6572b + ",x=" + this.f6573c + ", y=" + this.f6574d + ", sdkVersion=" + this.f6575e + ", errorCode=" + this.f6576f + ", hasStreetPano=" + hasStreetPano() + "]";
    }
}
