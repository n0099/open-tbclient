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
    private Configuration KG;
    private MaskView KH;
    private b[] KI;
    private d.a KJ;
    private boolean mShouldCheckLocInWindow = true;
    private boolean mUseDirectOffset = false;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.KG = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.KI = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.a aVar) {
        this.KJ = aVar;
    }

    public void show(Activity activity) {
        d(activity, true);
    }

    public void d(Activity activity, boolean z) {
        a((ViewGroup) activity.findViewById(16908290), activity, z);
    }

    private void a(ViewGroup viewGroup, Activity activity, boolean z) {
        if (this.KH == null) {
            this.KH = n(activity);
            this.KH.setUseDirectOffset(this.mUseDirectOffset);
            if (!z) {
                this.KH.setFocusable(false);
                this.KH.setFocusableInTouchMode(false);
                this.KH.clearFocus();
            }
        }
        if (this.KH.getParent() == null) {
            viewGroup.addView(this.KH);
            if (this.KG.mEnterAnimationId != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.KG.mEnterAnimationId);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (c.this.KJ != null) {
                            c.this.KJ.onShown();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.KH.startAnimation(loadAnimation);
            } else if (this.KJ != null) {
                this.KJ.onShown();
            }
        }
    }

    public void showOnDecorView(Activity activity) {
        a((ViewGroup) activity.getWindow().getDecorView(), activity, true);
    }

    public void dismiss() {
        if (this.KH != null && (this.KH.getParent() instanceof ViewGroup)) {
            final ViewGroup viewGroup = (ViewGroup) this.KH.getParent();
            if (this.KG.mExitAnimationId != -1) {
                Context context = this.KH.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.KG.mExitAnimationId);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        viewGroup.removeView(c.this.KH);
                        if (c.this.KJ != null) {
                            c.this.KJ.onDismiss();
                        }
                        c.this.onDestroy();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.KH.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.KH);
            if (this.KJ != null) {
                this.KJ.onDismiss();
            }
            onDestroy();
        }
    }

    public void setShouldCheckLocInWindow(boolean z) {
        this.mShouldCheckLocInWindow = z;
    }

    private MaskView n(Activity activity) {
        MaskView maskView = new MaskView(activity);
        maskView.setFullingColor(activity.getResources().getColor(this.KG.mFullingColorId));
        maskView.setFullingAlpha(this.KG.mAlpha);
        maskView.setOverlayTarget(this.KG.mOverlayTarget);
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
        if (this.KG.mTargetView != null) {
            maskView.setTargetRect(a.getViewAbsRect(this.KG.mTargetView, 0, i));
        } else {
            View findViewById = activity.findViewById(this.KG.mTargetViewId);
            if (findViewById != null) {
                maskView.setTargetRect(a.getViewAbsRect(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.KG.mFullingViewId);
        if (findViewById2 != null) {
            maskView.setFullingRect(a.getViewAbsRect(findViewById2, 0, i));
        }
        if (this.KG.mOutsideTouchable) {
            maskView.setClickable(false);
        } else {
            maskView.setOnClickListener(this);
        }
        for (b bVar : this.KI) {
            maskView.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return maskView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.KG = null;
        this.KI = null;
        this.KJ = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.KG == null || !this.KG.mAutoDismiss) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.KG != null && this.KG.mAutoDismiss) {
            dismiss();
        }
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }
}
