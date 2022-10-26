package com.baidu.pass.ecommerce.common.mvp;
/* loaded from: classes2.dex */
public interface IPresenter {
    void attachView(IBaseView iBaseView);

    void destroy();

    IBaseView getView();
}
