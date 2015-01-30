package com.baidu.adp.widget.ListView;

import android.view.MotionEvent;
import android.view.View;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af {
    private static float xn = 3.0f;
    private BdListView mListView;
    private j xo;
    private boolean xp = false;
    private int mStartY = 0;
    protected int mState = 3;
    private Boolean xq = false;
    private ad wV = null;
    private int xr = 800;

    public af(BdListView bdListView, j jVar) {
        this.xo = null;
        this.mListView = null;
        if (jVar == null) {
            throw new InvalidParameterException("PullRefresh view is null");
        }
        if (bdListView == null) {
            throw new InvalidParameterException("PullRefresh listView is null");
        }
        this.xo = jVar;
        this.mListView = bdListView;
        View view = this.xo.getView();
        view.setPadding(0, -this.xo.jD(), 0, 0);
        view.invalidate();
        this.mListView.f(view);
    }

    public j jL() {
        return this.xo;
    }

    public void done() {
        this.mState = 3;
        this.xo.setPadding(0, -this.xo.jD(), 0, 0);
        this.xo.R(true);
        if (this.wV != null) {
            this.wV.T(false);
        }
    }

    public void U(boolean z) {
        this.mState = 2;
        this.xo.setPadding(0, this.xo.jB(), 0, 0);
        this.xo.jA();
        this.xo.S(z);
    }

    public void setOnScrollToPullListener(ad adVar) {
        this.wV = adVar;
    }

    public void a(MotionEvent motionEvent, int i) {
        if (motionEvent.getAction() == 0 && jL().jC()) {
            this.xp = false;
            this.xq = false;
            if (i == 0 && !this.xp) {
                this.xp = true;
                this.mStartY = (int) motionEvent.getY();
            }
        }
    }

    public void b(MotionEvent motionEvent, int i) {
        if (jL().jC()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    if (this.mState != 2) {
                        if (this.mState == 1) {
                            this.mState = 3;
                            this.xo.setPadding(0, -this.xo.jD(), 0, 0);
                            this.xo.R(false);
                            if (this.wV != null) {
                                this.wV.T(true);
                                return;
                            }
                            return;
                        } else if (this.mState == 0) {
                            U(false);
                            if (this.wV != null) {
                                this.wV.T(true);
                                return;
                            }
                            return;
                        } else if (this.mState == 3 && this.wV != null) {
                            this.wV.T(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (!this.xp && i == 0) {
                        this.xp = true;
                        this.mStartY = y;
                    }
                    if (this.mState != 2 && this.xp) {
                        if (this.mState == 0) {
                            this.mListView.setSelection(0);
                            if (((int) ((y - this.mStartY) / xn)) < this.xo.jD() && y - this.mStartY > 0) {
                                this.mState = 1;
                                this.xo.Q(this.xq.booleanValue());
                                this.xq = false;
                                if (this.wV != null) {
                                    this.wV.T(true);
                                }
                            } else if (y - this.mStartY <= 0) {
                                this.mState = 3;
                                this.xo.setPadding(0, -this.xo.jD(), 0, 0);
                                this.xo.R(false);
                                if (this.wV != null) {
                                    this.wV.T(true);
                                }
                            }
                        } else if (this.mState == 1) {
                            this.mListView.setSelection(0);
                            if (((int) ((y - this.mStartY) / xn)) >= this.xo.jD()) {
                                this.mState = 0;
                                this.xq = true;
                                this.xo.jz();
                                if (this.wV != null) {
                                    this.wV.T(true);
                                }
                            } else if (y - this.mStartY <= 0) {
                                this.mState = 3;
                                this.xo.setPadding(0, -this.xo.jD(), 0, 0);
                                this.xo.R(false);
                                if (this.wV != null) {
                                    this.wV.T(true);
                                }
                            }
                        } else if (this.mState == 3) {
                            if (y - this.mStartY > 0) {
                                this.mState = 1;
                                this.xo.Q(this.xq.booleanValue());
                                this.xq = false;
                                if (this.wV != null) {
                                    this.wV.T(true);
                                }
                            } else if (this.wV != null) {
                                this.wV.T(false);
                            }
                        }
                        if (this.mState == 1 || this.mState == 0) {
                            this.xo.setPadding(0, ((int) ((y - this.mStartY) / xn)) - this.xo.jD(), 0, 0);
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
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.ListView.BdListView.jI():void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(af afVar) {
        afVar.jM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jM() {
        View view;
        j jL = jL();
        if (jL != null && (view = jL.getView()) != null) {
            ah ahVar = new ah(view.getContext(), 0, -jL.jD(), this.xr);
            ahVar.a(new ag(this));
            ahVar.g(view);
        }
    }
}
