package com.baidu.adp.lib.guide;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.adp.lib.guide.d;
/* loaded from: classes.dex */
public class c implements View.OnClickListener, View.OnKeyListener {
    static final /* synthetic */ boolean $assertionsDisabled;
    private Configuration MU;
    private MaskView MV;
    private b[] MW;
    private d.a MX;
    private boolean mShouldCheckLocInWindow = true;
    private boolean mUseDirectOffset = false;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.MU = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.MW = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.a aVar) {
        this.MX = aVar;
    }

    public void show(Activity activity) {
        d(activity, true);
    }

    public void d(Activity activity, boolean z) {
        a((ViewGroup) activity.findViewById(16908290), activity, z);
    }

    public void a(Activity activity, ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            if (!z) {
                viewGroup.setFocusable(false);
                viewGroup.setFocusableInTouchMode(false);
                viewGroup.clearFocus();
            }
            for (b bVar : this.MW) {
                View view = bVar.getView(activity.getLayoutInflater());
                if (view.getParent() == null) {
                    viewGroup.addView(view);
                }
            }
            if (this.MU.mEnterAnimationId == -1) {
                if (this.MX != null) {
                    this.MX.onShown();
                    return;
                }
                return;
            }
            Animation animation = null;
            try {
                animation = AnimationUtils.loadAnimation(activity, this.MU.mEnterAnimationId);
            } catch (Resources.NotFoundException e) {
            }
            if (animation == null) {
                if (this.MX != null) {
                    this.MX.onShown();
                    return;
                }
                return;
            }
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation2) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation2) {
                    if (c.this.MX != null) {
                        c.this.MX.onShown();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation2) {
                }
            });
            viewGroup.startAnimation(animation);
        }
    }

    public void d(final ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.MU.mExitAnimationId != -1) {
                Context context = viewGroup.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.MU.mExitAnimationId);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        viewGroup.removeAllViews();
                        if (c.this.MX != null) {
                            c.this.MX.onDismiss();
                        }
                        c.this.onDestroy();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                viewGroup.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeAllViews();
            if (this.MX != null) {
                this.MX.onDismiss();
            }
            onDestroy();
        }
    }

    private void a(ViewGroup viewGroup, Activity activity, boolean z) {
        if (this.MV == null) {
            this.MV = m(activity);
            this.MV.setUseDirectOffset(this.mUseDirectOffset);
            if (!z) {
                this.MV.setFocusable(false);
                this.MV.setFocusableInTouchMode(false);
                this.MV.clearFocus();
            }
        }
        if (this.MV.getParent() == null) {
            viewGroup.addView(this.MV);
            if (this.MU.mEnterAnimationId != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.MU.mEnterAnimationId);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.3
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (c.this.MX != null) {
                            c.this.MX.onShown();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.MV.startAnimation(loadAnimation);
            } else if (this.MX != null) {
                this.MX.onShown();
            }
        }
    }

    public void showOnDecorView(Activity activity) {
        a((ViewGroup) activity.getWindow().getDecorView(), activity, true);
    }

    public void dismiss() {
        if (this.MV != null && (this.MV.getParent() instanceof ViewGroup)) {
            final ViewGroup viewGroup = (ViewGroup) this.MV.getParent();
            if (this.MU.mExitAnimationId != -1) {
                Context context = this.MV.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.MU.mExitAnimationId);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        viewGroup.removeView(c.this.MV);
                        if (c.this.MX != null) {
                            c.this.MX.onDismiss();
                        }
                        c.this.onDestroy();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.MV.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.MV);
            if (this.MX != null) {
                this.MX.onDismiss();
            }
            onDestroy();
        }
    }

    public void setShouldCheckLocInWindow(boolean z) {
        this.mShouldCheckLocInWindow = z;
    }

    private MaskView m(Activity activity) {
        MaskView maskView = new MaskView(activity);
        maskView.setFullingColor(activity.getResources().getColor(this.MU.mFullingColorId));
        maskView.setFullingAlpha(this.MU.mAlpha);
        maskView.setOverlayTarget(this.MU.mOverlayTarget);
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
        if (this.MU.mTargetView != null) {
            maskView.setTargetRect(a.getViewAbsRect(this.MU.mTargetView, 0, i));
        } else {
            View findViewById = activity.findViewById(this.MU.mTargetViewId);
            if (findViewById != null) {
                maskView.setTargetRect(a.getViewAbsRect(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.MU.mFullingViewId);
        if (findViewById2 != null) {
            maskView.setFullingRect(a.getViewAbsRect(findViewById2, 0, i));
        }
        if (this.MU.mOutsideTouchable) {
            maskView.setClickable(false);
        } else {
            maskView.setOnClickListener(this);
        }
        for (b bVar : this.MW) {
            maskView.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return maskView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.MU = null;
        this.MW = null;
        this.MX = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.MU == null || !this.MU.mAutoDismiss) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.MU != null && this.MU.mAutoDismiss) {
            dismiss();
        }
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }
}
