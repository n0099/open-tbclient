package com.baidu.prologue.business.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.prologue.b;
import com.baidu.prologue.image.PrologueImageView;
/* loaded from: classes6.dex */
public class c extends b<com.baidu.prologue.business.b.b> {
    protected PrologueImageView bAR;
    View bAS;
    String bAT;
    protected Bitmap mBitmap;

    public c(Context context) {
        super(context);
        this.bAR = null;
        this.mBitmap = null;
        this.bAS = null;
        this.bAT = "";
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_image;
    }

    @Override // com.baidu.prologue.business.c.a
    public void Or() {
        this.bAR = (PrologueImageView) this.mRootView.findViewById(b.C0249b.splash_ad_image);
        this.bAS = this.mRootView.findViewById(b.C0249b.image_splash_clickable);
        if (this.bAO) {
            com.baidu.prologue.image.d.OD().a(this.bAT, this.bAR);
        } else {
            this.bAR.setImageBitmap(this.mBitmap);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View On() {
        return this.bAS;
    }

    public void setImageUrl(String str) {
        this.bAT = str;
    }

    public c f(Bitmap bitmap) {
        this.mBitmap = bitmap;
        return this;
    }
}
