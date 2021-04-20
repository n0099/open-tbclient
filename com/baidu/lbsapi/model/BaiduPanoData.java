package com.baidu.lbsapi.model;

import android.text.TextUtils;
import com.baidu.pano.platform.c.j;
/* loaded from: classes2.dex */
public class BaiduPanoData {

    /* renamed from: a  reason: collision with root package name */
    public String f6386a;

    /* renamed from: b  reason: collision with root package name */
    public String f6387b;

    /* renamed from: c  reason: collision with root package name */
    public int f6388c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f6389d = 0;

    /* renamed from: e  reason: collision with root package name */
    public String f6390e = j.a();

    /* renamed from: f  reason: collision with root package name */
    public int f6391f = 404;

    /* renamed from: g  reason: collision with root package name */
    public String f6392g = "";

    public String getDescription() {
        return toString();
    }

    public int getErrorCode() {
        return this.f6391f;
    }

    public String getName() {
        return this.f6387b;
    }

    public String getPid() {
        return this.f6386a;
    }

    public int getX() {
        return this.f6388c;
    }

    public int getY() {
        return this.f6389d;
    }

    public boolean hasStreetPano() {
        return !TextUtils.isEmpty(this.f6386a);
    }

    public void setErrorCode(int i) {
        this.f6391f = i;
    }

    public void setName(String str) {
        this.f6387b = str;
    }

    public void setPid(String str) {
        this.f6386a = str;
    }

    public void setX(int i) {
        if (i > 100000000) {
            i /= 100;
        }
        this.f6388c = i;
    }

    public void setY(int i) {
        if (i > 100000000) {
            i /= 100;
        }
        this.f6389d = i;
    }

    public String toString() {
        return "BaiduPanoData [pid = " + this.f6386a + ", name=" + this.f6387b + ",x=" + this.f6388c + ", y=" + this.f6389d + ", sdkVersion=" + this.f6390e + ", errorCode=" + this.f6391f + ", hasStreetPano=" + hasStreetPano() + "]";
    }
}
