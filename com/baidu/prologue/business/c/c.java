package com.baidu.prologue.business.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.prologue.b;
import com.baidu.prologue.image.PrologueImageView;
/* loaded from: classes9.dex */
public class c extends b<com.baidu.prologue.business.b.b> {
    protected PrologueImageView bLH;
    View bLI;
    String bLJ;
    protected Bitmap mBitmap;

    public c(Context context) {
        super(context);
        this.bLH = null;
        this.mBitmap = null;
        this.bLI = null;
        this.bLJ = "";
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_image;
    }

    @Override // com.baidu.prologue.business.c.a
    public void VH() {
        this.bLH = (PrologueImageView) this.mRootView.findViewById(b.C0279b.splash_ad_image);
        this.bLI = this.mRootView.findViewById(b.C0279b.image_splash_clickable);
        if (this.bLE) {
            com.baidu.prologue.image.d.VT().a(this.bLJ, this.bLH);
        } else {
            this.bLH.setImageBitmap(this.mBitmap);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View VE() {
        return this.bLI;
    }

    public void setImageUrl(String str) {
        this.bLJ = str;
    }

    public c f(Bitmap bitmap) {
        this.mBitmap = bitmap;
        return this;
    }
}
