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
    private Configuration ni;
    private h nj;
    private b[] nk;
    private boolean nl = true;
    private g.a nm;

    static {
        $assertionsDisabled = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.ni = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.nk = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g.a aVar) {
        this.nm = aVar;
    }

    public void j(Activity activity) {
        if (this.nj == null) {
            this.nj = k(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.nj.getParent() == null) {
            viewGroup.addView(this.nj);
            if (this.ni.ng != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.ni.ng);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.nj.startAnimation(loadAnimation);
            } else if (this.nm != null) {
                this.nm.dR();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.nj != null && (viewGroup = (ViewGroup) this.nj.getParent()) != null) {
            if (this.ni.nh != -1) {
                Context context = this.nj.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.ni.nh);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.nj.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.nj);
            if (this.nm != null) {
                this.nm.onDismiss();
            }
            onDestroy();
        }
    }

    public void w(boolean z) {
        this.nl = z;
    }

    private h k(Activity activity) {
        h hVar = new h(activity);
        hVar.ag(activity.getResources().getColor(this.ni.nc));
        hVar.af(this.ni.mAlpha);
        hVar.A(this.ni.ne);
        hVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.nl && i == 0) {
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
        if (this.ni.bL != null) {
            hVar.a(a.a(this.ni.bL, 0, i));
        } else {
            View findViewById = activity.findViewById(this.ni.nb);
            if (findViewById != null) {
                hVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.ni.na);
        if (findViewById2 != null) {
            hVar.b(a.a(findViewById2, 0, i));
        }
        if (this.ni.mZ) {
            hVar.setClickable(false);
        } else {
            hVar.setOnClickListener(this);
        }
        for (b bVar : this.nk) {
            hVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.ni = null;
        this.nk = null;
        this.nm = null;
        this.nj.removeAllViews();
        this.nj = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.ni == null || !this.ni.nd) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ni != null && this.ni.nd) {
            dismiss();
        }
    }
}
