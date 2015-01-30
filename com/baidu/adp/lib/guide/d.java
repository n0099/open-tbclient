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
    private h jA;
    private Configuration jw;
    private i jx;
    private b[] jy;
    private boolean jz = true;

    static {
        $assertionsDisabled = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.jw = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.jy = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        this.jA = hVar;
    }

    public void i(Activity activity) {
        if (this.jx == null) {
            this.jx = j(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.jx.getParent() == null) {
            viewGroup.addView(this.jx);
            if (this.jw.ju != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.jw.ju);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.jx.startAnimation(loadAnimation);
            } else if (this.jA != null) {
                this.jA.dy();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.jx != null && (viewGroup = (ViewGroup) this.jx.getParent()) != null) {
            if (this.jw.jv != -1) {
                Context context = this.jx.getContext();
                if (!$assertionsDisabled && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.jw.jv);
                if (!$assertionsDisabled && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.jx.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.jx);
            if (this.jA != null) {
                this.jA.onDismiss();
            }
            onDestroy();
        }
    }

    public void t(boolean z) {
        this.jz = z;
    }

    private i j(Activity activity) {
        i iVar = new i(activity);
        iVar.Q(activity.getResources().getColor(this.jw.jq));
        iVar.P(this.jw.mAlpha);
        iVar.x(this.jw.js);
        iVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.jz && i == 0) {
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
        if (this.jw.aE != null) {
            iVar.a(a.a(this.jw.aE, 0, i));
        } else {
            View findViewById = activity.findViewById(this.jw.jp);
            if (findViewById != null) {
                iVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.jw.jo);
        if (findViewById2 != null) {
            iVar.b(a.a(findViewById2, 0, i));
        }
        if (this.jw.jn) {
            iVar.setClickable(false);
        } else {
            iVar.setOnClickListener(this);
        }
        for (b bVar : this.jy) {
            iVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.jw = null;
        this.jy = null;
        this.jA = null;
        this.jx.removeAllViews();
        this.jx = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.jw == null || !this.jw.jr) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jw != null && this.jw.jr) {
            dismiss();
        }
    }
}
