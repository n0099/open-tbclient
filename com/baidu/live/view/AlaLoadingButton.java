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
    private TextView bTC;
    private ImageView bTD;
    private FrameLayout bTE;
    private CharSequence bTF;
    private RotateAnimation bTG;
    private int bTH;
    private float bTI;
    private int bTJ;
    private int bTK;
    private int bTL;
    private int bTM;
    private float bTN;
    private float bTO;
    private View.OnTouchListener bTP;
    private int mStatus;
    private CharSequence mText;
    private int mTextColor;
    private float mTextSize;

    public AlaLoadingButton(@NonNull Context context) {
        super(context);
        this.mStatus = -1;
        this.bTP = new View.OnTouchListener() { // from class: com.baidu.live.view.AlaLoadingButton.1
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
        this.bTP = new View.OnTouchListener() { // from class: com.baidu.live.view.AlaLoadingButton.1
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
        this.bTP = new View.OnTouchListener() { // from class: com.baidu.live.view.AlaLoadingButton.1
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
        this.bTE = (FrameLayout) findViewById(a.f.ala_loading_button_root);
        this.bTC = (TextView) findViewById(a.f.ala_loading_button_text);
        this.bTD = (ImageView) findViewById(a.f.ala_loading_button_loading);
        setOnTouchListener(this.bTP);
        if (this.mText == null) {
            this.mText = getResources().getText(a.h.sdk_yuyin_loading_button_follow);
        } else {
            this.bTC.setText(this.mText);
        }
        if (this.bTF == null) {
            this.bTF = getResources().getText(a.h.sdk_yuyin_loading_button_followed);
        }
        if (this.mTextColor != 0) {
            this.bTC.setTextColor(this.mTextColor);
        } else {
            this.mTextColor = -1;
        }
        if (this.mTextSize != 0.0f) {
            this.bTC.setTextSize(0, this.mTextSize);
        }
        if (this.bTN != 0.0f || this.bTO != 0.0f) {
            this.bTC.setPadding((int) this.bTN, (int) this.bTO, (int) this.bTN, (int) this.bTO);
        }
        if (this.bTI != 0.0f) {
            setLoadingIconSize((int) this.bTI);
        }
        if (this.bTJ != 0) {
            this.bTD.setImageResource(this.bTJ);
        }
        if (this.bTK != 0) {
            this.bTE.setBackgroundResource(this.bTK);
        } else {
            this.bTK = a.e.ala_loading_button_nomal_bg;
        }
        if (this.bTH == 0) {
            this.bTH = Color.parseColor("#525252");
        }
    }

    public void setStatus(int i) {
        this.mStatus = i;
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        switch (i) {
            case 1:
                if (this.bTG != null && this.bTG.hasStarted()) {
                    stopAnim();
                }
                this.bTE.setBackgroundResource(this.bTK);
                this.bTC.setText(this.mText);
                this.bTC.setTextColor(this.mTextColor);
                return;
            case 2:
            default:
                return;
            case 3:
                this.bTE.setBackgroundResource(this.bTK);
                startAnim();
                return;
            case 4:
                if (this.bTG != null && this.bTG.hasStarted()) {
                    stopAnim();
                }
                this.bTE.setBackgroundResource(this.bTL != 0 ? this.bTL : a.e.ala_loading_button_done_bg);
                this.bTC.setText(this.bTF);
                this.bTC.setTextColor(this.bTH);
                return;
            case 5:
                this.bTE.setBackgroundResource(this.bTL != 0 ? this.bTM : a.e.ala_loading_button_close_done_bg);
                this.bTC.setText(this.bTF);
                this.bTC.setTextColor(-1);
                return;
        }
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setTextColor(int i) {
        if (this.bTC != null) {
            this.mTextColor = i;
            this.bTC.setTextColor(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (this.bTE != null) {
            this.bTK = i;
            this.bTE.setBackgroundResource(i);
        }
    }

    public void setText(CharSequence charSequence) {
        this.mText = charSequence;
        this.bTC.setText(charSequence);
    }

    public String getText() {
        return this.bTC == null ? "" : this.bTC.getText().toString().trim();
    }

    public void setLoadingIconResource(int i) {
        if (this.bTD != null) {
            this.bTJ = i;
            this.bTD.setImageResource(i);
        }
    }

    public void setLoadingIconSize(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = 17;
        this.bTD.setLayoutParams(layoutParams);
    }

    private void startAnim() {
        if (this.bTC != null) {
            this.bTC.setVisibility(4);
        }
        if (this.bTD != null) {
            this.bTD.setVisibility(0);
        }
        if (this.bTG == null) {
            this.bTG = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            this.bTG.setDuration(300L);
            this.bTG.setInterpolator(new LinearInterpolator());
            this.bTG.setRepeatCount(-1);
            this.bTG.setFillAfter(true);
            this.bTG.setStartOffset(10L);
        }
        if (this.bTD != null) {
            this.bTD.startAnimation(this.bTG);
        }
    }

    private void stopAnim() {
        if (this.bTC != null) {
            this.bTC.setVisibility(0);
        }
        if (this.bTD != null) {
            this.bTD.setVisibility(8);
        }
        if (this.bTG != null && this.bTD != null) {
            this.bTD.clearAnimation();
        }
    }

    private void g(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.AlaLoadingButton);
        this.mText = obtainStyledAttributes.getText(a.j.AlaLoadingButton_ala_text);
        this.bTF = obtainStyledAttributes.getText(a.j.AlaLoadingButton_ala_text_done);
        this.mTextSize = obtainStyledAttributes.getDimension(a.j.AlaLoadingButton_ala_text_size, 0.0f);
        this.bTN = obtainStyledAttributes.getDimension(a.j.AlaLoadingButton_ala_padding_lr, 0.0f);
        this.bTO = obtainStyledAttributes.getDimension(a.j.AlaLoadingButton_ala_padding_tb, 0.0f);
        this.bTI = obtainStyledAttributes.getDimension(a.j.AlaLoadingButton_ala_loading_size, 0.0f);
        this.bTJ = obtainStyledAttributes.getResourceId(a.j.AlaLoadingButton_ala_loading_icon, 0);
        this.bTK = obtainStyledAttributes.getResourceId(a.j.AlaLoadingButton_ala_background, 0);
        this.bTL = obtainStyledAttributes.getResourceId(a.j.AlaLoadingButton_ala_done_background, 0);
        this.bTM = obtainStyledAttributes.getResourceId(a.j.AlaLoadingButton_ala_close_done_background, 0);
        this.mTextColor = obtainStyledAttributes.getColor(a.j.AlaLoadingButton_ala_text_color, 0);
        this.bTH = obtainStyledAttributes.getColor(a.j.AlaLoadingButton_ala_done_text_color, 0);
        obtainStyledAttributes.recycle();
    }
}
