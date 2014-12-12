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
    private Configuration ju;
    private i jv;
    private b[] jw;
    private boolean jx = true;
    private h jy;

    static {
        $assertionsDisabled = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.ju = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.jw = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        this.jy = hVar;
    }

    public void i(Activity activity) {
        if (this.jv == null) {
            this.jv = j(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.jv.getParent() == null) {
            viewGroup.addView(this.jv);
            if (this.ju.js != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.ju.js);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.jv.startAnimation(loadAnimation);
            } else if (this.jy != null) {
                this.jy.dA();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.jv != null && (viewGroup = (ViewGroup) this.jv.getParent()) != null) {
            if (this.ju.jt != -1) {
                Context context = this.jv.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.ju.jt);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.jv.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.jv);
            if (this.jy != null) {
                this.jy.onDismiss();
            }
            onDestroy();
        }
    }

    public void t(boolean z) {
        this.jx = z;
    }

    private i j(Activity activity) {
        i iVar = new i(activity);
        iVar.L(activity.getResources().getColor(this.ju.jo));
        iVar.K(this.ju.mAlpha);
        iVar.x(this.ju.jq);
        iVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.jx && i == 0) {
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
        if (this.ju.aD != null) {
            iVar.a(a.a(this.ju.aD, 0, i));
        } else {
            View findViewById = activity.findViewById(this.ju.jn);
            if (findViewById != null) {
                iVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.ju.jm);
        if (findViewById2 != null) {
            iVar.b(a.a(findViewById2, 0, i));
        }
        if (this.ju.jl) {
            iVar.setClickable(false);
        } else {
            iVar.setOnClickListener(this);
        }
        for (b bVar : this.jw) {
            iVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.ju = null;
        this.jw = null;
        this.jy = null;
        this.jv.removeAllViews();
        this.jv = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.ju == null || !this.ju.jp) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ju != null && this.ju.jp) {
            dismiss();
        }
    }
}
