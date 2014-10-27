package com.baidu.adp.widget.ListView;

import android.view.MotionEvent;
import android.view.View;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae {
    private static float vh = 3.0f;
    private i vi;
    private BdListView vl;
    private boolean vj = false;
    private int vk = 0;
    protected int mState = 3;
    private Boolean vm = false;
    private ac uP = null;
    private int vn = 800;

    public ae(BdListView bdListView, i iVar) {
        this.vi = null;
        this.vl = null;
        if (iVar == null) {
            throw new InvalidParameterException("PullRefresh view is null");
        }
        if (bdListView == null) {
            throw new InvalidParameterException("PullRefresh listView is null");
        }
        this.vi = iVar;
        this.vl = bdListView;
        View view = this.vi.getView();
        view.setPadding(0, -this.vi.hI(), 0, 0);
        view.invalidate();
        this.vl.f(view);
    }

    public i hS() {
        return this.vi;
    }

    public void done() {
        this.mState = 3;
        this.vi.setPadding(0, -this.vi.hI(), 0, 0);
        this.vi.F(true);
        if (this.uP != null) {
            this.uP.I(false);
        }
    }

    public void J(boolean z) {
        this.mState = 2;
        this.vi.setPadding(0, 0, 0, 0);
        this.vi.hF();
        this.vi.G(z);
    }

    public void setOnScrollToPullListener(ac acVar) {
        this.uP = acVar;
    }

    public void a(MotionEvent motionEvent, int i) {
        if (motionEvent.getAction() == 0 && hS().hH()) {
            this.vj = false;
            this.vm = false;
            if (i == 0 && !this.vj) {
                this.vj = true;
                this.vk = (int) motionEvent.getY();
            }
        }
    }

    public void b(MotionEvent motionEvent, int i) {
        if (hS().hH()) {
            switch (motionEvent.getAction()) {
                case 1:
                    if (this.mState != 2) {
                        if (this.mState == 1) {
                            this.mState = 3;
                            this.vi.setPadding(0, -this.vi.hI(), 0, 0);
                            this.vi.F(false);
                            if (this.uP != null) {
                                this.uP.I(true);
                                return;
                            }
                            return;
                        } else if (this.mState == 0) {
                            J(false);
                            if (this.uP != null) {
                                this.uP.I(true);
                                return;
                            }
                            return;
                        } else if (this.mState == 3 && this.uP != null) {
                            this.uP.I(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (!this.vj && i == 0) {
                        this.vj = true;
                        this.vk = y;
                    }
                    if (this.mState != 2 && this.vj) {
                        if (this.mState == 0) {
                            this.vl.setSelection(0);
                            if (((int) ((y - this.vk) / vh)) < this.vi.hI() && y - this.vk > 0) {
                                this.mState = 1;
                                this.vi.E(this.vm.booleanValue());
                                this.vm = false;
                                if (this.uP != null) {
                                    this.uP.I(true);
                                }
                            } else if (y - this.vk <= 0) {
                                this.mState = 3;
                                this.vi.setPadding(0, -this.vi.hI(), 0, 0);
                                this.vi.F(false);
                                if (this.uP != null) {
                                    this.uP.I(true);
                                }
                            }
                        } else if (this.mState == 1) {
                            this.vl.setSelection(0);
                            if (((int) ((y - this.vk) / vh)) >= this.vi.hI()) {
                                this.mState = 0;
                                this.vm = true;
                                this.vi.hE();
                                if (this.uP != null) {
                                    this.uP.I(true);
                                }
                            } else if (y - this.vk <= 0) {
                                this.mState = 3;
                                this.vi.setPadding(0, -this.vi.hI(), 0, 0);
                                this.vi.F(false);
                                if (this.uP != null) {
                                    this.uP.I(true);
                                }
                            }
                        } else if (this.mState == 3) {
                            if (y - this.vk > 0) {
                                this.mState = 1;
                                this.vi.E(this.vm.booleanValue());
                                this.vm = false;
                                if (this.uP != null) {
                                    this.uP.I(true);
                                }
                            } else if (this.uP != null) {
                                this.uP.I(false);
                            }
                        }
                        if (this.mState == 1 || this.mState == 0) {
                            this.vi.setPadding(0, ((int) ((y - this.vk) / vh)) - this.vi.hI(), 0, 0);
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

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.ListView.BdListView.hN():void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ae aeVar) {
        aeVar.hT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hT() {
        View view;
        i hS = hS();
        if (hS != null && (view = hS.getView()) != null) {
            ag agVar = new ag(view.getContext(), 0, -hS.hI(), this.vn);
            agVar.a(new af(this));
            agVar.g(view);
        }
    }
}
