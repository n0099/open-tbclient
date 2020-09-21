package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
/* loaded from: classes3.dex */
public class OverlayLocationData {
    private String a;
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
        return this.a;
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
        this.a = str;
    }

    public void setImgWidth(int i) {
        this.c = i;
    }

    public void setRotation(int i) {
        this.e = i;
    }
}
