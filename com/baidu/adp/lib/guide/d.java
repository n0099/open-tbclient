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
    private Configuration tY;
    private i tZ;
    private b[] ua;
    private boolean ub = true;
    private h uc;

    static {
        $assertionsDisabled = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.tY = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.ua = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        this.uc = hVar;
    }

    public void i(Activity activity) {
        if (this.tZ == null) {
            this.tZ = j(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.tZ.getParent() == null) {
            viewGroup.addView(this.tZ);
            if (this.tY.tW != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.tY.tW);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.tZ.startAnimation(loadAnimation);
            } else if (this.uc != null) {
                this.uc.gH();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.tZ != null && (viewGroup = (ViewGroup) this.tZ.getParent()) != null) {
            if (this.tY.tX != -1) {
                Context context = this.tZ.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.tY.tX);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.tZ.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.tZ);
            if (this.uc != null) {
                this.uc.onDismiss();
            }
            onDestroy();
        }
    }

    public void t(boolean z) {
        this.ub = z;
    }

    private i j(Activity activity) {
        i iVar = new i(activity);
        iVar.P(activity.getResources().getColor(this.tY.tS));
        iVar.O(this.tY.mAlpha);
        iVar.x(this.tY.tU);
        iVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.ub && i == 0) {
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
        if (this.tY.lI != null) {
            iVar.a(a.a(this.tY.lI, 0, i));
        } else {
            View findViewById = activity.findViewById(this.tY.tR);
            if (findViewById != null) {
                iVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.tY.tQ);
        if (findViewById2 != null) {
            iVar.b(a.a(findViewById2, 0, i));
        }
        if (this.tY.tP) {
            iVar.setClickable(false);
        } else {
            iVar.setOnClickListener(this);
        }
        for (b bVar : this.ua) {
            iVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.tY = null;
        this.ua = null;
        this.uc = null;
        this.tZ.removeAllViews();
        this.tZ = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.tY == null || !this.tY.tT) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.tY != null && this.tY.tT) {
            dismiss();
        }
    }
}
