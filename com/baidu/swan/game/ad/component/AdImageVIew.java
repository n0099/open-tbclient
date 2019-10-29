package com.baidu.swan.game.ad.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.facebook.common.b.f;
import com.facebook.common.references.a;
import com.facebook.drawee.a.a.c;
import com.facebook.imagepipeline.e.b;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
/* loaded from: classes2.dex */
public class AdImageVIew extends AppCompatImageView {
    public AdImageVIew(Context context) {
        super(context);
    }

    public AdImageVIew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdImageVIew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageUrl(String str) {
        c.cDD().e(ImageRequestBuilder.R(Uri.parse(str)).cJI(), getContext()).a(new b() { // from class: com.baidu.swan.game.ad.component.AdImageVIew.1
            @Override // com.facebook.imagepipeline.e.b
            protected void h(@Nullable Bitmap bitmap) {
                if (bitmap != null) {
                    AdImageVIew.this.setImageBitmap(bitmap);
                }
            }

            @Override // com.facebook.datasource.a
            protected void a(com.facebook.datasource.b<a<com.facebook.imagepipeline.f.b>> bVar) {
            }
        }, f.cCI());
    }
}
