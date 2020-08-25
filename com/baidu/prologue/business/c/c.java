package com.baidu.prologue.business.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.prologue.b;
import com.baidu.prologue.image.PrologueImageView;
/* loaded from: classes9.dex */
public class c extends b<com.baidu.prologue.business.b.b> {
    protected PrologueImageView bLD;
    View bLE;
    String bLF;
    protected Bitmap mBitmap;

    public c(Context context) {
        super(context);
        this.bLD = null;
        this.mBitmap = null;
        this.bLE = null;
        this.bLF = "";
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_image;
    }

    @Override // com.baidu.prologue.business.c.a
    public void VH() {
        this.bLD = (PrologueImageView) this.mRootView.findViewById(b.C0279b.splash_ad_image);
        this.bLE = this.mRootView.findViewById(b.C0279b.image_splash_clickable);
        if (this.bLA) {
            com.baidu.prologue.image.d.VT().a(this.bLF, this.bLD);
        } else {
            this.bLD.setImageBitmap(this.mBitmap);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View VE() {
        return this.bLE;
    }

    public void setImageUrl(String str) {
        this.bLF = str;
    }

    public c f(Bitmap bitmap) {
        this.mBitmap = bitmap;
        return this;
    }
}
