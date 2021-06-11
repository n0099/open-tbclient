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
    public int f7057a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f7059c;

    /* renamed from: d  reason: collision with root package name */
    public String f7060d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f7061e;

    /* renamed from: f  reason: collision with root package name */
    public int f7062f;

    /* renamed from: i  reason: collision with root package name */
    public Typeface f7065i;
    public float l;

    /* renamed from: g  reason: collision with root package name */
    public int f7063g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public int f7064h = 12;
    public int j = 4;
    public int k = 32;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7058b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Text text = new Text();
        text.A = this.f7058b;
        text.z = this.f7057a;
        text.B = this.f7059c;
        text.f7048a = this.f7060d;
        text.f7049b = this.f7061e;
        text.f7050c = this.f7062f;
        text.f7051d = this.f7063g;
        text.f7052e = this.f7064h;
        text.f7053f = this.f7065i;
        text.f7054g = this.j;
        text.f7055h = this.k;
        text.f7056i = this.l;
        return text;
    }

    public TextOptions align(int i2, int i3) {
        this.j = i2;
        this.k = i3;
        return this;
    }

    public TextOptions bgColor(int i2) {
        this.f7062f = i2;
        return this;
    }

    public TextOptions extraInfo(Bundle bundle) {
        this.f7059c = bundle;
        return this;
    }

    public TextOptions fontColor(int i2) {
        this.f7063g = i2;
        return this;
    }

    public TextOptions fontSize(int i2) {
        this.f7064h = i2;
        return this;
    }

    public float getAlignX() {
        return this.j;
    }

    public float getAlignY() {
        return this.k;
    }

    public int getBgColor() {
        return this.f7062f;
    }

    public Bundle getExtraInfo() {
        return this.f7059c;
    }

    public int getFontColor() {
        return this.f7063g;
    }

    public int getFontSize() {
        return this.f7064h;
    }

    public LatLng getPosition() {
        return this.f7061e;
    }

    public float getRotate() {
        return this.l;
    }

    public String getText() {
        return this.f7060d;
    }

    public Typeface getTypeface() {
        return this.f7065i;
    }

    public int getZIndex() {
        return this.f7057a;
    }

    public boolean isVisible() {
        return this.f7058b;
    }

    public TextOptions position(LatLng latLng) {
        if (latLng != null) {
            this.f7061e = latLng;
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
        this.f7060d = str;
        return this;
    }

    public TextOptions typeface(Typeface typeface) {
        this.f7065i = typeface;
        return this;
    }

    public TextOptions visible(boolean z) {
        this.f7058b = z;
        return this;
    }

    public TextOptions zIndex(int i2) {
        this.f7057a = i2;
        return this;
    }
}
