package com.baidu.lbsapi.panoramaview;

import android.os.Bundle;
import com.baidu.pano.platform.comapi.a.a;
/* loaded from: classes2.dex */
public class TextMarker extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f6370a;

    /* renamed from: b  reason: collision with root package name */
    public int f6371b;

    /* renamed from: c  reason: collision with root package name */
    public int f6372c;

    /* renamed from: d  reason: collision with root package name */
    public int f6373d;

    /* renamed from: e  reason: collision with root package name */
    public int f6374e;

    /* renamed from: f  reason: collision with root package name */
    public int f6375f;

    /* renamed from: g  reason: collision with root package name */
    public int f6376g;

    /* renamed from: h  reason: collision with root package name */
    public int f6377h;

    public void setBgColor(int i) {
        this.f6373d = i;
    }

    public void setFontColor(int i) {
        this.f6372c = i;
    }

    public void setFontSize(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f6371b = i;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f6374e = i;
        this.f6375f = i2;
        this.f6376g = i3;
        this.f6377h = i4;
    }

    public void setText(String str) {
        this.f6370a = str;
    }

    @Override // com.baidu.pano.platform.comapi.a.a
    public Bundle toBundle(String str, Bundle bundle) {
        bundle.putInt("markerType", 1003);
        String str2 = this.f6370a;
        if (str2 == null) {
            str2 = "";
        }
        bundle.putString("text", str2);
        int i = this.f6371b;
        if (i == 0) {
            i = 12;
        }
        bundle.putInt("fontsize", i);
        bundle.putInt("fontcolor", this.f6372c);
        bundle.putInt("bgcolor", this.f6373d);
        bundle.putInt("paddingleft", this.f6374e);
        bundle.putInt("paddingtop", this.f6375f);
        bundle.putInt("paddingright", this.f6376g);
        bundle.putInt("paddingbottom", this.f6377h);
        return super.toBundle(str, bundle);
    }
}
