package com.baidu.nadcore.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class NadButtonLottieView extends LottieAnimationView {
    public float a;
    public float b;

    public NadButtonLottieView(Context context) {
        super(context);
        b();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Path path = new Path();
        path.addRoundRect(new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight()), this.a, this.b, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

    public void setXRradius(float f) {
        this.a = f;
    }

    public void setYRradius(float f) {
        this.b = f;
    }

    public NadButtonLottieView(Context context, String str) {
        super(context);
        b();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setAnimationFromUrl(str);
        playAnimation();
    }

    public final void b() {
        setRepeatCount(-1);
        setRepeatMode(1);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
}
