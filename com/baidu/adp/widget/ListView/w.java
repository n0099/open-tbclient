package com.baidu.adp.widget.ListView;

import android.view.MotionEvent;
import android.view.View;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w {
    private static float b = 3.0f;
    private f c;
    private BdListView f;
    private boolean d = false;
    private int e = 0;
    protected int a = 3;
    private Boolean g = false;
    private u h = null;
    private int i = 800;

    public w(BdListView bdListView, f fVar) {
        this.c = null;
        this.f = null;
        if (fVar == null) {
            throw new InvalidParameterException("PullRefresh view is null");
        }
        if (bdListView == null) {
            throw new InvalidParameterException("PullRefresh listView is null");
        }
        this.c = fVar;
        this.f = bdListView;
        View h = this.c.h();
        h.setPadding(0, -this.c.j(), 0, 0);
        h.invalidate();
        this.f.a(h);
    }

    public final f a() {
        return this.c;
    }

    public final void b() {
        this.a = 3;
        this.c.a(0, -this.c.j(), 0, 0);
        this.c.b(true);
        if (this.h != null) {
            this.h.a(false);
        }
    }

    public final void a(boolean z) {
        this.a = 2;
        this.c.a(0, 0, 0, 0);
        this.c.f();
        this.c.c(z);
    }

    public final void a(u uVar) {
        this.h = uVar;
    }

    public final void a(MotionEvent motionEvent, int i) {
        if (motionEvent.getAction() == 0 && this.c.i()) {
            this.d = false;
            this.g = false;
            if (i == 0 && !this.d) {
                this.d = true;
                this.e = (int) motionEvent.getY();
            }
        }
    }

    public final void b(MotionEvent motionEvent, int i) {
        if (this.c.i()) {
            switch (motionEvent.getAction()) {
                case 1:
                    if (this.a != 2) {
                        if (this.a == 1) {
                            this.a = 3;
                            this.c.a(0, -this.c.j(), 0, 0);
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
                            if (((int) ((y - this.e) / b)) < this.c.j() && y - this.e > 0) {
                                this.a = 1;
                                this.c.a(this.g.booleanValue());
                                this.g = false;
                                if (this.h != null) {
                                    this.h.a(true);
                                }
                            } else if (y - this.e <= 0) {
                                this.a = 3;
                                this.c.a(0, -this.c.j(), 0, 0);
                                this.c.b(false);
                                if (this.h != null) {
                                    this.h.a(true);
                                }
                            }
                        } else if (this.a == 1) {
                            this.f.setSelection(0);
                            if (((int) ((y - this.e) / b)) >= this.c.j()) {
                                this.a = 0;
                                this.g = true;
                                this.c.e();
                                if (this.h != null) {
                                    this.h.a(true);
                                }
                            } else if (y - this.e <= 0) {
                                this.a = 3;
                                this.c.a(0, -this.c.j(), 0, 0);
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
                            this.c.a(0, ((int) ((y - this.e) / b)) - this.c.j(), 0, 0);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(w wVar) {
        View h;
        f fVar = wVar.c;
        if (fVar == null || (h = fVar.h()) == null) {
            return;
        }
        y yVar = new y(h.getContext(), 0, -fVar.j(), wVar.i);
        yVar.a(new x(wVar));
        yVar.a(h);
    }
}
