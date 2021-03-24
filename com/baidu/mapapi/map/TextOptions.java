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
    public int f7011a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f7013c;

    /* renamed from: d  reason: collision with root package name */
    public String f7014d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f7015e;

    /* renamed from: f  reason: collision with root package name */
    public int f7016f;
    public Typeface i;
    public float l;

    /* renamed from: g  reason: collision with root package name */
    public int f7017g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public int f7018h = 12;
    public int j = 4;
    public int k = 32;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7012b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Text text = new Text();
        text.x = this.f7012b;
        text.w = this.f7011a;
        text.y = this.f7013c;
        text.f7003a = this.f7014d;
        text.f7004b = this.f7015e;
        text.f7005c = this.f7016f;
        text.f7006d = this.f7017g;
        text.f7007e = this.f7018h;
        text.f7008f = this.i;
        text.f7009g = this.j;
        text.f7010h = this.k;
        text.i = this.l;
        return text;
    }

    public TextOptions align(int i, int i2) {
        this.j = i;
        this.k = i2;
        return this;
    }

    public TextOptions bgColor(int i) {
        this.f7016f = i;
        return this;
    }

    public TextOptions extraInfo(Bundle bundle) {
        this.f7013c = bundle;
        return this;
    }

    public TextOptions fontColor(int i) {
        this.f7017g = i;
        return this;
    }

    public TextOptions fontSize(int i) {
        this.f7018h = i;
        return this;
    }

    public float getAlignX() {
        return this.j;
    }

    public float getAlignY() {
        return this.k;
    }

    public int getBgColor() {
        return this.f7016f;
    }

    public Bundle getExtraInfo() {
        return this.f7013c;
    }

    public int getFontColor() {
        return this.f7017g;
    }

    public int getFontSize() {
        return this.f7018h;
    }

    public LatLng getPosition() {
        return this.f7015e;
    }

    public float getRotate() {
        return this.l;
    }

    public String getText() {
        return this.f7014d;
    }

    public Typeface getTypeface() {
        return this.i;
    }

    public int getZIndex() {
        return this.f7011a;
    }

    public boolean isVisible() {
        return this.f7012b;
    }

    public TextOptions position(LatLng latLng) {
        if (latLng != null) {
            this.f7015e = latLng;
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
        this.f7014d = str;
        return this;
    }

    public TextOptions typeface(Typeface typeface) {
        this.i = typeface;
        return this;
    }

    public TextOptions visible(boolean z) {
        this.f7012b = z;
        return this;
    }

    public TextOptions zIndex(int i) {
        this.f7011a = i;
        return this;
    }
}
