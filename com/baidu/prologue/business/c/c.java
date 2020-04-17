package com.baidu.prologue.business.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.prologue.b;
import com.baidu.prologue.image.PrologueImageView;
/* loaded from: classes6.dex */
public class c extends b<com.baidu.prologue.business.b.b> {
    protected PrologueImageView btk;
    View btl;
    String btm;
    protected Bitmap mBitmap;

    public c(Context context) {
        super(context);
        this.btk = null;
        this.mBitmap = null;
        this.btl = null;
        this.btm = "";
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_image;
    }

    @Override // com.baidu.prologue.business.c.a
    public void Mf() {
        this.btk = (PrologueImageView) this.mRootView.findViewById(b.C0194b.splash_ad_image);
        this.btl = this.mRootView.findViewById(b.C0194b.image_splash_clickable);
        if (this.bth) {
            com.baidu.prologue.image.d.Mr().a(this.btm, this.btk);
        } else {
            this.btk.setImageBitmap(this.mBitmap);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View Mb() {
        return this.btl;
    }

    public void setImageUrl(String str) {
        this.btm = str;
    }

    public c f(Bitmap bitmap) {
        this.mBitmap = bitmap;
        return this;
    }
}
