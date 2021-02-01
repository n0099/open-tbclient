package com.baidu.lbsapi.model;

import android.text.TextUtils;
import com.baidu.pano.platform.c.j;
/* loaded from: classes4.dex */
public class BaiduPanoData {

    /* renamed from: a  reason: collision with root package name */
    private String f2501a;

    /* renamed from: b  reason: collision with root package name */
    private String f2502b;
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
        return this.f2501a;
    }

    public void setPid(String str) {
        this.f2501a = str;
    }

    public String getName() {
        return this.f2502b;
    }

    public void setName(String str) {
        this.f2502b = str;
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
        return !TextUtils.isEmpty(this.f2501a);
    }

    public String toString() {
        return "BaiduPanoData [pid = " + this.f2501a + ", name=" + this.f2502b + ",x=" + this.c + ", y=" + this.d + ", sdkVersion=" + this.e + ", errorCode=" + this.f + ", hasStreetPano=" + hasStreetPano() + "]";
    }
}
