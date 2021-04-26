package com.baidu.pass.ecommerce.common.mvp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public abstract class BaseMvpView extends FrameLayout implements IBaseView {
    public BaseMvpView(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public final void doFailure(int i2, String str) {
        doFailure(Integer.MIN_VALUE, i2, str);
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public final void doResult(Object obj) {
        doResult(Integer.MIN_VALUE, obj);
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void showLoading(int i2) {
    }

    public BaseMvpView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public final void doFailure(int i2, int i3, String str) {
        doFailure(i2, i3, str, null);
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public final void doResult(int i2, Object obj) {
        doResult(i2, obj, null);
    }

    public BaseMvpView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
