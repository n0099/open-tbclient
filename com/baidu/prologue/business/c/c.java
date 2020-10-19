package com.baidu.prologue.business.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.prologue.b;
import com.baidu.prologue.image.PrologueImageView;
/* loaded from: classes19.dex */
public class c extends b<com.baidu.prologue.business.b.b> {
    protected PrologueImageView bUq;
    View bUr;
    String bUs;
    protected Bitmap mBitmap;

    public c(Context context) {
        super(context);
        this.bUq = null;
        this.mBitmap = null;
        this.bUr = null;
        this.bUs = "";
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_image;
    }

    @Override // com.baidu.prologue.business.c.a
    public void Yn() {
        this.bUq = (PrologueImageView) this.mRootView.findViewById(b.C0292b.splash_ad_image);
        this.bUr = this.mRootView.findViewById(b.C0292b.image_splash_clickable);
        if (this.bUn) {
            com.baidu.prologue.image.d.Yz().a(this.bUs, this.bUq);
        } else {
            this.bUq.setImageBitmap(this.mBitmap);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View Yk() {
        return this.bUr;
    }

    public void setImageUrl(String str) {
        this.bUs = str;
    }

    public c f(Bitmap bitmap) {
        this.mBitmap = bitmap;
        return this;
    }
}
