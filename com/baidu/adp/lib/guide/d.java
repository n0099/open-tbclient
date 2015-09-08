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
    private Configuration tV;
    private h tW;
    private b[] tX;
    private boolean tY = true;
    private g.a tZ;

    static {
        $assertionsDisabled = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.tV = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.tX = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g.a aVar) {
        this.tZ = aVar;
    }

    public void i(Activity activity) {
        if (this.tW == null) {
            this.tW = j(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.tW.getParent() == null) {
            viewGroup.addView(this.tW);
            if (this.tV.tT != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.tV.tT);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.tW.startAnimation(loadAnimation);
            } else if (this.tZ != null) {
                this.tZ.gz();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.tW != null && (viewGroup = (ViewGroup) this.tW.getParent()) != null) {
            if (this.tV.tU != -1) {
                Context context = this.tW.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.tV.tU);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.tW.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.tW);
            if (this.tZ != null) {
                this.tZ.onDismiss();
            }
            onDestroy();
        }
    }

    public void t(boolean z) {
        this.tY = z;
    }

    private h j(Activity activity) {
        h hVar = new h(activity);
        hVar.R(activity.getResources().getColor(this.tV.tP));
        hVar.Q(this.tV.mAlpha);
        hVar.x(this.tV.tR);
        hVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.tY && i == 0) {
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
        if (this.tV.lJ != null) {
            hVar.a(a.a(this.tV.lJ, 0, i));
        } else {
            View findViewById = activity.findViewById(this.tV.tO);
            if (findViewById != null) {
                hVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.tV.tN);
        if (findViewById2 != null) {
            hVar.b(a.a(findViewById2, 0, i));
        }
        if (this.tV.tM) {
            hVar.setClickable(false);
        } else {
            hVar.setOnClickListener(this);
        }
        for (b bVar : this.tX) {
            hVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.tV = null;
        this.tX = null;
        this.tZ = null;
        this.tW.removeAllViews();
        this.tW = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.tV == null || !this.tV.tQ) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.tV != null && this.tV.tQ) {
            dismiss();
        }
    }
}
