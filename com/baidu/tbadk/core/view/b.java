package com.baidu.tbadk.core.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class b extends ImageView {
    public void vr() {
        if (getBackground() != null) {
            Bitmap bitmap = ((BitmapDrawable) getBackground()).getBitmap();
            setBackgroundDrawable(null);
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }
}
