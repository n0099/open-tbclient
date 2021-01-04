package com.baidu.lbsapi.model;

import android.text.TextUtils;
import com.baidu.pano.platform.c.j;
/* loaded from: classes15.dex */
public class BaiduPanoData {

    /* renamed from: a  reason: collision with root package name */
    private String f2552a;

    /* renamed from: b  reason: collision with root package name */
    private String f2553b;
    private int c = 0;
    private int d = 0;
    private String e = j.a();
    private int f = 404;
    private String g = "";

    public int getX() {
        return this.c;
    }

    public void setX(int i) {
        if (i > 100000000) {
            i /= 100;
        }
        this.c = i;
    }

    public int getY() {
        return this.d;
    }

    public void setY(int i) {
        if (i > 100000000) {
            i /= 100;
        }
        this.d = i;
    }

    public String getPid() {
        return this.f2552a;
    }

    public void setPid(String str) {
        this.f2552a = str;
    }

    public String getName() {
        return this.f2553b;
    }

    public void setName(String str) {
        this.f2553b = str;
    }

    public int getErrorCode() {
        return this.f;
    }

    public void setErrorCode(int i) {
        this.f = i;
    }

    public String getDescription() {
        return toString();
    }

    public boolean hasStreetPano() {
        return !TextUtils.isEmpty(this.f2552a);
    }

    public String toString() {
        return "BaiduPanoData [pid = " + this.f2552a + ", name=" + this.f2553b + ",x=" + this.c + ", y=" + this.d + ", sdkVersion=" + this.e + ", errorCode=" + this.f + ", hasStreetPano=" + hasStreetPano() + "]";
    }
}
