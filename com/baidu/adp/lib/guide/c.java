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
    private Configuration aik;
    private e ail;
    private b[] aim;
    private boolean ain = true;
    private d.a aio;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.aik = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.aim = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.a aVar) {
        this.aio = aVar;
    }

    public void j(Activity activity) {
        a((ViewGroup) activity.findViewById(16908290), activity);
    }

    private void a(ViewGroup viewGroup, Activity activity) {
        if (this.ail == null) {
            this.ail = l(activity);
        }
        if (this.ail.getParent() == null) {
            viewGroup.addView(this.ail);
            if (this.aik.aii != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.aik.aii);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (c.this.aio != null) {
                            c.this.aio.bL();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.ail.startAnimation(loadAnimation);
            } else if (this.aio != null) {
                this.aio.bL();
            }
        }
    }

    public void k(Activity activity) {
        a((ViewGroup) activity.getWindow().getDecorView(), activity);
    }

    public void dismiss() {
        final ViewGroup viewGroup;
        if (this.ail != null && (viewGroup = (ViewGroup) this.ail.getParent()) != null) {
            if (this.aik.aij != -1) {
                Context context = this.ail.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.aik.aij);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        viewGroup.removeView(c.this.ail);
                        if (c.this.aio != null) {
                            c.this.aio.onDismiss();
                        }
                        c.this.onDestroy();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.ail.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.ail);
            if (this.aio != null) {
                this.aio.onDismiss();
            }
            onDestroy();
        }
    }

    public void ae(boolean z) {
        this.ain = z;
    }

    private e l(Activity activity) {
        e eVar = new e(activity);
        eVar.cZ(activity.getResources().getColor(this.aik.aie));
        eVar.cY(this.aik.mAlpha);
        eVar.ai(this.aik.aig);
        eVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.ain && i == 0) {
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
        if (this.aik.yH != null) {
            eVar.e(a.c(this.aik.yH, 0, i));
        } else {
            View findViewById = activity.findViewById(this.aik.aid);
            if (findViewById != null) {
                eVar.e(a.c(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.aik.aic);
        if (findViewById2 != null) {
            eVar.f(a.c(findViewById2, 0, i));
        }
        if (this.aik.aib) {
            eVar.setClickable(false);
        } else {
            eVar.setOnClickListener(this);
        }
        for (b bVar : this.aim) {
            eVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.aik = null;
        this.aim = null;
        this.aio = null;
        this.ail.removeAllViews();
        this.ail = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.aik == null || !this.aik.aif) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aik != null && this.aik.aif) {
            dismiss();
        }
    }
}
