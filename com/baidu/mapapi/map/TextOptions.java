package com.baidu.mapapi.map;

import android.graphics.Typeface;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes3.dex */
public final class TextOptions extends OverlayOptions {
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;
    public int a;
    public Bundle c;
    public String d;
    public LatLng e;
    public int f;
    public Typeface i;
    public float l;
    public int g = -16777216;
    public int h = 12;
    public int j = 4;
    public int k = 32;
    public boolean b = true;

    public float getAlignX() {
        return this.j;
    }

    public float getAlignY() {
        return this.k;
    }

    public int getBgColor() {
        return this.f;
    }

    public Bundle getExtraInfo() {
        return this.c;
    }

    public int getFontColor() {
        return this.g;
    }

    public int getFontSize() {
        return this.h;
    }

    public LatLng getPosition() {
        return this.e;
    }

    public float getRotate() {
        return this.l;
    }

    public String getText() {
        return this.d;
    }

    public Typeface getTypeface() {
        return this.i;
    }

    public int getZIndex() {
        return this.a;
    }

    public boolean isVisible() {
        return this.b;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Text text = new Text();
        text.H = this.b;
        text.G = this.a;
        text.I = this.c;
        text.a = this.d;
        text.b = this.e;
        text.c = this.f;
        text.d = this.g;
        text.e = this.h;
        text.f = this.i;
        text.g = this.j;
        text.h = this.k;
        text.i = this.l;
        return text;
    }

    public TextOptions align(int i, int i2) {
        this.j = i;
        this.k = i2;
        return this;
    }

    public TextOptions bgColor(int i) {
        this.f = i;
        return this;
    }

    public TextOptions extraInfo(Bundle bundle) {
        this.c = bundle;
        return this;
    }

    public TextOptions fontColor(int i) {
        this.g = i;
        return this;
    }

    public TextOptions fontSize(int i) {
        this.h = i;
        return this;
    }

    public TextOptions position(LatLng latLng) {
        if (latLng != null) {
            this.e = latLng;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: position can not be null");
    }

    public TextOptions rotate(float f) {
        this.l = f;
        return this;
    }

    public TextOptions text(String str) {
        if (str != null && !str.equals("")) {
            this.d = str;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: text can not be null or empty");
    }

    public TextOptions typeface(Typeface typeface) {
        this.i = typeface;
        return this;
    }

    public TextOptions visible(boolean z) {
        this.b = z;
        return this;
    }

    public TextOptions zIndex(int i) {
        this.a = i;
        return this;
    }
}
