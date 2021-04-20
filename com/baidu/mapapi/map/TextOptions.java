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
    public int f7047a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f7049c;

    /* renamed from: d  reason: collision with root package name */
    public String f7050d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f7051e;

    /* renamed from: f  reason: collision with root package name */
    public int f7052f;
    public Typeface i;
    public float l;

    /* renamed from: g  reason: collision with root package name */
    public int f7053g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public int f7054h = 12;
    public int j = 4;
    public int k = 32;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7048b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Text text = new Text();
        text.x = this.f7048b;
        text.w = this.f7047a;
        text.y = this.f7049c;
        text.f7039a = this.f7050d;
        text.f7040b = this.f7051e;
        text.f7041c = this.f7052f;
        text.f7042d = this.f7053g;
        text.f7043e = this.f7054h;
        text.f7044f = this.i;
        text.f7045g = this.j;
        text.f7046h = this.k;
        text.i = this.l;
        return text;
    }

    public TextOptions align(int i, int i2) {
        this.j = i;
        this.k = i2;
        return this;
    }

    public TextOptions bgColor(int i) {
        this.f7052f = i;
        return this;
    }

    public TextOptions extraInfo(Bundle bundle) {
        this.f7049c = bundle;
        return this;
    }

    public TextOptions fontColor(int i) {
        this.f7053g = i;
        return this;
    }

    public TextOptions fontSize(int i) {
        this.f7054h = i;
        return this;
    }

    public float getAlignX() {
        return this.j;
    }

    public float getAlignY() {
        return this.k;
    }

    public int getBgColor() {
        return this.f7052f;
    }

    public Bundle getExtraInfo() {
        return this.f7049c;
    }

    public int getFontColor() {
        return this.f7053g;
    }

    public int getFontSize() {
        return this.f7054h;
    }

    public LatLng getPosition() {
        return this.f7051e;
    }

    public float getRotate() {
        return this.l;
    }

    public String getText() {
        return this.f7050d;
    }

    public Typeface getTypeface() {
        return this.i;
    }

    public int getZIndex() {
        return this.f7047a;
    }

    public boolean isVisible() {
        return this.f7048b;
    }

    public TextOptions position(LatLng latLng) {
        if (latLng != null) {
            this.f7051e = latLng;
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
        this.f7050d = str;
        return this;
    }

    public TextOptions typeface(Typeface typeface) {
        this.i = typeface;
        return this;
    }

    public TextOptions visible(boolean z) {
        this.f7048b = z;
        return this;
    }

    public TextOptions zIndex(int i) {
        this.f7047a = i;
        return this;
    }
}
