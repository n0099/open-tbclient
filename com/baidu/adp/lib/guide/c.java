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
    private boolean zA = true;
    private boolean zB = false;
    private d.a zC;
    private Configuration zx;
    private MaskView zy;
    private b[] zz;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.zx = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.zz = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.a aVar) {
        this.zC = aVar;
    }

    public void q(Activity activity) {
        a((ViewGroup) activity.findViewById(16908290), activity);
    }

    private void a(ViewGroup viewGroup, Activity activity) {
        if (this.zy == null) {
            this.zy = s(activity);
            this.zy.S(this.zB);
        }
        if (this.zy.getParent() == null) {
            viewGroup.addView(this.zy);
            if (this.zx.zv != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.zx.zv);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (c.this.zC != null) {
                            c.this.zC.onShown();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.zy.startAnimation(loadAnimation);
            } else if (this.zC != null) {
                this.zC.onShown();
            }
        }
    }

    public void r(Activity activity) {
        a((ViewGroup) activity.getWindow().getDecorView(), activity);
    }

    public void dismiss() {
        if (this.zy != null && (this.zy.getParent() instanceof ViewGroup)) {
            final ViewGroup viewGroup = (ViewGroup) this.zy.getParent();
            if (this.zx.zw != -1) {
                Context context = this.zy.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.zx.zw);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        viewGroup.removeView(c.this.zy);
                        if (c.this.zC != null) {
                            c.this.zC.onDismiss();
                        }
                        c.this.onDestroy();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.zy.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.zy);
            if (this.zC != null) {
                this.zC.onDismiss();
            }
            onDestroy();
        }
    }

    public void R(boolean z) {
        this.zA = z;
    }

    private MaskView s(Activity activity) {
        MaskView maskView = new MaskView(activity);
        maskView.aa(activity.getResources().getColor(this.zx.zr));
        maskView.Z(this.zx.mAlpha);
        maskView.W(this.zx.zt);
        maskView.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.zA && i == 0) {
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
        if (this.zx.mTargetView != null) {
            maskView.b(a.a(this.zx.mTargetView, 0, i));
        } else {
            View findViewById = activity.findViewById(this.zx.zq);
            if (findViewById != null) {
                maskView.b(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.zx.zp);
        if (findViewById2 != null) {
            maskView.c(a.a(findViewById2, 0, i));
        }
        if (this.zx.zo) {
            maskView.setClickable(false);
        } else {
            maskView.setOnClickListener(this);
        }
        for (b bVar : this.zz) {
            maskView.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return maskView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.zx = null;
        this.zz = null;
        this.zC = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.zx == null || !this.zx.zs) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.zx != null && this.zx.zs) {
            dismiss();
        }
    }

    public void S(boolean z) {
        this.zB = z;
    }
}
