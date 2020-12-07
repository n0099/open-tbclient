package com.baidu.prologue.business.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.prologue.b;
import com.baidu.prologue.image.PrologueImageView;
/* loaded from: classes14.dex */
public class c extends b<com.baidu.prologue.business.b.b> {
    protected PrologueImageView cnw;
    View cnx;
    String cny;
    protected Bitmap mBitmap;

    public c(Context context) {
        super(context);
        this.cnw = null;
        this.mBitmap = null;
        this.cnx = null;
        this.cny = "";
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_image;
    }

    @Override // com.baidu.prologue.business.c.a
    public void ZG() {
        this.cnw = (PrologueImageView) this.mRootView.findViewById(b.C0327b.splash_ad_image);
        this.cnx = this.mRootView.findViewById(b.C0327b.image_splash_clickable);
        if (this.cns) {
            com.baidu.prologue.image.d.afq().a(this.cny, this.cnw);
        } else {
            this.cnw.setImageBitmap(this.mBitmap);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View afc() {
        return this.cnx;
    }

    public void setImageUrl(String str) {
        this.cny = str;
    }

    public c g(Bitmap bitmap) {
        this.mBitmap = bitmap;
        return this;
    }
}
