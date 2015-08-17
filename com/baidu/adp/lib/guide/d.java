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
    private Configuration tX;
    private h tY;
    private b[] tZ;
    private boolean ua = true;
    private g.a ub;

    static {
        $assertionsDisabled = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.tX = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.tZ = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g.a aVar) {
        this.ub = aVar;
    }

    public void i(Activity activity) {
        if (this.tY == null) {
            this.tY = j(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.tY.getParent() == null) {
            viewGroup.addView(this.tY);
            if (this.tX.tV != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.tX.tV);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.tY.startAnimation(loadAnimation);
            } else if (this.ub != null) {
                this.ub.gC();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.tY != null && (viewGroup = (ViewGroup) this.tY.getParent()) != null) {
            if (this.tX.tW != -1) {
                Context context = this.tY.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.tX.tW);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.tY.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.tY);
            if (this.ub != null) {
                this.ub.onDismiss();
            }
            onDestroy();
        }
    }

    public void t(boolean z) {
        this.ua = z;
    }

    private h j(Activity activity) {
        h hVar = new h(activity);
        hVar.R(activity.getResources().getColor(this.tX.tR));
        hVar.Q(this.tX.mAlpha);
        hVar.x(this.tX.tT);
        hVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.ua && i == 0) {
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
        if (this.tX.lJ != null) {
            hVar.a(a.a(this.tX.lJ, 0, i));
        } else {
            View findViewById = activity.findViewById(this.tX.tQ);
            if (findViewById != null) {
                hVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.tX.tP);
        if (findViewById2 != null) {
            hVar.b(a.a(findViewById2, 0, i));
        }
        if (this.tX.tO) {
            hVar.setClickable(false);
        } else {
            hVar.setOnClickListener(this);
        }
        for (b bVar : this.tZ) {
            hVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.tX = null;
        this.tZ = null;
        this.ub = null;
        this.tY.removeAllViews();
        this.tY = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.tX == null || !this.tX.tS) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.tX != null && this.tX.tS) {
            dismiss();
        }
    }
}
