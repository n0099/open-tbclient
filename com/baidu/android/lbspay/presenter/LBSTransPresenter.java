package com.baidu.android.lbspay.presenter;

import android.os.Bundle;
/* loaded from: classes3.dex */
public interface LBSTransPresenter {
    void SaveInstanceState(Bundle bundle);

    void cancelBean();

    void execBean();

    void handleFailure(int i2, int i3, String str);

    void handleResponse(int i2, Object obj, String str);

    void init(Bundle bundle);
}
