package com.baidu.adp.widget.ListView;

import android.view.MotionEvent;
import android.view.View;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab {
    private static float Ie = 3.0f;
    private f If;
    private BdListView mListView;
    private boolean Ig = false;
    private int mStartY = 0;
    protected int mState = 3;
    private Boolean Ih = false;
    private z HM = null;
    private int Ii = 800;

    public ab(BdListView bdListView, f fVar) {
        this.If = null;
        this.mListView = null;
        if (fVar == null) {
            throw new InvalidParameterException("PullRefresh view is null");
        }
        if (bdListView == null) {
            throw new InvalidParameterException("PullRefresh listView is null");
        }
        this.If = fVar;
        this.mListView = bdListView;
        View view = this.If.getView();
        view.setPadding(0, -this.If.mR(), 0, 0);
        view.invalidate();
        this.mListView.f(view);
    }

    public f mZ() {
        return this.If;
    }

    public void done() {
        this.mState = 3;
        this.If.setPadding(0, -this.If.mR(), 0, 0);
        this.If.P(true);
        if (this.HM != null) {
            this.HM.R(false);
        }
    }

    public void S(boolean z) {
        this.mState = 2;
        this.If.setPadding(0, 0, 0, 0);
        this.If.mP();
        this.If.Q(z);
    }

    public void setOnScrollToPullListener(z zVar) {
        this.HM = zVar;
    }

    public void a(MotionEvent motionEvent, int i) {
        if (motionEvent.getAction() == 0 && mZ().mQ()) {
            this.Ig = false;
            this.Ih = false;
            if (i == 0 && !this.Ig) {
                this.Ig = true;
                this.mStartY = (int) motionEvent.getY();
            }
        }
    }

    public void b(MotionEvent motionEvent, int i) {
        if (mZ().mQ()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    if (this.mState != 2) {
                        if (this.mState == 1) {
                            this.mState = 3;
                            this.If.setPadding(0, -this.If.mR(), 0, 0);
                            this.If.P(false);
                            if (this.HM != null) {
                                this.HM.R(true);
                                return;
                            }
                            return;
                        } else if (this.mState == 0) {
                            S(false);
                            if (this.HM != null) {
                                this.HM.R(true);
                                return;
                            }
                            return;
                        } else if (this.mState == 3 && this.HM != null) {
                            this.HM.R(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (!this.Ig && i == 0) {
                        this.Ig = true;
                        this.mStartY = y;
                    }
                    if (this.mState != 2 && this.Ig) {
                        if (this.mState == 0) {
                            this.mListView.setSelection(0);
                            if (((int) ((y - this.mStartY) / Ie)) < this.If.mR() && y - this.mStartY > 0) {
                                this.mState = 1;
                                this.If.O(this.Ih.booleanValue());
                                this.Ih = false;
                                if (this.HM != null) {
                                    this.HM.R(true);
                                }
                            } else if (y - this.mStartY <= 0) {
                                this.mState = 3;
                                this.If.setPadding(0, -this.If.mR(), 0, 0);
                                this.If.P(false);
                                if (this.HM != null) {
                                    this.HM.R(true);
                                }
                            }
                        } else if (this.mState == 1) {
                            this.mListView.setSelection(0);
                            if (((int) ((y - this.mStartY) / Ie)) >= this.If.mR()) {
                                this.mState = 0;
                                this.Ih = true;
                                this.If.mO();
                                if (this.HM != null) {
                                    this.HM.R(true);
                                }
                            } else if (y - this.mStartY <= 0) {
                                this.mState = 3;
                                this.If.setPadding(0, -this.If.mR(), 0, 0);
                                this.If.P(false);
                                if (this.HM != null) {
                                    this.HM.R(true);
                                }
                            }
                        } else if (this.mState == 3) {
                            if (y - this.mStartY > 0) {
                                this.mState = 1;
                                this.If.O(this.Ih.booleanValue());
                                this.Ih = false;
                                if (this.HM != null) {
                                    this.HM.R(true);
                                }
                            } else if (this.HM != null) {
                                this.HM.R(false);
                            }
                        }
                        if (this.mState == 1 || this.mState == 0) {
                            this.If.setPadding(0, ((int) ((y - this.mStartY) / Ie)) - this.If.mR(), 0, 0);
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
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.ListView.BdListView.mW():void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ab abVar) {
        abVar.na();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na() {
        View view;
        f mZ = mZ();
        if (mZ != null && (view = mZ.getView()) != null) {
            ad adVar = new ad(view.getContext(), 0, -mZ.mR(), this.Ii);
            adVar.a(new ac(this));
            adVar.g(view);
        }
    }
}
