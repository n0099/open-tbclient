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
    private Configuration uA;
    private h uB;
    private b[] uC;
    private boolean uD = true;
    private g.a uE;

    static {
        $assertionsDisabled = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.uA = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.uC = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g.a aVar) {
        this.uE = aVar;
    }

    public void j(Activity activity) {
        if (this.uB == null) {
            this.uB = k(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.uB.getParent() == null) {
            viewGroup.addView(this.uB);
            if (this.uA.uy != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.uA.uy);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.uB.startAnimation(loadAnimation);
            } else if (this.uE != null) {
                this.uE.fd();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.uB != null && (viewGroup = (ViewGroup) this.uB.getParent()) != null) {
            if (this.uA.uz != -1) {
                Context context = this.uB.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.uA.uz);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.uB.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.uB);
            if (this.uE != null) {
                this.uE.onDismiss();
            }
            onDestroy();
        }
    }

    public void x(boolean z) {
        this.uD = z;
    }

    private h k(Activity activity) {
        h hVar = new h(activity);
        hVar.ag(activity.getResources().getColor(this.uA.uu));
        hVar.af(this.uA.mAlpha);
        hVar.B(this.uA.uw);
        hVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.uD && i == 0) {
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
        if (this.uA.jv != null) {
            hVar.a(a.a(this.uA.jv, 0, i));
        } else {
            View findViewById = activity.findViewById(this.uA.ut);
            if (findViewById != null) {
                hVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.uA.us);
        if (findViewById2 != null) {
            hVar.b(a.a(findViewById2, 0, i));
        }
        if (this.uA.ur) {
            hVar.setClickable(false);
        } else {
            hVar.setOnClickListener(this);
        }
        for (b bVar : this.uC) {
            hVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.uA = null;
        this.uC = null;
        this.uE = null;
        this.uB.removeAllViews();
        this.uB = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.uA == null || !this.uA.uv) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.uA != null && this.uA.uv) {
            dismiss();
        }
    }
}
