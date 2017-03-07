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
    private Configuration uS;
    private h uT;
    private b[] uU;
    private boolean uV = true;
    private g.a uW;

    static {
        $assertionsDisabled = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.uS = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.uU = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g.a aVar) {
        this.uW = aVar;
    }

    public void j(Activity activity) {
        if (this.uT == null) {
            this.uT = k(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.uT.getParent() == null) {
            viewGroup.addView(this.uT);
            if (this.uS.uQ != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.uS.uQ);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.uT.startAnimation(loadAnimation);
            } else if (this.uW != null) {
                this.uW.eX();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.uT != null && (viewGroup = (ViewGroup) this.uT.getParent()) != null) {
            if (this.uS.uR != -1) {
                Context context = this.uT.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.uS.uR);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.uT.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.uT);
            if (this.uW != null) {
                this.uW.onDismiss();
            }
            onDestroy();
        }
    }

    public void x(boolean z) {
        this.uV = z;
    }

    private h k(Activity activity) {
        h hVar = new h(activity);
        hVar.ah(activity.getResources().getColor(this.uS.uM));
        hVar.ag(this.uS.mAlpha);
        hVar.B(this.uS.uO);
        hVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.uV && i == 0) {
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
        if (this.uS.jv != null) {
            hVar.a(a.a(this.uS.jv, 0, i));
        } else {
            View findViewById = activity.findViewById(this.uS.uL);
            if (findViewById != null) {
                hVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.uS.uK);
        if (findViewById2 != null) {
            hVar.b(a.a(findViewById2, 0, i));
        }
        if (this.uS.uJ) {
            hVar.setClickable(false);
        } else {
            hVar.setOnClickListener(this);
        }
        for (b bVar : this.uU) {
            hVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.uS = null;
        this.uU = null;
        this.uW = null;
        this.uT.removeAllViews();
        this.uT = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.uS == null || !this.uS.uN) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.uS != null && this.uS.uN) {
            dismiss();
        }
    }
}
