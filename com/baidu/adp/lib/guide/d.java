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
    private Configuration nc;
    private h nd;
    private b[] ne;
    private boolean nf = true;
    private g.a ng;

    static {
        $assertionsDisabled = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.nc = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.ne = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g.a aVar) {
        this.ng = aVar;
    }

    public void j(Activity activity) {
        if (this.nd == null) {
            this.nd = k(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.nd.getParent() == null) {
            viewGroup.addView(this.nd);
            if (this.nc.na != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.nc.na);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.nd.startAnimation(loadAnimation);
            } else if (this.ng != null) {
                this.ng.dP();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.nd != null && (viewGroup = (ViewGroup) this.nd.getParent()) != null) {
            if (this.nc.nb != -1) {
                Context context = this.nd.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.nc.nb);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.nd.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.nd);
            if (this.ng != null) {
                this.ng.onDismiss();
            }
            onDestroy();
        }
    }

    public void w(boolean z) {
        this.nf = z;
    }

    private h k(Activity activity) {
        h hVar = new h(activity);
        hVar.ah(activity.getResources().getColor(this.nc.mU));
        hVar.ag(this.nc.mAlpha);
        hVar.A(this.nc.mW);
        hVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.nf && i == 0) {
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
        if (this.nc.bK != null) {
            hVar.a(a.a(this.nc.bK, 0, i));
        } else {
            View findViewById = activity.findViewById(this.nc.mT);
            if (findViewById != null) {
                hVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.nc.mS);
        if (findViewById2 != null) {
            hVar.b(a.a(findViewById2, 0, i));
        }
        if (this.nc.mQ) {
            hVar.setClickable(false);
        } else {
            hVar.setOnClickListener(this);
        }
        for (b bVar : this.ne) {
            hVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.nc = null;
        this.ne = null;
        this.ng = null;
        this.nd.removeAllViews();
        this.nd = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.nc == null || !this.nc.mV) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nc != null && this.nc.mV) {
            dismiss();
        }
    }
}
