package com.baidu.adp.lib.guide;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.adp.lib.guide.d;
/* loaded from: classes.dex */
public class c implements View.OnClickListener, View.OnKeyListener {
    static final /* synthetic */ boolean $assertionsDisabled;
    private Configuration JC;
    private MaskView JD;
    private b[] JE;
    private d.a JF;
    private boolean mShouldCheckLocInWindow = true;
    private boolean mUseDirectOffset = false;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.JC = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.JE = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.a aVar) {
        this.JF = aVar;
    }

    public void show(Activity activity) {
        showMask((ViewGroup) activity.findViewById(16908290), activity);
    }

    private void showMask(ViewGroup viewGroup, Activity activity) {
        if (this.JD == null) {
            this.JD = m(activity);
            this.JD.setUseDirectOffset(this.mUseDirectOffset);
        }
        if (this.JD.getParent() == null) {
            viewGroup.addView(this.JD);
            if (this.JC.mEnterAnimationId != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.JC.mEnterAnimationId);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (c.this.JF != null) {
                            c.this.JF.onShown();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.JD.startAnimation(loadAnimation);
            } else if (this.JF != null) {
                this.JF.onShown();
            }
        }
    }

    public void showOnDecorView(Activity activity) {
        showMask((ViewGroup) activity.getWindow().getDecorView(), activity);
    }

    public void dismiss() {
        if (this.JD != null && (this.JD.getParent() instanceof ViewGroup)) {
            final ViewGroup viewGroup = (ViewGroup) this.JD.getParent();
            if (this.JC.mExitAnimationId != -1) {
                Context context = this.JD.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.JC.mExitAnimationId);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        viewGroup.removeView(c.this.JD);
                        if (c.this.JF != null) {
                            c.this.JF.onDismiss();
                        }
                        c.this.onDestroy();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.JD.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.JD);
            if (this.JF != null) {
                this.JF.onDismiss();
            }
            onDestroy();
        }
    }

    public void setShouldCheckLocInWindow(boolean z) {
        this.mShouldCheckLocInWindow = z;
    }

    private MaskView m(Activity activity) {
        MaskView maskView = new MaskView(activity);
        maskView.setFullingColor(activity.getResources().getColor(this.JC.mFullingColorId));
        maskView.setFullingAlpha(this.JC.mAlpha);
        maskView.setOverlayTarget(this.JC.mOverlayTarget);
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
        if (this.JC.mTargetView != null) {
            maskView.setTargetRect(a.getViewAbsRect(this.JC.mTargetView, 0, i));
        } else {
            View findViewById = activity.findViewById(this.JC.mTargetViewId);
            if (findViewById != null) {
                maskView.setTargetRect(a.getViewAbsRect(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.JC.mFullingViewId);
        if (findViewById2 != null) {
            maskView.setFullingRect(a.getViewAbsRect(findViewById2, 0, i));
        }
        if (this.JC.mOutsideTouchable) {
            maskView.setClickable(false);
        } else {
            maskView.setOnClickListener(this);
        }
        for (b bVar : this.JE) {
            maskView.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return maskView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.JC = null;
        this.JE = null;
        this.JF = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.JC == null || !this.JC.mAutoDismiss) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.JC != null && this.JC.mAutoDismiss) {
            dismiss();
        }
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }
}
