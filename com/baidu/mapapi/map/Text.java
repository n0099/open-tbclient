package com.baidu.mapapi.map;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import vi.com.gdi.bgl.android.java.EnvDrawText;
/* loaded from: classes3.dex */
public final class Text extends Overlay {
    private static final String k = Text.class.getSimpleName();
    String a;
    LatLng b;
    int c;
    int d;
    int e;
    Typeface f;
    int g;
    int h;
    float i;
    int j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Text() {
        this.type = com.baidu.mapsdkplatform.comapi.map.i.text;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a() {
        if (this.f != null) {
            EnvDrawText.removeFontCache(this.f.hashCode());
        }
        return super.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        float f;
        float f2 = 0.5f;
        super.a(bundle);
        if (this.b == null) {
            throw new IllegalStateException("BDMapSDKException: when you add a text overlay, you must provide text and the position info.");
        }
        bundle.putString("text", this.a);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.b);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("font_color", Color.argb(this.d >>> 24, this.d & 255, (this.d >> 8) & 255, (this.d >> 16) & 255));
        bundle.putInt("bg_color", Color.argb(this.c >>> 24, this.c & 255, (this.c >> 8) & 255, (this.c >> 16) & 255));
        bundle.putInt(SharedPrefConfig.PREFS_FONT_SIZE, this.e);
        if (this.f != null) {
            EnvDrawText.registFontCache(this.f.hashCode(), this.f);
            bundle.putInt("type_face", this.f.hashCode());
        }
        switch (this.g) {
            case 1:
                f = 0.0f;
                break;
            case 2:
                f = 1.0f;
                break;
            case 3:
            default:
                f = 0.5f;
                break;
            case 4:
                f = 0.5f;
                break;
        }
        bundle.putFloat("align_x", f);
        switch (this.h) {
            case 8:
                f2 = 0.0f;
                break;
            case 16:
                f2 = 1.0f;
                break;
        }
        bundle.putFloat("align_y", f2);
        bundle.putFloat(RotateImageAction.ACTION_NAME, this.i);
        bundle.putInt(IMTrack.DbBuilder.ACTION_UPDATE, this.j);
        return bundle;
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

    public void setAlign(int i, int i2) {
        this.g = i;
        this.h = i2;
        this.j = 1;
        this.listener.b(this);
    }

    public void setBgColor(int i) {
        this.c = i;
        this.j = 1;
        this.listener.b(this);
    }

    public void setFontColor(int i) {
        this.d = i;
        this.j = 1;
        this.listener.b(this);
    }

    public void setFontSize(int i) {
        this.e = i;
        this.j = 1;
        this.listener.b(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: position can not be null");
        }
        this.b = latLng;
        this.j = 1;
        this.listener.b(this);
    }

    public void setRotate(float f) {
        this.i = f;
        this.j = 1;
        this.listener.b(this);
    }

    public void setText(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("BDMapSDKException: text can not be null or empty");
        }
        this.a = str;
        this.j = 1;
        this.listener.b(this);
    }

    public void setTypeface(Typeface typeface) {
        this.f = typeface;
        this.j = 1;
        this.listener.b(this);
    }
}
