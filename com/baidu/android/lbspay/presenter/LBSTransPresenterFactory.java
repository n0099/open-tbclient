package com.baidu.android.lbspay.presenter;

import com.baidu.android.lbspay.activity.LBSTransActivity;
/* loaded from: classes.dex */
public class LBSTransPresenterFactory {
    public static final String TRANS_AUTH_PRESENTER = "LBSTransAuthPresenter";

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static LBSTransPresenterFactory f2646a = new LBSTransPresenterFactory();
    }

    public static LBSTransPresenterFactory getInstance() {
        return a.f2646a;
    }

    public LBSTransPresenter getTransPresenter(LBSTransActivity lBSTransActivity, String str) {
        if (((str.hashCode() == 595313813 && str.equals(TRANS_AUTH_PRESENTER)) ? (char) 0 : (char) 65535) != 0) {
            return null;
        }
        return new LBSTransAuthPresenter(lBSTransActivity);
    }

    public LBSTransPresenterFactory() {
    }
}
