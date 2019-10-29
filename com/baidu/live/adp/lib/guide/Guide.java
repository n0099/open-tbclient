package com.baidu.live.adp.lib.guide;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.live.adp.lib.guide.GuideBuilder;
/* loaded from: classes6.dex */
public class Guide implements View.OnClickListener, View.OnKeyListener {
    static final /* synthetic */ boolean $assertionsDisabled;
    private Component[] mComponents;
    private Configuration mConfiguration;
    private MaskView mMaskView;
    private GuideBuilder.OnVisibilityChangedListener mOnVisibilityChangedListener;
    private boolean mShouldCheckLocInWindow = true;
    private boolean mUseDirectOffset = false;

    static {
        $assertionsDisabled = !Guide.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConfiguration(Configuration configuration) {
        this.mConfiguration = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setComponents(Component[] componentArr) {
        this.mComponents = componentArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCallback(GuideBuilder.OnVisibilityChangedListener onVisibilityChangedListener) {
        this.mOnVisibilityChangedListener = onVisibilityChangedListener;
    }

    public void show(Activity activity) {
        showMask((ViewGroup) activity.findViewById(16908290), activity);
    }

    private void showMask(ViewGroup viewGroup, Activity activity) {
        if (this.mMaskView == null) {
            this.mMaskView = onCreateView(activity);
            this.mMaskView.setUseDirectOffset(this.mUseDirectOffset);
        }
        if (this.mMaskView.getParent() == null) {
            viewGroup.addView(this.mMaskView);
            if (this.mConfiguration.mEnterAnimationId != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.mConfiguration.mEnterAnimationId);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.adp.lib.guide.Guide.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (Guide.this.mOnVisibilityChangedListener != null) {
                            Guide.this.mOnVisibilityChangedListener.onShown();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.mMaskView.startAnimation(loadAnimation);
            } else if (this.mOnVisibilityChangedListener != null) {
                this.mOnVisibilityChangedListener.onShown();
            }
        }
    }

    public void showOnDecorView(Activity activity) {
        showMask((ViewGroup) activity.getWindow().getDecorView(), activity);
    }

    public void dismiss() {
        if (this.mMaskView != null && (this.mMaskView.getParent() instanceof ViewGroup)) {
            final ViewGroup viewGroup = (ViewGroup) this.mMaskView.getParent();
            if (this.mConfiguration.mExitAnimationId != -1) {
                Context context = this.mMaskView.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.mConfiguration.mExitAnimationId);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.adp.lib.guide.Guide.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        viewGroup.removeView(Guide.this.mMaskView);
                        if (Guide.this.mOnVisibilityChangedListener != null) {
                            Guide.this.mOnVisibilityChangedListener.onDismiss();
                        }
                        Guide.this.onDestroy();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.mMaskView.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.mMaskView);
            if (this.mOnVisibilityChangedListener != null) {
                this.mOnVisibilityChangedListener.onDismiss();
            }
            onDestroy();
        }
    }

    public void setShouldCheckLocInWindow(boolean z) {
        this.mShouldCheckLocInWindow = z;
    }

    private MaskView onCreateView(Activity activity) {
        MaskView maskView = new MaskView(activity);
        maskView.setFullingColor(activity.getResources().getColor(this.mConfiguration.mFullingColorId));
        maskView.setFullingAlpha(this.mConfiguration.mAlpha);
        maskView.setOverlayTarget(this.mConfiguration.mOverlayTarget);
        maskView.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.mShouldCheckLocInWindow && i == 0) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                i = activity.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            } catch (InstantiationException e4) {
                e4.printStackTrace();
            } catch (NoSuchFieldException e5) {
                e5.printStackTrace();
            } catch (NumberFormatException e6) {
                e6.printStackTrace();
            } catch (SecurityException e7) {
                e7.printStackTrace();
            }
        }
        if (this.mConfiguration.mTargetView != null) {
            maskView.setTargetRect(Common.getViewAbsRect(this.mConfiguration.mTargetView, 0, i));
        } else {
            View findViewById = activity.findViewById(this.mConfiguration.mTargetViewId);
            if (findViewById != null) {
                maskView.setTargetRect(Common.getViewAbsRect(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.mConfiguration.mFullingViewId);
        if (findViewById2 != null) {
            maskView.setFullingRect(Common.getViewAbsRect(findViewById2, 0, i));
        }
        if (this.mConfiguration.mOutsideTouchable) {
            maskView.setClickable(false);
        } else {
            maskView.setOnClickListener(this);
        }
        for (Component component : this.mComponents) {
            maskView.addView(Common.componentToView(activity.getLayoutInflater(), component));
        }
        return maskView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.mConfiguration = null;
        this.mComponents = null;
        this.mOnVisibilityChangedListener = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.mConfiguration == null || !this.mConfiguration.mAutoDismiss) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mConfiguration != null && this.mConfiguration.mAutoDismiss) {
            dismiss();
        }
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }
}
