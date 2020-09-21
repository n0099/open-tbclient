package com.baidu.prologue.business.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.prologue.b;
import com.baidu.prologue.image.PrologueImageView;
/* loaded from: classes10.dex */
public class c extends b<com.baidu.prologue.business.b.b> {
    protected PrologueImageView bNH;
    View bNI;
    String bNJ;
    protected Bitmap mBitmap;

    public c(Context context) {
        super(context);
        this.bNH = null;
        this.mBitmap = null;
        this.bNI = null;
        this.bNJ = "";
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_image;
    }

    @Override // com.baidu.prologue.business.c.a
    public void Wq() {
        this.bNH = (PrologueImageView) this.mRootView.findViewById(b.C0277b.splash_ad_image);
        this.bNI = this.mRootView.findViewById(b.C0277b.image_splash_clickable);
        if (this.bNE) {
            com.baidu.prologue.image.d.WC().a(this.bNJ, this.bNH);
        } else {
            this.bNH.setImageBitmap(this.mBitmap);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View Wn() {
        return this.bNI;
    }

    public void setImageUrl(String str) {
        this.bNJ = str;
    }

    public c f(Bitmap bitmap) {
        this.mBitmap = bitmap;
        return this;
    }
}
