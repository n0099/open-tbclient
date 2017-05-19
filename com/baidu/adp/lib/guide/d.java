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
    private Configuration uB;
    private h uC;
    private b[] uD;
    private boolean uE = true;
    private g.a uF;

    static {
        $assertionsDisabled = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.uB = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.uD = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g.a aVar) {
        this.uF = aVar;
    }

    public void j(Activity activity) {
        if (this.uC == null) {
            this.uC = k(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.uC.getParent() == null) {
            viewGroup.addView(this.uC);
            if (this.uB.uz != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.uB.uz);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.uC.startAnimation(loadAnimation);
            } else if (this.uF != null) {
                this.uF.fd();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.uC != null && (viewGroup = (ViewGroup) this.uC.getParent()) != null) {
            if (this.uB.uA != -1) {
                Context context = this.uC.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.uB.uA);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.uC.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.uC);
            if (this.uF != null) {
                this.uF.onDismiss();
            }
            onDestroy();
        }
    }

    public void x(boolean z) {
        this.uE = z;
    }

    private h k(Activity activity) {
        h hVar = new h(activity);
        hVar.af(activity.getResources().getColor(this.uB.uv));
        hVar.ae(this.uB.mAlpha);
        hVar.B(this.uB.ux);
        hVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.uE && i == 0) {
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
        if (this.uB.jv != null) {
            hVar.a(a.a(this.uB.jv, 0, i));
        } else {
            View findViewById = activity.findViewById(this.uB.uu);
            if (findViewById != null) {
                hVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.uB.ut);
        if (findViewById2 != null) {
            hVar.b(a.a(findViewById2, 0, i));
        }
        if (this.uB.us) {
            hVar.setClickable(false);
        } else {
            hVar.setOnClickListener(this);
        }
        for (b bVar : this.uD) {
            hVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.uB = null;
        this.uD = null;
        this.uF = null;
        this.uC.removeAllViews();
        this.uC = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.uB == null || !this.uB.uw) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.uB != null && this.uB.uw) {
            dismiss();
        }
    }
}
