package com.baidu.adp.widget.ListView;

import android.view.MotionEvent;
import android.view.View;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u {
    private static float b = 3.0f;
    private d c;
    private BdListView f;
    private boolean d = false;
    private int e = 0;
    protected int a = 3;
    private Boolean g = false;
    private s h = null;
    private int i = 800;

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.ListView.BdListView.a():void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(u uVar) {
        uVar.c();
    }

    public u(BdListView bdListView, d dVar) {
        this.c = null;
        this.f = null;
        if (dVar == null) {
            throw new InvalidParameterException("PullRefresh view is null");
        }
        if (bdListView == null) {
            throw new InvalidParameterException("PullRefresh listView is null");
        }
        this.c = dVar;
        this.f = bdListView;
        View i = this.c.i();
        i.setPadding(0, -this.c.k(), 0, 0);
        i.invalidate();
        this.f.a(i);
    }

    public d a() {
        return this.c;
    }

    public void b() {
        this.a = 3;
        this.c.a(0, -this.c.k(), 0, 0);
        this.c.b(true);
        if (this.h != null) {
            this.h.a(false);
        }
    }

    public void a(boolean z) {
        this.a = 2;
        this.c.a(0, 0, 0, 0);
        this.c.f();
        this.c.c(z);
    }

    public void a(s sVar) {
        this.h = sVar;
    }

    public void a(MotionEvent motionEvent, int i) {
        if (motionEvent.getAction() == 0 && a().j()) {
            this.d = false;
            this.g = false;
            if (i == 0 && !this.d) {
                this.d = true;
                this.e = (int) motionEvent.getY();
            }
        }
    }

    public void b(MotionEvent motionEvent, int i) {
        if (a().j()) {
            switch (motionEvent.getAction()) {
                case 1:
                    if (this.a != 2) {
                        if (this.a == 1) {
                            this.a = 3;
                            this.c.a(0, -this.c.k(), 0, 0);
                            this.c.b(false);
                            if (this.h != null) {
                                this.h.a(true);
                                return;
                            }
                            return;
                        } else if (this.a == 0) {
                            a(false);
                            if (this.h != null) {
                                this.h.a(true);
                                return;
                            }
                            return;
                        } else if (this.a == 3 && this.h != null) {
                            this.h.a(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (!this.d && i == 0) {
                        this.d = true;
                        this.e = y;
                    }
                    if (this.a != 2 && this.d) {
                        if (this.a == 0) {
                            this.f.setSelection(0);
                            if (((int) ((y - this.e) / b)) < this.c.k() && y - this.e > 0) {
                                this.a = 1;
                                this.c.a(this.g.booleanValue());
                                this.g = false;
                                if (this.h != null) {
                                    this.h.a(true);
                                }
                            } else if (y - this.e <= 0) {
                                this.a = 3;
                                this.c.a(0, -this.c.k(), 0, 0);
                                this.c.b(false);
                                if (this.h != null) {
                                    this.h.a(true);
                                }
                            }
                        } else if (this.a == 1) {
                            this.f.setSelection(0);
                            if (((int) ((y - this.e) / b)) >= this.c.k()) {
                                this.a = 0;
                                this.g = true;
                                this.c.e();
                                if (this.h != null) {
                                    this.h.a(true);
                                }
                            } else if (y - this.e <= 0) {
                                this.a = 3;
                                this.c.a(0, -this.c.k(), 0, 0);
                                this.c.b(false);
                                if (this.h != null) {
                                    this.h.a(true);
                                }
                            }
                        } else if (this.a == 3) {
                            if (y - this.e > 0) {
                                this.a = 1;
                                this.c.a(this.g.booleanValue());
                                this.g = false;
                                if (this.h != null) {
                                    this.h.a(true);
                                }
                            } else if (this.h != null) {
                                this.h.a(false);
                            }
                        }
                        if (this.a == 1 || this.a == 0) {
                            this.c.a(0, ((int) ((y - this.e) / b)) - this.c.k(), 0, 0);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        View i;
        d a = a();
        if (a != null && (i = a.i()) != null) {
            w wVar = new w(i.getContext(), 0, -a.k(), this.i);
            wVar.a(new v(this));
            wVar.a(i);
        }
    }
}
