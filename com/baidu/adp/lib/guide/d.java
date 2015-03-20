package com.baidu.adp.lib.guide;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
/* loaded from: classes.dex */
public class d implements View.OnClickListener, View.OnKeyListener {
    static final /* synthetic */ boolean $assertionsDisabled;
    private Configuration uN;
    private i uO;
    private b[] uP;
    private boolean uQ = true;
    private h uR;

    static {
        $assertionsDisabled = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.uN = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.uP = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        this.uR = hVar;
    }

    public void i(Activity activity) {
        if (this.uO == null) {
            this.uO = j(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.uO.getParent() == null) {
            viewGroup.addView(this.uO);
            if (this.uN.uL != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.uN.uL);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.uO.startAnimation(loadAnimation);
            } else if (this.uR != null) {
                this.uR.gW();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.uO != null && (viewGroup = (ViewGroup) this.uO.getParent()) != null) {
            if (this.uN.uM != -1) {
                Context context = this.uO.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.uN.uM);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.uO.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.uO);
            if (this.uR != null) {
                this.uR.onDismiss();
            }
            onDestroy();
        }
    }

    public void t(boolean z) {
        this.uQ = z;
    }

    private i j(Activity activity) {
        i iVar = new i(activity);
        iVar.R(activity.getResources().getColor(this.uN.uH));
        iVar.Q(this.uN.mAlpha);
        iVar.x(this.uN.uJ);
        iVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.uQ && i == 0) {
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
        if (this.uN.lI != null) {
            iVar.a(a.a(this.uN.lI, 0, i));
        } else {
            View findViewById = activity.findViewById(this.uN.uG);
            if (findViewById != null) {
                iVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.uN.uF);
        if (findViewById2 != null) {
            iVar.b(a.a(findViewById2, 0, i));
        }
        if (this.uN.uE) {
            iVar.setClickable(false);
        } else {
            iVar.setOnClickListener(this);
        }
        for (b bVar : this.uP) {
            iVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.uN = null;
        this.uP = null;
        this.uR = null;
        this.uO.removeAllViews();
        this.uO = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.uN == null || !this.uN.uI) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.uN != null && this.uN.uI) {
            dismiss();
        }
    }
}
