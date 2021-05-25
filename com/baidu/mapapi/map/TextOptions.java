package com.baidu.mapapi.map;

import android.graphics.Typeface;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class TextOptions extends OverlayOptions {
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;

    /* renamed from: a  reason: collision with root package name */
    public int f7014a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f7016c;

    /* renamed from: d  reason: collision with root package name */
    public String f7017d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f7018e;

    /* renamed from: f  reason: collision with root package name */
    public int f7019f;

    /* renamed from: i  reason: collision with root package name */
    public Typeface f7022i;
    public float l;

    /* renamed from: g  reason: collision with root package name */
    public int f7020g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public int f7021h = 12;
    public int j = 4;
    public int k = 32;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7015b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Text text = new Text();
        text.A = this.f7015b;
        text.z = this.f7014a;
        text.B = this.f7016c;
        text.f7005a = this.f7017d;
        text.f7006b = this.f7018e;
        text.f7007c = this.f7019f;
        text.f7008d = this.f7020g;
        text.f7009e = this.f7021h;
        text.f7010f = this.f7022i;
        text.f7011g = this.j;
        text.f7012h = this.k;
        text.f7013i = this.l;
        return text;
    }

    public TextOptions align(int i2, int i3) {
        this.j = i2;
        this.k = i3;
        return this;
    }

    public TextOptions bgColor(int i2) {
        this.f7019f = i2;
        return this;
    }

    public TextOptions extraInfo(Bundle bundle) {
        this.f7016c = bundle;
        return this;
    }

    public TextOptions fontColor(int i2) {
        this.f7020g = i2;
        return this;
    }

    public TextOptions fontSize(int i2) {
        this.f7021h = i2;
        return this;
    }

    public float getAlignX() {
        return this.j;
    }

    public float getAlignY() {
        return this.k;
    }

    public int getBgColor() {
        return this.f7019f;
    }

    public Bundle getExtraInfo() {
        return this.f7016c;
    }

    public int getFontColor() {
        return this.f7020g;
    }

    public int getFontSize() {
        return this.f7021h;
    }

    public LatLng getPosition() {
        return this.f7018e;
    }

    public float getRotate() {
        return this.l;
    }

    public String getText() {
        return this.f7017d;
    }

    public Typeface getTypeface() {
        return this.f7022i;
    }

    public int getZIndex() {
        return this.f7014a;
    }

    public boolean isVisible() {
        return this.f7015b;
    }

    public TextOptions position(LatLng latLng) {
        if (latLng != null) {
            this.f7018e = latLng;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: position can not be null");
    }

    public TextOptions rotate(float f2) {
        this.l = f2;
        return this;
    }

    public TextOptions text(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("BDMapSDKException: text can not be null or empty");
        }
        this.f7017d = str;
        return this;
    }

    public TextOptions typeface(Typeface typeface) {
        this.f7022i = typeface;
        return this;
    }

    public TextOptions visible(boolean z) {
        this.f7015b = z;
        return this;
    }

    public TextOptions zIndex(int i2) {
        this.f7014a = i2;
        return this;
    }
}
