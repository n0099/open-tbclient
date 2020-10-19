package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
/* loaded from: classes7.dex */
public class OverlayLocationData {

    /* renamed from: a  reason: collision with root package name */
    private String f2887a;
    private Bitmap b;
    private int c;
    private int d;
    private int e;

    public Bitmap getImage() {
        return this.b;
    }

    public int getImgHeight() {
        return this.d;
    }

    public String getImgName() {
        return this.f2887a;
    }

    public int getImgWidth() {
        return this.c;
    }

    public int isRotation() {
        return this.e;
    }

    public void setImage(Bitmap bitmap) {
        this.b = bitmap;
    }

    public void setImgHeight(int i) {
        this.d = i;
    }

    public void setImgName(String str) {
        this.f2887a = str;
    }

    public void setImgWidth(int i) {
        this.c = i;
    }

    public void setRotation(int i) {
        this.e = i;
    }
}
