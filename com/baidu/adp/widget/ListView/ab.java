package com.baidu.adp.widget.ListView;

import android.view.MotionEvent;
import android.view.View;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab {
    private static float HU = 3.0f;
    private f HV;
    private BdListView mListView;
    private boolean HW = false;
    private int mStartY = 0;
    protected int mState = 3;
    private Boolean HX = false;
    private z HC = null;
    private int HY = 800;

    public ab(BdListView bdListView, f fVar) {
        this.HV = null;
        this.mListView = null;
        if (fVar == null) {
            throw new InvalidParameterException("PullRefresh view is null");
        }
        if (bdListView == null) {
            throw new InvalidParameterException("PullRefresh listView is null");
        }
        this.HV = fVar;
        this.mListView = bdListView;
        View view = this.HV.getView();
        view.setPadding(0, -this.HV.nj(), 0, 0);
        view.invalidate();
        this.mListView.f(view);
    }

    public f nq() {
        return this.HV;
    }

    public void done() {
        this.mState = 3;
        this.HV.setPadding(0, -this.HV.nj(), 0, 0);
        this.HV.R(true);
        if (this.HC != null) {
            this.HC.T(false);
        }
    }

    public void U(boolean z) {
        this.mState = 2;
        this.HV.setPadding(0, 0, 0, 0);
        this.HV.ni();
        this.HV.S(z);
    }

    public void setOnScrollToPullListener(z zVar) {
        this.HC = zVar;
    }

    public void a(MotionEvent motionEvent, int i) {
        if (motionEvent.getAction() == 0 && nq().isEnable()) {
            this.HW = false;
            this.HX = false;
            if (i == 0 && !this.HW) {
                this.HW = true;
                this.mStartY = (int) motionEvent.getY();
            }
        }
    }

    public void b(MotionEvent motionEvent, int i) {
        if (nq().isEnable()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    if (this.mState != 2) {
                        if (this.mState == 1) {
                            this.mState = 3;
                            this.HV.setPadding(0, -this.HV.nj(), 0, 0);
                            this.HV.R(false);
                            if (this.HC != null) {
                                this.HC.T(true);
                                return;
                            }
                            return;
                        } else if (this.mState == 0) {
                            U(false);
                            if (this.HC != null) {
                                this.HC.T(true);
                                return;
                            }
                            return;
                        } else if (this.mState == 3 && this.HC != null) {
                            this.HC.T(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (!this.HW && i == 0) {
                        this.HW = true;
                        this.mStartY = y;
                    }
                    if (this.mState != 2 && this.HW) {
                        if (this.mState == 0) {
                            this.mListView.setSelection(0);
                            if (((int) ((y - this.mStartY) / HU)) < this.HV.nj() && y - this.mStartY > 0) {
                                this.mState = 1;
                                this.HV.Q(this.HX.booleanValue());
                                this.HX = false;
                                if (this.HC != null) {
                                    this.HC.T(true);
                                }
                            } else if (y - this.mStartY <= 0) {
                                this.mState = 3;
                                this.HV.setPadding(0, -this.HV.nj(), 0, 0);
                                this.HV.R(false);
                                if (this.HC != null) {
                                    this.HC.T(true);
                                }
                            }
                        } else if (this.mState == 1) {
                            this.mListView.setSelection(0);
                            if (((int) ((y - this.mStartY) / HU)) >= this.HV.nj()) {
                                this.mState = 0;
                                this.HX = true;
                                this.HV.nh();
                                if (this.HC != null) {
                                    this.HC.T(true);
                                }
                            } else if (y - this.mStartY <= 0) {
                                this.mState = 3;
                                this.HV.setPadding(0, -this.HV.nj(), 0, 0);
                                this.HV.R(false);
                                if (this.HC != null) {
                                    this.HC.T(true);
                                }
                            }
                        } else if (this.mState == 3) {
                            if (y - this.mStartY > 0) {
                                this.mState = 1;
                                this.HV.Q(this.HX.booleanValue());
                                this.HX = false;
                                if (this.HC != null) {
                                    this.HC.T(true);
                                }
                            } else if (this.HC != null) {
                                this.HC.T(false);
                            }
                        }
                        if (this.mState == 1 || this.mState == 0) {
                            this.HV.setPadding(0, ((int) ((y - this.mStartY) / HU)) - this.HV.nj(), 0, 0);
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
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.ListView.BdListView.completePullRefresh():void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ab abVar) {
        abVar.nr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr() {
        View view;
        f nq = nq();
        if (nq != null && (view = nq.getView()) != null) {
            ad adVar = new ad(view.getContext(), 0, -nq.nj(), this.HY);
            adVar.a(new ac(this));
            adVar.g(view);
        }
    }
}
