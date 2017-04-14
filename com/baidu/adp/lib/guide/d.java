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
    private Configuration uv;
    private h uw;
    private b[] ux;
    private boolean uy = true;
    private g.a uz;

    static {
        $assertionsDisabled = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.uv = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.ux = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g.a aVar) {
        this.uz = aVar;
    }

    public void j(Activity activity) {
        if (this.uw == null) {
            this.uw = k(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.uw.getParent() == null) {
            viewGroup.addView(this.uw);
            if (this.uv.ut != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.uv.ut);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.uw.startAnimation(loadAnimation);
            } else if (this.uz != null) {
                this.uz.fc();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.uw != null && (viewGroup = (ViewGroup) this.uw.getParent()) != null) {
            if (this.uv.uu != -1) {
                Context context = this.uw.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.uv.uu);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.uw.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.uw);
            if (this.uz != null) {
                this.uz.onDismiss();
            }
            onDestroy();
        }
    }

    public void x(boolean z) {
        this.uy = z;
    }

    private h k(Activity activity) {
        h hVar = new h(activity);
        hVar.ag(activity.getResources().getColor(this.uv.up));
        hVar.af(this.uv.mAlpha);
        hVar.B(this.uv.ur);
        hVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.uy && i == 0) {
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
        if (this.uv.jv != null) {
            hVar.a(a.a(this.uv.jv, 0, i));
        } else {
            View findViewById = activity.findViewById(this.uv.uo);
            if (findViewById != null) {
                hVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.uv.um);
        if (findViewById2 != null) {
            hVar.b(a.a(findViewById2, 0, i));
        }
        if (this.uv.ul) {
            hVar.setClickable(false);
        } else {
            hVar.setOnClickListener(this);
        }
        for (b bVar : this.ux) {
            hVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.uv = null;
        this.ux = null;
        this.uz = null;
        this.uw.removeAllViews();
        this.uw = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.uv == null || !this.uv.uq) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.uv != null && this.uv.uq) {
            dismiss();
        }
    }
}
