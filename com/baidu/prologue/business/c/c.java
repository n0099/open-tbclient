package com.baidu.prologue.business.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.prologue.b;
import com.baidu.prologue.image.PrologueImageView;
/* loaded from: classes6.dex */
public class c extends b<com.baidu.prologue.business.b.b> {
    protected PrologueImageView bFF;
    View bFG;
    String bFH;
    protected Bitmap mBitmap;

    public c(Context context) {
        super(context);
        this.bFF = null;
        this.mBitmap = null;
        this.bFG = null;
        this.bFH = "";
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_image;
    }

    @Override // com.baidu.prologue.business.c.a
    public void Px() {
        this.bFF = (PrologueImageView) this.mRootView.findViewById(b.C0255b.splash_ad_image);
        this.bFG = this.mRootView.findViewById(b.C0255b.image_splash_clickable);
        if (this.bFC) {
            com.baidu.prologue.image.d.PJ().a(this.bFH, this.bFF);
        } else {
            this.bFF.setImageBitmap(this.mBitmap);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View Pt() {
        return this.bFG;
    }

    public void setImageUrl(String str) {
        this.bFH = str;
    }

    public c f(Bitmap bitmap) {
        this.mBitmap = bitmap;
        return this;
    }
}
