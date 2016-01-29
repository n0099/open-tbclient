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
    private Configuration um;
    private h uo;
    private b[] up;
    private boolean uq = true;
    private g.a ur;

    static {
        $assertionsDisabled = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.um = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.up = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g.a aVar) {
        this.ur = aVar;
    }

    public void i(Activity activity) {
        if (this.uo == null) {
            this.uo = j(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.uo.getParent() == null) {
            viewGroup.addView(this.uo);
            if (this.um.uk != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.um.uk);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.uo.startAnimation(loadAnimation);
            } else if (this.ur != null) {
                this.ur.gI();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.uo != null && (viewGroup = (ViewGroup) this.uo.getParent()) != null) {
            if (this.um.ul != -1) {
                Context context = this.uo.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.um.ul);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.uo.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.uo);
            if (this.ur != null) {
                this.ur.onDismiss();
            }
            onDestroy();
        }
    }

    public void t(boolean z) {
        this.uq = z;
    }

    private h j(Activity activity) {
        h hVar = new h(activity);
        hVar.ad(activity.getResources().getColor(this.um.ug));
        hVar.ac(this.um.mAlpha);
        hVar.x(this.um.ui);
        hVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.uq && i == 0) {
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
        if (this.um.lJ != null) {
            hVar.a(a.a(this.um.lJ, 0, i));
        } else {
            View findViewById = activity.findViewById(this.um.uf);
            if (findViewById != null) {
                hVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.um.ue);
        if (findViewById2 != null) {
            hVar.b(a.a(findViewById2, 0, i));
        }
        if (this.um.ud) {
            hVar.setClickable(false);
        } else {
            hVar.setOnClickListener(this);
        }
        for (b bVar : this.up) {
            hVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.um = null;
        this.up = null;
        this.ur = null;
        this.uo.removeAllViews();
        this.uo = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.um == null || !this.um.uh) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.um != null && this.um.uh) {
            dismiss();
        }
    }
}
