package com.baidu.nadcore.video.videoplayer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.baidu.tieba.m31;
/* loaded from: classes3.dex */
public class LockImageView extends ImageView {
    public m31 a;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            LockImageView.this.a.l(this.a);
        }
    }

    public LockImageView(Context context) {
        this(context, null);
    }

    public final void d(Context context) {
        this.a = new m31(c(getResources(), R.drawable.nad_videoplayer_player_lock_header), c(getResources(), R.drawable.nad_videoplayer_player_lock_body));
    }

    public void e(int i) {
        post(new a(i));
    }

    public LockImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final Bitmap c(Resources resources, int i) {
        return BitmapFactory.decodeResource(resources, i);
    }

    public LockImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d(context);
    }

    public void b() {
        this.a.b();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a.setBounds(0, 0, getWidth(), getHeight());
        setImageDrawable(this.a);
    }
}
