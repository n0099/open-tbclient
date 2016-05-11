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
    private Configuration kl;
    private h km;
    private b[] kn;
    private boolean ko = true;
    private g.a kp;

    static {
        $assertionsDisabled = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.kl = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.kn = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g.a aVar) {
        this.kp = aVar;
    }

    public void d(Activity activity) {
        if (this.km == null) {
            this.km = e(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.km.getParent() == null) {
            viewGroup.addView(this.km);
            if (this.kl.kj != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.kl.kj);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.km.startAnimation(loadAnimation);
            } else if (this.kp != null) {
                this.kp.cW();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.km != null && (viewGroup = (ViewGroup) this.km.getParent()) != null) {
            if (this.kl.kk != -1) {
                Context context = this.km.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.kl.kk);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.km.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.km);
            if (this.kp != null) {
                this.kp.onDismiss();
            }
            onDestroy();
        }
    }

    public void s(boolean z) {
        this.ko = z;
    }

    private h e(Activity activity) {
        h hVar = new h(activity);
        hVar.Q(activity.getResources().getColor(this.kl.kf));
        hVar.P(this.kl.mAlpha);
        hVar.w(this.kl.kh);
        hVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.ko && i == 0) {
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
        if (this.kl.bL != null) {
            hVar.a(a.a(this.kl.bL, 0, i));
        } else {
            View findViewById = activity.findViewById(this.kl.ke);
            if (findViewById != null) {
                hVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.kl.kd);
        if (findViewById2 != null) {
            hVar.b(a.a(findViewById2, 0, i));
        }
        if (this.kl.kc) {
            hVar.setClickable(false);
        } else {
            hVar.setOnClickListener(this);
        }
        for (b bVar : this.kn) {
            hVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.kl = null;
        this.kn = null;
        this.kp = null;
        this.km.removeAllViews();
        this.km = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.kl == null || !this.kl.kg) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kl != null && this.kl.kg) {
            dismiss();
        }
    }
}
