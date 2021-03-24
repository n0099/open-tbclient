package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes2.dex */
public class UploadingFileView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public UploadCircleView f6177a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f6178b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f6179c;
    public DynamicWaveView dynamicWaveView;

    /* loaded from: classes2.dex */
    public class a implements Interpolator {

        /* renamed from: b  reason: collision with root package name */
        public float f6182b = 0.5f;

        public a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            double pow = Math.pow(2.0d, (-10.0f) * f2);
            float f3 = this.f6182b;
            double d2 = f2 - (f3 / 4.0f);
            Double.isNaN(d2);
            double d3 = f3;
            Double.isNaN(d3);
            return (float) ((pow * Math.sin((d2 * 6.283185307179586d) / d3)) + 1.0d);
        }
    }

    public UploadingFileView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f6179c.setVisibility(0);
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(200L);
        animationSet.setFillAfter(true);
        this.f6179c.startAnimation(animationSet);
    }

    public void setProgress(int i) {
        if (i < 100) {
            this.f6177a.setProgress(i);
            if (i == 0) {
                this.dynamicWaveView.setVisibility(0);
                return;
            }
            return;
        }
        this.f6177a.setProgress(100);
        this.dynamicWaveView.stopAnim();
    }

    public void showUpSucView() {
        this.f6177a.setVisibility(8);
        this.dynamicWaveView.setVisibility(8);
        this.f6178b.setVisibility(0);
        a();
    }

    public UploadingFileView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    private void a() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.4f, 1.0f, 0.4f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(new a());
        scaleAnimation.setDuration(1000L);
        scaleAnimation.setFillAfter(true);
        this.f6178b.startAnimation(scaleAnimation);
        postDelayed(new Runnable() { // from class: com.baidu.fsg.face.liveness.view.UploadingFileView.1
            @Override // java.lang.Runnable
            public void run() {
                UploadingFileView.this.b();
            }
        }, 300L);
    }

    public UploadingFileView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_sapi_liveness_uploading_file_view, (ViewGroup) this, true);
        this.dynamicWaveView = (DynamicWaveView) findViewById(R.id.dynamic_wave);
        this.f6177a = (UploadCircleView) inflate.findViewById(R.id.my_circle);
        this.f6178b = (ImageView) inflate.findViewById(R.id.circle);
        this.f6179c = (ImageView) inflate.findViewById(R.id.tick);
    }
}
