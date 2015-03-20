package com.baidu.adp.widget.ListView;

import android.view.MotionEvent;
import android.view.View;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab {
    private static float Ic = 3.0f;
    private f Id;
    private BdListView mListView;
    private boolean Ie = false;
    private int mStartY = 0;
    protected int mState = 3;
    private Boolean If = false;
    private z HK = null;
    private int Ig = 800;

    public ab(BdListView bdListView, f fVar) {
        this.Id = null;
        this.mListView = null;
        if (fVar == null) {
            throw new InvalidParameterException("PullRefresh view is null");
        }
        if (bdListView == null) {
            throw new InvalidParameterException("PullRefresh listView is null");
        }
        this.Id = fVar;
        this.mListView = bdListView;
        View view = this.Id.getView();
        view.setPadding(0, -this.Id.mR(), 0, 0);
        view.invalidate();
        this.mListView.f(view);
    }

    public f mZ() {
        return this.Id;
    }

    public void done() {
        this.mState = 3;
        this.Id.setPadding(0, -this.Id.mR(), 0, 0);
        this.Id.P(true);
        if (this.HK != null) {
            this.HK.R(false);
        }
    }

    public void S(boolean z) {
        this.mState = 2;
        this.Id.setPadding(0, 0, 0, 0);
        this.Id.mP();
        this.Id.Q(z);
    }

    public void setOnScrollToPullListener(z zVar) {
        this.HK = zVar;
    }

    public void a(MotionEvent motionEvent, int i) {
        if (motionEvent.getAction() == 0 && mZ().mQ()) {
            this.Ie = false;
            this.If = false;
            if (i == 0 && !this.Ie) {
                this.Ie = true;
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
                            this.Id.setPadding(0, -this.Id.mR(), 0, 0);
                            this.Id.P(false);
                            if (this.HK != null) {
                                this.HK.R(true);
                                return;
                            }
                            return;
                        } else if (this.mState == 0) {
                            S(false);
                            if (this.HK != null) {
                                this.HK.R(true);
                                return;
                            }
                            return;
                        } else if (this.mState == 3 && this.HK != null) {
                            this.HK.R(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 2:
                    int y = (int) motionEvent.getY();
                    if (!this.Ie && i == 0) {
                        this.Ie = true;
                        this.mStartY = y;
                    }
                    if (this.mState != 2 && this.Ie) {
                        if (this.mState == 0) {
                            this.mListView.setSelection(0);
                            if (((int) ((y - this.mStartY) / Ic)) < this.Id.mR() && y - this.mStartY > 0) {
                                this.mState = 1;
                                this.Id.O(this.If.booleanValue());
                                this.If = false;
                                if (this.HK != null) {
                                    this.HK.R(true);
                                }
                            } else if (y - this.mStartY <= 0) {
                                this.mState = 3;
                                this.Id.setPadding(0, -this.Id.mR(), 0, 0);
                                this.Id.P(false);
                                if (this.HK != null) {
                                    this.HK.R(true);
                                }
                            }
                        } else if (this.mState == 1) {
                            this.mListView.setSelection(0);
                            if (((int) ((y - this.mStartY) / Ic)) >= this.Id.mR()) {
                                this.mState = 0;
                                this.If = true;
                                this.Id.mO();
                                if (this.HK != null) {
                                    this.HK.R(true);
                                }
                            } else if (y - this.mStartY <= 0) {
                                this.mState = 3;
                                this.Id.setPadding(0, -this.Id.mR(), 0, 0);
                                this.Id.P(false);
                                if (this.HK != null) {
                                    this.HK.R(true);
                                }
                            }
                        } else if (this.mState == 3) {
                            if (y - this.mStartY > 0) {
                                this.mState = 1;
                                this.Id.O(this.If.booleanValue());
                                this.If = false;
                                if (this.HK != null) {
                                    this.HK.R(true);
                                }
                            } else if (this.HK != null) {
                                this.HK.R(false);
                            }
                        }
                        if (this.mState == 1 || this.mState == 0) {
                            this.Id.setPadding(0, ((int) ((y - this.mStartY) / Ic)) - this.Id.mR(), 0, 0);
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
            ad adVar = new ad(view.getContext(), 0, -mZ.mR(), this.Ig);
            adVar.a(new ac(this));
            adVar.g(view);
        }
    }
}
