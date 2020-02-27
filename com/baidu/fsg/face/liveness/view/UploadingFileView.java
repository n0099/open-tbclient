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
/* loaded from: classes4.dex */
public class UploadingFileView extends FrameLayout {
    private UploadCircleView a;
    private ImageView b;
    private ImageView c;
    public DynamicWaveView dynamicWaveView;

    public UploadingFileView(Context context) {
        this(context, null);
    }

    public UploadingFileView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public UploadingFileView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_sapi_liveness_uploading_file_view, (ViewGroup) this, true);
        this.dynamicWaveView = (DynamicWaveView) findViewById(R.id.dynamic_wave);
        this.a = (UploadCircleView) inflate.findViewById(R.id.my_circle);
        this.b = (ImageView) inflate.findViewById(R.id.circle);
        this.c = (ImageView) inflate.findViewById(R.id.tick);
    }

    public void setProgress(int i) {
        if (i < 100) {
            this.a.setProgress(i);
            if (i == 0) {
                this.dynamicWaveView.setVisibility(0);
                return;
            }
            return;
        }
        this.a.setProgress(100);
        this.dynamicWaveView.stopAnim();
    }

    public void showUpSucView() {
        this.a.setVisibility(8);
        this.dynamicWaveView.setVisibility(8);
        this.b.setVisibility(0);
        a();
    }

    private void a() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.4f, 1.0f, 0.4f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(new a());
        scaleAnimation.setDuration(1000L);
        scaleAnimation.setFillAfter(true);
        this.b.startAnimation(scaleAnimation);
        postDelayed(new Runnable() { // from class: com.baidu.fsg.face.liveness.view.UploadingFileView.1
            @Override // java.lang.Runnable
            public void run() {
                UploadingFileView.this.b();
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.c.setVisibility(0);
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(200L);
        animationSet.setFillAfter(true);
        this.c.startAnimation(animationSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a implements Interpolator {
        private float b = 0.5f;

        public a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) ((Math.pow(2.0d, (-10.0f) * f) * Math.sin(((f - (this.b / 4.0f)) * 6.283185307179586d) / this.b)) + 1.0d);
        }
    }
}
