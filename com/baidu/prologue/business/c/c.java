package com.baidu.prologue.business.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.prologue.b;
import com.baidu.prologue.image.PrologueImageView;
/* loaded from: classes6.dex */
public class c extends b<com.baidu.prologue.business.b.b> {
    protected PrologueImageView bto;
    View btp;
    String btq;
    protected Bitmap mBitmap;

    public c(Context context) {
        super(context);
        this.bto = null;
        this.mBitmap = null;
        this.btp = null;
        this.btq = "";
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_image;
    }

    @Override // com.baidu.prologue.business.c.a
    public void Me() {
        this.bto = (PrologueImageView) this.mRootView.findViewById(b.C0216b.splash_ad_image);
        this.btp = this.mRootView.findViewById(b.C0216b.image_splash_clickable);
        if (this.btl) {
            com.baidu.prologue.image.d.Mq().a(this.btq, this.bto);
        } else {
            this.bto.setImageBitmap(this.mBitmap);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View Ma() {
        return this.btp;
    }

    public void setImageUrl(String str) {
        this.btq = str;
    }

    public c f(Bitmap bitmap) {
        this.mBitmap = bitmap;
        return this;
    }
}
