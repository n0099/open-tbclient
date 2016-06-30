package com.baidu.adp.lib.guide;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.adp.lib.guide.g;
/* loaded from: classes.dex */
public class d implements View.OnClickListener, View.OnKeyListener {
    static final /* synthetic */ boolean $assertionsDisabled;
    private Configuration kj;
    private h kk;
    private b[] kl;
    private boolean km = true;
    private g.a kn;

    static {
        $assertionsDisabled = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.kj = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.kl = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g.a aVar) {
        this.kn = aVar;
    }

    public void f(Activity activity) {
        if (this.kk == null) {
            this.kk = g(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.kk.getParent() == null) {
            viewGroup.addView(this.kk);
            if (this.kj.kh != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.kj.kh);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.kk.startAnimation(loadAnimation);
            } else if (this.kn != null) {
                this.kn.cX();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.kk != null && (viewGroup = (ViewGroup) this.kk.getParent()) != null) {
            if (this.kj.ki != -1) {
                Context context = this.kk.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.kj.ki);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.kk.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.kk);
            if (this.kn != null) {
                this.kn.onDismiss();
            }
            onDestroy();
        }
    }

    public void s(boolean z) {
        this.km = z;
    }

    private h g(Activity activity) {
        h hVar = new h(activity);
        hVar.Q(activity.getResources().getColor(this.kj.kd));
        hVar.P(this.kj.mAlpha);
        hVar.w(this.kj.kf);
        hVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.km && i == 0) {
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
        if (this.kj.bL != null) {
            hVar.a(a.a(this.kj.bL, 0, i));
        } else {
            View findViewById = activity.findViewById(this.kj.kc);
            if (findViewById != null) {
                hVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.kj.kb);
        if (findViewById2 != null) {
            hVar.b(a.a(findViewById2, 0, i));
        }
        if (this.kj.jZ) {
            hVar.setClickable(false);
        } else {
            hVar.setOnClickListener(this);
        }
        for (b bVar : this.kl) {
            hVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.kj = null;
        this.kl = null;
        this.kn = null;
        this.kk.removeAllViews();
        this.kk = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.kj == null || !this.kj.ke) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kj != null && this.kj.ke) {
            dismiss();
        }
    }
}
