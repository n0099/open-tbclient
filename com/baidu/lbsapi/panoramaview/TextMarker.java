package com.baidu.lbsapi.panoramaview;

import android.os.Bundle;
import com.baidu.pano.platform.comapi.a.a;
/* loaded from: classes2.dex */
public class TextMarker extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f6405a;

    /* renamed from: b  reason: collision with root package name */
    public int f6406b;

    /* renamed from: c  reason: collision with root package name */
    public int f6407c;

    /* renamed from: d  reason: collision with root package name */
    public int f6408d;

    /* renamed from: e  reason: collision with root package name */
    public int f6409e;

    /* renamed from: f  reason: collision with root package name */
    public int f6410f;

    /* renamed from: g  reason: collision with root package name */
    public int f6411g;

    /* renamed from: h  reason: collision with root package name */
    public int f6412h;

    public void setBgColor(int i) {
        this.f6408d = i;
    }

    public void setFontColor(int i) {
        this.f6407c = i;
    }

    public void setFontSize(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f6406b = i;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f6409e = i;
        this.f6410f = i2;
        this.f6411g = i3;
        this.f6412h = i4;
    }

    public void setText(String str) {
        this.f6405a = str;
    }

    @Override // com.baidu.pano.platform.comapi.a.a
    public Bundle toBundle(String str, Bundle bundle) {
        bundle.putInt("markerType", 1003);
        String str2 = this.f6405a;
        if (str2 == null) {
            str2 = "";
        }
        bundle.putString("text", str2);
        int i = this.f6406b;
        if (i == 0) {
            i = 12;
        }
        bundle.putInt("fontsize", i);
        bundle.putInt("fontcolor", this.f6407c);
        bundle.putInt("bgcolor", this.f6408d);
        bundle.putInt("paddingleft", this.f6409e);
        bundle.putInt("paddingtop", this.f6410f);
        bundle.putInt("paddingright", this.f6411g);
        bundle.putInt("paddingbottom", this.f6412h);
        return super.toBundle(str, bundle);
    }
}
