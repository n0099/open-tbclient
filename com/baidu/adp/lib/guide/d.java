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
    private g.a uA;
    private Configuration uw;
    private h ux;
    private b[] uy;
    private boolean uz = true;

    static {
        $assertionsDisabled = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.uw = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.uy = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g.a aVar) {
        this.uA = aVar;
    }

    public void d(Activity activity) {
        if (this.ux == null) {
            this.ux = e(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.ux.getParent() == null) {
            viewGroup.addView(this.ux);
            if (this.uw.uu != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.uw.uu);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.ux.startAnimation(loadAnimation);
            } else if (this.uA != null) {
                this.uA.gI();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.ux != null && (viewGroup = (ViewGroup) this.ux.getParent()) != null) {
            if (this.uw.uv != -1) {
                Context context = this.ux.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.uw.uv);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.ux.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.ux);
            if (this.uA != null) {
                this.uA.onDismiss();
            }
            onDestroy();
        }
    }

    public void s(boolean z) {
        this.uz = z;
    }

    private h e(Activity activity) {
        h hVar = new h(activity);
        hVar.ac(activity.getResources().getColor(this.uw.uq));
        hVar.ab(this.uw.mAlpha);
        hVar.w(this.uw.us);
        hVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.uz && i == 0) {
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
        if (this.uw.lK != null) {
            hVar.a(a.a(this.uw.lK, 0, i));
        } else {
            View findViewById = activity.findViewById(this.uw.up);
            if (findViewById != null) {
                hVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.uw.uo);
        if (findViewById2 != null) {
            hVar.b(a.a(findViewById2, 0, i));
        }
        if (this.uw.um) {
            hVar.setClickable(false);
        } else {
            hVar.setOnClickListener(this);
        }
        for (b bVar : this.uy) {
            hVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.uw = null;
        this.uy = null;
        this.uA = null;
        this.ux.removeAllViews();
        this.ux = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.uw == null || !this.uw.ur) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.uw != null && this.uw.ur) {
            dismiss();
        }
    }
}
