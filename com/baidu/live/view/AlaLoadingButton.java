package com.baidu.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class AlaLoadingButton extends FrameLayout {
    private TextView bUg;
    private ImageView bUh;
    private FrameLayout bUi;
    private CharSequence bUj;
    private RotateAnimation bUk;
    private int bUl;
    private float bUm;
    private int bUn;
    private int bUo;
    private int bUp;
    private int bUq;
    private float bUr;
    private float bUs;
    private View.OnTouchListener bUt;
    private int mStatus;
    private CharSequence mText;
    private int mTextColor;
    private float mTextSize;

    public AlaLoadingButton(@NonNull Context context) {
        super(context);
        this.mStatus = -1;
        this.bUt = new View.OnTouchListener() { // from class: com.baidu.live.view.AlaLoadingButton.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    view.setAlpha(0.5f);
                    return false;
                } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                    view.setAlpha(1.0f);
                    return false;
                } else {
                    return false;
                }
            }
        };
        init(context);
    }

    public AlaLoadingButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatus = -1;
        this.bUt = new View.OnTouchListener() { // from class: com.baidu.live.view.AlaLoadingButton.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    view.setAlpha(0.5f);
                    return false;
                } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                    view.setAlpha(1.0f);
                    return false;
                } else {
                    return false;
                }
            }
        };
        g(attributeSet);
        init(context);
    }

    public AlaLoadingButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatus = -1;
        this.bUt = new View.OnTouchListener() { // from class: com.baidu.live.view.AlaLoadingButton.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    view.setAlpha(0.5f);
                    return false;
                } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                    view.setAlpha(1.0f);
                    return false;
                } else {
                    return false;
                }
            }
        };
        g(attributeSet);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.yuyin_ala_loading_button, (ViewGroup) this, true);
        this.bUi = (FrameLayout) findViewById(a.f.ala_loading_button_root);
        this.bUg = (TextView) findViewById(a.f.ala_loading_button_text);
        this.bUh = (ImageView) findViewById(a.f.ala_loading_button_loading);
        setOnTouchListener(this.bUt);
        if (this.mText == null) {
            this.mText = getResources().getText(a.h.sdk_yuyin_loading_button_follow);
        } else {
            this.bUg.setText(this.mText);
        }
        if (this.bUj == null) {
            this.bUj = getResources().getText(a.h.sdk_yuyin_loading_button_followed);
        }
        if (this.mTextColor != 0) {
            this.bUg.setTextColor(this.mTextColor);
        } else {
            this.mTextColor = -1;
        }
        if (this.mTextSize != 0.0f) {
            this.bUg.setTextSize(0, this.mTextSize);
        }
        if (this.bUr != 0.0f || this.bUs != 0.0f) {
            this.bUg.setPadding((int) this.bUr, (int) this.bUs, (int) this.bUr, (int) this.bUs);
        }
        if (this.bUm != 0.0f) {
            setLoadingIconSize((int) this.bUm);
        }
        if (this.bUn != 0) {
            this.bUh.setImageResource(this.bUn);
        }
        if (this.bUo != 0) {
            this.bUi.setBackgroundResource(this.bUo);
        } else {
            this.bUo = a.e.ala_loading_button_nomal_bg;
        }
        if (this.bUl == 0) {
            this.bUl = Color.parseColor("#525252");
        }
    }

    public void setStatus(int i) {
        this.mStatus = i;
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        switch (i) {
            case 1:
                if (this.bUk != null && this.bUk.hasStarted()) {
                    stopAnim();
                }
                this.bUi.setBackgroundResource(this.bUo);
                this.bUg.setText(this.mText);
                this.bUg.setTextColor(this.mTextColor);
                return;
            case 2:
            default:
                return;
            case 3:
                this.bUi.setBackgroundResource(this.bUo);
                startAnim();
                return;
            case 4:
                if (this.bUk != null && this.bUk.hasStarted()) {
                    stopAnim();
                }
                this.bUi.setBackgroundResource(this.bUp != 0 ? this.bUp : a.e.ala_loading_button_done_bg);
                this.bUg.setText(this.bUj);
                this.bUg.setTextColor(this.bUl);
                return;
            case 5:
                this.bUi.setBackgroundResource(this.bUp != 0 ? this.bUq : a.e.ala_loading_button_close_done_bg);
                this.bUg.setText(this.bUj);
                this.bUg.setTextColor(-1);
                return;
        }
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setTextColor(int i) {
        if (this.bUg != null) {
            this.mTextColor = i;
            this.bUg.setTextColor(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (this.bUi != null) {
            this.bUo = i;
            this.bUi.setBackgroundResource(i);
        }
    }

    public void setText(CharSequence charSequence) {
        this.mText = charSequence;
        this.bUg.setText(charSequence);
    }

    public String getText() {
        return this.bUg == null ? "" : this.bUg.getText().toString().trim();
    }

    public void setLoadingIconResource(int i) {
        if (this.bUh != null) {
            this.bUn = i;
            this.bUh.setImageResource(i);
        }
    }

    public void setLoadingIconSize(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = 17;
        this.bUh.setLayoutParams(layoutParams);
    }

    private void startAnim() {
        if (this.bUg != null) {
            this.bUg.setVisibility(4);
        }
        if (this.bUh != null) {
            this.bUh.setVisibility(0);
        }
        if (this.bUk == null) {
            this.bUk = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            this.bUk.setDuration(300L);
            this.bUk.setInterpolator(new LinearInterpolator());
            this.bUk.setRepeatCount(-1);
            this.bUk.setFillAfter(true);
            this.bUk.setStartOffset(10L);
        }
        if (this.bUh != null) {
            this.bUh.startAnimation(this.bUk);
        }
    }

    private void stopAnim() {
        if (this.bUg != null) {
            this.bUg.setVisibility(0);
        }
        if (this.bUh != null) {
            this.bUh.setVisibility(8);
        }
        if (this.bUk != null && this.bUh != null) {
            this.bUh.clearAnimation();
        }
    }

    private void g(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.AlaLoadingButton);
        this.mText = obtainStyledAttributes.getText(a.j.AlaLoadingButton_ala_text);
        this.bUj = obtainStyledAttributes.getText(a.j.AlaLoadingButton_ala_text_done);
        this.mTextSize = obtainStyledAttributes.getDimension(a.j.AlaLoadingButton_ala_text_size, 0.0f);
        this.bUr = obtainStyledAttributes.getDimension(a.j.AlaLoadingButton_ala_padding_lr, 0.0f);
        this.bUs = obtainStyledAttributes.getDimension(a.j.AlaLoadingButton_ala_padding_tb, 0.0f);
        this.bUm = obtainStyledAttributes.getDimension(a.j.AlaLoadingButton_ala_loading_size, 0.0f);
        this.bUn = obtainStyledAttributes.getResourceId(a.j.AlaLoadingButton_ala_loading_icon, 0);
        this.bUo = obtainStyledAttributes.getResourceId(a.j.AlaLoadingButton_ala_background, 0);
        this.bUp = obtainStyledAttributes.getResourceId(a.j.AlaLoadingButton_ala_done_background, 0);
        this.bUq = obtainStyledAttributes.getResourceId(a.j.AlaLoadingButton_ala_close_done_background, 0);
        this.mTextColor = obtainStyledAttributes.getColor(a.j.AlaLoadingButton_ala_text_color, 0);
        this.bUl = obtainStyledAttributes.getColor(a.j.AlaLoadingButton_ala_done_text_color, 0);
        obtainStyledAttributes.recycle();
    }
}
