package com.baidu.mapapi.map;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import mapsdkvi.com.gdi.bgl.android.java.EnvDrawText;
/* loaded from: classes2.dex */
public final class Text extends Overlay {
    public static final String k = "Text";

    /* renamed from: a  reason: collision with root package name */
    public String f7039a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7040b;

    /* renamed from: c  reason: collision with root package name */
    public int f7041c;

    /* renamed from: d  reason: collision with root package name */
    public int f7042d;

    /* renamed from: e  reason: collision with root package name */
    public int f7043e;

    /* renamed from: f  reason: collision with root package name */
    public Typeface f7044f;

    /* renamed from: g  reason: collision with root package name */
    public int f7045g;

    /* renamed from: h  reason: collision with root package name */
    public int f7046h;
    public float i;
    public int j;

    public Text() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.text;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a() {
        Typeface typeface = this.f7044f;
        if (typeface != null) {
            EnvDrawText.removeFontCache(typeface.hashCode());
        }
        return super.a();
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        if (this.f7040b != null) {
            bundle.putString("text", this.f7039a);
            GeoPoint ll2mc = CoordUtil.ll2mc(this.f7040b);
            bundle.putDouble("location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc.getLatitudeE6());
            int i = this.f7042d;
            bundle.putInt("font_color", Color.argb(i >>> 24, i & 255, (i >> 8) & 255, (i >> 16) & 255));
            int i2 = this.f7041c;
            bundle.putInt("bg_color", Color.argb(i2 >>> 24, i2 & 255, (i2 >> 8) & 255, (i2 >> 16) & 255));
            bundle.putInt("font_size", this.f7043e);
            Typeface typeface = this.f7044f;
            if (typeface != null) {
                EnvDrawText.registFontCache(typeface.hashCode(), this.f7044f);
                bundle.putInt("type_face", this.f7044f.hashCode());
            }
            int i3 = this.f7045g;
            float f2 = 1.0f;
            bundle.putFloat("align_x", i3 != 1 ? i3 != 2 ? 0.5f : 1.0f : 0.0f);
            int i4 = this.f7046h;
            if (i4 == 8) {
                f2 = 0.0f;
            } else if (i4 != 16) {
                f2 = 0.5f;
            }
            bundle.putFloat("align_y", f2);
            bundle.putFloat("rotate", this.i);
            bundle.putInt(IMTrack.DbBuilder.ACTION_UPDATE, this.j);
            return bundle;
        }
        throw new IllegalStateException("when you add a text overlay, you must provide text and the position info.");
    }

    public float getAlignX() {
        return this.f7045g;
    }

    public float getAlignY() {
        return this.f7046h;
    }

    public int getBgColor() {
        return this.f7041c;
    }

    public int getFontColor() {
        return this.f7042d;
    }

    public int getFontSize() {
        return this.f7043e;
    }

    public LatLng getPosition() {
        return this.f7040b;
    }

    public float getRotate() {
        return this.i;
    }

    public String getText() {
        return this.f7039a;
    }

    public Typeface getTypeface() {
        return this.f7044f;
    }

    public void setAlign(int i, int i2) {
        this.f7045g = i;
        this.f7046h = i2;
        this.j = 1;
        this.listener.b(this);
    }

    public void setBgColor(int i) {
        this.f7041c = i;
        this.j = 1;
        this.listener.b(this);
    }

    public void setFontColor(int i) {
        this.f7042d = i;
        this.j = 1;
        this.listener.b(this);
    }

    public void setFontSize(int i) {
        this.f7043e = i;
        this.j = 1;
        this.listener.b(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("position can not be null");
        }
        this.f7040b = latLng;
        this.j = 1;
        this.listener.b(this);
    }

    public void setRotate(float f2) {
        this.i = f2;
        this.j = 1;
        this.listener.b(this);
    }

    public void setText(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("text can not be null or empty");
        }
        this.f7039a = str;
        this.j = 1;
        this.listener.b(this);
    }

    public void setTypeface(Typeface typeface) {
        this.f7044f = typeface;
        this.j = 1;
        this.listener.b(this);
    }
}
