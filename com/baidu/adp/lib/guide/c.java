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
    private Configuration ail;
    private e aim;
    private b[] ain;
    private boolean aio = true;
    private boolean aip = false;
    private d.a aiq;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.ail = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.ain = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.a aVar) {
        this.aiq = aVar;
    }

    public void l(Activity activity) {
        a((ViewGroup) activity.findViewById(16908290), activity);
    }

    private void a(ViewGroup viewGroup, Activity activity) {
        if (this.aim == null) {
            this.aim = n(activity);
            this.aim.ai(this.aip);
        }
        if (this.aim.getParent() == null) {
            viewGroup.addView(this.aim);
            if (this.ail.aij != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.ail.aij);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (c.this.aiq != null) {
                            c.this.aiq.bL();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.aim.startAnimation(loadAnimation);
            } else if (this.aiq != null) {
                this.aiq.bL();
            }
        }
    }

    public void m(Activity activity) {
        a((ViewGroup) activity.getWindow().getDecorView(), activity);
    }

    public void dismiss() {
        if (this.aim != null && (this.aim.getParent() instanceof ViewGroup)) {
            final ViewGroup viewGroup = (ViewGroup) this.aim.getParent();
            if (this.ail.aik != -1) {
                Context context = this.aim.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.ail.aik);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        viewGroup.removeView(c.this.aim);
                        if (c.this.aiq != null) {
                            c.this.aiq.onDismiss();
                        }
                        c.this.onDestroy();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.aim.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.aim);
            if (this.aiq != null) {
                this.aiq.onDismiss();
            }
            onDestroy();
        }
    }

    public void ah(boolean z) {
        this.aio = z;
    }

    private e n(Activity activity) {
        e eVar = new e(activity);
        eVar.cZ(activity.getResources().getColor(this.ail.aif));
        eVar.cY(this.ail.mAlpha);
        eVar.am(this.ail.aih);
        eVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.aio && i == 0) {
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
        if (this.ail.yG != null) {
            eVar.f(a.c(this.ail.yG, 0, i));
        } else {
            View findViewById = activity.findViewById(this.ail.aie);
            if (findViewById != null) {
                eVar.f(a.c(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.ail.aid);
        if (findViewById2 != null) {
            eVar.g(a.c(findViewById2, 0, i));
        }
        if (this.ail.aic) {
            eVar.setClickable(false);
        } else {
            eVar.setOnClickListener(this);
        }
        for (b bVar : this.ain) {
            eVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.ail = null;
        this.ain = null;
        this.aiq = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.ail == null || !this.ail.aig) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ail != null && this.ail.aig) {
            dismiss();
        }
    }

    public void ai(boolean z) {
        this.aip = z;
    }
}
