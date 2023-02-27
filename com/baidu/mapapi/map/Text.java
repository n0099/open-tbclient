package com.baidu.mapapi.map;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import vi.com.gdi.bgl.android.java.EnvDrawText;
/* loaded from: classes2.dex */
public final class Text extends Overlay {
    public static final String k = "Text";
    public String a;
    public LatLng b;
    public int c;
    public int d;
    public int e;
    public Typeface f;
    public int g;
    public int h;
    public float i;
    public int j;

    public Text() {
        this.type = com.baidu.mapsdkplatform.comapi.map.i.e;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a() {
        Typeface typeface = this.f;
        if (typeface != null) {
            EnvDrawText.removeFontCache(typeface.hashCode());
        }
        return super.a();
    }

    public float getAlignX() {
        return this.g;
    }

    public float getAlignY() {
        return this.h;
    }

    public int getBgColor() {
        return this.c;
    }

    public int getFontColor() {
        return this.d;
    }

    public int getFontSize() {
        return this.e;
    }

    public LatLng getPosition() {
        return this.b;
    }

    public float getRotate() {
        return this.i;
    }

    public String getText() {
        return this.a;
    }

    public Typeface getTypeface() {
        return this.f;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        float f;
        super.a(bundle);
        if (this.b != null) {
            bundle.putString("text", this.a);
            GeoPoint ll2mc = CoordUtil.ll2mc(this.b);
            bundle.putDouble("location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc.getLatitudeE6());
            int i = this.d;
            int i2 = (i >> 8) & 255;
            bundle.putInt("font_color", Color.argb(i >>> 24, i & 255, i2, (i >> 16) & 255));
            int i3 = this.c;
            int i4 = (i3 >> 8) & 255;
            bundle.putInt("bg_color", Color.argb(i3 >>> 24, i3 & 255, i4, (i3 >> 16) & 255));
            bundle.putInt("font_size", this.e);
            Typeface typeface = this.f;
            if (typeface != null) {
                EnvDrawText.registFontCache(typeface.hashCode(), this.f);
                bundle.putInt("type_face", this.f.hashCode());
            }
            int i5 = this.g;
            float f2 = 1.0f;
            if (i5 != 1) {
                if (i5 != 2) {
                    f = 0.5f;
                } else {
                    f = 1.0f;
                }
            } else {
                f = 0.0f;
            }
            bundle.putFloat("align_x", f);
            int i6 = this.h;
            if (i6 != 8) {
                if (i6 != 16) {
                    f2 = 0.5f;
                }
            } else {
                f2 = 0.0f;
            }
            bundle.putFloat("align_y", f2);
            bundle.putFloat("rotate", this.i);
            bundle.putInt(StickerDataChangeType.UPDATE, this.j);
            return bundle;
        }
        throw new IllegalStateException("BDMapSDKException: when you add a text overlay, you must provide text and the position info.");
    }

    public void setAlign(int i, int i2) {
        this.g = i;
        this.h = i2;
        this.j = 1;
        this.listener.c(this);
    }

    public void setBgColor(int i) {
        this.c = i;
        this.j = 1;
        this.listener.c(this);
    }

    public void setFontColor(int i) {
        this.d = i;
        this.j = 1;
        this.listener.c(this);
    }

    public void setFontSize(int i) {
        this.e = i;
        this.j = 1;
        this.listener.c(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng != null) {
            this.b = latLng;
            this.j = 1;
            this.listener.c(this);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: position can not be null");
    }

    public void setRotate(float f) {
        this.i = f;
        this.j = 1;
        this.listener.c(this);
    }

    public void setText(String str) {
        if (str != null && !str.equals("")) {
            this.a = str;
            this.j = 1;
            this.listener.c(this);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: text can not be null or empty");
    }

    public void setTypeface(Typeface typeface) {
        this.f = typeface;
        this.j = 1;
        this.listener.c(this);
    }
}
