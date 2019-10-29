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
    private boolean mShouldCheckLocInWindow = true;
    private boolean mUseDirectOffset = false;
    private d.a oA;
    private Configuration ox;
    private MaskView oy;
    private b[] oz;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.ox = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.oz = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.a aVar) {
        this.oA = aVar;
    }

    public void show(Activity activity) {
        showMask((ViewGroup) activity.findViewById(16908290), activity);
    }

    private void showMask(ViewGroup viewGroup, Activity activity) {
        if (this.oy == null) {
            this.oy = o(activity);
            this.oy.setUseDirectOffset(this.mUseDirectOffset);
        }
        if (this.oy.getParent() == null) {
            viewGroup.addView(this.oy);
            if (this.ox.mEnterAnimationId != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.ox.mEnterAnimationId);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (c.this.oA != null) {
                            c.this.oA.onShown();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.oy.startAnimation(loadAnimation);
            } else if (this.oA != null) {
                this.oA.onShown();
            }
        }
    }

    public void showOnDecorView(Activity activity) {
        showMask((ViewGroup) activity.getWindow().getDecorView(), activity);
    }

    public void dismiss() {
        if (this.oy != null && (this.oy.getParent() instanceof ViewGroup)) {
            final ViewGroup viewGroup = (ViewGroup) this.oy.getParent();
            if (this.ox.mExitAnimationId != -1) {
                Context context = this.oy.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.ox.mExitAnimationId);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        viewGroup.removeView(c.this.oy);
                        if (c.this.oA != null) {
                            c.this.oA.onDismiss();
                        }
                        c.this.onDestroy();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.oy.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.oy);
            if (this.oA != null) {
                this.oA.onDismiss();
            }
            onDestroy();
        }
    }

    public void setShouldCheckLocInWindow(boolean z) {
        this.mShouldCheckLocInWindow = z;
    }

    private MaskView o(Activity activity) {
        MaskView maskView = new MaskView(activity);
        maskView.setFullingColor(activity.getResources().getColor(this.ox.mFullingColorId));
        maskView.setFullingAlpha(this.ox.mAlpha);
        maskView.setOverlayTarget(this.ox.mOverlayTarget);
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
        if (this.ox.mTargetView != null) {
            maskView.setTargetRect(a.getViewAbsRect(this.ox.mTargetView, 0, i));
        } else {
            View findViewById = activity.findViewById(this.ox.mTargetViewId);
            if (findViewById != null) {
                maskView.setTargetRect(a.getViewAbsRect(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.ox.mFullingViewId);
        if (findViewById2 != null) {
            maskView.setFullingRect(a.getViewAbsRect(findViewById2, 0, i));
        }
        if (this.ox.mOutsideTouchable) {
            maskView.setClickable(false);
        } else {
            maskView.setOnClickListener(this);
        }
        for (b bVar : this.oz) {
            maskView.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return maskView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.ox = null;
        this.oz = null;
        this.oA = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.ox == null || !this.ox.mAutoDismiss) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ox != null && this.ox.mAutoDismiss) {
            dismiss();
        }
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }
}
