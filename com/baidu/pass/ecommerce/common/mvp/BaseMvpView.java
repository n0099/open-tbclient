package com.baidu.pass.ecommerce.common.mvp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public abstract class BaseMvpView extends FrameLayout implements IBaseView {
    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void showLoading(int i) {
    }

    public BaseMvpView(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public final void doResult(Object obj) {
        doResult(Integer.MIN_VALUE, obj);
    }

    public BaseMvpView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public final void doFailure(int i, String str) {
        doFailure(Integer.MIN_VALUE, i, str);
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public final void doResult(int i, Object obj) {
        doResult(i, obj, null);
    }

    public BaseMvpView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public final void doFailure(int i, int i2, String str) {
        doFailure(i, i2, str, null);
    }
}
