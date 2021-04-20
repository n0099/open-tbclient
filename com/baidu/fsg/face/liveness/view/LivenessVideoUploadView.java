package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes2.dex */
public class LivenessVideoUploadView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f6128a;

    /* renamed from: b  reason: collision with root package name */
    public LivenessCircleProgressView f6129b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f6130c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f6131d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f6132e;

    /* renamed from: f  reason: collision with root package name */
    public a f6133f;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        boolean b();

        void c();
    }

    public LivenessVideoUploadView(@NonNull Context context) {
        super(context);
        a();
    }

    public void setUploadListener(a aVar) {
        this.f6133f = aVar;
    }

    public void showBackgroundBitmap() {
        final int i = (int) ((getContext().getResources().getDisplayMetrics().widthPixels * 7) / 24.0f);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -i, 0.0f, 0.0f);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(600L);
        translateAnimation.setInterpolator(new BounceInterpolator());
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LivenessVideoUploadView.this.f6131d.clearAnimation();
                LivenessVideoUploadView.this.f6131d.setTranslationX(-i);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.f6131d.startAnimation(translateAnimation);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, i, 0.0f, 0.0f);
        translateAnimation2.setFillAfter(true);
        translateAnimation2.setDuration(600L);
        translateAnimation2.setInterpolator(new BounceInterpolator());
        this.f6132e.startAnimation(translateAnimation2);
        translateAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LivenessVideoUploadView.this.f6132e.clearAnimation();
                LivenessVideoUploadView.this.f6132e.setTranslationX(i);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    public void updateProgress(int i) {
        this.f6129b.updateProgress(i);
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_liveness_video_upload_view, (ViewGroup) this, true);
        this.f6129b = (LivenessCircleProgressView) inflate.findViewById(R.id.uploading_file_view);
        this.f6130c = (TextView) inflate.findViewById(R.id.uploading_tv);
        this.f6128a = (ImageView) inflate.findViewById(R.id.img_canvas_view);
        this.f6131d = (LinearLayout) inflate.findViewById(R.id.cancle_upload);
        this.f6132e = (LinearLayout) inflate.findViewById(R.id.confirm_upload);
        this.f6131d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LivenessVideoUploadView.this.f6133f != null) {
                    LivenessVideoUploadView.this.f6133f.a();
                }
            }
        });
        this.f6132e.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LivenessVideoUploadView.this.f6133f == null || !LivenessVideoUploadView.this.f6133f.b()) {
                    return;
                }
                LivenessVideoUploadView.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        long j = 300;
        alphaAnimation.setDuration(j);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LivenessVideoUploadView.this.f6132e.setVisibility(8);
                LivenessVideoUploadView.this.f6131d.setVisibility(8);
                if (LivenessVideoUploadView.this.f6133f != null) {
                    LivenessVideoUploadView.this.f6129b.setVisibility(0);
                    LivenessVideoUploadView.this.f6130c.setVisibility(0);
                    LivenessVideoUploadView.this.f6133f.c();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        float[] fArr = {this.f6129b.getX() + (this.f6129b.getWidth() / 2), this.f6129b.getY() + (this.f6129b.getHeight() / 2)};
        float[] fArr2 = {this.f6131d.getX() + (this.f6131d.getWidth() / 2), this.f6131d.getY() + (this.f6131d.getHeight() / 2)};
        float[] fArr3 = {this.f6132e.getX() + (this.f6132e.getWidth() / 2), this.f6132e.getY() + (this.f6132e.getHeight() / 2)};
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, fArr[0] - fArr2[0], 0.0f, fArr[1] - fArr2[1]);
        translateAnimation.setDuration(j);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new LinearInterpolator());
        AnimationSet animationSet = new AnimationSet(getContext(), null);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        this.f6131d.startAnimation(animationSet);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, fArr[0] - fArr3[0], 0.0f, fArr[1] - fArr3[1]);
        translateAnimation2.setDuration(j);
        translateAnimation2.setFillAfter(true);
        translateAnimation2.setInterpolator(new LinearInterpolator());
        AnimationSet animationSet2 = new AnimationSet(getContext(), null);
        animationSet2.addAnimation(translateAnimation2);
        animationSet2.addAnimation(alphaAnimation);
        this.f6132e.startAnimation(animationSet2);
    }

    public LivenessVideoUploadView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
