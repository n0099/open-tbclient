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
    private Configuration yE;
    private MaskView yF;
    private b[] yG;
    private boolean yH = true;
    private boolean yI = false;
    private d.a yJ;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.yE = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.yG = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.a aVar) {
        this.yJ = aVar;
    }

    public void j(Activity activity) {
        a((ViewGroup) activity.findViewById(16908290), activity);
    }

    private void a(ViewGroup viewGroup, Activity activity) {
        if (this.yF == null) {
            this.yF = l(activity);
            this.yF.C(this.yI);
        }
        if (this.yF.getParent() == null) {
            viewGroup.addView(this.yF);
            if (this.yE.yC != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.yE.yC);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (c.this.yJ != null) {
                            c.this.yJ.onShown();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.yF.startAnimation(loadAnimation);
            } else if (this.yJ != null) {
                this.yJ.onShown();
            }
        }
    }

    public void k(Activity activity) {
        a((ViewGroup) activity.getWindow().getDecorView(), activity);
    }

    public void dismiss() {
        if (this.yF != null && (this.yF.getParent() instanceof ViewGroup)) {
            final ViewGroup viewGroup = (ViewGroup) this.yF.getParent();
            if (this.yE.yD != -1) {
                Context context = this.yF.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.yE.yD);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        viewGroup.removeView(c.this.yF);
                        if (c.this.yJ != null) {
                            c.this.yJ.onDismiss();
                        }
                        c.this.onDestroy();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.yF.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.yF);
            if (this.yJ != null) {
                this.yJ.onDismiss();
            }
            onDestroy();
        }
    }

    public void B(boolean z) {
        this.yH = z;
    }

    private MaskView l(Activity activity) {
        MaskView maskView = new MaskView(activity);
        maskView.aa(activity.getResources().getColor(this.yE.yy));
        maskView.Z(this.yE.mAlpha);
        maskView.G(this.yE.yA);
        maskView.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.yH && i == 0) {
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
        if (this.yE.mTargetView != null) {
            maskView.b(a.a(this.yE.mTargetView, 0, i));
        } else {
            View findViewById = activity.findViewById(this.yE.yx);
            if (findViewById != null) {
                maskView.b(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.yE.yw);
        if (findViewById2 != null) {
            maskView.c(a.a(findViewById2, 0, i));
        }
        if (this.yE.yv) {
            maskView.setClickable(false);
        } else {
            maskView.setOnClickListener(this);
        }
        for (b bVar : this.yG) {
            maskView.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return maskView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.yE = null;
        this.yG = null;
        this.yJ = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.yE == null || !this.yE.yz) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.yE != null && this.yE.yz) {
            dismiss();
        }
    }

    public void C(boolean z) {
        this.yI = z;
    }
}
