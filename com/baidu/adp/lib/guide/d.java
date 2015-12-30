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
    private Configuration ud;
    private h ue;
    private b[] uf;
    private boolean ug = true;
    private g.a uh;

    static {
        $assertionsDisabled = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.ud = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.uf = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g.a aVar) {
        this.uh = aVar;
    }

    public void i(Activity activity) {
        if (this.ue == null) {
            this.ue = j(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.ue.getParent() == null) {
            viewGroup.addView(this.ue);
            if (this.ud.ub != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.ud.ub);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.ue.startAnimation(loadAnimation);
            } else if (this.uh != null) {
                this.uh.gA();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.ue != null && (viewGroup = (ViewGroup) this.ue.getParent()) != null) {
            if (this.ud.uc != -1) {
                Context context = this.ue.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.ud.uc);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.ue.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.ue);
            if (this.uh != null) {
                this.uh.onDismiss();
            }
            onDestroy();
        }
    }

    public void t(boolean z) {
        this.ug = z;
    }

    private h j(Activity activity) {
        h hVar = new h(activity);
        hVar.S(activity.getResources().getColor(this.ud.tX));
        hVar.R(this.ud.mAlpha);
        hVar.x(this.ud.tZ);
        hVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.ug && i == 0) {
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
        if (this.ud.lJ != null) {
            hVar.a(a.a(this.ud.lJ, 0, i));
        } else {
            View findViewById = activity.findViewById(this.ud.tW);
            if (findViewById != null) {
                hVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.ud.tV);
        if (findViewById2 != null) {
            hVar.b(a.a(findViewById2, 0, i));
        }
        if (this.ud.tU) {
            hVar.setClickable(false);
        } else {
            hVar.setOnClickListener(this);
        }
        for (b bVar : this.uf) {
            hVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.ud = null;
        this.uf = null;
        this.uh = null;
        this.ue.removeAllViews();
        this.ue = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.ud == null || !this.ud.tY) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ud != null && this.ud.tY) {
            dismiss();
        }
    }
}
