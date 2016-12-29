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
    private Configuration nj;
    private h nk;
    private b[] nl;
    private boolean nm = true;
    private g.a nn;

    static {
        $assertionsDisabled = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.nj = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.nl = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g.a aVar) {
        this.nn = aVar;
    }

    public void j(Activity activity) {
        if (this.nk == null) {
            this.nk = k(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.nk.getParent() == null) {
            viewGroup.addView(this.nk);
            if (this.nj.nh != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.nj.nh);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.nk.startAnimation(loadAnimation);
            } else if (this.nn != null) {
                this.nn.dR();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.nk != null && (viewGroup = (ViewGroup) this.nk.getParent()) != null) {
            if (this.nj.ni != -1) {
                Context context = this.nk.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.nj.ni);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.nk.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.nk);
            if (this.nn != null) {
                this.nn.onDismiss();
            }
            onDestroy();
        }
    }

    public void w(boolean z) {
        this.nm = z;
    }

    private h k(Activity activity) {
        h hVar = new h(activity);
        hVar.ah(activity.getResources().getColor(this.nj.nd));
        hVar.ag(this.nj.mAlpha);
        hVar.A(this.nj.nf);
        hVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.nm && i == 0) {
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
        if (this.nj.bL != null) {
            hVar.a(a.a(this.nj.bL, 0, i));
        } else {
            View findViewById = activity.findViewById(this.nj.nc);
            if (findViewById != null) {
                hVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.nj.nb);
        if (findViewById2 != null) {
            hVar.b(a.a(findViewById2, 0, i));
        }
        if (this.nj.na) {
            hVar.setClickable(false);
        } else {
            hVar.setOnClickListener(this);
        }
        for (b bVar : this.nl) {
            hVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.nj = null;
        this.nl = null;
        this.nn = null;
        this.nk.removeAllViews();
        this.nk = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.nj == null || !this.nj.ne) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nj != null && this.nj.ne) {
            dismiss();
        }
    }
}
