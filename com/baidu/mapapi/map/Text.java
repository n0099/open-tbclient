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
    public String f7105a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7106b;

    /* renamed from: c  reason: collision with root package name */
    public int f7107c;

    /* renamed from: d  reason: collision with root package name */
    public int f7108d;

    /* renamed from: e  reason: collision with root package name */
    public int f7109e;

    /* renamed from: f  reason: collision with root package name */
    public Typeface f7110f;

    /* renamed from: g  reason: collision with root package name */
    public int f7111g;

    /* renamed from: h  reason: collision with root package name */
    public int f7112h;

    /* renamed from: i  reason: collision with root package name */
    public float f7113i;
    public int j;

    public Text() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.text;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a() {
        Typeface typeface = this.f7110f;
        if (typeface != null) {
            EnvDrawText.removeFontCache(typeface.hashCode());
        }
        return super.a();
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        if (this.f7106b != null) {
            bundle.putString("text", this.f7105a);
            GeoPoint ll2mc = CoordUtil.ll2mc(this.f7106b);
            bundle.putDouble("location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc.getLatitudeE6());
            int i2 = this.f7108d;
            bundle.putInt("font_color", Color.argb(i2 >>> 24, i2 & 255, (i2 >> 8) & 255, (i2 >> 16) & 255));
            int i3 = this.f7107c;
            bundle.putInt("bg_color", Color.argb(i3 >>> 24, i3 & 255, (i3 >> 8) & 255, (i3 >> 16) & 255));
            bundle.putInt("font_size", this.f7109e);
            Typeface typeface = this.f7110f;
            if (typeface != null) {
                EnvDrawText.registFontCache(typeface.hashCode(), this.f7110f);
                bundle.putInt("type_face", this.f7110f.hashCode());
            }
            int i4 = this.f7111g;
            float f2 = 1.0f;
            bundle.putFloat("align_x", i4 != 1 ? i4 != 2 ? 0.5f : 1.0f : 0.0f);
            int i5 = this.f7112h;
            if (i5 == 8) {
                f2 = 0.0f;
            } else if (i5 != 16) {
                f2 = 0.5f;
            }
            bundle.putFloat("align_y", f2);
            bundle.putFloat("rotate", this.f7113i);
            bundle.putInt(IMTrack.DbBuilder.ACTION_UPDATE, this.j);
            return bundle;
        }
        throw new IllegalStateException("BDMapSDKException: when you add a text overlay, you must provide text and the position info.");
    }

    public float getAlignX() {
        return this.f7111g;
    }

    public float getAlignY() {
        return this.f7112h;
    }

    public int getBgColor() {
        return this.f7107c;
    }

    public int getFontColor() {
        return this.f7108d;
    }

    public int getFontSize() {
        return this.f7109e;
    }

    public LatLng getPosition() {
        return this.f7106b;
    }

    public float getRotate() {
        return this.f7113i;
    }

    public String getText() {
        return this.f7105a;
    }

    public Typeface getTypeface() {
        return this.f7110f;
    }

    public void setAlign(int i2, int i3) {
        this.f7111g = i2;
        this.f7112h = i3;
        this.j = 1;
        this.listener.b(this);
    }

    public void setBgColor(int i2) {
        this.f7107c = i2;
        this.j = 1;
        this.listener.b(this);
    }

    public void setFontColor(int i2) {
        this.f7108d = i2;
        this.j = 1;
        this.listener.b(this);
    }

    public void setFontSize(int i2) {
        this.f7109e = i2;
        this.j = 1;
        this.listener.b(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: position can not be null");
        }
        this.f7106b = latLng;
        this.j = 1;
        this.listener.b(this);
    }

    public void setRotate(float f2) {
        this.f7113i = f2;
        this.j = 1;
        this.listener.b(this);
    }

    public void setText(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("BDMapSDKException: text can not be null or empty");
        }
        this.f7105a = str;
        this.j = 1;
        this.listener.b(this);
    }

    public void setTypeface(Typeface typeface) {
        this.f7110f = typeface;
        this.j = 1;
        this.listener.b(this);
    }
}
