package com.baidu.batsdk.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.batsdk.a.d;
import com.baidu.batsdk.b.b;
import com.baidu.batsdk.b.e;
import com.baidu.batsdk.b.g;
import com.baidu.batsdk.f.a;
import com.slidingmenu.lib.R;
import java.util.HashMap;
/* loaded from: classes.dex */
public class FeedbackActivity extends Activity {
    private Intent a;
    private RelativeLayout b;
    private Button c;
    private Button d;
    private EditText e;
    private EditText f;
    private ImageView g;
    private ImageView h;
    private Animator i;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.b = new RelativeLayout(this);
        this.b.setId(R.style.setting_bg_arrow);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setId(R.style.auto_skin_list);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setId(R.style.NobackDialog);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setId(R.style.NewUserDialog);
        this.c = new Button(this);
        this.c.setId(R.style.AppTheme);
        this.c.setText("返回");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.setMargins(2, 2, 2, 2);
        linearLayout.addView(this.c, layoutParams);
        TextView textView = new TextView(this);
        textView.setId(R.style.setting_bg_text);
        textView.setText(String.valueOf(e.b()) + "-意见反馈");
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.weight = 1.0f;
        linearLayout.addView(textView, layoutParams2);
        this.d = new Button(this);
        this.d.setId(R.style.setting_bg_layout);
        this.d.setText("提交");
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams3.setMargins(2, 2, 2, 2);
        linearLayout.addView(this.d, layoutParams3);
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(-1184275);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(10);
        this.b.addView(linearLayout, layoutParams4);
        this.e = new EditText(this);
        this.e.setId(R.style.title_multi_textview);
        this.e.setHint("请填入您宝贵的建议/问题/投诉，非常感谢！");
        this.e.setMinLines(4);
        this.e.setGravity(48);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(10);
        relativeLayout.addView(this.e, layoutParams5);
        this.f = new EditText(this);
        this.f.setId(R.style.title_back_info);
        this.f.setHint("请填入您的百度帐号/qq号/手机号，有积分噢！");
        this.f.setGravity(48);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams6.addRule(3, this.e.getId());
        relativeLayout.addView(this.f, layoutParams6);
        this.g = new ImageView(this);
        this.g.setId(R.style.comm_controls);
        this.g.setMaxHeight(200);
        this.g.setMaxWidth(200);
        this.g.setPadding(1, 1, 1, 1);
        this.g.setAdjustViewBounds(true);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.setMargins(2, 6, 2, 2);
        layoutParams7.addRule(14);
        layoutParams7.addRule(3, this.f.getId());
        relativeLayout.addView(this.g, layoutParams7);
        TextView textView2 = new TextView(this);
        textView2.setId(R.style.title_3_info);
        textView2.setText("©2013 Baidu");
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.setMargins(2, 6, 2, 2);
        layoutParams8.addRule(14);
        layoutParams8.addRule(3, this.g.getId());
        relativeLayout.addView(textView2, layoutParams8);
        scrollView.addView(relativeLayout, new FrameLayout.LayoutParams(-1, -2));
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setHorizontalScrollBarEnabled(false);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams9.addRule(3, linearLayout.getId());
        this.b.addView(scrollView, layoutParams9);
        this.h = new ImageView(this);
        this.h.setId(R.style.title_margin);
        this.h.setVisibility(4);
        this.h.setAdjustViewBounds(true);
        this.b.addView(this.h, new RelativeLayout.LayoutParams(-1, -1));
        setContentView(this.b, new ViewGroup.LayoutParams(-1, -1));
        this.a = getIntent();
        a.b("FeedbackActivity start.");
        byte[] byteArrayExtra = this.a.getByteArrayExtra("screenshot");
        final Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArrayExtra, 0, byteArrayExtra.length);
        if (decodeByteArray == null) {
            this.g.setVisibility(4);
        } else {
            this.g.setImageBitmap(decodeByteArray);
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.batsdk.ui.FeedbackActivity.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    View currentFocus;
                    InputMethodManager inputMethodManager = (InputMethodManager) FeedbackActivity.this.getSystemService("input_method");
                    if (inputMethodManager != null && (currentFocus = FeedbackActivity.this.getCurrentFocus()) != null) {
                        inputMethodManager.hideSoftInputFromWindow(currentFocus.getApplicationWindowToken(), 2);
                    }
                    if (b.h() >= 11) {
                        FeedbackActivity.a(FeedbackActivity.this, decodeByteArray);
                    } else {
                        FeedbackActivity.b(FeedbackActivity.this, decodeByteArray);
                    }
                }
            });
        }
        String stringExtra = this.a.getStringExtra("uname");
        if (stringExtra.length() > 0) {
            this.f.setText(stringExtra);
        }
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.batsdk.ui.FeedbackActivity.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedbackActivity.this.setResult(0);
                FeedbackActivity.this.finish();
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.batsdk.ui.FeedbackActivity.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String editable = FeedbackActivity.this.e.getText().toString();
                String editable2 = FeedbackActivity.this.f.getText().toString();
                a.a("FeedbackActivity content:" + editable + "\nusername:" + editable2);
                if (editable == null || "" == editable || editable.length() == 0) {
                    Toast.makeText(FeedbackActivity.this, "Sorry, 请输入反馈内容！", 1).show();
                    FeedbackActivity.this.e.requestFocus();
                } else if (editable2 != null && editable2.length() > 0) {
                    g.a(editable2);
                    Intent intent = FeedbackActivity.this.getIntent();
                    HashMap hashMap = new HashMap();
                    b.a(intent, hashMap);
                    hashMap.put("feedbackCnt", editable);
                    hashMap.put("feedbackType", "bug");
                    hashMap.put("feedbackVoice", "");
                    hashMap.put("uname", editable2);
                    b.b(FeedbackActivity.this, b.a(hashMap));
                    FeedbackActivity.this.setResult(0);
                    Toast.makeText(FeedbackActivity.this, "您的反馈已提交，非常感谢！", 1).show();
                    FeedbackActivity.this.finish();
                    d.b = System.currentTimeMillis();
                    com.baidu.batsdk.a.a.a();
                } else {
                    Toast.makeText(FeedbackActivity.this, "Sorry, 请输入您的账号！", 1).show();
                    FeedbackActivity.this.f.requestFocus();
                }
            }
        });
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        BatsdkService.c();
    }

    @Override // android.app.Activity
    public void onStop() {
        View currentFocus;
        super.onStop();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && (currentFocus = getCurrentFocus()) != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getApplicationWindowToken(), 2);
        }
        BatsdkService.b();
        BatsdkService.a = false;
    }

    static /* synthetic */ void a(FeedbackActivity feedbackActivity, Bitmap bitmap) {
        final float width;
        if (feedbackActivity.i != null) {
            feedbackActivity.i.cancel();
        }
        feedbackActivity.h.setImageBitmap(bitmap);
        final Rect rect = new Rect();
        Rect rect2 = new Rect();
        Point point = new Point();
        feedbackActivity.g.getGlobalVisibleRect(rect);
        feedbackActivity.b.getGlobalVisibleRect(rect2, point);
        rect.offset(-point.x, -point.y);
        rect2.offset(-point.x, -point.y);
        if (rect2.width() / rect2.height() > rect.width() / rect.height()) {
            width = rect.height() / rect2.height();
            float width2 = ((rect2.width() * width) - rect.width()) / 2.0f;
            rect.left = (int) (rect.left - width2);
            rect.right = (int) (width2 + rect.right);
        } else {
            width = rect.width() / rect2.width();
            float height = ((rect2.height() * width) - rect.height()) / 2.0f;
            rect.top = (int) (rect.top - height);
            rect.bottom = (int) (height + rect.bottom);
        }
        feedbackActivity.g.setAlpha(0.0f);
        feedbackActivity.h.setVisibility(0);
        feedbackActivity.h.setPivotX(0.0f);
        feedbackActivity.h.setPivotY(0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.batsdk.ui.FeedbackActivity.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                FeedbackActivity.this.i = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                FeedbackActivity.this.i = null;
            }
        });
        animatorSet.play(ObjectAnimator.ofFloat(feedbackActivity.h, View.X, rect2.left)).with(ObjectAnimator.ofFloat(feedbackActivity.h, View.Y, rect2.top)).with(ObjectAnimator.ofFloat(feedbackActivity.h, View.SCALE_X, 1.0f)).with(ObjectAnimator.ofFloat(feedbackActivity.h, View.SCALE_Y, 1.0f));
        animatorSet.start();
        feedbackActivity.i = animatorSet;
        feedbackActivity.h.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.batsdk.ui.FeedbackActivity.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedbackActivity.this.i != null) {
                    FeedbackActivity.this.i.cancel();
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.play(ObjectAnimator.ofFloat(FeedbackActivity.this.h, View.X, rect.left)).with(ObjectAnimator.ofFloat(FeedbackActivity.this.h, View.Y, rect.top)).with(ObjectAnimator.ofFloat(FeedbackActivity.this.h, View.SCALE_X, width)).with(ObjectAnimator.ofFloat(FeedbackActivity.this.h, View.SCALE_Y, width));
                animatorSet2.setDuration(300L);
                animatorSet2.setInterpolator(new DecelerateInterpolator());
                animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.batsdk.ui.FeedbackActivity.5.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        FeedbackActivity.this.g.setAlpha(1.0f);
                        FeedbackActivity.this.h.setVisibility(4);
                        FeedbackActivity.this.i = null;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationCancel(Animator animator) {
                        FeedbackActivity.this.g.setAlpha(1.0f);
                        FeedbackActivity.this.h.setVisibility(4);
                        FeedbackActivity.this.i = null;
                    }
                });
                animatorSet2.start();
                FeedbackActivity.this.i = animatorSet2;
            }
        });
    }

    static /* synthetic */ void b(FeedbackActivity feedbackActivity, Bitmap bitmap) {
        feedbackActivity.h.setImageBitmap(bitmap);
        feedbackActivity.h.setVisibility(0);
        feedbackActivity.h.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.batsdk.ui.FeedbackActivity.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedbackActivity.this.h.setVisibility(4);
            }
        });
    }
}
