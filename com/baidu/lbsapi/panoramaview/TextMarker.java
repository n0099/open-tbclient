package com.baidu.lbsapi.panoramaview;

import android.os.Bundle;
import com.baidu.pano.platform.comapi.a.a;
/* loaded from: classes2.dex */
public class TextMarker extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f6590a;

    /* renamed from: b  reason: collision with root package name */
    public int f6591b;

    /* renamed from: c  reason: collision with root package name */
    public int f6592c;

    /* renamed from: d  reason: collision with root package name */
    public int f6593d;

    /* renamed from: e  reason: collision with root package name */
    public int f6594e;

    /* renamed from: f  reason: collision with root package name */
    public int f6595f;

    /* renamed from: g  reason: collision with root package name */
    public int f6596g;

    /* renamed from: h  reason: collision with root package name */
    public int f6597h;

    public void setBgColor(int i2) {
        this.f6593d = i2;
    }

    public void setFontColor(int i2) {
        this.f6592c = i2;
    }

    public void setFontSize(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.f6591b = i2;
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        this.f6594e = i2;
        this.f6595f = i3;
        this.f6596g = i4;
        this.f6597h = i5;
    }

    public void setText(String str) {
        this.f6590a = str;
    }

    @Override // com.baidu.pano.platform.comapi.a.a
    public Bundle toBundle(String str, Bundle bundle) {
        bundle.putInt("markerType", 1003);
        String str2 = this.f6590a;
        if (str2 == null) {
            str2 = "";
        }
        bundle.putString("text", str2);
        int i2 = this.f6591b;
        if (i2 == 0) {
            i2 = 12;
        }
        bundle.putInt("fontsize", i2);
        bundle.putInt("fontcolor", this.f6592c);
        bundle.putInt("bgcolor", this.f6593d);
        bundle.putInt("paddingleft", this.f6594e);
        bundle.putInt("paddingtop", this.f6595f);
        bundle.putInt("paddingright", this.f6596g);
        bundle.putInt("paddingbottom", this.f6597h);
        return super.toBundle(str, bundle);
    }
}
