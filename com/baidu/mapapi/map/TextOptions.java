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
    public int f7114a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f7116c;

    /* renamed from: d  reason: collision with root package name */
    public String f7117d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f7118e;

    /* renamed from: f  reason: collision with root package name */
    public int f7119f;

    /* renamed from: i  reason: collision with root package name */
    public Typeface f7122i;
    public float l;

    /* renamed from: g  reason: collision with root package name */
    public int f7120g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public int f7121h = 12;
    public int j = 4;
    public int k = 32;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7115b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Text text = new Text();
        text.A = this.f7115b;
        text.z = this.f7114a;
        text.B = this.f7116c;
        text.f7105a = this.f7117d;
        text.f7106b = this.f7118e;
        text.f7107c = this.f7119f;
        text.f7108d = this.f7120g;
        text.f7109e = this.f7121h;
        text.f7110f = this.f7122i;
        text.f7111g = this.j;
        text.f7112h = this.k;
        text.f7113i = this.l;
        return text;
    }

    public TextOptions align(int i2, int i3) {
        this.j = i2;
        this.k = i3;
        return this;
    }

    public TextOptions bgColor(int i2) {
        this.f7119f = i2;
        return this;
    }

    public TextOptions extraInfo(Bundle bundle) {
        this.f7116c = bundle;
        return this;
    }

    public TextOptions fontColor(int i2) {
        this.f7120g = i2;
        return this;
    }

    public TextOptions fontSize(int i2) {
        this.f7121h = i2;
        return this;
    }

    public float getAlignX() {
        return this.j;
    }

    public float getAlignY() {
        return this.k;
    }

    public int getBgColor() {
        return this.f7119f;
    }

    public Bundle getExtraInfo() {
        return this.f7116c;
    }

    public int getFontColor() {
        return this.f7120g;
    }

    public int getFontSize() {
        return this.f7121h;
    }

    public LatLng getPosition() {
        return this.f7118e;
    }

    public float getRotate() {
        return this.l;
    }

    public String getText() {
        return this.f7117d;
    }

    public Typeface getTypeface() {
        return this.f7122i;
    }

    public int getZIndex() {
        return this.f7114a;
    }

    public boolean isVisible() {
        return this.f7115b;
    }

    public TextOptions position(LatLng latLng) {
        if (latLng != null) {
            this.f7118e = latLng;
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
        this.f7117d = str;
        return this;
    }

    public TextOptions typeface(Typeface typeface) {
        this.f7122i = typeface;
        return this;
    }

    public TextOptions visible(boolean z) {
        this.f7115b = z;
        return this;
    }

    public TextOptions zIndex(int i2) {
        this.f7114a = i2;
        return this;
    }
}
