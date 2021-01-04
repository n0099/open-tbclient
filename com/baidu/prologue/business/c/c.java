package com.baidu.prologue.business.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.prologue.b;
import com.baidu.prologue.image.PrologueImageView;
/* loaded from: classes5.dex */
public class c extends b<com.baidu.prologue.business.b.b> {
    protected PrologueImageView cuD;
    View cuE;
    String cuF;
    protected Bitmap mBitmap;

    public c(Context context) {
        super(context);
        this.cuD = null;
        this.mBitmap = null;
        this.cuE = null;
        this.cuF = "";
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_image;
    }

    @Override // com.baidu.prologue.business.c.a
    public void abn() {
        this.cuD = (PrologueImageView) this.mRootView.findViewById(b.C0327b.splash_ad_image);
        this.cuE = this.mRootView.findViewById(b.C0327b.image_splash_clickable);
        if (this.cuA) {
            com.baidu.prologue.image.d.ahm().b(this.cuF, this.cuD);
        } else {
            this.cuD.setImageBitmap(this.mBitmap);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View agY() {
        return this.cuE;
    }

    public void setImageUrl(String str) {
        this.cuF = str;
    }

    public c h(Bitmap bitmap) {
        this.mBitmap = bitmap;
        return this;
    }
}
