package com.baidu.adp.widget.ListView;

import android.view.MotionEvent;
import android.view.View;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af {
    private static float xk = 3.0f;
    private BdListView mListView;
    private j xl;
    private boolean xm = false;
    private int mStartY = 0;
    protected int mState = 3;
    private Boolean xn = false;
    private ad wS = null;
    private int xo = 800;

    public af(BdListView bdListView, j jVar) {
        this.xl = null;
        this.mListView = null;
        if (jVar == null) {
            throw new InvalidParameterException("PullRefresh view is null");
        }
        if (bdListView == null) {
            throw new InvalidParameterException("PullRefresh listView is null");
        }
        this.xl = jVar;
        this.mListView = bdListView;
        View view = this.xl.getView();
        view.setPadding(0, -this.xl.jw(), 0, 0);
        view.invalidate();
        this.mListView.f(view);
    }

    public j jE() {
        return this.xl;
    }

    public void done() {
        this.mState = 3;
        this.xl.setPadding(0, -this.xl.jw(), 0, 0);
        this.xl.R(true);
        if (this.wS != null) {
            this.wS.T(false);
        }
    }

    public void U(boolean z) {
        this.mState = 2;
        this.xl.setPadding(0, this.xl.ju(), 0, 0);
        this.xl.jt();
        this.xl.S(z);
    }

    public void setOnScrollToPullListener(ad adVar) {
        this.wS = adVar;
    }

    public void a(MotionEvent motionEvent, int i) {
        if (motionEvent.getAction() == 0 && jE().jv()) {
            this.xm = false;
            this.xn = false;
            if (i == 0 && !this.xm) {
                this.xm = true;
                this.mStartY = (int) motionEvent.getY();
            }
        }
    }

    public void b(MotionEvent motionEvent, int i) {
        if (jE().jv()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    if (this.mState != 2) {
                        if (this.mState == 1) {
                            this.mState = 3;
                            this.xl.setPadding(0, -this.xl.jw(), 0, 0);
                            this.xl.R(false);
                            if (this.wS != null) {
                                this.wS.T(true);
                                return;
                            }
                            return;
                        } else if (this.mState == 0) {
                            U(false);
                            if (this.wS != null) {
                                this.wS.T(true);
                                return;
                            }
                            return;
                        } else if (this.mState == 3 && this.wS != null) {
                            this.wS.T(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (!this.xm && i == 0) {
                        this.xm = true;
                        this.mStartY = y;
                    }
                    if (this.mState != 2 && this.xm) {
                        if (this.mState == 0) {
                            this.mListView.setSelection(0);
                            if (((int) ((y - this.mStartY) / xk)) < this.xl.jw() && y - this.mStartY > 0) {
                                this.mState = 1;
                                this.xl.Q(this.xn.booleanValue());
                                this.xn = false;
                                if (this.wS != null) {
                                    this.wS.T(true);
                                }
                            } else if (y - this.mStartY <= 0) {
                                this.mState = 3;
                                this.xl.setPadding(0, -this.xl.jw(), 0, 0);
                                this.xl.R(false);
                                if (this.wS != null) {
                                    this.wS.T(true);
                                }
                            }
                        } else if (this.mState == 1) {
                            this.mListView.setSelection(0);
                            if (((int) ((y - this.mStartY) / xk)) >= this.xl.jw()) {
                                this.mState = 0;
                                this.xn = true;
                                this.xl.js();
                                if (this.wS != null) {
                                    this.wS.T(true);
                                }
                            } else if (y - this.mStartY <= 0) {
                                this.mState = 3;
                                this.xl.setPadding(0, -this.xl.jw(), 0, 0);
                                this.xl.R(false);
                                if (this.wS != null) {
                                    this.wS.T(true);
                                }
                            }
                        } else if (this.mState == 3) {
                            if (y - this.mStartY > 0) {
                                this.mState = 1;
                                this.xl.Q(this.xn.booleanValue());
                                this.xn = false;
                                if (this.wS != null) {
                                    this.wS.T(true);
                                }
                            } else if (this.wS != null) {
                                this.wS.T(false);
                            }
                        }
                        if (this.mState == 1 || this.mState == 0) {
                            this.xl.setPadding(0, ((int) ((y - this.mStartY) / xk)) - this.xl.jw(), 0, 0);
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
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.ListView.BdListView.jB():void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(af afVar) {
        afVar.jF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jF() {
        View view;
        j jE = jE();
        if (jE != null && (view = jE.getView()) != null) {
            ah ahVar = new ah(view.getContext(), 0, -jE.jw(), this.xo);
            ahVar.a(new ag(this));
            ahVar.g(view);
        }
    }
}
