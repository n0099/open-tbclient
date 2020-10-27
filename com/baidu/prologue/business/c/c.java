package com.baidu.prologue.business.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.prologue.b;
import com.baidu.prologue.image.PrologueImageView;
/* loaded from: classes19.dex */
public class c extends b<com.baidu.prologue.business.b.b> {
    protected PrologueImageView ccO;
    View ccP;
    String ccQ;
    protected Bitmap mBitmap;

    public c(Context context) {
        super(context);
        this.ccO = null;
        this.mBitmap = null;
        this.ccP = null;
        this.ccQ = "";
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_image;
    }

    @Override // com.baidu.prologue.business.c.a
    public void Vr() {
        this.ccO = (PrologueImageView) this.mRootView.findViewById(b.C0306b.splash_ad_image);
        this.ccP = this.mRootView.findViewById(b.C0306b.image_splash_clickable);
        if (this.ccL) {
            com.baidu.prologue.image.d.aas().a(this.ccQ, this.ccO);
        } else {
            this.ccO.setImageBitmap(this.mBitmap);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View aae() {
        return this.ccP;
    }

    public void setImageUrl(String str) {
        this.ccQ = str;
    }

    public c g(Bitmap bitmap) {
        this.mBitmap = bitmap;
        return this;
    }
}
