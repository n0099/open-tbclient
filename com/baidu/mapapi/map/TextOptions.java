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
    public int f7298a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f7300c;

    /* renamed from: d  reason: collision with root package name */
    public String f7301d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f7302e;

    /* renamed from: f  reason: collision with root package name */
    public int f7303f;

    /* renamed from: i  reason: collision with root package name */
    public Typeface f7306i;
    public float l;

    /* renamed from: g  reason: collision with root package name */
    public int f7304g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public int f7305h = 12;
    public int j = 4;
    public int k = 32;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7299b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Text text = new Text();
        text.x = this.f7299b;
        text.w = this.f7298a;
        text.y = this.f7300c;
        text.f7289a = this.f7301d;
        text.f7290b = this.f7302e;
        text.f7291c = this.f7303f;
        text.f7292d = this.f7304g;
        text.f7293e = this.f7305h;
        text.f7294f = this.f7306i;
        text.f7295g = this.j;
        text.f7296h = this.k;
        text.f7297i = this.l;
        return text;
    }

    public TextOptions align(int i2, int i3) {
        this.j = i2;
        this.k = i3;
        return this;
    }

    public TextOptions bgColor(int i2) {
        this.f7303f = i2;
        return this;
    }

    public TextOptions extraInfo(Bundle bundle) {
        this.f7300c = bundle;
        return this;
    }

    public TextOptions fontColor(int i2) {
        this.f7304g = i2;
        return this;
    }

    public TextOptions fontSize(int i2) {
        this.f7305h = i2;
        return this;
    }

    public float getAlignX() {
        return this.j;
    }

    public float getAlignY() {
        return this.k;
    }

    public int getBgColor() {
        return this.f7303f;
    }

    public Bundle getExtraInfo() {
        return this.f7300c;
    }

    public int getFontColor() {
        return this.f7304g;
    }

    public int getFontSize() {
        return this.f7305h;
    }

    public LatLng getPosition() {
        return this.f7302e;
    }

    public float getRotate() {
        return this.l;
    }

    public String getText() {
        return this.f7301d;
    }

    public Typeface getTypeface() {
        return this.f7306i;
    }

    public int getZIndex() {
        return this.f7298a;
    }

    public boolean isVisible() {
        return this.f7299b;
    }

    public TextOptions position(LatLng latLng) {
        if (latLng != null) {
            this.f7302e = latLng;
            return this;
        }
        throw new IllegalArgumentException("position can not be null");
    }

    public TextOptions rotate(float f2) {
        this.l = f2;
        return this;
    }

    public TextOptions text(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("text can not be null or empty");
        }
        this.f7301d = str;
        return this;
    }

    public TextOptions typeface(Typeface typeface) {
        this.f7306i = typeface;
        return this;
    }

    public TextOptions visible(boolean z) {
        this.f7299b = z;
        return this;
    }

    public TextOptions zIndex(int i2) {
        this.f7298a = i2;
        return this;
    }
}
