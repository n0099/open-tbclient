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
    private Configuration yD;
    private MaskView yE;
    private b[] yF;
    private boolean yG = true;
    private boolean yH = false;
    private d.a yI;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.yD = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.yF = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.a aVar) {
        this.yI = aVar;
    }

    public void k(Activity activity) {
        a((ViewGroup) activity.findViewById(16908290), activity);
    }

    private void a(ViewGroup viewGroup, Activity activity) {
        if (this.yE == null) {
            this.yE = m(activity);
            this.yE.C(this.yH);
        }
        if (this.yE.getParent() == null) {
            viewGroup.addView(this.yE);
            if (this.yD.yB != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.yD.yB);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (c.this.yI != null) {
                            c.this.yI.onShown();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.yE.startAnimation(loadAnimation);
            } else if (this.yI != null) {
                this.yI.onShown();
            }
        }
    }

    public void l(Activity activity) {
        a((ViewGroup) activity.getWindow().getDecorView(), activity);
    }

    public void dismiss() {
        if (this.yE != null && (this.yE.getParent() instanceof ViewGroup)) {
            final ViewGroup viewGroup = (ViewGroup) this.yE.getParent();
            if (this.yD.yC != -1) {
                Context context = this.yE.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.yD.yC);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        viewGroup.removeView(c.this.yE);
                        if (c.this.yI != null) {
                            c.this.yI.onDismiss();
                        }
                        c.this.onDestroy();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.yE.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.yE);
            if (this.yI != null) {
                this.yI.onDismiss();
            }
            onDestroy();
        }
    }

    public void B(boolean z) {
        this.yG = z;
    }

    private MaskView m(Activity activity) {
        MaskView maskView = new MaskView(activity);
        maskView.aa(activity.getResources().getColor(this.yD.yx));
        maskView.Z(this.yD.mAlpha);
        maskView.G(this.yD.yz);
        maskView.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.yG && i == 0) {
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
        if (this.yD.mTargetView != null) {
            maskView.b(a.a(this.yD.mTargetView, 0, i));
        } else {
            View findViewById = activity.findViewById(this.yD.yw);
            if (findViewById != null) {
                maskView.b(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.yD.yv);
        if (findViewById2 != null) {
            maskView.c(a.a(findViewById2, 0, i));
        }
        if (this.yD.yu) {
            maskView.setClickable(false);
        } else {
            maskView.setOnClickListener(this);
        }
        for (b bVar : this.yF) {
            maskView.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return maskView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.yD = null;
        this.yF = null;
        this.yI = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.yD == null || !this.yD.yy) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.yD != null && this.yD.yy) {
            dismiss();
        }
    }

    public void C(boolean z) {
        this.yH = z;
    }
}
