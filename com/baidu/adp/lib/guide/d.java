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
    private Configuration kO;
    private h kP;
    private b[] kQ;
    private boolean kR = true;
    private g.a kS;

    static {
        $assertionsDisabled = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.kO = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.kQ = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g.a aVar) {
        this.kS = aVar;
    }

    public void f(Activity activity) {
        if (this.kP == null) {
            this.kP = g(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.kP.getParent() == null) {
            viewGroup.addView(this.kP);
            if (this.kO.kM != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.kO.kM);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.kP.startAnimation(loadAnimation);
            } else if (this.kS != null) {
                this.kS.cW();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.kP != null && (viewGroup = (ViewGroup) this.kP.getParent()) != null) {
            if (this.kO.kN != -1) {
                Context context = this.kP.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.kO.kN);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.kP.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.kP);
            if (this.kS != null) {
                this.kS.onDismiss();
            }
            onDestroy();
        }
    }

    public void u(boolean z) {
        this.kR = z;
    }

    private h g(Activity activity) {
        h hVar = new h(activity);
        hVar.T(activity.getResources().getColor(this.kO.kI));
        hVar.S(this.kO.mAlpha);
        hVar.y(this.kO.kK);
        hVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.kR && i == 0) {
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
        if (this.kO.bL != null) {
            hVar.a(a.a(this.kO.bL, 0, i));
        } else {
            View findViewById = activity.findViewById(this.kO.kH);
            if (findViewById != null) {
                hVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.kO.kG);
        if (findViewById2 != null) {
            hVar.b(a.a(findViewById2, 0, i));
        }
        if (this.kO.kF) {
            hVar.setClickable(false);
        } else {
            hVar.setOnClickListener(this);
        }
        for (b bVar : this.kQ) {
            hVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.kO = null;
        this.kQ = null;
        this.kS = null;
        this.kP.removeAllViews();
        this.kP = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.kO == null || !this.kO.kJ) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kO != null && this.kO.kJ) {
            dismiss();
        }
    }
}
