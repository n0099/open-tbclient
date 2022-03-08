package com.baidu.pass.ecommerce.common.mvp;

import com.baidu.pass.ecommerce.common.mvp.IBaseView;
/* loaded from: classes4.dex */
public interface IPresenter<V extends IBaseView> {
    void attachView(V v);

    void destroy();

    V getView();
}
