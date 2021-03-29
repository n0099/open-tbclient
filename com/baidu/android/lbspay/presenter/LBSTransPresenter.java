package com.baidu.android.lbspay.presenter;

import android.os.Bundle;
/* loaded from: classes.dex */
public interface LBSTransPresenter {
    void SaveInstanceState(Bundle bundle);

    void cancelBean();

    void execBean();

    void handleFailure(int i, int i2, String str);

    void handleResponse(int i, Object obj, String str);

    void init(Bundle bundle);
}
