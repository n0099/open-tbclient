package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes3.dex */
public class GuidPageView extends ImageView {

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null || view.getBackground() == null) {
                return;
            }
            Bitmap bitmap = ((BitmapDrawable) view.getBackground()).getBitmap();
            view.setBackgroundDrawable(null);
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            view.setVisibility(8);
        }
    }

    public GuidPageView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        setOnClickListener(new a());
    }

    public void b() {
        if (getBackground() == null) {
            return;
        }
        Bitmap bitmap = ((BitmapDrawable) getBackground()).getBitmap();
        setBackgroundDrawable(null);
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public GuidPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
