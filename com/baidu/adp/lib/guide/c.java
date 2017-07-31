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
    private Configuration wd;
    private e we;
    private b[] wf;
    private boolean wg = true;
    private d.a wh;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.wd = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.wf = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.a aVar) {
        this.wh = aVar;
    }

    public void j(Activity activity) {
        a((ViewGroup) activity.findViewById(16908290), activity);
    }

    private void a(ViewGroup viewGroup, Activity activity) {
        if (this.we == null) {
            this.we = l(activity);
        }
        if (this.we.getParent() == null) {
            viewGroup.addView(this.we);
            if (this.wd.wb != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.wd.wb);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (c.this.wh != null) {
                            c.this.wh.fl();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.we.startAnimation(loadAnimation);
            } else if (this.wh != null) {
                this.wh.fl();
            }
        }
    }

    public void k(Activity activity) {
        a((ViewGroup) activity.getWindow().getDecorView(), activity);
    }

    public void dismiss() {
        final ViewGroup viewGroup;
        if (this.we != null && (viewGroup = (ViewGroup) this.we.getParent()) != null) {
            if (this.wd.wc != -1) {
                Context context = this.we.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.wd.wc);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.lib.guide.c.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        viewGroup.removeView(c.this.we);
                        if (c.this.wh != null) {
                            c.this.wh.onDismiss();
                        }
                        c.this.onDestroy();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.we.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.we);
            if (this.wh != null) {
                this.wh.onDismiss();
            }
            onDestroy();
        }
    }

    public void x(boolean z) {
        this.wg = z;
    }

    private e l(Activity activity) {
        e eVar = new e(activity);
        eVar.aj(activity.getResources().getColor(this.wd.vX));
        eVar.ai(this.wd.mAlpha);
        eVar.B(this.wd.vZ);
        eVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.wg && i == 0) {
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
        if (this.wd.jv != null) {
            eVar.a(a.a(this.wd.jv, 0, i));
        } else {
            View findViewById = activity.findViewById(this.wd.vW);
            if (findViewById != null) {
                eVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.wd.vV);
        if (findViewById2 != null) {
            eVar.b(a.a(findViewById2, 0, i));
        }
        if (this.wd.vU) {
            eVar.setClickable(false);
        } else {
            eVar.setOnClickListener(this);
        }
        for (b bVar : this.wf) {
            eVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.wd = null;
        this.wf = null;
        this.wh = null;
        this.we.removeAllViews();
        this.we = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.wd == null || !this.wd.vY) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.wd != null && this.wd.vY) {
            dismiss();
        }
    }
}
