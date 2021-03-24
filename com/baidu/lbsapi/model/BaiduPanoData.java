package com.baidu.lbsapi.model;

import android.text.TextUtils;
import com.baidu.pano.platform.c.j;
/* loaded from: classes2.dex */
public class BaiduPanoData {

    /* renamed from: a  reason: collision with root package name */
    public String f6350a;

    /* renamed from: b  reason: collision with root package name */
    public String f6351b;

    /* renamed from: c  reason: collision with root package name */
    public int f6352c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f6353d = 0;

    /* renamed from: e  reason: collision with root package name */
    public String f6354e = j.a();

    /* renamed from: f  reason: collision with root package name */
    public int f6355f = 404;

    /* renamed from: g  reason: collision with root package name */
    public String f6356g = "";

    public String getDescription() {
        return toString();
    }

    public int getErrorCode() {
        return this.f6355f;
    }

    public String getName() {
        return this.f6351b;
    }

    public String getPid() {
        return this.f6350a;
    }

    public int getX() {
        return this.f6352c;
    }

    public int getY() {
        return this.f6353d;
    }

    public boolean hasStreetPano() {
        return !TextUtils.isEmpty(this.f6350a);
    }

    public void setErrorCode(int i) {
        this.f6355f = i;
    }

    public void setName(String str) {
        this.f6351b = str;
    }

    public void setPid(String str) {
        this.f6350a = str;
    }

    public void setX(int i) {
        if (i > 100000000) {
            i /= 100;
        }
        this.f6352c = i;
    }

    public void setY(int i) {
        if (i > 100000000) {
            i /= 100;
        }
        this.f6353d = i;
    }

    public String toString() {
        return "BaiduPanoData [pid = " + this.f6350a + ", name=" + this.f6351b + ",x=" + this.f6352c + ", y=" + this.f6353d + ", sdkVersion=" + this.f6354e + ", errorCode=" + this.f6355f + ", hasStreetPano=" + hasStreetPano() + "]";
    }
}
