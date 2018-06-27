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
    private Configuration yI;
    private MaskView yJ;
    private b[] yK;
    private boolean yL = true;
    private boolean yM = false;
    private d.a yN;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.yI = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.yK = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.a aVar) {
        this.yN = aVar;
    }

    public void k(Activity activity) {
        a((ViewGroup) activity.findViewById(16908290), activity);
    }

    private void a(ViewGroup viewGroup, Activity activity) {
        if (this.yJ == null) {
            this.yJ = m(activity);
            this.yJ.D(this.yM);
        }
        if (this.yJ.getParent() == null) {
            viewGroup.addView(this.yJ);
            if (this.yI.yG != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.yI.yG);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (c.this.yN != null) {
                            c.this.yN.onShown();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.yJ.startAnimation(loadAnimation);
            } else if (this.yN != null) {
                this.yN.onShown();
            }
        }
    }

    public void l(Activity activity) {
        a((ViewGroup) activity.getWindow().getDecorView(), activity);
    }

    public void dismiss() {
        if (this.yJ != null && (this.yJ.getParent() instanceof ViewGroup)) {
            final ViewGroup viewGroup = (ViewGroup) this.yJ.getParent();
            if (this.yI.yH != -1) {
                Context context = this.yJ.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.yI.yH);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        viewGroup.removeView(c.this.yJ);
                        if (c.this.yN != null) {
                            c.this.yN.onDismiss();
                        }
                        c.this.onDestroy();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.yJ.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.yJ);
            if (this.yN != null) {
                this.yN.onDismiss();
            }
            onDestroy();
        }
    }

    public void C(boolean z) {
        this.yL = z;
    }

    private MaskView m(Activity activity) {
        MaskView maskView = new MaskView(activity);
        maskView.aa(activity.getResources().getColor(this.yI.yC));
        maskView.Z(this.yI.mAlpha);
        maskView.H(this.yI.yE);
        maskView.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.yL && i == 0) {
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
        if (this.yI.mTargetView != null) {
            maskView.b(a.a(this.yI.mTargetView, 0, i));
        } else {
            View findViewById = activity.findViewById(this.yI.yB);
            if (findViewById != null) {
                maskView.b(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.yI.yA);
        if (findViewById2 != null) {
            maskView.c(a.a(findViewById2, 0, i));
        }
        if (this.yI.yz) {
            maskView.setClickable(false);
        } else {
            maskView.setOnClickListener(this);
        }
        for (b bVar : this.yK) {
            maskView.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return maskView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.yI = null;
        this.yK = null;
        this.yN = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.yI == null || !this.yI.yD) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.yI != null && this.yI.yD) {
            dismiss();
        }
    }

    public void D(boolean z) {
        this.yM = z;
    }
}
