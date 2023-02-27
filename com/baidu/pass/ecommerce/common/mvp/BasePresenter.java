package com.baidu.pass.ecommerce.common.mvp;

import com.baidu.pass.ecommerce.common.mvp.IBaseView;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public abstract class BasePresenter<V extends IBaseView> implements IPresenter<V> {
    public WeakReference<V> wrf;

    @Override // com.baidu.pass.ecommerce.common.mvp.IPresenter
    public void destroy() {
        WeakReference<V> weakReference = this.wrf;
        if (weakReference != null) {
            weakReference.clear();
            this.wrf = null;
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IPresenter
    public V getView() {
        WeakReference<V> weakReference = this.wrf;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IPresenter
    public void attachView(V v) {
        this.wrf = new WeakReference<>(v);
    }

    public void doResult(Object obj) {
        V view2 = getView();
        if (view2 != null) {
            view2.doResult(obj);
        }
    }

    public void showLoading(int i) {
        V view2 = getView();
        if (view2 != null) {
            view2.showLoading(i);
        }
    }

    public void doFailure(int i, int i2, String str) {
        V view2 = getView();
        if (view2 != null) {
            view2.doFailure(i, i2, str);
        }
    }

    public void doResult(int i, Object obj, String str) {
        V view2 = getView();
        if (view2 != null) {
            view2.doResult(i, obj, str);
        }
    }

    public void doFailure(int i, String str) {
        V view2 = getView();
        if (view2 != null) {
            view2.doFailure(i, str);
        }
    }

    public void doResult(int i, Object obj) {
        V view2 = getView();
        if (view2 != null) {
            view2.doResult(i, obj);
        }
    }
}
