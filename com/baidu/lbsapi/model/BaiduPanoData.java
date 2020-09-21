package com.baidu.lbsapi.model;

import android.text.TextUtils;
import com.baidu.pano.platform.c.j;
/* loaded from: classes3.dex */
public class BaiduPanoData {
    private String a;
    private String b;
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
        return this.a;
    }

    public void setPid(String str) {
        this.a = str;
    }

    public String getName() {
        return this.b;
    }

    public void setName(String str) {
        this.b = str;
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
        return !TextUtils.isEmpty(this.a);
    }

    public String toString() {
        return "BaiduPanoData [pid = " + this.a + ", name=" + this.b + ",x=" + this.c + ", y=" + this.d + ", sdkVersion=" + this.e + ", errorCode=" + this.f + ", hasStreetPano=" + hasStreetPano() + "]";
    }
}
