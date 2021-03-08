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
/* loaded from: classes5.dex */
public class LivenessVideoUploadView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f1791a;
    private LivenessCircleProgressView b;
    private TextView c;
    private LinearLayout d;
    private LinearLayout e;
    private a f;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        boolean b();

        void c();
    }

    public LivenessVideoUploadView(@NonNull Context context) {
        super(context);
        a();
    }

    public LivenessVideoUploadView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_liveness_video_upload_view, (ViewGroup) this, true);
        this.b = (LivenessCircleProgressView) inflate.findViewById(R.id.uploading_file_view);
        this.c = (TextView) inflate.findViewById(R.id.uploading_tv);
        this.f1791a = (ImageView) inflate.findViewById(R.id.img_canvas_view);
        this.d = (LinearLayout) inflate.findViewById(R.id.cancle_upload);
        this.e = (LinearLayout) inflate.findViewById(R.id.confirm_upload);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LivenessVideoUploadView.this.f != null) {
                    LivenessVideoUploadView.this.f.a();
                }
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LivenessVideoUploadView.this.f != null && LivenessVideoUploadView.this.f.b()) {
                    LivenessVideoUploadView.this.b();
                }
            }
        });
    }

    public void updateProgress(int i) {
        this.b.updateProgress(i);
    }

    public void showBackgroundBitmap() {
        final int i = (int) ((getContext().getResources().getDisplayMetrics().widthPixels * 7) / 24.0f);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -i, 0.0f, 0.0f);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(600L);
        translateAnimation.setInterpolator(new BounceInterpolator());
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LivenessVideoUploadView.this.d.clearAnimation();
                LivenessVideoUploadView.this.d.setTranslationX(-i);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.d.startAnimation(translateAnimation);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, i, 0.0f, 0.0f);
        translateAnimation2.setFillAfter(true);
        translateAnimation2.setDuration(600L);
        translateAnimation2.setInterpolator(new BounceInterpolator());
        this.e.startAnimation(translateAnimation2);
        translateAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LivenessVideoUploadView.this.e.clearAnimation();
                LivenessVideoUploadView.this.e.setTranslationX(i);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setUploadListener(a aVar) {
        this.f = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LivenessVideoUploadView.this.e.setVisibility(8);
                LivenessVideoUploadView.this.d.setVisibility(8);
                if (LivenessVideoUploadView.this.f != null) {
                    LivenessVideoUploadView.this.b.setVisibility(0);
                    LivenessVideoUploadView.this.c.setVisibility(0);
                    LivenessVideoUploadView.this.f.c();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        float[] fArr = {this.b.getX() + (this.b.getWidth() / 2), this.b.getY() + (this.b.getHeight() / 2)};
        float[] fArr2 = {this.d.getX() + (this.d.getWidth() / 2), this.d.getY() + (this.d.getHeight() / 2)};
        float[] fArr3 = {this.e.getX() + (this.e.getWidth() / 2), this.e.getY() + (this.e.getHeight() / 2)};
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, fArr[0] - fArr2[0], 0.0f, fArr[1] - fArr2[1]);
        translateAnimation.setDuration(300);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new LinearInterpolator());
        AnimationSet animationSet = new AnimationSet(getContext(), null);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        this.d.startAnimation(animationSet);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, fArr[0] - fArr3[0], 0.0f, fArr[1] - fArr3[1]);
        translateAnimation2.setDuration(300);
        translateAnimation2.setFillAfter(true);
        translateAnimation2.setInterpolator(new LinearInterpolator());
        AnimationSet animationSet2 = new AnimationSet(getContext(), null);
        animationSet2.addAnimation(translateAnimation2);
        animationSet2.addAnimation(alphaAnimation);
        this.e.startAnimation(animationSet2);
    }
}
