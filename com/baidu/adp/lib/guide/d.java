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
    static final /* synthetic */ boolean ju;
    private Configuration jq;
    private i jr;
    private b[] js;
    private h jt;

    static {
        ju = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.jq = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.js = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        this.jt = hVar;
    }

    public void c(Activity activity) {
        if (this.jr == null) {
            this.jr = d(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.jr.getParent() == null) {
            viewGroup.addView(this.jr);
            if (this.jq.jo != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.jq.jo);
                if (!ju && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.jr.startAnimation(loadAnimation);
            } else if (this.jt != null) {
                this.jt.dB();
            }
        }
    }

    public void dismiss() {
        ViewGroup viewGroup;
        if (this.jr != null && (viewGroup = (ViewGroup) this.jr.getParent()) != null) {
            if (this.jq.jp != -1) {
                Context context = this.jr.getContext();
                if (!ju && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.jq.jp);
                if (!ju && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.jr.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.jr);
            if (this.jt != null) {
                this.jt.onDismiss();
            }
            onDestroy();
        }
    }

    private i d(Activity activity) {
        i iVar = new i(activity);
        iVar.D(activity.getResources().getColor(this.jq.jk));
        iVar.C(this.jq.jh);
        iVar.t(this.jq.jm);
        iVar.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (i == 0) {
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
        if (this.jq.jf != null) {
            iVar.a(a.a(this.jq.jf, 0, i));
        } else {
            View findViewById = activity.findViewById(this.jq.jj);
            if (findViewById != null) {
                iVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.jq.ji);
        if (findViewById2 != null) {
            iVar.b(a.a(findViewById2, 0, i));
        }
        if (this.jq.jg) {
            iVar.setClickable(false);
        } else {
            iVar.setOnClickListener(this);
        }
        for (b bVar : this.js) {
            iVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.jq = null;
        this.js = null;
        this.jt = null;
        this.jr.removeAllViews();
        this.jr = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.jq == null || !this.jq.jl) {
                return false;
            }
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jq != null && this.jq.jl) {
            dismiss();
        }
    }
}
