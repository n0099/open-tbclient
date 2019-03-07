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
    private Configuration BK;
    private MaskView BL;
    private b[] BM;
    private boolean BN = true;
    private boolean BO = false;
    private d.a BP;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.BK = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.BM = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.a aVar) {
        this.BP = aVar;
    }

    public void n(Activity activity) {
        a((ViewGroup) activity.findViewById(16908290), activity);
    }

    private void a(ViewGroup viewGroup, Activity activity) {
        if (this.BL == null) {
            this.BL = p(activity);
            this.BL.aa(this.BO);
        }
        if (this.BL.getParent() == null) {
            viewGroup.addView(this.BL);
            if (this.BK.BI != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.BK.BI);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (c.this.BP != null) {
                            c.this.BP.onShown();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.BL.startAnimation(loadAnimation);
            } else if (this.BP != null) {
                this.BP.onShown();
            }
        }
    }

    public void o(Activity activity) {
        a((ViewGroup) activity.getWindow().getDecorView(), activity);
    }

    public void dismiss() {
        if (this.BL != null && (this.BL.getParent() instanceof ViewGroup)) {
            final ViewGroup viewGroup = (ViewGroup) this.BL.getParent();
            if (this.BK.BJ != -1) {
                Context context = this.BL.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.BK.BJ);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        viewGroup.removeView(c.this.BL);
                        if (c.this.BP != null) {
                            c.this.BP.onDismiss();
                        }
                        c.this.onDestroy();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.BL.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.BL);
            if (this.BP != null) {
                this.BP.onDismiss();
            }
            onDestroy();
        }
    }

    public void Z(boolean z) {
        this.BN = z;
    }

    private MaskView p(Activity activity) {
        MaskView maskView = new MaskView(activity);
        maskView.ai(activity.getResources().getColor(this.BK.BE));
        maskView.ah(this.BK.mAlpha);
        maskView.ae(this.BK.BG);
        maskView.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.BN && i == 0) {
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
        if (this.BK.mTargetView != null) {
            maskView.b(a.a(this.BK.mTargetView, 0, i));
        } else {
            View findViewById = activity.findViewById(this.BK.BD);
            if (findViewById != null) {
                maskView.b(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.BK.BC);
        if (findViewById2 != null) {
            maskView.c(a.a(findViewById2, 0, i));
        }
        if (this.BK.BB) {
            maskView.setClickable(false);
        } else {
            maskView.setOnClickListener(this);
        }
        for (b bVar : this.BM) {
            maskView.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return maskView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.BK = null;
        this.BM = null;
        this.BP = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.BK == null || !this.BK.BF) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.BK != null && this.BK.BF) {
            dismiss();
        }
    }

    public void aa(boolean z) {
        this.BO = z;
    }
}
