package com.baidu.swan.game.ad.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.facebook.common.b.i;
import com.facebook.common.references.a;
import com.facebook.drawee.a.a.c;
import com.facebook.imagepipeline.d.b;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
/* loaded from: classes3.dex */
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
        c.euR().e(ImageRequestBuilder.aj(Uri.parse(str)).eBI(), getContext()).a(new b() { // from class: com.baidu.swan.game.ad.component.AdImageVIew.1
            @Override // com.facebook.imagepipeline.d.b
            protected void f(@Nullable Bitmap bitmap) {
                if (bitmap != null) {
                    AdImageVIew.this.setImageBitmap(bitmap);
                }
            }

            @Override // com.facebook.datasource.a
            protected void a(com.facebook.datasource.b<a<com.facebook.imagepipeline.f.c>> bVar) {
            }
        }, i.etX());
    }
}
