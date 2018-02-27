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
    private Configuration aif;
    private e aig;
    private b[] aih;
    private boolean aii = true;
    private boolean aij = false;
    private d.a aik;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.aif = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.aih = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.a aVar) {
        this.aik = aVar;
    }

    public void l(Activity activity) {
        a((ViewGroup) activity.findViewById(16908290), activity);
    }

    private void a(ViewGroup viewGroup, Activity activity) {
        if (this.aig == null) {
            this.aig = n(activity);
            this.aig.ai(this.aij);
        }
        if (this.aig.getParent() == null) {
            viewGroup.addView(this.aig);
            if (this.aif.aid != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.aif.aid);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (c.this.aik != null) {
                            c.this.aik.bL();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.aig.startAnimation(loadAnimation);
            } else if (this.aik != null) {
                this.aik.bL();
            }
        }
    }

    public void m(Activity activity) {
        a((ViewGroup) activity.getWindow().getDecorView(), activity);
    }

    public void dismiss() {
        if (this.aig != null && (this.aig.getParent() instanceof ViewGroup)) {
            final ViewGroup viewGroup = (ViewGroup) this.aig.getParent();
            if (this.aif.aie != -1) {
                Context context = this.aig.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.aif.aie);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        viewGroup.removeView(c.this.aig);
                        if (c.this.aik != null) {
                            c.this.aik.onDismiss();
                        }
                        c.this.onDestroy();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.aig.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.aig);
            if (this.aik != null) {
                this.aik.onDismiss();
            }
            onDestroy();
        }
    }

    public void ah(boolean z) {
        this.aii = z;
    }

    private e n(Activity activity) {
        e eVar = new e(activity);
        eVar.cZ(activity.getResources().getColor(this.aif.ahZ));
        eVar.cY(this.aif.mAlpha);
        eVar.am(this.aif.aib);
        eVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.aii && i == 0) {
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
        if (this.aif.yB != null) {
            eVar.f(a.c(this.aif.yB, 0, i));
        } else {
            View findViewById = activity.findViewById(this.aif.ahY);
            if (findViewById != null) {
                eVar.f(a.c(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.aif.ahX);
        if (findViewById2 != null) {
            eVar.g(a.c(findViewById2, 0, i));
        }
        if (this.aif.ahW) {
            eVar.setClickable(false);
        } else {
            eVar.setOnClickListener(this);
        }
        for (b bVar : this.aih) {
            eVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.aif = null;
        this.aih = null;
        this.aik = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.aif == null || !this.aif.aia) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aif != null && this.aif.aia) {
            dismiss();
        }
    }

    public void ai(boolean z) {
        this.aij = z;
    }
}
