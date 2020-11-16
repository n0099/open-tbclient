package com.baidu.prologue.business.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.prologue.b;
import com.baidu.prologue.image.PrologueImageView;
/* loaded from: classes14.dex */
public class c extends b<com.baidu.prologue.business.b.b> {
    protected PrologueImageView cgO;
    View cgP;
    String cgQ;
    protected Bitmap mBitmap;

    public c(Context context) {
        super(context);
        this.cgO = null;
        this.mBitmap = null;
        this.cgP = null;
        this.cgQ = "";
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_image;
    }

    @Override // com.baidu.prologue.business.c.a
    public void Xh() {
        this.cgO = (PrologueImageView) this.mRootView.findViewById(b.C0316b.splash_ad_image);
        this.cgP = this.mRootView.findViewById(b.C0316b.image_splash_clickable);
        if (this.cgL) {
            com.baidu.prologue.image.d.aci().a(this.cgQ, this.cgO);
        } else {
            this.cgO.setImageBitmap(this.mBitmap);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View abU() {
        return this.cgP;
    }

    public void setImageUrl(String str) {
        this.cgQ = str;
    }

    public c g(Bitmap bitmap) {
        this.mBitmap = bitmap;
        return this;
    }
}
