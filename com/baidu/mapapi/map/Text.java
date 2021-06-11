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
    public String f7048a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7049b;

    /* renamed from: c  reason: collision with root package name */
    public int f7050c;

    /* renamed from: d  reason: collision with root package name */
    public int f7051d;

    /* renamed from: e  reason: collision with root package name */
    public int f7052e;

    /* renamed from: f  reason: collision with root package name */
    public Typeface f7053f;

    /* renamed from: g  reason: collision with root package name */
    public int f7054g;

    /* renamed from: h  reason: collision with root package name */
    public int f7055h;

    /* renamed from: i  reason: collision with root package name */
    public float f7056i;
    public int j;

    public Text() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.text;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a() {
        Typeface typeface = this.f7053f;
        if (typeface != null) {
            EnvDrawText.removeFontCache(typeface.hashCode());
        }
        return super.a();
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        if (this.f7049b != null) {
            bundle.putString("text", this.f7048a);
            GeoPoint ll2mc = CoordUtil.ll2mc(this.f7049b);
            bundle.putDouble("location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc.getLatitudeE6());
            int i2 = this.f7051d;
            bundle.putInt("font_color", Color.argb(i2 >>> 24, i2 & 255, (i2 >> 8) & 255, (i2 >> 16) & 255));
            int i3 = this.f7050c;
            bundle.putInt("bg_color", Color.argb(i3 >>> 24, i3 & 255, (i3 >> 8) & 255, (i3 >> 16) & 255));
            bundle.putInt("font_size", this.f7052e);
            Typeface typeface = this.f7053f;
            if (typeface != null) {
                EnvDrawText.registFontCache(typeface.hashCode(), this.f7053f);
                bundle.putInt("type_face", this.f7053f.hashCode());
            }
            int i4 = this.f7054g;
            float f2 = 1.0f;
            bundle.putFloat("align_x", i4 != 1 ? i4 != 2 ? 0.5f : 1.0f : 0.0f);
            int i5 = this.f7055h;
            if (i5 == 8) {
                f2 = 0.0f;
            } else if (i5 != 16) {
                f2 = 0.5f;
            }
            bundle.putFloat("align_y", f2);
            bundle.putFloat("rotate", this.f7056i);
            bundle.putInt(IMTrack.DbBuilder.ACTION_UPDATE, this.j);
            return bundle;
        }
        throw new IllegalStateException("BDMapSDKException: when you add a text overlay, you must provide text and the position info.");
    }

    public float getAlignX() {
        return this.f7054g;
    }

    public float getAlignY() {
        return this.f7055h;
    }

    public int getBgColor() {
        return this.f7050c;
    }

    public int getFontColor() {
        return this.f7051d;
    }

    public int getFontSize() {
        return this.f7052e;
    }

    public LatLng getPosition() {
        return this.f7049b;
    }

    public float getRotate() {
        return this.f7056i;
    }

    public String getText() {
        return this.f7048a;
    }

    public Typeface getTypeface() {
        return this.f7053f;
    }

    public void setAlign(int i2, int i3) {
        this.f7054g = i2;
        this.f7055h = i3;
        this.j = 1;
        this.listener.b(this);
    }

    public void setBgColor(int i2) {
        this.f7050c = i2;
        this.j = 1;
        this.listener.b(this);
    }

    public void setFontColor(int i2) {
        this.f7051d = i2;
        this.j = 1;
        this.listener.b(this);
    }

    public void setFontSize(int i2) {
        this.f7052e = i2;
        this.j = 1;
        this.listener.b(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: position can not be null");
        }
        this.f7049b = latLng;
        this.j = 1;
        this.listener.b(this);
    }

    public void setRotate(float f2) {
        this.f7056i = f2;
        this.j = 1;
        this.listener.b(this);
    }

    public void setText(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("BDMapSDKException: text can not be null or empty");
        }
        this.f7048a = str;
        this.j = 1;
        this.listener.b(this);
    }

    public void setTypeface(Typeface typeface) {
        this.f7053f = typeface;
        this.j = 1;
        this.listener.b(this);
    }
}
