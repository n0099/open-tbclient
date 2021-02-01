package com.baidu.lbsapi.panoramaview;

import android.os.Bundle;
import com.baidu.pano.platform.comapi.a.a;
/* loaded from: classes4.dex */
public class TextMarker extends a {

    /* renamed from: a  reason: collision with root package name */
    private String f2511a;

    /* renamed from: b  reason: collision with root package name */
    private int f2512b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    @Override // com.baidu.pano.platform.comapi.a.a
    public Bundle toBundle(String str, Bundle bundle) {
        bundle.putInt("markerType", 1003);
        bundle.putString("text", this.f2511a == null ? "" : this.f2511a);
        bundle.putInt("fontsize", this.f2512b == 0 ? 12 : this.f2512b);
        bundle.putInt("fontcolor", this.c);
        bundle.putInt("bgcolor", this.d);
        bundle.putInt("paddingleft", this.e);
        bundle.putInt("paddingtop", this.f);
        bundle.putInt("paddingright", this.g);
        bundle.putInt("paddingbottom", this.h);
        return super.toBundle(str, bundle);
    }

    public void setText(String str) {
        this.f2511a = str;
    }

    public void setFontSize(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f2512b = i;
    }

    public void setFontColor(int i) {
        this.c = i;
    }

    public void setBgColor(int i) {
        this.d = i;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.e = i;
        this.f = i2;
        this.g = i3;
        this.h = i4;
    }
}
