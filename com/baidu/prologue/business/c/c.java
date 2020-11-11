package com.baidu.prologue.business.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.prologue.b;
import com.baidu.prologue.image.PrologueImageView;
/* loaded from: classes19.dex */
public class c extends b<com.baidu.prologue.business.b.b> {
    protected PrologueImageView ciA;
    View ciB;
    String ciC;
    protected Bitmap mBitmap;

    public c(Context context) {
        super(context);
        this.ciA = null;
        this.mBitmap = null;
        this.ciB = null;
        this.ciC = "";
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_image;
    }

    @Override // com.baidu.prologue.business.c.a
    public void XQ() {
        this.ciA = (PrologueImageView) this.mRootView.findViewById(b.C0318b.splash_ad_image);
        this.ciB = this.mRootView.findViewById(b.C0318b.image_splash_clickable);
        if (this.cix) {
            com.baidu.prologue.image.d.acR().a(this.ciC, this.ciA);
        } else {
            this.ciA.setImageBitmap(this.mBitmap);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View acD() {
        return this.ciB;
    }

    public void setImageUrl(String str) {
        this.ciC = str;
    }

    public c g(Bitmap bitmap) {
        this.mBitmap = bitmap;
        return this;
    }
}
