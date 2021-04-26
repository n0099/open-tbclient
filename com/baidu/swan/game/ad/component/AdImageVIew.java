package com.baidu.swan.game.ad.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
/* loaded from: classes3.dex */
public class AdImageVIew extends AppCompatImageView {

    /* loaded from: classes3.dex */
    public class a extends BaseBitmapDataSubscriber {
        public a() {
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            if (bitmap != null) {
                AdImageVIew.this.setImageBitmap(bitmap);
            }
        }
    }

    public AdImageVIew(Context context) {
        super(context);
    }

    public void setImageUrl(String str) {
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).build(), getContext()).subscribe(new a(), UiThreadImmediateExecutorService.getInstance());
    }

    public AdImageVIew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdImageVIew(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
