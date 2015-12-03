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
    private Configuration ub;
    private h uc;
    private b[] ud;
    private boolean ue = true;
    private g.a uf;

    static {
        $assertionsDisabled = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.ub = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.ud = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g.a aVar) {
        this.uf = aVar;
    }

    public void i(Activity activity) {
        if (this.uc == null) {
            this.uc = j(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.uc.getParent() == null) {
            viewGroup.addView(this.uc);
            if (this.ub.tZ != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.ub.tZ);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.uc.startAnimation(loadAnimation);
            } else if (this.uf != null) {
                this.uf.gA();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.uc != null && (viewGroup = (ViewGroup) this.uc.getParent()) != null) {
            if (this.ub.ua != -1) {
                Context context = this.uc.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.ub.ua);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.uc.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.uc);
            if (this.uf != null) {
                this.uf.onDismiss();
            }
            onDestroy();
        }
    }

    public void t(boolean z) {
        this.ue = z;
    }

    private h j(Activity activity) {
        h hVar = new h(activity);
        hVar.S(activity.getResources().getColor(this.ub.tV));
        hVar.R(this.ub.mAlpha);
        hVar.x(this.ub.tX);
        hVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.ue && i == 0) {
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
        if (this.ub.lJ != null) {
            hVar.a(a.a(this.ub.lJ, 0, i));
        } else {
            View findViewById = activity.findViewById(this.ub.tU);
            if (findViewById != null) {
                hVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.ub.tT);
        if (findViewById2 != null) {
            hVar.b(a.a(findViewById2, 0, i));
        }
        if (this.ub.tS) {
            hVar.setClickable(false);
        } else {
            hVar.setOnClickListener(this);
        }
        for (b bVar : this.ud) {
            hVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.ub = null;
        this.ud = null;
        this.uf = null;
        this.uc.removeAllViews();
        this.uc = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.ub == null || !this.ub.tW) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ub != null && this.ub.tW) {
            dismiss();
        }
    }
}
