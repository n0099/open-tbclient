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

    public void doFailure(int i2, String str) {
        V view = getView();
        if (view != null) {
            view.doFailure(i2, str);
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

    public void showLoading(int i2) {
        V view = getView();
        if (view != null) {
            view.showLoading(i2);
        }
    }

    public void doFailure(int i2, int i3, String str) {
        V view = getView();
        if (view != null) {
            view.doFailure(i2, i3, str);
        }
    }

    public void doResult(int i2, Object obj) {
        V view = getView();
        if (view != null) {
            view.doResult(i2, obj);
        }
    }

    public void doResult(int i2, Object obj, String str) {
        V view = getView();
        if (view != null) {
            view.doResult(i2, obj, str);
        }
    }
}
