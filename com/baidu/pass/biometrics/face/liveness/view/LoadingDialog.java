package com.baidu.pass.biometrics.face.liveness.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import com.baidu.pass.biometrics.face.R;
/* loaded from: classes2.dex */
public class LoadingDialog extends Dialog {
    private View firstDto;
    private Handler handler;
    private View secondDto;
    private long startTime;
    private TextView textView;
    private View thirdDto;

    public LoadingDialog(Context context) {
        this(context, R.style.PassBio_SDK_Dialog);
    }

    public LoadingDialog(Context context, int i) {
        super(context, i);
        this.handler = new Handler();
        init();
    }

    private void init() {
        setContentView(R.layout.layout_pass_face_view_loading_);
        this.textView = (TextView) findViewById(R.id.text_view);
        this.firstDto = findViewById(R.id.first_dto);
        this.secondDto = findViewById(R.id.second_dto);
        this.thirdDto = findViewById(R.id.third_dto);
        setCancel(false);
    }

    public LoadingDialog setMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            this.textView.setVisibility(8);
        } else {
            this.textView.setText(str);
        }
        return this;
    }

    public LoadingDialog setMessage(int i) {
        if (i == -1) {
            this.textView.setVisibility(8);
        } else {
            this.textView.setText(i);
        }
        return this;
    }

    public LoadingDialog setCancel(boolean z) {
        setCancelable(z);
        setCanceledOnTouchOutside(z);
        return this;
    }

    public LoadingDialog showDialog() {
        show();
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            getWindow().setDimAmount(0.0f);
            super.show();
            starAinm(this.firstDto, 0);
            starAinm(this.secondDto, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
            starAinm(this.thirdDto, 500);
            this.startTime = System.currentTimeMillis();
        } catch (Exception e) {
        }
    }

    private void starAinm(final View view, int i) {
        CycleInterpolator cycleInterpolator = new CycleInterpolator(2000.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        final AnimationSet animationSet = new AnimationSet(true);
        animationSet.setInterpolator(cycleInterpolator);
        animationSet.setDuration(3000000L);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        this.handler.postDelayed(new Runnable() { // from class: com.baidu.pass.biometrics.face.liveness.view.LoadingDialog.1
            @Override // java.lang.Runnable
            public void run() {
                view.setVisibility(0);
                view.startAnimation(animationSet);
            }
        }, i);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        int i = 0;
        if (System.currentTimeMillis() - this.startTime < 200) {
            i = 200;
        }
        this.handler.postDelayed(new Runnable() { // from class: com.baidu.pass.biometrics.face.liveness.view.LoadingDialog.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    LoadingDialog.super.dismiss();
                } catch (Exception e) {
                }
                LoadingDialog.this.firstDto.clearAnimation();
                LoadingDialog.this.secondDto.clearAnimation();
                LoadingDialog.this.thirdDto.clearAnimation();
            }
        }, i);
    }
}
