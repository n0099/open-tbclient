package com.baidu.searchbox.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
/* loaded from: classes4.dex */
public class CollapsiblePanel extends LinearLayout {
    public static final boolean DEBUG = false;
    public static final String TAG = "CollapsiblePanel";
    public int mAnimDuration;
    public Animation.AnimationListener mCollapsibleAnimListener;
    public OnCollapsibleListener mCollapsibleListener;
    public int mCollapsibleSize;
    public View mCollapsibleView;
    public boolean mCollapsibleViewDefaultVisible;
    public View mContentView;
    public boolean mIsOpened;
    public boolean mToggleEnable;

    /* loaded from: classes4.dex */
    public interface OnCollapsibleListener {
        void applyTransformation(int i, int i2, float f);

        void onCollapsibleResult(boolean z);

        void onCollapsibleStatusChange(boolean z);
    }

    public void onCollapsibleFinished(boolean z) {
    }

    /* loaded from: classes4.dex */
    public class CollapsibleAnimation extends Animation {
        public float mFromAlpha;
        public int mFromSize;
        public float mToAlpha;
        public int mToSize;

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }

        public CollapsibleAnimation(int i, int i2, float f, float f2) {
            this.mFromSize = i;
            this.mToSize = i2;
            this.mFromAlpha = f;
            this.mToAlpha = f2;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            if (CollapsiblePanel.this.mCollapsibleView != null) {
                float f2 = this.mFromAlpha;
                transformation.setAlpha(f2 + ((this.mToAlpha - f2) * f));
                int i = this.mFromSize;
                CollapsiblePanel.this.setCollapsibleViewSize((int) (i + ((this.mToSize - i) * f)));
                if (CollapsiblePanel.this.mCollapsibleListener != null) {
                    CollapsiblePanel.this.mCollapsibleListener.applyTransformation(this.mFromSize, this.mToSize, f);
                }
            }
        }
    }

    public CollapsiblePanel(Context context) {
        super(context);
        this.mAnimDuration = 0;
        this.mIsOpened = false;
        this.mCollapsibleViewDefaultVisible = false;
        this.mToggleEnable = true;
        this.mCollapsibleAnimListener = new Animation.AnimationListener() { // from class: com.baidu.searchbox.ui.CollapsiblePanel.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (CollapsiblePanel.this.mCollapsibleListener != null) {
                    CollapsiblePanel.this.mCollapsibleListener.onCollapsibleStatusChange(true);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                CollapsiblePanel collapsiblePanel = CollapsiblePanel.this;
                collapsiblePanel.mIsOpened = !collapsiblePanel.mIsOpened;
                if (CollapsiblePanel.this.mCollapsibleListener != null) {
                    CollapsiblePanel.this.mCollapsibleListener.onCollapsibleStatusChange(false);
                    CollapsiblePanel.this.mCollapsibleListener.onCollapsibleResult(CollapsiblePanel.this.mIsOpened);
                }
                if (CollapsiblePanel.this.mCollapsibleView != null) {
                    CollapsiblePanel.this.mCollapsibleView.setAnimation(null);
                }
                CollapsiblePanel collapsiblePanel2 = CollapsiblePanel.this;
                collapsiblePanel2.onCollapsibleFinished(collapsiblePanel2.mIsOpened);
            }
        };
        init(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCollapsibleViewSize(int i) {
        LinearLayout.LayoutParams layoutParams;
        View view2 = this.mCollapsibleView;
        if (view2 != null && (layoutParams = (LinearLayout.LayoutParams) view2.getLayoutParams()) != null) {
            if (1 == getOrientation()) {
                layoutParams.height = i;
            } else {
                layoutParams.width = i;
            }
            this.mCollapsibleView.setLayoutParams(layoutParams);
        }
    }

    public void setCollapsibleAnimDuration(int i) {
        if (i >= 0) {
            this.mAnimDuration = i;
        }
    }

    public void setCollapsibleView(View view2) {
        if (view2 != null) {
            View view3 = this.mCollapsibleView;
            if (view3 != null) {
                removeView(view3);
                this.mCollapsibleSize = 0;
            }
            this.mCollapsibleView = view2;
            addView(view2);
        }
    }

    public void setCollapsibleViewDefaultVisible(boolean z) {
        this.mCollapsibleViewDefaultVisible = z;
        this.mIsOpened = z;
    }

    public void setContentView(View view2) {
        if (view2 != null) {
            View view3 = this.mContentView;
            if (view3 != null) {
                removeView(view3);
            }
            this.mContentView = view2;
            addView(view2, 0);
        }
    }

    public void setOnCollapsibleListener(OnCollapsibleListener onCollapsibleListener) {
        this.mCollapsibleListener = onCollapsibleListener;
    }

    public void setToggleEnable(boolean z) {
        this.mToggleEnable = z;
    }

    public CollapsiblePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAnimDuration = 0;
        this.mIsOpened = false;
        this.mCollapsibleViewDefaultVisible = false;
        this.mToggleEnable = true;
        this.mCollapsibleAnimListener = new Animation.AnimationListener() { // from class: com.baidu.searchbox.ui.CollapsiblePanel.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (CollapsiblePanel.this.mCollapsibleListener != null) {
                    CollapsiblePanel.this.mCollapsibleListener.onCollapsibleStatusChange(true);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                CollapsiblePanel collapsiblePanel = CollapsiblePanel.this;
                collapsiblePanel.mIsOpened = !collapsiblePanel.mIsOpened;
                if (CollapsiblePanel.this.mCollapsibleListener != null) {
                    CollapsiblePanel.this.mCollapsibleListener.onCollapsibleStatusChange(false);
                    CollapsiblePanel.this.mCollapsibleListener.onCollapsibleResult(CollapsiblePanel.this.mIsOpened);
                }
                if (CollapsiblePanel.this.mCollapsibleView != null) {
                    CollapsiblePanel.this.mCollapsibleView.setAnimation(null);
                }
                CollapsiblePanel collapsiblePanel2 = CollapsiblePanel.this;
                collapsiblePanel2.onCollapsibleFinished(collapsiblePanel2.mIsOpened);
            }
        };
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setOrientation(1);
        this.mAnimDuration = context.getResources().getInteger(com.baidu.tieba.R.integer.obfuscated_res_0x7f0a0012);
    }

    @SuppressLint({"NewApi", "suppressNewApi"})
    @TargetApi(11)
    public CollapsiblePanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAnimDuration = 0;
        this.mIsOpened = false;
        this.mCollapsibleViewDefaultVisible = false;
        this.mToggleEnable = true;
        this.mCollapsibleAnimListener = new Animation.AnimationListener() { // from class: com.baidu.searchbox.ui.CollapsiblePanel.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (CollapsiblePanel.this.mCollapsibleListener != null) {
                    CollapsiblePanel.this.mCollapsibleListener.onCollapsibleStatusChange(true);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                CollapsiblePanel collapsiblePanel = CollapsiblePanel.this;
                collapsiblePanel.mIsOpened = !collapsiblePanel.mIsOpened;
                if (CollapsiblePanel.this.mCollapsibleListener != null) {
                    CollapsiblePanel.this.mCollapsibleListener.onCollapsibleStatusChange(false);
                    CollapsiblePanel.this.mCollapsibleListener.onCollapsibleResult(CollapsiblePanel.this.mIsOpened);
                }
                if (CollapsiblePanel.this.mCollapsibleView != null) {
                    CollapsiblePanel.this.mCollapsibleView.setAnimation(null);
                }
                CollapsiblePanel collapsiblePanel2 = CollapsiblePanel.this;
                collapsiblePanel2.onCollapsibleFinished(collapsiblePanel2.mIsOpened);
            }
        };
        init(context, attributeSet);
    }

    private boolean isAnimationPlaying() {
        Animation animation;
        View view2 = this.mCollapsibleView;
        if (view2 != null && (animation = view2.getAnimation()) != null && !animation.hasEnded()) {
            return true;
        }
        return false;
    }

    public void closeCollapsibleView() {
        if (this.mCollapsibleView == null) {
            return;
        }
        post(new Runnable() { // from class: com.baidu.searchbox.ui.CollapsiblePanel.2
            @Override // java.lang.Runnable
            public void run() {
                CollapsiblePanel collapsiblePanel = CollapsiblePanel.this;
                CollapsibleAnimation collapsibleAnimation = new CollapsibleAnimation(collapsiblePanel.mCollapsibleSize, 0, 1.0f, 0.0f);
                collapsibleAnimation.setDuration(CollapsiblePanel.this.mAnimDuration);
                collapsibleAnimation.setAnimationListener(CollapsiblePanel.this.mCollapsibleAnimListener);
                CollapsiblePanel.this.mCollapsibleView.startAnimation(collapsibleAnimation);
                CollapsiblePanel.this.invalidate();
            }
        });
    }

    public int getCollapsibleSize() {
        return this.mCollapsibleSize;
    }

    public boolean getCollapsibleViewDefaultVisible() {
        return this.mCollapsibleViewDefaultVisible;
    }

    public View getContentView() {
        return this.mContentView;
    }

    public View getStretchView() {
        return this.mCollapsibleView;
    }

    public boolean isCollapsibleViewOpened() {
        return this.mIsOpened;
    }

    public void openCollapsibleView() {
        if (this.mCollapsibleView == null) {
            return;
        }
        post(new Runnable() { // from class: com.baidu.searchbox.ui.CollapsiblePanel.1
            @Override // java.lang.Runnable
            public void run() {
                CollapsiblePanel collapsiblePanel = CollapsiblePanel.this;
                CollapsibleAnimation collapsibleAnimation = new CollapsibleAnimation(0, collapsiblePanel.mCollapsibleSize, 0.0f, 1.0f);
                collapsibleAnimation.setDuration(CollapsiblePanel.this.mAnimDuration);
                collapsibleAnimation.setAnimationListener(CollapsiblePanel.this.mCollapsibleAnimListener);
                CollapsiblePanel.this.mCollapsibleView.startAnimation(collapsibleAnimation);
                CollapsiblePanel.this.invalidate();
            }
        });
    }

    public boolean toggle() {
        if (!this.mToggleEnable || isAnimationPlaying()) {
            return false;
        }
        if (this.mIsOpened) {
            closeCollapsibleView();
            return true;
        }
        openCollapsibleView();
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        View view2;
        if (this.mCollapsibleSize == 0 && (view2 = this.mCollapsibleView) != null) {
            view2.measure(i, 0);
            if (1 == getOrientation()) {
                this.mCollapsibleSize = this.mCollapsibleView.getMeasuredHeight();
                if (!this.mCollapsibleViewDefaultVisible) {
                    this.mCollapsibleView.getLayoutParams().height = 0;
                }
            } else {
                this.mCollapsibleSize = this.mCollapsibleView.getMeasuredWidth();
                if (!this.mCollapsibleViewDefaultVisible) {
                    this.mCollapsibleView.getLayoutParams().width = 0;
                }
            }
        }
        super.onMeasure(i, i2);
    }
}
