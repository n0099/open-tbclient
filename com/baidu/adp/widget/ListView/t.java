package com.baidu.adp.widget.ListView;

import android.view.MotionEvent;
import android.view.View;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
class t {
    private static float a = 3.0f;
    private d b;
    private BdListView f;
    private boolean c = false;
    private int d = 0;
    private int e = 3;
    private Boolean g = false;

    public t(BdListView bdListView, d dVar) {
        this.b = null;
        this.f = null;
        if (dVar == null) {
            throw new InvalidParameterException("PullRefresh view is null");
        }
        if (bdListView == null) {
            throw new InvalidParameterException("PullRefresh listView is null");
        }
        this.b = dVar;
        this.f = bdListView;
        View f = this.b.f();
        f.setPadding(0, -this.b.h(), 0, 0);
        f.invalidate();
        this.f.a(f);
    }

    public d a() {
        return this.b;
    }

    public void b() {
        this.e = 3;
        this.b.a(0, -this.b.h(), 0, 0);
        this.b.b(true);
    }

    public void a(boolean z) {
        this.e = 2;
        this.b.a(0, 0, 0, 0);
        this.b.c();
        this.b.c(z);
    }

    public void a(MotionEvent motionEvent, int i) {
        if (a().g()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.c = false;
                    this.g = false;
                    if (i == 0 && !this.c) {
                        this.c = true;
                        this.d = (int) motionEvent.getY();
                        return;
                    }
                    return;
                case 1:
                    if (this.e != 2) {
                        if (this.e == 1) {
                            this.e = 3;
                            this.b.a(0, -this.b.h(), 0, 0);
                            this.b.b(false);
                            return;
                        } else if (this.e == 0) {
                            a(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (!this.c && i == 0) {
                        this.c = true;
                        this.d = y;
                    }
                    if (this.e != 2 && this.c) {
                        if (this.e == 0) {
                            this.f.setSelection(0);
                            if (((int) ((y - this.d) / a)) < this.b.h() && y - this.d > 0) {
                                this.e = 1;
                                this.b.a(this.g.booleanValue());
                                this.g = false;
                            } else if (y - this.d <= 0) {
                                this.e = 3;
                                this.b.a(0, -this.b.h(), 0, 0);
                                this.b.b(false);
                            }
                        } else if (this.e == 1) {
                            this.f.setSelection(0);
                            if (((int) ((y - this.d) / a)) >= this.b.h()) {
                                this.e = 0;
                                this.g = true;
                                this.b.b();
                            } else if (y - this.d <= 0) {
                                this.e = 3;
                                this.b.a(0, -this.b.h(), 0, 0);
                                this.b.b(false);
                            }
                        } else if (this.e == 3 && y - this.d > 0) {
                            this.e = 1;
                            this.b.a(this.g.booleanValue());
                            this.g = false;
                        }
                        if (this.e == 1 || this.e == 0) {
                            this.b.a(0, ((int) ((y - this.d) / a)) - this.b.h(), 0, 0);
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
