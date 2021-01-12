package com.baidu.prologue.business.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.prologue.b;
import com.baidu.prologue.image.PrologueImageView;
/* loaded from: classes5.dex */
public class c extends b<com.baidu.prologue.business.b.b> {
    protected PrologueImageView cpL;
    View cpM;
    String cpN;
    protected Bitmap mBitmap;

    public c(Context context) {
        super(context);
        this.cpL = null;
        this.mBitmap = null;
        this.cpM = null;
        this.cpN = "";
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_image;
    }

    @Override // com.baidu.prologue.business.c.a
    public void Xv() {
        this.cpL = (PrologueImageView) this.mRootView.findViewById(b.C0310b.splash_ad_image);
        this.cpM = this.mRootView.findViewById(b.C0310b.image_splash_clickable);
        if (this.cpI) {
            com.baidu.prologue.image.d.adt().b(this.cpN, this.cpL);
        } else {
            this.cpL.setImageBitmap(this.mBitmap);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View adf() {
        return this.cpM;
    }

    public void setImageUrl(String str) {
        this.cpN = str;
    }

    public c h(Bitmap bitmap) {
        this.mBitmap = bitmap;
        return this;
    }
}
