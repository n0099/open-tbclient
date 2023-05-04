package com.baidu.nadcore.video.videoplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.n51;
/* loaded from: classes2.dex */
public class ImageTextView extends LinearLayout {
    public static final int d = n51.a(4.0f);
    public int a;
    public ImageView b;
    public TextView c;

    public ImageTextView(Context context) {
        super(context);
        a();
    }

    public ImageTextView b(int i) {
        this.c.setTextColor(getResources().getColorStateList(i));
        return this;
    }

    public ImageTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ImageTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public final void a() {
        setOrientation(1);
        setGravity(17);
        ImageView imageView = new ImageView(getContext());
        this.b = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.b, new LinearLayout.LayoutParams(-2, -2));
        TextView textView = new TextView(getContext());
        this.c = textView;
        textView.setTextColor(-1);
        this.c.setTextSize(12.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, d, 0, 0);
        addView(this.c, layoutParams);
    }

    public void setIconAndTitle(int i, int i2) {
        if (i != 0) {
            if (this.a != i) {
                this.b.setImageResource(i);
                this.b.setVisibility(0);
                this.a = i;
            }
        } else {
            this.b.setImageDrawable(null);
            this.b.setVisibility(8);
        }
        if (i2 != 0) {
            this.c.setText(i2);
            this.c.setVisibility(0);
            return;
        }
        this.c.setText((CharSequence) null);
        this.c.setVisibility(8);
    }
}
