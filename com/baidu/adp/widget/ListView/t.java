package com.baidu.adp.widget.ListView;

import android.view.MotionEvent;
import android.view.View;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t {
    private static float b = 3.0f;
    private d c;
    private BdListView f;
    private boolean d = false;
    private int e = 0;

    /* renamed from: a  reason: collision with root package name */
    protected int f574a = 3;
    private Boolean g = false;

    public t(BdListView bdListView, d dVar) {
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
        View f = this.c.f();
        f.setPadding(0, -this.c.h(), 0, 0);
        f.invalidate();
        this.f.a(f);
    }

    public d a() {
        return this.c;
    }

    public void b() {
        this.f574a = 3;
        this.c.a(0, -this.c.h(), 0, 0);
        this.c.b(true);
    }

    public void a(boolean z) {
        this.f574a = 2;
        this.c.a(0, 0, 0, 0);
        this.c.c();
        this.c.c(z);
    }

    public void a(MotionEvent motionEvent, int i) {
        if (motionEvent.getAction() == 0 && a().g()) {
            this.d = false;
            this.g = false;
            if (i == 0 && !this.d) {
                this.d = true;
                this.e = (int) motionEvent.getY();
            }
        }
    }

    public void b(MotionEvent motionEvent, int i) {
        if (a().g()) {
            switch (motionEvent.getAction()) {
                case 1:
                    if (this.f574a != 2) {
                        if (this.f574a == 1) {
                            this.f574a = 3;
                            this.c.a(0, -this.c.h(), 0, 0);
                            this.c.b(false);
                            return;
                        } else if (this.f574a == 0) {
                            a(false);
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
                    if (this.f574a != 2 && this.d) {
                        if (this.f574a == 0) {
                            this.f.setSelection(0);
                            if (((int) ((y - this.e) / b)) < this.c.h() && y - this.e > 0) {
                                this.f574a = 1;
                                this.c.a(this.g.booleanValue());
                                this.g = false;
                            } else if (y - this.e <= 0) {
                                this.f574a = 3;
                                this.c.a(0, -this.c.h(), 0, 0);
                                this.c.b(false);
                            }
                        } else if (this.f574a == 1) {
                            this.f.setSelection(0);
                            if (((int) ((y - this.e) / b)) >= this.c.h()) {
                                this.f574a = 0;
                                this.g = true;
                                this.c.b();
                            } else if (y - this.e <= 0) {
                                this.f574a = 3;
                                this.c.a(0, -this.c.h(), 0, 0);
                                this.c.b(false);
                            }
                        } else if (this.f574a == 3 && y - this.e > 0) {
                            this.f574a = 1;
                            this.c.a(this.g.booleanValue());
                            this.g = false;
                        }
                        if (this.f574a == 1 || this.f574a == 0) {
                            this.c.a(0, ((int) ((y - this.e) / b)) - this.c.h(), 0, 0);
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
}
