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
    private Configuration uB;
    private e uC;
    private b[] uD;
    private boolean uE = true;
    private d.a uF;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.uB = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.uD = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.a aVar) {
        this.uF = aVar;
    }

    public void j(Activity activity) {
        a((ViewGroup) activity.findViewById(16908290), activity);
    }

    private void a(ViewGroup viewGroup, Activity activity) {
        if (this.uC == null) {
            this.uC = l(activity);
        }
        if (this.uC.getParent() == null) {
            viewGroup.addView(this.uC);
            if (this.uB.uz != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.uB.uz);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (c.this.uF != null) {
                            c.this.uF.fa();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.uC.startAnimation(loadAnimation);
            } else if (this.uF != null) {
                this.uF.fa();
            }
        }
    }

    public void k(Activity activity) {
        a((ViewGroup) activity.getWindow().getDecorView(), activity);
    }

    public void dismiss() {
        final ViewGroup viewGroup;
        if (this.uC != null && (viewGroup = (ViewGroup) this.uC.getParent()) != null) {
            if (this.uB.uA != -1) {
                Context context = this.uC.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.uB.uA);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        viewGroup.removeView(c.this.uC);
                        if (c.this.uF != null) {
                            c.this.uF.onDismiss();
                        }
                        c.this.onDestroy();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.uC.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.uC);
            if (this.uF != null) {
                this.uF.onDismiss();
            }
            onDestroy();
        }
    }

    public void x(boolean z) {
        this.uE = z;
    }

    private e l(Activity activity) {
        e eVar = new e(activity);
        eVar.ag(activity.getResources().getColor(this.uB.uv));
        eVar.af(this.uB.mAlpha);
        eVar.B(this.uB.ux);
        eVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.uE && i == 0) {
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
        if (this.uB.jv != null) {
            eVar.a(a.a(this.uB.jv, 0, i));
        } else {
            View findViewById = activity.findViewById(this.uB.uu);
            if (findViewById != null) {
                eVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.uB.ut);
        if (findViewById2 != null) {
            eVar.b(a.a(findViewById2, 0, i));
        }
        if (this.uB.us) {
            eVar.setClickable(false);
        } else {
            eVar.setOnClickListener(this);
        }
        for (b bVar : this.uD) {
            eVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.uB = null;
        this.uD = null;
        this.uF = null;
        this.uC.removeAllViews();
        this.uC = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.uB == null || !this.uB.uw) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.uB != null && this.uB.uw) {
            dismiss();
        }
    }
}
