package com.baidu.prologue.business.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.prologue.b;
import com.baidu.prologue.image.PrologueImageView;
/* loaded from: classes8.dex */
public class c extends b<com.baidu.prologue.business.b.b> {
    protected PrologueImageView bGd;
    View bGe;
    String bGf;
    protected Bitmap mBitmap;

    public c(Context context) {
        super(context);
        this.bGd = null;
        this.mBitmap = null;
        this.bGe = null;
        this.bGf = "";
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_image;
    }

    @Override // com.baidu.prologue.business.c.a
    public void PM() {
        this.bGd = (PrologueImageView) this.mRootView.findViewById(b.C0258b.splash_ad_image);
        this.bGe = this.mRootView.findViewById(b.C0258b.image_splash_clickable);
        if (this.bGa) {
            com.baidu.prologue.image.d.PY().a(this.bGf, this.bGd);
        } else {
            this.bGd.setImageBitmap(this.mBitmap);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View PI() {
        return this.bGe;
    }

    public void setImageUrl(String str) {
        this.bGf = str;
    }

    public c f(Bitmap bitmap) {
        this.mBitmap = bitmap;
        return this;
    }
}
