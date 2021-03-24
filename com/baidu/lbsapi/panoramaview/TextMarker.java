package com.baidu.lbsapi.panoramaview;

import android.os.Bundle;
import com.baidu.pano.platform.comapi.a.a;
/* loaded from: classes2.dex */
public class TextMarker extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f6369a;

    /* renamed from: b  reason: collision with root package name */
    public int f6370b;

    /* renamed from: c  reason: collision with root package name */
    public int f6371c;

    /* renamed from: d  reason: collision with root package name */
    public int f6372d;

    /* renamed from: e  reason: collision with root package name */
    public int f6373e;

    /* renamed from: f  reason: collision with root package name */
    public int f6374f;

    /* renamed from: g  reason: collision with root package name */
    public int f6375g;

    /* renamed from: h  reason: collision with root package name */
    public int f6376h;

    public void setBgColor(int i) {
        this.f6372d = i;
    }

    public void setFontColor(int i) {
        this.f6371c = i;
    }

    public void setFontSize(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f6370b = i;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f6373e = i;
        this.f6374f = i2;
        this.f6375g = i3;
        this.f6376h = i4;
    }

    public void setText(String str) {
        this.f6369a = str;
    }

    @Override // com.baidu.pano.platform.comapi.a.a
    public Bundle toBundle(String str, Bundle bundle) {
        bundle.putInt("markerType", 1003);
        String str2 = this.f6369a;
        if (str2 == null) {
            str2 = "";
        }
        bundle.putString("text", str2);
        int i = this.f6370b;
        if (i == 0) {
            i = 12;
        }
        bundle.putInt("fontsize", i);
        bundle.putInt("fontcolor", this.f6371c);
        bundle.putInt("bgcolor", this.f6372d);
        bundle.putInt("paddingleft", this.f6373e);
        bundle.putInt("paddingtop", this.f6374f);
        bundle.putInt("paddingright", this.f6375g);
        bundle.putInt("paddingbottom", this.f6376h);
        return super.toBundle(str, bundle);
    }
}
