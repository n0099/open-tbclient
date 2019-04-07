package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class GuidPageView extends ImageView {
    public GuidPageView(Context context) {
        super(context);
        init();
    }

    public GuidPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.GuidPageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && view.getBackground() != null) {
                    Bitmap bitmap = ((BitmapDrawable) view.getBackground()).getBitmap();
                    view.setBackgroundDrawable(null);
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                    view.setVisibility(8);
                }
            }
        });
    }

    public void aeh() {
        if (getBackground() != null) {
            Bitmap bitmap = ((BitmapDrawable) getBackground()).getBitmap();
            setBackgroundDrawable(null);
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }
}
