package com.baidu.pass.ecommerce.common.mvp;

import com.baidu.pass.ecommerce.common.mvp.IBaseView;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public abstract class BasePresenter<V extends IBaseView> implements IPresenter<V> {
    public WeakReference<V> wrf;

    @Override // com.baidu.pass.ecommerce.common.mvp.IPresenter
    public void attachView(V v) {
        this.wrf = new WeakReference<>(v);
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IPresenter
    public void destroy() {
        WeakReference<V> weakReference = this.wrf;
        if (weakReference != null) {
            weakReference.clear();
            this.wrf = null;
        }
    }

    public void doFailure(int i, String str) {
        V view = getView();
        if (view != null) {
            view.doFailure(i, str);
        }
    }

    public void doResult(Object obj) {
        V view = getView();
        if (view != null) {
            view.doResult(obj);
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

    public void showLoading(int i) {
        V view = getView();
        if (view != null) {
            view.showLoading(i);
        }
    }

    public void doFailure(int i, int i2, String str) {
        V view = getView();
        if (view != null) {
            view.doFailure(i, i2, str);
        }
    }

    public void doResult(int i, Object obj) {
        V view = getView();
        if (view != null) {
            view.doResult(i, obj);
        }
    }

    public void doResult(int i, Object obj, String str) {
        V view = getView();
        if (view != null) {
            view.doResult(i, obj, str);
        }
    }
}
