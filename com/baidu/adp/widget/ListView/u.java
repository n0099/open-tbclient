package com.baidu.adp.widget.ListView;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.cyberplayer.sdk.BVideoView;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u {
    private static float b = 3.0f;
    private d c;
    private BdListView f;
    private boolean d = false;
    private int e = 0;

    /* renamed from: a  reason: collision with root package name */
    protected int f580a = 3;
    private Boolean g = false;
    private s h = null;
    private int i = BVideoView.MEDIA_INFO_BAD_INTERLEAVING;

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
        this.f580a = 3;
        this.c.a(0, -this.c.k(), 0, 0);
        this.c.b(true);
        if (this.h != null) {
            this.h.a(false);
        }
    }

    public void a(boolean z) {
        this.f580a = 2;
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
                    if (this.f580a != 2) {
                        if (this.f580a == 1) {
                            this.f580a = 3;
                            this.c.a(0, -this.c.k(), 0, 0);
                            this.c.b(false);
                            if (this.h != null) {
                                this.h.a(true);
                                return;
                            }
                            return;
                        } else if (this.f580a == 0) {
                            a(false);
                            if (this.h != null) {
                                this.h.a(true);
                                return;
                            }
                            return;
                        } else if (this.f580a == 3 && this.h != null) {
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
                    if (this.f580a != 2 && this.d) {
                        if (this.f580a == 0) {
                            this.f.setSelection(0);
                            if (((int) ((y - this.e) / b)) < this.c.k() && y - this.e > 0) {
                                this.f580a = 1;
                                this.c.a(this.g.booleanValue());
                                this.g = false;
                                if (this.h != null) {
                                    this.h.a(true);
                                }
                            } else if (y - this.e <= 0) {
                                this.f580a = 3;
                                this.c.a(0, -this.c.k(), 0, 0);
                                this.c.b(false);
                                if (this.h != null) {
                                    this.h.a(true);
                                }
                            }
                        } else if (this.f580a == 1) {
                            this.f.setSelection(0);
                            if (((int) ((y - this.e) / b)) >= this.c.k()) {
                                this.f580a = 0;
                                this.g = true;
                                this.c.e();
                                if (this.h != null) {
                                    this.h.a(true);
                                }
                            } else if (y - this.e <= 0) {
                                this.f580a = 3;
                                this.c.a(0, -this.c.k(), 0, 0);
                                this.c.b(false);
                                if (this.h != null) {
                                    this.h.a(true);
                                }
                            }
                        } else if (this.f580a == 3) {
                            if (y - this.e > 0) {
                                this.f580a = 1;
                                this.c.a(this.g.booleanValue());
                                this.g = false;
                                if (this.h != null) {
                                    this.h.a(true);
                                }
                            } else if (this.h != null) {
                                this.h.a(false);
                            }
                        }
                        if (this.f580a == 1 || this.f580a == 0) {
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
        d a2 = a();
        if (a2 != null && (i = a2.i()) != null) {
            w wVar = new w(i.getContext(), 0, -a2.k(), this.i);
            wVar.a(new v(this));
            wVar.a(i);
        }
    }
}
