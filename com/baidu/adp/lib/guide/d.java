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

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f495a;
    private Configuration b;
    private i c;
    private b[] d;
    private h e;

    static {
        f495a = !d.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        this.b = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b[] bVarArr) {
        this.d = bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        this.e = hVar;
    }

    public void a(Activity activity) {
        if (this.c == null) {
            this.c = b(activity);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.c.getParent() == null) {
            viewGroup.addView(this.c);
            if (this.b.i != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, this.b.i);
                if (!f495a && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new e(this));
                this.c.startAnimation(loadAnimation);
            } else if (this.e != null) {
                this.e.a();
            }
        }
    }

    public void a() {
        ViewGroup viewGroup;
        if (this.c != null && (viewGroup = (ViewGroup) this.c.getParent()) != null) {
            if (this.b.j != -1) {
                Context context = this.c.getContext();
                if (!f495a && context == null) {
                    throw new AssertionError();
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(context, this.b.j);
                if (!f495a && loadAnimation == null) {
                    throw new AssertionError();
                }
                loadAnimation.setAnimationListener(new f(this, viewGroup));
                this.c.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.c);
            if (this.e != null) {
                this.e.b();
            }
            b();
        }
    }

    private i b(Activity activity) {
        i iVar = new i(activity);
        iVar.b(activity.getResources().getColor(this.b.e));
        iVar.a(this.b.b);
        iVar.a(this.b.g);
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
        if (this.b.f494a != null) {
            iVar.a(a.a(this.b.f494a, 0, i));
        } else {
            View findViewById = activity.findViewById(this.b.d);
            if (findViewById != null) {
                iVar.a(a.a(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.b.c);
        if (findViewById2 != null) {
            iVar.b(a.a(findViewById2, 0, i));
        }
        iVar.setOnClickListener(this);
        for (b bVar : this.d) {
            iVar.addView(a.a(activity.getLayoutInflater(), bVar));
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.b = null;
        this.d = null;
        this.e = null;
        this.c.removeAllViews();
        this.c = null;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (this.b == null || !this.b.f) {
                return false;
            }
            a();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b != null && this.b.f) {
            a();
        }
    }
}
