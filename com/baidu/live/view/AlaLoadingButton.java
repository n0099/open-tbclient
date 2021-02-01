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
/* loaded from: classes11.dex */
public class AlaLoadingButton extends FrameLayout {
    private TextView bSG;
    private ImageView bSH;
    private FrameLayout bSI;
    private CharSequence bSJ;
    private RotateAnimation bSK;
    private int bSL;
    private float bSM;
    private int bSN;
    private int bSO;
    private int bSP;
    private int bSQ;
    private float bSR;
    private float bSS;
    private View.OnTouchListener bST;
    private int mStatus;
    private CharSequence mText;
    private int mTextColor;
    private float mTextSize;

    public AlaLoadingButton(@NonNull Context context) {
        super(context);
        this.mStatus = -1;
        this.bST = new View.OnTouchListener() { // from class: com.baidu.live.view.AlaLoadingButton.1
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
        this.bST = new View.OnTouchListener() { // from class: com.baidu.live.view.AlaLoadingButton.1
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
        this.bST = new View.OnTouchListener() { // from class: com.baidu.live.view.AlaLoadingButton.1
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
        this.bSI = (FrameLayout) findViewById(a.f.ala_loading_button_root);
        this.bSG = (TextView) findViewById(a.f.ala_loading_button_text);
        this.bSH = (ImageView) findViewById(a.f.ala_loading_button_loading);
        setOnTouchListener(this.bST);
        if (this.mText == null) {
            this.mText = getResources().getText(a.h.sdk_yuyin_loading_button_follow);
        } else {
            this.bSG.setText(this.mText);
        }
        if (this.bSJ == null) {
            this.bSJ = getResources().getText(a.h.sdk_yuyin_loading_button_followed);
        }
        if (this.mTextColor != 0) {
            this.bSG.setTextColor(this.mTextColor);
        } else {
            this.mTextColor = -1;
        }
        if (this.mTextSize != 0.0f) {
            this.bSG.setTextSize(0, this.mTextSize);
        }
        if (this.bSR != 0.0f || this.bSS != 0.0f) {
            this.bSG.setPadding((int) this.bSR, (int) this.bSS, (int) this.bSR, (int) this.bSS);
        }
        if (this.bSM != 0.0f) {
            setLoadingIconSize((int) this.bSM);
        }
        if (this.bSN != 0) {
            this.bSH.setImageResource(this.bSN);
        }
        if (this.bSO != 0) {
            this.bSI.setBackgroundResource(this.bSO);
        } else {
            this.bSO = a.e.ala_loading_button_nomal_bg;
        }
        if (this.bSL == 0) {
            this.bSL = Color.parseColor("#525252");
        }
    }

    public void setStatus(int i) {
        this.mStatus = i;
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        switch (i) {
            case 1:
                if (this.bSK != null && this.bSK.hasStarted()) {
                    stopAnim();
                }
                this.bSI.setBackgroundResource(this.bSO);
                this.bSG.setText(this.mText);
                this.bSG.setTextColor(this.mTextColor);
                return;
            case 2:
            default:
                return;
            case 3:
                this.bSI.setBackgroundResource(this.bSO);
                startAnim();
                return;
            case 4:
                if (this.bSK != null && this.bSK.hasStarted()) {
                    stopAnim();
                }
                this.bSI.setBackgroundResource(this.bSP != 0 ? this.bSP : a.e.ala_loading_button_done_bg);
                this.bSG.setText(this.bSJ);
                this.bSG.setTextColor(this.bSL);
                return;
            case 5:
                this.bSI.setBackgroundResource(this.bSP != 0 ? this.bSQ : a.e.ala_loading_button_close_done_bg);
                this.bSG.setText(this.bSJ);
                this.bSG.setTextColor(-1);
                return;
        }
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setTextColor(int i) {
        if (this.bSG != null) {
            this.mTextColor = i;
            this.bSG.setTextColor(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (this.bSI != null) {
            this.bSO = i;
            this.bSI.setBackgroundResource(i);
        }
    }

    public void setText(CharSequence charSequence) {
        this.mText = charSequence;
        this.bSG.setText(charSequence);
    }

    public String getText() {
        return this.bSG == null ? "" : this.bSG.getText().toString().trim();
    }

    public void setLoadingIconResource(int i) {
        if (this.bSH != null) {
            this.bSN = i;
            this.bSH.setImageResource(i);
        }
    }

    public void setLoadingIconSize(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = 17;
        this.bSH.setLayoutParams(layoutParams);
    }

    private void startAnim() {
        if (this.bSG != null) {
            this.bSG.setVisibility(4);
        }
        if (this.bSH != null) {
            this.bSH.setVisibility(0);
        }
        if (this.bSK == null) {
            this.bSK = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            this.bSK.setDuration(300L);
            this.bSK.setInterpolator(new LinearInterpolator());
            this.bSK.setRepeatCount(-1);
            this.bSK.setFillAfter(true);
            this.bSK.setStartOffset(10L);
        }
        if (this.bSH != null) {
            this.bSH.startAnimation(this.bSK);
        }
    }

    private void stopAnim() {
        if (this.bSG != null) {
            this.bSG.setVisibility(0);
        }
        if (this.bSH != null) {
            this.bSH.setVisibility(8);
        }
        if (this.bSK != null && this.bSH != null) {
            this.bSH.clearAnimation();
        }
    }

    private void g(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.AlaLoadingButton);
        this.mText = obtainStyledAttributes.getText(a.j.AlaLoadingButton_ala_text);
        this.bSJ = obtainStyledAttributes.getText(a.j.AlaLoadingButton_ala_text_done);
        this.mTextSize = obtainStyledAttributes.getDimension(a.j.AlaLoadingButton_ala_text_size, 0.0f);
        this.bSR = obtainStyledAttributes.getDimension(a.j.AlaLoadingButton_ala_padding_lr, 0.0f);
        this.bSS = obtainStyledAttributes.getDimension(a.j.AlaLoadingButton_ala_padding_tb, 0.0f);
        this.bSM = obtainStyledAttributes.getDimension(a.j.AlaLoadingButton_ala_loading_size, 0.0f);
        this.bSN = obtainStyledAttributes.getResourceId(a.j.AlaLoadingButton_ala_loading_icon, 0);
        this.bSO = obtainStyledAttributes.getResourceId(a.j.AlaLoadingButton_ala_background, 0);
        this.bSP = obtainStyledAttributes.getResourceId(a.j.AlaLoadingButton_ala_done_background, 0);
        this.bSQ = obtainStyledAttributes.getResourceId(a.j.AlaLoadingButton_ala_close_done_background, 0);
        this.mTextColor = obtainStyledAttributes.getColor(a.j.AlaLoadingButton_ala_text_color, 0);
        this.bSL = obtainStyledAttributes.getColor(a.j.AlaLoadingButton_ala_done_text_color, 0);
        obtainStyledAttributes.recycle();
    }
}
