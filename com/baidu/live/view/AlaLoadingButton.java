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
    private TextView bOQ;
    private ImageView bOR;
    private FrameLayout bOS;
    private CharSequence bOT;
    private RotateAnimation bOU;
    private int bOV;
    private float bOW;
    private int bOX;
    private int bOY;
    private int bOZ;
    private int bPa;
    private float bPb;
    private float bPc;
    private View.OnTouchListener bPd;
    private int mStatus;
    private CharSequence mText;
    private int mTextColor;
    private float mTextSize;

    public AlaLoadingButton(@NonNull Context context) {
        super(context);
        this.mStatus = -1;
        this.bPd = new View.OnTouchListener() { // from class: com.baidu.live.view.AlaLoadingButton.1
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
        this.bPd = new View.OnTouchListener() { // from class: com.baidu.live.view.AlaLoadingButton.1
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
        this.bPd = new View.OnTouchListener() { // from class: com.baidu.live.view.AlaLoadingButton.1
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
        this.bOS = (FrameLayout) findViewById(a.f.ala_loading_button_root);
        this.bOQ = (TextView) findViewById(a.f.ala_loading_button_text);
        this.bOR = (ImageView) findViewById(a.f.ala_loading_button_loading);
        setOnTouchListener(this.bPd);
        if (this.mText == null) {
            this.mText = getResources().getText(a.h.sdk_yuyin_loading_button_follow);
        } else {
            this.bOQ.setText(this.mText);
        }
        if (this.bOT == null) {
            this.bOT = getResources().getText(a.h.sdk_yuyin_loading_button_followed);
        }
        if (this.mTextColor != 0) {
            this.bOQ.setTextColor(this.mTextColor);
        } else {
            this.mTextColor = -1;
        }
        if (this.mTextSize != 0.0f) {
            this.bOQ.setTextSize(0, this.mTextSize);
        }
        if (this.bPb != 0.0f || this.bPc != 0.0f) {
            this.bOQ.setPadding((int) this.bPb, (int) this.bPc, (int) this.bPb, (int) this.bPc);
        }
        if (this.bOW != 0.0f) {
            setLoadingIconSize((int) this.bOW);
        }
        if (this.bOX != 0) {
            this.bOR.setImageResource(this.bOX);
        }
        if (this.bOY != 0) {
            this.bOS.setBackgroundResource(this.bOY);
        } else {
            this.bOY = a.e.ala_loading_button_nomal_bg;
        }
        if (this.bOV == 0) {
            this.bOV = Color.parseColor("#525252");
        }
    }

    public void setStatus(int i) {
        this.mStatus = i;
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        switch (i) {
            case 1:
                if (this.bOU != null && this.bOU.hasStarted()) {
                    stopAnim();
                }
                this.bOS.setBackgroundResource(this.bOY);
                this.bOQ.setText(this.mText);
                this.bOQ.setTextColor(this.mTextColor);
                return;
            case 2:
            default:
                return;
            case 3:
                this.bOS.setBackgroundResource(this.bOY);
                startAnim();
                return;
            case 4:
                if (this.bOU != null && this.bOU.hasStarted()) {
                    stopAnim();
                }
                this.bOS.setBackgroundResource(this.bOZ != 0 ? this.bOZ : a.e.ala_loading_button_done_bg);
                this.bOQ.setText(this.bOT);
                this.bOQ.setTextColor(this.bOV);
                return;
            case 5:
                this.bOS.setBackgroundResource(this.bOZ != 0 ? this.bPa : a.e.ala_loading_button_close_done_bg);
                this.bOQ.setText(this.bOT);
                this.bOQ.setTextColor(-1);
                return;
        }
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setTextColor(int i) {
        if (this.bOQ != null) {
            this.mTextColor = i;
            this.bOQ.setTextColor(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (this.bOS != null) {
            this.bOY = i;
            this.bOS.setBackgroundResource(i);
        }
    }

    public void setText(CharSequence charSequence) {
        this.mText = charSequence;
        this.bOQ.setText(charSequence);
    }

    public String getText() {
        return this.bOQ == null ? "" : this.bOQ.getText().toString().trim();
    }

    public void setLoadingIconResource(int i) {
        if (this.bOR != null) {
            this.bOX = i;
            this.bOR.setImageResource(i);
        }
    }

    public void setLoadingIconSize(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = 17;
        this.bOR.setLayoutParams(layoutParams);
    }

    private void startAnim() {
        if (this.bOQ != null) {
            this.bOQ.setVisibility(4);
        }
        if (this.bOR != null) {
            this.bOR.setVisibility(0);
        }
        if (this.bOU == null) {
            this.bOU = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            this.bOU.setDuration(300L);
            this.bOU.setInterpolator(new LinearInterpolator());
            this.bOU.setRepeatCount(-1);
            this.bOU.setFillAfter(true);
            this.bOU.setStartOffset(10L);
        }
        if (this.bOR != null) {
            this.bOR.startAnimation(this.bOU);
        }
    }

    private void stopAnim() {
        if (this.bOQ != null) {
            this.bOQ.setVisibility(0);
        }
        if (this.bOR != null) {
            this.bOR.setVisibility(8);
        }
        if (this.bOU != null && this.bOR != null) {
            this.bOR.clearAnimation();
        }
    }

    private void g(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.AlaLoadingButton);
        this.mText = obtainStyledAttributes.getText(a.j.AlaLoadingButton_ala_text);
        this.bOT = obtainStyledAttributes.getText(a.j.AlaLoadingButton_ala_text_done);
        this.mTextSize = obtainStyledAttributes.getDimension(a.j.AlaLoadingButton_ala_text_size, 0.0f);
        this.bPb = obtainStyledAttributes.getDimension(a.j.AlaLoadingButton_ala_padding_lr, 0.0f);
        this.bPc = obtainStyledAttributes.getDimension(a.j.AlaLoadingButton_ala_padding_tb, 0.0f);
        this.bOW = obtainStyledAttributes.getDimension(a.j.AlaLoadingButton_ala_loading_size, 0.0f);
        this.bOX = obtainStyledAttributes.getResourceId(a.j.AlaLoadingButton_ala_loading_icon, 0);
        this.bOY = obtainStyledAttributes.getResourceId(a.j.AlaLoadingButton_ala_background, 0);
        this.bOZ = obtainStyledAttributes.getResourceId(a.j.AlaLoadingButton_ala_done_background, 0);
        this.bPa = obtainStyledAttributes.getResourceId(a.j.AlaLoadingButton_ala_close_done_background, 0);
        this.mTextColor = obtainStyledAttributes.getColor(a.j.AlaLoadingButton_ala_text_color, 0);
        this.bOV = obtainStyledAttributes.getColor(a.j.AlaLoadingButton_ala_done_text_color, 0);
        obtainStyledAttributes.recycle();
    }
}
